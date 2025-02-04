/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
    public void throwingWithSuccessfulCompletion() {
        Assert.assertEquals("hello", Functions0.throwing(() -> "hello").value());
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private Functions0Test instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getTrue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getTrue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFalse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFalse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwing() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwing);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithSuccessfulCompletion() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwingWithSuccessfulCompletion);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithUserSpecifiedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.throwingWithUserSpecifiedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newFastList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newFastList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newUnifiedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newUnifiedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newHashBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newHashBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newUnifiedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newUnifiedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zeroInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zeroInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zeroAtomicInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zeroAtomicInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zeroAtomicLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zeroAtomicLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> payload) throws java.lang.Throwable {
            this.instance = new Functions0Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> getTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> getFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> throwing;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> throwingWithSuccessfulCompletion;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> throwingWithUserSpecifiedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> newFastList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> newUnifiedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> newHashBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> newUnifiedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> zeroInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> zeroAtomicInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> zeroAtomicLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<Functions0Test> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.getTrue = Functions0Test::getTrue;
            this.payloads.getFalse = Functions0Test::getFalse;
            this.payloads.throwing = Functions0Test::throwing;
            this.payloads.throwingWithSuccessfulCompletion = Functions0Test::throwingWithSuccessfulCompletion;
            this.payloads.throwingWithUserSpecifiedException = Functions0Test::throwingWithUserSpecifiedException;
            this.payloads.newFastList = Functions0Test::newFastList;
            this.payloads.newUnifiedSet = Functions0Test::newUnifiedSet;
            this.payloads.newHashBag = Functions0Test::newHashBag;
            this.payloads.newUnifiedMap = Functions0Test::newUnifiedMap;
            this.payloads.zeroInteger = Functions0Test::zeroInteger;
            this.payloads.zeroAtomicInteger = Functions0Test::zeroAtomicInteger;
            this.payloads.zeroAtomicLong = Functions0Test::zeroAtomicLong;
            this.payloads.classIsNonInstantiable = Functions0Test::classIsNonInstantiable;
        }
    }
*/
}
