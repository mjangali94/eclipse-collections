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
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LazyLongIterable}.
 * This file was automatically generated from template file abstractLazyPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLazyLongIterableTestCase {

    protected abstract LazyLongIterable classUnderTest();

    protected abstract LazyLongIterable getEmptyIterable();

    protected abstract LazyLongIterable newWith(long element1, long element2);

    @Test
    public void longIterator() {
        long sum = 0L;
        for (LongIterator iterator = this.classUnderTest().longIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test(expected = NoSuchElementException.class)
    public void longIterator_throws() {
        LongIterator iterator = this.classUnderTest().longIterator();
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
        Assert.assertEquals(1L, this.classUnderTest().count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(0L, this.classUnderTest().count(LongPredicates.lessThan(0L)));
        Assert.assertEquals(2L, this.newWith(0L, 1L).count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(2L, this.newWith(32L, 33L).count(LongPredicates.lessThan(34L)));
        Assert.assertEquals(0L, this.newWith(32L, 33L).count(LongPredicates.lessThan(0L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(LongPredicates.greaterThan(4L)));
        Assert.assertTrue(this.newWith(0L, 1L).anySatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.newWith(0L, 1L).anySatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.newWith(32L, 33L).anySatisfy(LongPredicates.lessThan(0L)));
        Assert.assertTrue(this.newWith(32L, 33L).anySatisfy(LongPredicates.lessThan(33L)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(LongPredicates.lessThan(4L)));
        Assert.assertTrue(this.newWith(0L, 1L).allSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.newWith(0L, 1L).allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertFalse(this.newWith(0L, 1L).allSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.newWith(32L, 33L).allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertFalse(this.newWith(32L, 33L).allSatisfy(LongPredicates.lessThan(33L)));
        Assert.assertTrue(this.newWith(32L, 33L).allSatisfy(LongPredicates.lessThan(34L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(LongPredicates.greaterThan(4L)));
        Assert.assertFalse(this.newWith(0L, 1L).noneSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(this.newWith(0L, 1L).noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertTrue(this.newWith(32L, 33L).noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.newWith(32L, 33L).noneSatisfy(LongPredicates.lessThan(33L)));
    }

    @Test
    public void select() {
        Verify.assertSize(2, this.classUnderTest().select(LongPredicates.greaterThan(1L)));
        Verify.assertEmpty(this.classUnderTest().select(LongPredicates.lessThan(0L)));
        Verify.assertSize(2, this.newWith(0L, 1L).select(LongPredicates.lessThan(2L)));
        Verify.assertEmpty(this.newWith(32L, 33L).select(LongPredicates.lessThan(2L)));
        Verify.assertSize(2, this.newWith(32L, 33L).select(LongPredicates.lessThan(34L)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.classUnderTest().reject(LongPredicates.greaterThan(1L)));
        Verify.assertEmpty(this.classUnderTest().reject(LongPredicates.greaterThan(0L)));
        Verify.assertEmpty(this.newWith(0L, 1L).reject(LongPredicates.lessThan(2L)));
        Verify.assertEmpty(this.newWith(32L, 33L).reject(LongPredicates.lessThan(34L)));
        Verify.assertSize(2, this.newWith(32L, 33L).reject(LongPredicates.lessThan(2L)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.classUnderTest().detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(0L, this.classUnderTest().detectIfNone(LongPredicates.greaterThan(3L), 0L));
        Assert.assertEquals(0L, this.newWith(0L, 1L).detectIfNone(LongPredicates.lessThan(2L), 1L));
        Assert.assertEquals(33L, this.newWith(32L, 33L).detectIfNone(LongPredicates.equal(33L), 1L));
        Assert.assertEquals(32L, this.newWith(0L, 1L).detectIfNone(LongPredicates.equal(33L), 32L));
        Assert.assertEquals(32L, this.newWith(34L, 35L).detectIfNone(LongPredicates.equal(33L), 32L));
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(3, this.classUnderTest().collect(String::valueOf));
    }

    @Test
    public void tap() {
        StringBuilder tapStringBuilder = new StringBuilder();
        StringBuilder eachStringBuilder = new StringBuilder();
        LazyLongIterable lazy = this.classUnderTest().tap(tapStringBuilder::append);
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
        Assert.assertEquals(1L, this.newWith(0L, 1L).sum());
        Assert.assertEquals(33L, this.newWith(0L, 33L).sum());
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
        Assert.assertEquals(3L, this.classUnderTest().max());
        Assert.assertEquals(33L, this.newWith(33L, 0L).max());
        Assert.assertEquals(100L, this.newWith(100L, 1L).max());
        Assert.assertEquals(2L, this.newWith(1L, 2L).max());
    }

    @Test
    public void min() {
        Assert.assertEquals(1L, this.classUnderTest().min());
        Assert.assertEquals(0L, this.newWith(33L, 0L).min());
        Assert.assertEquals(1L, this.newWith(100L, 1L).min());
        Assert.assertEquals(1L, this.newWith(2L, 1L).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyIterable().minIfEmpty(5L));
        Assert.assertEquals(1L, this.classUnderTest().minIfEmpty(0L));
        Assert.assertEquals(0L, this.classUnderTest().select(LongPredicates.lessThan(0L)).minIfEmpty(0L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyIterable().maxIfEmpty(5L));
        Assert.assertEquals(3L, this.classUnderTest().maxIfEmpty(0L));
        Assert.assertEquals(0L, this.classUnderTest().select(LongPredicates.lessThan(0L)).maxIfEmpty(0L));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new LazyLongIterableAdapter(new LongArrayList()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new LazyLongIterableAdapter(new LongArrayList()).min();
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
        Assert.assertEquals(16.0d, this.newWith(1L, 31L).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyIterable().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new long[] { 0L, 1L }, this.newWith(0L, 1L).toArray()) || Arrays.equals(new long[] { 1L, 0L }, this.newWith(0L, 1L).toArray()));
        Assert.assertTrue(Arrays.equals(new long[] { 1L, 31L }, this.newWith(1L, 31L).toArray()) || Arrays.equals(new long[] { 31L, 1L }, this.newWith(1L, 31L).toArray()));
        Assert.assertTrue(Arrays.equals(new long[] { 31L, 35L }, this.newWith(31L, 35L).toArray()) || Arrays.equals(new long[] { 35L, 31L }, this.newWith(31L, 35L).toArray()));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(1L));
        Assert.assertTrue(this.classUnderTest().contains(2L));
        Assert.assertTrue(this.classUnderTest().contains(3L));
        Assert.assertFalse(this.classUnderTest().contains(4L));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(1L));
        Assert.assertTrue(this.classUnderTest().containsAll(2L));
        Assert.assertTrue(this.classUnderTest().containsAll(1L, 2L));
        Assert.assertTrue(this.classUnderTest().containsAll(1L, 2L, 3L));
        Assert.assertFalse(this.classUnderTest().containsAll(1L, 2L, 3L, 4L));
        Assert.assertFalse(this.classUnderTest().containsAll(4L, 5L, 6L));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(this.classUnderTest().containsAll(LongArrayList.newListWith(2L)));
        Assert.assertTrue(this.classUnderTest().containsAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertTrue(this.classUnderTest().containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(this.classUnderTest().containsAll(LongArrayList.newListWith(1L, 2L, 3L, 4L)));
        Assert.assertFalse(this.classUnderTest().containsAll(LongArrayList.newListWith(4L, 5L, 6L)));
    }

    @Test
    public void testToString() {
        LazyLongIterable iterable = this.newWith(1L, 2L);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        LazyLongIterable iterable1 = this.newWith(0L, 31L);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        LazyLongIterable iterable2 = this.newWith(31L, 32L);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        LazyLongIterable iterable3 = this.newWith(32L, 33L);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        LazyLongIterable iterable4 = this.newWith(0L, 1L);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        LazyLongIterable iterable1 = this.newWith(0L, 31L);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        LazyLongIterable iterable2 = this.newWith(31L, 32L);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        LazyLongIterable iterable3 = this.newWith(32L, 33L);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        LazyLongIterable iterable4 = this.newWith(1L, 2L);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        LazyLongIterable iterable5 = this.newWith(0L, 1L);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0, 1") || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0/1]") || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0/1") || iterable5.makeString("/").equals("1/0"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable2 = new StringBuilder();
        LazyLongIterable iterable = this.newWith(1L, 2L);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable7 = new StringBuilder();
        LazyLongIterable iterable1 = this.newWith(0L, 31L);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LazyLongIterable iterable2 = this.newWith(31L, 32L);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LazyLongIterable iterable4 = this.newWith(32L, 33L);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LazyLongIterable iterable5 = this.newWith(0L, 1L);
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
        LazyLongIterable iterable = this.newWith(31L, 32L);
        Assert.assertTrue(LongArrayList.newListWith(31L, 32L).equals(iterable.toList()) || LongArrayList.newListWith(32L, 31L).equals(iterable.toList()));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new long[] { 1, 2, 3 }, this.classUnderTest().toSortedArray());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), this.classUnderTest().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), this.classUnderTest().toBag());
    }

    @Test
    public void asLazy() {
        LazyLongIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLazyLongIterableTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectPrimitives() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyCollectPrimitives);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLazyLongIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyLongIterableTestCase> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.longIterator = AbstractLazyLongIterableTestCase::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyLongIterableTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractLazyLongIterableTestCase::forEach;
            this.payloads.size = AbstractLazyLongIterableTestCase::size;
            this.payloads.isEmpty = AbstractLazyLongIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLazyLongIterableTestCase::notEmpty;
            this.payloads.count = AbstractLazyLongIterableTestCase::count;
            this.payloads.anySatisfy = AbstractLazyLongIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLazyLongIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLazyLongIterableTestCase::noneSatisfy;
            this.payloads.select = AbstractLazyLongIterableTestCase::select;
            this.payloads.reject = AbstractLazyLongIterableTestCase::reject;
            this.payloads.detectIfNone = AbstractLazyLongIterableTestCase::detectIfNone;
            this.payloads.collect = AbstractLazyLongIterableTestCase::collect;
            this.payloads.tap = AbstractLazyLongIterableTestCase::tap;
            this.payloads.flatCollect = AbstractLazyLongIterableTestCase::flatCollect;
            this.payloads.lazyCollectPrimitives = AbstractLazyLongIterableTestCase::lazyCollectPrimitives;
            this.payloads.sum = AbstractLazyLongIterableTestCase::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyLongIterableTestCase::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyLongIterableTestCase::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = AbstractLazyLongIterableTestCase::max;
            this.payloads.min = AbstractLazyLongIterableTestCase::min;
            this.payloads.minIfEmpty = AbstractLazyLongIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLazyLongIterableTestCase::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyLongIterableTestCase::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyLongIterableTestCase::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = AbstractLazyLongIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyLongIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractLazyLongIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyLongIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractLazyLongIterableTestCase::toArray;
            this.payloads.contains = AbstractLazyLongIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractLazyLongIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractLazyLongIterableTestCase::containsAllIterable;
            this.payloads.testToString = AbstractLazyLongIterableTestCase::testToString;
            this.payloads.makeString = AbstractLazyLongIterableTestCase::makeString;
            this.payloads.appendString = AbstractLazyLongIterableTestCase::appendString;
            this.payloads.toList = AbstractLazyLongIterableTestCase::toList;
            this.payloads.toSortedArray = AbstractLazyLongIterableTestCase::toSortedArray;
            this.payloads.toSortedList = AbstractLazyLongIterableTestCase::toSortedList;
            this.payloads.toSet = AbstractLazyLongIterableTestCase::toSet;
            this.payloads.toBag = AbstractLazyLongIterableTestCase::toBag;
            this.payloads.asLazy = AbstractLazyLongIterableTestCase::asLazy;
        }
    }
}
