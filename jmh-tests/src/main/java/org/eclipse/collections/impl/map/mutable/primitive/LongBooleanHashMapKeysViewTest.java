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
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class LongBooleanHashMapKeysViewTest {

    private final LazyLongIterable iterable = LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false, 31L, true, generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static LongArrayList generateCollisions1() {
        LongArrayList collisions = new LongArrayList();
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        for (long i = 32L; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(32L)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size() {
        Verify.assertSize(0, new LongBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(new LongBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new LongBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false).keysView().isEmpty());
        Assert.assertTrue(LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false).keysView().notEmpty());
        Assert.assertFalse(LongBooleanHashMap.newWithKeysValues(31L, true, 32L, true).keysView().isEmpty());
        Assert.assertTrue(LongBooleanHashMap.newWithKeysValues(31L, true, 32L, true).keysView().notEmpty());
        Assert.assertFalse(LongBooleanHashMap.newWithKeysValues(32L, true, 33L, true).keysView().isEmpty());
        Assert.assertTrue(LongBooleanHashMap.newWithKeysValues(32L, true, 33L, true).keysView().notEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(0L));
        Assert.assertTrue(this.iterable.contains(1L));
        Assert.assertFalse(this.iterable.contains(2L));
        Assert.assertTrue(this.iterable.contains(31L));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(0L, 1L));
        Assert.assertFalse(this.iterable.containsAll(1L, 5L));
        Assert.assertFalse(this.iterable.containsAll(2L, 5L));
        Assert.assertFalse(this.iterable.containsAll(31L, 2L));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(LongHashSet.newSetWith(0L, 1L)));
        Assert.assertFalse(this.iterable.containsAll(LongHashSet.newSetWith(1L, 5L)));
        Assert.assertFalse(this.iterable.containsAll(LongHashSet.newSetWith(2L, 5L)));
        Assert.assertFalse(this.iterable.containsAll(LongHashSet.newSetWith(31L, 2L)));
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new long[] { 0L, 1L }, LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false).keysView().toArray()) || Arrays.equals(new long[] { 0L, 1L }, LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false).keysView().toArray()));
        Assert.assertArrayEquals(new long[] {}, new LongBooleanHashMap().keysView().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new long[] { 0L, 1L, 31L, generateCollisions1().getFirst(), generateCollisions1().get(1) }, this.iterable.toSortedArray());
        Assert.assertArrayEquals(new long[] {}, new LongBooleanHashMap().keysView().toSortedArray());
    }

    @Test
    public void longIterator() {
        MutableLongSet expected = LongHashSet.newSetWith(0L, 1L, 31L, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableLongSet actual = LongHashSet.newSetWith();
        LongIterator iterator = this.iterable.longIterator();
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
        LongIterator iterator = this.iterable.longIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0]);
    }

    @Test
    public void count() {
        Assert.assertEquals(4L, this.iterable.count(LongPredicates.greaterThan(0L)));
        Assert.assertEquals(3L, this.iterable.count(LongPredicates.lessThan(32L)));
        Assert.assertEquals(1L, this.iterable.count(LongPredicates.greaterThan(32L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.iterable.anySatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertTrue(this.iterable.anySatisfy(LongPredicates.greaterThan(31L)));
        Assert.assertFalse(this.iterable.anySatisfy(LongPredicates.equal(2L)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(LongPredicates.not(LongPredicates.equal(2L))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.iterable.noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.iterable.noneSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.iterable.noneSatisfy(LongPredicates.greaterThan(31L)));
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.equal(2L)));
    }

    @Test
    public void select() {
        Verify.assertSize(3, this.iterable.select(LongPredicates.lessThan(32L)));
        Verify.assertSize(4, this.iterable.select(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(LongPredicates.greaterThan(0L)));
        Verify.assertSize(2, this.iterable.reject(LongPredicates.lessThan(32L)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(0L, this.iterable.detectIfNone(LongPredicates.lessThan(1L), 9L));
        Assert.assertEquals(1L, this.iterable.detectIfNone(LongPredicates.equal(1L), 9L));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(LongPredicates.greaterThan(generateCollisions1().getFirst()), 9L));
        Assert.assertEquals(9L, this.iterable.detectIfNone(LongPredicates.greaterThan(generateCollisions1().get(1)), 9L));
    }

    @Test
    public void collect() {
        Assert.assertEquals(UnifiedSet.newSetWith(-1L, 0L, 30L, generateCollisions1().getFirst() - 1, generateCollisions1().get(1) - 1), this.iterable.collect((long parameter) -> parameter - 1).toSet());
    }

    @Test
    public void max() {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new LongBooleanHashMap().keysView().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0L, this.iterable.min());
        Assert.assertEquals(31L, LongBooleanHashMap.newWithKeysValues(31L, true, 32L, false).keysView().min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, new LongBooleanHashMap().keysView().minIfEmpty(5L));
        Assert.assertEquals(0L, new LongBooleanHashMap().keysView().minIfEmpty(0L));
        Assert.assertEquals(0L, this.iterable.minIfEmpty(5L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, new LongBooleanHashMap().keysView().maxIfEmpty(5L));
        Assert.assertEquals(0L, new LongBooleanHashMap().keysView().maxIfEmpty(0L));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty(5L));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new LongBooleanHashMap().keysView().min();
    }

    @Test
    public void sum() {
        Assert.assertEquals(94L, LongBooleanHashMap.newWithKeysValues(30L, true, 31L, false, 32L, true).withKeysValues(0L, true, 1L, false).keysView().sum());
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList() {
        new LongBooleanHashMap().keysView().average();
    }

    @Test
    public void average() {
        Assert.assertEquals(31.0, LongBooleanHashMap.newWithKeysValues(30L, true, 31L, false, 32L, true).keysView().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(31.0, LongBooleanHashMap.newWithKeysValues(30L, true, 31L, false, 32L, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, LongBooleanHashMap.newWithKeysValues(30L, true, 31L, false, 32L, true).withKeyValue(1L, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList() {
        new LongBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", new LongBooleanHashMap().keysView().toString());
        Assert.assertEquals("[0]", LongBooleanHashMap.newWithKeysValues(0L, true).keysView().toString());
        Assert.assertEquals("[1]", LongBooleanHashMap.newWithKeysValues(1L, false).keysView().toString());
        Assert.assertEquals("[5]", LongBooleanHashMap.newWithKeysValues(5L, false).keysView().toString());
        LazyLongIterable iterable1 = LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false).keysView();
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 1]") || iterable1.toString().equals("[1, 0]"));
        LazyLongIterable iterable2 = LongBooleanHashMap.newWithKeysValues(1L, false, 32L, true).keysView();
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[1, 32]") || iterable2.toString().equals("[32, 1]"));
        LazyLongIterable iterable3 = LongBooleanHashMap.newWithKeysValues(0L, true, 32L, true).keysView();
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[0, 32]") || iterable3.toString().equals("[32, 0]"));
        LazyLongIterable iterable4 = LongBooleanHashMap.newWithKeysValues(32L, true, 33L, false).keysView();
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[32, 33]") || iterable4.toString().equals("[33, 32]"));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", new LongBooleanHashMap().keysView().makeString());
        Assert.assertEquals("31", new LongBooleanHashMap().withKeyValue(31L, true).keysView().makeString());
        Assert.assertEquals("32", new LongBooleanHashMap().withKeyValue(32L, false).keysView().makeString());
        LazyLongIterable iterable0 = LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false).keysView();
        Assert.assertTrue(iterable0.makeString(), "0, 1".equals(iterable0.makeString()) || "1, 0".equals(iterable0.makeString()));
        LazyLongIterable iterable1 = LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false).keysView();
        Assert.assertTrue(iterable1.makeString(), "0, 31".equals(iterable1.makeString()) || "31, 0".equals(iterable1.makeString()));
        LazyLongIterable iterable2 = LongBooleanHashMap.newWithKeysValues(31L, true, 32L, true).keysView();
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), "[31/32]".equals(iterable2.makeString("[", "/", "]")) || "[32/31]".equals(iterable2.makeString("[", "/", "]")));
        LazyLongIterable iterable3 = LongBooleanHashMap.newWithKeysValues(32L, true, 33L, true).keysView();
        Assert.assertTrue(iterable3.makeString("/"), "32/33".equals(iterable3.makeString("/")) || "33/32".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        new LongBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable0 = new StringBuilder();
        new LongBooleanHashMap().withKeyValue(31L, true).keysView().appendString(appendable0);
        Assert.assertEquals("31", appendable0.toString());
        StringBuilder appendable1 = new StringBuilder();
        new LongBooleanHashMap().withKeyValue(32L, true).keysView().appendString(appendable1);
        Assert.assertEquals("32", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        LazyLongIterable set1 = LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "0, 31".equals(appendable2.toString()) || "31, 0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        LazyLongIterable set2 = LongBooleanHashMap.newWithKeysValues(31L, true, 32L, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "31/32".equals(appendable3.toString()) || "32/31".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        LazyLongIterable set4 = LongBooleanHashMap.newWithKeysValues(32L, true, 33L, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[32/33]".equals(appendable4.toString()) || "[33/32]".equals(appendable4.toString()));
    }

    @Test
    public void toList() {
        Assert.assertEquals(LongArrayList.newListWith(0L), LongBooleanHashMap.newWithKeysValues(0L, true).keysView().toList());
        Assert.assertEquals(LongArrayList.newListWith(31L), LongBooleanHashMap.newWithKeysValues(31L, true).keysView().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 31L), LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false, 31L, true).keysView().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L), LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false, 31L, true).keysView().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L), LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false, 31L, true).keysView().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, this.iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongBooleanHashMapKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new LongBooleanHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> average_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> median_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.size = LongBooleanHashMapKeysViewTest::size;
            this.payloads.empty = LongBooleanHashMapKeysViewTest::empty;
            this.payloads.contains = LongBooleanHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = LongBooleanHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = LongBooleanHashMapKeysViewTest::containsAllIterable;
            this.payloads.toArray = LongBooleanHashMapKeysViewTest::toArray;
            this.payloads.toSortedArray = LongBooleanHashMapKeysViewTest::toSortedArray;
            this.payloads.longIterator = LongBooleanHashMapKeysViewTest::longIterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongBooleanHashMapKeysViewTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LongBooleanHashMapKeysViewTest::forEach;
            this.payloads.count = LongBooleanHashMapKeysViewTest::count;
            this.payloads.anySatisfy = LongBooleanHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = LongBooleanHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = LongBooleanHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = LongBooleanHashMapKeysViewTest::select;
            this.payloads.reject = LongBooleanHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = LongBooleanHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = LongBooleanHashMapKeysViewTest::collect;
            this.payloads.max = LongBooleanHashMapKeysViewTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongBooleanHashMapKeysViewTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = LongBooleanHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = LongBooleanHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongBooleanHashMapKeysViewTest::maxIfEmpty;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongBooleanHashMapKeysViewTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.sum = LongBooleanHashMapKeysViewTest::sum;
            this.payloads.average_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongBooleanHashMapKeysViewTest::average_throws_emptyList, java.lang.ArithmeticException.class);
            this.payloads.average = LongBooleanHashMapKeysViewTest::average;
            this.payloads.median = LongBooleanHashMapKeysViewTest::median;
            this.payloads.median_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongBooleanHashMapKeysViewTest::median_throws_emptyList, java.lang.ArithmeticException.class);
            this.payloads.testToString = LongBooleanHashMapKeysViewTest::testToString;
            this.payloads.makeString = LongBooleanHashMapKeysViewTest::makeString;
            this.payloads.appendString = LongBooleanHashMapKeysViewTest::appendString;
            this.payloads.toList = LongBooleanHashMapKeysViewTest::toList;
            this.payloads.toSortedList = LongBooleanHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = LongBooleanHashMapKeysViewTest::toSet;
            this.payloads.toBag = LongBooleanHashMapKeysViewTest::toBag;
            this.payloads.asLazy = LongBooleanHashMapKeysViewTest::asLazy;
        }
    }
}
