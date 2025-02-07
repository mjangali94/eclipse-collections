/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.immutable.primitive;

import java.util.EmptyStackException;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.stack.primitive.ImmutableBooleanStack;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableBooleanEmptyStack}.
 */
public class ImmutableBooleanEmptyStackTest extends AbstractImmutableBooleanStackTestCase {

    @Override
    protected ImmutableBooleanStack classUnderTest() {
        return ImmutableBooleanEmptyStack.INSTANCE;
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void pop() {
        this.classUnderTest().pop();
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception() {
        this.classUnderTest().pop(1);
    }

    @Override
    @Test
    public void popWithCount() {
        ImmutableBooleanStack stack = this.classUnderTest();
        ImmutableBooleanStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void booleanIterator() {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void peek() {
        this.classUnderTest().peek();
    }

    @Test
    public void peekWithCount() {
        Assert.assertEquals(BooleanArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertThrows(EmptyStackException.class, () -> this.classUnderTest().peek(1));
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void peek_at_index_equal_to_size_throws_exception() {
        this.classUnderTest().peekAt(0);
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void peek_at_index_greater_than_size_throws_exception() {
        this.classUnderTest().peekAt(1);
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newWith().notEmpty());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
    }

    @Test
    @Override
    public void testEquals() {
        super.testEquals();
        Verify.assertPostSerializedIdentity(this.classUnderTest());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableBooleanEmptyStackTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_peekAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_less_than_zero_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_less_than_zero_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_push() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.push);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_negative_count_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_negative_count_throws_exception);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pop_with_count_greater_than_stack_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pop_with_count_greater_than_stack_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_popWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.popWithCount);
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
        public void benchmark_peekWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peekWithCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_equal_to_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_equal_to_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_peek_at_index_greater_than_size_throws_exception() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.peek_at_index_greater_than_size_throws_exception);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableBooleanEmptyStackTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> push;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> pop_with_negative_count_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> pop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> pop_with_count_greater_than_stack_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> popWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> peekWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyStackTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableBooleanEmptyStackTest::newCollectionWith;
            this.payloads.newCollection = ImmutableBooleanEmptyStackTest::newCollection;
            this.payloads.contains = ImmutableBooleanEmptyStackTest::contains;
            this.payloads.containsAllArray = ImmutableBooleanEmptyStackTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableBooleanEmptyStackTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableBooleanEmptyStackTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableBooleanEmptyStackTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableBooleanEmptyStackTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableBooleanEmptyStackTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableBooleanEmptyStackTest::forEach;
            this.payloads.size = ImmutableBooleanEmptyStackTest::size;
            this.payloads.count = ImmutableBooleanEmptyStackTest::count;
            this.payloads.anySatisfy = ImmutableBooleanEmptyStackTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableBooleanEmptyStackTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableBooleanEmptyStackTest::noneSatisfy;
            this.payloads.select = ImmutableBooleanEmptyStackTest::select;
            this.payloads.reject = ImmutableBooleanEmptyStackTest::reject;
            this.payloads.detectIfNone = ImmutableBooleanEmptyStackTest::detectIfNone;
            this.payloads.collect = ImmutableBooleanEmptyStackTest::collect;
            this.payloads.injectInto = ImmutableBooleanEmptyStackTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableBooleanEmptyStackTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableBooleanEmptyStackTest::reduceIfEmpty;
            this.payloads.toArray = ImmutableBooleanEmptyStackTest::toArray;
            this.payloads.testHashCode = ImmutableBooleanEmptyStackTest::testHashCode;
            this.payloads.toSet = ImmutableBooleanEmptyStackTest::toSet;
            this.payloads.toBag = ImmutableBooleanEmptyStackTest::toBag;
            this.payloads.asLazy = ImmutableBooleanEmptyStackTest::asLazy;
            this.payloads.peekAtIndex = ImmutableBooleanEmptyStackTest::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.push = ImmutableBooleanEmptyStackTest::push;
            this.payloads.pop_with_negative_count_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::pop_with_negative_count_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = ImmutableBooleanEmptyStackTest::testToString;
            this.payloads.makeString = ImmutableBooleanEmptyStackTest::makeString;
            this.payloads.appendString = ImmutableBooleanEmptyStackTest::appendString;
            this.payloads.toList = ImmutableBooleanEmptyStackTest::toList;
            this.payloads.toImmutable = ImmutableBooleanEmptyStackTest::toImmutable;
            this.payloads.pop = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::pop, java.util.EmptyStackException.class);
            this.payloads.pop_with_count_greater_than_stack_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::pop_with_count_greater_than_stack_size_throws_exception, java.util.EmptyStackException.class);
            this.payloads.popWithCount = ImmutableBooleanEmptyStackTest::popWithCount;
            this.payloads.booleanIterator = ImmutableBooleanEmptyStackTest::booleanIterator;
            this.payloads.peek = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::peek, java.util.EmptyStackException.class);
            this.payloads.peekWithCount = ImmutableBooleanEmptyStackTest::peekWithCount;
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::peek_at_index_equal_to_size_throws_exception, java.util.EmptyStackException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyStackTest::peek_at_index_greater_than_size_throws_exception, java.util.EmptyStackException.class);
            this.payloads.notEmpty = ImmutableBooleanEmptyStackTest::notEmpty;
            this.payloads.isEmpty = ImmutableBooleanEmptyStackTest::isEmpty;
            this.payloads.testEquals = ImmutableBooleanEmptyStackTest::testEquals;
        }
    }
}
