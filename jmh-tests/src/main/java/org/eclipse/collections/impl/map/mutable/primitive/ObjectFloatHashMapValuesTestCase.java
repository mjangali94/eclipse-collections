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
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedFloatCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableFloatCollection;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveHashMapValuesTestCase.stg.
 */
public abstract class ObjectFloatHashMapValuesTestCase extends AbstractMutableFloatCollectionTestCase {

    public abstract MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1);

    public abstract MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2);

    public abstract MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3);

    public abstract MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3, String key4, float value4);

    public abstract MutableObjectFloatMap<String> newEmptyMap();

    @Override
    protected MutableFloatCollection classUnderTest() {
        return this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f).values();
    }

    @Override
    protected MutableFloatCollection newWith(float... elements) {
        MutableObjectFloatMap map = this.newEmptyMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(String.valueOf(i), elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableFloatCollection newMutableCollectionWith(float... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableList<Float> newObjectCollectionWith(Float... elements) {
        return FastList.newListWith(elements);
    }

    @Override
    @Test
    public void floatIterator() {
        MutableFloatCollection bag = this.newWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatArrayList list = FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatIterator iterator1 = bag.floatIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator1.hasNext());
            Assert.assertTrue(list.remove(iterator1.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator1.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator1::next);
        MutableObjectFloatMap<String> map2 = new ObjectFloatHashMap<>();
        for (float each = 2.0f; each < 100.0f; each++) {
            map2.put(String.valueOf(each), each);
        }
        MutableFloatIterator iterator2 = map2.floatIterator();
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
        Assert.assertTrue(map2.isEmpty());
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
    public void without() {
        this.classUnderTest().without(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new FloatArrayList());
    }

    @Override
    @Test
    public void remove() {
        MutableObjectFloatMap<String> map = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
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
        MutableObjectFloatMap<String> map = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
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
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1.0f));
        MutableObjectFloatMap<String> map = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
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
        MutableObjectFloatMap<String> map = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
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
        MutableObjectFloatMap<String> map = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(1.0f, 2.0f, 3.0f));
        Assert.assertTrue(collection.retainAll(2.0f, 3.0f, 5.0f));
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertTrue(collection.contains(2.0f));
        Assert.assertTrue(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertTrue(map.contains(2.0f));
        Assert.assertTrue(map.contains(3.0f));
        Assert.assertTrue(collection.retainAll(1.0f, 0.0f, 4.0f));
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
        MutableObjectFloatMap<String> map = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
        MutableFloatCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Assert.assertTrue(collection.retainAll(FloatArrayList.newListWith(2.0f, 3.0f, 5.0f)));
        Assert.assertFalse(collection.contains(1.0f));
        Assert.assertTrue(collection.contains(2.0f));
        Assert.assertTrue(collection.contains(3.0f));
        Assert.assertFalse(map.contains(1.0f));
        Assert.assertTrue(map.contains(2.0f));
        Assert.assertTrue(map.contains(3.0f));
        Assert.assertTrue(collection.retainAll(FloatArrayList.newListWith(1.0f, 0.0f, 4.0f)));
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
        MutableObjectFloatMap<String> map = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
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
    public void asSynchronized() {
        MutableFloatCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedFloatCollection.class, this.classUnderTest().asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableFloatCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableFloatCollection.class, this.classUnderTest().asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
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
        FloatIterable iterable = this.newMapWithKeysValues(String.valueOf(1), 1.0f, String.valueOf(2), 2.0f, String.valueOf(3), 3.0f);
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

        private ObjectFloatHashMapValuesTestCase instance;

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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatHashMapValuesTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapValuesTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectFloatHashMapValuesTestCase::newCollectionWith;
            this.payloads.newCollection = ObjectFloatHashMapValuesTestCase::newCollection;
            this.payloads.isEmpty = ObjectFloatHashMapValuesTestCase::isEmpty;
            this.payloads.notEmpty = ObjectFloatHashMapValuesTestCase::notEmpty;
            this.payloads.tap = ObjectFloatHashMapValuesTestCase::tap;
            this.payloads.contains_NaN = ObjectFloatHashMapValuesTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ObjectFloatHashMapValuesTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ObjectFloatHashMapValuesTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ObjectFloatHashMapValuesTestCase::contains_zero;
            this.payloads.contains_different_NaNs = ObjectFloatHashMapValuesTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = ObjectFloatHashMapValuesTestCase::containsAllArray;
            this.payloads.containsAllIterable = ObjectFloatHashMapValuesTestCase::containsAllIterable;
            this.payloads.containsAnyArray = ObjectFloatHashMapValuesTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectFloatHashMapValuesTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectFloatHashMapValuesTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectFloatHashMapValuesTestCase::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectFloatHashMapValuesTestCase::forEach;
            this.payloads.size = ObjectFloatHashMapValuesTestCase::size;
            this.payloads.count = ObjectFloatHashMapValuesTestCase::count;
            this.payloads.anySatisfy = ObjectFloatHashMapValuesTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectFloatHashMapValuesTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectFloatHashMapValuesTestCase::noneSatisfy;
            this.payloads.collectWithTarget = ObjectFloatHashMapValuesTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectFloatHashMapValuesTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectFloatHashMapValuesTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectFloatHashMapValuesTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectFloatHashMapValuesTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectFloatHashMapValuesTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectFloatHashMapValuesTestCase::rejectWithTarget;
            this.payloads.detectIfNone = ObjectFloatHashMapValuesTestCase::detectIfNone;
            this.payloads.max = ObjectFloatHashMapValuesTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectFloatHashMapValuesTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectFloatHashMapValuesTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectFloatHashMapValuesTestCase::maxIfEmpty;
            this.payloads.sum = ObjectFloatHashMapValuesTestCase::sum;
            this.payloads.summaryStatistics = ObjectFloatHashMapValuesTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = ObjectFloatHashMapValuesTestCase::sumConsistentRounding;
            this.payloads.average = ObjectFloatHashMapValuesTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectFloatHashMapValuesTestCase::averageIfEmpty;
            this.payloads.median = ObjectFloatHashMapValuesTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectFloatHashMapValuesTestCase::medianIfEmpty;
            this.payloads.toArray = ObjectFloatHashMapValuesTestCase::toArray;
            this.payloads.toArrayWithTargetArray = ObjectFloatHashMapValuesTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectFloatHashMapValuesTestCase::toSortedArray;
            this.payloads.testHashCode = ObjectFloatHashMapValuesTestCase::testHashCode;
            this.payloads.testToString = ObjectFloatHashMapValuesTestCase::testToString;
            this.payloads.toList = ObjectFloatHashMapValuesTestCase::toList;
            this.payloads.toSortedList = ObjectFloatHashMapValuesTestCase::toSortedList;
            this.payloads.toSortedListByComparator = ObjectFloatHashMapValuesTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectFloatHashMapValuesTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectFloatHashMapValuesTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectFloatHashMapValuesTestCase::toSet;
            this.payloads.toBag = ObjectFloatHashMapValuesTestCase::toBag;
            this.payloads.asLazy = ObjectFloatHashMapValuesTestCase::asLazy;
            this.payloads.injectInto = ObjectFloatHashMapValuesTestCase::injectInto;
            this.payloads.injectIntoBoolean = ObjectFloatHashMapValuesTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectFloatHashMapValuesTestCase::injectIntoByte;
            this.payloads.injectIntoChar = ObjectFloatHashMapValuesTestCase::injectIntoChar;
            this.payloads.injectIntoShort = ObjectFloatHashMapValuesTestCase::injectIntoShort;
            this.payloads.injectIntoInt = ObjectFloatHashMapValuesTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectFloatHashMapValuesTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectFloatHashMapValuesTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectFloatHashMapValuesTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectFloatHashMapValuesTestCase::reduce;
            this.payloads.reduceIfEmpty = ObjectFloatHashMapValuesTestCase::reduceIfEmpty;
            this.payloads.testEquals = ObjectFloatHashMapValuesTestCase::testEquals;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = ObjectFloatHashMapValuesTestCase::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = ObjectFloatHashMapValuesTestCase::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = ObjectFloatHashMapValuesTestCase::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectFloatHashMapValuesTestCase::newEmpty;
            this.payloads.floatIterator = ObjectFloatHashMapValuesTestCase::floatIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = ObjectFloatHashMapValuesTestCase::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapValuesTestCase::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectFloatHashMapValuesTestCase::remove;
            this.payloads.removeIf = ObjectFloatHashMapValuesTestCase::removeIf;
            this.payloads.removeAll = ObjectFloatHashMapValuesTestCase::removeAll;
            this.payloads.removeAll_iterable = ObjectFloatHashMapValuesTestCase::removeAll_iterable;
            this.payloads.retainAll = ObjectFloatHashMapValuesTestCase::retainAll;
            this.payloads.retainAll_iterable = ObjectFloatHashMapValuesTestCase::retainAll_iterable;
            this.payloads.clear = ObjectFloatHashMapValuesTestCase::clear;
            this.payloads.contains = ObjectFloatHashMapValuesTestCase::contains;
            this.payloads.reject = ObjectFloatHashMapValuesTestCase::reject;
            this.payloads.select = ObjectFloatHashMapValuesTestCase::select;
            this.payloads.collect = ObjectFloatHashMapValuesTestCase::collect;
            this.payloads.makeString = ObjectFloatHashMapValuesTestCase::makeString;
            this.payloads.appendString = ObjectFloatHashMapValuesTestCase::appendString;
            this.payloads.asSynchronized = ObjectFloatHashMapValuesTestCase::asSynchronized;
            this.payloads.asUnmodifiable = ObjectFloatHashMapValuesTestCase::asUnmodifiable;
            this.payloads.chunk = ObjectFloatHashMapValuesTestCase::chunk;
        }
    }
}
