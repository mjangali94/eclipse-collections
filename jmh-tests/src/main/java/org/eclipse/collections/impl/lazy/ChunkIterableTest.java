/*
 * Copyright (c) 2021 Goldman Sachs.
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ChunkIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ChunkIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ChunkIterableTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ChunkIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ChunkIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ChunkIterableTest> forEachWith;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEach = ChunkIterableTest::forEach;
            this.payloads.forEachWithIndex = ChunkIterableTest::forEachWithIndex;
            this.payloads.forEachWith = ChunkIterableTest::forEachWith;
        }
    }
*/
}
