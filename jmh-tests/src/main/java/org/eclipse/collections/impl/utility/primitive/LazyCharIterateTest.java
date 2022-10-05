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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyCharIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyCharIterateTest {

    private final CharIterable iterable = CharLists.mutable.with((char) 1, (char) 2, (char) 3);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyCharIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyCharIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyCharIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableCharList list = CharLists.mutable.empty();
        LazyCharIterable charIterable = LazyCharIterate.tap(this.iterable, (CharProcedure) list::add);
        Assert.assertEquals(this.iterable, CharLists.mutable.ofAll(charIterable));
        Assert.assertEquals(this.iterable, list);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyCharIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyCharIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyCharIterateTest::adapt;
            this.payloads.collectIf = LazyCharIterateTest::collectIf;
            this.payloads.empty = LazyCharIterateTest::empty;
            this.payloads.tap = LazyCharIterateTest::tap;
        }
    }
}
