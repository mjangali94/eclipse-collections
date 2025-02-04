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
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableDoubleCollection}s
 * This file was automatically generated from template file abstractMutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractMutableDoubleCollectionTestCase extends AbstractDoubleIterableTestCase {

    @Override
    protected abstract MutableDoubleCollection classUnderTest();

    @Override
    protected abstract MutableDoubleCollection newWith(double... elements);

    @Override
    protected abstract MutableDoubleCollection newMutableCollectionWith(double... elements);

    @Test
    public void clear() {
        MutableDoubleCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableDoubleCollection collection = this.classUnderTest();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0.0));
        Assert.assertFalse(collection.contains(1.0));
        Assert.assertFalse(collection.contains(2.0));
        Assert.assertFalse(collection.contains(3.0));
        MutableDoubleCollection collection1 = this.newWith(0.0, 1.0, 31.0, 32.0);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0.0));
        Assert.assertFalse(collection1.contains(1.0));
        Assert.assertFalse(collection1.contains(31.0));
        Assert.assertFalse(collection1.contains(32.0));
        MutableDoubleCollection collection2 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
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
        MutableDoubleCollection collection = this.newWith(14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));
        double[] numbers = { 14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0 };
        for (double number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(-1.0));
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));
    }

    @Test
    public void add() {
        MutableDoubleCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.add(1.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0), emptyCollection);
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertTrue(collection.add(4.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0), collection);
    }

    @Test
    public void addAllArray() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll());
        Assert.assertTrue(collection.addAll(4.0, 5.0, 6.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), collection);
    }

    @Test
    public void addAllIterable() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll(this.newMutableCollectionWith()));
        Assert.assertTrue(collection.addAll(this.newMutableCollectionWith(4.0, 5.0, 6.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), collection);
    }

    @Test
    public void remove() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.remove(-1.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection);
        Assert.assertTrue(collection.remove(3.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0), collection);
    }

    @Test
    public void removeIf() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(DoublePredicates.equal(-1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection);
        Assert.assertTrue(collection.removeIf(DoublePredicates.equal(2.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 3.0), collection);
        Assert.assertTrue(collection.removeIf(DoublePredicates.greaterThan(1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection);
        Assert.assertFalse(collection.removeIf(DoublePredicates.greaterThan(1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection);
        Assert.assertTrue(collection.removeIf(DoublePredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.removeIf(DoublePredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(DoublePredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(DoublePredicates.alwaysFalse()));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(DoublePredicates.greaterThan(1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(DoublePredicates.lessThan(3.0)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0), collection);
        collection = this.classUnderTest();
        MutableDoubleCollection remove = this.newMutableCollectionWith(1.0, 3.0);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2.0), collection);
        collection = this.classUnderTest();
        remove = this.newMutableCollectionWith(2.0);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 3.0), collection);
        collection = this.newMutableCollectionWith(1.0, 3.0, 2.0, 5.0, 6.0, 4.0);
        remove = this.newMutableCollectionWith(2.0, 4.0, 6.0);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 3.0, 5.0), collection);
        collection = this.newMutableCollectionWith(1.0, 3.0, 2.0, 5.0, 6.0, 4.0);
        remove = this.newMutableCollectionWith(1.0, 3.0, 5.0);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 6.0, 4.0), collection);
    }

    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1.0));
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll());
        Assert.assertFalse(collection.removeAll(-1.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection);
        Assert.assertTrue(collection.removeAll(1.0, 5.0));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 3.0), collection);
        Assert.assertTrue(collection.removeAll(3.0, 2.0));
        Assert.assertEquals(this.newMutableCollectionWith(), collection);
        MutableDoubleCollection collection1 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertFalse(collection1.removeAll());
        Assert.assertTrue(collection1.removeAll(0.0, 1.0));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 2.0), collection1);
    }

    @Test
    public void removeAll_iterable() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith()));
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith(-1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection);
        Assert.assertTrue(collection.removeAll(this.newMutableCollectionWith(1.0, 5.0)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 3.0), collection);
        MutableDoubleCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.removeAll(this.newMutableCollectionWith(3.0, 2.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection1);
        MutableDoubleCollection collection2 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0);
        Assert.assertFalse(collection2.removeAll(new DoubleArrayList()));
        Assert.assertTrue(collection2.removeAll(DoubleArrayList.newListWith(0.0, 1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 2.0, 3.0), collection2);
        Assert.assertFalse(collection2.removeAll(DoubleArrayList.newListWith(0.0)));
        Assert.assertTrue(collection2.removeAll(DoubleArrayList.newListWith(2.0)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0), collection2);
        MutableDoubleCollection collection3 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(collection3.removeAll(DoubleHashBag.newBagWith(0.0, 1.0, 1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 2.0), collection3);
    }

    @Test
    public void retainAll() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(1.0, 2.0, 3.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection);
        Assert.assertTrue(collection.retainAll(1.0, 2.0, 5.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0), collection);
        MutableDoubleCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(-3.0, 1.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection1);
        Assert.assertTrue(collection1.retainAll(-1.0));
        Verify.assertEmpty(collection1);
        MutableDoubleCollection collection2 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertFalse(collection2.retainAll(0.0, 1.0, 2.0, 3.0));
        Assert.assertTrue(collection2.retainAll(0.0, 1.0, 3.0));
        Assert.assertEquals(this.newMutableCollectionWith(0.0, 1.0, 1.0, 3.0, 3.0, 3.0), collection2);
        Assert.assertFalse(collection2.retainAll(0.0, 1.0, 3.0));
        Assert.assertTrue(collection2.retainAll(5.0, 3.0));
        Assert.assertEquals(this.newMutableCollectionWith(3.0, 3.0, 3.0), collection2);
        MutableDoubleCollection collection3 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(collection3.retainAll(2.0, 8.0, 8.0, 2.0));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 2.0), collection3);
        MutableDoubleCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll());
        Verify.assertEmpty(collection4);
    }

    @Test
    public void retainAll_iterable() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(this.newMutableCollectionWith(1.0, 2.0, 3.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection);
        Assert.assertTrue(collection.retainAll(this.newMutableCollectionWith(1.0, 2.0, 5.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0), collection);
        MutableDoubleCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-3.0, 1.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection1);
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-1.0)));
        Verify.assertEmpty(collection1);
        MutableDoubleCollection collection2 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertFalse(collection2.retainAll(this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0)));
        Assert.assertTrue(collection2.retainAll(DoubleArrayList.newListWith(0.0, 1.0, 3.0)));
        Assert.assertEquals(this.newMutableCollectionWith(0.0, 1.0, 1.0, 3.0, 3.0, 3.0), collection2);
        Assert.assertFalse(collection2.retainAll(DoubleArrayList.newListWith(0.0, 1.0, 3.0)));
        Assert.assertTrue(collection2.retainAll(DoubleArrayList.newListWith(5.0, 3.0)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0, 3.0, 3.0), collection2);
        MutableDoubleCollection collection3 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(collection3.retainAll(DoubleHashBag.newBagWith(2.0, 8.0, 8.0, 2.0)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 2.0), collection3);
        MutableDoubleCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll(new DoubleArrayList()));
        Verify.assertEmpty(collection4);
    }

    @Test
    public void with() {
        MutableDoubleCollection emptyCollection = this.newWith();
        MutableDoubleCollection collection = emptyCollection.with(1.0);
        MutableDoubleCollection collection0 = this.newWith().with(1.0).with(2.0);
        MutableDoubleCollection collection1 = this.newWith().with(1.0).with(2.0).with(3.0);
        MutableDoubleCollection collection2 = this.newWith().with(1.0).with(2.0).with(3.0).with(4.0);
        MutableDoubleCollection collection3 = this.newWith().with(1.0).with(2.0).with(3.0).with(4.0).with(5.0);
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0), collection0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0), collection3);
    }

    @Test
    public void withAll() {
        MutableDoubleCollection emptyCollection = this.newWith();
        MutableDoubleCollection collection = emptyCollection.withAll(this.newMutableCollectionWith(1.0));
        MutableDoubleCollection collection0 = this.newWith().withAll(this.newMutableCollectionWith(1.0, 2.0));
        MutableDoubleCollection collection1 = this.newWith().withAll(this.newMutableCollectionWith(1.0, 2.0, 3.0));
        MutableDoubleCollection collection2 = this.newWith().withAll(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0));
        MutableDoubleCollection collection3 = this.newWith().withAll(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0), collection0);
        Assert.assertEquals(this.classUnderTest(), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0), collection3);
    }

    @Test
    public void without() {
        MutableDoubleCollection collection = this.newWith(1.0, 2.0, 3.0, 4.0, 5.0);
        Assert.assertSame(collection, collection.without(9.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0), collection.without(9.0));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 3.0, 4.0, 5.0), collection.without(1.0));
        Assert.assertEquals(this.newMutableCollectionWith(3.0, 4.0, 5.0), collection.without(2.0));
        Assert.assertEquals(this.newMutableCollectionWith(4.0, 5.0), collection.without(3.0));
        Assert.assertEquals(this.newMutableCollectionWith(5.0), collection.without(4.0));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(5.0));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(6.0));
    }

    @Test
    public void withoutAll() {
        MutableDoubleCollection collection = this.newWith(1.0, 2.0, 3.0, 4.0, 5.0);
        Assert.assertSame(collection, collection.withoutAll(this.newMutableCollectionWith(8.0, 9.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0), collection.withoutAll(this.newMutableCollectionWith(8.0, 9.0)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 3.0, 4.0), collection.withoutAll(this.newMutableCollectionWith(1.0, 5.0)));
        Assert.assertEquals(this.newMutableCollectionWith(3.0, 4.0), collection.withoutAll(this.newMutableCollectionWith(2.0, 20.0)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(3.0, 4.0)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(9.0)));
        MutableDoubleCollection collection1 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 2.0), collection1.withoutAll(DoubleHashBag.newBagWith(0.0, 1.0)));
    }

    @Test
    public void asSynchronized() {
        MutableDoubleCollection collection = this.classUnderTest();
        Assert.assertEquals(collection, collection.asSynchronized());
        Verify.assertInstanceOf(this.newWith(1.0, 2.0, 3.0).asSynchronized().getClass(), this.classUnderTest().asSynchronized());
        MutableDoubleCollection collection1 = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        MutableDoubleCollection synchronizedCollection = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0).asSynchronized();
        Verify.assertInstanceOf(synchronizedCollection.getClass(), collection1.asSynchronized());
        Assert.assertEquals(synchronizedCollection, collection1.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(this.newWith(1.0, 2.0, 3.0).asUnmodifiable().getClass(), this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.newWith(1.0, 2.0, 3.0).asUnmodifiable(), this.classUnderTest().asUnmodifiable());
        MutableDoubleCollection collection = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        MutableDoubleCollection unmodifiableCollection = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0).asUnmodifiable();
        Verify.assertInstanceOf(unmodifiableCollection.getClass(), collection.asUnmodifiable());
        Assert.assertEquals(unmodifiableCollection, collection.asUnmodifiable());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void doubleIterator_throws_non_empty_collection() {
        super.doubleIterator_throws_non_empty_collection();
        MutableDoubleCollection collection = this.newWith();
        collection.add(1.0);
        collection.add(2.0);
        collection.add(3.0);
        DoubleIterator iterator = collection.doubleIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableDoubleCollection doubleIterable = this.newWith(0.0, 1.0, 31.0, 32.0);
        MutableDoubleIterator iterator = doubleIterable.doubleIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(doubleIterable);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void doubleIterator_throws_for_remove_before_next() {
        MutableDoubleCollection doubleIterable = this.classUnderTest();
        MutableDoubleIterator iterator = doubleIterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void doubleIterator_throws_for_consecutive_remove() {
        MutableDoubleCollection doubleIterable = this.classUnderTest();
        MutableDoubleIterator iterator = doubleIterable.doubleIterator();
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

        private AbstractMutableDoubleCollectionTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleCollectionTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableDoubleCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableDoubleCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableDoubleCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractMutableDoubleCollectionTestCase::tap;
            this.payloads.contains_NaN = AbstractMutableDoubleCollectionTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractMutableDoubleCollectionTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractMutableDoubleCollectionTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractMutableDoubleCollectionTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractMutableDoubleCollectionTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractMutableDoubleCollectionTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractMutableDoubleCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableDoubleCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableDoubleCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableDoubleCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableDoubleCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableDoubleCollectionTestCase::containsNoneIterable;
            this.payloads.doubleIterator = AbstractMutableDoubleCollectionTestCase::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleCollectionTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableDoubleCollectionTestCase::forEach;
            this.payloads.size = AbstractMutableDoubleCollectionTestCase::size;
            this.payloads.count = AbstractMutableDoubleCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractMutableDoubleCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableDoubleCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableDoubleCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableDoubleCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableDoubleCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableDoubleCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableDoubleCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableDoubleCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableDoubleCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableDoubleCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableDoubleCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableDoubleCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractMutableDoubleCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableDoubleCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableDoubleCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableDoubleCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableDoubleCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableDoubleCollectionTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractMutableDoubleCollectionTestCase::sumConsistentRounding;
            this.payloads.average = AbstractMutableDoubleCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableDoubleCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableDoubleCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableDoubleCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableDoubleCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableDoubleCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableDoubleCollectionTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableDoubleCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleCollectionTestCase::testToString;
            this.payloads.makeString = AbstractMutableDoubleCollectionTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleCollectionTestCase::appendString;
            this.payloads.toList = AbstractMutableDoubleCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableDoubleCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableDoubleCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableDoubleCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableDoubleCollectionTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractMutableDoubleCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableDoubleCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableDoubleCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableDoubleCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableDoubleCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableDoubleCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableDoubleCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableDoubleCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableDoubleCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableDoubleCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableDoubleCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableDoubleCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableDoubleCollectionTestCase::chunk;
            this.payloads.clear = AbstractMutableDoubleCollectionTestCase::clear;
            this.payloads.testEquals = AbstractMutableDoubleCollectionTestCase::testEquals;
            this.payloads.contains = AbstractMutableDoubleCollectionTestCase::contains;
            this.payloads.add = AbstractMutableDoubleCollectionTestCase::add;
            this.payloads.addAllArray = AbstractMutableDoubleCollectionTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractMutableDoubleCollectionTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableDoubleCollectionTestCase::remove;
            this.payloads.removeIf = AbstractMutableDoubleCollectionTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableDoubleCollectionTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableDoubleCollectionTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableDoubleCollectionTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableDoubleCollectionTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableDoubleCollectionTestCase::with;
            this.payloads.withAll = AbstractMutableDoubleCollectionTestCase::withAll;
            this.payloads.without = AbstractMutableDoubleCollectionTestCase::without;
            this.payloads.withoutAll = AbstractMutableDoubleCollectionTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableDoubleCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleCollectionTestCase::asUnmodifiable;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleCollectionTestCase::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = AbstractMutableDoubleCollectionTestCase::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = AbstractMutableDoubleCollectionTestCase::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = AbstractMutableDoubleCollectionTestCase::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableDoubleCollectionTestCase::newEmpty;
        }
    }
}
