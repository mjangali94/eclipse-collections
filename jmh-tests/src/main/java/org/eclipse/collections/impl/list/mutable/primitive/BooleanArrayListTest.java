/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable.primitive;

import java.lang.reflect.Field;
import java.util.BitSet;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link BooleanArrayList}.
 */
public class BooleanArrayListTest extends AbstractBooleanListTestCase {

    private final BooleanArrayList list = this.classUnderTest();

    @Override
    protected final BooleanArrayList classUnderTest() {
        return BooleanArrayList.newListWith(true, false, true);
    }

    @Override
    protected BooleanArrayList newWith(boolean... elements) {
        return BooleanArrayList.newListWith(elements);
    }

    @Test
    public void testBooleanArrayListWithInitialCapacity() throws Exception {
        MutableBooleanList arrayList = new BooleanArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = BooleanArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(64L, ((BitSet) items.get(arrayList)).size());
        BooleanArrayList arrayList1 = new BooleanArrayList(64);
        Assert.assertEquals(64L, ((BitSet) items.get(arrayList1)).size());
        BooleanArrayList arrayList2 = new BooleanArrayList(65);
        Assert.assertEquals(128L, ((BitSet) items.get(arrayList2)).size());
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        MutableBooleanList listWithCapacity = new BooleanArrayList(64);
        for (int i = 0; i < 64; i++) {
            listWithCapacity.add((i & 1) == 0);
        }
        listWithCapacity.addAtIndex(64, true);
        Field items = BooleanArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(128L, ((BitSet) items.get(listWithCapacity)).size());
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new BooleanArrayList());
        Verify.assertSize(0, new BooleanArrayList(1));
        Verify.assertSize(1, BooleanArrayList.newListWith(false));
        Verify.assertSize(3, this.list);
        Verify.assertSize(3, BooleanArrayList.newList(this.list));
    }

    @Override
    @Test
    public void with() {
        super.with();
        BooleanArrayList emptyList = new BooleanArrayList();
        BooleanArrayList arrayList = emptyList.with(true);
        BooleanArrayList arrayList0 = new BooleanArrayList().with(false, false);
        BooleanArrayList arrayList1 = new BooleanArrayList().with(true, true, false);
        BooleanArrayList arrayList2 = new BooleanArrayList().with(true, true, false, true);
        BooleanArrayList arrayList3 = new BooleanArrayList().with(true, true, false, true, false);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(BooleanArrayList.newListWith(true), arrayList);
        Assert.assertEquals(BooleanArrayList.newListWith(false, false), arrayList0);
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, false), arrayList1);
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, false, true), arrayList2);
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, false, true, false), arrayList3);
    }

    private static class LastValueBeforeFalseWasFalse implements BooleanPredicate {

        private static final long serialVersionUID = 1L;

        private boolean value = true;

        @Override
        public boolean accept(boolean currentValue) {
            boolean oldValue = this.value;
            this.value = currentValue;
            return !currentValue && !oldValue;
        }
    }

    @Test
    public void removeIfWithStatefulPredicate() {
        MutableBooleanList list = this.newWith(true, true, false, false, true, false, true, false, false, false);
        Assert.assertTrue(list.removeIf(new LastValueBeforeFalseWasFalse()));
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, false, true, false, true, false), list);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanArrayListTest instance;

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
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_empty_list() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_empty_list);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst_emptyList_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast_emptyList_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_negative);
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
        public void benchmark_addAll_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size_empty_list() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size_empty_list);
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
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set_throws_index_greater_than_size);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_newWithNValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues_throws_negative_size);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testBooleanArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testBooleanArrayListWithInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndexAtCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndexAtCapacity);
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
        public void benchmark_removeIfWithStatefulPredicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWithStatefulPredicate);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> get_throws_empty_list;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAll_throws_index_greater_than_size_empty_list;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> set_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> testBooleanArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanArrayListTest> removeIfWithStatefulPredicate;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = BooleanArrayListTest::newCollectionWith;
            this.payloads.newCollection = BooleanArrayListTest::newCollection;
            this.payloads.isEmpty = BooleanArrayListTest::isEmpty;
            this.payloads.notEmpty = BooleanArrayListTest::notEmpty;
            this.payloads.contains = BooleanArrayListTest::contains;
            this.payloads.containsAnyArray = BooleanArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = BooleanArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = BooleanArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = BooleanArrayListTest::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.count = BooleanArrayListTest::count;
            this.payloads.anySatisfy = BooleanArrayListTest::anySatisfy;
            this.payloads.allSatisfy = BooleanArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = BooleanArrayListTest::noneSatisfy;
            this.payloads.select = BooleanArrayListTest::select;
            this.payloads.reject = BooleanArrayListTest::reject;
            this.payloads.detectIfNone = BooleanArrayListTest::detectIfNone;
            this.payloads.collect = BooleanArrayListTest::collect;
            this.payloads.injectInto = BooleanArrayListTest::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = BooleanArrayListTest::reduce;
            this.payloads.reduceIfEmpty = BooleanArrayListTest::reduceIfEmpty;
            this.payloads.testHashCode = BooleanArrayListTest::testHashCode;
            this.payloads.toSet = BooleanArrayListTest::toSet;
            this.payloads.toBag = BooleanArrayListTest::toBag;
            this.payloads.asLazy = BooleanArrayListTest::asLazy;
            this.payloads.clear = BooleanArrayListTest::clear;
            this.payloads.containsAllArray = BooleanArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = BooleanArrayListTest::containsAllIterable;
            this.payloads.add = BooleanArrayListTest::add;
            this.payloads.removeAll = BooleanArrayListTest::removeAll;
            this.payloads.removeAll_iterable = BooleanArrayListTest::removeAll_iterable;
            this.payloads.retainAll_iterable = BooleanArrayListTest::retainAll_iterable;
            this.payloads.retainAll = BooleanArrayListTest::retainAll;
            this.payloads.withAll = BooleanArrayListTest::withAll;
            this.payloads.without = BooleanArrayListTest::without;
            this.payloads.withoutAll = BooleanArrayListTest::withoutAll;
            this.payloads.asSynchronized = BooleanArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = BooleanArrayListTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = BooleanArrayListTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = BooleanArrayListTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = BooleanArrayListTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = BooleanArrayListTest::chunk;
            this.payloads.get = BooleanArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_empty_list = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::get_throws_empty_list, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = BooleanArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = BooleanArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = BooleanArrayListTest::indexOf;
            this.payloads.lastIndexOf = BooleanArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = BooleanArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = BooleanArrayListTest::addAllArray;
            this.payloads.addAllIterable = BooleanArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size_empty_list = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::addAll_throws_index_greater_than_size_empty_list, java.lang.IndexOutOfBoundsException.class);
            this.payloads.remove = BooleanArrayListTest::remove;
            this.payloads.removeIf = BooleanArrayListTest::removeIf;
            this.payloads.removeAtIndex = BooleanArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = BooleanArrayListTest::set;
            this.payloads.set_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::set_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.booleanIterator = BooleanArrayListTest::booleanIterator;
            this.payloads.forEach = BooleanArrayListTest::forEach;
            this.payloads.toArray = BooleanArrayListTest::toArray;
            this.payloads.reverseThis = BooleanArrayListTest::reverseThis;
            this.payloads.toReversed = BooleanArrayListTest::toReversed;
            this.payloads.distinct = BooleanArrayListTest::distinct;
            this.payloads.injectIntoWithIndex = BooleanArrayListTest::injectIntoWithIndex;
            this.payloads.forEachWithIndex = BooleanArrayListTest::forEachWithIndex;
            this.payloads.testEquals = BooleanArrayListTest::testEquals;
            this.payloads.testToString = BooleanArrayListTest::testToString;
            this.payloads.makeString = BooleanArrayListTest::makeString;
            this.payloads.newWithNValues = BooleanArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(BooleanArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.appendString = BooleanArrayListTest::appendString;
            this.payloads.toList = BooleanArrayListTest::toList;
            this.payloads.toImmutable = BooleanArrayListTest::toImmutable;
            this.payloads.tap = BooleanArrayListTest::tap;
            this.payloads.collectWithIndex = BooleanArrayListTest::collectWithIndex;
            this.payloads.testBooleanArrayListWithInitialCapacity = BooleanArrayListTest::testBooleanArrayListWithInitialCapacity;
            this.payloads.addAtIndexAtCapacity = BooleanArrayListTest::addAtIndexAtCapacity;
            this.payloads.size = BooleanArrayListTest::size;
            this.payloads.with = BooleanArrayListTest::with;
            this.payloads.removeIfWithStatefulPredicate = BooleanArrayListTest::removeIfWithStatefulPredicate;
        }
    }
}
