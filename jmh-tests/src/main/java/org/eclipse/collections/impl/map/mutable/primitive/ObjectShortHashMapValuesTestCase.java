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
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedShortCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableShortCollection;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveHashMapValuesTestCase.stg.
 */
public abstract class ObjectShortHashMapValuesTestCase extends AbstractMutableShortCollectionTestCase {

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1);

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2);

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3);

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3, String key4, short value4);

    public abstract MutableObjectShortMap<String> newEmptyMap();

    @Override
    protected MutableShortCollection classUnderTest() {
        return this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3).values();
    }

    @Override
    protected MutableShortCollection newWith(short... elements) {
        MutableObjectShortMap map = this.newEmptyMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(String.valueOf(i), elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableShortCollection newMutableCollectionWith(short... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableList<Short> newObjectCollectionWith(Short... elements) {
        return FastList.newListWith(elements);
    }

    @Override
    @Test
    public void shortIterator() {
        MutableShortCollection bag = this.newWith((short) 0, (short) 1, (short) 2, (short) 3);
        ShortArrayList list = ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3);
        ShortIterator iterator1 = bag.shortIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator1.hasNext());
            Assert.assertTrue(list.remove(iterator1.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator1.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator1::next);
        MutableObjectShortMap<String> map2 = new ObjectShortHashMap<>();
        for (short each = (short) 2; each < (short) 100; each++) {
            map2.put(String.valueOf(each), each);
        }
        MutableShortIterator iterator2 = map2.shortIterator();
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
        Assert.assertTrue(map2.isEmpty());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll((short) 0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new ShortArrayList());
    }

    @Override
    @Test
    public void remove() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertTrue(collection.remove((short) 3));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertTrue(collection.contains((short) 1));
        Assert.assertTrue(collection.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(map.contains((short) 1));
        Assert.assertTrue(map.contains((short) 2));
    }

    @Override
    @Test
    public void removeIf() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(ShortPredicates.equal((short) 3)));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertTrue(collection.contains((short) 1));
        Assert.assertTrue(collection.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(map.contains((short) 1));
        Assert.assertTrue(map.contains((short) 2));
        Assert.assertFalse(collection.removeIf(ShortPredicates.equal((short) 3)));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll((short) 1));
        MutableObjectShortMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll((short) 1, (short) 5));
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertTrue(collection.contains((short) 2));
        Assert.assertTrue(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertTrue(map.contains((short) 2));
        Assert.assertTrue(map.contains((short) 3));
        Assert.assertTrue(collection.removeAll((short) 3, (short) 2));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertFalse(map.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new ShortArrayList()));
        Assert.assertFalse(this.newWith().removeAll(ShortArrayList.newListWith((short) 1)));
        MutableObjectShortMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(ShortArrayList.newListWith((short) 1, (short) 5)));
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertTrue(collection.contains((short) 2));
        Assert.assertTrue(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertTrue(map.contains((short) 2));
        Assert.assertTrue(map.contains((short) 3));
        Assert.assertTrue(collection.removeAll(ShortArrayList.newListWith((short) 3, (short) 2)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertFalse(map.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll((short) 1));
        MutableObjectShortMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertFalse(collection.retainAll((short) 1, (short) 2, (short) 3));
        Assert.assertTrue(collection.retainAll((short) 2, (short) 3, (short) 5));
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertTrue(collection.contains((short) 2));
        Assert.assertTrue(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertTrue(map.contains((short) 2));
        Assert.assertTrue(map.contains((short) 3));
        Assert.assertTrue(collection.retainAll((short) 1, (short) 0, (short) 4));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertFalse(map.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new ShortArrayList()));
        Assert.assertFalse(this.newWith().retainAll(ShortArrayList.newListWith((short) 1)));
        MutableObjectShortMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Assert.assertTrue(collection.retainAll(ShortArrayList.newListWith((short) 2, (short) 3, (short) 5)));
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertTrue(collection.contains((short) 2));
        Assert.assertTrue(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertTrue(map.contains((short) 2));
        Assert.assertTrue(map.contains((short) 3));
        Assert.assertTrue(collection.retainAll(ShortArrayList.newListWith((short) 1, (short) 0, (short) 4)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertFalse(map.contains((short) 1));
        Assert.assertFalse(map.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableShortCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableObjectShortMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        MutableShortCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains((short) 0));
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        MutableShortCollection collection1 = this.newWith((short) 0, (short) 1, (short) 31, (short) 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains((short) 0));
        Assert.assertFalse(collection1.contains((short) 1));
        Assert.assertFalse(collection1.contains((short) 31));
        Assert.assertFalse(collection1.contains((short) 32));
        MutableShortCollection collection2 = this.newWith((short) 0, (short) 1, (short) 2);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains() {
        MutableShortCollection collection = this.newWith((short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertFalse(collection.contains((short) 29));
        Assert.assertFalse(collection.contains((short) 49));
        short[] numbers = { (short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1 };
        for (short number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((short) 29));
        Assert.assertFalse(collection.contains((short) 49));
    }

    @Override
    @Test
    public void reject() {
        ShortIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(ShortPredicates.lessThan((short) 4)));
        Verify.assertSize(1, iterable.reject(ShortPredicates.lessThan((short) 3)));
    }

    @Override
    @Test
    public void select() {
        ShortIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(ShortPredicates.lessThan((short) 4)));
        Verify.assertSize(2, iterable.select(ShortPredicates.lessThan((short) 3)));
    }

    @Override
    @Test
    public void collect() {
        ShortToObjectFunction<Short> function = (short parameter) -> (short) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((short) 0, (short) 1, (short) 2).toBag(), this.newWith((short) 1, (short) 2, (short) 3).collect(function).toBag());
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(this.newObjectCollectionWith((short) 0, (short) 1, (short) 2).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((short) 2), this.newWith((short) 3).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1", this.newWith((short) 1).makeString("/"));
        Assert.assertEquals("31", this.newWith((short) 31).makeString());
        Assert.assertEquals("32", this.newWith((short) 32).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        ShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        ShortIterable iterable3 = this.newWith((short) 32, (short) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        ShortIterable iterable4 = this.newWith((short) 1, (short) 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        ShortIterable iterable5 = this.newWith((short) 0, (short) 1);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0, 1") || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0/1]") || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0/1") || iterable5.makeString("/").equals("1/0"));
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
        this.newWith((short) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        ShortIterable iterable = this.newWith((short) 1, (short) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith((short) 31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith((short) 32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        ShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        ShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        ShortIterable iterable4 = this.newWith((short) 32, (short) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        ShortIterable iterable5 = this.newWith((short) 0, (short) 1);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0, 1".equals(appendable10.toString()) || "1, 0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0/1".equals(appendable11.toString()) || "1/0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0/1]".equals(appendable12.toString()) || "[1/0]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableShortCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedShortCollection.class, this.classUnderTest().asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableShortCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableShortCollection.class, this.classUnderTest().asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    public void testEquals() {
        // Testing equals() is not applicable for MutableShortCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableShortCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableShortCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableShortCollection.
    }

    @Override
    @Test
    public void chunk() {
        ShortIterable iterable = this.newMapWithKeysValues(String.valueOf(1), (short) 1, String.valueOf(2), (short) 2, String.valueOf(3), (short) 3);
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1), ShortBags.mutable.with((short) 2), ShortBags.mutable.with((short) 3)).toSet(), iterable.chunk(1).toSet());
        MutableSet<ShortIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2), ShortBags.mutable.with((short) 3)).toSet().equals(chunked) || Lists.mutable.with(ShortBags.mutable.with((short) 2, (short) 3), ShortBags.mutable.with((short) 1)).toSet().equals(chunked) || Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 3), ShortBags.mutable.with((short) 2)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortHashMapValuesTestCase instance;

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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortHashMapValuesTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapValuesTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectShortHashMapValuesTestCase::newCollectionWith;
            this.payloads.newCollection = ObjectShortHashMapValuesTestCase::newCollection;
            this.payloads.isEmpty = ObjectShortHashMapValuesTestCase::isEmpty;
            this.payloads.notEmpty = ObjectShortHashMapValuesTestCase::notEmpty;
            this.payloads.tap = ObjectShortHashMapValuesTestCase::tap;
            this.payloads.containsAllArray = ObjectShortHashMapValuesTestCase::containsAllArray;
            this.payloads.containsAllIterable = ObjectShortHashMapValuesTestCase::containsAllIterable;
            this.payloads.containsAnyArray = ObjectShortHashMapValuesTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectShortHashMapValuesTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectShortHashMapValuesTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectShortHashMapValuesTestCase::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectShortHashMapValuesTestCase::forEach;
            this.payloads.size = ObjectShortHashMapValuesTestCase::size;
            this.payloads.count = ObjectShortHashMapValuesTestCase::count;
            this.payloads.anySatisfy = ObjectShortHashMapValuesTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectShortHashMapValuesTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectShortHashMapValuesTestCase::noneSatisfy;
            this.payloads.collectWithTarget = ObjectShortHashMapValuesTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectShortHashMapValuesTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectShortHashMapValuesTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectShortHashMapValuesTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectShortHashMapValuesTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectShortHashMapValuesTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectShortHashMapValuesTestCase::rejectWithTarget;
            this.payloads.detectIfNone = ObjectShortHashMapValuesTestCase::detectIfNone;
            this.payloads.max = ObjectShortHashMapValuesTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectShortHashMapValuesTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectShortHashMapValuesTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectShortHashMapValuesTestCase::maxIfEmpty;
            this.payloads.sum = ObjectShortHashMapValuesTestCase::sum;
            this.payloads.summaryStatistics = ObjectShortHashMapValuesTestCase::summaryStatistics;
            this.payloads.average = ObjectShortHashMapValuesTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectShortHashMapValuesTestCase::averageIfEmpty;
            this.payloads.median = ObjectShortHashMapValuesTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectShortHashMapValuesTestCase::medianIfEmpty;
            this.payloads.toArray = ObjectShortHashMapValuesTestCase::toArray;
            this.payloads.toArrayWithTargetArray = ObjectShortHashMapValuesTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectShortHashMapValuesTestCase::toSortedArray;
            this.payloads.testHashCode = ObjectShortHashMapValuesTestCase::testHashCode;
            this.payloads.testToString = ObjectShortHashMapValuesTestCase::testToString;
            this.payloads.toList = ObjectShortHashMapValuesTestCase::toList;
            this.payloads.toSortedList = ObjectShortHashMapValuesTestCase::toSortedList;
            this.payloads.toSortedListByComparator = ObjectShortHashMapValuesTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectShortHashMapValuesTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectShortHashMapValuesTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectShortHashMapValuesTestCase::toSet;
            this.payloads.toBag = ObjectShortHashMapValuesTestCase::toBag;
            this.payloads.asLazy = ObjectShortHashMapValuesTestCase::asLazy;
            this.payloads.injectInto = ObjectShortHashMapValuesTestCase::injectInto;
            this.payloads.injectIntoBoolean = ObjectShortHashMapValuesTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectShortHashMapValuesTestCase::injectIntoByte;
            this.payloads.injectIntoChar = ObjectShortHashMapValuesTestCase::injectIntoChar;
            this.payloads.injectIntoShort = ObjectShortHashMapValuesTestCase::injectIntoShort;
            this.payloads.injectIntoInt = ObjectShortHashMapValuesTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectShortHashMapValuesTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectShortHashMapValuesTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectShortHashMapValuesTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectShortHashMapValuesTestCase::reduce;
            this.payloads.reduceIfEmpty = ObjectShortHashMapValuesTestCase::reduceIfEmpty;
            this.payloads.testEquals = ObjectShortHashMapValuesTestCase::testEquals;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = ObjectShortHashMapValuesTestCase::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = ObjectShortHashMapValuesTestCase::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = ObjectShortHashMapValuesTestCase::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectShortHashMapValuesTestCase::newEmpty;
            this.payloads.shortIterator = ObjectShortHashMapValuesTestCase::shortIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapValuesTestCase::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectShortHashMapValuesTestCase::remove;
            this.payloads.removeIf = ObjectShortHashMapValuesTestCase::removeIf;
            this.payloads.removeAll = ObjectShortHashMapValuesTestCase::removeAll;
            this.payloads.removeAll_iterable = ObjectShortHashMapValuesTestCase::removeAll_iterable;
            this.payloads.retainAll = ObjectShortHashMapValuesTestCase::retainAll;
            this.payloads.retainAll_iterable = ObjectShortHashMapValuesTestCase::retainAll_iterable;
            this.payloads.clear = ObjectShortHashMapValuesTestCase::clear;
            this.payloads.contains = ObjectShortHashMapValuesTestCase::contains;
            this.payloads.reject = ObjectShortHashMapValuesTestCase::reject;
            this.payloads.select = ObjectShortHashMapValuesTestCase::select;
            this.payloads.collect = ObjectShortHashMapValuesTestCase::collect;
            this.payloads.makeString = ObjectShortHashMapValuesTestCase::makeString;
            this.payloads.appendString = ObjectShortHashMapValuesTestCase::appendString;
            this.payloads.asSynchronized = ObjectShortHashMapValuesTestCase::asSynchronized;
            this.payloads.asUnmodifiable = ObjectShortHashMapValuesTestCase::asUnmodifiable;
            this.payloads.chunk = ObjectShortHashMapValuesTestCase::chunk;
        }
    }
}
