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
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableIntCollection}s
 * This file was automatically generated from template file abstractMutablePrimitiveCollectionTestCase.stg.
 */
public abstract class AbstractMutableIntCollectionTestCase extends AbstractIntIterableTestCase {

    @Override
    protected abstract MutableIntCollection classUnderTest();

    @Override
    protected abstract MutableIntCollection newWith(int... elements);

    @Override
    protected abstract MutableIntCollection newMutableCollectionWith(int... elements);

    @Test
    public void clear() {
        MutableIntCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);
        MutableIntCollection collection = this.classUnderTest();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0));
        Assert.assertFalse(collection.contains(1));
        Assert.assertFalse(collection.contains(2));
        Assert.assertFalse(collection.contains(3));
        MutableIntCollection collection1 = this.newWith(0, 1, 31, 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0));
        Assert.assertFalse(collection1.contains(1));
        Assert.assertFalse(collection1.contains(31));
        Assert.assertFalse(collection1.contains(32));
        MutableIntCollection collection2 = this.newWith(0, 1, 1, 2, 2, 2);
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
        MutableIntCollection collection = this.newWith(14, 2, 30, 31, 32, 35, 0, 1);
        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));
        int[] numbers = { 14, 2, 30, 31, 32, 35, 0, 1 };
        for (int number : numbers) {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }
        Assert.assertFalse(collection.contains(-1));
        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));
    }

    @Test
    public void add() {
        MutableIntCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.add(1));
        Assert.assertEquals(this.newMutableCollectionWith(1), emptyCollection);
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertTrue(collection.add(4));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4), collection);
    }

    @Test
    public void addAllArray() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll());
        Assert.assertTrue(collection.addAll(4, 5, 6));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6), collection);
    }

    @Test
    public void addAllIterable() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.addAll(this.newMutableCollectionWith()));
        Assert.assertTrue(collection.addAll(this.newMutableCollectionWith(4, 5, 6)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6), collection);
    }

    @Test
    public void remove() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.remove(-1));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection);
        Assert.assertTrue(collection.remove(3));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2), collection);
    }

    @Test
    public void removeIf() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(IntPredicates.equal(-1)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection);
        Assert.assertTrue(collection.removeIf(IntPredicates.equal(2)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 3), collection);
        Assert.assertTrue(collection.removeIf(IntPredicates.greaterThan(1)));
        Assert.assertEquals(this.newMutableCollectionWith(1), collection);
        Assert.assertFalse(collection.removeIf(IntPredicates.greaterThan(1)));
        Assert.assertEquals(this.newMutableCollectionWith(1), collection);
        Assert.assertTrue(collection.removeIf(IntPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.removeIf(IntPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(IntPredicates.alwaysTrue()));
        Assert.assertTrue(collection.isEmpty());
        collection = this.classUnderTest();
        Assert.assertFalse(collection.removeIf(IntPredicates.alwaysFalse()));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(IntPredicates.greaterThan(1)));
        Assert.assertEquals(this.newMutableCollectionWith(1), collection);
        collection = this.classUnderTest();
        Assert.assertTrue(collection.removeIf(IntPredicates.lessThan(3)));
        Assert.assertEquals(this.newMutableCollectionWith(3), collection);
        collection = this.classUnderTest();
        MutableIntCollection remove = this.newMutableCollectionWith(1, 3);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2), collection);
        collection = this.classUnderTest();
        remove = this.newMutableCollectionWith(2);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1, 3), collection);
        collection = this.newMutableCollectionWith(1, 3, 2, 5, 6, 4);
        remove = this.newMutableCollectionWith(2, 4, 6);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(1, 3, 5), collection);
        collection = this.newMutableCollectionWith(1, 3, 2, 5, 6, 4);
        remove = this.newMutableCollectionWith(1, 3, 5);
        Assert.assertTrue(collection.removeIf(remove::contains));
        Assert.assertEquals(this.newMutableCollectionWith(2, 6, 4), collection);
    }

    @Test
    public void removeAll() {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1));
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll());
        Assert.assertFalse(collection.removeAll(-1));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection);
        Assert.assertTrue(collection.removeAll(1, 5));
        Assert.assertEquals(this.newMutableCollectionWith(2, 3), collection);
        Assert.assertTrue(collection.removeAll(3, 2));
        Assert.assertEquals(this.newMutableCollectionWith(), collection);
        MutableIntCollection collection1 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertFalse(collection1.removeAll());
        Assert.assertTrue(collection1.removeAll(0, 1));
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 2), collection1);
    }

    @Test
    public void removeAll_iterable() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith()));
        Assert.assertFalse(collection.removeAll(this.newMutableCollectionWith(-1)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection);
        Assert.assertTrue(collection.removeAll(this.newMutableCollectionWith(1, 5)));
        Assert.assertEquals(this.newMutableCollectionWith(2, 3), collection);
        MutableIntCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.removeAll(this.newMutableCollectionWith(3, 2)));
        Assert.assertEquals(this.newMutableCollectionWith(1), collection1);
        MutableIntCollection collection2 = this.newWith(0, 1, 1, 2, 2, 2, 3);
        Assert.assertFalse(collection2.removeAll(new IntArrayList()));
        Assert.assertTrue(collection2.removeAll(IntArrayList.newListWith(0, 1)));
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 2, 3), collection2);
        Assert.assertFalse(collection2.removeAll(IntArrayList.newListWith(0)));
        Assert.assertTrue(collection2.removeAll(IntArrayList.newListWith(2)));
        Assert.assertEquals(this.newMutableCollectionWith(3), collection2);
        MutableIntCollection collection3 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(collection3.removeAll(IntHashBag.newBagWith(0, 1, 1)));
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 2), collection3);
    }

    @Test
    public void retainAll() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(1, 2, 3));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection);
        Assert.assertTrue(collection.retainAll(1, 2, 5));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2), collection);
        MutableIntCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(-3, 1));
        Assert.assertEquals(this.newMutableCollectionWith(1), collection1);
        Assert.assertTrue(collection1.retainAll(-1));
        Verify.assertEmpty(collection1);
        MutableIntCollection collection2 = this.newWith(0, 1, 1, 2, 2, 2, 3, 3, 3);
        Assert.assertFalse(collection2.retainAll(0, 1, 2, 3));
        Assert.assertTrue(collection2.retainAll(0, 1, 3));
        Assert.assertEquals(this.newMutableCollectionWith(0, 1, 1, 3, 3, 3), collection2);
        Assert.assertFalse(collection2.retainAll(0, 1, 3));
        Assert.assertTrue(collection2.retainAll(5, 3));
        Assert.assertEquals(this.newMutableCollectionWith(3, 3, 3), collection2);
        MutableIntCollection collection3 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(collection3.retainAll(2, 8, 8, 2));
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 2), collection3);
        MutableIntCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll());
        Verify.assertEmpty(collection4);
    }

    @Test
    public void retainAll_iterable() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertFalse(collection.retainAll(this.newMutableCollectionWith(1, 2, 3)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection);
        Assert.assertTrue(collection.retainAll(this.newMutableCollectionWith(1, 2, 5)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2), collection);
        MutableIntCollection collection1 = this.classUnderTest();
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-3, 1)));
        Assert.assertEquals(this.newMutableCollectionWith(1), collection1);
        Assert.assertTrue(collection1.retainAll(this.newMutableCollectionWith(-1)));
        Verify.assertEmpty(collection1);
        MutableIntCollection collection2 = this.newWith(0, 1, 1, 2, 2, 2, 3, 3, 3);
        Assert.assertFalse(collection2.retainAll(this.newMutableCollectionWith(0, 1, 2, 3)));
        Assert.assertTrue(collection2.retainAll(IntArrayList.newListWith(0, 1, 3)));
        Assert.assertEquals(this.newMutableCollectionWith(0, 1, 1, 3, 3, 3), collection2);
        Assert.assertFalse(collection2.retainAll(IntArrayList.newListWith(0, 1, 3)));
        Assert.assertTrue(collection2.retainAll(IntArrayList.newListWith(5, 3)));
        Assert.assertEquals(this.newMutableCollectionWith(3, 3, 3), collection2);
        MutableIntCollection collection3 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(collection3.retainAll(IntHashBag.newBagWith(2, 8, 8, 2)));
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 2), collection3);
        MutableIntCollection collection4 = this.classUnderTest();
        Assert.assertTrue(collection4.retainAll(new IntArrayList()));
        Verify.assertEmpty(collection4);
    }

    @Test
    public void with() {
        MutableIntCollection emptyCollection = this.newWith();
        MutableIntCollection collection = emptyCollection.with(1);
        MutableIntCollection collection0 = this.newWith().with(1).with(2);
        MutableIntCollection collection1 = this.newWith().with(1).with(2).with(3);
        MutableIntCollection collection2 = this.newWith().with(1).with(2).with(3).with(4);
        MutableIntCollection collection3 = this.newWith().with(1).with(2).with(3).with(4).with(5);
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2), collection0);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5), collection3);
    }

    @Test
    public void withAll() {
        MutableIntCollection emptyCollection = this.newWith();
        MutableIntCollection collection = emptyCollection.withAll(this.newMutableCollectionWith(1));
        MutableIntCollection collection0 = this.newWith().withAll(this.newMutableCollectionWith(1, 2));
        MutableIntCollection collection1 = this.newWith().withAll(this.newMutableCollectionWith(1, 2, 3));
        MutableIntCollection collection2 = this.newWith().withAll(this.newMutableCollectionWith(1, 2, 3, 4));
        MutableIntCollection collection3 = this.newWith().withAll(this.newMutableCollectionWith(1, 2, 3, 4, 5));
        Assert.assertSame(emptyCollection, collection);
        Assert.assertEquals(this.newMutableCollectionWith(1), collection);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2), collection0);
        Assert.assertEquals(this.classUnderTest(), collection1);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4), collection2);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5), collection3);
    }

    @Test
    public void without() {
        MutableIntCollection collection = this.newWith(1, 2, 3, 4, 5);
        Assert.assertSame(collection, collection.without(9));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5), collection.without(9));
        Assert.assertEquals(this.newMutableCollectionWith(2, 3, 4, 5), collection.without(1));
        Assert.assertEquals(this.newMutableCollectionWith(3, 4, 5), collection.without(2));
        Assert.assertEquals(this.newMutableCollectionWith(4, 5), collection.without(3));
        Assert.assertEquals(this.newMutableCollectionWith(5), collection.without(4));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(5));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.without(6));
    }

    @Test
    public void withoutAll() {
        MutableIntCollection collection = this.newWith(1, 2, 3, 4, 5);
        Assert.assertSame(collection, collection.withoutAll(this.newMutableCollectionWith(8, 9)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5), collection.withoutAll(this.newMutableCollectionWith(8, 9)));
        Assert.assertEquals(this.newMutableCollectionWith(2, 3, 4), collection.withoutAll(this.newMutableCollectionWith(1, 5)));
        Assert.assertEquals(this.newMutableCollectionWith(3, 4), collection.withoutAll(this.newMutableCollectionWith(2, 20)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(3, 4)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.withoutAll(this.newMutableCollectionWith(9)));
        MutableIntCollection collection1 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 2), collection1.withoutAll(IntHashBag.newBagWith(0, 1)));
    }

    @Test
    public void asSynchronized() {
        MutableIntCollection collection = this.classUnderTest();
        Assert.assertEquals(collection, collection.asSynchronized());
        Verify.assertInstanceOf(this.newWith(1, 2, 3).asSynchronized().getClass(), this.classUnderTest().asSynchronized());
        MutableIntCollection collection1 = this.newWith(1, 2, 2, 3, 3, 3);
        MutableIntCollection synchronizedCollection = this.newWith(1, 2, 2, 3, 3, 3).asSynchronized();
        Verify.assertInstanceOf(synchronizedCollection.getClass(), collection1.asSynchronized());
        Assert.assertEquals(synchronizedCollection, collection1.asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(this.newWith(1, 2, 3).asUnmodifiable().getClass(), this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.newWith(1, 2, 3).asUnmodifiable(), this.classUnderTest().asUnmodifiable());
        MutableIntCollection collection = this.newWith(1, 2, 2, 3, 3, 3);
        MutableIntCollection unmodifiableCollection = this.newWith(1, 2, 2, 3, 3, 3).asUnmodifiable();
        Verify.assertInstanceOf(unmodifiableCollection.getClass(), collection.asUnmodifiable());
        Assert.assertEquals(unmodifiableCollection, collection.asUnmodifiable());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void intIterator_throws_non_empty_collection() {
        super.intIterator_throws_non_empty_collection();
        MutableIntCollection collection = this.newWith();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        IntIterator iterator = collection.intIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void intIterator_with_remove() {
        MutableIntCollection intIterable = this.newWith(0, 1, 31, 32);
        MutableIntIterator iterator = intIterable.intIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(intIterable);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void intIterator_throws_for_remove_before_next() {
        MutableIntCollection intIterable = this.classUnderTest();
        MutableIntIterator iterator = intIterable.intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void intIterator_throws_for_consecutive_remove() {
        MutableIntCollection intIterable = this.classUnderTest();
        MutableIntIterator iterator = intIterable.intIterator();
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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractIntIterableTestCase._Benchmark {

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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::intIterator_throws_non_empty_collection, this.description("intIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intIterator_with_remove, this.description("intIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intIterator_throws_for_remove_before_next, this.description("intIterator_throws_for_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intIterator_throws_for_consecutive_remove, this.description("intIterator_throws_for_consecutive_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableIntCollectionTestCase implementation();
    }
}
