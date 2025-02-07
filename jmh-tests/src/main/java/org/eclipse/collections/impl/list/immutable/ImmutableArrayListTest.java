/*
 * Copyright (c) 2021 Goldman Sachs.
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
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableArrayListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_each() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.each);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromNegative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromGreaterThanTO() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromGreaterThanTO);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListToGreaterThanSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListToGreaterThanSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator_throwsNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator_throwsNegative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator_throwsGreaterThanSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator_throwsGreaterThanSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithOut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithOut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexIllegalFrom() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexIllegalFrom);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexIllegalTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexIllegalTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_exception_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_exception_when_multiple_items() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_exception_when_multiple_items);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableArrayListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> newWithOut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> newListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> newListWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forEachWithIndexIllegalFrom;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> forEachWithIndexIllegalTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> getOnly_exception_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayListTest> getOnly_exception_when_multiple_items;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableArrayListTest::stream;
            this.payloads.parallelStream = ImmutableArrayListTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableArrayListTest::countBy;
            this.payloads.countByWith = ImmutableArrayListTest::countByWith;
            this.payloads.countByEach = ImmutableArrayListTest::countByEach;
            this.payloads.selectWith = ImmutableArrayListTest::selectWith;
            this.payloads.selectWith_target = ImmutableArrayListTest::selectWith_target;
            this.payloads.rejectWith = ImmutableArrayListTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableArrayListTest::rejectWith_target;
            this.payloads.partition = ImmutableArrayListTest::partition;
            this.payloads.partitionWith = ImmutableArrayListTest::partitionWith;
            this.payloads.collectWith = ImmutableArrayListTest::collectWith;
            this.payloads.collect_target = ImmutableArrayListTest::collect_target;
            this.payloads.collectWith_target = ImmutableArrayListTest::collectWith_target;
            this.payloads.injectInto = ImmutableArrayListTest::injectInto;
            this.payloads.injectIntoInt = ImmutableArrayListTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableArrayListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableArrayListTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableArrayListTest::sumFloat;
            this.payloads.sumDouble = ImmutableArrayListTest::sumDouble;
            this.payloads.sumInteger = ImmutableArrayListTest::sumInteger;
            this.payloads.sumLong = ImmutableArrayListTest::sumLong;
            this.payloads.sumByInt = ImmutableArrayListTest::sumByInt;
            this.payloads.sumByFloat = ImmutableArrayListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableArrayListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableArrayListTest::sumByLong;
            this.payloads.sumByDouble = ImmutableArrayListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableArrayListTest::sumByDoubleConsistentRounding;
            this.payloads.makeString = ImmutableArrayListTest::makeString;
            this.payloads.appendString = ImmutableArrayListTest::appendString;
            this.payloads.testToString = ImmutableArrayListTest::testToString;
            this.payloads.select = ImmutableArrayListTest::select;
            this.payloads.selectInstancesOf = ImmutableArrayListTest::selectInstancesOf;
            this.payloads.reject = ImmutableArrayListTest::reject;
            this.payloads.collect = ImmutableArrayListTest::collect;
            this.payloads.collectByte = ImmutableArrayListTest::collectByte;
            this.payloads.collectChar = ImmutableArrayListTest::collectChar;
            this.payloads.collectDouble = ImmutableArrayListTest::collectDouble;
            this.payloads.collectFloat = ImmutableArrayListTest::collectFloat;
            this.payloads.collectInt = ImmutableArrayListTest::collectInt;
            this.payloads.collectLong = ImmutableArrayListTest::collectLong;
            this.payloads.collectShort = ImmutableArrayListTest::collectShort;
            this.payloads.flatCollect = ImmutableArrayListTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableArrayListTest::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = ImmutableArrayListTest::detect;
            this.payloads.detectWith = ImmutableArrayListTest::detectWith;
            this.payloads.detectIfNone = ImmutableArrayListTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableArrayListTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableArrayListTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableArrayListTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableArrayListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableArrayListTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableArrayListTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableArrayListTest::anySatisfyWith;
            this.payloads.count = ImmutableArrayListTest::count;
            this.payloads.countWith = ImmutableArrayListTest::countWith;
            this.payloads.collectIf = ImmutableArrayListTest::collectIf;
            this.payloads.getFirst = ImmutableArrayListTest::getFirst;
            this.payloads.getLast = ImmutableArrayListTest::getLast;
            this.payloads.isEmpty = ImmutableArrayListTest::isEmpty;
            this.payloads.iterator = ImmutableArrayListTest::iterator;
            this.payloads.toArray = ImmutableArrayListTest::toArray;
            this.payloads.toSortedList = ImmutableArrayListTest::toSortedList;
            this.payloads.toSortedSet = ImmutableArrayListTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableArrayListTest::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = ImmutableArrayListTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableArrayListTest::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableArrayListTest::min;
            this.payloads.max = ImmutableArrayListTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableArrayListTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableArrayListTest::max_without_comparator;
            this.payloads.minBy = ImmutableArrayListTest::minBy;
            this.payloads.maxBy = ImmutableArrayListTest::maxBy;
            this.payloads.add = ImmutableArrayListTest::add;
            this.payloads.remove = ImmutableArrayListTest::remove;
            this.payloads.clear = ImmutableArrayListTest::clear;
            this.payloads.removeAll = ImmutableArrayListTest::removeAll;
            this.payloads.retainAll = ImmutableArrayListTest::retainAll;
            this.payloads.addAll = ImmutableArrayListTest::addAll;
            this.payloads.aggregateByMutating = ImmutableArrayListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableArrayListTest::aggregateByNonMutating;
            this.payloads.tap = ImmutableArrayListTest::tap;
            this.payloads.equalsAndHashCode = ImmutableArrayListTest::equalsAndHashCode;
            this.payloads.contains = ImmutableArrayListTest::contains;
            this.payloads.containsAll = ImmutableArrayListTest::containsAll;
            this.payloads.containsAllArray = ImmutableArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableArrayListTest::containsAllIterable;
            this.payloads.indexOf = ImmutableArrayListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableArrayListTest::lastIndexOf;
            this.payloads.forEach = ImmutableArrayListTest::forEach;
            this.payloads.each = ImmutableArrayListTest::each;
            this.payloads.reverseForEach = ImmutableArrayListTest::reverseForEach;
            this.payloads.reverseForEachWithIndex = ImmutableArrayListTest::reverseForEachWithIndex;
            this.payloads.corresponds = ImmutableArrayListTest::corresponds;
            this.payloads.forEachFromTo = ImmutableArrayListTest::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = ImmutableArrayListTest::forEachWithIndexFromTo;
            this.payloads.forEachWith = ImmutableArrayListTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableArrayListTest::forEachWithIndex;
            this.payloads.detectIndex = ImmutableArrayListTest::detectIndex;
            this.payloads.detectLastIndex = ImmutableArrayListTest::detectLastIndex;
            this.payloads.select_target = ImmutableArrayListTest::select_target;
            this.payloads.reject_target = ImmutableArrayListTest::reject_target;
            this.payloads.flatCollectWithTarget = ImmutableArrayListTest::flatCollectWithTarget;
            this.payloads.distinct = ImmutableArrayListTest::distinct;
            this.payloads.distinctWithHashingStrategy = ImmutableArrayListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = ImmutableArrayListTest::distinctBy;
            this.payloads.zip = ImmutableArrayListTest::zip;
            this.payloads.zipWithIndex = ImmutableArrayListTest::zipWithIndex;
            this.payloads.chunk_large_size = ImmutableArrayListTest::chunk_large_size;
            this.payloads.collectIfWithTarget = ImmutableArrayListTest::collectIfWithTarget;
            this.payloads.toList = ImmutableArrayListTest::toList;
            this.payloads.toSortedListBy = ImmutableArrayListTest::toSortedListBy;
            this.payloads.removeAtIndex = ImmutableArrayListTest::removeAtIndex;
            this.payloads.set = ImmutableArrayListTest::set;
            this.payloads.addAtIndex = ImmutableArrayListTest::addAtIndex;
            this.payloads.addAllAtIndex = ImmutableArrayListTest::addAllAtIndex;
            this.payloads.sort = ImmutableArrayListTest::sort;
            this.payloads.replaceAll = ImmutableArrayListTest::replaceAll;
            this.payloads.subList = ImmutableArrayListTest::subList;
            this.payloads.subListFromNegative = ImmutableArrayListTest::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = ImmutableArrayListTest::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = ImmutableArrayListTest::subListToGreaterThanSize;
            this.payloads.listIterator = ImmutableArrayListTest::listIterator;
            this.payloads.listIterator_throwsNegative = ImmutableArrayListTest::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = ImmutableArrayListTest::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = ImmutableArrayListTest::toStack;
            this.payloads.take = ImmutableArrayListTest::take;
            this.payloads.take_throws = ImmutableArrayListTest::take_throws;
            this.payloads.takeWhile = ImmutableArrayListTest::takeWhile;
            this.payloads.drop = ImmutableArrayListTest::drop;
            this.payloads.drop_throws = ImmutableArrayListTest::drop_throws;
            this.payloads.dropWhile = ImmutableArrayListTest::dropWhile;
            this.payloads.partitionWhile = ImmutableArrayListTest::partitionWhile;
            this.payloads.collectBoolean = ImmutableArrayListTest::collectBoolean;
            this.payloads.collectWithIndex = ImmutableArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableArrayListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = ImmutableArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableArrayListTest::rejectWithIndexWithTarget;
            this.payloads.groupBy = ImmutableArrayListTest::groupBy;
            this.payloads.groupByEach = ImmutableArrayListTest::groupByEach;
            this.payloads.asReversed = ImmutableArrayListTest::asReversed;
            this.payloads.toReversed = ImmutableArrayListTest::toReversed;
            this.payloads.toImmutable = ImmutableArrayListTest::toImmutable;
            this.payloads.newWith = ImmutableArrayListTest::newWith;
            this.payloads.newWithAll = ImmutableArrayListTest::newWithAll;
            this.payloads.newWithOut = ImmutableArrayListTest::newWithOut;
            this.payloads.newWithoutAll = ImmutableArrayListTest::newWithoutAll;
            this.payloads.newListWith = ImmutableArrayListTest::newListWith;
            this.payloads.newListWithVarArgs = ImmutableArrayListTest::newListWithVarArgs;
            this.payloads.toSet = ImmutableArrayListTest::toSet;
            this.payloads.toMap = ImmutableArrayListTest::toMap;
            this.payloads.serialization = ImmutableArrayListTest::serialization;
            this.payloads.forEachWithIndexIllegalFrom = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::forEachWithIndexIllegalFrom, java.lang.IndexOutOfBoundsException.class);
            this.payloads.forEachWithIndexIllegalTo = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::forEachWithIndexIllegalTo, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get = ImmutableArrayListTest::get;
            this.payloads.iteratorRemove = ImmutableArrayListTest::iteratorRemove;
            this.payloads.groupByUniqueKey = ImmutableArrayListTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableArrayListTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly = ImmutableArrayListTest::getOnly;
            this.payloads.getOnly_exception_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::getOnly_exception_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_exception_when_multiple_items = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayListTest::getOnly_exception_when_multiple_items, java.lang.IllegalStateException.class);
        }
    }
}
