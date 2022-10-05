/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;

/**
 * JUnit test for {@link ImmutableCharHashBag}.
 * This file was automatically generated from template file immutablePrimitiveHashBagTest.stg.
 */
public class ImmutableCharHashBagTest extends AbstractImmutableCharBagTestCase {

    @Override
    protected final ImmutableCharBag classUnderTest() {
        return CharBags.immutable.of((char) 1, (char) 2, (char) 3);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableCharHashBag iterable = ImmutableCharHashBag.newBagWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableCharBag bag = this.classUnderTest();
        ImmutableCharSet expected = CharSets.immutable.with((char) 1, (char) 2, (char) 3);
        ImmutableCharSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharHashBagTest instance;

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
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharHashBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableCharHashBagTest::newCollectionWith;
            this.payloads.newCollection = ImmutableCharHashBagTest::newCollection;
            this.payloads.isEmpty = ImmutableCharHashBagTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharHashBagTest::notEmpty;
            this.payloads.tap = ImmutableCharHashBagTest::tap;
            this.payloads.contains = ImmutableCharHashBagTest::contains;
            this.payloads.containsAllArray = ImmutableCharHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableCharHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableCharHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableCharHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableCharHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableCharHashBagTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharHashBagTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharHashBagTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.size = ImmutableCharHashBagTest::size;
            this.payloads.anySatisfy = ImmutableCharHashBagTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharHashBagTest::noneSatisfy;
            this.payloads.collect = ImmutableCharHashBagTest::collect;
            this.payloads.collectWithTarget = ImmutableCharHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableCharHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableCharHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableCharHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableCharHashBagTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableCharHashBagTest::select;
            this.payloads.selectWithTarget = ImmutableCharHashBagTest::selectWithTarget;
            this.payloads.reject = ImmutableCharHashBagTest::reject;
            this.payloads.rejectWithTarget = ImmutableCharHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableCharHashBagTest::detectIfNone;
            this.payloads.max = ImmutableCharHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableCharHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ImmutableCharHashBagTest::summaryStatistics;
            this.payloads.average = ImmutableCharHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableCharHashBagTest::averageIfEmpty;
            this.payloads.median = ImmutableCharHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableCharHashBagTest::medianIfEmpty;
            this.payloads.toArray = ImmutableCharHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableCharHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableCharHashBagTest::toSortedArray;
            this.payloads.testHashCode = ImmutableCharHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ImmutableCharHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableCharHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableCharHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableCharHashBagTest::toSet;
            this.payloads.toBag = ImmutableCharHashBagTest::toBag;
            this.payloads.asLazy = ImmutableCharHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableCharHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableCharHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableCharHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableCharHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableCharHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableCharHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableCharHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableCharHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableCharHashBagTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableCharHashBagTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableCharHashBagTest::chunk;
            this.payloads.testNewWith = ImmutableCharHashBagTest::testNewWith;
            this.payloads.newWithAll = ImmutableCharHashBagTest::newWithAll;
            this.payloads.newWithout = ImmutableCharHashBagTest::newWithout;
            this.payloads.newWithoutAll = ImmutableCharHashBagTest::newWithoutAll;
            this.payloads.sizeDistinct = ImmutableCharHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = ImmutableCharHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableCharHashBagTest::selectDuplicates;
            this.payloads.topOccurrences = ImmutableCharHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableCharHashBagTest::bottomOccurrences;
            this.payloads.forEachWithOccurrences = ImmutableCharHashBagTest::forEachWithOccurrences;
            this.payloads.charIterator = ImmutableCharHashBagTest::charIterator;
            this.payloads.forEach = ImmutableCharHashBagTest::forEach;
            this.payloads.count = ImmutableCharHashBagTest::count;
            this.payloads.sum = ImmutableCharHashBagTest::sum;
            this.payloads.testEquals = ImmutableCharHashBagTest::testEquals;
            this.payloads.testToString = ImmutableCharHashBagTest::testToString;
            this.payloads.makeString = ImmutableCharHashBagTest::makeString;
            this.payloads.appendString = ImmutableCharHashBagTest::appendString;
            this.payloads.toList = ImmutableCharHashBagTest::toList;
            this.payloads.toSortedList = ImmutableCharHashBagTest::toSortedList;
            this.payloads.toImmutable = ImmutableCharHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ImmutableCharHashBagTest::toStringOfItemToCount;
            this.payloads.injectInto = ImmutableCharHashBagTest::injectInto;
            this.payloads.selectUnique = ImmutableCharHashBagTest::selectUnique;
        }
    }
}
