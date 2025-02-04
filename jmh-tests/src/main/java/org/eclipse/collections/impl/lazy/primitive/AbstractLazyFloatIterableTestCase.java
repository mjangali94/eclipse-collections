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
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LazyFloatIterable}.
 * This file was automatically generated from template file abstractLazyPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLazyFloatIterableTestCase {

    protected abstract LazyFloatIterable classUnderTest();

    protected abstract LazyFloatIterable getEmptyIterable();

    protected abstract LazyFloatIterable newWith(float element1, float element2);

    @Test
    public void floatIterator() {
        double sum = 0.0;
        for (FloatIterator iterator = this.classUnderTest().floatIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(6.0, sum, 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void floatIterator_throws() {
        FloatIterator iterator = this.classUnderTest().floatIterator();
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
        Assert.assertEquals(1L, this.classUnderTest().count(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(0L, this.classUnderTest().count(FloatPredicates.lessThan(0.0f)));
        Assert.assertEquals(2L, this.newWith(0.0f, 1.0f).count(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(2L, this.newWith(32.0f, 33.0f).count(FloatPredicates.lessThan(34.0f)));
        Assert.assertEquals(0L, this.newWith(32.0f, 33.0f).count(FloatPredicates.lessThan(0.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(FloatPredicates.greaterThan(4.0f)));
        Assert.assertTrue(this.newWith(0.0f, 1.0f).anySatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertFalse(this.newWith(0.0f, 1.0f).anySatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertFalse(this.newWith(32.0f, 33.0f).anySatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertTrue(this.newWith(32.0f, 33.0f).anySatisfy(FloatPredicates.lessThan(33.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(FloatPredicates.lessThan(4.0f)));
        Assert.assertTrue(this.newWith(0.0f, 1.0f).allSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertFalse(this.newWith(0.0f, 1.0f).allSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertFalse(this.newWith(0.0f, 1.0f).allSatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertFalse(this.newWith(32.0f, 33.0f).allSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertFalse(this.newWith(32.0f, 33.0f).allSatisfy(FloatPredicates.lessThan(33.0f)));
        Assert.assertTrue(this.newWith(32.0f, 33.0f).allSatisfy(FloatPredicates.lessThan(34.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(FloatPredicates.greaterThan(4.0f)));
        Assert.assertFalse(this.newWith(0.0f, 1.0f).noneSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertTrue(this.newWith(0.0f, 1.0f).noneSatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertTrue(this.newWith(32.0f, 33.0f).noneSatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertFalse(this.newWith(32.0f, 33.0f).noneSatisfy(FloatPredicates.lessThan(33.0f)));
    }

    @Test
    public void select() {
        Verify.assertSize(2, this.classUnderTest().select(FloatPredicates.greaterThan(1.0f)));
        Verify.assertEmpty(this.classUnderTest().select(FloatPredicates.lessThan(0.0f)));
        Verify.assertSize(2, this.newWith(0.0f, 1.0f).select(FloatPredicates.lessThan(2.0f)));
        Verify.assertEmpty(this.newWith(32.0f, 33.0f).select(FloatPredicates.lessThan(2.0f)));
        Verify.assertSize(2, this.newWith(32.0f, 33.0f).select(FloatPredicates.lessThan(34.0f)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.classUnderTest().reject(FloatPredicates.greaterThan(1.0f)));
        Verify.assertEmpty(this.classUnderTest().reject(FloatPredicates.greaterThan(0.0f)));
        Verify.assertEmpty(this.newWith(0.0f, 1.0f).reject(FloatPredicates.lessThan(2.0f)));
        Verify.assertEmpty(this.newWith(32.0f, 33.0f).reject(FloatPredicates.lessThan(34.0f)));
        Verify.assertSize(2, this.newWith(32.0f, 33.0f).reject(FloatPredicates.lessThan(2.0f)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1.0, this.classUnderTest().detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);
        Assert.assertEquals(0.0, this.newWith(0.0f, 1.0f).detectIfNone(FloatPredicates.lessThan(2.0f), 1.0f), 0.0);
        Assert.assertEquals(33.0, this.newWith(32.0f, 33.0f).detectIfNone(FloatPredicates.equal(33.0f), 1.0f), 0.0);
        Assert.assertEquals(32.0, this.newWith(0.0f, 1.0f).detectIfNone(FloatPredicates.equal(33.0f), 32.0f), 0.0);
        Assert.assertEquals(32.0, this.newWith(34.0f, 35.0f).detectIfNone(FloatPredicates.equal(33.0f), 32.0f), 0.0);
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(3, this.classUnderTest().collect(String::valueOf));
    }

    @Test
    public void tap() {
        StringBuilder tapStringBuilder = new StringBuilder();
        StringBuilder eachStringBuilder = new StringBuilder();
        LazyFloatIterable lazy = this.classUnderTest().tap(tapStringBuilder::append);
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
        Assert.assertEquals(1.0, this.newWith(0.0f, 1.0f).sum(), 0.0);
        Assert.assertEquals(33.0, this.newWith(0.0f, 33.0f).sum(), 0.0);
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
        Assert.assertEquals(3.0f, this.classUnderTest().max(), 0.0);
        Assert.assertEquals(33.0f, this.newWith(33.0f, 0.0f).max(), 0.0);
        Assert.assertEquals(100.0f, this.newWith(100.0f, 1.0f).max(), 0.0);
        Assert.assertEquals(2.0f, this.newWith(1.0f, 2.0f).max(), 0.0);
    }

    @Test
    public void min() {
        Assert.assertEquals(1.0f, this.classUnderTest().min(), 0.0);
        Assert.assertEquals(0.0f, this.newWith(33.0f, 0.0f).min(), 0.0);
        Assert.assertEquals(1.0f, this.newWith(100.0f, 1.0f).min(), 0.0);
        Assert.assertEquals(1.0f, this.newWith(2.0f, 1.0f).min(), 0.0);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0f, this.getEmptyIterable().minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(1.0f, this.classUnderTest().minIfEmpty(0.0f), 0.0);
        Assert.assertEquals(0.0f, this.classUnderTest().select(FloatPredicates.lessThan(0.0f)).minIfEmpty(0.0f), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0f, this.getEmptyIterable().maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(3.0f, this.classUnderTest().maxIfEmpty(0.0f), 0.0);
        Assert.assertEquals(0.0f, this.classUnderTest().select(FloatPredicates.lessThan(0.0f)).maxIfEmpty(0.0f), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new LazyFloatIterableAdapter(new FloatArrayList()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new LazyFloatIterableAdapter(new FloatArrayList()).min();
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
        Assert.assertEquals(16.0d, this.newWith(1.0f, 31.0f).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyIterable().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new float[] { 0.0f, 1.0f }, this.newWith(0.0f, 1.0f).toArray()) || Arrays.equals(new float[] { 1.0f, 0.0f }, this.newWith(0.0f, 1.0f).toArray()));
        Assert.assertTrue(Arrays.equals(new float[] { 1.0f, 31.0f }, this.newWith(1.0f, 31.0f).toArray()) || Arrays.equals(new float[] { 31.0f, 1.0f }, this.newWith(1.0f, 31.0f).toArray()));
        Assert.assertTrue(Arrays.equals(new float[] { 31.0f, 35.0f }, this.newWith(31.0f, 35.0f).toArray()) || Arrays.equals(new float[] { 35.0f, 31.0f }, this.newWith(31.0f, 35.0f).toArray()));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(1.0f));
        Assert.assertTrue(this.classUnderTest().contains(2.0f));
        Assert.assertTrue(this.classUnderTest().contains(3.0f));
        Assert.assertFalse(this.classUnderTest().contains(4.0f));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(1.0f));
        Assert.assertTrue(this.classUnderTest().containsAll(2.0f));
        Assert.assertTrue(this.classUnderTest().containsAll(1.0f, 2.0f));
        Assert.assertTrue(this.classUnderTest().containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertFalse(this.classUnderTest().containsAll(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertFalse(this.classUnderTest().containsAll(4.0f, 5.0f, 6.0f));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(this.classUnderTest().containsAll(FloatArrayList.newListWith(2.0f)));
        Assert.assertTrue(this.classUnderTest().containsAll(FloatArrayList.newListWith(1.0f, 2.0f)));
        Assert.assertTrue(this.classUnderTest().containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Assert.assertFalse(this.classUnderTest().containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f)));
        Assert.assertFalse(this.classUnderTest().containsAll(FloatArrayList.newListWith(4.0f, 5.0f, 6.0f)));
    }

    @Test
    public void testToString() {
        LazyFloatIterable iterable = this.newWith(1.0f, 2.0f);
        Assert.assertTrue("[1.0, 2.0]".equals(iterable.toString()) || "[2.0, 1.0]".equals(iterable.toString()));
        LazyFloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0.0, 31.0]") || iterable1.toString().equals("[31.0, 0.0]"));
        LazyFloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31.0, 32.0]") || iterable2.toString().equals("[32.0, 31.0]"));
        LazyFloatIterable iterable3 = this.newWith(32.0f, 33.0f);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32.0, 33.0]") || iterable3.toString().equals("[33.0, 32.0]"));
        LazyFloatIterable iterable4 = this.newWith(0.0f, 1.0f);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0.0, 1.0]") || iterable4.toString().equals("[1.0, 0.0]"));
    }

    @Test
    public void makeString() {
        LazyFloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0.0, 31.0") || iterable1.makeString().equals("31.0, 0.0"));
        LazyFloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31.0/32.0]") || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));
        LazyFloatIterable iterable3 = this.newWith(32.0f, 33.0f);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32.0/33.0") || iterable3.makeString("/").equals("33.0/32.0"));
        LazyFloatIterable iterable4 = this.newWith(1.0f, 2.0f);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString()) || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/")) || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]")) || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));
        LazyFloatIterable iterable5 = this.newWith(0.0f, 1.0f);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0.0, 1.0") || iterable5.makeString().equals("1.0, 0.0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0.0/1.0]") || iterable5.makeString("[", "/", "]").equals("[1.0/0.0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0.0/1.0") || iterable5.makeString("/").equals("1.0/0.0"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable2 = new StringBuilder();
        LazyFloatIterable iterable = this.newWith(1.0f, 2.0f);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString()) || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString()) || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable7 = new StringBuilder();
        LazyFloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString()) || "31.0, 0.0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LazyFloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString()) || "32.0/31.0".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LazyFloatIterable iterable4 = this.newWith(32.0f, 33.0f);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString()) || "[33.0/32.0]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LazyFloatIterable iterable5 = this.newWith(0.0f, 1.0f);
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
        LazyFloatIterable iterable = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(FloatArrayList.newListWith(31.0f, 32.0f).equals(iterable.toList()) || FloatArrayList.newListWith(32.0f, 31.0f).equals(iterable.toList()));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 1, 2, 3 }, this.classUnderTest().toSortedArray(), 0.0f);
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toBag());
    }

    @Test
    public void asLazy() {
        LazyFloatIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLazyFloatIterableTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLazyFloatIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLazyFloatIterableTestCase> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.floatIterator = AbstractLazyFloatIterableTestCase::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyFloatIterableTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractLazyFloatIterableTestCase::forEach;
            this.payloads.size = AbstractLazyFloatIterableTestCase::size;
            this.payloads.isEmpty = AbstractLazyFloatIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLazyFloatIterableTestCase::notEmpty;
            this.payloads.count = AbstractLazyFloatIterableTestCase::count;
            this.payloads.anySatisfy = AbstractLazyFloatIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLazyFloatIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLazyFloatIterableTestCase::noneSatisfy;
            this.payloads.select = AbstractLazyFloatIterableTestCase::select;
            this.payloads.reject = AbstractLazyFloatIterableTestCase::reject;
            this.payloads.detectIfNone = AbstractLazyFloatIterableTestCase::detectIfNone;
            this.payloads.collect = AbstractLazyFloatIterableTestCase::collect;
            this.payloads.tap = AbstractLazyFloatIterableTestCase::tap;
            this.payloads.flatCollect = AbstractLazyFloatIterableTestCase::flatCollect;
            this.payloads.lazyCollectPrimitives = AbstractLazyFloatIterableTestCase::lazyCollectPrimitives;
            this.payloads.sum = AbstractLazyFloatIterableTestCase::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyFloatIterableTestCase::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyFloatIterableTestCase::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = AbstractLazyFloatIterableTestCase::max;
            this.payloads.min = AbstractLazyFloatIterableTestCase::min;
            this.payloads.minIfEmpty = AbstractLazyFloatIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLazyFloatIterableTestCase::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyFloatIterableTestCase::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyFloatIterableTestCase::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = AbstractLazyFloatIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyFloatIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractLazyFloatIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLazyFloatIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractLazyFloatIterableTestCase::toArray;
            this.payloads.contains = AbstractLazyFloatIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractLazyFloatIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractLazyFloatIterableTestCase::containsAllIterable;
            this.payloads.testToString = AbstractLazyFloatIterableTestCase::testToString;
            this.payloads.makeString = AbstractLazyFloatIterableTestCase::makeString;
            this.payloads.appendString = AbstractLazyFloatIterableTestCase::appendString;
            this.payloads.toList = AbstractLazyFloatIterableTestCase::toList;
            this.payloads.toSortedArray = AbstractLazyFloatIterableTestCase::toSortedArray;
            this.payloads.toSortedList = AbstractLazyFloatIterableTestCase::toSortedList;
            this.payloads.toSet = AbstractLazyFloatIterableTestCase::toSet;
            this.payloads.toBag = AbstractLazyFloatIterableTestCase::toBag;
            this.payloads.asLazy = AbstractLazyFloatIterableTestCase::asLazy;
        }
    }
}
