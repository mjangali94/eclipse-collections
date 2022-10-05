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
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseDoubleIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseDoubleIterableTest {

    @Test
    public void isEmpty() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertEmpty(new DoubleArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertFalse(iterable.contains(0.0));
        Assert.assertTrue(iterable.contains(1.0));
    }

    @Test
    public void containsAllArray() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.containsAll(1.0));
        Assert.assertTrue(iterable.containsAll(1.0, 2.0, 3.0));
        Assert.assertFalse(iterable.containsAll(1.0, 2.0, 3.0, 4.0));
    }

    @Test
    public void containsAllIterable() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Assert.assertFalse(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0)));
    }

    @Test
    public void iterator() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        DoubleIterator iterator = iterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        DoubleIterator iterator = iterable.doubleIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        double[] sum = new double[1];
        iterable.forEach((double each) -> sum[0] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
    }

    @Test
    public void size() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(0, new DoubleArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().count(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, -1.0, 2.0).asReversed().anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, -1.0, 2.0).asReversed().anySatisfy(DoublePredicates.equal(0.0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, 2.0, 3.0).asReversed().allSatisfy(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, 2.0, 3.0).asReversed().noneSatisfy(DoublePredicates.greaterThan(3.0)));
    }

    @Test
    public void select() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(3, iterable.select(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(2, iterable.select(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void reject() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(0, iterable.reject(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(1, iterable.reject(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void detectIfNone() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals(1.0, iterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(0.0, iterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);
    }

    @Test
    public void collect() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(0.0, 1.0, 2.0), iterable.collect((double parameter) -> parameter - 1));
    }

    @Test
    public void max() {
        Assert.assertEquals(9.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new DoubleArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new DoubleArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, new DoubleArrayList().asReversed().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleArrayList().asReversed().minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().minIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, new DoubleArrayList().asReversed().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleArrayList().asReversed().maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(9.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().maxIfEmpty(5.0), 0.0);
    }

    @Test
    public void sum() {
        Assert.assertEquals(10.0, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().sum(), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        DoubleIterable iterable = DoubleArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())).asReversed().toArray());
        Assert.assertEquals(1.082323233711138, iterable.sum(), 1.0e-15);
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new double[] { 3.0, 4.0, 2.0, 1.0 }, DoubleArrayList.newListWith(1.0, 2.0, 4.0, 3.0).asReversed().toArray(), 0.0);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new double[] { 1.0, 3.0, 7.0, 9.0 }, DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0).asReversed().toSortedArray(), 0.0);
    }

    @Test
    public void testToString() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals("[1.0, 2.0, 3.0]", iterable.toString());
        Assert.assertEquals("[]", new DoubleArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals("1.0, 2.0, 3.0", iterable.makeString());
        Assert.assertEquals("1.0", DoubleArrayList.newListWith(1.0).makeString("/"));
        Assert.assertEquals("1.0/2.0/3.0", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new DoubleArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        StringBuilder appendable = new StringBuilder();
        new DoubleArrayList().asReversed().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        iterable.appendString(appendable2);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(DoubleArrayList.newListWith(2.0, 1.0), DoubleArrayList.newListWith(1.0, 2.0).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(2.0, 3.0, 1.0).asReversed().toSortedList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
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
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_throws_emptyList, this.description("min_throws_emptyList"), java.util.NoSuchElementException.class);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumConsistentRounding, this.description("sumConsistentRounding"));
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        private ReverseDoubleIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ReverseDoubleIterableTest();
        }

        @java.lang.Override
        public ReverseDoubleIterableTest implementation() {
            return this.implementation;
        }
    }
}
