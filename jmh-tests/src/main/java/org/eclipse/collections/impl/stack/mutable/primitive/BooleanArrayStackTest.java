/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.stack.primitive.MutableBooleanStack;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanStackTestCase;
import org.eclipse.collections.impl.factory.primitive.BooleanStacks;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link BooleanArrayStack}.
 */
public class BooleanArrayStackTest extends AbstractMutableBooleanStackTestCase {

    @Override
    protected MutableBooleanStack classUnderTest() {
        return BooleanStacks.mutable.with(true, false, true, false);
    }

    @Override
    protected MutableBooleanStack newWith(boolean... elements) {
        return BooleanStacks.mutable.of(elements);
    }

    @Override
    protected MutableBooleanStack newMutableCollectionWith(boolean... elements) {
        return BooleanArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Object> newObjectCollectionWith(Object... elements) {
        return ArrayStack.newStackWith(elements);
    }

    @Override
    protected MutableBooleanStack newWithTopToBottom(boolean... elements) {
        return BooleanArrayStack.newStackFromTopToBottom(elements);
    }

    @Override
    protected MutableBooleanStack newWithIterableTopToBottom(BooleanIterable iterable) {
        return BooleanStacks.mutable.ofAllReversed(iterable);
    }

    @Override
    protected MutableBooleanStack newWithIterable(BooleanIterable iterable) {
        return BooleanStacks.mutable.ofAll(iterable);
    }

    @Test
    public void testPushPopAndPeek() {
        BooleanArrayStack stack = BooleanArrayStack.newStackFromTopToBottom();
        stack.push(true);
        Assert.assertTrue(stack.peek());
        Assert.assertEquals(BooleanArrayStack.newStackFromTopToBottom(true), stack);
        stack.push(false);
        Assert.assertFalse(stack.peek());
        Assert.assertEquals(BooleanArrayStack.newStackFromTopToBottom(false, true), stack);
        stack.push(true);
        Assert.assertTrue(stack.peek());
        Assert.assertEquals(BooleanArrayStack.newStackFromTopToBottom(true, false, true), stack);
        Assert.assertFalse(stack.peekAt(1));
        Assert.assertTrue(stack.pop());
        Assert.assertFalse(stack.peek());
        Assert.assertFalse(stack.pop());
        Assert.assertTrue(stack.peek());
        Assert.assertTrue(stack.pop());
        BooleanArrayStack stack2 = BooleanArrayStack.newStackFromTopToBottom(true, false, true, false, true);
        stack2.pop(2);
        Assert.assertEquals(BooleanArrayStack.newStackFromTopToBottom(true, false, true), stack2);
        Assert.assertEquals(BooleanArrayList.newListWith(true, false), stack2.peek(2));
        BooleanArrayStack stack8 = BooleanArrayStack.newStackFromTopToBottom(false, true, false, true);
        Verify.assertEmpty(stack8.pop(0));
        Assert.assertEquals(BooleanArrayStack.newStackFromTopToBottom(false, true, false, true), stack8);
        Assert.assertEquals(new BooleanArrayList(), stack8.peek(0));
        BooleanArrayStack stack9 = BooleanArrayStack.newStackFromTopToBottom();
        Assert.assertEquals(new BooleanArrayList(), stack9.pop(0));
        Assert.assertEquals(new BooleanArrayList(), stack9.peek(0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanArrayStackTest instance;

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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_testPushPopAndPeek() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPushPopAndPeek);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanArrayStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayStackTest> testPushPopAndPeek;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = BooleanArrayStackTest::newCollectionWith;
            this.payloads.newCollection = BooleanArrayStackTest::newCollection;
            this.payloads.isEmpty = BooleanArrayStackTest::isEmpty;
            this.payloads.notEmpty = BooleanArrayStackTest::notEmpty;
            this.payloads.contains = BooleanArrayStackTest::contains;
            this.payloads.containsAllArray = BooleanArrayStackTest::containsAllArray;
            this.payloads.containsAllIterable = BooleanArrayStackTest::containsAllIterable;
            this.payloads.containsAnyArray = BooleanArrayStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = BooleanArrayStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = BooleanArrayStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = BooleanArrayStackTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = BooleanArrayStackTest::forEach;
            this.payloads.size = BooleanArrayStackTest::size;
            this.payloads.count = BooleanArrayStackTest::count;
            this.payloads.anySatisfy = BooleanArrayStackTest::anySatisfy;
            this.payloads.allSatisfy = BooleanArrayStackTest::allSatisfy;
            this.payloads.noneSatisfy = BooleanArrayStackTest::noneSatisfy;
            this.payloads.select = BooleanArrayStackTest::select;
            this.payloads.reject = BooleanArrayStackTest::reject;
            this.payloads.detectIfNone = BooleanArrayStackTest::detectIfNone;
            this.payloads.collect = BooleanArrayStackTest::collect;
            this.payloads.injectInto = BooleanArrayStackTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = BooleanArrayStackTest::reduce;
            this.payloads.reduceIfEmpty = BooleanArrayStackTest::reduceIfEmpty;
            this.payloads.toArray = BooleanArrayStackTest::toArray;
            this.payloads.testEquals = BooleanArrayStackTest::testEquals;
            this.payloads.testHashCode = BooleanArrayStackTest::testHashCode;
            this.payloads.toSet = BooleanArrayStackTest::toSet;
            this.payloads.toBag = BooleanArrayStackTest::toBag;
            this.payloads.asLazy = BooleanArrayStackTest::asLazy;
            this.payloads.booleanIterator = BooleanArrayStackTest::booleanIterator;
            this.payloads.peekAtIndex = BooleanArrayStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = BooleanArrayStackTest::testToString;
            this.payloads.toList = BooleanArrayStackTest::toList;
            this.payloads.makeString = BooleanArrayStackTest::makeString;
            this.payloads.appendString = BooleanArrayStackTest::appendString;
            this.payloads.toImmutable = BooleanArrayStackTest::toImmutable;
            this.payloads.peek = BooleanArrayStackTest::peek;
            this.payloads.peekWithCount = BooleanArrayStackTest::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = BooleanArrayStackTest::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = BooleanArrayStackTest::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = BooleanArrayStackTest::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = BooleanArrayStackTest::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = BooleanArrayStackTest::push;
            this.payloads.pop = BooleanArrayStackTest::pop;
            this.payloads.popWithCount = BooleanArrayStackTest::popWithCount;
            this.payloads.clear = BooleanArrayStackTest::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asSynchronized = BooleanArrayStackTest::asSynchronized;
            this.payloads.asUnmodifiable = BooleanArrayStackTest::asUnmodifiable;
            this.payloads.testPushPopAndPeek = BooleanArrayStackTest::testPushPopAndPeek;
        }
    }
}
