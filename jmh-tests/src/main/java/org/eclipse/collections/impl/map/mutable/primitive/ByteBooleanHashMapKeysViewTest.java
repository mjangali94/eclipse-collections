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
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class ByteBooleanHashMapKeysViewTest {

    private final LazyByteIterable iterable = ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 31, true, generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static ByteArrayList generateCollisions1() {
        ByteArrayList collisions = new ByteArrayList();
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        for (byte i = (byte) 32; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask((byte) 32)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size() {
        Verify.assertSize(0, new ByteBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(new ByteBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new ByteBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false).keysView().isEmpty());
        Assert.assertTrue(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false).keysView().notEmpty());
        Assert.assertFalse(ByteBooleanHashMap.newWithKeysValues((byte) 31, true, (byte) 32, true).keysView().isEmpty());
        Assert.assertTrue(ByteBooleanHashMap.newWithKeysValues((byte) 31, true, (byte) 32, true).keysView().notEmpty());
        Assert.assertFalse(ByteBooleanHashMap.newWithKeysValues((byte) 32, true, (byte) 33, true).keysView().isEmpty());
        Assert.assertTrue(ByteBooleanHashMap.newWithKeysValues((byte) 32, true, (byte) 33, true).keysView().notEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains((byte) 0));
        Assert.assertTrue(this.iterable.contains((byte) 1));
        Assert.assertFalse(this.iterable.contains((byte) 2));
        Assert.assertTrue(this.iterable.contains((byte) 31));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll((byte) 0, (byte) 1));
        Assert.assertFalse(this.iterable.containsAll((byte) 1, (byte) 5));
        Assert.assertFalse(this.iterable.containsAll((byte) 2, (byte) 5));
        Assert.assertFalse(this.iterable.containsAll((byte) 31, (byte) 2));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(ByteHashSet.newSetWith((byte) 0, (byte) 1)));
        Assert.assertFalse(this.iterable.containsAll(ByteHashSet.newSetWith((byte) 1, (byte) 5)));
        Assert.assertFalse(this.iterable.containsAll(ByteHashSet.newSetWith((byte) 2, (byte) 5)));
        Assert.assertFalse(this.iterable.containsAll(ByteHashSet.newSetWith((byte) 31, (byte) 2)));
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 1 }, ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false).keysView().toArray()) || Arrays.equals(new byte[] { (byte) 0, (byte) 1 }, ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false).keysView().toArray()));
        Assert.assertArrayEquals(new byte[] {}, new ByteBooleanHashMap().keysView().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 0, (byte) 1, (byte) 31, generateCollisions1().getFirst(), generateCollisions1().get(1) }, this.iterable.toSortedArray());
        Assert.assertArrayEquals(new byte[] {}, new ByteBooleanHashMap().keysView().toSortedArray());
    }

    @Test
    public void byteIterator() {
        MutableByteSet expected = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableByteSet actual = ByteHashSet.newSetWith();
        ByteIterator iterator = this.iterable.byteIterator();
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
        ByteIterator iterator = this.iterable.byteIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        byte[] sum = new byte[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0]);
    }

    @Test
    public void count() {
        Assert.assertEquals(4L, this.iterable.count(BytePredicates.greaterThan((byte) 0)));
        Assert.assertEquals(3L, this.iterable.count(BytePredicates.lessThan((byte) 32)));
        Assert.assertEquals(1L, this.iterable.count(BytePredicates.greaterThan((byte) 32)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.iterable.anySatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(this.iterable.anySatisfy(BytePredicates.greaterThan((byte) 31)));
        Assert.assertFalse(this.iterable.anySatisfy(BytePredicates.equal((byte) 2)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.iterable.allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertFalse(this.iterable.allSatisfy(BytePredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(BytePredicates.not(BytePredicates.equal((byte) 2))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.iterable.noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(BytePredicates.greaterThan((byte) 31)));
        Assert.assertTrue(this.iterable.noneSatisfy(BytePredicates.equal((byte) 2)));
    }

    @Test
    public void select() {
        Verify.assertSize(3, this.iterable.select(BytePredicates.lessThan((byte) 32)));
        Verify.assertSize(4, this.iterable.select(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(BytePredicates.greaterThan((byte) 0)));
        Verify.assertSize(2, this.iterable.reject(BytePredicates.lessThan((byte) 32)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals((byte) 0, this.iterable.detectIfNone(BytePredicates.lessThan((byte) 1), (byte) 9));
        Assert.assertEquals((byte) 1, this.iterable.detectIfNone(BytePredicates.equal((byte) 1), (byte) 9));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(BytePredicates.greaterThan(generateCollisions1().getFirst()), (byte) 9));
        Assert.assertEquals((byte) 9, this.iterable.detectIfNone(BytePredicates.greaterThan(generateCollisions1().get(1)), (byte) 9));
    }

    @Test
    public void collect() {
        Assert.assertEquals(UnifiedSet.newSetWith((byte) -1, (byte) 0, (byte) 30, (byte) (generateCollisions1().getFirst() - 1), (byte) (generateCollisions1().get(1) - 1)), this.iterable.collect((byte parameter) -> (byte) (parameter - 1)).toSet());
    }

    @Test
    public void max() {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new ByteBooleanHashMap().keysView().max();
    }

    @Test
    public void min() {
        Assert.assertEquals((byte) 0, this.iterable.min());
        Assert.assertEquals((byte) 31, ByteBooleanHashMap.newWithKeysValues((byte) 31, true, (byte) 32, false).keysView().min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((byte) 5, new ByteBooleanHashMap().keysView().minIfEmpty((byte) 5));
        Assert.assertEquals((byte) 0, new ByteBooleanHashMap().keysView().minIfEmpty((byte) 0));
        Assert.assertEquals((byte) 0, this.iterable.minIfEmpty((byte) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((byte) 5, new ByteBooleanHashMap().keysView().maxIfEmpty((byte) 5));
        Assert.assertEquals((byte) 0, new ByteBooleanHashMap().keysView().maxIfEmpty((byte) 0));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty((byte) 5));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new ByteBooleanHashMap().keysView().min();
    }

    @Test
    public void sum() {
        Assert.assertEquals(94L, ByteBooleanHashMap.newWithKeysValues((byte) 30, true, (byte) 31, false, (byte) 32, true).withKeysValues((byte) 0, true, (byte) 1, false).keysView().sum());
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList() {
        new ByteBooleanHashMap().keysView().average();
    }

    @Test
    public void average() {
        Assert.assertEquals(31.0, ByteBooleanHashMap.newWithKeysValues((byte) 30, true, (byte) 31, false, (byte) 32, true).keysView().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(31.0, ByteBooleanHashMap.newWithKeysValues((byte) 30, true, (byte) 31, false, (byte) 32, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, ByteBooleanHashMap.newWithKeysValues((byte) 30, true, (byte) 31, false, (byte) 32, true).withKeyValue((byte) 1, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList() {
        new ByteBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", new ByteBooleanHashMap().keysView().toString());
        Assert.assertEquals("[0]", ByteBooleanHashMap.newWithKeysValues((byte) 0, true).keysView().toString());
        Assert.assertEquals("[1]", ByteBooleanHashMap.newWithKeysValues((byte) 1, false).keysView().toString());
        Assert.assertEquals("[5]", ByteBooleanHashMap.newWithKeysValues((byte) 5, false).keysView().toString());
        LazyByteIterable iterable1 = ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false).keysView();
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 1]") || iterable1.toString().equals("[1, 0]"));
        LazyByteIterable iterable2 = ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 32, true).keysView();
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[1, 32]") || iterable2.toString().equals("[32, 1]"));
        LazyByteIterable iterable3 = ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 32, true).keysView();
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[0, 32]") || iterable3.toString().equals("[32, 0]"));
        LazyByteIterable iterable4 = ByteBooleanHashMap.newWithKeysValues((byte) 32, true, (byte) 33, false).keysView();
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[32, 33]") || iterable4.toString().equals("[33, 32]"));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", new ByteBooleanHashMap().keysView().makeString());
        Assert.assertEquals("31", new ByteBooleanHashMap().withKeyValue((byte) 31, true).keysView().makeString());
        Assert.assertEquals("32", new ByteBooleanHashMap().withKeyValue((byte) 32, false).keysView().makeString());
        LazyByteIterable iterable0 = ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false).keysView();
        Assert.assertTrue(iterable0.makeString(), "0, 1".equals(iterable0.makeString()) || "1, 0".equals(iterable0.makeString()));
        LazyByteIterable iterable1 = ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false).keysView();
        Assert.assertTrue(iterable1.makeString(), "0, 31".equals(iterable1.makeString()) || "31, 0".equals(iterable1.makeString()));
        LazyByteIterable iterable2 = ByteBooleanHashMap.newWithKeysValues((byte) 31, true, (byte) 32, true).keysView();
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), "[31/32]".equals(iterable2.makeString("[", "/", "]")) || "[32/31]".equals(iterable2.makeString("[", "/", "]")));
        LazyByteIterable iterable3 = ByteBooleanHashMap.newWithKeysValues((byte) 32, true, (byte) 33, true).keysView();
        Assert.assertTrue(iterable3.makeString("/"), "32/33".equals(iterable3.makeString("/")) || "33/32".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        new ByteBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable0 = new StringBuilder();
        new ByteBooleanHashMap().withKeyValue((byte) 31, true).keysView().appendString(appendable0);
        Assert.assertEquals("31", appendable0.toString());
        StringBuilder appendable1 = new StringBuilder();
        new ByteBooleanHashMap().withKeyValue((byte) 32, true).keysView().appendString(appendable1);
        Assert.assertEquals("32", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        LazyByteIterable set1 = ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "0, 31".equals(appendable2.toString()) || "31, 0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        LazyByteIterable set2 = ByteBooleanHashMap.newWithKeysValues((byte) 31, true, (byte) 32, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "31/32".equals(appendable3.toString()) || "32/31".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        LazyByteIterable set4 = ByteBooleanHashMap.newWithKeysValues((byte) 32, true, (byte) 33, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[32/33]".equals(appendable4.toString()) || "[33/32]".equals(appendable4.toString()));
    }

    @Test
    public void toList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0), ByteBooleanHashMap.newWithKeysValues((byte) 0, true).keysView().toList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 31), ByteBooleanHashMap.newWithKeysValues((byte) 31, true).keysView().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 31), ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 31, true).keysView().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31), ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 31, true).keysView().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 31), ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 31, true).keysView().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyByteIterable.class, this.iterable.asLazy());
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator, this.description("byteIterator"));
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

        private ByteBooleanHashMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteBooleanHashMapKeysViewTest();
        }

        @java.lang.Override
        public ByteBooleanHashMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
