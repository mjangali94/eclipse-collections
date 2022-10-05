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
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedIntCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableIntCollection;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharIntHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class CharIntHashMapValuesTest extends AbstractMutableIntCollectionTestCase {

    @Override
    protected MutableIntCollection classUnderTest() {
        return CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3).values();
    }

    @Override
    protected MutableIntCollection newWith(int... elements) {
        CharIntHashMap map = new CharIntHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((char) i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableIntCollection newMutableCollectionWith(int... elements) {
        return this.newWith(elements);
    }

    @Override
    protected Bag<Integer> newObjectCollectionWith(Integer... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void intIterator() {
        MutableIntCollection bag = this.newWith(0, 1, 2, 3);
        IntArrayList list = IntArrayList.newListWith(0, 1, 2, 3);
        IntIterator iterator = bag.intIterator();
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
        this.classUnderTest().addAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new IntArrayList());
    }

    @Override
    @Test
    public void remove() {
        CharIntHashMap map = CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        MutableIntCollection collection = map.values();
        Assert.assertTrue(collection.remove(3));
        Assert.assertFalse(collection.contains(3));
        Assert.assertTrue(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertFalse(map.contains(3));
        Assert.assertTrue(map.contains(1));
        Assert.assertTrue(map.contains(2));
    }

    @Override
    @Test
    public void removeIf() {
        CharIntHashMap map = CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        MutableIntCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(IntPredicates.equal(3)));
        Assert.assertFalse(collection.contains(3));
        Assert.assertTrue(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertFalse(map.contains(3));
        Assert.assertTrue(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertFalse(collection.removeIf(IntPredicates.equal(3)));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableIntCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedIntCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableIntCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableIntCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1));
        CharIntHashMap map = CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        MutableIntCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(1, 5));
        Assert.assertFalse(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertTrue(collection.removeAll(3, 2));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertFalse(collection.contains(3));
        Assert.assertFalse(map.contains(1));
        Assert.assertFalse(map.contains(2));
        Assert.assertFalse(map.contains(3));
        Assert.assertTrue(map.isEmpty());
        map = CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 2, 2, (char) 3, 3);
        collection = map.values();
        Assert.assertTrue(collection.removeAll(0, 5));
        Assert.assertFalse(collection.contains(0));
        Assert.assertTrue(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(map.contains(0));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new IntArrayList()));
        Assert.assertFalse(this.newWith().removeAll(IntArrayList.newListWith(1)));
        CharIntHashMap map = CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        MutableIntCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(IntArrayList.newListWith(1, 5)));
        Assert.assertFalse(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertTrue(collection.removeAll(IntArrayList.newListWith(3, 2)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertFalse(collection.contains(3));
        Assert.assertFalse(map.contains(1));
        Assert.assertFalse(map.contains(2));
        Assert.assertFalse(map.contains(3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(1));
        CharIntHashMap map = CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 2, 2, (char) 3, 3);
        MutableIntCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(0, 1, 2, 3));
        Assert.assertTrue(collection.retainAll(0, 2, 3, 5));
        Assert.assertTrue(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertTrue(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(collection.retainAll(2, 3, 5));
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertFalse(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(collection.retainAll(3, 5));
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertFalse(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertFalse(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(collection.retainAll(0, 0, 1));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertFalse(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertFalse(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertFalse(map.contains(2));
        Assert.assertFalse(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new IntArrayList()));
        Assert.assertFalse(this.newWith().retainAll(IntArrayList.newListWith(1)));
        CharIntHashMap map = CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 2, 2, (char) 3, 3);
        MutableIntCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(IntArrayList.newListWith(0, 1, 2, 3)));
        Assert.assertTrue(collection.retainAll(IntArrayList.newListWith(0, 2, 3, 5)));
        Assert.assertTrue(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertTrue(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(collection.retainAll(IntArrayList.newListWith(2, 3, 5)));
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertTrue(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertFalse(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(collection.retainAll(IntArrayList.newListWith(3, 5)));
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertTrue(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertFalse(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertFalse(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(collection.retainAll(IntArrayList.newListWith(0, 0, 1)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertFalse(collection.contains(3));
        Assert.assertFalse(collection.contains(5));
        Assert.assertFalse(map.contains(0));
        Assert.assertFalse(map.contains(1));
        Assert.assertFalse(map.contains(2));
        Assert.assertFalse(map.contains(3));
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableIntCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        CharIntHashMap map = CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        MutableIntCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertFalse(collection.contains(3));
        MutableIntCollection collection1 = this.newWith(0, 1, 31, 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0));
        Assert.assertFalse(collection1.contains(1));
        Assert.assertFalse(collection1.contains(31));
        Assert.assertFalse(collection1.contains(32));
        MutableIntCollection collection2 = this.newWith(0, 1, 2);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains() {
        MutableIntCollection collection = this.newWith(14, 2, 30, 31, 32, 35, 0, 1);
        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));
        int[] numbers = { 14, 2, 30, 31, 32, 35, 0, 1 };
        for (int number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));
    }

    @Override
    @Test
    public void reject() {
        IntIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(IntPredicates.lessThan(4)));
        Verify.assertSize(1, iterable.reject(IntPredicates.lessThan(3)));
    }

    @Override
    @Test
    public void select() {
        IntIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(IntPredicates.lessThan(4)));
        Verify.assertSize(2, iterable.select(IntPredicates.lessThan(3)));
    }

    @Override
    @Test
    public void collect() {
        IntToObjectFunction<Integer> function = (int parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 2).toBag(), this.newWith(1, 2, 3).collect(function).toBag());
        IntIterable iterable = this.newWith(1, 2, 3);
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 2).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2), this.newWith(3).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("1", this.newWith(1).makeString("/"));
        Assert.assertEquals("31", this.newWith(31).makeString());
        Assert.assertEquals("32", this.newWith(32).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        IntIterable iterable1 = this.newWith(0, 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        IntIterable iterable2 = this.newWith(31, 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        IntIterable iterable3 = this.newWith(32, 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        IntIterable iterable4 = this.newWith(1, 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        IntIterable iterable5 = this.newWith(0, 1);
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
        this.newWith(1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        IntIterable iterable = this.newWith(1, 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        IntIterable iterable1 = this.newWith(0, 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        IntIterable iterable2 = this.newWith(31, 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        IntIterable iterable4 = this.newWith(32, 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        IntIterable iterable5 = this.newWith(0, 1);
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
        // Testing equals() is not applicable for MutableIntCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableIntCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableIntCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableIntCollection.
    }

    @Override
    @Test
    public void chunk() {
        IntIterable iterable = this.classUnderTest();
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1), IntBags.mutable.with(2), IntBags.mutable.with(3)).toSet(), iterable.chunk(1).toSet());
        MutableSet<IntIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(IntBags.mutable.with(1, 2), IntBags.mutable.with(3)).toSet().equals(chunked) || Lists.mutable.with(IntBags.mutable.with(2, 3), IntBags.mutable.with(1)).toSet().equals(chunked) || Lists.mutable.with(IntBags.mutable.with(1, 3), IntBags.mutable.with(2)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharIntHashMapValuesTest instance;

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
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new CharIntHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CharIntHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = CharIntHashMapValuesTest::newCollection;
            this.payloads.isEmpty = CharIntHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = CharIntHashMapValuesTest::notEmpty;
            this.payloads.tap = CharIntHashMapValuesTest::tap;
            this.payloads.containsAllArray = CharIntHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = CharIntHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = CharIntHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = CharIntHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = CharIntHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = CharIntHashMapValuesTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = CharIntHashMapValuesTest::forEach;
            this.payloads.size = CharIntHashMapValuesTest::size;
            this.payloads.count = CharIntHashMapValuesTest::count;
            this.payloads.anySatisfy = CharIntHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = CharIntHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = CharIntHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = CharIntHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CharIntHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CharIntHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CharIntHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CharIntHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = CharIntHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = CharIntHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = CharIntHashMapValuesTest::detectIfNone;
            this.payloads.max = CharIntHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = CharIntHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharIntHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharIntHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = CharIntHashMapValuesTest::sum;
            this.payloads.summaryStatistics = CharIntHashMapValuesTest::summaryStatistics;
            this.payloads.average = CharIntHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CharIntHashMapValuesTest::averageIfEmpty;
            this.payloads.median = CharIntHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CharIntHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = CharIntHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = CharIntHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = CharIntHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = CharIntHashMapValuesTest::testHashCode;
            this.payloads.testToString = CharIntHashMapValuesTest::testToString;
            this.payloads.toList = CharIntHashMapValuesTest::toList;
            this.payloads.toSortedList = CharIntHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = CharIntHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CharIntHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CharIntHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CharIntHashMapValuesTest::toSet;
            this.payloads.toBag = CharIntHashMapValuesTest::toBag;
            this.payloads.asLazy = CharIntHashMapValuesTest::asLazy;
            this.payloads.injectInto = CharIntHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = CharIntHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CharIntHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = CharIntHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = CharIntHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = CharIntHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = CharIntHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = CharIntHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = CharIntHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CharIntHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = CharIntHashMapValuesTest::reduceIfEmpty;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = CharIntHashMapValuesTest::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = CharIntHashMapValuesTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = CharIntHashMapValuesTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = CharIntHashMapValuesTest::newEmpty;
            this.payloads.intIterator = CharIntHashMapValuesTest::intIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = CharIntHashMapValuesTest::remove;
            this.payloads.removeIf = CharIntHashMapValuesTest::removeIf;
            this.payloads.asSynchronized = CharIntHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = CharIntHashMapValuesTest::asUnmodifiable;
            this.payloads.removeAll = CharIntHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = CharIntHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = CharIntHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = CharIntHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = CharIntHashMapValuesTest::clear;
            this.payloads.contains = CharIntHashMapValuesTest::contains;
            this.payloads.reject = CharIntHashMapValuesTest::reject;
            this.payloads.select = CharIntHashMapValuesTest::select;
            this.payloads.collect = CharIntHashMapValuesTest::collect;
            this.payloads.makeString = CharIntHashMapValuesTest::makeString;
            this.payloads.appendString = CharIntHashMapValuesTest::appendString;
            this.payloads.testEquals = CharIntHashMapValuesTest::testEquals;
            this.payloads.chunk = CharIntHashMapValuesTest::chunk;
        }
    }
}
