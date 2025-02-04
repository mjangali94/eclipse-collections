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

public class QuintupletonListTest extends AbstractMemoryEfficientMutableListTestCase {

    @Override
    protected int getSize() {
        return 5;
    }

    @Override
    protected Class<?> getListType() {
        return QuintupletonList.class;
    }

    @Test
    public void testClone() {
        MutableList<String> growableList = this.list.clone();
        Verify.assertEqualsAndHashCode(this.list, growableList);
        Verify.assertInstanceOf(QuintupletonList.class, growableList);
    }

    @Test
    public void testEqualsAndHashCode() {
        MutableList<String> one = Lists.fixedSize.of("1", "2", "3", "4", "5");
        List<String> oneA = new ArrayList<>(one);
        Verify.assertEqualsAndHashCode(one, oneA);
        Verify.assertPostSerializedEqualsAndHashCode(one);
    }

    @Test
    public void testContains() {
        Verify.assertContains("1", this.list);
        Verify.assertContains("2", this.list);
        Verify.assertContains("3", this.list);
        Verify.assertContains("4", this.list);
        Verify.assertContains("5", this.list);
        Verify.assertNotContains("6", this.list);
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
        newList.add("6");
        Verify.assertStartsWith(newList, "1", "2", "3", "4", "5", "6");
    }

    @Test
    public void testGet() {
        Verify.assertStartsWith(this.list, "1", "2", "3", "4", "5");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(5));
    }

    @Test
    public void testSet() {
        MutableList<String> list = Lists.fixedSize.of("1", "2", "3", "4", "5");
        Assert.assertEquals("1", list.set(0, "5"));
        Assert.assertEquals("2", list.set(1, "4"));
        Assert.assertEquals("3", list.set(2, "3"));
        Assert.assertEquals("4", list.set(3, "2"));
        Assert.assertEquals("5", list.set(4, "1"));
        Assert.assertEquals(FastList.newListWith("5", "4", "3", "2", "1"), list);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, "0"));
    }

    private void assertUnchanged() {
        Verify.assertSize(5, this.list);
        Verify.assertNotContains("6", this.list);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5"), this.list);
    }

    @Test
    public void testSerializableEqualsAndHashCode() {
        Verify.assertPostSerializedEqualsAndHashCode(this.list);
        MutableList<String> copyOfList = SerializeTestHelper.serializeDeserialize(this.list);
        Assert.assertNotSame(this.list, copyOfList);
    }

    @Test
    public void testGetFirstGetLast() {
        MutableList<String> list5 = Lists.fixedSize.of("1", "2", "3", "4", "5");
        Assert.assertEquals("1", list5.getFirst());
        Assert.assertEquals("5", list5.getLast());
    }

    @Test
    public void testForEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4", "5");
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5"), result);
    }

    @Test
    public void testForEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4", "5");
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5"), result);
        Assert.assertEquals(10, indexSum[0]);
    }

    @Test
    public void testForEachWith() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3", "4", "5");
        source.forEachWith(Procedures2.fromProcedure(result::add), null);
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4", "5"), result);
    }

    @Test
    public void testForLoop() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three", "four", "five");
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE", "FOUR", "FIVE");
        for (String each : list) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void testSubList() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three", "four", "five");
        MutableList<String> subList = list.subList(0, 4);
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE", "FOUR", "FIVE");
        for (String each : subList) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void without() {
        MutableList<Integer> list = new QuintupletonList<>(1, 2, 3, 2, 4);
        Assert.assertSame(list, list.without(9));
        list = list.without(2);
        Verify.assertListsEqual(FastList.newListWith(1, 3, 2, 4), list);
        Verify.assertInstanceOf(QuadrupletonList.class, list);
    }

    @Test
    public void testGetOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.list.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private QuintupletonListTest instance;

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
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContains);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> payload) throws java.lang.Throwable {
            this.instance = new QuintupletonListTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testGetClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> subList_methodsThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testAddAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testAdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testAddingAllToOtherList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testGet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testSerializableEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testGetFirstGetLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testForLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<QuintupletonListTest> testGetOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testGetClass = QuintupletonListTest::testGetClass;
            this.payloads.replaceAll = QuintupletonListTest::replaceAll;
            this.payloads.sort = QuintupletonListTest::sort;
            this.payloads.sortThis = QuintupletonListTest::sortThis;
            this.payloads.sortThisWithComparator = QuintupletonListTest::sortThisWithComparator;
            this.payloads.sortThisBy = QuintupletonListTest::sortThisBy;
            this.payloads.sortThisByInt = QuintupletonListTest::sortThisByInt;
            this.payloads.sortThisByBoolean = QuintupletonListTest::sortThisByBoolean;
            this.payloads.sortThisByChar = QuintupletonListTest::sortThisByChar;
            this.payloads.sortThisByByte = QuintupletonListTest::sortThisByByte;
            this.payloads.sortThisByShort = QuintupletonListTest::sortThisByShort;
            this.payloads.sortThisByFloat = QuintupletonListTest::sortThisByFloat;
            this.payloads.sortThisByLong = QuintupletonListTest::sortThisByLong;
            this.payloads.sortThisByDouble = QuintupletonListTest::sortThisByDouble;
            this.payloads.reverseThis = QuintupletonListTest::reverseThis;
            this.payloads.toReversed = QuintupletonListTest::toReversed;
            this.payloads.with = QuintupletonListTest::with;
            this.payloads.withAll = QuintupletonListTest::withAll;
            this.payloads.withoutAll = QuintupletonListTest::withoutAll;
            this.payloads.toStack = QuintupletonListTest::toStack;
            this.payloads.aggregateByMutating = QuintupletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = QuintupletonListTest::aggregateByNonMutating;
            this.payloads.add = QuintupletonListTest::add;
            this.payloads.addAtIndex = QuintupletonListTest::addAtIndex;
            this.payloads.addAll = QuintupletonListTest::addAll;
            this.payloads.addAllAtIndex = QuintupletonListTest::addAllAtIndex;
            this.payloads.addAllIterable = QuintupletonListTest::addAllIterable;
            this.payloads.removeIndex = QuintupletonListTest::removeIndex;
            this.payloads.remove = QuintupletonListTest::remove;
            this.payloads.removeAll = QuintupletonListTest::removeAll;
            this.payloads.removeAllIterable = QuintupletonListTest::removeAllIterable;
            this.payloads.retainAll = QuintupletonListTest::retainAll;
            this.payloads.retainAllIterable = QuintupletonListTest::retainAllIterable;
            this.payloads.clear = QuintupletonListTest::clear;
            this.payloads.subList_methodsThrow = QuintupletonListTest::subList_methodsThrow;
            this.payloads.testClone = QuintupletonListTest::testClone;
            this.payloads.testEqualsAndHashCode = QuintupletonListTest::testEqualsAndHashCode;
            this.payloads.testContains = QuintupletonListTest::testContains;
            this.payloads.testRemove = QuintupletonListTest::testRemove;
            this.payloads.testAddAtIndex = QuintupletonListTest::testAddAtIndex;
            this.payloads.testAdd = QuintupletonListTest::testAdd;
            this.payloads.testAddingAllToOtherList = QuintupletonListTest::testAddingAllToOtherList;
            this.payloads.testGet = QuintupletonListTest::testGet;
            this.payloads.testSet = QuintupletonListTest::testSet;
            this.payloads.testSerializableEqualsAndHashCode = QuintupletonListTest::testSerializableEqualsAndHashCode;
            this.payloads.testGetFirstGetLast = QuintupletonListTest::testGetFirstGetLast;
            this.payloads.testForEach = QuintupletonListTest::testForEach;
            this.payloads.testForEachWithIndex = QuintupletonListTest::testForEachWithIndex;
            this.payloads.testForEachWith = QuintupletonListTest::testForEachWith;
            this.payloads.testForLoop = QuintupletonListTest::testForLoop;
            this.payloads.testSubList = QuintupletonListTest::testSubList;
            this.payloads.without = QuintupletonListTest::without;
            this.payloads.testGetOnly = QuintupletonListTest::testGetOnly;
        }
    }
}
