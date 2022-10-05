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

import org.eclipse.collections.api.stack.primitive.ImmutableLongStack;
import org.eclipse.collections.impl.factory.primitive.LongStacks;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableLongArrayStackTest extends AbstractImmutableLongStackTestCase {

    @Override
    protected ImmutableLongStack classUnderTest() {
        return ImmutableLongArrayStack.newStackWith(1L, 2L, 3L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws() {
        ImmutableLongArrayStack.newStack(LongStacks.mutable.with(1L));
    }

    @Test
    public void newWithIterable() {
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L), this.newWithIterable(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test
    public void newWithTopToBottom() {
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L, 3L), this.newWithTopToBottom(1L, 2L, 3L));
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableLongArrayStack iterable = ImmutableLongArrayStack.newStackWith(1L, 2L, 3L);
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongArrayStackTest instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> testNewStack_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> newWithIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> newWithTopToBottom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayStackTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableLongArrayStackTest::newCollectionWith;
            this.payloads.newCollection = ImmutableLongArrayStackTest::newCollection;
            this.payloads.isEmpty = ImmutableLongArrayStackTest::isEmpty;
            this.payloads.notEmpty = ImmutableLongArrayStackTest::notEmpty;
            this.payloads.tap = ImmutableLongArrayStackTest::tap;
            this.payloads.contains = ImmutableLongArrayStackTest::contains;
            this.payloads.containsAllArray = ImmutableLongArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableLongArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableLongArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableLongArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableLongArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableLongArrayStackTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableLongArrayStackTest::forEach;
            this.payloads.size = ImmutableLongArrayStackTest::size;
            this.payloads.count = ImmutableLongArrayStackTest::count;
            this.payloads.anySatisfy = ImmutableLongArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableLongArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableLongArrayStackTest::noneSatisfy;
            this.payloads.collect = ImmutableLongArrayStackTest::collect;
            this.payloads.collectWithTarget = ImmutableLongArrayStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableLongArrayStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableLongArrayStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableLongArrayStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableLongArrayStackTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableLongArrayStackTest::select;
            this.payloads.selectWithTarget = ImmutableLongArrayStackTest::selectWithTarget;
            this.payloads.reject = ImmutableLongArrayStackTest::reject;
            this.payloads.rejectWithTarget = ImmutableLongArrayStackTest::rejectWithTarget;
            this.payloads.max = ImmutableLongArrayStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableLongArrayStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableLongArrayStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableLongArrayStackTest::maxIfEmpty;
            this.payloads.sum = ImmutableLongArrayStackTest::sum;
            this.payloads.summaryStatistics = ImmutableLongArrayStackTest::summaryStatistics;
            this.payloads.average = ImmutableLongArrayStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableLongArrayStackTest::averageIfEmpty;
            this.payloads.median = ImmutableLongArrayStackTest::median;
            this.payloads.medianIfEmpty = ImmutableLongArrayStackTest::medianIfEmpty;
            this.payloads.toArray = ImmutableLongArrayStackTest::toArray;
            this.payloads.toArrayWithTargetArray = ImmutableLongArrayStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableLongArrayStackTest::toSortedArray;
            this.payloads.testEquals = ImmutableLongArrayStackTest::testEquals;
            this.payloads.testHashCode = ImmutableLongArrayStackTest::testHashCode;
            this.payloads.toSortedList = ImmutableLongArrayStackTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableLongArrayStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableLongArrayStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableLongArrayStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableLongArrayStackTest::toSet;
            this.payloads.toBag = ImmutableLongArrayStackTest::toBag;
            this.payloads.asLazy = ImmutableLongArrayStackTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableLongArrayStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableLongArrayStackTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableLongArrayStackTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableLongArrayStackTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableLongArrayStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableLongArrayStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableLongArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableLongArrayStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableLongArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableLongArrayStackTest::reduceIfEmpty;
            this.payloads.longIterator = ImmutableLongArrayStackTest::longIterator;
            this.payloads.peek = ImmutableLongArrayStackTest::peek;
            this.payloads.peekAtIndex = ImmutableLongArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.detectIfNone = ImmutableLongArrayStackTest::detectIfNone;
            this.payloads.selectWithIndex = ImmutableLongArrayStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableLongArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableLongArrayStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableLongArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableLongArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableLongArrayStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = ImmutableLongArrayStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.push = ImmutableLongArrayStackTest::push;
            this.payloads.pop = ImmutableLongArrayStackTest::pop;
            this.payloads.popWithCount = ImmutableLongArrayStackTest::popWithCount;
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = ImmutableLongArrayStackTest::testToString;
            this.payloads.makeString = ImmutableLongArrayStackTest::makeString;
            this.payloads.appendString = ImmutableLongArrayStackTest::appendString;
            this.payloads.toList = ImmutableLongArrayStackTest::toList;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toImmutable = ImmutableLongArrayStackTest::toImmutable;
            this.payloads.testNewStack_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayStackTest::testNewStack_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newWithIterable = ImmutableLongArrayStackTest::newWithIterable;
            this.payloads.newWithTopToBottom = ImmutableLongArrayStackTest::newWithTopToBottom;
            this.payloads.injectInto = ImmutableLongArrayStackTest::injectInto;
        }
    }
}
