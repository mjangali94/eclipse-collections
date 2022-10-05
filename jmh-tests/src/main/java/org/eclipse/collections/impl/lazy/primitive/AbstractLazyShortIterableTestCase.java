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
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LazyShortIterable}.
 * This file was automatically generated from template file abstractLazyPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLazyShortIterableTestCase {

    protected abstract LazyShortIterable classUnderTest();

    protected abstract LazyShortIterable getEmptyIterable();

    protected abstract LazyShortIterable newWith(short element1, short element2);

    @Test
    public void shortIterator() {
        long sum = 0L;
        for (ShortIterator iterator = this.classUnderTest().shortIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test(expected = NoSuchElementException.class)
    public void shortIterator_throws() {
        ShortIterator iterator = this.classUnderTest().shortIterator();
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
        Assert.assertEquals(1L, this.classUnderTest().count(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(0L, this.classUnderTest().count(ShortPredicates.lessThan((short) 0)));
        Assert.assertEquals(2L, this.newWith((short) 0, (short) 1).count(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(2L, this.newWith((short) 32, (short) 33).count(ShortPredicates.lessThan((short) 34)));
        Assert.assertEquals(0L, this.newWith((short) 32, (short) 33).count(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(ShortPredicates.greaterThan((short) 4)));
        Assert.assertTrue(this.newWith((short) 0, (short) 1).anySatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.newWith((short) 0, (short) 1).anySatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 32, (short) 33).anySatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertTrue(this.newWith((short) 32, (short) 33).anySatisfy(ShortPredicates.lessThan((short) 33)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(ShortPredicates.lessThan((short) 4)));
        Assert.assertTrue(this.newWith((short) 0, (short) 1).allSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.newWith((short) 0, (short) 1).allSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertFalse(this.newWith((short) 0, (short) 1).allSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 32, (short) 33).allSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertFalse(this.newWith((short) 32, (short) 33).allSatisfy(ShortPredicates.lessThan((short) 33)));
        Assert.assertTrue(this.newWith((short) 32, (short) 33).allSatisfy(ShortPredicates.lessThan((short) 34)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(ShortPredicates.greaterThan((short) 4)));
        Assert.assertFalse(this.newWith((short) 0, (short) 1).noneSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertTrue(this.newWith((short) 0, (short) 1).noneSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertTrue(this.newWith((short) 32, (short) 33).noneSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 32, (short) 33).noneSatisfy(ShortPredicates.lessThan((short) 33)));
    }

    @Test
    public void select() {
        Verify.assertSize(2, this.classUnderTest().select(ShortPredicates.greaterThan((short) 1)));
        Verify.assertEmpty(this.classUnderTest().select(ShortPredicates.lessThan((short) 0)));
        Verify.assertSize(2, this.newWith((short) 0, (short) 1).select(ShortPredicates.lessThan((short) 2)));
        Verify.assertEmpty(this.newWith((short) 32, (short) 33).select(ShortPredicates.lessThan((short) 2)));
        Verify.assertSize(2, this.newWith((short) 32, (short) 33).select(ShortPredicates.lessThan((short) 34)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.classUnderTest().reject(ShortPredicates.greaterThan((short) 1)));
        Verify.assertEmpty(this.classUnderTest().reject(ShortPredicates.greaterThan((short) 0)));
        Verify.assertEmpty(this.newWith((short) 0, (short) 1).reject(ShortPredicates.lessThan((short) 2)));
        Verify.assertEmpty(this.newWith((short) 32, (short) 33).reject(ShortPredicates.lessThan((short) 34)));
        Verify.assertSize(2, this.newWith((short) 32, (short) 33).reject(ShortPredicates.lessThan((short) 2)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.classUnderTest().detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals(0L, this.classUnderTest().detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
        Assert.assertEquals(0L, this.newWith((short) 0, (short) 1).detectIfNone(ShortPredicates.lessThan((short) 2), (short) 1));
        Assert.assertEquals(33L, this.newWith((short) 32, (short) 33).detectIfNone(ShortPredicates.equal((short) 33), (short) 1));
        Assert.assertEquals(32L, this.newWith((short) 0, (short) 1).detectIfNone(ShortPredicates.equal((short) 33), (short) 32));
        Assert.assertEquals(32L, this.newWith((short) 34, (short) 35).detectIfNone(ShortPredicates.equal((short) 33), (short) 32));
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(3, this.classUnderTest().collect(String::valueOf));
    }

    @Test
    public void tap() {
        StringBuilder tapStringBuilder = new StringBuilder();
        StringBuilder eachStringBuilder = new StringBuilder();
        LazyShortIterable lazy = this.classUnderTest().tap(tapStringBuilder::append);
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
        Assert.assertEquals(1L, this.newWith((short) 0, (short) 1).sum());
        Assert.assertEquals(33L, this.newWith((short) 0, (short) 33).sum());
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
        Assert.assertEquals((short) 3, this.classUnderTest().max());
        Assert.assertEquals((short) 33, this.newWith((short) 33, (short) 0).max());
        Assert.assertEquals((short) 100, this.newWith((short) 100, (short) 1).max());
        Assert.assertEquals((short) 2, this.newWith((short) 1, (short) 2).max());
    }

    @Test
    public void min() {
        Assert.assertEquals((short) 1, this.classUnderTest().min());
        Assert.assertEquals((short) 0, this.newWith((short) 33, (short) 0).min());
        Assert.assertEquals((short) 1, this.newWith((short) 100, (short) 1).min());
        Assert.assertEquals((short) 1, this.newWith((short) 2, (short) 1).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((short) 5, this.getEmptyIterable().minIfEmpty((short) 5));
        Assert.assertEquals((short) 1, this.classUnderTest().minIfEmpty((short) 0));
        Assert.assertEquals((short) 0, this.classUnderTest().select(ShortPredicates.lessThan((short) 0)).minIfEmpty((short) 0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((short) 5, this.getEmptyIterable().maxIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.classUnderTest().maxIfEmpty((short) 0));
        Assert.assertEquals((short) 0, this.classUnderTest().select(ShortPredicates.lessThan((short) 0)).maxIfEmpty((short) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new LazyShortIterableAdapter(new ShortArrayList()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new LazyShortIterableAdapter(new ShortArrayList()).min();
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
        Assert.assertEquals(16.0d, this.newWith((short) 1, (short) 31).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyIterable().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new short[] { (short) 0, (short) 1 }, this.newWith((short) 0, (short) 1).toArray()) || Arrays.equals(new short[] { (short) 1, (short) 0 }, this.newWith((short) 0, (short) 1).toArray()));
        Assert.assertTrue(Arrays.equals(new short[] { (short) 1, (short) 31 }, this.newWith((short) 1, (short) 31).toArray()) || Arrays.equals(new short[] { (short) 31, (short) 1 }, this.newWith((short) 1, (short) 31).toArray()));
        Assert.assertTrue(Arrays.equals(new short[] { (short) 31, (short) 35 }, this.newWith((short) 31, (short) 35).toArray()) || Arrays.equals(new short[] { (short) 35, (short) 31 }, this.newWith((short) 31, (short) 35).toArray()));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains((short) 1));
        Assert.assertTrue(this.classUnderTest().contains((short) 2));
        Assert.assertTrue(this.classUnderTest().contains((short) 3));
        Assert.assertFalse(this.classUnderTest().contains((short) 4));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll((short) 1));
        Assert.assertTrue(this.classUnderTest().containsAll((short) 2));
        Assert.assertTrue(this.classUnderTest().containsAll((short) 1, (short) 2));
        Assert.assertTrue(this.classUnderTest().containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertFalse(this.classUnderTest().containsAll((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertFalse(this.classUnderTest().containsAll((short) 4, (short) 5, (short) 6));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 2)));
        Assert.assertTrue(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 1, (short) 2)));
        Assert.assertTrue(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4)));
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 4, (short) 5, (short) 6)));
    }

    @Test
    public void testToString() {
        LazyShortIterable iterable = this.newWith((short) 1, (short) 2);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        LazyShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        LazyShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        LazyShortIterable iterable3 = this.newWith((short) 32, (short) 33);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        LazyShortIterable iterable4 = this.newWith((short) 0, (short) 1);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        LazyShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        LazyShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        LazyShortIterable iterable3 = this.newWith((short) 32, (short) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        LazyShortIterable iterable4 = this.newWith((short) 1, (short) 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        LazyShortIterable iterable5 = this.newWith((short) 0, (short) 1);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0, 1") || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0/1]") || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0/1") || iterable5.makeString("/").equals("1/0"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable2 = new StringBuilder();
        LazyShortIterable iterable = this.newWith((short) 1, (short) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable7 = new StringBuilder();
        LazyShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LazyShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LazyShortIterable iterable4 = this.newWith((short) 32, (short) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LazyShortIterable iterable5 = this.newWith((short) 0, (short) 1);
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
        LazyShortIterable iterable = this.newWith((short) 31, (short) 32);
        Assert.assertTrue(ShortArrayList.newListWith((short) 31, (short) 32).equals(iterable.toList()) || ShortArrayList.newListWith((short) 32, (short) 31).equals(iterable.toList()));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new short[] { 1, 2, 3 }, this.classUnderTest().toSortedArray());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toBag());
    }

    @Test
    public void asLazy() {
        LazyShortIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLazyShortIterableTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLazyShortIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyShortIterableTestCase> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.shortIterator = AbstractLazyShortIterableTestCase::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyShortIterableTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractLazyShortIterableTestCase::forEach;
            this.payloads.size = AbstractLazyShortIterableTestCase::size;
            this.payloads.isEmpty = AbstractLazyShortIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLazyShortIterableTestCase::notEmpty;
            this.payloads.count = AbstractLazyShortIterableTestCase::count;
            this.payloads.anySatisfy = AbstractLazyShortIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLazyShortIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLazyShortIterableTestCase::noneSatisfy;
            this.payloads.select = AbstractLazyShortIterableTestCase::select;
            this.payloads.reject = AbstractLazyShortIterableTestCase::reject;
            this.payloads.detectIfNone = AbstractLazyShortIterableTestCase::detectIfNone;
            this.payloads.collect = AbstractLazyShortIterableTestCase::collect;
            this.payloads.tap = AbstractLazyShortIterableTestCase::tap;
            this.payloads.flatCollect = AbstractLazyShortIterableTestCase::flatCollect;
            this.payloads.lazyCollectPrimitives = AbstractLazyShortIterableTestCase::lazyCollectPrimitives;
            this.payloads.sum = AbstractLazyShortIterableTestCase::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyShortIterableTestCase::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyShortIterableTestCase::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = AbstractLazyShortIterableTestCase::max;
            this.payloads.min = AbstractLazyShortIterableTestCase::min;
            this.payloads.minIfEmpty = AbstractLazyShortIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLazyShortIterableTestCase::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyShortIterableTestCase::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyShortIterableTestCase::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = AbstractLazyShortIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyShortIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractLazyShortIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyShortIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractLazyShortIterableTestCase::toArray;
            this.payloads.contains = AbstractLazyShortIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractLazyShortIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractLazyShortIterableTestCase::containsAllIterable;
            this.payloads.testToString = AbstractLazyShortIterableTestCase::testToString;
            this.payloads.makeString = AbstractLazyShortIterableTestCase::makeString;
            this.payloads.appendString = AbstractLazyShortIterableTestCase::appendString;
            this.payloads.toList = AbstractLazyShortIterableTestCase::toList;
            this.payloads.toSortedArray = AbstractLazyShortIterableTestCase::toSortedArray;
            this.payloads.toSortedList = AbstractLazyShortIterableTestCase::toSortedList;
            this.payloads.toSet = AbstractLazyShortIterableTestCase::toSet;
            this.payloads.toBag = AbstractLazyShortIterableTestCase::toBag;
            this.payloads.asLazy = AbstractLazyShortIterableTestCase::asLazy;
        }
    }
}
