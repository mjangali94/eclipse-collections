/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.primitive.SynchronizedByteIterable;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedByteIterable}s
 * This file was automatically generated from template file synchronizedPrimitiveIterableTest.stg.
 */
public class SynchronizedByteIterableTest extends AbstractByteIterableTestCase {

    @Override
    protected ByteIterable classUnderTest() {
        return SynchronizedByteIterable.of(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected ByteIterable newWith(byte... elements) {
        return SynchronizedByteIterable.of(ByteArrayList.newListWith(elements));
    }

    @Override
    protected ByteIterable newMutableCollectionWith(byte... elements) {
        return ByteArrayList.newListWith(elements);
    }

    @Override
    protected RichIterable<Byte> newObjectCollectionWith(Byte... elements) {
        return FastList.newListWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_iterable_throws() {
        SynchronizedByteIterable.of(null);
    }

    @Override
    @Test
    public void byteIterator() {
        ByteIterable iterable = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3);
        ByteArrayList list = ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3);
        ByteIterator iterator = iterable.byteIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void testEquals() {
        // Testing equals() is not applicable.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable.
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedByteIterableTest instance;

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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_null_iterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.null_iterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> null_iterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIterableTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedByteIterableTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedByteIterableTest::newCollection;
            this.payloads.isEmpty = SynchronizedByteIterableTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteIterableTest::notEmpty;
            this.payloads.tap = SynchronizedByteIterableTest::tap;
            this.payloads.contains = SynchronizedByteIterableTest::contains;
            this.payloads.containsAllArray = SynchronizedByteIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedByteIterableTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedByteIterableTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedByteIterableTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedByteIterableTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedByteIterableTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedByteIterableTest::forEach;
            this.payloads.size = SynchronizedByteIterableTest::size;
            this.payloads.count = SynchronizedByteIterableTest::count;
            this.payloads.anySatisfy = SynchronizedByteIterableTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedByteIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedByteIterableTest::noneSatisfy;
            this.payloads.collect = SynchronizedByteIterableTest::collect;
            this.payloads.collectWithTarget = SynchronizedByteIterableTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedByteIterableTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedByteIterableTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedByteIterableTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedByteIterableTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedByteIterableTest::select;
            this.payloads.selectWithTarget = SynchronizedByteIterableTest::selectWithTarget;
            this.payloads.reject = SynchronizedByteIterableTest::reject;
            this.payloads.rejectWithTarget = SynchronizedByteIterableTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedByteIterableTest::detectIfNone;
            this.payloads.max = SynchronizedByteIterableTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedByteIterableTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedByteIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedByteIterableTest::maxIfEmpty;
            this.payloads.sum = SynchronizedByteIterableTest::sum;
            this.payloads.summaryStatistics = SynchronizedByteIterableTest::summaryStatistics;
            this.payloads.average = SynchronizedByteIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedByteIterableTest::averageIfEmpty;
            this.payloads.median = SynchronizedByteIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedByteIterableTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedByteIterableTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedByteIterableTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedByteIterableTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedByteIterableTest::testHashCode;
            this.payloads.testToString = SynchronizedByteIterableTest::testToString;
            this.payloads.makeString = SynchronizedByteIterableTest::makeString;
            this.payloads.appendString = SynchronizedByteIterableTest::appendString;
            this.payloads.toList = SynchronizedByteIterableTest::toList;
            this.payloads.toSortedList = SynchronizedByteIterableTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedByteIterableTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedByteIterableTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedByteIterableTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedByteIterableTest::toSet;
            this.payloads.toBag = SynchronizedByteIterableTest::toBag;
            this.payloads.asLazy = SynchronizedByteIterableTest::asLazy;
            this.payloads.injectInto = SynchronizedByteIterableTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedByteIterableTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedByteIterableTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedByteIterableTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedByteIterableTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedByteIterableTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedByteIterableTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedByteIterableTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedByteIterableTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedByteIterableTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedByteIterableTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedByteIterableTest::chunk;
            this.payloads.null_iterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIterableTest::null_iterable_throws, java.lang.IllegalArgumentException.class);
            this.payloads.byteIterator = SynchronizedByteIterableTest::byteIterator;
            this.payloads.testEquals = SynchronizedByteIterableTest::testEquals;
        }
    }
}
