/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableLongCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongBag}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractImmutableLongBagTestCase extends AbstractImmutableLongCollectionTestCase {

    @Override
    protected abstract ImmutableLongBag classUnderTest();

    @Override
    protected ImmutableLongBag newWith(long... elements) {
        return LongBags.immutable.of(elements);
    }

    @Override
    protected MutableLongBag newMutableCollectionWith(long... elements) {
        return LongHashBag.newBagWith(elements);
    }

    @Override
    protected ImmutableBag<Long> newObjectCollectionWith(Long... elements) {
        return HashBag.newBagWith(elements).toImmutable();
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith(1L).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0L, 1L, 2L).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0L, 1L, 1L, 2L, 2L, 2L).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        ImmutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        ImmutableLongBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(LongHashBag.newBagWith(3L, 3L, 3L), filtered);
    }

    @Test
    public void selectDuplicates() {
        ImmutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(LongHashBag.newBagWith(2L, 2L, 3L, 3L, 3L), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        ImmutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L, 3L, 4L, 5L, 5L, 6L);
        ImmutableLongSet expected = LongSets.immutable.with(1L, 4L, 6L);
        ImmutableLongSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected ImmutableLongBag newWithOccurrences(LongIntPair... elementsWithOccurrences) {
        MutableLongBag bag = LongBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            LongIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }

    @Test
    public void topOccurrences() {
        ImmutableLongBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1L, 1), PrimitiveTuples.pair(2L, 2), PrimitiveTuples.pair(3L, 3), PrimitiveTuples.pair(4L, 4), PrimitiveTuples.pair(5L, 5), PrimitiveTuples.pair(6L, 6), PrimitiveTuples.pair(7L, 7), PrimitiveTuples.pair(8L, 8), PrimitiveTuples.pair(9L, 9), PrimitiveTuples.pair(10L, 10));
        ImmutableList<LongIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1L).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith(1L, 2L, 3L).topOccurrences(5));
        Verify.assertSize(3, this.newWith(1L, 2L, 3L).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1L, 2L, 3L).topOccurrences(2));
        Verify.assertSize(3, this.newWith(1L, 1L, 2L, 3L).topOccurrences(2));
        Verify.assertSize(2, this.newWith(1L, 1L, 2L, 2L, 3L).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1L, 1L, 2L, 2L, 3L, 3L).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        ImmutableLongBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1L, 1), PrimitiveTuples.pair(2L, 2), PrimitiveTuples.pair(3L, 3), PrimitiveTuples.pair(4L, 4), PrimitiveTuples.pair(5L, 5), PrimitiveTuples.pair(6L, 6), PrimitiveTuples.pair(7L, 7), PrimitiveTuples.pair(8L, 8), PrimitiveTuples.pair(9L, 9), PrimitiveTuples.pair(10L, 10));
        ImmutableList<LongIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1L).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1L, 2L, 3L).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1L, 2L, 3L).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith(1L, 2L, 3L).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith(1L, 1L, 2L, 3L).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1L, 1L, 2L, 2L, 3L).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1L, 1L, 2L, 2L, 3L, 3L).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1L, 1L, 2L).forEachWithOccurrences((long argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1221".equals(string) || "2112".equals(string));
    }

    @Test
    @Override
    public void longIterator() {
        ImmutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        LongArrayList list = LongArrayList.newListWith(1L, 2L, 2L, 3L, 3L, 3L);
        LongIterator iterator = bag.longIterator();
        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @Override
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        this.newWith(1L, 2L, 2L, 3L, 3L, 3L).forEach((long each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count() {
        super.count();
        ImmutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(5L, bag.count(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(1L, bag.count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(0L, bag.count(LongPredicates.greaterThan(4L)));
    }

    @Test
    @Override
    public void sum() {
        super.sum();
        Assert.assertEquals(14L, this.newWith(1L, 2L, 2L, 3L, 3L, 3L).sum());
    }

    @Test
    @Override
    public void testEquals() {
        super.testEquals();
        ImmutableLongBag bag1 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        ImmutableLongBag bag2 = this.newWith(0L, 2L, 1L, 2L, 1L, 2L);
        ImmutableLongBag bag3 = this.newWith(0L, 1L, 2L, 2L, 2L);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
        Assert.assertNotEquals(this.newWith(), LongArrayList.newListWith());
        Assert.assertNotEquals(this.newWith(1L), LongArrayList.newListWith(1L));
    }

    @Test
    @Override
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1, 1, 1]", this.newWith(1L, 1L, 1L).toString());
    }

    @Test
    @Override
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1, 1, 1", this.newWith(1L, 1L, 1L).makeString());
    }

    @Test
    @Override
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1L, 1L, 1L).appendString(appendable1);
        Assert.assertEquals("1, 1, 1", appendable1.toString());
    }

    @Test
    @Override
    public void toList() {
        super.toList();
        Assert.assertEquals(LongArrayList.newListWith(1L, 1L, 1L), this.newWith(1L, 1L, 1L).toList());
    }

    @Test
    @Override
    public void toSortedList() {
        super.toSortedList();
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 2L, 3L, 3L, 3L), this.newWith(1L, 2L, 2L, 3L, 3L, 3L).toSortedList());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        ImmutableLongBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        ImmutableLongBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100L + "=3}", this.newWith(100L, 100L, 100L).toStringOfItemToCount());
        String actual = this.newWith(100L, 101L, 101L).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100L + "=1, " + 101L + "=2}").equals(actual) || ("{" + 101L + "=2, " + 100L + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableLongCollectionTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sizeDistinct, this.description("sizeDistinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectByOccurrences, this.description("selectByOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectDuplicates, this.description("selectDuplicates"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::topOccurrences, this.description("topOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::bottomOccurrences, this.description("bottomOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithOccurrences, this.description("forEachWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator, this.description("longIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toStringOfItemToCount, this.description("toStringOfItemToCount"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableLongBagTestCase implementation();
    }
}
