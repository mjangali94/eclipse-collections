/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.Collections;
import org.eclipse.collections.api.list.MutableList;

public class ListAdapterAsUnmodifiableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        return ListAdapter.adapt(Collections.singletonList(1)).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ListAdapterAsUnmodifiableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAppendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAppendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListListIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListListIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new ListAdapterAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> subListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> setAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterAsUnmodifiableTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = ListAdapterAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = ListAdapterAsUnmodifiableTest::testAppendString;
            this.payloads.select = ListAdapterAsUnmodifiableTest::select;
            this.payloads.selectWith = ListAdapterAsUnmodifiableTest::selectWith;
            this.payloads.reject = ListAdapterAsUnmodifiableTest::reject;
            this.payloads.rejectWith = ListAdapterAsUnmodifiableTest::rejectWith;
            this.payloads.partition = ListAdapterAsUnmodifiableTest::partition;
            this.payloads.partitionWith = ListAdapterAsUnmodifiableTest::partitionWith;
            this.payloads.collect = ListAdapterAsUnmodifiableTest::collect;
            this.payloads.collectInt = ListAdapterAsUnmodifiableTest::collectInt;
            this.payloads.collectBoolean = ListAdapterAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = ListAdapterAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = ListAdapterAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = ListAdapterAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = ListAdapterAsUnmodifiableTest::collectFloat;
            this.payloads.collectLong = ListAdapterAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = ListAdapterAsUnmodifiableTest::collectShort;
            this.payloads.collectWith = ListAdapterAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = ListAdapterAsUnmodifiableTest::collectIf;
            this.payloads.groupBy = ListAdapterAsUnmodifiableTest::groupBy;
            this.payloads.zip = ListAdapterAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = ListAdapterAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = ListAdapterAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = ListAdapterAsUnmodifiableTest::tap;
            this.payloads.removeFromIndex = ListAdapterAsUnmodifiableTest::removeFromIndex;
            this.payloads.newEmpty = ListAdapterAsUnmodifiableTest::newEmpty;
            this.payloads.corresponds = ListAdapterAsUnmodifiableTest::corresponds;
            this.payloads.detectIndex = ListAdapterAsUnmodifiableTest::detectIndex;
            this.payloads.detectLastIndex = ListAdapterAsUnmodifiableTest::detectLastIndex;
            this.payloads.testClone = ListAdapterAsUnmodifiableTest::testClone;
            this.payloads.serialization = ListAdapterAsUnmodifiableTest::serialization;
            this.payloads.subList = ListAdapterAsUnmodifiableTest::subList;
            this.payloads.listIterator = ListAdapterAsUnmodifiableTest::listIterator;
            this.payloads.subListListIterator = ListAdapterAsUnmodifiableTest::subListListIterator;
            this.payloads.set = ListAdapterAsUnmodifiableTest::set;
            this.payloads.addAtIndex = ListAdapterAsUnmodifiableTest::addAtIndex;
            this.payloads.addAllAtIndex = ListAdapterAsUnmodifiableTest::addAllAtIndex;
            this.payloads.removeAtIndex = ListAdapterAsUnmodifiableTest::removeAtIndex;
            this.payloads.setAtIndex = ListAdapterAsUnmodifiableTest::setAtIndex;
            this.payloads.sortThis = ListAdapterAsUnmodifiableTest::sortThis;
            this.payloads.sortThisWithComparator = ListAdapterAsUnmodifiableTest::sortThisWithComparator;
            this.payloads.sortThisBy = ListAdapterAsUnmodifiableTest::sortThisBy;
            this.payloads.sortThisByBoolean = ListAdapterAsUnmodifiableTest::sortThisByBoolean;
            this.payloads.sortThisByChar = ListAdapterAsUnmodifiableTest::sortThisByChar;
            this.payloads.sortThisByByte = ListAdapterAsUnmodifiableTest::sortThisByByte;
            this.payloads.sortThisByShort = ListAdapterAsUnmodifiableTest::sortThisByShort;
            this.payloads.sortThisByInt = ListAdapterAsUnmodifiableTest::sortThisByInt;
            this.payloads.sortThisByFloat = ListAdapterAsUnmodifiableTest::sortThisByFloat;
            this.payloads.sortThisByLong = ListAdapterAsUnmodifiableTest::sortThisByLong;
            this.payloads.sortThisByDouble = ListAdapterAsUnmodifiableTest::sortThisByDouble;
            this.payloads.reverseThis = ListAdapterAsUnmodifiableTest::reverseThis;
            this.payloads.testEquals = ListAdapterAsUnmodifiableTest::testEquals;
        }
    }
}
