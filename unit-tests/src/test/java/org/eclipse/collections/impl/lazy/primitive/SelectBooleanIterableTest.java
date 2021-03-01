/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

public class SelectBooleanIterableTest {

    private final SelectBooleanIterable iterable = new SelectBooleanIterable(BooleanArrayList.newListWith(true, false, false, true), BooleanPredicates.isTrue());

    @Test
    public void booleanIterator() {
        StringBuilder concat = new StringBuilder();
        for (BooleanIterator iterator = this.iterable.booleanIterator(); iterator.hasNext(); ) {
            concat.append(iterator.next());
        }
        Assert.assertEquals("truetrue", concat.toString());
    }

    @Test
    public void forEach() {
        String[] concat = new String[1];
        concat[0] = "";
        this.iterable.forEach(each -> concat[0] += each);
        Assert.assertEquals("truetrue", concat[0]);
    }

    @Test
    public void injectInto() {
        MutableInteger result = this.iterable.injectInto(new MutableInteger(0), (object, value) -> object.add(value ? 1 : 0));
        Assert.assertEquals(new MutableInteger(2), result);
    }

    @Test
    public void size() {
        Assert.assertEquals(2L, this.iterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, this.iterable.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(0L, this.iterable.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.iterable.anySatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.iterable.allSatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void select() {
        Assert.assertEquals(0L, this.iterable.select(BooleanPredicates.isFalse()).size());
        Assert.assertEquals(2L, this.iterable.select(BooleanPredicates.equal(true)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(2L, this.iterable.reject(BooleanPredicates.isFalse()).size());
        Assert.assertEquals(0L, this.iterable.reject(BooleanPredicates.equal(true)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertTrue(this.iterable.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(this.iterable.detectIfNone(BooleanPredicates.isFalse(), false));
    }

    @Test
    public void collect() {
        Assert.assertEquals(2L, this.iterable.collect(String::valueOf).size());
    }

    @Test
    public void toArray() {
        Assert.assertEquals(2L, this.iterable.toArray().length);
        Assert.assertTrue(this.iterable.toArray()[0]);
        Assert.assertTrue(this.iterable.toArray()[1]);
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(true));
        Assert.assertFalse(this.iterable.contains(false));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.iterable.containsAll(true, true));
        Assert.assertFalse(this.iterable.containsAll(false, true));
        Assert.assertFalse(this.iterable.containsAll(false, false));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanIterator, this.description("booleanIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll, this.description("containsAll"));
        }

        private SelectBooleanIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SelectBooleanIterableTest();
        }

        @java.lang.Override
        public SelectBooleanIterableTest implementation() {
            return this.implementation;
        }
    }
}
