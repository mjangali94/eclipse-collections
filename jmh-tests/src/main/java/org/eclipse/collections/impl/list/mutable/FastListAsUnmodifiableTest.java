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

import org.eclipse.collections.api.list.MutableList;

public class FastListAsUnmodifiableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        return FastList.newListWith(1).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public FastListAsUnmodifiableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new FastListAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> subListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> setAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListAsUnmodifiableTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = FastListAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = FastListAsUnmodifiableTest::testAppendString;
            this.payloads.select = FastListAsUnmodifiableTest::select;
            this.payloads.selectWith = FastListAsUnmodifiableTest::selectWith;
            this.payloads.reject = FastListAsUnmodifiableTest::reject;
            this.payloads.rejectWith = FastListAsUnmodifiableTest::rejectWith;
            this.payloads.partition = FastListAsUnmodifiableTest::partition;
            this.payloads.partitionWith = FastListAsUnmodifiableTest::partitionWith;
            this.payloads.collect = FastListAsUnmodifiableTest::collect;
            this.payloads.collectInt = FastListAsUnmodifiableTest::collectInt;
            this.payloads.collectBoolean = FastListAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = FastListAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = FastListAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = FastListAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = FastListAsUnmodifiableTest::collectFloat;
            this.payloads.collectLong = FastListAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = FastListAsUnmodifiableTest::collectShort;
            this.payloads.collectWith = FastListAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = FastListAsUnmodifiableTest::collectIf;
            this.payloads.groupBy = FastListAsUnmodifiableTest::groupBy;
            this.payloads.zip = FastListAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = FastListAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = FastListAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = FastListAsUnmodifiableTest::tap;
            this.payloads.removeFromIndex = FastListAsUnmodifiableTest::removeFromIndex;
            this.payloads.newEmpty = FastListAsUnmodifiableTest::newEmpty;
            this.payloads.corresponds = FastListAsUnmodifiableTest::corresponds;
            this.payloads.detectIndex = FastListAsUnmodifiableTest::detectIndex;
            this.payloads.detectLastIndex = FastListAsUnmodifiableTest::detectLastIndex;
            this.payloads.testClone = FastListAsUnmodifiableTest::testClone;
            this.payloads.serialization = FastListAsUnmodifiableTest::serialization;
            this.payloads.subList = FastListAsUnmodifiableTest::subList;
            this.payloads.listIterator = FastListAsUnmodifiableTest::listIterator;
            this.payloads.subListListIterator = FastListAsUnmodifiableTest::subListListIterator;
            this.payloads.set = FastListAsUnmodifiableTest::set;
            this.payloads.addAtIndex = FastListAsUnmodifiableTest::addAtIndex;
            this.payloads.addAllAtIndex = FastListAsUnmodifiableTest::addAllAtIndex;
            this.payloads.removeAtIndex = FastListAsUnmodifiableTest::removeAtIndex;
            this.payloads.setAtIndex = FastListAsUnmodifiableTest::setAtIndex;
            this.payloads.sortThis = FastListAsUnmodifiableTest::sortThis;
            this.payloads.sortThisWithComparator = FastListAsUnmodifiableTest::sortThisWithComparator;
            this.payloads.sortThisBy = FastListAsUnmodifiableTest::sortThisBy;
            this.payloads.sortThisByBoolean = FastListAsUnmodifiableTest::sortThisByBoolean;
            this.payloads.sortThisByChar = FastListAsUnmodifiableTest::sortThisByChar;
            this.payloads.sortThisByByte = FastListAsUnmodifiableTest::sortThisByByte;
            this.payloads.sortThisByShort = FastListAsUnmodifiableTest::sortThisByShort;
            this.payloads.sortThisByInt = FastListAsUnmodifiableTest::sortThisByInt;
            this.payloads.sortThisByFloat = FastListAsUnmodifiableTest::sortThisByFloat;
            this.payloads.sortThisByLong = FastListAsUnmodifiableTest::sortThisByLong;
            this.payloads.sortThisByDouble = FastListAsUnmodifiableTest::sortThisByDouble;
            this.payloads.reverseThis = FastListAsUnmodifiableTest::reverseThis;
            this.payloads.testEquals = FastListAsUnmodifiableTest::testEquals;
        }
    }
}
