/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedBooleanSet}.
 */
public class SynchronizedBooleanSetTest extends AbstractBooleanSetTestCase {

    @Override
    protected SynchronizedBooleanSet classUnderTest() {
        return new SynchronizedBooleanSet(BooleanHashSet.newSetWith(true, false, true));
    }

    @Override
    protected SynchronizedBooleanSet newWith(boolean... elements) {
        return new SynchronizedBooleanSet(BooleanHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedBooleanSet set = this.classUnderTest();
        MutableBooleanSet setWithLockObject = new SynchronizedBooleanSet(BooleanHashSet.newSetWith(true, false, true), new Object()).asSynchronized();
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedBooleanSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedBooleanSetTest();
            this.instance.setup();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanSetTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollection = SynchronizedBooleanSetTest::newCollection;
            this.payloads.containsAnyArray = SynchronizedBooleanSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedBooleanSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedBooleanSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedBooleanSetTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanSetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanSetTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanSetTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedBooleanSetTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedBooleanSetTest::reduceIfEmpty;
            this.payloads.booleanIterator_with_remove = SynchronizedBooleanSetTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedBooleanSetTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedBooleanSetTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = SynchronizedBooleanSetTest::chunk;
            this.payloads.newCollectionWith = SynchronizedBooleanSetTest::newCollectionWith;
            this.payloads.isEmpty = SynchronizedBooleanSetTest::isEmpty;
            this.payloads.notEmpty = SynchronizedBooleanSetTest::notEmpty;
            this.payloads.clear = SynchronizedBooleanSetTest::clear;
            this.payloads.contains = SynchronizedBooleanSetTest::contains;
            this.payloads.containsAllArray = SynchronizedBooleanSetTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedBooleanSetTest::containsAllIterable;
            this.payloads.add = SynchronizedBooleanSetTest::add;
            this.payloads.addAllArray = SynchronizedBooleanSetTest::addAllArray;
            this.payloads.addAllIterable = SynchronizedBooleanSetTest::addAllIterable;
            this.payloads.remove = SynchronizedBooleanSetTest::remove;
            this.payloads.removeAll = SynchronizedBooleanSetTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedBooleanSetTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedBooleanSetTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedBooleanSetTest::retainAll_iterable;
            this.payloads.with = SynchronizedBooleanSetTest::with;
            this.payloads.withAll = SynchronizedBooleanSetTest::withAll;
            this.payloads.without = SynchronizedBooleanSetTest::without;
            this.payloads.withoutAll = SynchronizedBooleanSetTest::withoutAll;
            this.payloads.toArray = SynchronizedBooleanSetTest::toArray;
            this.payloads.toList = SynchronizedBooleanSetTest::toList;
            this.payloads.toSet = SynchronizedBooleanSetTest::toSet;
            this.payloads.toBag = SynchronizedBooleanSetTest::toBag;
            this.payloads.testEquals = SynchronizedBooleanSetTest::testEquals;
            this.payloads.testHashCode = SynchronizedBooleanSetTest::testHashCode;
            this.payloads.booleanIterator = SynchronizedBooleanSetTest::booleanIterator;
            this.payloads.forEach = SynchronizedBooleanSetTest::forEach;
            this.payloads.injectInto = SynchronizedBooleanSetTest::injectInto;
            this.payloads.size = SynchronizedBooleanSetTest::size;
            this.payloads.count = SynchronizedBooleanSetTest::count;
            this.payloads.anySatisfy = SynchronizedBooleanSetTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedBooleanSetTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedBooleanSetTest::noneSatisfy;
            this.payloads.select = SynchronizedBooleanSetTest::select;
            this.payloads.reject = SynchronizedBooleanSetTest::reject;
            this.payloads.detectIfNone = SynchronizedBooleanSetTest::detectIfNone;
            this.payloads.collect = SynchronizedBooleanSetTest::collect;
            this.payloads.testToString = SynchronizedBooleanSetTest::testToString;
            this.payloads.makeString = SynchronizedBooleanSetTest::makeString;
            this.payloads.appendString = SynchronizedBooleanSetTest::appendString;
            this.payloads.asLazy = SynchronizedBooleanSetTest::asLazy;
            this.payloads.asUnmodifiable = SynchronizedBooleanSetTest::asUnmodifiable;
            this.payloads.union = SynchronizedBooleanSetTest::union;
            this.payloads.intersect = SynchronizedBooleanSetTest::intersect;
            this.payloads.difference = SynchronizedBooleanSetTest::difference;
            this.payloads.symmetricDifference = SynchronizedBooleanSetTest::symmetricDifference;
            this.payloads.isSubsetOf = SynchronizedBooleanSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = SynchronizedBooleanSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = SynchronizedBooleanSetTest::cartesianProduct;
            this.payloads.asSynchronized = SynchronizedBooleanSetTest::asSynchronized;
        }
    }
}
