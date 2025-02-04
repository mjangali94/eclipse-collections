/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.internal.primitive;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class BooleanIteratorIterateTest {

    private final BooleanIterable iterable = BooleanArrayList.newListWith(true, false, true);

    @Test
    public void select_target() {
        Verify.assertSize(1, BooleanIteratorIterate.select(this.iterable.booleanIterator(), BooleanPredicates.equal(false), new BooleanArrayList(2)));
        Verify.assertSize(2, BooleanIteratorIterate.select(this.iterable.booleanIterator(), BooleanPredicates.equal(true), new BooleanArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, BooleanIteratorIterate.reject(this.iterable.booleanIterator(), BooleanPredicates.equal(true), new BooleanArrayList(1)));
        Verify.assertSize(2, BooleanIteratorIterate.reject(this.iterable.booleanIterator(), BooleanPredicates.equal(false), new BooleanArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, BooleanIteratorIterate.collect(this.iterable.booleanIterator(), String::valueOf, FastList.newList()));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanIteratorIterateTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanIteratorIterateTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanIteratorIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanIteratorIterateTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanIteratorIterateTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanIteratorIterateTest> collect_target;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.select_target = BooleanIteratorIterateTest::select_target;
            this.payloads.reject_target = BooleanIteratorIterateTest::reject_target;
            this.payloads.collect_target = BooleanIteratorIterateTest::collect_target;
        }
    }
*/
}
