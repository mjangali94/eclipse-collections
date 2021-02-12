/*
 * Copyright (c) 2016 Goldman Sachs.
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select_target, this.description("select_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject_target, this.description("reject_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_target, this.description("collect_target"));
        }

        private BooleanIteratorIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanIteratorIterateTest();
        }

        @java.lang.Override
        public BooleanIteratorIterateTest implementation() {
            return this.implementation;
        }
    }
}
