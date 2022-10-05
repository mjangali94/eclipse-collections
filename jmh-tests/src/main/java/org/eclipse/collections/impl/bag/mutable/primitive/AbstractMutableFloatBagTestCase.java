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
import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;

/**
 * JUnit test for {@link MutableFloatBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableFloatBagTestCase extends AbstractMutableFloatCollectionTestCase {

    @Override
    protected abstract MutableFloatBag classUnderTest();

    @Override
    protected abstract MutableFloatBag newWith(float... elements);

    @Override
    protected MutableFloatBag newMutableCollectionWith(float... elements) {
        return FloatHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Float> newObjectCollectionWith(Float... elements) {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct() {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0f, 1.0f, 2.0f).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f).sizeDistinct());
    }

    @Test
    public void selectByOccurrences() {
        MutableFloatBag bag = this.newWith(100.0f, 100.0f, 100.0f, 50.0f, 50.0f);
        MutableFloatBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f, 100.0f, 100.0f), filtered);
    }

    @Test
    public void selectDuplicates() {
        MutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(2.0f, 2.0f, 3.0f, 3.0f, 3.0f), bag.selectDuplicates());
    }

    @Test
    public void selectUnique() {
        MutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f, 3.0f, 4.0f, 5.0f, 5.0f, 6.0f);
        MutableFloatSet expected = FloatSets.mutable.with(1.0f, 4.0f, 6.0f);
        MutableFloatSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableFloatBag newWithOccurrences(FloatIntPair... elementsWithOccurrences) {
        MutableFloatBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            FloatIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences() {
        MutableFloatBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1.0f, 1), PrimitiveTuples.pair(2.0f, 2), PrimitiveTuples.pair(3.0f, 3), PrimitiveTuples.pair(4.0f, 4), PrimitiveTuples.pair(5.0f, 5), PrimitiveTuples.pair(6.0f, 6), PrimitiveTuples.pair(7.0f, 7), PrimitiveTuples.pair(8.0f, 8), PrimitiveTuples.pair(9.0f, 9), PrimitiveTuples.pair(10.0f, 10));
        MutableList<FloatIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1.0f).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).topOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).topOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 3.0f).topOccurrences(2));
        Verify.assertSize(2, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        MutableFloatBag bag = this.newWithOccurrences(PrimitiveTuples.pair(1.0f, 1), PrimitiveTuples.pair(2.0f, 2), PrimitiveTuples.pair(3.0f, 3), PrimitiveTuples.pair(4.0f, 4), PrimitiveTuples.pair(5.0f, 5), PrimitiveTuples.pair(6.0f, 6), PrimitiveTuples.pair(7.0f, 7), PrimitiveTuples.pair(8.0f, 8), PrimitiveTuples.pair(9.0f, 9), PrimitiveTuples.pair(10.0f, 10));
        MutableList<FloatIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1.0f).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith(1.0f, 1.0f, 2.0f, 3.0f).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void addOccurrences() {
        MutableFloatBag bag = this.newWith();
        bag.addOccurrences(100.0f, 3);
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f, 100.0f, 100.0f), bag);
        bag.addOccurrences(100.0f, 2);
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f, 100.0f, 100.0f, 100.0f, 100.0f), bag);
        bag.addOccurrences(100.0f, 0);
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f, 100.0f, 100.0f, 100.0f, 100.0f), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(100.0f, -1);
    }

    @Test
    public void removeOccurrences() {
        MutableFloatBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences(100.0f, 2));
        bag.addOccurrences(100.0f, 5);
        Assert.assertTrue(bag.removeOccurrences(100.0f, 2));
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f, 100.0f, 100.0f), bag);
        Assert.assertFalse(bag.removeOccurrences(100.0f, 0));
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f, 100.0f, 100.0f), bag);
        Assert.assertTrue(bag.removeOccurrences(100.0f, 5));
        Assert.assertEquals(new FloatHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences(100.0f, 5));
        Assert.assertEquals(new FloatHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences(100.0f, -1);
    }

    @Test
    public void forEachWithOccurrences() {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1.0f, 1.0f, 2.0f).forEachWithOccurrences((float argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1.022.01".equals(string) || "2.011.02".equals(string));
    }

    @Test
    @Override
    public void add() {
        super.add();
        MutableFloatBag bag = this.newWith();
        Assert.assertTrue(bag.add(100.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f), bag);
        Assert.assertTrue(bag.add(100.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f, 100.0f), bag);
    }

    @Test
    @Override
    public void addAllIterable() {
        super.addAllIterable();
        MutableFloatBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(FloatArrayList.newListWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f)));
        Assert.assertFalse(bag.addAll(new FloatArrayList()));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f), bag);
        Assert.assertTrue(bag.addAll(FloatHashBag.newBagWith(4.0f, 4.0f, 4.0f, 4.0f)));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f, 4.0f, 4.0f, 4.0f, 4.0f), bag);
    }

    @Test
    @Override
    public void remove() {
        super.remove();
        MutableFloatBag bag = this.newWith();
        Assert.assertFalse(bag.remove(100.0f));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new FloatHashBag(), bag);
        Assert.assertTrue(bag.add(100.0f));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add(100.0f));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove(100.0f));
        Verify.assertSize(1, bag);
        Assert.assertEquals(FloatHashBag.newBagWith(100.0f), bag);
        Assert.assertTrue(bag.remove(100.0f));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new FloatHashBag(), bag);
    }

    @Test
    @Override
    public void floatIterator() {
        MutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        FloatArrayList list = FloatArrayList.newListWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        FloatIterator iterator = bag.floatIterator();
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
    public void floatIterator_with_remove() {
        super.floatIterator_with_remove();
        MutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        MutableFloatIterator iterator = bag.floatIterator();
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
        double[] sum = new double[1];
        this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).forEach((float each) -> sum[0] += each);
        Assert.assertEquals(14L, sum[0], 0.0f);
    }

    @Test
    @Override
    public void count() {
        super.count();
        MutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(5L, bag.count(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(1L, bag.count(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(0L, bag.count(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    @Override
    public void sum() {
        super.sum();
        Assert.assertEquals(14.0, this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).sum(), 0.0);
    }

    @Test
    @Override
    public void testEquals() {
        super.testEquals();
        MutableFloatBag bag1 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        MutableFloatBag bag2 = this.newWith(0.0f, 2.0f, 1.0f, 2.0f, 1.0f, 2.0f);
        MutableFloatBag bag3 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
    }

    @Test
    @Override
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1.0, 1.0, 1.0]", this.newWith(1.0f, 1.0f, 1.0f).toString());
    }

    @Test
    @Override
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1.0, 1.0, 1.0", this.newWith(1.0f, 1.0f, 1.0f).makeString());
    }

    @Test
    @Override
    public void appendString() {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1.0f, 1.0f, 1.0f).appendString(appendable1);
        Assert.assertEquals("1.0, 1.0, 1.0", appendable1.toString());
    }

    @Test
    @Override
    public void toList() {
        super.toList();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 1.0f, 1.0f), this.newWith(1.0f, 1.0f, 1.0f).toList());
    }

    @Test
    @Override
    public void toSortedList() {
        super.toSortedList();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f), this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).toSortedList());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableFloatBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount() {
        MutableFloatBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100.0f + "=3}", this.newWith(100.0f, 100.0f, 100.0f).toStringOfItemToCount());
        String actual = this.newWith(100.0f, 101.0f, 101.0f).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100.0f + "=1, " + 101.0f + "=2}").equals(actual) || ("{" + 101.0f + "=2, " + 100.0f + "=1}").equals(actual));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase._Benchmark {

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator_with_remove, this.description("floatIterator_with_remove"));
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
        public abstract AbstractMutableFloatBagTestCase implementation();
    }
}
