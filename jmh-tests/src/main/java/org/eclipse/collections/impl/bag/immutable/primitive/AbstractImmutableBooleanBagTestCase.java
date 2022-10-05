/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableBooleanBag}.
 */
public abstract class AbstractImmutableBooleanBagTestCase extends AbstractImmutableBooleanCollectionTestCase {

    @Override
    protected abstract ImmutableBooleanBag classUnderTest();

    @Override
    protected ImmutableBooleanBag newWith(boolean... elements) {
        return BooleanBags.immutable.with(elements);
    }

    @Override
    protected MutableBooleanBag newMutableCollectionWith(boolean... elements) {
        return BooleanHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Object> newObjectCollectionWith(Object... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith(true).sizeDistinct());
        Assert.assertEquals(1L, this.newWith(true, true, true).sizeDistinct());
        Assert.assertEquals(2L, this.newWith(true, false, true, false, true).sizeDistinct());
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((argument1, argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("true2false1".equals(string) || "false1true2".equals(string));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, this.classUnderTest());
    }

    @Override
    @Test
    public void booleanIterator() {
        BooleanHashBag bag = BooleanHashBag.newBagWith();
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        for (int i = 0; i < this.classUnderTest().size(); i++) {
            Assert.assertTrue(iterator.hasNext());
            bag.add(iterator.next());
        }
        Assert.assertEquals(bag, this.classUnderTest());
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        long[] count = { 0 };
        ImmutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertTrue(bag.anySatisfy(value -> {
            count[0]++;
            return value;
        }));
        Assert.assertEquals(2L, count[0]);
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        int[] count = { 0 };
        ImmutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertFalse(bag.allSatisfy(value -> {
            count[0]++;
            return !value;
        }));
        Assert.assertEquals(2L, count[0]);
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        ImmutableBooleanBag bag = this.newWith(false, true, false);
        Assert.assertFalse(bag.noneSatisfy(value -> value));
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        ImmutableBooleanBag bag = this.newWith(true, false, false, true, true, true);
        BooleanToObjectFunction<String> stringValueOf = parameter -> parameter ? "true" : "false";
        Assert.assertEquals(HashBag.newBagWith("true", "false", "false", "true", "true", "true"), bag.collect(stringValueOf));
        ImmutableBooleanBag bag1 = this.newWith(false, false);
        Assert.assertEquals(HashBag.newBagWith("false", "false"), bag1.collect(stringValueOf));
        ImmutableBooleanBag bag2 = this.newWith(true, true);
        Assert.assertEquals(HashBag.newBagWith("true", "true"), bag2.collect(stringValueOf));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        ImmutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        ImmutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        ImmutableBooleanCollection collection3 = this.newWith(true, false);
        ImmutableBooleanCollection collection4 = this.newWith(true, true, false);
        Assert.assertEquals(collection1, collection2);
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(collection3, collection4);
        Assert.assertNotEquals(collection3, BooleanArrayList.newListWith(true, false));
        Assert.assertNotEquals(this.newWith(true), BooleanArrayList.newListWith(true));
        Assert.assertNotEquals(this.newWith(), BooleanArrayList.newListWith());
    }

    @Override
    @Test
    public void testHashCode() {
        super.testHashCode();
        ImmutableBooleanCollection collection1 = this.newWith(true, false, true, false);
        ImmutableBooleanCollection collection2 = this.newWith(true, false, false, true);
        ImmutableBooleanCollection collection3 = this.newWith(true, false);
        ImmutableBooleanCollection collection4 = this.newWith(true, true, false);
        Verify.assertEqualsAndHashCode(collection1, collection2);
        Assert.assertNotEquals(collection3.hashCode(), collection4.hashCode());
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[true, true, true]", BooleanHashBag.newBagWith(true, true, true).toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("true, true, true", BooleanHashBag.newBagWith(true, true, true).makeString());
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(true, true, true).appendString(appendable1);
        Assert.assertEquals("true, true, true", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        ImmutableBooleanBag bag1 = this.newWith(false, false, true);
        bag1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "false, false, true".equals(appendable2.toString()) || "true, false, false".equals(appendable2.toString()) || "false, true, false".equals(appendable2.toString()));
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBooleanList list = this.newWith(false, false, true).toList();
        Assert.assertTrue(list.equals(BooleanArrayList.newListWith(false, false, true)) || list.equals(BooleanArrayList.newListWith(true, false, false)) || list.equals(BooleanArrayList.newListWith(false, true, false)));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        ImmutableBooleanBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void selectUnique() {
        ImmutableBooleanBag bag = BooleanBags.immutable.with(false, false, true);
        ImmutableBooleanSet expected = BooleanSets.immutable.with(true);
        ImmutableBooleanSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        ImmutableBooleanBag bag2 = BooleanBags.immutable.with(false, false, true, true);
        ImmutableBooleanSet expected2 = BooleanSets.immutable.empty();
        ImmutableBooleanSet actual2 = bag2.selectUnique();
        Assert.assertEquals(expected2, actual2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableBooleanBagTestCase instance;

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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableBooleanBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBooleanBagTestCase> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableBooleanBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableBooleanBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableBooleanBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableBooleanBagTestCase::notEmpty;
            this.payloads.contains = AbstractImmutableBooleanBagTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableBooleanBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableBooleanBagTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableBooleanBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableBooleanBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableBooleanBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableBooleanBagTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanBagTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanBagTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanBagTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractImmutableBooleanBagTestCase::forEach;
            this.payloads.count = AbstractImmutableBooleanBagTestCase::count;
            this.payloads.select = AbstractImmutableBooleanBagTestCase::select;
            this.payloads.reject = AbstractImmutableBooleanBagTestCase::reject;
            this.payloads.detectIfNone = AbstractImmutableBooleanBagTestCase::detectIfNone;
            this.payloads.injectInto = AbstractImmutableBooleanBagTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableBooleanBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableBooleanBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableBooleanBagTestCase::reduceIfEmpty;
            this.payloads.toArray = AbstractImmutableBooleanBagTestCase::toArray;
            this.payloads.toSet = AbstractImmutableBooleanBagTestCase::toSet;
            this.payloads.toBag = AbstractImmutableBooleanBagTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableBooleanBagTestCase::asLazy;
            this.payloads.testNewWith = AbstractImmutableBooleanBagTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableBooleanBagTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableBooleanBagTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableBooleanBagTestCase::newWithoutAll;
            this.payloads.sizeDistinct = AbstractImmutableBooleanBagTestCase::sizeDistinct;
            this.payloads.forEachWithOccurrences = AbstractImmutableBooleanBagTestCase::forEachWithOccurrences;
            this.payloads.size = AbstractImmutableBooleanBagTestCase::size;
            this.payloads.booleanIterator = AbstractImmutableBooleanBagTestCase::booleanIterator;
            this.payloads.anySatisfy = AbstractImmutableBooleanBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableBooleanBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableBooleanBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableBooleanBagTestCase::collect;
            this.payloads.testEquals = AbstractImmutableBooleanBagTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableBooleanBagTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableBooleanBagTestCase::testToString;
            this.payloads.makeString = AbstractImmutableBooleanBagTestCase::makeString;
            this.payloads.appendString = AbstractImmutableBooleanBagTestCase::appendString;
            this.payloads.toList = AbstractImmutableBooleanBagTestCase::toList;
            this.payloads.toImmutable = AbstractImmutableBooleanBagTestCase::toImmutable;
            this.payloads.selectUnique = AbstractImmutableBooleanBagTestCase::selectUnique;
        }
    }
}
