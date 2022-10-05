/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable.primitive;

import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedBooleanList}.
 */
public class SynchronizedBooleanListTest extends AbstractBooleanListTestCase {

    @Override
    protected SynchronizedBooleanList classUnderTest() {
        return new SynchronizedBooleanList(BooleanArrayList.newListWith(true, false, true));
    }

    @Override
    protected SynchronizedBooleanList newWith(boolean... elements) {
        return new SynchronizedBooleanList(BooleanArrayList.newListWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedBooleanList list = this.classUnderTest();
        MutableBooleanList listWithLockObject = new SynchronizedBooleanList(BooleanArrayList.newListWith(true, false, true), new Object()).asSynchronized();
        Assert.assertEquals(list, listWithLockObject);
        Assert.assertSame(listWithLockObject, listWithLockObject.asSynchronized());
        Assert.assertSame(list, list.asSynchronized());
        Assert.assertEquals(list, list.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedBooleanListTest instance;

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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_empty_list() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_empty_list);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst_emptyList_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast_emptyList_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
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
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_negative);
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
        public void benchmark_addAll_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size_empty_list() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size_empty_list);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set_throws_index_greater_than_size);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues_throws_negative_size);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedBooleanListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> get_throws_empty_list;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> addAll_throws_index_greater_than_size_empty_list;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> set_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBooleanListTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedBooleanListTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedBooleanListTest::newCollection;
            this.payloads.isEmpty = SynchronizedBooleanListTest::isEmpty;
            this.payloads.notEmpty = SynchronizedBooleanListTest::notEmpty;
            this.payloads.contains = SynchronizedBooleanListTest::contains;
            this.payloads.containsAnyArray = SynchronizedBooleanListTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedBooleanListTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedBooleanListTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedBooleanListTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.count = SynchronizedBooleanListTest::count;
            this.payloads.anySatisfy = SynchronizedBooleanListTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedBooleanListTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedBooleanListTest::noneSatisfy;
            this.payloads.select = SynchronizedBooleanListTest::select;
            this.payloads.reject = SynchronizedBooleanListTest::reject;
            this.payloads.detectIfNone = SynchronizedBooleanListTest::detectIfNone;
            this.payloads.collect = SynchronizedBooleanListTest::collect;
            this.payloads.injectInto = SynchronizedBooleanListTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedBooleanListTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedBooleanListTest::reduceIfEmpty;
            this.payloads.testHashCode = SynchronizedBooleanListTest::testHashCode;
            this.payloads.toSet = SynchronizedBooleanListTest::toSet;
            this.payloads.toBag = SynchronizedBooleanListTest::toBag;
            this.payloads.asLazy = SynchronizedBooleanListTest::asLazy;
            this.payloads.clear = SynchronizedBooleanListTest::clear;
            this.payloads.containsAllArray = SynchronizedBooleanListTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedBooleanListTest::containsAllIterable;
            this.payloads.add = SynchronizedBooleanListTest::add;
            this.payloads.removeAll = SynchronizedBooleanListTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedBooleanListTest::removeAll_iterable;
            this.payloads.retainAll_iterable = SynchronizedBooleanListTest::retainAll_iterable;
            this.payloads.retainAll = SynchronizedBooleanListTest::retainAll;
            this.payloads.with = SynchronizedBooleanListTest::with;
            this.payloads.withAll = SynchronizedBooleanListTest::withAll;
            this.payloads.without = SynchronizedBooleanListTest::without;
            this.payloads.withoutAll = SynchronizedBooleanListTest::withoutAll;
            this.payloads.asUnmodifiable = SynchronizedBooleanListTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = SynchronizedBooleanListTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedBooleanListTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedBooleanListTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = SynchronizedBooleanListTest::chunk;
            this.payloads.get = SynchronizedBooleanListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_empty_list = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::get_throws_empty_list, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = SynchronizedBooleanListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = SynchronizedBooleanListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = SynchronizedBooleanListTest::indexOf;
            this.payloads.lastIndexOf = SynchronizedBooleanListTest::lastIndexOf;
            this.payloads.addAtIndex = SynchronizedBooleanListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = SynchronizedBooleanListTest::addAllArray;
            this.payloads.addAllIterable = SynchronizedBooleanListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size_empty_list = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::addAll_throws_index_greater_than_size_empty_list, java.lang.IndexOutOfBoundsException.class);
            this.payloads.remove = SynchronizedBooleanListTest::remove;
            this.payloads.removeIf = SynchronizedBooleanListTest::removeIf;
            this.payloads.removeAtIndex = SynchronizedBooleanListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = SynchronizedBooleanListTest::set;
            this.payloads.set_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::set_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.booleanIterator = SynchronizedBooleanListTest::booleanIterator;
            this.payloads.forEach = SynchronizedBooleanListTest::forEach;
            this.payloads.size = SynchronizedBooleanListTest::size;
            this.payloads.toArray = SynchronizedBooleanListTest::toArray;
            this.payloads.reverseThis = SynchronizedBooleanListTest::reverseThis;
            this.payloads.toReversed = SynchronizedBooleanListTest::toReversed;
            this.payloads.distinct = SynchronizedBooleanListTest::distinct;
            this.payloads.injectIntoWithIndex = SynchronizedBooleanListTest::injectIntoWithIndex;
            this.payloads.forEachWithIndex = SynchronizedBooleanListTest::forEachWithIndex;
            this.payloads.testEquals = SynchronizedBooleanListTest::testEquals;
            this.payloads.testToString = SynchronizedBooleanListTest::testToString;
            this.payloads.makeString = SynchronizedBooleanListTest::makeString;
            this.payloads.newWithNValues = SynchronizedBooleanListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBooleanListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.appendString = SynchronizedBooleanListTest::appendString;
            this.payloads.toList = SynchronizedBooleanListTest::toList;
            this.payloads.toImmutable = SynchronizedBooleanListTest::toImmutable;
            this.payloads.tap = SynchronizedBooleanListTest::tap;
            this.payloads.collectWithIndex = SynchronizedBooleanListTest::collectWithIndex;
            this.payloads.asSynchronized = SynchronizedBooleanListTest::asSynchronized;
        }
    }
}
