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
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
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
 * JUnit test for {@link UnmodifiableShortBooleanMap#values()}.
 * This file was automatically generated from template file unmodifiablePrimitiveBooleanMapValuesTest.stg.
 */
public class UnmodifiableShortBooleanMapValuesTest extends AbstractMutableBooleanCollectionTestCase {

    @Override
    protected MutableBooleanCollection classUnderTest() {
        return new UnmodifiableShortBooleanMap(ShortBooleanHashMap.newWithKeysValues((short) 1, true, (short) 2, false, (short) 3, true)).values();
    }

    @Override
    protected MutableBooleanCollection newWith(boolean... elements) {
        ShortBooleanHashMap map = new ShortBooleanHashMap();
        for (int i = 0; i < elements.length; i++) {
            map.put((short) i, elements[i]);
        }
        return map.asUnmodifiable().values();
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
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.newWith().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.newWith().removeAll(BooleanArrayList.newListWith(false, true));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.newWith().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.newWith().retainAll(BooleanArrayList.newListWith(false, true));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        MutableBooleanCollection emptyCollection = this.newWith();
        emptyCollection.clear();
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
    public void asSynchronized() {
        MutableBooleanCollection booleanCollection = this.classUnderTest().asSynchronized();
        Verify.assertInstanceOf(SynchronizedBooleanCollection.class, booleanCollection);
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

    @Override
    @Test
    public void booleanIterator_with_remove() {
        MutableBooleanIterator booleanIterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        booleanIterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableBooleanIterator booleanIterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        // Not applicable for Unmodifiable*
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableShortBooleanMapValuesTest instance;

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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableShortBooleanMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableShortBooleanMapValuesTest> iterator_throws_on_consecutive_invocation_of_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableShortBooleanMapValuesTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableShortBooleanMapValuesTest::newCollection;
            this.payloads.isEmpty = UnmodifiableShortBooleanMapValuesTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableShortBooleanMapValuesTest::notEmpty;
            this.payloads.containsAnyArray = UnmodifiableShortBooleanMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableShortBooleanMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableShortBooleanMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableShortBooleanMapValuesTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableShortBooleanMapValuesTest::forEach;
            this.payloads.size = UnmodifiableShortBooleanMapValuesTest::size;
            this.payloads.count = UnmodifiableShortBooleanMapValuesTest::count;
            this.payloads.anySatisfy = UnmodifiableShortBooleanMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableShortBooleanMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableShortBooleanMapValuesTest::noneSatisfy;
            this.payloads.detectIfNone = UnmodifiableShortBooleanMapValuesTest::detectIfNone;
            this.payloads.injectInto = UnmodifiableShortBooleanMapValuesTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableShortBooleanMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableShortBooleanMapValuesTest::reduceIfEmpty;
            this.payloads.toArray = UnmodifiableShortBooleanMapValuesTest::toArray;
            this.payloads.testHashCode = UnmodifiableShortBooleanMapValuesTest::testHashCode;
            this.payloads.testToString = UnmodifiableShortBooleanMapValuesTest::testToString;
            this.payloads.makeString = UnmodifiableShortBooleanMapValuesTest::makeString;
            this.payloads.toList = UnmodifiableShortBooleanMapValuesTest::toList;
            this.payloads.toSet = UnmodifiableShortBooleanMapValuesTest::toSet;
            this.payloads.toBag = UnmodifiableShortBooleanMapValuesTest::toBag;
            this.payloads.asLazy = UnmodifiableShortBooleanMapValuesTest::asLazy;
            this.payloads.booleanIterator = UnmodifiableShortBooleanMapValuesTest::booleanIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = UnmodifiableShortBooleanMapValuesTest::remove;
            this.payloads.containsAllArray = UnmodifiableShortBooleanMapValuesTest::containsAllArray;
            this.payloads.asUnmodifiable = UnmodifiableShortBooleanMapValuesTest::asUnmodifiable;
            this.payloads.containsAllIterable = UnmodifiableShortBooleanMapValuesTest::containsAllIterable;
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableShortBooleanMapValuesTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableShortBooleanMapValuesTest::contains;
            this.payloads.reject = UnmodifiableShortBooleanMapValuesTest::reject;
            this.payloads.select = UnmodifiableShortBooleanMapValuesTest::select;
            this.payloads.collect = UnmodifiableShortBooleanMapValuesTest::collect;
            this.payloads.appendString = UnmodifiableShortBooleanMapValuesTest::appendString;
            this.payloads.chunk = UnmodifiableShortBooleanMapValuesTest::chunk;
            this.payloads.asSynchronized = UnmodifiableShortBooleanMapValuesTest::asSynchronized;
            this.payloads.testEquals = UnmodifiableShortBooleanMapValuesTest::testEquals;
            this.payloads.booleanIterator_with_remove = UnmodifiableShortBooleanMapValuesTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableShortBooleanMapValuesTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = UnmodifiableShortBooleanMapValuesTest::iterator_throws_on_consecutive_invocation_of_remove;
        }
    }
}
