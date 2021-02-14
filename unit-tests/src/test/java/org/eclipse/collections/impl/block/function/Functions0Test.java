/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class Functions0Test {

    @Test
    public void getTrue() {
        Assert.assertTrue(Functions0.getTrue().value());
    }

    @Test
    public void getFalse() {
        Assert.assertFalse(Functions0.getFalse().value());
    }

    @Test
    public void throwing() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> Functions0.throwing(() -> {
            throw new IOException();
        }).value());
    }

    @Test
    public void throwingWithUserSpecifiedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Functions0.throwing(() -> {
                throw new IOException();
            }, RuntimeException::new).value();
        });
        Verify.assertThrowsWithCause(MyRuntimeException.class, IOException.class, () -> {
            Functions0.throwing(() -> {
                throw new IOException();
            }, this::throwMyException).value();
        });
        Assert.assertThrows(NullPointerException.class, () -> {
            Functions0.throwing(() -> {
                throw new NullPointerException();
            }, this::throwMyException).value();
        });
    }

    private MyRuntimeException throwMyException(Throwable exception) {
        return new MyRuntimeException(exception);
    }

    @Test
    public void newFastList() {
        Assert.assertEquals(Lists.mutable.of(), Functions0.newFastList().value());
        Verify.assertInstanceOf(FastList.class, Functions0.newFastList().value());
    }

    @Test
    public void newUnifiedSet() {
        Assert.assertEquals(UnifiedSet.newSet(), Functions0.newUnifiedSet().value());
        Verify.assertInstanceOf(UnifiedSet.class, Functions0.newUnifiedSet().value());
    }

    @Test
    public void newHashBag() {
        Assert.assertEquals(Bags.mutable.of(), Functions0.newHashBag().value());
        Verify.assertInstanceOf(HashBag.class, Functions0.newHashBag().value());
    }

    @Test
    public void newUnifiedMap() {
        Assert.assertEquals(UnifiedMap.newMap(), Functions0.newUnifiedMap().value());
        Verify.assertInstanceOf(UnifiedMap.class, Functions0.newUnifiedMap().value());
    }

    @Test
    public void zeroInteger() {
        Assert.assertEquals(Integer.valueOf(0), Functions0.zeroInteger().value());
        Assert.assertEquals(Integer.valueOf(0), Functions0.value(0).value());
    }

    @Test
    public void zeroAtomicInteger() {
        Verify.assertInstanceOf(AtomicInteger.class, Functions0.zeroAtomicInteger().value());
        Assert.assertEquals(0, Functions0.zeroAtomicInteger().value().get());
    }

    @Test
    public void zeroAtomicLong() {
        Verify.assertInstanceOf(AtomicLong.class, Functions0.zeroAtomicLong().value());
        Assert.assertEquals(0, Functions0.zeroAtomicLong().value().get());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(Functions0.class);
    }

    private static class MyRuntimeException extends RuntimeException {

        MyRuntimeException(Throwable cause) {
            super(cause);
        }
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getTrue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getTrue, this.description("getTrue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFalse() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFalse, this.description("getFalse"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwing() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::throwing, this.description("throwing"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithUserSpecifiedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::throwingWithUserSpecifiedException, this.description("throwingWithUserSpecifiedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newFastList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newFastList, this.description("newFastList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newUnifiedSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newUnifiedSet, this.description("newUnifiedSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newHashBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newHashBag, this.description("newHashBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newUnifiedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newUnifiedMap, this.description("newUnifiedMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zeroInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zeroInteger, this.description("zeroInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zeroAtomicInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zeroAtomicInteger, this.description("zeroAtomicInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zeroAtomicLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zeroAtomicLong, this.description("zeroAtomicLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private Functions0Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new Functions0Test();
        }

        @java.lang.Override
        public Functions0Test implementation() {
            return this.implementation;
        }
    }
}
