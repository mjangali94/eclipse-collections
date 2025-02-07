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
import org.eclipse.collections.impl.factory.Lists;

public class SingletonListSubListTest extends UnmodifiableMemoryEfficientListTestCase<String> {

    @Override
    protected MutableList<String> getCollection() {
        return Lists.fixedSize.of("1").subList(0, 1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SingletonListSubListTest instance;

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
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
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

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> payload) throws java.lang.Throwable {
            this.instance = new SingletonListSubListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListSubListTest> detectLastIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = SingletonListSubListTest::testMakeString;
            this.payloads.testAppendString = SingletonListSubListTest::testAppendString;
            this.payloads.select = SingletonListSubListTest::select;
            this.payloads.selectWith = SingletonListSubListTest::selectWith;
            this.payloads.reject = SingletonListSubListTest::reject;
            this.payloads.rejectWith = SingletonListSubListTest::rejectWith;
            this.payloads.partition = SingletonListSubListTest::partition;
            this.payloads.partitionWith = SingletonListSubListTest::partitionWith;
            this.payloads.collect = SingletonListSubListTest::collect;
            this.payloads.collectInt = SingletonListSubListTest::collectInt;
            this.payloads.collectBoolean = SingletonListSubListTest::collectBoolean;
            this.payloads.collectByte = SingletonListSubListTest::collectByte;
            this.payloads.collectChar = SingletonListSubListTest::collectChar;
            this.payloads.collectDouble = SingletonListSubListTest::collectDouble;
            this.payloads.collectFloat = SingletonListSubListTest::collectFloat;
            this.payloads.collectLong = SingletonListSubListTest::collectLong;
            this.payloads.collectShort = SingletonListSubListTest::collectShort;
            this.payloads.collectWith = SingletonListSubListTest::collectWith;
            this.payloads.collectIf = SingletonListSubListTest::collectIf;
            this.payloads.groupBy = SingletonListSubListTest::groupBy;
            this.payloads.zip = SingletonListSubListTest::zip;
            this.payloads.zipWithIndex = SingletonListSubListTest::zipWithIndex;
            this.payloads.flatCollect = SingletonListSubListTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonListSubListTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = SingletonListSubListTest::tap;
            this.payloads.listIterator = SingletonListSubListTest::listIterator;
            this.payloads.addAllAtIndex = SingletonListSubListTest::addAllAtIndex;
            this.payloads.addAtIndex = SingletonListSubListTest::addAtIndex;
            this.payloads.removeFromIndex = SingletonListSubListTest::removeFromIndex;
            this.payloads.subList = SingletonListSubListTest::subList;
            this.payloads.newEmpty = SingletonListSubListTest::newEmpty;
            this.payloads.corresponds = SingletonListSubListTest::corresponds;
            this.payloads.detectIndex = SingletonListSubListTest::detectIndex;
            this.payloads.detectLastIndex = SingletonListSubListTest::detectLastIndex;
        }
    }
}
