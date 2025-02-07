/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;

public class MultiReaderUnifiedSetAsUnmodifiableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableCollection<Integer> getCollection() {
        return MultiReaderUnifiedSet.newSetWith(1).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderUnifiedSetAsUnmodifiableTest instance;

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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderUnifiedSetAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetAsUnmodifiableTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = MultiReaderUnifiedSetAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = MultiReaderUnifiedSetAsUnmodifiableTest::testAppendString;
            this.payloads.select = MultiReaderUnifiedSetAsUnmodifiableTest::select;
            this.payloads.selectWith = MultiReaderUnifiedSetAsUnmodifiableTest::selectWith;
            this.payloads.reject = MultiReaderUnifiedSetAsUnmodifiableTest::reject;
            this.payloads.rejectWith = MultiReaderUnifiedSetAsUnmodifiableTest::rejectWith;
            this.payloads.partition = MultiReaderUnifiedSetAsUnmodifiableTest::partition;
            this.payloads.partitionWith = MultiReaderUnifiedSetAsUnmodifiableTest::partitionWith;
            this.payloads.collect = MultiReaderUnifiedSetAsUnmodifiableTest::collect;
            this.payloads.collectInt = MultiReaderUnifiedSetAsUnmodifiableTest::collectInt;
            this.payloads.collectBoolean = MultiReaderUnifiedSetAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = MultiReaderUnifiedSetAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = MultiReaderUnifiedSetAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = MultiReaderUnifiedSetAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = MultiReaderUnifiedSetAsUnmodifiableTest::collectFloat;
            this.payloads.collectLong = MultiReaderUnifiedSetAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = MultiReaderUnifiedSetAsUnmodifiableTest::collectShort;
            this.payloads.collectWith = MultiReaderUnifiedSetAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = MultiReaderUnifiedSetAsUnmodifiableTest::collectIf;
            this.payloads.newEmpty = MultiReaderUnifiedSetAsUnmodifiableTest::newEmpty;
            this.payloads.groupBy = MultiReaderUnifiedSetAsUnmodifiableTest::groupBy;
            this.payloads.zip = MultiReaderUnifiedSetAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = MultiReaderUnifiedSetAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = MultiReaderUnifiedSetAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = MultiReaderUnifiedSetAsUnmodifiableTest::tap;
        }
    }
}
