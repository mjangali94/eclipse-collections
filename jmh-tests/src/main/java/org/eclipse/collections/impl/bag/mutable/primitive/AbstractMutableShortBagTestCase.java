/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.api.set.primitive.MutableShortSet;

/**
 * JUnit test for {@link MutableShortBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableShortBagTestCase extends AbstractMutableShortCollectionTestCase {

    @Override
    protected abstract MutableShortBag classUnderTest();

    @Override
    protected abstract MutableShortBag newWith(short... elements);

    @Override
    protected MutableShortBag newMutableCollectionWith(short... elements) {
        return ShortHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Short> newObjectCollectionWith(Short... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith((short) 0, (short) 1, (short) 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        MutableShortBag bag = this.newWith((short) 100, (short) 100, (short) 100, (short) 50, (short) 50);
        MutableShortBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100, (short) 100, (short) 100), filtered);
    }

    @Test
    public void selectDuplicates() {
        MutableShortBag bag = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 2, (short) 2, (short) 3, (short) 3, (short) 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        MutableShortBag bag = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3, (short) 3, (short) 4, (short) 5, (short) 5, (short) 6);
        MutableShortSet expected = ShortSets.mutable.with((short) 1, (short) 4, (short) 6);
        MutableShortSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableShortBag newWithOccurrences(ShortIntPair... elementsWithOccurrences) {
        MutableShortBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            ShortIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences() {
        MutableShortBag bag = this.newWithOccurrences(PrimitiveTuples.pair((short) 1, 1), PrimitiveTuples.pair((short) 2, 2), PrimitiveTuples.pair((short) 3, 3), PrimitiveTuples.pair((short) 4, 4), PrimitiveTuples.pair((short) 5, 5), PrimitiveTuples.pair((short) 6, 6), PrimitiveTuples.pair((short) 7, 7), PrimitiveTuples.pair((short) 8, 8), PrimitiveTuples.pair((short) 9, 9), PrimitiveTuples.pair((short) 10, 10));
        MutableList<ShortIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((short) 1).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith((short) 1, (short) 2, (short) 3).topOccurrences(5));
        Verify.assertSize(3, this.newWith((short) 1, (short) 2, (short) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((short) 1, (short) 2, (short) 3).topOccurrences(2));
        Verify.assertSize(3, this.newWith((short) 1, (short) 1, (short) 2, (short) 3).topOccurrences(2));
        Verify.assertSize(2, this.newWith((short) 1, (short) 1, (short) 2, (short) 2, (short) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        MutableShortBag bag = this.newWithOccurrences(PrimitiveTuples.pair((short) 1, 1), PrimitiveTuples.pair((short) 2, 2), PrimitiveTuples.pair((short) 3, 3), PrimitiveTuples.pair((short) 4, 4), PrimitiveTuples.pair((short) 5, 5), PrimitiveTuples.pair((short) 6, 6), PrimitiveTuples.pair((short) 7, 7), PrimitiveTuples.pair((short) 8, 8), PrimitiveTuples.pair((short) 9, 9), PrimitiveTuples.pair((short) 10, 10));
        MutableList<ShortIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((short) 1).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((short) 1, (short) 2, (short) 3).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((short) 1, (short) 2, (short) 3).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith((short) 1, (short) 2, (short) 3).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith((short) 1, (short) 1, (short) 2, (short) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((short) 1, (short) 1, (short) 2, (short) 2, (short) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void addOccurrences() {
        MutableShortBag bag = this.newWith();
        bag.addOccurrences((short) 100, 3);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100, (short) 100, (short) 100), bag);
        bag.addOccurrences((short) 100, 2);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100, (short) 100, (short) 100, (short) 100, (short) 100), bag);
        bag.addOccurrences((short) 100, 0);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100, (short) 100, (short) 100, (short) 100, (short) 100), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences((short) 100, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableShortBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences((short) 100, 2));
        bag.addOccurrences((short) 100, 5);
        Assert.assertTrue(bag.removeOccurrences((short) 100, 2));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100, (short) 100, (short) 100), bag);
        Assert.assertFalse(bag.removeOccurrences((short) 100, 0));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100, (short) 100, (short) 100), bag);
        Assert.assertTrue(bag.removeOccurrences((short) 100, 5));
        Assert.assertEquals(new ShortHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences((short) 100, 5));
        Assert.assertEquals(new ShortHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences((short) 100, -1);
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith((short) 1, (short) 1, (short) 2).forEachWithOccurrences((short argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1221".equals(string) || "2112".equals(string));
    }

    @Test
    @Override
    public void add() {
        super.add();
        MutableShortBag bag = this.newWith();
        Assert.assertTrue(bag.add((short) 100));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100), bag);
        Assert.assertTrue(bag.add((short) 100));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100, (short) 100), bag);
    }

    @Test
    @Override
    public void addAllIterable() {
        super.addAllIterable();
        MutableShortBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3)));
        Assert.assertFalse(bag.addAll(new ShortArrayList()));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3), bag);
        Assert.assertTrue(bag.addAll(ShortHashBag.newBagWith((short) 4, (short) 4, (short) 4, (short) 4)));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3, (short) 4, (short) 4, (short) 4, (short) 4), bag);
    }

    @Test
    @Override
    public void remove() {
        super.remove();
        MutableShortBag bag = this.newWith();
        Assert.assertFalse(bag.remove((short) 100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new ShortHashBag(), bag);
        Assert.assertTrue(bag.add((short) 100));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add((short) 100));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove((short) 100));
        Verify.assertSize(1, bag);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 100), bag);
        Assert.assertTrue(bag.remove((short) 100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new ShortHashBag(), bag);
    }

    @Test
    @Override
    public void shortIterator() {
        MutableShortBag bag = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        ShortArrayList list = ShortArrayList.newListWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        ShortIterator iterator = bag.shortIterator();
        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void shortIterator_with_remove() {
        super.shortIterator_with_remove();
        MutableShortBag bag = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        MutableShortIterator iterator = bag.shortIterator();
        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
            iterator.remove();
        }
        Verify.assertEmpty(bag);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @Override
    public void forEach() {
        super.forEach();
        long[] sum = new long[1];
        this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3).forEach((short each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count() {
        super.count();
        MutableShortBag bag = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(5L, bag.count(ShortPredicates.greaterThan((short) 1)));
        Assert.assertEquals(1L, bag.count(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(0L, bag.count(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    @Override
    public void sum() {
        super.sum();
        Assert.assertEquals(14L, this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3).sum());
    }

    @Test
    @Override
    public void testEquals() {
        super.testEquals();
        MutableShortBag bag1 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        MutableShortBag bag2 = this.newWith((short) 0, (short) 2, (short) 1, (short) 2, (short) 1, (short) 2);
        MutableShortBag bag3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
    }

    @Test
    @Override
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1, 1, 1]", this.newWith((short) 1, (short) 1, (short) 1).toString());
    }

    @Test
    @Override
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1, 1, 1", this.newWith((short) 1, (short) 1, (short) 1).makeString());
    }

    @Test
    @Override
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith((short) 1, (short) 1, (short) 1).appendString(appendable1);
        Assert.assertEquals("1, 1, 1", appendable1.toString());
    }

    @Test
    @Override
    public void toList() {
        super.toList();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 1, (short) 1), this.newWith((short) 1, (short) 1, (short) 1).toList());
    }

    @Test
    @Override
    public void toSortedList() {
        super.toSortedList();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3), this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3).toSortedList());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableShortBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        MutableShortBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + (short) 100 + "=3}", this.newWith((short) 100, (short) 100, (short) 100).toStringOfItemToCount());
        String actual = this.newWith((short) 100, (short) 101, (short) 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + (short) 100 + "=1, " + (short) 101 + "=2}").equals(actual) || ("{" + (short) 101 + "=2, " + (short) 100 + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortBagTestCase instance;

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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortBagTestCase> toStringOfItemToCount;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableShortBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableShortBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableShortBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortBagTestCase::notEmpty;
            this.payloads.tap = AbstractMutableShortBagTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableShortBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableShortBagTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableShortBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableShortBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableShortBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableShortBagTestCase::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = AbstractMutableShortBagTestCase::size;
            this.payloads.anySatisfy = AbstractMutableShortBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableShortBagTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableShortBagTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableShortBagTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableShortBagTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableShortBagTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableShortBagTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableShortBagTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableShortBagTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableShortBagTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableShortBagTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableShortBagTestCase::detectIfNone;
            this.payloads.max = AbstractMutableShortBagTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableShortBagTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortBagTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortBagTestCase::maxIfEmpty;
            this.payloads.summaryStatistics = AbstractMutableShortBagTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableShortBagTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableShortBagTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableShortBagTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableShortBagTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableShortBagTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableShortBagTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableShortBagTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableShortBagTestCase::testHashCode;
            this.payloads.toSortedListByComparator = AbstractMutableShortBagTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableShortBagTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableShortBagTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableShortBagTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortBagTestCase::toBag;
            this.payloads.asLazy = AbstractMutableShortBagTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableShortBagTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableShortBagTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableShortBagTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableShortBagTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableShortBagTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableShortBagTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableShortBagTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableShortBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableShortBagTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableShortBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableShortBagTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableShortBagTestCase::chunk;
            this.payloads.clear = AbstractMutableShortBagTestCase::clear;
            this.payloads.contains = AbstractMutableShortBagTestCase::contains;
            this.payloads.addAllArray = AbstractMutableShortBagTestCase::addAllArray;
            this.payloads.removeIf = AbstractMutableShortBagTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableShortBagTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableShortBagTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableShortBagTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableShortBagTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableShortBagTestCase::with;
            this.payloads.withAll = AbstractMutableShortBagTestCase::withAll;
            this.payloads.without = AbstractMutableShortBagTestCase::without;
            this.payloads.withoutAll = AbstractMutableShortBagTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableShortBagTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortBagTestCase::asUnmodifiable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_for_remove_before_next = AbstractMutableShortBagTestCase::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = AbstractMutableShortBagTestCase::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableShortBagTestCase::newEmpty;
            this.payloads.sizeDistinct = AbstractMutableShortBagTestCase::sizeDistinct;
            this.payloads.selectByOccurrences = AbstractMutableShortBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractMutableShortBagTestCase::selectDuplicates;
            this.payloads.selectUnique = AbstractMutableShortBagTestCase::selectUnique;
            this.payloads.topOccurrences = AbstractMutableShortBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractMutableShortBagTestCase::bottomOccurrences;
            this.payloads.addOccurrences = AbstractMutableShortBagTestCase::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = AbstractMutableShortBagTestCase::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = AbstractMutableShortBagTestCase::forEachWithOccurrences;
            this.payloads.add = AbstractMutableShortBagTestCase::add;
            this.payloads.addAllIterable = AbstractMutableShortBagTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableShortBagTestCase::remove;
            this.payloads.shortIterator = AbstractMutableShortBagTestCase::shortIterator;
            this.payloads.shortIterator_with_remove = AbstractMutableShortBagTestCase::shortIterator_with_remove;
            this.payloads.forEach = AbstractMutableShortBagTestCase::forEach;
            this.payloads.count = AbstractMutableShortBagTestCase::count;
            this.payloads.sum = AbstractMutableShortBagTestCase::sum;
            this.payloads.testEquals = AbstractMutableShortBagTestCase::testEquals;
            this.payloads.testToString = AbstractMutableShortBagTestCase::testToString;
            this.payloads.makeString = AbstractMutableShortBagTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortBagTestCase::appendString;
            this.payloads.toList = AbstractMutableShortBagTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortBagTestCase::toSortedList;
            this.payloads.toImmutable = AbstractMutableShortBagTestCase::toImmutable;
            this.payloads.toStringOfItemToCount = AbstractMutableShortBagTestCase::toStringOfItemToCount;
        }
    }
}
