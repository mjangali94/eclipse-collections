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
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableByteCollection}s
 * This file was automatically generated from template file abstractMutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractMutableByteCollectionTestCase extends AbstractByteIterableTestCase {

    @Override
    protected abstract MutableByteCollection classUnderTest();

    @Override
    protected abstract MutableByteCollection newWith(byte... elements);

    @Override
    protected abstract MutableByteCollection newMutableCollectionWith(byte... elements);

    @Test
    public void clear() {
        MutableByteCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableByteCollection collection = this.classUnderTest();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        MutableByteCollection collection1 = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains((byte) 0));
        Assert.assertFalse(collection1.contains((byte) 1));
        Assert.assertFalse(collection1.contains((byte) 31));
        Assert.assertFalse(collection1.contains((byte) 32));
        MutableByteCollection collection2 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
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
        MutableByteCollection collection = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));
        byte[] numbers = { (byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1 };
        for (byte number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((byte) -1));
        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));
    }

    @Test
    public void add() {
        MutableByteCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.add((byte) 1));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), emptyCollection);
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertTrue(collection.add((byte) 4));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), collection);
    }

    @Test
    public void addAllArray() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll());
        Assert.assertTrue(collection.addAll((byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), collection);
    }

    @Test
    public void addAllIterable() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll(this.newMutableCollectionWith()));
        Assert.assertTrue(collection.addAll(this.newMutableCollectionWith((byte) 4, (byte) 5, (byte) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), collection);
    }

    @Test
    public void remove() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.remove((byte) -1));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection);
        Assert.assertTrue(collection.remove((byte) 3));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2), collection);
    }

    @Test
    public void removeIf() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(BytePredicates.equal((byte) -1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection);
        Assert.assertTrue(collection.removeIf(BytePredicates.equal((byte) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 3), collection);
        Assert.assertTrue(collection.removeIf(BytePredicates.greaterThan((byte) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection);
        Assert.assertFalse(collection.removeIf(BytePredicates.greaterThan((byte) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection);
        Assert.assertTrue(collection.removeIf(BytePredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.removeIf(BytePredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(BytePredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(BytePredicates.alwaysFalse()));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(BytePredicates.greaterThan((byte) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(BytePredicates.lessThan((byte) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 3), collection);
        collection = this.classUnderTest();
        MutableByteCollection remove = this.newMutableCollectionWith((byte) 1, (byte) 3);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2), collection);
        collection = this.classUnderTest();
        remove = this.newMutableCollectionWith((byte) 2);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 3), collection);
        collection = this.newMutableCollectionWith((byte) 1, (byte) 3, (byte) 2, (byte) 5, (byte) 6, (byte) 4);
        remove = this.newMutableCollectionWith((byte) 2, (byte) 4, (byte) 6);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 3, (byte) 5), collection);
        collection = this.newMutableCollectionWith((byte) 1, (byte) 3, (byte) 2, (byte) 5, (byte) 6, (byte) 4);
        remove = this.newMutableCollectionWith((byte) 1, (byte) 3, (byte) 5);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 6, (byte) 4), collection);
    }

    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll((byte) 1));
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll());
        Assert.assertFalse(collection.removeAll((byte) -1));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection);
        Assert.assertTrue(collection.removeAll((byte) 1, (byte) 5));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 3), collection);
        Assert.assertTrue(collection.removeAll((byte) 3, (byte) 2));
        Assert.assertEquals(this.newMutableCollectionWith(), collection);
        MutableByteCollection collection1 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertFalse(collection1.removeAll());
        Assert.assertTrue(collection1.removeAll((byte) 0, (byte) 1));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 2), collection1);
    }

    @Test
    public void removeAll_iterable() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith()));
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith((byte) -1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection);
        Assert.assertTrue(collection.removeAll(this.newMutableCollectionWith((byte) 1, (byte) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 3), collection);
        MutableByteCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.removeAll(this.newMutableCollectionWith((byte) 3, (byte) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection1);
        MutableByteCollection collection2 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 3);
        Assert.assertFalse(collection2.removeAll(new ByteArrayList()));
        Assert.assertTrue(collection2.removeAll(ByteArrayList.newListWith((byte) 0, (byte) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 2, (byte) 3), collection2);
        Assert.assertFalse(collection2.removeAll(ByteArrayList.newListWith((byte) 0)));
        Assert.assertTrue(collection2.removeAll(ByteArrayList.newListWith((byte) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 3), collection2);
        MutableByteCollection collection3 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(collection3.removeAll(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 2), collection3);
    }

    @Test
    public void retainAll() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection);
        Assert.assertTrue(collection.retainAll((byte) 1, (byte) 2, (byte) 5));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2), collection);
        MutableByteCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll((byte) -3, (byte) 1));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection1);
        Assert.assertTrue(collection1.retainAll((byte) -1));
        Verify.assertEmpty(collection1);
        MutableByteCollection collection2 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertFalse(collection2.retainAll((byte) 0, (byte) 1, (byte) 2, (byte) 3));
        Assert.assertTrue(collection2.retainAll((byte) 0, (byte) 1, (byte) 3));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 1, (byte) 3, (byte) 3, (byte) 3), collection2);
        Assert.assertFalse(collection2.retainAll((byte) 0, (byte) 1, (byte) 3));
        Assert.assertTrue(collection2.retainAll((byte) 5, (byte) 3));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 3, (byte) 3, (byte) 3), collection2);
        MutableByteCollection collection3 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(collection3.retainAll((byte) 2, (byte) 8, (byte) 8, (byte) 2));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 2), collection3);
        MutableByteCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll());
        Verify.assertEmpty(collection4);
    }

    @Test
    public void retainAll_iterable() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection);
        Assert.assertTrue(collection.retainAll(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2), collection);
        MutableByteCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith((byte) -3, (byte) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection1);
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith((byte) -1)));
        Verify.assertEmpty(collection1);
        MutableByteCollection collection2 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertFalse(collection2.retainAll(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3)));
        Assert.assertTrue(collection2.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 1, (byte) 3, (byte) 3, (byte) 3), collection2);
        Assert.assertFalse(collection2.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 3)));
        Assert.assertTrue(collection2.retainAll(ByteArrayList.newListWith((byte) 5, (byte) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 3, (byte) 3, (byte) 3), collection2);
        MutableByteCollection collection3 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(collection3.retainAll(ByteHashBag.newBagWith((byte) 2, (byte) 8, (byte) 8, (byte) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 2), collection3);
        MutableByteCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll(new ByteArrayList()));
        Verify.assertEmpty(collection4);
    }

    @Test
    public void with() {
        MutableByteCollection emptyCollection = this.newWith();
        MutableByteCollection collection = emptyCollection.with((byte) 1);
        MutableByteCollection collection0 = this.newWith().with((byte) 1).with((byte) 2);
        MutableByteCollection collection1 = this.newWith().with((byte) 1).with((byte) 2).with((byte) 3);
        MutableByteCollection collection2 = this.newWith().with((byte) 1).with((byte) 2).with((byte) 3).with((byte) 4);
        MutableByteCollection collection3 = this.newWith().with((byte) 1).with((byte) 2).with((byte) 3).with((byte) 4).with((byte) 5);
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2), collection0);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), collection1);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), collection3);
    }

    @Test
    public void withAll() {
        MutableByteCollection emptyCollection = this.newWith();
        MutableByteCollection collection = emptyCollection.withAll(this.newMutableCollectionWith((byte) 1));
        MutableByteCollection collection0 = this.newWith().withAll(this.newMutableCollectionWith((byte) 1, (byte) 2));
        MutableByteCollection collection1 = this.newWith().withAll(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3));
        MutableByteCollection collection2 = this.newWith().withAll(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        MutableByteCollection collection3 = this.newWith().withAll(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), collection);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2), collection0);
        Assert.assertEquals(this.classUnderTest(), collection1);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), collection3);
    }

    @Test
    public void without() {
        MutableByteCollection collection = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        Assert.assertSame(collection, collection.without((byte) 9));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), collection.without((byte) 9));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 3, (byte) 4, (byte) 5), collection.without((byte) 1));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 3, (byte) 4, (byte) 5), collection.without((byte) 2));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 4, (byte) 5), collection.without((byte) 3));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 5), collection.without((byte) 4));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without((byte) 5));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without((byte) 6));
    }

    @Test
    public void withoutAll() {
        MutableByteCollection collection = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        Assert.assertSame(collection, collection.withoutAll(this.newMutableCollectionWith((byte) 8, (byte) 9)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), collection.withoutAll(this.newMutableCollectionWith((byte) 8, (byte) 9)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 3, (byte) 4), collection.withoutAll(this.newMutableCollectionWith((byte) 1, (byte) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 3, (byte) 4), collection.withoutAll(this.newMutableCollectionWith((byte) 2, (byte) 20)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith((byte) 3, (byte) 4)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith((byte) 9)));
        MutableByteCollection collection1 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 2), collection1.withoutAll(ByteHashBag.newBagWith((byte) 0, (byte) 1)));
    }

    @Test
    public void asSynchronized() {
        MutableByteCollection collection = this.classUnderTest();
        Assert.assertEquals(collection, collection.asSynchronized());
        Verify.assertInstanceOf(this.newWith((byte) 1, (byte) 2, (byte) 3).asSynchronized().getClass(), this.classUnderTest().asSynchronized());
        MutableByteCollection collection1 = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        MutableByteCollection synchronizedCollection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).asSynchronized();
        Verify.assertInstanceOf(synchronizedCollection.getClass(), collection1.asSynchronized());
        Assert.assertEquals(synchronizedCollection, collection1.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(this.newWith((byte) 1, (byte) 2, (byte) 3).asUnmodifiable().getClass(), this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.newWith((byte) 1, (byte) 2, (byte) 3).asUnmodifiable(), this.classUnderTest().asUnmodifiable());
        MutableByteCollection collection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        MutableByteCollection unmodifiableCollection = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).asUnmodifiable();
        Verify.assertInstanceOf(unmodifiableCollection.getClass(), collection.asUnmodifiable());
        Assert.assertEquals(unmodifiableCollection, collection.asUnmodifiable());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void byteIterator_throws_non_empty_collection() {
        super.byteIterator_throws_non_empty_collection();
        MutableByteCollection collection = this.newWith();
        collection.add((byte) 1);
        collection.add((byte) 2);
        collection.add((byte) 3);
        ByteIterator iterator = collection.byteIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void byteIterator_with_remove() {
        MutableByteCollection byteIterable = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32);
        MutableByteIterator iterator = byteIterable.byteIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(byteIterable);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void byteIterator_throws_for_remove_before_next() {
        MutableByteCollection byteIterable = this.classUnderTest();
        MutableByteIterator iterator = byteIterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void byteIterator_throws_for_consecutive_remove() {
        MutableByteCollection byteIterable = this.classUnderTest();
        MutableByteIterator iterator = byteIterable.byteIterator();
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractByteIterableTestCase._Benchmark {

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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::byteIterator_throws_non_empty_collection, this.description("byteIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator_with_remove, this.description("byteIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator_throws_for_remove_before_next, this.description("byteIterator_throws_for_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator_throws_for_consecutive_remove, this.description("byteIterator_throws_for_consecutive_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableByteCollectionTestCase implementation();
    }
}
