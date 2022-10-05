/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stack.primitive;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.stack.primitive.BooleanStack;
import org.eclipse.collections.api.stack.primitive.ImmutableBooleanStack;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractBooleanIterableTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link BooleanStack}.
 */
public abstract class AbstractBooleanStackTestCase extends AbstractBooleanIterableTestCase {

    @Override
    protected abstract BooleanStack classUnderTest();

    @Override
    protected abstract BooleanStack newWith(boolean... elements);

    @Override
    protected abstract BooleanStack newMutableCollectionWith(boolean... elements);

    @Override
    protected RichIterable<Object> newObjectCollectionWith(Object... elements) {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract BooleanStack newWithTopToBottom(boolean... elements);

    @Override
    @Test
    public void booleanIterator() {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            Assert.assertTrue(iterator.hasNext());
            boolean sizeEven = (size & 1) == 0;
            boolean iEven = (i & 1) == 0;
            Assert.assertEquals(sizeEven != iEven, iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals((this.classUnderTest().size() & 1) != 0, this.classUnderTest().booleanIterator().next());
    }

    @Test
    public void peek() {
        Assert.assertEquals((this.classUnderTest().size() & 1) != 0, this.classUnderTest().peek());
        Assert.assertEquals(BooleanArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(BooleanArrayList.newListWith((this.classUnderTest().size() & 1) != 0, (this.classUnderTest().size() & 1) == 0), this.classUnderTest().peek(2));
    }

    @Test
    public void peekAtIndex() {
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            boolean sizeEven = (this.classUnderTest().size() & 1) == 0;
            boolean iEven = (i & 1) == 0;
            Assert.assertEquals(sizeEven != iEven, this.classUnderTest().peekAt(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_less_than_zero_throws_exception() {
        this.classUnderTest().peekAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_greater_than_size_throws_exception() {
        this.classUnderTest().peekAt(this.classUnderTest().size() + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_equal_to_size_throws_exception() {
        this.classUnderTest().peekAt(this.classUnderTest().size());
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals(this.createExpectedString("[", ", ", "]"), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBooleanList list = new BooleanArrayList();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            list.add((i & 1) != 0);
        }
        Assert.assertEquals(list, this.classUnderTest().toList());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals(this.createExpectedString("", ", ", ""), this.classUnderTest().makeString());
        Assert.assertEquals(this.createExpectedString("", "|", ""), this.classUnderTest().makeString("|"));
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), this.classUnderTest().makeString("{", "|", "}"));
    }

    protected String createExpectedString(String start, String sep, String end) {
        StringBuilder expectedString = new StringBuilder(start);
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            boolean sizeEven = (this.classUnderTest().size() & 1) == 0;
            boolean iEven = (i & 1) == 0;
            expectedString.append(sizeEven != iEven);
            expectedString.append(i == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.classUnderTest().appendString(appendable1);
        Assert.assertEquals(this.createExpectedString("", ", ", ""), appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2, "|");
        Assert.assertEquals(this.createExpectedString("", "|", ""), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "{", "|", "}");
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), appendable3.toString());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableBooleanStack.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractBooleanStackTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractBooleanStackTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> peek;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> peekAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> peek_at_index_less_than_zero_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> peek_at_index_greater_than_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> peek_at_index_equal_to_size_throws_exception;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanStackTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractBooleanStackTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractBooleanStackTestCase::newCollection;
            this.payloads.isEmpty = AbstractBooleanStackTestCase::isEmpty;
            this.payloads.notEmpty = AbstractBooleanStackTestCase::notEmpty;
            this.payloads.contains = AbstractBooleanStackTestCase::contains;
            this.payloads.containsAllArray = AbstractBooleanStackTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractBooleanStackTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractBooleanStackTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractBooleanStackTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractBooleanStackTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractBooleanStackTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanStackTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanStackTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanStackTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractBooleanStackTestCase::forEach;
            this.payloads.size = AbstractBooleanStackTestCase::size;
            this.payloads.count = AbstractBooleanStackTestCase::count;
            this.payloads.anySatisfy = AbstractBooleanStackTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractBooleanStackTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractBooleanStackTestCase::noneSatisfy;
            this.payloads.select = AbstractBooleanStackTestCase::select;
            this.payloads.reject = AbstractBooleanStackTestCase::reject;
            this.payloads.detectIfNone = AbstractBooleanStackTestCase::detectIfNone;
            this.payloads.collect = AbstractBooleanStackTestCase::collect;
            this.payloads.injectInto = AbstractBooleanStackTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanStackTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractBooleanStackTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractBooleanStackTestCase::reduceIfEmpty;
            this.payloads.toArray = AbstractBooleanStackTestCase::toArray;
            this.payloads.testEquals = AbstractBooleanStackTestCase::testEquals;
            this.payloads.testHashCode = AbstractBooleanStackTestCase::testHashCode;
            this.payloads.toSet = AbstractBooleanStackTestCase::toSet;
            this.payloads.toBag = AbstractBooleanStackTestCase::toBag;
            this.payloads.asLazy = AbstractBooleanStackTestCase::asLazy;
            this.payloads.booleanIterator = AbstractBooleanStackTestCase::booleanIterator;
            this.payloads.peek = AbstractBooleanStackTestCase::peek;
            this.payloads.peekAtIndex = AbstractBooleanStackTestCase::peekAtIndex;
            this.payloads.peek_at_index_less_than_zero_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanStackTestCase::peek_at_index_less_than_zero_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_greater_than_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanStackTestCase::peek_at_index_greater_than_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.peek_at_index_equal_to_size_throws_exception = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanStackTestCase::peek_at_index_equal_to_size_throws_exception, java.lang.IllegalArgumentException.class);
            this.payloads.testToString = AbstractBooleanStackTestCase::testToString;
            this.payloads.toList = AbstractBooleanStackTestCase::toList;
            this.payloads.makeString = AbstractBooleanStackTestCase::makeString;
            this.payloads.appendString = AbstractBooleanStackTestCase::appendString;
            this.payloads.toImmutable = AbstractBooleanStackTestCase::toImmutable;
        }
    }
}
