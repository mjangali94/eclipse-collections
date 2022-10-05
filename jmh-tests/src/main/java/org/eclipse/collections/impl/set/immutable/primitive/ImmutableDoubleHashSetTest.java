/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable.primitive;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableDoubleHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;

/**
 * JUnit test for {@link ImmutableDoubleHashSet}.
 * This file was automatically generated from template file immutablePrimitiveHashSetTest.stg.
 */
public class ImmutableDoubleHashSetTest extends AbstractImmutableDoubleHashSetTestCase {

    @Override
    protected ImmutableDoubleSet classUnderTest() {
        return DoubleHashSet.newSetWith(1.0, 2.0, 3.0).toImmutable();
    }

    @Override
    protected ImmutableDoubleSet newWith(double... elements) {
        return DoubleHashSet.newSetWith(elements).toImmutable();
    }

    @Override
    protected MutableDoubleSet newMutableCollectionWith(double... elements) {
        return DoubleHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Double> newObjectCollectionWith(Double... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubleHashSetTest instance;

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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubleHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashSetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableDoubleHashSetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableDoubleHashSetTest::newCollection;
            this.payloads.tap = ImmutableDoubleHashSetTest::tap;
            this.payloads.contains = ImmutableDoubleHashSetTest::contains;
            this.payloads.contains_NaN = ImmutableDoubleHashSetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ImmutableDoubleHashSetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ImmutableDoubleHashSetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ImmutableDoubleHashSetTest::contains_zero;
            this.payloads.testEquals_NaN = ImmutableDoubleHashSetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = ImmutableDoubleHashSetTest::contains_different_NaNs;
            this.payloads.containsAllArray = ImmutableDoubleHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableDoubleHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableDoubleHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableDoubleHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableDoubleHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableDoubleHashSetTest::containsNoneIterable;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashSetTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableDoubleHashSetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableDoubleHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableDoubleHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableDoubleHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableDoubleHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableDoubleHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableDoubleHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableDoubleHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableDoubleHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableDoubleHashSetTest::rejectWithTarget;
            this.payloads.max = ImmutableDoubleHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableDoubleHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableDoubleHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableDoubleHashSetTest::maxIfEmpty;
            this.payloads.sum = ImmutableDoubleHashSetTest::sum;
            this.payloads.summaryStatistics = ImmutableDoubleHashSetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ImmutableDoubleHashSetTest::sumConsistentRounding;
            this.payloads.average = ImmutableDoubleHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableDoubleHashSetTest::averageIfEmpty;
            this.payloads.median = ImmutableDoubleHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableDoubleHashSetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableDoubleHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableDoubleHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableDoubleHashSetTest::testToString;
            this.payloads.makeString = ImmutableDoubleHashSetTest::makeString;
            this.payloads.appendString = ImmutableDoubleHashSetTest::appendString;
            this.payloads.toList = ImmutableDoubleHashSetTest::toList;
            this.payloads.toSortedList = ImmutableDoubleHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableDoubleHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableDoubleHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableDoubleHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableDoubleHashSetTest::toSet;
            this.payloads.injectInto = ImmutableDoubleHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableDoubleHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableDoubleHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableDoubleHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableDoubleHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableDoubleHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableDoubleHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableDoubleHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableDoubleHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableDoubleHashSetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableDoubleHashSetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableDoubleHashSetTest::chunk;
            this.payloads.testNewWith = ImmutableDoubleHashSetTest::testNewWith;
            this.payloads.newWithAll = ImmutableDoubleHashSetTest::newWithAll;
            this.payloads.newWithout = ImmutableDoubleHashSetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableDoubleHashSetTest::newWithoutAll;
            this.payloads.size = ImmutableDoubleHashSetTest::size;
            this.payloads.isEmpty = ImmutableDoubleHashSetTest::isEmpty;
            this.payloads.notEmpty = ImmutableDoubleHashSetTest::notEmpty;
            this.payloads.freeze = ImmutableDoubleHashSetTest::freeze;
            this.payloads.toImmutable = ImmutableDoubleHashSetTest::toImmutable;
            this.payloads.doubleIterator = ImmutableDoubleHashSetTest::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashSetTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableDoubleHashSetTest::forEach;
            this.payloads.count = ImmutableDoubleHashSetTest::count;
            this.payloads.select = ImmutableDoubleHashSetTest::select;
            this.payloads.reject = ImmutableDoubleHashSetTest::reject;
            this.payloads.detectIfNone = ImmutableDoubleHashSetTest::detectIfNone;
            this.payloads.collect = ImmutableDoubleHashSetTest::collect;
            this.payloads.toSortedArray = ImmutableDoubleHashSetTest::toSortedArray;
            this.payloads.testEquals = ImmutableDoubleHashSetTest::testEquals;
            this.payloads.testHashCode = ImmutableDoubleHashSetTest::testHashCode;
            this.payloads.toBag = ImmutableDoubleHashSetTest::toBag;
            this.payloads.asLazy = ImmutableDoubleHashSetTest::asLazy;
            this.payloads.union = ImmutableDoubleHashSetTest::union;
            this.payloads.intersect = ImmutableDoubleHashSetTest::intersect;
            this.payloads.difference = ImmutableDoubleHashSetTest::difference;
            this.payloads.symmetricDifference = ImmutableDoubleHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableDoubleHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableDoubleHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableDoubleHashSetTest::cartesianProduct;
        }
    }
}
