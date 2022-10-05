/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LongIterable}s
 * This file was automatically generated from template file abstractPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLongIterableTestCase {

    protected abstract LongIterable classUnderTest();

    protected abstract LongIterable newWith(long... elements);

    protected abstract LongIterable newMutableCollectionWith(long... elements);

    protected abstract RichIterable<Long> newObjectCollectionWith(Long... elements);

    @Test
    public void newCollectionWith() {
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        Verify.assertSize(3, iterable);
        Verify.assertSize(4, this.newWith(0L, 1L, 31L, 32L));
        Assert.assertTrue(iterable.containsAll(1L, 2L, 3L));
        LongIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll(1L, 2L, 3L));
        LongIterable iterable2 = this.newWith(1L);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll(1L, 2L, 3L));
    }

    @Test
    public void newCollection() {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L));
        Assert.assertEquals(this.newMutableCollectionWith(0L, 1L, 31L, 32L), this.newWith(0L, 1L, 31L, 32L));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith(0L, 1L, 31L, 32L));
        Verify.assertNotEmpty(this.newWith(0L, 1L, 2L));
        Verify.assertNotEmpty(this.newWith(0L, 31L));
        Verify.assertNotEmpty(this.newWith(31L, 32L));
        Verify.assertNotEmpty(this.newWith(32L, 33L));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith(0L, 1L, 31L, 32L).notEmpty());
        Assert.assertTrue(this.newWith(0L, 1L, 2L).notEmpty());
        Assert.assertTrue(this.newWith(0L, 31L).notEmpty());
        Assert.assertTrue(this.newWith(31L, 32L).notEmpty());
        Assert.assertTrue(this.newWith(32L, 33L).notEmpty());
    }

    @Test
    public void tap() {
        MutableLongList tapResult = LongLists.mutable.empty();
        LongIterable collection = this.newWith(14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void contains() {
        LongIterable iterable = this.newWith(14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L);
        Assert.assertFalse(iterable.contains(29L));
        Assert.assertFalse(iterable.contains(49L));
        long[] numbers = { 14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L };
        for (long number : numbers) {
            Assert.assertTrue(iterable.contains(number));
        }
        Assert.assertFalse(iterable.contains(-1L));
        Assert.assertFalse(iterable.contains(29L));
        Assert.assertFalse(iterable.contains(49L));
        LongIterable iterable1 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(iterable1.contains(0L));
        Assert.assertTrue(iterable1.contains(1L));
        Assert.assertTrue(iterable1.contains(2L));
        Assert.assertFalse(iterable1.contains(3L));
        LongIterable iterable2 = this.classUnderTest();
        for (long each = 1; each <= iterable2.size(); each++) {
            Assert.assertTrue(iterable2.contains(each));
        }
        Assert.assertFalse(iterable2.contains(iterable2.size() + 1));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toArray()));
        Assert.assertFalse(this.classUnderTest().containsAll(this.classUnderTest().size() + 1));
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        Assert.assertTrue(iterable.containsAll(1L));
        Assert.assertTrue(iterable.containsAll(1L, 2L, 3L));
        Assert.assertFalse(iterable.containsAll(1L, 2L, 3L, 4L));
        Assert.assertFalse(iterable.containsAll(1L, 2L, 4L));
        Assert.assertFalse(iterable.containsAll(4L, 5L, 6L));
        LongIterable iterable1 = this.newWith(14L, 2L, 30L, 32L, 35L, 0L, 1L);
        Assert.assertTrue(iterable1.containsAll(14L));
        Assert.assertTrue(iterable1.containsAll(35L));
        Assert.assertFalse(iterable1.containsAll(-1L));
        Assert.assertTrue(iterable1.containsAll(14L, 1L, 30L));
        Assert.assertTrue(iterable1.containsAll(14L, 1L, 32L));
        Assert.assertTrue(iterable1.containsAll(14L, 1L, 35L));
        Assert.assertFalse(iterable1.containsAll(0L, 2L, 35L, -1L));
        Assert.assertFalse(iterable1.containsAll(31L, -1L));
        LongIterable iterable2 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(iterable2.containsAll(0L));
        Assert.assertTrue(iterable2.containsAll(0L, 0L, 0L));
        Assert.assertTrue(iterable2.containsAll(0L, 1L, 1L));
        Assert.assertTrue(iterable2.containsAll(0L, 1L, 2L));
        Assert.assertFalse(iterable2.containsAll(0L, 1L, 2L, 3L, 4L));
        Assert.assertFalse(iterable2.containsAll(3L, 4L));
        int size = 33;
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        LongIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(1L, 2L, 3L));
        Assert.assertTrue(iterable3.containsAll());
        Assert.assertFalse(iterable3.containsAll(3L, 4L, 5L, 33L, 34L));
        Assert.assertTrue(iterable3.containsAll(array));
        LongIterable iterable4 = LongSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(1L, 2L, 3L));
        Assert.assertTrue(iterable4.containsAll());
        Assert.assertFalse(iterable4.containsAll(3L, 4L, 5L, 33L, 34L));
        Assert.assertTrue(iterable4.containsAll(array));
    }

    @Test
    public void containsAllIterable() {
        LongIterable source = this.classUnderTest();
        Assert.assertTrue(source.containsAll(this.classUnderTest()));
        Assert.assertFalse(source.containsAll(LongArrayList.newListWith(source.size() + 1)));
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        Assert.assertTrue(this.newWith().containsAll(new LongArrayList()));
        Assert.assertFalse(this.newWith().containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L, 4L)));
        Assert.assertFalse(iterable.containsAll(LongArrayList.newListWith(1L, 2L, 4L)));
        Assert.assertFalse(iterable.containsAll(LongArrayList.newListWith(4L, 5L, 6L)));
        LongIterable iterable1 = this.newWith(14L, 2L, 30L, 32L, 35L, 0L, 1L);
        Assert.assertTrue(iterable1.containsAll(LongHashSet.newSetWith(14L)));
        Assert.assertTrue(iterable1.containsAll(LongHashSet.newSetWith(35L)));
        Assert.assertFalse(iterable1.containsAll(LongHashSet.newSetWith(-1L)));
        Assert.assertTrue(iterable1.containsAll(LongHashSet.newSetWith(14L, 1L, 30L)));
        Assert.assertTrue(iterable1.containsAll(LongHashSet.newSetWith(14L, 1L, 32L)));
        Assert.assertTrue(iterable1.containsAll(LongHashSet.newSetWith(14L, 1L, 35L)));
        Assert.assertFalse(iterable1.containsAll(LongHashSet.newSetWith(0L, 2L, 35L, -1L)));
        Assert.assertFalse(iterable1.containsAll(LongHashSet.newSetWith(31L, -1L)));
        LongIterable iterable2 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(iterable2.containsAll(LongArrayList.newListWith(0L)));
        Assert.assertTrue(iterable2.containsAll(LongArrayList.newListWith(0L, 0L, 0L)));
        Assert.assertTrue(iterable2.containsAll(LongArrayList.newListWith(0L, 1L, 1L)));
        Assert.assertTrue(iterable2.containsAll(LongArrayList.newListWith(0L, 1L, 2L)));
        Assert.assertFalse(iterable2.containsAll(LongArrayList.newListWith(0L, 1L, 2L, 3L, 4L)));
        Assert.assertFalse(iterable2.containsAll(LongArrayList.newListWith(3L, 4L)));
        int size = 33;
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        LongIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(LongLists.immutable.with(1L, 2L, 3L)));
        Assert.assertTrue(iterable3.containsAll(LongLists.mutable.empty()));
        Assert.assertFalse(iterable3.containsAll(LongLists.mutable.with(3L, 4L, 5L, 33L, 34L)));
        Assert.assertTrue(iterable3.containsAll(LongLists.immutable.with(array)));
        LongIterable iterable4 = LongSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(LongLists.immutable.with(1L, 2L, 3L)));
        Assert.assertTrue(iterable4.containsAll(LongLists.mutable.empty()));
        Assert.assertFalse(iterable4.containsAll(LongLists.mutable.with(3L, 4L, 5L, 33L, 34L)));
        Assert.assertTrue(iterable4.containsAll(LongLists.immutable.with(array)));
    }

    @Test
    public void containsAnyArray() {
        LongIterable iterable = this.newWith(1L, 2L, 3L, 4L, 5L);
        Assert.assertTrue(iterable.containsAny(1L, 1L, 1L));
        Assert.assertFalse(iterable.containsAny());
        Assert.assertTrue(iterable.containsAny(1L, 2L, 3L));
        Assert.assertFalse(iterable.containsAny(6L, 7L, 8L));
        LongIterable iterable2 = this.newWith(0L, 1L, 3L, 7L);
        Assert.assertTrue(iterable2.containsAny(3L, 3L, 1L, 9L));
        Assert.assertFalse(iterable2.containsAny());
        Assert.assertTrue(iterable2.containsAny(-1L, 3L, 5L));
        Assert.assertFalse(iterable2.containsAny(2L, 4L, 6L));
        int size = 33;
        long[] array = new long[size];
        long[] unmatched = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            unmatched[i] = i + 34;
        }
        LongIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(array));
        Assert.assertFalse(iterable3.containsAny(unmatched));
        LongIterable iterable4 = LongSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(array));
        Assert.assertFalse(iterable4.containsAny(unmatched));
        LongIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny());
        Assert.assertFalse(emptyIterable.containsAny(0L, 0L));
        Assert.assertFalse(emptyIterable.containsAny(-1L));
        Assert.assertFalse(emptyIterable.containsAny(1L, 2L, 3L));
    }

    @Test
    public void containsAnyIterable() {
        LongIterable iterable = this.newWith(1L, 2L, 3L, 4L, 5L);
        Assert.assertTrue(iterable.containsAny(LongLists.immutable.with(1L, 1L, 1L)));
        Assert.assertFalse(iterable.containsAny(LongLists.mutable.empty()));
        Assert.assertTrue(iterable.containsAny(LongLists.immutable.with(1L, 2L, 3L)));
        Assert.assertFalse(iterable.containsAny(LongLists.mutable.with(6L, 7L, 8L)));
        LongIterable iterable2 = this.newWith(0L, 1L, 3L, 7L);
        Assert.assertTrue(iterable2.containsAny(LongSets.immutable.with(3L, 3L, 1L, 9L)));
        Assert.assertFalse(iterable2.containsAny(LongSets.mutable.empty()));
        Assert.assertTrue(iterable2.containsAny(LongSets.immutable.with(-1L, 3L, 5L)));
        Assert.assertFalse(iterable2.containsAny(LongSets.mutable.with(2L, 4L, 6L)));
        LongIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny(LongLists.mutable.empty()));
        Assert.assertFalse(emptyIterable.containsAny(LongLists.immutable.with(0L, 0L)));
        Assert.assertFalse(emptyIterable.containsAny(LongLists.mutable.with(-1L)));
        Assert.assertFalse(emptyIterable.containsAny(LongLists.immutable.with(1L, 2L, 3L)));
        int size = 33;
        long[] array = new long[size];
        long[] unmatched = new long[size];
        long[] bigger = new long[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            bigger[i] = i + 1;
            unmatched[i] = i + 34;
        }
        bigger[size - 1] = 33L;
        LongIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(LongLists.immutable.with(array)));
        Assert.assertFalse(iterable3.containsAny(LongLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsAny(LongSets.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsAny(LongSets.mutable.with(bigger)));
        LongIterable iterable4 = LongSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(LongLists.immutable.with(array)));
        Assert.assertFalse(iterable4.containsAny(LongLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable4.containsAny(LongSets.immutable.with(array)));
        Assert.assertTrue(iterable4.containsAny(LongSets.immutable.with(bigger)));
    }

    @Test
    public void containsNoneArray() {
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        Assert.assertFalse(iterable.containsNone(1L, 1L));
        Assert.assertTrue(iterable.containsNone());
        Assert.assertFalse(iterable.containsNone(3L, 4L, 5L, 6L));
        Assert.assertTrue(iterable.containsNone(7L, 8L, 11L));
        LongIterable iterable2 = this.newWith(0L, 1L, 3L, 7L);
        Assert.assertTrue(iterable2.containsNone(2L, 4L, 6L));
        Assert.assertTrue(iterable2.containsNone());
        Assert.assertFalse(iterable2.containsNone(-1L, 1L, 3L));
        Assert.assertFalse(iterable2.containsNone(7L, 3L, 1L, 0L));
        int size = 33;
        long[] array = new long[size];
        long[] unmatched = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            unmatched[i] = i + 34;
        }
        LongIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(array));
        Assert.assertTrue(iterable3.containsNone(unmatched));
        LongIterable iterable4 = LongSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(array));
        Assert.assertTrue(iterable4.containsNone(unmatched));
        LongIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(1L, 2L, 3L));
        Assert.assertTrue(emptyIterable.containsNone());
        Assert.assertTrue(emptyIterable.containsNone(-1L, 5L));
        Assert.assertTrue(emptyIterable.containsNone(0L));
    }

    @Test
    public void containsNoneIterable() {
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        Assert.assertFalse(iterable.containsNone(LongLists.immutable.with(1L, 1L)));
        Assert.assertTrue(iterable.containsNone(LongLists.mutable.empty()));
        Assert.assertFalse(iterable.containsNone(LongLists.mutable.with(3L, 4L, 5L, 6L)));
        Assert.assertTrue(iterable.containsNone(LongLists.immutable.with(7L, 8L, 11L)));
        LongIterable iterable2 = this.newWith(0L, 1L, 3L, 7L);
        Assert.assertTrue(iterable2.containsNone(LongSets.immutable.with(2L, 4L, 6L)));
        Assert.assertTrue(iterable2.containsNone(LongSets.mutable.empty()));
        Assert.assertFalse(iterable2.containsNone(LongSets.immutable.with(-1L, 1L, 3L)));
        Assert.assertFalse(iterable2.containsNone(LongSets.mutable.with(7L, 3L, 1L, 0L)));
        LongIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(LongLists.immutable.with(1L, 2L, 3L)));
        Assert.assertTrue(emptyIterable.containsNone(LongLists.mutable.empty()));
        Assert.assertTrue(emptyIterable.containsNone(LongLists.immutable.with(-1L, 5L)));
        Assert.assertTrue(emptyIterable.containsNone(LongLists.mutable.with(0L)));
        int size = 33;
        long[] array = new long[size];
        long[] unmatched = new long[size];
        long[] bigger = new long[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            bigger[i] = i + 1;
            unmatched[i] = i + 34;
        }
        bigger[size - 1] = 33L;
        LongIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(LongLists.immutable.with(array)));
        Assert.assertTrue(iterable3.containsNone(LongLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsNone(LongSets.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsNone(LongSets.mutable.with(bigger)));
        LongIterable iterable4 = LongSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(LongLists.immutable.with(array)));
        Assert.assertTrue(iterable4.containsNone(LongLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable4.containsNone(LongSets.immutable.with(array)));
        Assert.assertFalse(iterable4.containsNone(LongSets.immutable.with(bigger)));
    }

    @Test
    public abstract void longIterator();

    @Test(expected = NoSuchElementException.class)
    public void longIterator_throws() {
        LongIterator iterator = this.classUnderTest().longIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void longIterator_throws_non_empty_collection() {
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        LongIterator iterator = iterable.longIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.classUnderTest().forEach(each -> sum[0] += each);
        int size = this.classUnderTest().size();
        long sum1 = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum1, sum[0]);
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.newWith());
        Verify.assertSize(1, this.newWith(3L));
        Verify.assertSize(3, this.newWith(1L, 2L, 3L));
    }

    @Test
    public void count() {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 3 ? 3 : size, iterable.count(LongPredicates.lessThan(4L)));
        Assert.assertEquals(2L, this.newWith(1L, 0L, 2L).count(LongPredicates.greaterThan(0L)));
        Assert.assertEquals(1, this.newWith(1L).count(LongPredicates.alwaysTrue()));
        Assert.assertEquals(0, this.newWith(1L).count(LongPredicates.alwaysFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1L, -1L, 2L).anySatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.newWith(1L, -1L, 2L).anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWith(-1L, -1L, -2L, 31L, 32L).anySatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertTrue(this.newWith(2L, -1L, -2L, 31L, 32L).anySatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.newWith(1L, -1L, 31L, 32L).anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWith(32L).anySatisfy(LongPredicates.greaterThan(0L)));
        LongIterable iterable = this.newWith(0L, 1L, 2L);
        Assert.assertTrue(iterable.anySatisfy(value -> value < 3L));
        Assert.assertFalse(iterable.anySatisfy(LongPredicates.greaterThan(3L)));
        LongIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(LongPredicates.greaterThan(3L)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(LongPredicates.lessThan(3L)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newWith(1L, 0L, 2L).allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertTrue(this.newWith(1L, 2L, 3L).allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.newWith(1L, 0L, 31L, 32L).allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.newWith(1L, 0L, 31L, 32L).allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertTrue(this.newWith(1L, 2L, 31L, 32L).allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.newWith(32L).allSatisfy(LongPredicates.equal(33L)));
        Assert.assertFalse(this.newWith(-32L).allSatisfy(LongPredicates.equal(33L)));
        LongIterable iterable = this.newWith(0L, 1L, 2L);
        Assert.assertFalse(iterable.allSatisfy(value -> 3L < value));
        Assert.assertTrue(iterable.allSatisfy(LongPredicates.lessThan(3L)));
        LongIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(LongPredicates.greaterThan(3L)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(LongPredicates.lessThan(3L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newWith(1L, 0L, 2L).noneSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.newWith(1L, 0L, 2L).noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWith(1L, 2L, 3L).noneSatisfy(LongPredicates.greaterThan(3L)));
        Assert.assertFalse(this.newWith(1L, 0L, 31L, 32L).noneSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.newWith(1L, 0L, 31L, 32L).noneSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertTrue(this.newWith(1L, 2L, 31L, 32L).noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.newWith(32L).noneSatisfy(LongPredicates.greaterThan(0L)));
        LongIterable iterable = this.newWith(0L, 1L, 2L);
        Assert.assertFalse(iterable.noneSatisfy(value -> 1L < value));
        Assert.assertTrue(iterable.noneSatisfy(LongPredicates.greaterThan(3L)));
        LongIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size <= 3, iterable1.noneSatisfy(LongPredicates.greaterThan(3L)));
        Assert.assertEquals(size == 0, iterable1.noneSatisfy(LongPredicates.lessThan(3L)));
    }

    @Test
    public void collect() {
        LongToObjectFunction<Long> function = parameter -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 2L), this.newWith(1L, 2L, 3L).collect(function));
        LongIterable iterable = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 1L, 2L, 2L, 2L), iterable.collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2L), this.newWith(3L).collect(function));
    }

    @Test
    public void collectWithTarget() {
        LongToObjectFunction<Long> function = parameter -> parameter - 1;
        Assert.assertEquals(Bags.mutable.with(0L, 1L, 2L), this.newWith(1L, 2L, 3L).collect(function, Bags.mutable.empty()));
        LongIterable iterable = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(Sets.mutable.with(0L, 1L, 2L), iterable.collect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().collect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2L), this.newWith(3L).collect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectWithTarget() {
        LongToObjectFunction<List<Long>> function = parameter -> Lists.mutable.with(parameter - 1);
        Assert.assertEquals(Bags.mutable.with(0L, 1L, 2L), this.newWith(1L, 2L, 3L).flatCollect(function, Bags.mutable.empty()));
        LongIterable iterable = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(Sets.mutable.with(0L, 1L, 2L), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2L), this.newWith(3L).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectIterableWithTarget() {
        LongToObjectFunction<Iterable<Long>> function = parameter -> Lists.mutable.with(parameter - 1).asLazy();
        Assert.assertEquals(Bags.mutable.with(0L, 1L, 2L), this.newWith(1L, 2L, 3L).flatCollect(function, Bags.mutable.empty()));
        LongIterable iterable = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(Sets.mutable.with(0L, 1L, 2L), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2L), this.newWith(3L).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToLists() {
        LongIterable iterable = this.newWith(1L, 2L);
        Assert.assertEquals(BooleanLists.mutable.with(true, true), iterable.collectBoolean(each -> true, BooleanLists.mutable.empty()));
        Assert.assertEquals(ByteLists.mutable.with((byte) 1, (byte) 1), iterable.collectByte(each -> (byte) 1, ByteLists.mutable.empty()));
        Assert.assertEquals(CharLists.mutable.with('a', 'a'), iterable.collectChar(each -> 'a', CharLists.mutable.empty()));
        Assert.assertEquals(ShortLists.mutable.with((short) 1, (short) 1), iterable.collectShort(each -> (short) 1, ShortLists.mutable.empty()));
        Assert.assertEquals(IntLists.mutable.with(1, 1), iterable.collectInt(each -> 1, IntLists.mutable.empty()));
        Assert.assertEquals(FloatLists.mutable.with(1.0f, 1.0f), iterable.collectFloat(each -> 1.0f, FloatLists.mutable.empty()));
        Assert.assertEquals(LongLists.mutable.with(1L, 1L), iterable.collectLong(each -> 1L, LongLists.mutable.empty()));
        Assert.assertEquals(DoubleLists.mutable.with(1.0d, 1.0d), iterable.collectDouble(each -> 1.0d, DoubleLists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToSets() {
        LongIterable iterable = this.newWith(1L, 2L);
        Assert.assertEquals(BooleanSets.mutable.with(false), iterable.collectBoolean(each -> false, BooleanSets.mutable.empty()));
        Assert.assertEquals(ByteSets.mutable.with((byte) 2), iterable.collectByte(each -> (byte) 2, ByteSets.mutable.empty()));
        Assert.assertEquals(CharSets.mutable.with('b'), iterable.collectChar(each -> 'b', CharSets.mutable.empty()));
        Assert.assertEquals(ShortSets.mutable.with((short) 2), iterable.collectShort(each -> (short) 2, ShortSets.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(2), iterable.collectInt(each -> 2, IntSets.mutable.empty()));
        Assert.assertEquals(FloatSets.mutable.with(2.0f), iterable.collectFloat(each -> 2.0f, FloatSets.mutable.empty()));
        Assert.assertEquals(LongSets.mutable.with(2L), iterable.collectLong(each -> 2L, LongSets.mutable.empty()));
        Assert.assertEquals(DoubleSets.mutable.with(2.0d), iterable.collectDouble(each -> 2.0d, DoubleSets.mutable.empty()));
    }

    @Test
    public void select() {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(LongPredicates.lessThan(4L)));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(LongPredicates.lessThan(3L)));
        LongIterable iterable1 = this.newWith(0L, 1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(this.newMutableCollectionWith(0L, 1L), iterable1.select(LongPredicates.lessThan(2L)));
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 3L, 3L, 3L), iterable1.select(LongPredicates.greaterThan(1L)));
        LongIterable iterable2 = this.newWith(0L);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.select(LongPredicates.alwaysTrue()));
        Verify.assertSize(0, iterable2.select(LongPredicates.alwaysFalse()));
    }

    @Test
    public void selectWithTarget() {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(LongPredicates.lessThan(4L), LongSets.mutable.empty()));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(LongPredicates.lessThan(3L), LongSets.mutable.empty()));
        LongIterable iterable1 = this.newWith(0L, 1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(LongSets.mutable.with(0L, 1L), iterable1.select(LongPredicates.lessThan(2L), LongSets.mutable.empty()));
        Assert.assertEquals(LongSets.mutable.with(2L, 3L), iterable1.select(LongPredicates.greaterThan(1L), LongSets.mutable.empty()));
    }

    @Test
    public void reject() {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(LongPredicates.lessThan(4L)));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(LongPredicates.lessThan(3L)));
        LongIterable iterable1 = this.newWith(0L, 1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(this.newMutableCollectionWith(2L, 2L, 3L, 3L, 3L), iterable1.reject(LongPredicates.lessThan(2L)));
        Assert.assertEquals(this.newMutableCollectionWith(0L, 1L), iterable1.reject(LongPredicates.greaterThan(1L)));
        LongIterable iterable2 = this.newWith(0L);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.reject(LongPredicates.alwaysFalse()));
        Verify.assertSize(0, iterable2.reject(LongPredicates.alwaysTrue()));
    }

    @Test
    public void rejectWithTarget() {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(LongPredicates.lessThan(4L), LongSets.mutable.empty()));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(LongPredicates.lessThan(3L), LongSets.mutable.empty()));
        LongIterable iterable1 = this.newWith(0L, 1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(LongSets.mutable.with(2L, 3L), iterable1.reject(LongPredicates.lessThan(2L), LongSets.mutable.empty()));
        Assert.assertEquals(LongSets.mutable.with(0L, 1L), iterable1.reject(LongPredicates.greaterThan(1L), LongSets.mutable.empty()));
    }

    @Test
    public void detectIfNone() {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(LongPredicates.equal(4L), 0L));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(LongPredicates.equal(2L), 0L));
        Assert.assertEquals(size > 0 ? 1L : 0L, iterable.detectIfNone(LongPredicates.lessThan(2L), 0L));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
        LongIterable iterable1 = this.newWith(0L, 1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(0L, iterable1.detectIfNone(LongPredicates.lessThan(1L), 4L));
        Assert.assertEquals(3L, iterable1.detectIfNone(LongPredicates.greaterThan(2L), 4L));
        Assert.assertEquals(4L, iterable1.detectIfNone(LongPredicates.greaterThan(4L), 4L));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, this.newWith(-1L, -2L, 9L).max());
        Assert.assertEquals(-1L, this.newWith(-1L, -2L, -9L).max());
        Assert.assertEquals(32L, this.newWith(1L, 0L, 9L, 30L, 31L, 32L).max());
        Assert.assertEquals(32L, this.newWith(-1L, 0L, 9L, 30L, 31L, 32L).max());
        Assert.assertEquals(31L, this.newWith(31L, 0L, 30L).max());
        Assert.assertEquals(39L, this.newWith(32L, 39L, 35L).max());
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyCollection() {
        this.newWith().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(-2L, this.newWith(-1L, -2L, 9L).min());
        Assert.assertEquals(0L, this.newWith(1L, 0L, 9L, 30L, 31L, 32L).min());
        Assert.assertEquals(-1L, this.newWith(-1L, 0L, 9L, 30L, 31L, 32L).min());
        Assert.assertEquals(31L, this.newWith(31L, 32L, 33L).min());
        Assert.assertEquals(32L, this.newWith(32L, 39L, 35L).min());
        Assert.assertEquals(1L, this.classUnderTest().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyCollection() {
        this.newWith().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, this.newWith().minIfEmpty(5L));
        Assert.assertEquals(0L, this.newWith().minIfEmpty(0L));
        Assert.assertEquals(0L, this.newWith(1L, 0L, 9L, 7L).minIfEmpty(5L));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5L : 1L, this.classUnderTest().minIfEmpty(5L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.newWith().maxIfEmpty(5L));
        Assert.assertEquals(0L, this.newWith().maxIfEmpty(0L));
        Assert.assertEquals(9L, this.newWith(1L, 0L, 9L, 7L).maxIfEmpty(5L));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5L : size, this.classUnderTest().maxIfEmpty(5L));
    }

    @Test
    public void sum() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().sum());
        Assert.assertEquals(10L, this.newWith(0L, 1L, 2L, 3L, 4L).sum());
        Assert.assertEquals(93L, this.newWith(30L, 31L, 32L).sum());
    }

    @Test
    public void summaryStatistics() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().summaryStatistics().getSum());
        Assert.assertEquals(10L, this.newWith(0L, 1L, 2L, 3L, 4L).summaryStatistics().getSum());
        Assert.assertEquals(93L, this.newWith(30L, 31L, 32L).summaryStatistics().getSum());
    }

    @Test
    public void average() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1L, 2L, 3L, 4L).average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1L, 2L, 3L, 4L).average(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30L, 30L, 31L, 31L, 32L, 32L).average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.newWith().average();
    }

    /**
     * @since 9.0
     */
    @Test
    public void averageIfEmpty() {
        Assert.assertEquals(2.5, this.newWith().averageIfEmpty(2.5), 0.0);
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1L, 2L, 3L, 4L).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1L, 2L, 3L, 4L).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30L, 30L, 31L, 31L, 32L, 32L).averageIfEmpty(0.0), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(1.0, this.newWith(1L).median(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1L, 2L, 3L, 4L).median(), 0.0);
        Assert.assertEquals(3.0, this.newWith(1L, 2L, 3L, 4L, 5L).median(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30L, 30L, 31L, 31L, 32L).median(), 0.0);
        Assert.assertEquals(30.5, this.newWith(1L, 30L, 30L, 31L, 31L, 32L).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.newWith().median();
    }

    /**
     * @since 9.0
     */
    @Test
    public void medianIfEmpty() {
        Assert.assertEquals(2.5, this.newWith().medianIfEmpty(2.5), 0.0);
        Assert.assertEquals(1.0, this.newWith(1L).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1L, 2L, 3L, 4L).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(3.0, this.newWith(1L, 2L, 3L, 4L, 5L).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30L, 30L, 31L, 31L, 32L).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(30.5, this.newWith(1L, 30L, 30L, 31L, 31L, 32L).medianIfEmpty(0.0), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().toArray().length);
        LongIterable iterable = this.newWith(1L, 2L);
        Assert.assertTrue(Arrays.equals(new long[] { 1L, 2L }, iterable.toArray()) || Arrays.equals(new long[] { 2L, 1L }, iterable.toArray()));
        Assert.assertTrue(Arrays.equals(new long[] { 0L, 1L }, this.newWith(0L, 1L).toArray()) || Arrays.equals(new long[] { 1L, 0L }, this.newWith(0L, 1L).toArray()));
        Assert.assertTrue(Arrays.equals(new long[] { 1L, 31L }, this.newWith(1L, 31L).toArray()) || Arrays.equals(new long[] { 31L, 1L }, this.newWith(1L, 31L).toArray()));
        Assert.assertTrue(Arrays.equals(new long[] { 31L, 35L }, this.newWith(31L, 35L).toArray()) || Arrays.equals(new long[] { 35L, 31L }, this.newWith(31L, 35L).toArray()));
        Assert.assertArrayEquals(new long[] {}, this.newWith().toArray());
        Assert.assertArrayEquals(new long[] { 32L }, this.newWith(32L).toArray());
    }

    @Test
    public void toArrayWithTargetArray() {
        long[] originalAsSortedArray = this.classUnderTest().toSortedArray();
        long[] target = new long[this.classUnderTest().size()];
        Assert.assertSame(target, this.classUnderTest().toArray(target));
        Arrays.sort(target);
        Assert.assertTrue(Arrays.equals(originalAsSortedArray, target));
        if (this.classUnderTest().size() > 0) {
            long[] targetTooSmall = new long[this.classUnderTest().size() - 1];
            long[] result = this.classUnderTest().toArray(targetTooSmall);
            Assert.assertNotSame(targetTooSmall, result);
            Arrays.sort(result);
            Assert.assertTrue(Arrays.equals(this.classUnderTest().toSortedArray(), result));
        }
        long[] targetTooBig = new long[this.classUnderTest().size() + 1];
        long[] bigResult = this.classUnderTest().toArray(targetTooBig);
        Assert.assertSame(targetTooBig, bigResult);
        Arrays.sort(targetTooBig);
        for (int i = 0; i < originalAsSortedArray.length; i++) {
            Assert.assertEquals(originalAsSortedArray[i], bigResult[i + 1]);
        }
    }

    @Test
    public void toSortedArray() {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        Assert.assertArrayEquals(array, iterable.toSortedArray());
        Assert.assertArrayEquals(new long[] { 1L, 3L, 7L, 9L }, this.newWith(3L, 1L, 9L, 7L).toSortedArray());
    }

    @Test
    public void testEquals() {
        LongIterable iterable1 = this.newWith(1L, 2L, 3L, 4L);
        LongIterable iterable2 = this.newWith(1L, 2L, 3L, 4L);
        LongIterable iterable3 = this.newWith(5L, 6L, 7L, 8L);
        LongIterable iterable4 = this.newWith(5L, 6L, 7L);
        LongIterable iterable5 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        LongIterable iterable6 = this.newWith(1L, 31L, 32L);
        LongIterable iterable7 = this.newWith(35L, 31L, 1L);
        LongIterable iterable8 = this.newWith(32L, 31L, 1L, 50L);
        LongIterable iterable9 = this.newWith(0L, 1L, 2L);
        LongIterable iterable10 = this.newWith(0L, 1L, 3L);
        LongIterable iterable11 = this.newWith(3L, 1L, 2L);
        LongIterable iterable12 = this.newWith(3L);
        Verify.assertEqualsAndHashCode(iterable1, iterable2);
        Verify.assertPostSerializedEqualsAndHashCode(iterable1);
        Verify.assertPostSerializedEqualsAndHashCode(iterable12);
        Verify.assertPostSerializedEqualsAndHashCode(iterable5);
        Verify.assertPostSerializedEqualsAndHashCode(iterable6);
        Assert.assertNotEquals(iterable12, iterable11);
        Assert.assertNotEquals(iterable1, iterable3);
        Assert.assertNotEquals(iterable1, iterable4);
        Assert.assertNotEquals(iterable6, iterable7);
        Assert.assertNotEquals(iterable6, iterable8);
        Assert.assertNotEquals(iterable9, iterable10);
        Assert.assertNotEquals(iterable9, iterable11);
        Assert.assertNotEquals(this.newWith(), this.newWith(100L));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(this.newObjectCollectionWith(1L, 2L, 3L).hashCode(), this.newWith(1L, 2L, 3L).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 31L).hashCode(), this.newWith(0L, 1L, 31L).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32L).hashCode(), this.newWith(32L).hashCode());
        Assert.assertNotEquals(this.newObjectCollectionWith(32L).hashCode(), this.newWith(0L).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(31L, 32L, 50L).hashCode(), this.newWith(31L, 32L, 50L).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32L, 50L, 60L).hashCode(), this.newWith(32L, 50L, 60L).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[1]", this.newWith(1L).toString());
        Assert.assertEquals("[31]", this.newWith(31L).toString());
        Assert.assertEquals("[32]", this.newWith(32L).toString());
        LongIterable iterable = this.newWith(1L, 2L);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        LongIterable iterable1 = this.newWith(0L, 31L);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        LongIterable iterable2 = this.newWith(31L, 32L);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        LongIterable iterable3 = this.newWith(32L, 33L);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        LongIterable iterable4 = this.newWith(0L, 1L);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        LongIterable iterable = this.classUnderTest();
        Assert.assertEquals("1", this.newWith(1L).makeString("/"));
        Assert.assertEquals("31", this.newWith(31L).makeString());
        Assert.assertEquals("32", this.newWith(32L).makeString());
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        LongIterable iterable1 = this.newWith(0L, 31L);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        LongIterable iterable2 = this.newWith(31L, 32L);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        LongIterable iterable3 = this.newWith(32L, 33L);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        LongIterable iterable4 = this.newWith(1L, 2L);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        LongIterable iterable5 = this.newWith(0L, 1L);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0, 1") || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0/1]") || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0/1") || iterable5.makeString("/").equals("1/0"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", ", ", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        LongIterable iterable = this.newWith(1L, 2L);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31L).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32L).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        LongIterable iterable1 = this.newWith(0L, 31L);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        LongIterable iterable2 = this.newWith(31L, 32L);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        LongIterable iterable4 = this.newWith(32L, 33L);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        LongIterable iterable5 = this.newWith(0L, 1L);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0, 1".equals(appendable10.toString()) || "1, 0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0/1".equals(appendable11.toString()) || "1/0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0/1]".equals(appendable12.toString()) || "[1/0]".equals(appendable12.toString()));
    }

    @Test
    public void toList() {
        LongIterable iterable = this.newWith(31L, 32L);
        Assert.assertTrue(LongArrayList.newListWith(31L, 32L).equals(iterable.toList()) || LongArrayList.newListWith(32L, 31L).equals(iterable.toList()));
        Assert.assertEquals(LongArrayList.newListWith(0L), this.newWith(0L).toList());
        Assert.assertEquals(LongArrayList.newListWith(31L), this.newWith(31L).toList());
        Assert.assertEquals(LongArrayList.newListWith(32L), this.newWith(32L).toList());
        Assert.assertEquals(new LongArrayList(), this.newWith().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(LongArrayList.newListWith(), this.newWith().toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWith(1L).toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 31L), this.newWith(0L, 31L, 1L).toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 31L, 32L), this.newWith(0L, 31L, 32L, 1L).toSortedList());
    }

    @Test
    public void toSortedListByComparator() {
        LongIterable iterable = this.newWith(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        // odd/even comparator
        MutableLongList result = iterable.toSortedList((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertNotSame(iterable, result);
        result.collectBoolean(e -> e % 2 == 0, BooleanLists.mutable.of()).forEachWithIndex((e, i) -> Assert.assertEquals("index " + i, i < 5, e));
    }

    @Test
    public void toSortedListByFunctionNaturalOrder() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        LongIterable index = this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L);
        MutableLongList result = index.toSortedListBy(i -> list.get((int) i));
        Assert.assertNotSame(index, result);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 0L, 4L, 3L), result);
    }

    @Test
    public void toSortedListByFunctionWithComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        LongIterable index = this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L);
        MutableLongList result = index.toSortedListBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertNotSame(index, result);
        Assert.assertEquals(LongArrayList.newListWith(3L, 4L, 0L, 2L, 1L), result);
    }

    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(LongHashSet.newSetWith(1L), this.newWith(1L).toSet());
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L).toSet());
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L), this.newWith(0L, 1L, 31L).toSet());
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 31L, 32L), this.newWith(0L, 1L, 31L, 32L).toSet());
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), this.newWith(1L, 2L, 2L, 3L, 3L, 3L).toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(new LongHashBag(), this.newWith().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(1L), this.newWith(1L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), this.newWith(1L, 2L, 3L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 2L, 3L, 3L, 3L), this.newWith(1L, 2L, 2L, 3L, 3L, 3L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L, 32L), this.newWith(0L, 1L, 31L, 32L).toBag());
    }

    @Test
    public void asLazy() {
        LongIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable.asLazy());
        LongIterable iterable1 = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(iterable1.toBag(), iterable1.asLazy().toBag());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable1.asLazy());
        LongIterable iterable2 = this.newWith(1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(iterable2.toBag(), iterable2.asLazy().toBag());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable2.asLazy());
        LongIterable iterable3 = this.newWith();
        Assert.assertEquals(iterable3.toBag(), iterable3.asLazy().toBag());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable3.asLazy());
        LongIterable iterable4 = this.newWith(1L);
        Assert.assertEquals(iterable4.toBag(), iterable4.asLazy().toBag());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable4.asLazy());
    }

    @Test
    public void injectInto() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        Long sum1 = iterable1.injectInto(Long.valueOf(0L), (Long result, long value) -> Long.valueOf((long) (result + value + 1)));
        Assert.assertEquals(Long.valueOf(36L), sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        Long sum2 = iterable2.injectInto(Long.valueOf(0L), (Long result, long value) -> Long.valueOf((long) (result + value + 1)));
        Assert.assertEquals(Long.valueOf(37L), sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        Long sum3 = iterable3.injectInto(Long.valueOf(0L), (Long result, long value) -> Long.valueOf((long) (result + value + 1)));
        Assert.assertEquals(Long.valueOf(38L), sum3);
    }

    @Test
    public void injectIntoBoolean() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        boolean sum1 = iterable1.injectIntoBoolean(false, (boolean result, long value) -> (boolean) (result || value == 0L));
        Assert.assertEquals(true, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        boolean sum2 = iterable2.injectIntoBoolean(false, (boolean result, long value) -> (boolean) (result || value == 0L));
        Assert.assertEquals(false, sum2);
    }

    @Test
    public void injectIntoByte() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        byte sum1 = iterable1.injectIntoByte((byte) 0, (byte result, long value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 36, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        byte sum2 = iterable2.injectIntoByte((byte) 0, (byte result, long value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 37, sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        byte sum3 = iterable3.injectIntoByte((byte) 0, (byte result, long value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 38, sum3);
    }

    @Test
    public void injectIntoChar() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        char sum1 = iterable1.injectIntoChar((char) 0, (char result, long value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 36, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        char sum2 = iterable2.injectIntoChar((char) 0, (char result, long value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 37, sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        char sum3 = iterable3.injectIntoChar((char) 0, (char result, long value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 38, sum3);
    }

    @Test
    public void injectIntoShort() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        short sum1 = iterable1.injectIntoShort((short) 0, (short result, long value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 36, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        short sum2 = iterable2.injectIntoShort((short) 0, (short result, long value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 37, sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        short sum3 = iterable3.injectIntoShort((short) 0, (short result, long value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 38, sum3);
    }

    @Test
    public void injectIntoInt() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        int sum1 = iterable1.injectIntoInt(0, (int result, long value) -> (int) (result + value + 1));
        Assert.assertEquals(36, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        int sum2 = iterable2.injectIntoInt(0, (int result, long value) -> (int) (result + value + 1));
        Assert.assertEquals(37, sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        int sum3 = iterable3.injectIntoInt(0, (int result, long value) -> (int) (result + value + 1));
        Assert.assertEquals(38, sum3);
    }

    @Test
    public void injectIntoFloat() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        float sum1 = iterable1.injectIntoFloat(0.0f, (float result, long value) -> (float) (result + value + 1));
        Assert.assertEquals(36.0f, sum1, 0.001);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        float sum2 = iterable2.injectIntoFloat(0.0f, (float result, long value) -> (float) (result + value + 1));
        Assert.assertEquals(37.0f, sum2, 0.001);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        float sum3 = iterable3.injectIntoFloat(0.0f, (float result, long value) -> (float) (result + value + 1));
        Assert.assertEquals(38.0f, sum3, 0.001);
    }

    @Test
    public void injectIntoLong() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        long sum1 = iterable1.injectIntoLong(0L, (long result, long value) -> (long) (result + value + 1));
        Assert.assertEquals(36L, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        long sum2 = iterable2.injectIntoLong(0L, (long result, long value) -> (long) (result + value + 1));
        Assert.assertEquals(37L, sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        long sum3 = iterable3.injectIntoLong(0L, (long result, long value) -> (long) (result + value + 1));
        Assert.assertEquals(38L, sum3);
    }

    @Test
    public void injectIntoDouble() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        double sum1 = iterable1.injectIntoDouble(0.0, (double result, long value) -> (double) (result + value + 1));
        Assert.assertEquals(36.0, sum1, 0.001);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        double sum2 = iterable2.injectIntoDouble(0.0, (double result, long value) -> (double) (result + value + 1));
        Assert.assertEquals(37.0, sum2, 0.001);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        double sum3 = iterable3.injectIntoDouble(0.0, (double result, long value) -> (double) (result + value + 1));
        Assert.assertEquals(38.0, sum3, 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void reduceOnEmptyThrows() {
        this.newWith().reduce((long result, long value) -> result + value + 1L);
    }

    @Test
    public void reduce() {
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        long sum1 = iterable1.reduce((long result, long value) -> result + value + 1L);
        Assert.assertEquals(35L, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        long sum2 = iterable2.reduce((long result, long value) -> result + value + 1L);
        Assert.assertEquals(36L, sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        long sum3 = iterable3.reduce((long result, long value) -> result + value + 1L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void reduceIfEmpty() {
        long empty1 = this.newWith().reduceIfEmpty((long result, long value) -> result + value + 1L, 1L);
        Assert.assertEquals(1L, empty1);
        long empty2 = this.newWith().reduceIfEmpty((long result, long value) -> result + value + 1L, 0L);
        Assert.assertEquals(0L, empty2);
        LongIterable iterable1 = this.newWith(0L, 2L, 31L);
        long sum1 = iterable1.reduceIfEmpty((long result, long value) -> result + value + 1L, 0L);
        Assert.assertEquals(35L, sum1);
        LongIterable iterable2 = this.newWith(1L, 2L, 31L);
        long sum2 = iterable2.reduceIfEmpty((long result, long value) -> result + value + 1L, 0L);
        Assert.assertEquals(36L, sum2);
        LongIterable iterable3 = this.newWith(0L, 1L, 2L, 31L);
        long sum3 = iterable3.reduceIfEmpty((long result, long value) -> result + value + 1L, 0L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void chunk() {
        LongIterable iterable = this.newWith(0L, 1L, 2L, 3L, 4L, 5L);
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0L), this.newMutableCollectionWith(1L), this.newMutableCollectionWith(2L), this.newMutableCollectionWith(3L), this.newMutableCollectionWith(4L), this.newMutableCollectionWith(5L)).toSet(), iterable.chunk(1).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0L, 1L), this.newMutableCollectionWith(2L, 3L), this.newMutableCollectionWith(4L, 5L)).toSet(), iterable.chunk(2).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0L, 1L, 2L), this.newMutableCollectionWith(3L, 4L, 5L)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0L, 1L, 2L, 3L), this.newMutableCollectionWith(4L, 5L)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L, 5L)).toSet(), iterable.chunk(6).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L, 5L)).toSet(), iterable.chunk(7).toSet());
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0L)), this.newWith(0L).chunk(1));
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newMutableCollectionWith().chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newCollectionWith, this.description("newCollectionWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newCollection, this.description("newCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::tap, this.description("tap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllArray, this.description("containsAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAnyArray, this.description("containsAnyArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAnyIterable, this.description("containsAnyIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsNoneArray, this.description("containsNoneArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsNoneIterable, this.description("containsNoneIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator, this.description("longIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::longIterator_throws, this.description("longIterator_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::longIterator_throws_non_empty_collection, this.description("longIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithTarget, this.description("collectWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollectWithTarget, this.description("flatCollectWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollectIterableWithTarget, this.description("flatCollectIterableWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectPrimitivesToLists, this.description("collectPrimitivesToLists"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectPrimitivesToSets, this.description("collectPrimitivesToSets"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithTarget, this.description("selectWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWithTarget, this.description("rejectWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_throws_emptyCollection, this.description("max_throws_emptyCollection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_throws_emptyCollection, this.description("min_throws_emptyCollection"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minIfEmpty, this.description("minIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxIfEmpty, this.description("maxIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::summaryStatistics, this.description("summaryStatistics"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::average, this.description("average"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::averageThrowsOnEmpty, this.description("averageThrowsOnEmpty"), java.lang.ArithmeticException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::averageIfEmpty, this.description("averageIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::median, this.description("median"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::medianThrowsOnEmpty, this.description("medianThrowsOnEmpty"), java.lang.ArithmeticException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::medianIfEmpty, this.description("medianIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArrayWithTargetArray, this.description("toArrayWithTargetArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testHashCode, this.description("testHashCode"));
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
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListByComparator, this.description("toSortedListByComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListByFunctionNaturalOrder, this.description("toSortedListByFunctionNaturalOrder"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListByFunctionWithComparator, this.description("toSortedListByFunctionWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoBoolean, this.description("injectIntoBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoByte, this.description("injectIntoByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoChar, this.description("injectIntoChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoShort, this.description("injectIntoShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoInt, this.description("injectIntoInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoFloat, this.description("injectIntoFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoLong, this.description("injectIntoLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoDouble, this.description("injectIntoDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::reduceOnEmptyThrows, this.description("reduceOnEmptyThrows"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reduce, this.description("reduce"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reduceIfEmpty, this.description("reduceIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk, this.description("chunk"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractLongIterableTestCase implementation();
    }
}
