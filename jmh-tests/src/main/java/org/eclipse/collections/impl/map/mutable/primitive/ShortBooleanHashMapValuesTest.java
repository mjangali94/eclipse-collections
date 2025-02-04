/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedBooleanCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableBooleanCollection;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortBooleanHashMap#values()}.
 * This file was automatically generated from template file primitiveBooleanHashMapValuesTest.stg.
 */
public class ShortBooleanHashMapValuesTest extends AbstractMutableBooleanCollectionTestCase {

    @Override
    protected MutableBooleanCollection classUnderTest() {
        return ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false, (short) 3, true).values();
    }

    @Override
    protected MutableBooleanCollection newWith(boolean... elements) {
        ShortBooleanHashMap map = new ShortBooleanHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((short) i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableBooleanCollection newMutableCollectionWith(boolean... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Object> newObjectCollectionWith(Object... elements) {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void booleanIterator() {
        MutableBooleanCollection collection = this.newWith(true, false, false, true, true, true);
        BooleanArrayList list = BooleanArrayList.newListWith(true, false, false, true, true, true);
        BooleanIterator iterator = collection.booleanIterator();
        for (int i = 0; i < 6; i++) {
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
        this.classUnderTest().addAll(new BooleanArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().add(false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(true, false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.classUnderTest().with(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.classUnderTest().without(false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.classUnderTest().withAll(new BooleanArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.classUnderTest().withoutAll(new BooleanArrayList());
    }

    @Override
    @Test
    public void remove() {
        ShortBooleanHashMap map = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false, (short) 3, true);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.remove(false));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));
    }

    @Override
    @Test
    public void containsAllArray() {
        MutableBooleanCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.containsAll());
        Assert.assertFalse(emptyCollection.containsAll(true));
        Assert.assertFalse(emptyCollection.containsAll(false));
        MutableBooleanCollection classUnderTest = this.classUnderTest();
        Assert.assertTrue(classUnderTest.containsAll());
        Assert.assertTrue(classUnderTest.containsAll(true));
        Assert.assertTrue(classUnderTest.containsAll(false));
        Assert.assertTrue(classUnderTest.containsAll(false, true));
    }

    @Override
    @Test
    public void asSynchronized() {
        MutableBooleanCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedBooleanCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableBooleanCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableBooleanCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void containsAllIterable() {
        MutableBooleanCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.containsAll(new BooleanArrayList()));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(false)));
        MutableBooleanCollection classUnderTest = this.classUnderTest();
        Assert.assertTrue(classUnderTest.containsAll(new BooleanArrayList()));
        Assert.assertTrue(classUnderTest.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(classUnderTest.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(classUnderTest.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(true));
        ShortBooleanHashMap map = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.removeAll(false));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));
        Assert.assertTrue(collection.removeAll(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));
        ShortBooleanHashMap map1 = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.removeAll(false, true));
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));
    }

    @Override
    @Test
    public void removeAll_iterable() {
        Assert.assertFalse(this.newWith().removeAll(new BooleanArrayList()));
        Assert.assertFalse(this.newWith().removeAll(BooleanArrayList.newListWith(true)));
        ShortBooleanHashMap map = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.removeAll(BooleanArrayList.newListWith(false)));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));
        Assert.assertTrue(collection.removeAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));
        ShortBooleanHashMap map1 = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.removeAll(BooleanArrayList.newListWith(false, true)));
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));
    }

    @Override
    @Test
    public void retainAll() {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(true));
        ShortBooleanHashMap map = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.retainAll(true));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));
        Assert.assertTrue(collection.retainAll(false));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));
        ShortBooleanHashMap map1 = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.retainAll());
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));
        ShortBooleanHashMap sentinelMap = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 0, false);
        MutableBooleanCollection collection2 = sentinelMap.values();
        Assert.assertTrue(collection2.retainAll(false));
        Assert.assertTrue(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertTrue(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
        Assert.assertTrue(collection2.retainAll(true));
        Assert.assertFalse(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertFalse(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
    }

    @Override
    @Test
    public void retainAll_iterable() {
        Assert.assertFalse(this.newWith().retainAll(new BooleanArrayList()));
        Assert.assertFalse(this.newWith().retainAll(BooleanArrayList.newListWith(true)));
        ShortBooleanHashMap map = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.retainAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));
        Assert.assertTrue(collection.retainAll(BooleanArrayList.newListWith(false)));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));
        ShortBooleanHashMap map1 = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.retainAll(new BooleanArrayList()));
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));
        ShortBooleanHashMap sentinelMap = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 0, false);
        MutableBooleanCollection collection2 = sentinelMap.values();
        Assert.assertTrue(collection2.retainAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertTrue(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
        Assert.assertTrue(collection2.retainAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertFalse(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
    }

    @Override
    @Test
    public void clear() {
        MutableBooleanCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        ShortBooleanHashMap map = ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false, (short) 3, true);
        MutableBooleanCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(false));
        Assert.assertFalse(map.contains(true));
        Assert.assertFalse(map.contains(false));
    }

    @Override
    @Test
    public void contains() {
        BooleanIterable emptyCollection = this.newWith();
        Assert.assertFalse(emptyCollection.contains(true));
        Assert.assertFalse(emptyCollection.contains(false));
        BooleanIterable booleanIterable = this.classUnderTest();
        Assert.assertTrue(booleanIterable.contains(true));
        Assert.assertTrue(booleanIterable.contains(false));
        Assert.assertFalse(this.newWith(true, true, true).contains(false));
        Assert.assertFalse(this.newWith(false, false, false).contains(true));
    }

    @Override
    @Test
    public void reject() {
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertSize(1, iterable.reject(BooleanPredicates.isTrue()));
        Verify.assertSize(2, iterable.reject(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void select() {
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertSize(1, iterable.select(BooleanPredicates.isFalse()));
        Verify.assertSize(2, iterable.select(BooleanPredicates.isTrue()));
    }

    @Override
    @Test
    public void collect() {
        BooleanToObjectFunction<Integer> function = (boolean parameter) -> parameter ? 1 : 0;
        Assert.assertEquals(this.newObjectCollectionWith(1, 0, 1).toBag(), this.newWith(true, false, true).collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
    }

    @Override
    @Test
    public void appendString() {
        // does not call super.appendString() because of iterator.toString() test.
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", "/", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(true).appendString(appendable1);
        Assert.assertEquals("true", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        BooleanIterable iterable = this.newWith(true, false);
        iterable.appendString(appendable2);
        Assert.assertTrue("true, false".equals(appendable2.toString()) || "false, true".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("true/false".equals(appendable3.toString()) || "false/true".equals(appendable3.toString()));
        ShortBooleanHashMap map = new ShortBooleanHashMap();
        map.put((short) 1, true);
        map.put((short) 2, false);
        StringBuilder stringBuilder = new StringBuilder();
        map.values().appendString(stringBuilder, "[", ", ", "]");
        Assert.assertEquals("[true, false]", stringBuilder.toString());
    }

    @Override
    @Test
    public void chunk() {
        BooleanIterable iterable1 = this.newWith(true);
        Verify.assertIterablesEqual(Lists.mutable.with(BooleanBags.mutable.with(true)).toSet(), iterable1.chunk(1).toSet());
        BooleanIterable iterable2 = this.newWith(false);
        Verify.assertIterablesEqual(Lists.mutable.with(BooleanBags.mutable.with(false)).toSet(), iterable2.chunk(1).toSet());
        BooleanIterable iterable3 = this.newWith(false, true);
        Verify.assertIterablesEqual(Lists.mutable.with(BooleanBags.mutable.with(false), BooleanBags.mutable.with(true)).toSet(), iterable3.chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(BooleanBags.mutable.with(false, true)), iterable3.chunk(2));
        Verify.assertIterablesEqual(Lists.mutable.with(BooleanBags.mutable.with(false, true)), iterable3.chunk(3));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.classUnderTest().chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.classUnderTest().chunk(-1));
    }

    @Override
    @Test
    public void testEquals() {
        // Testing equals() is not applicable for MutableBooleanCollection.
    }

    @Override
    public void testToString() {
        // Testing toString() is not applicable for MutableBooleanCollection.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable for MutableBooleanCollection.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable for MutableBooleanCollection.
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortBooleanHashMapValuesTest instance;

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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ShortBooleanHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapValuesTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ShortBooleanHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = ShortBooleanHashMapValuesTest::newCollection;
            this.payloads.isEmpty = ShortBooleanHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = ShortBooleanHashMapValuesTest::notEmpty;
            this.payloads.containsAnyArray = ShortBooleanHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ShortBooleanHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ShortBooleanHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ShortBooleanHashMapValuesTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = ShortBooleanHashMapValuesTest::forEach;
            this.payloads.size = ShortBooleanHashMapValuesTest::size;
            this.payloads.count = ShortBooleanHashMapValuesTest::count;
            this.payloads.anySatisfy = ShortBooleanHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = ShortBooleanHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ShortBooleanHashMapValuesTest::noneSatisfy;
            this.payloads.detectIfNone = ShortBooleanHashMapValuesTest::detectIfNone;
            this.payloads.injectInto = ShortBooleanHashMapValuesTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ShortBooleanHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = ShortBooleanHashMapValuesTest::reduceIfEmpty;
            this.payloads.toArray = ShortBooleanHashMapValuesTest::toArray;
            this.payloads.testHashCode = ShortBooleanHashMapValuesTest::testHashCode;
            this.payloads.testToString = ShortBooleanHashMapValuesTest::testToString;
            this.payloads.makeString = ShortBooleanHashMapValuesTest::makeString;
            this.payloads.toList = ShortBooleanHashMapValuesTest::toList;
            this.payloads.toSet = ShortBooleanHashMapValuesTest::toSet;
            this.payloads.toBag = ShortBooleanHashMapValuesTest::toBag;
            this.payloads.asLazy = ShortBooleanHashMapValuesTest::asLazy;
            this.payloads.booleanIterator_with_remove = ShortBooleanHashMapValuesTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ShortBooleanHashMapValuesTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ShortBooleanHashMapValuesTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.booleanIterator = ShortBooleanHashMapValuesTest::booleanIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ShortBooleanHashMapValuesTest::remove;
            this.payloads.containsAllArray = ShortBooleanHashMapValuesTest::containsAllArray;
            this.payloads.asSynchronized = ShortBooleanHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ShortBooleanHashMapValuesTest::asUnmodifiable;
            this.payloads.containsAllIterable = ShortBooleanHashMapValuesTest::containsAllIterable;
            this.payloads.removeAll = ShortBooleanHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = ShortBooleanHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = ShortBooleanHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = ShortBooleanHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = ShortBooleanHashMapValuesTest::clear;
            this.payloads.contains = ShortBooleanHashMapValuesTest::contains;
            this.payloads.reject = ShortBooleanHashMapValuesTest::reject;
            this.payloads.select = ShortBooleanHashMapValuesTest::select;
            this.payloads.collect = ShortBooleanHashMapValuesTest::collect;
            this.payloads.appendString = ShortBooleanHashMapValuesTest::appendString;
            this.payloads.chunk = ShortBooleanHashMapValuesTest::chunk;
            this.payloads.testEquals = ShortBooleanHashMapValuesTest::testEquals;
        }
    }
}
