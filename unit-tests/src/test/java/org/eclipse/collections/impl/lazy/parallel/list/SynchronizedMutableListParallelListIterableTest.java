/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.list;

import java.util.LinkedList;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.function.checked.CheckedFunction;
import org.eclipse.collections.impl.block.predicate.checked.CheckedPredicate;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.block.procedure.checked.CheckedProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class SynchronizedMutableListParallelListIterableTest extends ParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return ListAdapter.adapt(new LinkedList<>(Lists.mutable.of(littleElements))).asSynchronized().asParallel(null, this.batchSize);
    }

    @Override
    @Test
    public void forEach_executionException() {
        try {
            this.classUnderTest().forEach(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            Assert.assertEquals("Execution exception", e.getMessage());
        }
    }

    @Override
    @Test
    public void collect_executionException() {
        try {
            this.classUnderTest().collect(each -> {
                throw new RuntimeException("Execution exception");
            }).toString();
        } catch (RuntimeException e) {
            Assert.assertEquals("Execution exception", e.getMessage());
        }
    }

    @Override
    @Test
    public void anySatisfy_executionException() {
        try {
            this.classUnderTest().anySatisfy(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            Assert.assertEquals("Execution exception", e.getMessage());
        }
    }

    @Override
    @Test
    public void allSatisfy_executionException() {
        try {
            this.classUnderTest().allSatisfy(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            Assert.assertEquals("Execution exception", e.getMessage());
        }
    }

    @Override
    @Test
    public void detect_executionException() {
        try {
            this.classUnderTest().detect(each -> {
                throw new RuntimeException("Execution exception");
            });
        } catch (RuntimeException e) {
            Assert.assertEquals("Execution exception", e.getMessage());
        }
    }

    @Override
    @Test
    public void forEach_interruptedException() {
        MutableCollection<Integer> actual1 = HashBag.<Integer>newBag().asSynchronized();
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().forEach(new CheckedProcedure<Integer>() {

            @Override
            public void safeValue(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                actual1.add(each);
            }
        }));
        Assert.assertFalse(Thread.interrupted());
        MutableCollection<Integer> actual2 = HashBag.<Integer>newBag().asSynchronized();
        this.classUnderTest().forEach(CollectionAddProcedure.on(actual2));
        Assert.assertEquals(this.getExpected().toBag(), actual2);
    }

    @Override
    @Test
    public void anySatisfy_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().anySatisfy(new CheckedPredicate<Integer>() {

            @Override
            public boolean safeAccept(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                return each < 1;
            }
        }));
        Assert.assertFalse(Thread.interrupted());
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.lessThan(1)));
    }

    @Override
    @Test
    public void allSatisfy_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().allSatisfy(new CheckedPredicate<Integer>() {

            @Override
            public boolean safeAccept(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                return each < 5;
            }
        }));
        Assert.assertFalse(Thread.interrupted());
        Assert.assertTrue(this.classUnderTest().allSatisfy(Predicates.lessThan(5)));
    }

    @Override
    @Test
    public void detect_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().detect(new CheckedPredicate<Integer>() {

            @Override
            public boolean safeAccept(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                return each.intValue() == 3;
            }
        }));
        Assert.assertFalse(Thread.interrupted());
        Assert.assertEquals(Integer.valueOf(3), this.classUnderTest().detect(Integer.valueOf(3)::equals));
    }

    @Override
    @Test
    public void toString_interruptedException() {
        Thread.currentThread().interrupt();
        Verify.assertThrowsWithCause(RuntimeException.class, InterruptedException.class, () -> this.classUnderTest().collect(new CheckedFunction<Integer, String>() {

            @Override
            public String safeValueOf(Integer each) throws InterruptedException {
                Thread.sleep(1000);
                return String.valueOf(each);
            }
        }).toString());
        Assert.assertFalse(Thread.interrupted());
        MutableCollection<Integer> actual = HashBag.<Integer>newBag().asSynchronized();
        this.classUnderTest().forEach(CollectionAddProcedure.on(actual));
        Assert.assertEquals(this.getExpected().toBag(), actual);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach_executionException, this.description("forEach_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_executionException, this.description("collect_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy_executionException, this.description("anySatisfy_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy_executionException, this.description("allSatisfy_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect_executionException, this.description("detect_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach_interruptedException, this.description("forEach_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy_interruptedException, this.description("anySatisfy_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy_interruptedException, this.description("allSatisfy_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect_interruptedException, this.description("detect_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toString_interruptedException, this.description("toString_interruptedException"));
        }

        private SynchronizedMutableListParallelListIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedMutableListParallelListIterableTest();
        }

        @java.lang.Override
        public SynchronizedMutableListParallelListIterableTest implementation() {
            return this.implementation;
        }
    }
}
