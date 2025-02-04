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
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableLongCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedLongCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableLongCollection;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteLongHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class ByteLongHashMapValuesTest extends AbstractMutableLongCollectionTestCase {

    @Override
    protected MutableLongCollection classUnderTest() {
        return ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L).values();
    }

    @Override
    protected MutableLongCollection newWith(long... elements) {
        ByteLongHashMap map = new ByteLongHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((byte) i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableLongCollection newMutableCollectionWith(long... elements) {
        return this.newWith(elements);
    }

    @Override
    protected Bag<Long> newObjectCollectionWith(Long... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void longIterator() {
        MutableLongCollection bag = this.newWith(0L, 1L, 2L, 3L);
        LongArrayList list = LongArrayList.newListWith(0L, 1L, 2L, 3L);
        LongIterator iterator = bag.longIterator();
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
        this.classUnderTest().addAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0L, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new LongArrayList());
    }

    @Override
    @Test
    public void remove() {
        ByteLongHashMap map = ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertTrue(collection.remove(3L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertTrue(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
    }

    @Override
    @Test
    public void removeIf() {
        ByteLongHashMap map = ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(LongPredicates.equal(3L)));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertTrue(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertFalse(collection.removeIf(LongPredicates.equal(3L)));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableLongCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedLongCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableLongCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableLongCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1L));
        ByteLongHashMap map = ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(1L, 5L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertTrue(collection.removeAll(3L, 2L));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.isEmpty());
        map = ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 2, 2L, (byte) 3, 3L);
        collection = map.values();
        Assert.assertTrue(collection.removeAll(0L, 5L));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new LongArrayList()));
        Assert.assertFalse(this.newWith().removeAll(LongArrayList.newListWith(1L)));
        ByteLongHashMap map = ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(LongArrayList.newListWith(1L, 5L)));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertTrue(collection.removeAll(LongArrayList.newListWith(3L, 2L)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(1L));
        ByteLongHashMap map = ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(0L, 1L, 2L, 3L));
        Assert.assertTrue(collection.retainAll(0L, 2L, 3L, 5L));
        Assert.assertTrue(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertTrue(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(collection.retainAll(2L, 3L, 5L));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(collection.retainAll(3L, 5L));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(collection.retainAll(0L, 0L, 1L));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new LongArrayList()));
        Assert.assertFalse(this.newWith().retainAll(LongArrayList.newListWith(1L)));
        ByteLongHashMap map = ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(LongArrayList.newListWith(0L, 1L, 2L, 3L)));
        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(0L, 2L, 3L, 5L)));
        Assert.assertTrue(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertTrue(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(2L, 3L, 5L)));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(3L, 5L)));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(0L, 0L, 1L)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableLongCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        ByteLongHashMap map = ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        MutableLongCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        MutableLongCollection collection1 = this.newWith(0L, 1L, 31L, 32L);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0L));
        Assert.assertFalse(collection1.contains(1L));
        Assert.assertFalse(collection1.contains(31L));
        Assert.assertFalse(collection1.contains(32L));
        MutableLongCollection collection2 = this.newWith(0L, 1L, 2L);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains() {
        MutableLongCollection collection = this.newWith(14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L);
        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));
        long[] numbers = { 14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L };
        for (long number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));
    }

    @Override
    @Test
    public void reject() {
        LongIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(LongPredicates.lessThan(4L)));
        Verify.assertSize(1, iterable.reject(LongPredicates.lessThan(3L)));
    }

    @Override
    @Test
    public void select() {
        LongIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(LongPredicates.lessThan(4L)));
        Verify.assertSize(2, iterable.select(LongPredicates.lessThan(3L)));
    }

    @Override
    @Test
    public void collect() {
        LongToObjectFunction<Long> function = (long parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 2L).toBag(), this.newWith(1L, 2L, 3L).collect(function).toBag());
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 2L).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2L), this.newWith(3L).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1", this.newWith(1L).makeString("/"));
        Assert.assertEquals("31", this.newWith(31L).makeString());
        Assert.assertEquals("32", this.newWith(32L).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        LongIterable iterable1 = this.newWith(0L, 31L);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        LongIterable iterable2 = this.newWith(31L, 32L);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        LongIterable iterable3 = this.newWith(32L, 33L);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        LongIterable iterable4 = this.newWith(1L, 2L);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        LongIterable iterable5 = this.newWith(0L, 1L);
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
        this.newWith(1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        LongIterable iterable = this.newWith(1L, 2L);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31L).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32L).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        LongIterable iterable1 = this.newWith(0L, 31L);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LongIterable iterable2 = this.newWith(31L, 32L);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LongIterable iterable4 = this.newWith(32L, 33L);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LongIterable iterable5 = this.newWith(0L, 1L);
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
    public void testEquals() {
        // Testing equals() is not applicable for MutableLongCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableLongCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableLongCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableLongCollection.
    }

    @Override
    @Test
    public void chunk() {
        LongIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L), LongBags.mutable.with(2L), LongBags.mutable.with(3L)).toSet(), iterable.chunk(1).toSet());
        MutableSet<LongIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(LongBags.mutable.with(1L, 2L), LongBags.mutable.with(3L)).toSet().equals(chunked) || Lists.mutable.with(LongBags.mutable.with(2L, 3L), LongBags.mutable.with(1L)).toSet().equals(chunked) || Lists.mutable.with(LongBags.mutable.with(1L, 3L), LongBags.mutable.with(2L)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteLongHashMapValuesTest instance;

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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ByteLongHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteLongHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = ByteLongHashMapValuesTest::newCollection;
            this.payloads.isEmpty = ByteLongHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = ByteLongHashMapValuesTest::notEmpty;
            this.payloads.tap = ByteLongHashMapValuesTest::tap;
            this.payloads.containsAllArray = ByteLongHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ByteLongHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteLongHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteLongHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteLongHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteLongHashMapValuesTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteLongHashMapValuesTest::forEach;
            this.payloads.size = ByteLongHashMapValuesTest::size;
            this.payloads.count = ByteLongHashMapValuesTest::count;
            this.payloads.anySatisfy = ByteLongHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = ByteLongHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ByteLongHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = ByteLongHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteLongHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteLongHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteLongHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteLongHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ByteLongHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = ByteLongHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = ByteLongHashMapValuesTest::detectIfNone;
            this.payloads.max = ByteLongHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ByteLongHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteLongHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteLongHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = ByteLongHashMapValuesTest::sum;
            this.payloads.summaryStatistics = ByteLongHashMapValuesTest::summaryStatistics;
            this.payloads.average = ByteLongHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteLongHashMapValuesTest::averageIfEmpty;
            this.payloads.median = ByteLongHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteLongHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = ByteLongHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = ByteLongHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ByteLongHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = ByteLongHashMapValuesTest::testHashCode;
            this.payloads.testToString = ByteLongHashMapValuesTest::testToString;
            this.payloads.toList = ByteLongHashMapValuesTest::toList;
            this.payloads.toSortedList = ByteLongHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = ByteLongHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteLongHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteLongHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteLongHashMapValuesTest::toSet;
            this.payloads.toBag = ByteLongHashMapValuesTest::toBag;
            this.payloads.asLazy = ByteLongHashMapValuesTest::asLazy;
            this.payloads.injectInto = ByteLongHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = ByteLongHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteLongHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteLongHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteLongHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteLongHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteLongHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteLongHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteLongHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteLongHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = ByteLongHashMapValuesTest::reduceIfEmpty;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = ByteLongHashMapValuesTest::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = ByteLongHashMapValuesTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = ByteLongHashMapValuesTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ByteLongHashMapValuesTest::newEmpty;
            this.payloads.longIterator = ByteLongHashMapValuesTest::longIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteLongHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ByteLongHashMapValuesTest::remove;
            this.payloads.removeIf = ByteLongHashMapValuesTest::removeIf;
            this.payloads.asSynchronized = ByteLongHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteLongHashMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = ByteLongHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = ByteLongHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = ByteLongHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = ByteLongHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = ByteLongHashMapValuesTest::clear;
            this.payloads.contains = ByteLongHashMapValuesTest::contains;
            this.payloads.reject = ByteLongHashMapValuesTest::reject;
            this.payloads.select = ByteLongHashMapValuesTest::select;
            this.payloads.collect = ByteLongHashMapValuesTest::collect;
            this.payloads.makeString = ByteLongHashMapValuesTest::makeString;
            this.payloads.appendString = ByteLongHashMapValuesTest::appendString;
            this.payloads.testEquals = ByteLongHashMapValuesTest::testEquals;
            this.payloads.chunk = ByteLongHashMapValuesTest::chunk;
        }
    }
*/
}
