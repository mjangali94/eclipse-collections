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
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.api.set.primitive.MutableIntSet;

/**
 * JUnit test for {@link MutableIntBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableIntBagTestCase extends AbstractMutableIntCollectionTestCase {

    @Override
    protected abstract MutableIntBag classUnderTest();

    @Override
    protected abstract MutableIntBag newWith(int... elements);

    @Override
    protected MutableIntBag newMutableCollectionWith(int... elements) {
        return IntHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Integer> newObjectCollectionWith(Integer... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0, 1, 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0, 1, 1, 2, 2, 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        MutableIntBag bag = this.newWith(100, 100, 100, 50, 50);
        MutableIntBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), filtered);
    }

    @Test
    public void selectDuplicates() {
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(IntHashBag.newBagWith(2, 2, 3, 3, 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3, 3, 4, 5, 5, 6);
        MutableIntSet expected = IntSets.mutable.with(1, 4, 6);
        MutableIntSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableIntBag newWithOccurrences(IntIntPair... elementsWithOccurrences) {
        MutableIntBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            IntIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences() {
        MutableIntBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2), PrimitiveTuples.pair(3, 3), PrimitiveTuples.pair(4, 4), PrimitiveTuples.pair(5, 5), PrimitiveTuples.pair(6, 6), PrimitiveTuples.pair(7, 7), PrimitiveTuples.pair(8, 8), PrimitiveTuples.pair(9, 9), PrimitiveTuples.pair(10, 10));
        MutableList<IntIntPair> top5 = bag.topOccurrences(5);
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
        MutableIntBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2), PrimitiveTuples.pair(3, 3), PrimitiveTuples.pair(4, 4), PrimitiveTuples.pair(5, 5), PrimitiveTuples.pair(6, 6), PrimitiveTuples.pair(7, 7), PrimitiveTuples.pair(8, 8), PrimitiveTuples.pair(9, 9), PrimitiveTuples.pair(10, 10));
        MutableList<IntIntPair> bottom5 = bag.bottomOccurrences(5);
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
    public void addOccurrences() {
        MutableIntBag bag = this.newWith();
        bag.addOccurrences(100, 3);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), bag);
        bag.addOccurrences(100, 2);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100, 100, 100), bag);
        bag.addOccurrences(100, 0);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100, 100, 100), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(100, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableIntBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences(100, 2));
        bag.addOccurrences(100, 5);
        Assert.assertTrue(bag.removeOccurrences(100, 2));
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), bag);
        Assert.assertFalse(bag.removeOccurrences(100, 0));
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), bag);
        Assert.assertTrue(bag.removeOccurrences(100, 5));
        Assert.assertEquals(new IntHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences(100, 5));
        Assert.assertEquals(new IntHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences(100, -1);
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
    public void add() {
        super.add();
        MutableIntBag bag = this.newWith();
        Assert.assertTrue(bag.add(100));
        Assert.assertEquals(IntHashBag.newBagWith(100), bag);
        Assert.assertTrue(bag.add(100));
        Assert.assertEquals(IntHashBag.newBagWith(100, 100), bag);
    }

    @Test
    @Override
    public void addAllIterable() {
        super.addAllIterable();
        MutableIntBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(IntArrayList.newListWith(1, 2, 2, 3, 3, 3)));
        Assert.assertFalse(bag.addAll(new IntArrayList()));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3, 3, 3), bag);
        Assert.assertTrue(bag.addAll(IntHashBag.newBagWith(4, 4, 4, 4)));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4), bag);
    }

    @Test
    @Override
    public void remove() {
        super.remove();
        MutableIntBag bag = this.newWith();
        Assert.assertFalse(bag.remove(100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new IntHashBag(), bag);
        Assert.assertTrue(bag.add(100));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add(100));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove(100));
        Verify.assertSize(1, bag);
        Assert.assertEquals(IntHashBag.newBagWith(100), bag);
        Assert.assertTrue(bag.remove(100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new IntHashBag(), bag);
    }

    @Test
    @Override
    public void intIterator() {
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
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

    @Override
    @Test
    public void intIterator_with_remove() {
        super.intIterator_with_remove();
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        MutableIntIterator iterator = bag.intIterator();
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
        this.newWith(1, 2, 2, 3, 3, 3).forEach((int each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count() {
        super.count();
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
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
        MutableIntBag bag1 = this.newWith(0, 1, 1, 2, 2, 2);
        MutableIntBag bag2 = this.newWith(0, 2, 1, 2, 1, 2);
        MutableIntBag bag3 = this.newWith(0, 1, 2, 2, 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
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
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableIntBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        MutableIntBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100 + "=3}", this.newWith(100, 100, 100).toStringOfItemToCount());
        String actual = this.newWith(100, 101, 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100 + "=1, " + 101 + "=2}").equals(actual) || ("{" + 101 + "=2, " + 100 + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntBagTestCase instance;

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
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntBagTestCase> toStringOfItemToCount;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractMutableIntBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractMutableIntBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractMutableIntBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntBagTestCase::notEmpty;
            this.payloads.tap = AbstractMutableIntBagTestCase::tap;
            this.payloads.containsAllArray = AbstractMutableIntBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractMutableIntBagTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractMutableIntBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractMutableIntBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractMutableIntBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractMutableIntBagTestCase::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.size = AbstractMutableIntBagTestCase::size;
            this.payloads.anySatisfy = AbstractMutableIntBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableIntBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableIntBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractMutableIntBagTestCase::collect;
            this.payloads.collectWithTarget = AbstractMutableIntBagTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractMutableIntBagTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractMutableIntBagTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractMutableIntBagTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractMutableIntBagTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractMutableIntBagTestCase::select;
            this.payloads.selectWithTarget = AbstractMutableIntBagTestCase::selectWithTarget;
            this.payloads.reject = AbstractMutableIntBagTestCase::reject;
            this.payloads.rejectWithTarget = AbstractMutableIntBagTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractMutableIntBagTestCase::detectIfNone;
            this.payloads.max = AbstractMutableIntBagTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableIntBagTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableIntBagTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableIntBagTestCase::maxIfEmpty;
            this.payloads.summaryStatistics = AbstractMutableIntBagTestCase::summaryStatistics;
            this.payloads.average = AbstractMutableIntBagTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractMutableIntBagTestCase::averageIfEmpty;
            this.payloads.median = AbstractMutableIntBagTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractMutableIntBagTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractMutableIntBagTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractMutableIntBagTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractMutableIntBagTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractMutableIntBagTestCase::testHashCode;
            this.payloads.toSortedListByComparator = AbstractMutableIntBagTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractMutableIntBagTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractMutableIntBagTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractMutableIntBagTestCase::toSet;
            this.payloads.toBag = AbstractMutableIntBagTestCase::toBag;
            this.payloads.asLazy = AbstractMutableIntBagTestCase::asLazy;
            this.payloads.injectInto = AbstractMutableIntBagTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractMutableIntBagTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractMutableIntBagTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractMutableIntBagTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractMutableIntBagTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractMutableIntBagTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractMutableIntBagTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractMutableIntBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableIntBagTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractMutableIntBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractMutableIntBagTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractMutableIntBagTestCase::chunk;
            this.payloads.clear = AbstractMutableIntBagTestCase::clear;
            this.payloads.contains = AbstractMutableIntBagTestCase::contains;
            this.payloads.addAllArray = AbstractMutableIntBagTestCase::addAllArray;
            this.payloads.removeIf = AbstractMutableIntBagTestCase::removeIf;
            this.payloads.removeAll = AbstractMutableIntBagTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractMutableIntBagTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractMutableIntBagTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractMutableIntBagTestCase::retainAll_iterable;
            this.payloads.with = AbstractMutableIntBagTestCase::with;
            this.payloads.withAll = AbstractMutableIntBagTestCase::withAll;
            this.payloads.without = AbstractMutableIntBagTestCase::without;
            this.payloads.withoutAll = AbstractMutableIntBagTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractMutableIntBagTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableIntBagTestCase::asUnmodifiable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_for_remove_before_next = AbstractMutableIntBagTestCase::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = AbstractMutableIntBagTestCase::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractMutableIntBagTestCase::newEmpty;
            this.payloads.sizeDistinct = AbstractMutableIntBagTestCase::sizeDistinct;
            this.payloads.selectByOccurrences = AbstractMutableIntBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractMutableIntBagTestCase::selectDuplicates;
            this.payloads.selectUnique = AbstractMutableIntBagTestCase::selectUnique;
            this.payloads.topOccurrences = AbstractMutableIntBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractMutableIntBagTestCase::bottomOccurrences;
            this.payloads.addOccurrences = AbstractMutableIntBagTestCase::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = AbstractMutableIntBagTestCase::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.forEachWithOccurrences = AbstractMutableIntBagTestCase::forEachWithOccurrences;
            this.payloads.add = AbstractMutableIntBagTestCase::add;
            this.payloads.addAllIterable = AbstractMutableIntBagTestCase::addAllIterable;
            this.payloads.remove = AbstractMutableIntBagTestCase::remove;
            this.payloads.intIterator = AbstractMutableIntBagTestCase::intIterator;
            this.payloads.intIterator_with_remove = AbstractMutableIntBagTestCase::intIterator_with_remove;
            this.payloads.forEach = AbstractMutableIntBagTestCase::forEach;
            this.payloads.count = AbstractMutableIntBagTestCase::count;
            this.payloads.sum = AbstractMutableIntBagTestCase::sum;
            this.payloads.testEquals = AbstractMutableIntBagTestCase::testEquals;
            this.payloads.testToString = AbstractMutableIntBagTestCase::testToString;
            this.payloads.makeString = AbstractMutableIntBagTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntBagTestCase::appendString;
            this.payloads.toList = AbstractMutableIntBagTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntBagTestCase::toSortedList;
            this.payloads.toImmutable = AbstractMutableIntBagTestCase::toImmutable;
            this.payloads.toStringOfItemToCount = AbstractMutableIntBagTestCase::toStringOfItemToCount;
        }
    }
}
