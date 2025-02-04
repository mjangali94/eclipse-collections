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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongCollectionTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCollectionTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableLongCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableLongCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableLongCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractMutableLongCollectionTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableLongCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableLongCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableLongCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableLongCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableLongCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableLongCollectionTestCase::containsNoneIterable;
            this.payloads.longIterator = AbstractMutableLongCollectionTestCase::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCollectionTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableLongCollectionTestCase::forEach;
            this.payloads.size = AbstractMutableLongCollectionTestCase::size;
            this.payloads.count = AbstractMutableLongCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractMutableLongCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableLongCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableLongCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableLongCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableLongCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableLongCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableLongCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableLongCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableLongCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableLongCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableLongCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableLongCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractMutableLongCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableLongCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableLongCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableLongCollectionTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableLongCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableLongCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableLongCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableLongCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableLongCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableLongCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableLongCollectionTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableLongCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableLongCollectionTestCase::testToString;
            this.payloads.makeString = AbstractMutableLongCollectionTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongCollectionTestCase::appendString;
            this.payloads.toList = AbstractMutableLongCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableLongCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableLongCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableLongCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableLongCollectionTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractMutableLongCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableLongCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableLongCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableLongCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableLongCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableLongCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableLongCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableLongCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableLongCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableLongCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableLongCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableLongCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableLongCollectionTestCase::chunk;
            this.payloads.clear = AbstractMutableLongCollectionTestCase::clear;
            this.payloads.testEquals = AbstractMutableLongCollectionTestCase::testEquals;
            this.payloads.contains = AbstractMutableLongCollectionTestCase::contains;
            this.payloads.add = AbstractMutableLongCollectionTestCase::add;
            this.payloads.addAllArray = AbstractMutableLongCollectionTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractMutableLongCollectionTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableLongCollectionTestCase::remove;
            this.payloads.removeIf = AbstractMutableLongCollectionTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableLongCollectionTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableLongCollectionTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableLongCollectionTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableLongCollectionTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableLongCollectionTestCase::with;
            this.payloads.withAll = AbstractMutableLongCollectionTestCase::withAll;
            this.payloads.without = AbstractMutableLongCollectionTestCase::without;
            this.payloads.withoutAll = AbstractMutableLongCollectionTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableLongCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongCollectionTestCase::asUnmodifiable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCollectionTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = AbstractMutableLongCollectionTestCase::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = AbstractMutableLongCollectionTestCase::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = AbstractMutableLongCollectionTestCase::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableLongCollectionTestCase::newEmpty;
        }
    }
}
