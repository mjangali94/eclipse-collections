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

import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableIntHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableIntSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitiveKeySetTest.stg.
 */
public class ImmutableIntMapKeySetTest extends AbstractImmutableIntHashSetTestCase {

    @Override
    protected ImmutableIntSet classUnderTest() {
        return (ImmutableIntSet) IntByteHashMap.newWithKeysValues(1, (byte) -1, 2, (byte) 2, 3, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableIntSet newWith(int... elements) {
        IntByteHashMap intByteHashMap = new IntByteHashMap();
        for (int element : elements) {
            intByteHashMap.put(element, (byte) 0);
        }
        return (ImmutableIntSet) intByteHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        int collision1 = AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst();
        int collision2 = AbstractImmutableIntHashSetTestCase.generateCollisions().get(1);
        IntByteHashMap intByteHashMap = IntByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        intByteHashMap.removeKey(collision2);
        IntSet intSet = intByteHashMap.keySet().freeze();
        Assert.assertTrue(intSet.contains(collision1));
        Assert.assertFalse(intSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableIntMapKeySetTest instance;

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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableIntMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntMapKeySetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableIntMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableIntMapKeySetTest::newCollection;
            this.payloads.tap = ImmutableIntMapKeySetTest::tap;
            this.payloads.contains = ImmutableIntMapKeySetTest::contains;
            this.payloads.containsAllArray = ImmutableIntMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableIntMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableIntMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableIntMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableIntMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableIntMapKeySetTest::containsNoneIterable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntMapKeySetTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableIntMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableIntMapKeySetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableIntMapKeySetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableIntMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableIntMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableIntMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableIntMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableIntMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableIntMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableIntMapKeySetTest::rejectWithTarget;
            this.payloads.max = ImmutableIntMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableIntMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableIntMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableIntMapKeySetTest::maxIfEmpty;
            this.payloads.sum = ImmutableIntMapKeySetTest::sum;
            this.payloads.summaryStatistics = ImmutableIntMapKeySetTest::summaryStatistics;
            this.payloads.average = ImmutableIntMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableIntMapKeySetTest::averageIfEmpty;
            this.payloads.median = ImmutableIntMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableIntMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableIntMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableIntMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableIntMapKeySetTest::testToString;
            this.payloads.makeString = ImmutableIntMapKeySetTest::makeString;
            this.payloads.appendString = ImmutableIntMapKeySetTest::appendString;
            this.payloads.toList = ImmutableIntMapKeySetTest::toList;
            this.payloads.toSortedList = ImmutableIntMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableIntMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableIntMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableIntMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableIntMapKeySetTest::toSet;
            this.payloads.injectInto = ImmutableIntMapKeySetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableIntMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableIntMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableIntMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableIntMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableIntMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableIntMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableIntMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableIntMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableIntMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableIntMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableIntMapKeySetTest::chunk;
            this.payloads.testNewWith = ImmutableIntMapKeySetTest::testNewWith;
            this.payloads.newWithAll = ImmutableIntMapKeySetTest::newWithAll;
            this.payloads.newWithout = ImmutableIntMapKeySetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableIntMapKeySetTest::newWithoutAll;
            this.payloads.size = ImmutableIntMapKeySetTest::size;
            this.payloads.isEmpty = ImmutableIntMapKeySetTest::isEmpty;
            this.payloads.notEmpty = ImmutableIntMapKeySetTest::notEmpty;
            this.payloads.freeze = ImmutableIntMapKeySetTest::freeze;
            this.payloads.toImmutable = ImmutableIntMapKeySetTest::toImmutable;
            this.payloads.intIterator = ImmutableIntMapKeySetTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntMapKeySetTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableIntMapKeySetTest::forEach;
            this.payloads.count = ImmutableIntMapKeySetTest::count;
            this.payloads.select = ImmutableIntMapKeySetTest::select;
            this.payloads.reject = ImmutableIntMapKeySetTest::reject;
            this.payloads.detectIfNone = ImmutableIntMapKeySetTest::detectIfNone;
            this.payloads.collect = ImmutableIntMapKeySetTest::collect;
            this.payloads.toSortedArray = ImmutableIntMapKeySetTest::toSortedArray;
            this.payloads.testEquals = ImmutableIntMapKeySetTest::testEquals;
            this.payloads.testHashCode = ImmutableIntMapKeySetTest::testHashCode;
            this.payloads.toBag = ImmutableIntMapKeySetTest::toBag;
            this.payloads.asLazy = ImmutableIntMapKeySetTest::asLazy;
            this.payloads.union = ImmutableIntMapKeySetTest::union;
            this.payloads.intersect = ImmutableIntMapKeySetTest::intersect;
            this.payloads.difference = ImmutableIntMapKeySetTest::difference;
            this.payloads.symmetricDifference = ImmutableIntMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableIntMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableIntMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableIntMapKeySetTest::cartesianProduct;
        }
    }
}
