/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableBooleanBag}.
 */
public class UnmodifiableBooleanBagTest extends AbstractMutableBooleanBagTestCase {

    private final MutableBooleanBag bag = this.classUnderTest();

    @Override
    protected final UnmodifiableBooleanBag classUnderTest() {
        return new UnmodifiableBooleanBag(BooleanHashBag.newBagWith(true, false, true));
    }

    @Override
    protected UnmodifiableBooleanBag newWith(boolean... elements) {
        return new UnmodifiableBooleanBag(BooleanHashBag.newBagWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences() {
        this.bag.addOccurrences(false, 3);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(true, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences() {
        this.bag.removeOccurrences(true, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences(true, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newWith().add(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(true, false, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove(false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().removeAll(true, false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.classUnderTest().removeAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.classUnderTest().retainAll(true, false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.classUnderTest().retainAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.newWith().with(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.newWith().withAll(this.newMutableCollectionWith(true));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.newWith(true, false, true, false, true).without(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.newWith(true, false, true, false, true).withoutAll(this.newMutableCollectionWith(false, false));
    }

    @Override
    @Test
    public void containsAllArray() {
        UnmodifiableBooleanBag collection = this.classUnderTest();
        Assert.assertTrue(collection.containsAll(true));
        Assert.assertTrue(collection.containsAll(true, false, true));
        Assert.assertTrue(collection.containsAll(true, false));
        Assert.assertTrue(collection.containsAll(true, true));
        Assert.assertTrue(collection.containsAll(false, false));
        UnmodifiableBooleanBag emptyCollection = this.newWith();
        Assert.assertFalse(emptyCollection.containsAll(true));
        Assert.assertFalse(emptyCollection.containsAll(false));
        Assert.assertFalse(emptyCollection.containsAll(false, true, false));
        Assert.assertFalse(this.newWith(true, true).containsAll(false, true, false));
        UnmodifiableBooleanBag trueCollection = this.newWith(true, true, true, true);
        Assert.assertFalse(trueCollection.containsAll(true, false));
        UnmodifiableBooleanBag falseCollection = this.newWith(false, false, false, false);
        Assert.assertFalse(falseCollection.containsAll(true, false));
    }

    @Override
    @Test
    public void containsAllIterable() {
        UnmodifiableBooleanBag emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.containsAll(new BooleanArrayList()));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(false)));
        UnmodifiableBooleanBag collection = this.newWith(true, true, false, false, false);
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true, false, true)));
        Assert.assertFalse(this.newWith(true, true).containsAll(BooleanArrayList.newListWith(false, true, false)));
        UnmodifiableBooleanBag trueCollection = this.newWith(true, true, true, true);
        Assert.assertFalse(trueCollection.containsAll(BooleanArrayList.newListWith(true, false)));
        UnmodifiableBooleanBag falseCollection = this.newWith(false, false, false, false);
        Assert.assertFalse(falseCollection.containsAll(BooleanArrayList.newListWith(true, false)));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        Assert.assertSame(this.bag, this.bag.asUnmodifiable());
        Assert.assertEquals(this.bag, this.bag.asUnmodifiable());
    }

    @Override
    @Test
    public void booleanIterator_with_remove() {
        MutableBooleanIterator booleanIterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        booleanIterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableBooleanIterator booleanIterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        // Not applicable for Unmodifiable*
    }

    @Override
    public void selectUnique() {
        super.selectUnique();
        MutableBooleanBag bag = this.classUnderTest();
        MutableBooleanSet expected = BooleanSets.mutable.with(false);
        MutableBooleanSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public UnmodifiableBooleanBagTest instance;

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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableBooleanBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBooleanBagTest> iterator_throws_on_consecutive_invocation_of_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableBooleanBagTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableBooleanBagTest::newCollection;
            this.payloads.isEmpty = UnmodifiableBooleanBagTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableBooleanBagTest::notEmpty;
            this.payloads.contains = UnmodifiableBooleanBagTest::contains;
            this.payloads.containsAnyArray = UnmodifiableBooleanBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableBooleanBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableBooleanBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableBooleanBagTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.booleanIterator = UnmodifiableBooleanBagTest::booleanIterator;
            this.payloads.forEach = UnmodifiableBooleanBagTest::forEach;
            this.payloads.count = UnmodifiableBooleanBagTest::count;
            this.payloads.select = UnmodifiableBooleanBagTest::select;
            this.payloads.reject = UnmodifiableBooleanBagTest::reject;
            this.payloads.detectIfNone = UnmodifiableBooleanBagTest::detectIfNone;
            this.payloads.injectInto = UnmodifiableBooleanBagTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableBooleanBagTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableBooleanBagTest::reduceIfEmpty;
            this.payloads.toArray = UnmodifiableBooleanBagTest::toArray;
            this.payloads.toSet = UnmodifiableBooleanBagTest::toSet;
            this.payloads.toBag = UnmodifiableBooleanBagTest::toBag;
            this.payloads.asLazy = UnmodifiableBooleanBagTest::asLazy;
            this.payloads.asSynchronized = UnmodifiableBooleanBagTest::asSynchronized;
            this.payloads.chunk = UnmodifiableBooleanBagTest::chunk;
            this.payloads.sizeDistinct = UnmodifiableBooleanBagTest::sizeDistinct;
            this.payloads.forEachWithOccurrences = UnmodifiableBooleanBagTest::forEachWithOccurrences;
            this.payloads.size = UnmodifiableBooleanBagTest::size;
            this.payloads.anySatisfy = UnmodifiableBooleanBagTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableBooleanBagTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableBooleanBagTest::noneSatisfy;
            this.payloads.collect = UnmodifiableBooleanBagTest::collect;
            this.payloads.testEquals = UnmodifiableBooleanBagTest::testEquals;
            this.payloads.testHashCode = UnmodifiableBooleanBagTest::testHashCode;
            this.payloads.testToString = UnmodifiableBooleanBagTest::testToString;
            this.payloads.makeString = UnmodifiableBooleanBagTest::makeString;
            this.payloads.appendString = UnmodifiableBooleanBagTest::appendString;
            this.payloads.toList = UnmodifiableBooleanBagTest::toList;
            this.payloads.toImmutable = UnmodifiableBooleanBagTest::toImmutable;
            this.payloads.topOccurrences = UnmodifiableBooleanBagTest::topOccurrences;
            this.payloads.bottomOccurrences = UnmodifiableBooleanBagTest::bottomOccurrences;
            this.payloads.selectUnique = UnmodifiableBooleanBagTest::selectUnique;
            this.payloads.addOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::addOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::addOccurrences_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeOccurrences = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::removeOccurrences, java.lang.UnsupportedOperationException.class);
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::removeOccurrences_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBooleanBagTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.containsAllArray = UnmodifiableBooleanBagTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableBooleanBagTest::containsAllIterable;
            this.payloads.asUnmodifiable = UnmodifiableBooleanBagTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = UnmodifiableBooleanBagTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableBooleanBagTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = UnmodifiableBooleanBagTest::iterator_throws_on_consecutive_invocation_of_remove;
        }
    }
}
