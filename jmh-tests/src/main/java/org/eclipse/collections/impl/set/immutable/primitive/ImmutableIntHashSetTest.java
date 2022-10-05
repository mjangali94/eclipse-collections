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
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableIntHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;

/**
 * JUnit test for {@link ImmutableIntHashSet}.
 * This file was automatically generated from template file immutablePrimitiveHashSetTest.stg.
 */
public class ImmutableIntHashSetTest extends AbstractImmutableIntHashSetTestCase {

    @Override
    protected ImmutableIntSet classUnderTest() {
        return IntHashSet.newSetWith(1, 2, 3).toImmutable();
    }

    @Override
    protected ImmutableIntSet newWith(int... elements) {
        return IntHashSet.newSetWith(elements).toImmutable();
    }

    @Override
    protected MutableIntSet newMutableCollectionWith(int... elements) {
        return IntHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Integer> newObjectCollectionWith(Integer... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableIntHashSetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableIntHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntHashSetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableIntHashSetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableIntHashSetTest::newCollection;
            this.payloads.tap = ImmutableIntHashSetTest::tap;
            this.payloads.contains = ImmutableIntHashSetTest::contains;
            this.payloads.containsAllArray = ImmutableIntHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableIntHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableIntHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableIntHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableIntHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableIntHashSetTest::containsNoneIterable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntHashSetTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableIntHashSetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableIntHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableIntHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableIntHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableIntHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableIntHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableIntHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableIntHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableIntHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableIntHashSetTest::rejectWithTarget;
            this.payloads.max = ImmutableIntHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableIntHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableIntHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableIntHashSetTest::maxIfEmpty;
            this.payloads.sum = ImmutableIntHashSetTest::sum;
            this.payloads.summaryStatistics = ImmutableIntHashSetTest::summaryStatistics;
            this.payloads.average = ImmutableIntHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableIntHashSetTest::averageIfEmpty;
            this.payloads.median = ImmutableIntHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableIntHashSetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableIntHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableIntHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableIntHashSetTest::testToString;
            this.payloads.makeString = ImmutableIntHashSetTest::makeString;
            this.payloads.appendString = ImmutableIntHashSetTest::appendString;
            this.payloads.toList = ImmutableIntHashSetTest::toList;
            this.payloads.toSortedList = ImmutableIntHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableIntHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableIntHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableIntHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableIntHashSetTest::toSet;
            this.payloads.injectInto = ImmutableIntHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableIntHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableIntHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableIntHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableIntHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableIntHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableIntHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableIntHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableIntHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableIntHashSetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableIntHashSetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableIntHashSetTest::chunk;
            this.payloads.testNewWith = ImmutableIntHashSetTest::testNewWith;
            this.payloads.newWithAll = ImmutableIntHashSetTest::newWithAll;
            this.payloads.newWithout = ImmutableIntHashSetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableIntHashSetTest::newWithoutAll;
            this.payloads.size = ImmutableIntHashSetTest::size;
            this.payloads.isEmpty = ImmutableIntHashSetTest::isEmpty;
            this.payloads.notEmpty = ImmutableIntHashSetTest::notEmpty;
            this.payloads.freeze = ImmutableIntHashSetTest::freeze;
            this.payloads.toImmutable = ImmutableIntHashSetTest::toImmutable;
            this.payloads.intIterator = ImmutableIntHashSetTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntHashSetTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableIntHashSetTest::forEach;
            this.payloads.count = ImmutableIntHashSetTest::count;
            this.payloads.select = ImmutableIntHashSetTest::select;
            this.payloads.reject = ImmutableIntHashSetTest::reject;
            this.payloads.detectIfNone = ImmutableIntHashSetTest::detectIfNone;
            this.payloads.collect = ImmutableIntHashSetTest::collect;
            this.payloads.toSortedArray = ImmutableIntHashSetTest::toSortedArray;
            this.payloads.testEquals = ImmutableIntHashSetTest::testEquals;
            this.payloads.testHashCode = ImmutableIntHashSetTest::testHashCode;
            this.payloads.toBag = ImmutableIntHashSetTest::toBag;
            this.payloads.asLazy = ImmutableIntHashSetTest::asLazy;
            this.payloads.union = ImmutableIntHashSetTest::union;
            this.payloads.intersect = ImmutableIntHashSetTest::intersect;
            this.payloads.difference = ImmutableIntHashSetTest::difference;
            this.payloads.symmetricDifference = ImmutableIntHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableIntHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableIntHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableIntHashSetTest::cartesianProduct;
        }
    }
}
