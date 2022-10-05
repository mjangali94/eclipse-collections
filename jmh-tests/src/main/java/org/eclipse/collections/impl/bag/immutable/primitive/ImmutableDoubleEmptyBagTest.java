/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;

/**
 * JUnit test for {@link ImmutableDoubleEmptyBag}.
 * This file was automatically generated from template file immutablePrimitiveEmptyBagTest.stg.
 */
public class ImmutableDoubleEmptyBagTest extends AbstractImmutableDoubleBagTestCase {

    @Override
    protected final ImmutableDoubleBag classUnderTest() {
        return DoubleBags.immutable.of();
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
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((double argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("", string);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableDoubleBag bag = this.classUnderTest();
        ImmutableDoubleSet expected = DoubleSets.immutable.empty();
        ImmutableDoubleSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void occurrencesOf() {
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf(1.0));
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf(2.0));
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf(3.0));
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableDoubleEmptyBag iterable = new ImmutableDoubleEmptyBag();
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(0.0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubleEmptyBagTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
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
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubleEmptyBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleEmptyBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableDoubleEmptyBagTest::newCollectionWith;
            this.payloads.newCollection = ImmutableDoubleEmptyBagTest::newCollection;
            this.payloads.tap = ImmutableDoubleEmptyBagTest::tap;
            this.payloads.contains = ImmutableDoubleEmptyBagTest::contains;
            this.payloads.contains_NaN = ImmutableDoubleEmptyBagTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ImmutableDoubleEmptyBagTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ImmutableDoubleEmptyBagTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ImmutableDoubleEmptyBagTest::contains_zero;
            this.payloads.testEquals_NaN = ImmutableDoubleEmptyBagTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = ImmutableDoubleEmptyBagTest::contains_different_NaNs;
            this.payloads.containsAllArray = ImmutableDoubleEmptyBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableDoubleEmptyBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableDoubleEmptyBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableDoubleEmptyBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableDoubleEmptyBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableDoubleEmptyBagTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.size = ImmutableDoubleEmptyBagTest::size;
            this.payloads.anySatisfy = ImmutableDoubleEmptyBagTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableDoubleEmptyBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableDoubleEmptyBagTest::noneSatisfy;
            this.payloads.collect = ImmutableDoubleEmptyBagTest::collect;
            this.payloads.collectWithTarget = ImmutableDoubleEmptyBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableDoubleEmptyBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableDoubleEmptyBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableDoubleEmptyBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableDoubleEmptyBagTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableDoubleEmptyBagTest::select;
            this.payloads.selectWithTarget = ImmutableDoubleEmptyBagTest::selectWithTarget;
            this.payloads.reject = ImmutableDoubleEmptyBagTest::reject;
            this.payloads.rejectWithTarget = ImmutableDoubleEmptyBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableDoubleEmptyBagTest::detectIfNone;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableDoubleEmptyBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableDoubleEmptyBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ImmutableDoubleEmptyBagTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ImmutableDoubleEmptyBagTest::sumConsistentRounding;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableDoubleEmptyBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableDoubleEmptyBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableDoubleEmptyBagTest::toSortedArray;
            this.payloads.testHashCode = ImmutableDoubleEmptyBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ImmutableDoubleEmptyBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableDoubleEmptyBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableDoubleEmptyBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableDoubleEmptyBagTest::toSet;
            this.payloads.toBag = ImmutableDoubleEmptyBagTest::toBag;
            this.payloads.asLazy = ImmutableDoubleEmptyBagTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableDoubleEmptyBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableDoubleEmptyBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableDoubleEmptyBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableDoubleEmptyBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableDoubleEmptyBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableDoubleEmptyBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableDoubleEmptyBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableDoubleEmptyBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableDoubleEmptyBagTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableDoubleEmptyBagTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableDoubleEmptyBagTest::chunk;
            this.payloads.testNewWith = ImmutableDoubleEmptyBagTest::testNewWith;
            this.payloads.newWithAll = ImmutableDoubleEmptyBagTest::newWithAll;
            this.payloads.newWithout = ImmutableDoubleEmptyBagTest::newWithout;
            this.payloads.newWithoutAll = ImmutableDoubleEmptyBagTest::newWithoutAll;
            this.payloads.sizeDistinct = ImmutableDoubleEmptyBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = ImmutableDoubleEmptyBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableDoubleEmptyBagTest::selectDuplicates;
            this.payloads.topOccurrences = ImmutableDoubleEmptyBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableDoubleEmptyBagTest::bottomOccurrences;
            this.payloads.doubleIterator = ImmutableDoubleEmptyBagTest::doubleIterator;
            this.payloads.forEach = ImmutableDoubleEmptyBagTest::forEach;
            this.payloads.count = ImmutableDoubleEmptyBagTest::count;
            this.payloads.sum = ImmutableDoubleEmptyBagTest::sum;
            this.payloads.testEquals = ImmutableDoubleEmptyBagTest::testEquals;
            this.payloads.testToString = ImmutableDoubleEmptyBagTest::testToString;
            this.payloads.makeString = ImmutableDoubleEmptyBagTest::makeString;
            this.payloads.appendString = ImmutableDoubleEmptyBagTest::appendString;
            this.payloads.toList = ImmutableDoubleEmptyBagTest::toList;
            this.payloads.toSortedList = ImmutableDoubleEmptyBagTest::toSortedList;
            this.payloads.toImmutable = ImmutableDoubleEmptyBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ImmutableDoubleEmptyBagTest::toStringOfItemToCount;
            this.payloads.average = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::average, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableDoubleEmptyBagTest::averageIfEmpty;
            this.payloads.median = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::median, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableDoubleEmptyBagTest::medianIfEmpty;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::max, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleEmptyBagTest::min, java.util.NoSuchElementException.class);
            this.payloads.notEmpty = ImmutableDoubleEmptyBagTest::notEmpty;
            this.payloads.isEmpty = ImmutableDoubleEmptyBagTest::isEmpty;
            this.payloads.forEachWithOccurrences = ImmutableDoubleEmptyBagTest::forEachWithOccurrences;
            this.payloads.selectUnique = ImmutableDoubleEmptyBagTest::selectUnique;
            this.payloads.occurrencesOf = ImmutableDoubleEmptyBagTest::occurrencesOf;
            this.payloads.injectInto = ImmutableDoubleEmptyBagTest::injectInto;
        }
    }
}
