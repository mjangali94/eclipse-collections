/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.AddToList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableArrayList}.
 */
public class ImmutableArrayListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return this.newList(1, 2, 3);
    }

    @Test
    public void newWith() {
        ImmutableList<Integer> list = this.newList(1, 2, 3);
        ImmutableList<Integer> with = list.newWith(4);
        Assert.assertNotEquals(list, with);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), with);
    }

    @Test
    public void newWithAll() {
        ImmutableList<Integer> list = this.newList(1, 2, 3);
        ImmutableList<Integer> withAll = list.newWithAll(FastList.newListWith(4, 5));
        Assert.assertNotEquals(list, withAll);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5), withAll);
    }

    @Test
    public void newWithOut() {
        ImmutableList<Integer> list = this.newList(1, 2, 3, 4);
        ImmutableList<Integer> without4 = list.newWithout(4);
        Assert.assertNotEquals(list, without4);
        Assert.assertEquals(FastList.newListWith(1, 2, 3), without4);
        ImmutableList<Integer> without1 = list.newWithout(1);
        Assert.assertNotEquals(list, without1);
        Assert.assertEquals(FastList.newListWith(2, 3, 4), without1);
        ImmutableList<Integer> without0 = list.newWithout(0);
        Assert.assertSame(list, without0);
        ImmutableList<Integer> without5 = list.newWithout(5);
        Assert.assertSame(list, without5);
    }

    @Test
    public void newWithoutAll() {
        ImmutableList<Integer> list = this.newList(1, 2, 3, 4, 5);
        ImmutableList<Integer> withoutAll = list.newWithoutAll(FastList.newListWith(4, 5));
        Assert.assertNotEquals(list, withoutAll);
        Assert.assertEquals(FastList.newListWith(1, 2, 3), withoutAll);
        Assert.assertEquals(FastList.newListWith(1, 2, 3), list.newWithoutAll(HashBag.newBagWith(4, 4, 5)));
        ImmutableList<Integer> largeList = this.newList(Interval.oneTo(20).toArray());
        ImmutableList<Integer> largeWithoutAll = largeList.newWithoutAll(FastList.newList(Interval.oneTo(10)));
        Assert.assertEquals(FastList.newList(Interval.fromTo(11, 20)), largeWithoutAll);
        ImmutableList<Integer> largeWithoutAll2 = largeWithoutAll.newWithoutAll(Interval.fromTo(11, 15));
        Assert.assertEquals(FastList.newList(Interval.fromTo(16, 20)), largeWithoutAll2);
        ImmutableList<Integer> largeWithoutAll3 = largeWithoutAll2.newWithoutAll(UnifiedSet.newSet(Interval.fromTo(16, 19)));
        Assert.assertEquals(FastList.newListWith(20), largeWithoutAll3);
    }

    private ImmutableArrayList<Integer> newList(Integer... elements) {
        return ImmutableArrayList.newListWith(elements);
    }

    private ImmutableList<Integer> newListWith(int one, int two) {
        return ImmutableArrayList.newListWith(one, two);
    }

    private ImmutableList<Integer> newListWith(int one, int two, int three) {
        return ImmutableArrayList.newListWith(one, two, three);
    }

    private ImmutableList<Integer> newListWith(int... littleElements) {
        Integer[] bigElements = new Integer[littleElements.length];
        for (int i = 0; i < littleElements.length; i++) {
            bigElements[i] = littleElements[i];
        }
        return ImmutableArrayList.newListWith(bigElements);
    }

    @Test
    public void newListWith() {
        ImmutableList<Integer> collection = ImmutableArrayList.newListWith(1);
        Assert.assertTrue(collection.notEmpty());
        Assert.assertEquals(1, collection.size());
        Assert.assertTrue(collection.contains(1));
    }

    @Test
    public void newListWithVarArgs() {
        ImmutableList<Integer> collection = this.newListWith(1, 2, 3, 4);
        Assert.assertTrue(collection.notEmpty());
        Assert.assertEquals(4, collection.size());
        Assert.assertTrue(collection.containsAllArguments(1, 2, 3, 4));
        Assert.assertTrue(collection.containsAllIterable(Interval.oneTo(4)));
    }

    @Test
    public void toSet() {
        ImmutableArrayList<Integer> integers = ImmutableArrayList.newListWith(1, 2, 3, 4);
        MutableSet<Integer> set = integers.toSet();
        Verify.assertContainsAll(set, 1, 2, 3, 4);
    }

    @Test
    public void toMap() {
        ImmutableArrayList<Integer> integers = ImmutableArrayList.newListWith(1, 2, 3, 4);
        MutableMap<String, String> map = integers.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1", "2", "2", "3", "3", "4", "4"), map);
    }

    @Test
    public void serialization() {
        ImmutableList<Integer> collection = ImmutableArrayList.newListWith(1, 2, 3, 4, 5);
        ImmutableList<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Assert.assertEquals(5, deserializedCollection.size());
        Assert.assertTrue(deserializedCollection.containsAllArguments(1, 2, 3, 4, 5));
        Verify.assertEqualsAndHashCode(collection, deserializedCollection);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void forEachWithIndexIllegalFrom() {
        MutableList<Integer> result = Lists.mutable.of();
        this.newList(1, 2).forEachWithIndex(-1, 2, new AddToList(result));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void forEachWithIndexIllegalTo() {
        MutableList<Integer> result = Lists.mutable.of();
        this.newList(1, 2).forEachWithIndex(1, -2, new AddToList(result));
    }

    @Test
    @Override
    public void get() {
        ImmutableList<Integer> list = this.classUnderTest();
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    @Override
    public void iteratorRemove() {
        try {
            this.classUnderTest().iterator().remove();
            Assert.fail("Should not reach here! Exception should be thrown on previous line.");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalStateException || e instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void groupByUniqueKey() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), this.classUnderTest().groupByUniqueKey(id -> id));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws() {
        this.classUnderTest().groupByUniqueKey(Functions.getFixedValue(1));
    }

    @Test
    public void groupByUniqueKey_target() {
        MutableMap<Integer, Integer> integers = this.classUnderTest().groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), integers);
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws() {
        this.classUnderTest().groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(2, 2));
    }

    @Test
    public void getOnly() {
        ImmutableList<Integer> list = this.newList(2);
        Assert.assertEquals(Integer.valueOf(2), list.getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_exception_when_empty() {
        ImmutableList<Integer> list = this.newList();
        list.getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_exception_when_multiple_items() {
        ImmutableList<Integer> list = this.newList(1, 2, 3);
        list.getOnly();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWith, this.description("newWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithAll, this.description("newWithAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithOut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithOut, this.description("newWithOut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithoutAll, this.description("newWithoutAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWith, this.description("newListWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithVarArgs() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newListWithVarArgs, this.description("newListWithVarArgs"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMap, this.description("toMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialization, this.description("serialization"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexIllegalFrom() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachWithIndexIllegalFrom, this.description("forEachWithIndexIllegalFrom"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexIllegalTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::forEachWithIndexIllegalTo, this.description("forEachWithIndexIllegalTo"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iteratorRemove, this.description("iteratorRemove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey, this.description("groupByUniqueKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_throws, this.description("groupByUniqueKey_throws"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_target, this.description("groupByUniqueKey_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::groupByUniqueKey_target_throws, this.description("groupByUniqueKey_target_throws"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly_exception_when_empty, this.description("getOnly_exception_when_empty"), java.lang.IllegalStateException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_multiple_items() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly_exception_when_multiple_items, this.description("getOnly_exception_when_multiple_items"), java.lang.IllegalStateException.class);
        }

        private ImmutableArrayListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableArrayListTest();
        }

        @java.lang.Override
        public ImmutableArrayListTest implementation() {
            return this.implementation;
        }
    }
}
