/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.primitive;

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyByteIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyByteIterateTest {

    private final ByteIterable iterable = ByteLists.mutable.with((byte) 1, (byte) 2, (byte) 3);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyByteIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyByteIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyByteIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableByteList list = ByteLists.mutable.empty();
        LazyByteIterable byteIterable = LazyByteIterate.tap(this.iterable, (ByteProcedure) list::add);
        Assert.assertEquals(this.iterable, ByteLists.mutable.ofAll(byteIterable));
        Assert.assertEquals(this.iterable, list);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyByteIterateTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyByteIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyByteIterateTest::adapt;
            this.payloads.collectIf = LazyByteIterateTest::collectIf;
            this.payloads.empty = LazyByteIterateTest::empty;
            this.payloads.tap = LazyByteIterateTest::tap;
        }
    }
}
