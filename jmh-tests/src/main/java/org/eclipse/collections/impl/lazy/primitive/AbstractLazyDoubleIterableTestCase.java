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
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LazyDoubleIterable}.
 * This file was automatically generated from template file abstractLazyPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLazyDoubleIterableTestCase {

    protected abstract LazyDoubleIterable classUnderTest();

    protected abstract LazyDoubleIterable getEmptyIterable();

    protected abstract LazyDoubleIterable newWith(double element1, double element2);

    @Test
    public void doubleIterator() {
        double sum = 0.0;
        for (DoubleIterator iterator = this.classUnderTest().doubleIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(6.0, sum, 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void doubleIterator_throws() {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        double[] sum = new double[1];
        this.classUnderTest().forEach(each -> sum[0] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
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
        Assert.assertEquals(1L, this.classUnderTest().count(DoublePredicates.lessThan(2.0)));
        Assert.assertEquals(0L, this.classUnderTest().count(DoublePredicates.lessThan(0.0)));
        Assert.assertEquals(2L, this.newWith(0.0, 1.0).count(DoublePredicates.lessThan(2.0)));
        Assert.assertEquals(2L, this.newWith(32.0, 33.0).count(DoublePredicates.lessThan(34.0)));
        Assert.assertEquals(0L, this.newWith(32.0, 33.0).count(DoublePredicates.lessThan(0.0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(DoublePredicates.greaterThan(4.0)));
        Assert.assertTrue(this.newWith(0.0, 1.0).anySatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertFalse(this.newWith(0.0, 1.0).anySatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertFalse(this.newWith(32.0, 33.0).anySatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertTrue(this.newWith(32.0, 33.0).anySatisfy(DoublePredicates.lessThan(33.0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(DoublePredicates.lessThan(4.0)));
        Assert.assertTrue(this.newWith(0.0, 1.0).allSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertFalse(this.newWith(0.0, 1.0).allSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertFalse(this.newWith(0.0, 1.0).allSatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertFalse(this.newWith(32.0, 33.0).allSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertFalse(this.newWith(32.0, 33.0).allSatisfy(DoublePredicates.lessThan(33.0)));
        Assert.assertTrue(this.newWith(32.0, 33.0).allSatisfy(DoublePredicates.lessThan(34.0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(DoublePredicates.greaterThan(4.0)));
        Assert.assertFalse(this.newWith(0.0, 1.0).noneSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertTrue(this.newWith(0.0, 1.0).noneSatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertTrue(this.newWith(32.0, 33.0).noneSatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertFalse(this.newWith(32.0, 33.0).noneSatisfy(DoublePredicates.lessThan(33.0)));
    }

    @Test
    public void select() {
        Verify.assertSize(2, this.classUnderTest().select(DoublePredicates.greaterThan(1.0)));
        Verify.assertEmpty(this.classUnderTest().select(DoublePredicates.lessThan(0.0)));
        Verify.assertSize(2, this.newWith(0.0, 1.0).select(DoublePredicates.lessThan(2.0)));
        Verify.assertEmpty(this.newWith(32.0, 33.0).select(DoublePredicates.lessThan(2.0)));
        Verify.assertSize(2, this.newWith(32.0, 33.0).select(DoublePredicates.lessThan(34.0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.classUnderTest().reject(DoublePredicates.greaterThan(1.0)));
        Verify.assertEmpty(this.classUnderTest().reject(DoublePredicates.greaterThan(0.0)));
        Verify.assertEmpty(this.newWith(0.0, 1.0).reject(DoublePredicates.lessThan(2.0)));
        Verify.assertEmpty(this.newWith(32.0, 33.0).reject(DoublePredicates.lessThan(34.0)));
        Verify.assertSize(2, this.newWith(32.0, 33.0).reject(DoublePredicates.lessThan(2.0)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1.0, this.classUnderTest().detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);
        Assert.assertEquals(0.0, this.newWith(0.0, 1.0).detectIfNone(DoublePredicates.lessThan(2.0), 1.0), 0.0);
        Assert.assertEquals(33.0, this.newWith(32.0, 33.0).detectIfNone(DoublePredicates.equal(33.0), 1.0), 0.0);
        Assert.assertEquals(32.0, this.newWith(0.0, 1.0).detectIfNone(DoublePredicates.equal(33.0), 32.0), 0.0);
        Assert.assertEquals(32.0, this.newWith(34.0, 35.0).detectIfNone(DoublePredicates.equal(33.0), 32.0), 0.0);
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(3, this.classUnderTest().collect(String::valueOf));
    }

    @Test
    public void tap() {
        StringBuilder tapStringBuilder = new StringBuilder();
        StringBuilder eachStringBuilder = new StringBuilder();
        LazyDoubleIterable lazy = this.classUnderTest().tap(tapStringBuilder::append);
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
        Assert.assertEquals(6.0, this.classUnderTest().sum(), 0.0);
        Assert.assertEquals(1.0, this.newWith(0.0, 1.0).sum(), 0.0);
        Assert.assertEquals(33.0, this.newWith(0.0, 33.0).sum(), 0.0);
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
        Assert.assertEquals(3.0, this.classUnderTest().max(), 0.0);
        Assert.assertEquals(33.0, this.newWith(33.0, 0.0).max(), 0.0);
        Assert.assertEquals(100.0, this.newWith(100.0, 1.0).max(), 0.0);
        Assert.assertEquals(2.0, this.newWith(1.0, 2.0).max(), 0.0);
    }

    @Test
    public void min() {
        Assert.assertEquals(1.0, this.classUnderTest().min(), 0.0);
        Assert.assertEquals(0.0, this.newWith(33.0, 0.0).min(), 0.0);
        Assert.assertEquals(1.0, this.newWith(100.0, 1.0).min(), 0.0);
        Assert.assertEquals(1.0, this.newWith(2.0, 1.0).min(), 0.0);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, this.getEmptyIterable().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().select(DoublePredicates.lessThan(0.0)).minIfEmpty(0.0), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, this.getEmptyIterable().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.classUnderTest().maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().select(DoublePredicates.lessThan(0.0)).maxIfEmpty(0.0), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new LazyDoubleIterableAdapter(new DoubleArrayList()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new LazyDoubleIterableAdapter(new DoubleArrayList()).min();
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
        Assert.assertEquals(16.0d, this.newWith(1.0, 31.0).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyIterable().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new double[] { 0.0, 1.0 }, this.newWith(0.0, 1.0).toArray()) || Arrays.equals(new double[] { 1.0, 0.0 }, this.newWith(0.0, 1.0).toArray()));
        Assert.assertTrue(Arrays.equals(new double[] { 1.0, 31.0 }, this.newWith(1.0, 31.0).toArray()) || Arrays.equals(new double[] { 31.0, 1.0 }, this.newWith(1.0, 31.0).toArray()));
        Assert.assertTrue(Arrays.equals(new double[] { 31.0, 35.0 }, this.newWith(31.0, 35.0).toArray()) || Arrays.equals(new double[] { 35.0, 31.0 }, this.newWith(31.0, 35.0).toArray()));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(1.0));
        Assert.assertTrue(this.classUnderTest().contains(2.0));
        Assert.assertTrue(this.classUnderTest().contains(3.0));
        Assert.assertFalse(this.classUnderTest().contains(4.0));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(1.0));
        Assert.assertTrue(this.classUnderTest().containsAll(2.0));
        Assert.assertTrue(this.classUnderTest().containsAll(1.0, 2.0));
        Assert.assertTrue(this.classUnderTest().containsAll(1.0, 2.0, 3.0));
        Assert.assertFalse(this.classUnderTest().containsAll(1.0, 2.0, 3.0, 4.0));
        Assert.assertFalse(this.classUnderTest().containsAll(4.0, 5.0, 6.0));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(this.classUnderTest().containsAll(DoubleArrayList.newListWith(2.0)));
        Assert.assertTrue(this.classUnderTest().containsAll(DoubleArrayList.newListWith(1.0, 2.0)));
        Assert.assertTrue(this.classUnderTest().containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Assert.assertFalse(this.classUnderTest().containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0)));
        Assert.assertFalse(this.classUnderTest().containsAll(DoubleArrayList.newListWith(4.0, 5.0, 6.0)));
    }

    @Test
    public void testToString() {
        LazyDoubleIterable iterable = this.newWith(1.0, 2.0);
        Assert.assertTrue("[1.0, 2.0]".equals(iterable.toString()) || "[2.0, 1.0]".equals(iterable.toString()));
        LazyDoubleIterable iterable1 = this.newWith(0.0, 31.0);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0.0, 31.0]") || iterable1.toString().equals("[31.0, 0.0]"));
        LazyDoubleIterable iterable2 = this.newWith(31.0, 32.0);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31.0, 32.0]") || iterable2.toString().equals("[32.0, 31.0]"));
        LazyDoubleIterable iterable3 = this.newWith(32.0, 33.0);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32.0, 33.0]") || iterable3.toString().equals("[33.0, 32.0]"));
        LazyDoubleIterable iterable4 = this.newWith(0.0, 1.0);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0.0, 1.0]") || iterable4.toString().equals("[1.0, 0.0]"));
    }

    @Test
    public void makeString() {
        LazyDoubleIterable iterable1 = this.newWith(0.0, 31.0);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0.0, 31.0") || iterable1.makeString().equals("31.0, 0.0"));
        LazyDoubleIterable iterable2 = this.newWith(31.0, 32.0);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31.0/32.0]") || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));
        LazyDoubleIterable iterable3 = this.newWith(32.0, 33.0);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32.0/33.0") || iterable3.makeString("/").equals("33.0/32.0"));
        LazyDoubleIterable iterable4 = this.newWith(1.0, 2.0);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString()) || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/")) || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]")) || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));
        LazyDoubleIterable iterable5 = this.newWith(0.0, 1.0);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0.0, 1.0") || iterable5.makeString().equals("1.0, 0.0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0.0/1.0]") || iterable5.makeString("[", "/", "]").equals("[1.0/0.0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0.0/1.0") || iterable5.makeString("/").equals("1.0/0.0"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable2 = new StringBuilder();
        LazyDoubleIterable iterable = this.newWith(1.0, 2.0);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString()) || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString()) || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable7 = new StringBuilder();
        LazyDoubleIterable iterable1 = this.newWith(0.0, 31.0);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString()) || "31.0, 0.0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LazyDoubleIterable iterable2 = this.newWith(31.0, 32.0);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString()) || "32.0/31.0".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LazyDoubleIterable iterable4 = this.newWith(32.0, 33.0);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString()) || "[33.0/32.0]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LazyDoubleIterable iterable5 = this.newWith(0.0, 1.0);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0.0, 1.0".equals(appendable10.toString()) || "1.0, 0.0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0.0/1.0".equals(appendable11.toString()) || "1.0/0.0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0.0/1.0]".equals(appendable12.toString()) || "[1.0/0.0]".equals(appendable12.toString()));
    }

    @Test
    public void toList() {
        LazyDoubleIterable iterable = this.newWith(31.0, 32.0);
        Assert.assertTrue(DoubleArrayList.newListWith(31.0, 32.0).equals(iterable.toList()) || DoubleArrayList.newListWith(32.0, 31.0).equals(iterable.toList()));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new double[] { 1, 2, 3 }, this.classUnderTest().toSortedArray(), 0.0);
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), this.classUnderTest().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), this.classUnderTest().toBag());
    }

    @Test
    public void asLazy() {
        LazyDoubleIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLazyDoubleIterableTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLazyDoubleIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyDoubleIterableTestCase> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.doubleIterator = AbstractLazyDoubleIterableTestCase::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyDoubleIterableTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractLazyDoubleIterableTestCase::forEach;
            this.payloads.size = AbstractLazyDoubleIterableTestCase::size;
            this.payloads.isEmpty = AbstractLazyDoubleIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLazyDoubleIterableTestCase::notEmpty;
            this.payloads.count = AbstractLazyDoubleIterableTestCase::count;
            this.payloads.anySatisfy = AbstractLazyDoubleIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLazyDoubleIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLazyDoubleIterableTestCase::noneSatisfy;
            this.payloads.select = AbstractLazyDoubleIterableTestCase::select;
            this.payloads.reject = AbstractLazyDoubleIterableTestCase::reject;
            this.payloads.detectIfNone = AbstractLazyDoubleIterableTestCase::detectIfNone;
            this.payloads.collect = AbstractLazyDoubleIterableTestCase::collect;
            this.payloads.tap = AbstractLazyDoubleIterableTestCase::tap;
            this.payloads.flatCollect = AbstractLazyDoubleIterableTestCase::flatCollect;
            this.payloads.lazyCollectPrimitives = AbstractLazyDoubleIterableTestCase::lazyCollectPrimitives;
            this.payloads.sum = AbstractLazyDoubleIterableTestCase::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyDoubleIterableTestCase::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyDoubleIterableTestCase::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = AbstractLazyDoubleIterableTestCase::max;
            this.payloads.min = AbstractLazyDoubleIterableTestCase::min;
            this.payloads.minIfEmpty = AbstractLazyDoubleIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLazyDoubleIterableTestCase::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyDoubleIterableTestCase::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyDoubleIterableTestCase::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = AbstractLazyDoubleIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyDoubleIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractLazyDoubleIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyDoubleIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractLazyDoubleIterableTestCase::toArray;
            this.payloads.contains = AbstractLazyDoubleIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractLazyDoubleIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractLazyDoubleIterableTestCase::containsAllIterable;
            this.payloads.testToString = AbstractLazyDoubleIterableTestCase::testToString;
            this.payloads.makeString = AbstractLazyDoubleIterableTestCase::makeString;
            this.payloads.appendString = AbstractLazyDoubleIterableTestCase::appendString;
            this.payloads.toList = AbstractLazyDoubleIterableTestCase::toList;
            this.payloads.toSortedArray = AbstractLazyDoubleIterableTestCase::toSortedArray;
            this.payloads.toSortedList = AbstractLazyDoubleIterableTestCase::toSortedList;
            this.payloads.toSet = AbstractLazyDoubleIterableTestCase::toSet;
            this.payloads.toBag = AbstractLazyDoubleIterableTestCase::toBag;
            this.payloads.asLazy = AbstractLazyDoubleIterableTestCase::asLazy;
        }
    }
}
