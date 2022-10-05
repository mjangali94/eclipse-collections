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
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LazyByteIterable}.
 * This file was automatically generated from template file abstractLazyPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLazyByteIterableTestCase {

    protected abstract LazyByteIterable classUnderTest();

    protected abstract LazyByteIterable getEmptyIterable();

    protected abstract LazyByteIterable newWith(byte element1, byte element2);

    @Test
    public void byteIterator() {
        long sum = 0L;
        for (ByteIterator iterator = this.classUnderTest().byteIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test(expected = NoSuchElementException.class)
    public void byteIterator_throws() {
        ByteIterator iterator = this.classUnderTest().byteIterator();
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
        Assert.assertEquals(1L, this.classUnderTest().count(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(0L, this.classUnderTest().count(BytePredicates.lessThan((byte) 0)));
        Assert.assertEquals(2L, this.newWith((byte) 0, (byte) 1).count(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(2L, this.newWith((byte) 32, (byte) 33).count(BytePredicates.lessThan((byte) 34)));
        Assert.assertEquals(0L, this.newWith((byte) 32, (byte) 33).count(BytePredicates.lessThan((byte) 0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BytePredicates.greaterThan((byte) 4)));
        Assert.assertTrue(this.newWith((byte) 0, (byte) 1).anySatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(this.newWith((byte) 0, (byte) 1).anySatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 32, (byte) 33).anySatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 32, (byte) 33).anySatisfy(BytePredicates.lessThan((byte) 33)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BytePredicates.lessThan((byte) 4)));
        Assert.assertTrue(this.newWith((byte) 0, (byte) 1).allSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(this.newWith((byte) 0, (byte) 1).allSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertFalse(this.newWith((byte) 0, (byte) 1).allSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 32, (byte) 33).allSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertFalse(this.newWith((byte) 32, (byte) 33).allSatisfy(BytePredicates.lessThan((byte) 33)));
        Assert.assertTrue(this.newWith((byte) 32, (byte) 33).allSatisfy(BytePredicates.lessThan((byte) 34)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BytePredicates.greaterThan((byte) 4)));
        Assert.assertFalse(this.newWith((byte) 0, (byte) 1).noneSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertTrue(this.newWith((byte) 0, (byte) 1).noneSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 32, (byte) 33).noneSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 32, (byte) 33).noneSatisfy(BytePredicates.lessThan((byte) 33)));
    }

    @Test
    public void select() {
        Verify.assertSize(2, this.classUnderTest().select(BytePredicates.greaterThan((byte) 1)));
        Verify.assertEmpty(this.classUnderTest().select(BytePredicates.lessThan((byte) 0)));
        Verify.assertSize(2, this.newWith((byte) 0, (byte) 1).select(BytePredicates.lessThan((byte) 2)));
        Verify.assertEmpty(this.newWith((byte) 32, (byte) 33).select(BytePredicates.lessThan((byte) 2)));
        Verify.assertSize(2, this.newWith((byte) 32, (byte) 33).select(BytePredicates.lessThan((byte) 34)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.classUnderTest().reject(BytePredicates.greaterThan((byte) 1)));
        Verify.assertEmpty(this.classUnderTest().reject(BytePredicates.greaterThan((byte) 0)));
        Verify.assertEmpty(this.newWith((byte) 0, (byte) 1).reject(BytePredicates.lessThan((byte) 2)));
        Verify.assertEmpty(this.newWith((byte) 32, (byte) 33).reject(BytePredicates.lessThan((byte) 34)));
        Verify.assertSize(2, this.newWith((byte) 32, (byte) 33).reject(BytePredicates.lessThan((byte) 2)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.classUnderTest().detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
        Assert.assertEquals(0L, this.classUnderTest().detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
        Assert.assertEquals(0L, this.newWith((byte) 0, (byte) 1).detectIfNone(BytePredicates.lessThan((byte) 2), (byte) 1));
        Assert.assertEquals(33L, this.newWith((byte) 32, (byte) 33).detectIfNone(BytePredicates.equal((byte) 33), (byte) 1));
        Assert.assertEquals(32L, this.newWith((byte) 0, (byte) 1).detectIfNone(BytePredicates.equal((byte) 33), (byte) 32));
        Assert.assertEquals(32L, this.newWith((byte) 34, (byte) 35).detectIfNone(BytePredicates.equal((byte) 33), (byte) 32));
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(3, this.classUnderTest().collect(String::valueOf));
    }

    @Test
    public void tap() {
        StringBuilder tapStringBuilder = new StringBuilder();
        StringBuilder eachStringBuilder = new StringBuilder();
        LazyByteIterable lazy = this.classUnderTest().tap(tapStringBuilder::append);
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
        Assert.assertEquals(1L, this.newWith((byte) 0, (byte) 1).sum());
        Assert.assertEquals(33L, this.newWith((byte) 0, (byte) 33).sum());
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
        Assert.assertEquals((byte) 3, this.classUnderTest().max());
        Assert.assertEquals((byte) 33, this.newWith((byte) 33, (byte) 0).max());
        Assert.assertEquals((byte) 100, this.newWith((byte) 100, (byte) 1).max());
        Assert.assertEquals((byte) 2, this.newWith((byte) 1, (byte) 2).max());
    }

    @Test
    public void min() {
        Assert.assertEquals((byte) 1, this.classUnderTest().min());
        Assert.assertEquals((byte) 0, this.newWith((byte) 33, (byte) 0).min());
        Assert.assertEquals((byte) 1, this.newWith((byte) 100, (byte) 1).min());
        Assert.assertEquals((byte) 1, this.newWith((byte) 2, (byte) 1).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((byte) 5, this.getEmptyIterable().minIfEmpty((byte) 5));
        Assert.assertEquals((byte) 1, this.classUnderTest().minIfEmpty((byte) 0));
        Assert.assertEquals((byte) 0, this.classUnderTest().select(BytePredicates.lessThan((byte) 0)).minIfEmpty((byte) 0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((byte) 5, this.getEmptyIterable().maxIfEmpty((byte) 5));
        Assert.assertEquals((byte) 3, this.classUnderTest().maxIfEmpty((byte) 0));
        Assert.assertEquals((byte) 0, this.classUnderTest().select(BytePredicates.lessThan((byte) 0)).maxIfEmpty((byte) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new LazyByteIterableAdapter(new ByteArrayList()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new LazyByteIterableAdapter(new ByteArrayList()).min();
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
        Assert.assertEquals(16.0d, this.newWith((byte) 1, (byte) 31).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyIterable().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 1 }, this.newWith((byte) 0, (byte) 1).toArray()) || Arrays.equals(new byte[] { (byte) 1, (byte) 0 }, this.newWith((byte) 0, (byte) 1).toArray()));
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 1, (byte) 31 }, this.newWith((byte) 1, (byte) 31).toArray()) || Arrays.equals(new byte[] { (byte) 31, (byte) 1 }, this.newWith((byte) 1, (byte) 31).toArray()));
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 31, (byte) 35 }, this.newWith((byte) 31, (byte) 35).toArray()) || Arrays.equals(new byte[] { (byte) 35, (byte) 31 }, this.newWith((byte) 31, (byte) 35).toArray()));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains((byte) 1));
        Assert.assertTrue(this.classUnderTest().contains((byte) 2));
        Assert.assertTrue(this.classUnderTest().contains((byte) 3));
        Assert.assertFalse(this.classUnderTest().contains((byte) 4));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll((byte) 1));
        Assert.assertTrue(this.classUnderTest().containsAll((byte) 2));
        Assert.assertTrue(this.classUnderTest().containsAll((byte) 1, (byte) 2));
        Assert.assertTrue(this.classUnderTest().containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(this.classUnderTest().containsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertFalse(this.classUnderTest().containsAll((byte) 4, (byte) 5, (byte) 6));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 2)));
        Assert.assertTrue(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2)));
        Assert.assertTrue(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4)));
        Assert.assertFalse(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 4, (byte) 5, (byte) 6)));
    }

    @Test
    public void testToString() {
        LazyByteIterable iterable = this.newWith((byte) 1, (byte) 2);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        LazyByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        LazyByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        LazyByteIterable iterable3 = this.newWith((byte) 32, (byte) 33);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        LazyByteIterable iterable4 = this.newWith((byte) 0, (byte) 1);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        LazyByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        LazyByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        LazyByteIterable iterable3 = this.newWith((byte) 32, (byte) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        LazyByteIterable iterable4 = this.newWith((byte) 1, (byte) 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        LazyByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0, 1") || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0/1]") || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0/1") || iterable5.makeString("/").equals("1/0"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable2 = new StringBuilder();
        LazyByteIterable iterable = this.newWith((byte) 1, (byte) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable7 = new StringBuilder();
        LazyByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LazyByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LazyByteIterable iterable4 = this.newWith((byte) 32, (byte) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LazyByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
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
        LazyByteIterable iterable = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(ByteArrayList.newListWith((byte) 31, (byte) 32).equals(iterable.toList()) || ByteArrayList.newListWith((byte) 32, (byte) 31).equals(iterable.toList()));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new byte[] { 1, 2, 3 }, this.classUnderTest().toSortedArray());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), this.classUnderTest().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), this.classUnderTest().toBag());
    }

    @Test
    public void asLazy() {
        LazyByteIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator, this.description("byteIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::byteIterator_throws, this.description("byteIterator_throws"), java.util.NoSuchElementException.class);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::tap, this.description("tap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollect, this.description("flatCollect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectPrimitives() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lazyCollectPrimitives, this.description("lazyCollectPrimitives"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_throws_emptyIterable, this.description("max_throws_emptyIterable"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_throws_emptyIterable, this.description("min_throws_emptyIterable"), java.util.NoSuchElementException.class);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
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

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractLazyByteIterableTestCase implementation();
    }
}
