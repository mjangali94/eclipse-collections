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

import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class IntHashBagTest extends AbstractMutableIntBagTestCase {

    @Override
    protected final IntHashBag classUnderTest() {
        return IntHashBag.newBagWith(1, 2, 3);
    }

    @Override
    protected IntHashBag newWith(int... elements) {
        return IntHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new IntHashBag(3));
        Verify.assertSize(0, IntHashBag.newBag(3));
        Verify.assertSize(3, IntHashBag.newBagWith(0, 1, 2));
        Verify.assertSize(3, new IntHashBag(IntHashBag.newBagWith(0, 1, 2)));
        Verify.assertSize(3, IntHashBag.newBag(IntHashBag.newBagWith(0, 1, 2)));
        Verify.assertSize(3, IntHashBag.newBag(IntArrayList.newListWith(0, 1, 2)));
        Verify.assertSize(3, new IntHashBag(IntArrayList.newListWith(0, 1, 2)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        IntHashBag hashBag = new IntHashBag().with(1);
        IntHashBag hashBag0 = new IntHashBag().with(1, 2);
        IntHashBag hashBag1 = new IntHashBag().with(1, 2, 3);
        IntHashBag hashBag2 = new IntHashBag().with(1).with(2).with(3).with(4);
        IntHashBag hashBag3 = new IntHashBag().with(1).with(2).with(3).with(4).with(5);
        Assert.assertEquals(IntHashBag.newBagWith(1), hashBag);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), hashBag0);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), hashBag1);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4), hashBag2);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        IntHashBag hashBag = IntHashBag.newBagWith(1, 1, 2, 2, 2, 2, 3);
        Integer sum = hashBag.injectInto(Integer.valueOf(4), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(17), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntHashBagTest instance;

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
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new IntHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = IntHashBagTest::newCollectionWith;
            this.payloads.newCollection = IntHashBagTest::newCollection;
            this.payloads.isEmpty = IntHashBagTest::isEmpty;
            this.payloads.notEmpty = IntHashBagTest::notEmpty;
            this.payloads.tap = IntHashBagTest::tap;
            this.payloads.containsAllArray = IntHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = IntHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = IntHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = IntHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = IntHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = IntHashBagTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = IntHashBagTest::anySatisfy;
            this.payloads.allSatisfy = IntHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = IntHashBagTest::noneSatisfy;
            this.payloads.collect = IntHashBagTest::collect;
            this.payloads.collectWithTarget = IntHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = IntHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = IntHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = IntHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = IntHashBagTest::collectPrimitivesToSets;
            this.payloads.select = IntHashBagTest::select;
            this.payloads.selectWithTarget = IntHashBagTest::selectWithTarget;
            this.payloads.reject = IntHashBagTest::reject;
            this.payloads.rejectWithTarget = IntHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = IntHashBagTest::detectIfNone;
            this.payloads.max = IntHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = IntHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = IntHashBagTest::summaryStatistics;
            this.payloads.average = IntHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = IntHashBagTest::averageIfEmpty;
            this.payloads.median = IntHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = IntHashBagTest::medianIfEmpty;
            this.payloads.toArray = IntHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = IntHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = IntHashBagTest::toSortedArray;
            this.payloads.testHashCode = IntHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = IntHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = IntHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = IntHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = IntHashBagTest::toSet;
            this.payloads.toBag = IntHashBagTest::toBag;
            this.payloads.asLazy = IntHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = IntHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = IntHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = IntHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = IntHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = IntHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = IntHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = IntHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = IntHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = IntHashBagTest::reduce;
            this.payloads.reduceIfEmpty = IntHashBagTest::reduceIfEmpty;
            this.payloads.chunk = IntHashBagTest::chunk;
            this.payloads.clear = IntHashBagTest::clear;
            this.payloads.contains = IntHashBagTest::contains;
            this.payloads.addAllArray = IntHashBagTest::addAllArray;
            this.payloads.removeIf = IntHashBagTest::removeIf;
            this.payloads.removeAll = IntHashBagTest::removeAll;
            this.payloads.removeAll_iterable = IntHashBagTest::removeAll_iterable;
            this.payloads.retainAll = IntHashBagTest::retainAll;
            this.payloads.retainAll_iterable = IntHashBagTest::retainAll_iterable;
            this.payloads.withAll = IntHashBagTest::withAll;
            this.payloads.without = IntHashBagTest::without;
            this.payloads.withoutAll = IntHashBagTest::withoutAll;
            this.payloads.asSynchronized = IntHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = IntHashBagTest::asUnmodifiable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_for_remove_before_next = IntHashBagTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = IntHashBagTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = IntHashBagTest::newEmpty;
            this.payloads.sizeDistinct = IntHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = IntHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = IntHashBagTest::selectDuplicates;
            this.payloads.selectUnique = IntHashBagTest::selectUnique;
            this.payloads.topOccurrences = IntHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = IntHashBagTest::bottomOccurrences;
            this.payloads.addOccurrences = IntHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = IntHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = IntHashBagTest::forEachWithOccurrences;
            this.payloads.add = IntHashBagTest::add;
            this.payloads.addAllIterable = IntHashBagTest::addAllIterable;
            this.payloads.remove = IntHashBagTest::remove;
            this.payloads.intIterator = IntHashBagTest::intIterator;
            this.payloads.intIterator_with_remove = IntHashBagTest::intIterator_with_remove;
            this.payloads.forEach = IntHashBagTest::forEach;
            this.payloads.count = IntHashBagTest::count;
            this.payloads.sum = IntHashBagTest::sum;
            this.payloads.testEquals = IntHashBagTest::testEquals;
            this.payloads.testToString = IntHashBagTest::testToString;
            this.payloads.makeString = IntHashBagTest::makeString;
            this.payloads.appendString = IntHashBagTest::appendString;
            this.payloads.toList = IntHashBagTest::toList;
            this.payloads.toSortedList = IntHashBagTest::toSortedList;
            this.payloads.toImmutable = IntHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = IntHashBagTest::toStringOfItemToCount;
            this.payloads.size = IntHashBagTest::size;
            this.payloads.with = IntHashBagTest::with;
            this.payloads.injectInto = IntHashBagTest::injectInto;
        }
    }
}
