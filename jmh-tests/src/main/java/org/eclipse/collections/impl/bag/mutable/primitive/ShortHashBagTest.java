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

import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class ShortHashBagTest extends AbstractMutableShortBagTestCase {

    @Override
    protected final ShortHashBag classUnderTest() {
        return ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    protected ShortHashBag newWith(short... elements) {
        return ShortHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new ShortHashBag(3));
        Verify.assertSize(0, ShortHashBag.newBag(3));
        Verify.assertSize(3, ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2));
        Verify.assertSize(3, new ShortHashBag(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2)));
        Verify.assertSize(3, ShortHashBag.newBag(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2)));
        Verify.assertSize(3, ShortHashBag.newBag(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
        Verify.assertSize(3, new ShortHashBag(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        ShortHashBag hashBag = new ShortHashBag().with((short) 1);
        ShortHashBag hashBag0 = new ShortHashBag().with((short) 1, (short) 2);
        ShortHashBag hashBag1 = new ShortHashBag().with((short) 1, (short) 2, (short) 3);
        ShortHashBag hashBag2 = new ShortHashBag().with((short) 1).with((short) 2).with((short) 3).with((short) 4);
        ShortHashBag hashBag3 = new ShortHashBag().with((short) 1).with((short) 2).with((short) 3).with((short) 4).with((short) 5);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), hashBag);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), hashBag0);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), hashBag1);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4), hashBag2);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ShortHashBag hashBag = ShortHashBag.newBagWith((short) 1, (short) 1, (short) 2, (short) 2, (short) 2, (short) 2, (short) 3);
        Short sum = hashBag.injectInto(Short.valueOf((short) 4), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 17), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortHashBagTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new ShortHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ShortHashBagTest::newCollectionWith;
            this.payloads.newCollection = ShortHashBagTest::newCollection;
            this.payloads.isEmpty = ShortHashBagTest::isEmpty;
            this.payloads.notEmpty = ShortHashBagTest::notEmpty;
            this.payloads.tap = ShortHashBagTest::tap;
            this.payloads.containsAllArray = ShortHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = ShortHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ShortHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ShortHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ShortHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ShortHashBagTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ShortHashBagTest::anySatisfy;
            this.payloads.allSatisfy = ShortHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = ShortHashBagTest::noneSatisfy;
            this.payloads.collect = ShortHashBagTest::collect;
            this.payloads.collectWithTarget = ShortHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ShortHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ShortHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ShortHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ShortHashBagTest::collectPrimitivesToSets;
            this.payloads.select = ShortHashBagTest::select;
            this.payloads.selectWithTarget = ShortHashBagTest::selectWithTarget;
            this.payloads.reject = ShortHashBagTest::reject;
            this.payloads.rejectWithTarget = ShortHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ShortHashBagTest::detectIfNone;
            this.payloads.max = ShortHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ShortHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ShortHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ShortHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ShortHashBagTest::summaryStatistics;
            this.payloads.average = ShortHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ShortHashBagTest::averageIfEmpty;
            this.payloads.median = ShortHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ShortHashBagTest::medianIfEmpty;
            this.payloads.toArray = ShortHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ShortHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ShortHashBagTest::toSortedArray;
            this.payloads.testHashCode = ShortHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ShortHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ShortHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ShortHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ShortHashBagTest::toSet;
            this.payloads.toBag = ShortHashBagTest::toBag;
            this.payloads.asLazy = ShortHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = ShortHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ShortHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ShortHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ShortHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ShortHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ShortHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ShortHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ShortHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ShortHashBagTest::reduce;
            this.payloads.reduceIfEmpty = ShortHashBagTest::reduceIfEmpty;
            this.payloads.chunk = ShortHashBagTest::chunk;
            this.payloads.clear = ShortHashBagTest::clear;
            this.payloads.contains = ShortHashBagTest::contains;
            this.payloads.addAllArray = ShortHashBagTest::addAllArray;
            this.payloads.removeIf = ShortHashBagTest::removeIf;
            this.payloads.removeAll = ShortHashBagTest::removeAll;
            this.payloads.removeAll_iterable = ShortHashBagTest::removeAll_iterable;
            this.payloads.retainAll = ShortHashBagTest::retainAll;
            this.payloads.retainAll_iterable = ShortHashBagTest::retainAll_iterable;
            this.payloads.withAll = ShortHashBagTest::withAll;
            this.payloads.without = ShortHashBagTest::without;
            this.payloads.withoutAll = ShortHashBagTest::withoutAll;
            this.payloads.asSynchronized = ShortHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = ShortHashBagTest::asUnmodifiable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_for_remove_before_next = ShortHashBagTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = ShortHashBagTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ShortHashBagTest::newEmpty;
            this.payloads.sizeDistinct = ShortHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = ShortHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ShortHashBagTest::selectDuplicates;
            this.payloads.selectUnique = ShortHashBagTest::selectUnique;
            this.payloads.topOccurrences = ShortHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ShortHashBagTest::bottomOccurrences;
            this.payloads.addOccurrences = ShortHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = ShortHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = ShortHashBagTest::forEachWithOccurrences;
            this.payloads.add = ShortHashBagTest::add;
            this.payloads.addAllIterable = ShortHashBagTest::addAllIterable;
            this.payloads.remove = ShortHashBagTest::remove;
            this.payloads.shortIterator = ShortHashBagTest::shortIterator;
            this.payloads.shortIterator_with_remove = ShortHashBagTest::shortIterator_with_remove;
            this.payloads.forEach = ShortHashBagTest::forEach;
            this.payloads.count = ShortHashBagTest::count;
            this.payloads.sum = ShortHashBagTest::sum;
            this.payloads.testEquals = ShortHashBagTest::testEquals;
            this.payloads.testToString = ShortHashBagTest::testToString;
            this.payloads.makeString = ShortHashBagTest::makeString;
            this.payloads.appendString = ShortHashBagTest::appendString;
            this.payloads.toList = ShortHashBagTest::toList;
            this.payloads.toSortedList = ShortHashBagTest::toSortedList;
            this.payloads.toImmutable = ShortHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ShortHashBagTest::toStringOfItemToCount;
            this.payloads.size = ShortHashBagTest::size;
            this.payloads.with = ShortHashBagTest::with;
            this.payloads.injectInto = ShortHashBagTest::injectInto;
        }
    }
}
