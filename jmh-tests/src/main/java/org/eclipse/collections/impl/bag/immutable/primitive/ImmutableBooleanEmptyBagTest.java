/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableBooleanEmptyBag}.
 */
public class ImmutableBooleanEmptyBagTest extends AbstractImmutableBooleanBagTestCase {

    @Override
    protected final ImmutableBooleanBag classUnderTest() {
        return BooleanBags.immutable.of();
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
    }

    @Override
    @Test
    public void size() {
        Verify.assertSize(0, this.classUnderTest());
    }

    @Override
    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((argument1, argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("", string);
    }

    @Test
    public void occurrencesOf() {
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf(true));
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf(false));
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableBooleanBag bag = this.classUnderTest();
        ImmutableBooleanSet expected = BooleanSets.immutable.empty();
        ImmutableBooleanSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableBooleanEmptyBagTest instance;

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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableBooleanEmptyBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableBooleanEmptyBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableBooleanEmptyBagTest::newCollectionWith;
            this.payloads.newCollection = ImmutableBooleanEmptyBagTest::newCollection;
            this.payloads.contains = ImmutableBooleanEmptyBagTest::contains;
            this.payloads.containsAllArray = ImmutableBooleanEmptyBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableBooleanEmptyBagTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableBooleanEmptyBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableBooleanEmptyBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableBooleanEmptyBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableBooleanEmptyBagTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyBagTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyBagTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableBooleanEmptyBagTest::forEach;
            this.payloads.count = ImmutableBooleanEmptyBagTest::count;
            this.payloads.select = ImmutableBooleanEmptyBagTest::select;
            this.payloads.reject = ImmutableBooleanEmptyBagTest::reject;
            this.payloads.detectIfNone = ImmutableBooleanEmptyBagTest::detectIfNone;
            this.payloads.injectInto = ImmutableBooleanEmptyBagTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableBooleanEmptyBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableBooleanEmptyBagTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableBooleanEmptyBagTest::reduceIfEmpty;
            this.payloads.toArray = ImmutableBooleanEmptyBagTest::toArray;
            this.payloads.toSet = ImmutableBooleanEmptyBagTest::toSet;
            this.payloads.toBag = ImmutableBooleanEmptyBagTest::toBag;
            this.payloads.asLazy = ImmutableBooleanEmptyBagTest::asLazy;
            this.payloads.testNewWith = ImmutableBooleanEmptyBagTest::testNewWith;
            this.payloads.newWithAll = ImmutableBooleanEmptyBagTest::newWithAll;
            this.payloads.newWithout = ImmutableBooleanEmptyBagTest::newWithout;
            this.payloads.newWithoutAll = ImmutableBooleanEmptyBagTest::newWithoutAll;
            this.payloads.sizeDistinct = ImmutableBooleanEmptyBagTest::sizeDistinct;
            this.payloads.booleanIterator = ImmutableBooleanEmptyBagTest::booleanIterator;
            this.payloads.anySatisfy = ImmutableBooleanEmptyBagTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableBooleanEmptyBagTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableBooleanEmptyBagTest::noneSatisfy;
            this.payloads.collect = ImmutableBooleanEmptyBagTest::collect;
            this.payloads.testEquals = ImmutableBooleanEmptyBagTest::testEquals;
            this.payloads.testHashCode = ImmutableBooleanEmptyBagTest::testHashCode;
            this.payloads.testToString = ImmutableBooleanEmptyBagTest::testToString;
            this.payloads.makeString = ImmutableBooleanEmptyBagTest::makeString;
            this.payloads.appendString = ImmutableBooleanEmptyBagTest::appendString;
            this.payloads.toList = ImmutableBooleanEmptyBagTest::toList;
            this.payloads.toImmutable = ImmutableBooleanEmptyBagTest::toImmutable;
            this.payloads.notEmpty = ImmutableBooleanEmptyBagTest::notEmpty;
            this.payloads.isEmpty = ImmutableBooleanEmptyBagTest::isEmpty;
            this.payloads.size = ImmutableBooleanEmptyBagTest::size;
            this.payloads.forEachWithOccurrences = ImmutableBooleanEmptyBagTest::forEachWithOccurrences;
            this.payloads.occurrencesOf = ImmutableBooleanEmptyBagTest::occurrencesOf;
            this.payloads.selectUnique = ImmutableBooleanEmptyBagTest::selectUnique;
        }
    }
}
