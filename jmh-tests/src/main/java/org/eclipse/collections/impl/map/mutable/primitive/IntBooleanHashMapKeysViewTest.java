/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class IntBooleanHashMapKeysViewTest {

    private final LazyIntIterable iterable = IntBooleanHashMap.newWithKeysValues(0, true, 1, false, 31, true, generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static IntArrayList generateCollisions1() {
        IntArrayList collisions = new IntArrayList();
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        for (int i = 32; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size() {
        Verify.assertSize(0, new IntBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(new IntBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new IntBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(IntBooleanHashMap.newWithKeysValues(0, true, 31, false).keysView().isEmpty());
        Assert.assertTrue(IntBooleanHashMap.newWithKeysValues(0, true, 31, false).keysView().notEmpty());
        Assert.assertFalse(IntBooleanHashMap.newWithKeysValues(31, true, 32, true).keysView().isEmpty());
        Assert.assertTrue(IntBooleanHashMap.newWithKeysValues(31, true, 32, true).keysView().notEmpty());
        Assert.assertFalse(IntBooleanHashMap.newWithKeysValues(32, true, 33, true).keysView().isEmpty());
        Assert.assertTrue(IntBooleanHashMap.newWithKeysValues(32, true, 33, true).keysView().notEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(0));
        Assert.assertTrue(this.iterable.contains(1));
        Assert.assertFalse(this.iterable.contains(2));
        Assert.assertTrue(this.iterable.contains(31));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(0, 1));
        Assert.assertFalse(this.iterable.containsAll(1, 5));
        Assert.assertFalse(this.iterable.containsAll(2, 5));
        Assert.assertFalse(this.iterable.containsAll(31, 2));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(IntHashSet.newSetWith(0, 1)));
        Assert.assertFalse(this.iterable.containsAll(IntHashSet.newSetWith(1, 5)));
        Assert.assertFalse(this.iterable.containsAll(IntHashSet.newSetWith(2, 5)));
        Assert.assertFalse(this.iterable.containsAll(IntHashSet.newSetWith(31, 2)));
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new int[] { 0, 1 }, IntBooleanHashMap.newWithKeysValues(0, true, 1, false).keysView().toArray()) || Arrays.equals(new int[] { 0, 1 }, IntBooleanHashMap.newWithKeysValues(0, true, 1, false).keysView().toArray()));
        Assert.assertArrayEquals(new int[] {}, new IntBooleanHashMap().keysView().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new int[] { 0, 1, 31, generateCollisions1().getFirst(), generateCollisions1().get(1) }, this.iterable.toSortedArray());
        Assert.assertArrayEquals(new int[] {}, new IntBooleanHashMap().keysView().toSortedArray());
    }

    @Test
    public void intIterator() {
        MutableIntSet expected = IntHashSet.newSetWith(0, 1, 31, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableIntSet actual = IntHashSet.newSetWith();
        IntIterator iterator = this.iterable.intIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        IntIterator iterator = this.iterable.intIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        int[] sum = new int[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0]);
    }

    @Test
    public void count() {
        Assert.assertEquals(4L, this.iterable.count(IntPredicates.greaterThan(0)));
        Assert.assertEquals(3L, this.iterable.count(IntPredicates.lessThan(32)));
        Assert.assertEquals(1L, this.iterable.count(IntPredicates.greaterThan(32)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.iterable.anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.iterable.anySatisfy(IntPredicates.greaterThan(31)));
        Assert.assertFalse(this.iterable.anySatisfy(IntPredicates.equal(2)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.iterable.allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.iterable.allSatisfy(IntPredicates.lessThan(1)));
        Assert.assertFalse(this.iterable.allSatisfy(IntPredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(IntPredicates.not(IntPredicates.equal(2))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.iterable.noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.iterable.noneSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.iterable.noneSatisfy(IntPredicates.greaterThan(31)));
        Assert.assertTrue(this.iterable.noneSatisfy(IntPredicates.equal(2)));
    }

    @Test
    public void select() {
        Verify.assertSize(3, this.iterable.select(IntPredicates.lessThan(32)));
        Verify.assertSize(4, this.iterable.select(IntPredicates.greaterThan(0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(IntPredicates.greaterThan(0)));
        Verify.assertSize(2, this.iterable.reject(IntPredicates.lessThan(32)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(0, this.iterable.detectIfNone(IntPredicates.lessThan(1), 9));
        Assert.assertEquals(1, this.iterable.detectIfNone(IntPredicates.equal(1), 9));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(IntPredicates.greaterThan(generateCollisions1().getFirst()), 9));
        Assert.assertEquals(9, this.iterable.detectIfNone(IntPredicates.greaterThan(generateCollisions1().get(1)), 9));
    }

    @Test
    public void collect() {
        Assert.assertEquals(UnifiedSet.newSetWith(-1, 0, 30, generateCollisions1().getFirst() - 1, generateCollisions1().get(1) - 1), this.iterable.collect((int parameter) -> parameter - 1).toSet());
    }

    @Test
    public void max() {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new IntBooleanHashMap().keysView().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0, this.iterable.min());
        Assert.assertEquals(31, IntBooleanHashMap.newWithKeysValues(31, true, 32, false).keysView().min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5, new IntBooleanHashMap().keysView().minIfEmpty(5));
        Assert.assertEquals(0, new IntBooleanHashMap().keysView().minIfEmpty(0));
        Assert.assertEquals(0, this.iterable.minIfEmpty(5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5, new IntBooleanHashMap().keysView().maxIfEmpty(5));
        Assert.assertEquals(0, new IntBooleanHashMap().keysView().maxIfEmpty(0));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new IntBooleanHashMap().keysView().min();
    }

    @Test
    public void sum() {
        Assert.assertEquals(94L, IntBooleanHashMap.newWithKeysValues(30, true, 31, false, 32, true).withKeysValues(0, true, 1, false).keysView().sum());
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList() {
        new IntBooleanHashMap().keysView().average();
    }

    @Test
    public void average() {
        Assert.assertEquals(31.0, IntBooleanHashMap.newWithKeysValues(30, true, 31, false, 32, true).keysView().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(31.0, IntBooleanHashMap.newWithKeysValues(30, true, 31, false, 32, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, IntBooleanHashMap.newWithKeysValues(30, true, 31, false, 32, true).withKeyValue(1, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList() {
        new IntBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", new IntBooleanHashMap().keysView().toString());
        Assert.assertEquals("[0]", IntBooleanHashMap.newWithKeysValues(0, true).keysView().toString());
        Assert.assertEquals("[1]", IntBooleanHashMap.newWithKeysValues(1, false).keysView().toString());
        Assert.assertEquals("[5]", IntBooleanHashMap.newWithKeysValues(5, false).keysView().toString());
        LazyIntIterable iterable1 = IntBooleanHashMap.newWithKeysValues(0, true, 1, false).keysView();
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 1]") || iterable1.toString().equals("[1, 0]"));
        LazyIntIterable iterable2 = IntBooleanHashMap.newWithKeysValues(1, false, 32, true).keysView();
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[1, 32]") || iterable2.toString().equals("[32, 1]"));
        LazyIntIterable iterable3 = IntBooleanHashMap.newWithKeysValues(0, true, 32, true).keysView();
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[0, 32]") || iterable3.toString().equals("[32, 0]"));
        LazyIntIterable iterable4 = IntBooleanHashMap.newWithKeysValues(32, true, 33, false).keysView();
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[32, 33]") || iterable4.toString().equals("[33, 32]"));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", new IntBooleanHashMap().keysView().makeString());
        Assert.assertEquals("31", new IntBooleanHashMap().withKeyValue(31, true).keysView().makeString());
        Assert.assertEquals("32", new IntBooleanHashMap().withKeyValue(32, false).keysView().makeString());
        LazyIntIterable iterable0 = IntBooleanHashMap.newWithKeysValues(0, true, 1, false).keysView();
        Assert.assertTrue(iterable0.makeString(), "0, 1".equals(iterable0.makeString()) || "1, 0".equals(iterable0.makeString()));
        LazyIntIterable iterable1 = IntBooleanHashMap.newWithKeysValues(0, true, 31, false).keysView();
        Assert.assertTrue(iterable1.makeString(), "0, 31".equals(iterable1.makeString()) || "31, 0".equals(iterable1.makeString()));
        LazyIntIterable iterable2 = IntBooleanHashMap.newWithKeysValues(31, true, 32, true).keysView();
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), "[31/32]".equals(iterable2.makeString("[", "/", "]")) || "[32/31]".equals(iterable2.makeString("[", "/", "]")));
        LazyIntIterable iterable3 = IntBooleanHashMap.newWithKeysValues(32, true, 33, true).keysView();
        Assert.assertTrue(iterable3.makeString("/"), "32/33".equals(iterable3.makeString("/")) || "33/32".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        new IntBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable0 = new StringBuilder();
        new IntBooleanHashMap().withKeyValue(31, true).keysView().appendString(appendable0);
        Assert.assertEquals("31", appendable0.toString());
        StringBuilder appendable1 = new StringBuilder();
        new IntBooleanHashMap().withKeyValue(32, true).keysView().appendString(appendable1);
        Assert.assertEquals("32", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        LazyIntIterable set1 = IntBooleanHashMap.newWithKeysValues(0, true, 31, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "0, 31".equals(appendable2.toString()) || "31, 0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        LazyIntIterable set2 = IntBooleanHashMap.newWithKeysValues(31, true, 32, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "31/32".equals(appendable3.toString()) || "32/31".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        LazyIntIterable set4 = IntBooleanHashMap.newWithKeysValues(32, true, 33, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[32/33]".equals(appendable4.toString()) || "[33/32]".equals(appendable4.toString()));
    }

    @Test
    public void toList() {
        Assert.assertEquals(IntArrayList.newListWith(0), IntBooleanHashMap.newWithKeysValues(0, true).keysView().toList());
        Assert.assertEquals(IntArrayList.newListWith(31), IntBooleanHashMap.newWithKeysValues(31, true).keysView().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 31), IntBooleanHashMap.newWithKeysValues(0, true, 1, false, 31, true).keysView().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31), IntBooleanHashMap.newWithKeysValues(0, true, 1, false, 31, true).keysView().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31), IntBooleanHashMap.newWithKeysValues(0, true, 1, false, 31, true).keysView().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, this.iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntBooleanHashMapKeysViewTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median_throws_emptyList);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new IntBooleanHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> average_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> median_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.size = IntBooleanHashMapKeysViewTest::size;
            this.payloads.empty = IntBooleanHashMapKeysViewTest::empty;
            this.payloads.contains = IntBooleanHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = IntBooleanHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = IntBooleanHashMapKeysViewTest::containsAllIterable;
            this.payloads.toArray = IntBooleanHashMapKeysViewTest::toArray;
            this.payloads.toSortedArray = IntBooleanHashMapKeysViewTest::toSortedArray;
            this.payloads.intIterator = IntBooleanHashMapKeysViewTest::intIterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntBooleanHashMapKeysViewTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = IntBooleanHashMapKeysViewTest::forEach;
            this.payloads.count = IntBooleanHashMapKeysViewTest::count;
            this.payloads.anySatisfy = IntBooleanHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = IntBooleanHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = IntBooleanHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = IntBooleanHashMapKeysViewTest::select;
            this.payloads.reject = IntBooleanHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = IntBooleanHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = IntBooleanHashMapKeysViewTest::collect;
            this.payloads.max = IntBooleanHashMapKeysViewTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntBooleanHashMapKeysViewTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = IntBooleanHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = IntBooleanHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntBooleanHashMapKeysViewTest::maxIfEmpty;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntBooleanHashMapKeysViewTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.sum = IntBooleanHashMapKeysViewTest::sum;
            this.payloads.average_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntBooleanHashMapKeysViewTest::average_throws_emptyList, java.lang.ArithmeticException.class);
            this.payloads.average = IntBooleanHashMapKeysViewTest::average;
            this.payloads.median = IntBooleanHashMapKeysViewTest::median;
            this.payloads.median_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntBooleanHashMapKeysViewTest::median_throws_emptyList, java.lang.ArithmeticException.class);
            this.payloads.testToString = IntBooleanHashMapKeysViewTest::testToString;
            this.payloads.makeString = IntBooleanHashMapKeysViewTest::makeString;
            this.payloads.appendString = IntBooleanHashMapKeysViewTest::appendString;
            this.payloads.toList = IntBooleanHashMapKeysViewTest::toList;
            this.payloads.toSortedList = IntBooleanHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = IntBooleanHashMapKeysViewTest::toSet;
            this.payloads.toBag = IntBooleanHashMapKeysViewTest::toBag;
            this.payloads.asLazy = IntBooleanHashMapKeysViewTest::asLazy;
        }
    }
}
