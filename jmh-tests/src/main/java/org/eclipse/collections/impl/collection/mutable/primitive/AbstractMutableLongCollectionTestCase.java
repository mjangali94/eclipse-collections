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
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableLongCollection}s
 * This file was automatically generated from template file abstractMutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractMutableLongCollectionTestCase extends AbstractLongIterableTestCase {

    @Override
    protected abstract MutableLongCollection classUnderTest();

    @Override
    protected abstract MutableLongCollection newWith(long... elements);

    @Override
    protected abstract MutableLongCollection newMutableCollectionWith(long... elements);

    @Test
    public void clear() {
        MutableLongCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableLongCollection collection = this.classUnderTest();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        MutableLongCollection collection1 = this.newWith(0L, 1L, 31L, 32L);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0L));
        Assert.assertFalse(collection1.contains(1L));
        Assert.assertFalse(collection1.contains(31L));
        Assert.assertFalse(collection1.contains(32L));
        MutableLongCollection collection2 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
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
        MutableLongCollection collection = this.newWith(14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L);
        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));
        long[] numbers = { 14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L };
        for (long number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(-1L));
        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));
    }

    @Test
    public void add() {
        MutableLongCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.add(1L));
        Assert.assertEquals(this.newMutableCollectionWith(1L), emptyCollection);
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertTrue(collection.add(4L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L), collection);
    }

    @Test
    public void addAllArray() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll());
        Assert.assertTrue(collection.addAll(4L, 5L, 6L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L), collection);
    }

    @Test
    public void addAllIterable() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll(this.newMutableCollectionWith()));
        Assert.assertTrue(collection.addAll(this.newMutableCollectionWith(4L, 5L, 6L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L), collection);
    }

    @Test
    public void remove() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.remove(-1L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection);
        Assert.assertTrue(collection.remove(3L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L), collection);
    }

    @Test
    public void removeIf() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(LongPredicates.equal(-1L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection);
        Assert.assertTrue(collection.removeIf(LongPredicates.equal(2L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 3L), collection);
        Assert.assertTrue(collection.removeIf(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection);
        Assert.assertFalse(collection.removeIf(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection);
        Assert.assertTrue(collection.removeIf(LongPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.removeIf(LongPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(LongPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(LongPredicates.alwaysFalse()));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(LongPredicates.lessThan(3L)));
        Assert.assertEquals(this.newMutableCollectionWith(3L), collection);
        collection = this.classUnderTest();
        MutableLongCollection remove = this.newMutableCollectionWith(1L, 3L);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2L), collection);
        collection = this.classUnderTest();
        remove = this.newMutableCollectionWith(2L);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 3L), collection);
        collection = this.newMutableCollectionWith(1L, 3L, 2L, 5L, 6L, 4L);
        remove = this.newMutableCollectionWith(2L, 4L, 6L);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 3L, 5L), collection);
        collection = this.newMutableCollectionWith(1L, 3L, 2L, 5L, 6L, 4L);
        remove = this.newMutableCollectionWith(1L, 3L, 5L);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 6L, 4L), collection);
    }

    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1L));
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll());
        Assert.assertFalse(collection.removeAll(-1L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection);
        Assert.assertTrue(collection.removeAll(1L, 5L));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 3L), collection);
        Assert.assertTrue(collection.removeAll(3L, 2L));
        Assert.assertEquals(this.newMutableCollectionWith(), collection);
        MutableLongCollection collection1 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertFalse(collection1.removeAll());
        Assert.assertTrue(collection1.removeAll(0L, 1L));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 2L), collection1);
    }

    @Test
    public void removeAll_iterable() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith()));
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith(-1L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection);
        Assert.assertTrue(collection.removeAll(this.newMutableCollectionWith(1L, 5L)));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 3L), collection);
        MutableLongCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.removeAll(this.newMutableCollectionWith(3L, 2L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection1);
        MutableLongCollection collection2 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L, 3L);
        Assert.assertFalse(collection2.removeAll(new LongArrayList()));
        Assert.assertTrue(collection2.removeAll(LongArrayList.newListWith(0L, 1L)));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 2L, 3L), collection2);
        Assert.assertFalse(collection2.removeAll(LongArrayList.newListWith(0L)));
        Assert.assertTrue(collection2.removeAll(LongArrayList.newListWith(2L)));
        Assert.assertEquals(this.newMutableCollectionWith(3L), collection2);
        MutableLongCollection collection3 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(collection3.removeAll(LongHashBag.newBagWith(0L, 1L, 1L)));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 2L), collection3);
    }

    @Test
    public void retainAll() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(1L, 2L, 3L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection);
        Assert.assertTrue(collection.retainAll(1L, 2L, 5L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L), collection);
        MutableLongCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(-3L, 1L));
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection1);
        Assert.assertTrue(collection1.retainAll(-1L));
        Verify.assertEmpty(collection1);
        MutableLongCollection collection2 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertFalse(collection2.retainAll(0L, 1L, 2L, 3L));
        Assert.assertTrue(collection2.retainAll(0L, 1L, 3L));
        Assert.assertEquals(this.newMutableCollectionWith(0L, 1L, 1L, 3L, 3L, 3L), collection2);
        Assert.assertFalse(collection2.retainAll(0L, 1L, 3L));
        Assert.assertTrue(collection2.retainAll(5L, 3L));
        Assert.assertEquals(this.newMutableCollectionWith(3L, 3L, 3L), collection2);
        MutableLongCollection collection3 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(collection3.retainAll(2L, 8L, 8L, 2L));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 2L), collection3);
        MutableLongCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll());
        Verify.assertEmpty(collection4);
    }

    @Test
    public void retainAll_iterable() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(this.newMutableCollectionWith(1L, 2L, 3L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection);
        Assert.assertTrue(collection.retainAll(this.newMutableCollectionWith(1L, 2L, 5L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L), collection);
        MutableLongCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-3L, 1L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection1);
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-1L)));
        Verify.assertEmpty(collection1);
        MutableLongCollection collection2 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertFalse(collection2.retainAll(this.newMutableCollectionWith(0L, 1L, 2L, 3L)));
        Assert.assertTrue(collection2.retainAll(LongArrayList.newListWith(0L, 1L, 3L)));
        Assert.assertEquals(this.newMutableCollectionWith(0L, 1L, 1L, 3L, 3L, 3L), collection2);
        Assert.assertFalse(collection2.retainAll(LongArrayList.newListWith(0L, 1L, 3L)));
        Assert.assertTrue(collection2.retainAll(LongArrayList.newListWith(5L, 3L)));
        Assert.assertEquals(this.newMutableCollectionWith(3L, 3L, 3L), collection2);
        MutableLongCollection collection3 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(collection3.retainAll(LongHashBag.newBagWith(2L, 8L, 8L, 2L)));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 2L), collection3);
        MutableLongCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll(new LongArrayList()));
        Verify.assertEmpty(collection4);
    }

    @Test
    public void with() {
        MutableLongCollection emptyCollection = this.newWith();
        MutableLongCollection collection = emptyCollection.with(1L);
        MutableLongCollection collection0 = this.newWith().with(1L).with(2L);
        MutableLongCollection collection1 = this.newWith().with(1L).with(2L).with(3L);
        MutableLongCollection collection2 = this.newWith().with(1L).with(2L).with(3L).with(4L);
        MutableLongCollection collection3 = this.newWith().with(1L).with(2L).with(3L).with(4L).with(5L);
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L), collection0);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L), collection3);
    }

    @Test
    public void withAll() {
        MutableLongCollection emptyCollection = this.newWith();
        MutableLongCollection collection = emptyCollection.withAll(this.newMutableCollectionWith(1L));
        MutableLongCollection collection0 = this.newWith().withAll(this.newMutableCollectionWith(1L, 2L));
        MutableLongCollection collection1 = this.newWith().withAll(this.newMutableCollectionWith(1L, 2L, 3L));
        MutableLongCollection collection2 = this.newWith().withAll(this.newMutableCollectionWith(1L, 2L, 3L, 4L));
        MutableLongCollection collection3 = this.newWith().withAll(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L));
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1L), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L), collection0);
        Assert.assertEquals(this.classUnderTest(), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L), collection3);
    }

    @Test
    public void without() {
        MutableLongCollection collection = this.newWith(1L, 2L, 3L, 4L, 5L);
        Assert.assertSame(collection, collection.without(9L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L), collection.without(9L));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 3L, 4L, 5L), collection.without(1L));
        Assert.assertEquals(this.newMutableCollectionWith(3L, 4L, 5L), collection.without(2L));
        Assert.assertEquals(this.newMutableCollectionWith(4L, 5L), collection.without(3L));
        Assert.assertEquals(this.newMutableCollectionWith(5L), collection.without(4L));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(5L));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(6L));
    }

    @Test
    public void withoutAll() {
        MutableLongCollection collection = this.newWith(1L, 2L, 3L, 4L, 5L);
        Assert.assertSame(collection, collection.withoutAll(this.newMutableCollectionWith(8L, 9L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L), collection.withoutAll(this.newMutableCollectionWith(8L, 9L)));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 3L, 4L), collection.withoutAll(this.newMutableCollectionWith(1L, 5L)));
        Assert.assertEquals(this.newMutableCollectionWith(3L, 4L), collection.withoutAll(this.newMutableCollectionWith(2L, 20L)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(3L, 4L)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(9L)));
        MutableLongCollection collection1 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 2L), collection1.withoutAll(LongHashBag.newBagWith(0L, 1L)));
    }

    @Test
    public void asSynchronized() {
        MutableLongCollection collection = this.classUnderTest();
        Assert.assertEquals(collection, collection.asSynchronized());
        Verify.assertInstanceOf(this.newWith(1L, 2L, 3L).asSynchronized().getClass(), this.classUnderTest().asSynchronized());
        MutableLongCollection collection1 = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        MutableLongCollection synchronizedCollection = this.newWith(1L, 2L, 2L, 3L, 3L, 3L).asSynchronized();
        Verify.assertInstanceOf(synchronizedCollection.getClass(), collection1.asSynchronized());
        Assert.assertEquals(synchronizedCollection, collection1.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(this.newWith(1L, 2L, 3L).asUnmodifiable().getClass(), this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.newWith(1L, 2L, 3L).asUnmodifiable(), this.classUnderTest().asUnmodifiable());
        MutableLongCollection collection = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        MutableLongCollection unmodifiableCollection = this.newWith(1L, 2L, 2L, 3L, 3L, 3L).asUnmodifiable();
        Verify.assertInstanceOf(unmodifiableCollection.getClass(), collection.asUnmodifiable());
        Assert.assertEquals(unmodifiableCollection, collection.asUnmodifiable());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void longIterator_throws_non_empty_collection() {
        super.longIterator_throws_non_empty_collection();
        MutableLongCollection collection = this.newWith();
        collection.add(1L);
        collection.add(2L);
        collection.add(3L);
        LongIterator iterator = collection.longIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void longIterator_with_remove() {
        MutableLongCollection longIterable = this.newWith(0L, 1L, 31L, 32L);
        MutableLongIterator iterator = longIterable.longIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(longIterable);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void longIterator_throws_for_remove_before_next() {
        MutableLongCollection longIterable = this.classUnderTest();
        MutableLongIterator iterator = longIterable.longIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void longIterator_throws_for_consecutive_remove() {
        MutableLongCollection longIterable = this.classUnderTest();
        MutableLongIterator iterator = longIterable.longIterator();
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractLongIterableTestCase._Benchmark {

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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::longIterator_throws_non_empty_collection, this.description("longIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator_with_remove, this.description("longIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator_throws_for_remove_before_next, this.description("longIterator_throws_for_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator_throws_for_consecutive_remove, this.description("longIterator_throws_for_consecutive_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableLongCollectionTestCase implementation();
    }
}
