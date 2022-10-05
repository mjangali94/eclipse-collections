/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.immutable.primitive;

import org.eclipse.collections.api.collection.primitive.ImmutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractLongIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableLongCollectionTestCase extends AbstractLongIterableTestCase {

    @Override
    protected abstract ImmutableLongCollection classUnderTest();

    @Override
    protected abstract ImmutableLongCollection newWith(long... elements);

    @Override
    protected abstract MutableLongCollection newMutableCollectionWith(long... elements);

    protected void assertSizeAndContains(ImmutableLongCollection collection, long... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (long i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableLongCollection immutableCollection = this.newWith();
        ImmutableLongCollection collection = immutableCollection.newWith(1L);
        ImmutableLongCollection collection0 = immutableCollection.newWith(1L).newWith(2L);
        ImmutableLongCollection collection1 = immutableCollection.newWith(1L).newWith(2L).newWith(3L);
        ImmutableLongCollection collection2 = immutableCollection.newWith(1L).newWith(2L).newWith(3L).newWith(4L);
        ImmutableLongCollection collection3 = immutableCollection.newWith(1L).newWith(2L).newWith(3L).newWith(4L).newWith(5L);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
        this.assertSizeAndContains(collection3, 1L, 2L, 3L, 4L, 5L);
    }

    @Test
    public void newWithAll() {
        ImmutableLongCollection immutableCollection = this.newWith();
        ImmutableLongCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(1L));
        ImmutableLongCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(2L));
        ImmutableLongCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(3L));
        ImmutableLongCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(1L, 2L, 3L, 4L));
        ImmutableLongCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
        this.assertSizeAndContains(collection3, 1L, 2L, 3L, 4L, 5L);
    }

    @Test
    public void newWithout() {
        ImmutableLongCollection collection3 = this.newWith(1L, 2L, 3L, 4L, 5L);
        ImmutableLongCollection collection2 = collection3.newWithout(5L);
        ImmutableLongCollection collection1 = collection2.newWithout(4L);
        ImmutableLongCollection collection0 = collection1.newWithout(3L);
        ImmutableLongCollection collection4 = collection0.newWithout(2L);
        ImmutableLongCollection collection5 = collection4.newWithout(1L);
        ImmutableLongCollection collection6 = collection5.newWithout(0L);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
    }

    @Test
    public void newWithoutAll() {
        ImmutableLongCollection collection3 = this.newWith(1L, 2L, 3L, 4L, 5L);
        ImmutableLongCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(5L));
        ImmutableLongCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(4L));
        ImmutableLongCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(3L));
        ImmutableLongCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(2L));
        ImmutableLongCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith(1L));
        ImmutableLongCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith(0L));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1L);
        this.assertSizeAndContains(collection0, 1L, 2L);
        this.assertSizeAndContains(collection1, 1L, 2L, 3L);
        this.assertSizeAndContains(collection2, 1L, 2L, 3L, 4L);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableLongCollectionTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableLongCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongCollectionTestCase> newWithoutAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableLongCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableLongCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableLongCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableLongCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableLongCollectionTestCase::tap;
            this.payloads.contains = AbstractImmutableLongCollectionTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableLongCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableLongCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableLongCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableLongCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableLongCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableLongCollectionTestCase::containsNoneIterable;
            this.payloads.longIterator = AbstractImmutableLongCollectionTestCase::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongCollectionTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongCollectionTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableLongCollectionTestCase::forEach;
            this.payloads.size = AbstractImmutableLongCollectionTestCase::size;
            this.payloads.count = AbstractImmutableLongCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableLongCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableLongCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableLongCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableLongCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableLongCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableLongCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableLongCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableLongCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableLongCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableLongCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableLongCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableLongCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableLongCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractImmutableLongCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractImmutableLongCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableLongCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableLongCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableLongCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableLongCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableLongCollectionTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableLongCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableLongCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableLongCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableLongCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableLongCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableLongCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableLongCollectionTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableLongCollectionTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableLongCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableLongCollectionTestCase::testToString;
            this.payloads.makeString = AbstractImmutableLongCollectionTestCase::makeString;
            this.payloads.appendString = AbstractImmutableLongCollectionTestCase::appendString;
            this.payloads.toList = AbstractImmutableLongCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableLongCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableLongCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableLongCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableLongCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableLongCollectionTestCase::toSet;
            this.payloads.toBag = AbstractImmutableLongCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableLongCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractImmutableLongCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableLongCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableLongCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableLongCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableLongCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableLongCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableLongCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableLongCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableLongCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableLongCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableLongCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableLongCollectionTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableLongCollectionTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableLongCollectionTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableLongCollectionTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableLongCollectionTestCase::newWithoutAll;
        }
    }
}
