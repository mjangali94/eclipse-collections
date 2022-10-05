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
import org.eclipse.collections.impl.block.factory.Procedures2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TripletonList}.
 */
public class TripletonListTest extends AbstractMemoryEfficientMutableListTestCase {

    @Override
    protected int getSize() {
        return 3;
    }

    @Override
    protected Class<?> getListType() {
        return TripletonList.class;
    }

    @Test
    public void testClone() {
        MutableList<String> growableList = this.list.clone();
        Verify.assertEqualsAndHashCode(this.list, growableList);
        Verify.assertInstanceOf(TripletonList.class, growableList);
    }

    @Test
    public void testContains() {
        Assert.assertTrue(this.list.contains("1"));
        Assert.assertTrue(this.list.contains("2"));
        Assert.assertTrue(this.list.contains("3"));
        Assert.assertFalse(this.list.contains("4"));
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
        MutableList<String> newList = FastList.newList(this.list);
        newList.add("4");
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), newList);
    }

    @Test
    public void testGet() {
        Verify.assertStartsWith(this.list, "1", "2", "3");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(3));
    }

    @Test
    public void testSet() {
        MutableList<String> list = Lists.fixedSize.of("1", "2", "3");
        Assert.assertEquals("1", list.set(0, "3"));
        Assert.assertEquals("2", list.set(1, "2"));
        Assert.assertEquals("3", list.set(2, "1"));
        Assert.assertEquals(FastList.newListWith("3", "2", "1"), list);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "0"));
    }

    private void assertUnchanged() {
        Verify.assertInstanceOf(TripletonList.class, this.list);
        Verify.assertSize(3, this.list);
        Verify.assertNotContains("4", this.list);
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), this.list);
    }

    @Test
    public void testSerializableEqualsAndHashCode() {
        Verify.assertPostSerializedEqualsAndHashCode(this.list);
        MutableList<String> copyOfList = SerializeTestHelper.serializeDeserialize(this.list);
        Assert.assertNotSame(this.list, copyOfList);
    }

    @Test
    public void testCreate1() {
        MutableList<String> list = Lists.fixedSize.of("1");
        Verify.assertSize(1, list);
        Verify.assertItemAtIndex("1", 0, list);
    }

    @Test
    public void testEqualsAndHashCode() {
        MutableList<String> one = Lists.fixedSize.of("1", "2", "3");
        MutableList<String> oneA = FastList.newList(one);
        Verify.assertEqualsAndHashCode(one, oneA);
        Verify.assertPostSerializedEqualsAndHashCode(one);
    }

    @Test
    public void testForEach() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3");
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
    }

    @Test
    public void forEachFromTo() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3");
        source.forEach(0, 2, result::add);
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
    }

    @Test
    public void forEachWithIndex() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3");
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
        Assert.assertEquals(3, indexSum[0]);
    }

    @Test
    public void forEachWithIndexFromTo() {
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3");
        source.forEachWithIndex(0, 2, (each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
        Assert.assertEquals(3, indexSum[0]);
    }

    @Test
    public void testForEachWith() {
        MutableList<String> result = Lists.mutable.of();
        MutableList<String> source = Lists.fixedSize.of("1", "2", "3");
        source.forEachWith(Procedures2.fromProcedure(result::add), null);
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), result);
    }

    @Test
    public void testGetFirstGetLast() {
        MutableList<String> list3 = Lists.fixedSize.of("1", "2", "3");
        Assert.assertEquals("1", list3.getFirst());
        Assert.assertEquals("3", list3.getLast());
    }

    @Test
    public void testForLoop() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three");
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE");
        for (String each : list) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void testSubList() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three");
        MutableList<String> subList = list.subList(0, 3);
        MutableList<String> upperList = Lists.fixedSize.of("ONE", "TWO", "THREE");
        for (String each : subList) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
        Assert.assertEquals("one", subList.getFirst());
        Assert.assertEquals("three", subList.getLast());
        MutableList<String> subList2 = list.subList(1, 2);
        Assert.assertEquals("two", subList2.getFirst());
        Assert.assertEquals("two", subList2.getLast());
        MutableList<String> subList3 = list.subList(0, 1);
        Assert.assertEquals("one", subList3.getFirst());
        Assert.assertEquals("one", subList3.getLast());
        MutableList<String> subList4 = subList.subList(1, 3);
        Assert.assertEquals("two", subList4.getFirst());
        Assert.assertEquals("three", subList4.getLast());
    }

    @Test
    public void testListIterator() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three");
        ListIterator<String> iterator = list.listIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());
        Assert.assertEquals("one", iterator.next());
        Assert.assertEquals("two", iterator.next());
        Assert.assertEquals("three", iterator.next());
        Assert.assertTrue(iterator.hasPrevious());
        Assert.assertEquals("three", iterator.previous());
        Assert.assertEquals("two", iterator.previous());
        Assert.assertEquals("one", iterator.previous());
        iterator.set("1");
        Assert.assertEquals("1", iterator.next());
        Assert.assertEquals("1", list.getFirst());
        list.subList(1, 3);
    }

    @Test
    public void testSubListListIterator() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three");
        MutableList<String> subList = list.subList(1, 3);
        ListIterator<String> iterator = subList.listIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.hasPrevious());
        Assert.assertEquals("two", iterator.next());
        Assert.assertEquals("three", iterator.next());
        Assert.assertTrue(iterator.hasPrevious());
        Assert.assertEquals("three", iterator.previous());
        Assert.assertEquals("two", iterator.previous());
        iterator.set("2");
        Assert.assertEquals("2", iterator.next());
        Assert.assertEquals("2", subList.getFirst());
        Assert.assertEquals("2", list.get(1));
    }

    @Test
    public void testSubListSet() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three");
        MutableList<String> subList = list.subList(1, 3);
        Assert.assertEquals("two", subList.set(0, "2"));
        Assert.assertEquals("2", subList.getFirst());
        Assert.assertEquals("2", list.get(1));
    }

    @Test
    public void testNewEmpty() {
        MutableList<String> list = Lists.fixedSize.of("one", "two", "three");
        Verify.assertEmpty(list.newEmpty());
    }

    @Test
    public void subListForEach() {
        MutableList<String> list = Lists.fixedSize.of("1", "2", "3");
        MutableList<String> source = list.subList(1, 3);
        MutableList<String> result = Lists.mutable.of();
        source.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith("2", "3"), result);
    }

    @Test
    public void testSubListForEachWithIndex() {
        MutableList<String> list = Lists.fixedSize.of("1", "2", "3");
        MutableList<String> source = list.subList(1, 3);
        int[] indexSum = new int[1];
        MutableList<String> result = Lists.mutable.of();
        source.forEachWithIndex((each, index) -> {
            result.add(each);
            indexSum[0] += index;
        });
        Assert.assertEquals(FastList.newListWith("2", "3"), result);
        Assert.assertEquals(1, indexSum[0]);
    }

    @Test
    public void testSubListForEachWith() {
        MutableList<String> list = Lists.fixedSize.of("1", "2", "3");
        MutableList<String> source = list.subList(1, 3);
        MutableList<String> result = Lists.mutable.of();
        source.forEachWith(Procedures2.fromProcedure(result::add), null);
        Assert.assertEquals(FastList.newListWith("2", "3"), result);
    }

    @Test
    public void testIndexOf() {
        MutableList<String> list = Lists.fixedSize.of("1", null, "3");
        Assert.assertEquals(0, list.indexOf("1"));
        Assert.assertEquals(1, list.indexOf(null));
        Assert.assertEquals(2, list.indexOf("3"));
        Assert.assertEquals(-1, list.indexOf("4"));
    }

    @Test
    public void testLastIndexOf() {
        MutableList<String> list = Lists.fixedSize.of("1", null, "1");
        Assert.assertEquals(2, list.lastIndexOf("1"));
        Assert.assertEquals(1, list.lastIndexOf(null));
        Assert.assertEquals(-1, list.lastIndexOf("4"));
    }

    @Test
    public void without() {
        MutableList<Integer> list = new TripletonList<>(2, 3, 2);
        Assert.assertSame(list, list.without(9));
        list = list.without(2);
        Verify.assertListsEqual(FastList.newListWith(3, 2), list);
        Verify.assertInstanceOf(DoubletonList.class, list);
    }

    @Test
    public void testGetOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.list.getOnly());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TripletonListTest instance;

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
        public void benchmark_testCreate1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCreate1);
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
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexFromTo);
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
        public void benchmark_testListIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testListIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListListIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListForEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSubListForEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGetOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> payload) throws java.lang.Throwable {
            this.instance = new TripletonListTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testGetClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> subList_methodsThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testContains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testAddAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testAdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testAddingAllToOtherList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testGet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testSerializableEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testCreate1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testGetFirstGetLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testForLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testSubList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testSubListListIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testSubListSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> subListForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testSubListForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testSubListForEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testLastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TripletonListTest> testGetOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testGetClass = TripletonListTest::testGetClass;
            this.payloads.replaceAll = TripletonListTest::replaceAll;
            this.payloads.sort = TripletonListTest::sort;
            this.payloads.sortThis = TripletonListTest::sortThis;
            this.payloads.sortThisWithComparator = TripletonListTest::sortThisWithComparator;
            this.payloads.sortThisBy = TripletonListTest::sortThisBy;
            this.payloads.sortThisByInt = TripletonListTest::sortThisByInt;
            this.payloads.sortThisByBoolean = TripletonListTest::sortThisByBoolean;
            this.payloads.sortThisByChar = TripletonListTest::sortThisByChar;
            this.payloads.sortThisByByte = TripletonListTest::sortThisByByte;
            this.payloads.sortThisByShort = TripletonListTest::sortThisByShort;
            this.payloads.sortThisByFloat = TripletonListTest::sortThisByFloat;
            this.payloads.sortThisByLong = TripletonListTest::sortThisByLong;
            this.payloads.sortThisByDouble = TripletonListTest::sortThisByDouble;
            this.payloads.reverseThis = TripletonListTest::reverseThis;
            this.payloads.toReversed = TripletonListTest::toReversed;
            this.payloads.with = TripletonListTest::with;
            this.payloads.withAll = TripletonListTest::withAll;
            this.payloads.withoutAll = TripletonListTest::withoutAll;
            this.payloads.toStack = TripletonListTest::toStack;
            this.payloads.aggregateByMutating = TripletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = TripletonListTest::aggregateByNonMutating;
            this.payloads.add = TripletonListTest::add;
            this.payloads.addAtIndex = TripletonListTest::addAtIndex;
            this.payloads.addAll = TripletonListTest::addAll;
            this.payloads.addAllAtIndex = TripletonListTest::addAllAtIndex;
            this.payloads.addAllIterable = TripletonListTest::addAllIterable;
            this.payloads.removeIndex = TripletonListTest::removeIndex;
            this.payloads.remove = TripletonListTest::remove;
            this.payloads.removeAll = TripletonListTest::removeAll;
            this.payloads.removeAllIterable = TripletonListTest::removeAllIterable;
            this.payloads.retainAll = TripletonListTest::retainAll;
            this.payloads.retainAllIterable = TripletonListTest::retainAllIterable;
            this.payloads.clear = TripletonListTest::clear;
            this.payloads.subList_methodsThrow = TripletonListTest::subList_methodsThrow;
            this.payloads.testClone = TripletonListTest::testClone;
            this.payloads.testContains = TripletonListTest::testContains;
            this.payloads.testRemove = TripletonListTest::testRemove;
            this.payloads.testAddAtIndex = TripletonListTest::testAddAtIndex;
            this.payloads.testAdd = TripletonListTest::testAdd;
            this.payloads.testAddingAllToOtherList = TripletonListTest::testAddingAllToOtherList;
            this.payloads.testGet = TripletonListTest::testGet;
            this.payloads.testSet = TripletonListTest::testSet;
            this.payloads.testSerializableEqualsAndHashCode = TripletonListTest::testSerializableEqualsAndHashCode;
            this.payloads.testCreate1 = TripletonListTest::testCreate1;
            this.payloads.testEqualsAndHashCode = TripletonListTest::testEqualsAndHashCode;
            this.payloads.testForEach = TripletonListTest::testForEach;
            this.payloads.forEachFromTo = TripletonListTest::forEachFromTo;
            this.payloads.forEachWithIndex = TripletonListTest::forEachWithIndex;
            this.payloads.forEachWithIndexFromTo = TripletonListTest::forEachWithIndexFromTo;
            this.payloads.testForEachWith = TripletonListTest::testForEachWith;
            this.payloads.testGetFirstGetLast = TripletonListTest::testGetFirstGetLast;
            this.payloads.testForLoop = TripletonListTest::testForLoop;
            this.payloads.testSubList = TripletonListTest::testSubList;
            this.payloads.testListIterator = TripletonListTest::testListIterator;
            this.payloads.testSubListListIterator = TripletonListTest::testSubListListIterator;
            this.payloads.testSubListSet = TripletonListTest::testSubListSet;
            this.payloads.testNewEmpty = TripletonListTest::testNewEmpty;
            this.payloads.subListForEach = TripletonListTest::subListForEach;
            this.payloads.testSubListForEachWithIndex = TripletonListTest::testSubListForEachWithIndex;
            this.payloads.testSubListForEachWith = TripletonListTest::testSubListForEachWith;
            this.payloads.testIndexOf = TripletonListTest::testIndexOf;
            this.payloads.testLastIndexOf = TripletonListTest::testLastIndexOf;
            this.payloads.without = TripletonListTest::without;
            this.payloads.testGetOnly = TripletonListTest::testGetOnly;
        }
    }
}
