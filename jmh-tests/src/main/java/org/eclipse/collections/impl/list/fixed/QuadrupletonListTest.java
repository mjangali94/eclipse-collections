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

/**
 * JUnit test for {@link QuadrupletonList}.
 */
public class QuadrupletonListTest extends AbstractMemoryEfficientMutableListTestCase {

    @Override
    protected int getSize() {
        return 4;
    }

    @Override
    protected Class<?> getListType() {
        return QuadrupletonList.class;
    }

    @Test
    public void testClone() {
        MutableList<String> growableList = this.list.clone();
        Verify.assertEqualsAndHashCode(this.list, growableList);
        Verify.assertInstanceOf(QuadrupletonList.class, growableList);
    }

    @Test
    public void testContains() {
        Verify.assertContains("1", this.list);
        Verify.assertContains("2", this.list);
        Verify.assertContains("3", this.list);
        Verify.assertContains("4", this.list);
        Verify.assertNotContains("5", this.list);
    }

    @Test
    public void testEqualsAndHashCode() {
        MutableList<String> one = Lists.fixedSize.of("1", "2", "3", "4");
        List<String> oneA = new ArrayList<>(one);
        Verify.assertEqualsAndHashCode(one, oneA);
        Verify.assertPostSerializedEqualsAndHashCode(one);
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
        newList.add("5");
        Verify.assertStartsWith(newList, "1", "2", "3", "4", "5");
    }

    @Test
    public void testGet() {
        Verify.assertStartsWith(this.list, "1", "2", "3", "4");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(4));
    }

    @Test
    public void testSet() {
        MutableList<String> list = Lists.fixedSize.of("1", "2", "3", "4");
        Assert.assertEquals("1", list.set(0, "4"));
        Assert.assertEquals("2", list.set(1, "3"));
        Assert.assertEquals("3", list.set(2, "2"));
        Assert.assertEquals("4", list.set(3, "1"));
        Assert.assertEquals(FastList.newListWith("4", "3", "2", "1"), list);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.set(4, "0"));
    }

    private void assertUnchanged() {
        Verify.assertSize(4, this.list);
        Verify.assertNotContains("5", this.list);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), this.list);
    }

    @Test
    public void testSerializableEqualsAndHashCode() {
        Verify.assertPostSerializedEqualsAndHashCode(this.list);
        MutableList<String> copyOfList = SerializeTestHelper.serializeDeserialize(this.list);
        Assert.assertNotSame(this.list, copyOfList);
    }

    @Test
    public void testGetFirstGetLast() {
        MutableList<String> list4 = Lists.fixedSize.of("1", "2", "3", "4");
        Assert.assertEquals("1", list4.getFirst());
        Assert.assertEquals("4", list4.getLast());
    }

    @Test
    public void testForEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4");
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), result);
    }

    @Test
    public void testForEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4");
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), result);
        Assert.assertEquals(6, indexSum[0]);
    }

    @Test
    public void testForEachWith() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4");
        source.forEachWith(Procedures2.fromProcedure(result::add), null);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), result);
    }

    @Test
    public void testForLoop() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three", "four");
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE", "FOUR");
        for (String each : list) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void testSubList() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three", "four");
        MutableList<String> subList = list.subList(0, 3);
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE", "FOUR");
        for (String each : subList) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void without() {
        MutableList<Integer> list = new QuadrupletonList<>(1, 2, 3, 2);
        Assert.assertSame(list, list.without(9));
        list = list.without(2);
        Verify.assertListsEqual(FastList.newListWith(1, 3, 2), list);
        Verify.assertInstanceOf(TripletonList.class, list);
    }

    @Test
    public void testGetOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.list.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private QuadrupletonListTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetClass() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetClass);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
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
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
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
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
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
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
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
        public void benchmark_subList_methodsThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList_methodsThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAdd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAdd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddingAllToOtherList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddingAllToOtherList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSerializableEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSerializableEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetFirstGetLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetFirstGetLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testForLoop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> payload) throws java.lang.Throwable {
            this.instance = new QuadrupletonListTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testGetClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> subList_methodsThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testAddAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testAdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testAddingAllToOtherList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testGet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testSerializableEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testGetFirstGetLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testForLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuadrupletonListTest> testGetOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testGetClass = QuadrupletonListTest::testGetClass;
            this.payloads.replaceAll = QuadrupletonListTest::replaceAll;
            this.payloads.sort = QuadrupletonListTest::sort;
            this.payloads.sortThis = QuadrupletonListTest::sortThis;
            this.payloads.sortThisWithComparator = QuadrupletonListTest::sortThisWithComparator;
            this.payloads.sortThisBy = QuadrupletonListTest::sortThisBy;
            this.payloads.sortThisByInt = QuadrupletonListTest::sortThisByInt;
            this.payloads.sortThisByBoolean = QuadrupletonListTest::sortThisByBoolean;
            this.payloads.sortThisByChar = QuadrupletonListTest::sortThisByChar;
            this.payloads.sortThisByByte = QuadrupletonListTest::sortThisByByte;
            this.payloads.sortThisByShort = QuadrupletonListTest::sortThisByShort;
            this.payloads.sortThisByFloat = QuadrupletonListTest::sortThisByFloat;
            this.payloads.sortThisByLong = QuadrupletonListTest::sortThisByLong;
            this.payloads.sortThisByDouble = QuadrupletonListTest::sortThisByDouble;
            this.payloads.reverseThis = QuadrupletonListTest::reverseThis;
            this.payloads.toReversed = QuadrupletonListTest::toReversed;
            this.payloads.with = QuadrupletonListTest::with;
            this.payloads.withAll = QuadrupletonListTest::withAll;
            this.payloads.withoutAll = QuadrupletonListTest::withoutAll;
            this.payloads.toStack = QuadrupletonListTest::toStack;
            this.payloads.aggregateByMutating = QuadrupletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = QuadrupletonListTest::aggregateByNonMutating;
            this.payloads.add = QuadrupletonListTest::add;
            this.payloads.addAtIndex = QuadrupletonListTest::addAtIndex;
            this.payloads.addAll = QuadrupletonListTest::addAll;
            this.payloads.addAllAtIndex = QuadrupletonListTest::addAllAtIndex;
            this.payloads.addAllIterable = QuadrupletonListTest::addAllIterable;
            this.payloads.removeIndex = QuadrupletonListTest::removeIndex;
            this.payloads.remove = QuadrupletonListTest::remove;
            this.payloads.removeAll = QuadrupletonListTest::removeAll;
            this.payloads.removeAllIterable = QuadrupletonListTest::removeAllIterable;
            this.payloads.retainAll = QuadrupletonListTest::retainAll;
            this.payloads.retainAllIterable = QuadrupletonListTest::retainAllIterable;
            this.payloads.clear = QuadrupletonListTest::clear;
            this.payloads.subList_methodsThrow = QuadrupletonListTest::subList_methodsThrow;
            this.payloads.testClone = QuadrupletonListTest::testClone;
            this.payloads.testContains = QuadrupletonListTest::testContains;
            this.payloads.testEqualsAndHashCode = QuadrupletonListTest::testEqualsAndHashCode;
            this.payloads.testRemove = QuadrupletonListTest::testRemove;
            this.payloads.testAddAtIndex = QuadrupletonListTest::testAddAtIndex;
            this.payloads.testAdd = QuadrupletonListTest::testAdd;
            this.payloads.testAddingAllToOtherList = QuadrupletonListTest::testAddingAllToOtherList;
            this.payloads.testGet = QuadrupletonListTest::testGet;
            this.payloads.testSet = QuadrupletonListTest::testSet;
            this.payloads.testSerializableEqualsAndHashCode = QuadrupletonListTest::testSerializableEqualsAndHashCode;
            this.payloads.testGetFirstGetLast = QuadrupletonListTest::testGetFirstGetLast;
            this.payloads.testForEach = QuadrupletonListTest::testForEach;
            this.payloads.testForEachWithIndex = QuadrupletonListTest::testForEachWithIndex;
            this.payloads.testForEachWith = QuadrupletonListTest::testForEachWith;
            this.payloads.testForLoop = QuadrupletonListTest::testForLoop;
            this.payloads.testSubList = QuadrupletonListTest::testSubList;
            this.payloads.without = QuadrupletonListTest::without;
            this.payloads.testGetOnly = QuadrupletonListTest::testGetOnly;
        }
    }
}
