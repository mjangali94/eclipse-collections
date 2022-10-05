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
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableShortHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;

/**
 * JUnit test for {@link ImmutableShortSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenShortHashSetTest extends AbstractImmutableShortHashSetTestCase {

    @Override
    protected ImmutableShortSet classUnderTest() {
        return (ImmutableShortSet) ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3).freeze();
    }

    @Override
    protected ImmutableShortSet newWith(short... elements) {
        return (ImmutableShortSet) ShortHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableShortSet newMutableCollectionWith(short... elements) {
        return ShortHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Short> newObjectCollectionWith(Short... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FrozenShortHashSetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new FrozenShortHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenShortHashSetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FrozenShortHashSetTest::newCollectionWith;
            this.payloads.newCollection = FrozenShortHashSetTest::newCollection;
            this.payloads.tap = FrozenShortHashSetTest::tap;
            this.payloads.contains = FrozenShortHashSetTest::contains;
            this.payloads.containsAllArray = FrozenShortHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = FrozenShortHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = FrozenShortHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = FrozenShortHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = FrozenShortHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = FrozenShortHashSetTest::containsNoneIterable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenShortHashSetTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = FrozenShortHashSetTest::anySatisfy;
            this.payloads.allSatisfy = FrozenShortHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = FrozenShortHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = FrozenShortHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FrozenShortHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FrozenShortHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FrozenShortHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FrozenShortHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = FrozenShortHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = FrozenShortHashSetTest::rejectWithTarget;
            this.payloads.max = FrozenShortHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenShortHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FrozenShortHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenShortHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FrozenShortHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = FrozenShortHashSetTest::maxIfEmpty;
            this.payloads.sum = FrozenShortHashSetTest::sum;
            this.payloads.summaryStatistics = FrozenShortHashSetTest::summaryStatistics;
            this.payloads.average = FrozenShortHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenShortHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FrozenShortHashSetTest::averageIfEmpty;
            this.payloads.median = FrozenShortHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenShortHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FrozenShortHashSetTest::medianIfEmpty;
            this.payloads.toArray = FrozenShortHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = FrozenShortHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = FrozenShortHashSetTest::testToString;
            this.payloads.makeString = FrozenShortHashSetTest::makeString;
            this.payloads.appendString = FrozenShortHashSetTest::appendString;
            this.payloads.toList = FrozenShortHashSetTest::toList;
            this.payloads.toSortedList = FrozenShortHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = FrozenShortHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FrozenShortHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FrozenShortHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FrozenShortHashSetTest::toSet;
            this.payloads.injectInto = FrozenShortHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = FrozenShortHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FrozenShortHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = FrozenShortHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = FrozenShortHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = FrozenShortHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = FrozenShortHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = FrozenShortHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = FrozenShortHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenShortHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FrozenShortHashSetTest::reduce;
            this.payloads.reduceIfEmpty = FrozenShortHashSetTest::reduceIfEmpty;
            this.payloads.chunk = FrozenShortHashSetTest::chunk;
            this.payloads.testNewWith = FrozenShortHashSetTest::testNewWith;
            this.payloads.newWithAll = FrozenShortHashSetTest::newWithAll;
            this.payloads.newWithout = FrozenShortHashSetTest::newWithout;
            this.payloads.newWithoutAll = FrozenShortHashSetTest::newWithoutAll;
            this.payloads.size = FrozenShortHashSetTest::size;
            this.payloads.isEmpty = FrozenShortHashSetTest::isEmpty;
            this.payloads.notEmpty = FrozenShortHashSetTest::notEmpty;
            this.payloads.freeze = FrozenShortHashSetTest::freeze;
            this.payloads.toImmutable = FrozenShortHashSetTest::toImmutable;
            this.payloads.shortIterator = FrozenShortHashSetTest::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenShortHashSetTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FrozenShortHashSetTest::forEach;
            this.payloads.count = FrozenShortHashSetTest::count;
            this.payloads.select = FrozenShortHashSetTest::select;
            this.payloads.reject = FrozenShortHashSetTest::reject;
            this.payloads.detectIfNone = FrozenShortHashSetTest::detectIfNone;
            this.payloads.collect = FrozenShortHashSetTest::collect;
            this.payloads.toSortedArray = FrozenShortHashSetTest::toSortedArray;
            this.payloads.testEquals = FrozenShortHashSetTest::testEquals;
            this.payloads.testHashCode = FrozenShortHashSetTest::testHashCode;
            this.payloads.toBag = FrozenShortHashSetTest::toBag;
            this.payloads.asLazy = FrozenShortHashSetTest::asLazy;
            this.payloads.union = FrozenShortHashSetTest::union;
            this.payloads.intersect = FrozenShortHashSetTest::intersect;
            this.payloads.difference = FrozenShortHashSetTest::difference;
            this.payloads.symmetricDifference = FrozenShortHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = FrozenShortHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = FrozenShortHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = FrozenShortHashSetTest::cartesianProduct;
        }
    }
}
