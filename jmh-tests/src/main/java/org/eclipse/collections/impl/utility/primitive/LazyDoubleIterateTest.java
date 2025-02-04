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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyDoubleIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyDoubleIterateTest {

    private final DoubleIterable iterable = DoubleLists.mutable.with(1.0, 2.0, 3.0);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyDoubleIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyDoubleIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyDoubleIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableDoubleList list = DoubleLists.mutable.empty();
        LazyDoubleIterable doubleIterable = LazyDoubleIterate.tap(this.iterable, (DoubleProcedure) list::add);
        Assert.assertEquals(this.iterable, DoubleLists.mutable.ofAll(doubleIterable));
        Assert.assertEquals(this.iterable, list);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyDoubleIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyDoubleIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyDoubleIterateTest::adapt;
            this.payloads.collectIf = LazyDoubleIterateTest::collectIf;
            this.payloads.empty = LazyDoubleIterateTest::empty;
            this.payloads.tap = LazyDoubleIterateTest::tap;
        }
    }
*/
}
