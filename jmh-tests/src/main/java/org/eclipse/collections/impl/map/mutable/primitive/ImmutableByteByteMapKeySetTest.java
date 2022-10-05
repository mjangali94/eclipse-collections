/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableByteHashSetTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteSet} created from the freeze() method.
 */
public class ImmutableByteByteMapKeySetTest extends AbstractImmutableByteHashSetTestCase {

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ImmutableByteByteMapKeySet set = (ImmutableByteByteMapKeySet) new ByteByteHashMap().keySet().freeze();
        for (byte i = 2; collisions.size() <= 10; i++) {
            if (set.spreadAndMask(i) == set.spreadAndMask((byte) 2)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected ImmutableByteSet classUnderTest() {
        return (ImmutableByteSet) ByteByteHashMap.newWithKeysValues((byte) 1, (byte) -1, (byte) 2, (byte) 2, (byte) 3, (byte) 4).keySet().freeze();
    }

    @Override
    protected ImmutableByteSet newWith(byte... elements) {
        ByteByteHashMap byteByteHashMap = new ByteByteHashMap();
        for (byte element : elements) {
            byteByteHashMap.put(element, element);
        }
        return (ImmutableByteSet) byteByteHashMap.keySet().freeze();
    }

    @Test
    @Override
    public void contains() {
        super.contains();
        byte collision1 = ImmutableByteByteMapKeySetTest.generateCollisions().getFirst();
        byte collision2 = ImmutableByteByteMapKeySetTest.generateCollisions().get(1);
        ByteByteHashMap byteByteHashMap = ByteByteHashMap.newWithKeysValues(collision1, (byte) 0, collision2, (byte) 0);
        byteByteHashMap.removeKey(collision2);
        ByteSet byteSet = byteByteHashMap.keySet().freeze();
        Assert.assertTrue(byteSet.contains(collision1));
        Assert.assertFalse(byteSet.contains(collision2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteByteMapKeySetTest instance;

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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_isCartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isCartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteByteMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> isCartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteByteMapKeySetTest> contains;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableByteByteMapKeySetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableByteByteMapKeySetTest::newCollection;
            this.payloads.tap = ImmutableByteByteMapKeySetTest::tap;
            this.payloads.containsAllArray = ImmutableByteByteMapKeySetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableByteByteMapKeySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableByteByteMapKeySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableByteByteMapKeySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableByteByteMapKeySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableByteByteMapKeySetTest::containsNoneIterable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteByteMapKeySetTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableByteByteMapKeySetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteByteMapKeySetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteByteMapKeySetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableByteByteMapKeySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableByteByteMapKeySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableByteByteMapKeySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableByteByteMapKeySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableByteByteMapKeySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableByteByteMapKeySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableByteByteMapKeySetTest::rejectWithTarget;
            this.payloads.max = ImmutableByteByteMapKeySetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteByteMapKeySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableByteByteMapKeySetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteByteMapKeySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableByteByteMapKeySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteByteMapKeySetTest::maxIfEmpty;
            this.payloads.sum = ImmutableByteByteMapKeySetTest::sum;
            this.payloads.summaryStatistics = ImmutableByteByteMapKeySetTest::summaryStatistics;
            this.payloads.average = ImmutableByteByteMapKeySetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteByteMapKeySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableByteByteMapKeySetTest::averageIfEmpty;
            this.payloads.median = ImmutableByteByteMapKeySetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteByteMapKeySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableByteByteMapKeySetTest::medianIfEmpty;
            this.payloads.toArray = ImmutableByteByteMapKeySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableByteByteMapKeySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableByteByteMapKeySetTest::testToString;
            this.payloads.makeString = ImmutableByteByteMapKeySetTest::makeString;
            this.payloads.appendString = ImmutableByteByteMapKeySetTest::appendString;
            this.payloads.toList = ImmutableByteByteMapKeySetTest::toList;
            this.payloads.toSortedList = ImmutableByteByteMapKeySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableByteByteMapKeySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableByteByteMapKeySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableByteByteMapKeySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableByteByteMapKeySetTest::toSet;
            this.payloads.injectInto = ImmutableByteByteMapKeySetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableByteByteMapKeySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableByteByteMapKeySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableByteByteMapKeySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableByteByteMapKeySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableByteByteMapKeySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableByteByteMapKeySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableByteByteMapKeySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableByteByteMapKeySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteByteMapKeySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableByteByteMapKeySetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableByteByteMapKeySetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableByteByteMapKeySetTest::chunk;
            this.payloads.testNewWith = ImmutableByteByteMapKeySetTest::testNewWith;
            this.payloads.newWithAll = ImmutableByteByteMapKeySetTest::newWithAll;
            this.payloads.newWithout = ImmutableByteByteMapKeySetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableByteByteMapKeySetTest::newWithoutAll;
            this.payloads.size = ImmutableByteByteMapKeySetTest::size;
            this.payloads.isEmpty = ImmutableByteByteMapKeySetTest::isEmpty;
            this.payloads.notEmpty = ImmutableByteByteMapKeySetTest::notEmpty;
            this.payloads.byteIterator = ImmutableByteByteMapKeySetTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteByteMapKeySetTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableByteByteMapKeySetTest::forEach;
            this.payloads.count = ImmutableByteByteMapKeySetTest::count;
            this.payloads.select = ImmutableByteByteMapKeySetTest::select;
            this.payloads.reject = ImmutableByteByteMapKeySetTest::reject;
            this.payloads.detectIfNone = ImmutableByteByteMapKeySetTest::detectIfNone;
            this.payloads.collect = ImmutableByteByteMapKeySetTest::collect;
            this.payloads.toSortedArray = ImmutableByteByteMapKeySetTest::toSortedArray;
            this.payloads.testEquals = ImmutableByteByteMapKeySetTest::testEquals;
            this.payloads.testHashCode = ImmutableByteByteMapKeySetTest::testHashCode;
            this.payloads.toBag = ImmutableByteByteMapKeySetTest::toBag;
            this.payloads.asLazy = ImmutableByteByteMapKeySetTest::asLazy;
            this.payloads.toImmutable = ImmutableByteByteMapKeySetTest::toImmutable;
            this.payloads.union = ImmutableByteByteMapKeySetTest::union;
            this.payloads.intersect = ImmutableByteByteMapKeySetTest::intersect;
            this.payloads.difference = ImmutableByteByteMapKeySetTest::difference;
            this.payloads.symmetricDifference = ImmutableByteByteMapKeySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableByteByteMapKeySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableByteByteMapKeySetTest::isProperSubsetOf;
            this.payloads.isCartesianProduct = ImmutableByteByteMapKeySetTest::isCartesianProduct;
            this.payloads.contains = ImmutableByteByteMapKeySetTest::contains;
        }
    }
}
