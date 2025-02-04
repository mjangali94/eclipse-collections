/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.junit.Assert;
import org.junit.Test;

public class CollectionAdapterAsUnmodifiableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableCollection<Integer> getCollection() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        return new CollectionAdapter<>(list).asUnmodifiable();
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().select(ignored -> true));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().select(ignored -> false));
    }

    @Override
    @Test
    public void selectWith() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().selectWith((ignored1, ignored2) -> true, null));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().selectWith((ignored1, ignored2) -> false, null));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().reject(ignored1 -> false));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().reject(ignored -> true));
    }

    @Override
    @Test
    public void rejectWith() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().rejectWith((ignored11, ignored21) -> false, null));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().rejectWith((ignored1, ignored2) -> true, null));
    }

    @Override
    @Test
    public void partition() {
        PartitionMutableCollection<?> partition = this.getCollection().partition(ignored -> true);
        Assert.assertEquals(this.getCollection().toList(), partition.getSelected());
        Assert.assertNotEquals(this.getCollection().toList(), partition.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        PartitionMutableCollection<?> partition = this.getCollection().partitionWith((ignored1, ignored2) -> true, null);
        Assert.assertEquals(this.getCollection().toList(), partition.getSelected());
        Assert.assertNotEquals(this.getCollection().toList(), partition.getRejected());
    }

    @Override
    @Test
    public void collect() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().collect(Functions.getPassThru()));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().collect(Object::getClass));
    }

    @Override
    @Test
    public void collectWith() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().collectWith(Functions2.fromFunction(Functions.getPassThru()), null));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().collectWith(Functions2.fromFunction(Object::getClass), null));
    }

    @Override
    @Test
    public void collectIf() {
        Assert.assertEquals(this.getCollection().toList(), this.getCollection().collectIf(ignored -> true, Functions.getPassThru()));
        Assert.assertNotEquals(this.getCollection().toList(), this.getCollection().collectIf(ignored -> false, Object::getClass));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectionAdapterAsUnmodifiableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> payload) throws java.lang.Throwable {
            this.instance = new CollectionAdapterAsUnmodifiableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectionAdapterAsUnmodifiableTest> collectIf;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = CollectionAdapterAsUnmodifiableTest::testMakeString;
            this.payloads.testAppendString = CollectionAdapterAsUnmodifiableTest::testAppendString;
            this.payloads.collectInt = CollectionAdapterAsUnmodifiableTest::collectInt;
            this.payloads.collectBoolean = CollectionAdapterAsUnmodifiableTest::collectBoolean;
            this.payloads.collectByte = CollectionAdapterAsUnmodifiableTest::collectByte;
            this.payloads.collectChar = CollectionAdapterAsUnmodifiableTest::collectChar;
            this.payloads.collectDouble = CollectionAdapterAsUnmodifiableTest::collectDouble;
            this.payloads.collectFloat = CollectionAdapterAsUnmodifiableTest::collectFloat;
            this.payloads.collectLong = CollectionAdapterAsUnmodifiableTest::collectLong;
            this.payloads.collectShort = CollectionAdapterAsUnmodifiableTest::collectShort;
            this.payloads.newEmpty = CollectionAdapterAsUnmodifiableTest::newEmpty;
            this.payloads.groupBy = CollectionAdapterAsUnmodifiableTest::groupBy;
            this.payloads.zip = CollectionAdapterAsUnmodifiableTest::zip;
            this.payloads.zipWithIndex = CollectionAdapterAsUnmodifiableTest::zipWithIndex;
            this.payloads.flatCollect = CollectionAdapterAsUnmodifiableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectionAdapterAsUnmodifiableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = CollectionAdapterAsUnmodifiableTest::tap;
            this.payloads.select = CollectionAdapterAsUnmodifiableTest::select;
            this.payloads.selectWith = CollectionAdapterAsUnmodifiableTest::selectWith;
            this.payloads.reject = CollectionAdapterAsUnmodifiableTest::reject;
            this.payloads.rejectWith = CollectionAdapterAsUnmodifiableTest::rejectWith;
            this.payloads.partition = CollectionAdapterAsUnmodifiableTest::partition;
            this.payloads.partitionWith = CollectionAdapterAsUnmodifiableTest::partitionWith;
            this.payloads.collect = CollectionAdapterAsUnmodifiableTest::collect;
            this.payloads.collectWith = CollectionAdapterAsUnmodifiableTest::collectWith;
            this.payloads.collectIf = CollectionAdapterAsUnmodifiableTest::collectIf;
        }
    }
}
