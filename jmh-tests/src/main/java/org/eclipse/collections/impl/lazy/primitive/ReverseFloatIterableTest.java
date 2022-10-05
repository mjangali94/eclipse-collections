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
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseFloatIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseFloatIterableTest {

    @Test
    public void isEmpty() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertEmpty(new FloatArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertFalse(iterable.contains(0.0f));
        Assert.assertTrue(iterable.contains(1.0f));
    }

    @Test
    public void containsAllArray() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertTrue(iterable.containsAll(1.0f));
        Assert.assertTrue(iterable.containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertFalse(iterable.containsAll(1.0f, 2.0f, 3.0f, 4.0f));
    }

    @Test
    public void containsAllIterable() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Assert.assertFalse(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f)));
    }

    @Test
    public void iterator() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        FloatIterator iterator = iterable.floatIterator();
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
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        FloatIterator iterator = iterable.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        double[] sum = new double[1];
        iterable.forEach((float each) -> sum[0] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
    }

    @Test
    public void size() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertSize(0, new FloatArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, FloatArrayList.newListWith(1.0f, 0.0f, 2.0f).asReversed().count(FloatPredicates.greaterThan(0.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(FloatArrayList.newListWith(1.0f, -1.0f, 2.0f).asReversed().anySatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(FloatArrayList.newListWith(1.0f, -1.0f, 2.0f).asReversed().anySatisfy(FloatPredicates.equal(0.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(FloatArrayList.newListWith(1.0f, 0.0f, 2.0f).asReversed().allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f).asReversed().allSatisfy(FloatPredicates.greaterThan(0.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(FloatArrayList.newListWith(1.0f, 0.0f, 2.0f).asReversed().noneSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f).asReversed().noneSatisfy(FloatPredicates.greaterThan(3.0f)));
    }

    @Test
    public void select() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertSize(3, iterable.select(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(2, iterable.select(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void reject() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertSize(0, iterable.reject(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(1, iterable.reject(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void detectIfNone() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertEquals(1.0, iterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
        Assert.assertEquals(0.0, iterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);
    }

    @Test
    public void collect() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(0.0f, 1.0f, 2.0f), iterable.collect((float parameter) -> parameter - 1));
    }

    @Test
    public void max() {
        Assert.assertEquals(9.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new FloatArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new FloatArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, new FloatArrayList().asReversed().minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, new FloatArrayList().asReversed().minIfEmpty(0.0f), 0.0);
        Assert.assertEquals(0.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().minIfEmpty(5.0f), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, new FloatArrayList().asReversed().maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, new FloatArrayList().asReversed().maxIfEmpty(0.0f), 0.0);
        Assert.assertEquals(9.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().maxIfEmpty(5.0f), 0.0);
    }

    @Test
    public void sum() {
        Assert.assertEquals(10.0, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f).asReversed().sum(), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        FloatIterable iterable = FloatArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())).asReversed().toArray());
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, iterable.sum(), 1.0e-15);
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new float[] { 3.0f, 4.0f, 2.0f, 1.0f }, FloatArrayList.newListWith(1.0f, 2.0f, 4.0f, 3.0f).asReversed().toArray(), 0.0f);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 1.0f, 3.0f, 7.0f, 9.0f }, FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f).asReversed().toSortedArray(), 0.0f);
    }

    @Test
    public void testToString() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertEquals("[1.0, 2.0, 3.0]", iterable.toString());
        Assert.assertEquals("[]", new FloatArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertEquals("1.0, 2.0, 3.0", iterable.makeString());
        Assert.assertEquals("1.0", FloatArrayList.newListWith(1.0f).makeString("/"));
        Assert.assertEquals("1.0/2.0/3.0", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new FloatArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        StringBuilder appendable = new StringBuilder();
        new FloatArrayList().asReversed().appendString(appendable);
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
        Assert.assertEquals(FloatArrayList.newListWith(2.0f, 1.0f), FloatArrayList.newListWith(1.0f, 2.0f).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(2.0f, 3.0f, 1.0f).asReversed().toSortedList());
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

        private ReverseFloatIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ReverseFloatIterableTest();
        }

        @java.lang.Override
        public ReverseFloatIterableTest implementation() {
            return this.implementation;
        }
    }
}
