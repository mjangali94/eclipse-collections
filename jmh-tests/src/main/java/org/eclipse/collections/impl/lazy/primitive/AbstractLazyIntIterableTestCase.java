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

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LazyIntIterable}.
 * This file was automatically generated from template file abstractLazyPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLazyIntIterableTestCase {

    protected abstract LazyIntIterable classUnderTest();

    protected abstract LazyIntIterable getEmptyIterable();

    protected abstract LazyIntIterable newWith(int element1, int element2);

    @Test
    public void intIterator() {
        long sum = 0L;
        for (IntIterator iterator = this.classUnderTest().intIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test(expected = NoSuchElementException.class)
    public void intIterator_throws() {
        IntIterator iterator = this.classUnderTest().intIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.classUnderTest().forEach(each -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size() {
        Verify.assertSize(3, this.classUnderTest());
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyIterable());
        Verify.assertNotEmpty(this.classUnderTest());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyIterable().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
    }

    @Test
    public void count() {
        Assert.assertEquals(1L, this.classUnderTest().count(IntPredicates.lessThan(2)));
        Assert.assertEquals(0L, this.classUnderTest().count(IntPredicates.lessThan(0)));
        Assert.assertEquals(2L, this.newWith(0, 1).count(IntPredicates.lessThan(2)));
        Assert.assertEquals(2L, this.newWith(32, 33).count(IntPredicates.lessThan(34)));
        Assert.assertEquals(0L, this.newWith(32, 33).count(IntPredicates.lessThan(0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(IntPredicates.greaterThan(4)));
        Assert.assertTrue(this.newWith(0, 1).anySatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.newWith(0, 1).anySatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(this.newWith(32, 33).anySatisfy(IntPredicates.lessThan(0)));
        Assert.assertTrue(this.newWith(32, 33).anySatisfy(IntPredicates.lessThan(33)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(IntPredicates.lessThan(1)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(IntPredicates.lessThan(4)));
        Assert.assertTrue(this.newWith(0, 1).allSatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.newWith(0, 1).allSatisfy(IntPredicates.lessThan(1)));
        Assert.assertFalse(this.newWith(0, 1).allSatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(this.newWith(32, 33).allSatisfy(IntPredicates.lessThan(1)));
        Assert.assertFalse(this.newWith(32, 33).allSatisfy(IntPredicates.lessThan(33)));
        Assert.assertTrue(this.newWith(32, 33).allSatisfy(IntPredicates.lessThan(34)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(IntPredicates.lessThan(2)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(IntPredicates.lessThan(1)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(IntPredicates.greaterThan(4)));
        Assert.assertFalse(this.newWith(0, 1).noneSatisfy(IntPredicates.lessThan(2)));
        Assert.assertTrue(this.newWith(0, 1).noneSatisfy(IntPredicates.lessThan(0)));
        Assert.assertTrue(this.newWith(32, 33).noneSatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(this.newWith(32, 33).noneSatisfy(IntPredicates.lessThan(33)));
    }

    @Test
    public void select() {
        Verify.assertSize(2, this.classUnderTest().select(IntPredicates.greaterThan(1)));
        Verify.assertEmpty(this.classUnderTest().select(IntPredicates.lessThan(0)));
        Verify.assertSize(2, this.newWith(0, 1).select(IntPredicates.lessThan(2)));
        Verify.assertEmpty(this.newWith(32, 33).select(IntPredicates.lessThan(2)));
        Verify.assertSize(2, this.newWith(32, 33).select(IntPredicates.lessThan(34)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.classUnderTest().reject(IntPredicates.greaterThan(1)));
        Verify.assertEmpty(this.classUnderTest().reject(IntPredicates.greaterThan(0)));
        Verify.assertEmpty(this.newWith(0, 1).reject(IntPredicates.lessThan(2)));
        Verify.assertEmpty(this.newWith(32, 33).reject(IntPredicates.lessThan(34)));
        Verify.assertSize(2, this.newWith(32, 33).reject(IntPredicates.lessThan(2)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.classUnderTest().detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(0L, this.classUnderTest().detectIfNone(IntPredicates.greaterThan(3), 0));
        Assert.assertEquals(0L, this.newWith(0, 1).detectIfNone(IntPredicates.lessThan(2), 1));
        Assert.assertEquals(33L, this.newWith(32, 33).detectIfNone(IntPredicates.equal(33), 1));
        Assert.assertEquals(32L, this.newWith(0, 1).detectIfNone(IntPredicates.equal(33), 32));
        Assert.assertEquals(32L, this.newWith(34, 35).detectIfNone(IntPredicates.equal(33), 32));
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(3, this.classUnderTest().collect(String::valueOf));
    }

    @Test
    public void tap() {
        StringBuilder tapStringBuilder = new StringBuilder();
        StringBuilder eachStringBuilder = new StringBuilder();
        LazyIntIterable lazy = this.classUnderTest().tap(tapStringBuilder::append);
        Assert.assertEquals(lazy.makeString(""), tapStringBuilder.toString());
        lazy.tap(eachStringBuilder::append).forEach(eachStringBuilder::append);
        Assert.assertEquals(CharAdapter.adapt(eachStringBuilder.toString()).toBag(), CharAdapter.adapt(tapStringBuilder.toString()).toBag());
    }

    @Test
    public void flatCollect() {
        Verify.assertIterableSize(3, this.classUnderTest().flatCollect(Lists.mutable::with));
    }

    @Test
    public void lazyCollectPrimitives() {
        Assert.assertEquals(BooleanLists.immutable.of(false, true, false), this.classUnderTest().collectBoolean(e -> e % 2 == 0).toList());
        Assert.assertEquals(CharLists.immutable.of((char) 2, (char) 3, (char) 4), this.classUnderTest().asLazy().collectChar(e -> (char) (e + 1)).toList());
        Assert.assertEquals(ByteLists.immutable.of((byte) 2, (byte) 3, (byte) 4), this.classUnderTest().asLazy().collectByte(e -> (byte) (e + 1)).toList());
        Assert.assertEquals(ShortLists.immutable.of((short) 2, (short) 3, (short) 4), this.classUnderTest().asLazy().collectShort(e -> (short) (e + 1)).toList());
        Assert.assertEquals(IntLists.immutable.of(2, 3, 4), this.classUnderTest().asLazy().collectInt(e -> (int) (e + 1)).toList());
        Assert.assertEquals(FloatLists.immutable.of(2.0f, 3.0f, 4.0f), this.classUnderTest().asLazy().collectFloat(e -> (float) (e + 1)).toList());
        Assert.assertEquals(LongLists.immutable.of(2L, 3L, 4L), this.classUnderTest().asLazy().collectLong(e -> (long) (e + 1)).toList());
        Assert.assertEquals(DoubleLists.immutable.of(2.0, 3.0, 4.0), this.classUnderTest().asLazy().collectDouble(e -> (double) (e + 1)).toList());
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, this.classUnderTest().sum());
        Assert.assertEquals(1L, this.newWith(0, 1).sum());
        Assert.assertEquals(33L, this.newWith(0, 33).sum());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyIterable() {
        this.getEmptyIterable().max();
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyIterable() {
        this.getEmptyIterable().min();
    }

    @Test
    public void max() {
        Assert.assertEquals(3, this.classUnderTest().max());
        Assert.assertEquals(33, this.newWith(33, 0).max());
        Assert.assertEquals(100, this.newWith(100, 1).max());
        Assert.assertEquals(2, this.newWith(1, 2).max());
    }

    @Test
    public void min() {
        Assert.assertEquals(1, this.classUnderTest().min());
        Assert.assertEquals(0, this.newWith(33, 0).min());
        Assert.assertEquals(1, this.newWith(100, 1).min());
        Assert.assertEquals(1, this.newWith(2, 1).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5, this.getEmptyIterable().minIfEmpty(5));
        Assert.assertEquals(1, this.classUnderTest().minIfEmpty(0));
        Assert.assertEquals(0, this.classUnderTest().select(IntPredicates.lessThan(0)).minIfEmpty(0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5, this.getEmptyIterable().maxIfEmpty(5));
        Assert.assertEquals(3, this.classUnderTest().maxIfEmpty(0));
        Assert.assertEquals(0, this.classUnderTest().select(IntPredicates.lessThan(0)).maxIfEmpty(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new LazyIntIterableAdapter(new IntArrayList()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new LazyIntIterableAdapter(new IntArrayList()).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(2.0d, this.classUnderTest().average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyIterable().average();
    }

    @Test
    public void median() {
        Assert.assertEquals(2.0d, this.classUnderTest().median(), 0.0);
        Assert.assertEquals(16.0d, this.newWith(1, 31).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyIterable().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new int[] { 0, 1 }, this.newWith(0, 1).toArray()) || Arrays.equals(new int[] { 1, 0 }, this.newWith(0, 1).toArray()));
        Assert.assertTrue(Arrays.equals(new int[] { 1, 31 }, this.newWith(1, 31).toArray()) || Arrays.equals(new int[] { 31, 1 }, this.newWith(1, 31).toArray()));
        Assert.assertTrue(Arrays.equals(new int[] { 31, 35 }, this.newWith(31, 35).toArray()) || Arrays.equals(new int[] { 35, 31 }, this.newWith(31, 35).toArray()));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(1));
        Assert.assertTrue(this.classUnderTest().contains(2));
        Assert.assertTrue(this.classUnderTest().contains(3));
        Assert.assertFalse(this.classUnderTest().contains(4));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(1));
        Assert.assertTrue(this.classUnderTest().containsAll(2));
        Assert.assertTrue(this.classUnderTest().containsAll(1, 2));
        Assert.assertTrue(this.classUnderTest().containsAll(1, 2, 3));
        Assert.assertFalse(this.classUnderTest().containsAll(1, 2, 3, 4));
        Assert.assertFalse(this.classUnderTest().containsAll(4, 5, 6));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(this.classUnderTest().containsAll(IntArrayList.newListWith(2)));
        Assert.assertTrue(this.classUnderTest().containsAll(IntArrayList.newListWith(1, 2)));
        Assert.assertTrue(this.classUnderTest().containsAll(IntArrayList.newListWith(1, 2, 3)));
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(1, 2, 3, 4)));
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(4, 5, 6)));
    }

    @Test
    public void testToString() {
        LazyIntIterable iterable = this.newWith(1, 2);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        LazyIntIterable iterable1 = this.newWith(0, 31);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        LazyIntIterable iterable2 = this.newWith(31, 32);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        LazyIntIterable iterable3 = this.newWith(32, 33);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        LazyIntIterable iterable4 = this.newWith(0, 1);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        LazyIntIterable iterable1 = this.newWith(0, 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        LazyIntIterable iterable2 = this.newWith(31, 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        LazyIntIterable iterable3 = this.newWith(32, 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        LazyIntIterable iterable4 = this.newWith(1, 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        LazyIntIterable iterable5 = this.newWith(0, 1);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0, 1") || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0/1]") || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0/1") || iterable5.makeString("/").equals("1/0"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable2 = new StringBuilder();
        LazyIntIterable iterable = this.newWith(1, 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable7 = new StringBuilder();
        LazyIntIterable iterable1 = this.newWith(0, 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LazyIntIterable iterable2 = this.newWith(31, 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LazyIntIterable iterable4 = this.newWith(32, 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LazyIntIterable iterable5 = this.newWith(0, 1);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0, 1".equals(appendable10.toString()) || "1, 0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0/1".equals(appendable11.toString()) || "1/0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0/1]".equals(appendable12.toString()) || "[1/0]".equals(appendable12.toString()));
    }

    @Test
    public void toList() {
        LazyIntIterable iterable = this.newWith(31, 32);
        Assert.assertTrue(IntArrayList.newListWith(31, 32).equals(iterable.toList()) || IntArrayList.newListWith(32, 31).equals(iterable.toList()));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new int[] { 1, 2, 3 }, this.classUnderTest().toSortedArray());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), this.classUnderTest().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), this.classUnderTest().toBag());
    }

    @Test
    public void asLazy() {
        LazyIntIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLazyIntIterableTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectPrimitives() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyCollectPrimitives);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLazyIntIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyIntIterableTestCase> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.intIterator = AbstractLazyIntIterableTestCase::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyIntIterableTestCase::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractLazyIntIterableTestCase::forEach;
            this.payloads.size = AbstractLazyIntIterableTestCase::size;
            this.payloads.isEmpty = AbstractLazyIntIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLazyIntIterableTestCase::notEmpty;
            this.payloads.count = AbstractLazyIntIterableTestCase::count;
            this.payloads.anySatisfy = AbstractLazyIntIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLazyIntIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLazyIntIterableTestCase::noneSatisfy;
            this.payloads.select = AbstractLazyIntIterableTestCase::select;
            this.payloads.reject = AbstractLazyIntIterableTestCase::reject;
            this.payloads.detectIfNone = AbstractLazyIntIterableTestCase::detectIfNone;
            this.payloads.collect = AbstractLazyIntIterableTestCase::collect;
            this.payloads.tap = AbstractLazyIntIterableTestCase::tap;
            this.payloads.flatCollect = AbstractLazyIntIterableTestCase::flatCollect;
            this.payloads.lazyCollectPrimitives = AbstractLazyIntIterableTestCase::lazyCollectPrimitives;
            this.payloads.sum = AbstractLazyIntIterableTestCase::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyIntIterableTestCase::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyIntIterableTestCase::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = AbstractLazyIntIterableTestCase::max;
            this.payloads.min = AbstractLazyIntIterableTestCase::min;
            this.payloads.minIfEmpty = AbstractLazyIntIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLazyIntIterableTestCase::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyIntIterableTestCase::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyIntIterableTestCase::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = AbstractLazyIntIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyIntIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractLazyIntIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyIntIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractLazyIntIterableTestCase::toArray;
            this.payloads.contains = AbstractLazyIntIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractLazyIntIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractLazyIntIterableTestCase::containsAllIterable;
            this.payloads.testToString = AbstractLazyIntIterableTestCase::testToString;
            this.payloads.makeString = AbstractLazyIntIterableTestCase::makeString;
            this.payloads.appendString = AbstractLazyIntIterableTestCase::appendString;
            this.payloads.toList = AbstractLazyIntIterableTestCase::toList;
            this.payloads.toSortedArray = AbstractLazyIntIterableTestCase::toSortedArray;
            this.payloads.toSortedList = AbstractLazyIntIterableTestCase::toSortedList;
            this.payloads.toSet = AbstractLazyIntIterableTestCase::toSet;
            this.payloads.toBag = AbstractLazyIntIterableTestCase::toBag;
            this.payloads.asLazy = AbstractLazyIntIterableTestCase::asLazy;
        }
    }
}
