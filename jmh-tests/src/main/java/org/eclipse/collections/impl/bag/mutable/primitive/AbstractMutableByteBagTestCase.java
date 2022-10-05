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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableByteCollectionTestCase._Benchmark {

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator, this.description("byteIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator_with_remove, this.description("byteIterator_with_remove"));
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
        public abstract AbstractMutableByteBagTestCase implementation();
    }
}
