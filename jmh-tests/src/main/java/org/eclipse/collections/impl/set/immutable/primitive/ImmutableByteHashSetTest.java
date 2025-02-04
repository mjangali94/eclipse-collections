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
 * JUnit test for {@link ImmutableByteHashSet}.
 * This file was automatically generated from template file immutablePrimitiveHashSetTest.stg.
 */
public class ImmutableByteHashSetTest extends AbstractImmutableByteHashSetTestCase {

    @Override
    protected ImmutableByteSet classUnderTest() {
        return ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3).toImmutable();
    }

    @Override
    protected ImmutableByteSet newWith(byte... elements) {
        return ByteHashSet.newSetWith(elements).toImmutable();
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

        private ImmutableByteHashSetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteHashSetTest> isCartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableByteHashSetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableByteHashSetTest::newCollection;
            this.payloads.tap = ImmutableByteHashSetTest::tap;
            this.payloads.contains = ImmutableByteHashSetTest::contains;
            this.payloads.containsAllArray = ImmutableByteHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableByteHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableByteHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableByteHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableByteHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableByteHashSetTest::containsNoneIterable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteHashSetTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableByteHashSetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableByteHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableByteHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableByteHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableByteHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableByteHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableByteHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableByteHashSetTest::rejectWithTarget;
            this.payloads.max = ImmutableByteHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableByteHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableByteHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteHashSetTest::maxIfEmpty;
            this.payloads.sum = ImmutableByteHashSetTest::sum;
            this.payloads.summaryStatistics = ImmutableByteHashSetTest::summaryStatistics;
            this.payloads.average = ImmutableByteHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableByteHashSetTest::averageIfEmpty;
            this.payloads.median = ImmutableByteHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableByteHashSetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableByteHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableByteHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableByteHashSetTest::testToString;
            this.payloads.makeString = ImmutableByteHashSetTest::makeString;
            this.payloads.appendString = ImmutableByteHashSetTest::appendString;
            this.payloads.toList = ImmutableByteHashSetTest::toList;
            this.payloads.toSortedList = ImmutableByteHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableByteHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableByteHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableByteHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableByteHashSetTest::toSet;
            this.payloads.injectInto = ImmutableByteHashSetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableByteHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableByteHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableByteHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableByteHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableByteHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableByteHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableByteHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableByteHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableByteHashSetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableByteHashSetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableByteHashSetTest::chunk;
            this.payloads.testNewWith = ImmutableByteHashSetTest::testNewWith;
            this.payloads.newWithAll = ImmutableByteHashSetTest::newWithAll;
            this.payloads.newWithout = ImmutableByteHashSetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableByteHashSetTest::newWithoutAll;
            this.payloads.size = ImmutableByteHashSetTest::size;
            this.payloads.isEmpty = ImmutableByteHashSetTest::isEmpty;
            this.payloads.notEmpty = ImmutableByteHashSetTest::notEmpty;
            this.payloads.byteIterator = ImmutableByteHashSetTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteHashSetTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableByteHashSetTest::forEach;
            this.payloads.count = ImmutableByteHashSetTest::count;
            this.payloads.select = ImmutableByteHashSetTest::select;
            this.payloads.reject = ImmutableByteHashSetTest::reject;
            this.payloads.detectIfNone = ImmutableByteHashSetTest::detectIfNone;
            this.payloads.collect = ImmutableByteHashSetTest::collect;
            this.payloads.toSortedArray = ImmutableByteHashSetTest::toSortedArray;
            this.payloads.testEquals = ImmutableByteHashSetTest::testEquals;
            this.payloads.testHashCode = ImmutableByteHashSetTest::testHashCode;
            this.payloads.toBag = ImmutableByteHashSetTest::toBag;
            this.payloads.asLazy = ImmutableByteHashSetTest::asLazy;
            this.payloads.toImmutable = ImmutableByteHashSetTest::toImmutable;
            this.payloads.union = ImmutableByteHashSetTest::union;
            this.payloads.intersect = ImmutableByteHashSetTest::intersect;
            this.payloads.difference = ImmutableByteHashSetTest::difference;
            this.payloads.symmetricDifference = ImmutableByteHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableByteHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableByteHashSetTest::isProperSubsetOf;
            this.payloads.isCartesianProduct = ImmutableByteHashSetTest::isCartesianProduct;
        }
    }
}
