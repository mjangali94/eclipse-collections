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
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectFloatIterableTest {

    private final FloatIterable floatIterable = Interval.oneTo(3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());

    @Test
    public void iterator() {
        double sum = 0.0;
        FloatIterator iterator = this.floatIterable.floatIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(6.0, sum, 0.0f);
    }

    @Test
    public void size() {
        Assert.assertEquals(3L, this.floatIterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.floatIterable.notEmpty());
        Assert.assertFalse(this.floatIterable.isEmpty());
    }

    @Test
    public void forEach() {
        double[] value = new double[1];
        this.floatIterable.forEach(each -> {
            value[0] += each;
        });
        Assert.assertEquals(6.0, value[0], 0.0f);
    }

    @Test
    public void count() {
        Assert.assertEquals(1, this.floatIterable.count(FloatPredicates.equal(1.0f)));
        Assert.assertEquals(3, this.floatIterable.count(FloatPredicates.lessThan(4.0f)));
        Assert.assertEquals(2, this.floatIterable.count(FloatPredicates.greaterThan(1.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.floatIterable.anySatisfy(FloatPredicates.greaterThan(1.0f)));
        Assert.assertTrue(this.floatIterable.anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(this.floatIterable.anySatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.floatIterable.noneSatisfy(FloatPredicates.greaterThan(2.0f)));
        Assert.assertTrue(this.floatIterable.noneSatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.floatIterable.allSatisfy(FloatPredicates.lessThan(4.0f)));
        Assert.assertFalse(this.floatIterable.allSatisfy(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void select() {
        Assert.assertEquals(3L, this.floatIterable.select(FloatPredicates.lessThan(4.0f)).size());
        Assert.assertEquals(2L, this.floatIterable.select(FloatPredicates.lessThan(3.0f)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(0L, this.floatIterable.reject(FloatPredicates.lessThan(4.0f)).size());
        Assert.assertEquals(1L, this.floatIterable.reject(FloatPredicates.lessThan(3.0f)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1.0f, this.floatIterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0f);
        Assert.assertEquals(0.0f, this.floatIterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0f);
    }

    @Test
    public void sum() {
        Assert.assertEquals(6.0, this.floatIterable.sum(), 0.0f);
    }

    @Test
    public void sumConsistentRounding() {
        FloatIterable iterable = Interval.oneTo(100_000).toList().shuffleThis().collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, iterable.sum(), 1.0e-15);
    }

    @Test
    public void max() {
        Assert.assertEquals(3.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).max(), 0.0f);
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).min(), 0.0f);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(0.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).minIfEmpty(0.0f), 0.0f);
        Assert.assertEquals(0.0f, FastList.<Integer>newList().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).minIfEmpty(0.0f), 0.0f);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(3.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).maxIfEmpty(0.0f), 0.0f);
        Assert.assertEquals(0.0f, FastList.<Integer>newList().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).maxIfEmpty(0.0f), 0.0f);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }, Interval.oneTo(4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).toArray(), 0.0f);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }, Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).toSortedArray(), 0.0f);
    }

    @Test
    public void contains() {
        FloatIterable floatIterable = Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertTrue(floatIterable.contains(1.0f));
        Assert.assertTrue(floatIterable.contains(3.0f));
        Assert.assertTrue(floatIterable.contains(4.0f));
        Assert.assertFalse(floatIterable.contains(5.0f));
    }

    @Test
    public void containsAllArray() {
        FloatIterable floatIterable = Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertTrue(floatIterable.containsAll(1.0f));
        Assert.assertTrue(floatIterable.containsAll(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertFalse(floatIterable.containsAll(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertFalse(floatIterable.containsAll(7.0f, 6.0f, 5.0f));
    }

    @Test
    public void containsAllIterable() {
        FloatIterable floatIterable = Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertTrue(floatIterable.containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(floatIterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f)));
        Assert.assertFalse(floatIterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f)));
        Assert.assertFalse(floatIterable.containsAll(FloatArrayList.newListWith(7.0f, 6.0f, 5.0f)));
    }

    @Test
    public void collect() {
        Assert.assertEquals(FastList.newListWith("1.0", "2.0", "3.0"), this.floatIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.floatIterable.toString());
    }

    @Test
    public void makeString() {
        Assert.assertEquals("1.0, 2.0, 3.0", this.floatIterable.makeString());
        Assert.assertEquals("1.0/2.0/3.0", this.floatIterable.makeString("/"));
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.floatIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.floatIterable.appendString(appendable);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.floatIterable.appendString(appendable2, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.floatIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.floatIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.floatIterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.floatIterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), this.floatIterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), this.floatIterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.floatIterable.toSet(), this.floatIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, this.floatIterable.asLazy());
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumConsistentRounding, this.description("sumConsistentRounding"));
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

        private CollectFloatIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectFloatIterableTest();
        }

        @java.lang.Override
        public CollectFloatIterableTest implementation() {
            return this.implementation;
        }
    }
}
