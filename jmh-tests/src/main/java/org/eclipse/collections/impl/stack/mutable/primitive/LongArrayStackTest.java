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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import org.eclipse.collections.impl.factory.primitive.LongStacks;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class LongArrayStackTest extends AbstractMutableLongStackTestCase {

    @Override
    protected MutableLongStack classUnderTest() {
        return LongArrayStack.newStackWith(1L, 2L, 3L);
    }

    @Override
    protected MutableLongStack newWith(long... elements) {
        return LongArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableLongStack newMutableCollectionWith(long... elements) {
        return LongArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableLongStack newWithTopToBottom(long... elements) {
        return LongArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableLongStack newWithIterableTopToBottom(LongIterable iterable) {
        return LongArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableLongStack newWithIterable(LongIterable iterable) {
        return LongArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Long> newObjectCollectionWith(Long... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        LongArrayStack stack = LongArrayStack.newStackFromTopToBottom();
        stack.push(1L);
        Assert.assertEquals(1L, stack.peek());
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L), stack);
        stack.push(2L);
        Assert.assertEquals(2L, stack.peek());
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(2L, 1L), stack);
        stack.push(3L);
        Assert.assertEquals(3L, stack.peek());
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(3L, 2L, 1L), stack);
        Assert.assertEquals(2L, stack.peekAt(1));
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.peek());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.peek());
        Assert.assertEquals(1L, stack.pop());
        LongArrayStack stack2 = LongArrayStack.newStackFromTopToBottom(5L, 4L, 3L, 2L, 1L);
        stack2.pop(2);
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(3L, 2L, 1L), stack2);
        Assert.assertEquals(LongArrayList.newListWith(3L, 2L), stack2.peek(2));
        LongArrayStack stack8 = LongArrayStack.newStackFromTopToBottom(1L, 2L, 3L, 4L);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L, 3L, 4L), stack8);
        Assert.assertEquals(new LongArrayList(), stack8.peek(0));
        LongArrayStack stack9 = LongArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new LongArrayList(), stack9.pop(0));
        Assert.assertEquals(new LongArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongArrayStackTest instance;

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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_less_than_zero_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_less_than_zero_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_greater_than_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_greater_than_size_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_equal_to_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_equal_to_size_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peekWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekWithCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_empty_stack_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_empty_stack_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackWithOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackWithOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackIterableOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewStackFromTopToBottomIterableOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewStackFromTopToBottomIterableOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_push() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.push);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_popWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.popWithCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_empty_stack_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_empty_stack_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_negative_count_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_negative_count_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_count_greater_than_stack_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_count_greater_than_stack_size_throws_exception);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPushPopAndPeek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPushPopAndPeek);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new LongArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> testPushPopAndPeek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayStackTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = LongArrayStackTest::newCollectionWith;
            this.payloads.newCollection = LongArrayStackTest::newCollection;
            this.payloads.isEmpty = LongArrayStackTest::isEmpty;
            this.payloads.notEmpty = LongArrayStackTest::notEmpty;
            this.payloads.tap = LongArrayStackTest::tap;
            this.payloads.contains = LongArrayStackTest::contains;
            this.payloads.containsAllArray = LongArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = LongArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = LongArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = LongArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = LongArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = LongArrayStackTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = LongArrayStackTest::forEach;
            this.payloads.size = LongArrayStackTest::size;
            this.payloads.count = LongArrayStackTest::count;
            this.payloads.anySatisfy = LongArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = LongArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = LongArrayStackTest::noneSatisfy;
            this.payloads.collect = LongArrayStackTest::collect;
            this.payloads.collectWithTarget = LongArrayStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = LongArrayStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = LongArrayStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = LongArrayStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = LongArrayStackTest::collectPrimitivesToSets;
            this.payloads.select = LongArrayStackTest::select;
            this.payloads.selectWithTarget = LongArrayStackTest::selectWithTarget;
            this.payloads.reject = LongArrayStackTest::reject;
            this.payloads.rejectWithTarget = LongArrayStackTest::rejectWithTarget;
            this.payloads.max = LongArrayStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = LongArrayStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongArrayStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongArrayStackTest::maxIfEmpty;
            this.payloads.sum = LongArrayStackTest::sum;
            this.payloads.summaryStatistics = LongArrayStackTest::summaryStatistics;
            this.payloads.average = LongArrayStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = LongArrayStackTest::averageIfEmpty;
            this.payloads.median = LongArrayStackTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = LongArrayStackTest::medianIfEmpty;
            this.payloads.toArray = LongArrayStackTest::toArray;
            this.payloads.toArrayWithTargetArray = LongArrayStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = LongArrayStackTest::toSortedArray;
            this.payloads.testEquals = LongArrayStackTest::testEquals;
            this.payloads.testHashCode = LongArrayStackTest::testHashCode;
            this.payloads.toSortedList = LongArrayStackTest::toSortedList;
            this.payloads.toSortedListByComparator = LongArrayStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = LongArrayStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = LongArrayStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = LongArrayStackTest::toSet;
            this.payloads.toBag = LongArrayStackTest::toBag;
            this.payloads.asLazy = LongArrayStackTest::asLazy;
            this.payloads.injectInto = LongArrayStackTest::injectInto;
            this.payloads.injectIntoBoolean = LongArrayStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = LongArrayStackTest::injectIntoByte;
            this.payloads.injectIntoChar = LongArrayStackTest::injectIntoChar;
            this.payloads.injectIntoShort = LongArrayStackTest::injectIntoShort;
            this.payloads.injectIntoInt = LongArrayStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = LongArrayStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = LongArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = LongArrayStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = LongArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = LongArrayStackTest::reduceIfEmpty;
            this.payloads.longIterator = LongArrayStackTest::longIterator;
            this.payloads.peekAtIndex = LongArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = LongArrayStackTest::testToString;
            this.payloads.toList = LongArrayStackTest::toList;
            this.payloads.makeString = LongArrayStackTest::makeString;
            this.payloads.detectIfNone = LongArrayStackTest::detectIfNone;
            this.payloads.appendString = LongArrayStackTest::appendString;
            this.payloads.toImmutable = LongArrayStackTest::toImmutable;
            this.payloads.selectWithIndex = LongArrayStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = LongArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = LongArrayStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = LongArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = LongArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = LongArrayStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = LongArrayStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.peek = LongArrayStackTest::peek;
            this.payloads.peekWithCount = LongArrayStackTest::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = LongArrayStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = LongArrayStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = LongArrayStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = LongArrayStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = LongArrayStackTest::push;
            this.payloads.pop = LongArrayStackTest::pop;
            this.payloads.popWithCount = LongArrayStackTest::popWithCount;
            this.payloads.clear = LongArrayStackTest::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asSynchronized = LongArrayStackTest::asSynchronized;
            this.payloads.asUnmodifiable = LongArrayStackTest::asUnmodifiable;
            this.payloads.newEmpty = LongArrayStackTest::newEmpty;
            this.payloads.testPushPopAndPeek = LongArrayStackTest::testPushPopAndPeek;
            this.payloads.classIsNonInstantiable = LongArrayStackTest::classIsNonInstantiable;
        }
    }
}
