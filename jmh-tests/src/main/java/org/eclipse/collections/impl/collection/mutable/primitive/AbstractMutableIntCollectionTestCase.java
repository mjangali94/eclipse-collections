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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntCollectionTestCase instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntCollectionTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntCollectionTestCase> newEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableIntCollectionTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableIntCollectionTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableIntCollectionTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntCollectionTestCase::notEmpty;
            this.payloads.tap = AbstractMutableIntCollectionTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableIntCollectionTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableIntCollectionTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableIntCollectionTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableIntCollectionTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableIntCollectionTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableIntCollectionTestCase::containsNoneIterable;
            this.payloads.intIterator = AbstractMutableIntCollectionTestCase::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntCollectionTestCase::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractMutableIntCollectionTestCase::forEach;
            this.payloads.size = AbstractMutableIntCollectionTestCase::size;
            this.payloads.count = AbstractMutableIntCollectionTestCase::count;
            this.payloads.anySatisfy = AbstractMutableIntCollectionTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableIntCollectionTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableIntCollectionTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableIntCollectionTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableIntCollectionTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableIntCollectionTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableIntCollectionTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableIntCollectionTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableIntCollectionTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableIntCollectionTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableIntCollectionTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableIntCollectionTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableIntCollectionTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableIntCollectionTestCase::detectIfNone;
            this.payloads.max = AbstractMutableIntCollectionTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntCollectionTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableIntCollectionTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntCollectionTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableIntCollectionTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableIntCollectionTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableIntCollectionTestCase::sum;
            this.payloads.summaryStatistics = AbstractMutableIntCollectionTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableIntCollectionTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntCollectionTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableIntCollectionTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableIntCollectionTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntCollectionTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableIntCollectionTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableIntCollectionTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableIntCollectionTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableIntCollectionTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableIntCollectionTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableIntCollectionTestCase::testToString;
            this.payloads.makeString = AbstractMutableIntCollectionTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntCollectionTestCase::appendString;
            this.payloads.toList = AbstractMutableIntCollectionTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntCollectionTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractMutableIntCollectionTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableIntCollectionTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableIntCollectionTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableIntCollectionTestCase::toSet;
            this.payloads.toBag = AbstractMutableIntCollectionTestCase::toBag;
            this.payloads.asLazy = AbstractMutableIntCollectionTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableIntCollectionTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableIntCollectionTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableIntCollectionTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableIntCollectionTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableIntCollectionTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableIntCollectionTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableIntCollectionTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableIntCollectionTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableIntCollectionTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntCollectionTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableIntCollectionTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableIntCollectionTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableIntCollectionTestCase::chunk;
            this.payloads.clear = AbstractMutableIntCollectionTestCase::clear;
            this.payloads.testEquals = AbstractMutableIntCollectionTestCase::testEquals;
            this.payloads.contains = AbstractMutableIntCollectionTestCase::contains;
            this.payloads.add = AbstractMutableIntCollectionTestCase::add;
            this.payloads.addAllArray = AbstractMutableIntCollectionTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractMutableIntCollectionTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableIntCollectionTestCase::remove;
            this.payloads.removeIf = AbstractMutableIntCollectionTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableIntCollectionTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableIntCollectionTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableIntCollectionTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableIntCollectionTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableIntCollectionTestCase::with;
            this.payloads.withAll = AbstractMutableIntCollectionTestCase::withAll;
            this.payloads.without = AbstractMutableIntCollectionTestCase::without;
            this.payloads.withoutAll = AbstractMutableIntCollectionTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableIntCollectionTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableIntCollectionTestCase::asUnmodifiable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntCollectionTestCase::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = AbstractMutableIntCollectionTestCase::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = AbstractMutableIntCollectionTestCase::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = AbstractMutableIntCollectionTestCase::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableIntCollectionTestCase::newEmpty;
        }
    }
}
