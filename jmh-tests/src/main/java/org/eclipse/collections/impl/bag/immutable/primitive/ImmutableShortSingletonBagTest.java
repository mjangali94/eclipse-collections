/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;

/**
 * JUnit test for {@link ImmutableShortSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableShortSingletonBagTest extends AbstractImmutableShortBagTestCase {

    @Override
    protected final ImmutableShortBag classUnderTest() {
        return ShortBags.immutable.of((short) 1);
    }

    @Override
    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((short argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("11", string);
    }

    @Override
    @Test
    public void selectByOccurrences() {
        ImmutableShortSingletonBag bag = new ImmutableShortSingletonBag((short) 1);
        ImmutableShortBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), filtered1);
        ImmutableShortBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(ShortBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates() {
        ImmutableShortSingletonBag bag = new ImmutableShortSingletonBag((short) 1);
        Assert.assertEquals(ShortHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableShortBag bag = this.classUnderTest();
        ImmutableShortSet expected = ShortSets.immutable.with((short) 1);
        ImmutableShortSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableShortSingletonBag iterable = new ImmutableShortSingletonBag((short) 1);
        MutableShort result = iterable.injectInto(new MutableShort((short) 1), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 2), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableShortSingletonBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableShortSingletonBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortSingletonBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableShortSingletonBagTest::newCollectionWith;
            this.payloads.newCollection = ImmutableShortSingletonBagTest::newCollection;
            this.payloads.isEmpty = ImmutableShortSingletonBagTest::isEmpty;
            this.payloads.notEmpty = ImmutableShortSingletonBagTest::notEmpty;
            this.payloads.tap = ImmutableShortSingletonBagTest::tap;
            this.payloads.contains = ImmutableShortSingletonBagTest::contains;
            this.payloads.containsAllArray = ImmutableShortSingletonBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableShortSingletonBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableShortSingletonBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableShortSingletonBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableShortSingletonBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableShortSingletonBagTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortSingletonBagTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortSingletonBagTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.size = ImmutableShortSingletonBagTest::size;
            this.payloads.anySatisfy = ImmutableShortSingletonBagTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableShortSingletonBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableShortSingletonBagTest::noneSatisfy;
            this.payloads.collect = ImmutableShortSingletonBagTest::collect;
            this.payloads.collectWithTarget = ImmutableShortSingletonBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableShortSingletonBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableShortSingletonBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableShortSingletonBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableShortSingletonBagTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableShortSingletonBagTest::select;
            this.payloads.selectWithTarget = ImmutableShortSingletonBagTest::selectWithTarget;
            this.payloads.reject = ImmutableShortSingletonBagTest::reject;
            this.payloads.rejectWithTarget = ImmutableShortSingletonBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableShortSingletonBagTest::detectIfNone;
            this.payloads.max = ImmutableShortSingletonBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortSingletonBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableShortSingletonBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortSingletonBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableShortSingletonBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableShortSingletonBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ImmutableShortSingletonBagTest::summaryStatistics;
            this.payloads.average = ImmutableShortSingletonBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortSingletonBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableShortSingletonBagTest::averageIfEmpty;
            this.payloads.median = ImmutableShortSingletonBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortSingletonBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableShortSingletonBagTest::medianIfEmpty;
            this.payloads.toArray = ImmutableShortSingletonBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableShortSingletonBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableShortSingletonBagTest::toSortedArray;
            this.payloads.testHashCode = ImmutableShortSingletonBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ImmutableShortSingletonBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableShortSingletonBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableShortSingletonBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableShortSingletonBagTest::toSet;
            this.payloads.toBag = ImmutableShortSingletonBagTest::toBag;
            this.payloads.asLazy = ImmutableShortSingletonBagTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableShortSingletonBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableShortSingletonBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableShortSingletonBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableShortSingletonBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableShortSingletonBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableShortSingletonBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableShortSingletonBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableShortSingletonBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortSingletonBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableShortSingletonBagTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableShortSingletonBagTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableShortSingletonBagTest::chunk;
            this.payloads.testNewWith = ImmutableShortSingletonBagTest::testNewWith;
            this.payloads.newWithAll = ImmutableShortSingletonBagTest::newWithAll;
            this.payloads.newWithout = ImmutableShortSingletonBagTest::newWithout;
            this.payloads.newWithoutAll = ImmutableShortSingletonBagTest::newWithoutAll;
            this.payloads.sizeDistinct = ImmutableShortSingletonBagTest::sizeDistinct;
            this.payloads.topOccurrences = ImmutableShortSingletonBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableShortSingletonBagTest::bottomOccurrences;
            this.payloads.shortIterator = ImmutableShortSingletonBagTest::shortIterator;
            this.payloads.forEach = ImmutableShortSingletonBagTest::forEach;
            this.payloads.count = ImmutableShortSingletonBagTest::count;
            this.payloads.sum = ImmutableShortSingletonBagTest::sum;
            this.payloads.testEquals = ImmutableShortSingletonBagTest::testEquals;
            this.payloads.testToString = ImmutableShortSingletonBagTest::testToString;
            this.payloads.makeString = ImmutableShortSingletonBagTest::makeString;
            this.payloads.appendString = ImmutableShortSingletonBagTest::appendString;
            this.payloads.toList = ImmutableShortSingletonBagTest::toList;
            this.payloads.toSortedList = ImmutableShortSingletonBagTest::toSortedList;
            this.payloads.toImmutable = ImmutableShortSingletonBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ImmutableShortSingletonBagTest::toStringOfItemToCount;
            this.payloads.forEachWithOccurrences = ImmutableShortSingletonBagTest::forEachWithOccurrences;
            this.payloads.selectByOccurrences = ImmutableShortSingletonBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableShortSingletonBagTest::selectDuplicates;
            this.payloads.selectUnique = ImmutableShortSingletonBagTest::selectUnique;
            this.payloads.injectInto = ImmutableShortSingletonBagTest::injectInto;
        }
    }
}
