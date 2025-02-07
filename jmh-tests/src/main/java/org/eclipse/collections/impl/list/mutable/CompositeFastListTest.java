/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.parallel.ParallelIterate;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class CompositeFastListTest extends AbstractListTestCase {

    @Override
    protected <T> MutableList<T> newWith(T... littleElements) {
        MutableList<T> result = new CompositeFastList<>();
        for (T element : littleElements) {
            result.add(element);
        }
        return result;
    }

    @Override
    @Test
    public void testClone() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newWith().clone());
    }

    @Test
    public void size() {
        CompositeFastList<String> list = new CompositeFastList<>();
        Verify.assertSize(0, list);
        list.add("1");
        Verify.assertSize(1, list);
        list.addAll(FastList.newListWith("1", "1", "1", "1"));
        Verify.assertSize(5, list);
        list.remove(1);
        Verify.assertSize(4, list);
        list.remove("1");
        Verify.assertSize(3, list);
        list.add(3, "1");
        Verify.assertSize(4, list);
        ListIterator<String> listIterator = list.listIterator();
        listIterator.add("1");
        Verify.assertSize(5, list);
        listIterator.next();
        listIterator.remove();
        Verify.assertSize(4, list);
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.remove();
        Verify.assertSize(3, list);
        list.removeAll(FastList.newListWith("1"));
        Verify.assertSize(0, list);
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        Verify.assertSize(8, list);
        list.clear();
        Verify.assertSize(0, list);
        CompositeFastList<String> list2 = new CompositeFastList<>();
        Verify.assertSize(0, list2);
        list2.listIterator().add("1");
        Verify.assertSize(1, list2);
    }

    @Test
    public void testDefaultConstructor() {
        MutableList<String> list = new CompositeFastList<>();
        list.add("1");
        list.add("2");
        Verify.assertSize(2, list);
        Verify.assertContains("1", list);
    }

    @Test
    public void parallelBatchForEach() {
        MutableList<Integer> integers = Interval.oneTo(1_000_000).toList().shuffleThis();
        Collection<Integer> evens = ParallelIterate.select(integers, IntegerPredicates.isEven());
        Verify.assertInstanceOf(CompositeFastList.class, evens);
        Collection<Integer> evens2 = ParallelIterate.select(evens, e -> e <= 100_000);
        Verify.assertInstanceOf(CompositeFastList.class, evens2);
        Verify.assertSize(50_000, evens2);
        Collection<String> evenStrings = ParallelIterate.collect(evens2, Object::toString);
        Verify.assertInstanceOf(CompositeFastList.class, evenStrings);
        Verify.assertSize(50_000, evenStrings);
        Assert.assertEquals(integers.select(e -> e <= 100_000).select(IntegerPredicates.isEven()).collect(Object::toString).toList(), evenStrings);
        Collection<Integer> odds = ParallelIterate.select(integers, IntegerPredicates.isOdd());
        Verify.assertInstanceOf(CompositeFastList.class, odds);
        Collection<Integer> odds2 = ParallelIterate.select(odds, e -> e <= 100_000);
        Verify.assertInstanceOf(CompositeFastList.class, odds2);
        Verify.assertSize(50_000, odds2);
        Collection<String> oddStrings = ParallelIterate.collect(odds2, Object::toString);
        Verify.assertInstanceOf(CompositeFastList.class, oddStrings);
        Verify.assertSize(50_000, oddStrings);
        Assert.assertEquals(integers.select(e -> e <= 100_000).select(IntegerPredicates.isOdd()).collect(Object::toString).toList(), oddStrings);
        MutableList<Integer> range = Interval.fromTo(-1_234_567, 1_234_567).toList().shuffleThis();
        Collection<Integer> positives = ParallelIterate.select(range, IntegerPredicates.isPositive());
        Verify.assertInstanceOf(CompositeFastList.class, positives);
        Verify.assertSize(1_234_567, positives);
        Collection<Integer> evenPositives = ParallelIterate.select(positives, IntegerPredicates.isEven());
        Verify.assertSize(617_283, evenPositives);
        Assert.assertEquals(2000, ParallelIterate.count(evenPositives, e -> e <= 4000));
        Collection<Integer> oddPositives = ParallelIterate.select(positives, IntegerPredicates.isOdd());
        Verify.assertSize(617_284, oddPositives);
        Assert.assertEquals(2000, ParallelIterate.count(oddPositives, e -> e <= 4000));
        Collection<Integer> negatives = ParallelIterate.select(range, IntegerPredicates.isNegative());
        Verify.assertInstanceOf(CompositeFastList.class, negatives);
        Verify.assertSize(1_234_567, negatives);
        Collection<Integer> evenNegatives = ParallelIterate.select(negatives, IntegerPredicates.isEven());
        Verify.assertSize(617_283, evenNegatives);
        Assert.assertEquals(2000, ParallelIterate.count(evenNegatives, e -> e >= -4000));
        Collection<Integer> oddNegatives = ParallelIterate.select(negatives, IntegerPredicates.isOdd());
        Verify.assertSize(617_284, oddNegatives);
        Assert.assertEquals(2000, ParallelIterate.count(oddNegatives, e -> e >= -4000));
    }

    @Test
    public void testGet() {
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("A", "B", "C", "B"));
        list.addAll(FastList.newListWith("Cat", "Dog", "Mouse", "Bird"));
        Assert.assertEquals("1", list.get(0));
        Assert.assertEquals("2", list.get(1));
        Assert.assertEquals("A", list.get(4));
        Assert.assertEquals("4", list.get(3));
        Assert.assertEquals("Cat", list.get(8));
        Assert.assertEquals("Bird", list.get(11));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(12));
    }

    @Test
    public void testAddWithIndex() {
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("A", "B", "C", "B"));
        list.add(3, "NEW");
        Verify.assertSize(9, list);
        Assert.assertEquals("NEW", list.get(3));
        Assert.assertEquals("4", list.get(4));
        list.add(0, "START");
        Verify.assertSize(10, list);
        Assert.assertEquals("START", list.getFirst());
        list.add(10, "END");
        Verify.assertSize(11, list);
        Assert.assertEquals("END", list.getLast());
    }

    @Override
    @Test
    public void reverseThis() {
        super.reverseThis();
        CompositeFastList<Integer> composite = new CompositeFastList<>();
        composite.addAll(FastList.newListWith(9, 8, 7));
        composite.addAll(FastList.newListWith(6, 5, 4));
        composite.addAll(FastList.newListWith(3, 2, 1));
        CompositeFastList<Integer> reversed = composite.reverseThis();
        Assert.assertSame(composite, reversed);
        Assert.assertEquals(Interval.oneTo(9), reversed);
    }

    @Override
    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, super::addAllAtIndex);
    }

    @Override
    @Test
    public void set() {
        super.set();
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("A", "B", "C", "B"));
        Assert.assertEquals("1", list.set(0, "NEW"));
        Verify.assertSize(8, list);
        Assert.assertEquals("NEW", list.getFirst());
        Assert.assertEquals("2", list.get(1));
        Assert.assertEquals("B", list.set(7, "END"));
        Verify.assertSize(8, list);
        Assert.assertEquals("END", list.getLast());
    }

    @Test
    public void set_bugFix_off_by_one_error() {
        MutableList<Integer> compositeList = new CompositeFastList<>();
        MutableList<Integer> list1 = FastList.newListWith(1, 2, 3);
        MutableList<Integer> list2 = FastList.newListWith(4, 5);
        MutableList<Integer> list3 = FastList.newList();
        compositeList.addAll(list1);
        compositeList.addAll(list2);
        compositeList.addAll(list3);
        Assert.assertEquals(Integer.valueOf(4), compositeList.get(3));
        Assert.assertEquals(Integer.valueOf(4), compositeList.set(3, 99));
        Assert.assertEquals(Integer.valueOf(99), compositeList.get(3));
    }

    @Override
    @Test
    public void indexOf() {
        super.indexOf();
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("3", "B", "3", "B"));
        list.addAll(FastList.newListWith("3", "B", "3", "X"));
        Assert.assertEquals(2, list.indexOf("3"));
        Assert.assertEquals(5, list.indexOf("B"));
        Assert.assertEquals(11, list.indexOf("X"));
        Assert.assertEquals(-1, list.indexOf("missing"));
    }

    @Override
    @Test
    public void lastIndexOf() {
        super.lastIndexOf();
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("3", "B", "3", "B"));
        Assert.assertEquals(6, list.lastIndexOf("3"));
        Assert.assertEquals(3, list.lastIndexOf("4"));
        Assert.assertEquals(-1, list.lastIndexOf("missing"));
    }

    @Test
    public void testRemoveWithIndex() {
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("3", "B", "3", "B"));
        Assert.assertEquals("1", list.remove(0));
        Verify.assertSize(7, list);
        Assert.assertEquals("2", list.getFirst());
        Assert.assertEquals("B", list.remove(6));
        Verify.assertSize(6, list);
        Assert.assertEquals("3", list.getLast());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(Lists.mutable.of());
        list.addAll(FastList.newListWith("3", "B", "3", "B"));
        list.addAll(Lists.mutable.of());
        Assert.assertArrayEquals(new String[] { "1", "2", "3", "4", "3", "B", "3", "B" }, list.toArray());
    }

    @Test
    public void testEmptyIterator() {
        Assert.assertFalse(new CompositeFastList<String>().iterator().hasNext());
    }

    @Override
    @Test
    public void clear() {
        super.clear();
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("3", "B", "3", "B"));
        list.clear();
        Assert.assertTrue(list.isEmpty());
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testContainsAll() {
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("3", "B", "3", "B"));
        Assert.assertTrue(list.containsAll(FastList.newList().with("2", "B")));
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableList<String> list = new CompositeFastList<>();
        list.addAll(FastList.newListWith("1", "2", "3", "4"));
        list.addAll(FastList.newListWith("3", "B", "3", "B"));
        list.retainAll(FastList.newList().with("2", "B"));
        Verify.assertSize(3, list);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        MutableList<Integer> list = FastList.newList();
        CompositeFastList<Integer> iterables = new CompositeFastList<>();
        iterables.addComposited(Interval.oneTo(5).toList());
        iterables.addComposited(Interval.fromTo(6, 10).toList());
        iterables.forEach(CollectionAddProcedure.on(list));
        Verify.assertSize(10, list);
        Verify.assertAllSatisfy(list, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<Integer> list = FastList.newList();
        CompositeFastList<Integer> iterables = new CompositeFastList<>();
        iterables.addComposited(Interval.fromTo(6, 10).toList());
        iterables.addComposited(Interval.oneTo(5).toList());
        iterables.forEachWithIndex((each, index) -> list.add(index, each));
        Verify.assertSize(10, list);
        Verify.assertAllSatisfy(list, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
        Verify.assertStartsWith(list, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5);
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        MutableList<Integer> list = FastList.newList();
        CompositeFastList<Integer> iterables = new CompositeFastList<>();
        iterables.addComposited(Interval.fromTo(6, 10).toList());
        iterables.addComposited(Interval.oneTo(5).toList());
        iterables.forEachWith((each, parameter) -> list.add(parameter.intValue(), each), 0);
        Verify.assertSize(10, list);
        Verify.assertAllSatisfy(list, Predicates.greaterThan(0).and(Predicates.lessThan(11)));
        Verify.assertStartsWith(list, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6);
    }

    @Test
    public void testEquals() {
        CompositeFastList<String> composite = new CompositeFastList<>();
        MutableList<String> list = FastList.newList();
        Verify.assertEqualsAndHashCode(composite, list);
        MutableList<String> list2 = FastList.newListWith("one", "two", "three");
        MutableList<String> composite2 = new CompositeFastList<>();
        MutableList<String> firstBit = FastList.newListWith("one", "two");
        MutableList<String> secondBit = FastList.newListWith("three");
        composite2.addAll(firstBit);
        composite2.addAll(secondBit);
        Verify.assertEqualsAndHashCode(list2, composite2);
        Assert.assertNotEquals(firstBit, composite2);
        Assert.assertNotEquals(composite2, firstBit);
        MutableList<String> list1 = FastList.newListWith("one", null, "three");
        CompositeFastList<String> composite1 = new CompositeFastList<>();
        MutableList<String> firstBit1 = FastList.newListWith("one", null);
        MutableList<String> secondBit1 = FastList.newListWith("three");
        composite1.addAll(firstBit1);
        composite1.addAll(secondBit1);
        Verify.assertEqualsAndHashCode(list1, composite1);
    }

    @Test
    public void testHashCode() {
        CompositeFastList<String> composite = new CompositeFastList<>();
        MutableList<String> list = FastList.newList();
        Verify.assertEqualsAndHashCode(composite, list);
        MutableList<String> list2 = FastList.newListWith("one", "two", "three");
        MutableList<String> composite2 = new CompositeFastList<>();
        MutableList<String> firstBit = FastList.newListWith("one", "two");
        MutableList<String> secondBit = FastList.newListWith("three");
        composite2.addAll(firstBit);
        composite2.addAll(secondBit);
        Verify.assertEqualsAndHashCode(list2, composite2);
        MutableList<String> list1 = FastList.newListWith("one", null, "three");
        CompositeFastList<String> composite1 = new CompositeFastList<>();
        MutableList<String> firstBit1 = FastList.newListWith("one", null);
        MutableList<String> secondBit1 = FastList.newListWith("three");
        composite1.addAll(firstBit1);
        composite1.addAll(secondBit1);
        Verify.assertEqualsAndHashCode(list1, composite1);
    }

    @Override
    @Test
    public void listIterator() {
        super.listIterator();
        CompositeFastList<String> composite = new CompositeFastList<>();
        FastList<String> firstBit = FastList.newListWith("one", "two");
        FastList<String> secondBit = FastList.newListWith("three");
        composite.addAll(firstBit);
        composite.addAll(secondBit);
        ListIterator<String> listIterator = composite.listIterator();
        listIterator.add("four");
        Verify.assertSize(4, composite);
        Assert.assertTrue(listIterator.hasNext());
        String element = listIterator.next();
        Assert.assertEquals("one", element);
        String element3 = listIterator.next();
        Assert.assertEquals("two", element3);
        String element2 = listIterator.previous();
        Assert.assertEquals("two", element2);
        String element1 = listIterator.next();
        Assert.assertEquals("two", element1);
        listIterator.remove();
        Verify.assertSize(3, composite);
    }

    @Override
    @Test
    public void subList() {
        MutableList<String> list = this.newWith("A", "B", "C", "D");
        MutableList<String> sublist = list.subList(1, 3);
        Verify.assertPostSerializedEqualsAndHashCode(sublist);
        Verify.assertSize(2, sublist);
        Verify.assertContainsAll(sublist, "B", "C");
        sublist.add("X");
        Verify.assertSize(3, sublist);
        Verify.assertContainsAll(sublist, "B", "C", "X");
        Verify.assertSize(5, list);
        Verify.assertContainsAll(list, "A", "B", "C", "X", "D");
        sublist.remove("X");
        Verify.assertContainsAll(sublist, "B", "C");
        Verify.assertContainsAll(list, "A", "B", "C", "D");
        Assert.assertEquals("C", sublist.set(1, "R"));
        Verify.assertContainsAll(sublist, "B", "R");
        Verify.assertContainsAll(list, "A", "B", "R", "D");
        sublist.clear();
        Verify.assertEmpty(sublist);
        Verify.assertContainsAll(list, "A", "D");
    }

    @Test
    public void notRandomAccess() {
        Assert.assertFalse(this.newWith() instanceof RandomAccess);
    }

    @Test
    public void removingFromIteratorIsCool() {
        CompositeFastList<String> undertest = new CompositeFastList<>();
        undertest.addAll(FastList.newListWith("a"));
        undertest.addAll(FastList.newListWith("b", "c", "d"));
        Iterator<String> iterator1 = undertest.iterator();
        iterator1.next();
        iterator1.next();
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals("d", iterator1.next());
        Assert.assertEquals(FastList.newListWith("a", "b", "d"), undertest);
        Iterator<String> iterator2 = undertest.iterator();
        iterator2.next();
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(FastList.newListWith("a", "d"), undertest);
        Iterator<String> iterator3 = undertest.iterator();
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(FastList.newListWith("d"), undertest);
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(FastList.newList(), undertest);
    }

    @Test(expected = IllegalStateException.class)
    public void removingFromIteratorIsUncoolFromEmptyIterator() {
        new CompositeFastList<String>().iterator().remove();
    }

    @Test
    @Override
    public void reverseForEachWithIndex() {
        super.reverseForEachWithIndex();
        MutableList<Integer> integers1 = Interval.oneTo(4).toList();
        MutableList<Integer> integers2 = Interval.fromTo(5, 8).toList();
        MutableList<Integer> integers3 = Interval.fromTo(9, 11).toList();
        CompositeFastList<Integer> compositeFastList = new CompositeFastList<>();
        compositeFastList.addAll(integers1);
        compositeFastList.addAll(integers2);
        compositeFastList.addAll(integers3);
        List<Integer> result = Lists.mutable.empty();
        compositeFastList.reverseForEachWithIndex((each, index) -> result.add(each + index));
        Assert.assertEquals(Lists.mutable.with(21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public CompositeFastListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
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
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
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
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
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
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
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
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
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
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
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
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_randomAccess_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.randomAccess_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirstOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLastOptional);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newListWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newListWithSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_forEachFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromToInReverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
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
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMethods);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_small);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_large);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_small() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_small);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis_with_comparator_large() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis_with_comparator_large);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisByInt);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromToInReverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromToInReverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexOnRange() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexOnRange);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListToGreaterThanSizeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListToGreaterThanSizeException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromGreaterThanToException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromGreaterThanToException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithIndexOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getWithArrayIndexOutOfBoundsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getWithArrayIndexOutOfBoundsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooSmall() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooSmall);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIteratorIndexTooBig() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIteratorIndexTooBig);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearchWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearchWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnDifferentListSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnDifferentListSizes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBothThrowsOnNullList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBothThrowsOnNullList);
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
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testDefaultConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testDefaultConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelBatchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelBatchForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAddWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAddWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set_bugFix_off_by_one_error() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set_bugFix_off_by_one_error);
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
        public void benchmark_testRemoveWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testRemoveWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEmptyIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEmptyIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContainsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notRandomAccess() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notRandomAccess);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removingFromIteratorIsCool() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removingFromIteratorIsCool);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removingFromIteratorIsUncoolFromEmptyIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removingFromIteratorIsUncoolFromEmptyIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> payload) throws java.lang.Throwable {
            this.instance = new CompositeFastListTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> randomAccess_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getFirstOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getLastOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> newListWithSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> reverseForEach_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> reverseForEachWithIndex_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removeIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> withMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThis_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThis_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThis_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThis_with_comparator_small;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThis_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThis_with_comparator_large;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachWithIndexWithFromToInReverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedListWithNullWithNoComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachWithIndexOnRange;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> subListFromOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> subListToGreaterThanSizeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> subListFromGreaterThanToException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getWithIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> getWithArrayIndexOutOfBoundsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> listIteratorIndexTooSmall;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> listIteratorIndexTooBig;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> binarySearchWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachInBothThrowsOnDifferentListSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachInBothThrowsOnNullList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testDefaultConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> parallelBatchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testGet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testAddWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> set_bugFix_off_by_one_error;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testRemoveWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testEmptyIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testContainsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> notRandomAccess;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removingFromIteratorIsCool;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> removingFromIteratorIsUncoolFromEmptyIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CompositeFastListTest> reverseForEachWithIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = CompositeFastListTest::testNewCollection;
            this.payloads.contains = CompositeFastListTest::contains;
            this.payloads.containsBy = CompositeFastListTest::containsBy;
            this.payloads.containsAllIterable = CompositeFastListTest::containsAllIterable;
            this.payloads.containsAnyIterable = CompositeFastListTest::containsAnyIterable;
            this.payloads.containsNoneIterable = CompositeFastListTest::containsNoneIterable;
            this.payloads.containsAllArray = CompositeFastListTest::containsAllArray;
            this.payloads.containsAnyCollection = CompositeFastListTest::containsAnyCollection;
            this.payloads.containsNoneCollection = CompositeFastListTest::containsNoneCollection;
            this.payloads.containsAllCollection = CompositeFastListTest::containsAllCollection;
            this.payloads.tap = CompositeFastListTest::tap;
            this.payloads.select = CompositeFastListTest::select;
            this.payloads.selectWith = CompositeFastListTest::selectWith;
            this.payloads.selectWith_target = CompositeFastListTest::selectWith_target;
            this.payloads.reject = CompositeFastListTest::reject;
            this.payloads.rejectWith = CompositeFastListTest::rejectWith;
            this.payloads.rejectWith_target = CompositeFastListTest::rejectWith_target;
            this.payloads.selectInstancesOf = CompositeFastListTest::selectInstancesOf;
            this.payloads.collect = CompositeFastListTest::collect;
            this.payloads.collectTarget = CompositeFastListTest::collectTarget;
            this.payloads.collectBoolean = CompositeFastListTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = CompositeFastListTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = CompositeFastListTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = CompositeFastListTest::collectByte;
            this.payloads.collectByteWithTarget = CompositeFastListTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = CompositeFastListTest::collectByteWithBagTarget;
            this.payloads.collectChar = CompositeFastListTest::collectChar;
            this.payloads.collectCharWithTarget = CompositeFastListTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = CompositeFastListTest::collectCharWithBagTarget;
            this.payloads.collectDouble = CompositeFastListTest::collectDouble;
            this.payloads.collectDoubleWithTarget = CompositeFastListTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = CompositeFastListTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = CompositeFastListTest::collectFloat;
            this.payloads.collectFloatWithTarget = CompositeFastListTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = CompositeFastListTest::collectFloatWithBagTarget;
            this.payloads.collectInt = CompositeFastListTest::collectInt;
            this.payloads.collectIntWithTarget = CompositeFastListTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = CompositeFastListTest::collectIntWithBagTarget;
            this.payloads.collectLong = CompositeFastListTest::collectLong;
            this.payloads.collectLongWithTarget = CompositeFastListTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = CompositeFastListTest::collectLongWithBagTarget;
            this.payloads.collectShort = CompositeFastListTest::collectShort;
            this.payloads.collectShortWithTarget = CompositeFastListTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = CompositeFastListTest::collectShortWithBagTarget;
            this.payloads.flatCollect = CompositeFastListTest::flatCollect;
            this.payloads.flatCollectWith = CompositeFastListTest::flatCollectWith;
            this.payloads.flatCollectBoolean = CompositeFastListTest::flatCollectBoolean;
            this.payloads.flatCollectByte = CompositeFastListTest::flatCollectByte;
            this.payloads.flatCollectShort = CompositeFastListTest::flatCollectShort;
            this.payloads.flatCollectInt = CompositeFastListTest::flatCollectInt;
            this.payloads.flatCollectChar = CompositeFastListTest::flatCollectChar;
            this.payloads.flatCollectLong = CompositeFastListTest::flatCollectLong;
            this.payloads.flatCollectDouble = CompositeFastListTest::flatCollectDouble;
            this.payloads.flatCollectFloat = CompositeFastListTest::flatCollectFloat;
            this.payloads.detect = CompositeFastListTest::detect;
            this.payloads.detectOptional = CompositeFastListTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = CompositeFastListTest::min;
            this.payloads.minOptional = CompositeFastListTest::minOptional;
            this.payloads.max = CompositeFastListTest::max;
            this.payloads.maxOptional = CompositeFastListTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = CompositeFastListTest::min_without_comparator;
            this.payloads.max_without_comparator = CompositeFastListTest::max_without_comparator;
            this.payloads.min_null_safe = CompositeFastListTest::min_null_safe;
            this.payloads.max_null_safe = CompositeFastListTest::max_null_safe;
            this.payloads.minBy = CompositeFastListTest::minBy;
            this.payloads.minByOptional = CompositeFastListTest::minByOptional;
            this.payloads.maxBy = CompositeFastListTest::maxBy;
            this.payloads.maxByOptional = CompositeFastListTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = CompositeFastListTest::detectWith;
            this.payloads.detectWithOptional = CompositeFastListTest::detectWithOptional;
            this.payloads.detectIfNone = CompositeFastListTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = CompositeFastListTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = CompositeFastListTest::allSatisfy;
            this.payloads.allSatisfyWith = CompositeFastListTest::allSatisfyWith;
            this.payloads.noneSatisfy = CompositeFastListTest::noneSatisfy;
            this.payloads.noneSatisfyWith = CompositeFastListTest::noneSatisfyWith;
            this.payloads.anySatisfy = CompositeFastListTest::anySatisfy;
            this.payloads.anySatisfyWith = CompositeFastListTest::anySatisfyWith;
            this.payloads.count = CompositeFastListTest::count;
            this.payloads.countWith = CompositeFastListTest::countWith;
            this.payloads.collectIf = CompositeFastListTest::collectIf;
            this.payloads.collectWith = CompositeFastListTest::collectWith;
            this.payloads.collectWith_target = CompositeFastListTest::collectWith_target;
            this.payloads.getAny = CompositeFastListTest::getAny;
            this.payloads.getFirst = CompositeFastListTest::getFirst;
            this.payloads.getLast = CompositeFastListTest::getLast;
            this.payloads.getOnly = CompositeFastListTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = CompositeFastListTest::isEmpty;
            this.payloads.iterator = CompositeFastListTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = CompositeFastListTest::injectInto;
            this.payloads.injectIntoInt = CompositeFastListTest::injectIntoInt;
            this.payloads.injectIntoLong = CompositeFastListTest::injectIntoLong;
            this.payloads.injectIntoDouble = CompositeFastListTest::injectIntoDouble;
            this.payloads.injectIntoFloat = CompositeFastListTest::injectIntoFloat;
            this.payloads.sumFloat = CompositeFastListTest::sumFloat;
            this.payloads.summarizeFloat = CompositeFastListTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = CompositeFastListTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = CompositeFastListTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = CompositeFastListTest::sumDouble;
            this.payloads.summarizeDouble = CompositeFastListTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = CompositeFastListTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = CompositeFastListTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = CompositeFastListTest::sumInteger;
            this.payloads.summarizeInt = CompositeFastListTest::summarizeInt;
            this.payloads.sumLong = CompositeFastListTest::sumLong;
            this.payloads.summarizeLong = CompositeFastListTest::summarizeLong;
            this.payloads.sumByInt = CompositeFastListTest::sumByInt;
            this.payloads.sumByFloat = CompositeFastListTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = CompositeFastListTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = CompositeFastListTest::sumByLong;
            this.payloads.sumByDouble = CompositeFastListTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = CompositeFastListTest::sumByDoubleConsistentRounding;
            this.payloads.partition = CompositeFastListTest::partition;
            this.payloads.partitionWith = CompositeFastListTest::partitionWith;
            this.payloads.toList = CompositeFastListTest::toList;
            this.payloads.toImmutableList = CompositeFastListTest::toImmutableList;
            this.payloads.toCollection = CompositeFastListTest::toCollection;
            this.payloads.toBag = CompositeFastListTest::toBag;
            this.payloads.toImmutableBag = CompositeFastListTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = CompositeFastListTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = CompositeFastListTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = CompositeFastListTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = CompositeFastListTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = CompositeFastListTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = CompositeFastListTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = CompositeFastListTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = CompositeFastListTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = CompositeFastListTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = CompositeFastListTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = CompositeFastListTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = CompositeFastListTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = CompositeFastListTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = CompositeFastListTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = CompositeFastListTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = CompositeFastListTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = CompositeFastListTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = CompositeFastListTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = CompositeFastListTest::toSet;
            this.payloads.toImmutableSet = CompositeFastListTest::toImmutableSet;
            this.payloads.toMap = CompositeFastListTest::toMap;
            this.payloads.toImmutableMap = CompositeFastListTest::toImmutableMap;
            this.payloads.toMapTarget = CompositeFastListTest::toMapTarget;
            this.payloads.toSortedMap = CompositeFastListTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = CompositeFastListTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = CompositeFastListTest::toSortedMapBy;
            this.payloads.toBiMap = CompositeFastListTest::toBiMap;
            this.payloads.toImmutableBiMap = CompositeFastListTest::toImmutableBiMap;
            this.payloads.fusedCollectMakeString = CompositeFastListTest::fusedCollectMakeString;
            this.payloads.appendStringThrows = CompositeFastListTest::appendStringThrows;
            this.payloads.countBy = CompositeFastListTest::countBy;
            this.payloads.countByWith = CompositeFastListTest::countByWith;
            this.payloads.countByEach = CompositeFastListTest::countByEach;
            this.payloads.groupBy = CompositeFastListTest::groupBy;
            this.payloads.groupByEach = CompositeFastListTest::groupByEach;
            this.payloads.groupByUniqueKey = CompositeFastListTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = CompositeFastListTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = CompositeFastListTest::zip;
            this.payloads.zipWithIndex = CompositeFastListTest::zipWithIndex;
            this.payloads.chunk_empty = CompositeFastListTest::chunk_empty;
            this.payloads.chunk_single = CompositeFastListTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = CompositeFastListTest::chunk_large_size;
            this.payloads.empty = CompositeFastListTest::empty;
            this.payloads.notEmpty = CompositeFastListTest::notEmpty;
            this.payloads.aggregateByMutating = CompositeFastListTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = CompositeFastListTest::aggregateByNonMutating;
            this.payloads.reduceOptional = CompositeFastListTest::reduceOptional;
            this.payloads.testNewWith = CompositeFastListTest::testNewWith;
            this.payloads.testNewWithWith = CompositeFastListTest::testNewWithWith;
            this.payloads.testNewWithWithWith = CompositeFastListTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = CompositeFastListTest::testNewWithVarArgs;
            this.payloads.addAll = CompositeFastListTest::addAll;
            this.payloads.addAllIterable = CompositeFastListTest::addAllIterable;
            this.payloads.removeAll = CompositeFastListTest::removeAll;
            this.payloads.removeAllIterable = CompositeFastListTest::removeAllIterable;
            this.payloads.retainAllIterable = CompositeFastListTest::retainAllIterable;
            this.payloads.injectIntoWith = CompositeFastListTest::injectIntoWith;
            this.payloads.removeObject = CompositeFastListTest::removeObject;
            this.payloads.selectAndRejectWith = CompositeFastListTest::selectAndRejectWith;
            this.payloads.removeIfWith = CompositeFastListTest::removeIfWith;
            this.payloads.with = CompositeFastListTest::with;
            this.payloads.withAll = CompositeFastListTest::withAll;
            this.payloads.without = CompositeFastListTest::without;
            this.payloads.withoutAll = CompositeFastListTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = CompositeFastListTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = CompositeFastListTest::asLazy;
            this.payloads.randomAccess_throws = CompositeFastListTest::randomAccess_throws;
            this.payloads.getFirstOptional = CompositeFastListTest::getFirstOptional;
            this.payloads.getLastOptional = CompositeFastListTest::getLastOptional;
            this.payloads.detectIndex = CompositeFastListTest::detectIndex;
            this.payloads.detectLastIndex = CompositeFastListTest::detectLastIndex;
            this.payloads.collectWithIndex = CompositeFastListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = CompositeFastListTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = CompositeFastListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = CompositeFastListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = CompositeFastListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = CompositeFastListTest::rejectWithIndexWithTarget;
            this.payloads.asSynchronized = CompositeFastListTest::asSynchronized;
            this.payloads.toImmutable = CompositeFastListTest::toImmutable;
            this.payloads.asUnmodifiable = CompositeFastListTest::asUnmodifiable;
            this.payloads.equalsAndHashCode = CompositeFastListTest::equalsAndHashCode;
            this.payloads.newListWithSize = CompositeFastListTest::newListWithSize;
            this.payloads.serialization = CompositeFastListTest::serialization;
            this.payloads.corresponds = CompositeFastListTest::corresponds;
            this.payloads.forEachFromTo = CompositeFastListTest::forEachFromTo;
            this.payloads.forEachFromToInReverse = CompositeFastListTest::forEachFromToInReverse;
            this.payloads.reverseForEach = CompositeFastListTest::reverseForEach;
            this.payloads.reverseForEach_emptyList = CompositeFastListTest::reverseForEach_emptyList;
            this.payloads.reverseForEachWithIndex_emptyList = CompositeFastListTest::reverseForEachWithIndex_emptyList;
            this.payloads.toReversed = CompositeFastListTest::toReversed;
            this.payloads.distinct = CompositeFastListTest::distinct;
            this.payloads.distinctWithHashingStrategy = CompositeFastListTest::distinctWithHashingStrategy;
            this.payloads.distinctBy = CompositeFastListTest::distinctBy;
            this.payloads.removeIf = CompositeFastListTest::removeIf;
            this.payloads.removeIndex = CompositeFastListTest::removeIndex;
            this.payloads.addAtIndex = CompositeFastListTest::addAtIndex;
            this.payloads.withMethods = CompositeFastListTest::withMethods;
            this.payloads.sortThis_with_null = CompositeFastListTest::sortThis_with_null;
            this.payloads.sortThis_small = CompositeFastListTest::sortThis_small;
            this.payloads.sortThis = CompositeFastListTest::sortThis;
            this.payloads.sortThis_large = CompositeFastListTest::sortThis_large;
            this.payloads.sortThis_with_comparator_small = CompositeFastListTest::sortThis_with_comparator_small;
            this.payloads.sortThis_with_comparator = CompositeFastListTest::sortThis_with_comparator;
            this.payloads.sortThis_with_comparator_large = CompositeFastListTest::sortThis_with_comparator_large;
            this.payloads.sortThisBy = CompositeFastListTest::sortThisBy;
            this.payloads.sortThisByBoolean = CompositeFastListTest::sortThisByBoolean;
            this.payloads.sortThisByInt = CompositeFastListTest::sortThisByInt;
            this.payloads.sortThisByChar = CompositeFastListTest::sortThisByChar;
            this.payloads.sortThisByByte = CompositeFastListTest::sortThisByByte;
            this.payloads.sortThisByShort = CompositeFastListTest::sortThisByShort;
            this.payloads.sortThisByFloat = CompositeFastListTest::sortThisByFloat;
            this.payloads.sortThisByLong = CompositeFastListTest::sortThisByLong;
            this.payloads.sortThisByDouble = CompositeFastListTest::sortThisByDouble;
            this.payloads.newEmpty = CompositeFastListTest::newEmpty;
            this.payloads.testToString = CompositeFastListTest::testToString;
            this.payloads.makeString = CompositeFastListTest::makeString;
            this.payloads.makeStringWithSeparator = CompositeFastListTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = CompositeFastListTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = CompositeFastListTest::appendString;
            this.payloads.appendStringWithSeparator = CompositeFastListTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = CompositeFastListTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.forEachWithIndexWithFromTo = CompositeFastListTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithIndexWithFromToInReverse = CompositeFastListTest::forEachWithIndexWithFromToInReverse;
            this.payloads.sortThisWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::sortThisWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::toSortedListWithNullWithNoComparator, java.lang.NullPointerException.class);
            this.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements, java.lang.NullPointerException.class);
            this.payloads.forEachOnRange = CompositeFastListTest::forEachOnRange;
            this.payloads.forEachWithIndexOnRange = CompositeFastListTest::forEachWithIndexOnRange;
            this.payloads.subListFromOutOfBoundsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::subListFromOutOfBoundsException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListToGreaterThanSizeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::subListToGreaterThanSizeException, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subListFromGreaterThanToException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::subListFromGreaterThanToException, java.lang.IllegalArgumentException.class);
            this.payloads.getWithIndexOutOfBoundsException = CompositeFastListTest::getWithIndexOutOfBoundsException;
            this.payloads.getWithArrayIndexOutOfBoundsException = CompositeFastListTest::getWithArrayIndexOutOfBoundsException;
            this.payloads.listIteratorIndexTooSmall = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::listIteratorIndexTooSmall, java.lang.IndexOutOfBoundsException.class);
            this.payloads.listIteratorIndexTooBig = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::listIteratorIndexTooBig, java.lang.IndexOutOfBoundsException.class);
            this.payloads.chunk = CompositeFastListTest::chunk;
            this.payloads.toStack = CompositeFastListTest::toStack;
            this.payloads.take = CompositeFastListTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = CompositeFastListTest::takeWhile;
            this.payloads.drop = CompositeFastListTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.dropWhile = CompositeFastListTest::dropWhile;
            this.payloads.partitionWhile = CompositeFastListTest::partitionWhile;
            this.payloads.asReversed = CompositeFastListTest::asReversed;
            this.payloads.binarySearch = CompositeFastListTest::binarySearch;
            this.payloads.binarySearchWithComparator = CompositeFastListTest::binarySearchWithComparator;
            this.payloads.forEachInBoth = CompositeFastListTest::forEachInBoth;
            this.payloads.forEachInBothThrowsOnDifferentListSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::forEachInBothThrowsOnDifferentListSizes, java.lang.IllegalArgumentException.class);
            this.payloads.forEachInBothThrowsOnNullList = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::forEachInBothThrowsOnNullList, java.lang.NullPointerException.class);
            this.payloads.replaceAll = CompositeFastListTest::replaceAll;
            this.payloads.sort = CompositeFastListTest::sort;
            this.payloads.testClone = CompositeFastListTest::testClone;
            this.payloads.size = CompositeFastListTest::size;
            this.payloads.testDefaultConstructor = CompositeFastListTest::testDefaultConstructor;
            this.payloads.parallelBatchForEach = CompositeFastListTest::parallelBatchForEach;
            this.payloads.testGet = CompositeFastListTest::testGet;
            this.payloads.testAddWithIndex = CompositeFastListTest::testAddWithIndex;
            this.payloads.reverseThis = CompositeFastListTest::reverseThis;
            this.payloads.addAllAtIndex = CompositeFastListTest::addAllAtIndex;
            this.payloads.set = CompositeFastListTest::set;
            this.payloads.set_bugFix_off_by_one_error = CompositeFastListTest::set_bugFix_off_by_one_error;
            this.payloads.indexOf = CompositeFastListTest::indexOf;
            this.payloads.lastIndexOf = CompositeFastListTest::lastIndexOf;
            this.payloads.testRemoveWithIndex = CompositeFastListTest::testRemoveWithIndex;
            this.payloads.toArray = CompositeFastListTest::toArray;
            this.payloads.testEmptyIterator = CompositeFastListTest::testEmptyIterator;
            this.payloads.clear = CompositeFastListTest::clear;
            this.payloads.testContainsAll = CompositeFastListTest::testContainsAll;
            this.payloads.retainAll = CompositeFastListTest::retainAll;
            this.payloads.forEach = CompositeFastListTest::forEach;
            this.payloads.forEachWithIndex = CompositeFastListTest::forEachWithIndex;
            this.payloads.forEachWith = CompositeFastListTest::forEachWith;
            this.payloads.testEquals = CompositeFastListTest::testEquals;
            this.payloads.testHashCode = CompositeFastListTest::testHashCode;
            this.payloads.listIterator = CompositeFastListTest::listIterator;
            this.payloads.subList = CompositeFastListTest::subList;
            this.payloads.notRandomAccess = CompositeFastListTest::notRandomAccess;
            this.payloads.removingFromIteratorIsCool = CompositeFastListTest::removingFromIteratorIsCool;
            this.payloads.removingFromIteratorIsUncoolFromEmptyIterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(CompositeFastListTest::removingFromIteratorIsUncoolFromEmptyIterator, java.lang.IllegalStateException.class);
            this.payloads.reverseForEachWithIndex = CompositeFastListTest::reverseForEachWithIndex;
        }
    }
}
