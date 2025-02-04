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

import java.util.Collections;
import java.util.Iterator;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.SynchronizedMutableList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SingletonList}.
 */
public class SingletonListTest extends AbstractMemoryEfficientMutableListTestCase {

    @Override
    protected int getSize() {
        return 1;
    }

    @Override
    protected Class<?> getListType() {
        return SingletonList.class;
    }

    @Test
    public void equalsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.list, FastList.newList(this.list));
        Verify.assertPostSerializedEqualsAndHashCode(this.list);
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedMutableList.class, this.list.asSynchronized());
    }

    @Test
    public void testClone() {
        MutableList<String> clone = this.list.clone();
        Verify.assertEqualsAndHashCode(this.list, clone);
        Verify.assertInstanceOf(SingletonList.class, clone);
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.list.contains("1"));
        Assert.assertFalse(this.list.contains("2"));
    }

    @Test
    public void addingAllToOtherList() {
        MutableList<String> newList = FastList.newList(this.list);
        newList.add("2");
        Verify.assertItemAtIndex("1", 0, newList);
        Verify.assertItemAtIndex("2", 1, newList);
    }

    @Test
    public void get() {
        Verify.assertItemAtIndex("1", 0, this.list);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(1));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.get(-1));
    }

    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.of();
        MutableList<Integer> collection = SingletonListTest.newWith(1);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void forEach() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableList<Integer> collection = SingletonListTest.newWith(1);
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    private static <T> MutableList<T> newWith(T item) {
        return Lists.fixedSize.of(item);
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableList<Integer> collection = SingletonListTest.newWith(1);
        collection.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    @Test
    public void forEachWithIndex() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableList<Integer> collection = SingletonListTest.newWith(1);
        collection.forEachWithIndex((object, index) -> result.add(object + index));
        Verify.assertContainsAll(result, 1);
    }

    @Test
    public void set() {
        Assert.assertEquals("1", this.list.set(0, "2"));
        Assert.assertEquals(FastList.newListWith("2"), this.list);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.list.set(1, "2"));
    }

    @Test
    public void select() {
        Verify.assertContainsAll(SingletonListTest.newWith(1).select(Predicates.lessThan(3)), 1);
        Verify.assertEmpty(SingletonListTest.newWith(1).select(Predicates.greaterThan(3)));
    }

    @Test
    public void selectWith() {
        Verify.assertContainsAll(SingletonListTest.newWith(1).selectWith(Predicates2.lessThan(), 3), 1);
        Verify.assertEmpty(SingletonListTest.newWith(1).selectWith(Predicates2.greaterThan(), 3));
    }

    @Test
    public void reject() {
        Verify.assertEmpty(SingletonListTest.newWith(1).reject(Predicates.lessThan(3)));
        Verify.assertContainsAll(SingletonListTest.newWith(1).reject(Predicates.greaterThan(3), UnifiedSet.newSet()), 1);
    }

    @Test
    public void rejectWith() {
        Verify.assertEmpty(SingletonListTest.newWith(1).rejectWith(Predicates2.lessThan(), 3));
        Verify.assertContainsAll(SingletonListTest.newWith(1).rejectWith(Predicates2.greaterThan(), 3, UnifiedSet.newSet()), 1);
    }

    @Test
    public void collect() {
        Verify.assertContainsAll(SingletonListTest.newWith(1).collect(String::valueOf), "1");
        Verify.assertContainsAll(SingletonListTest.newWith(1).collect(String::valueOf, UnifiedSet.newSet()), "1");
    }

    @Test
    public void flatCollect() {
        Function<Integer, MutableSet<String>> function = object -> UnifiedSet.newSetWith(object.toString());
        Verify.assertListsEqual(FastList.newListWith("1"), SingletonListTest.newWith(1).flatCollect(function));
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1"), SingletonListTest.newWith(1).flatCollect(function, UnifiedSet.newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(Integer.valueOf(1), SingletonListTest.newWith(1).detect(Integer.valueOf(1)::equals));
        Assert.assertNull(SingletonListTest.newWith(1).detect(Integer.valueOf(6)::equals));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(Integer.valueOf(1), SingletonListTest.newWith(1).detectWith(Object::equals, 1));
        Assert.assertNull(SingletonListTest.newWith(1).detectWith(Object::equals, 6));
    }

    @Test
    public void detectIfNone() {
        Function0<Integer> function = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(1), SingletonListTest.newWith(1).detectIfNone(Integer.valueOf(1)::equals, function));
        Assert.assertEquals(Integer.valueOf(6), SingletonListTest.newWith(1).detectIfNone(Integer.valueOf(6)::equals, function));
    }

    @Test
    public void detectWithIfNone() {
        Function0<Integer> function = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(1), SingletonListTest.newWith(1).detectWithIfNone(Object::equals, 1, function));
        Assert.assertEquals(Integer.valueOf(6), SingletonListTest.newWith(1).detectWithIfNone(Object::equals, 6, function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(SingletonListTest.newWith(1).allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(SingletonListTest.newWith(1).allSatisfy(Integer.valueOf(2)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(SingletonListTest.newWith(1).allSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(SingletonListTest.newWith(1).allSatisfyWith(Object::equals, 2));
    }

    @Test
    public void anySatisfy() {
        Assert.assertFalse(SingletonListTest.newWith(1).anySatisfy(String.class::isInstance));
        Assert.assertTrue(SingletonListTest.newWith(1).anySatisfy(Integer.class::isInstance));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertFalse(SingletonListTest.newWith(1).anySatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertTrue(SingletonListTest.newWith(1).anySatisfyWith(Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(SingletonListTest.newWith(1).noneSatisfy(String.class::isInstance));
        Assert.assertFalse(SingletonListTest.newWith(1).noneSatisfy(Integer.valueOf(1)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(SingletonListTest.newWith(1).noneSatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertFalse(SingletonListTest.newWith(1).noneSatisfyWith(Object::equals, 1));
    }

    @Test
    public void count() {
        Assert.assertEquals(1, SingletonListTest.newWith(1).count(Integer.class::isInstance));
        Assert.assertEquals(0, SingletonListTest.newWith(1).count(String.class::isInstance));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(1, SingletonListTest.newWith(1).countWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertEquals(0, SingletonListTest.newWith(1).countWith(Predicates2.instanceOf(), String.class));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(SingletonListTest.newWith(1).collectIf(Integer.class::isInstance, String::valueOf), "1");
        Verify.assertContainsAll(SingletonListTest.newWith(1).collectIf(Integer.class::isInstance, String::valueOf, FastList.newList()), "1");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(FastList.newListWith(2), SingletonListTest.newWith(1).collectWith(AddFunction.INTEGER, 1));
        Assert.assertEquals(FastList.newListWith(2), SingletonListTest.newWith(1).collectWith(AddFunction.INTEGER, 1, FastList.newList()));
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(Integer.valueOf(1), SingletonListTest.newWith(1).getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertEquals(Integer.valueOf(1), SingletonListTest.newWith(1).getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertEquals(Integer.valueOf(1), SingletonListTest.newWith(1).getOnly());
    }

    @Test
    public void isEmpty() {
        Verify.assertNotEmpty(SingletonListTest.newWith(1));
        Assert.assertTrue(SingletonListTest.newWith(1).notEmpty());
    }

    @Test
    public void iterator() {
        MutableList<Integer> objects = SingletonListTest.newWith(1);
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Integer integer = iterator.next();
            Assert.assertEquals(1, integer.intValue() + i);
        }
    }

    @Test
    public void injectInto() {
        MutableList<Integer> objects = SingletonListTest.newWith(1);
        Integer result = objects.injectInto(1, AddFunction.INTEGER);
        Assert.assertEquals(Integer.valueOf(2), result);
    }

    @Test
    public void injectIntoWith() {
        MutableList<Integer> objects = SingletonListTest.newWith(1);
        Integer result = objects.injectIntoWith(1, (injectedValued, item, parameter) -> injectedValued + item + parameter, 0);
        Assert.assertEquals(Integer.valueOf(2), result);
    }

    @Test
    public void toArray() {
        MutableList<Integer> objects = SingletonListTest.newWith(1);
        Object[] array = objects.toArray();
        Verify.assertSize(1, array);
        Integer[] array2 = objects.toArray(new Integer[1]);
        Verify.assertSize(1, array2);
    }

    @Test
    public void selectAndRejectWith() {
        MutableList<Integer> objects = SingletonListTest.newWith(1);
        Twin<MutableList<Integer>> result = objects.selectAndRejectWith(Object::equals, 1);
        Verify.assertSize(1, result.getOne());
        Verify.assertEmpty(result.getTwo());
    }

    @Test
    public void removeIf() {
        MutableList<Integer> objects = SingletonListTest.newWith(1);
        Assert.assertThrows(UnsupportedOperationException.class, () -> objects.removeIf(Predicates.isNull()));
    }

    @Test
    public void removeIfWith() {
        MutableList<Integer> objects = SingletonListTest.newWith(1);
        Assert.assertThrows(UnsupportedOperationException.class, () -> objects.removeIfWith(Predicates2.isNull(), null));
    }

    @Test
    public void toList() {
        MutableList<Integer> list = SingletonListTest.newWith(1).toList();
        list.add(2);
        list.add(3);
        list.add(4);
        Verify.assertContainsAll(list, 1, 2, 3, 4);
    }

    @Test
    public void toSortedList() {
        MutableList<Integer> integers = SingletonListTest.newWith(1);
        MutableList<Integer> list = integers.toSortedList(Collections.reverseOrder());
        Verify.assertStartsWith(list, 1);
        Assert.assertNotSame(integers, list);
        MutableList<Integer> list2 = integers.toSortedList();
        Verify.assertStartsWith(list2, 1);
        Assert.assertNotSame(integers, list2);
    }

    @Test
    public void toSortedListBy() {
        MutableList<Integer> integers = SingletonListTest.newWith(1);
        MutableList<Integer> list = integers.toSortedListBy(Functions.getIntegerPassThru());
        Assert.assertEquals(FastList.newListWith(1), list);
        Assert.assertNotSame(integers, list);
    }

    @Test
    public void toSet() {
        MutableList<Integer> integers = SingletonListTest.newWith(1);
        MutableSet<Integer> set = integers.toSet();
        Verify.assertContainsAll(set, 1);
    }

    @Test
    public void toMap() {
        MutableList<Integer> integers = SingletonListTest.newWith(1);
        MutableMap<Integer, Integer> map = integers.toMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru());
        Verify.assertContainsAll(map.keySet(), 1);
        Verify.assertContainsAll(map.values(), 1);
    }

    @Test
    public void forLoop() {
        MutableList<String> list = SingletonListTest.newWith("one");
        MutableList<String> upperList = SingletonListTest.newWith("ONE");
        for (String each : list) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
    }

    @Test
    public void subList() {
        MutableList<String> list = SingletonListTest.newWith("one");
        MutableList<String> subList = list.subList(0, 1);
        MutableList<String> upperList = SingletonListTest.newWith("ONE");
        for (String each : subList) {
            Verify.assertContains(each.toUpperCase(), upperList);
        }
        Assert.assertEquals("one", subList.getFirst());
        Assert.assertEquals("one", subList.getLast());
    }

    @Test
    public void testToString() {
        MutableList<MutableList<?>> list = Lists.fixedSize.of(Lists.fixedSize.of());
        list.set(0, list);
        Assert.assertEquals("[(this SingletonList)]", list.toString());
    }

    private MutableList<Integer> newList() {
        return Lists.fixedSize.of(1);
    }

    private MutableList<Integer> classUnderTestWithNull() {
        return Lists.fixedSize.of((Integer) null);
    }

    @Test
    public void min_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.classUnderTestWithNull().min(Integer::compareTo);
    }

    @Test
    public void max_null_throws() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.classUnderTestWithNull().max(Integer::compareTo);
    }

    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(1), this.newList().min(Integer::compareTo));
    }

    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(1), this.newList().max(Comparators.reverse(Integer::compareTo)));
    }

    @Test
    public void min_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.classUnderTestWithNull().min();
    }

    @Test
    public void max_null_throws_without_comparator() {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        this.classUnderTestWithNull().max();
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(Integer.valueOf(1), this.newList().min());
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(Integer.valueOf(this.newList().size()), this.newList().max());
    }

    @Test
    public void minBy() {
        Assert.assertEquals(Integer.valueOf(1), this.newList().minBy(String::valueOf));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(Integer.valueOf(1), this.newList().maxBy(String::valueOf));
    }

    @Test
    public void without() {
        MutableList<Integer> list = new SingletonList<>(2);
        Assert.assertSame(list, list.without(9));
        list = list.without(2);
        Verify.assertListsEqual(Lists.mutable.of(), list);
        Verify.assertInstanceOf(EmptyList.class, list);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SingletonListTest instance;

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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addingAllToOtherList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addingAllToOtherList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> payload) throws java.lang.Throwable {
            this.instance = new SingletonListTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> testGetClass;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> subList_methodsThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> addingAllToOtherList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonListTest> without;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testGetClass = SingletonListTest::testGetClass;
            this.payloads.replaceAll = SingletonListTest::replaceAll;
            this.payloads.sort = SingletonListTest::sort;
            this.payloads.sortThis = SingletonListTest::sortThis;
            this.payloads.sortThisWithComparator = SingletonListTest::sortThisWithComparator;
            this.payloads.sortThisBy = SingletonListTest::sortThisBy;
            this.payloads.sortThisByInt = SingletonListTest::sortThisByInt;
            this.payloads.sortThisByBoolean = SingletonListTest::sortThisByBoolean;
            this.payloads.sortThisByChar = SingletonListTest::sortThisByChar;
            this.payloads.sortThisByByte = SingletonListTest::sortThisByByte;
            this.payloads.sortThisByShort = SingletonListTest::sortThisByShort;
            this.payloads.sortThisByFloat = SingletonListTest::sortThisByFloat;
            this.payloads.sortThisByLong = SingletonListTest::sortThisByLong;
            this.payloads.sortThisByDouble = SingletonListTest::sortThisByDouble;
            this.payloads.reverseThis = SingletonListTest::reverseThis;
            this.payloads.toReversed = SingletonListTest::toReversed;
            this.payloads.with = SingletonListTest::with;
            this.payloads.withAll = SingletonListTest::withAll;
            this.payloads.withoutAll = SingletonListTest::withoutAll;
            this.payloads.toStack = SingletonListTest::toStack;
            this.payloads.aggregateByMutating = SingletonListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SingletonListTest::aggregateByNonMutating;
            this.payloads.add = SingletonListTest::add;
            this.payloads.addAtIndex = SingletonListTest::addAtIndex;
            this.payloads.addAll = SingletonListTest::addAll;
            this.payloads.addAllAtIndex = SingletonListTest::addAllAtIndex;
            this.payloads.addAllIterable = SingletonListTest::addAllIterable;
            this.payloads.removeIndex = SingletonListTest::removeIndex;
            this.payloads.remove = SingletonListTest::remove;
            this.payloads.removeAll = SingletonListTest::removeAll;
            this.payloads.removeAllIterable = SingletonListTest::removeAllIterable;
            this.payloads.retainAll = SingletonListTest::retainAll;
            this.payloads.retainAllIterable = SingletonListTest::retainAllIterable;
            this.payloads.clear = SingletonListTest::clear;
            this.payloads.subList_methodsThrow = SingletonListTest::subList_methodsThrow;
            this.payloads.equalsAndHashCode = SingletonListTest::equalsAndHashCode;
            this.payloads.asSynchronized = SingletonListTest::asSynchronized;
            this.payloads.testClone = SingletonListTest::testClone;
            this.payloads.contains = SingletonListTest::contains;
            this.payloads.addingAllToOtherList = SingletonListTest::addingAllToOtherList;
            this.payloads.get = SingletonListTest::get;
            this.payloads.tap = SingletonListTest::tap;
            this.payloads.forEach = SingletonListTest::forEach;
            this.payloads.forEachWith = SingletonListTest::forEachWith;
            this.payloads.forEachWithIndex = SingletonListTest::forEachWithIndex;
            this.payloads.set = SingletonListTest::set;
            this.payloads.select = SingletonListTest::select;
            this.payloads.selectWith = SingletonListTest::selectWith;
            this.payloads.reject = SingletonListTest::reject;
            this.payloads.rejectWith = SingletonListTest::rejectWith;
            this.payloads.collect = SingletonListTest::collect;
            this.payloads.flatCollect = SingletonListTest::flatCollect;
            this.payloads.detect = SingletonListTest::detect;
            this.payloads.detectWith = SingletonListTest::detectWith;
            this.payloads.detectIfNone = SingletonListTest::detectIfNone;
            this.payloads.detectWithIfNone = SingletonListTest::detectWithIfNone;
            this.payloads.allSatisfy = SingletonListTest::allSatisfy;
            this.payloads.allSatisfyWith = SingletonListTest::allSatisfyWith;
            this.payloads.anySatisfy = SingletonListTest::anySatisfy;
            this.payloads.anySatisfyWith = SingletonListTest::anySatisfyWith;
            this.payloads.noneSatisfy = SingletonListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SingletonListTest::noneSatisfyWith;
            this.payloads.count = SingletonListTest::count;
            this.payloads.countWith = SingletonListTest::countWith;
            this.payloads.collectIf = SingletonListTest::collectIf;
            this.payloads.collectWith = SingletonListTest::collectWith;
            this.payloads.getFirst = SingletonListTest::getFirst;
            this.payloads.getLast = SingletonListTest::getLast;
            this.payloads.getOnly = SingletonListTest::getOnly;
            this.payloads.isEmpty = SingletonListTest::isEmpty;
            this.payloads.iterator = SingletonListTest::iterator;
            this.payloads.injectInto = SingletonListTest::injectInto;
            this.payloads.injectIntoWith = SingletonListTest::injectIntoWith;
            this.payloads.toArray = SingletonListTest::toArray;
            this.payloads.selectAndRejectWith = SingletonListTest::selectAndRejectWith;
            this.payloads.removeIf = SingletonListTest::removeIf;
            this.payloads.removeIfWith = SingletonListTest::removeIfWith;
            this.payloads.toList = SingletonListTest::toList;
            this.payloads.toSortedList = SingletonListTest::toSortedList;
            this.payloads.toSortedListBy = SingletonListTest::toSortedListBy;
            this.payloads.toSet = SingletonListTest::toSet;
            this.payloads.toMap = SingletonListTest::toMap;
            this.payloads.forLoop = SingletonListTest::forLoop;
            this.payloads.subList = SingletonListTest::subList;
            this.payloads.testToString = SingletonListTest::testToString;
            this.payloads.min_null_throws = SingletonListTest::min_null_throws;
            this.payloads.max_null_throws = SingletonListTest::max_null_throws;
            this.payloads.min = SingletonListTest::min;
            this.payloads.max = SingletonListTest::max;
            this.payloads.min_null_throws_without_comparator = SingletonListTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = SingletonListTest::max_null_throws_without_comparator;
            this.payloads.min_without_comparator = SingletonListTest::min_without_comparator;
            this.payloads.max_without_comparator = SingletonListTest::max_without_comparator;
            this.payloads.minBy = SingletonListTest::minBy;
            this.payloads.maxBy = SingletonListTest::maxBy;
            this.payloads.without = SingletonListTest::without;
        }
    }
*/
}
