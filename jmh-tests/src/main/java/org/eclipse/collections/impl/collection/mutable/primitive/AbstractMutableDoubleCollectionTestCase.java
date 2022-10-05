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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractDoubleIterableTestCase._Benchmark {

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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::doubleIterator_throws_non_empty_collection, this.description("doubleIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator_with_remove, this.description("doubleIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator_throws_for_remove_before_next, this.description("doubleIterator_throws_for_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator_throws_for_consecutive_remove, this.description("doubleIterator_throws_for_consecutive_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableDoubleCollectionTestCase implementation();
    }
}
