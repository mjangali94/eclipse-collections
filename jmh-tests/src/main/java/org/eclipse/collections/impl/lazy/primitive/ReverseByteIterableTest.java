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
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseByteIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseByteIterableTest {

    @Test
    public void isEmpty() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertEmpty(new ByteArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertFalse(iterable.contains((byte) 0));
        Assert.assertTrue(iterable.contains((byte) 1));
    }

    @Test
    public void containsAllArray() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertTrue(iterable.containsAll((byte) 1));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(iterable.containsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4));
    }

    @Test
    public void containsAllIterable() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4)));
    }

    @Test
    public void iterator() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        ByteIterator iterator = iterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        ByteIterator iterator = iterable.byteIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        long[] sum = new long[1];
        iterable.forEach((byte each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertSize(0, new ByteArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 2).asReversed().count(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(ByteArrayList.newListWith((byte) 1, (byte) -1, (byte) 2).asReversed().anySatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(ByteArrayList.newListWith((byte) 1, (byte) -1, (byte) 2).asReversed().anySatisfy(BytePredicates.equal((byte) 0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 2).asReversed().allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3).asReversed().allSatisfy(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 2).asReversed().noneSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3).asReversed().noneSatisfy(BytePredicates.greaterThan((byte) 3)));
    }

    @Test
    public void select() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertSize(3, iterable.select(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(2, iterable.select(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void reject() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertSize(0, iterable.reject(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(1, iterable.reject(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void detectIfNone() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertEquals(1L, iterable.detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
        Assert.assertEquals(0L, iterable.detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
    }

    @Test
    public void collect() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith((byte) 0, (byte) 1, (byte) 2), iterable.collect((byte parameter) -> (byte) (parameter - 1)));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new ByteArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new ByteArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, new ByteArrayList().asReversed().minIfEmpty((byte) 5));
        Assert.assertEquals(0L, new ByteArrayList().asReversed().minIfEmpty((byte) 0));
        Assert.assertEquals(0L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().minIfEmpty((byte) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, new ByteArrayList().asReversed().maxIfEmpty((byte) 5));
        Assert.assertEquals(0L, new ByteArrayList().asReversed().maxIfEmpty((byte) 0));
        Assert.assertEquals(9L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().maxIfEmpty((byte) 5));
    }

    @Test
    public void sum() {
        Assert.assertEquals(10L, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).asReversed().sum());
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 3, (byte) 4, (byte) 2, (byte) 1 }, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 4, (byte) 3).asReversed().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 3, (byte) 7, (byte) 9 }, ByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).asReversed().toSortedArray());
    }

    @Test
    public void testToString() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertEquals("[1, 2, 3]", iterable.toString());
        Assert.assertEquals("[]", new ByteArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertEquals("1, 2, 3", iterable.makeString());
        Assert.assertEquals("1", ByteArrayList.newListWith((byte) 1).makeString("/"));
        Assert.assertEquals("1/2/3", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new ByteArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        StringBuilder appendable = new StringBuilder();
        new ByteArrayList().asReversed().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        iterable.appendString(appendable2);
        Assert.assertEquals("1, 2, 3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertEquals("1/2/3", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 2, (byte) 1), ByteArrayList.newListWith((byte) 1, (byte) 2).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 2, (byte) 3, (byte) 1).asReversed().toSortedList());
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

        private ReverseByteIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ReverseByteIterableTest();
        }

        @java.lang.Override
        public ReverseByteIterableTest implementation() {
            return this.implementation;
        }
    }
}
