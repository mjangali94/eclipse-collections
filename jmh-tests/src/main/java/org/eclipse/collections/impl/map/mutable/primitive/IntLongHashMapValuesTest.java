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
 * JUnit test for {@link IntLongHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class IntLongHashMapValuesTest extends AbstractMutableLongCollectionTestCase {

    @Override
    protected MutableLongCollection classUnderTest() {
        return IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L).values();
    }

    @Override
    protected MutableLongCollection newWith(long... elements) {
        IntLongHashMap map = new IntLongHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
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
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
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
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
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
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
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
        map = IntLongHashMap.newWithKeysValues(0, 0L, 2, 2L, 3, 3L);
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
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
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
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
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
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
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
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntLongHashMapValuesTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new IntLongHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntLongHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = IntLongHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = IntLongHashMapValuesTest::newCollection;
            this.payloads.isEmpty = IntLongHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = IntLongHashMapValuesTest::notEmpty;
            this.payloads.tap = IntLongHashMapValuesTest::tap;
            this.payloads.containsAllArray = IntLongHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = IntLongHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = IntLongHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = IntLongHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = IntLongHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = IntLongHashMapValuesTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = IntLongHashMapValuesTest::forEach;
            this.payloads.size = IntLongHashMapValuesTest::size;
            this.payloads.count = IntLongHashMapValuesTest::count;
            this.payloads.anySatisfy = IntLongHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = IntLongHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = IntLongHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = IntLongHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = IntLongHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = IntLongHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = IntLongHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = IntLongHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = IntLongHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = IntLongHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = IntLongHashMapValuesTest::detectIfNone;
            this.payloads.max = IntLongHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = IntLongHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntLongHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntLongHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = IntLongHashMapValuesTest::sum;
            this.payloads.summaryStatistics = IntLongHashMapValuesTest::summaryStatistics;
            this.payloads.average = IntLongHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = IntLongHashMapValuesTest::averageIfEmpty;
            this.payloads.median = IntLongHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = IntLongHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = IntLongHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = IntLongHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = IntLongHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = IntLongHashMapValuesTest::testHashCode;
            this.payloads.testToString = IntLongHashMapValuesTest::testToString;
            this.payloads.toList = IntLongHashMapValuesTest::toList;
            this.payloads.toSortedList = IntLongHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = IntLongHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = IntLongHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = IntLongHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = IntLongHashMapValuesTest::toSet;
            this.payloads.toBag = IntLongHashMapValuesTest::toBag;
            this.payloads.asLazy = IntLongHashMapValuesTest::asLazy;
            this.payloads.injectInto = IntLongHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = IntLongHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = IntLongHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = IntLongHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = IntLongHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = IntLongHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = IntLongHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = IntLongHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = IntLongHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = IntLongHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = IntLongHashMapValuesTest::reduceIfEmpty;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = IntLongHashMapValuesTest::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = IntLongHashMapValuesTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = IntLongHashMapValuesTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = IntLongHashMapValuesTest::newEmpty;
            this.payloads.longIterator = IntLongHashMapValuesTest::longIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntLongHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = IntLongHashMapValuesTest::remove;
            this.payloads.removeIf = IntLongHashMapValuesTest::removeIf;
            this.payloads.asSynchronized = IntLongHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = IntLongHashMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = IntLongHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = IntLongHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = IntLongHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = IntLongHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = IntLongHashMapValuesTest::clear;
            this.payloads.contains = IntLongHashMapValuesTest::contains;
            this.payloads.reject = IntLongHashMapValuesTest::reject;
            this.payloads.select = IntLongHashMapValuesTest::select;
            this.payloads.collect = IntLongHashMapValuesTest::collect;
            this.payloads.makeString = IntLongHashMapValuesTest::makeString;
            this.payloads.appendString = IntLongHashMapValuesTest::appendString;
            this.payloads.testEquals = IntLongHashMapValuesTest::testEquals;
            this.payloads.chunk = IntLongHashMapValuesTest::chunk;
        }
    }
}
