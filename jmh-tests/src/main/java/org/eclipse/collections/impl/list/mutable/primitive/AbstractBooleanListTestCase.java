/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable.primitive;

import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.tuple.primitive.BooleanIntPair;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableBooleanList}.
 */
public abstract class AbstractBooleanListTestCase extends AbstractMutableBooleanCollectionTestCase {

    @Override
    protected abstract MutableBooleanList classUnderTest();

    @Override
    protected abstract MutableBooleanList newWith(boolean... elements);

    @Override
    protected MutableBooleanList newMutableCollectionWith(boolean... elements) {
        return BooleanArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Object> newObjectCollectionWith(Object... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableBooleanList list = this.classUnderTest();
        Assert.assertTrue(list.get(0));
        Assert.assertFalse(list.get(1));
        Assert.assertTrue(list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_greater_than_size() {
        this.classUnderTest().get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_empty_list() {
        this.newWith().get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_negative() {
        this.classUnderTest().get(-1);
    }

    @Test
    public void getFirst() {
        MutableBooleanList singleItemList = this.newWith(true);
        Assert.assertTrue(singleItemList.getFirst());
        Assert.assertTrue(this.classUnderTest().getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableBooleanList singleItemList = this.newWith(true);
        Assert.assertTrue(singleItemList.getLast());
        Assert.assertTrue(this.classUnderTest().getLast());
        Assert.assertFalse(this.newWith(true, true, false).getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Test
    public void indexOf() {
        MutableBooleanList arrayList = this.newWith(true, false, true);
        Assert.assertEquals(0L, arrayList.indexOf(true));
        Assert.assertEquals(1L, arrayList.indexOf(false));
        Assert.assertEquals(-1L, this.newWith(false, false).indexOf(true));
        MutableBooleanList emptyList = this.newWith();
        Assert.assertEquals(-1L, emptyList.indexOf(true));
        Assert.assertEquals(-1L, emptyList.indexOf(false));
    }

    @Test
    public void lastIndexOf() {
        MutableBooleanList list = this.newWith(true, false, true);
        Assert.assertEquals(2L, list.lastIndexOf(true));
        Assert.assertEquals(1L, list.lastIndexOf(false));
        Assert.assertEquals(-1L, this.newWith(false, false).lastIndexOf(true));
        MutableBooleanList emptyList = this.newWith();
        Assert.assertEquals(-1L, emptyList.lastIndexOf(true));
        Assert.assertEquals(-1L, emptyList.lastIndexOf(false));
    }

    @Test
    public void addAtIndex() {
        MutableBooleanList emptyList = this.newWith();
        emptyList.addAtIndex(0, false);
        Assert.assertEquals(BooleanArrayList.newListWith(false), emptyList);
        MutableBooleanList list = this.classUnderTest();
        list.addAtIndex(3, true);
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, true), list);
        list.addAtIndex(2, false);
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, false, true, true), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, true);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableBooleanList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(false, true, false));
        Assert.assertTrue(list.addAllAtIndex(4, true, true));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true, true, true, false), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableBooleanList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1, new BooleanArrayList()));
        Assert.assertTrue(list.addAll(BooleanArrayList.newListWith(false, true, false)));
        Assert.assertTrue(list.addAllAtIndex(4, BooleanArrayList.newListWith(true, true)));
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true, false, true, true, true, false), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, false, true);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, false, true);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size_empty_list() {
        this.newWith().addAllAtIndex(1, false);
    }

    @Override
    @Test
    public void remove() {
        super.remove();
        Assert.assertFalse(this.newWith(true, true).remove(false));
        MutableBooleanList list = this.classUnderTest();
        Assert.assertTrue(list.remove(true));
        Assert.assertEquals(BooleanArrayList.newListWith(false, true), list);
    }

    @Test
    public void removeIf() {
        Assert.assertFalse(this.newWith(true, true).removeIf(b -> !b));
        MutableBooleanList list1 = this.classUnderTest();
        Assert.assertTrue(list1.removeIf(b -> b));
        Assert.assertEquals(BooleanArrayList.newListWith(false), list1);
        MutableBooleanList list2 = this.classUnderTest();
        Assert.assertTrue(list2.removeIf(b -> !b));
        Assert.assertEquals(BooleanArrayList.newListWith(true, true), list2);
    }

    @Test
    public void removeAtIndex() {
        MutableBooleanList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(BooleanArrayList.newListWith(true, true), list);
        list.removeAtIndex(1);
        Assert.assertEquals(BooleanArrayList.newListWith(true), list);
        list.removeAtIndex(0);
        Assert.assertEquals(BooleanArrayList.newListWith(), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtIndex_throws_index_greater_than_size() {
        this.newWith().removeAtIndex(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtIndex_throws_index_negative() {
        this.classUnderTest().removeAtIndex(-1);
    }

    @Test
    public void set() {
        MutableBooleanList list = this.classUnderTest();
        list.set(1, false);
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), list);
        list.set(1, true);
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, true), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set_throws_index_greater_than_size() {
        this.newWith().set(1, false);
    }

    @Override
    @Test
    public void booleanIterator() {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        String[] sum = new String[2];
        sum[0] = "";
        sum[1] = "";
        this.classUnderTest().forEach(each -> sum[0] += each + " ");
        this.newWith().forEach(each -> sum[1] += each);
        Assert.assertEquals("true false true ", sum[0]);
        Assert.assertEquals("", sum[1]);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, this.classUnderTest());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        MutableBooleanList list = this.classUnderTest();
        Assert.assertEquals(3L, (long) list.toArray().length);
        Assert.assertTrue(list.toArray()[0]);
        Assert.assertFalse(list.toArray()[1]);
        Assert.assertTrue(list.toArray()[2]);
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, false, false), this.newWith(false, false, true, true).reverseThis());
        MutableBooleanList originalList = this.newWith(true, true, false, false);
        Assert.assertSame(originalList, originalList.reverseThis());
        MutableBooleanList originalList2 = this.newWith(true, false, false);
        originalList2.removeAtIndex(2);
        Assert.assertEquals(originalList2, BooleanArrayList.newListWith(true, false));
        Assert.assertEquals(originalList2.reverseThis(), BooleanArrayList.newListWith(false, true));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, false, false), this.newWith(false, false, true, true).toReversed());
        MutableBooleanList originalList = this.newWith(true, true, false, false);
        Assert.assertNotSame(originalList, originalList.toReversed());
    }

    @Test
    public void distinct() {
        Assert.assertEquals(BooleanArrayList.newListWith(true, false), this.newWith(true, true, false, false).distinct());
        Assert.assertEquals(BooleanArrayList.newListWith(false, true), this.newWith(false, false, true, true).distinct());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.newWith(false).distinct());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWith(true).distinct());
    }

    @Test
    public void injectIntoWithIndex() {
        MutableBooleanList list = this.newWith(true, false, true);
        MutableInteger result = list.injectIntoWithIndex(new MutableInteger(0), (object, value, index) -> object.add((value ? 1 : 0) + index));
        Assert.assertEquals(new MutableInteger(5), result);
    }

    @Test
    public void forEachWithIndex() {
        String[] sum = new String[2];
        sum[0] = "";
        sum[1] = "";
        this.classUnderTest().forEachWithIndex((each, index) -> sum[0] += index + ":" + each);
        this.newWith().forEachWithIndex((each, index) -> sum[1] += index + ":" + each);
        Assert.assertEquals("0:true1:false2:true", sum[0]);
        Assert.assertEquals("", sum[1]);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableBooleanList list1 = this.newWith(true, false, true, true);
        MutableBooleanList list2 = this.newWith(true, true, false, true);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[true, false, true]", this.classUnderTest().toString());
        Assert.assertEquals("[]", this.newWith().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("true, false, true", this.classUnderTest().makeString());
        Assert.assertEquals("true", this.newWith(true).makeString("/"));
        Assert.assertEquals("true/false/true", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
    }

    @Test
    public void newWithNValues() {
        Assert.assertEquals(this.newWith(true, true, true), BooleanArrayList.newWithNValues(3, true));
        Assert.assertEquals(this.newWith(false, false), BooleanArrayList.newWithNValues(2, false));
        Assert.assertEquals(this.newWith(), BooleanArrayList.newWithNValues(0, false));
        Assert.assertEquals(this.newWith(), BooleanArrayList.newWithNValues(0, true));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        BooleanArrayList.newWithNValues(-1, true);
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("true, false, true", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("true/false/true", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableBooleanList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), immutable);
    }

    @Test
    public void tap() {
        MutableBooleanList list = BooleanLists.mutable.empty();
        this.classUnderTest().tap(list::add);
        Assert.assertEquals(this.classUnderTest(), list);
    }

    @Test
    public void collectWithIndex() {
        MutableList<BooleanIntPair> pairs = this.classUnderTest().collectWithIndex(PrimitiveTuples::pair);
        MutableBooleanList list1 = pairs.collectBoolean(BooleanIntPair::getOne);
        Assert.assertEquals(this.classUnderTest(), list1);
        MutableIntList list2 = pairs.collectInt(BooleanIntPair::getTwo);
        Assert.assertEquals(IntInterval.zeroTo(this.classUnderTest().size() - 1), list2);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractBooleanListTestCase instance;

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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
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
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
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
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_empty_list() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_empty_list);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst_emptyList_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast_emptyList_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_negative);
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
        public void benchmark_addAll_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size_empty_list() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size_empty_list);
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
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_newWithNValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues_throws_negative_size);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractBooleanListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> get_throws_empty_list;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> addAll_throws_index_greater_than_size_empty_list;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> set_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanListTestCase> collectWithIndex;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractBooleanListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractBooleanListTestCase::newCollection;
            this.payloads.isEmpty = AbstractBooleanListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractBooleanListTestCase::notEmpty;
            this.payloads.contains = AbstractBooleanListTestCase::contains;
            this.payloads.containsAnyArray = AbstractBooleanListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractBooleanListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractBooleanListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractBooleanListTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.count = AbstractBooleanListTestCase::count;
            this.payloads.anySatisfy = AbstractBooleanListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractBooleanListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractBooleanListTestCase::noneSatisfy;
            this.payloads.select = AbstractBooleanListTestCase::select;
            this.payloads.reject = AbstractBooleanListTestCase::reject;
            this.payloads.detectIfNone = AbstractBooleanListTestCase::detectIfNone;
            this.payloads.collect = AbstractBooleanListTestCase::collect;
            this.payloads.injectInto = AbstractBooleanListTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractBooleanListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractBooleanListTestCase::reduceIfEmpty;
            this.payloads.testHashCode = AbstractBooleanListTestCase::testHashCode;
            this.payloads.toSet = AbstractBooleanListTestCase::toSet;
            this.payloads.toBag = AbstractBooleanListTestCase::toBag;
            this.payloads.asLazy = AbstractBooleanListTestCase::asLazy;
            this.payloads.clear = AbstractBooleanListTestCase::clear;
            this.payloads.containsAllArray = AbstractBooleanListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractBooleanListTestCase::containsAllIterable;
            this.payloads.add = AbstractBooleanListTestCase::add;
            this.payloads.removeAll = AbstractBooleanListTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractBooleanListTestCase::removeAll_iterable;
            this.payloads.retainAll_iterable = AbstractBooleanListTestCase::retainAll_iterable;
            this.payloads.retainAll = AbstractBooleanListTestCase::retainAll;
            this.payloads.with = AbstractBooleanListTestCase::with;
            this.payloads.withAll = AbstractBooleanListTestCase::withAll;
            this.payloads.without = AbstractBooleanListTestCase::without;
            this.payloads.withoutAll = AbstractBooleanListTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractBooleanListTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractBooleanListTestCase::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = AbstractBooleanListTestCase::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractBooleanListTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractBooleanListTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.chunk = AbstractBooleanListTestCase::chunk;
            this.payloads.get = AbstractBooleanListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_empty_list = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::get_throws_empty_list, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractBooleanListTestCase::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = AbstractBooleanListTestCase::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.indexOf = AbstractBooleanListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractBooleanListTestCase::lastIndexOf;
            this.payloads.addAtIndex = AbstractBooleanListTestCase::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = AbstractBooleanListTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractBooleanListTestCase::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size_empty_list = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::addAll_throws_index_greater_than_size_empty_list, java.lang.IndexOutOfBoundsException.class);
            this.payloads.remove = AbstractBooleanListTestCase::remove;
            this.payloads.removeIf = AbstractBooleanListTestCase::removeIf;
            this.payloads.removeAtIndex = AbstractBooleanListTestCase::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = AbstractBooleanListTestCase::set;
            this.payloads.set_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::set_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.booleanIterator = AbstractBooleanListTestCase::booleanIterator;
            this.payloads.forEach = AbstractBooleanListTestCase::forEach;
            this.payloads.size = AbstractBooleanListTestCase::size;
            this.payloads.toArray = AbstractBooleanListTestCase::toArray;
            this.payloads.reverseThis = AbstractBooleanListTestCase::reverseThis;
            this.payloads.toReversed = AbstractBooleanListTestCase::toReversed;
            this.payloads.distinct = AbstractBooleanListTestCase::distinct;
            this.payloads.injectIntoWithIndex = AbstractBooleanListTestCase::injectIntoWithIndex;
            this.payloads.forEachWithIndex = AbstractBooleanListTestCase::forEachWithIndex;
            this.payloads.testEquals = AbstractBooleanListTestCase::testEquals;
            this.payloads.testToString = AbstractBooleanListTestCase::testToString;
            this.payloads.makeString = AbstractBooleanListTestCase::makeString;
            this.payloads.newWithNValues = AbstractBooleanListTestCase::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanListTestCase::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.appendString = AbstractBooleanListTestCase::appendString;
            this.payloads.toList = AbstractBooleanListTestCase::toList;
            this.payloads.toImmutable = AbstractBooleanListTestCase::toImmutable;
            this.payloads.tap = AbstractBooleanListTestCase::tap;
            this.payloads.collectWithIndex = AbstractBooleanListTestCase::collectWithIndex;
        }
    }
*/
}
