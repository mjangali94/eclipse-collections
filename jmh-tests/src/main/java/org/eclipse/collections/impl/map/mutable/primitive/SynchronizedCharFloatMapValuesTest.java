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
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedFloatCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableFloatCollection;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedCharFloatMap#values()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapValuesTest.stg.
 */
public class SynchronizedCharFloatMapValuesTest extends AbstractMutableFloatCollectionTestCase {

    @Override
    protected MutableFloatCollection classUnderTest() {
        return new SynchronizedCharFloatMap(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f)).values();
    }

    @Override
    protected MutableFloatCollection newWith(float... elements) {
        CharFloatHashMap map = new CharFloatHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((char) i, elements[i]);
        }
        return map.asSynchronized().values();
    }

    @Override
    protected MutableFloatCollection newMutableCollectionWith(float... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Float> newObjectCollectionWith(Float... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void floatIterator() {
        MutableFloatCollection bag = this.newWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatArrayList list = FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatIterator iterator = bag.floatIterator();
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
        this.classUnderTest().addAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0.0f);
    }

    @Override
    @Test
    public void testEquals_NaN() {
        // Testing equals() is not applicable for MutableFloatCollection.
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0.0f, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new FloatArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableFloatCollection collection = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatCollection collectionWithout = collection.without(2.0f);
        Assert.assertSame(collection, collectionWithout);
        MutableFloatCollection expectedCollection = this.newWith(1.0f, 3.0f);
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.toList());
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.without(4.0f).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableFloatCollection collection = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatCollection collectionWithout = collection.withoutAll(new FloatArrayList(2.0f, 4.0f));
        Assert.assertSame(collection, collectionWithout);
        MutableFloatCollection expectedCollection = this.newWith(1.0f, 3.0f);
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.toList());
    }

    @Override
    @Test
    public void remove() {
        CharFloatHashMap map = CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertTrue(collection.remove(3.0f));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertTrue(collection.contains(1.0f));
        Assert.assertTrue(collection.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(map.contains(1.0f));
        Assert.assertTrue(map.contains(2.0f));
    }

    @Override
    @Test
    public void removeIf() {
        CharFloatHashMap map = CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(FloatPredicates.equal(3.0f)));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertTrue(collection.contains(1.0f));
        Assert.assertTrue(collection.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(map.contains(1.0f));
        Assert.assertTrue(map.contains(2.0f));
        Assert.assertFalse(collection.removeIf(FloatPredicates.equal(3.0f)));
    }

    @Override
    @Test
    public void sumConsistentRounding() {
        FloatIterable iterable = this.newWith(Interval.fromTo(Character.MIN_VALUE, Character.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0).collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())).toArray());
        Assert.assertEquals(1.0823232337616622, iterable.sum(), 1.0e-15);
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableFloatCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedFloatCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableFloatCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableFloatCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1.0f));
        CharFloatHashMap map = CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(1.0f, 5.0f));
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertTrue(collection.contains(2.0f));
        Assert.assertTrue(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertTrue(map.contains(2.0f));
        Assert.assertTrue(map.contains(3.0f));
        Assert.assertTrue(collection.removeAll(3.0f, 2.0f));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertFalse(collection.contains(2.0f));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertFalse(map.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new FloatArrayList()));
        Assert.assertFalse(this.newWith().removeAll(FloatArrayList.newListWith(1.0f)));
        CharFloatHashMap map = CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(FloatArrayList.newListWith(1.0f, 5.0f)));
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertTrue(collection.contains(2.0f));
        Assert.assertTrue(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertTrue(map.contains(2.0f));
        Assert.assertTrue(map.contains(3.0f));
        Assert.assertTrue(collection.removeAll(FloatArrayList.newListWith(3.0f, 2.0f)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertFalse(collection.contains(2.0f));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertFalse(map.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(1.0f));
        CharFloatHashMap map = CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(1.0f, 2.0f, 3.0f));
        Assert.assertTrue(collection.retainAll(1.0f, 5.0f));
        Assert.assertTrue(collection.contains(1.0f));
        Assert.assertFalse(collection.contains(2.0f));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertTrue(map.contains(1.0f));
        Assert.assertFalse(map.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(collection.retainAll(3.0f, 2.0f));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertFalse(collection.contains(2.0f));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertFalse(map.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new FloatArrayList()));
        Assert.assertFalse(this.newWith().retainAll(FloatArrayList.newListWith(1.0f)));
        CharFloatHashMap map = CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(1.0f, 2.0f, 3.0f));
        Assert.assertTrue(collection.retainAll(FloatArrayList.newListWith(1.0f, 5.0f)));
        Assert.assertTrue(collection.contains(1.0f));
        Assert.assertFalse(collection.contains(2.0f));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertTrue(map.contains(1.0f));
        Assert.assertFalse(map.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(collection.retainAll(FloatArrayList.newListWith(3.0f, 2.0f)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertFalse(collection.contains(2.0f));
        Assert.assertFalse(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertFalse(map.contains(2.0f));
        Assert.assertFalse(map.contains(3.0f));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableFloatCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        CharFloatHashMap map = CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        MutableFloatCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0.0f));
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertFalse(collection.contains(2.0f));
        Assert.assertFalse(collection.contains(3.0f));
        MutableFloatCollection collection1 = this.newWith(0.0f, 1.0f, 31.0f, 32.0f);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0.0f));
        Assert.assertFalse(collection1.contains(1.0f));
        Assert.assertFalse(collection1.contains(31.0f));
        Assert.assertFalse(collection1.contains(32.0f));
        MutableFloatCollection collection2 = this.newWith(0.0f, 1.0f, 2.0f);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains() {
        MutableFloatCollection collection = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));
        float[] numbers = { 14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f };
        for (float number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));
    }

    @Override
    @Test
    public void reject() {
        FloatIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(1, iterable.reject(FloatPredicates.lessThan(3.0f)));
    }

    @Override
    @Test
    public void select() {
        FloatIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(2, iterable.select(FloatPredicates.lessThan(3.0f)));
    }

    @Override
    @Test
    public void collect() {
        FloatToObjectFunction<Float> function = (float parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 2.0f).toBag(), this.newWith(1.0f, 2.0f, 3.0f).collect(function).toBag());
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 2.0f).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2.0f), this.newWith(3.0f).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1.0", this.newWith(1.0f).makeString("/"));
        Assert.assertEquals("31.0", this.newWith(31.0f).makeString());
        Assert.assertEquals("32.0", this.newWith(32.0f).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0.0, 31.0") || iterable1.makeString().equals("31.0, 0.0"));
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31.0/32.0]") || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));
        FloatIterable iterable3 = this.newWith(32.0f, 33.0f);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32.0/33.0") || iterable3.makeString("/").equals("33.0/32.0"));
        FloatIterable iterable4 = this.newWith(1.0f, 2.0f);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString()) || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/")) || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]")) || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
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
        this.newWith(1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        FloatIterable iterable = this.newWith(1.0f, 2.0f);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString()) || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString()) || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31.0f).appendString(appendable5);
        Assert.assertEquals("31.0", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32.0f).appendString(appendable6);
        Assert.assertEquals("32.0", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString()) || "31.0, 0.0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString()) || "32.0/31.0".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        FloatIterable iterable4 = this.newWith(32.0f, 33.0f);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString()) || "[33.0/32.0]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
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
        // Testing equals() is not applicable for MutableFloatCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableFloatCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableFloatCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableFloatCollection.
    }

    @Override
    @Test
    public void chunk() {
        FloatIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f), FloatBags.mutable.with(2.0f), FloatBags.mutable.with(3.0f)).toSet(), iterable.chunk(1).toSet());
        MutableSet<FloatIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f), FloatBags.mutable.with(3.0f)).toSet().equals(chunked) || Lists.mutable.with(FloatBags.mutable.with(2.0f, 3.0f), FloatBags.mutable.with(1.0f)).toSet().equals(chunked) || Lists.mutable.with(FloatBags.mutable.with(1.0f, 3.0f), FloatBags.mutable.with(2.0f)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedCharFloatMapValuesTest instance;

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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedCharFloatMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedCharFloatMapValuesTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedCharFloatMapValuesTest::newCollection;
            this.payloads.isEmpty = SynchronizedCharFloatMapValuesTest::isEmpty;
            this.payloads.notEmpty = SynchronizedCharFloatMapValuesTest::notEmpty;
            this.payloads.tap = SynchronizedCharFloatMapValuesTest::tap;
            this.payloads.contains_NaN = SynchronizedCharFloatMapValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedCharFloatMapValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedCharFloatMapValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedCharFloatMapValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = SynchronizedCharFloatMapValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedCharFloatMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedCharFloatMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedCharFloatMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedCharFloatMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedCharFloatMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedCharFloatMapValuesTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedCharFloatMapValuesTest::forEach;
            this.payloads.size = SynchronizedCharFloatMapValuesTest::size;
            this.payloads.count = SynchronizedCharFloatMapValuesTest::count;
            this.payloads.anySatisfy = SynchronizedCharFloatMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedCharFloatMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedCharFloatMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = SynchronizedCharFloatMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedCharFloatMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedCharFloatMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedCharFloatMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedCharFloatMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedCharFloatMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedCharFloatMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedCharFloatMapValuesTest::detectIfNone;
            this.payloads.max = SynchronizedCharFloatMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedCharFloatMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedCharFloatMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedCharFloatMapValuesTest::maxIfEmpty;
            this.payloads.sum = SynchronizedCharFloatMapValuesTest::sum;
            this.payloads.summaryStatistics = SynchronizedCharFloatMapValuesTest::summaryStatistics;
            this.payloads.average = SynchronizedCharFloatMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedCharFloatMapValuesTest::averageIfEmpty;
            this.payloads.median = SynchronizedCharFloatMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedCharFloatMapValuesTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedCharFloatMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedCharFloatMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedCharFloatMapValuesTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedCharFloatMapValuesTest::testHashCode;
            this.payloads.testToString = SynchronizedCharFloatMapValuesTest::testToString;
            this.payloads.toList = SynchronizedCharFloatMapValuesTest::toList;
            this.payloads.toSortedList = SynchronizedCharFloatMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedCharFloatMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedCharFloatMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedCharFloatMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedCharFloatMapValuesTest::toSet;
            this.payloads.toBag = SynchronizedCharFloatMapValuesTest::toBag;
            this.payloads.asLazy = SynchronizedCharFloatMapValuesTest::asLazy;
            this.payloads.injectInto = SynchronizedCharFloatMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedCharFloatMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedCharFloatMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedCharFloatMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedCharFloatMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedCharFloatMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedCharFloatMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedCharFloatMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedCharFloatMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedCharFloatMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedCharFloatMapValuesTest::reduceIfEmpty;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = SynchronizedCharFloatMapValuesTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = SynchronizedCharFloatMapValuesTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = SynchronizedCharFloatMapValuesTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedCharFloatMapValuesTest::newEmpty;
            this.payloads.floatIterator = SynchronizedCharFloatMapValuesTest::floatIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = SynchronizedCharFloatMapValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedCharFloatMapValuesTest::without;
            this.payloads.withoutAll = SynchronizedCharFloatMapValuesTest::withoutAll;
            this.payloads.remove = SynchronizedCharFloatMapValuesTest::remove;
            this.payloads.removeIf = SynchronizedCharFloatMapValuesTest::removeIf;
            this.payloads.sumConsistentRounding = SynchronizedCharFloatMapValuesTest::sumConsistentRounding;
            this.payloads.asSynchronized = SynchronizedCharFloatMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedCharFloatMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = SynchronizedCharFloatMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedCharFloatMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedCharFloatMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedCharFloatMapValuesTest::retainAll_iterable;
            this.payloads.clear = SynchronizedCharFloatMapValuesTest::clear;
            this.payloads.contains = SynchronizedCharFloatMapValuesTest::contains;
            this.payloads.reject = SynchronizedCharFloatMapValuesTest::reject;
            this.payloads.select = SynchronizedCharFloatMapValuesTest::select;
            this.payloads.collect = SynchronizedCharFloatMapValuesTest::collect;
            this.payloads.makeString = SynchronizedCharFloatMapValuesTest::makeString;
            this.payloads.appendString = SynchronizedCharFloatMapValuesTest::appendString;
            this.payloads.testEquals = SynchronizedCharFloatMapValuesTest::testEquals;
            this.payloads.chunk = SynchronizedCharFloatMapValuesTest::chunk;
        }
    }
}
