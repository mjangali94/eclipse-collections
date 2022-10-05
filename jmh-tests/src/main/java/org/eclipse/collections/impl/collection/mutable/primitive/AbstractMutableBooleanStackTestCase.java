/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.EmptyStackException;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.stack.primitive.MutableBooleanStack;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.stack.mutable.primitive.SynchronizedBooleanStack;
import org.eclipse.collections.impl.stack.mutable.primitive.UnmodifiableBooleanStack;
import org.eclipse.collections.impl.stack.primitive.AbstractBooleanStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableBooleanStack}.
 */
public abstract class AbstractMutableBooleanStackTestCase extends AbstractBooleanStackTestCase {

    @Override
    protected abstract MutableBooleanStack classUnderTest();

    @Override
    protected abstract MutableBooleanStack newWith(boolean... elements);

    @Override
    protected abstract MutableBooleanStack newMutableCollectionWith(boolean... elements);

    @Override
    protected abstract MutableBooleanStack newWithTopToBottom(boolean... elements);

    protected abstract MutableBooleanStack newWithIterableTopToBottom(BooleanIterable iterable);

    protected abstract MutableBooleanStack newWithIterable(BooleanIterable iterable);

    @Override
    public void peekAtIndex() {
        super.peekAtIndex();
        MutableBooleanStack stack = this.classUnderTest();
        stack.pop(2);
        Assert.assertEquals((this.classUnderTest().size() & 1) != 0, stack.peekAt(0));
    }

    @Override
    @Test
    public void peek() {
        super.peek();
        MutableBooleanStack stack = this.classUnderTest();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            Assert.assertEquals((i & 1) != 0, stack.peek());
            stack.pop();
        }
    }

    @Test
    public void peekWithCount() {
        MutableBooleanStack stack = this.classUnderTest();
        Assert.assertEquals(BooleanArrayList.newListWith(false, true), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(BooleanArrayList.newListWith(false), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception() {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder() {
        MutableBooleanStack stack = this.newWith(true, false, true, true);
        Assert.assertTrue(stack.pop());
        Assert.assertTrue(stack.pop());
        Assert.assertFalse(stack.pop());
        Assert.assertTrue(stack.pop());
    }

    @Test
    public void testNewStackIterableOrder() {
        MutableBooleanStack stack = this.newWithIterable(BooleanArrayList.newListWith(true, false, true, true));
        Assert.assertTrue(stack.pop());
        Assert.assertTrue(stack.pop());
        Assert.assertFalse(stack.pop());
        Assert.assertTrue(stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder() {
        MutableBooleanStack stack = this.newWithTopToBottom(false, true, true);
        Assert.assertFalse(stack.pop());
        Assert.assertTrue(stack.pop());
        Assert.assertTrue(stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder() {
        MutableBooleanStack stack = this.newWithIterableTopToBottom(BooleanArrayList.newListWith(false, true, true));
        Assert.assertFalse(stack.pop());
        Assert.assertTrue(stack.pop());
        Assert.assertTrue(stack.pop());
    }

    @Test
    public void push() {
        MutableBooleanStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push(true);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(BooleanArrayList.newListWith(false, true), stack.peek(2));
    }

    @Test
    public void pop() {
        MutableBooleanStack stack = this.classUnderTest();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Assert.assertEquals((i & 1) != 0, stack.pop());
            Verify.assertSize(size - i - 1, stack);
        }
    }

    @Test
    public void popWithCount() {
        MutableBooleanStack stack = this.classUnderTest();
        int size = this.classUnderTest().size();
        Assert.assertEquals(BooleanArrayList.newListWith((size & 1) != 0, (size & 1) == 0), stack.pop(2));
        Verify.assertSize(size - 2, stack);
    }

    @Test
    public void clear() {
        MutableBooleanStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableBooleanStack stack1 = this.newWith();
        Verify.assertSize(0, stack1);
        stack1.clear();
        Verify.assertSize(0, stack1);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_empty_stack_throws_exception() {
        this.newWith().pop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_negative_count_throws_exception() {
        this.newWith(true).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception() {
        this.newWith(false).pop(2);
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedBooleanStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableBooleanStack.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asUnmodifiable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableBooleanStackTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableBooleanStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> peek_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> testNewStackWithOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> testNewStackIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> testNewStackFromTopToBottomOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> testNewStackFromTopToBottomIterableOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> pop_empty_stack_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableBooleanStackTestCase> asUnmodifiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableBooleanStackTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableBooleanStackTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableBooleanStackTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableBooleanStackTestCase::notEmpty;
            this.payloads.contains = AbstractMutableBooleanStackTestCase::contains;
            this.payloads.containsAllArray = AbstractMutableBooleanStackTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableBooleanStackTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableBooleanStackTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableBooleanStackTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableBooleanStackTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableBooleanStackTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableBooleanStackTestCase::forEach;
            this.payloads.size = AbstractMutableBooleanStackTestCase::size;
            this.payloads.count = AbstractMutableBooleanStackTestCase::count;
            this.payloads.anySatisfy = AbstractMutableBooleanStackTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableBooleanStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableBooleanStackTestCase::noneSatisfy;
            this.payloads.select = AbstractMutableBooleanStackTestCase::select;
            this.payloads.reject = AbstractMutableBooleanStackTestCase::reject;
            this.payloads.detectIfNone = AbstractMutableBooleanStackTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableBooleanStackTestCase::collect;
            this.payloads.injectInto = AbstractMutableBooleanStackTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableBooleanStackTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableBooleanStackTestCase::reduceIfEmpty;
            this.payloads.toArray = AbstractMutableBooleanStackTestCase::toArray;
            this.payloads.testEquals = AbstractMutableBooleanStackTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableBooleanStackTestCase::testHashCode;
            this.payloads.toSet = AbstractMutableBooleanStackTestCase::toSet;
            this.payloads.toBag = AbstractMutableBooleanStackTestCase::toBag;
            this.payloads.asLazy = AbstractMutableBooleanStackTestCase::asLazy;
            this.payloads.booleanIterator = AbstractMutableBooleanStackTestCase::booleanIterator;
            this.payloads.peekAtIndex = AbstractMutableBooleanStackTestCase::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = AbstractMutableBooleanStackTestCase::testToString;
            this.payloads.toList = AbstractMutableBooleanStackTestCase::toList;
            this.payloads.makeString = AbstractMutableBooleanStackTestCase::makeString;
            this.payloads.appendString = AbstractMutableBooleanStackTestCase::appendString;
            this.payloads.toImmutable = AbstractMutableBooleanStackTestCase::toImmutable;
            this.payloads.peek = AbstractMutableBooleanStackTestCase::peek;
            this.payloads.peekWithCount = AbstractMutableBooleanStackTestCase::peekWithCount;
            this.payloads.peek_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::peek_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.testNewStackWithOrder = AbstractMutableBooleanStackTestCase::testNewStackWithOrder;
            this.payloads.testNewStackIterableOrder = AbstractMutableBooleanStackTestCase::testNewStackIterableOrder;
            this.payloads.testNewStackFromTopToBottomOrder = AbstractMutableBooleanStackTestCase::testNewStackFromTopToBottomOrder;
            this.payloads.testNewStackFromTopToBottomIterableOrder = AbstractMutableBooleanStackTestCase::testNewStackFromTopToBottomIterableOrder;
            this.payloads.push = AbstractMutableBooleanStackTestCase::push;
            this.payloads.pop = AbstractMutableBooleanStackTestCase::pop;
            this.payloads.popWithCount = AbstractMutableBooleanStackTestCase::popWithCount;
            this.payloads.clear = AbstractMutableBooleanStackTestCase::clear;
            this.payloads.pop_empty_stack_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::pop_empty_stack_throws_exception, java.util.EmptyStackException.class);
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableBooleanStackTestCase::pop_with_count_greater_than_stack_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.asSynchronized = AbstractMutableBooleanStackTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableBooleanStackTestCase::asUnmodifiable;
        }
    }
}
