/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedIntStackTest extends AbstractMutableIntStackTestCase {

    @Override
    protected MutableIntStack classUnderTest() {
        return new SynchronizedIntStack(IntArrayStack.newStackWith(1, 2, 3));
    }

    @Override
    protected MutableIntStack newWith(int... elements) {
        return new SynchronizedIntStack(IntArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableIntStack newWithTopToBottom(int... elements) {
        return new SynchronizedIntStack(IntArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableIntStack newMutableCollectionWith(int... elements) {
        return new SynchronizedIntStack(IntArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableIntStack newWithIterableTopToBottom(IntIterable iterable) {
        return new SynchronizedIntStack(IntArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableIntStack newWithIterable(IntIterable iterable) {
        return new SynchronizedIntStack(IntArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableIntStack stack1 = new SynchronizedIntStack(IntArrayStack.newStackWith(1, 2, 3), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedIntStackTest instance;

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
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekWithCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_empty_stack_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_empty_stack_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackWithOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackWithOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackIterableOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomIterableOrder);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_empty_stack_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_empty_stack_throws_exception);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedIntStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntStackTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedIntStackTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedIntStackTest::newCollection;
            this.payloads.isEmpty = SynchronizedIntStackTest::isEmpty;
            this.payloads.notEmpty = SynchronizedIntStackTest::notEmpty;
            this.payloads.tap = SynchronizedIntStackTest::tap;
            this.payloads.contains = SynchronizedIntStackTest::contains;
            this.payloads.containsAllArray = SynchronizedIntStackTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedIntStackTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedIntStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedIntStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedIntStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedIntStackTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedIntStackTest::forEach;
            this.payloads.size = SynchronizedIntStackTest::size;
            this.payloads.count = SynchronizedIntStackTest::count;
            this.payloads.anySatisfy = SynchronizedIntStackTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedIntStackTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedIntStackTest::noneSatisfy;
            this.payloads.collect = SynchronizedIntStackTest::collect;
            this.payloads.collectWithTarget = SynchronizedIntStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedIntStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedIntStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedIntStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedIntStackTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedIntStackTest::select;
            this.payloads.selectWithTarget = SynchronizedIntStackTest::selectWithTarget;
            this.payloads.reject = SynchronizedIntStackTest::reject;
            this.payloads.rejectWithTarget = SynchronizedIntStackTest::rejectWithTarget;
            this.payloads.max = SynchronizedIntStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedIntStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedIntStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedIntStackTest::maxIfEmpty;
            this.payloads.sum = SynchronizedIntStackTest::sum;
            this.payloads.summaryStatistics = SynchronizedIntStackTest::summaryStatistics;
            this.payloads.average = SynchronizedIntStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedIntStackTest::averageIfEmpty;
            this.payloads.median = SynchronizedIntStackTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedIntStackTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedIntStackTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedIntStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedIntStackTest::toSortedArray;
            this.payloads.testEquals = SynchronizedIntStackTest::testEquals;
            this.payloads.testHashCode = SynchronizedIntStackTest::testHashCode;
            this.payloads.toSortedList = SynchronizedIntStackTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedIntStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedIntStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedIntStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedIntStackTest::toSet;
            this.payloads.toBag = SynchronizedIntStackTest::toBag;
            this.payloads.asLazy = SynchronizedIntStackTest::asLazy;
            this.payloads.injectInto = SynchronizedIntStackTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedIntStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedIntStackTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedIntStackTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedIntStackTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedIntStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedIntStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedIntStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedIntStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedIntStackTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedIntStackTest::reduceIfEmpty;
            this.payloads.intIterator = SynchronizedIntStackTest::intIterator;
            this.payloads.peekAtIndex = SynchronizedIntStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = SynchronizedIntStackTest::testToString;
            this.payloads.toList = SynchronizedIntStackTest::toList;
            this.payloads.makeString = SynchronizedIntStackTest::makeString;
            this.payloads.detectIfNone = SynchronizedIntStackTest::detectIfNone;
            this.payloads.appendString = SynchronizedIntStackTest::appendString;
            this.payloads.toImmutable = SynchronizedIntStackTest::toImmutable;
            this.payloads.selectWithIndex = SynchronizedIntStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = SynchronizedIntStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = SynchronizedIntStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = SynchronizedIntStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = SynchronizedIntStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedIntStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = SynchronizedIntStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.peek = SynchronizedIntStackTest::peek;
            this.payloads.peekWithCount = SynchronizedIntStackTest::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = SynchronizedIntStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = SynchronizedIntStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = SynchronizedIntStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = SynchronizedIntStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = SynchronizedIntStackTest::push;
            this.payloads.pop = SynchronizedIntStackTest::pop;
            this.payloads.popWithCount = SynchronizedIntStackTest::popWithCount;
            this.payloads.clear = SynchronizedIntStackTest::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asUnmodifiable = SynchronizedIntStackTest::asUnmodifiable;
            this.payloads.newEmpty = SynchronizedIntStackTest::newEmpty;
            this.payloads.asSynchronized = SynchronizedIntStackTest::asSynchronized;
        }
    }
}
