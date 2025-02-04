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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyLongIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyLongIterateTest {

    private final LongIterable iterable = LongLists.mutable.with(1L, 2L, 3L);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyLongIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyLongIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyLongIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableLongList list = LongLists.mutable.empty();
        LazyLongIterable longIterable = LazyLongIterate.tap(this.iterable, (LongProcedure) list::add);
        Assert.assertEquals(this.iterable, LongLists.mutable.ofAll(longIterable));
        Assert.assertEquals(this.iterable, list);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyLongIterateTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyLongIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyLongIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyLongIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyLongIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyLongIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyLongIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyLongIterateTest::adapt;
            this.payloads.collectIf = LazyLongIterateTest::collectIf;
            this.payloads.empty = LazyLongIterateTest::empty;
            this.payloads.tap = LazyLongIterateTest::tap;
        }
    }
}
