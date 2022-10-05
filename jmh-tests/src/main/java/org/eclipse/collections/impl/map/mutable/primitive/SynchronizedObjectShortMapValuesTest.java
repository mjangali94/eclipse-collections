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
import org.eclipse.collections.api.list.MutableList;
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
 * JUnit test for {@link SynchronizedObjectShortMap#values()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapValuesTest.stg.
 */
public class SynchronizedObjectShortMapValuesTest extends AbstractMutableShortCollectionTestCase {

    @Override
    protected MutableShortCollection classUnderTest() {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3)).values();
    }

    @Override
    protected MutableShortCollection newWith(short... elements) {
        ObjectShortHashMap<Integer> map = new ObjectShortHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.asSynchronized().values();
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
        ShortIterator iterator = bag.shortIterator();
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
    public void withAll() {
        this.classUnderTest().withAll(new ShortArrayList());
    }

    @Override
    @Test
    public void without() {
        MutableShortCollection collection = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortCollection collectionWithout = collection.without((short) 2);
        Assert.assertSame(collection, collectionWithout);
        MutableShortCollection expectedCollection = this.newWith((short) 1, (short) 3);
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.toList());
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.without((short) 4).toList());
    }

    @Override
    @Test
    public void withoutAll() {
        MutableShortCollection collection = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortCollection collectionWithout = collection.withoutAll(new ShortArrayList((short) 2, (short) 4));
        Assert.assertSame(collection, collectionWithout);
        MutableShortCollection expectedCollection = this.newWith((short) 1, (short) 3);
        Assert.assertEquals(expectedCollection.toList(), collectionWithout.toList());
    }

    @Override
    @Test
    public void remove() {
        ObjectShortHashMap<Integer> map = ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
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
        ObjectShortHashMap<Integer> map = ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
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
        ObjectShortHashMap<Integer> map = ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
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
        ObjectShortHashMap<Integer> map = ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
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
        ObjectShortHashMap<Integer> map = ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertFalse(collection.retainAll((short) 1, (short) 2, (short) 3));
        Assert.assertTrue(collection.retainAll((short) 1, (short) 5));
        Assert.assertTrue(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertTrue(map.contains((short) 1));
        Assert.assertFalse(map.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(collection.retainAll((short) 3, (short) 2));
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
        ObjectShortHashMap<Integer> map = ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
        MutableShortCollection collection = map.values();
        Assert.assertFalse(collection.retainAll((short) 1, (short) 2, (short) 3));
        Assert.assertTrue(collection.retainAll(ShortArrayList.newListWith((short) 1, (short) 5)));
        Assert.assertTrue(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        Assert.assertTrue(map.contains((short) 1));
        Assert.assertFalse(map.contains((short) 2));
        Assert.assertFalse(map.contains((short) 3));
        Assert.assertTrue(collection.retainAll(ShortArrayList.newListWith((short) 3, (short) 2)));
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
        ObjectShortHashMap<Integer> map = ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
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
        ShortIterable iterable = this.classUnderTest();
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

        private SynchronizedObjectShortMapValuesTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedObjectShortMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedObjectShortMapValuesTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedObjectShortMapValuesTest::newCollection;
            this.payloads.isEmpty = SynchronizedObjectShortMapValuesTest::isEmpty;
            this.payloads.notEmpty = SynchronizedObjectShortMapValuesTest::notEmpty;
            this.payloads.tap = SynchronizedObjectShortMapValuesTest::tap;
            this.payloads.containsAllArray = SynchronizedObjectShortMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedObjectShortMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedObjectShortMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedObjectShortMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedObjectShortMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedObjectShortMapValuesTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedObjectShortMapValuesTest::forEach;
            this.payloads.size = SynchronizedObjectShortMapValuesTest::size;
            this.payloads.count = SynchronizedObjectShortMapValuesTest::count;
            this.payloads.anySatisfy = SynchronizedObjectShortMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedObjectShortMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedObjectShortMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = SynchronizedObjectShortMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedObjectShortMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedObjectShortMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedObjectShortMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedObjectShortMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = SynchronizedObjectShortMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = SynchronizedObjectShortMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedObjectShortMapValuesTest::detectIfNone;
            this.payloads.max = SynchronizedObjectShortMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedObjectShortMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedObjectShortMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedObjectShortMapValuesTest::maxIfEmpty;
            this.payloads.sum = SynchronizedObjectShortMapValuesTest::sum;
            this.payloads.summaryStatistics = SynchronizedObjectShortMapValuesTest::summaryStatistics;
            this.payloads.average = SynchronizedObjectShortMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedObjectShortMapValuesTest::averageIfEmpty;
            this.payloads.median = SynchronizedObjectShortMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedObjectShortMapValuesTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedObjectShortMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedObjectShortMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedObjectShortMapValuesTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedObjectShortMapValuesTest::testHashCode;
            this.payloads.testToString = SynchronizedObjectShortMapValuesTest::testToString;
            this.payloads.toList = SynchronizedObjectShortMapValuesTest::toList;
            this.payloads.toSortedList = SynchronizedObjectShortMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedObjectShortMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedObjectShortMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedObjectShortMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedObjectShortMapValuesTest::toSet;
            this.payloads.toBag = SynchronizedObjectShortMapValuesTest::toBag;
            this.payloads.asLazy = SynchronizedObjectShortMapValuesTest::asLazy;
            this.payloads.injectInto = SynchronizedObjectShortMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedObjectShortMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedObjectShortMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedObjectShortMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedObjectShortMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedObjectShortMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedObjectShortMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedObjectShortMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedObjectShortMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedObjectShortMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedObjectShortMapValuesTest::reduceIfEmpty;
            this.payloads.testEquals = SynchronizedObjectShortMapValuesTest::testEquals;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = SynchronizedObjectShortMapValuesTest::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = SynchronizedObjectShortMapValuesTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = SynchronizedObjectShortMapValuesTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedObjectShortMapValuesTest::newEmpty;
            this.payloads.shortIterator = SynchronizedObjectShortMapValuesTest::shortIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = SynchronizedObjectShortMapValuesTest::without;
            this.payloads.withoutAll = SynchronizedObjectShortMapValuesTest::withoutAll;
            this.payloads.remove = SynchronizedObjectShortMapValuesTest::remove;
            this.payloads.removeIf = SynchronizedObjectShortMapValuesTest::removeIf;
            this.payloads.removeAll = SynchronizedObjectShortMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedObjectShortMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedObjectShortMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedObjectShortMapValuesTest::retainAll_iterable;
            this.payloads.clear = SynchronizedObjectShortMapValuesTest::clear;
            this.payloads.contains = SynchronizedObjectShortMapValuesTest::contains;
            this.payloads.reject = SynchronizedObjectShortMapValuesTest::reject;
            this.payloads.select = SynchronizedObjectShortMapValuesTest::select;
            this.payloads.collect = SynchronizedObjectShortMapValuesTest::collect;
            this.payloads.makeString = SynchronizedObjectShortMapValuesTest::makeString;
            this.payloads.appendString = SynchronizedObjectShortMapValuesTest::appendString;
            this.payloads.asSynchronized = SynchronizedObjectShortMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedObjectShortMapValuesTest::asUnmodifiable;
            this.payloads.chunk = SynchronizedObjectShortMapValuesTest::chunk;
        }
    }
}
