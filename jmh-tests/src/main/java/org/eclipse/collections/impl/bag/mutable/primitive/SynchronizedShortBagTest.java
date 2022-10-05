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

import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortBag}.
 * This file was automatically generated from template file synchronizedPrimitiveBagTest.stg.
 */
public class SynchronizedShortBagTest extends AbstractMutableShortBagTestCase {

    @Override
    protected SynchronizedShortBag classUnderTest() {
        return new SynchronizedShortBag(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected SynchronizedShortBag newWith(short... elements) {
        return new SynchronizedShortBag(ShortHashBag.newBagWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedShortBag bag = this.classUnderTest();
        MutableShortBag bagWithLockObject = new SynchronizedShortBag(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), new Object());
        Assert.assertEquals(bag, bagWithLockObject);
        Assert.assertSame(bagWithLockObject, bagWithLockObject.asSynchronized());
        Assert.assertSame(bag, bag.asSynchronized());
        Assert.assertEquals(bag, bag.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedShortBagTest instance;

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
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBagTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedShortBagTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedShortBagTest::newCollection;
            this.payloads.isEmpty = SynchronizedShortBagTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortBagTest::notEmpty;
            this.payloads.tap = SynchronizedShortBagTest::tap;
            this.payloads.containsAllArray = SynchronizedShortBagTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedShortBagTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedShortBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedShortBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedShortBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedShortBagTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = SynchronizedShortBagTest::size;
            this.payloads.anySatisfy = SynchronizedShortBagTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedShortBagTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedShortBagTest::noneSatisfy;
            this.payloads.collect = SynchronizedShortBagTest::collect;
            this.payloads.collectWithTarget = SynchronizedShortBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedShortBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedShortBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedShortBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedShortBagTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedShortBagTest::select;
            this.payloads.selectWithTarget = SynchronizedShortBagTest::selectWithTarget;
            this.payloads.reject = SynchronizedShortBagTest::reject;
            this.payloads.rejectWithTarget = SynchronizedShortBagTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedShortBagTest::detectIfNone;
            this.payloads.max = SynchronizedShortBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedShortBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedShortBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedShortBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedShortBagTest::summaryStatistics;
            this.payloads.average = SynchronizedShortBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedShortBagTest::averageIfEmpty;
            this.payloads.median = SynchronizedShortBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedShortBagTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedShortBagTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedShortBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedShortBagTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedShortBagTest::testHashCode;
            this.payloads.toSortedListByComparator = SynchronizedShortBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedShortBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedShortBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedShortBagTest::toSet;
            this.payloads.toBag = SynchronizedShortBagTest::toBag;
            this.payloads.asLazy = SynchronizedShortBagTest::asLazy;
            this.payloads.injectInto = SynchronizedShortBagTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedShortBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedShortBagTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedShortBagTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedShortBagTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedShortBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedShortBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedShortBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedShortBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedShortBagTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedShortBagTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedShortBagTest::chunk;
            this.payloads.clear = SynchronizedShortBagTest::clear;
            this.payloads.contains = SynchronizedShortBagTest::contains;
            this.payloads.addAllArray = SynchronizedShortBagTest::addAllArray;
            this.payloads.removeIf = SynchronizedShortBagTest::removeIf;
            this.payloads.removeAll = SynchronizedShortBagTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedShortBagTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedShortBagTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedShortBagTest::retainAll_iterable;
            this.payloads.with = SynchronizedShortBagTest::with;
            this.payloads.withAll = SynchronizedShortBagTest::withAll;
            this.payloads.without = SynchronizedShortBagTest::without;
            this.payloads.withoutAll = SynchronizedShortBagTest::withoutAll;
            this.payloads.asUnmodifiable = SynchronizedShortBagTest::asUnmodifiable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_for_remove_before_next = SynchronizedShortBagTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = SynchronizedShortBagTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedShortBagTest::newEmpty;
            this.payloads.sizeDistinct = SynchronizedShortBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = SynchronizedShortBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = SynchronizedShortBagTest::selectDuplicates;
            this.payloads.selectUnique = SynchronizedShortBagTest::selectUnique;
            this.payloads.topOccurrences = SynchronizedShortBagTest::topOccurrences;
            this.payloads.bottomOccurrences = SynchronizedShortBagTest::bottomOccurrences;
            this.payloads.addOccurrences = SynchronizedShortBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = SynchronizedShortBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = SynchronizedShortBagTest::forEachWithOccurrences;
            this.payloads.add = SynchronizedShortBagTest::add;
            this.payloads.addAllIterable = SynchronizedShortBagTest::addAllIterable;
            this.payloads.remove = SynchronizedShortBagTest::remove;
            this.payloads.shortIterator = SynchronizedShortBagTest::shortIterator;
            this.payloads.shortIterator_with_remove = SynchronizedShortBagTest::shortIterator_with_remove;
            this.payloads.forEach = SynchronizedShortBagTest::forEach;
            this.payloads.count = SynchronizedShortBagTest::count;
            this.payloads.sum = SynchronizedShortBagTest::sum;
            this.payloads.testEquals = SynchronizedShortBagTest::testEquals;
            this.payloads.testToString = SynchronizedShortBagTest::testToString;
            this.payloads.makeString = SynchronizedShortBagTest::makeString;
            this.payloads.appendString = SynchronizedShortBagTest::appendString;
            this.payloads.toList = SynchronizedShortBagTest::toList;
            this.payloads.toSortedList = SynchronizedShortBagTest::toSortedList;
            this.payloads.toImmutable = SynchronizedShortBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = SynchronizedShortBagTest::toStringOfItemToCount;
            this.payloads.asSynchronized = SynchronizedShortBagTest::asSynchronized;
        }
    }
}
