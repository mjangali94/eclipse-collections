/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableCharHashSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharEmptySet}.
 * This file was automatically generated from template file immutablePrimitiveEmptySetTest.stg.
 */
public class ImmutableCharEmptySetTest extends AbstractImmutableCharHashSetTestCase {

    @Override
    protected final ImmutableCharSet classUnderTest() {
        return CharSets.immutable.empty();
    }

    @Override
    protected ImmutableCharSet newWith(char... elements) {
        return CharSets.immutable.with(elements);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average() {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void averageIfEmpty() {
        Assert.assertEquals(1.2, this.classUnderTest().averageIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median() {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void medianIfEmpty() {
        Assert.assertEquals(1.2, this.classUnderTest().medianIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min();
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
    }

    @Override
    @Test
    public void toBag() {
        Assert.assertEquals(CharBags.immutable.empty(), this.classUnderTest().toBag());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharEmptySetTest instance;

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
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
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
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
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
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharEmptySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptySetTest> toBag;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableCharEmptySetTest::newCollectionWith;
            this.payloads.newCollection = ImmutableCharEmptySetTest::newCollection;
            this.payloads.tap = ImmutableCharEmptySetTest::tap;
            this.payloads.contains = ImmutableCharEmptySetTest::contains;
            this.payloads.containsAllArray = ImmutableCharEmptySetTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableCharEmptySetTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableCharEmptySetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableCharEmptySetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableCharEmptySetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableCharEmptySetTest::containsNoneIterable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableCharEmptySetTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharEmptySetTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharEmptySetTest::noneSatisfy;
            this.payloads.collectWithTarget = ImmutableCharEmptySetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableCharEmptySetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableCharEmptySetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableCharEmptySetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableCharEmptySetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ImmutableCharEmptySetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ImmutableCharEmptySetTest::rejectWithTarget;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharEmptySetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharEmptySetTest::maxIfEmpty;
            this.payloads.sum = ImmutableCharEmptySetTest::sum;
            this.payloads.summaryStatistics = ImmutableCharEmptySetTest::summaryStatistics;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableCharEmptySetTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableCharEmptySetTest::toArrayWithTargetArray;
            this.payloads.testToString = ImmutableCharEmptySetTest::testToString;
            this.payloads.makeString = ImmutableCharEmptySetTest::makeString;
            this.payloads.appendString = ImmutableCharEmptySetTest::appendString;
            this.payloads.toList = ImmutableCharEmptySetTest::toList;
            this.payloads.toSortedList = ImmutableCharEmptySetTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableCharEmptySetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableCharEmptySetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableCharEmptySetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableCharEmptySetTest::toSet;
            this.payloads.injectInto = ImmutableCharEmptySetTest::injectInto;
            this.payloads.injectIntoBoolean = ImmutableCharEmptySetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableCharEmptySetTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableCharEmptySetTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableCharEmptySetTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableCharEmptySetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableCharEmptySetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableCharEmptySetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableCharEmptySetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableCharEmptySetTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableCharEmptySetTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableCharEmptySetTest::chunk;
            this.payloads.testNewWith = ImmutableCharEmptySetTest::testNewWith;
            this.payloads.newWithAll = ImmutableCharEmptySetTest::newWithAll;
            this.payloads.newWithout = ImmutableCharEmptySetTest::newWithout;
            this.payloads.newWithoutAll = ImmutableCharEmptySetTest::newWithoutAll;
            this.payloads.size = ImmutableCharEmptySetTest::size;
            this.payloads.freeze = ImmutableCharEmptySetTest::freeze;
            this.payloads.toImmutable = ImmutableCharEmptySetTest::toImmutable;
            this.payloads.charIterator = ImmutableCharEmptySetTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableCharEmptySetTest::forEach;
            this.payloads.count = ImmutableCharEmptySetTest::count;
            this.payloads.select = ImmutableCharEmptySetTest::select;
            this.payloads.reject = ImmutableCharEmptySetTest::reject;
            this.payloads.detectIfNone = ImmutableCharEmptySetTest::detectIfNone;
            this.payloads.collect = ImmutableCharEmptySetTest::collect;
            this.payloads.toSortedArray = ImmutableCharEmptySetTest::toSortedArray;
            this.payloads.testEquals = ImmutableCharEmptySetTest::testEquals;
            this.payloads.testHashCode = ImmutableCharEmptySetTest::testHashCode;
            this.payloads.asLazy = ImmutableCharEmptySetTest::asLazy;
            this.payloads.union = ImmutableCharEmptySetTest::union;
            this.payloads.intersect = ImmutableCharEmptySetTest::intersect;
            this.payloads.difference = ImmutableCharEmptySetTest::difference;
            this.payloads.symmetricDifference = ImmutableCharEmptySetTest::symmetricDifference;
            this.payloads.isSubsetOf = ImmutableCharEmptySetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableCharEmptySetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ImmutableCharEmptySetTest::cartesianProduct;
            this.payloads.average = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::average, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableCharEmptySetTest::averageIfEmpty;
            this.payloads.median = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::median, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableCharEmptySetTest::medianIfEmpty;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::max, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptySetTest::min, java.util.NoSuchElementException.class);
            this.payloads.notEmpty = ImmutableCharEmptySetTest::notEmpty;
            this.payloads.isEmpty = ImmutableCharEmptySetTest::isEmpty;
            this.payloads.toBag = ImmutableCharEmptySetTest::toBag;
        }
    }
}
