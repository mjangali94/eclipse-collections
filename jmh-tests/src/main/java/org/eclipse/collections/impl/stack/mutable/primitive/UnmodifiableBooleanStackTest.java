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

import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.stack.primitive.MutableBooleanStack;
import org.eclipse.collections.impl.stack.primitive.AbstractBooleanStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableBooleanStack}.
 */
public class UnmodifiableBooleanStackTest extends AbstractBooleanStackTestCase {

    @Override
    protected UnmodifiableBooleanStack classUnderTest() {
        return new UnmodifiableBooleanStack(BooleanArrayStack.newStackWith(true, false, true, false));
    }

    @Override
    protected UnmodifiableBooleanStack newWith(boolean... elements) {
        return new UnmodifiableBooleanStack(BooleanArrayStack.newStackWith(elements));
    }

    @Override
    protected UnmodifiableBooleanStack newMutableCollectionWith(boolean... elements) {
        return new UnmodifiableBooleanStack(BooleanArrayStack.newStackWith(elements));
    }

    @Override
    protected UnmodifiableBooleanStack newWithTopToBottom(boolean... elements) {
        return new UnmodifiableBooleanStack(BooleanArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push() {
        MutableBooleanStack stack = new UnmodifiableBooleanStack(BooleanArrayStack.newStackFromTopToBottom(true, true, false, true, false));
        stack.push(true);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void pop() {
        MutableBooleanStack stack = new UnmodifiableBooleanStack(BooleanArrayStack.newStackFromTopToBottom(true, true, false, true, false));
        stack.pop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void popWithCount() {
        MutableBooleanStack stack = new UnmodifiableBooleanStack(BooleanArrayStack.newStackFromTopToBottom(true, true, false, true, false));
        stack.pop(2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Test
    public void asUnmodifiable() {
        MutableBooleanStack stack1 = new UnmodifiableBooleanStack(BooleanArrayStack.newStackWith(true, false, true));
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        MutableBooleanStack stack1 = new UnmodifiableBooleanStack(BooleanArrayStack.newStackWith(true, false, true));
        Verify.assertInstanceOf(SynchronizedBooleanStack.class, stack1.asSynchronized());
    }

    @Test
    public void booleanIterator_with_remove() {
        MutableBooleanIterator booleanIterator = (MutableBooleanIterator) this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        booleanIterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableBooleanIterator booleanIterator = (MutableBooleanIterator) this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableBooleanStackTest instance;

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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableBooleanStackTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanStackTest> iterator_throws_on_invocation_of_remove_before_next;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableBooleanStackTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableBooleanStackTest::newCollection;
            this.payloads.isEmpty = UnmodifiableBooleanStackTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableBooleanStackTest::notEmpty;
            this.payloads.contains = UnmodifiableBooleanStackTest::contains;
            this.payloads.containsAllArray = UnmodifiableBooleanStackTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableBooleanStackTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableBooleanStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableBooleanStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableBooleanStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableBooleanStackTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableBooleanStackTest::forEach;
            this.payloads.size = UnmodifiableBooleanStackTest::size;
            this.payloads.count = UnmodifiableBooleanStackTest::count;
            this.payloads.anySatisfy = UnmodifiableBooleanStackTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableBooleanStackTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableBooleanStackTest::noneSatisfy;
            this.payloads.select = UnmodifiableBooleanStackTest::select;
            this.payloads.reject = UnmodifiableBooleanStackTest::reject;
            this.payloads.detectIfNone = UnmodifiableBooleanStackTest::detectIfNone;
            this.payloads.collect = UnmodifiableBooleanStackTest::collect;
            this.payloads.injectInto = UnmodifiableBooleanStackTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableBooleanStackTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableBooleanStackTest::reduceIfEmpty;
            this.payloads.toArray = UnmodifiableBooleanStackTest::toArray;
            this.payloads.testEquals = UnmodifiableBooleanStackTest::testEquals;
            this.payloads.testHashCode = UnmodifiableBooleanStackTest::testHashCode;
            this.payloads.toSet = UnmodifiableBooleanStackTest::toSet;
            this.payloads.toBag = UnmodifiableBooleanStackTest::toBag;
            this.payloads.asLazy = UnmodifiableBooleanStackTest::asLazy;
            this.payloads.booleanIterator = UnmodifiableBooleanStackTest::booleanIterator;
            this.payloads.peek = UnmodifiableBooleanStackTest::peek;
            this.payloads.peekAtIndex = UnmodifiableBooleanStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = UnmodifiableBooleanStackTest::testToString;
            this.payloads.toList = UnmodifiableBooleanStackTest::toList;
            this.payloads.makeString = UnmodifiableBooleanStackTest::makeString;
            this.payloads.appendString = UnmodifiableBooleanStackTest::appendString;
            this.payloads.toImmutable = UnmodifiableBooleanStackTest::toImmutable;
            this.payloads.push = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::push, java.lang.UnsupportedOperationException.class);
            this.payloads.pop = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::pop, java.lang.UnsupportedOperationException.class);
            this.payloads.popWithCount = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::popWithCount, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanStackTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableBooleanStackTest::asUnmodifiable;
            this.payloads.asSynchronized = UnmodifiableBooleanStackTest::asSynchronized;
            this.payloads.booleanIterator_with_remove = UnmodifiableBooleanStackTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableBooleanStackTest::iterator_throws_on_invocation_of_remove_before_next;
        }
    }
}
