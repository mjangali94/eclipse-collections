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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableCharCollectionTestCase._Benchmark {

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator, this.description("charIterator"));
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
        public abstract AbstractImmutableCharBagTestCase implementation();
    }
}
