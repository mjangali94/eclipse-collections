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
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class FloatBooleanHashMapKeysViewTest {

    private final LazyFloatIterable iterable = FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false, 31.0f, true, generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static FloatArrayList generateCollisions1() {
        FloatArrayList collisions = new FloatArrayList();
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float i = 32.0f; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(32.0f)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size() {
        Verify.assertSize(0, new FloatBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(new FloatBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new FloatBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false).keysView().isEmpty());
        Assert.assertTrue(FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false).keysView().notEmpty());
        Assert.assertFalse(FloatBooleanHashMap.newWithKeysValues(31.0f, true, 32.0f, true).keysView().isEmpty());
        Assert.assertTrue(FloatBooleanHashMap.newWithKeysValues(31.0f, true, 32.0f, true).keysView().notEmpty());
        Assert.assertFalse(FloatBooleanHashMap.newWithKeysValues(32.0f, true, 33.0f, true).keysView().isEmpty());
        Assert.assertTrue(FloatBooleanHashMap.newWithKeysValues(32.0f, true, 33.0f, true).keysView().notEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(0.0f));
        Assert.assertTrue(this.iterable.contains(1.0f));
        Assert.assertFalse(this.iterable.contains(2.0f));
        Assert.assertTrue(this.iterable.contains(31.0f));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(0.0f, 1.0f));
        Assert.assertFalse(this.iterable.containsAll(1.0f, 5.0f));
        Assert.assertFalse(this.iterable.containsAll(2.0f, 5.0f));
        Assert.assertFalse(this.iterable.containsAll(31.0f, 2.0f));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(FloatHashSet.newSetWith(0.0f, 1.0f)));
        Assert.assertFalse(this.iterable.containsAll(FloatHashSet.newSetWith(1.0f, 5.0f)));
        Assert.assertFalse(this.iterable.containsAll(FloatHashSet.newSetWith(2.0f, 5.0f)));
        Assert.assertFalse(this.iterable.containsAll(FloatHashSet.newSetWith(31.0f, 2.0f)));
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new float[] { 0.0f, 1.0f }, FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false).keysView().toArray()) || Arrays.equals(new float[] { 0.0f, 1.0f }, FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false).keysView().toArray()));
        Assert.assertArrayEquals(new float[] {}, new FloatBooleanHashMap().keysView().toArray(), 0.0f);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 0.0f, 1.0f, 31.0f, generateCollisions1().getFirst(), generateCollisions1().get(1) }, this.iterable.toSortedArray(), 0.0f);
        Assert.assertArrayEquals(new float[] {}, new FloatBooleanHashMap().keysView().toSortedArray(), 0.0f);
    }

    @Test
    public void floatIterator() {
        MutableFloatSet expected = FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableFloatSet actual = FloatHashSet.newSetWith();
        FloatIterator iterator = this.iterable.floatIterator();
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
        FloatIterator iterator = this.iterable.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        float[] sum = new float[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0], 0.0f);
    }

    @Test
    public void count() {
        Assert.assertEquals(4L, this.iterable.count(FloatPredicates.greaterThan(0.0f)));
        Assert.assertEquals(3L, this.iterable.count(FloatPredicates.lessThan(32.0f)));
        Assert.assertEquals(1L, this.iterable.count(FloatPredicates.greaterThan(32.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.iterable.anySatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(this.iterable.anySatisfy(FloatPredicates.greaterThan(31.0f)));
        Assert.assertFalse(this.iterable.anySatisfy(FloatPredicates.equal(2.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.iterable.allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.iterable.allSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertFalse(this.iterable.allSatisfy(FloatPredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(FloatPredicates.not(FloatPredicates.equal(2.0f))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.iterable.noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.iterable.noneSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.iterable.noneSatisfy(FloatPredicates.greaterThan(31.0f)));
        Assert.assertTrue(this.iterable.noneSatisfy(FloatPredicates.equal(2.0f)));
    }

    @Test
    public void select() {
        Verify.assertSize(3, this.iterable.select(FloatPredicates.lessThan(32.0f)));
        Verify.assertSize(4, this.iterable.select(FloatPredicates.greaterThan(0.0f)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(FloatPredicates.greaterThan(0.0f)));
        Verify.assertSize(2, this.iterable.reject(FloatPredicates.lessThan(32.0f)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(0.0f, this.iterable.detectIfNone(FloatPredicates.lessThan(1.0f), 9.0f), 0.0f);
        Assert.assertEquals(1.0f, this.iterable.detectIfNone(FloatPredicates.equal(1.0f), 9.0f), 0.0f);
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(FloatPredicates.greaterThan(generateCollisions1().getFirst()), 9.0f), 0.0f);
        Assert.assertEquals(9.0f, this.iterable.detectIfNone(FloatPredicates.greaterThan(generateCollisions1().get(1)), 9.0f), 0.0f);
    }

    @Test
    public void collect() {
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0f, 0.0f, 30.0f, generateCollisions1().getFirst() - 1, generateCollisions1().get(1) - 1), this.iterable.collect((float parameter) -> parameter - 1).toSet());
    }

    @Test
    public void max() {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max(), 0.0f);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new FloatBooleanHashMap().keysView().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0f, this.iterable.min(), 0.0f);
        Assert.assertEquals(31.0f, FloatBooleanHashMap.newWithKeysValues(31.0f, true, 32.0f, false).keysView().min(), 0.0f);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0f, new FloatBooleanHashMap().keysView().minIfEmpty(5.0f), 0.0f);
        Assert.assertEquals(0.0f, new FloatBooleanHashMap().keysView().minIfEmpty(0.0f), 0.0f);
        Assert.assertEquals(0.0f, this.iterable.minIfEmpty(5.0f), 0.0f);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0f, new FloatBooleanHashMap().keysView().maxIfEmpty(5.0f), 0.0f);
        Assert.assertEquals(0.0f, new FloatBooleanHashMap().keysView().maxIfEmpty(0.0f), 0.0f);
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty(5.0f), 0.0f);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new FloatBooleanHashMap().keysView().min();
    }

    @Test
    public void sum() {
        Assert.assertEquals(94.0, FloatBooleanHashMap.newWithKeysValues(30.0f, true, 31.0f, false, 32.0f, true).withKeysValues(0.0f, true, 1.0f, false).keysView().sum(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList() {
        new FloatBooleanHashMap().keysView().average();
    }

    @Test
    public void average() {
        Assert.assertEquals(31.0, FloatBooleanHashMap.newWithKeysValues(30.0f, true, 31.0f, false, 32.0f, true).keysView().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(31.0, FloatBooleanHashMap.newWithKeysValues(30.0f, true, 31.0f, false, 32.0f, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, FloatBooleanHashMap.newWithKeysValues(30.0f, true, 31.0f, false, 32.0f, true).withKeyValue(1.0f, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList() {
        new FloatBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", new FloatBooleanHashMap().keysView().toString());
        Assert.assertEquals("[0.0]", FloatBooleanHashMap.newWithKeysValues(0.0f, true).keysView().toString());
        Assert.assertEquals("[1.0]", FloatBooleanHashMap.newWithKeysValues(1.0f, false).keysView().toString());
        Assert.assertEquals("[5.0]", FloatBooleanHashMap.newWithKeysValues(5.0f, false).keysView().toString());
        LazyFloatIterable iterable1 = FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false).keysView();
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0.0, 1.0]") || iterable1.toString().equals("[1.0, 0.0]"));
        LazyFloatIterable iterable2 = FloatBooleanHashMap.newWithKeysValues(1.0f, false, 32.0f, true).keysView();
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[1.0, 32.0]") || iterable2.toString().equals("[32.0, 1.0]"));
        LazyFloatIterable iterable3 = FloatBooleanHashMap.newWithKeysValues(0.0f, true, 32.0f, true).keysView();
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[0.0, 32.0]") || iterable3.toString().equals("[32.0, 0.0]"));
        LazyFloatIterable iterable4 = FloatBooleanHashMap.newWithKeysValues(32.0f, true, 33.0f, false).keysView();
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[32.0, 33.0]") || iterable4.toString().equals("[33.0, 32.0]"));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", new FloatBooleanHashMap().keysView().makeString());
        Assert.assertEquals("31.0", new FloatBooleanHashMap().withKeyValue(31.0f, true).keysView().makeString());
        Assert.assertEquals("32.0", new FloatBooleanHashMap().withKeyValue(32.0f, false).keysView().makeString());
        LazyFloatIterable iterable0 = FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false).keysView();
        Assert.assertTrue(iterable0.makeString(), "0.0, 1.0".equals(iterable0.makeString()) || "1.0, 0.0".equals(iterable0.makeString()));
        LazyFloatIterable iterable1 = FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false).keysView();
        Assert.assertTrue(iterable1.makeString(), "0.0, 31.0".equals(iterable1.makeString()) || "31.0, 0.0".equals(iterable1.makeString()));
        LazyFloatIterable iterable2 = FloatBooleanHashMap.newWithKeysValues(31.0f, true, 32.0f, true).keysView();
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), "[31.0/32.0]".equals(iterable2.makeString("[", "/", "]")) || "[32.0/31.0]".equals(iterable2.makeString("[", "/", "]")));
        LazyFloatIterable iterable3 = FloatBooleanHashMap.newWithKeysValues(32.0f, true, 33.0f, true).keysView();
        Assert.assertTrue(iterable3.makeString("/"), "32.0/33.0".equals(iterable3.makeString("/")) || "33.0/32.0".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        new FloatBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable0 = new StringBuilder();
        new FloatBooleanHashMap().withKeyValue(31.0f, true).keysView().appendString(appendable0);
        Assert.assertEquals("31.0", appendable0.toString());
        StringBuilder appendable1 = new StringBuilder();
        new FloatBooleanHashMap().withKeyValue(32.0f, true).keysView().appendString(appendable1);
        Assert.assertEquals("32.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        LazyFloatIterable set1 = FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "0.0, 31.0".equals(appendable2.toString()) || "31.0, 0.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        LazyFloatIterable set2 = FloatBooleanHashMap.newWithKeysValues(31.0f, true, 32.0f, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "31.0/32.0".equals(appendable3.toString()) || "32.0/31.0".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        LazyFloatIterable set4 = FloatBooleanHashMap.newWithKeysValues(32.0f, true, 33.0f, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[32.0/33.0]".equals(appendable4.toString()) || "[33.0/32.0]".equals(appendable4.toString()));
    }

    @Test
    public void toList() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), FloatBooleanHashMap.newWithKeysValues(0.0f, true).keysView().toList());
        Assert.assertEquals(FloatArrayList.newListWith(31.0f), FloatBooleanHashMap.newWithKeysValues(31.0f, true).keysView().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 1.0f, 31.0f), FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false, 31.0f, true).keysView().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f), FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false, 31.0f, true).keysView().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f), FloatBooleanHashMap.newWithKeysValues(0.0f, true, 1.0f, false, 31.0f, true).keysView().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, this.iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllArray, this.description("containsAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::iterator_throws, this.description("iterator_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_throws_emptyList, this.description("max_throws_emptyList"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minIfEmpty, this.description("minIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxIfEmpty, this.description("maxIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_throws_emptyList, this.description("min_throws_emptyList"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::average_throws_emptyList, this.description("average_throws_emptyList"), java.lang.ArithmeticException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::average, this.description("average"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::median, this.description("median"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::median_throws_emptyList, this.description("median_throws_emptyList"), java.lang.ArithmeticException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        private FloatBooleanHashMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatBooleanHashMapKeysViewTest();
        }

        @java.lang.Override
        public FloatBooleanHashMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
