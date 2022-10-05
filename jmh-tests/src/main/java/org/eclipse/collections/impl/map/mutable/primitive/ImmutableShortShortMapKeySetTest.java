/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableShortHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableShortSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class ImmutableShortShortMapKeySetTest extends AbstractImmutableShortHashSetTestCase {

    @Override
    protected ImmutableShortSet classUnderTest() {
        return (ImmutableShortSet) ShortShortHashMap.newWithKeysValues((short) 1, (short) -1, (short) 2, (short) 2, (short) 3, (short) 4).keySet().freeze();
    }

    @Override
    protected ImmutableShortSet newWith(short... elements) {
        ShortShortHashMap shortShortHashMap = new ShortShortHashMap();
        for (short element : elements) {
            shortShortHashMap.put(element, element);
        }
        return (ImmutableShortSet) shortShortHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        short collision1 = AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst();
        short collision2 = AbstractImmutableShortHashSetTestCase.generateCollisions().get(1);
        ShortShortHashMap shortShortHashMap = ShortShortHashMap.newWithKeysValues(collision1, collision1, collision2, collision2);
        shortShortHashMap.removeKey(collision2);
        ShortSet shortSet = shortShortHashMap.keySet().freeze();
        Assert.assertTrue(shortSet.contains(collision1));
        Assert.assertFalse(shortSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableShortShortMapKeySetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
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
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
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
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableShortShortMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortShortMapKeySetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableShortShortMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableShortShortMapKeySetTest::newCollection;
            this.payloads.tap = ImmutableShortShortMapKeySetTest::tap;
            this.payloads.contains = ImmutableShortShortMapKeySetTest::contains;
            this.payloads.containsAllArray = ImmutableShortShortMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableShortShortMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableShortShortMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableShortShortMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableShortShortMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableShortShortMapKeySetTest::containsNoneIterable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortShortMapKeySetTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableShortShortMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableShortShortMapKeySetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableShortShortMapKeySetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableShortShortMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableShortShortMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableShortShortMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableShortShortMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableShortShortMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableShortShortMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableShortShortMapKeySetTest::rejectWithTarget;
            this.payloads.max = ImmutableShortShortMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortShortMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableShortShortMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortShortMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableShortShortMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableShortShortMapKeySetTest::maxIfEmpty;
            this.payloads.sum = ImmutableShortShortMapKeySetTest::sum;
            this.payloads.summaryStatistics = ImmutableShortShortMapKeySetTest::summaryStatistics;
            this.payloads.average = ImmutableShortShortMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortShortMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableShortShortMapKeySetTest::averageIfEmpty;
            this.payloads.median = ImmutableShortShortMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortShortMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableShortShortMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableShortShortMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableShortShortMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableShortShortMapKeySetTest::testToString;
            this.payloads.makeString = ImmutableShortShortMapKeySetTest::makeString;
            this.payloads.appendString = ImmutableShortShortMapKeySetTest::appendString;
            this.payloads.toList = ImmutableShortShortMapKeySetTest::toList;
            this.payloads.toSortedList = ImmutableShortShortMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableShortShortMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableShortShortMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableShortShortMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableShortShortMapKeySetTest::toSet;
            this.payloads.injectInto = ImmutableShortShortMapKeySetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableShortShortMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableShortShortMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableShortShortMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableShortShortMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableShortShortMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableShortShortMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableShortShortMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableShortShortMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortShortMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableShortShortMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableShortShortMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableShortShortMapKeySetTest::chunk;
            this.payloads.testNewWith = ImmutableShortShortMapKeySetTest::testNewWith;
            this.payloads.newWithAll = ImmutableShortShortMapKeySetTest::newWithAll;
            this.payloads.newWithout = ImmutableShortShortMapKeySetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableShortShortMapKeySetTest::newWithoutAll;
            this.payloads.size = ImmutableShortShortMapKeySetTest::size;
            this.payloads.isEmpty = ImmutableShortShortMapKeySetTest::isEmpty;
            this.payloads.notEmpty = ImmutableShortShortMapKeySetTest::notEmpty;
            this.payloads.freeze = ImmutableShortShortMapKeySetTest::freeze;
            this.payloads.toImmutable = ImmutableShortShortMapKeySetTest::toImmutable;
            this.payloads.shortIterator = ImmutableShortShortMapKeySetTest::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortShortMapKeySetTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableShortShortMapKeySetTest::forEach;
            this.payloads.count = ImmutableShortShortMapKeySetTest::count;
            this.payloads.select = ImmutableShortShortMapKeySetTest::select;
            this.payloads.reject = ImmutableShortShortMapKeySetTest::reject;
            this.payloads.detectIfNone = ImmutableShortShortMapKeySetTest::detectIfNone;
            this.payloads.collect = ImmutableShortShortMapKeySetTest::collect;
            this.payloads.toSortedArray = ImmutableShortShortMapKeySetTest::toSortedArray;
            this.payloads.testEquals = ImmutableShortShortMapKeySetTest::testEquals;
            this.payloads.testHashCode = ImmutableShortShortMapKeySetTest::testHashCode;
            this.payloads.toBag = ImmutableShortShortMapKeySetTest::toBag;
            this.payloads.asLazy = ImmutableShortShortMapKeySetTest::asLazy;
            this.payloads.union = ImmutableShortShortMapKeySetTest::union;
            this.payloads.intersect = ImmutableShortShortMapKeySetTest::intersect;
            this.payloads.difference = ImmutableShortShortMapKeySetTest::difference;
            this.payloads.symmetricDifference = ImmutableShortShortMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableShortShortMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableShortShortMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableShortShortMapKeySetTest::cartesianProduct;
        }
    }
}
