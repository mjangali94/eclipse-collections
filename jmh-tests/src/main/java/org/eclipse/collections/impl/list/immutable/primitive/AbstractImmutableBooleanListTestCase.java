/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableBooleanList}.
 */
public abstract class AbstractImmutableBooleanListTestCase extends AbstractImmutableBooleanCollectionTestCase {

    @Override
    protected abstract ImmutableBooleanList classUnderTest();

    @Override
    protected ImmutableBooleanList newWith(boolean... elements) {
        return BooleanLists.immutable.of(elements);
    }

    @Override
    protected MutableBooleanList newMutableCollectionWith(boolean... elements) {
        return BooleanArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Object> newObjectCollectionWith(Object... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void newWithOn64ElementCollection() {
        MutableBooleanList sixtyFourElementCollection = new BooleanArrayList();
        for (int i = 0; i < 64; i++) {
            sixtyFourElementCollection.add(true);
        }
        ImmutableBooleanList immutableBooleanList = sixtyFourElementCollection.toImmutable();
        Assert.assertEquals(sixtyFourElementCollection, immutableBooleanList);
        ImmutableBooleanList newImmutableBooleanList = immutableBooleanList.newWith(false);
        Assert.assertFalse(newImmutableBooleanList.get(64));
        ImmutableBooleanList newImmutableBooleanList1 = immutableBooleanList.newWith(true);
        Assert.assertTrue(newImmutableBooleanList1.get(64));
    }

    @Test
    public void get() {
        ImmutableBooleanList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals((i & 1) == 0, list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_greater_than_size() {
        ImmutableBooleanList list = this.classUnderTest();
        list.get(list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_negative() {
        this.classUnderTest().get(-1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Test
    public void getFirst() {
        Assert.assertTrue(this.classUnderTest().getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertEquals((this.classUnderTest().size() & 1) != 0, this.classUnderTest().getLast());
    }

    @Test
    public void indexOf() {
        ImmutableBooleanList list = this.classUnderTest();
        Assert.assertEquals(0L, list.indexOf(true));
        Assert.assertEquals(list.size() > 2 ? 1L : -1L, list.indexOf(false));
        MutableBooleanList mutableList = this.newMutableCollectionWith();
        for (int i = 0; i < list.size(); i++) {
            mutableList.add(false);
        }
        Assert.assertEquals(-1L, mutableList.toImmutable().indexOf(true));
    }

    @Test
    public void lastIndexOf() {
        ImmutableBooleanList list = this.classUnderTest();
        int size = list.size();
        Assert.assertEquals((size & 1) == 0 ? size - 2 : size - 1, list.lastIndexOf(true));
        Assert.assertEquals((size & 1) == 0 ? size - 1 : size - 2, list.lastIndexOf(false));
        MutableBooleanList mutableList = this.newMutableCollectionWith();
        for (int i = 0; i < list.size(); i++) {
            mutableList.add(false);
        }
        Assert.assertEquals(-1L, mutableList.toImmutable().lastIndexOf(true));
    }

    @Override
    @Test
    public void booleanIterator() {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Assert.assertEquals(i % 2 == 0, iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        String[] sum = new String[1];
        sum[0] = "";
        this.classUnderTest().forEach(each -> sum[0] += each);
        StringBuilder expectedString = new StringBuilder();
        for (int i = 0; i < this.classUnderTest().size(); i++) {
            expectedString.append((i & 1) == 0);
        }
        Assert.assertEquals(expectedString.toString(), sum[0]);
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

    @Test
    public void toReversed() {
        Assert.assertEquals(BooleanArrayList.newListWith(true, true, false, false), this.newWith(false, false, true, true).toReversed());
        ImmutableBooleanList originalList = this.newWith(true, true, false, false);
        Assert.assertNotSame(originalList, originalList.toReversed());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        ImmutableBooleanList list = this.classUnderTest();
        Assert.assertEquals(this.classUnderTest().size(), list.toArray().length);
        for (int i = 0; i < this.classUnderTest().size(); i++) {
            Assert.assertEquals((i & 1) == 0, list.toArray()[i]);
        }
    }

    @Test
    public void injectIntoWithIndex() {
        ImmutableBooleanList list = this.newWith(true, false, true);
        MutableInteger result = list.injectIntoWithIndex(new MutableInteger(0), (object, value, index) -> object.add((value ? 1 : 0) + index));
        Assert.assertEquals(new MutableInteger(5), result);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableBooleanList list1 = this.newWith(true, false, true, true);
        ImmutableBooleanList list2 = this.newWith(true, true, false, true);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            expectedString.append((i & 1) == 0);
            expectedString.append(i == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            boolean isEven = (i & 1) == 0;
            expectedString.append(isEven);
            expectedString1.append(isEven);
            expectedString.append(i == size - 1 ? "" : ", ");
            expectedString1.append(i == size - 1 ? "" : "/");
        }
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().makeString());
        Assert.assertEquals(expectedString1.toString(), this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedString1 = new StringBuilder();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++) {
            boolean isEven = (i & 1) == 0;
            expectedString.append(isEven);
            expectedString1.append(isEven);
            expectedString.append(i == size - 1 ? "" : ", ");
            expectedString1.append(i == size - 1 ? "" : "/");
        }
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBooleanList list = this.classUnderTest().toList();
        Verify.assertEqualsAndHashCode(this.classUnderTest(), list);
        Assert.assertNotSame(this.classUnderTest(), list);
    }

    @Override
    @Test
    public void testNewWith() {
        ImmutableBooleanCollection booleanCollection = this.classUnderTest();
        MutableBooleanList list = booleanCollection.toList();
        ImmutableBooleanCollection collection = booleanCollection.newWith(true);
        ImmutableBooleanCollection collection0 = booleanCollection.newWith(true).newWith(false);
        ImmutableBooleanCollection collection1 = booleanCollection.newWith(true).newWith(false).newWith(true);
        ImmutableBooleanCollection collection2 = booleanCollection.newWith(true).newWith(false).newWith(true).newWith(false);
        ImmutableBooleanCollection collection3 = booleanCollection.newWith(true).newWith(false).newWith(true).newWith(false).newWith(true);
        ImmutableBooleanCollection collection4 = collection3.newWith(true).newWith(false).newWith(true).newWith(false).newWith(true);
        Assert.assertEquals(list, booleanCollection);
        Assert.assertEquals(list.with(true), collection);
        Assert.assertEquals(list.with(false), collection0);
        Assert.assertEquals(list.with(true), collection1);
        Assert.assertEquals(list.with(false), collection2);
        Assert.assertEquals(list.with(true), collection3);
        list.addAll(true, false, true, false, true);
        Assert.assertEquals(list, collection4);
    }

    @Override
    @Test
    public void newWithAll() {
        ImmutableBooleanCollection booleanCollection = this.classUnderTest();
        MutableBooleanList list = booleanCollection.toList();
        ImmutableBooleanCollection collection = booleanCollection.newWithAll(this.newMutableCollectionWith(true));
        ImmutableBooleanCollection collection0 = booleanCollection.newWithAll(this.newMutableCollectionWith(true, false));
        ImmutableBooleanCollection collection1 = booleanCollection.newWithAll(this.newMutableCollectionWith(true, false, true));
        ImmutableBooleanCollection collection2 = booleanCollection.newWithAll(this.newMutableCollectionWith(true, false, true, false));
        ImmutableBooleanCollection collection3 = booleanCollection.newWithAll(this.newMutableCollectionWith(true, false, true, false, true));
        ImmutableBooleanCollection collection4 = collection3.newWithAll(this.newMutableCollectionWith(true, false, true, false, true));
        Assert.assertEquals(list, booleanCollection);
        Assert.assertEquals(list.with(true), collection);
        Assert.assertEquals(list.with(false), collection0);
        Assert.assertEquals(list.with(true), collection1);
        Assert.assertEquals(list.with(false), collection2);
        Assert.assertEquals(list.with(true), collection3);
        list.addAll(true, false, true, false, true);
        Assert.assertEquals(list, collection4);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableBooleanCollection trueCollection = this.getTrueCollection(this.classUnderTest()).toImmutable();
        Assert.assertSame(trueCollection, trueCollection.newWithout(false));
        Assert.assertNotSame(trueCollection, trueCollection.newWithout(true));
        ImmutableBooleanCollection collection = this.classUnderTest();
        MutableBooleanList list = collection.toList();
        Assert.assertEquals(list.without(true), collection.newWithout(true));
        MutableBooleanList list1 = collection.toList();
        Assert.assertEquals(list1.without(false), collection.newWithout(false));
        Assert.assertEquals(this.classUnderTest(), collection);
    }

    @Override
    @Test
    public void newWithoutAll() {
        ImmutableBooleanCollection immutableBooleanCollection = this.classUnderTest();
        MutableBooleanCollection mutableTrueCollection = this.getTrueCollection(immutableBooleanCollection);
        ImmutableBooleanCollection trueCollection = mutableTrueCollection.toImmutable();
        Assert.assertEquals(this.newMutableCollectionWith(), trueCollection.newWithoutAll(this.newMutableCollectionWith(true, false)));
        Assert.assertEquals(mutableTrueCollection, trueCollection);
        MutableBooleanList list = immutableBooleanCollection.toList();
        list.removeAll(true);
        Assert.assertEquals(list, immutableBooleanCollection.newWithoutAll(this.newMutableCollectionWith(true)));
        Assert.assertEquals(this.newMutableCollectionWith(), immutableBooleanCollection.newWithoutAll(this.newMutableCollectionWith(true, false)));
        ImmutableBooleanCollection collection = this.newWith(true, false, true, false, true);
        Assert.assertEquals(this.newMutableCollectionWith(false, false), collection.newWithoutAll(this.newMutableCollectionWith(true, true)));
        Assert.assertEquals(this.newMutableCollectionWith(), collection.newWithoutAll(this.newMutableCollectionWith(true, false)));
    }

    private MutableBooleanCollection getTrueCollection(ImmutableBooleanCollection collection) {
        MutableBooleanCollection trueCollection = this.newMutableCollectionWith();
        for (int i = 0; i < collection.size(); i++) {
            trueCollection.add(true);
        }
        return trueCollection;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableBooleanListTestCase instance;

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
        public void benchmark_newWithOn64ElementCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithOn64ElementCollection);
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
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableBooleanListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> newWithOn64ElementCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanListTestCase> newWithoutAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableBooleanListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableBooleanListTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableBooleanListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableBooleanListTestCase::notEmpty;
            this.payloads.contains = AbstractImmutableBooleanListTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableBooleanListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableBooleanListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableBooleanListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableBooleanListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableBooleanListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableBooleanListTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanListTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanListTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanListTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.size = AbstractImmutableBooleanListTestCase::size;
            this.payloads.count = AbstractImmutableBooleanListTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableBooleanListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableBooleanListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableBooleanListTestCase::noneSatisfy;
            this.payloads.select = AbstractImmutableBooleanListTestCase::select;
            this.payloads.reject = AbstractImmutableBooleanListTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableBooleanListTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableBooleanListTestCase::collect;
            this.payloads.injectInto = AbstractImmutableBooleanListTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableBooleanListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableBooleanListTestCase::reduceIfEmpty;
            this.payloads.testHashCode = AbstractImmutableBooleanListTestCase::testHashCode;
            this.payloads.toSet = AbstractImmutableBooleanListTestCase::toSet;
            this.payloads.toBag = AbstractImmutableBooleanListTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableBooleanListTestCase::asLazy;
            this.payloads.newWithOn64ElementCollection = AbstractImmutableBooleanListTestCase::newWithOn64ElementCollection;
            this.payloads.get = AbstractImmutableBooleanListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.getFirst = AbstractImmutableBooleanListTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableBooleanListTestCase::getLast;
            this.payloads.indexOf = AbstractImmutableBooleanListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractImmutableBooleanListTestCase::lastIndexOf;
            this.payloads.booleanIterator = AbstractImmutableBooleanListTestCase::booleanIterator;
            this.payloads.forEach = AbstractImmutableBooleanListTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractImmutableBooleanListTestCase::forEachWithIndex;
            this.payloads.toReversed = AbstractImmutableBooleanListTestCase::toReversed;
            this.payloads.toArray = AbstractImmutableBooleanListTestCase::toArray;
            this.payloads.injectIntoWithIndex = AbstractImmutableBooleanListTestCase::injectIntoWithIndex;
            this.payloads.testEquals = AbstractImmutableBooleanListTestCase::testEquals;
            this.payloads.testToString = AbstractImmutableBooleanListTestCase::testToString;
            this.payloads.makeString = AbstractImmutableBooleanListTestCase::makeString;
            this.payloads.appendString = AbstractImmutableBooleanListTestCase::appendString;
            this.payloads.toList = AbstractImmutableBooleanListTestCase::toList;
            this.payloads.testNewWith = AbstractImmutableBooleanListTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableBooleanListTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableBooleanListTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableBooleanListTestCase::newWithoutAll;
        }
    }
}
