/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderHashBagAsReadUntouchableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableBag<Integer> getCollection() {
        return MultiReaderHashBag.newBagWith(1, 1).asReadUntouchable();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences() {
        this.getCollection().addOccurrences(1, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences() {
        this.getCollection().removeOccurrences(1, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setOccurrences() {
        this.getCollection().setOccurrences(1, 1);
    }

    @Test
    public void occurrencesOf() {
        Assert.assertEquals(2, this.getCollection().occurrencesOf(1));
        Assert.assertEquals(0, this.getCollection().occurrencesOf(0));
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(1, this.getCollection().sizeDistinct());
    }

    @Test
    public void toMapOfItemToCount() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 2), this.getCollection().toMapOfItemToCount());
    }

    @Test
    public void toStringOfItemToCount() {
        Assert.assertEquals("{1=2}", this.getCollection().toStringOfItemToCount());
    }

    @Test
    public void forEachWithOccurrences() {
        int[] sum = new int[1];
        this.getCollection().forEachWithOccurrences((each, occurrences) -> {
            if (occurrences > 1) {
                sum[0] += each * occurrences;
            }
        });
        Assert.assertEquals(2, sum[0]);
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = MultiReaderHashBag.newBagWith("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5").asReadUntouchable();
        MutableSet<String> expected = Sets.mutable.with("0", "4", "5");
        MutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void distinctView() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().distinctView());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MultiReaderHashBagAsReadUntouchableTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderHashBagAsReadUntouchableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagAsReadUntouchableTest> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = MultiReaderHashBagAsReadUntouchableTest::testMakeString;
            this.payloads.testAppendString = MultiReaderHashBagAsReadUntouchableTest::testAppendString;
            this.payloads.select = MultiReaderHashBagAsReadUntouchableTest::select;
            this.payloads.selectWith = MultiReaderHashBagAsReadUntouchableTest::selectWith;
            this.payloads.reject = MultiReaderHashBagAsReadUntouchableTest::reject;
            this.payloads.rejectWith = MultiReaderHashBagAsReadUntouchableTest::rejectWith;
            this.payloads.partition = MultiReaderHashBagAsReadUntouchableTest::partition;
            this.payloads.partitionWith = MultiReaderHashBagAsReadUntouchableTest::partitionWith;
            this.payloads.collect = MultiReaderHashBagAsReadUntouchableTest::collect;
            this.payloads.collectInt = MultiReaderHashBagAsReadUntouchableTest::collectInt;
            this.payloads.collectBoolean = MultiReaderHashBagAsReadUntouchableTest::collectBoolean;
            this.payloads.collectByte = MultiReaderHashBagAsReadUntouchableTest::collectByte;
            this.payloads.collectChar = MultiReaderHashBagAsReadUntouchableTest::collectChar;
            this.payloads.collectDouble = MultiReaderHashBagAsReadUntouchableTest::collectDouble;
            this.payloads.collectFloat = MultiReaderHashBagAsReadUntouchableTest::collectFloat;
            this.payloads.collectLong = MultiReaderHashBagAsReadUntouchableTest::collectLong;
            this.payloads.collectShort = MultiReaderHashBagAsReadUntouchableTest::collectShort;
            this.payloads.collectWith = MultiReaderHashBagAsReadUntouchableTest::collectWith;
            this.payloads.collectIf = MultiReaderHashBagAsReadUntouchableTest::collectIf;
            this.payloads.newEmpty = MultiReaderHashBagAsReadUntouchableTest::newEmpty;
            this.payloads.groupBy = MultiReaderHashBagAsReadUntouchableTest::groupBy;
            this.payloads.zip = MultiReaderHashBagAsReadUntouchableTest::zip;
            this.payloads.zipWithIndex = MultiReaderHashBagAsReadUntouchableTest::zipWithIndex;
            this.payloads.flatCollect = MultiReaderHashBagAsReadUntouchableTest::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = MultiReaderHashBagAsReadUntouchableTest::tap;
            this.payloads.addOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::addOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.removeOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::removeOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.setOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagAsReadUntouchableTest::setOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.occurrencesOf = MultiReaderHashBagAsReadUntouchableTest::occurrencesOf;
            this.payloads.sizeDistinct = MultiReaderHashBagAsReadUntouchableTest::sizeDistinct;
            this.payloads.toMapOfItemToCount = MultiReaderHashBagAsReadUntouchableTest::toMapOfItemToCount;
            this.payloads.toStringOfItemToCount = MultiReaderHashBagAsReadUntouchableTest::toStringOfItemToCount;
            this.payloads.forEachWithOccurrences = MultiReaderHashBagAsReadUntouchableTest::forEachWithOccurrences;
            this.payloads.selectUnique = MultiReaderHashBagAsReadUntouchableTest::selectUnique;
            this.payloads.distinctView = MultiReaderHashBagAsReadUntouchableTest::distinctView;
        }
    }
}
