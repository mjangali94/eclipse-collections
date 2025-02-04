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

import org.eclipse.collections.api.collection.primitive.ImmutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractFloatIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatCollection}s.
 * This file was automatically generated from template file abstractImmutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractImmutableFloatCollectionTestCase extends AbstractFloatIterableTestCase {

    @Override
    protected abstract ImmutableFloatCollection classUnderTest();

    @Override
    protected abstract ImmutableFloatCollection newWith(float... elements);

    @Override
    protected abstract MutableFloatCollection newMutableCollectionWith(float... elements);

    protected void assertSizeAndContains(ImmutableFloatCollection collection, float... elements) {
        Assert.assertEquals(elements.length, collection.size());
        for (float i : elements) {
            Assert.assertTrue(collection.contains(i));
        }
    }

    @Test
    public void testNewWith() {
        ImmutableFloatCollection immutableCollection = this.newWith();
        ImmutableFloatCollection collection = immutableCollection.newWith(1.0f);
        ImmutableFloatCollection collection0 = immutableCollection.newWith(1.0f).newWith(2.0f);
        ImmutableFloatCollection collection1 = immutableCollection.newWith(1.0f).newWith(2.0f).newWith(3.0f);
        ImmutableFloatCollection collection2 = immutableCollection.newWith(1.0f).newWith(2.0f).newWith(3.0f).newWith(4.0f);
        ImmutableFloatCollection collection3 = immutableCollection.newWith(1.0f).newWith(2.0f).newWith(3.0f).newWith(4.0f).newWith(5.0f);
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
        this.assertSizeAndContains(collection3, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
    }

    @Test
    public void newWithAll() {
        ImmutableFloatCollection immutableCollection = this.newWith();
        ImmutableFloatCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0f));
        ImmutableFloatCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(2.0f));
        ImmutableFloatCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(3.0f));
        ImmutableFloatCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f));
        ImmutableFloatCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        this.assertSizeAndContains(immutableCollection);
        this.assertSizeAndContains(collection, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
        this.assertSizeAndContains(collection3, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
    }

    @Test
    public void newWithout() {
        ImmutableFloatCollection collection3 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        ImmutableFloatCollection collection2 = collection3.newWithout(5.0f);
        ImmutableFloatCollection collection1 = collection2.newWithout(4.0f);
        ImmutableFloatCollection collection0 = collection1.newWithout(3.0f);
        ImmutableFloatCollection collection4 = collection0.newWithout(2.0f);
        ImmutableFloatCollection collection5 = collection4.newWithout(1.0f);
        ImmutableFloatCollection collection6 = collection5.newWithout(0.0f);
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
    }

    @Test
    public void newWithoutAll() {
        ImmutableFloatCollection collection3 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        ImmutableFloatCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(5.0f));
        ImmutableFloatCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(4.0f));
        ImmutableFloatCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(3.0f));
        ImmutableFloatCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(2.0f));
        ImmutableFloatCollection collection5 = collection4.newWithoutAll(this.newMutableCollectionWith(1.0f));
        ImmutableFloatCollection collection6 = collection5.newWithoutAll(this.newMutableCollectionWith(0.0f));
        this.assertSizeAndContains(collection6);
        this.assertSizeAndContains(collection5);
        this.assertSizeAndContains(collection4, 1.0f);
        this.assertSizeAndContains(collection0, 1.0f, 2.0f);
        this.assertSizeAndContains(collection1, 1.0f, 2.0f, 3.0f);
        this.assertSizeAndContains(collection2, 1.0f, 2.0f, 3.0f, 4.0f);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableFloatCollectionTestCase instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableFloatCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatCollectionTestCase> newWithoutAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableFloatCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableFloatCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableFloatCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableFloatCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableFloatCollectionTestCase::tap;
            this.payloads.contains = AbstractImmutableFloatCollectionTestCase::contains;
            this.payloads.contains_NaN = AbstractImmutableFloatCollectionTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractImmutableFloatCollectionTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractImmutableFloatCollectionTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractImmutableFloatCollectionTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractImmutableFloatCollectionTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractImmutableFloatCollectionTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractImmutableFloatCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableFloatCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableFloatCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableFloatCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableFloatCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableFloatCollectionTestCase::containsNoneIterable;
            this.payloads.floatIterator = AbstractImmutableFloatCollectionTestCase::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatCollectionTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatCollectionTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableFloatCollectionTestCase::forEach;
            this.payloads.size = AbstractImmutableFloatCollectionTestCase::size;
            this.payloads.count = AbstractImmutableFloatCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableFloatCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableFloatCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableFloatCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableFloatCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableFloatCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableFloatCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableFloatCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableFloatCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableFloatCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableFloatCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableFloatCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableFloatCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableFloatCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractImmutableFloatCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractImmutableFloatCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableFloatCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableFloatCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableFloatCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableFloatCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractImmutableFloatCollectionTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractImmutableFloatCollectionTestCase::sumConsistentRounding;
            this.payloads.average = AbstractImmutableFloatCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableFloatCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableFloatCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableFloatCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableFloatCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableFloatCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableFloatCollectionTestCase::toSortedArray;
            this.payloads.testEquals = AbstractImmutableFloatCollectionTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableFloatCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableFloatCollectionTestCase::testToString;
            this.payloads.makeString = AbstractImmutableFloatCollectionTestCase::makeString;
            this.payloads.appendString = AbstractImmutableFloatCollectionTestCase::appendString;
            this.payloads.toList = AbstractImmutableFloatCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableFloatCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractImmutableFloatCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableFloatCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableFloatCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableFloatCollectionTestCase::toSet;
            this.payloads.toBag = AbstractImmutableFloatCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableFloatCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractImmutableFloatCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableFloatCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableFloatCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableFloatCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableFloatCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableFloatCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableFloatCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableFloatCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableFloatCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableFloatCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableFloatCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableFloatCollectionTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableFloatCollectionTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableFloatCollectionTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableFloatCollectionTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableFloatCollectionTestCase::newWithoutAll;
        }
    }
}
