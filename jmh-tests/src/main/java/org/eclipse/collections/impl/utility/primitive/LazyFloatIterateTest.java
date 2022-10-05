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

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyFloatIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyFloatIterateTest {

    private final FloatIterable iterable = FloatLists.mutable.with(1.0f, 2.0f, 3.0f);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyFloatIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyFloatIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyFloatIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableFloatList list = FloatLists.mutable.empty();
        LazyFloatIterable floatIterable = LazyFloatIterate.tap(this.iterable, (FloatProcedure) list::add);
        Assert.assertEquals(this.iterable, FloatLists.mutable.ofAll(floatIterable));
        Assert.assertEquals(this.iterable, list);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyFloatIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyFloatIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyFloatIterateTest::adapt;
            this.payloads.collectIf = LazyFloatIterateTest::collectIf;
            this.payloads.empty = LazyFloatIterateTest::empty;
            this.payloads.tap = LazyFloatIterateTest::tap;
        }
    }
}
