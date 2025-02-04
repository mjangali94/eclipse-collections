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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyIntIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyIntIterateTest {

    private final IntIterable iterable = IntLists.mutable.with(1, 2, 3);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyIntIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyIntIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyIntIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableIntList list = IntLists.mutable.empty();
        LazyIntIterable intIterable = LazyIntIterate.tap(this.iterable, (IntProcedure) list::add);
        Assert.assertEquals(this.iterable, IntLists.mutable.ofAll(intIterable));
        Assert.assertEquals(this.iterable, list);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyIntIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyIntIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyIntIterateTest::adapt;
            this.payloads.collectIf = LazyIntIterateTest::collectIf;
            this.payloads.empty = LazyIntIterateTest::empty;
            this.payloads.tap = LazyIntIterateTest::tap;
        }
    }
*/
}
