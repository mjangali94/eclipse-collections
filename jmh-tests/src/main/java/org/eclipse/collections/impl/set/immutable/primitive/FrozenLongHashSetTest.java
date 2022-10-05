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
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableLongHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;

/**
 * JUnit test for {@link ImmutableLongSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenLongHashSetTest extends AbstractImmutableLongHashSetTestCase {

    @Override
    protected ImmutableLongSet classUnderTest() {
        return (ImmutableLongSet) LongHashSet.newSetWith(1L, 2L, 3L).freeze();
    }

    @Override
    protected ImmutableLongSet newWith(long... elements) {
        return (ImmutableLongSet) LongHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableLongSet newMutableCollectionWith(long... elements) {
        return LongHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Long> newObjectCollectionWith(Long... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FrozenLongHashSetTest instance;

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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new FrozenLongHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenLongHashSetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FrozenLongHashSetTest::newCollectionWith;
            this.payloads.newCollection = FrozenLongHashSetTest::newCollection;
            this.payloads.tap = FrozenLongHashSetTest::tap;
            this.payloads.contains = FrozenLongHashSetTest::contains;
            this.payloads.containsAllArray = FrozenLongHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = FrozenLongHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = FrozenLongHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = FrozenLongHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = FrozenLongHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = FrozenLongHashSetTest::containsNoneIterable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenLongHashSetTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = FrozenLongHashSetTest::anySatisfy;
            this.payloads.allSatisfy = FrozenLongHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = FrozenLongHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = FrozenLongHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FrozenLongHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FrozenLongHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FrozenLongHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FrozenLongHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = FrozenLongHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = FrozenLongHashSetTest::rejectWithTarget;
            this.payloads.max = FrozenLongHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenLongHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FrozenLongHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenLongHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FrozenLongHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = FrozenLongHashSetTest::maxIfEmpty;
            this.payloads.sum = FrozenLongHashSetTest::sum;
            this.payloads.summaryStatistics = FrozenLongHashSetTest::summaryStatistics;
            this.payloads.average = FrozenLongHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenLongHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FrozenLongHashSetTest::averageIfEmpty;
            this.payloads.median = FrozenLongHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenLongHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FrozenLongHashSetTest::medianIfEmpty;
            this.payloads.toArray = FrozenLongHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = FrozenLongHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = FrozenLongHashSetTest::testToString;
            this.payloads.makeString = FrozenLongHashSetTest::makeString;
            this.payloads.appendString = FrozenLongHashSetTest::appendString;
            this.payloads.toList = FrozenLongHashSetTest::toList;
            this.payloads.toSortedList = FrozenLongHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = FrozenLongHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FrozenLongHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FrozenLongHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FrozenLongHashSetTest::toSet;
            this.payloads.injectInto = FrozenLongHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = FrozenLongHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FrozenLongHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = FrozenLongHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = FrozenLongHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = FrozenLongHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = FrozenLongHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = FrozenLongHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = FrozenLongHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenLongHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FrozenLongHashSetTest::reduce;
            this.payloads.reduceIfEmpty = FrozenLongHashSetTest::reduceIfEmpty;
            this.payloads.chunk = FrozenLongHashSetTest::chunk;
            this.payloads.testNewWith = FrozenLongHashSetTest::testNewWith;
            this.payloads.newWithAll = FrozenLongHashSetTest::newWithAll;
            this.payloads.newWithout = FrozenLongHashSetTest::newWithout;
            this.payloads.newWithoutAll = FrozenLongHashSetTest::newWithoutAll;
            this.payloads.size = FrozenLongHashSetTest::size;
            this.payloads.isEmpty = FrozenLongHashSetTest::isEmpty;
            this.payloads.notEmpty = FrozenLongHashSetTest::notEmpty;
            this.payloads.freeze = FrozenLongHashSetTest::freeze;
            this.payloads.toImmutable = FrozenLongHashSetTest::toImmutable;
            this.payloads.longIterator = FrozenLongHashSetTest::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenLongHashSetTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FrozenLongHashSetTest::forEach;
            this.payloads.count = FrozenLongHashSetTest::count;
            this.payloads.select = FrozenLongHashSetTest::select;
            this.payloads.reject = FrozenLongHashSetTest::reject;
            this.payloads.detectIfNone = FrozenLongHashSetTest::detectIfNone;
            this.payloads.collect = FrozenLongHashSetTest::collect;
            this.payloads.toSortedArray = FrozenLongHashSetTest::toSortedArray;
            this.payloads.testEquals = FrozenLongHashSetTest::testEquals;
            this.payloads.testHashCode = FrozenLongHashSetTest::testHashCode;
            this.payloads.toBag = FrozenLongHashSetTest::toBag;
            this.payloads.asLazy = FrozenLongHashSetTest::asLazy;
            this.payloads.union = FrozenLongHashSetTest::union;
            this.payloads.intersect = FrozenLongHashSetTest::intersect;
            this.payloads.difference = FrozenLongHashSetTest::difference;
            this.payloads.symmetricDifference = FrozenLongHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = FrozenLongHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = FrozenLongHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = FrozenLongHashSetTest::cartesianProduct;
        }
    }
}
