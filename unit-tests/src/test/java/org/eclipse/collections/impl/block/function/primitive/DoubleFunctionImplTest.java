/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function.primitive;

import org.junit.Assert;
import org.junit.Test;

public final class DoubleFunctionImplTest {

    private static final Object JUNK = new Object();

    @Test
    public void testValueOf() {
        Assert.assertSame(new TestDoubleFunctionImpl(0.0d).valueOf(JUNK), new TestDoubleFunctionImpl(0.0d).valueOf(JUNK));
        Assert.assertEquals(Double.valueOf(1.0d), new TestDoubleFunctionImpl(1.0d).valueOf(JUNK));
    }

    private static final class TestDoubleFunctionImpl extends DoubleFunctionImpl<Object> {

        private static final long serialVersionUID = 1L;

        private final double toReturn;

        private TestDoubleFunctionImpl(double toReturn) {
            this.toReturn = toReturn;
        }

        @Override
        public double doubleValueOf(Object anObject) {
            return this.toReturn;
        }
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testValueOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testValueOf, this.description("testValueOf"));
        }

        private DoubleFunctionImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleFunctionImplTest();
        }

        @java.lang.Override
        public DoubleFunctionImplTest implementation() {
            return this.implementation;
        }
    }
}
