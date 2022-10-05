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

import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class CharHashBagTest extends AbstractMutableCharBagTestCase {

    @Override
    protected final CharHashBag classUnderTest() {
        return CharHashBag.newBagWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected CharHashBag newWith(char... elements) {
        return CharHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new CharHashBag(3));
        Verify.assertSize(0, CharHashBag.newBag(3));
        Verify.assertSize(3, CharHashBag.newBagWith((char) 0, (char) 1, (char) 2));
        Verify.assertSize(3, new CharHashBag(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2)));
        Verify.assertSize(3, CharHashBag.newBag(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2)));
        Verify.assertSize(3, CharHashBag.newBag(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
        Verify.assertSize(3, new CharHashBag(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        CharHashBag hashBag = new CharHashBag().with((char) 1);
        CharHashBag hashBag0 = new CharHashBag().with((char) 1, (char) 2);
        CharHashBag hashBag1 = new CharHashBag().with((char) 1, (char) 2, (char) 3);
        CharHashBag hashBag2 = new CharHashBag().with((char) 1).with((char) 2).with((char) 3).with((char) 4);
        CharHashBag hashBag3 = new CharHashBag().with((char) 1).with((char) 2).with((char) 3).with((char) 4).with((char) 5);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), hashBag);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), hashBag0);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), hashBag1);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4), hashBag2);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        CharHashBag hashBag = CharHashBag.newBagWith((char) 1, (char) 1, (char) 2, (char) 2, (char) 2, (char) 2, (char) 3);
        Character sum = hashBag.injectInto(Character.valueOf((char) 4), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 17), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharHashBagTest instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new CharHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CharHashBagTest::newCollectionWith;
            this.payloads.newCollection = CharHashBagTest::newCollection;
            this.payloads.isEmpty = CharHashBagTest::isEmpty;
            this.payloads.notEmpty = CharHashBagTest::notEmpty;
            this.payloads.tap = CharHashBagTest::tap;
            this.payloads.containsAllArray = CharHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = CharHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = CharHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = CharHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = CharHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = CharHashBagTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = CharHashBagTest::anySatisfy;
            this.payloads.allSatisfy = CharHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = CharHashBagTest::noneSatisfy;
            this.payloads.collect = CharHashBagTest::collect;
            this.payloads.collectWithTarget = CharHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CharHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CharHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CharHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CharHashBagTest::collectPrimitivesToSets;
            this.payloads.select = CharHashBagTest::select;
            this.payloads.selectWithTarget = CharHashBagTest::selectWithTarget;
            this.payloads.reject = CharHashBagTest::reject;
            this.payloads.rejectWithTarget = CharHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = CharHashBagTest::detectIfNone;
            this.payloads.max = CharHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = CharHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = CharHashBagTest::summaryStatistics;
            this.payloads.average = CharHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CharHashBagTest::averageIfEmpty;
            this.payloads.median = CharHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CharHashBagTest::medianIfEmpty;
            this.payloads.toArray = CharHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = CharHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = CharHashBagTest::toSortedArray;
            this.payloads.testHashCode = CharHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = CharHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CharHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CharHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CharHashBagTest::toSet;
            this.payloads.toBag = CharHashBagTest::toBag;
            this.payloads.asLazy = CharHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = CharHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CharHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = CharHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = CharHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = CharHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = CharHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = CharHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = CharHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CharHashBagTest::reduce;
            this.payloads.reduceIfEmpty = CharHashBagTest::reduceIfEmpty;
            this.payloads.chunk = CharHashBagTest::chunk;
            this.payloads.clear = CharHashBagTest::clear;
            this.payloads.contains = CharHashBagTest::contains;
            this.payloads.addAllArray = CharHashBagTest::addAllArray;
            this.payloads.removeIf = CharHashBagTest::removeIf;
            this.payloads.removeAll = CharHashBagTest::removeAll;
            this.payloads.removeAll_iterable = CharHashBagTest::removeAll_iterable;
            this.payloads.retainAll = CharHashBagTest::retainAll;
            this.payloads.retainAll_iterable = CharHashBagTest::retainAll_iterable;
            this.payloads.withAll = CharHashBagTest::withAll;
            this.payloads.without = CharHashBagTest::without;
            this.payloads.withoutAll = CharHashBagTest::withoutAll;
            this.payloads.asSynchronized = CharHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = CharHashBagTest::asUnmodifiable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_for_remove_before_next = CharHashBagTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = CharHashBagTest::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = CharHashBagTest::newEmpty;
            this.payloads.sizeDistinct = CharHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = CharHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = CharHashBagTest::selectDuplicates;
            this.payloads.selectUnique = CharHashBagTest::selectUnique;
            this.payloads.topOccurrences = CharHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = CharHashBagTest::bottomOccurrences;
            this.payloads.addOccurrences = CharHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = CharHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = CharHashBagTest::forEachWithOccurrences;
            this.payloads.add = CharHashBagTest::add;
            this.payloads.addAllIterable = CharHashBagTest::addAllIterable;
            this.payloads.remove = CharHashBagTest::remove;
            this.payloads.charIterator = CharHashBagTest::charIterator;
            this.payloads.charIterator_with_remove = CharHashBagTest::charIterator_with_remove;
            this.payloads.forEach = CharHashBagTest::forEach;
            this.payloads.count = CharHashBagTest::count;
            this.payloads.sum = CharHashBagTest::sum;
            this.payloads.testEquals = CharHashBagTest::testEquals;
            this.payloads.testToString = CharHashBagTest::testToString;
            this.payloads.makeString = CharHashBagTest::makeString;
            this.payloads.appendString = CharHashBagTest::appendString;
            this.payloads.toList = CharHashBagTest::toList;
            this.payloads.toSortedList = CharHashBagTest::toSortedList;
            this.payloads.toImmutable = CharHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = CharHashBagTest::toStringOfItemToCount;
            this.payloads.size = CharHashBagTest::size;
            this.payloads.with = CharHashBagTest::with;
            this.payloads.injectInto = CharHashBagTest::injectInto;
        }
    }
}
