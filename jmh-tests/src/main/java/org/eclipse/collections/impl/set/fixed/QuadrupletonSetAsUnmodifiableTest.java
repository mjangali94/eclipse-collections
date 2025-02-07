/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.fixed;

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class QuadrupletonSetAsUnmodifiableTest extends UnmodifiableMutableCollectionTestCase<String> {

    @Override
    protected MutableCollection<String> getCollection() {
        return Sets.fixedSize.of("1", "2", "3", "4").asUnmodifiable();
    }

    @Override
    @Test
    public void collectBoolean() {
        Verify.assertSize(1, this.getCollection().collectBoolean(Boolean::parseBoolean));
    }

    @Override
    @Test
    public void collectByte() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectByte(Byte::parseByte));
    }

    @Override
    @Test
    public void collectChar() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectChar((CharFunction<String>) string -> string.charAt(0)));
    }

    @Override
    @Test
    public void collectDouble() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectDouble(Double::parseDouble));
    }

    @Override
    @Test
    public void collectFloat() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectFloat(Float::parseFloat));
    }

    @Override
    @Test
    public void collectInt() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectInt(Integer::parseInt));
    }

    @Override
    @Test
    public void collectLong() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectLong(Long::parseLong));
    }

    @Override
    @Test
    public void collectShort() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectShort(Short::parseShort));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public QuadrupletonSetAsUnmodifiableTest instance;

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
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new QuadrupletonSetAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonSetAsUnmodifiableTest> collectShort;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = QuadrupletonSetAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = QuadrupletonSetAsUnmodifiableTest::testAppendString;
            this.payloads.select = QuadrupletonSetAsUnmodifiableTest::select;
            this.payloads.selectWith = QuadrupletonSetAsUnmodifiableTest::selectWith;
            this.payloads.reject = QuadrupletonSetAsUnmodifiableTest::reject;
            this.payloads.rejectWith = QuadrupletonSetAsUnmodifiableTest::rejectWith;
            this.payloads.partition = QuadrupletonSetAsUnmodifiableTest::partition;
            this.payloads.partitionWith = QuadrupletonSetAsUnmodifiableTest::partitionWith;
            this.payloads.collect = QuadrupletonSetAsUnmodifiableTest::collect;
            this.payloads.collectWith = QuadrupletonSetAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = QuadrupletonSetAsUnmodifiableTest::collectIf;
            this.payloads.newEmpty = QuadrupletonSetAsUnmodifiableTest::newEmpty;
            this.payloads.groupBy = QuadrupletonSetAsUnmodifiableTest::groupBy;
            this.payloads.zip = QuadrupletonSetAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = QuadrupletonSetAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = QuadrupletonSetAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(QuadrupletonSetAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = QuadrupletonSetAsUnmodifiableTest::tap;
            this.payloads.collectBoolean = QuadrupletonSetAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = QuadrupletonSetAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = QuadrupletonSetAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = QuadrupletonSetAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = QuadrupletonSetAsUnmodifiableTest::collectFloat;
            this.payloads.collectInt = QuadrupletonSetAsUnmodifiableTest::collectInt;
            this.payloads.collectLong = QuadrupletonSetAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = QuadrupletonSetAsUnmodifiableTest::collectShort;
        }
    }
}
