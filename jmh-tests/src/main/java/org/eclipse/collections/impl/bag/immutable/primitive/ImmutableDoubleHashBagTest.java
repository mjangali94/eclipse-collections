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

import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;

/**
 * JUnit test for {@link ImmutableDoubleHashBag}.
 * This file was automatically generated from template file immutablePrimitiveHashBagTest.stg.
 */
public class ImmutableDoubleHashBagTest extends AbstractImmutableDoubleBagTestCase {

    @Override
    protected final ImmutableDoubleBag classUnderTest() {
        return DoubleBags.immutable.of(1.0, 2.0, 3.0);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableDoubleHashBag iterable = ImmutableDoubleHashBag.newBagWith(1.0, 2.0, 3.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableDoubleBag bag = this.classUnderTest();
        ImmutableDoubleSet expected = DoubleSets.immutable.with(1.0, 2.0, 3.0);
        ImmutableDoubleSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubleHashBagTest instance;

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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubleHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleHashBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableDoubleHashBagTest::newCollectionWith;
            this.payloads.newCollection = ImmutableDoubleHashBagTest::newCollection;
            this.payloads.isEmpty = ImmutableDoubleHashBagTest::isEmpty;
            this.payloads.notEmpty = ImmutableDoubleHashBagTest::notEmpty;
            this.payloads.tap = ImmutableDoubleHashBagTest::tap;
            this.payloads.contains = ImmutableDoubleHashBagTest::contains;
            this.payloads.contains_NaN = ImmutableDoubleHashBagTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ImmutableDoubleHashBagTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ImmutableDoubleHashBagTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ImmutableDoubleHashBagTest::contains_zero;
            this.payloads.testEquals_NaN = ImmutableDoubleHashBagTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = ImmutableDoubleHashBagTest::contains_different_NaNs;
            this.payloads.containsAllArray = ImmutableDoubleHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableDoubleHashBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableDoubleHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableDoubleHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableDoubleHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableDoubleHashBagTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashBagTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashBagTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.size = ImmutableDoubleHashBagTest::size;
            this.payloads.anySatisfy = ImmutableDoubleHashBagTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableDoubleHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableDoubleHashBagTest::noneSatisfy;
            this.payloads.collect = ImmutableDoubleHashBagTest::collect;
            this.payloads.collectWithTarget = ImmutableDoubleHashBagTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableDoubleHashBagTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableDoubleHashBagTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableDoubleHashBagTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableDoubleHashBagTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableDoubleHashBagTest::select;
            this.payloads.selectWithTarget = ImmutableDoubleHashBagTest::selectWithTarget;
            this.payloads.reject = ImmutableDoubleHashBagTest::reject;
            this.payloads.rejectWithTarget = ImmutableDoubleHashBagTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableDoubleHashBagTest::detectIfNone;
            this.payloads.max = ImmutableDoubleHashBagTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashBagTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableDoubleHashBagTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashBagTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableDoubleHashBagTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableDoubleHashBagTest::maxIfEmpty;
            this.payloads.summaryStatistics = ImmutableDoubleHashBagTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ImmutableDoubleHashBagTest::sumConsistentRounding;
            this.payloads.average = ImmutableDoubleHashBagTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashBagTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableDoubleHashBagTest::averageIfEmpty;
            this.payloads.median = ImmutableDoubleHashBagTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashBagTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableDoubleHashBagTest::medianIfEmpty;
            this.payloads.toArray = ImmutableDoubleHashBagTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableDoubleHashBagTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableDoubleHashBagTest::toSortedArray;
            this.payloads.testHashCode = ImmutableDoubleHashBagTest::testHashCode;
            this.payloads.toSortedListByComparator = ImmutableDoubleHashBagTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableDoubleHashBagTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableDoubleHashBagTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableDoubleHashBagTest::toSet;
            this.payloads.toBag = ImmutableDoubleHashBagTest::toBag;
            this.payloads.asLazy = ImmutableDoubleHashBagTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableDoubleHashBagTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableDoubleHashBagTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableDoubleHashBagTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableDoubleHashBagTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableDoubleHashBagTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableDoubleHashBagTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableDoubleHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableDoubleHashBagTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableDoubleHashBagTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableDoubleHashBagTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableDoubleHashBagTest::chunk;
            this.payloads.testNewWith = ImmutableDoubleHashBagTest::testNewWith;
            this.payloads.newWithAll = ImmutableDoubleHashBagTest::newWithAll;
            this.payloads.newWithout = ImmutableDoubleHashBagTest::newWithout;
            this.payloads.newWithoutAll = ImmutableDoubleHashBagTest::newWithoutAll;
            this.payloads.sizeDistinct = ImmutableDoubleHashBagTest::sizeDistinct;
            this.payloads.selectByOccurrences = ImmutableDoubleHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableDoubleHashBagTest::selectDuplicates;
            this.payloads.topOccurrences = ImmutableDoubleHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableDoubleHashBagTest::bottomOccurrences;
            this.payloads.forEachWithOccurrences = ImmutableDoubleHashBagTest::forEachWithOccurrences;
            this.payloads.doubleIterator = ImmutableDoubleHashBagTest::doubleIterator;
            this.payloads.forEach = ImmutableDoubleHashBagTest::forEach;
            this.payloads.count = ImmutableDoubleHashBagTest::count;
            this.payloads.sum = ImmutableDoubleHashBagTest::sum;
            this.payloads.testEquals = ImmutableDoubleHashBagTest::testEquals;
            this.payloads.testToString = ImmutableDoubleHashBagTest::testToString;
            this.payloads.makeString = ImmutableDoubleHashBagTest::makeString;
            this.payloads.appendString = ImmutableDoubleHashBagTest::appendString;
            this.payloads.toList = ImmutableDoubleHashBagTest::toList;
            this.payloads.toSortedList = ImmutableDoubleHashBagTest::toSortedList;
            this.payloads.toImmutable = ImmutableDoubleHashBagTest::toImmutable;
            this.payloads.toStringOfItemToCount = ImmutableDoubleHashBagTest::toStringOfItemToCount;
            this.payloads.injectInto = ImmutableDoubleHashBagTest::injectInto;
            this.payloads.selectUnique = ImmutableDoubleHashBagTest::selectUnique;
        }
    }
}
