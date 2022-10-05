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

import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.math.MutableByte;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;

/**
 * JUnit test for {@link ImmutableByteSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableByteSingletonBagTest extends AbstractImmutableByteBagTestCase {

    @Override
    protected final ImmutableByteBag classUnderTest() {
        return ByteBags.immutable.of((byte) 1);
    }

    @Override
    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((byte argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("11", string);
    }

    @Override
    @Test
    public void selectByOccurrences() {
        ImmutableByteSingletonBag bag = new ImmutableByteSingletonBag((byte) 1);
        ImmutableByteBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), filtered1);
        ImmutableByteBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(ByteBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates() {
        ImmutableByteSingletonBag bag = new ImmutableByteSingletonBag((byte) 1);
        Assert.assertEquals(ByteHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableByteBag bag = this.classUnderTest();
        ImmutableByteSet expected = ByteSets.immutable.with((byte) 1);
        ImmutableByteSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableByteSingletonBag iterable = new ImmutableByteSingletonBag((byte) 1);
        MutableByte result = iterable.injectInto(new MutableByte((byte) 1), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 2), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteSingletonBagTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteSingletonBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteSingletonBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableByteSingletonBagTest::newCollectionWith;
            this.payloads.newCollection = ImmutableByteSingletonBagTest::newCollection;
            this.payloads.isEmpty = ImmutableByteSingletonBagTest::isEmpty;
            this.payloads.notEmpty = ImmutableByteSingletonBagTest::notEmpty;
            this.payloads.tap = ImmutableByteSingletonBagTest::tap;
            this.payloads.contains = ImmutableByteSingletonBagTest::contains;
            this.payloads.containsAllArray = ImmutableByteSingletonBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableByteSingletonBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableByteSingletonBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableByteSingletonBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableByteSingletonBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableByteSingletonBagTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteSingletonBagTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteSingletonBagTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.size = ImmutableByteSingletonBagTest::size;
            this.payloads.anySatisfy = ImmutableByteSingletonBagTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteSingletonBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteSingletonBagTest::noneSatisfy;
            this.payloads.collect = ImmutableByteSingletonBagTest::collect;
            this.payloads.collectWithTarget = ImmutableByteSingletonBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableByteSingletonBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableByteSingletonBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableByteSingletonBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableByteSingletonBagTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableByteSingletonBagTest::select;
            this.payloads.selectWithTarget = ImmutableByteSingletonBagTest::selectWithTarget;
            this.payloads.reject = ImmutableByteSingletonBagTest::reject;
            this.payloads.rejectWithTarget = ImmutableByteSingletonBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableByteSingletonBagTest::detectIfNone;
            this.payloads.max = ImmutableByteSingletonBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteSingletonBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableByteSingletonBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteSingletonBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableByteSingletonBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteSingletonBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ImmutableByteSingletonBagTest::summaryStatistics;
            this.payloads.average = ImmutableByteSingletonBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteSingletonBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableByteSingletonBagTest::averageIfEmpty;
            this.payloads.median = ImmutableByteSingletonBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteSingletonBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableByteSingletonBagTest::medianIfEmpty;
            this.payloads.toArray = ImmutableByteSingletonBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableByteSingletonBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableByteSingletonBagTest::toSortedArray;
            this.payloads.testHashCode = ImmutableByteSingletonBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ImmutableByteSingletonBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableByteSingletonBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableByteSingletonBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableByteSingletonBagTest::toSet;
            this.payloads.toBag = ImmutableByteSingletonBagTest::toBag;
            this.payloads.asLazy = ImmutableByteSingletonBagTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableByteSingletonBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableByteSingletonBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableByteSingletonBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableByteSingletonBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableByteSingletonBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableByteSingletonBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableByteSingletonBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableByteSingletonBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteSingletonBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableByteSingletonBagTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableByteSingletonBagTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableByteSingletonBagTest::chunk;
            this.payloads.testNewWith = ImmutableByteSingletonBagTest::testNewWith;
            this.payloads.newWithAll = ImmutableByteSingletonBagTest::newWithAll;
            this.payloads.newWithout = ImmutableByteSingletonBagTest::newWithout;
            this.payloads.newWithoutAll = ImmutableByteSingletonBagTest::newWithoutAll;
            this.payloads.sizeDistinct = ImmutableByteSingletonBagTest::sizeDistinct;
            this.payloads.topOccurrences = ImmutableByteSingletonBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableByteSingletonBagTest::bottomOccurrences;
            this.payloads.byteIterator = ImmutableByteSingletonBagTest::byteIterator;
            this.payloads.forEach = ImmutableByteSingletonBagTest::forEach;
            this.payloads.count = ImmutableByteSingletonBagTest::count;
            this.payloads.sum = ImmutableByteSingletonBagTest::sum;
            this.payloads.testEquals = ImmutableByteSingletonBagTest::testEquals;
            this.payloads.testToString = ImmutableByteSingletonBagTest::testToString;
            this.payloads.makeString = ImmutableByteSingletonBagTest::makeString;
            this.payloads.appendString = ImmutableByteSingletonBagTest::appendString;
            this.payloads.toList = ImmutableByteSingletonBagTest::toList;
            this.payloads.toSortedList = ImmutableByteSingletonBagTest::toSortedList;
            this.payloads.toImmutable = ImmutableByteSingletonBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ImmutableByteSingletonBagTest::toStringOfItemToCount;
            this.payloads.forEachWithOccurrences = ImmutableByteSingletonBagTest::forEachWithOccurrences;
            this.payloads.selectByOccurrences = ImmutableByteSingletonBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableByteSingletonBagTest::selectDuplicates;
            this.payloads.selectUnique = ImmutableByteSingletonBagTest::selectUnique;
            this.payloads.injectInto = ImmutableByteSingletonBagTest::injectInto;
        }
    }
}
