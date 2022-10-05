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

import java.util.HashSet;
import java.util.Set;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;

public class SetAdapterAsUnmodifiableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableCollection<Integer> getCollection() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        return SetAdapter.adapt(set).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SetAdapterAsUnmodifiableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new SetAdapterAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterAsUnmodifiableTest> tap;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = SetAdapterAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = SetAdapterAsUnmodifiableTest::testAppendString;
            this.payloads.select = SetAdapterAsUnmodifiableTest::select;
            this.payloads.selectWith = SetAdapterAsUnmodifiableTest::selectWith;
            this.payloads.reject = SetAdapterAsUnmodifiableTest::reject;
            this.payloads.rejectWith = SetAdapterAsUnmodifiableTest::rejectWith;
            this.payloads.partition = SetAdapterAsUnmodifiableTest::partition;
            this.payloads.partitionWith = SetAdapterAsUnmodifiableTest::partitionWith;
            this.payloads.collect = SetAdapterAsUnmodifiableTest::collect;
            this.payloads.collectInt = SetAdapterAsUnmodifiableTest::collectInt;
            this.payloads.collectBoolean = SetAdapterAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = SetAdapterAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = SetAdapterAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = SetAdapterAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = SetAdapterAsUnmodifiableTest::collectFloat;
            this.payloads.collectLong = SetAdapterAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = SetAdapterAsUnmodifiableTest::collectShort;
            this.payloads.collectWith = SetAdapterAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = SetAdapterAsUnmodifiableTest::collectIf;
            this.payloads.newEmpty = SetAdapterAsUnmodifiableTest::newEmpty;
            this.payloads.groupBy = SetAdapterAsUnmodifiableTest::groupBy;
            this.payloads.zip = SetAdapterAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = SetAdapterAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = SetAdapterAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = SetAdapterAsUnmodifiableTest::tap;
        }
    }
}
