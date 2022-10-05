/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedLongBag}.
 * This file was automatically generated from template file synchronizedPrimitiveBagTest.stg.
 */
public class SynchronizedLongBagTest extends AbstractMutableLongBagTestCase {

    @Override
    protected SynchronizedLongBag classUnderTest() {
        return new SynchronizedLongBag(LongHashBag.newBagWith(1L, 2L, 3L));
    }

    @Override
    protected SynchronizedLongBag newWith(long... elements) {
        return new SynchronizedLongBag(LongHashBag.newBagWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedLongBag bag = this.classUnderTest();
        MutableLongBag bagWithLockObject = new SynchronizedLongBag(LongHashBag.newBagWith(1L, 2L, 3L), new Object());
        Assert.assertEquals(bag, bagWithLockObject);
        Assert.assertSame(bagWithLockObject, bagWithLockObject.asSynchronized());
        Assert.assertSame(bag, bag.asSynchronized());
        Assert.assertEquals(bag, bag.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedLongBagTest instance;

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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
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
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedLongBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongBagTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedLongBagTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedLongBagTest::newCollection;
            this.payloads.isEmpty = SynchronizedLongBagTest::isEmpty;
            this.payloads.notEmpty = SynchronizedLongBagTest::notEmpty;
            this.payloads.tap = SynchronizedLongBagTest::tap;
            this.payloads.containsAllArray = SynchronizedLongBagTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedLongBagTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedLongBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedLongBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedLongBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedLongBagTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = SynchronizedLongBagTest::size;
            this.payloads.anySatisfy = SynchronizedLongBagTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedLongBagTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedLongBagTest::noneSatisfy;
            this.payloads.collect = SynchronizedLongBagTest::collect;
            this.payloads.collectWithTarget = SynchronizedLongBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedLongBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedLongBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedLongBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedLongBagTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedLongBagTest::select;
            this.payloads.selectWithTarget = SynchronizedLongBagTest::selectWithTarget;
            this.payloads.reject = SynchronizedLongBagTest::reject;
            this.payloads.rejectWithTarget = SynchronizedLongBagTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedLongBagTest::detectIfNone;
            this.payloads.max = SynchronizedLongBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedLongBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedLongBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedLongBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedLongBagTest::summaryStatistics;
            this.payloads.average = SynchronizedLongBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedLongBagTest::averageIfEmpty;
            this.payloads.median = SynchronizedLongBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedLongBagTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedLongBagTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedLongBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedLongBagTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedLongBagTest::testHashCode;
            this.payloads.toSortedListByComparator = SynchronizedLongBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedLongBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedLongBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedLongBagTest::toSet;
            this.payloads.toBag = SynchronizedLongBagTest::toBag;
            this.payloads.asLazy = SynchronizedLongBagTest::asLazy;
            this.payloads.injectInto = SynchronizedLongBagTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedLongBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedLongBagTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedLongBagTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedLongBagTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedLongBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedLongBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedLongBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedLongBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedLongBagTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedLongBagTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedLongBagTest::chunk;
            this.payloads.clear = SynchronizedLongBagTest::clear;
            this.payloads.contains = SynchronizedLongBagTest::contains;
            this.payloads.addAllArray = SynchronizedLongBagTest::addAllArray;
            this.payloads.removeIf = SynchronizedLongBagTest::removeIf;
            this.payloads.removeAll = SynchronizedLongBagTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedLongBagTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedLongBagTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedLongBagTest::retainAll_iterable;
            this.payloads.with = SynchronizedLongBagTest::with;
            this.payloads.withAll = SynchronizedLongBagTest::withAll;
            this.payloads.without = SynchronizedLongBagTest::without;
            this.payloads.withoutAll = SynchronizedLongBagTest::withoutAll;
            this.payloads.asUnmodifiable = SynchronizedLongBagTest::asUnmodifiable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_for_remove_before_next = SynchronizedLongBagTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = SynchronizedLongBagTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedLongBagTest::newEmpty;
            this.payloads.sizeDistinct = SynchronizedLongBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = SynchronizedLongBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = SynchronizedLongBagTest::selectDuplicates;
            this.payloads.selectUnique = SynchronizedLongBagTest::selectUnique;
            this.payloads.topOccurrences = SynchronizedLongBagTest::topOccurrences;
            this.payloads.bottomOccurrences = SynchronizedLongBagTest::bottomOccurrences;
            this.payloads.addOccurrences = SynchronizedLongBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = SynchronizedLongBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = SynchronizedLongBagTest::forEachWithOccurrences;
            this.payloads.add = SynchronizedLongBagTest::add;
            this.payloads.addAllIterable = SynchronizedLongBagTest::addAllIterable;
            this.payloads.remove = SynchronizedLongBagTest::remove;
            this.payloads.longIterator = SynchronizedLongBagTest::longIterator;
            this.payloads.longIterator_with_remove = SynchronizedLongBagTest::longIterator_with_remove;
            this.payloads.forEach = SynchronizedLongBagTest::forEach;
            this.payloads.count = SynchronizedLongBagTest::count;
            this.payloads.sum = SynchronizedLongBagTest::sum;
            this.payloads.testEquals = SynchronizedLongBagTest::testEquals;
            this.payloads.testToString = SynchronizedLongBagTest::testToString;
            this.payloads.makeString = SynchronizedLongBagTest::makeString;
            this.payloads.appendString = SynchronizedLongBagTest::appendString;
            this.payloads.toList = SynchronizedLongBagTest::toList;
            this.payloads.toSortedList = SynchronizedLongBagTest::toSortedList;
            this.payloads.toImmutable = SynchronizedLongBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = SynchronizedLongBagTest::toStringOfItemToCount;
            this.payloads.asSynchronized = SynchronizedLongBagTest::asSynchronized;
        }
    }
}
