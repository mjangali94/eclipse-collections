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
import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableCharCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.api.set.primitive.MutableCharSet;

/**
 * JUnit test for {@link MutableCharBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableCharBagTestCase extends AbstractMutableCharCollectionTestCase {

    @Override
    protected abstract MutableCharBag classUnderTest();

    @Override
    protected abstract MutableCharBag newWith(char... elements);

    @Override
    protected MutableCharBag newMutableCollectionWith(char... elements) {
        return CharHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Character> newObjectCollectionWith(Character... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith((char) 0, (char) 1, (char) 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        MutableCharBag bag = this.newWith((char) 100, (char) 100, (char) 100, (char) 50, (char) 50);
        MutableCharBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(CharHashBag.newBagWith((char) 100, (char) 100, (char) 100), filtered);
    }

    @Test
    public void selectDuplicates() {
        MutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(CharHashBag.newBagWith((char) 2, (char) 2, (char) 3, (char) 3, (char) 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        MutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3, (char) 3, (char) 4, (char) 5, (char) 5, (char) 6);
        MutableCharSet expected = CharSets.mutable.with((char) 1, (char) 4, (char) 6);
        MutableCharSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableCharBag newWithOccurrences(CharIntPair... elementsWithOccurrences) {
        MutableCharBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            CharIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences() {
        MutableCharBag bag = this.newWithOccurrences(PrimitiveTuples.pair((char) 1, 1), PrimitiveTuples.pair((char) 2, 2), PrimitiveTuples.pair((char) 3, 3), PrimitiveTuples.pair((char) 4, 4), PrimitiveTuples.pair((char) 5, 5), PrimitiveTuples.pair((char) 6, 6), PrimitiveTuples.pair((char) 7, 7), PrimitiveTuples.pair((char) 8, 8), PrimitiveTuples.pair((char) 9, 9), PrimitiveTuples.pair((char) 10, 10));
        MutableList<CharIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((char) 1).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith((char) 1, (char) 2, (char) 3).topOccurrences(5));
        Verify.assertSize(3, this.newWith((char) 1, (char) 2, (char) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((char) 1, (char) 2, (char) 3).topOccurrences(2));
        Verify.assertSize(3, this.newWith((char) 1, (char) 1, (char) 2, (char) 3).topOccurrences(2));
        Verify.assertSize(2, this.newWith((char) 1, (char) 1, (char) 2, (char) 2, (char) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        MutableCharBag bag = this.newWithOccurrences(PrimitiveTuples.pair((char) 1, 1), PrimitiveTuples.pair((char) 2, 2), PrimitiveTuples.pair((char) 3, 3), PrimitiveTuples.pair((char) 4, 4), PrimitiveTuples.pair((char) 5, 5), PrimitiveTuples.pair((char) 6, 6), PrimitiveTuples.pair((char) 7, 7), PrimitiveTuples.pair((char) 8, 8), PrimitiveTuples.pair((char) 9, 9), PrimitiveTuples.pair((char) 10, 10));
        MutableList<CharIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((char) 1).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((char) 1, (char) 2, (char) 3).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((char) 1, (char) 2, (char) 3).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith((char) 1, (char) 2, (char) 3).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith((char) 1, (char) 1, (char) 2, (char) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((char) 1, (char) 1, (char) 2, (char) 2, (char) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void addOccurrences() {
        MutableCharBag bag = this.newWith();
        bag.addOccurrences((char) 100, 3);
        Assert.assertEquals(CharHashBag.newBagWith((char) 100, (char) 100, (char) 100), bag);
        bag.addOccurrences((char) 100, 2);
        Assert.assertEquals(CharHashBag.newBagWith((char) 100, (char) 100, (char) 100, (char) 100, (char) 100), bag);
        bag.addOccurrences((char) 100, 0);
        Assert.assertEquals(CharHashBag.newBagWith((char) 100, (char) 100, (char) 100, (char) 100, (char) 100), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences((char) 100, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableCharBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences((char) 100, 2));
        bag.addOccurrences((char) 100, 5);
        Assert.assertTrue(bag.removeOccurrences((char) 100, 2));
        Assert.assertEquals(CharHashBag.newBagWith((char) 100, (char) 100, (char) 100), bag);
        Assert.assertFalse(bag.removeOccurrences((char) 100, 0));
        Assert.assertEquals(CharHashBag.newBagWith((char) 100, (char) 100, (char) 100), bag);
        Assert.assertTrue(bag.removeOccurrences((char) 100, 5));
        Assert.assertEquals(new CharHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences((char) 100, 5));
        Assert.assertEquals(new CharHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences((char) 100, -1);
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith((char) 1, (char) 1, (char) 2).forEachWithOccurrences((char argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("\u00012\u00021".equals(string) || "\u00021\u00012".equals(string));
    }

    @Test
    @Override
    public void add() {
        super.add();
        MutableCharBag bag = this.newWith();
        Assert.assertTrue(bag.add((char) 100));
        Assert.assertEquals(CharHashBag.newBagWith((char) 100), bag);
        Assert.assertTrue(bag.add((char) 100));
        Assert.assertEquals(CharHashBag.newBagWith((char) 100, (char) 100), bag);
    }

    @Test
    @Override
    public void addAllIterable() {
        super.addAllIterable();
        MutableCharBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3)));
        Assert.assertFalse(bag.addAll(new CharArrayList()));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3), bag);
        Assert.assertTrue(bag.addAll(CharHashBag.newBagWith((char) 4, (char) 4, (char) 4, (char) 4)));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3, (char) 4, (char) 4, (char) 4, (char) 4), bag);
    }

    @Test
    @Override
    public void remove() {
        super.remove();
        MutableCharBag bag = this.newWith();
        Assert.assertFalse(bag.remove((char) 100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new CharHashBag(), bag);
        Assert.assertTrue(bag.add((char) 100));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add((char) 100));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove((char) 100));
        Verify.assertSize(1, bag);
        Assert.assertEquals(CharHashBag.newBagWith((char) 100), bag);
        Assert.assertTrue(bag.remove((char) 100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new CharHashBag(), bag);
    }

    @Test
    @Override
    public void charIterator() {
        MutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        CharArrayList list = CharArrayList.newListWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        CharIterator iterator = bag.charIterator();
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
    public void charIterator_with_remove() {
        super.charIterator_with_remove();
        MutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        MutableCharIterator iterator = bag.charIterator();
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
        this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3).forEach((char each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count() {
        super.count();
        MutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(5L, bag.count(CharPredicates.greaterThan((char) 1)));
        Assert.assertEquals(1L, bag.count(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(0L, bag.count(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    @Override
    public void sum() {
        super.sum();
        Assert.assertEquals(14L, this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3).sum());
    }

    @Test
    @Override
    public void testEquals() {
        super.testEquals();
        MutableCharBag bag1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        MutableCharBag bag2 = this.newWith((char) 0, (char) 2, (char) 1, (char) 2, (char) 1, (char) 2);
        MutableCharBag bag3 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
    }

    @Test
    @Override
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[\u0001, \u0001, \u0001]", this.newWith((char) 1, (char) 1, (char) 1).toString());
    }

    @Test
    @Override
    public void makeString() {
        super.makeString();
        Assert.assertEquals("\u0001, \u0001, \u0001", this.newWith((char) 1, (char) 1, (char) 1).makeString());
    }

    @Test
    @Override
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith((char) 1, (char) 1, (char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001, \u0001, \u0001", appendable1.toString());
    }

    @Test
    @Override
    public void toList() {
        super.toList();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 1, (char) 1), this.newWith((char) 1, (char) 1, (char) 1).toList());
    }

    @Test
    @Override
    public void toSortedList() {
        super.toSortedList();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3), this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3).toSortedList());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableCharBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        MutableCharBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + (char) 100 + "=3}", this.newWith((char) 100, (char) 100, (char) 100).toStringOfItemToCount());
        String actual = this.newWith((char) 100, (char) 101, (char) 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + (char) 100 + "=1, " + (char) 101 + "=2}").equals(actual) || ("{" + (char) 101 + "=2, " + (char) 100 + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharBagTestCase instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharBagTestCase> toStringOfItemToCount;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableCharBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableCharBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableCharBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharBagTestCase::notEmpty;
            this.payloads.tap = AbstractMutableCharBagTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableCharBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableCharBagTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableCharBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableCharBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableCharBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableCharBagTestCase::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = AbstractMutableCharBagTestCase::size;
            this.payloads.anySatisfy = AbstractMutableCharBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableCharBagTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableCharBagTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableCharBagTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableCharBagTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableCharBagTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableCharBagTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableCharBagTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableCharBagTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableCharBagTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableCharBagTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableCharBagTestCase::detectIfNone;
            this.payloads.max = AbstractMutableCharBagTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableCharBagTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharBagTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharBagTestCase::maxIfEmpty;
            this.payloads.summaryStatistics = AbstractMutableCharBagTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableCharBagTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableCharBagTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableCharBagTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableCharBagTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableCharBagTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableCharBagTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableCharBagTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableCharBagTestCase::testHashCode;
            this.payloads.toSortedListByComparator = AbstractMutableCharBagTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableCharBagTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableCharBagTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableCharBagTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharBagTestCase::toBag;
            this.payloads.asLazy = AbstractMutableCharBagTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableCharBagTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableCharBagTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableCharBagTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableCharBagTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableCharBagTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableCharBagTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableCharBagTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableCharBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableCharBagTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableCharBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableCharBagTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableCharBagTestCase::chunk;
            this.payloads.clear = AbstractMutableCharBagTestCase::clear;
            this.payloads.contains = AbstractMutableCharBagTestCase::contains;
            this.payloads.addAllArray = AbstractMutableCharBagTestCase::addAllArray;
            this.payloads.removeIf = AbstractMutableCharBagTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableCharBagTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableCharBagTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableCharBagTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableCharBagTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableCharBagTestCase::with;
            this.payloads.withAll = AbstractMutableCharBagTestCase::withAll;
            this.payloads.without = AbstractMutableCharBagTestCase::without;
            this.payloads.withoutAll = AbstractMutableCharBagTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableCharBagTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharBagTestCase::asUnmodifiable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_for_remove_before_next = AbstractMutableCharBagTestCase::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = AbstractMutableCharBagTestCase::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableCharBagTestCase::newEmpty;
            this.payloads.sizeDistinct = AbstractMutableCharBagTestCase::sizeDistinct;
            this.payloads.selectByOccurrences = AbstractMutableCharBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractMutableCharBagTestCase::selectDuplicates;
            this.payloads.selectUnique = AbstractMutableCharBagTestCase::selectUnique;
            this.payloads.topOccurrences = AbstractMutableCharBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractMutableCharBagTestCase::bottomOccurrences;
            this.payloads.addOccurrences = AbstractMutableCharBagTestCase::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = AbstractMutableCharBagTestCase::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = AbstractMutableCharBagTestCase::forEachWithOccurrences;
            this.payloads.add = AbstractMutableCharBagTestCase::add;
            this.payloads.addAllIterable = AbstractMutableCharBagTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableCharBagTestCase::remove;
            this.payloads.charIterator = AbstractMutableCharBagTestCase::charIterator;
            this.payloads.charIterator_with_remove = AbstractMutableCharBagTestCase::charIterator_with_remove;
            this.payloads.forEach = AbstractMutableCharBagTestCase::forEach;
            this.payloads.count = AbstractMutableCharBagTestCase::count;
            this.payloads.sum = AbstractMutableCharBagTestCase::sum;
            this.payloads.testEquals = AbstractMutableCharBagTestCase::testEquals;
            this.payloads.testToString = AbstractMutableCharBagTestCase::testToString;
            this.payloads.makeString = AbstractMutableCharBagTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharBagTestCase::appendString;
            this.payloads.toList = AbstractMutableCharBagTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharBagTestCase::toSortedList;
            this.payloads.toImmutable = AbstractMutableCharBagTestCase::toImmutable;
            this.payloads.toStringOfItemToCount = AbstractMutableCharBagTestCase::toStringOfItemToCount;
        }
    }
}
