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
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectLongIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectLongIterableTest {

    private final SelectLongIterable iterable = new SelectLongIterable(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), LongPredicates.lessThan(3L));

    @Test
    public void longIterator() {
        long sum = 0L;
        for (LongIterator iterator = this.iterable.longIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.iterable.forEach((long each) -> sum[0] += each);
        Assert.assertEquals(3L, sum[0]);
    }

    @Test
    public void size() {
        Verify.assertSize(2, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.iterable.notEmpty());
        Verify.assertNotEmpty(this.iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(1L, this.iterable.count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(0L, this.iterable.count(LongPredicates.lessThan(0L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.iterable.anySatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.iterable.allSatisfy(LongPredicates.lessThan(4L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.iterable.noneSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void select() {
        Verify.assertSize(1, this.iterable.select(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, this.iterable.select(LongPredicates.lessThan(0L)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, this.iterable.reject(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(0L, this.iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(2, this.iterable.collect(String::valueOf));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3L, this.iterable.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals(2L, this.iterable.max());
    }

    @Test
    public void min() {
        Assert.assertEquals(1L, this.iterable.min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1L, this.iterable.minIfEmpty(0L));
        Assert.assertEquals(0L, this.iterable.select(LongPredicates.lessThan(0L)).minIfEmpty(0L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2L, this.iterable.maxIfEmpty(0L));
        Assert.assertEquals(0L, this.iterable.select(LongPredicates.lessThan(0L)).maxIfEmpty(0L));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new long[] { 1, 2 }, this.iterable.toArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(1L));
        Assert.assertTrue(this.iterable.contains(2L));
        Assert.assertFalse(this.iterable.contains(3L));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(1L));
        Assert.assertTrue(this.iterable.containsAll(2L));
        Assert.assertTrue(this.iterable.containsAll(1L, 2L));
        Assert.assertFalse(this.iterable.containsAll(1L, 2L, 3L));
        Assert.assertFalse(this.iterable.containsAll(4L, 5L, 6L));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(2L)));
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertFalse(this.iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(this.iterable.containsAll(LongArrayList.newListWith(4L, 5L, 6L)));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new long[] { 1, 2 }, this.iterable.toSortedArray());
    }

    @Test
    public void toList() {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), this.iterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), this.iterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), this.iterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto() {
        MutableLong result = this.iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(3L), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator, this.description("longIterator"));
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

        private SelectLongIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SelectLongIterableTest();
        }

        @java.lang.Override
        public SelectLongIterableTest implementation() {
            return this.implementation;
        }
    }
}
