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
 * JUnit test for {@link ImmutableIntSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenIntHashSetTest extends AbstractImmutableIntHashSetTestCase {

    @Override
    protected ImmutableIntSet classUnderTest() {
        return (ImmutableIntSet) IntHashSet.newSetWith(1, 2, 3).freeze();
    }

    @Override
    protected ImmutableIntSet newWith(int... elements) {
        return (ImmutableIntSet) IntHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableIntSet newMutableCollectionWith(int... elements) {
        return IntHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Integer> newObjectCollectionWith(Integer... elements) {
        return UnifiedSet.newSetWith(elements);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FrozenIntHashSetTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new FrozenIntHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenIntHashSetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FrozenIntHashSetTest::newCollectionWith;
            this.payloads.newCollection = FrozenIntHashSetTest::newCollection;
            this.payloads.tap = FrozenIntHashSetTest::tap;
            this.payloads.contains = FrozenIntHashSetTest::contains;
            this.payloads.containsAllArray = FrozenIntHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = FrozenIntHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = FrozenIntHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = FrozenIntHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = FrozenIntHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = FrozenIntHashSetTest::containsNoneIterable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenIntHashSetTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = FrozenIntHashSetTest::anySatisfy;
            this.payloads.allSatisfy = FrozenIntHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = FrozenIntHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = FrozenIntHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FrozenIntHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FrozenIntHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FrozenIntHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FrozenIntHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = FrozenIntHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = FrozenIntHashSetTest::rejectWithTarget;
            this.payloads.max = FrozenIntHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenIntHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FrozenIntHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenIntHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FrozenIntHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = FrozenIntHashSetTest::maxIfEmpty;
            this.payloads.sum = FrozenIntHashSetTest::sum;
            this.payloads.summaryStatistics = FrozenIntHashSetTest::summaryStatistics;
            this.payloads.average = FrozenIntHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenIntHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FrozenIntHashSetTest::averageIfEmpty;
            this.payloads.median = FrozenIntHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenIntHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FrozenIntHashSetTest::medianIfEmpty;
            this.payloads.toArray = FrozenIntHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = FrozenIntHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = FrozenIntHashSetTest::testToString;
            this.payloads.makeString = FrozenIntHashSetTest::makeString;
            this.payloads.appendString = FrozenIntHashSetTest::appendString;
            this.payloads.toList = FrozenIntHashSetTest::toList;
            this.payloads.toSortedList = FrozenIntHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = FrozenIntHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FrozenIntHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FrozenIntHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FrozenIntHashSetTest::toSet;
            this.payloads.injectInto = FrozenIntHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = FrozenIntHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FrozenIntHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = FrozenIntHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = FrozenIntHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = FrozenIntHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = FrozenIntHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = FrozenIntHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = FrozenIntHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenIntHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FrozenIntHashSetTest::reduce;
            this.payloads.reduceIfEmpty = FrozenIntHashSetTest::reduceIfEmpty;
            this.payloads.chunk = FrozenIntHashSetTest::chunk;
            this.payloads.testNewWith = FrozenIntHashSetTest::testNewWith;
            this.payloads.newWithAll = FrozenIntHashSetTest::newWithAll;
            this.payloads.newWithout = FrozenIntHashSetTest::newWithout;
            this.payloads.newWithoutAll = FrozenIntHashSetTest::newWithoutAll;
            this.payloads.size = FrozenIntHashSetTest::size;
            this.payloads.isEmpty = FrozenIntHashSetTest::isEmpty;
            this.payloads.notEmpty = FrozenIntHashSetTest::notEmpty;
            this.payloads.freeze = FrozenIntHashSetTest::freeze;
            this.payloads.toImmutable = FrozenIntHashSetTest::toImmutable;
            this.payloads.intIterator = FrozenIntHashSetTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenIntHashSetTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FrozenIntHashSetTest::forEach;
            this.payloads.count = FrozenIntHashSetTest::count;
            this.payloads.select = FrozenIntHashSetTest::select;
            this.payloads.reject = FrozenIntHashSetTest::reject;
            this.payloads.detectIfNone = FrozenIntHashSetTest::detectIfNone;
            this.payloads.collect = FrozenIntHashSetTest::collect;
            this.payloads.toSortedArray = FrozenIntHashSetTest::toSortedArray;
            this.payloads.testEquals = FrozenIntHashSetTest::testEquals;
            this.payloads.testHashCode = FrozenIntHashSetTest::testHashCode;
            this.payloads.toBag = FrozenIntHashSetTest::toBag;
            this.payloads.asLazy = FrozenIntHashSetTest::asLazy;
            this.payloads.union = FrozenIntHashSetTest::union;
            this.payloads.intersect = FrozenIntHashSetTest::intersect;
            this.payloads.difference = FrozenIntHashSetTest::difference;
            this.payloads.symmetricDifference = FrozenIntHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = FrozenIntHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = FrozenIntHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = FrozenIntHashSetTest::cartesianProduct;
        }
    }
*/
}
