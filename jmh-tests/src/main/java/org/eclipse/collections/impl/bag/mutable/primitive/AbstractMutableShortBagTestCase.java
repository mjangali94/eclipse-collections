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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase._Benchmark {

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
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addOccurrences, this.description("addOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addOccurrences_throws, this.description("addOccurrences_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeOccurrences, this.description("removeOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeOccurrences_throws, this.description("removeOccurrences_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithOccurrences, this.description("forEachWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator, this.description("shortIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator_with_remove, this.description("shortIterator_with_remove"));
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
        public abstract AbstractMutableShortBagTestCase implementation();
    }
}
