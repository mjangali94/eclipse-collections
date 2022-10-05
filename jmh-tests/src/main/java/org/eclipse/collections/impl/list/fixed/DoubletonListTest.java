/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.fixed;

import java.util.ArrayList;
import java.util.Comparator;
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

/**
 * JUnit test for {@link DoubletonList}.
 */
public class DoubletonListTest extends AbstractMemoryEfficientMutableListTestCase {

    @Override
    protected int getSize() {
        return 2;
    }

    @Override
    protected Class<?> getListType() {
        return DoubletonList.class;
    }

    @Test
    public void testClone() {
        MutableList<String> growableList = this.list.clone();
        Verify.assertEqualsAndHashCode(this.list, growableList);
        Verify.assertInstanceOf(DoubletonList.class, growableList);
    }

    @Test
    public void testContains() {
        Assert.assertTrue(this.list.contains("1"));
        Assert.assertTrue(this.list.contains("2"));
        Assert.assertFalse(this.list.contains("3"));
    }

    @Test
    public void testRemove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.list.remove(0));
    }

    @Test
    public void testAddAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.list.add(0, "1"));
    }

    @Test
    public void testAdd() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.list.add("1"));
    }

    @Test
    public void testAddingAllToOtherList() {
        List<String> newList = new ArrayList<>(this.list);
        newList.add("3");
        Verify.assertStartsWith(newList, "1", "2", "3");
    }

    @Test
    public void testGet() {
        Verify.assertStartsWith(this.list, "1", "2");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(2));
    }

    @Test
    public void testSet() {
        Assert.assertEquals("1", this.list.set(0, "2"));
        Assert.assertEquals("2", this.list.set(1, "1"));
        Assert.assertEquals(FastList.newListWith("2", "1"), this.list);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.set(2, "0"));
    }

    @Test
    public void testSerialization() {
        Verify.assertPostSerializedEqualsAndHashCode(this.list);
        MutableList<String> copy = SerializeTestHelper.serializeDeserialize(this.list);
        Verify.assertInstanceOf(DoubletonList.class, copy);
        Verify.assertSize(2, copy);
        Verify.assertContainsAll(copy, "1", "2");
        Verify.assertNotContains("3", copy);
    }

    @Test
    public void testEqualsAndHashCode() {
        MutableList<String> one = this.classUnderTest();
        List<String> oneA = new ArrayList<>(one);
        Verify.assertEqualsAndHashCode(one, oneA);
        Verify.assertPostSerializedEqualsAndHashCode(one);
    }

    @Test
    public void testForEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = this.classUnderTest();
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2"), result);
    }

    @Test
    public void testForEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = this.classUnderTest();
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2"), result);
        Assert.assertEquals(1, indexSum[0]);
    }

    @Test
    public void testForEachWith() {
        MutableList<String> result = Lists.mutable.of();
        this.list.forEachWith(Procedures2.fromProcedure(result::add), null);
        Assert.assertEquals(FastList.newListWith("1", "2"), result);
    }

    @Test
    public void testGetFirstGetLast() {
        Assert.assertEquals("1", this.list.getFirst());
        Assert.assertEquals("2", this.list.getLast());
    }

    @Test
    public void testForLoop() {
        MutableList<String> list = Lists.fixedSize.of("one", "two");
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO");
        for (String each : list) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void testSubList() {
        MutableList<String> list = Lists.fixedSize.of("one", "two");
        MutableList<String> subList = list.subList(0, 2);
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO");
        for (String each : subList) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
        Assert.assertEquals("one", subList.getFirst());
        Assert.assertEquals("two", subList.getLast());
        MutableList<String> subList2 = list.subList(1, 2);
        Assert.assertEquals("two", subList2.getFirst());
        Assert.assertEquals("two", subList2.getLast());
        MutableList<String> subList3 = list.subList(0, 1);
        Assert.assertEquals("one", subList3.getFirst());
        Assert.assertEquals("one", subList3.getLast());
    }

    @Test
    public void without() {
        MutableList<Integer> list = new DoubletonList<>(2, 2);
        Assert.assertSame(list, list.without(9));
        list = list.without(2);
        Verify.assertListsEqual(FastList.newListWith(2), list);
        Verify.assertInstanceOf(SingletonList.class, list);
    }

    @Test
    public void testGetOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.list.getOnly());
    }

    @Override
    @Test
    public void sort() {
        super.sort();
        MutableList<String> strings = this.classUnderTest().reverseThis();
        strings.sort(Comparator.naturalOrder());
        Assert.assertEquals(this.classUnderTest(), strings);
        MutableList<String> strings2 = this.classUnderTest().reverseThis();
        strings2.sort(null);
        Assert.assertEquals(this.classUnderTest(), strings2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubletonListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetClass() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetClass);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
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
        public void benchmark_testSerialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSerialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
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
        public void benchmark_testGetFirstGetLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetFirstGetLast);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> payload) throws java.lang.Throwable {
            this.instance = new DoubletonListTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testGetClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> subList_methodsThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testAddAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testAdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testAddingAllToOtherList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testGet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testSerialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testGetFirstGetLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testForLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> testGetOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonListTest> sort;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testGetClass = DoubletonListTest::testGetClass;
            this.payloads.replaceAll = DoubletonListTest::replaceAll;
            this.payloads.sortThis = DoubletonListTest::sortThis;
            this.payloads.sortThisWithComparator = DoubletonListTest::sortThisWithComparator;
            this.payloads.sortThisBy = DoubletonListTest::sortThisBy;
            this.payloads.sortThisByInt = DoubletonListTest::sortThisByInt;
            this.payloads.sortThisByBoolean = DoubletonListTest::sortThisByBoolean;
            this.payloads.sortThisByChar = DoubletonListTest::sortThisByChar;
            this.payloads.sortThisByByte = DoubletonListTest::sortThisByByte;
            this.payloads.sortThisByShort = DoubletonListTest::sortThisByShort;
            this.payloads.sortThisByFloat = DoubletonListTest::sortThisByFloat;
            this.payloads.sortThisByLong = DoubletonListTest::sortThisByLong;
            this.payloads.sortThisByDouble = DoubletonListTest::sortThisByDouble;
            this.payloads.reverseThis = DoubletonListTest::reverseThis;
            this.payloads.toReversed = DoubletonListTest::toReversed;
            this.payloads.with = DoubletonListTest::with;
            this.payloads.withAll = DoubletonListTest::withAll;
            this.payloads.withoutAll = DoubletonListTest::withoutAll;
            this.payloads.toStack = DoubletonListTest::toStack;
            this.payloads.aggregateByMutating = DoubletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = DoubletonListTest::aggregateByNonMutating;
            this.payloads.add = DoubletonListTest::add;
            this.payloads.addAtIndex = DoubletonListTest::addAtIndex;
            this.payloads.addAll = DoubletonListTest::addAll;
            this.payloads.addAllAtIndex = DoubletonListTest::addAllAtIndex;
            this.payloads.addAllIterable = DoubletonListTest::addAllIterable;
            this.payloads.removeIndex = DoubletonListTest::removeIndex;
            this.payloads.remove = DoubletonListTest::remove;
            this.payloads.removeAll = DoubletonListTest::removeAll;
            this.payloads.removeAllIterable = DoubletonListTest::removeAllIterable;
            this.payloads.retainAll = DoubletonListTest::retainAll;
            this.payloads.retainAllIterable = DoubletonListTest::retainAllIterable;
            this.payloads.clear = DoubletonListTest::clear;
            this.payloads.subList_methodsThrow = DoubletonListTest::subList_methodsThrow;
            this.payloads.testClone = DoubletonListTest::testClone;
            this.payloads.testContains = DoubletonListTest::testContains;
            this.payloads.testRemove = DoubletonListTest::testRemove;
            this.payloads.testAddAtIndex = DoubletonListTest::testAddAtIndex;
            this.payloads.testAdd = DoubletonListTest::testAdd;
            this.payloads.testAddingAllToOtherList = DoubletonListTest::testAddingAllToOtherList;
            this.payloads.testGet = DoubletonListTest::testGet;
            this.payloads.testSet = DoubletonListTest::testSet;
            this.payloads.testSerialization = DoubletonListTest::testSerialization;
            this.payloads.testEqualsAndHashCode = DoubletonListTest::testEqualsAndHashCode;
            this.payloads.testForEach = DoubletonListTest::testForEach;
            this.payloads.testForEachWithIndex = DoubletonListTest::testForEachWithIndex;
            this.payloads.testForEachWith = DoubletonListTest::testForEachWith;
            this.payloads.testGetFirstGetLast = DoubletonListTest::testGetFirstGetLast;
            this.payloads.testForLoop = DoubletonListTest::testForLoop;
            this.payloads.testSubList = DoubletonListTest::testSubList;
            this.payloads.without = DoubletonListTest::without;
            this.payloads.testGetOnly = DoubletonListTest::testGetOnly;
            this.payloads.sort = DoubletonListTest::sort;
        }
    }
}
