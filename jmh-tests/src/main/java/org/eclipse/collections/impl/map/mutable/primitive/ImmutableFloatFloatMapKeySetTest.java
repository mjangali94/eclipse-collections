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

import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableFloatHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableFloatSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class ImmutableFloatFloatMapKeySetTest extends AbstractImmutableFloatHashSetTestCase {

    @Override
    protected ImmutableFloatSet classUnderTest() {
        return (ImmutableFloatSet) FloatFloatHashMap.newWithKeysValues(1.0f, -1.0f, 2.0f, 2.0f, 3.0f, 4.0f).keySet().freeze();
    }

    @Override
    protected ImmutableFloatSet newWith(float... elements) {
        FloatFloatHashMap floatFloatHashMap = new FloatFloatHashMap();
        for (float element : elements) {
            floatFloatHashMap.put(element, element);
        }
        return (ImmutableFloatSet) floatFloatHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        float collision1 = AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst();
        float collision2 = AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1);
        FloatFloatHashMap floatFloatHashMap = FloatFloatHashMap.newWithKeysValues(collision1, collision1, collision2, collision2);
        floatFloatHashMap.removeKey(collision2);
        FloatSet floatSet = floatFloatHashMap.keySet().freeze();
        Assert.assertTrue(floatSet.contains(collision1));
        Assert.assertFalse(floatSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableFloatFloatMapKeySetTest instance;

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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableFloatFloatMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatFloatMapKeySetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableFloatFloatMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableFloatFloatMapKeySetTest::newCollection;
            this.payloads.tap = ImmutableFloatFloatMapKeySetTest::tap;
            this.payloads.contains = ImmutableFloatFloatMapKeySetTest::contains;
            this.payloads.contains_NaN = ImmutableFloatFloatMapKeySetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ImmutableFloatFloatMapKeySetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ImmutableFloatFloatMapKeySetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ImmutableFloatFloatMapKeySetTest::contains_zero;
            this.payloads.testEquals_NaN = ImmutableFloatFloatMapKeySetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = ImmutableFloatFloatMapKeySetTest::contains_different_NaNs;
            this.payloads.containsAllArray = ImmutableFloatFloatMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableFloatFloatMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableFloatFloatMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableFloatFloatMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableFloatFloatMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableFloatFloatMapKeySetTest::containsNoneIterable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatFloatMapKeySetTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableFloatFloatMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableFloatFloatMapKeySetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableFloatFloatMapKeySetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableFloatFloatMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableFloatFloatMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableFloatFloatMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableFloatFloatMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableFloatFloatMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableFloatFloatMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableFloatFloatMapKeySetTest::rejectWithTarget;
            this.payloads.max = ImmutableFloatFloatMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatFloatMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableFloatFloatMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatFloatMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableFloatFloatMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableFloatFloatMapKeySetTest::maxIfEmpty;
            this.payloads.sum = ImmutableFloatFloatMapKeySetTest::sum;
            this.payloads.summaryStatistics = ImmutableFloatFloatMapKeySetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ImmutableFloatFloatMapKeySetTest::sumConsistentRounding;
            this.payloads.average = ImmutableFloatFloatMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatFloatMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableFloatFloatMapKeySetTest::averageIfEmpty;
            this.payloads.median = ImmutableFloatFloatMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatFloatMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableFloatFloatMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableFloatFloatMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableFloatFloatMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableFloatFloatMapKeySetTest::testToString;
            this.payloads.makeString = ImmutableFloatFloatMapKeySetTest::makeString;
            this.payloads.appendString = ImmutableFloatFloatMapKeySetTest::appendString;
            this.payloads.toList = ImmutableFloatFloatMapKeySetTest::toList;
            this.payloads.toSortedList = ImmutableFloatFloatMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableFloatFloatMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableFloatFloatMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableFloatFloatMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableFloatFloatMapKeySetTest::toSet;
            this.payloads.injectInto = ImmutableFloatFloatMapKeySetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableFloatFloatMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableFloatFloatMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableFloatFloatMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableFloatFloatMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableFloatFloatMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableFloatFloatMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableFloatFloatMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableFloatFloatMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatFloatMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableFloatFloatMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableFloatFloatMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableFloatFloatMapKeySetTest::chunk;
            this.payloads.testNewWith = ImmutableFloatFloatMapKeySetTest::testNewWith;
            this.payloads.newWithAll = ImmutableFloatFloatMapKeySetTest::newWithAll;
            this.payloads.newWithout = ImmutableFloatFloatMapKeySetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableFloatFloatMapKeySetTest::newWithoutAll;
            this.payloads.size = ImmutableFloatFloatMapKeySetTest::size;
            this.payloads.isEmpty = ImmutableFloatFloatMapKeySetTest::isEmpty;
            this.payloads.notEmpty = ImmutableFloatFloatMapKeySetTest::notEmpty;
            this.payloads.freeze = ImmutableFloatFloatMapKeySetTest::freeze;
            this.payloads.toImmutable = ImmutableFloatFloatMapKeySetTest::toImmutable;
            this.payloads.floatIterator = ImmutableFloatFloatMapKeySetTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatFloatMapKeySetTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableFloatFloatMapKeySetTest::forEach;
            this.payloads.count = ImmutableFloatFloatMapKeySetTest::count;
            this.payloads.select = ImmutableFloatFloatMapKeySetTest::select;
            this.payloads.reject = ImmutableFloatFloatMapKeySetTest::reject;
            this.payloads.detectIfNone = ImmutableFloatFloatMapKeySetTest::detectIfNone;
            this.payloads.collect = ImmutableFloatFloatMapKeySetTest::collect;
            this.payloads.toSortedArray = ImmutableFloatFloatMapKeySetTest::toSortedArray;
            this.payloads.testEquals = ImmutableFloatFloatMapKeySetTest::testEquals;
            this.payloads.testHashCode = ImmutableFloatFloatMapKeySetTest::testHashCode;
            this.payloads.toBag = ImmutableFloatFloatMapKeySetTest::toBag;
            this.payloads.asLazy = ImmutableFloatFloatMapKeySetTest::asLazy;
            this.payloads.union = ImmutableFloatFloatMapKeySetTest::union;
            this.payloads.intersect = ImmutableFloatFloatMapKeySetTest::intersect;
            this.payloads.difference = ImmutableFloatFloatMapKeySetTest::difference;
            this.payloads.symmetricDifference = ImmutableFloatFloatMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableFloatFloatMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableFloatFloatMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableFloatFloatMapKeySetTest::cartesianProduct;
        }
    }
}
