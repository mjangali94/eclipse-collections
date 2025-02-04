/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedDoubleCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableDoubleCollection;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleDoubleMap#values()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapValuesTest.stg.
 */
public class UnmodifiableDoubleDoubleMapValuesTest extends AbstractMutableDoubleCollectionTestCase {

    @Override
    protected MutableDoubleCollection classUnderTest() {
        return DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0).values().asUnmodifiable();
    }

    @Override
    protected MutableDoubleCollection newWith(double... elements) {
        DoubleDoubleHashMap map = new DoubleDoubleHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.asUnmodifiable().values();
    }

    @Override
    protected MutableDoubleCollection newMutableCollectionWith(double... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Double> newObjectCollectionWith(Double... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void doubleIterator() {
        MutableDoubleCollection bag = this.newWith(0.0, 1.0, 2.0, 3.0);
        DoubleArrayList list = DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0);
        DoubleIterator iterator = bag.doubleIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void doubleIterator_with_remove() {
        MutableDoubleCollection doubleIterable = this.classUnderTest();
        MutableDoubleIterator iterator = doubleIterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void doubleIterator_throws_for_remove_before_next() {
        MutableDoubleCollection doubleIterable = this.classUnderTest();
        MutableDoubleIterator iterator = doubleIterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void doubleIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0.0);
    }

    @Override
    @Test
    public void testEquals_NaN() {
        // Testing equals() is not applicable for MutableDoubleCollection.
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0.0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(DoublePredicates.equal(0.0));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableDoubleCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableDoubleCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.newWith().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.newWith().removeAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.newWith().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.newWith().retainAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        MutableDoubleCollection emptyCollection = this.newWith();
        emptyCollection.clear();
    }

    @Override
    @Test
    public void contains() {
        MutableDoubleCollection collection = this.newWith(14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));
        double[] numbers = { 14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0 };
        for (double number : numbers) {
            Assert.assertTrue(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));
    }

    @Override
    @Test
    public void reject() {
        DoubleIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(1, iterable.reject(DoublePredicates.lessThan(3.0)));
    }

    @Override
    @Test
    public void select() {
        DoubleIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(2, iterable.select(DoublePredicates.lessThan(3.0)));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        DoubleToObjectFunction<Double> function = (double parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 2.0).toBag(), this.newWith(1.0, 2.0, 3.0).collect(function).toBag());
        DoubleIterable iterable = this.newWith(1.0, 2.0, 3.0);
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 2.0).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2.0), this.newWith(3.0).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1.0", this.newWith(1.0).makeString("/"));
        Assert.assertEquals("31.0", this.newWith(31.0).makeString());
        Assert.assertEquals("32.0", this.newWith(32.0).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        DoubleIterable iterable1 = this.newWith(0.0, 31.0);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0.0, 31.0") || iterable1.makeString().equals("31.0, 0.0"));
        DoubleIterable iterable2 = this.newWith(31.0, 32.0);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31.0/32.0]") || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));
        DoubleIterable iterable3 = this.newWith(32.0, 33.0);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32.0/33.0") || iterable3.makeString("/").equals("33.0/32.0"));
        DoubleIterable iterable4 = this.newWith(1.0, 2.0);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString()) || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/")) || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]")) || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));
        DoubleIterable iterable5 = this.newWith(0.0, 1.0);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0.0, 1.0") || iterable5.makeString().equals("1.0, 0.0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0.0/1.0]") || iterable5.makeString("[", "/", "]").equals("[1.0/0.0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0.0/1.0") || iterable5.makeString("/").equals("1.0/0.0"));
    }

    @Override
    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", ", ", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1.0).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        DoubleIterable iterable = this.newWith(1.0, 2.0);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString()) || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString()) || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31.0).appendString(appendable5);
        Assert.assertEquals("31.0", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32.0).appendString(appendable6);
        Assert.assertEquals("32.0", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        DoubleIterable iterable1 = this.newWith(0.0, 31.0);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString()) || "31.0, 0.0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        DoubleIterable iterable2 = this.newWith(31.0, 32.0);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString()) || "32.0/31.0".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        DoubleIterable iterable4 = this.newWith(32.0, 33.0);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString()) || "[33.0/32.0]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        DoubleIterable iterable5 = this.newWith(0.0, 1.0);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0.0, 1.0".equals(appendable10.toString()) || "1.0, 0.0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0.0/1.0".equals(appendable11.toString()) || "1.0/0.0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0.0/1.0]".equals(appendable12.toString()) || "[1.0/0.0]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableDoubleCollection collection = this.classUnderTest().asSynchronized();
        Verify.assertInstanceOf(SynchronizedDoubleCollection.class, collection);
    }

    @Override
    @Test
    public void testEquals() {
        // Testing equals() is not applicable for MutableDoubleCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableDoubleCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableDoubleCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableDoubleCollection.
    }

    @Override
    @Test
    public void chunk() {
        DoubleIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0), DoubleBags.mutable.with(2.0), DoubleBags.mutable.with(3.0)).toSet(), iterable.chunk(1).toSet());
        MutableSet<DoubleIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0), DoubleBags.mutable.with(3.0)).toSet().equals(chunked) || Lists.mutable.with(DoubleBags.mutable.with(2.0, 3.0), DoubleBags.mutable.with(1.0)).toSet().equals(chunked) || Lists.mutable.with(DoubleBags.mutable.with(1.0, 3.0), DoubleBags.mutable.with(2.0)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableDoubleDoubleMapValuesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
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
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
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
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableDoubleDoubleMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleDoubleMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableDoubleDoubleMapValuesTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableDoubleDoubleMapValuesTest::newCollection;
            this.payloads.isEmpty = UnmodifiableDoubleDoubleMapValuesTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableDoubleDoubleMapValuesTest::notEmpty;
            this.payloads.tap = UnmodifiableDoubleDoubleMapValuesTest::tap;
            this.payloads.contains_NaN = UnmodifiableDoubleDoubleMapValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = UnmodifiableDoubleDoubleMapValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = UnmodifiableDoubleDoubleMapValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = UnmodifiableDoubleDoubleMapValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = UnmodifiableDoubleDoubleMapValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = UnmodifiableDoubleDoubleMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableDoubleDoubleMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableDoubleDoubleMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableDoubleDoubleMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableDoubleDoubleMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableDoubleDoubleMapValuesTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableDoubleDoubleMapValuesTest::forEach;
            this.payloads.size = UnmodifiableDoubleDoubleMapValuesTest::size;
            this.payloads.count = UnmodifiableDoubleDoubleMapValuesTest::count;
            this.payloads.anySatisfy = UnmodifiableDoubleDoubleMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableDoubleDoubleMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableDoubleDoubleMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = UnmodifiableDoubleDoubleMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableDoubleDoubleMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableDoubleDoubleMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableDoubleDoubleMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableDoubleDoubleMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = UnmodifiableDoubleDoubleMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = UnmodifiableDoubleDoubleMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = UnmodifiableDoubleDoubleMapValuesTest::detectIfNone;
            this.payloads.max = UnmodifiableDoubleDoubleMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableDoubleDoubleMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableDoubleDoubleMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableDoubleDoubleMapValuesTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableDoubleDoubleMapValuesTest::sum;
            this.payloads.summaryStatistics = UnmodifiableDoubleDoubleMapValuesTest::summaryStatistics;
            this.payloads.sumConsistentRounding = UnmodifiableDoubleDoubleMapValuesTest::sumConsistentRounding;
            this.payloads.average = UnmodifiableDoubleDoubleMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableDoubleDoubleMapValuesTest::averageIfEmpty;
            this.payloads.median = UnmodifiableDoubleDoubleMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableDoubleDoubleMapValuesTest::medianIfEmpty;
            this.payloads.toArray = UnmodifiableDoubleDoubleMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = UnmodifiableDoubleDoubleMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = UnmodifiableDoubleDoubleMapValuesTest::toSortedArray;
            this.payloads.testHashCode = UnmodifiableDoubleDoubleMapValuesTest::testHashCode;
            this.payloads.testToString = UnmodifiableDoubleDoubleMapValuesTest::testToString;
            this.payloads.toList = UnmodifiableDoubleDoubleMapValuesTest::toList;
            this.payloads.toSortedList = UnmodifiableDoubleDoubleMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableDoubleDoubleMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableDoubleDoubleMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableDoubleDoubleMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableDoubleDoubleMapValuesTest::toSet;
            this.payloads.toBag = UnmodifiableDoubleDoubleMapValuesTest::toBag;
            this.payloads.asLazy = UnmodifiableDoubleDoubleMapValuesTest::asLazy;
            this.payloads.injectInto = UnmodifiableDoubleDoubleMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = UnmodifiableDoubleDoubleMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableDoubleDoubleMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableDoubleDoubleMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableDoubleDoubleMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableDoubleDoubleMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableDoubleDoubleMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableDoubleDoubleMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableDoubleDoubleMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableDoubleDoubleMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableDoubleDoubleMapValuesTest::reduceIfEmpty;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.newEmpty = UnmodifiableDoubleDoubleMapValuesTest::newEmpty;
            this.payloads.doubleIterator = UnmodifiableDoubleDoubleMapValuesTest::doubleIterator;
            this.payloads.doubleIterator_with_remove = UnmodifiableDoubleDoubleMapValuesTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = UnmodifiableDoubleDoubleMapValuesTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = UnmodifiableDoubleDoubleMapValuesTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = UnmodifiableDoubleDoubleMapValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = UnmodifiableDoubleDoubleMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleDoubleMapValuesTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableDoubleDoubleMapValuesTest::contains;
            this.payloads.reject = UnmodifiableDoubleDoubleMapValuesTest::reject;
            this.payloads.select = UnmodifiableDoubleDoubleMapValuesTest::select;
            this.payloads.collect = UnmodifiableDoubleDoubleMapValuesTest::collect;
            this.payloads.makeString = UnmodifiableDoubleDoubleMapValuesTest::makeString;
            this.payloads.appendString = UnmodifiableDoubleDoubleMapValuesTest::appendString;
            this.payloads.asSynchronized = UnmodifiableDoubleDoubleMapValuesTest::asSynchronized;
            this.payloads.testEquals = UnmodifiableDoubleDoubleMapValuesTest::testEquals;
            this.payloads.chunk = UnmodifiableDoubleDoubleMapValuesTest::chunk;
        }
    }
}
