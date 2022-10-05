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

import java.util.ArrayList;
import java.util.List;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Procedures2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class SextupletonListTest extends AbstractMemoryEfficientMutableListTestCase {

    @Override
    protected int getSize() {
        return 6;
    }

    @Override
    protected Class<?> getListType() {
        return SextupletonList.class;
    }

    @Test
    public void testClone() {
        MutableList<String> growableList = this.list.clone();
        Verify.assertEqualsAndHashCode(this.list, growableList);
        Verify.assertInstanceOf(SextupletonList.class, growableList);
    }

    @Test
    public void testEqualsAndHashCode() {
        MutableList<String> one = Lists.fixedSize.of("1", "2", "3", "4", "5", "6");
        List<String> oneA = new ArrayList<>(one);
        Verify.assertEqualsAndHashCode(one, oneA);
        Verify.assertPostSerializedEqualsAndHashCode(one);
    }

    @Test
    public void testContains() {
        Assert.assertTrue(this.list.contains("1"));
        Assert.assertTrue(this.list.contains("2"));
        Assert.assertTrue(this.list.contains("3"));
        Assert.assertTrue(this.list.contains("4"));
        Assert.assertTrue(this.list.contains("5"));
        Assert.assertTrue(this.list.contains("6"));
        Assert.assertFalse(this.list.contains("7"));
    }

    @Test
    public void testRemove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.list.remove(0));
        this.assertUnchanged();
    }

    @Test
    public void testAddAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.list.add(0, "1"));
        this.assertUnchanged();
    }

    @Test
    public void testAdd() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.list.add("1"));
        this.assertUnchanged();
    }

    @Test
    public void testAddingAllToOtherList() {
        List<String> newList = new ArrayList<>(this.list);
        newList.add("7");
        Verify.assertStartsWith(newList, "1", "2", "3", "4", "5", "6", "7");
    }

    @Test
    public void testGet() {
        Verify.assertStartsWith(this.list, "1", "2", "3", "4", "5", "6");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(6));
    }

    @Test
    public void testSet() {
        MutableList<String> list = Lists.fixedSize.of("1", "2", "3", "4", "5", "6");
        Assert.assertEquals("1", list.set(0, "6"));
        Assert.assertEquals("2", list.set(1, "5"));
        Assert.assertEquals("3", list.set(2, "4"));
        Assert.assertEquals("4", list.set(3, "3"));
        Assert.assertEquals("5", list.set(4, "2"));
        Assert.assertEquals("6", list.set(5, "1"));
        Assert.assertEquals(FastList.newListWith("6", "5", "4", "3", "2", "1"), list);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.set(6, "0"));
    }

    private void assertUnchanged() {
        Verify.assertSize(6, this.list);
        Verify.assertNotContains("7", this.list);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6"), this.list);
    }

    @Test
    public void testSerializableEqualsAndHashCode() {
        Verify.assertPostSerializedEqualsAndHashCode(this.list);
        MutableList<String> copyOfList = SerializeTestHelper.serializeDeserialize(this.list);
        Assert.assertNotSame(this.list, copyOfList);
    }

    @Test
    public void testGetFirstGetLast() {
        MutableList<String> list6 = Lists.fixedSize.of("1", "2", "3", "4", "5", "6");
        Assert.assertEquals("1", list6.getFirst());
        Assert.assertEquals("6", list6.getLast());
    }

    @Test
    public void testForEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4", "5", "6");
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6"), result);
    }

    @Test
    public void testForEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4", "5", "6");
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6"), result);
        Assert.assertEquals(15, indexSum[0]);
    }

    @Test
    public void testForEachWith() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4", "5", "6");
        source.forEachWith(Procedures2.fromProcedure(result::add), null);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5", "6"), result);
    }

    @Test
    public void testForLoop() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three", "four", "five", "six");
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX");
        for (String each : list) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void testSubList() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three", "four", "five", "six");
        MutableList<String> subList = list.subList(0, 5);
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX");
        for (String each : subList) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void without() {
        MutableList<Integer> list = new SextupletonList<>(1, 2, 3, 2, 3, 4);
        Assert.assertSame(list, list.without(9));
        list = list.without(2);
        Verify.assertListsEqual(FastList.newListWith(1, 3, 2, 3, 4), list);
        Verify.assertInstanceOf(QuintupletonList.class, list);
    }

    @Test
    public void testGetOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.list.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SextupletonListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetClass() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetClass);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
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
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
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
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
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
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
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
        public void benchmark_subList_methodsThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList_methodsThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAdd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAdd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddingAllToOtherList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddingAllToOtherList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSerializableEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSerializableEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetFirstGetLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetFirstGetLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForLoop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> payload) throws java.lang.Throwable {
            this.instance = new SextupletonListTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testGetClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> subList_methodsThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testAddAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testAdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testAddingAllToOtherList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testGet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testSerializableEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testGetFirstGetLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testForLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SextupletonListTest> testGetOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testGetClass = SextupletonListTest::testGetClass;
            this.payloads.replaceAll = SextupletonListTest::replaceAll;
            this.payloads.sort = SextupletonListTest::sort;
            this.payloads.sortThis = SextupletonListTest::sortThis;
            this.payloads.sortThisWithComparator = SextupletonListTest::sortThisWithComparator;
            this.payloads.sortThisBy = SextupletonListTest::sortThisBy;
            this.payloads.sortThisByInt = SextupletonListTest::sortThisByInt;
            this.payloads.sortThisByBoolean = SextupletonListTest::sortThisByBoolean;
            this.payloads.sortThisByChar = SextupletonListTest::sortThisByChar;
            this.payloads.sortThisByByte = SextupletonListTest::sortThisByByte;
            this.payloads.sortThisByShort = SextupletonListTest::sortThisByShort;
            this.payloads.sortThisByFloat = SextupletonListTest::sortThisByFloat;
            this.payloads.sortThisByLong = SextupletonListTest::sortThisByLong;
            this.payloads.sortThisByDouble = SextupletonListTest::sortThisByDouble;
            this.payloads.reverseThis = SextupletonListTest::reverseThis;
            this.payloads.toReversed = SextupletonListTest::toReversed;
            this.payloads.with = SextupletonListTest::with;
            this.payloads.withAll = SextupletonListTest::withAll;
            this.payloads.withoutAll = SextupletonListTest::withoutAll;
            this.payloads.toStack = SextupletonListTest::toStack;
            this.payloads.aggregateByMutating = SextupletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SextupletonListTest::aggregateByNonMutating;
            this.payloads.add = SextupletonListTest::add;
            this.payloads.addAtIndex = SextupletonListTest::addAtIndex;
            this.payloads.addAll = SextupletonListTest::addAll;
            this.payloads.addAllAtIndex = SextupletonListTest::addAllAtIndex;
            this.payloads.addAllIterable = SextupletonListTest::addAllIterable;
            this.payloads.removeIndex = SextupletonListTest::removeIndex;
            this.payloads.remove = SextupletonListTest::remove;
            this.payloads.removeAll = SextupletonListTest::removeAll;
            this.payloads.removeAllIterable = SextupletonListTest::removeAllIterable;
            this.payloads.retainAll = SextupletonListTest::retainAll;
            this.payloads.retainAllIterable = SextupletonListTest::retainAllIterable;
            this.payloads.clear = SextupletonListTest::clear;
            this.payloads.subList_methodsThrow = SextupletonListTest::subList_methodsThrow;
            this.payloads.testClone = SextupletonListTest::testClone;
            this.payloads.testEqualsAndHashCode = SextupletonListTest::testEqualsAndHashCode;
            this.payloads.testContains = SextupletonListTest::testContains;
            this.payloads.testRemove = SextupletonListTest::testRemove;
            this.payloads.testAddAtIndex = SextupletonListTest::testAddAtIndex;
            this.payloads.testAdd = SextupletonListTest::testAdd;
            this.payloads.testAddingAllToOtherList = SextupletonListTest::testAddingAllToOtherList;
            this.payloads.testGet = SextupletonListTest::testGet;
            this.payloads.testSet = SextupletonListTest::testSet;
            this.payloads.testSerializableEqualsAndHashCode = SextupletonListTest::testSerializableEqualsAndHashCode;
            this.payloads.testGetFirstGetLast = SextupletonListTest::testGetFirstGetLast;
            this.payloads.testForEach = SextupletonListTest::testForEach;
            this.payloads.testForEachWithIndex = SextupletonListTest::testForEachWithIndex;
            this.payloads.testForEachWith = SextupletonListTest::testForEachWith;
            this.payloads.testForLoop = SextupletonListTest::testForLoop;
            this.payloads.testSubList = SextupletonListTest::testSubList;
            this.payloads.without = SextupletonListTest::without;
            this.payloads.testGetOnly = SextupletonListTest::testGetOnly;
        }
    }
}
