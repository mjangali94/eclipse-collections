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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatCollectionTestCase instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCollectionTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableFloatCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableFloatCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableFloatCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractMutableFloatCollectionTestCase::tap;
            this.payloads.contains_NaN = AbstractMutableFloatCollectionTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractMutableFloatCollectionTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractMutableFloatCollectionTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractMutableFloatCollectionTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractMutableFloatCollectionTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractMutableFloatCollectionTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractMutableFloatCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableFloatCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableFloatCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableFloatCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableFloatCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableFloatCollectionTestCase::containsNoneIterable;
            this.payloads.floatIterator = AbstractMutableFloatCollectionTestCase::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCollectionTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableFloatCollectionTestCase::forEach;
            this.payloads.size = AbstractMutableFloatCollectionTestCase::size;
            this.payloads.count = AbstractMutableFloatCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractMutableFloatCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableFloatCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableFloatCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableFloatCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableFloatCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableFloatCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableFloatCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableFloatCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableFloatCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableFloatCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableFloatCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableFloatCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractMutableFloatCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableFloatCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableFloatCollectionTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractMutableFloatCollectionTestCase::sumConsistentRounding;
            this.payloads.average = AbstractMutableFloatCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableFloatCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableFloatCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableFloatCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableFloatCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableFloatCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableFloatCollectionTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableFloatCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatCollectionTestCase::testToString;
            this.payloads.makeString = AbstractMutableFloatCollectionTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatCollectionTestCase::appendString;
            this.payloads.toList = AbstractMutableFloatCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableFloatCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableFloatCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableFloatCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableFloatCollectionTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractMutableFloatCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableFloatCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableFloatCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableFloatCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableFloatCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableFloatCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableFloatCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableFloatCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableFloatCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableFloatCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableFloatCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableFloatCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableFloatCollectionTestCase::chunk;
            this.payloads.clear = AbstractMutableFloatCollectionTestCase::clear;
            this.payloads.testEquals = AbstractMutableFloatCollectionTestCase::testEquals;
            this.payloads.contains = AbstractMutableFloatCollectionTestCase::contains;
            this.payloads.add = AbstractMutableFloatCollectionTestCase::add;
            this.payloads.addAllArray = AbstractMutableFloatCollectionTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractMutableFloatCollectionTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableFloatCollectionTestCase::remove;
            this.payloads.removeIf = AbstractMutableFloatCollectionTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableFloatCollectionTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableFloatCollectionTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableFloatCollectionTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableFloatCollectionTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableFloatCollectionTestCase::with;
            this.payloads.withAll = AbstractMutableFloatCollectionTestCase::withAll;
            this.payloads.without = AbstractMutableFloatCollectionTestCase::without;
            this.payloads.withoutAll = AbstractMutableFloatCollectionTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableFloatCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatCollectionTestCase::asUnmodifiable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCollectionTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = AbstractMutableFloatCollectionTestCase::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = AbstractMutableFloatCollectionTestCase::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = AbstractMutableFloatCollectionTestCase::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableFloatCollectionTestCase::newEmpty;
        }
    }
}
