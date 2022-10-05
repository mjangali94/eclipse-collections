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
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableIntCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntBag}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractImmutableIntBagTestCase extends AbstractImmutableIntCollectionTestCase {

    @Override
    protected abstract ImmutableIntBag classUnderTest();

    @Override
    protected ImmutableIntBag newWith(int... elements) {
        return IntBags.immutable.of(elements);
    }

    @Override
    protected MutableIntBag newMutableCollectionWith(int... elements) {
        return IntHashBag.newBagWith(elements);
    }

    @Override
    protected ImmutableBag<Integer> newObjectCollectionWith(Integer... elements) {
        return HashBag.newBagWith(elements).toImmutable();
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith(1).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0, 1, 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0, 1, 1, 2, 2, 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        ImmutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        ImmutableIntBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(IntHashBag.newBagWith(3, 3, 3), filtered);
    }

    @Test
    public void selectDuplicates() {
        ImmutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(IntHashBag.newBagWith(2, 2, 3, 3, 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        ImmutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3, 3, 4, 5, 5, 6);
        ImmutableIntSet expected = IntSets.immutable.with(1, 4, 6);
        ImmutableIntSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected ImmutableIntBag newWithOccurrences(IntIntPair... elementsWithOccurrences) {
        MutableIntBag bag = IntBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            IntIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }

    @Test
    public void topOccurrences() {
        ImmutableIntBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2), PrimitiveTuples.pair(3, 3), PrimitiveTuples.pair(4, 4), PrimitiveTuples.pair(5, 5), PrimitiveTuples.pair(6, 6), PrimitiveTuples.pair(7, 7), PrimitiveTuples.pair(8, 8), PrimitiveTuples.pair(9, 9), PrimitiveTuples.pair(10, 10));
        ImmutableList<IntIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).topOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1, 2, 3).topOccurrences(2));
        Verify.assertSize(3, this.newWith(1, 1, 2, 3).topOccurrences(2));
        Verify.assertSize(2, this.newWith(1, 1, 2, 2, 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1, 1, 2, 2, 3, 3).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        ImmutableIntBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2), PrimitiveTuples.pair(3, 3), PrimitiveTuples.pair(4, 4), PrimitiveTuples.pair(5, 5), PrimitiveTuples.pair(6, 6), PrimitiveTuples.pair(7, 7), PrimitiveTuples.pair(8, 8), PrimitiveTuples.pair(9, 9), PrimitiveTuples.pair(10, 10));
        ImmutableList<IntIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith(1, 2, 3).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith(1, 1, 2, 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1, 1, 2, 2, 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1, 1, 2, 2, 3, 3).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1, 1, 2).forEachWithOccurrences((int argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1221".equals(string) || "2112".equals(string));
    }

    @Test
    @Override
    public void intIterator() {
        ImmutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        IntArrayList list = IntArrayList.newListWith(1, 2, 2, 3, 3, 3);
        IntIterator iterator = bag.intIterator();
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
        this.newWith(1, 2, 2, 3, 3, 3).forEach((int each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count() {
        super.count();
        ImmutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(5L, bag.count(IntPredicates.greaterThan(1)));
        Assert.assertEquals(1L, bag.count(IntPredicates.lessThan(2)));
        Assert.assertEquals(0L, bag.count(IntPredicates.greaterThan(4)));
    }

    @Test
    @Override
    public void sum() {
        super.sum();
        Assert.assertEquals(14L, this.newWith(1, 2, 2, 3, 3, 3).sum());
    }

    @Test
    @Override
    public void testEquals() {
        super.testEquals();
        ImmutableIntBag bag1 = this.newWith(0, 1, 1, 2, 2, 2);
        ImmutableIntBag bag2 = this.newWith(0, 2, 1, 2, 1, 2);
        ImmutableIntBag bag3 = this.newWith(0, 1, 2, 2, 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
        Assert.assertNotEquals(this.newWith(), IntArrayList.newListWith());
        Assert.assertNotEquals(this.newWith(1), IntArrayList.newListWith(1));
    }

    @Test
    @Override
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1, 1, 1]", this.newWith(1, 1, 1).toString());
    }

    @Test
    @Override
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1, 1, 1", this.newWith(1, 1, 1).makeString());
    }

    @Test
    @Override
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1, 1, 1).appendString(appendable1);
        Assert.assertEquals("1, 1, 1", appendable1.toString());
    }

    @Test
    @Override
    public void toList() {
        super.toList();
        Assert.assertEquals(IntArrayList.newListWith(1, 1, 1), this.newWith(1, 1, 1).toList());
    }

    @Test
    @Override
    public void toSortedList() {
        super.toSortedList();
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 2, 3, 3, 3), this.newWith(1, 2, 2, 3, 3, 3).toSortedList());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        ImmutableIntBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        ImmutableIntBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100 + "=3}", this.newWith(100, 100, 100).toStringOfItemToCount());
        String actual = this.newWith(100, 101, 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100 + "=1, " + 101 + "=2}").equals(actual) || ("{" + 101 + "=2, " + 100 + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableIntCollectionTestCase._Benchmark {

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intIterator, this.description("intIterator"));
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
        public abstract AbstractImmutableIntBagTestCase implementation();
    }
}
