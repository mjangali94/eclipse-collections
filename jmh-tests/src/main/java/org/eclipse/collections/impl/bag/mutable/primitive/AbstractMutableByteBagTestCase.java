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
import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableByteCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.api.set.primitive.MutableByteSet;

/**
 * JUnit test for {@link MutableByteBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableByteBagTestCase extends AbstractMutableByteCollectionTestCase {

    @Override
    protected abstract MutableByteBag classUnderTest();

    @Override
    protected abstract MutableByteBag newWith(byte... elements);

    @Override
    protected MutableByteBag newMutableCollectionWith(byte... elements) {
        return ByteHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Byte> newObjectCollectionWith(Byte... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith((byte) 0, (byte) 1, (byte) 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        MutableByteBag bag = this.newWith((byte) 100, (byte) 100, (byte) 100, (byte) 50, (byte) 50);
        MutableByteBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100, (byte) 100, (byte) 100), filtered);
    }

    @Test
    public void selectDuplicates() {
        MutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        MutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 4, (byte) 5, (byte) 5, (byte) 6);
        MutableByteSet expected = ByteSets.mutable.with((byte) 1, (byte) 4, (byte) 6);
        MutableByteSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableByteBag newWithOccurrences(ByteIntPair... elementsWithOccurrences) {
        MutableByteBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            ByteIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences() {
        MutableByteBag bag = this.newWithOccurrences(PrimitiveTuples.pair((byte) 1, 1), PrimitiveTuples.pair((byte) 2, 2), PrimitiveTuples.pair((byte) 3, 3), PrimitiveTuples.pair((byte) 4, 4), PrimitiveTuples.pair((byte) 5, 5), PrimitiveTuples.pair((byte) 6, 6), PrimitiveTuples.pair((byte) 7, 7), PrimitiveTuples.pair((byte) 8, 8), PrimitiveTuples.pair((byte) 9, 9), PrimitiveTuples.pair((byte) 10, 10));
        MutableList<ByteIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((byte) 1).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).topOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).topOccurrences(2));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 3).topOccurrences(2));
        Verify.assertSize(2, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        MutableByteBag bag = this.newWithOccurrences(PrimitiveTuples.pair((byte) 1, 1), PrimitiveTuples.pair((byte) 2, 2), PrimitiveTuples.pair((byte) 3, 3), PrimitiveTuples.pair((byte) 4, 4), PrimitiveTuples.pair((byte) 5, 5), PrimitiveTuples.pair((byte) 6, 6), PrimitiveTuples.pair((byte) 7, 7), PrimitiveTuples.pair((byte) 8, 8), PrimitiveTuples.pair((byte) 9, 9), PrimitiveTuples.pair((byte) 10, 10));
        MutableList<ByteIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((byte) 1).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void addOccurrences() {
        MutableByteBag bag = this.newWith();
        bag.addOccurrences((byte) 100, 3);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100, (byte) 100, (byte) 100), bag);
        bag.addOccurrences((byte) 100, 2);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100, (byte) 100, (byte) 100, (byte) 100, (byte) 100), bag);
        bag.addOccurrences((byte) 100, 0);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100, (byte) 100, (byte) 100, (byte) 100, (byte) 100), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences((byte) 100, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableByteBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences((byte) 100, 2));
        bag.addOccurrences((byte) 100, 5);
        Assert.assertTrue(bag.removeOccurrences((byte) 100, 2));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100, (byte) 100, (byte) 100), bag);
        Assert.assertFalse(bag.removeOccurrences((byte) 100, 0));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100, (byte) 100, (byte) 100), bag);
        Assert.assertTrue(bag.removeOccurrences((byte) 100, 5));
        Assert.assertEquals(new ByteHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences((byte) 100, 5));
        Assert.assertEquals(new ByteHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences((byte) 100, -1);
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith((byte) 1, (byte) 1, (byte) 2).forEachWithOccurrences((byte argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1221".equals(string) || "2112".equals(string));
    }

    @Test
    @Override
    public void add() {
        super.add();
        MutableByteBag bag = this.newWith();
        Assert.assertTrue(bag.add((byte) 100));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100), bag);
        Assert.assertTrue(bag.add((byte) 100));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100, (byte) 100), bag);
    }

    @Test
    @Override
    public void addAllIterable() {
        super.addAllIterable();
        MutableByteBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3)));
        Assert.assertFalse(bag.addAll(new ByteArrayList()));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), bag);
        Assert.assertTrue(bag.addAll(ByteHashBag.newBagWith((byte) 4, (byte) 4, (byte) 4, (byte) 4)));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 4, (byte) 4), bag);
    }

    @Test
    @Override
    public void remove() {
        super.remove();
        MutableByteBag bag = this.newWith();
        Assert.assertFalse(bag.remove((byte) 100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new ByteHashBag(), bag);
        Assert.assertTrue(bag.add((byte) 100));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add((byte) 100));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove((byte) 100));
        Verify.assertSize(1, bag);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 100), bag);
        Assert.assertTrue(bag.remove((byte) 100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new ByteHashBag(), bag);
    }

    @Test
    @Override
    public void byteIterator() {
        MutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        ByteArrayList list = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        ByteIterator iterator = bag.byteIterator();
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
    public void byteIterator_with_remove() {
        super.byteIterator_with_remove();
        MutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        MutableByteIterator iterator = bag.byteIterator();
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
        this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).forEach((byte each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count() {
        super.count();
        MutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(5L, bag.count(BytePredicates.greaterThan((byte) 1)));
        Assert.assertEquals(1L, bag.count(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(0L, bag.count(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    @Override
    public void sum() {
        super.sum();
        Assert.assertEquals(14L, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).sum());
    }

    @Test
    @Override
    public void testEquals() {
        super.testEquals();
        MutableByteBag bag1 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        MutableByteBag bag2 = this.newWith((byte) 0, (byte) 2, (byte) 1, (byte) 2, (byte) 1, (byte) 2);
        MutableByteBag bag3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
    }

    @Test
    @Override
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1, 1, 1]", this.newWith((byte) 1, (byte) 1, (byte) 1).toString());
    }

    @Test
    @Override
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1, 1, 1", this.newWith((byte) 1, (byte) 1, (byte) 1).makeString());
    }

    @Test
    @Override
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith((byte) 1, (byte) 1, (byte) 1).appendString(appendable1);
        Assert.assertEquals("1, 1, 1", appendable1.toString());
    }

    @Test
    @Override
    public void toList() {
        super.toList();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 1, (byte) 1), this.newWith((byte) 1, (byte) 1, (byte) 1).toList());
    }

    @Test
    @Override
    public void toSortedList() {
        super.toSortedList();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).toSortedList());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableByteBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        MutableByteBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + (byte) 100 + "=3}", this.newWith((byte) 100, (byte) 100, (byte) 100).toStringOfItemToCount());
        String actual = this.newWith((byte) 100, (byte) 101, (byte) 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + (byte) 100 + "=1, " + (byte) 101 + "=2}").equals(actual) || ("{" + (byte) 101 + "=2, " + (byte) 100 + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteBagTestCase instance;

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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteBagTestCase> toStringOfItemToCount;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableByteBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableByteBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableByteBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteBagTestCase::notEmpty;
            this.payloads.tap = AbstractMutableByteBagTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableByteBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableByteBagTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableByteBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableByteBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableByteBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableByteBagTestCase::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = AbstractMutableByteBagTestCase::size;
            this.payloads.anySatisfy = AbstractMutableByteBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableByteBagTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableByteBagTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableByteBagTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableByteBagTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableByteBagTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableByteBagTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableByteBagTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableByteBagTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableByteBagTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableByteBagTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableByteBagTestCase::detectIfNone;
            this.payloads.max = AbstractMutableByteBagTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableByteBagTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteBagTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteBagTestCase::maxIfEmpty;
            this.payloads.summaryStatistics = AbstractMutableByteBagTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableByteBagTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableByteBagTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableByteBagTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableByteBagTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableByteBagTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableByteBagTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableByteBagTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableByteBagTestCase::testHashCode;
            this.payloads.toSortedListByComparator = AbstractMutableByteBagTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableByteBagTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableByteBagTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableByteBagTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteBagTestCase::toBag;
            this.payloads.asLazy = AbstractMutableByteBagTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableByteBagTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableByteBagTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableByteBagTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableByteBagTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableByteBagTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableByteBagTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableByteBagTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableByteBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableByteBagTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableByteBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableByteBagTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableByteBagTestCase::chunk;
            this.payloads.clear = AbstractMutableByteBagTestCase::clear;
            this.payloads.contains = AbstractMutableByteBagTestCase::contains;
            this.payloads.addAllArray = AbstractMutableByteBagTestCase::addAllArray;
            this.payloads.removeIf = AbstractMutableByteBagTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableByteBagTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableByteBagTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableByteBagTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableByteBagTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableByteBagTestCase::with;
            this.payloads.withAll = AbstractMutableByteBagTestCase::withAll;
            this.payloads.without = AbstractMutableByteBagTestCase::without;
            this.payloads.withoutAll = AbstractMutableByteBagTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableByteBagTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteBagTestCase::asUnmodifiable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_for_remove_before_next = AbstractMutableByteBagTestCase::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = AbstractMutableByteBagTestCase::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableByteBagTestCase::newEmpty;
            this.payloads.sizeDistinct = AbstractMutableByteBagTestCase::sizeDistinct;
            this.payloads.selectByOccurrences = AbstractMutableByteBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractMutableByteBagTestCase::selectDuplicates;
            this.payloads.selectUnique = AbstractMutableByteBagTestCase::selectUnique;
            this.payloads.topOccurrences = AbstractMutableByteBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractMutableByteBagTestCase::bottomOccurrences;
            this.payloads.addOccurrences = AbstractMutableByteBagTestCase::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = AbstractMutableByteBagTestCase::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = AbstractMutableByteBagTestCase::forEachWithOccurrences;
            this.payloads.add = AbstractMutableByteBagTestCase::add;
            this.payloads.addAllIterable = AbstractMutableByteBagTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableByteBagTestCase::remove;
            this.payloads.byteIterator = AbstractMutableByteBagTestCase::byteIterator;
            this.payloads.byteIterator_with_remove = AbstractMutableByteBagTestCase::byteIterator_with_remove;
            this.payloads.forEach = AbstractMutableByteBagTestCase::forEach;
            this.payloads.count = AbstractMutableByteBagTestCase::count;
            this.payloads.sum = AbstractMutableByteBagTestCase::sum;
            this.payloads.testEquals = AbstractMutableByteBagTestCase::testEquals;
            this.payloads.testToString = AbstractMutableByteBagTestCase::testToString;
            this.payloads.makeString = AbstractMutableByteBagTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteBagTestCase::appendString;
            this.payloads.toList = AbstractMutableByteBagTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteBagTestCase::toSortedList;
            this.payloads.toImmutable = AbstractMutableByteBagTestCase::toImmutable;
            this.payloads.toStringOfItemToCount = AbstractMutableByteBagTestCase::toStringOfItemToCount;
        }
    }
}
