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

/**
 * Junit test for {@link LongFunctionImpl}.
 */
public class LongFunctionImplTest {

    @Test
    public void valueOf() {
        LongFunctionImpl<Long> longFunction = new LongFunctionImpl<Long>() {

            public long longValueOf(Long each) {
                return each.longValue();
            }
        };
        Assert.assertEquals(1L, longFunction.longValueOf(1L));
        Assert.assertEquals(1L, longFunction.valueOf(1L).longValue());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::valueOf, this.description("valueOf"));
        }

        private LongFunctionImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongFunctionImplTest();
        }

        @java.lang.Override
        public LongFunctionImplTest implementation() {
            return this.implementation;
        }
    }
}
