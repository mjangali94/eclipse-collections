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
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableCharHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;

/**
 * JUnit test for {@link ImmutableCharSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenCharHashSetTest extends AbstractImmutableCharHashSetTestCase {

    @Override
    protected ImmutableCharSet classUnderTest() {
        return (ImmutableCharSet) CharHashSet.newSetWith((char) 1, (char) 2, (char) 3).freeze();
    }

    @Override
    protected ImmutableCharSet newWith(char... elements) {
        return (ImmutableCharSet) CharHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableCharSet newMutableCollectionWith(char... elements) {
        return CharHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Character> newObjectCollectionWith(Character... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FrozenCharHashSetTest instance;

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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new FrozenCharHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenCharHashSetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FrozenCharHashSetTest::newCollectionWith;
            this.payloads.newCollection = FrozenCharHashSetTest::newCollection;
            this.payloads.tap = FrozenCharHashSetTest::tap;
            this.payloads.contains = FrozenCharHashSetTest::contains;
            this.payloads.containsAllArray = FrozenCharHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = FrozenCharHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = FrozenCharHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = FrozenCharHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = FrozenCharHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = FrozenCharHashSetTest::containsNoneIterable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenCharHashSetTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = FrozenCharHashSetTest::anySatisfy;
            this.payloads.allSatisfy = FrozenCharHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = FrozenCharHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = FrozenCharHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FrozenCharHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FrozenCharHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FrozenCharHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FrozenCharHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = FrozenCharHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = FrozenCharHashSetTest::rejectWithTarget;
            this.payloads.max = FrozenCharHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenCharHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FrozenCharHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenCharHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FrozenCharHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = FrozenCharHashSetTest::maxIfEmpty;
            this.payloads.sum = FrozenCharHashSetTest::sum;
            this.payloads.summaryStatistics = FrozenCharHashSetTest::summaryStatistics;
            this.payloads.average = FrozenCharHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenCharHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FrozenCharHashSetTest::averageIfEmpty;
            this.payloads.median = FrozenCharHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenCharHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FrozenCharHashSetTest::medianIfEmpty;
            this.payloads.toArray = FrozenCharHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = FrozenCharHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = FrozenCharHashSetTest::testToString;
            this.payloads.makeString = FrozenCharHashSetTest::makeString;
            this.payloads.appendString = FrozenCharHashSetTest::appendString;
            this.payloads.toList = FrozenCharHashSetTest::toList;
            this.payloads.toSortedList = FrozenCharHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = FrozenCharHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FrozenCharHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FrozenCharHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FrozenCharHashSetTest::toSet;
            this.payloads.injectInto = FrozenCharHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = FrozenCharHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FrozenCharHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = FrozenCharHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = FrozenCharHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = FrozenCharHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = FrozenCharHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = FrozenCharHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = FrozenCharHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenCharHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FrozenCharHashSetTest::reduce;
            this.payloads.reduceIfEmpty = FrozenCharHashSetTest::reduceIfEmpty;
            this.payloads.chunk = FrozenCharHashSetTest::chunk;
            this.payloads.testNewWith = FrozenCharHashSetTest::testNewWith;
            this.payloads.newWithAll = FrozenCharHashSetTest::newWithAll;
            this.payloads.newWithout = FrozenCharHashSetTest::newWithout;
            this.payloads.newWithoutAll = FrozenCharHashSetTest::newWithoutAll;
            this.payloads.size = FrozenCharHashSetTest::size;
            this.payloads.isEmpty = FrozenCharHashSetTest::isEmpty;
            this.payloads.notEmpty = FrozenCharHashSetTest::notEmpty;
            this.payloads.freeze = FrozenCharHashSetTest::freeze;
            this.payloads.toImmutable = FrozenCharHashSetTest::toImmutable;
            this.payloads.charIterator = FrozenCharHashSetTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenCharHashSetTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FrozenCharHashSetTest::forEach;
            this.payloads.count = FrozenCharHashSetTest::count;
            this.payloads.select = FrozenCharHashSetTest::select;
            this.payloads.reject = FrozenCharHashSetTest::reject;
            this.payloads.detectIfNone = FrozenCharHashSetTest::detectIfNone;
            this.payloads.collect = FrozenCharHashSetTest::collect;
            this.payloads.toSortedArray = FrozenCharHashSetTest::toSortedArray;
            this.payloads.testEquals = FrozenCharHashSetTest::testEquals;
            this.payloads.testHashCode = FrozenCharHashSetTest::testHashCode;
            this.payloads.toBag = FrozenCharHashSetTest::toBag;
            this.payloads.asLazy = FrozenCharHashSetTest::asLazy;
            this.payloads.union = FrozenCharHashSetTest::union;
            this.payloads.intersect = FrozenCharHashSetTest::intersect;
            this.payloads.difference = FrozenCharHashSetTest::difference;
            this.payloads.symmetricDifference = FrozenCharHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = FrozenCharHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = FrozenCharHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = FrozenCharHashSetTest::cartesianProduct;
        }
    }
}
