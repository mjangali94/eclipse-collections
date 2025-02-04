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

import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatBag}.
 * This file was automatically generated from template file synchronizedPrimitiveBagTest.stg.
 */
public class SynchronizedFloatBagTest extends AbstractMutableFloatBagTestCase {

    @Override
    protected SynchronizedFloatBag classUnderTest() {
        return new SynchronizedFloatBag(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected SynchronizedFloatBag newWith(float... elements) {
        return new SynchronizedFloatBag(FloatHashBag.newBagWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedFloatBag bag = this.classUnderTest();
        MutableFloatBag bagWithLockObject = new SynchronizedFloatBag(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), new Object());
        Assert.assertEquals(bag, bagWithLockObject);
        Assert.assertSame(bagWithLockObject, bagWithLockObject.asSynchronized());
        Assert.assertSame(bag, bag.asSynchronized());
        Assert.assertEquals(bag, bag.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedFloatBagTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedFloatBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatBagTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedFloatBagTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedFloatBagTest::newCollection;
            this.payloads.isEmpty = SynchronizedFloatBagTest::isEmpty;
            this.payloads.notEmpty = SynchronizedFloatBagTest::notEmpty;
            this.payloads.tap = SynchronizedFloatBagTest::tap;
            this.payloads.contains_NaN = SynchronizedFloatBagTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedFloatBagTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedFloatBagTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedFloatBagTest::contains_zero;
            this.payloads.testEquals_NaN = SynchronizedFloatBagTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = SynchronizedFloatBagTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedFloatBagTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedFloatBagTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedFloatBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedFloatBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedFloatBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedFloatBagTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = SynchronizedFloatBagTest::size;
            this.payloads.anySatisfy = SynchronizedFloatBagTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedFloatBagTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedFloatBagTest::noneSatisfy;
            this.payloads.collect = SynchronizedFloatBagTest::collect;
            this.payloads.collectWithTarget = SynchronizedFloatBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedFloatBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedFloatBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedFloatBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedFloatBagTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedFloatBagTest::select;
            this.payloads.selectWithTarget = SynchronizedFloatBagTest::selectWithTarget;
            this.payloads.reject = SynchronizedFloatBagTest::reject;
            this.payloads.rejectWithTarget = SynchronizedFloatBagTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedFloatBagTest::detectIfNone;
            this.payloads.max = SynchronizedFloatBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedFloatBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedFloatBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedFloatBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = SynchronizedFloatBagTest::summaryStatistics;
            this.payloads.sumConsistentRounding = SynchronizedFloatBagTest::sumConsistentRounding;
            this.payloads.average = SynchronizedFloatBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedFloatBagTest::averageIfEmpty;
            this.payloads.median = SynchronizedFloatBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedFloatBagTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedFloatBagTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedFloatBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedFloatBagTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedFloatBagTest::testHashCode;
            this.payloads.toSortedListByComparator = SynchronizedFloatBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedFloatBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedFloatBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedFloatBagTest::toSet;
            this.payloads.toBag = SynchronizedFloatBagTest::toBag;
            this.payloads.asLazy = SynchronizedFloatBagTest::asLazy;
            this.payloads.injectInto = SynchronizedFloatBagTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedFloatBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedFloatBagTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedFloatBagTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedFloatBagTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedFloatBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedFloatBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedFloatBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedFloatBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedFloatBagTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedFloatBagTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedFloatBagTest::chunk;
            this.payloads.clear = SynchronizedFloatBagTest::clear;
            this.payloads.contains = SynchronizedFloatBagTest::contains;
            this.payloads.addAllArray = SynchronizedFloatBagTest::addAllArray;
            this.payloads.removeIf = SynchronizedFloatBagTest::removeIf;
            this.payloads.removeAll = SynchronizedFloatBagTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedFloatBagTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedFloatBagTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedFloatBagTest::retainAll_iterable;
            this.payloads.with = SynchronizedFloatBagTest::with;
            this.payloads.withAll = SynchronizedFloatBagTest::withAll;
            this.payloads.without = SynchronizedFloatBagTest::without;
            this.payloads.withoutAll = SynchronizedFloatBagTest::withoutAll;
            this.payloads.asUnmodifiable = SynchronizedFloatBagTest::asUnmodifiable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_for_remove_before_next = SynchronizedFloatBagTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = SynchronizedFloatBagTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedFloatBagTest::newEmpty;
            this.payloads.sizeDistinct = SynchronizedFloatBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = SynchronizedFloatBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = SynchronizedFloatBagTest::selectDuplicates;
            this.payloads.selectUnique = SynchronizedFloatBagTest::selectUnique;
            this.payloads.topOccurrences = SynchronizedFloatBagTest::topOccurrences;
            this.payloads.bottomOccurrences = SynchronizedFloatBagTest::bottomOccurrences;
            this.payloads.addOccurrences = SynchronizedFloatBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = SynchronizedFloatBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = SynchronizedFloatBagTest::forEachWithOccurrences;
            this.payloads.add = SynchronizedFloatBagTest::add;
            this.payloads.addAllIterable = SynchronizedFloatBagTest::addAllIterable;
            this.payloads.remove = SynchronizedFloatBagTest::remove;
            this.payloads.floatIterator = SynchronizedFloatBagTest::floatIterator;
            this.payloads.floatIterator_with_remove = SynchronizedFloatBagTest::floatIterator_with_remove;
            this.payloads.forEach = SynchronizedFloatBagTest::forEach;
            this.payloads.count = SynchronizedFloatBagTest::count;
            this.payloads.sum = SynchronizedFloatBagTest::sum;
            this.payloads.testEquals = SynchronizedFloatBagTest::testEquals;
            this.payloads.testToString = SynchronizedFloatBagTest::testToString;
            this.payloads.makeString = SynchronizedFloatBagTest::makeString;
            this.payloads.appendString = SynchronizedFloatBagTest::appendString;
            this.payloads.toList = SynchronizedFloatBagTest::toList;
            this.payloads.toSortedList = SynchronizedFloatBagTest::toSortedList;
            this.payloads.toImmutable = SynchronizedFloatBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = SynchronizedFloatBagTest::toStringOfItemToCount;
            this.payloads.asSynchronized = SynchronizedFloatBagTest::asSynchronized;
        }
    }
}
