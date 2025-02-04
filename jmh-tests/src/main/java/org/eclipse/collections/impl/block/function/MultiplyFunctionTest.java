/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MultiplyFunctionTest {

    @Test
    public void integerBlock() {
        Assert.assertEquals(Integer.valueOf(20), MultiplyFunction.INTEGER.value(2, 10));
    }

    @Test
    public void doubleBlock() {
        Assert.assertEquals(new Double(20), MultiplyFunction.DOUBLE.value(2.0, 10.0));
    }

    @Test
    public void longBlock() {
        Assert.assertEquals(Long.valueOf(20), MultiplyFunction.LONG.value(2L, 10L));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(MultiplyFunction.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MultiplyFunctionTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_integerBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.integerBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiplyFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new MultiplyFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiplyFunctionTest> integerBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiplyFunctionTest> doubleBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiplyFunctionTest> longBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiplyFunctionTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.integerBlock = MultiplyFunctionTest::integerBlock;
            this.payloads.doubleBlock = MultiplyFunctionTest::doubleBlock;
            this.payloads.longBlock = MultiplyFunctionTest::longBlock;
            this.payloads.classIsNonInstantiable = MultiplyFunctionTest::classIsNonInstantiable;
        }
    }
}
