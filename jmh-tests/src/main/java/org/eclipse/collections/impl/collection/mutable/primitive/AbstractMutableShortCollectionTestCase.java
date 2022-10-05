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
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableShortCollection}s
 * This file was automatically generated from template file abstractMutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractMutableShortCollectionTestCase extends AbstractShortIterableTestCase {

    @Override
    protected abstract MutableShortCollection classUnderTest();

    @Override
    protected abstract MutableShortCollection newWith(short... elements);

    @Override
    protected abstract MutableShortCollection newMutableCollectionWith(short... elements);

    @Test
    public void clear() {
        MutableShortCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableShortCollection collection = this.classUnderTest();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains((short) 0));
        Assert.assertFalse(collection.contains((short) 1));
        Assert.assertFalse(collection.contains((short) 2));
        Assert.assertFalse(collection.contains((short) 3));
        MutableShortCollection collection1 = this.newWith((short) 0, (short) 1, (short) 31, (short) 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains((short) 0));
        Assert.assertFalse(collection1.contains((short) 1));
        Assert.assertFalse(collection1.contains((short) 31));
        Assert.assertFalse(collection1.contains((short) 32));
        MutableShortCollection collection2 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
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
        MutableShortCollection collection = this.newWith((short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertFalse(collection.contains((short) 29));
        Assert.assertFalse(collection.contains((short) 49));
        short[] numbers = { (short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1 };
        for (short number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((short) -1));
        Assert.assertFalse(collection.contains((short) 29));
        Assert.assertFalse(collection.contains((short) 49));
    }

    @Test
    public void add() {
        MutableShortCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.add((short) 1));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), emptyCollection);
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertTrue(collection.add((short) 4));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4), collection);
    }

    @Test
    public void addAllArray() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll());
        Assert.assertTrue(collection.addAll((short) 4, (short) 5, (short) 6));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), collection);
    }

    @Test
    public void addAllIterable() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll(this.newMutableCollectionWith()));
        Assert.assertTrue(collection.addAll(this.newMutableCollectionWith((short) 4, (short) 5, (short) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), collection);
    }

    @Test
    public void remove() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.remove((short) -1));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection);
        Assert.assertTrue(collection.remove((short) 3));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2), collection);
    }

    @Test
    public void removeIf() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(ShortPredicates.equal((short) -1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection);
        Assert.assertTrue(collection.removeIf(ShortPredicates.equal((short) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 3), collection);
        Assert.assertTrue(collection.removeIf(ShortPredicates.greaterThan((short) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection);
        Assert.assertFalse(collection.removeIf(ShortPredicates.greaterThan((short) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection);
        Assert.assertTrue(collection.removeIf(ShortPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.removeIf(ShortPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(ShortPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(ShortPredicates.alwaysFalse()));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(ShortPredicates.greaterThan((short) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(ShortPredicates.lessThan((short) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 3), collection);
        collection = this.classUnderTest();
        MutableShortCollection remove = this.newMutableCollectionWith((short) 1, (short) 3);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2), collection);
        collection = this.classUnderTest();
        remove = this.newMutableCollectionWith((short) 2);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 3), collection);
        collection = this.newMutableCollectionWith((short) 1, (short) 3, (short) 2, (short) 5, (short) 6, (short) 4);
        remove = this.newMutableCollectionWith((short) 2, (short) 4, (short) 6);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 3, (short) 5), collection);
        collection = this.newMutableCollectionWith((short) 1, (short) 3, (short) 2, (short) 5, (short) 6, (short) 4);
        remove = this.newMutableCollectionWith((short) 1, (short) 3, (short) 5);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 6, (short) 4), collection);
    }

    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll((short) 1));
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll());
        Assert.assertFalse(collection.removeAll((short) -1));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection);
        Assert.assertTrue(collection.removeAll((short) 1, (short) 5));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 3), collection);
        Assert.assertTrue(collection.removeAll((short) 3, (short) 2));
        Assert.assertEquals(this.newMutableCollectionWith(), collection);
        MutableShortCollection collection1 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertFalse(collection1.removeAll());
        Assert.assertTrue(collection1.removeAll((short) 0, (short) 1));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 2), collection1);
    }

    @Test
    public void removeAll_iterable() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith()));
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith((short) -1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection);
        Assert.assertTrue(collection.removeAll(this.newMutableCollectionWith((short) 1, (short) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 3), collection);
        MutableShortCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.removeAll(this.newMutableCollectionWith((short) 3, (short) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection1);
        MutableShortCollection collection2 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2, (short) 3);
        Assert.assertFalse(collection2.removeAll(new ShortArrayList()));
        Assert.assertTrue(collection2.removeAll(ShortArrayList.newListWith((short) 0, (short) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 2, (short) 3), collection2);
        Assert.assertFalse(collection2.removeAll(ShortArrayList.newListWith((short) 0)));
        Assert.assertTrue(collection2.removeAll(ShortArrayList.newListWith((short) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 3), collection2);
        MutableShortCollection collection3 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(collection3.removeAll(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 2), collection3);
    }

    @Test
    public void retainAll() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection);
        Assert.assertTrue(collection.retainAll((short) 1, (short) 2, (short) 5));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2), collection);
        MutableShortCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll((short) -3, (short) 1));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection1);
        Assert.assertTrue(collection1.retainAll((short) -1));
        Verify.assertEmpty(collection1);
        MutableShortCollection collection2 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertFalse(collection2.retainAll((short) 0, (short) 1, (short) 2, (short) 3));
        Assert.assertTrue(collection2.retainAll((short) 0, (short) 1, (short) 3));
        Assert.assertEquals(this.newMutableCollectionWith((short) 0, (short) 1, (short) 1, (short) 3, (short) 3, (short) 3), collection2);
        Assert.assertFalse(collection2.retainAll((short) 0, (short) 1, (short) 3));
        Assert.assertTrue(collection2.retainAll((short) 5, (short) 3));
        Assert.assertEquals(this.newMutableCollectionWith((short) 3, (short) 3, (short) 3), collection2);
        MutableShortCollection collection3 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(collection3.retainAll((short) 2, (short) 8, (short) 8, (short) 2));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 2), collection3);
        MutableShortCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll());
        Verify.assertEmpty(collection4);
    }

    @Test
    public void retainAll_iterable() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection);
        Assert.assertTrue(collection.retainAll(this.newMutableCollectionWith((short) 1, (short) 2, (short) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2), collection);
        MutableShortCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith((short) -3, (short) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection1);
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith((short) -1)));
        Verify.assertEmpty(collection1);
        MutableShortCollection collection2 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertFalse(collection2.retainAll(this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3)));
        Assert.assertTrue(collection2.retainAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 0, (short) 1, (short) 1, (short) 3, (short) 3, (short) 3), collection2);
        Assert.assertFalse(collection2.retainAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 3)));
        Assert.assertTrue(collection2.retainAll(ShortArrayList.newListWith((short) 5, (short) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 3, (short) 3, (short) 3), collection2);
        MutableShortCollection collection3 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(collection3.retainAll(ShortHashBag.newBagWith((short) 2, (short) 8, (short) 8, (short) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 2), collection3);
        MutableShortCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll(new ShortArrayList()));
        Verify.assertEmpty(collection4);
    }

    @Test
    public void with() {
        MutableShortCollection emptyCollection = this.newWith();
        MutableShortCollection collection = emptyCollection.with((short) 1);
        MutableShortCollection collection0 = this.newWith().with((short) 1).with((short) 2);
        MutableShortCollection collection1 = this.newWith().with((short) 1).with((short) 2).with((short) 3);
        MutableShortCollection collection2 = this.newWith().with((short) 1).with((short) 2).with((short) 3).with((short) 4);
        MutableShortCollection collection3 = this.newWith().with((short) 1).with((short) 2).with((short) 3).with((short) 4).with((short) 5);
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2), collection0);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), collection1);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), collection3);
    }

    @Test
    public void withAll() {
        MutableShortCollection emptyCollection = this.newWith();
        MutableShortCollection collection = emptyCollection.withAll(this.newMutableCollectionWith((short) 1));
        MutableShortCollection collection0 = this.newWith().withAll(this.newMutableCollectionWith((short) 1, (short) 2));
        MutableShortCollection collection1 = this.newWith().withAll(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3));
        MutableShortCollection collection2 = this.newWith().withAll(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4));
        MutableShortCollection collection3 = this.newWith().withAll(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), collection);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2), collection0);
        Assert.assertEquals(this.classUnderTest(), collection1);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), collection3);
    }

    @Test
    public void without() {
        MutableShortCollection collection = this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        Assert.assertSame(collection, collection.without((short) 9));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), collection.without((short) 9));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 3, (short) 4, (short) 5), collection.without((short) 1));
        Assert.assertEquals(this.newMutableCollectionWith((short) 3, (short) 4, (short) 5), collection.without((short) 2));
        Assert.assertEquals(this.newMutableCollectionWith((short) 4, (short) 5), collection.without((short) 3));
        Assert.assertEquals(this.newMutableCollectionWith((short) 5), collection.without((short) 4));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without((short) 5));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without((short) 6));
    }

    @Test
    public void withoutAll() {
        MutableShortCollection collection = this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        Assert.assertSame(collection, collection.withoutAll(this.newMutableCollectionWith((short) 8, (short) 9)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), collection.withoutAll(this.newMutableCollectionWith((short) 8, (short) 9)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 3, (short) 4), collection.withoutAll(this.newMutableCollectionWith((short) 1, (short) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 3, (short) 4), collection.withoutAll(this.newMutableCollectionWith((short) 2, (short) 20)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith((short) 3, (short) 4)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith((short) 9)));
        MutableShortCollection collection1 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 2), collection1.withoutAll(ShortHashBag.newBagWith((short) 0, (short) 1)));
    }

    @Test
    public void asSynchronized() {
        MutableShortCollection collection = this.classUnderTest();
        Assert.assertEquals(collection, collection.asSynchronized());
        Verify.assertInstanceOf(this.newWith((short) 1, (short) 2, (short) 3).asSynchronized().getClass(), this.classUnderTest().asSynchronized());
        MutableShortCollection collection1 = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        MutableShortCollection synchronizedCollection = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3).asSynchronized();
        Verify.assertInstanceOf(synchronizedCollection.getClass(), collection1.asSynchronized());
        Assert.assertEquals(synchronizedCollection, collection1.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(this.newWith((short) 1, (short) 2, (short) 3).asUnmodifiable().getClass(), this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.newWith((short) 1, (short) 2, (short) 3).asUnmodifiable(), this.classUnderTest().asUnmodifiable());
        MutableShortCollection collection = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        MutableShortCollection unmodifiableCollection = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3).asUnmodifiable();
        Verify.assertInstanceOf(unmodifiableCollection.getClass(), collection.asUnmodifiable());
        Assert.assertEquals(unmodifiableCollection, collection.asUnmodifiable());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void shortIterator_throws_non_empty_collection() {
        super.shortIterator_throws_non_empty_collection();
        MutableShortCollection collection = this.newWith();
        collection.add((short) 1);
        collection.add((short) 2);
        collection.add((short) 3);
        ShortIterator iterator = collection.shortIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void shortIterator_with_remove() {
        MutableShortCollection shortIterable = this.newWith((short) 0, (short) 1, (short) 31, (short) 32);
        MutableShortIterator iterator = shortIterable.shortIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(shortIterable);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void shortIterator_throws_for_remove_before_next() {
        MutableShortCollection shortIterable = this.classUnderTest();
        MutableShortIterator iterator = shortIterable.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void shortIterator_throws_for_consecutive_remove() {
        MutableShortCollection shortIterable = this.classUnderTest();
        MutableShortIterator iterator = shortIterable.shortIterator();
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractShortIterableTestCase._Benchmark {

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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::shortIterator_throws_non_empty_collection, this.description("shortIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator_with_remove, this.description("shortIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator_throws_for_remove_before_next, this.description("shortIterator_throws_for_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator_throws_for_consecutive_remove, this.description("shortIterator_throws_for_consecutive_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableShortCollectionTestCase implementation();
    }
}
