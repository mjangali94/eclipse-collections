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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharCollectionTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharCollectionTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableCharCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableCharCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableCharCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractMutableCharCollectionTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableCharCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableCharCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableCharCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableCharCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableCharCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableCharCollectionTestCase::containsNoneIterable;
            this.payloads.charIterator = AbstractMutableCharCollectionTestCase::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharCollectionTestCase::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableCharCollectionTestCase::forEach;
            this.payloads.size = AbstractMutableCharCollectionTestCase::size;
            this.payloads.count = AbstractMutableCharCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractMutableCharCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableCharCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableCharCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableCharCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableCharCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableCharCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableCharCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableCharCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableCharCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableCharCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableCharCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableCharCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractMutableCharCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableCharCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableCharCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableCharCollectionTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableCharCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableCharCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableCharCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableCharCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableCharCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableCharCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableCharCollectionTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableCharCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharCollectionTestCase::testToString;
            this.payloads.makeString = AbstractMutableCharCollectionTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharCollectionTestCase::appendString;
            this.payloads.toList = AbstractMutableCharCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableCharCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableCharCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableCharCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableCharCollectionTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractMutableCharCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableCharCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableCharCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableCharCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableCharCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableCharCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableCharCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableCharCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableCharCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableCharCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableCharCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableCharCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableCharCollectionTestCase::chunk;
            this.payloads.clear = AbstractMutableCharCollectionTestCase::clear;
            this.payloads.testEquals = AbstractMutableCharCollectionTestCase::testEquals;
            this.payloads.contains = AbstractMutableCharCollectionTestCase::contains;
            this.payloads.add = AbstractMutableCharCollectionTestCase::add;
            this.payloads.addAllArray = AbstractMutableCharCollectionTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractMutableCharCollectionTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableCharCollectionTestCase::remove;
            this.payloads.removeIf = AbstractMutableCharCollectionTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableCharCollectionTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableCharCollectionTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableCharCollectionTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableCharCollectionTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableCharCollectionTestCase::with;
            this.payloads.withAll = AbstractMutableCharCollectionTestCase::withAll;
            this.payloads.without = AbstractMutableCharCollectionTestCase::without;
            this.payloads.withoutAll = AbstractMutableCharCollectionTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableCharCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharCollectionTestCase::asUnmodifiable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharCollectionTestCase::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = AbstractMutableCharCollectionTestCase::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = AbstractMutableCharCollectionTestCase::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = AbstractMutableCharCollectionTestCase::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableCharCollectionTestCase::newEmpty;
        }
    }
}
