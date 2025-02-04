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
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableCharCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedCharCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableCharCollection;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveHashMapValuesTestCase.stg.
 */
public abstract class ObjectCharHashMapValuesTestCase extends AbstractMutableCharCollectionTestCase {

    public abstract MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1);

    public abstract MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2);

    public abstract MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2, String key3, char value3);

    public abstract MutableObjectCharMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2, String key3, char value3, String key4, char value4);

    public abstract MutableObjectCharMap<String> newEmptyMap();

    @Override
    protected MutableCharCollection classUnderTest() {
        return this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3).values();
    }

    @Override
    protected MutableCharCollection newWith(char... elements) {
        MutableObjectCharMap map = this.newEmptyMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(String.valueOf(i), elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableCharCollection newMutableCollectionWith(char... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableList<Character> newObjectCollectionWith(Character... elements) {
        return FastList.newListWith(elements);
    }

    @Override
    @Test
    public void charIterator() {
        MutableCharCollection bag = this.newWith((char) 0, (char) 1, (char) 2, (char) 3);
        CharArrayList list = CharArrayList.newListWith((char) 0, (char) 1, (char) 2, (char) 3);
        CharIterator iterator1 = bag.charIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator1.hasNext());
            Assert.assertTrue(list.remove(iterator1.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator1.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator1::next);
        MutableObjectCharMap<String> map2 = new ObjectCharHashMap<>();
        for (char each = (char) 2; each < (char) 100; each++) {
            map2.put(String.valueOf(each), each);
        }
        MutableCharIterator iterator2 = map2.charIterator();
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
        Assert.assertTrue(map2.isEmpty());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll((char) 0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new CharArrayList());
    }

    @Override
    @Test
    public void remove() {
        MutableObjectCharMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        MutableCharCollection collection = map.values();
        Assert.assertTrue(collection.remove((char) 3));
        Assert.assertFalse(collection.contains((char) 3));
        Assert.assertTrue(collection.contains((char) 1));
        Assert.assertTrue(collection.contains((char) 2));
        Assert.assertFalse(map.contains((char) 3));
        Assert.assertTrue(map.contains((char) 1));
        Assert.assertTrue(map.contains((char) 2));
    }

    @Override
    @Test
    public void removeIf() {
        MutableObjectCharMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        MutableCharCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(CharPredicates.equal((char) 3)));
        Assert.assertFalse(collection.contains((char) 3));
        Assert.assertTrue(collection.contains((char) 1));
        Assert.assertTrue(collection.contains((char) 2));
        Assert.assertFalse(map.contains((char) 3));
        Assert.assertTrue(map.contains((char) 1));
        Assert.assertTrue(map.contains((char) 2));
        Assert.assertFalse(collection.removeIf(CharPredicates.equal((char) 3)));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll((char) 1));
        MutableObjectCharMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        MutableCharCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll((char) 1, (char) 5));
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertTrue(collection.contains((char) 2));
        Assert.assertTrue(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertTrue(map.contains((char) 2));
        Assert.assertTrue(map.contains((char) 3));
        Assert.assertTrue(collection.removeAll((char) 3, (char) 2));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertFalse(collection.contains((char) 2));
        Assert.assertFalse(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertFalse(map.contains((char) 2));
        Assert.assertFalse(map.contains((char) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new CharArrayList()));
        Assert.assertFalse(this.newWith().removeAll(CharArrayList.newListWith((char) 1)));
        MutableObjectCharMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        MutableCharCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());
        Assert.assertTrue(collection.removeAll(CharArrayList.newListWith((char) 1, (char) 5)));
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertTrue(collection.contains((char) 2));
        Assert.assertTrue(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertTrue(map.contains((char) 2));
        Assert.assertTrue(map.contains((char) 3));
        Assert.assertTrue(collection.removeAll(CharArrayList.newListWith((char) 3, (char) 2)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertFalse(collection.contains((char) 2));
        Assert.assertFalse(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertFalse(map.contains((char) 2));
        Assert.assertFalse(map.contains((char) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll((char) 1));
        MutableObjectCharMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        MutableCharCollection collection = map.values();
        Assert.assertFalse(collection.retainAll((char) 1, (char) 2, (char) 3));
        Assert.assertTrue(collection.retainAll((char) 2, (char) 3, (char) 5));
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertTrue(collection.contains((char) 2));
        Assert.assertTrue(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertTrue(map.contains((char) 2));
        Assert.assertTrue(map.contains((char) 3));
        Assert.assertTrue(collection.retainAll((char) 1, (char) 0, (char) 4));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertFalse(collection.contains((char) 2));
        Assert.assertFalse(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertFalse(map.contains((char) 2));
        Assert.assertFalse(map.contains((char) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new CharArrayList()));
        Assert.assertFalse(this.newWith().retainAll(CharArrayList.newListWith((char) 1)));
        MutableObjectCharMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        MutableCharCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertTrue(collection.retainAll(CharArrayList.newListWith((char) 2, (char) 3, (char) 5)));
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertTrue(collection.contains((char) 2));
        Assert.assertTrue(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertTrue(map.contains((char) 2));
        Assert.assertTrue(map.contains((char) 3));
        Assert.assertTrue(collection.retainAll(CharArrayList.newListWith((char) 1, (char) 0, (char) 4)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertFalse(collection.contains((char) 2));
        Assert.assertFalse(collection.contains((char) 3));
        Assert.assertFalse(map.contains((char) 1));
        Assert.assertFalse(map.contains((char) 2));
        Assert.assertFalse(map.contains((char) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear() {
        MutableCharCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableObjectCharMap<String> map = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        MutableCharCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains((char) 0));
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertFalse(collection.contains((char) 2));
        Assert.assertFalse(collection.contains((char) 3));
        MutableCharCollection collection1 = this.newWith((char) 0, (char) 1, (char) 31, (char) 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains((char) 0));
        Assert.assertFalse(collection1.contains((char) 1));
        Assert.assertFalse(collection1.contains((char) 31));
        Assert.assertFalse(collection1.contains((char) 32));
        MutableCharCollection collection2 = this.newWith((char) 0, (char) 1, (char) 2);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains() {
        MutableCharCollection collection = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
        char[] numbers = { (char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1 };
        for (char number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
    }

    @Override
    @Test
    public void reject() {
        CharIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(1, iterable.reject(CharPredicates.lessThan((char) 3)));
    }

    @Override
    @Test
    public void select() {
        CharIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(2, iterable.select(CharPredicates.lessThan((char) 3)));
    }

    @Override
    @Test
    public void collect() {
        CharToObjectFunction<Character> function = (char parameter) -> (char) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 2).toBag(), this.newWith((char) 1, (char) 2, (char) 3).collect(function).toBag());
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 2).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((char) 2), this.newWith((char) 3).collect(function));
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("\u0001", this.newWith((char) 1).makeString("/"));
        Assert.assertEquals("\u001f", this.newWith((char) 31).makeString());
        Assert.assertEquals("\u0020", this.newWith((char) 32).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        CharIterable iterable1 = this.newWith((char) 0, (char) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("\u0000, \u001f") || iterable1.makeString().equals("\u001f, \u0000"));
        CharIterable iterable2 = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[\u001f/\u0020]") || iterable2.makeString("[", "/", "]").equals("[\u0020/\u001f]"));
        CharIterable iterable3 = this.newWith((char) 32, (char) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("\u0020/\u0021") || iterable3.makeString("/").equals("\u0021/\u0020"));
        CharIterable iterable4 = this.newWith((char) 1, (char) 2);
        Assert.assertTrue("\u0001, \u0002".equals(iterable4.makeString()) || "\u0002, \u0001".equals(iterable4.makeString()));
        Assert.assertTrue("\u0001/\u0002".equals(iterable4.makeString("/")) || "\u0002/\u0001".equals(iterable4.makeString("/")));
        Assert.assertTrue("[\u0001/\u0002]".equals(iterable4.makeString("[", "/", "]")) || "[\u0002/\u0001]".equals(iterable4.makeString("[", "/", "]")));
        CharIterable iterable5 = this.newWith((char) 0, (char) 1);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("\u0000, \u0001") || iterable5.makeString().equals("\u0001, \u0000"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[\u0000/\u0001]") || iterable5.makeString("[", "/", "]").equals("[\u0001/\u0000]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("\u0000/\u0001") || iterable5.makeString("/").equals("\u0001/\u0000"));
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
        this.newWith((char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        CharIterable iterable = this.newWith((char) 1, (char) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("\u0001, \u0002".equals(appendable2.toString()) || "\u0002, \u0001".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("\u0001/\u0002".equals(appendable3.toString()) || "\u0002/\u0001".equals(appendable3.toString()));
        StringBuilder appendable5 = new StringBuilder();
        this.newWith((char) 31).appendString(appendable5);
        Assert.assertEquals("\u001f", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith((char) 32).appendString(appendable6);
        Assert.assertEquals("\u0020", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        CharIterable iterable1 = this.newWith((char) 0, (char) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "\u0000, \u001f".equals(appendable7.toString()) || "\u001f, \u0000".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        CharIterable iterable2 = this.newWith((char) 31, (char) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "\u001f/\u0020".equals(appendable8.toString()) || "\u0020/\u001f".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        CharIterable iterable4 = this.newWith((char) 32, (char) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[\u0020/\u0021]".equals(appendable9.toString()) || "[\u0021/\u0020]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        CharIterable iterable5 = this.newWith((char) 0, (char) 1);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "\u0000, \u0001".equals(appendable10.toString()) || "\u0001, \u0000".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "\u0000/\u0001".equals(appendable11.toString()) || "\u0001/\u0000".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[\u0000/\u0001]".equals(appendable12.toString()) || "[\u0001/\u0000]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableCharCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedCharCollection.class, this.classUnderTest().asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableCharCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableCharCollection.class, this.classUnderTest().asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    public void testEquals() {
        // Testing equals() is not applicable for MutableCharCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableCharCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableCharCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableCharCollection.
    }

    @Override
    @Test
    public void chunk() {
        CharIterable iterable = this.newMapWithKeysValues(String.valueOf(1), (char) 1, String.valueOf(2), (char) 2, String.valueOf(3), (char) 3);
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1), CharBags.mutable.with((char) 2), CharBags.mutable.with((char) 3)).toSet(), iterable.chunk(1).toSet());
        MutableSet<CharIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2), CharBags.mutable.with((char) 3)).toSet().equals(chunked) || Lists.mutable.with(CharBags.mutable.with((char) 2, (char) 3), CharBags.mutable.with((char) 1)).toSet().equals(chunked) || Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 3), CharBags.mutable.with((char) 2)).toSet().equals(chunked));
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectCharHashMapValuesTestCase instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectCharHashMapValuesTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapValuesTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectCharHashMapValuesTestCase::newCollectionWith;
            this.payloads.newCollection = ObjectCharHashMapValuesTestCase::newCollection;
            this.payloads.isEmpty = ObjectCharHashMapValuesTestCase::isEmpty;
            this.payloads.notEmpty = ObjectCharHashMapValuesTestCase::notEmpty;
            this.payloads.tap = ObjectCharHashMapValuesTestCase::tap;
            this.payloads.containsAllArray = ObjectCharHashMapValuesTestCase::containsAllArray;
            this.payloads.containsAllIterable = ObjectCharHashMapValuesTestCase::containsAllIterable;
            this.payloads.containsAnyArray = ObjectCharHashMapValuesTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectCharHashMapValuesTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectCharHashMapValuesTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectCharHashMapValuesTestCase::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectCharHashMapValuesTestCase::forEach;
            this.payloads.size = ObjectCharHashMapValuesTestCase::size;
            this.payloads.count = ObjectCharHashMapValuesTestCase::count;
            this.payloads.anySatisfy = ObjectCharHashMapValuesTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectCharHashMapValuesTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectCharHashMapValuesTestCase::noneSatisfy;
            this.payloads.collectWithTarget = ObjectCharHashMapValuesTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectCharHashMapValuesTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectCharHashMapValuesTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectCharHashMapValuesTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectCharHashMapValuesTestCase::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectCharHashMapValuesTestCase::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectCharHashMapValuesTestCase::rejectWithTarget;
            this.payloads.detectIfNone = ObjectCharHashMapValuesTestCase::detectIfNone;
            this.payloads.max = ObjectCharHashMapValuesTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectCharHashMapValuesTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectCharHashMapValuesTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectCharHashMapValuesTestCase::maxIfEmpty;
            this.payloads.sum = ObjectCharHashMapValuesTestCase::sum;
            this.payloads.summaryStatistics = ObjectCharHashMapValuesTestCase::summaryStatistics;
            this.payloads.average = ObjectCharHashMapValuesTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectCharHashMapValuesTestCase::averageIfEmpty;
            this.payloads.median = ObjectCharHashMapValuesTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectCharHashMapValuesTestCase::medianIfEmpty;
            this.payloads.toArray = ObjectCharHashMapValuesTestCase::toArray;
            this.payloads.toArrayWithTargetArray = ObjectCharHashMapValuesTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectCharHashMapValuesTestCase::toSortedArray;
            this.payloads.testHashCode = ObjectCharHashMapValuesTestCase::testHashCode;
            this.payloads.testToString = ObjectCharHashMapValuesTestCase::testToString;
            this.payloads.toList = ObjectCharHashMapValuesTestCase::toList;
            this.payloads.toSortedList = ObjectCharHashMapValuesTestCase::toSortedList;
            this.payloads.toSortedListByComparator = ObjectCharHashMapValuesTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectCharHashMapValuesTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectCharHashMapValuesTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectCharHashMapValuesTestCase::toSet;
            this.payloads.toBag = ObjectCharHashMapValuesTestCase::toBag;
            this.payloads.asLazy = ObjectCharHashMapValuesTestCase::asLazy;
            this.payloads.injectInto = ObjectCharHashMapValuesTestCase::injectInto;
            this.payloads.injectIntoBoolean = ObjectCharHashMapValuesTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectCharHashMapValuesTestCase::injectIntoByte;
            this.payloads.injectIntoChar = ObjectCharHashMapValuesTestCase::injectIntoChar;
            this.payloads.injectIntoShort = ObjectCharHashMapValuesTestCase::injectIntoShort;
            this.payloads.injectIntoInt = ObjectCharHashMapValuesTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectCharHashMapValuesTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectCharHashMapValuesTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectCharHashMapValuesTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectCharHashMapValuesTestCase::reduce;
            this.payloads.reduceIfEmpty = ObjectCharHashMapValuesTestCase::reduceIfEmpty;
            this.payloads.testEquals = ObjectCharHashMapValuesTestCase::testEquals;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = ObjectCharHashMapValuesTestCase::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = ObjectCharHashMapValuesTestCase::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = ObjectCharHashMapValuesTestCase::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectCharHashMapValuesTestCase::newEmpty;
            this.payloads.charIterator = ObjectCharHashMapValuesTestCase::charIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapValuesTestCase::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectCharHashMapValuesTestCase::remove;
            this.payloads.removeIf = ObjectCharHashMapValuesTestCase::removeIf;
            this.payloads.removeAll = ObjectCharHashMapValuesTestCase::removeAll;
            this.payloads.removeAll_iterable = ObjectCharHashMapValuesTestCase::removeAll_iterable;
            this.payloads.retainAll = ObjectCharHashMapValuesTestCase::retainAll;
            this.payloads.retainAll_iterable = ObjectCharHashMapValuesTestCase::retainAll_iterable;
            this.payloads.clear = ObjectCharHashMapValuesTestCase::clear;
            this.payloads.contains = ObjectCharHashMapValuesTestCase::contains;
            this.payloads.reject = ObjectCharHashMapValuesTestCase::reject;
            this.payloads.select = ObjectCharHashMapValuesTestCase::select;
            this.payloads.collect = ObjectCharHashMapValuesTestCase::collect;
            this.payloads.makeString = ObjectCharHashMapValuesTestCase::makeString;
            this.payloads.appendString = ObjectCharHashMapValuesTestCase::appendString;
            this.payloads.asSynchronized = ObjectCharHashMapValuesTestCase::asSynchronized;
            this.payloads.asUnmodifiable = ObjectCharHashMapValuesTestCase::asUnmodifiable;
            this.payloads.chunk = ObjectCharHashMapValuesTestCase::chunk;
        }
    }
}
