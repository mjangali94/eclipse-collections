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
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableByteHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;

/**
 * JUnit test for {@link ImmutableByteSet} created from the freeze() method.
 * This file was automatically generated from template file frozenPrimitiveSetTest.stg.
 */
public class FrozenByteHashSetTest extends AbstractImmutableByteHashSetTestCase {

    @Override
    protected ImmutableByteSet classUnderTest() {
        return (ImmutableByteSet) ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3).freeze();
    }

    @Override
    protected ImmutableByteSet newWith(byte... elements) {
        return (ImmutableByteSet) ByteHashSet.newSetWith(elements).freeze();
    }

    @Override
    protected MutableByteSet newMutableCollectionWith(byte... elements) {
        return ByteHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Byte> newObjectCollectionWith(Byte... elements) {
        return UnifiedSet.newSetWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FrozenByteHashSetTest instance;

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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_isCartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isCartesianProduct);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new FrozenByteHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FrozenByteHashSetTest> isCartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FrozenByteHashSetTest::newCollectionWith;
            this.payloads.newCollection = FrozenByteHashSetTest::newCollection;
            this.payloads.tap = FrozenByteHashSetTest::tap;
            this.payloads.contains = FrozenByteHashSetTest::contains;
            this.payloads.containsAllArray = FrozenByteHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = FrozenByteHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = FrozenByteHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = FrozenByteHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = FrozenByteHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = FrozenByteHashSetTest::containsNoneIterable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenByteHashSetTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = FrozenByteHashSetTest::anySatisfy;
            this.payloads.allSatisfy = FrozenByteHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = FrozenByteHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = FrozenByteHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FrozenByteHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FrozenByteHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FrozenByteHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FrozenByteHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = FrozenByteHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = FrozenByteHashSetTest::rejectWithTarget;
            this.payloads.max = FrozenByteHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenByteHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FrozenByteHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenByteHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FrozenByteHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = FrozenByteHashSetTest::maxIfEmpty;
            this.payloads.sum = FrozenByteHashSetTest::sum;
            this.payloads.summaryStatistics = FrozenByteHashSetTest::summaryStatistics;
            this.payloads.average = FrozenByteHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenByteHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FrozenByteHashSetTest::averageIfEmpty;
            this.payloads.median = FrozenByteHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenByteHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FrozenByteHashSetTest::medianIfEmpty;
            this.payloads.toArray = FrozenByteHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = FrozenByteHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = FrozenByteHashSetTest::testToString;
            this.payloads.makeString = FrozenByteHashSetTest::makeString;
            this.payloads.appendString = FrozenByteHashSetTest::appendString;
            this.payloads.toList = FrozenByteHashSetTest::toList;
            this.payloads.toSortedList = FrozenByteHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = FrozenByteHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FrozenByteHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FrozenByteHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FrozenByteHashSetTest::toSet;
            this.payloads.injectInto = FrozenByteHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = FrozenByteHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FrozenByteHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = FrozenByteHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = FrozenByteHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = FrozenByteHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = FrozenByteHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = FrozenByteHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = FrozenByteHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenByteHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FrozenByteHashSetTest::reduce;
            this.payloads.reduceIfEmpty = FrozenByteHashSetTest::reduceIfEmpty;
            this.payloads.chunk = FrozenByteHashSetTest::chunk;
            this.payloads.testNewWith = FrozenByteHashSetTest::testNewWith;
            this.payloads.newWithAll = FrozenByteHashSetTest::newWithAll;
            this.payloads.newWithout = FrozenByteHashSetTest::newWithout;
            this.payloads.newWithoutAll = FrozenByteHashSetTest::newWithoutAll;
            this.payloads.size = FrozenByteHashSetTest::size;
            this.payloads.isEmpty = FrozenByteHashSetTest::isEmpty;
            this.payloads.notEmpty = FrozenByteHashSetTest::notEmpty;
            this.payloads.byteIterator = FrozenByteHashSetTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FrozenByteHashSetTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FrozenByteHashSetTest::forEach;
            this.payloads.count = FrozenByteHashSetTest::count;
            this.payloads.select = FrozenByteHashSetTest::select;
            this.payloads.reject = FrozenByteHashSetTest::reject;
            this.payloads.detectIfNone = FrozenByteHashSetTest::detectIfNone;
            this.payloads.collect = FrozenByteHashSetTest::collect;
            this.payloads.toSortedArray = FrozenByteHashSetTest::toSortedArray;
            this.payloads.testEquals = FrozenByteHashSetTest::testEquals;
            this.payloads.testHashCode = FrozenByteHashSetTest::testHashCode;
            this.payloads.toBag = FrozenByteHashSetTest::toBag;
            this.payloads.asLazy = FrozenByteHashSetTest::asLazy;
            this.payloads.toImmutable = FrozenByteHashSetTest::toImmutable;
            this.payloads.union = FrozenByteHashSetTest::union;
            this.payloads.intersect = FrozenByteHashSetTest::intersect;
            this.payloads.difference = FrozenByteHashSetTest::difference;
            this.payloads.symmetricDifference = FrozenByteHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = FrozenByteHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = FrozenByteHashSetTest::isProperSubsetOf;
            this.payloads.isCartesianProduct = FrozenByteHashSetTest::isCartesianProduct;
        }
    }
}
