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

import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class FloatHashBagTest extends AbstractMutableFloatBagTestCase {

    @Override
    protected final FloatHashBag classUnderTest() {
        return FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    protected FloatHashBag newWith(float... elements) {
        return FloatHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new FloatHashBag(3));
        Verify.assertSize(0, FloatHashBag.newBag(3));
        Verify.assertSize(3, FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f));
        Verify.assertSize(3, new FloatHashBag(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f)));
        Verify.assertSize(3, FloatHashBag.newBag(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f)));
        Verify.assertSize(3, FloatHashBag.newBag(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
        Verify.assertSize(3, new FloatHashBag(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        FloatHashBag hashBag = new FloatHashBag().with(1.0f);
        FloatHashBag hashBag0 = new FloatHashBag().with(1.0f, 2.0f);
        FloatHashBag hashBag1 = new FloatHashBag().with(1.0f, 2.0f, 3.0f);
        FloatHashBag hashBag2 = new FloatHashBag().with(1.0f).with(2.0f).with(3.0f).with(4.0f);
        FloatHashBag hashBag3 = new FloatHashBag().with(1.0f).with(2.0f).with(3.0f).with(4.0f).with(5.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), hashBag);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), hashBag0);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), hashBag1);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f), hashBag2);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), hashBag3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        FloatHashBag hashBag = FloatHashBag.newBagWith(1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 3.0f);
        Float sum = hashBag.injectInto(Float.valueOf(4.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(17.0f), sum);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatHashBagTest instance;

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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new FloatHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FloatHashBagTest::newCollectionWith;
            this.payloads.newCollection = FloatHashBagTest::newCollection;
            this.payloads.isEmpty = FloatHashBagTest::isEmpty;
            this.payloads.notEmpty = FloatHashBagTest::notEmpty;
            this.payloads.tap = FloatHashBagTest::tap;
            this.payloads.contains_NaN = FloatHashBagTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = FloatHashBagTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = FloatHashBagTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = FloatHashBagTest::contains_zero;
            this.payloads.testEquals_NaN = FloatHashBagTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = FloatHashBagTest::contains_different_NaNs;
            this.payloads.containsAllArray = FloatHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = FloatHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = FloatHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = FloatHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = FloatHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = FloatHashBagTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = FloatHashBagTest::anySatisfy;
            this.payloads.allSatisfy = FloatHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = FloatHashBagTest::noneSatisfy;
            this.payloads.collect = FloatHashBagTest::collect;
            this.payloads.collectWithTarget = FloatHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FloatHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FloatHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FloatHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FloatHashBagTest::collectPrimitivesToSets;
            this.payloads.select = FloatHashBagTest::select;
            this.payloads.selectWithTarget = FloatHashBagTest::selectWithTarget;
            this.payloads.reject = FloatHashBagTest::reject;
            this.payloads.rejectWithTarget = FloatHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = FloatHashBagTest::detectIfNone;
            this.payloads.max = FloatHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FloatHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = FloatHashBagTest::summaryStatistics;
            this.payloads.sumConsistentRounding = FloatHashBagTest::sumConsistentRounding;
            this.payloads.average = FloatHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FloatHashBagTest::averageIfEmpty;
            this.payloads.median = FloatHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FloatHashBagTest::medianIfEmpty;
            this.payloads.toArray = FloatHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = FloatHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = FloatHashBagTest::toSortedArray;
            this.payloads.testHashCode = FloatHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = FloatHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FloatHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FloatHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FloatHashBagTest::toSet;
            this.payloads.toBag = FloatHashBagTest::toBag;
            this.payloads.asLazy = FloatHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = FloatHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FloatHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = FloatHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = FloatHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = FloatHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = FloatHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = FloatHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = FloatHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FloatHashBagTest::reduce;
            this.payloads.reduceIfEmpty = FloatHashBagTest::reduceIfEmpty;
            this.payloads.chunk = FloatHashBagTest::chunk;
            this.payloads.clear = FloatHashBagTest::clear;
            this.payloads.contains = FloatHashBagTest::contains;
            this.payloads.addAllArray = FloatHashBagTest::addAllArray;
            this.payloads.removeIf = FloatHashBagTest::removeIf;
            this.payloads.removeAll = FloatHashBagTest::removeAll;
            this.payloads.removeAll_iterable = FloatHashBagTest::removeAll_iterable;
            this.payloads.retainAll = FloatHashBagTest::retainAll;
            this.payloads.retainAll_iterable = FloatHashBagTest::retainAll_iterable;
            this.payloads.withAll = FloatHashBagTest::withAll;
            this.payloads.without = FloatHashBagTest::without;
            this.payloads.withoutAll = FloatHashBagTest::withoutAll;
            this.payloads.asSynchronized = FloatHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatHashBagTest::asUnmodifiable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_for_remove_before_next = FloatHashBagTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = FloatHashBagTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = FloatHashBagTest::newEmpty;
            this.payloads.sizeDistinct = FloatHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = FloatHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = FloatHashBagTest::selectDuplicates;
            this.payloads.selectUnique = FloatHashBagTest::selectUnique;
            this.payloads.topOccurrences = FloatHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = FloatHashBagTest::bottomOccurrences;
            this.payloads.addOccurrences = FloatHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = FloatHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = FloatHashBagTest::forEachWithOccurrences;
            this.payloads.add = FloatHashBagTest::add;
            this.payloads.addAllIterable = FloatHashBagTest::addAllIterable;
            this.payloads.remove = FloatHashBagTest::remove;
            this.payloads.floatIterator = FloatHashBagTest::floatIterator;
            this.payloads.floatIterator_with_remove = FloatHashBagTest::floatIterator_with_remove;
            this.payloads.forEach = FloatHashBagTest::forEach;
            this.payloads.count = FloatHashBagTest::count;
            this.payloads.sum = FloatHashBagTest::sum;
            this.payloads.testEquals = FloatHashBagTest::testEquals;
            this.payloads.testToString = FloatHashBagTest::testToString;
            this.payloads.makeString = FloatHashBagTest::makeString;
            this.payloads.appendString = FloatHashBagTest::appendString;
            this.payloads.toList = FloatHashBagTest::toList;
            this.payloads.toSortedList = FloatHashBagTest::toSortedList;
            this.payloads.toImmutable = FloatHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = FloatHashBagTest::toStringOfItemToCount;
            this.payloads.size = FloatHashBagTest::size;
            this.payloads.with = FloatHashBagTest::with;
            this.payloads.injectInto = FloatHashBagTest::injectInto;
        }
    }
}
