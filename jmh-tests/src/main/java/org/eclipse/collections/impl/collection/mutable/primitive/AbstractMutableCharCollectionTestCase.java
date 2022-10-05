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
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableCharCollection}s
 * This file was automatically generated from template file abstractMutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractMutableCharCollectionTestCase extends AbstractCharIterableTestCase {

    @Override
    protected abstract MutableCharCollection classUnderTest();

    @Override
    protected abstract MutableCharCollection newWith(char... elements);

    @Override
    protected abstract MutableCharCollection newMutableCollectionWith(char... elements);

    @Test
    public void clear() {
        MutableCharCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableCharCollection collection = this.classUnderTest();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains((char) 0));
        Assert.assertFalse(collection.contains((char) 1));
        Assert.assertFalse(collection.contains((char) 2));
        Assert.assertFalse(collection.contains((char) 3));
        MutableCharCollection collection1 = this.newWith((char) 0, (char) 1, (char) 31, (char) 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains((char) 0));
        Assert.assertFalse(collection1.contains((char) 1));
        Assert.assertFalse(collection1.contains((char) 31));
        Assert.assertFalse(collection1.contains((char) 32));
        MutableCharCollection collection2 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
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
        MutableCharCollection collection = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
        char[] numbers = { (char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1 };
        for (char number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((char) -1));
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
    }

    @Test
    public void add() {
        MutableCharCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.add((char) 1));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), emptyCollection);
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertTrue(collection.add((char) 4));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4), collection);
    }

    @Test
    public void addAllArray() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll());
        Assert.assertTrue(collection.addAll((char) 4, (char) 5, (char) 6));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), collection);
    }

    @Test
    public void addAllIterable() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll(this.newMutableCollectionWith()));
        Assert.assertTrue(collection.addAll(this.newMutableCollectionWith((char) 4, (char) 5, (char) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), collection);
    }

    @Test
    public void remove() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.remove((char) -1));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection);
        Assert.assertTrue(collection.remove((char) 3));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2), collection);
    }

    @Test
    public void removeIf() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(CharPredicates.equal((char) -1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection);
        Assert.assertTrue(collection.removeIf(CharPredicates.equal((char) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 3), collection);
        Assert.assertTrue(collection.removeIf(CharPredicates.greaterThan((char) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection);
        Assert.assertFalse(collection.removeIf(CharPredicates.greaterThan((char) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection);
        Assert.assertTrue(collection.removeIf(CharPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.removeIf(CharPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(CharPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(CharPredicates.alwaysFalse()));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(CharPredicates.greaterThan((char) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(CharPredicates.lessThan((char) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 3), collection);
        collection = this.classUnderTest();
        MutableCharCollection remove = this.newMutableCollectionWith((char) 1, (char) 3);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2), collection);
        collection = this.classUnderTest();
        remove = this.newMutableCollectionWith((char) 2);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 3), collection);
        collection = this.newMutableCollectionWith((char) 1, (char) 3, (char) 2, (char) 5, (char) 6, (char) 4);
        remove = this.newMutableCollectionWith((char) 2, (char) 4, (char) 6);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 3, (char) 5), collection);
        collection = this.newMutableCollectionWith((char) 1, (char) 3, (char) 2, (char) 5, (char) 6, (char) 4);
        remove = this.newMutableCollectionWith((char) 1, (char) 3, (char) 5);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 6, (char) 4), collection);
    }

    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll((char) 1));
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll());
        Assert.assertFalse(collection.removeAll((char) -1));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection);
        Assert.assertTrue(collection.removeAll((char) 1, (char) 5));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 3), collection);
        Assert.assertTrue(collection.removeAll((char) 3, (char) 2));
        Assert.assertEquals(this.newMutableCollectionWith(), collection);
        MutableCharCollection collection1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertFalse(collection1.removeAll());
        Assert.assertTrue(collection1.removeAll((char) 0, (char) 1));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 2), collection1);
    }

    @Test
    public void removeAll_iterable() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith()));
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith((char) -1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection);
        Assert.assertTrue(collection.removeAll(this.newMutableCollectionWith((char) 1, (char) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 3), collection);
        MutableCharCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.removeAll(this.newMutableCollectionWith((char) 3, (char) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection1);
        MutableCharCollection collection2 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2, (char) 3);
        Assert.assertFalse(collection2.removeAll(new CharArrayList()));
        Assert.assertTrue(collection2.removeAll(CharArrayList.newListWith((char) 0, (char) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 2, (char) 3), collection2);
        Assert.assertFalse(collection2.removeAll(CharArrayList.newListWith((char) 0)));
        Assert.assertTrue(collection2.removeAll(CharArrayList.newListWith((char) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 3), collection2);
        MutableCharCollection collection3 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(collection3.removeAll(CharHashBag.newBagWith((char) 0, (char) 1, (char) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 2), collection3);
    }

    @Test
    public void retainAll() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection);
        Assert.assertTrue(collection.retainAll((char) 1, (char) 2, (char) 5));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2), collection);
        MutableCharCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll((char) -3, (char) 1));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection1);
        Assert.assertTrue(collection1.retainAll((char) -1));
        Verify.assertEmpty(collection1);
        MutableCharCollection collection2 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertFalse(collection2.retainAll((char) 0, (char) 1, (char) 2, (char) 3));
        Assert.assertTrue(collection2.retainAll((char) 0, (char) 1, (char) 3));
        Assert.assertEquals(this.newMutableCollectionWith((char) 0, (char) 1, (char) 1, (char) 3, (char) 3, (char) 3), collection2);
        Assert.assertFalse(collection2.retainAll((char) 0, (char) 1, (char) 3));
        Assert.assertTrue(collection2.retainAll((char) 5, (char) 3));
        Assert.assertEquals(this.newMutableCollectionWith((char) 3, (char) 3, (char) 3), collection2);
        MutableCharCollection collection3 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(collection3.retainAll((char) 2, (char) 8, (char) 8, (char) 2));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 2), collection3);
        MutableCharCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll());
        Verify.assertEmpty(collection4);
    }

    @Test
    public void retainAll_iterable() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection);
        Assert.assertTrue(collection.retainAll(this.newMutableCollectionWith((char) 1, (char) 2, (char) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2), collection);
        MutableCharCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith((char) -3, (char) 1)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection1);
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith((char) -1)));
        Verify.assertEmpty(collection1);
        MutableCharCollection collection2 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertFalse(collection2.retainAll(this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3)));
        Assert.assertTrue(collection2.retainAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 0, (char) 1, (char) 1, (char) 3, (char) 3, (char) 3), collection2);
        Assert.assertFalse(collection2.retainAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 3)));
        Assert.assertTrue(collection2.retainAll(CharArrayList.newListWith((char) 5, (char) 3)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 3, (char) 3, (char) 3), collection2);
        MutableCharCollection collection3 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(collection3.retainAll(CharHashBag.newBagWith((char) 2, (char) 8, (char) 8, (char) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 2), collection3);
        MutableCharCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll(new CharArrayList()));
        Verify.assertEmpty(collection4);
    }

    @Test
    public void with() {
        MutableCharCollection emptyCollection = this.newWith();
        MutableCharCollection collection = emptyCollection.with((char) 1);
        MutableCharCollection collection0 = this.newWith().with((char) 1).with((char) 2);
        MutableCharCollection collection1 = this.newWith().with((char) 1).with((char) 2).with((char) 3);
        MutableCharCollection collection2 = this.newWith().with((char) 1).with((char) 2).with((char) 3).with((char) 4);
        MutableCharCollection collection3 = this.newWith().with((char) 1).with((char) 2).with((char) 3).with((char) 4).with((char) 5);
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2), collection0);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), collection1);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), collection3);
    }

    @Test
    public void withAll() {
        MutableCharCollection emptyCollection = this.newWith();
        MutableCharCollection collection = emptyCollection.withAll(this.newMutableCollectionWith((char) 1));
        MutableCharCollection collection0 = this.newWith().withAll(this.newMutableCollectionWith((char) 1, (char) 2));
        MutableCharCollection collection1 = this.newWith().withAll(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3));
        MutableCharCollection collection2 = this.newWith().withAll(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4));
        MutableCharCollection collection3 = this.newWith().withAll(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), collection);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2), collection0);
        Assert.assertEquals(this.classUnderTest(), collection1);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), collection3);
    }

    @Test
    public void without() {
        MutableCharCollection collection = this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
        Assert.assertSame(collection, collection.without((char) 9));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), collection.without((char) 9));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 3, (char) 4, (char) 5), collection.without((char) 1));
        Assert.assertEquals(this.newMutableCollectionWith((char) 3, (char) 4, (char) 5), collection.without((char) 2));
        Assert.assertEquals(this.newMutableCollectionWith((char) 4, (char) 5), collection.without((char) 3));
        Assert.assertEquals(this.newMutableCollectionWith((char) 5), collection.without((char) 4));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without((char) 5));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without((char) 6));
    }

    @Test
    public void withoutAll() {
        MutableCharCollection collection = this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
        Assert.assertSame(collection, collection.withoutAll(this.newMutableCollectionWith((char) 8, (char) 9)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), collection.withoutAll(this.newMutableCollectionWith((char) 8, (char) 9)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 3, (char) 4), collection.withoutAll(this.newMutableCollectionWith((char) 1, (char) 5)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 3, (char) 4), collection.withoutAll(this.newMutableCollectionWith((char) 2, (char) 20)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith((char) 3, (char) 4)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith((char) 9)));
        MutableCharCollection collection1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 2), collection1.withoutAll(CharHashBag.newBagWith((char) 0, (char) 1)));
    }

    @Test
    public void asSynchronized() {
        MutableCharCollection collection = this.classUnderTest();
        Assert.assertEquals(collection, collection.asSynchronized());
        Verify.assertInstanceOf(this.newWith((char) 1, (char) 2, (char) 3).asSynchronized().getClass(), this.classUnderTest().asSynchronized());
        MutableCharCollection collection1 = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        MutableCharCollection synchronizedCollection = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3).asSynchronized();
        Verify.assertInstanceOf(synchronizedCollection.getClass(), collection1.asSynchronized());
        Assert.assertEquals(synchronizedCollection, collection1.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(this.newWith((char) 1, (char) 2, (char) 3).asUnmodifiable().getClass(), this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.newWith((char) 1, (char) 2, (char) 3).asUnmodifiable(), this.classUnderTest().asUnmodifiable());
        MutableCharCollection collection = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        MutableCharCollection unmodifiableCollection = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3).asUnmodifiable();
        Verify.assertInstanceOf(unmodifiableCollection.getClass(), collection.asUnmodifiable());
        Assert.assertEquals(unmodifiableCollection, collection.asUnmodifiable());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws_non_empty_collection() {
        super.charIterator_throws_non_empty_collection();
        MutableCharCollection collection = this.newWith();
        collection.add((char) 1);
        collection.add((char) 2);
        collection.add((char) 3);
        CharIterator iterator = collection.charIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void charIterator_with_remove() {
        MutableCharCollection charIterable = this.newWith((char) 0, (char) 1, (char) 31, (char) 32);
        MutableCharIterator iterator = charIterable.charIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(charIterable);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void charIterator_throws_for_remove_before_next() {
        MutableCharCollection charIterable = this.classUnderTest();
        MutableCharIterator iterator = charIterable.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void charIterator_throws_for_consecutive_remove() {
        MutableCharCollection charIterable = this.classUnderTest();
        MutableCharIterator iterator = charIterable.charIterator();
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractCharIterableTestCase._Benchmark {

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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::charIterator_throws_non_empty_collection, this.description("charIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator_with_remove, this.description("charIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator_throws_for_remove_before_next, this.description("charIterator_throws_for_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator_throws_for_consecutive_remove, this.description("charIterator_throws_for_consecutive_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableCharCollectionTestCase implementation();
    }
}
