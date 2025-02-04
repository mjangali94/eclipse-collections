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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyShortIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyShortIterateTest {

    private final ShortIterable iterable = ShortLists.mutable.with((short) 1, (short) 2, (short) 3);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyShortIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyShortIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyShortIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableShortList list = ShortLists.mutable.empty();
        LazyShortIterable shortIterable = LazyShortIterate.tap(this.iterable, (ShortProcedure) list::add);
        Assert.assertEquals(this.iterable, ShortLists.mutable.ofAll(shortIterable));
        Assert.assertEquals(this.iterable, list);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyShortIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyShortIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyShortIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyShortIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyShortIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyShortIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyShortIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyShortIterateTest::adapt;
            this.payloads.collectIf = LazyShortIterateTest::collectIf;
            this.payloads.empty = LazyShortIterateTest::empty;
            this.payloads.tap = LazyShortIterateTest::tap;
        }
    }
*/
}
