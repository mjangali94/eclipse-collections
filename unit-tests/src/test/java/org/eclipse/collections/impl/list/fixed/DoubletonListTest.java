/*
 * Copyright (c) 2018 Goldman Sachs and others.
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
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
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
        public void benchmark_testSerialization() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSerialization, this.description("testSerialization"));
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
        public void benchmark_testForEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForEachWithIndex, this.description("testForEachWithIndex"));
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
        public void benchmark_without() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::without, this.description("without"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGetOnly, this.description("testGetOnly"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sort, this.description("sort"));
        }

        private DoubletonListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubletonListTest();
        }

        @java.lang.Override
        public DoubletonListTest implementation() {
            return this.implementation;
        }
    }
}
