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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortCollectionTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCollectionTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableShortCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableShortCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableShortCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractMutableShortCollectionTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableShortCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableShortCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableShortCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableShortCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableShortCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableShortCollectionTestCase::containsNoneIterable;
            this.payloads.shortIterator = AbstractMutableShortCollectionTestCase::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCollectionTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableShortCollectionTestCase::forEach;
            this.payloads.size = AbstractMutableShortCollectionTestCase::size;
            this.payloads.count = AbstractMutableShortCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractMutableShortCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableShortCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableShortCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableShortCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableShortCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableShortCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableShortCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableShortCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableShortCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableShortCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableShortCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableShortCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractMutableShortCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableShortCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableShortCollectionTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableShortCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableShortCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableShortCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableShortCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableShortCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableShortCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableShortCollectionTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableShortCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortCollectionTestCase::testToString;
            this.payloads.makeString = AbstractMutableShortCollectionTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortCollectionTestCase::appendString;
            this.payloads.toList = AbstractMutableShortCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableShortCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableShortCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableShortCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableShortCollectionTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractMutableShortCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableShortCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableShortCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableShortCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableShortCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableShortCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableShortCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableShortCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableShortCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableShortCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableShortCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableShortCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableShortCollectionTestCase::chunk;
            this.payloads.clear = AbstractMutableShortCollectionTestCase::clear;
            this.payloads.testEquals = AbstractMutableShortCollectionTestCase::testEquals;
            this.payloads.contains = AbstractMutableShortCollectionTestCase::contains;
            this.payloads.add = AbstractMutableShortCollectionTestCase::add;
            this.payloads.addAllArray = AbstractMutableShortCollectionTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractMutableShortCollectionTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableShortCollectionTestCase::remove;
            this.payloads.removeIf = AbstractMutableShortCollectionTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableShortCollectionTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableShortCollectionTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableShortCollectionTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableShortCollectionTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableShortCollectionTestCase::with;
            this.payloads.withAll = AbstractMutableShortCollectionTestCase::withAll;
            this.payloads.without = AbstractMutableShortCollectionTestCase::without;
            this.payloads.withoutAll = AbstractMutableShortCollectionTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableShortCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortCollectionTestCase::asUnmodifiable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCollectionTestCase::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = AbstractMutableShortCollectionTestCase::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = AbstractMutableShortCollectionTestCase::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = AbstractMutableShortCollectionTestCase::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableShortCollectionTestCase::newEmpty;
        }
    }
}
