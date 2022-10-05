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
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedDoubleCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableDoubleCollection;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortDoubleMap#values()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapValuesTest.stg.
 */
public class SynchronizedShortDoubleMapValuesTest extends AbstractMutableDoubleCollectionTestCase {

    @Override
    protected MutableDoubleCollection classUnderTest() {
        return new SynchronizedShortDoubleMap(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0)).values();
    }

    @Override
    protected MutableDoubleCollection newWith(double... elements) {
        ShortDoubleHashMap map = new ShortDoubleHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((short) i, elements[i]);
        }
        return map.asSynchronized().values();
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
    public void withAll() {
        this.classUnderTest().withAll(new DoubleArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableDoubleCollection collection = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleCollection collectionWithout = collection.without(2.0);
        Assert.assertSame(collection, collectionWithout);
        MutableDoubleCollection expectedCollection = this.newWith(1.0, 3.0);
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.toList());
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.without(4.0).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableDoubleCollection collection = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleCollection collectionWithout = collection.withoutAll(new DoubleArrayList(2.0, 4.0));
        Assert.assertSame(collection, collectionWithout);
        MutableDoubleCollection expectedCollection = this.newWith(1.0, 3.0);
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.toList());
    }

    @Override
    @Test
    public void remove() {
        ShortDoubleHashMap map = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertTrue(collection.remove(3.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertTrue(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
    }

    @Override
    @Test
    public void removeIf() {
        ShortDoubleHashMap map = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(DoublePredicates.equal(3.0)));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertTrue(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertFalse(collection.removeIf(DoublePredicates.equal(3.0)));
    }

    @Override
    @Test
    public void sumConsistentRounding() {
        DoubleIterable iterable = this.newWith(Interval.fromTo(Short.MIN_VALUE, Short.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0).collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())).toArray());
        Assert.assertEquals(2.1646464674222576, iterable.sum(), 1.0e-15);
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableDoubleCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedDoubleCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableDoubleCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableDoubleCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1.0));
        ShortDoubleHashMap map = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(1.0, 5.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertTrue(collection.removeAll(3.0, 2.0));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new DoubleArrayList()));
        Assert.assertFalse(this.newWith().removeAll(DoubleArrayList.newListWith(1.0)));
        ShortDoubleHashMap map = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(DoubleArrayList.newListWith(1.0, 5.0)));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertTrue(collection.contains(2.0));
        Assert.assertTrue(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertTrue(map.contains(2.0));
        Assert.assertTrue(map.contains(3.0));
        Assert.assertTrue(collection.removeAll(DoubleArrayList.newListWith(3.0, 2.0)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(1.0));
        ShortDoubleHashMap map = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(1.0, 2.0, 3.0));
        Assert.assertTrue(collection.retainAll(1.0, 5.0));
        Assert.assertTrue(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertTrue(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(collection.retainAll(3.0, 2.0));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new DoubleArrayList()));
        Assert.assertFalse(this.newWith().retainAll(DoubleArrayList.newListWith(1.0)));
        ShortDoubleHashMap map = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(1.0, 2.0, 3.0));
        Assert.assertTrue(collection.retainAll(DoubleArrayList.newListWith(1.0, 5.0)));
        Assert.assertTrue(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertTrue(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(collection.retainAll(DoubleArrayList.newListWith(3.0, 2.0)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        Assert.assertFalse(map.contains(1.0));
        Assert.assertFalse(map.contains(2.0));
        Assert.assertFalse(map.contains(3.0));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableDoubleCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        ShortDoubleHashMap map = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        MutableDoubleCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        MutableDoubleCollection collection1 = this.newWith(0.0, 1.0, 31.0, 32.0);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0.0));
        Assert.assertFalse(collection1.contains(1.0));
        Assert.assertFalse(collection1.contains(31.0));
        Assert.assertFalse(collection1.contains(32.0));
        MutableDoubleCollection collection2 = this.newWith(0.0, 1.0, 2.0);
        collection2.clear();
        Verify.assertSize(0, collection2);
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
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
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

        private SynchronizedShortDoubleMapValuesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
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
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
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
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortDoubleMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedShortDoubleMapValuesTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedShortDoubleMapValuesTest::newCollection;
            this.payloads.isEmpty = SynchronizedShortDoubleMapValuesTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortDoubleMapValuesTest::notEmpty;
            this.payloads.tap = SynchronizedShortDoubleMapValuesTest::tap;
            this.payloads.contains_NaN = SynchronizedShortDoubleMapValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedShortDoubleMapValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedShortDoubleMapValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedShortDoubleMapValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = SynchronizedShortDoubleMapValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedShortDoubleMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedShortDoubleMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedShortDoubleMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedShortDoubleMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedShortDoubleMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedShortDoubleMapValuesTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedShortDoubleMapValuesTest::forEach;
            this.payloads.size = SynchronizedShortDoubleMapValuesTest::size;
            this.payloads.count = SynchronizedShortDoubleMapValuesTest::count;
            this.payloads.anySatisfy = SynchronizedShortDoubleMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedShortDoubleMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedShortDoubleMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = SynchronizedShortDoubleMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedShortDoubleMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedShortDoubleMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedShortDoubleMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedShortDoubleMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedShortDoubleMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedShortDoubleMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedShortDoubleMapValuesTest::detectIfNone;
            this.payloads.max = SynchronizedShortDoubleMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedShortDoubleMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedShortDoubleMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedShortDoubleMapValuesTest::maxIfEmpty;
            this.payloads.sum = SynchronizedShortDoubleMapValuesTest::sum;
            this.payloads.summaryStatistics = SynchronizedShortDoubleMapValuesTest::summaryStatistics;
            this.payloads.average = SynchronizedShortDoubleMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedShortDoubleMapValuesTest::averageIfEmpty;
            this.payloads.median = SynchronizedShortDoubleMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedShortDoubleMapValuesTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedShortDoubleMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedShortDoubleMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedShortDoubleMapValuesTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedShortDoubleMapValuesTest::testHashCode;
            this.payloads.testToString = SynchronizedShortDoubleMapValuesTest::testToString;
            this.payloads.toList = SynchronizedShortDoubleMapValuesTest::toList;
            this.payloads.toSortedList = SynchronizedShortDoubleMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedShortDoubleMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedShortDoubleMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedShortDoubleMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedShortDoubleMapValuesTest::toSet;
            this.payloads.toBag = SynchronizedShortDoubleMapValuesTest::toBag;
            this.payloads.asLazy = SynchronizedShortDoubleMapValuesTest::asLazy;
            this.payloads.injectInto = SynchronizedShortDoubleMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedShortDoubleMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedShortDoubleMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedShortDoubleMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedShortDoubleMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedShortDoubleMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedShortDoubleMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedShortDoubleMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedShortDoubleMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedShortDoubleMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedShortDoubleMapValuesTest::reduceIfEmpty;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = SynchronizedShortDoubleMapValuesTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = SynchronizedShortDoubleMapValuesTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = SynchronizedShortDoubleMapValuesTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedShortDoubleMapValuesTest::newEmpty;
            this.payloads.doubleIterator = SynchronizedShortDoubleMapValuesTest::doubleIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = SynchronizedShortDoubleMapValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedShortDoubleMapValuesTest::without;
            this.payloads.withoutAll = SynchronizedShortDoubleMapValuesTest::withoutAll;
            this.payloads.remove = SynchronizedShortDoubleMapValuesTest::remove;
            this.payloads.removeIf = SynchronizedShortDoubleMapValuesTest::removeIf;
            this.payloads.sumConsistentRounding = SynchronizedShortDoubleMapValuesTest::sumConsistentRounding;
            this.payloads.asSynchronized = SynchronizedShortDoubleMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedShortDoubleMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = SynchronizedShortDoubleMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedShortDoubleMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedShortDoubleMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedShortDoubleMapValuesTest::retainAll_iterable;
            this.payloads.clear = SynchronizedShortDoubleMapValuesTest::clear;
            this.payloads.contains = SynchronizedShortDoubleMapValuesTest::contains;
            this.payloads.reject = SynchronizedShortDoubleMapValuesTest::reject;
            this.payloads.select = SynchronizedShortDoubleMapValuesTest::select;
            this.payloads.collect = SynchronizedShortDoubleMapValuesTest::collect;
            this.payloads.makeString = SynchronizedShortDoubleMapValuesTest::makeString;
            this.payloads.appendString = SynchronizedShortDoubleMapValuesTest::appendString;
            this.payloads.testEquals = SynchronizedShortDoubleMapValuesTest::testEquals;
            this.payloads.chunk = SynchronizedShortDoubleMapValuesTest::chunk;
        }
    }
}
