/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.immutable.primitive;

import org.eclipse.collections.api.stack.primitive.ImmutableFloatStack;
import org.eclipse.collections.impl.factory.primitive.FloatStacks;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableFloatArrayStackTest extends AbstractImmutableFloatStackTestCase {

    @Override
    protected ImmutableFloatStack classUnderTest() {
        return ImmutableFloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws() {
        ImmutableFloatArrayStack.newStack(FloatStacks.mutable.with(1.0f));
    }

    @Test
    public void newWithIterable() {
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f), this.newWithIterable(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void newWithTopToBottom() {
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 3.0f), this.newWithTopToBottom(1.0f, 2.0f, 3.0f));
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableFloatArrayStack iterable = ImmutableFloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableFloatArrayStackTest instance;

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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_less_than_zero_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_less_than_zero_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_greater_than_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_greater_than_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_equal_to_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_equal_to_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_push() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.push);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_popWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.popWithCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_negative_count_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_negative_count_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_count_greater_than_stack_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_count_greater_than_stack_size_throws_exception);
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
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStack_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStack_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithTopToBottom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithTopToBottom);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableFloatArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> testNewStack_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> newWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> newWithTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayStackTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableFloatArrayStackTest::newCollectionWith;
            this.payloads.newCollection = ImmutableFloatArrayStackTest::newCollection;
            this.payloads.isEmpty = ImmutableFloatArrayStackTest::isEmpty;
            this.payloads.notEmpty = ImmutableFloatArrayStackTest::notEmpty;
            this.payloads.tap = ImmutableFloatArrayStackTest::tap;
            this.payloads.contains = ImmutableFloatArrayStackTest::contains;
            this.payloads.contains_NaN = ImmutableFloatArrayStackTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ImmutableFloatArrayStackTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ImmutableFloatArrayStackTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ImmutableFloatArrayStackTest::contains_zero;
            this.payloads.testEquals_NaN = ImmutableFloatArrayStackTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = ImmutableFloatArrayStackTest::contains_different_NaNs;
            this.payloads.containsAllArray = ImmutableFloatArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableFloatArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableFloatArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableFloatArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableFloatArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableFloatArrayStackTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableFloatArrayStackTest::forEach;
            this.payloads.size = ImmutableFloatArrayStackTest::size;
            this.payloads.count = ImmutableFloatArrayStackTest::count;
            this.payloads.anySatisfy = ImmutableFloatArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableFloatArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableFloatArrayStackTest::noneSatisfy;
            this.payloads.collect = ImmutableFloatArrayStackTest::collect;
            this.payloads.collectWithTarget = ImmutableFloatArrayStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableFloatArrayStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableFloatArrayStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableFloatArrayStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableFloatArrayStackTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableFloatArrayStackTest::select;
            this.payloads.selectWithTarget = ImmutableFloatArrayStackTest::selectWithTarget;
            this.payloads.reject = ImmutableFloatArrayStackTest::reject;
            this.payloads.rejectWithTarget = ImmutableFloatArrayStackTest::rejectWithTarget;
            this.payloads.max = ImmutableFloatArrayStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableFloatArrayStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableFloatArrayStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableFloatArrayStackTest::maxIfEmpty;
            this.payloads.sum = ImmutableFloatArrayStackTest::sum;
            this.payloads.summaryStatistics = ImmutableFloatArrayStackTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ImmutableFloatArrayStackTest::sumConsistentRounding;
            this.payloads.average = ImmutableFloatArrayStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableFloatArrayStackTest::averageIfEmpty;
            this.payloads.median = ImmutableFloatArrayStackTest::median;
            this.payloads.medianIfEmpty = ImmutableFloatArrayStackTest::medianIfEmpty;
            this.payloads.toArray = ImmutableFloatArrayStackTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableFloatArrayStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableFloatArrayStackTest::toSortedArray;
            this.payloads.testEquals = ImmutableFloatArrayStackTest::testEquals;
            this.payloads.testHashCode = ImmutableFloatArrayStackTest::testHashCode;
            this.payloads.toSortedList = ImmutableFloatArrayStackTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableFloatArrayStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableFloatArrayStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableFloatArrayStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableFloatArrayStackTest::toSet;
            this.payloads.toBag = ImmutableFloatArrayStackTest::toBag;
            this.payloads.asLazy = ImmutableFloatArrayStackTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableFloatArrayStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableFloatArrayStackTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableFloatArrayStackTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableFloatArrayStackTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableFloatArrayStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableFloatArrayStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableFloatArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableFloatArrayStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableFloatArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableFloatArrayStackTest::reduceIfEmpty;
            this.payloads.floatIterator = ImmutableFloatArrayStackTest::floatIterator;
            this.payloads.peek = ImmutableFloatArrayStackTest::peek;
            this.payloads.peekAtIndex = ImmutableFloatArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.detectIfNone = ImmutableFloatArrayStackTest::detectIfNone;
            this.payloads.selectWithIndex = ImmutableFloatArrayStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableFloatArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableFloatArrayStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableFloatArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableFloatArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableFloatArrayStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = ImmutableFloatArrayStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.push = ImmutableFloatArrayStackTest::push;
            this.payloads.pop = ImmutableFloatArrayStackTest::pop;
            this.payloads.popWithCount = ImmutableFloatArrayStackTest::popWithCount;
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = ImmutableFloatArrayStackTest::testToString;
            this.payloads.makeString = ImmutableFloatArrayStackTest::makeString;
            this.payloads.appendString = ImmutableFloatArrayStackTest::appendString;
            this.payloads.toList = ImmutableFloatArrayStackTest::toList;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toImmutable = ImmutableFloatArrayStackTest::toImmutable;
            this.payloads.testNewStack_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayStackTest::testNewStack_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newWithIterable = ImmutableFloatArrayStackTest::newWithIterable;
            this.payloads.newWithTopToBottom = ImmutableFloatArrayStackTest::newWithTopToBottom;
            this.payloads.injectInto = ImmutableFloatArrayStackTest::injectInto;
        }
    }
}
