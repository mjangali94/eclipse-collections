/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableBooleanEmptyListTest extends AbstractImmutableBooleanListTestCase {

    @Override
    protected ImmutableBooleanList classUnderTest() {
        return ImmutableBooleanEmptyList.INSTANCE;
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableBooleanList emptyList = this.newWith();
        ImmutableBooleanList newList = emptyList.newWithout(true);
        Assert.assertEquals(this.newWith(), newList);
        Assert.assertSame(emptyList, newList);
        Assert.assertEquals(this.newMutableCollectionWith(), emptyList);
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        this.classUnderTest().get(0);
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst() {
        this.classUnderTest().getFirst();
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast() {
        this.classUnderTest().getLast();
    }

    @Override
    @Test
    public void indexOf() {
        Assert.assertEquals(-1L, this.classUnderTest().indexOf(true));
        Assert.assertEquals(-1L, this.classUnderTest().indexOf(false));
    }

    @Override
    @Test
    public void lastIndexOf() {
        Assert.assertEquals(-1L, this.classUnderTest().lastIndexOf(true));
        Assert.assertEquals(-1L, this.classUnderTest().lastIndexOf(false));
    }

    @Override
    @Test
    public void forEachWithIndex() {
        String[] sum = new String[2];
        sum[0] = "";
        this.classUnderTest().forEachWithIndex((each, index) -> sum[0] += index + ":" + each);
        Assert.assertEquals("", sum[0]);
    }

    @Override
    @Test
    public void toReversed() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void select() {
        super.select();
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(BooleanPredicates.isTrue()));
        BooleanIterable booleanIterable = iterable.select(BooleanPredicates.isFalse());
        Verify.assertEmpty(booleanIterable);
        Assert.assertSame(iterable, booleanIterable);
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(BooleanPredicates.isTrue()));
        BooleanIterable booleanIterable = iterable.reject(BooleanPredicates.isFalse());
        Verify.assertEmpty(booleanIterable);
        Assert.assertSame(iterable, booleanIterable);
    }

    @Override
    @Test
    public void testEquals() {
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(false, false, false, true));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(true));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableBooleanEmptyListTest instance;

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
        public void benchmark_newWithOn64ElementCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithOn64ElementCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
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
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableBooleanEmptyListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> newWithOn64ElementCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyListTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableBooleanEmptyListTest::newCollectionWith;
            this.payloads.newCollection = ImmutableBooleanEmptyListTest::newCollection;
            this.payloads.contains = ImmutableBooleanEmptyListTest::contains;
            this.payloads.containsAllArray = ImmutableBooleanEmptyListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableBooleanEmptyListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableBooleanEmptyListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableBooleanEmptyListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableBooleanEmptyListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableBooleanEmptyListTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.size = ImmutableBooleanEmptyListTest::size;
            this.payloads.count = ImmutableBooleanEmptyListTest::count;
            this.payloads.anySatisfy = ImmutableBooleanEmptyListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableBooleanEmptyListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableBooleanEmptyListTest::noneSatisfy;
            this.payloads.detectIfNone = ImmutableBooleanEmptyListTest::detectIfNone;
            this.payloads.collect = ImmutableBooleanEmptyListTest::collect;
            this.payloads.injectInto = ImmutableBooleanEmptyListTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableBooleanEmptyListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableBooleanEmptyListTest::reduceIfEmpty;
            this.payloads.testHashCode = ImmutableBooleanEmptyListTest::testHashCode;
            this.payloads.toSet = ImmutableBooleanEmptyListTest::toSet;
            this.payloads.toBag = ImmutableBooleanEmptyListTest::toBag;
            this.payloads.asLazy = ImmutableBooleanEmptyListTest::asLazy;
            this.payloads.newWithOn64ElementCollection = ImmutableBooleanEmptyListTest::newWithOn64ElementCollection;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.booleanIterator = ImmutableBooleanEmptyListTest::booleanIterator;
            this.payloads.forEach = ImmutableBooleanEmptyListTest::forEach;
            this.payloads.toArray = ImmutableBooleanEmptyListTest::toArray;
            this.payloads.injectIntoWithIndex = ImmutableBooleanEmptyListTest::injectIntoWithIndex;
            this.payloads.testToString = ImmutableBooleanEmptyListTest::testToString;
            this.payloads.makeString = ImmutableBooleanEmptyListTest::makeString;
            this.payloads.appendString = ImmutableBooleanEmptyListTest::appendString;
            this.payloads.toList = ImmutableBooleanEmptyListTest::toList;
            this.payloads.testNewWith = ImmutableBooleanEmptyListTest::testNewWith;
            this.payloads.newWithAll = ImmutableBooleanEmptyListTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableBooleanEmptyListTest::newWithoutAll;
            this.payloads.newWithout = ImmutableBooleanEmptyListTest::newWithout;
            this.payloads.get = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::get, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::getFirst, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyListTest::getLast, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = ImmutableBooleanEmptyListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableBooleanEmptyListTest::lastIndexOf;
            this.payloads.forEachWithIndex = ImmutableBooleanEmptyListTest::forEachWithIndex;
            this.payloads.toReversed = ImmutableBooleanEmptyListTest::toReversed;
            this.payloads.isEmpty = ImmutableBooleanEmptyListTest::isEmpty;
            this.payloads.notEmpty = ImmutableBooleanEmptyListTest::notEmpty;
            this.payloads.select = ImmutableBooleanEmptyListTest::select;
            this.payloads.reject = ImmutableBooleanEmptyListTest::reject;
            this.payloads.testEquals = ImmutableBooleanEmptyListTest::testEquals;
        }
    }
}
