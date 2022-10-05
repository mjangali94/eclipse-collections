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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;
import org.eclipse.collections.impl.factory.primitive.ByteStacks;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteArrayStack}.
 * This file was automatically generated from template file primitiveArrayStackTest.stg.
 */
public class ByteArrayStackTest extends AbstractMutableByteStackTestCase {

    @Override
    protected MutableByteStack classUnderTest() {
        return ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    protected MutableByteStack newWith(byte... elements) {
        return ByteArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableByteStack newMutableCollectionWith(byte... elements) {
        return ByteArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableByteStack newWithTopToBottom(byte... elements) {
        return ByteArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableByteStack newWithIterableTopToBottom(ByteIterable iterable) {
        return ByteArrayStack.newStackFromTopToBottom(iterable);
    }

    @Override
    protected MutableByteStack newWithIterable(ByteIterable iterable) {
        return ByteArrayStack.newStack(iterable);
    }

    @Override
    protected RichIterable<Byte> newObjectCollectionWith(Byte... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Test
    public void testPushPopAndPeek() {
        ByteArrayStack stack = ByteArrayStack.newStackFromTopToBottom();
        stack.push((byte) 1);
        Assert.assertEquals((byte) 1, stack.peek());
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1), stack);
        stack.push((byte) 2);
        Assert.assertEquals((byte) 2, stack.peek());
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 2, (byte) 1), stack);
        stack.push((byte) 3);
        Assert.assertEquals((byte) 3, stack.peek());
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 3, (byte) 2, (byte) 1), stack);
        Assert.assertEquals((byte) 2, stack.peekAt(1));
        Assert.assertEquals((byte) 3, stack.pop());
        Assert.assertEquals((byte) 2, stack.peek());
        Assert.assertEquals((byte) 2, stack.pop());
        Assert.assertEquals((byte) 1, stack.peek());
        Assert.assertEquals((byte) 1, stack.pop());
        ByteArrayStack stack2 = ByteArrayStack.newStackFromTopToBottom((byte) 5, (byte) 4, (byte) 3, (byte) 2, (byte) 1);
        stack2.pop(2);
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 3, (byte) 2, (byte) 1), stack2);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 2), stack2.peek(2));
        ByteArrayStack stack8 = ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        Verify.assertSize(0, stack8.pop(0));
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 3, (byte) 4), stack8);
        Assert.assertEquals(new ByteArrayList(), stack8.peek(0));
        ByteArrayStack stack9 = ByteArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new ByteArrayList(), stack9.pop(0));
        Assert.assertEquals(new ByteArrayList(), stack9.peek(0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteStacks.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteArrayStackTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new ByteArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> testPushPopAndPeek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayStackTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteArrayStackTest::newCollectionWith;
            this.payloads.newCollection = ByteArrayStackTest::newCollection;
            this.payloads.isEmpty = ByteArrayStackTest::isEmpty;
            this.payloads.notEmpty = ByteArrayStackTest::notEmpty;
            this.payloads.tap = ByteArrayStackTest::tap;
            this.payloads.contains = ByteArrayStackTest::contains;
            this.payloads.containsAllArray = ByteArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = ByteArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteArrayStackTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteArrayStackTest::forEach;
            this.payloads.size = ByteArrayStackTest::size;
            this.payloads.count = ByteArrayStackTest::count;
            this.payloads.anySatisfy = ByteArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = ByteArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = ByteArrayStackTest::noneSatisfy;
            this.payloads.collect = ByteArrayStackTest::collect;
            this.payloads.collectWithTarget = ByteArrayStackTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteArrayStackTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteArrayStackTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteArrayStackTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteArrayStackTest::collectPrimitivesToSets;
            this.payloads.select = ByteArrayStackTest::select;
            this.payloads.selectWithTarget = ByteArrayStackTest::selectWithTarget;
            this.payloads.reject = ByteArrayStackTest::reject;
            this.payloads.rejectWithTarget = ByteArrayStackTest::rejectWithTarget;
            this.payloads.max = ByteArrayStackTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ByteArrayStackTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteArrayStackTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteArrayStackTest::maxIfEmpty;
            this.payloads.sum = ByteArrayStackTest::sum;
            this.payloads.summaryStatistics = ByteArrayStackTest::summaryStatistics;
            this.payloads.average = ByteArrayStackTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteArrayStackTest::averageIfEmpty;
            this.payloads.median = ByteArrayStackTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteArrayStackTest::medianIfEmpty;
            this.payloads.toArray = ByteArrayStackTest::toArray;
            this.payloads.toArrayWithTargetArray = ByteArrayStackTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ByteArrayStackTest::toSortedArray;
            this.payloads.testEquals = ByteArrayStackTest::testEquals;
            this.payloads.testHashCode = ByteArrayStackTest::testHashCode;
            this.payloads.toSortedList = ByteArrayStackTest::toSortedList;
            this.payloads.toSortedListByComparator = ByteArrayStackTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteArrayStackTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteArrayStackTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteArrayStackTest::toSet;
            this.payloads.toBag = ByteArrayStackTest::toBag;
            this.payloads.asLazy = ByteArrayStackTest::asLazy;
            this.payloads.injectInto = ByteArrayStackTest::injectInto;
            this.payloads.injectIntoBoolean = ByteArrayStackTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteArrayStackTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteArrayStackTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteArrayStackTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteArrayStackTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteArrayStackTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteArrayStackTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteArrayStackTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = ByteArrayStackTest::reduceIfEmpty;
            this.payloads.byteIterator = ByteArrayStackTest::byteIterator;
            this.payloads.peekAtIndex = ByteArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = ByteArrayStackTest::testToString;
            this.payloads.toList = ByteArrayStackTest::toList;
            this.payloads.makeString = ByteArrayStackTest::makeString;
            this.payloads.detectIfNone = ByteArrayStackTest::detectIfNone;
            this.payloads.appendString = ByteArrayStackTest::appendString;
            this.payloads.toImmutable = ByteArrayStackTest::toImmutable;
            this.payloads.selectWithIndex = ByteArrayStackTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ByteArrayStackTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ByteArrayStackTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ByteArrayStackTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ByteArrayStackTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ByteArrayStackTest::collectWithIndexWithTarget;
            this.payloads.chunk = ByteArrayStackTest::chunk;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::getFirst, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::indexOf, java.lang.UnsupportedOperationException.class);
            this.payloads.injectIntoWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::injectIntoWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.forEachWithIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::forEachWithIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.peek = ByteArrayStackTest::peek;
            this.payloads.peekWithCount = ByteArrayStackTest::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = ByteArrayStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = ByteArrayStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = ByteArrayStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = ByteArrayStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = ByteArrayStackTest::push;
            this.payloads.pop = ByteArrayStackTest::pop;
            this.payloads.popWithCount = ByteArrayStackTest::popWithCount;
            this.payloads.clear = ByteArrayStackTest::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asSynchronized = ByteArrayStackTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteArrayStackTest::asUnmodifiable;
            this.payloads.newEmpty = ByteArrayStackTest::newEmpty;
            this.payloads.testPushPopAndPeek = ByteArrayStackTest::testPushPopAndPeek;
            this.payloads.classIsNonInstantiable = ByteArrayStackTest::classIsNonInstantiable;
        }
    }
}
