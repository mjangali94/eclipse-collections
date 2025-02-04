/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class BooleanHashSetTest extends AbstractBooleanSetTestCase {

    @Override
    protected BooleanHashSet classUnderTest() {
        return BooleanHashSet.newSetWith(true, false, true);
    }

    @Override
    protected BooleanHashSet newWith(boolean... elements) {
        return BooleanHashSet.newSetWith(elements);
    }

    @Test
    public void construction() throws Exception {
        Field table = BooleanHashSet.class.getDeclaredField("state");
        table.setAccessible(true);
        Assert.assertEquals(0, table.get(new BooleanHashSet()));
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        BooleanHashSet set0 = this.newWith();
        BooleanHashSet set1 = this.newWith(false);
        BooleanHashSet set2 = this.newWith(true);
        BooleanHashSet set3 = this.newWith(true, false);
        BooleanHashSet setFromList = BooleanHashSet.newSet(BooleanArrayList.newListWith(true, true, false));
        BooleanHashSet setFromSet0 = BooleanHashSet.newSet(set0);
        BooleanHashSet setFromSet1 = BooleanHashSet.newSet(set1);
        BooleanHashSet setFromSet2 = BooleanHashSet.newSet(set2);
        BooleanHashSet setFromSet3 = BooleanHashSet.newSet(set3);
        Assert.assertEquals(set3, setFromList);
        Assert.assertEquals(set0, setFromSet0);
        Assert.assertEquals(set1, setFromSet1);
        Assert.assertEquals(set2, setFromSet2);
        Assert.assertEquals(set3, setFromSet3);
    }

    @Override
    @Test
    public void booleanIterator_with_remove() {
        super.booleanIterator_with_remove();
        BooleanHashSet falseSet = this.newWith(false);
        MutableBooleanIterator mutableBooleanIterator = falseSet.booleanIterator();
        Assert.assertTrue(mutableBooleanIterator.hasNext());
        Assert.assertFalse(mutableBooleanIterator.next());
        mutableBooleanIterator.remove();
        Verify.assertEmpty(falseSet);
        Assert.assertThrows(NoSuchElementException.class, mutableBooleanIterator::next);
        Assert.assertThrows(IllegalStateException.class, mutableBooleanIterator::remove);
        BooleanHashSet trueSet = this.newWith(true);
        mutableBooleanIterator = trueSet.booleanIterator();
        Assert.assertTrue(mutableBooleanIterator.hasNext());
        Assert.assertTrue(mutableBooleanIterator.next());
        mutableBooleanIterator.remove();
        Verify.assertEmpty(trueSet);
        Assert.assertThrows(NoSuchElementException.class, mutableBooleanIterator::next);
        Assert.assertThrows(IllegalStateException.class, mutableBooleanIterator::remove);
        MutableBooleanSet emptySet = new BooleanHashSet();
        mutableBooleanIterator = emptySet.booleanIterator();
        Assert.assertFalse(mutableBooleanIterator.hasNext());
        Verify.assertEmpty(emptySet);
        Assert.assertThrows(NoSuchElementException.class, mutableBooleanIterator::next);
        Assert.assertThrows(IllegalStateException.class, mutableBooleanIterator::remove);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanHashSetTest instance;

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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_construction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.construction);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanHashSetTest();
            this.instance.setup();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> construction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanHashSetTest> booleanIterator_with_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAnyArray = BooleanHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = BooleanHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = BooleanHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = BooleanHashSetTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashSetTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashSetTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashSetTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = BooleanHashSetTest::reduce;
            this.payloads.reduceIfEmpty = BooleanHashSetTest::reduceIfEmpty;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = BooleanHashSetTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = BooleanHashSetTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = BooleanHashSetTest::chunk;
            this.payloads.newCollectionWith = BooleanHashSetTest::newCollectionWith;
            this.payloads.isEmpty = BooleanHashSetTest::isEmpty;
            this.payloads.notEmpty = BooleanHashSetTest::notEmpty;
            this.payloads.clear = BooleanHashSetTest::clear;
            this.payloads.contains = BooleanHashSetTest::contains;
            this.payloads.containsAllArray = BooleanHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = BooleanHashSetTest::containsAllIterable;
            this.payloads.add = BooleanHashSetTest::add;
            this.payloads.addAllArray = BooleanHashSetTest::addAllArray;
            this.payloads.addAllIterable = BooleanHashSetTest::addAllIterable;
            this.payloads.remove = BooleanHashSetTest::remove;
            this.payloads.removeAll = BooleanHashSetTest::removeAll;
            this.payloads.removeAll_iterable = BooleanHashSetTest::removeAll_iterable;
            this.payloads.retainAll = BooleanHashSetTest::retainAll;
            this.payloads.retainAll_iterable = BooleanHashSetTest::retainAll_iterable;
            this.payloads.with = BooleanHashSetTest::with;
            this.payloads.withAll = BooleanHashSetTest::withAll;
            this.payloads.without = BooleanHashSetTest::without;
            this.payloads.withoutAll = BooleanHashSetTest::withoutAll;
            this.payloads.toArray = BooleanHashSetTest::toArray;
            this.payloads.toList = BooleanHashSetTest::toList;
            this.payloads.toSet = BooleanHashSetTest::toSet;
            this.payloads.toBag = BooleanHashSetTest::toBag;
            this.payloads.testEquals = BooleanHashSetTest::testEquals;
            this.payloads.testHashCode = BooleanHashSetTest::testHashCode;
            this.payloads.booleanIterator = BooleanHashSetTest::booleanIterator;
            this.payloads.forEach = BooleanHashSetTest::forEach;
            this.payloads.injectInto = BooleanHashSetTest::injectInto;
            this.payloads.size = BooleanHashSetTest::size;
            this.payloads.count = BooleanHashSetTest::count;
            this.payloads.anySatisfy = BooleanHashSetTest::anySatisfy;
            this.payloads.allSatisfy = BooleanHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = BooleanHashSetTest::noneSatisfy;
            this.payloads.select = BooleanHashSetTest::select;
            this.payloads.reject = BooleanHashSetTest::reject;
            this.payloads.detectIfNone = BooleanHashSetTest::detectIfNone;
            this.payloads.collect = BooleanHashSetTest::collect;
            this.payloads.testToString = BooleanHashSetTest::testToString;
            this.payloads.makeString = BooleanHashSetTest::makeString;
            this.payloads.appendString = BooleanHashSetTest::appendString;
            this.payloads.asLazy = BooleanHashSetTest::asLazy;
            this.payloads.asSynchronized = BooleanHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = BooleanHashSetTest::asUnmodifiable;
            this.payloads.union = BooleanHashSetTest::union;
            this.payloads.intersect = BooleanHashSetTest::intersect;
            this.payloads.difference = BooleanHashSetTest::difference;
            this.payloads.symmetricDifference = BooleanHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = BooleanHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = BooleanHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = BooleanHashSetTest::cartesianProduct;
            this.payloads.construction = BooleanHashSetTest::construction;
            this.payloads.newCollection = BooleanHashSetTest::newCollection;
            this.payloads.booleanIterator_with_remove = BooleanHashSetTest::booleanIterator_with_remove;
        }
    }
}
