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
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class DoubleBooleanHashMapKeysViewTest {

    private final LazyDoubleIterable iterable = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true, generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static DoubleArrayList generateCollisions1() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        for (double i = 32.0; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(32.0)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size() {
        Verify.assertSize(0, new DoubleBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(new DoubleBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new DoubleBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView().isEmpty());
        Assert.assertTrue(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView().notEmpty());
        Assert.assertFalse(DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView().isEmpty());
        Assert.assertTrue(DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView().notEmpty());
        Assert.assertFalse(DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView().isEmpty());
        Assert.assertTrue(DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView().notEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(0.0));
        Assert.assertTrue(this.iterable.contains(1.0));
        Assert.assertFalse(this.iterable.contains(2.0));
        Assert.assertTrue(this.iterable.contains(31.0));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(0.0, 1.0));
        Assert.assertFalse(this.iterable.containsAll(1.0, 5.0));
        Assert.assertFalse(this.iterable.containsAll(2.0, 5.0));
        Assert.assertFalse(this.iterable.containsAll(31.0, 2.0));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(DoubleHashSet.newSetWith(0.0, 1.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleHashSet.newSetWith(1.0, 5.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleHashSet.newSetWith(2.0, 5.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleHashSet.newSetWith(31.0, 2.0)));
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new double[] { 0.0, 1.0 }, DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView().toArray()) || Arrays.equals(new double[] { 0.0, 1.0 }, DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView().toArray()));
        Assert.assertArrayEquals(new double[] {}, new DoubleBooleanHashMap().keysView().toArray(), 0.0);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new double[] { 0.0, 1.0, 31.0, generateCollisions1().getFirst(), generateCollisions1().get(1) }, this.iterable.toSortedArray(), 0.0);
        Assert.assertArrayEquals(new double[] {}, new DoubleBooleanHashMap().keysView().toSortedArray(), 0.0);
    }

    @Test
    public void doubleIterator() {
        MutableDoubleSet expected = DoubleHashSet.newSetWith(0.0, 1.0, 31.0, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableDoubleSet actual = DoubleHashSet.newSetWith();
        DoubleIterator iterator = this.iterable.doubleIterator();
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
        DoubleIterator iterator = this.iterable.doubleIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        double[] sum = new double[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0], 0.0);
    }

    @Test
    public void count() {
        Assert.assertEquals(4L, this.iterable.count(DoublePredicates.greaterThan(0.0)));
        Assert.assertEquals(3L, this.iterable.count(DoublePredicates.lessThan(32.0)));
        Assert.assertEquals(1L, this.iterable.count(DoublePredicates.greaterThan(32.0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.iterable.anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(this.iterable.anySatisfy(DoublePredicates.greaterThan(31.0)));
        Assert.assertFalse(this.iterable.anySatisfy(DoublePredicates.equal(2.0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(DoublePredicates.not(DoublePredicates.equal(2.0))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.iterable.noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.iterable.noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.iterable.noneSatisfy(DoublePredicates.greaterThan(31.0)));
        Assert.assertTrue(this.iterable.noneSatisfy(DoublePredicates.equal(2.0)));
    }

    @Test
    public void select() {
        Verify.assertSize(3, this.iterable.select(DoublePredicates.lessThan(32.0)));
        Verify.assertSize(4, this.iterable.select(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(DoublePredicates.greaterThan(0.0)));
        Verify.assertSize(2, this.iterable.reject(DoublePredicates.lessThan(32.0)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(0.0, this.iterable.detectIfNone(DoublePredicates.lessThan(1.0), 9.0), 0.0);
        Assert.assertEquals(1.0, this.iterable.detectIfNone(DoublePredicates.equal(1.0), 9.0), 0.0);
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(DoublePredicates.greaterThan(generateCollisions1().getFirst()), 9.0), 0.0);
        Assert.assertEquals(9.0, this.iterable.detectIfNone(DoublePredicates.greaterThan(generateCollisions1().get(1)), 9.0), 0.0);
    }

    @Test
    public void collect() {
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0, 0.0, 30.0, generateCollisions1().getFirst() - 1, generateCollisions1().get(1) - 1), this.iterable.collect((double parameter) -> parameter - 1).toSet());
    }

    @Test
    public void max() {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new DoubleBooleanHashMap().keysView().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0, this.iterable.min(), 0.0);
        Assert.assertEquals(31.0, DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, false).keysView().min(), 0.0);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, new DoubleBooleanHashMap().keysView().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleBooleanHashMap().keysView().minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, this.iterable.minIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, new DoubleBooleanHashMap().keysView().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleBooleanHashMap().keysView().maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty(5.0), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new DoubleBooleanHashMap().keysView().min();
    }

    @Test
    public void sum() {
        Assert.assertEquals(94.0, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).withKeysValues(0.0, true, 1.0, false).keysView().sum(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList() {
        new DoubleBooleanHashMap().keysView().average();
    }

    @Test
    public void average() {
        Assert.assertEquals(31.0, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).keysView().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(31.0, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).withKeyValue(1.0, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList() {
        new DoubleBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", new DoubleBooleanHashMap().keysView().toString());
        Assert.assertEquals("[0.0]", DoubleBooleanHashMap.newWithKeysValues(0.0, true).keysView().toString());
        Assert.assertEquals("[1.0]", DoubleBooleanHashMap.newWithKeysValues(1.0, false).keysView().toString());
        Assert.assertEquals("[5.0]", DoubleBooleanHashMap.newWithKeysValues(5.0, false).keysView().toString());
        LazyDoubleIterable iterable1 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView();
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0.0, 1.0]") || iterable1.toString().equals("[1.0, 0.0]"));
        LazyDoubleIterable iterable2 = DoubleBooleanHashMap.newWithKeysValues(1.0, false, 32.0, true).keysView();
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[1.0, 32.0]") || iterable2.toString().equals("[32.0, 1.0]"));
        LazyDoubleIterable iterable3 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 32.0, true).keysView();
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[0.0, 32.0]") || iterable3.toString().equals("[32.0, 0.0]"));
        LazyDoubleIterable iterable4 = DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, false).keysView();
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[32.0, 33.0]") || iterable4.toString().equals("[33.0, 32.0]"));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", new DoubleBooleanHashMap().keysView().makeString());
        Assert.assertEquals("31.0", new DoubleBooleanHashMap().withKeyValue(31.0, true).keysView().makeString());
        Assert.assertEquals("32.0", new DoubleBooleanHashMap().withKeyValue(32.0, false).keysView().makeString());
        LazyDoubleIterable iterable0 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView();
        Assert.assertTrue(iterable0.makeString(), "0.0, 1.0".equals(iterable0.makeString()) || "1.0, 0.0".equals(iterable0.makeString()));
        LazyDoubleIterable iterable1 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView();
        Assert.assertTrue(iterable1.makeString(), "0.0, 31.0".equals(iterable1.makeString()) || "31.0, 0.0".equals(iterable1.makeString()));
        LazyDoubleIterable iterable2 = DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView();
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), "[31.0/32.0]".equals(iterable2.makeString("[", "/", "]")) || "[32.0/31.0]".equals(iterable2.makeString("[", "/", "]")));
        LazyDoubleIterable iterable3 = DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView();
        Assert.assertTrue(iterable3.makeString("/"), "32.0/33.0".equals(iterable3.makeString("/")) || "33.0/32.0".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        new DoubleBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable0 = new StringBuilder();
        new DoubleBooleanHashMap().withKeyValue(31.0, true).keysView().appendString(appendable0);
        Assert.assertEquals("31.0", appendable0.toString());
        StringBuilder appendable1 = new StringBuilder();
        new DoubleBooleanHashMap().withKeyValue(32.0, true).keysView().appendString(appendable1);
        Assert.assertEquals("32.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        LazyDoubleIterable set1 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "0.0, 31.0".equals(appendable2.toString()) || "31.0, 0.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        LazyDoubleIterable set2 = DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "31.0/32.0".equals(appendable3.toString()) || "32.0/31.0".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        LazyDoubleIterable set4 = DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[32.0/33.0]".equals(appendable4.toString()) || "[33.0/32.0]".equals(appendable4.toString()));
    }

    @Test
    public void toList() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true).keysView().toList());
        Assert.assertEquals(DoubleArrayList.newListWith(31.0), DoubleBooleanHashMap.newWithKeysValues(31.0, true).keysView().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 31.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true).keysView().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true).keysView().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true).keysView().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, this.iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleBooleanHashMapKeysViewTest instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleBooleanHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> average_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> median_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.size = DoubleBooleanHashMapKeysViewTest::size;
            this.payloads.empty = DoubleBooleanHashMapKeysViewTest::empty;
            this.payloads.contains = DoubleBooleanHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = DoubleBooleanHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = DoubleBooleanHashMapKeysViewTest::containsAllIterable;
            this.payloads.toArray = DoubleBooleanHashMapKeysViewTest::toArray;
            this.payloads.toSortedArray = DoubleBooleanHashMapKeysViewTest::toSortedArray;
            this.payloads.doubleIterator = DoubleBooleanHashMapKeysViewTest::doubleIterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleBooleanHashMapKeysViewTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = DoubleBooleanHashMapKeysViewTest::forEach;
            this.payloads.count = DoubleBooleanHashMapKeysViewTest::count;
            this.payloads.anySatisfy = DoubleBooleanHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = DoubleBooleanHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleBooleanHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = DoubleBooleanHashMapKeysViewTest::select;
            this.payloads.reject = DoubleBooleanHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = DoubleBooleanHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = DoubleBooleanHashMapKeysViewTest::collect;
            this.payloads.max = DoubleBooleanHashMapKeysViewTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleBooleanHashMapKeysViewTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = DoubleBooleanHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = DoubleBooleanHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleBooleanHashMapKeysViewTest::maxIfEmpty;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleBooleanHashMapKeysViewTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.sum = DoubleBooleanHashMapKeysViewTest::sum;
            this.payloads.average_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleBooleanHashMapKeysViewTest::average_throws_emptyList, java.lang.ArithmeticException.class);
            this.payloads.average = DoubleBooleanHashMapKeysViewTest::average;
            this.payloads.median = DoubleBooleanHashMapKeysViewTest::median;
            this.payloads.median_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleBooleanHashMapKeysViewTest::median_throws_emptyList, java.lang.ArithmeticException.class);
            this.payloads.testToString = DoubleBooleanHashMapKeysViewTest::testToString;
            this.payloads.makeString = DoubleBooleanHashMapKeysViewTest::makeString;
            this.payloads.appendString = DoubleBooleanHashMapKeysViewTest::appendString;
            this.payloads.toList = DoubleBooleanHashMapKeysViewTest::toList;
            this.payloads.toSortedList = DoubleBooleanHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = DoubleBooleanHashMapKeysViewTest::toSet;
            this.payloads.toBag = DoubleBooleanHashMapKeysViewTest::toBag;
            this.payloads.asLazy = DoubleBooleanHashMapKeysViewTest::asLazy;
        }
    }
}
