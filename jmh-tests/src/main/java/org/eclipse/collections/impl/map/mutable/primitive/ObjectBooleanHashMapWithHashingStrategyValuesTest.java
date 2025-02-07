/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.list.mutable.FastList;

public class ObjectBooleanHashMapWithHashingStrategyValuesTest extends ObjectBooleanHashMapValuesTestCase {

    private static final HashingStrategy<Integer> INT_MOD_10_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.intValue() % 10;
        }

        public boolean equals(Integer object1, Integer object2) {
            return this.computeHashCode(object1) == this.computeHashCode(object2);
        }
    });

    @Override
    protected MutableBooleanCollection classUnderTest() {
        return ObjectBooleanHashMapWithHashingStrategy.newWithKeysValues(INT_MOD_10_STRATEGY, 1, true, 2, false, 3, true).values();
    }

    @Override
    protected MutableBooleanCollection newWith(boolean... elements) {
        ObjectBooleanHashMapWithHashingStrategy<Integer> map = new ObjectBooleanHashMapWithHashingStrategy<>(INT_MOD_10_STRATEGY);
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableBooleanCollection newMutableCollectionWith(boolean... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableList<Object> newObjectCollectionWith(Object... elements) {
        return FastList.newListWith(elements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ObjectBooleanHashMapWithHashingStrategyValuesTest instance;

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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectBooleanHashMapWithHashingStrategyValuesTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanHashMapWithHashingStrategyValuesTest> testHashCode;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectBooleanHashMapWithHashingStrategyValuesTest::newCollectionWith;
            this.payloads.newCollection = ObjectBooleanHashMapWithHashingStrategyValuesTest::newCollection;
            this.payloads.isEmpty = ObjectBooleanHashMapWithHashingStrategyValuesTest::isEmpty;
            this.payloads.notEmpty = ObjectBooleanHashMapWithHashingStrategyValuesTest::notEmpty;
            this.payloads.containsAnyArray = ObjectBooleanHashMapWithHashingStrategyValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectBooleanHashMapWithHashingStrategyValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectBooleanHashMapWithHashingStrategyValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectBooleanHashMapWithHashingStrategyValuesTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectBooleanHashMapWithHashingStrategyValuesTest::forEach;
            this.payloads.size = ObjectBooleanHashMapWithHashingStrategyValuesTest::size;
            this.payloads.count = ObjectBooleanHashMapWithHashingStrategyValuesTest::count;
            this.payloads.anySatisfy = ObjectBooleanHashMapWithHashingStrategyValuesTest::anySatisfy;
            this.payloads.allSatisfy = ObjectBooleanHashMapWithHashingStrategyValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectBooleanHashMapWithHashingStrategyValuesTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectBooleanHashMapWithHashingStrategyValuesTest::detectIfNone;
            this.payloads.injectInto = ObjectBooleanHashMapWithHashingStrategyValuesTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectBooleanHashMapWithHashingStrategyValuesTest::reduce;
            this.payloads.reduceIfEmpty = ObjectBooleanHashMapWithHashingStrategyValuesTest::reduceIfEmpty;
            this.payloads.toArray = ObjectBooleanHashMapWithHashingStrategyValuesTest::toArray;
            this.payloads.makeString = ObjectBooleanHashMapWithHashingStrategyValuesTest::makeString;
            this.payloads.toList = ObjectBooleanHashMapWithHashingStrategyValuesTest::toList;
            this.payloads.toSet = ObjectBooleanHashMapWithHashingStrategyValuesTest::toSet;
            this.payloads.toBag = ObjectBooleanHashMapWithHashingStrategyValuesTest::toBag;
            this.payloads.asLazy = ObjectBooleanHashMapWithHashingStrategyValuesTest::asLazy;
            this.payloads.containsAllArray = ObjectBooleanHashMapWithHashingStrategyValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ObjectBooleanHashMapWithHashingStrategyValuesTest::containsAllIterable;
            this.payloads.booleanIterator_with_remove = ObjectBooleanHashMapWithHashingStrategyValuesTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ObjectBooleanHashMapWithHashingStrategyValuesTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ObjectBooleanHashMapWithHashingStrategyValuesTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = ObjectBooleanHashMapWithHashingStrategyValuesTest::chunk;
            this.payloads.booleanIterator = ObjectBooleanHashMapWithHashingStrategyValuesTest::booleanIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectBooleanHashMapWithHashingStrategyValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectBooleanHashMapWithHashingStrategyValuesTest::remove;
            this.payloads.removeAll = ObjectBooleanHashMapWithHashingStrategyValuesTest::removeAll;
            this.payloads.removeAll_iterable = ObjectBooleanHashMapWithHashingStrategyValuesTest::removeAll_iterable;
            this.payloads.retainAll = ObjectBooleanHashMapWithHashingStrategyValuesTest::retainAll;
            this.payloads.retainAll_iterable = ObjectBooleanHashMapWithHashingStrategyValuesTest::retainAll_iterable;
            this.payloads.clear = ObjectBooleanHashMapWithHashingStrategyValuesTest::clear;
            this.payloads.contains = ObjectBooleanHashMapWithHashingStrategyValuesTest::contains;
            this.payloads.reject = ObjectBooleanHashMapWithHashingStrategyValuesTest::reject;
            this.payloads.select = ObjectBooleanHashMapWithHashingStrategyValuesTest::select;
            this.payloads.collect = ObjectBooleanHashMapWithHashingStrategyValuesTest::collect;
            this.payloads.appendString = ObjectBooleanHashMapWithHashingStrategyValuesTest::appendString;
            this.payloads.asUnmodifiable = ObjectBooleanHashMapWithHashingStrategyValuesTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectBooleanHashMapWithHashingStrategyValuesTest::asSynchronized;
            this.payloads.testEquals = ObjectBooleanHashMapWithHashingStrategyValuesTest::testEquals;
            this.payloads.testToString = ObjectBooleanHashMapWithHashingStrategyValuesTest::testToString;
            this.payloads.testHashCode = ObjectBooleanHashMapWithHashingStrategyValuesTest::testHashCode;
        }
    }
}
