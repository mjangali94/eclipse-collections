/*
 * Copyright (c) 2016 Goldman Sachs.
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
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testContains, this.description("testContains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testRemove, this.description("testRemove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testAddAtIndex, this.description("testAddAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAdd() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testAdd, this.description("testAdd"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddingAllToOtherList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testAddingAllToOtherList, this.description("testAddingAllToOtherList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGet, this.description("testGet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSet, this.description("testSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSerializableEqualsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSerializableEqualsAndHashCode, this.description("testSerializableEqualsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCreate1() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testCreate1, this.description("testCreate1"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEqualsAndHashCode, this.description("testEqualsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForEach, this.description("testForEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachFromTo, this.description("forEachFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndexFromTo, this.description("forEachWithIndexFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForEachWith, this.description("testForEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetFirstGetLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGetFirstGetLast, this.description("testGetFirstGetLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForLoop() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForLoop, this.description("testForLoop"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSubList, this.description("testSubList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testListIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testListIterator, this.description("testListIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListListIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSubListListIterator, this.description("testSubListListIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSubListSet, this.description("testSubListSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewEmpty, this.description("testNewEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListForEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subListForEach, this.description("subListForEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListForEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSubListForEachWithIndex, this.description("testSubListForEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSubListForEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSubListForEachWith, this.description("testSubListForEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIndexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testIndexOf, this.description("testIndexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLastIndexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testLastIndexOf, this.description("testLastIndexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::without, this.description("without"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGetOnly, this.description("testGetOnly"));
        }

        private TripletonListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TripletonListTest();
        }

        @java.lang.Override
        public TripletonListTest implementation() {
            return this.implementation;
        }
    }
}
