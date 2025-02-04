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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.junit.Assert;
import org.junit.Test;

public class LazyBooleanIterateTest {

    private final BooleanIterable iterable = BooleanLists.mutable.with(true, false);

    @Test
    public void adapt() {
        Assert.assertEquals(this.iterable, LazyBooleanIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf() {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyBooleanIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }

    @Test
    public void empty() {
        Assert.assertTrue(LazyBooleanIterate.empty().isEmpty());
    }

    @Test
    public void tap() {
        MutableBooleanList list = BooleanLists.mutable.empty();
        LazyBooleanIterable booleanIterable = LazyBooleanIterate.tap(this.iterable, (BooleanProcedure) list::add);
        Assert.assertEquals(this.iterable, BooleanLists.mutable.ofAll(booleanIterable));
        Assert.assertEquals(this.iterable, list);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyBooleanIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyBooleanIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyBooleanIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyBooleanIterateTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyBooleanIterateTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyBooleanIterateTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyBooleanIterateTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.adapt = LazyBooleanIterateTest::adapt;
            this.payloads.collectIf = LazyBooleanIterateTest::collectIf;
            this.payloads.empty = LazyBooleanIterateTest::empty;
            this.payloads.tap = LazyBooleanIterateTest::tap;
        }
    }
*/
}
