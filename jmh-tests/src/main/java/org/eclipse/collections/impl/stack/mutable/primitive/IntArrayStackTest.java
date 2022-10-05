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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.eclipse.collections.impl.factory.primitive.IntStacks;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class IntArrayStackTest extends AbstractMutableIntStackTestCase {

    @Override
    protected MutableIntStack classUnderTest() {
        return IntArrayStack.newStackWith(1, 2, 3);
    }

    @Override
    protected MutableIntStack newWith(int... elements) {
        return IntArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableIntStack newMutableCollectionWith(int... elements) {
        return IntArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableIntStack newWithTopToBottom(int... elements) {
        return IntArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableIntStack newWithIterableTopToBottom(IntIterable iterable) {
        return IntArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableIntStack newWithIterable(IntIterable iterable) {
        return IntArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Integer> newObjectCollectionWith(Integer... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        IntArrayStack stack = IntArrayStack.newStackFromTopToBottom();
        stack.push(1);
        Assert.assertEquals(1, stack.peek());
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1), stack);
        stack.push(2);
        Assert.assertEquals(2, stack.peek());
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(2, 1), stack);
        stack.push(3);
        Assert.assertEquals(3, stack.peek());
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(3, 2, 1), stack);
        Assert.assertEquals(2, stack.peekAt(1));
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.peek());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.peek());
        Assert.assertEquals(1, stack.pop());
        IntArrayStack stack2 = IntArrayStack.newStackFromTopToBottom(5, 4, 3, 2, 1);
        stack2.pop(2);
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(3, 2, 1), stack2);
        Assert.assertEquals(IntArrayList.newListWith(3, 2), stack2.peek(2));
        IntArrayStack stack8 = IntArrayStack.newStackFromTopToBottom(1, 2, 3, 4);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2, 3, 4), stack8);
        Assert.assertEquals(new IntArrayList(), stack8.peek(0));
        IntArrayStack stack9 = IntArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new IntArrayList(), stack9.pop(0));
        Assert.assertEquals(new IntArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntArrayStackTest instance;

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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
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
        public void benchmark_testPushPopAndPeek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPushPopAndPeek);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new IntArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> testPushPopAndPeek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayStackTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = IntArrayStackTest::newCollectionWith;
            this.payloads.newCollection = IntArrayStackTest::newCollection;
            this.payloads.isEmpty = IntArrayStackTest::isEmpty;
            this.payloads.notEmpty = IntArrayStackTest::notEmpty;
            this.payloads.tap = IntArrayStackTest::tap;
            this.payloads.contains = IntArrayStackTest::contains;
            this.payloads.containsAllArray = IntArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = IntArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = IntArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = IntArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = IntArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = IntArrayStackTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = IntArrayStackTest::forEach;
            this.payloads.size = IntArrayStackTest::size;
            this.payloads.count = IntArrayStackTest::count;
            this.payloads.anySatisfy = IntArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = IntArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = IntArrayStackTest::noneSatisfy;
            this.payloads.collect = IntArrayStackTest::collect;
            this.payloads.collectWithTarget = IntArrayStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = IntArrayStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = IntArrayStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = IntArrayStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = IntArrayStackTest::collectPrimitivesToSets;
            this.payloads.select = IntArrayStackTest::select;
            this.payloads.selectWithTarget = IntArrayStackTest::selectWithTarget;
            this.payloads.reject = IntArrayStackTest::reject;
            this.payloads.rejectWithTarget = IntArrayStackTest::rejectWithTarget;
            this.payloads.max = IntArrayStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = IntArrayStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntArrayStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntArrayStackTest::maxIfEmpty;
            this.payloads.sum = IntArrayStackTest::sum;
            this.payloads.summaryStatistics = IntArrayStackTest::summaryStatistics;
            this.payloads.average = IntArrayStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = IntArrayStackTest::averageIfEmpty;
            this.payloads.median = IntArrayStackTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = IntArrayStackTest::medianIfEmpty;
            this.payloads.toArray = IntArrayStackTest::toArray;
            this.payloads.toArrayWithTargetArray = IntArrayStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = IntArrayStackTest::toSortedArray;
            this.payloads.testEquals = IntArrayStackTest::testEquals;
            this.payloads.testHashCode = IntArrayStackTest::testHashCode;
            this.payloads.toSortedList = IntArrayStackTest::toSortedList;
            this.payloads.toSortedListByComparator = IntArrayStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = IntArrayStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = IntArrayStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = IntArrayStackTest::toSet;
            this.payloads.toBag = IntArrayStackTest::toBag;
            this.payloads.asLazy = IntArrayStackTest::asLazy;
            this.payloads.injectInto = IntArrayStackTest::injectInto;
            this.payloads.injectIntoBoolean = IntArrayStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = IntArrayStackTest::injectIntoByte;
            this.payloads.injectIntoChar = IntArrayStackTest::injectIntoChar;
            this.payloads.injectIntoShort = IntArrayStackTest::injectIntoShort;
            this.payloads.injectIntoInt = IntArrayStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = IntArrayStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = IntArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = IntArrayStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = IntArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = IntArrayStackTest::reduceIfEmpty;
            this.payloads.intIterator = IntArrayStackTest::intIterator;
            this.payloads.peekAtIndex = IntArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = IntArrayStackTest::testToString;
            this.payloads.toList = IntArrayStackTest::toList;
            this.payloads.makeString = IntArrayStackTest::makeString;
            this.payloads.detectIfNone = IntArrayStackTest::detectIfNone;
            this.payloads.appendString = IntArrayStackTest::appendString;
            this.payloads.toImmutable = IntArrayStackTest::toImmutable;
            this.payloads.selectWithIndex = IntArrayStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = IntArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = IntArrayStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = IntArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = IntArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = IntArrayStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = IntArrayStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.peek = IntArrayStackTest::peek;
            this.payloads.peekWithCount = IntArrayStackTest::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = IntArrayStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = IntArrayStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = IntArrayStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = IntArrayStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = IntArrayStackTest::push;
            this.payloads.pop = IntArrayStackTest::pop;
            this.payloads.popWithCount = IntArrayStackTest::popWithCount;
            this.payloads.clear = IntArrayStackTest::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asSynchronized = IntArrayStackTest::asSynchronized;
            this.payloads.asUnmodifiable = IntArrayStackTest::asUnmodifiable;
            this.payloads.newEmpty = IntArrayStackTest::newEmpty;
            this.payloads.testPushPopAndPeek = IntArrayStackTest::testPushPopAndPeek;
            this.payloads.classIsNonInstantiable = IntArrayStackTest::classIsNonInstantiable;
        }
    }
}
