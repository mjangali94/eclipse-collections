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

import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableLongHashSetTestCase;
import org.junit.Assert;

/**
 * JUnit test for {@link ImmutableLongSet} created from the freeze() method.
 * This file was automatically generated from template file immutablePrimitiveKeySetTest.stg.
 */
public class ImmutableLongMapKeySetTest extends AbstractImmutableLongHashSetTestCase {

    @Override
    protected ImmutableLongSet classUnderTest() {
        return (ImmutableLongSet) LongByteHashMap.newWithKeysValues(1L, (byte) -1, 2L, (byte) 2, 3L, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableLongSet newWith(long... elements) {
        LongByteHashMap longByteHashMap = new LongByteHashMap();
        for (long element : elements) {
            longByteHashMap.put(element, (byte) 0);
        }
        return (ImmutableLongSet) longByteHashMap.keySet().freeze();
    }

    @Override
    public void contains() {
        super.contains();
        long collision1 = AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst();
        long collision2 = AbstractImmutableLongHashSetTestCase.generateCollisions().get(1);
        LongByteHashMap longByteHashMap = LongByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        longByteHashMap.removeKey(collision2);
        LongSet longSet = longByteHashMap.keySet().freeze();
        Assert.assertTrue(longSet.contains(collision1));
        Assert.assertFalse(longSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongMapKeySetTest instance;

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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongMapKeySetTest> cartesianProduct;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableLongMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableLongMapKeySetTest::newCollection;
            this.payloads.tap = ImmutableLongMapKeySetTest::tap;
            this.payloads.contains = ImmutableLongMapKeySetTest::contains;
            this.payloads.containsAllArray = ImmutableLongMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableLongMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableLongMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableLongMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableLongMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableLongMapKeySetTest::containsNoneIterable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongMapKeySetTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableLongMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableLongMapKeySetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableLongMapKeySetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableLongMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableLongMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableLongMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableLongMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableLongMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableLongMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableLongMapKeySetTest::rejectWithTarget;
            this.payloads.max = ImmutableLongMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableLongMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableLongMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableLongMapKeySetTest::maxIfEmpty;
            this.payloads.sum = ImmutableLongMapKeySetTest::sum;
            this.payloads.summaryStatistics = ImmutableLongMapKeySetTest::summaryStatistics;
            this.payloads.average = ImmutableLongMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableLongMapKeySetTest::averageIfEmpty;
            this.payloads.median = ImmutableLongMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableLongMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableLongMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableLongMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableLongMapKeySetTest::testToString;
            this.payloads.makeString = ImmutableLongMapKeySetTest::makeString;
            this.payloads.appendString = ImmutableLongMapKeySetTest::appendString;
            this.payloads.toList = ImmutableLongMapKeySetTest::toList;
            this.payloads.toSortedList = ImmutableLongMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableLongMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableLongMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableLongMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableLongMapKeySetTest::toSet;
            this.payloads.injectInto = ImmutableLongMapKeySetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableLongMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableLongMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableLongMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableLongMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableLongMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableLongMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableLongMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableLongMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableLongMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableLongMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableLongMapKeySetTest::chunk;
            this.payloads.testNewWith = ImmutableLongMapKeySetTest::testNewWith;
            this.payloads.newWithAll = ImmutableLongMapKeySetTest::newWithAll;
            this.payloads.newWithout = ImmutableLongMapKeySetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableLongMapKeySetTest::newWithoutAll;
            this.payloads.size = ImmutableLongMapKeySetTest::size;
            this.payloads.isEmpty = ImmutableLongMapKeySetTest::isEmpty;
            this.payloads.notEmpty = ImmutableLongMapKeySetTest::notEmpty;
            this.payloads.freeze = ImmutableLongMapKeySetTest::freeze;
            this.payloads.toImmutable = ImmutableLongMapKeySetTest::toImmutable;
            this.payloads.longIterator = ImmutableLongMapKeySetTest::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongMapKeySetTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableLongMapKeySetTest::forEach;
            this.payloads.count = ImmutableLongMapKeySetTest::count;
            this.payloads.select = ImmutableLongMapKeySetTest::select;
            this.payloads.reject = ImmutableLongMapKeySetTest::reject;
            this.payloads.detectIfNone = ImmutableLongMapKeySetTest::detectIfNone;
            this.payloads.collect = ImmutableLongMapKeySetTest::collect;
            this.payloads.toSortedArray = ImmutableLongMapKeySetTest::toSortedArray;
            this.payloads.testEquals = ImmutableLongMapKeySetTest::testEquals;
            this.payloads.testHashCode = ImmutableLongMapKeySetTest::testHashCode;
            this.payloads.toBag = ImmutableLongMapKeySetTest::toBag;
            this.payloads.asLazy = ImmutableLongMapKeySetTest::asLazy;
            this.payloads.union = ImmutableLongMapKeySetTest::union;
            this.payloads.intersect = ImmutableLongMapKeySetTest::intersect;
            this.payloads.difference = ImmutableLongMapKeySetTest::difference;
            this.payloads.symmetricDifference = ImmutableLongMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableLongMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableLongMapKeySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableLongMapKeySetTest::cartesianProduct;
        }
    }
}
