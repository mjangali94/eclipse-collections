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
import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableCharCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharBag}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractImmutableCharBagTestCase extends AbstractImmutableCharCollectionTestCase {

    @Override
    protected abstract ImmutableCharBag classUnderTest();

    @Override
    protected ImmutableCharBag newWith(char... elements) {
        return CharBags.immutable.of(elements);
    }

    @Override
    protected MutableCharBag newMutableCollectionWith(char... elements) {
        return CharHashBag.newBagWith(elements);
    }

    @Override
    protected ImmutableBag<Character> newObjectCollectionWith(Character... elements) {
        return HashBag.newBagWith(elements).toImmutable();
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith((char) 1).sizeDistinct());
        Assert.assertEquals(3L, this.newWith((char) 0, (char) 1, (char) 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        ImmutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        ImmutableCharBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(CharHashBag.newBagWith((char) 3, (char) 3, (char) 3), filtered);
    }

    @Test
    public void selectDuplicates() {
        ImmutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(CharHashBag.newBagWith((char) 2, (char) 2, (char) 3, (char) 3, (char) 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        ImmutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3, (char) 3, (char) 4, (char) 5, (char) 5, (char) 6);
        ImmutableCharSet expected = CharSets.immutable.with((char) 1, (char) 4, (char) 6);
        ImmutableCharSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected ImmutableCharBag newWithOccurrences(CharIntPair... elementsWithOccurrences) {
        MutableCharBag bag = CharBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            CharIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }

    @Test
    public void topOccurrences() {
        ImmutableCharBag bag = this.newWithOccurrences(PrimitiveTuples.pair((char) 1, 1), PrimitiveTuples.pair((char) 2, 2), PrimitiveTuples.pair((char) 3, 3), PrimitiveTuples.pair((char) 4, 4), PrimitiveTuples.pair((char) 5, 5), PrimitiveTuples.pair((char) 6, 6), PrimitiveTuples.pair((char) 7, 7), PrimitiveTuples.pair((char) 8, 8), PrimitiveTuples.pair((char) 9, 9), PrimitiveTuples.pair((char) 10, 10));
        ImmutableList<CharIntPair> top5 = bag.topOccurrences(5);
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
        ImmutableCharBag bag = this.newWithOccurrences(PrimitiveTuples.pair((char) 1, 1), PrimitiveTuples.pair((char) 2, 2), PrimitiveTuples.pair((char) 3, 3), PrimitiveTuples.pair((char) 4, 4), PrimitiveTuples.pair((char) 5, 5), PrimitiveTuples.pair((char) 6, 6), PrimitiveTuples.pair((char) 7, 7), PrimitiveTuples.pair((char) 8, 8), PrimitiveTuples.pair((char) 9, 9), PrimitiveTuples.pair((char) 10, 10));
        ImmutableList<CharIntPair> bottom5 = bag.bottomOccurrences(5);
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
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith((char) 1, (char) 1, (char) 2).forEachWithOccurrences((char argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("\u00012\u00021".equals(string) || "\u00021\u00012".equals(string));
    }

    @Test
    @Override
    public void charIterator() {
        ImmutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
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
        ImmutableCharBag bag = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
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
        ImmutableCharBag bag1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        ImmutableCharBag bag2 = this.newWith((char) 0, (char) 2, (char) 1, (char) 2, (char) 1, (char) 2);
        ImmutableCharBag bag3 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
        Assert.assertNotEquals(this.newWith(), CharArrayList.newListWith());
        Assert.assertNotEquals(this.newWith((char) 1), CharArrayList.newListWith((char) 1));
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
        ImmutableCharBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        ImmutableCharBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + (char) 100 + "=3}", this.newWith((char) 100, (char) 100, (char) 100).toStringOfItemToCount());
        String actual = this.newWith((char) 100, (char) 101, (char) 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + (char) 100 + "=1, " + (char) 101 + "=2}").equals(actual) || ("{" + (char) 101 + "=2, " + (char) 100 + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableCharBagTestCase instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
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
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableCharBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBagTestCase> toStringOfItemToCount;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractImmutableCharBagTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractImmutableCharBagTestCase::newCollection;
            this.payloads.isEmpty = AbstractImmutableCharBagTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableCharBagTestCase::notEmpty;
            this.payloads.tap = AbstractImmutableCharBagTestCase::tap;
            this.payloads.contains = AbstractImmutableCharBagTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableCharBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableCharBagTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractImmutableCharBagTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractImmutableCharBagTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractImmutableCharBagTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractImmutableCharBagTestCase::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharBagTestCase::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharBagTestCase::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.size = AbstractImmutableCharBagTestCase::size;
            this.payloads.anySatisfy = AbstractImmutableCharBagTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableCharBagTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableCharBagTestCase::noneSatisfy;
            this.payloads.collect = AbstractImmutableCharBagTestCase::collect;
            this.payloads.collectWithTarget = AbstractImmutableCharBagTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractImmutableCharBagTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractImmutableCharBagTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractImmutableCharBagTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractImmutableCharBagTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractImmutableCharBagTestCase::select;
            this.payloads.selectWithTarget = AbstractImmutableCharBagTestCase::selectWithTarget;
            this.payloads.reject = AbstractImmutableCharBagTestCase::reject;
            this.payloads.rejectWithTarget = AbstractImmutableCharBagTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractImmutableCharBagTestCase::detectIfNone;
            this.payloads.max = AbstractImmutableCharBagTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharBagTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableCharBagTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharBagTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableCharBagTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableCharBagTestCase::maxIfEmpty;
            this.payloads.summaryStatistics = AbstractImmutableCharBagTestCase::summaryStatistics;
            this.payloads.average = AbstractImmutableCharBagTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharBagTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractImmutableCharBagTestCase::averageIfEmpty;
            this.payloads.median = AbstractImmutableCharBagTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharBagTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractImmutableCharBagTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractImmutableCharBagTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractImmutableCharBagTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractImmutableCharBagTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractImmutableCharBagTestCase::testHashCode;
            this.payloads.toSortedListByComparator = AbstractImmutableCharBagTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractImmutableCharBagTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractImmutableCharBagTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractImmutableCharBagTestCase::toSet;
            this.payloads.toBag = AbstractImmutableCharBagTestCase::toBag;
            this.payloads.asLazy = AbstractImmutableCharBagTestCase::asLazy;
            this.payloads.injectInto = AbstractImmutableCharBagTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractImmutableCharBagTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractImmutableCharBagTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractImmutableCharBagTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractImmutableCharBagTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractImmutableCharBagTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractImmutableCharBagTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractImmutableCharBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableCharBagTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharBagTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractImmutableCharBagTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractImmutableCharBagTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractImmutableCharBagTestCase::chunk;
            this.payloads.testNewWith = AbstractImmutableCharBagTestCase::testNewWith;
            this.payloads.newWithAll = AbstractImmutableCharBagTestCase::newWithAll;
            this.payloads.newWithout = AbstractImmutableCharBagTestCase::newWithout;
            this.payloads.newWithoutAll = AbstractImmutableCharBagTestCase::newWithoutAll;
            this.payloads.sizeDistinct = AbstractImmutableCharBagTestCase::sizeDistinct;
            this.payloads.selectByOccurrences = AbstractImmutableCharBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractImmutableCharBagTestCase::selectDuplicates;
            this.payloads.selectUnique = AbstractImmutableCharBagTestCase::selectUnique;
            this.payloads.topOccurrences = AbstractImmutableCharBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractImmutableCharBagTestCase::bottomOccurrences;
            this.payloads.forEachWithOccurrences = AbstractImmutableCharBagTestCase::forEachWithOccurrences;
            this.payloads.charIterator = AbstractImmutableCharBagTestCase::charIterator;
            this.payloads.forEach = AbstractImmutableCharBagTestCase::forEach;
            this.payloads.count = AbstractImmutableCharBagTestCase::count;
            this.payloads.sum = AbstractImmutableCharBagTestCase::sum;
            this.payloads.testEquals = AbstractImmutableCharBagTestCase::testEquals;
            this.payloads.testToString = AbstractImmutableCharBagTestCase::testToString;
            this.payloads.makeString = AbstractImmutableCharBagTestCase::makeString;
            this.payloads.appendString = AbstractImmutableCharBagTestCase::appendString;
            this.payloads.toList = AbstractImmutableCharBagTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableCharBagTestCase::toSortedList;
            this.payloads.toImmutable = AbstractImmutableCharBagTestCase::toImmutable;
            this.payloads.toStringOfItemToCount = AbstractImmutableCharBagTestCase::toStringOfItemToCount;
        }
    }
}
