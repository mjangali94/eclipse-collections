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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteCollectionTestCase instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCollectionTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableByteCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableByteCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableByteCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractMutableByteCollectionTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableByteCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableByteCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableByteCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableByteCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableByteCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableByteCollectionTestCase::containsNoneIterable;
            this.payloads.byteIterator = AbstractMutableByteCollectionTestCase::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCollectionTestCase::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableByteCollectionTestCase::forEach;
            this.payloads.size = AbstractMutableByteCollectionTestCase::size;
            this.payloads.count = AbstractMutableByteCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractMutableByteCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableByteCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableByteCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableByteCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableByteCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableByteCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableByteCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableByteCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableByteCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableByteCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableByteCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableByteCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractMutableByteCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableByteCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableByteCollectionTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableByteCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableByteCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableByteCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableByteCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableByteCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableByteCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableByteCollectionTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableByteCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteCollectionTestCase::testToString;
            this.payloads.makeString = AbstractMutableByteCollectionTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteCollectionTestCase::appendString;
            this.payloads.toList = AbstractMutableByteCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableByteCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableByteCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableByteCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableByteCollectionTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractMutableByteCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableByteCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableByteCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableByteCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableByteCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableByteCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableByteCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableByteCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableByteCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableByteCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableByteCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableByteCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableByteCollectionTestCase::chunk;
            this.payloads.clear = AbstractMutableByteCollectionTestCase::clear;
            this.payloads.testEquals = AbstractMutableByteCollectionTestCase::testEquals;
            this.payloads.contains = AbstractMutableByteCollectionTestCase::contains;
            this.payloads.add = AbstractMutableByteCollectionTestCase::add;
            this.payloads.addAllArray = AbstractMutableByteCollectionTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractMutableByteCollectionTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableByteCollectionTestCase::remove;
            this.payloads.removeIf = AbstractMutableByteCollectionTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableByteCollectionTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableByteCollectionTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableByteCollectionTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableByteCollectionTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableByteCollectionTestCase::with;
            this.payloads.withAll = AbstractMutableByteCollectionTestCase::withAll;
            this.payloads.without = AbstractMutableByteCollectionTestCase::without;
            this.payloads.withoutAll = AbstractMutableByteCollectionTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableByteCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteCollectionTestCase::asUnmodifiable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCollectionTestCase::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = AbstractMutableByteCollectionTestCase::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = AbstractMutableByteCollectionTestCase::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = AbstractMutableByteCollectionTestCase::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableByteCollectionTestCase::newEmpty;
        }
    }
}
