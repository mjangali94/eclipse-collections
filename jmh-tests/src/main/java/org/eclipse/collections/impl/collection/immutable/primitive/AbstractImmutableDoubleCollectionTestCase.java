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

import org.eclipse.collections.api.collection.primitive.ImmutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractDoubleIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableDoubleCollectionTestCase extends AbstractDoubleIterableTestCase {

    @Override
    protected abstract ImmutableDoubleCollection classUnderTest();

    @Override
    protected abstract ImmutableDoubleCollection newWith(double... elements);

    @Override
    protected abstract MutableDoubleCollection newMutableCollectionWith(double... elements);

    protected void assertSizeAndContains(ImmutableDoubleCollection collection, double... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (double i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableDoubleCollection immutableCollection = this.newWith();
        ImmutableDoubleCollection collection = immutableCollection.newWith(1.0);
        ImmutableDoubleCollection collection0 = immutableCollection.newWith(1.0).newWith(2.0);
        ImmutableDoubleCollection collection1 = immutableCollection.newWith(1.0).newWith(2.0).newWith(3.0);
        ImmutableDoubleCollection collection2 = immutableCollection.newWith(1.0).newWith(2.0).newWith(3.0).newWith(4.0);
        ImmutableDoubleCollection collection3 = immutableCollection.newWith(1.0).newWith(2.0).newWith(3.0).newWith(4.0).newWith(5.0);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
        this.assertSizeAndContains(collection3, 1.0, 2.0, 3.0, 4.0, 5.0);
    }

    @Test
    public void newWithAll() {
        ImmutableDoubleCollection immutableCollection = this.newWith();
        ImmutableDoubleCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0));
        ImmutableDoubleCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(2.0));
        ImmutableDoubleCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(3.0));
        ImmutableDoubleCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0));
        ImmutableDoubleCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
        this.assertSizeAndContains(collection3, 1.0, 2.0, 3.0, 4.0, 5.0);
    }

    @Test
    public void newWithout() {
        ImmutableDoubleCollection collection3 = this.newWith(1.0, 2.0, 3.0, 4.0, 5.0);
        ImmutableDoubleCollection collection2 = collection3.newWithout(5.0);
        ImmutableDoubleCollection collection1 = collection2.newWithout(4.0);
        ImmutableDoubleCollection collection0 = collection1.newWithout(3.0);
        ImmutableDoubleCollection collection4 = collection0.newWithout(2.0);
        ImmutableDoubleCollection collection5 = collection4.newWithout(1.0);
        ImmutableDoubleCollection collection6 = collection5.newWithout(0.0);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
    }

    @Test
    public void newWithoutAll() {
        ImmutableDoubleCollection collection3 = this.newWith(1.0, 2.0, 3.0, 4.0, 5.0);
        ImmutableDoubleCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(5.0));
        ImmutableDoubleCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(4.0));
        ImmutableDoubleCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(3.0));
        ImmutableDoubleCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(2.0));
        ImmutableDoubleCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith(1.0));
        ImmutableDoubleCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith(0.0));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0);
        this.assertSizeAndContains(collection0, 1.0, 2.0);
        this.assertSizeAndContains(collection1, 1.0, 2.0, 3.0);
        this.assertSizeAndContains(collection2, 1.0, 2.0, 3.0, 4.0);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableDoubleCollectionTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableDoubleCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCollectionTestCase> newWithoutAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableDoubleCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableDoubleCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableDoubleCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableDoubleCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableDoubleCollectionTestCase::tap;
            this.payloads.contains = AbstractImmutableDoubleCollectionTestCase::contains;
            this.payloads.contains_NaN = AbstractImmutableDoubleCollectionTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractImmutableDoubleCollectionTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractImmutableDoubleCollectionTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractImmutableDoubleCollectionTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractImmutableDoubleCollectionTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractImmutableDoubleCollectionTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractImmutableDoubleCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableDoubleCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableDoubleCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableDoubleCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableDoubleCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableDoubleCollectionTestCase::containsNoneIterable;
            this.payloads.doubleIterator = AbstractImmutableDoubleCollectionTestCase::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCollectionTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCollectionTestCase::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableDoubleCollectionTestCase::forEach;
            this.payloads.size = AbstractImmutableDoubleCollectionTestCase::size;
            this.payloads.count = AbstractImmutableDoubleCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableDoubleCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableDoubleCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableDoubleCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableDoubleCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableDoubleCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableDoubleCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableDoubleCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableDoubleCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableDoubleCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableDoubleCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableDoubleCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableDoubleCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableDoubleCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractImmutableDoubleCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractImmutableDoubleCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableDoubleCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableDoubleCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableDoubleCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableDoubleCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableDoubleCollectionTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractImmutableDoubleCollectionTestCase::sumConsistentRounding;
            this.payloads.average = AbstractImmutableDoubleCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableDoubleCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableDoubleCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableDoubleCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableDoubleCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableDoubleCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableDoubleCollectionTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableDoubleCollectionTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableDoubleCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableDoubleCollectionTestCase::testToString;
            this.payloads.makeString = AbstractImmutableDoubleCollectionTestCase::makeString;
            this.payloads.appendString = AbstractImmutableDoubleCollectionTestCase::appendString;
            this.payloads.toList = AbstractImmutableDoubleCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableDoubleCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableDoubleCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableDoubleCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableDoubleCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableDoubleCollectionTestCase::toSet;
            this.payloads.toBag = AbstractImmutableDoubleCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableDoubleCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractImmutableDoubleCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableDoubleCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableDoubleCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableDoubleCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableDoubleCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableDoubleCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableDoubleCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableDoubleCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableDoubleCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableDoubleCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableDoubleCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableDoubleCollectionTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableDoubleCollectionTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableDoubleCollectionTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableDoubleCollectionTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableDoubleCollectionTestCase::newWithoutAll;
        }
    }
}
