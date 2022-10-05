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
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableLongCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.api.set.primitive.MutableLongSet;

/**
 * JUnit test for {@link MutableLongBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableLongBagTestCase extends AbstractMutableLongCollectionTestCase {

    @Override
    protected abstract MutableLongBag classUnderTest();

    @Override
    protected abstract MutableLongBag newWith(long... elements);

    @Override
    protected MutableLongBag newMutableCollectionWith(long... elements) {
        return LongHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Long> newObjectCollectionWith(Long... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0L, 1L, 2L).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0L, 1L, 1L, 2L, 2L, 2L).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        MutableLongBag bag = this.newWith(100L, 100L, 100L, 50L, 50L);
        MutableLongBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(LongHashBag.newBagWith(100L, 100L, 100L), filtered);
    }

    @Test
    public void selectDuplicates() {
        MutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(LongHashBag.newBagWith(2L, 2L, 3L, 3L, 3L), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        MutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L, 3L, 4L, 5L, 5L, 6L);
        MutableLongSet expected = LongSets.mutable.with(1L, 4L, 6L);
        MutableLongSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableLongBag newWithOccurrences(LongIntPair... elementsWithOccurrences) {
        MutableLongBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            LongIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences() {
        MutableLongBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1L, 1), PrimitiveTuples.pair(2L, 2), PrimitiveTuples.pair(3L, 3), PrimitiveTuples.pair(4L, 4), PrimitiveTuples.pair(5L, 5), PrimitiveTuples.pair(6L, 6), PrimitiveTuples.pair(7L, 7), PrimitiveTuples.pair(8L, 8), PrimitiveTuples.pair(9L, 9), PrimitiveTuples.pair(10L, 10));
        MutableList<LongIntPair> top5 = bag.topOccurrences(5);
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
        MutableLongBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1L, 1), PrimitiveTuples.pair(2L, 2), PrimitiveTuples.pair(3L, 3), PrimitiveTuples.pair(4L, 4), PrimitiveTuples.pair(5L, 5), PrimitiveTuples.pair(6L, 6), PrimitiveTuples.pair(7L, 7), PrimitiveTuples.pair(8L, 8), PrimitiveTuples.pair(9L, 9), PrimitiveTuples.pair(10L, 10));
        MutableList<LongIntPair> bottom5 = bag.bottomOccurrences(5);
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
    public void addOccurrences() {
        MutableLongBag bag = this.newWith();
        bag.addOccurrences(100L, 3);
        Assert.assertEquals(LongHashBag.newBagWith(100L, 100L, 100L), bag);
        bag.addOccurrences(100L, 2);
        Assert.assertEquals(LongHashBag.newBagWith(100L, 100L, 100L, 100L, 100L), bag);
        bag.addOccurrences(100L, 0);
        Assert.assertEquals(LongHashBag.newBagWith(100L, 100L, 100L, 100L, 100L), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(100L, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableLongBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences(100L, 2));
        bag.addOccurrences(100L, 5);
        Assert.assertTrue(bag.removeOccurrences(100L, 2));
        Assert.assertEquals(LongHashBag.newBagWith(100L, 100L, 100L), bag);
        Assert.assertFalse(bag.removeOccurrences(100L, 0));
        Assert.assertEquals(LongHashBag.newBagWith(100L, 100L, 100L), bag);
        Assert.assertTrue(bag.removeOccurrences(100L, 5));
        Assert.assertEquals(new LongHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences(100L, 5));
        Assert.assertEquals(new LongHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences(100L, -1);
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
    public void add() {
        super.add();
        MutableLongBag bag = this.newWith();
        Assert.assertTrue(bag.add(100L));
        Assert.assertEquals(LongHashBag.newBagWith(100L), bag);
        Assert.assertTrue(bag.add(100L));
        Assert.assertEquals(LongHashBag.newBagWith(100L, 100L), bag);
    }

    @Test
    @Override
    public void addAllIterable() {
        super.addAllIterable();
        MutableLongBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(LongArrayList.newListWith(1L, 2L, 2L, 3L, 3L, 3L)));
        Assert.assertFalse(bag.addAll(new LongArrayList()));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 2L, 3L, 3L, 3L), bag);
        Assert.assertTrue(bag.addAll(LongHashBag.newBagWith(4L, 4L, 4L, 4L)));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 2L, 3L, 3L, 3L, 4L, 4L, 4L, 4L), bag);
    }

    @Test
    @Override
    public void remove() {
        super.remove();
        MutableLongBag bag = this.newWith();
        Assert.assertFalse(bag.remove(100L));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new LongHashBag(), bag);
        Assert.assertTrue(bag.add(100L));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add(100L));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove(100L));
        Verify.assertSize(1, bag);
        Assert.assertEquals(LongHashBag.newBagWith(100L), bag);
        Assert.assertTrue(bag.remove(100L));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new LongHashBag(), bag);
    }

    @Test
    @Override
    public void longIterator() {
        MutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
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

    @Override
    @Test
    public void longIterator_with_remove() {
        super.longIterator_with_remove();
        MutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        MutableLongIterator iterator = bag.longIterator();
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
        this.newWith(1L, 2L, 2L, 3L, 3L, 3L).forEach((long each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count() {
        super.count();
        MutableLongBag bag = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
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
        MutableLongBag bag1 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        MutableLongBag bag2 = this.newWith(0L, 2L, 1L, 2L, 1L, 2L);
        MutableLongBag bag3 = this.newWith(0L, 1L, 2L, 2L, 2L);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
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
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableLongBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        MutableLongBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100L + "=3}", this.newWith(100L, 100L, 100L).toStringOfItemToCount());
        String actual = this.newWith(100L, 101L, 101L).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100L + "=1, " + 101L + "=2}").equals(actual) || ("{" + 101L + "=2, " + 100L + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongBagTestCase instance;

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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongBagTestCase> toStringOfItemToCount;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableLongBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableLongBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableLongBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongBagTestCase::notEmpty;
            this.payloads.tap = AbstractMutableLongBagTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableLongBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableLongBagTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableLongBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableLongBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableLongBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableLongBagTestCase::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = AbstractMutableLongBagTestCase::size;
            this.payloads.anySatisfy = AbstractMutableLongBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableLongBagTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableLongBagTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableLongBagTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableLongBagTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableLongBagTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableLongBagTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableLongBagTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableLongBagTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableLongBagTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableLongBagTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableLongBagTestCase::detectIfNone;
            this.payloads.max = AbstractMutableLongBagTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableLongBagTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongBagTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongBagTestCase::maxIfEmpty;
            this.payloads.summaryStatistics = AbstractMutableLongBagTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableLongBagTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableLongBagTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableLongBagTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableLongBagTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableLongBagTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableLongBagTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableLongBagTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableLongBagTestCase::testHashCode;
            this.payloads.toSortedListByComparator = AbstractMutableLongBagTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableLongBagTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableLongBagTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableLongBagTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongBagTestCase::toBag;
            this.payloads.asLazy = AbstractMutableLongBagTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableLongBagTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableLongBagTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableLongBagTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableLongBagTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableLongBagTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableLongBagTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableLongBagTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableLongBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableLongBagTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableLongBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableLongBagTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableLongBagTestCase::chunk;
            this.payloads.clear = AbstractMutableLongBagTestCase::clear;
            this.payloads.contains = AbstractMutableLongBagTestCase::contains;
            this.payloads.addAllArray = AbstractMutableLongBagTestCase::addAllArray;
            this.payloads.removeIf = AbstractMutableLongBagTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableLongBagTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableLongBagTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableLongBagTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableLongBagTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableLongBagTestCase::with;
            this.payloads.withAll = AbstractMutableLongBagTestCase::withAll;
            this.payloads.without = AbstractMutableLongBagTestCase::without;
            this.payloads.withoutAll = AbstractMutableLongBagTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableLongBagTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongBagTestCase::asUnmodifiable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_for_remove_before_next = AbstractMutableLongBagTestCase::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = AbstractMutableLongBagTestCase::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableLongBagTestCase::newEmpty;
            this.payloads.sizeDistinct = AbstractMutableLongBagTestCase::sizeDistinct;
            this.payloads.selectByOccurrences = AbstractMutableLongBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractMutableLongBagTestCase::selectDuplicates;
            this.payloads.selectUnique = AbstractMutableLongBagTestCase::selectUnique;
            this.payloads.topOccurrences = AbstractMutableLongBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractMutableLongBagTestCase::bottomOccurrences;
            this.payloads.addOccurrences = AbstractMutableLongBagTestCase::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = AbstractMutableLongBagTestCase::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = AbstractMutableLongBagTestCase::forEachWithOccurrences;
            this.payloads.add = AbstractMutableLongBagTestCase::add;
            this.payloads.addAllIterable = AbstractMutableLongBagTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableLongBagTestCase::remove;
            this.payloads.longIterator = AbstractMutableLongBagTestCase::longIterator;
            this.payloads.longIterator_with_remove = AbstractMutableLongBagTestCase::longIterator_with_remove;
            this.payloads.forEach = AbstractMutableLongBagTestCase::forEach;
            this.payloads.count = AbstractMutableLongBagTestCase::count;
            this.payloads.sum = AbstractMutableLongBagTestCase::sum;
            this.payloads.testEquals = AbstractMutableLongBagTestCase::testEquals;
            this.payloads.testToString = AbstractMutableLongBagTestCase::testToString;
            this.payloads.makeString = AbstractMutableLongBagTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongBagTestCase::appendString;
            this.payloads.toList = AbstractMutableLongBagTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongBagTestCase::toSortedList;
            this.payloads.toImmutable = AbstractMutableLongBagTestCase::toImmutable;
            this.payloads.toStringOfItemToCount = AbstractMutableLongBagTestCase::toStringOfItemToCount;
        }
    }
}
