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

import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class LongHashBagTest extends AbstractMutableLongBagTestCase {

    @Override
    protected final LongHashBag classUnderTest() {
        return LongHashBag.newBagWith(1L, 2L, 3L);
    }

    @Override
    protected LongHashBag newWith(long... elements) {
        return LongHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new LongHashBag(3));
        Verify.assertSize(0, LongHashBag.newBag(3));
        Verify.assertSize(3, LongHashBag.newBagWith(0L, 1L, 2L));
        Verify.assertSize(3, new LongHashBag(LongHashBag.newBagWith(0L, 1L, 2L)));
        Verify.assertSize(3, LongHashBag.newBag(LongHashBag.newBagWith(0L, 1L, 2L)));
        Verify.assertSize(3, LongHashBag.newBag(LongArrayList.newListWith(0L, 1L, 2L)));
        Verify.assertSize(3, new LongHashBag(LongArrayList.newListWith(0L, 1L, 2L)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        LongHashBag hashBag = new LongHashBag().with(1L);
        LongHashBag hashBag0 = new LongHashBag().with(1L, 2L);
        LongHashBag hashBag1 = new LongHashBag().with(1L, 2L, 3L);
        LongHashBag hashBag2 = new LongHashBag().with(1L).with(2L).with(3L).with(4L);
        LongHashBag hashBag3 = new LongHashBag().with(1L).with(2L).with(3L).with(4L).with(5L);
        Assert.assertEquals(LongHashBag.newBagWith(1L), hashBag);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), hashBag0);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), hashBag1);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L), hashBag2);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        LongHashBag hashBag = LongHashBag.newBagWith(1L, 1L, 2L, 2L, 2L, 2L, 3L);
        Long sum = hashBag.injectInto(Long.valueOf(4L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(17L), sum);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongHashBagTest instance;

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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new LongHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = LongHashBagTest::newCollectionWith;
            this.payloads.newCollection = LongHashBagTest::newCollection;
            this.payloads.isEmpty = LongHashBagTest::isEmpty;
            this.payloads.notEmpty = LongHashBagTest::notEmpty;
            this.payloads.tap = LongHashBagTest::tap;
            this.payloads.containsAllArray = LongHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = LongHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = LongHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = LongHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = LongHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = LongHashBagTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = LongHashBagTest::anySatisfy;
            this.payloads.allSatisfy = LongHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = LongHashBagTest::noneSatisfy;
            this.payloads.collect = LongHashBagTest::collect;
            this.payloads.collectWithTarget = LongHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = LongHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = LongHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = LongHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = LongHashBagTest::collectPrimitivesToSets;
            this.payloads.select = LongHashBagTest::select;
            this.payloads.selectWithTarget = LongHashBagTest::selectWithTarget;
            this.payloads.reject = LongHashBagTest::reject;
            this.payloads.rejectWithTarget = LongHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = LongHashBagTest::detectIfNone;
            this.payloads.max = LongHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = LongHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = LongHashBagTest::summaryStatistics;
            this.payloads.average = LongHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = LongHashBagTest::averageIfEmpty;
            this.payloads.median = LongHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = LongHashBagTest::medianIfEmpty;
            this.payloads.toArray = LongHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = LongHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = LongHashBagTest::toSortedArray;
            this.payloads.testHashCode = LongHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = LongHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = LongHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = LongHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = LongHashBagTest::toSet;
            this.payloads.toBag = LongHashBagTest::toBag;
            this.payloads.asLazy = LongHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = LongHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = LongHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = LongHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = LongHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = LongHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = LongHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = LongHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = LongHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = LongHashBagTest::reduce;
            this.payloads.reduceIfEmpty = LongHashBagTest::reduceIfEmpty;
            this.payloads.chunk = LongHashBagTest::chunk;
            this.payloads.clear = LongHashBagTest::clear;
            this.payloads.contains = LongHashBagTest::contains;
            this.payloads.addAllArray = LongHashBagTest::addAllArray;
            this.payloads.removeIf = LongHashBagTest::removeIf;
            this.payloads.removeAll = LongHashBagTest::removeAll;
            this.payloads.removeAll_iterable = LongHashBagTest::removeAll_iterable;
            this.payloads.retainAll = LongHashBagTest::retainAll;
            this.payloads.retainAll_iterable = LongHashBagTest::retainAll_iterable;
            this.payloads.withAll = LongHashBagTest::withAll;
            this.payloads.without = LongHashBagTest::without;
            this.payloads.withoutAll = LongHashBagTest::withoutAll;
            this.payloads.asSynchronized = LongHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = LongHashBagTest::asUnmodifiable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_for_remove_before_next = LongHashBagTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = LongHashBagTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = LongHashBagTest::newEmpty;
            this.payloads.sizeDistinct = LongHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = LongHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = LongHashBagTest::selectDuplicates;
            this.payloads.selectUnique = LongHashBagTest::selectUnique;
            this.payloads.topOccurrences = LongHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = LongHashBagTest::bottomOccurrences;
            this.payloads.addOccurrences = LongHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = LongHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = LongHashBagTest::forEachWithOccurrences;
            this.payloads.add = LongHashBagTest::add;
            this.payloads.addAllIterable = LongHashBagTest::addAllIterable;
            this.payloads.remove = LongHashBagTest::remove;
            this.payloads.longIterator = LongHashBagTest::longIterator;
            this.payloads.longIterator_with_remove = LongHashBagTest::longIterator_with_remove;
            this.payloads.forEach = LongHashBagTest::forEach;
            this.payloads.count = LongHashBagTest::count;
            this.payloads.sum = LongHashBagTest::sum;
            this.payloads.testEquals = LongHashBagTest::testEquals;
            this.payloads.testToString = LongHashBagTest::testToString;
            this.payloads.makeString = LongHashBagTest::makeString;
            this.payloads.appendString = LongHashBagTest::appendString;
            this.payloads.toList = LongHashBagTest::toList;
            this.payloads.toSortedList = LongHashBagTest::toSortedList;
            this.payloads.toImmutable = LongHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = LongHashBagTest::toStringOfItemToCount;
            this.payloads.size = LongHashBagTest::size;
            this.payloads.with = LongHashBagTest::with;
            this.payloads.injectInto = LongHashBagTest::injectInto;
        }
    }
*/
}
