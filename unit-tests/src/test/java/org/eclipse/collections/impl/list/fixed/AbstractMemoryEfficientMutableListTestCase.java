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

import java.util.Collections;
import java.util.Comparator;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.FixedSizeList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.Counter;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractMemoryEfficientMutableListTestCase {

    protected MutableList<String> list;

    @Before
    public void setUp() {
        this.list = this.classUnderTest();
    }

    protected MutableList<String> classUnderTest() {
        return Lists.fixedSize.ofAll(this.getNStrings());
    }

    private MutableList<String> getNStrings() {
        return Interval.oneTo(this.getSize()).collect(String::valueOf).toList();
    }

    protected abstract int getSize();

    protected abstract Class<?> getListType();

    @Test
    public void testGetClass() {
        Verify.assertInstanceOf(this.getListType(), this.list);
    }

    @Test
    public void replaceAll() {
        this.list.replaceAll(s -> "");
        Assert.assertEquals(Lists.mutable.withNValues(this.getSize(), () -> ""), this.list);
    }

    @Test
    public void sort() {
        this.list.shuffleThis();
        this.list.sort(Comparator.naturalOrder());
        Assert.assertEquals(this.getNStrings(), this.list);
        this.list.shuffleThis();
        this.list.sort(null);
        Assert.assertEquals(this.getNStrings(), this.list);
    }

    @Test
    public void sortThis() {
        this.list.shuffleThis();
        MutableList<String> sortedList = this.list.sortThis();
        Assert.assertSame(this.list, sortedList);
        Assert.assertEquals(this.getNStrings(), sortedList);
    }

    @Test
    public void sortThisWithComparator() {
        this.list.shuffleThis();
        MutableList<String> sortedList = this.list.sortThis(Comparators.naturalOrder());
        Assert.assertSame(this.list, sortedList);
        Assert.assertEquals(this.getNStrings(), sortedList);
    }

    @Test
    public void sortThisBy() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisBy(Functions.getStringToInteger()));
    }

    @Test
    public void sortThisByInt() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisByInt(Integer::parseInt));
    }

    @Test
    public void sortThisByBoolean() {
        PartitionMutableList<String> partition = this.getNStrings().partition(s -> Integer.parseInt(s) % 2 == 0);
        MutableList<String> expected = FastList.newList(partition.getRejected()).withAll(partition.getSelected());
        Assert.assertEquals(expected, this.list.sortThisByBoolean(s -> Integer.parseInt(s) % 2 == 0));
    }

    @Test
    public void sortThisByChar() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisByChar(string -> string.charAt(0)));
    }

    @Test
    public void sortThisByByte() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisByByte(Byte::parseByte));
    }

    @Test
    public void sortThisByShort() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisByShort(Short::parseShort));
    }

    @Test
    public void sortThisByFloat() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisByFloat(Float::parseFloat));
    }

    @Test
    public void sortThisByLong() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisByLong(Long::parseLong));
    }

    @Test
    public void sortThisByDouble() {
        this.list.shuffleThis();
        Assert.assertEquals(this.getNStrings(), this.list.sortThisByDouble(Double::parseDouble));
    }

    @Test
    public void reverseThis() {
        MutableList<String> expected = FastList.newList(this.list);
        MutableList<String> actual = this.list.reverseThis();
        Collections.reverse(expected);
        Assert.assertEquals(actual, expected);
        Assert.assertSame(this.list, actual);
    }

    @Test
    public void toReversed() {
        MutableList<String> actual = this.list.toReversed();
        MutableList<String> expected = FastList.newList(this.list).reverseThis();
        Assert.assertEquals(actual, expected);
        Assert.assertNotSame(this.list, actual);
    }

    @Test
    public void with() {
        MutableList<String> list = this.classUnderTest();
        Verify.assertNotContains("11", list);
        MutableList<String> listWith = list.with("11");
        Assert.assertTrue(listWith.containsAll(list));
        Verify.assertContains("11", listWith);
        Verify.assertInstanceOf(FixedSizeList.class, listWith);
    }

    @Test
    public void withAll() {
        MutableList<String> list = this.classUnderTest();
        Verify.assertContainsNone(list, "11", "12");
        MutableList<String> listWith = list.withAll(FastList.newListWith("11", "12"));
        Assert.assertTrue(listWith.containsAll(list));
        Verify.assertContainsAll(listWith, "11", "12");
        Verify.assertInstanceOf(FixedSizeList.class, listWith);
        Assert.assertSame(listWith, listWith.withAll(FastList.newList()));
    }

    @Test
    public void withoutAll() {
        MutableList<String> list = this.classUnderTest().with("11").with("12");
        MutableList<String> listWithout = list.withoutAll(FastList.newListWith("11", "12"));
        Assert.assertTrue(listWithout.containsAll(this.classUnderTest()));
        Verify.assertContainsNone(listWithout, "11", "12");
        Verify.assertInstanceOf(FixedSizeList.class, listWithout);
        Assert.assertSame(listWithout, listWithout.withoutAll(FastList.newList()));
    }

    @Test
    public void toStack() {
        MutableStack<String> stack = this.classUnderTest().toStack();
        Assert.assertEquals(ArrayStack.newStack(this.classUnderTest()), stack);
    }

    @Test
    public void aggregateByMutating() {
        Function<String, String> groupBy = Functions.getStringPassThru();
        Procedure2<Counter, String> sumAggregator = (aggregate, value) -> aggregate.add(Integer.parseInt(value));
        MapIterable<String, Counter> actual = this.classUnderTest().aggregateInPlaceBy(groupBy, Counter::new, sumAggregator);
        MapIterable<String, Counter> expected = FastList.newList(this.classUnderTest()).aggregateInPlaceBy(groupBy, Counter::new, sumAggregator);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void aggregateByNonMutating() {
        Function<String, String> groupBy = Functions.getStringPassThru();
        Function2<Integer, String, Integer> sumAggregator = (aggregate, value) -> aggregate + Integer.parseInt(value);
        MapIterable<String, Integer> actual = this.classUnderTest().aggregateBy(groupBy, () -> 0, sumAggregator);
        MapIterable<String, Integer> expected = FastList.newList(this.classUnderTest()).aggregateBy(groupBy, () -> 0, sumAggregator);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void add() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().add(""));
    }

    @Test
    public void addAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().add(0, ""));
    }

    @Test
    public void addAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().addAll(Lists.mutable.empty()));
    }

    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().addAll(0, Lists.mutable.empty()));
    }

    @Test
    public void addAllIterable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().addAllIterable(Lists.mutable.empty()));
    }

    @Test
    public void removeIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().remove(0));
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().remove(null));
    }

    @Test
    public void removeAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().removeAll(Lists.fixedSize.empty()));
    }

    @Test
    public void removeAllIterable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().removeAllIterable(Lists.fixedSize.empty()));
    }

    @Test
    public void retainAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().retainAll(Lists.fixedSize.empty()));
    }

    @Test
    public void retainAllIterable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().retainAllIterable(Lists.fixedSize.empty()));
    }

    @Test
    public void clear() {
        Assert.assertThrows(UnsupportedOperationException.class, this.classUnderTest()::clear);
    }

    @Test
    public void subList_methodsThrow() {
        MutableList<String> subList = this.classUnderTest().subList(0, this.getSize());
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.add(""));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.add(0, ""));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.addAll(Lists.mutable.empty()));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.addAllIterable(Lists.mutable.empty()));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.remove(0));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.remove(null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.removeAll(Lists.fixedSize.empty()));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.removeAllIterable(Lists.fixedSize.empty()));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.removeIf(each -> true));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.removeIfWith((argument1, argument2) -> true, null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.retainAll(Lists.fixedSize.empty()));
        Assert.assertThrows(UnsupportedOperationException.class, () -> subList.retainAllIterable(Lists.fixedSize.empty()));
        Assert.assertThrows(UnsupportedOperationException.class, subList::clear);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetClass() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGetClass, this.description("testGetClass"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::replaceAll, this.description("replaceAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sort, this.description("sort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThis, this.description("sortThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisWithComparator, this.description("sortThisWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisBy, this.description("sortThisBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByInt, this.description("sortThisByInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByBoolean, this.description("sortThisByBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByChar, this.description("sortThisByChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByByte, this.description("sortThisByByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByShort, this.description("sortThisByShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByFloat, this.description("sortThisByFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByLong, this.description("sortThisByLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThisByDouble, this.description("sortThisByDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reverseThis, this.description("reverseThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toReversed, this.description("toReversed"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAll, this.description("withAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutAll, this.description("withoutAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toStack, this.description("toStack"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByMutating, this.description("aggregateByMutating"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByNonMutating, this.description("aggregateByNonMutating"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAtIndex, this.description("addAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAll, this.description("addAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllAtIndex, this.description("addAllAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeIndex, this.description("removeIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAll, this.description("removeAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllIterable, this.description("removeAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAll, this.description("retainAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAllIterable, this.description("retainAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList_methodsThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subList_methodsThrow, this.description("subList_methodsThrow"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMemoryEfficientMutableListTestCase implementation();
    }
}
