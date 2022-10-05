/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectCharIterableTest {

    private final CharIterable charIterable = Interval.oneTo(3).collectChar(PrimitiveFunctions.unboxIntegerToChar());

    @Test
    public void iterator() {
        long sum = 0L;
        CharIterator iterator = this.charIterable.charIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test
    public void size() {
        Assert.assertEquals(3L, this.charIterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.charIterable.notEmpty());
        Assert.assertFalse(this.charIterable.isEmpty());
    }

    @Test
    public void forEach() {
        long[] value = new long[1];
        this.charIterable.forEach(each -> {
            value[0] += each;
        });
        Assert.assertEquals(6L, value[0]);
    }

    @Test
    public void count() {
        Assert.assertEquals(1, this.charIterable.count(CharPredicates.equal((char) 1)));
        Assert.assertEquals(3, this.charIterable.count(CharPredicates.lessThan((char) 4)));
        Assert.assertEquals(2, this.charIterable.count(CharPredicates.greaterThan((char) 1)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.charIterable.anySatisfy(CharPredicates.greaterThan((char) 1)));
        Assert.assertTrue(this.charIterable.anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(this.charIterable.anySatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.charIterable.noneSatisfy(CharPredicates.greaterThan((char) 2)));
        Assert.assertTrue(this.charIterable.noneSatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.charIterable.allSatisfy(CharPredicates.lessThan((char) 4)));
        Assert.assertFalse(this.charIterable.allSatisfy(CharPredicates.lessThan((char) 3)));
    }

    @Test
    public void select() {
        Assert.assertEquals(3L, this.charIterable.select(CharPredicates.lessThan((char) 4)).size());
        Assert.assertEquals(2L, this.charIterable.select(CharPredicates.lessThan((char) 3)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(0L, this.charIterable.reject(CharPredicates.lessThan((char) 4)).size());
        Assert.assertEquals(1L, this.charIterable.reject(CharPredicates.lessThan((char) 3)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals((char) 1, this.charIterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals((char) 0, this.charIterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, this.charIterable.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals((char) 3, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).max());
    }

    @Test
    public void min() {
        Assert.assertEquals((char) 0, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((char) 0, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).minIfEmpty((char) 0));
        Assert.assertEquals((char) 0, FastList.<Integer>newList().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).minIfEmpty((char) 0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((char) 3, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).maxIfEmpty((char) 0));
        Assert.assertEquals((char) 0, FastList.<Integer>newList().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).maxIfEmpty((char) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectChar(PrimitiveFunctions.unboxIntegerToChar()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectChar(PrimitiveFunctions.unboxIntegerToChar()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectChar(PrimitiveFunctions.unboxIntegerToChar()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }, Interval.oneTo(4).collectChar(PrimitiveFunctions.unboxIntegerToChar()).toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 3, (char) 4 }, Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar()).toSortedArray());
    }

    @Test
    public void contains() {
        CharIterable charIterable = Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertTrue(charIterable.contains((char) 1));
        Assert.assertTrue(charIterable.contains((char) 3));
        Assert.assertTrue(charIterable.contains((char) 4));
        Assert.assertFalse(charIterable.contains((char) 5));
    }

    @Test
    public void containsAllArray() {
        CharIterable charIterable = Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertTrue(charIterable.containsAll((char) 1));
        Assert.assertTrue(charIterable.containsAll((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertFalse(charIterable.containsAll((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertFalse(charIterable.containsAll((char) 7, (char) 6, (char) 5));
    }

    @Test
    public void containsAllIterable() {
        CharIterable charIterable = Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertTrue(charIterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(charIterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4)));
        Assert.assertFalse(charIterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5)));
        Assert.assertFalse(charIterable.containsAll(CharArrayList.newListWith((char) 7, (char) 6, (char) 5)));
    }

    @Test
    public void collect() {
        Assert.assertEquals(FastList.newListWith("\u0001", "\u0002", "\u0003"), this.charIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.charIterable.toString());
    }

    @Test
    public void makeString() {
        Assert.assertEquals("\u0001, \u0002, \u0003", this.charIterable.makeString());
        Assert.assertEquals("\u0001/\u0002/\u0003", this.charIterable.makeString("/"));
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.charIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.charIterable.appendString(appendable);
        Assert.assertEquals("\u0001, \u0002, \u0003", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.charIterable.appendString(appendable2, "/");
        Assert.assertEquals("\u0001/\u0002/\u0003", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.charIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.charIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.charIterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.charIterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), this.charIterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), this.charIterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.charIterable.toSet(), this.charIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, this.charIterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
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
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::maxThrowsOnEmpty, this.description("maxThrowsOnEmpty"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::minThrowsOnEmpty, this.description("minThrowsOnEmpty"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::average, this.description("average"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::averageThrowsOnEmpty, this.description("averageThrowsOnEmpty"), java.lang.ArithmeticException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::median, this.description("median"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::medianThrowsOnEmpty, this.description("medianThrowsOnEmpty"), java.lang.ArithmeticException.class);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
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

        private CollectCharIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectCharIterableTest();
        }

        @java.lang.Override
        public CollectCharIterableTest implementation() {
            return this.implementation;
        }
    }
}
