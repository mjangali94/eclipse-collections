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

import java.io.Serializable;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderFastListAsReadUntouchableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        return MultiReaderFastList.newListWith(1).asReadUntouchable();
    }

    @Override
    @Test
    public void serialization() {
        MutableCollection<Integer> collection = this.getCollection();
        Assert.assertFalse(collection instanceof Serializable);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderFastListAsReadUntouchableTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderFastListAsReadUntouchableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> subListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> setAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListAsReadUntouchableTest> serialization;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = MultiReaderFastListAsReadUntouchableTest::testMakeString;
            this.payloads.testAppendString = MultiReaderFastListAsReadUntouchableTest::testAppendString;
            this.payloads.select = MultiReaderFastListAsReadUntouchableTest::select;
            this.payloads.selectWith = MultiReaderFastListAsReadUntouchableTest::selectWith;
            this.payloads.reject = MultiReaderFastListAsReadUntouchableTest::reject;
            this.payloads.rejectWith = MultiReaderFastListAsReadUntouchableTest::rejectWith;
            this.payloads.partition = MultiReaderFastListAsReadUntouchableTest::partition;
            this.payloads.partitionWith = MultiReaderFastListAsReadUntouchableTest::partitionWith;
            this.payloads.collect = MultiReaderFastListAsReadUntouchableTest::collect;
            this.payloads.collectInt = MultiReaderFastListAsReadUntouchableTest::collectInt;
            this.payloads.collectBoolean = MultiReaderFastListAsReadUntouchableTest::collectBoolean;
            this.payloads.collectByte = MultiReaderFastListAsReadUntouchableTest::collectByte;
            this.payloads.collectChar = MultiReaderFastListAsReadUntouchableTest::collectChar;
            this.payloads.collectDouble = MultiReaderFastListAsReadUntouchableTest::collectDouble;
            this.payloads.collectFloat = MultiReaderFastListAsReadUntouchableTest::collectFloat;
            this.payloads.collectLong = MultiReaderFastListAsReadUntouchableTest::collectLong;
            this.payloads.collectShort = MultiReaderFastListAsReadUntouchableTest::collectShort;
            this.payloads.collectWith = MultiReaderFastListAsReadUntouchableTest::collectWith;
            this.payloads.collectIf = MultiReaderFastListAsReadUntouchableTest::collectIf;
            this.payloads.groupBy = MultiReaderFastListAsReadUntouchableTest::groupBy;
            this.payloads.zip = MultiReaderFastListAsReadUntouchableTest::zip;
            this.payloads.zipWithIndex = MultiReaderFastListAsReadUntouchableTest::zipWithIndex;
            this.payloads.flatCollect = MultiReaderFastListAsReadUntouchableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListAsReadUntouchableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = MultiReaderFastListAsReadUntouchableTest::tap;
            this.payloads.removeFromIndex = MultiReaderFastListAsReadUntouchableTest::removeFromIndex;
            this.payloads.newEmpty = MultiReaderFastListAsReadUntouchableTest::newEmpty;
            this.payloads.corresponds = MultiReaderFastListAsReadUntouchableTest::corresponds;
            this.payloads.detectIndex = MultiReaderFastListAsReadUntouchableTest::detectIndex;
            this.payloads.detectLastIndex = MultiReaderFastListAsReadUntouchableTest::detectLastIndex;
            this.payloads.testClone = MultiReaderFastListAsReadUntouchableTest::testClone;
            this.payloads.subList = MultiReaderFastListAsReadUntouchableTest::subList;
            this.payloads.listIterator = MultiReaderFastListAsReadUntouchableTest::listIterator;
            this.payloads.subListListIterator = MultiReaderFastListAsReadUntouchableTest::subListListIterator;
            this.payloads.set = MultiReaderFastListAsReadUntouchableTest::set;
            this.payloads.addAtIndex = MultiReaderFastListAsReadUntouchableTest::addAtIndex;
            this.payloads.addAllAtIndex = MultiReaderFastListAsReadUntouchableTest::addAllAtIndex;
            this.payloads.removeAtIndex = MultiReaderFastListAsReadUntouchableTest::removeAtIndex;
            this.payloads.setAtIndex = MultiReaderFastListAsReadUntouchableTest::setAtIndex;
            this.payloads.sortThis = MultiReaderFastListAsReadUntouchableTest::sortThis;
            this.payloads.sortThisWithComparator = MultiReaderFastListAsReadUntouchableTest::sortThisWithComparator;
            this.payloads.sortThisBy = MultiReaderFastListAsReadUntouchableTest::sortThisBy;
            this.payloads.sortThisByBoolean = MultiReaderFastListAsReadUntouchableTest::sortThisByBoolean;
            this.payloads.sortThisByChar = MultiReaderFastListAsReadUntouchableTest::sortThisByChar;
            this.payloads.sortThisByByte = MultiReaderFastListAsReadUntouchableTest::sortThisByByte;
            this.payloads.sortThisByShort = MultiReaderFastListAsReadUntouchableTest::sortThisByShort;
            this.payloads.sortThisByInt = MultiReaderFastListAsReadUntouchableTest::sortThisByInt;
            this.payloads.sortThisByFloat = MultiReaderFastListAsReadUntouchableTest::sortThisByFloat;
            this.payloads.sortThisByLong = MultiReaderFastListAsReadUntouchableTest::sortThisByLong;
            this.payloads.sortThisByDouble = MultiReaderFastListAsReadUntouchableTest::sortThisByDouble;
            this.payloads.reverseThis = MultiReaderFastListAsReadUntouchableTest::reverseThis;
            this.payloads.testEquals = MultiReaderFastListAsReadUntouchableTest::testEquals;
            this.payloads.serialization = MultiReaderFastListAsReadUntouchableTest::serialization;
        }
    }
}
