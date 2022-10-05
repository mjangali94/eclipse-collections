/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.primitive.DoubleList;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapDoubleIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapDoubleIterableTest {

    private final DoubleList list = DoubleLists.immutable.with(1.0, 2.0, 3.0, 4.0, 5.0);

    @Test
    public void doubleIterator() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        double sum = 0.0;
        for (DoubleIterator iterator = iterable.doubleIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(15.0, sum, 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        double[] sum = new double[1];
        iterable.forEach((double each) -> sum[0] += each);
        Assert.assertEquals(15.0, sum[0], 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.count(DoublePredicates.lessThan(2.0)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertTrue(iterable.anySatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertTrue(iterable.anySatisfy(DoublePredicates.greaterThan(4.0)));
    }

    @Test
    public void allSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertTrue(iterable.allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(iterable.allSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertFalse(iterable.allSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertFalse(iterable.allSatisfy(DoublePredicates.lessThan(4.0)));
    }

    @Test
    public void noneSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertTrue(iterable.noneSatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertFalse(iterable.noneSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertTrue(iterable.noneSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertFalse(iterable.noneSatisfy(DoublePredicates.greaterThan(4.0)));
    }

    @Test
    public void select() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Verify.assertSize(4, iterable.select(DoublePredicates.greaterThan(1.0)));
        Verify.assertSize(0, iterable.select(DoublePredicates.lessThan(0.0)));
    }

    @Test
    public void reject() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Verify.assertSize(1, iterable.reject(DoublePredicates.greaterThan(1.0)));
        Verify.assertSize(0, iterable.reject(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void detectIfNone() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(1.0, iterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(4.0, iterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);
    }

    @Test
    public void collect() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(15.0, iterable.sum(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(5.0, iterable.max(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(1.0, iterable.min(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(1.0, iterable.minIfEmpty(0.0), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(5.0, iterable.maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new TapDoubleIterable(new DoubleArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new TapDoubleIterable(new DoubleArrayList(), System.out::println).min();
    }

    @Test
    public void average() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new TapDoubleIterable(new DoubleArrayList(), System.out::println).average();
    }

    @Test
    public void median() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new TapDoubleIterable(new DoubleArrayList(), System.out::println).median();
    }

    @Test
    public void toArray() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertArrayEquals(new double[] { 1, 2, 3, 4, 5 }, iterable.toArray(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertTrue(iterable.contains(1.0));
        Assert.assertTrue(iterable.contains(2.0));
        Assert.assertFalse(iterable.contains(6.0));
    }

    @Test
    public void containsAllArray() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(1.0));
        Assert.assertTrue(iterable.containsAll(2.0));
        Assert.assertTrue(iterable.containsAll(1.0, 2.0));
        Assert.assertTrue(iterable.containsAll(1.0, 2.0, 3.0));
        Assert.assertFalse(iterable.containsAll(4.0, 5.0, 6.0));
    }

    @Test
    public void containsAllIterable() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(2.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Assert.assertFalse(iterable.containsAll(DoubleArrayList.newListWith(4.0, 5.0, 6.0)));
    }

    @Test
    public void toSortedArray() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertArrayEquals(new double[] { 1, 2, 3, 4, 5 }, iterable.toSortedArray(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0, 4.0, 5.0), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto() {
        StringBuilder builder = new StringBuilder();
        TapDoubleIterable iterable = new TapDoubleIterable(this.list, builder::append);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(15.0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator, this.description("doubleIterator"));
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        private TapDoubleIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TapDoubleIterableTest();
        }

        @java.lang.Override
        public TapDoubleIterableTest implementation() {
            return this.implementation;
        }
    }
}
