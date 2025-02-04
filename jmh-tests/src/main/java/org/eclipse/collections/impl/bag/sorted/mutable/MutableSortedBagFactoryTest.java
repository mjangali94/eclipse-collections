/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.mutable;

import java.util.Comparator;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.SortedBags;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

public class MutableSortedBagFactoryTest {

    @Test
    public void ofEmpty() {
        Assert.assertEquals(TreeBag.newBag(), SortedBags.mutable.of());
        Assert.assertEquals(TreeBag.newBag(Comparators.reverseNaturalOrder()), SortedBags.mutable.of(Comparators.reverseNaturalOrder()));
    }

    @Test
    public void withEmpty() {
        Assert.assertEquals(TreeBag.newBag(), SortedBags.mutable.with());
        Assert.assertEquals(TreeBag.newBag(Comparators.reverseNaturalOrder()), SortedBags.mutable.with(Comparators.reverseNaturalOrder()));
    }

    @Test
    public void ofElements() {
        Assert.assertEquals(TreeBag.newBagWith(1, 1, 2), SortedBags.mutable.of(1, 1, 2));
        Assert.assertEquals(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 2), SortedBags.mutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2));
    }

    @Test
    public void withElements() {
        Assert.assertEquals(TreeBag.newBagWith(1, 1, 2), SortedBags.mutable.with(1, 1, 2));
        Assert.assertEquals(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 2), SortedBags.mutable.with(Comparators.reverseNaturalOrder(), 1, 1, 2));
    }

    @Test
    public void ofAll() {
        LazyIterable<Integer> list = FastList.newListWith(1, 2, 2).asLazy();
        Assert.assertEquals(TreeBag.newBagWith(1, 2, 2), SortedBags.mutable.ofAll(list));
    }

    @Test
    public void withAll() {
        LazyIterable<Integer> list = FastList.newListWith(1, 2, 2).asLazy();
        Assert.assertEquals(TreeBag.newBagWith(1, 2, 2), SortedBags.mutable.withAll(list));
    }

    @Test
    public void ofAllComparator() {
        LazyIterable<Integer> list = FastList.newListWith(1, 2, 2).asLazy();
        Assert.assertEquals(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 2, 2), SortedBags.mutable.ofAll(Comparators.reverseNaturalOrder(), list));
    }

    @Test
    public void withAllComparator() {
        LazyIterable<Integer> list = FastList.newListWith(1, 2, 2).asLazy();
        Assert.assertEquals(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 2, 2), SortedBags.mutable.withAll(Comparators.reverseNaturalOrder(), list));
    }

    @Test
    public void empty() {
        Assert.assertEquals(TreeBag.newBag(), SortedBags.mutable.empty());
        Assert.assertEquals(TreeBag.newBag(Comparator.reverseOrder()), SortedBags.mutable.empty(Comparator.reverseOrder()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableSortedBagFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofElements);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withElements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withElements);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAllComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAllComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableSortedBagFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> ofEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> withEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> ofElements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> withElements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> ofAllComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> withAllComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableSortedBagFactoryTest> empty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.ofEmpty = MutableSortedBagFactoryTest::ofEmpty;
            this.payloads.withEmpty = MutableSortedBagFactoryTest::withEmpty;
            this.payloads.ofElements = MutableSortedBagFactoryTest::ofElements;
            this.payloads.withElements = MutableSortedBagFactoryTest::withElements;
            this.payloads.ofAll = MutableSortedBagFactoryTest::ofAll;
            this.payloads.withAll = MutableSortedBagFactoryTest::withAll;
            this.payloads.ofAllComparator = MutableSortedBagFactoryTest::ofAllComparator;
            this.payloads.withAllComparator = MutableSortedBagFactoryTest::withAllComparator;
            this.payloads.empty = MutableSortedBagFactoryTest::empty;
        }
    }
}
