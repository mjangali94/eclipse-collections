/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableFloatCollection}s
 * This file was automatically generated from template file abstractMutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractMutableFloatCollectionTestCase extends AbstractFloatIterableTestCase {

    @Override
    protected abstract MutableFloatCollection classUnderTest();

    @Override
    protected abstract MutableFloatCollection newWith(float... elements);

    @Override
    protected abstract MutableFloatCollection newMutableCollectionWith(float... elements);

    @Test
    public void clear() {
        MutableFloatCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableFloatCollection collection = this.classUnderTest();
        collection.clear();
        Verify.assertEmpty(collection);
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
        MutableFloatCollection collection2 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        collection2.clear();
        Verify.assertSize(0, collection2);
        Assert.assertEquals(this.newMutableCollectionWith(), collection2);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        Verify.assertPostSerializedEqualsAndHashCode(this.newWith());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatCollection collection = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));
        float[] numbers = { 14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f };
        for (float number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(-1.0f));
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));
    }

    @Test
    public void add() {
        MutableFloatCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.add(1.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), emptyCollection);
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertTrue(collection.add(4.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f), collection);
    }

    @Test
    public void addAllArray() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll());
        Assert.assertTrue(collection.addAll(4.0f, 5.0f, 6.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), collection);
    }

    @Test
    public void addAllIterable() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll(this.newMutableCollectionWith()));
        Assert.assertTrue(collection.addAll(this.newMutableCollectionWith(4.0f, 5.0f, 6.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), collection);
    }

    @Test
    public void remove() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.remove(-1.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection);
        Assert.assertTrue(collection.remove(3.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f), collection);
    }

    @Test
    public void removeIf() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(FloatPredicates.equal(-1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection);
        Assert.assertTrue(collection.removeIf(FloatPredicates.equal(2.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 3.0f), collection);
        Assert.assertTrue(collection.removeIf(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection);
        Assert.assertFalse(collection.removeIf(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection);
        Assert.assertTrue(collection.removeIf(FloatPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.removeIf(FloatPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(FloatPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(FloatPredicates.alwaysFalse()));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(FloatPredicates.lessThan(3.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0f), collection);
        collection = this.classUnderTest();
        MutableFloatCollection remove = this.newMutableCollectionWith(1.0f, 3.0f);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f), collection);
        collection = this.classUnderTest();
        remove = this.newMutableCollectionWith(2.0f);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 3.0f), collection);
        collection = this.newMutableCollectionWith(1.0f, 3.0f, 2.0f, 5.0f, 6.0f, 4.0f);
        remove = this.newMutableCollectionWith(2.0f, 4.0f, 6.0f);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 3.0f, 5.0f), collection);
        collection = this.newMutableCollectionWith(1.0f, 3.0f, 2.0f, 5.0f, 6.0f, 4.0f);
        remove = this.newMutableCollectionWith(1.0f, 3.0f, 5.0f);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 6.0f, 4.0f), collection);
    }

    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1.0f));
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll());
        Assert.assertFalse(collection.removeAll(-1.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection);
        Assert.assertTrue(collection.removeAll(1.0f, 5.0f));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 3.0f), collection);
        Assert.assertTrue(collection.removeAll(3.0f, 2.0f));
        Assert.assertEquals(this.newMutableCollectionWith(), collection);
        MutableFloatCollection collection1 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertFalse(collection1.removeAll());
        Assert.assertTrue(collection1.removeAll(0.0f, 1.0f));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 2.0f), collection1);
    }

    @Test
    public void removeAll_iterable() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith()));
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith(-1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection);
        Assert.assertTrue(collection.removeAll(this.newMutableCollectionWith(1.0f, 5.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 3.0f), collection);
        MutableFloatCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.removeAll(this.newMutableCollectionWith(3.0f, 2.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection1);
        MutableFloatCollection collection2 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 3.0f);
        Assert.assertFalse(collection2.removeAll(new FloatArrayList()));
        Assert.assertTrue(collection2.removeAll(FloatArrayList.newListWith(0.0f, 1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 2.0f, 3.0f), collection2);
        Assert.assertFalse(collection2.removeAll(FloatArrayList.newListWith(0.0f)));
        Assert.assertTrue(collection2.removeAll(FloatArrayList.newListWith(2.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0f), collection2);
        MutableFloatCollection collection3 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(collection3.removeAll(FloatHashBag.newBagWith(0.0f, 1.0f, 1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 2.0f), collection3);
    }

    @Test
    public void retainAll() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection);
        Assert.assertTrue(collection.retainAll(1.0f, 2.0f, 5.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f), collection);
        MutableFloatCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(-3.0f, 1.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection1);
        Assert.assertTrue(collection1.retainAll(-1.0f));
        Verify.assertEmpty(collection1);
        MutableFloatCollection collection2 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertFalse(collection2.retainAll(0.0f, 1.0f, 2.0f, 3.0f));
        Assert.assertTrue(collection2.retainAll(0.0f, 1.0f, 3.0f));
        Assert.assertEquals(this.newMutableCollectionWith(0.0f, 1.0f, 1.0f, 3.0f, 3.0f, 3.0f), collection2);
        Assert.assertFalse(collection2.retainAll(0.0f, 1.0f, 3.0f));
        Assert.assertTrue(collection2.retainAll(5.0f, 3.0f));
        Assert.assertEquals(this.newMutableCollectionWith(3.0f, 3.0f, 3.0f), collection2);
        MutableFloatCollection collection3 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(collection3.retainAll(2.0f, 8.0f, 8.0f, 2.0f));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 2.0f), collection3);
        MutableFloatCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll());
        Verify.assertEmpty(collection4);
    }

    @Test
    public void retainAll_iterable() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection);
        Assert.assertTrue(collection.retainAll(this.newMutableCollectionWith(1.0f, 2.0f, 5.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f), collection);
        MutableFloatCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-3.0f, 1.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection1);
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-1.0f)));
        Verify.assertEmpty(collection1);
        MutableFloatCollection collection2 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertFalse(collection2.retainAll(this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f)));
        Assert.assertTrue(collection2.retainAll(FloatArrayList.newListWith(0.0f, 1.0f, 3.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(0.0f, 1.0f, 1.0f, 3.0f, 3.0f, 3.0f), collection2);
        Assert.assertFalse(collection2.retainAll(FloatArrayList.newListWith(0.0f, 1.0f, 3.0f)));
        Assert.assertTrue(collection2.retainAll(FloatArrayList.newListWith(5.0f, 3.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0f, 3.0f, 3.0f), collection2);
        MutableFloatCollection collection3 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(collection3.retainAll(FloatHashBag.newBagWith(2.0f, 8.0f, 8.0f, 2.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 2.0f), collection3);
        MutableFloatCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll(new FloatArrayList()));
        Verify.assertEmpty(collection4);
    }

    @Test
    public void with() {
        MutableFloatCollection emptyCollection = this.newWith();
        MutableFloatCollection collection = emptyCollection.with(1.0f);
        MutableFloatCollection collection0 = this.newWith().with(1.0f).with(2.0f);
        MutableFloatCollection collection1 = this.newWith().with(1.0f).with(2.0f).with(3.0f);
        MutableFloatCollection collection2 = this.newWith().with(1.0f).with(2.0f).with(3.0f).with(4.0f);
        MutableFloatCollection collection3 = this.newWith().with(1.0f).with(2.0f).with(3.0f).with(4.0f).with(5.0f);
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f), collection0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), collection3);
    }

    @Test
    public void withAll() {
        MutableFloatCollection emptyCollection = this.newWith();
        MutableFloatCollection collection = emptyCollection.withAll(this.newMutableCollectionWith(1.0f));
        MutableFloatCollection collection0 = this.newWith().withAll(this.newMutableCollectionWith(1.0f, 2.0f));
        MutableFloatCollection collection1 = this.newWith().withAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f));
        MutableFloatCollection collection2 = this.newWith().withAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f));
        MutableFloatCollection collection3 = this.newWith().withAll(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f), collection0);
        Assert.assertEquals(this.classUnderTest(), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), collection3);
    }

    @Test
    public void without() {
        MutableFloatCollection collection = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assert.assertSame(collection, collection.without(9.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), collection.without(9.0f));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 3.0f, 4.0f, 5.0f), collection.without(1.0f));
        Assert.assertEquals(this.newMutableCollectionWith(3.0f, 4.0f, 5.0f), collection.without(2.0f));
        Assert.assertEquals(this.newMutableCollectionWith(4.0f, 5.0f), collection.without(3.0f));
        Assert.assertEquals(this.newMutableCollectionWith(5.0f), collection.without(4.0f));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(5.0f));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(6.0f));
    }

    @Test
    public void withoutAll() {
        MutableFloatCollection collection = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assert.assertSame(collection, collection.withoutAll(this.newMutableCollectionWith(8.0f, 9.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), collection.withoutAll(this.newMutableCollectionWith(8.0f, 9.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 3.0f, 4.0f), collection.withoutAll(this.newMutableCollectionWith(1.0f, 5.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0f, 4.0f), collection.withoutAll(this.newMutableCollectionWith(2.0f, 20.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(3.0f, 4.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(9.0f)));
        MutableFloatCollection collection1 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 2.0f), collection1.withoutAll(FloatHashBag.newBagWith(0.0f, 1.0f)));
    }

    @Test
    public void asSynchronized() {
        MutableFloatCollection collection = this.classUnderTest();
        Assert.assertEquals(collection, collection.asSynchronized());
        Verify.assertInstanceOf(this.newWith(1.0f, 2.0f, 3.0f).asSynchronized().getClass(), this.classUnderTest().asSynchronized());
        MutableFloatCollection collection1 = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        MutableFloatCollection synchronizedCollection = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).asSynchronized();
        Verify.assertInstanceOf(synchronizedCollection.getClass(), collection1.asSynchronized());
        Assert.assertEquals(synchronizedCollection, collection1.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(this.newWith(1.0f, 2.0f, 3.0f).asUnmodifiable().getClass(), this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.newWith(1.0f, 2.0f, 3.0f).asUnmodifiable(), this.classUnderTest().asUnmodifiable());
        MutableFloatCollection collection = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        MutableFloatCollection unmodifiableCollection = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).asUnmodifiable();
        Verify.assertInstanceOf(unmodifiableCollection.getClass(), collection.asUnmodifiable());
        Assert.assertEquals(unmodifiableCollection, collection.asUnmodifiable());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void floatIterator_throws_non_empty_collection() {
        super.floatIterator_throws_non_empty_collection();
        MutableFloatCollection collection = this.newWith();
        collection.add(1.0f);
        collection.add(2.0f);
        collection.add(3.0f);
        FloatIterator iterator = collection.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void floatIterator_with_remove() {
        MutableFloatCollection floatIterable = this.newWith(0.0f, 1.0f, 31.0f, 32.0f);
        MutableFloatIterator iterator = floatIterable.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(floatIterable);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void floatIterator_throws_for_remove_before_next() {
        MutableFloatCollection floatIterable = this.classUnderTest();
        MutableFloatIterator iterator = floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void floatIterator_throws_for_consecutive_remove() {
        MutableFloatCollection floatIterable = this.classUnderTest();
        MutableFloatIterator iterator = floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    /**
     * @since 9.2.
     */
    @Test
    public void newEmpty() {
        Assert.assertTrue(this.classUnderTest().newEmpty().isEmpty());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().newEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractFloatIterableTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllArray, this.description("addAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeIf, this.description("removeIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAll, this.description("removeAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAll_iterable, this.description("removeAll_iterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAll, this.description("retainAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAll_iterable, this.description("retainAll_iterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAll, this.description("withAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::without, this.description("without"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutAll, this.description("withoutAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::floatIterator_throws_non_empty_collection, this.description("floatIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator_with_remove, this.description("floatIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator_throws_for_remove_before_next, this.description("floatIterator_throws_for_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator_throws_for_consecutive_remove, this.description("floatIterator_throws_for_consecutive_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableFloatCollectionTestCase implementation();
    }
}
