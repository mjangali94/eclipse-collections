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

import java.util.ListIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.list.fixed.UnmodifiableMemoryEfficientListTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link UnmodifiableMutableList}.
 */
public abstract class UnmodifiableMutableListTestCase extends UnmodifiableMemoryEfficientListTestCase<Integer> {

    @Test
    public void testClone() {
        Assert.assertEquals(this.getCollection(), this.getCollection().clone());
        Assert.assertNotSame(this.getCollection(), this.getCollection().clone());
    }

    @Test
    public void serialization() {
        Verify.assertPostSerializedEqualsAndHashCode(this.getCollection());
    }

    @Override
    @Test
    public void subList() {
        super.subList();
        MutableList<Integer> subList = this.getCollection().subList(0, 1);
        Assert.assertThrows(UnsupportedOperationException.class, subList::clear);
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.set(0, null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.add(0, null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.add(null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.remove(0));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.remove(null));
    }

    @Override
    @Test
    public void listIterator() {
        ListIterator<Integer> it = this.getCollection().listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        it.next();
        Assert.assertEquals(1, it.nextIndex());
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.set(null));
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
    }

    @Test
    public void subListListIterator() {
        ListIterator<Integer> it = this.getCollection().subList(0, 1).listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        it.next();
        Assert.assertEquals(1, it.nextIndex());
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.set(null));
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
        Assert.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
    }

    @Test
    public void set() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().set(0, null));
    }

    @Override
    @Test
    public void addAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().add(0, null));
    }

    @Override
    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().addAll(0, null));
    }

    @Test
    public void removeAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().remove(0));
    }

    @Test
    public void setAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().set(0, null));
    }

    @Test
    public void sortThis() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThis());
    }

    @Test
    public void sortThisWithComparator() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThis(Comparators.naturalOrder()));
    }

    @Test
    public void sortThisBy() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisBy(String::valueOf));
    }

    @Test
    public void sortThisByBoolean() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByBoolean(null));
    }

    @Test
    public void sortThisByChar() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByChar(null));
    }

    @Test
    public void sortThisByByte() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByByte(null));
    }

    @Test
    public void sortThisByShort() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByShort(null));
    }

    @Test
    public void sortThisByInt() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByInt(null));
    }

    @Test
    public void sortThisByFloat() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByFloat(null));
    }

    @Test
    public void sortThisByLong() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByLong(null));
    }

    @Test
    public void sortThisByDouble() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().sortThisByDouble(null));
    }

    @Test
    public void reverseThis() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getCollection().reverseThis());
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(this.getCollection(), this.getCollection());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableMutableListTestCase instance;

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
        public void benchmark_removeFromIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromIndex);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListListIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListListIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableMutableListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> testMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> testAppendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> removeFromIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> subListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> setAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListTestCase> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.removeIfWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::removeIfWith, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::removeAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::retainAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.testMakeString = UnmodifiableMutableListTestCase::testMakeString;
            this.payloads.testAppendString = UnmodifiableMutableListTestCase::testAppendString;
            this.payloads.select = UnmodifiableMutableListTestCase::select;
            this.payloads.selectWith = UnmodifiableMutableListTestCase::selectWith;
            this.payloads.reject = UnmodifiableMutableListTestCase::reject;
            this.payloads.rejectWith = UnmodifiableMutableListTestCase::rejectWith;
            this.payloads.partition = UnmodifiableMutableListTestCase::partition;
            this.payloads.partitionWith = UnmodifiableMutableListTestCase::partitionWith;
            this.payloads.collect = UnmodifiableMutableListTestCase::collect;
            this.payloads.collectInt = UnmodifiableMutableListTestCase::collectInt;
            this.payloads.collectBoolean = UnmodifiableMutableListTestCase::collectBoolean;
            this.payloads.collectByte = UnmodifiableMutableListTestCase::collectByte;
            this.payloads.collectChar = UnmodifiableMutableListTestCase::collectChar;
            this.payloads.collectDouble = UnmodifiableMutableListTestCase::collectDouble;
            this.payloads.collectFloat = UnmodifiableMutableListTestCase::collectFloat;
            this.payloads.collectLong = UnmodifiableMutableListTestCase::collectLong;
            this.payloads.collectShort = UnmodifiableMutableListTestCase::collectShort;
            this.payloads.collectWith = UnmodifiableMutableListTestCase::collectWith;
            this.payloads.collectIf = UnmodifiableMutableListTestCase::collectIf;
            this.payloads.groupBy = UnmodifiableMutableListTestCase::groupBy;
            this.payloads.zip = UnmodifiableMutableListTestCase::zip;
            this.payloads.zipWithIndex = UnmodifiableMutableListTestCase::zipWithIndex;
            this.payloads.flatCollect = UnmodifiableMutableListTestCase::flatCollect;
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListTestCase::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.tap = UnmodifiableMutableListTestCase::tap;
            this.payloads.removeFromIndex = UnmodifiableMutableListTestCase::removeFromIndex;
            this.payloads.newEmpty = UnmodifiableMutableListTestCase::newEmpty;
            this.payloads.corresponds = UnmodifiableMutableListTestCase::corresponds;
            this.payloads.detectIndex = UnmodifiableMutableListTestCase::detectIndex;
            this.payloads.detectLastIndex = UnmodifiableMutableListTestCase::detectLastIndex;
            this.payloads.testClone = UnmodifiableMutableListTestCase::testClone;
            this.payloads.serialization = UnmodifiableMutableListTestCase::serialization;
            this.payloads.subList = UnmodifiableMutableListTestCase::subList;
            this.payloads.listIterator = UnmodifiableMutableListTestCase::listIterator;
            this.payloads.subListListIterator = UnmodifiableMutableListTestCase::subListListIterator;
            this.payloads.set = UnmodifiableMutableListTestCase::set;
            this.payloads.addAtIndex = UnmodifiableMutableListTestCase::addAtIndex;
            this.payloads.addAllAtIndex = UnmodifiableMutableListTestCase::addAllAtIndex;
            this.payloads.removeAtIndex = UnmodifiableMutableListTestCase::removeAtIndex;
            this.payloads.setAtIndex = UnmodifiableMutableListTestCase::setAtIndex;
            this.payloads.sortThis = UnmodifiableMutableListTestCase::sortThis;
            this.payloads.sortThisWithComparator = UnmodifiableMutableListTestCase::sortThisWithComparator;
            this.payloads.sortThisBy = UnmodifiableMutableListTestCase::sortThisBy;
            this.payloads.sortThisByBoolean = UnmodifiableMutableListTestCase::sortThisByBoolean;
            this.payloads.sortThisByChar = UnmodifiableMutableListTestCase::sortThisByChar;
            this.payloads.sortThisByByte = UnmodifiableMutableListTestCase::sortThisByByte;
            this.payloads.sortThisByShort = UnmodifiableMutableListTestCase::sortThisByShort;
            this.payloads.sortThisByInt = UnmodifiableMutableListTestCase::sortThisByInt;
            this.payloads.sortThisByFloat = UnmodifiableMutableListTestCase::sortThisByFloat;
            this.payloads.sortThisByLong = UnmodifiableMutableListTestCase::sortThisByLong;
            this.payloads.sortThisByDouble = UnmodifiableMutableListTestCase::sortThisByDouble;
            this.payloads.reverseThis = UnmodifiableMutableListTestCase::reverseThis;
            this.payloads.testEquals = UnmodifiableMutableListTestCase::testEquals;
        }
    }
}
