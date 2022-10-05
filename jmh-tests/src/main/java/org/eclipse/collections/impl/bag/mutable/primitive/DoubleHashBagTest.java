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

import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class DoubleHashBagTest extends AbstractMutableDoubleBagTestCase {

    @Override
    protected final DoubleHashBag classUnderTest() {
        return DoubleHashBag.newBagWith(1.0, 2.0, 3.0);
    }

    @Override
    protected DoubleHashBag newWith(double... elements) {
        return DoubleHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new DoubleHashBag(3));
        Verify.assertSize(0, DoubleHashBag.newBag(3));
        Verify.assertSize(3, DoubleHashBag.newBagWith(0.0, 1.0, 2.0));
        Verify.assertSize(3, new DoubleHashBag(DoubleHashBag.newBagWith(0.0, 1.0, 2.0)));
        Verify.assertSize(3, DoubleHashBag.newBag(DoubleHashBag.newBagWith(0.0, 1.0, 2.0)));
        Verify.assertSize(3, DoubleHashBag.newBag(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
        Verify.assertSize(3, new DoubleHashBag(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        DoubleHashBag hashBag = new DoubleHashBag().with(1.0);
        DoubleHashBag hashBag0 = new DoubleHashBag().with(1.0, 2.0);
        DoubleHashBag hashBag1 = new DoubleHashBag().with(1.0, 2.0, 3.0);
        DoubleHashBag hashBag2 = new DoubleHashBag().with(1.0).with(2.0).with(3.0).with(4.0);
        DoubleHashBag hashBag3 = new DoubleHashBag().with(1.0).with(2.0).with(3.0).with(4.0).with(5.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), hashBag);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), hashBag0);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), hashBag1);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0), hashBag2);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        DoubleHashBag hashBag = DoubleHashBag.newBagWith(1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0);
        Double sum = hashBag.injectInto(Double.valueOf(4.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(17.0), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleHashBagTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = DoubleHashBagTest::newCollectionWith;
            this.payloads.newCollection = DoubleHashBagTest::newCollection;
            this.payloads.isEmpty = DoubleHashBagTest::isEmpty;
            this.payloads.notEmpty = DoubleHashBagTest::notEmpty;
            this.payloads.tap = DoubleHashBagTest::tap;
            this.payloads.contains_NaN = DoubleHashBagTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = DoubleHashBagTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = DoubleHashBagTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = DoubleHashBagTest::contains_zero;
            this.payloads.testEquals_NaN = DoubleHashBagTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = DoubleHashBagTest::contains_different_NaNs;
            this.payloads.containsAllArray = DoubleHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = DoubleHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = DoubleHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = DoubleHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = DoubleHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = DoubleHashBagTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = DoubleHashBagTest::anySatisfy;
            this.payloads.allSatisfy = DoubleHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleHashBagTest::noneSatisfy;
            this.payloads.collect = DoubleHashBagTest::collect;
            this.payloads.collectWithTarget = DoubleHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = DoubleHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = DoubleHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = DoubleHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = DoubleHashBagTest::collectPrimitivesToSets;
            this.payloads.select = DoubleHashBagTest::select;
            this.payloads.selectWithTarget = DoubleHashBagTest::selectWithTarget;
            this.payloads.reject = DoubleHashBagTest::reject;
            this.payloads.rejectWithTarget = DoubleHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = DoubleHashBagTest::detectIfNone;
            this.payloads.max = DoubleHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = DoubleHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = DoubleHashBagTest::summaryStatistics;
            this.payloads.sumConsistentRounding = DoubleHashBagTest::sumConsistentRounding;
            this.payloads.average = DoubleHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = DoubleHashBagTest::averageIfEmpty;
            this.payloads.median = DoubleHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = DoubleHashBagTest::medianIfEmpty;
            this.payloads.toArray = DoubleHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = DoubleHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = DoubleHashBagTest::toSortedArray;
            this.payloads.testHashCode = DoubleHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = DoubleHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = DoubleHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = DoubleHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = DoubleHashBagTest::toSet;
            this.payloads.toBag = DoubleHashBagTest::toBag;
            this.payloads.asLazy = DoubleHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = DoubleHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = DoubleHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = DoubleHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = DoubleHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = DoubleHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = DoubleHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = DoubleHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = DoubleHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = DoubleHashBagTest::reduce;
            this.payloads.reduceIfEmpty = DoubleHashBagTest::reduceIfEmpty;
            this.payloads.chunk = DoubleHashBagTest::chunk;
            this.payloads.clear = DoubleHashBagTest::clear;
            this.payloads.contains = DoubleHashBagTest::contains;
            this.payloads.addAllArray = DoubleHashBagTest::addAllArray;
            this.payloads.removeIf = DoubleHashBagTest::removeIf;
            this.payloads.removeAll = DoubleHashBagTest::removeAll;
            this.payloads.removeAll_iterable = DoubleHashBagTest::removeAll_iterable;
            this.payloads.retainAll = DoubleHashBagTest::retainAll;
            this.payloads.retainAll_iterable = DoubleHashBagTest::retainAll_iterable;
            this.payloads.withAll = DoubleHashBagTest::withAll;
            this.payloads.without = DoubleHashBagTest::without;
            this.payloads.withoutAll = DoubleHashBagTest::withoutAll;
            this.payloads.asSynchronized = DoubleHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleHashBagTest::asUnmodifiable;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_throws_for_remove_before_next = DoubleHashBagTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = DoubleHashBagTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = DoubleHashBagTest::newEmpty;
            this.payloads.sizeDistinct = DoubleHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = DoubleHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = DoubleHashBagTest::selectDuplicates;
            this.payloads.selectUnique = DoubleHashBagTest::selectUnique;
            this.payloads.topOccurrences = DoubleHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = DoubleHashBagTest::bottomOccurrences;
            this.payloads.addOccurrences = DoubleHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = DoubleHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = DoubleHashBagTest::forEachWithOccurrences;
            this.payloads.add = DoubleHashBagTest::add;
            this.payloads.addAllIterable = DoubleHashBagTest::addAllIterable;
            this.payloads.remove = DoubleHashBagTest::remove;
            this.payloads.doubleIterator = DoubleHashBagTest::doubleIterator;
            this.payloads.doubleIterator_with_remove = DoubleHashBagTest::doubleIterator_with_remove;
            this.payloads.forEach = DoubleHashBagTest::forEach;
            this.payloads.count = DoubleHashBagTest::count;
            this.payloads.sum = DoubleHashBagTest::sum;
            this.payloads.testEquals = DoubleHashBagTest::testEquals;
            this.payloads.testToString = DoubleHashBagTest::testToString;
            this.payloads.makeString = DoubleHashBagTest::makeString;
            this.payloads.appendString = DoubleHashBagTest::appendString;
            this.payloads.toList = DoubleHashBagTest::toList;
            this.payloads.toSortedList = DoubleHashBagTest::toSortedList;
            this.payloads.toImmutable = DoubleHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = DoubleHashBagTest::toStringOfItemToCount;
            this.payloads.size = DoubleHashBagTest::size;
            this.payloads.with = DoubleHashBagTest::with;
            this.payloads.injectInto = DoubleHashBagTest::injectInto;
        }
    }
}
