/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy;

import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChunkIterableTest {

    private final StringBuffer buffer = new StringBuffer();

    private ChunkIterable<Integer> undertest;

    @Before
    public void setUp() {
        this.undertest = new ChunkIterable<>(FastList.newListWith(1, 2, 3, 4, 5), 2);
    }

    @Test
    public void forEach() {
        this.undertest.forEach(Procedures.cast(this.buffer::append));
        Assert.assertEquals("[1, 2][3, 4][5]", this.buffer.toString());
    }

    @Test
    public void forEachWithIndex() {
        this.undertest.forEachWithIndex((each, index) -> {
            this.buffer.append('|');
            this.buffer.append(each);
            this.buffer.append(index);
        });
        Assert.assertEquals("|[1, 2]0|[3, 4]1|[5]2", this.buffer.toString());
    }

    @Test
    public void forEachWith() {
        this.undertest.forEachWith((argument1, argument2) -> {
            this.buffer.append('|');
            this.buffer.append(argument1);
            this.buffer.append(argument2);
        }, 'A');
        Assert.assertEquals("|[1, 2]A|[3, 4]A|[5]A", this.buffer.toString());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private ChunkIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ChunkIterableTest();
        }

        @java.lang.Override
        public ChunkIterableTest implementation() {
            return this.implementation;
        }
    }
}
