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
import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;

/**
 * JUnit test for {@link ImmutableCharEmptyBag}.
 * This file was automatically generated from template file immutablePrimitiveEmptyBagTest.stg.
 */
public class ImmutableCharEmptyBagTest extends AbstractImmutableCharBagTestCase {

    @Override
    protected final ImmutableCharBag classUnderTest() {
        return CharBags.immutable.of();
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
        this.classUnderTest().forEachWithOccurrences((char argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("", string);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableCharBag bag = this.classUnderTest();
        ImmutableCharSet expected = CharSets.immutable.empty();
        ImmutableCharSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void occurrencesOf() {
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf((char) 1));
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf((char) 2));
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf((char) 3));
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableCharEmptyBag iterable = new ImmutableCharEmptyBag();
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharEmptyBagTest instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharEmptyBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharEmptyBagTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableCharEmptyBagTest::newCollectionWith;
            this.payloads.newCollection = ImmutableCharEmptyBagTest::newCollection;
            this.payloads.tap = ImmutableCharEmptyBagTest::tap;
            this.payloads.contains = ImmutableCharEmptyBagTest::contains;
            this.payloads.containsAllArray = ImmutableCharEmptyBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableCharEmptyBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableCharEmptyBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableCharEmptyBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableCharEmptyBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableCharEmptyBagTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.size = ImmutableCharEmptyBagTest::size;
            this.payloads.anySatisfy = ImmutableCharEmptyBagTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharEmptyBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharEmptyBagTest::noneSatisfy;
            this.payloads.collect = ImmutableCharEmptyBagTest::collect;
            this.payloads.collectWithTarget = ImmutableCharEmptyBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableCharEmptyBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableCharEmptyBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableCharEmptyBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableCharEmptyBagTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableCharEmptyBagTest::select;
            this.payloads.selectWithTarget = ImmutableCharEmptyBagTest::selectWithTarget;
            this.payloads.reject = ImmutableCharEmptyBagTest::reject;
            this.payloads.rejectWithTarget = ImmutableCharEmptyBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableCharEmptyBagTest::detectIfNone;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharEmptyBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharEmptyBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ImmutableCharEmptyBagTest::summaryStatistics;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableCharEmptyBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableCharEmptyBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableCharEmptyBagTest::toSortedArray;
            this.payloads.testHashCode = ImmutableCharEmptyBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ImmutableCharEmptyBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableCharEmptyBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableCharEmptyBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableCharEmptyBagTest::toSet;
            this.payloads.toBag = ImmutableCharEmptyBagTest::toBag;
            this.payloads.asLazy = ImmutableCharEmptyBagTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableCharEmptyBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableCharEmptyBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableCharEmptyBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableCharEmptyBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableCharEmptyBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableCharEmptyBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableCharEmptyBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableCharEmptyBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableCharEmptyBagTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableCharEmptyBagTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableCharEmptyBagTest::chunk;
            this.payloads.testNewWith = ImmutableCharEmptyBagTest::testNewWith;
            this.payloads.newWithAll = ImmutableCharEmptyBagTest::newWithAll;
            this.payloads.newWithout = ImmutableCharEmptyBagTest::newWithout;
            this.payloads.newWithoutAll = ImmutableCharEmptyBagTest::newWithoutAll;
            this.payloads.sizeDistinct = ImmutableCharEmptyBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = ImmutableCharEmptyBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableCharEmptyBagTest::selectDuplicates;
            this.payloads.topOccurrences = ImmutableCharEmptyBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableCharEmptyBagTest::bottomOccurrences;
            this.payloads.charIterator = ImmutableCharEmptyBagTest::charIterator;
            this.payloads.forEach = ImmutableCharEmptyBagTest::forEach;
            this.payloads.count = ImmutableCharEmptyBagTest::count;
            this.payloads.sum = ImmutableCharEmptyBagTest::sum;
            this.payloads.testEquals = ImmutableCharEmptyBagTest::testEquals;
            this.payloads.testToString = ImmutableCharEmptyBagTest::testToString;
            this.payloads.makeString = ImmutableCharEmptyBagTest::makeString;
            this.payloads.appendString = ImmutableCharEmptyBagTest::appendString;
            this.payloads.toList = ImmutableCharEmptyBagTest::toList;
            this.payloads.toSortedList = ImmutableCharEmptyBagTest::toSortedList;
            this.payloads.toImmutable = ImmutableCharEmptyBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ImmutableCharEmptyBagTest::toStringOfItemToCount;
            this.payloads.average = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::average, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableCharEmptyBagTest::averageIfEmpty;
            this.payloads.median = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::median, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableCharEmptyBagTest::medianIfEmpty;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::max, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharEmptyBagTest::min, java.util.NoSuchElementException.class);
            this.payloads.notEmpty = ImmutableCharEmptyBagTest::notEmpty;
            this.payloads.isEmpty = ImmutableCharEmptyBagTest::isEmpty;
            this.payloads.forEachWithOccurrences = ImmutableCharEmptyBagTest::forEachWithOccurrences;
            this.payloads.selectUnique = ImmutableCharEmptyBagTest::selectUnique;
            this.payloads.occurrencesOf = ImmutableCharEmptyBagTest::occurrencesOf;
            this.payloads.injectInto = ImmutableCharEmptyBagTest::injectInto;
        }
    }
}
