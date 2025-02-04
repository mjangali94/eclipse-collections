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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMemoryEfficientMutableListTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMemoryEfficientMutableListTestCase();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> testGetClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMemoryEfficientMutableListTestCase> subList_methodsThrow;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testGetClass = AbstractMemoryEfficientMutableListTestCase::testGetClass;
            this.payloads.replaceAll = AbstractMemoryEfficientMutableListTestCase::replaceAll;
            this.payloads.sort = AbstractMemoryEfficientMutableListTestCase::sort;
            this.payloads.sortThis = AbstractMemoryEfficientMutableListTestCase::sortThis;
            this.payloads.sortThisWithComparator = AbstractMemoryEfficientMutableListTestCase::sortThisWithComparator;
            this.payloads.sortThisBy = AbstractMemoryEfficientMutableListTestCase::sortThisBy;
            this.payloads.sortThisByInt = AbstractMemoryEfficientMutableListTestCase::sortThisByInt;
            this.payloads.sortThisByBoolean = AbstractMemoryEfficientMutableListTestCase::sortThisByBoolean;
            this.payloads.sortThisByChar = AbstractMemoryEfficientMutableListTestCase::sortThisByChar;
            this.payloads.sortThisByByte = AbstractMemoryEfficientMutableListTestCase::sortThisByByte;
            this.payloads.sortThisByShort = AbstractMemoryEfficientMutableListTestCase::sortThisByShort;
            this.payloads.sortThisByFloat = AbstractMemoryEfficientMutableListTestCase::sortThisByFloat;
            this.payloads.sortThisByLong = AbstractMemoryEfficientMutableListTestCase::sortThisByLong;
            this.payloads.sortThisByDouble = AbstractMemoryEfficientMutableListTestCase::sortThisByDouble;
            this.payloads.reverseThis = AbstractMemoryEfficientMutableListTestCase::reverseThis;
            this.payloads.toReversed = AbstractMemoryEfficientMutableListTestCase::toReversed;
            this.payloads.with = AbstractMemoryEfficientMutableListTestCase::with;
            this.payloads.withAll = AbstractMemoryEfficientMutableListTestCase::withAll;
            this.payloads.withoutAll = AbstractMemoryEfficientMutableListTestCase::withoutAll;
            this.payloads.toStack = AbstractMemoryEfficientMutableListTestCase::toStack;
            this.payloads.aggregateByMutating = AbstractMemoryEfficientMutableListTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractMemoryEfficientMutableListTestCase::aggregateByNonMutating;
            this.payloads.add = AbstractMemoryEfficientMutableListTestCase::add;
            this.payloads.addAtIndex = AbstractMemoryEfficientMutableListTestCase::addAtIndex;
            this.payloads.addAll = AbstractMemoryEfficientMutableListTestCase::addAll;
            this.payloads.addAllAtIndex = AbstractMemoryEfficientMutableListTestCase::addAllAtIndex;
            this.payloads.addAllIterable = AbstractMemoryEfficientMutableListTestCase::addAllIterable;
            this.payloads.removeIndex = AbstractMemoryEfficientMutableListTestCase::removeIndex;
            this.payloads.remove = AbstractMemoryEfficientMutableListTestCase::remove;
            this.payloads.removeAll = AbstractMemoryEfficientMutableListTestCase::removeAll;
            this.payloads.removeAllIterable = AbstractMemoryEfficientMutableListTestCase::removeAllIterable;
            this.payloads.retainAll = AbstractMemoryEfficientMutableListTestCase::retainAll;
            this.payloads.retainAllIterable = AbstractMemoryEfficientMutableListTestCase::retainAllIterable;
            this.payloads.clear = AbstractMemoryEfficientMutableListTestCase::clear;
            this.payloads.subList_methodsThrow = AbstractMemoryEfficientMutableListTestCase::subList_methodsThrow;
        }
    }
*/
}
