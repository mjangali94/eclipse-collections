/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.UnsortedSetIterable;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableUnifiedSetTestCase {

    public abstract ImmutableSet<Integer> newSet(Integer... elements);

    public abstract ImmutableSet<Integer> newSetWith(int one, int two);

    public abstract ImmutableSet<Integer> newSetWith(int one, int two, int three);

    public abstract ImmutableSet<Integer> newSetWith(int... littleElements);

    @Test
    public void newCollection() {
        ImmutableSet<Integer> set = this.newSet();
        Assert.assertTrue(set.isEmpty());
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void newWith() {
        ImmutableSet<Integer> set = this.newSet(1, 2, 3);
        ImmutableSet<Integer> with = set.newWith(4);
        Assert.assertNotEquals(set, with);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), with);
        Assert.assertSame(set, set.newWith(3));
    }

    @Test
    public void newWithAll() {
        ImmutableSet<Integer> set = this.newSet(1, 2, 3);
        ImmutableSet<Integer> withAll = set.newWithAll(UnifiedSet.newSetWith(4, 5));
        Assert.assertNotEquals(set, withAll);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5), withAll);
    }

    @Test
    public void newWithOut() {
        ImmutableSet<Integer> set = this.newSet(1, 2, 3, 4);
        ImmutableSet<Integer> without = set.newWithout(4);
        Assert.assertNotEquals(set, without);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), without);
        Assert.assertSame(set, set.newWithout(5));
    }

    @Test
    public void newWithoutAll() {
        ImmutableSet<Integer> set = this.newSet(1, 2, 3, 4, 5);
        ImmutableSet<Integer> withoutAll = set.newWithoutAll(UnifiedSet.newSetWith(4, 5));
        Assert.assertNotEquals(set, withoutAll);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), withoutAll);
        ImmutableSet<Integer> largeList = this.newSet(Interval.oneTo(200).toArray());
        ImmutableSet<Integer> largeWithoutAll = largeList.newWithoutAll(FastList.newList(Interval.oneTo(100)));
        Assert.assertEquals(UnifiedSet.newSet(Interval.fromTo(101, 200)), largeWithoutAll);
        ImmutableSet<Integer> largeWithoutAll2 = largeWithoutAll.newWithoutAll(Interval.fromTo(101, 150));
        Assert.assertEquals(UnifiedSet.newSet(Interval.fromTo(151, 200)), largeWithoutAll2);
        ImmutableSet<Integer> largeWithoutAll3 = largeWithoutAll2.newWithoutAll(UnifiedSet.newSet(Interval.fromTo(151, 199)));
        Assert.assertEquals(UnifiedSet.newSetWith(200), largeWithoutAll3);
    }

    @Test
    public void newSetWith() {
        ImmutableSet<Integer> set = this.newSetWith(1);
        Assert.assertTrue(set.notEmpty());
        Assert.assertEquals(1, set.size());
        Assert.assertTrue(set.contains(1));
    }

    @Test
    public void newListWithVarArgs() {
        ImmutableSet<Integer> set = this.newSetWith(1, 2, 3, 4);
        Assert.assertTrue(set.notEmpty());
        Assert.assertEquals(4, set.size());
        Assert.assertTrue(set.containsAllArguments(1, 2, 3, 4));
        Assert.assertTrue(set.containsAllIterable(Interval.oneTo(4)));
    }

    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.of();
        ImmutableSet<Integer> set = this.newSetWith(1, 2, 3, 4);
        Assert.assertSame(set, set.tap(tapResult::add));
        Assert.assertEquals(set.toList(), tapResult);
    }

    @Test
    public void forEach() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableSet<Integer> set = this.newSetWith(1, 2, 3, 4);
        set.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    @Test
    public void forEachWithIndex() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableSet<Integer> set = this.newSetWith(1, 2, 3, 4);
        set.forEachWithIndex((object, index) -> result.add(object + index));
        Verify.assertContainsAll(result, 1, 3, 5, 7);
    }

    @Test
    public void select() {
        Assert.assertTrue(this.newSetWith(1, 2, 3, 4, 5).select(Predicates.lessThan(3)).containsAllArguments(1, 2));
        Assert.assertFalse(this.newSetWith(-1, 2, 3, 4, 5).select(Predicates.lessThan(3)).containsAllArguments(3, 4, 5));
    }

    @Test
    public void reject() {
        Assert.assertTrue(this.newSetWith(1, 2, 3, 4).reject(Predicates.lessThan(3)).containsAllArguments(3, 4));
    }

    @Test
    public void collect() {
        Assert.assertTrue(this.newSetWith(1, 2, 3, 4).collect(String::valueOf).containsAllArguments("1", "2", "3", "4"));
    }

    @Test
    public void detect() {
        Assert.assertEquals(Integer.valueOf(3), this.newSetWith(1, 2, 3, 4, 5).detect(Integer.valueOf(3)::equals));
        Assert.assertNull(this.newSetWith(1, 2, 3, 4, 5).detect(Integer.valueOf(6)::equals));
    }

    @Test
    public void detectIfNone() {
        Function0<Integer> function = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(3), this.newSetWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(3)::equals, function));
        Assert.assertEquals(Integer.valueOf(6), this.newSetWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(6)::equals, function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newSetWith(1, 2, 3).allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(this.newSetWith(1, 2, 3).allSatisfy(Integer.valueOf(1)::equals));
    }

    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.newSetWith(1, 2, 3).anySatisfy(String.class::isInstance));
        Assert.assertTrue(this.newSetWith(1, 2, 3).anySatisfy(Integer.class::isInstance));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newSetWith(1, 2, 3).noneSatisfy(String.class::isInstance));
        Assert.assertTrue(this.newSetWith(1, 2, 3).noneSatisfy(Integer.valueOf(100)::equals));
        Assert.assertFalse(this.newSetWith(1, 2, 3).noneSatisfy(Integer.valueOf(1)::equals));
    }

    @Test
    public void count() {
        Assert.assertEquals(3, this.newSetWith(1, 2, 3).count(Integer.class::isInstance));
    }

    @Test
    public void collectIf() {
        Assert.assertTrue(this.newSetWith(1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf).containsAllArguments("1", "2", "3"));
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(Integer.valueOf(1), this.newSetWith(1, 2, 3).getFirst());
        Assert.assertNotEquals(Integer.valueOf(3), this.newSetWith(1, 2, 3).getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertNotNull(this.newSetWith(1, 2, 3).getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertEquals(Integer.valueOf(1), this.newSetWith(1).getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_throws_when_empty() {
        this.newSet().getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_throws_when_multiple_values() {
        this.newSetWith(1, 2, 3).getOnly();
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.newSet().isEmpty());
        Assert.assertTrue(this.newSetWith(1, 2).notEmpty());
    }

    @Test
    public void iterator() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Integer integer = iterator.next();
            Assert.assertEquals(3, integer.intValue() + i);
        }
    }

    @Test
    public void injectInto() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        Integer result = objects.injectInto(1, AddFunction.INTEGER);
        Assert.assertEquals(Integer.valueOf(7), result);
    }

    @Test
    public void injectIntoInt() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        int result = objects.injectInto(1, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(7, result);
    }

    @Test
    public void injectIntoLong() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        long result = objects.injectInto(1, AddFunction.INTEGER_TO_LONG);
        Assert.assertEquals(7, result);
    }

    @Test
    public void injectIntoDouble() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        double result = objects.injectInto(1, AddFunction.INTEGER_TO_DOUBLE);
        Assert.assertEquals(7.0d, result, 0.001);
    }

    @Test
    public void injectIntoFloat() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        float result = objects.injectInto(1, AddFunction.INTEGER_TO_FLOAT);
        Assert.assertEquals(7.0d, result, 0.001);
    }

    @Test
    public void sumFloat() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        double actual = objects.sumOfFloat(Integer::floatValue);
        Assert.assertEquals(6.0f, actual, 0.001);
    }

    @Test
    public void sumDouble() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        double actual = objects.sumOfDouble(Integer::doubleValue);
        Assert.assertEquals(6.0d, actual, 0.001);
    }

    @Test
    public void sumInteger() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        long actual = objects.sumOfInt(integer -> integer);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void sumLong() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        long actual = objects.sumOfLong(Integer::longValue);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void toArray() {
        ImmutableSet<Integer> objects = this.newSetWith(1, 2, 3);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        Integer[] array2 = objects.toArray(new Integer[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void equalsAndHashCode() {
        ImmutableSet<Integer> set1 = this.newSetWith(1, 2, 3, 4);
        ImmutableSet<Integer> set2 = this.newSetWith(1, 2, 3, 4);
        ImmutableSet<Integer> set3 = this.newSetWith(2, 3, 4);
        Assert.assertNotEquals(set1, null);
        Verify.assertEqualsAndHashCode(set1, set1);
        Verify.assertEqualsAndHashCode(set1, set2);
        Assert.assertNotEquals(set2, set3);
        UnifiedSet<Integer> fastSet = UnifiedSet.newSet(set1);
        Verify.assertEqualsAndHashCode(set1, fastSet);
        Assert.assertEquals(set1, new HashSet<>(fastSet));
        Verify.assertEqualsAndHashCode(set1, UnifiedSet.newSetWith(1, 2, 3, 4));
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableSet<Integer> collection = this.newSetWith(1, 2, 3, 4);
        collection.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    @Test
    public void toList() {
        ImmutableSet<Integer> integers = this.newSetWith(1, 2, 3, 4);
        MutableList<Integer> list = integers.toList();
        Assert.assertTrue(list.containsAllArguments(1, 2, 3, 4));
    }

    @Test
    public void toSortedList() {
        ImmutableSet<Integer> integers = this.newSetWith(2, 4, 1, 3);
        MutableList<Integer> list = integers.toSortedList(Collections.reverseOrder());
        Assert.assertEquals(FastList.newListWith(4, 3, 2, 1), list);
    }

    @Test
    public void toSortedListBy() {
        ImmutableSet<Integer> integers = this.newSetWith(2, 4, 1, 3);
        MutableList<Integer> list = integers.toSortedListBy(String::valueOf);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), list);
    }

    @Test
    public void asSortedSet() {
        ImmutableSet<Integer> integers = this.newSetWith(2, 3, 1, 4);
        MutableSortedSet<Integer> set = integers.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(integers), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        ImmutableSet<Integer> integers = this.newSetWith(2, 4, 1, 3);
        MutableSortedSet<Integer> set = integers.toSortedSet(Collections.reverseOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 1, 2, 3, 4), set);
    }

    @Test
    public void toSortedSetBy() {
        ImmutableSet<Integer> integers = this.newSetWith(4, 1, 3, 2);
        MutableSortedSet<Integer> set = integers.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), set);
    }

    @Test
    public void toSet() {
        ImmutableSet<Integer> integers = this.newSetWith(1, 2, 3, 4);
        MutableSet<Integer> set = integers.toSet();
        Verify.assertContainsAll(set, 1, 2, 3, 4);
    }

    @Test
    public void toMap() {
        ImmutableSet<Integer> integers = this.newSetWith(1, 2, 3, 4);
        MutableMap<String, String> map = integers.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1", "2", "2", "3", "3", "4", "4"), map);
    }

    @Test
    public void serialization() {
        ImmutableSet<Integer> set = this.newSetWith(1, 2, 3, 4, 5);
        ImmutableSet<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(set);
        Assert.assertEquals(5, deserializedCollection.size());
        Assert.assertTrue(deserializedCollection.containsAllArguments(1, 2, 3, 4, 5));
        Verify.assertEqualsAndHashCode(set, deserializedCollection);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[1]", this.newSetWith(1).toString());
    }

    @Test
    public void powerSet() {
        ImmutableSet<Integer> set = this.newSetWith(1, 2, 3);
        ImmutableSet<UnsortedSetIterable<Integer>> powerSet = set.powerSet();
        Verify.assertSize(8, powerSet);
        Verify.assertContains(set, powerSet);
        Verify.assertContains(Sets.immutable.<Integer>of(), powerSet);
        Verify.assertInstanceOf(ImmutableSet.class, powerSet.getFirst());
        Verify.assertInstanceOf(ImmutableSet.class, powerSet.getLast());
    }

    @Test
    public void groupByUniqueKey() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), this.newSetWith(1, 2, 3).groupByUniqueKey(id -> id));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws() {
        this.newSetWith(1, 2, 3).groupByUniqueKey(Functions.getFixedValue(1));
    }

    @Test
    public void groupByUniqueKey_target() {
        MutableMap<Integer, Integer> integers = this.newSetWith(1, 2, 3).groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), integers);
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws() {
        this.newSetWith(1, 2, 3).groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(2, 2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableUnifiedSetTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_newSetWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newSetWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableUnifiedSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> newWithOut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> newSetWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> newListWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> asSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableUnifiedSetTestCase> groupByUniqueKey_target_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollection = AbstractImmutableUnifiedSetTestCase::newCollection;
            this.payloads.newWith = AbstractImmutableUnifiedSetTestCase::newWith;
            this.payloads.newWithAll = AbstractImmutableUnifiedSetTestCase::newWithAll;
            this.payloads.newWithOut = AbstractImmutableUnifiedSetTestCase::newWithOut;
            this.payloads.newWithoutAll = AbstractImmutableUnifiedSetTestCase::newWithoutAll;
            this.payloads.newSetWith = AbstractImmutableUnifiedSetTestCase::newSetWith;
            this.payloads.newListWithVarArgs = AbstractImmutableUnifiedSetTestCase::newListWithVarArgs;
            this.payloads.tap = AbstractImmutableUnifiedSetTestCase::tap;
            this.payloads.forEach = AbstractImmutableUnifiedSetTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractImmutableUnifiedSetTestCase::forEachWithIndex;
            this.payloads.select = AbstractImmutableUnifiedSetTestCase::select;
            this.payloads.reject = AbstractImmutableUnifiedSetTestCase::reject;
            this.payloads.collect = AbstractImmutableUnifiedSetTestCase::collect;
            this.payloads.detect = AbstractImmutableUnifiedSetTestCase::detect;
            this.payloads.detectIfNone = AbstractImmutableUnifiedSetTestCase::detectIfNone;
            this.payloads.allSatisfy = AbstractImmutableUnifiedSetTestCase::allSatisfy;
            this.payloads.anySatisfy = AbstractImmutableUnifiedSetTestCase::anySatisfy;
            this.payloads.noneSatisfy = AbstractImmutableUnifiedSetTestCase::noneSatisfy;
            this.payloads.count = AbstractImmutableUnifiedSetTestCase::count;
            this.payloads.collectIf = AbstractImmutableUnifiedSetTestCase::collectIf;
            this.payloads.getFirst = AbstractImmutableUnifiedSetTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableUnifiedSetTestCase::getLast;
            this.payloads.getOnly = AbstractImmutableUnifiedSetTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableUnifiedSetTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableUnifiedSetTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractImmutableUnifiedSetTestCase::isEmpty;
            this.payloads.iterator = AbstractImmutableUnifiedSetTestCase::iterator;
            this.payloads.injectInto = AbstractImmutableUnifiedSetTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractImmutableUnifiedSetTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractImmutableUnifiedSetTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableUnifiedSetTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractImmutableUnifiedSetTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractImmutableUnifiedSetTestCase::sumFloat;
            this.payloads.sumDouble = AbstractImmutableUnifiedSetTestCase::sumDouble;
            this.payloads.sumInteger = AbstractImmutableUnifiedSetTestCase::sumInteger;
            this.payloads.sumLong = AbstractImmutableUnifiedSetTestCase::sumLong;
            this.payloads.toArray = AbstractImmutableUnifiedSetTestCase::toArray;
            this.payloads.equalsAndHashCode = AbstractImmutableUnifiedSetTestCase::equalsAndHashCode;
            this.payloads.forEachWith = AbstractImmutableUnifiedSetTestCase::forEachWith;
            this.payloads.toList = AbstractImmutableUnifiedSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableUnifiedSetTestCase::toSortedList;
            this.payloads.toSortedListBy = AbstractImmutableUnifiedSetTestCase::toSortedListBy;
            this.payloads.asSortedSet = AbstractImmutableUnifiedSetTestCase::asSortedSet;
            this.payloads.toSortedSet_with_comparator = AbstractImmutableUnifiedSetTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractImmutableUnifiedSetTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractImmutableUnifiedSetTestCase::toSet;
            this.payloads.toMap = AbstractImmutableUnifiedSetTestCase::toMap;
            this.payloads.serialization = AbstractImmutableUnifiedSetTestCase::serialization;
            this.payloads.testToString = AbstractImmutableUnifiedSetTestCase::testToString;
            this.payloads.powerSet = AbstractImmutableUnifiedSetTestCase::powerSet;
            this.payloads.groupByUniqueKey = AbstractImmutableUnifiedSetTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableUnifiedSetTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractImmutableUnifiedSetTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableUnifiedSetTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
        }
    }
}
