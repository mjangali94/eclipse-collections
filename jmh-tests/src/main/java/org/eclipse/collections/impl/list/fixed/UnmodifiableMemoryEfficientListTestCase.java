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

import java.util.ListIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test to check that {@link AbstractMemoryEfficientMutableList}s are Unmodifiable.
 */
public abstract class UnmodifiableMemoryEfficientListTestCase<T> extends UnmodifiableMutableCollectionTestCase<T> {

    @Override
    protected abstract MutableList<T> getCollection();

    @Test
    public void listIterator() {
        MutableList<T> collection = this.getCollection();
        ListIterator<T> it = collection.listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        it.next();
        Assert.assertEquals(1, it.nextIndex());
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
        it.set(null);
        Assert.assertNotEquals(this.getCollection(), collection);
    }

    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().addAll(0, FastList.<T>newList().with((T) null)));
    }

    @Test
    public void addAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().add(0, null));
    }

    @Test
    public void removeFromIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().remove(0));
    }

    @Test
    public void subList() {
        MutableList<T> subList = this.getCollection().subList(0, 1);
        Assert.assertThrows(UnsupportedOperationException.class, subList::clear);
    }

    @Override
    @Test
    public void newEmpty() {
        MutableList<T> list = this.getCollection().newEmpty();
        list.add(null);
        Verify.assertContains(null, list);
    }

    @Test
    public void corresponds() {
        MutableList<T> mutableList1 = this.getCollection();
        MutableList<Integer> mutableList2 = mutableList1.collect(element -> Integer.valueOf(element.toString()) + 1);
        Assert.assertTrue(mutableList1.corresponds(mutableList2, (argument1, argument2) -> Integer.valueOf(argument1.toString()) < argument2));
        Assert.assertFalse(mutableList1.corresponds(mutableList2, (argument1, argument2) -> Integer.valueOf(argument1.toString()) > argument2));
        MutableList<Integer> mutableList3 = this.getCollection().collect(element -> Integer.valueOf(element.toString()));
        mutableList3.add(0);
        Assert.assertFalse(mutableList1.corresponds(mutableList3, Predicates2.alwaysTrue()));
    }

    @Test
    public void detectIndex() {
        MutableList<T> mutableList = this.getCollection();
        Assert.assertEquals(0, mutableList.detectIndex(element -> Integer.valueOf(element.toString()) == 1));
        Assert.assertEquals(-1, mutableList.detectIndex(element -> Integer.valueOf(element.toString()) == 0));
    }

    @Test
    public void detectLastIndex() {
        MutableList<T> mutableList = this.getCollection();
        Assert.assertEquals(0, mutableList.detectLastIndex(element -> Integer.valueOf(element.toString()) == 1));
        Assert.assertEquals(-1, mutableList.detectLastIndex(element -> Integer.valueOf(element.toString()) == 0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableMemoryEfficientListTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAppendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAppendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableMemoryEfficientListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMemoryEfficientListTestCase> detectLastIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = UnmodifiableMemoryEfficientListTestCase::testMakeString;
            this.payloads.testAppendString = UnmodifiableMemoryEfficientListTestCase::testAppendString;
            this.payloads.select = UnmodifiableMemoryEfficientListTestCase::select;
            this.payloads.selectWith = UnmodifiableMemoryEfficientListTestCase::selectWith;
            this.payloads.reject = UnmodifiableMemoryEfficientListTestCase::reject;
            this.payloads.rejectWith = UnmodifiableMemoryEfficientListTestCase::rejectWith;
            this.payloads.partition = UnmodifiableMemoryEfficientListTestCase::partition;
            this.payloads.partitionWith = UnmodifiableMemoryEfficientListTestCase::partitionWith;
            this.payloads.collect = UnmodifiableMemoryEfficientListTestCase::collect;
            this.payloads.collectInt = UnmodifiableMemoryEfficientListTestCase::collectInt;
            this.payloads.collectBoolean = UnmodifiableMemoryEfficientListTestCase::collectBoolean;
            this.payloads.collectByte = UnmodifiableMemoryEfficientListTestCase::collectByte;
            this.payloads.collectChar = UnmodifiableMemoryEfficientListTestCase::collectChar;
            this.payloads.collectDouble = UnmodifiableMemoryEfficientListTestCase::collectDouble;
            this.payloads.collectFloat = UnmodifiableMemoryEfficientListTestCase::collectFloat;
            this.payloads.collectLong = UnmodifiableMemoryEfficientListTestCase::collectLong;
            this.payloads.collectShort = UnmodifiableMemoryEfficientListTestCase::collectShort;
            this.payloads.collectWith = UnmodifiableMemoryEfficientListTestCase::collectWith;
            this.payloads.collectIf = UnmodifiableMemoryEfficientListTestCase::collectIf;
            this.payloads.groupBy = UnmodifiableMemoryEfficientListTestCase::groupBy;
            this.payloads.zip = UnmodifiableMemoryEfficientListTestCase::zip;
            this.payloads.zipWithIndex = UnmodifiableMemoryEfficientListTestCase::zipWithIndex;
            this.payloads.flatCollect = UnmodifiableMemoryEfficientListTestCase::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMemoryEfficientListTestCase::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = UnmodifiableMemoryEfficientListTestCase::tap;
            this.payloads.listIterator = UnmodifiableMemoryEfficientListTestCase::listIterator;
            this.payloads.addAllAtIndex = UnmodifiableMemoryEfficientListTestCase::addAllAtIndex;
            this.payloads.addAtIndex = UnmodifiableMemoryEfficientListTestCase::addAtIndex;
            this.payloads.removeFromIndex = UnmodifiableMemoryEfficientListTestCase::removeFromIndex;
            this.payloads.subList = UnmodifiableMemoryEfficientListTestCase::subList;
            this.payloads.newEmpty = UnmodifiableMemoryEfficientListTestCase::newEmpty;
            this.payloads.corresponds = UnmodifiableMemoryEfficientListTestCase::corresponds;
            this.payloads.detectIndex = UnmodifiableMemoryEfficientListTestCase::detectIndex;
            this.payloads.detectLastIndex = UnmodifiableMemoryEfficientListTestCase::detectLastIndex;
        }
    }
}
