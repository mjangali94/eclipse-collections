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

import java.util.NoSuchElementException;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link BooleanHashBag}.
 */
public class BooleanHashBagTest extends AbstractMutableBooleanBagTestCase {

    @Override
    protected BooleanHashBag classUnderTest() {
        return BooleanHashBag.newBagWith(true, false, true);
    }

    @Override
    protected BooleanHashBag newWith(boolean... elements) {
        return BooleanHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false, true), BooleanHashBag.newBag(BooleanArrayList.newListWith(true, false, true, false, true)));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, BooleanHashBag.newBagWith(true, false, true));
        Verify.assertSize(3, new BooleanHashBag(BooleanHashBag.newBagWith(true, false, true)));
        Verify.assertSize(3, new BooleanHashBag(BooleanArrayList.newListWith(true, false, true)));
    }

    @Override
    @Test
    public void with() {
        super.with();
        BooleanHashBag hashBag = new BooleanHashBag().with(true);
        BooleanHashBag emptyBag = new BooleanHashBag();
        BooleanHashBag hashBag0 = emptyBag.with(true, false);
        BooleanHashBag hashBag1 = new BooleanHashBag().with(true, false, true);
        BooleanHashBag hashBag2 = new BooleanHashBag().with(true).with(false).with(true).with(false);
        BooleanHashBag hashBag3 = new BooleanHashBag().with(true).with(false).with(true).with(false).with(true);
        Assert.assertSame(emptyBag, hashBag0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true), hashBag);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false), hashBag0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true), hashBag1);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false), hashBag2);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false, true), hashBag3);
    }

    @Override
    @Test
    public void booleanIterator() {
        super.booleanIterator();
        BooleanHashBag bag = this.newWith(true, false, false, true, true, true);
        BooleanIterator iterator = bag.booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        BooleanHashBag bag1 = this.newWith(false, false, true);
        bag1.appendString(appendable2);
        Assert.assertEquals(appendable2.toString(), "false, false, true", appendable2.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBooleanList list = this.newWith(true, true, true, false).toList();
        Assert.assertEquals(list, BooleanArrayList.newListWith(false, true, true, true));
    }

    @Override
    @Test
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

        public BooleanHashBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
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
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
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
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
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
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanHashBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = BooleanHashBagTest::newCollectionWith;
            this.payloads.isEmpty = BooleanHashBagTest::isEmpty;
            this.payloads.notEmpty = BooleanHashBagTest::notEmpty;
            this.payloads.contains = BooleanHashBagTest::contains;
            this.payloads.containsAnyArray = BooleanHashBagTest::containsAnyArray;
            this.payloads.containsAnyIterable = BooleanHashBagTest::containsAnyIterable;
            this.payloads.containsNoneArray = BooleanHashBagTest::containsNoneArray;
            this.payloads.containsNoneIterable = BooleanHashBagTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashBagTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashBagTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = BooleanHashBagTest::forEach;
            this.payloads.count = BooleanHashBagTest::count;
            this.payloads.select = BooleanHashBagTest::select;
            this.payloads.reject = BooleanHashBagTest::reject;
            this.payloads.detectIfNone = BooleanHashBagTest::detectIfNone;
            this.payloads.injectInto = BooleanHashBagTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashBagTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = BooleanHashBagTest::reduce;
            this.payloads.reduceIfEmpty = BooleanHashBagTest::reduceIfEmpty;
            this.payloads.toArray = BooleanHashBagTest::toArray;
            this.payloads.toSet = BooleanHashBagTest::toSet;
            this.payloads.toBag = BooleanHashBagTest::toBag;
            this.payloads.asLazy = BooleanHashBagTest::asLazy;
            this.payloads.clear = BooleanHashBagTest::clear;
            this.payloads.containsAllArray = BooleanHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = BooleanHashBagTest::containsAllIterable;
            this.payloads.add = BooleanHashBagTest::add;
            this.payloads.addAllArray = BooleanHashBagTest::addAllArray;
            this.payloads.remove = BooleanHashBagTest::remove;
            this.payloads.removeAll = BooleanHashBagTest::removeAll;
            this.payloads.removeAll_iterable = BooleanHashBagTest::removeAll_iterable;
            this.payloads.retainAll_iterable = BooleanHashBagTest::retainAll_iterable;
            this.payloads.retainAll = BooleanHashBagTest::retainAll;
            this.payloads.withAll = BooleanHashBagTest::withAll;
            this.payloads.without = BooleanHashBagTest::without;
            this.payloads.withoutAll = BooleanHashBagTest::withoutAll;
            this.payloads.asSynchronized = BooleanHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = BooleanHashBagTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = BooleanHashBagTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = BooleanHashBagTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = BooleanHashBagTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = BooleanHashBagTest::chunk;
            this.payloads.sizeDistinct = BooleanHashBagTest::sizeDistinct;
            this.payloads.addAllIterable = BooleanHashBagTest::addAllIterable;
            this.payloads.addOccurrences = BooleanHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = BooleanHashBagTest::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = BooleanHashBagTest::forEachWithOccurrences;
            this.payloads.anySatisfy = BooleanHashBagTest::anySatisfy;
            this.payloads.allSatisfy = BooleanHashBagTest::allSatisfy;
            this.payloads.noneSatisfy = BooleanHashBagTest::noneSatisfy;
            this.payloads.collect = BooleanHashBagTest::collect;
            this.payloads.testEquals = BooleanHashBagTest::testEquals;
            this.payloads.testHashCode = BooleanHashBagTest::testHashCode;
            this.payloads.testToString = BooleanHashBagTest::testToString;
            this.payloads.makeString = BooleanHashBagTest::makeString;
            this.payloads.toImmutable = BooleanHashBagTest::toImmutable;
            this.payloads.topOccurrences = BooleanHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = BooleanHashBagTest::bottomOccurrences;
            this.payloads.newCollection = BooleanHashBagTest::newCollection;
            this.payloads.size = BooleanHashBagTest::size;
            this.payloads.with = BooleanHashBagTest::with;
            this.payloads.booleanIterator = BooleanHashBagTest::booleanIterator;
            this.payloads.appendString = BooleanHashBagTest::appendString;
            this.payloads.toList = BooleanHashBagTest::toList;
            this.payloads.selectUnique = BooleanHashBagTest::selectUnique;
        }
    }
}
