/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class LazyIterateTest {

    @Test
    public void selectForEach() {
        LazyIterable<Integer> select = LazyIterate.select(Interval.oneTo(5), Predicates.lessThan(5));
        int sum = select.injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(10, sum);
    }

    @Test
    public void selectForEachWithIndex() {
        LazyIterable<Integer> select = LazyIterate.select(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
        });
        Assert.assertEquals(16, sum.getValue().intValue());
    }

    @Test
    public void selectIterator() {
        LazyIterable<Integer> select = LazyIterate.select(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(10, sum.getValue().intValue());
    }

    @Test
    public void selectForEachWith() {
        LazyIterable<Integer> select = LazyIterate.select(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(10, sum.getValue().intValue());
    }

    @Test
    public void rejectForEach() {
        LazyIterable<Integer> select = LazyIterate.reject(Interval.oneTo(5), Predicates.lessThan(5));
        int sum = select.injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(5, sum);
    }

    @Test
    public void rejectForEachWithIndex() {
        LazyIterable<Integer> select = LazyIterate.reject(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
        });
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Test
    public void rejectIterator() {
        LazyIterable<Integer> select = LazyIterate.reject(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Test
    public void rejectForEachWith() {
        LazyIterable<Integer> select = LazyIterate.reject(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Test
    public void collectForEach() {
        LazyIterable<String> select = LazyIterate.collect(Interval.oneTo(5), String::valueOf);
        Appendable builder = new StringBuilder();
        Procedure<String> appendProcedure = Procedures.append(builder);
        select.forEach(appendProcedure);
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void collectForEachWithIndex() {
        LazyIterable<String> select = LazyIterate.collect(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        select.forEachWithIndex((object, index) -> {
            builder.append(object);
            builder.append(index);
        });
        Assert.assertEquals("1021324354", builder.toString());
    }

    @Test
    public void collectIterator() {
        LazyIterable<String> select = LazyIterate.collect(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        for (String each : select) {
            builder.append(each);
        }
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void collectForEachWith() {
        LazyIterable<String> select = LazyIterate.collect(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        select.forEachWith((each, aBuilder) -> aBuilder.append(each), builder);
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void asDeferred() {
        MutableList<Integer> expected = FastList.newList(Interval.oneTo(5));
        MutableList<Integer> actual0 = LazyIterate.adapt(Interval.oneTo(5)).toList();
        MutableList<Integer> actual1 = Interval.oneTo(5).asLazy().toList();
        MutableList<Integer> actual2 = FastList.newList(Interval.oneTo(5)).asLazy().toList();
        MutableList<Integer> actual3 = actual2.asUnmodifiable().asLazy().toList();
        MutableList<Integer> actual4 = actual2.asSynchronized().asLazy().toList();
        MutableList<Integer> actual5 = actual2.asLazy().select(ignored -> true).toList();
        MutableList<Integer> actual6 = actual2.toImmutable().asLazy().toList();
        ImmutableList<Integer> actual7 = actual2.asLazy().toList().toImmutable();
        Assert.assertEquals(expected, actual0);
        Assert.assertEquals(expected, actual1);
        Assert.assertEquals(expected, actual2);
        Assert.assertEquals(expected, actual3);
        Assert.assertEquals(expected, actual4);
        Assert.assertEquals(expected, actual5);
        Assert.assertEquals(expected, actual6);
        Assert.assertEquals(expected, actual7);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LazyIterate.class);
    }

    @Test
    public void cartesianProduct() {
        MutableList<Integer> iterable1 = Lists.mutable.with(1, 2);
        MutableList<Integer> iterable2 = Lists.mutable.with(2, 3, 4);
        MutableBag<Pair<Integer, Integer>> expectedCartesianProduct1 = Bags.mutable.with(Tuples.pair(1, 2), Tuples.pair(2, 2), Tuples.pair(1, 3), Tuples.pair(2, 3), Tuples.pair(1, 4), Tuples.pair(2, 4));
        Assert.assertEquals(expectedCartesianProduct1, LazyIterate.cartesianProduct(iterable1, iterable2).toBag());
        MutableBag<Pair<Integer, Integer>> expectedCartesianProduct2 = Bags.mutable.with(Tuples.pair(2, 1), Tuples.pair(3, 1), Tuples.pair(4, 1), Tuples.pair(2, 2), Tuples.pair(3, 2), Tuples.pair(4, 2));
        Assert.assertEquals(expectedCartesianProduct2, LazyIterate.cartesianProduct(iterable2, iterable1).toBag());
    }

    @Test
    public void cartesianProductDuplicatesToConcreteCollections() {
        MutableList<Integer> iterable1 = Lists.mutable.with(1, 1);
        MutableList<Integer> iterable2 = Lists.mutable.with(2, 2);
        MutableBag<Pair<Integer, Integer>> expectedBag = Bags.mutable.with(Tuples.pair(1, 2), Tuples.pair(1, 2), Tuples.pair(1, 2), Tuples.pair(1, 2));
        Assert.assertEquals(expectedBag, LazyIterate.cartesianProduct(iterable1, iterable2).toBag());
        MutableSet<Pair<Integer, Integer>> expectedSet = Sets.mutable.with(Tuples.pair(1, 2));
        Assert.assertEquals(expectedSet, LazyIterate.cartesianProduct(iterable1, iterable2).toSet());
        MutableList<Pair<Integer, Integer>> expectedList = Lists.mutable.with(Tuples.pair(1, 2), Tuples.pair(1, 2), Tuples.pair(1, 2), Tuples.pair(1, 2));
        Assert.assertEquals(expectedList, LazyIterate.cartesianProduct(iterable1, iterable2).toList());
    }

    @Test
    public void cartesianProductWithFunction() {
        MutableList<Integer> iterable1 = Lists.mutable.with(1, 2);
        MutableList<Integer> iterable2 = Lists.mutable.with(2, 3, 4);
        MutableBag<Pair<Integer, Integer>> expectedCartesianProduct = Bags.mutable.with(Tuples.pair(1, 2), Tuples.pair(2, 2), Tuples.pair(1, 3), Tuples.pair(2, 3), Tuples.pair(1, 4), Tuples.pair(2, 4));
        Assert.assertEquals(expectedCartesianProduct, LazyIterate.cartesianProduct(iterable1, iterable2, Tuples::pair).toBag());
        MutableBag<MutableList<Integer>> expectedCartesianProduct2 = Bags.mutable.with(Lists.mutable.with(2, 1), Lists.mutable.with(3, 1), Lists.mutable.with(4, 1), Lists.mutable.with(2, 2), Lists.mutable.with(3, 2), Lists.mutable.with(4, 2));
        Assert.assertEquals(expectedCartesianProduct2, LazyIterate.cartesianProduct(iterable2, iterable1, Lists.mutable::with).toBag());
    }

    @Test
    public void cartesianProduct_empty() {
        Assert.assertEquals(Bags.mutable.empty(), LazyIterate.cartesianProduct(Lists.mutable.with(1, 2), Lists.mutable.empty()).toBag());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyIterateTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectForEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectForEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectForEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectForEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectForEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectForEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asDeferred() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asDeferred);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProductDuplicatesToConcreteCollections() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProductDuplicatesToConcreteCollections);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProductWithFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProductWithFunction);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct_empty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> payload) throws java.lang.Throwable {
            this.instance = new LazyIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> selectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> selectForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> selectIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> selectForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> rejectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> rejectForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> rejectIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> rejectForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> collectForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> collectForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> collectIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> collectForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> asDeferred;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> cartesianProductDuplicatesToConcreteCollections;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> cartesianProductWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIterateTest> cartesianProduct_empty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.selectForEach = LazyIterateTest::selectForEach;
            this.payloads.selectForEachWithIndex = LazyIterateTest::selectForEachWithIndex;
            this.payloads.selectIterator = LazyIterateTest::selectIterator;
            this.payloads.selectForEachWith = LazyIterateTest::selectForEachWith;
            this.payloads.rejectForEach = LazyIterateTest::rejectForEach;
            this.payloads.rejectForEachWithIndex = LazyIterateTest::rejectForEachWithIndex;
            this.payloads.rejectIterator = LazyIterateTest::rejectIterator;
            this.payloads.rejectForEachWith = LazyIterateTest::rejectForEachWith;
            this.payloads.collectForEach = LazyIterateTest::collectForEach;
            this.payloads.collectForEachWithIndex = LazyIterateTest::collectForEachWithIndex;
            this.payloads.collectIterator = LazyIterateTest::collectIterator;
            this.payloads.collectForEachWith = LazyIterateTest::collectForEachWith;
            this.payloads.asDeferred = LazyIterateTest::asDeferred;
            this.payloads.classIsNonInstantiable = LazyIterateTest::classIsNonInstantiable;
            this.payloads.cartesianProduct = LazyIterateTest::cartesianProduct;
            this.payloads.cartesianProductDuplicatesToConcreteCollections = LazyIterateTest::cartesianProductDuplicatesToConcreteCollections;
            this.payloads.cartesianProductWithFunction = LazyIterateTest::cartesianProductWithFunction;
            this.payloads.cartesianProduct_empty = LazyIterateTest::cartesianProduct_empty;
        }
    }
}
