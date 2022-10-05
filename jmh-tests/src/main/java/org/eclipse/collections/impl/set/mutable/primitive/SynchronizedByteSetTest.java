/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedByteSet}.
 * This file was automatically generated from template file synchronizedPrimitiveSetTest.stg.
 */
public class SynchronizedByteSetTest extends AbstractByteSetTestCase {

    @Override
    protected SynchronizedByteSet classUnderTest() {
        return new SynchronizedByteSet(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected SynchronizedByteSet newWith(byte... elements) {
        return new SynchronizedByteSet(ByteHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedByteSet set = this.classUnderTest();
        MutableByteSet setWithLockObject = new SynchronizedByteSet(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), new Object());
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedByteSetTest instance;

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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> isCartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteSetTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedByteSetTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedByteSetTest::newCollection;
            this.payloads.tap = SynchronizedByteSetTest::tap;
            this.payloads.containsAllArray = SynchronizedByteSetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedByteSetTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedByteSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedByteSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedByteSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedByteSetTest::containsNoneIterable;
            this.payloads.anySatisfy = SynchronizedByteSetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedByteSetTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedByteSetTest::noneSatisfy;
            this.payloads.collectWithTarget = SynchronizedByteSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedByteSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedByteSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedByteSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedByteSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedByteSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedByteSetTest::rejectWithTarget;
            this.payloads.max = SynchronizedByteSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedByteSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedByteSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedByteSetTest::maxIfEmpty;
            this.payloads.sum = SynchronizedByteSetTest::sum;
            this.payloads.summaryStatistics = SynchronizedByteSetTest::summaryStatistics;
            this.payloads.average = SynchronizedByteSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedByteSetTest::averageIfEmpty;
            this.payloads.median = SynchronizedByteSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedByteSetTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedByteSetTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedByteSetTest::toArrayWithTargetArray;
            this.payloads.testToString = SynchronizedByteSetTest::testToString;
            this.payloads.makeString = SynchronizedByteSetTest::makeString;
            this.payloads.appendString = SynchronizedByteSetTest::appendString;
            this.payloads.toList = SynchronizedByteSetTest::toList;
            this.payloads.toSortedList = SynchronizedByteSetTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedByteSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedByteSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedByteSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedByteSetTest::toSet;
            this.payloads.injectInto = SynchronizedByteSetTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedByteSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedByteSetTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedByteSetTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedByteSetTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedByteSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedByteSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedByteSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedByteSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedByteSetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedByteSetTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedByteSetTest::chunk;
            this.payloads.contains = SynchronizedByteSetTest::contains;
            this.payloads.addAllArray = SynchronizedByteSetTest::addAllArray;
            this.payloads.removeIf = SynchronizedByteSetTest::removeIf;
            this.payloads.retainAll = SynchronizedByteSetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedByteSetTest::retainAll_iterable;
            this.payloads.with = SynchronizedByteSetTest::with;
            this.payloads.withAll = SynchronizedByteSetTest::withAll;
            this.payloads.without = SynchronizedByteSetTest::without;
            this.payloads.withoutAll = SynchronizedByteSetTest::withoutAll;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteSetTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = SynchronizedByteSetTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = SynchronizedByteSetTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = SynchronizedByteSetTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedByteSetTest::newEmpty;
            this.payloads.size = SynchronizedByteSetTest::size;
            this.payloads.isEmpty = SynchronizedByteSetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteSetTest::notEmpty;
            this.payloads.clear = SynchronizedByteSetTest::clear;
            this.payloads.add = SynchronizedByteSetTest::add;
            this.payloads.addAllIterable = SynchronizedByteSetTest::addAllIterable;
            this.payloads.remove = SynchronizedByteSetTest::remove;
            this.payloads.removeAll = SynchronizedByteSetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedByteSetTest::removeAll_iterable;
            this.payloads.byteIterator = SynchronizedByteSetTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteSetTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedByteSetTest::forEach;
            this.payloads.count = SynchronizedByteSetTest::count;
            this.payloads.select = SynchronizedByteSetTest::select;
            this.payloads.reject = SynchronizedByteSetTest::reject;
            this.payloads.detectIfNone = SynchronizedByteSetTest::detectIfNone;
            this.payloads.collect = SynchronizedByteSetTest::collect;
            this.payloads.toSortedArray = SynchronizedByteSetTest::toSortedArray;
            this.payloads.testEquals = SynchronizedByteSetTest::testEquals;
            this.payloads.testHashCode = SynchronizedByteSetTest::testHashCode;
            this.payloads.toBag = SynchronizedByteSetTest::toBag;
            this.payloads.asLazy = SynchronizedByteSetTest::asLazy;
            this.payloads.asUnmodifiable = SynchronizedByteSetTest::asUnmodifiable;
            this.payloads.classIsNonInstantiable = SynchronizedByteSetTest::classIsNonInstantiable;
            this.payloads.union = SynchronizedByteSetTest::union;
            this.payloads.intersect = SynchronizedByteSetTest::intersect;
            this.payloads.difference = SynchronizedByteSetTest::difference;
            this.payloads.symmetricDifference = SynchronizedByteSetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedByteSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedByteSetTest::isProperSubsetOf;
            this.payloads.isCartesianProduct = SynchronizedByteSetTest::isCartesianProduct;
            this.payloads.asSynchronized = SynchronizedByteSetTest::asSynchronized;
        }
    }
}
