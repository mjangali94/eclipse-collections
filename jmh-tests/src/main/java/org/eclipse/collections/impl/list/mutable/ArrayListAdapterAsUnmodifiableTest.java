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

import java.util.ArrayList;
import org.eclipse.collections.api.list.MutableList;

public class ArrayListAdapterAsUnmodifiableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        return ArrayListAdapter.adapt(list).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ArrayListAdapterAsUnmodifiableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new ArrayListAdapterAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> subListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> setAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayListAdapterAsUnmodifiableTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = ArrayListAdapterAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = ArrayListAdapterAsUnmodifiableTest::testAppendString;
            this.payloads.select = ArrayListAdapterAsUnmodifiableTest::select;
            this.payloads.selectWith = ArrayListAdapterAsUnmodifiableTest::selectWith;
            this.payloads.reject = ArrayListAdapterAsUnmodifiableTest::reject;
            this.payloads.rejectWith = ArrayListAdapterAsUnmodifiableTest::rejectWith;
            this.payloads.partition = ArrayListAdapterAsUnmodifiableTest::partition;
            this.payloads.partitionWith = ArrayListAdapterAsUnmodifiableTest::partitionWith;
            this.payloads.collect = ArrayListAdapterAsUnmodifiableTest::collect;
            this.payloads.collectInt = ArrayListAdapterAsUnmodifiableTest::collectInt;
            this.payloads.collectBoolean = ArrayListAdapterAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = ArrayListAdapterAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = ArrayListAdapterAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = ArrayListAdapterAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = ArrayListAdapterAsUnmodifiableTest::collectFloat;
            this.payloads.collectLong = ArrayListAdapterAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = ArrayListAdapterAsUnmodifiableTest::collectShort;
            this.payloads.collectWith = ArrayListAdapterAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = ArrayListAdapterAsUnmodifiableTest::collectIf;
            this.payloads.groupBy = ArrayListAdapterAsUnmodifiableTest::groupBy;
            this.payloads.zip = ArrayListAdapterAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = ArrayListAdapterAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = ArrayListAdapterAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayListAdapterAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = ArrayListAdapterAsUnmodifiableTest::tap;
            this.payloads.removeFromIndex = ArrayListAdapterAsUnmodifiableTest::removeFromIndex;
            this.payloads.newEmpty = ArrayListAdapterAsUnmodifiableTest::newEmpty;
            this.payloads.corresponds = ArrayListAdapterAsUnmodifiableTest::corresponds;
            this.payloads.detectIndex = ArrayListAdapterAsUnmodifiableTest::detectIndex;
            this.payloads.detectLastIndex = ArrayListAdapterAsUnmodifiableTest::detectLastIndex;
            this.payloads.testClone = ArrayListAdapterAsUnmodifiableTest::testClone;
            this.payloads.serialization = ArrayListAdapterAsUnmodifiableTest::serialization;
            this.payloads.subList = ArrayListAdapterAsUnmodifiableTest::subList;
            this.payloads.listIterator = ArrayListAdapterAsUnmodifiableTest::listIterator;
            this.payloads.subListListIterator = ArrayListAdapterAsUnmodifiableTest::subListListIterator;
            this.payloads.set = ArrayListAdapterAsUnmodifiableTest::set;
            this.payloads.addAtIndex = ArrayListAdapterAsUnmodifiableTest::addAtIndex;
            this.payloads.addAllAtIndex = ArrayListAdapterAsUnmodifiableTest::addAllAtIndex;
            this.payloads.removeAtIndex = ArrayListAdapterAsUnmodifiableTest::removeAtIndex;
            this.payloads.setAtIndex = ArrayListAdapterAsUnmodifiableTest::setAtIndex;
            this.payloads.sortThis = ArrayListAdapterAsUnmodifiableTest::sortThis;
            this.payloads.sortThisWithComparator = ArrayListAdapterAsUnmodifiableTest::sortThisWithComparator;
            this.payloads.sortThisBy = ArrayListAdapterAsUnmodifiableTest::sortThisBy;
            this.payloads.sortThisByBoolean = ArrayListAdapterAsUnmodifiableTest::sortThisByBoolean;
            this.payloads.sortThisByChar = ArrayListAdapterAsUnmodifiableTest::sortThisByChar;
            this.payloads.sortThisByByte = ArrayListAdapterAsUnmodifiableTest::sortThisByByte;
            this.payloads.sortThisByShort = ArrayListAdapterAsUnmodifiableTest::sortThisByShort;
            this.payloads.sortThisByInt = ArrayListAdapterAsUnmodifiableTest::sortThisByInt;
            this.payloads.sortThisByFloat = ArrayListAdapterAsUnmodifiableTest::sortThisByFloat;
            this.payloads.sortThisByLong = ArrayListAdapterAsUnmodifiableTest::sortThisByLong;
            this.payloads.sortThisByDouble = ArrayListAdapterAsUnmodifiableTest::sortThisByDouble;
            this.payloads.reverseThis = ArrayListAdapterAsUnmodifiableTest::reverseThis;
            this.payloads.testEquals = ArrayListAdapterAsUnmodifiableTest::testEquals;
        }
    }
}
