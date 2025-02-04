/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.fixed;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.UnmodifiableMutableListTestCase;

public class ArrayAdapterAsUnmodifiableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        return ArrayAdapter.newArrayWith(1).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ArrayAdapterAsUnmodifiableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new ArrayAdapterAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> subListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> setAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ArrayAdapterAsUnmodifiableTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = ArrayAdapterAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = ArrayAdapterAsUnmodifiableTest::testAppendString;
            this.payloads.select = ArrayAdapterAsUnmodifiableTest::select;
            this.payloads.selectWith = ArrayAdapterAsUnmodifiableTest::selectWith;
            this.payloads.reject = ArrayAdapterAsUnmodifiableTest::reject;
            this.payloads.rejectWith = ArrayAdapterAsUnmodifiableTest::rejectWith;
            this.payloads.partition = ArrayAdapterAsUnmodifiableTest::partition;
            this.payloads.partitionWith = ArrayAdapterAsUnmodifiableTest::partitionWith;
            this.payloads.collect = ArrayAdapterAsUnmodifiableTest::collect;
            this.payloads.collectInt = ArrayAdapterAsUnmodifiableTest::collectInt;
            this.payloads.collectBoolean = ArrayAdapterAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = ArrayAdapterAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = ArrayAdapterAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = ArrayAdapterAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = ArrayAdapterAsUnmodifiableTest::collectFloat;
            this.payloads.collectLong = ArrayAdapterAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = ArrayAdapterAsUnmodifiableTest::collectShort;
            this.payloads.collectWith = ArrayAdapterAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = ArrayAdapterAsUnmodifiableTest::collectIf;
            this.payloads.groupBy = ArrayAdapterAsUnmodifiableTest::groupBy;
            this.payloads.zip = ArrayAdapterAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = ArrayAdapterAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = ArrayAdapterAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ArrayAdapterAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = ArrayAdapterAsUnmodifiableTest::tap;
            this.payloads.removeFromIndex = ArrayAdapterAsUnmodifiableTest::removeFromIndex;
            this.payloads.newEmpty = ArrayAdapterAsUnmodifiableTest::newEmpty;
            this.payloads.corresponds = ArrayAdapterAsUnmodifiableTest::corresponds;
            this.payloads.detectIndex = ArrayAdapterAsUnmodifiableTest::detectIndex;
            this.payloads.detectLastIndex = ArrayAdapterAsUnmodifiableTest::detectLastIndex;
            this.payloads.testClone = ArrayAdapterAsUnmodifiableTest::testClone;
            this.payloads.serialization = ArrayAdapterAsUnmodifiableTest::serialization;
            this.payloads.subList = ArrayAdapterAsUnmodifiableTest::subList;
            this.payloads.listIterator = ArrayAdapterAsUnmodifiableTest::listIterator;
            this.payloads.subListListIterator = ArrayAdapterAsUnmodifiableTest::subListListIterator;
            this.payloads.set = ArrayAdapterAsUnmodifiableTest::set;
            this.payloads.addAtIndex = ArrayAdapterAsUnmodifiableTest::addAtIndex;
            this.payloads.addAllAtIndex = ArrayAdapterAsUnmodifiableTest::addAllAtIndex;
            this.payloads.removeAtIndex = ArrayAdapterAsUnmodifiableTest::removeAtIndex;
            this.payloads.setAtIndex = ArrayAdapterAsUnmodifiableTest::setAtIndex;
            this.payloads.sortThis = ArrayAdapterAsUnmodifiableTest::sortThis;
            this.payloads.sortThisWithComparator = ArrayAdapterAsUnmodifiableTest::sortThisWithComparator;
            this.payloads.sortThisBy = ArrayAdapterAsUnmodifiableTest::sortThisBy;
            this.payloads.sortThisByBoolean = ArrayAdapterAsUnmodifiableTest::sortThisByBoolean;
            this.payloads.sortThisByChar = ArrayAdapterAsUnmodifiableTest::sortThisByChar;
            this.payloads.sortThisByByte = ArrayAdapterAsUnmodifiableTest::sortThisByByte;
            this.payloads.sortThisByShort = ArrayAdapterAsUnmodifiableTest::sortThisByShort;
            this.payloads.sortThisByInt = ArrayAdapterAsUnmodifiableTest::sortThisByInt;
            this.payloads.sortThisByFloat = ArrayAdapterAsUnmodifiableTest::sortThisByFloat;
            this.payloads.sortThisByLong = ArrayAdapterAsUnmodifiableTest::sortThisByLong;
            this.payloads.sortThisByDouble = ArrayAdapterAsUnmodifiableTest::sortThisByDouble;
            this.payloads.reverseThis = ArrayAdapterAsUnmodifiableTest::reverseThis;
            this.payloads.testEquals = ArrayAdapterAsUnmodifiableTest::testEquals;
        }
    }
}
