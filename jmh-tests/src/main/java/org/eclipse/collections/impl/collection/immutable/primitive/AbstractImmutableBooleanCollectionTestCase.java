/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.immutable.primitive;

import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractBooleanIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableBooleanCollection}s.
 */
public abstract class AbstractImmutableBooleanCollectionTestCase extends AbstractBooleanIterableTestCase {

    @Override
    protected abstract ImmutableBooleanCollection classUnderTest();

    @Override
    protected abstract ImmutableBooleanCollection newWith(boolean... elements);

    @Override
    protected abstract MutableBooleanCollection newMutableCollectionWith(boolean... elements);

    protected void assertSizeAndOccurrences(ImmutableBooleanCollection collection, int expectedTrueCount, int expectedFalseCount) {
        int trueCount = 0;
        int falseCount = 0;
        for (boolean b : collection.toArray()) {
            if (b) {
                trueCount++;
            } else {
                falseCount++;
            }
        }
        Assert.assertEquals(expectedTrueCount, trueCount);
        Assert.assertEquals(expectedFalseCount, falseCount);
    }

    @Test
    public void testNewWith() {
        ImmutableBooleanCollection immutableCollection = this.newWith();
        ImmutableBooleanCollection collection = immutableCollection.newWith(true);
        ImmutableBooleanCollection collection0 = immutableCollection.newWith(true).newWith(false);
        ImmutableBooleanCollection collection1 = immutableCollection.newWith(true).newWith(false).newWith(true);
        ImmutableBooleanCollection collection2 = immutableCollection.newWith(true).newWith(false).newWith(true).newWith(false);
        ImmutableBooleanCollection collection3 = immutableCollection.newWith(true).newWith(false).newWith(true).newWith(false).newWith(true);
        this.assertSizeAndOccurrences(immutableCollection, 0, 0);
        this.assertSizeAndOccurrences(collection, 1, 0);
        this.assertSizeAndOccurrences(collection0, 1, 1);
        this.assertSizeAndOccurrences(collection1, 2, 1);
        this.assertSizeAndOccurrences(collection2, 2, 2);
        this.assertSizeAndOccurrences(collection3, 3, 2);
    }

    @Test
    public void newWithAll() {
        ImmutableBooleanCollection immutableCollection = this.newWith();
        ImmutableBooleanCollection collection = immutableCollection.newWithAll(this.newMutableCollectionWith(true));
        ImmutableBooleanCollection collection0 = collection.newWithAll(this.newMutableCollectionWith(false));
        ImmutableBooleanCollection collection1 = collection0.newWithAll(this.newMutableCollectionWith(true));
        ImmutableBooleanCollection collection2 = immutableCollection.newWithAll(this.newMutableCollectionWith(true, false, true, false));
        ImmutableBooleanCollection collection3 = immutableCollection.newWithAll(this.newMutableCollectionWith(true, false, true, false, true));
        this.assertSizeAndOccurrences(immutableCollection, 0, 0);
        this.assertSizeAndOccurrences(collection, 1, 0);
        this.assertSizeAndOccurrences(collection0, 1, 1);
        this.assertSizeAndOccurrences(collection1, 2, 1);
        this.assertSizeAndOccurrences(collection2, 2, 2);
        this.assertSizeAndOccurrences(collection3, 3, 2);
    }

    @Test
    public void newWithout() {
        ImmutableBooleanCollection collection3 = this.newWith(true, false, true, false, true);
        ImmutableBooleanCollection collection2 = collection3.newWithout(true);
        ImmutableBooleanCollection collection1 = collection2.newWithout(false);
        ImmutableBooleanCollection collection0 = collection1.newWithout(true);
        ImmutableBooleanCollection collection4 = collection0.newWithout(false);
        ImmutableBooleanCollection collection5 = collection4.newWithout(true);
        ImmutableBooleanCollection collection6 = collection5.newWithout(false);
        this.assertSizeAndOccurrences(collection6, 0, 0);
        this.assertSizeAndOccurrences(collection5, 0, 0);
        this.assertSizeAndOccurrences(collection4, 1, 0);
        this.assertSizeAndOccurrences(collection0, 1, 1);
        this.assertSizeAndOccurrences(collection1, 2, 1);
        this.assertSizeAndOccurrences(collection2, 2, 2);
    }

    @Test
    public void newWithoutAll() {
        ImmutableBooleanCollection collection3 = this.newWith(true, false, true, true);
        ImmutableBooleanCollection collection2 = collection3.newWithoutAll(this.newMutableCollectionWith(true));
        ImmutableBooleanCollection collection1 = collection2.newWithoutAll(this.newMutableCollectionWith(false));
        ImmutableBooleanCollection collection0 = collection1.newWithoutAll(this.newMutableCollectionWith(true));
        ImmutableBooleanCollection collection4 = collection0.newWithoutAll(this.newMutableCollectionWith(false));
        this.assertSizeAndOccurrences(collection2, 0, 1);
        this.assertSizeAndOccurrences(collection1, 0, 0);
        this.assertSizeAndOccurrences(collection0, 0, 0);
        this.assertSizeAndOccurrences(collection4, 0, 0);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableBooleanCollectionTestCase instance;

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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableBooleanCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanCollectionTestCase> newWithoutAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableBooleanCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableBooleanCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableBooleanCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableBooleanCollectionTestCase::notEmpty;
            this.payloads.contains = AbstractImmutableBooleanCollectionTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableBooleanCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableBooleanCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableBooleanCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableBooleanCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableBooleanCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableBooleanCollectionTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanCollectionTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanCollectionTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanCollectionTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.booleanIterator = AbstractImmutableBooleanCollectionTestCase::booleanIterator;
            this.payloads.forEach = AbstractImmutableBooleanCollectionTestCase::forEach;
            this.payloads.size = AbstractImmutableBooleanCollectionTestCase::size;
            this.payloads.count = AbstractImmutableBooleanCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableBooleanCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableBooleanCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableBooleanCollectionTestCase::noneSatisfy;
            this.payloads.select = AbstractImmutableBooleanCollectionTestCase::select;
            this.payloads.reject = AbstractImmutableBooleanCollectionTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableBooleanCollectionTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableBooleanCollectionTestCase::collect;
            this.payloads.injectInto = AbstractImmutableBooleanCollectionTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableBooleanCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableBooleanCollectionTestCase::reduceIfEmpty;
            this.payloads.toArray = AbstractImmutableBooleanCollectionTestCase::toArray;
            this.payloads.testEquals = AbstractImmutableBooleanCollectionTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableBooleanCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableBooleanCollectionTestCase::testToString;
            this.payloads.makeString = AbstractImmutableBooleanCollectionTestCase::makeString;
            this.payloads.appendString = AbstractImmutableBooleanCollectionTestCase::appendString;
            this.payloads.toList = AbstractImmutableBooleanCollectionTestCase::toList;
            this.payloads.toSet = AbstractImmutableBooleanCollectionTestCase::toSet;
            this.payloads.toBag = AbstractImmutableBooleanCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableBooleanCollectionTestCase::asLazy;
            this.payloads.testNewWith = AbstractImmutableBooleanCollectionTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableBooleanCollectionTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableBooleanCollectionTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableBooleanCollectionTestCase::newWithoutAll;
        }
    }
}
