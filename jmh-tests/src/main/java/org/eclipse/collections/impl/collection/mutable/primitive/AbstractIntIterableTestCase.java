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
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
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
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link IntIterable}s
 * This file was automatically generated from template file abstractPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractIntIterableTestCase {

    protected abstract IntIterable classUnderTest();

    protected abstract IntIterable newWith(int... elements);

    protected abstract IntIterable newMutableCollectionWith(int... elements);

    protected abstract RichIterable<Integer> newObjectCollectionWith(Integer... elements);

    @Test
    public void newCollectionWith() {
        IntIterable iterable = this.newWith(1, 2, 3);
        Verify.assertSize(3, iterable);
        Verify.assertSize(4, this.newWith(0, 1, 31, 32));
        Assert.assertTrue(iterable.containsAll(1, 2, 3));
        IntIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll(1, 2, 3));
        IntIterable iterable2 = this.newWith(1);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll(1, 2, 3));
    }

    @Test
    public void newCollection() {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3), this.newWith(1, 2, 3));
        Assert.assertEquals(this.newMutableCollectionWith(0, 1, 31, 32), this.newWith(0, 1, 31, 32));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith(0, 1, 31, 32));
        Verify.assertNotEmpty(this.newWith(0, 1, 2));
        Verify.assertNotEmpty(this.newWith(0, 31));
        Verify.assertNotEmpty(this.newWith(31, 32));
        Verify.assertNotEmpty(this.newWith(32, 33));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith(0, 1, 31, 32).notEmpty());
        Assert.assertTrue(this.newWith(0, 1, 2).notEmpty());
        Assert.assertTrue(this.newWith(0, 31).notEmpty());
        Assert.assertTrue(this.newWith(31, 32).notEmpty());
        Assert.assertTrue(this.newWith(32, 33).notEmpty());
    }

    @Test
    public void tap() {
        MutableIntList tapResult = IntLists.mutable.empty();
        IntIterable collection = this.newWith(14, 2, 30, 31, 32, 35, 0, 1);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void contains() {
        IntIterable iterable = this.newWith(14, 2, 30, 31, 32, 35, 0, 1);
        Assert.assertFalse(iterable.contains(29));
        Assert.assertFalse(iterable.contains(49));
        int[] numbers = { 14, 2, 30, 31, 32, 35, 0, 1 };
        for (int number : numbers) {
            Assert.assertTrue(iterable.contains(number));
        }
        Assert.assertFalse(iterable.contains(-1));
        Assert.assertFalse(iterable.contains(29));
        Assert.assertFalse(iterable.contains(49));
        IntIterable iterable1 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(iterable1.contains(0));
        Assert.assertTrue(iterable1.contains(1));
        Assert.assertTrue(iterable1.contains(2));
        Assert.assertFalse(iterable1.contains(3));
        IntIterable iterable2 = this.classUnderTest();
        for (int each = 1; each <= iterable2.size(); each++) {
            Assert.assertTrue(iterable2.contains(each));
        }
        Assert.assertFalse(iterable2.contains(iterable2.size() + 1));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toArray()));
        Assert.assertFalse(this.classUnderTest().containsAll(this.classUnderTest().size() + 1));
        IntIterable iterable = this.newWith(1, 2, 3);
        Assert.assertTrue(iterable.containsAll(1));
        Assert.assertTrue(iterable.containsAll(1, 2, 3));
        Assert.assertFalse(iterable.containsAll(1, 2, 3, 4));
        Assert.assertFalse(iterable.containsAll(1, 2, 4));
        Assert.assertFalse(iterable.containsAll(4, 5, 6));
        IntIterable iterable1 = this.newWith(14, 2, 30, 32, 35, 0, 1);
        Assert.assertTrue(iterable1.containsAll(14));
        Assert.assertTrue(iterable1.containsAll(35));
        Assert.assertFalse(iterable1.containsAll(-1));
        Assert.assertTrue(iterable1.containsAll(14, 1, 30));
        Assert.assertTrue(iterable1.containsAll(14, 1, 32));
        Assert.assertTrue(iterable1.containsAll(14, 1, 35));
        Assert.assertFalse(iterable1.containsAll(0, 2, 35, -1));
        Assert.assertFalse(iterable1.containsAll(31, -1));
        IntIterable iterable2 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(iterable2.containsAll(0));
        Assert.assertTrue(iterable2.containsAll(0, 0, 0));
        Assert.assertTrue(iterable2.containsAll(0, 1, 1));
        Assert.assertTrue(iterable2.containsAll(0, 1, 2));
        Assert.assertFalse(iterable2.containsAll(0, 1, 2, 3, 4));
        Assert.assertFalse(iterable2.containsAll(3, 4));
        int size = 33;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        IntIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(1, 2, 3));
        Assert.assertTrue(iterable3.containsAll());
        Assert.assertFalse(iterable3.containsAll(3, 4, 5, 33, 34));
        Assert.assertTrue(iterable3.containsAll(array));
        IntIterable iterable4 = IntSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(1, 2, 3));
        Assert.assertTrue(iterable4.containsAll());
        Assert.assertFalse(iterable4.containsAll(3, 4, 5, 33, 34));
        Assert.assertTrue(iterable4.containsAll(array));
    }

    @Test
    public void containsAllIterable() {
        IntIterable source = this.classUnderTest();
        Assert.assertTrue(source.containsAll(this.classUnderTest()));
        Assert.assertFalse(source.containsAll(IntArrayList.newListWith(source.size() + 1)));
        IntIterable iterable = this.newWith(1, 2, 3);
        Assert.assertTrue(this.newWith().containsAll(new IntArrayList()));
        Assert.assertFalse(this.newWith().containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(1, 2, 3)));
        Assert.assertFalse(iterable.containsAll(IntArrayList.newListWith(1, 2, 3, 4)));
        Assert.assertFalse(iterable.containsAll(IntArrayList.newListWith(1, 2, 4)));
        Assert.assertFalse(iterable.containsAll(IntArrayList.newListWith(4, 5, 6)));
        IntIterable iterable1 = this.newWith(14, 2, 30, 32, 35, 0, 1);
        Assert.assertTrue(iterable1.containsAll(IntHashSet.newSetWith(14)));
        Assert.assertTrue(iterable1.containsAll(IntHashSet.newSetWith(35)));
        Assert.assertFalse(iterable1.containsAll(IntHashSet.newSetWith(-1)));
        Assert.assertTrue(iterable1.containsAll(IntHashSet.newSetWith(14, 1, 30)));
        Assert.assertTrue(iterable1.containsAll(IntHashSet.newSetWith(14, 1, 32)));
        Assert.assertTrue(iterable1.containsAll(IntHashSet.newSetWith(14, 1, 35)));
        Assert.assertFalse(iterable1.containsAll(IntHashSet.newSetWith(0, 2, 35, -1)));
        Assert.assertFalse(iterable1.containsAll(IntHashSet.newSetWith(31, -1)));
        IntIterable iterable2 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(iterable2.containsAll(IntArrayList.newListWith(0)));
        Assert.assertTrue(iterable2.containsAll(IntArrayList.newListWith(0, 0, 0)));
        Assert.assertTrue(iterable2.containsAll(IntArrayList.newListWith(0, 1, 1)));
        Assert.assertTrue(iterable2.containsAll(IntArrayList.newListWith(0, 1, 2)));
        Assert.assertFalse(iterable2.containsAll(IntArrayList.newListWith(0, 1, 2, 3, 4)));
        Assert.assertFalse(iterable2.containsAll(IntArrayList.newListWith(3, 4)));
        int size = 33;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        IntIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(IntLists.immutable.with(1, 2, 3)));
        Assert.assertTrue(iterable3.containsAll(IntLists.mutable.empty()));
        Assert.assertFalse(iterable3.containsAll(IntLists.mutable.with(3, 4, 5, 33, 34)));
        Assert.assertTrue(iterable3.containsAll(IntLists.immutable.with(array)));
        IntIterable iterable4 = IntSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(IntLists.immutable.with(1, 2, 3)));
        Assert.assertTrue(iterable4.containsAll(IntLists.mutable.empty()));
        Assert.assertFalse(iterable4.containsAll(IntLists.mutable.with(3, 4, 5, 33, 34)));
        Assert.assertTrue(iterable4.containsAll(IntLists.immutable.with(array)));
    }

    @Test
    public void containsAnyArray() {
        IntIterable iterable = this.newWith(1, 2, 3, 4, 5);
        Assert.assertTrue(iterable.containsAny(1, 1, 1));
        Assert.assertFalse(iterable.containsAny());
        Assert.assertTrue(iterable.containsAny(1, 2, 3));
        Assert.assertFalse(iterable.containsAny(6, 7, 8));
        IntIterable iterable2 = this.newWith(0, 1, 3, 7);
        Assert.assertTrue(iterable2.containsAny(3, 3, 1, 9));
        Assert.assertFalse(iterable2.containsAny());
        Assert.assertTrue(iterable2.containsAny(-1, 3, 5));
        Assert.assertFalse(iterable2.containsAny(2, 4, 6));
        int size = 33;
        int[] array = new int[size];
        int[] unmatched = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            unmatched[i] = i + 34;
        }
        IntIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(array));
        Assert.assertFalse(iterable3.containsAny(unmatched));
        IntIterable iterable4 = IntSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(array));
        Assert.assertFalse(iterable4.containsAny(unmatched));
        IntIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny());
        Assert.assertFalse(emptyIterable.containsAny(0, 0));
        Assert.assertFalse(emptyIterable.containsAny(-1));
        Assert.assertFalse(emptyIterable.containsAny(1, 2, 3));
    }

    @Test
    public void containsAnyIterable() {
        IntIterable iterable = this.newWith(1, 2, 3, 4, 5);
        Assert.assertTrue(iterable.containsAny(IntLists.immutable.with(1, 1, 1)));
        Assert.assertFalse(iterable.containsAny(IntLists.mutable.empty()));
        Assert.assertTrue(iterable.containsAny(IntLists.immutable.with(1, 2, 3)));
        Assert.assertFalse(iterable.containsAny(IntLists.mutable.with(6, 7, 8)));
        IntIterable iterable2 = this.newWith(0, 1, 3, 7);
        Assert.assertTrue(iterable2.containsAny(IntSets.immutable.with(3, 3, 1, 9)));
        Assert.assertFalse(iterable2.containsAny(IntSets.mutable.empty()));
        Assert.assertTrue(iterable2.containsAny(IntSets.immutable.with(-1, 3, 5)));
        Assert.assertFalse(iterable2.containsAny(IntSets.mutable.with(2, 4, 6)));
        IntIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny(IntLists.mutable.empty()));
        Assert.assertFalse(emptyIterable.containsAny(IntLists.immutable.with(0, 0)));
        Assert.assertFalse(emptyIterable.containsAny(IntLists.mutable.with(-1)));
        Assert.assertFalse(emptyIterable.containsAny(IntLists.immutable.with(1, 2, 3)));
        int size = 33;
        int[] array = new int[size];
        int[] unmatched = new int[size];
        int[] bigger = new int[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            bigger[i] = i + 1;
            unmatched[i] = i + 34;
        }
        bigger[size - 1] = 33;
        IntIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(IntLists.immutable.with(array)));
        Assert.assertFalse(iterable3.containsAny(IntLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsAny(IntSets.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsAny(IntSets.mutable.with(bigger)));
        IntIterable iterable4 = IntSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(IntLists.immutable.with(array)));
        Assert.assertFalse(iterable4.containsAny(IntLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable4.containsAny(IntSets.immutable.with(array)));
        Assert.assertTrue(iterable4.containsAny(IntSets.immutable.with(bigger)));
    }

    @Test
    public void containsNoneArray() {
        IntIterable iterable = this.newWith(1, 2, 3);
        Assert.assertFalse(iterable.containsNone(1, 1));
        Assert.assertTrue(iterable.containsNone());
        Assert.assertFalse(iterable.containsNone(3, 4, 5, 6));
        Assert.assertTrue(iterable.containsNone(7, 8, 11));
        IntIterable iterable2 = this.newWith(0, 1, 3, 7);
        Assert.assertTrue(iterable2.containsNone(2, 4, 6));
        Assert.assertTrue(iterable2.containsNone());
        Assert.assertFalse(iterable2.containsNone(-1, 1, 3));
        Assert.assertFalse(iterable2.containsNone(7, 3, 1, 0));
        int size = 33;
        int[] array = new int[size];
        int[] unmatched = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            unmatched[i] = i + 34;
        }
        IntIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(array));
        Assert.assertTrue(iterable3.containsNone(unmatched));
        IntIterable iterable4 = IntSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(array));
        Assert.assertTrue(iterable4.containsNone(unmatched));
        IntIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(1, 2, 3));
        Assert.assertTrue(emptyIterable.containsNone());
        Assert.assertTrue(emptyIterable.containsNone(-1, 5));
        Assert.assertTrue(emptyIterable.containsNone(0));
    }

    @Test
    public void containsNoneIterable() {
        IntIterable iterable = this.newWith(1, 2, 3);
        Assert.assertFalse(iterable.containsNone(IntLists.immutable.with(1, 1)));
        Assert.assertTrue(iterable.containsNone(IntLists.mutable.empty()));
        Assert.assertFalse(iterable.containsNone(IntLists.mutable.with(3, 4, 5, 6)));
        Assert.assertTrue(iterable.containsNone(IntLists.immutable.with(7, 8, 11)));
        IntIterable iterable2 = this.newWith(0, 1, 3, 7);
        Assert.assertTrue(iterable2.containsNone(IntSets.immutable.with(2, 4, 6)));
        Assert.assertTrue(iterable2.containsNone(IntSets.mutable.empty()));
        Assert.assertFalse(iterable2.containsNone(IntSets.immutable.with(-1, 1, 3)));
        Assert.assertFalse(iterable2.containsNone(IntSets.mutable.with(7, 3, 1, 0)));
        IntIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(IntLists.immutable.with(1, 2, 3)));
        Assert.assertTrue(emptyIterable.containsNone(IntLists.mutable.empty()));
        Assert.assertTrue(emptyIterable.containsNone(IntLists.immutable.with(-1, 5)));
        Assert.assertTrue(emptyIterable.containsNone(IntLists.mutable.with(0)));
        int size = 33;
        int[] array = new int[size];
        int[] unmatched = new int[size];
        int[] bigger = new int[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            bigger[i] = i + 1;
            unmatched[i] = i + 34;
        }
        bigger[size - 1] = 33;
        IntIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(IntLists.immutable.with(array)));
        Assert.assertTrue(iterable3.containsNone(IntLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsNone(IntSets.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsNone(IntSets.mutable.with(bigger)));
        IntIterable iterable4 = IntSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(IntLists.immutable.with(array)));
        Assert.assertTrue(iterable4.containsNone(IntLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable4.containsNone(IntSets.immutable.with(array)));
        Assert.assertFalse(iterable4.containsNone(IntSets.immutable.with(bigger)));
    }

    @Test
    public abstract void intIterator();

    @Test(expected = NoSuchElementException.class)
    public void intIterator_throws() {
        IntIterator iterator = this.classUnderTest().intIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void intIterator_throws_non_empty_collection() {
        IntIterable iterable = this.newWith(1, 2, 3);
        IntIterator iterator = iterable.intIterator();
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
        Verify.assertSize(1, this.newWith(3));
        Verify.assertSize(3, this.newWith(1, 2, 3));
    }

    @Test
    public void count() {
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 3 ? 3 : size, iterable.count(IntPredicates.lessThan(4)));
        Assert.assertEquals(2L, this.newWith(1, 0, 2).count(IntPredicates.greaterThan(0)));
        Assert.assertEquals(1, this.newWith(1).count(IntPredicates.alwaysTrue()));
        Assert.assertEquals(0, this.newWith(1).count(IntPredicates.alwaysFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1, -1, 2).anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, -1, 2).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWith(-1, -1, -2, 31, 32).anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.newWith(2, -1, -2, 31, 32).anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, -1, 31, 32).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWith(32).anySatisfy(IntPredicates.greaterThan(0)));
        IntIterable iterable = this.newWith(0, 1, 2);
        Assert.assertTrue(iterable.anySatisfy(value -> value < 3));
        Assert.assertFalse(iterable.anySatisfy(IntPredicates.greaterThan(3)));
        IntIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(IntPredicates.greaterThan(3)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(IntPredicates.lessThan(3)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newWith(1, 0, 2).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.newWith(1, 2, 3).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 0, 31, 32).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 0, 31, 32).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.newWith(1, 2, 31, 32).allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(32).allSatisfy(IntPredicates.equal(33)));
        Assert.assertFalse(this.newWith(-32).allSatisfy(IntPredicates.equal(33)));
        IntIterable iterable = this.newWith(0, 1, 2);
        Assert.assertFalse(iterable.allSatisfy(value -> 3 < value));
        Assert.assertTrue(iterable.allSatisfy(IntPredicates.lessThan(3)));
        IntIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(IntPredicates.greaterThan(3)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(IntPredicates.lessThan(3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newWith(1, 0, 2).noneSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 0, 2).noneSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWith(1, 2, 3).noneSatisfy(IntPredicates.greaterThan(3)));
        Assert.assertFalse(this.newWith(1, 0, 31, 32).noneSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.newWith(1, 0, 31, 32).noneSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(this.newWith(1, 2, 31, 32).noneSatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(this.newWith(32).noneSatisfy(IntPredicates.greaterThan(0)));
        IntIterable iterable = this.newWith(0, 1, 2);
        Assert.assertFalse(iterable.noneSatisfy(value -> 1 < value));
        Assert.assertTrue(iterable.noneSatisfy(IntPredicates.greaterThan(3)));
        IntIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size <= 3, iterable1.noneSatisfy(IntPredicates.greaterThan(3)));
        Assert.assertEquals(size == 0, iterable1.noneSatisfy(IntPredicates.lessThan(3)));
    }

    @Test
    public void collect() {
        IntToObjectFunction<Integer> function = parameter -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 2), this.newWith(1, 2, 3).collect(function));
        IntIterable iterable = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 1, 2, 2, 2), iterable.collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2), this.newWith(3).collect(function));
    }

    @Test
    public void collectWithTarget() {
        IntToObjectFunction<Integer> function = parameter -> parameter - 1;
        Assert.assertEquals(Bags.mutable.with(0, 1, 2), this.newWith(1, 2, 3).collect(function, Bags.mutable.empty()));
        IntIterable iterable = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(Sets.mutable.with(0, 1, 2), iterable.collect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().collect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2), this.newWith(3).collect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectWithTarget() {
        IntToObjectFunction<List<Integer>> function = parameter -> Lists.mutable.with(parameter - 1);
        Assert.assertEquals(Bags.mutable.with(0, 1, 2), this.newWith(1, 2, 3).flatCollect(function, Bags.mutable.empty()));
        IntIterable iterable = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(Sets.mutable.with(0, 1, 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2), this.newWith(3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectIterableWithTarget() {
        IntToObjectFunction<Iterable<Integer>> function = parameter -> Lists.mutable.with(parameter - 1).asLazy();
        Assert.assertEquals(Bags.mutable.with(0, 1, 2), this.newWith(1, 2, 3).flatCollect(function, Bags.mutable.empty()));
        IntIterable iterable = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(Sets.mutable.with(0, 1, 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2), this.newWith(3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToLists() {
        IntIterable iterable = this.newWith(1, 2);
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
        IntIterable iterable = this.newWith(1, 2);
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
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(IntPredicates.lessThan(4)));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(IntPredicates.lessThan(3)));
        IntIterable iterable1 = this.newWith(0, 1, 2, 2, 3, 3, 3);
        Assert.assertEquals(this.newMutableCollectionWith(0, 1), iterable1.select(IntPredicates.lessThan(2)));
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 3, 3, 3), iterable1.select(IntPredicates.greaterThan(1)));
        IntIterable iterable2 = this.newWith(0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.select(IntPredicates.alwaysTrue()));
        Verify.assertSize(0, iterable2.select(IntPredicates.alwaysFalse()));
    }

    @Test
    public void selectWithTarget() {
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(IntPredicates.lessThan(4), IntSets.mutable.empty()));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(IntPredicates.lessThan(3), IntSets.mutable.empty()));
        IntIterable iterable1 = this.newWith(0, 1, 2, 2, 3, 3, 3);
        Assert.assertEquals(IntSets.mutable.with(0, 1), iterable1.select(IntPredicates.lessThan(2), IntSets.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(2, 3), iterable1.select(IntPredicates.greaterThan(1), IntSets.mutable.empty()));
    }

    @Test
    public void reject() {
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(IntPredicates.lessThan(4)));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(IntPredicates.lessThan(3)));
        IntIterable iterable1 = this.newWith(0, 1, 2, 2, 3, 3, 3);
        Assert.assertEquals(this.newMutableCollectionWith(2, 2, 3, 3, 3), iterable1.reject(IntPredicates.lessThan(2)));
        Assert.assertEquals(this.newMutableCollectionWith(0, 1), iterable1.reject(IntPredicates.greaterThan(1)));
        IntIterable iterable2 = this.newWith(0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.reject(IntPredicates.alwaysFalse()));
        Verify.assertSize(0, iterable2.reject(IntPredicates.alwaysTrue()));
    }

    @Test
    public void rejectWithTarget() {
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(IntPredicates.lessThan(4), IntSets.mutable.empty()));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(IntPredicates.lessThan(3), IntSets.mutable.empty()));
        IntIterable iterable1 = this.newWith(0, 1, 2, 2, 3, 3, 3);
        Assert.assertEquals(IntSets.mutable.with(2, 3), iterable1.reject(IntPredicates.lessThan(2), IntSets.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1), iterable1.reject(IntPredicates.greaterThan(1), IntSets.mutable.empty()));
    }

    @Test
    public void detectIfNone() {
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(IntPredicates.equal(4), 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(IntPredicates.equal(2), 0));
        Assert.assertEquals(size > 0 ? 1L : 0L, iterable.detectIfNone(IntPredicates.lessThan(2), 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(IntPredicates.greaterThan(3), 0));
        IntIterable iterable1 = this.newWith(0, 1, 2, 2, 3, 3, 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(IntPredicates.lessThan(1), 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(IntPredicates.greaterThan(2), 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(IntPredicates.greaterThan(4), 4));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, this.newWith(-1, -2, 9).max());
        Assert.assertEquals(-1L, this.newWith(-1, -2, -9).max());
        Assert.assertEquals(32L, this.newWith(1, 0, 9, 30, 31, 32).max());
        Assert.assertEquals(32L, this.newWith(-1, 0, 9, 30, 31, 32).max());
        Assert.assertEquals(31L, this.newWith(31, 0, 30).max());
        Assert.assertEquals(39L, this.newWith(32, 39, 35).max());
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyCollection() {
        this.newWith().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(-2L, this.newWith(-1, -2, 9).min());
        Assert.assertEquals(0L, this.newWith(1, 0, 9, 30, 31, 32).min());
        Assert.assertEquals(-1L, this.newWith(-1, 0, 9, 30, 31, 32).min());
        Assert.assertEquals(31L, this.newWith(31, 32, 33).min());
        Assert.assertEquals(32L, this.newWith(32, 39, 35).min());
        Assert.assertEquals(1L, this.classUnderTest().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyCollection() {
        this.newWith().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, this.newWith().minIfEmpty(5));
        Assert.assertEquals(0L, this.newWith().minIfEmpty(0));
        Assert.assertEquals(0L, this.newWith(1, 0, 9, 7).minIfEmpty(5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5 : 1, this.classUnderTest().minIfEmpty(5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.newWith().maxIfEmpty(5));
        Assert.assertEquals(0L, this.newWith().maxIfEmpty(0));
        Assert.assertEquals(9L, this.newWith(1, 0, 9, 7).maxIfEmpty(5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5 : size, this.classUnderTest().maxIfEmpty(5));
    }

    @Test
    public void sum() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().sum());
        Assert.assertEquals(10L, this.newWith(0, 1, 2, 3, 4).sum());
        Assert.assertEquals(93L, this.newWith(30, 31, 32).sum());
    }

    @Test
    public void summaryStatistics() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().summaryStatistics().getSum());
        Assert.assertEquals(10L, this.newWith(0, 1, 2, 3, 4).summaryStatistics().getSum());
        Assert.assertEquals(93L, this.newWith(30, 31, 32).summaryStatistics().getSum());
    }

    @Test
    public void average() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1, 2, 3, 4).average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1, 2, 3, 4).average(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30, 30, 31, 31, 32, 32).average(), 0.0);
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
        Assert.assertEquals(2.5, this.newWith(1, 2, 3, 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1, 2, 3, 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30, 30, 31, 31, 32, 32).averageIfEmpty(0.0), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(1.0, this.newWith(1).median(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1, 2, 3, 4).median(), 0.0);
        Assert.assertEquals(3.0, this.newWith(1, 2, 3, 4, 5).median(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30, 30, 31, 31, 32).median(), 0.0);
        Assert.assertEquals(30.5, this.newWith(1, 30, 30, 31, 31, 32).median(), 0.0);
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
        Assert.assertEquals(1.0, this.newWith(1).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1, 2, 3, 4).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(3.0, this.newWith(1, 2, 3, 4, 5).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30, 30, 31, 31, 32).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(30.5, this.newWith(1, 30, 30, 31, 31, 32).medianIfEmpty(0.0), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().toArray().length);
        IntIterable iterable = this.newWith(1, 2);
        Assert.assertTrue(Arrays.equals(new int[] { 1, 2 }, iterable.toArray()) || Arrays.equals(new int[] { 2, 1 }, iterable.toArray()));
        Assert.assertTrue(Arrays.equals(new int[] { 0, 1 }, this.newWith(0, 1).toArray()) || Arrays.equals(new int[] { 1, 0 }, this.newWith(0, 1).toArray()));
        Assert.assertTrue(Arrays.equals(new int[] { 1, 31 }, this.newWith(1, 31).toArray()) || Arrays.equals(new int[] { 31, 1 }, this.newWith(1, 31).toArray()));
        Assert.assertTrue(Arrays.equals(new int[] { 31, 35 }, this.newWith(31, 35).toArray()) || Arrays.equals(new int[] { 35, 31 }, this.newWith(31, 35).toArray()));
        Assert.assertArrayEquals(new int[] {}, this.newWith().toArray());
        Assert.assertArrayEquals(new int[] { 32 }, this.newWith(32).toArray());
    }

    @Test
    public void toArrayWithTargetArray() {
        int[] originalAsSortedArray = this.classUnderTest().toSortedArray();
        int[] target = new int[this.classUnderTest().size()];
        Assert.assertSame(target, this.classUnderTest().toArray(target));
        Arrays.sort(target);
        Assert.assertTrue(Arrays.equals(originalAsSortedArray, target));
        if (this.classUnderTest().size() > 0) {
            int[] targetTooSmall = new int[this.classUnderTest().size() - 1];
            int[] result = this.classUnderTest().toArray(targetTooSmall);
            Assert.assertNotSame(targetTooSmall, result);
            Arrays.sort(result);
            Assert.assertTrue(Arrays.equals(this.classUnderTest().toSortedArray(), result));
        }
        int[] targetTooBig = new int[this.classUnderTest().size() + 1];
        int[] bigResult = this.classUnderTest().toArray(targetTooBig);
        Assert.assertSame(targetTooBig, bigResult);
        Arrays.sort(targetTooBig);
        for (int i = 0; i < originalAsSortedArray.length; i++) {
            Assert.assertEquals(originalAsSortedArray[i], bigResult[i + 1]);
        }
    }

    @Test
    public void toSortedArray() {
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        Assert.assertArrayEquals(array, iterable.toSortedArray());
        Assert.assertArrayEquals(new int[] { 1, 3, 7, 9 }, this.newWith(3, 1, 9, 7).toSortedArray());
    }

    @Test
    public void testEquals() {
        IntIterable iterable1 = this.newWith(1, 2, 3, 4);
        IntIterable iterable2 = this.newWith(1, 2, 3, 4);
        IntIterable iterable3 = this.newWith(5, 6, 7, 8);
        IntIterable iterable4 = this.newWith(5, 6, 7);
        IntIterable iterable5 = this.newWith(0, 1, 1, 2, 2, 2);
        IntIterable iterable6 = this.newWith(1, 31, 32);
        IntIterable iterable7 = this.newWith(35, 31, 1);
        IntIterable iterable8 = this.newWith(32, 31, 1, 50);
        IntIterable iterable9 = this.newWith(0, 1, 2);
        IntIterable iterable10 = this.newWith(0, 1, 3);
        IntIterable iterable11 = this.newWith(3, 1, 2);
        IntIterable iterable12 = this.newWith(3);
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
        Assert.assertNotEquals(this.newWith(), this.newWith(100));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(this.newObjectCollectionWith(1, 2, 3).hashCode(), this.newWith(1, 2, 3).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 31).hashCode(), this.newWith(0, 1, 31).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32).hashCode(), this.newWith(32).hashCode());
        Assert.assertNotEquals(this.newObjectCollectionWith(32).hashCode(), this.newWith(0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(31, 32, 50).hashCode(), this.newWith(31, 32, 50).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32, 50, 60).hashCode(), this.newWith(32, 50, 60).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[1]", this.newWith(1).toString());
        Assert.assertEquals("[31]", this.newWith(31).toString());
        Assert.assertEquals("[32]", this.newWith(32).toString());
        IntIterable iterable = this.newWith(1, 2);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        IntIterable iterable1 = this.newWith(0, 31);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        IntIterable iterable2 = this.newWith(31, 32);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        IntIterable iterable3 = this.newWith(32, 33);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        IntIterable iterable4 = this.newWith(0, 1);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        IntIterable iterable = this.classUnderTest();
        Assert.assertEquals("1", this.newWith(1).makeString("/"));
        Assert.assertEquals("31", this.newWith(31).makeString());
        Assert.assertEquals("32", this.newWith(32).makeString());
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        IntIterable iterable1 = this.newWith(0, 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        IntIterable iterable2 = this.newWith(31, 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        IntIterable iterable3 = this.newWith(32, 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        IntIterable iterable4 = this.newWith(1, 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        IntIterable iterable5 = this.newWith(0, 1);
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
        this.newWith(1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        IntIterable iterable = this.newWith(1, 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        IntIterable iterable1 = this.newWith(0, 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        IntIterable iterable2 = this.newWith(31, 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        IntIterable iterable4 = this.newWith(32, 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        IntIterable iterable5 = this.newWith(0, 1);
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
        IntIterable iterable = this.newWith(31, 32);
        Assert.assertTrue(IntArrayList.newListWith(31, 32).equals(iterable.toList()) || IntArrayList.newListWith(32, 31).equals(iterable.toList()));
        Assert.assertEquals(IntArrayList.newListWith(0), this.newWith(0).toList());
        Assert.assertEquals(IntArrayList.newListWith(31), this.newWith(31).toList());
        Assert.assertEquals(IntArrayList.newListWith(32), this.newWith(32).toList());
        Assert.assertEquals(new IntArrayList(), this.newWith().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(IntArrayList.newListWith(), this.newWith().toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWith(1).toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 31), this.newWith(0, 31, 1).toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 31, 32), this.newWith(0, 31, 32, 1).toSortedList());
    }

    @Test
    public void toSortedListByComparator() {
        IntIterable iterable = this.newWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        // odd/even comparator
        MutableIntList result = iterable.toSortedList((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertNotSame(iterable, result);
        result.collectBoolean(e -> e % 2 == 0, BooleanLists.mutable.of()).forEachWithIndex((e, i) -> Assert.assertEquals("index " + i, i < 5, e));
    }

    @Test
    public void toSortedListByFunctionNaturalOrder() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        IntIterable index = this.newMutableCollectionWith(0, 1, 2, 3, 4);
        MutableIntList result = index.toSortedListBy(i -> list.get((int) i));
        Assert.assertNotSame(index, result);
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 0, 4, 3), result);
    }

    @Test
    public void toSortedListByFunctionWithComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        IntIterable index = this.newMutableCollectionWith(0, 1, 2, 3, 4);
        MutableIntList result = index.toSortedListBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertNotSame(index, result);
        Assert.assertEquals(IntArrayList.newListWith(3, 4, 0, 2, 1), result);
    }

    @Test
    public void toSet() {
        Assert.assertEquals(IntHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(IntHashSet.newSetWith(1), this.newWith(1).toSet());
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), this.newWith(1, 2, 3).toSet());
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31), this.newWith(0, 1, 31).toSet());
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 31, 32), this.newWith(0, 1, 31, 32).toSet());
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), this.newWith(1, 2, 2, 3, 3, 3).toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(new IntHashBag(), this.newWith().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1), this.newWith(1).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), this.newWith(1, 2, 3).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3, 3, 3), this.newWith(1, 2, 2, 3, 3, 3).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31, 32), this.newWith(0, 1, 31, 32).toBag());
    }

    @Test
    public void asLazy() {
        IntIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyIntIterable.class, iterable.asLazy());
        IntIterable iterable1 = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(iterable1.toBag(), iterable1.asLazy().toBag());
        Verify.assertInstanceOf(LazyIntIterable.class, iterable1.asLazy());
        IntIterable iterable2 = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(iterable2.toBag(), iterable2.asLazy().toBag());
        Verify.assertInstanceOf(LazyIntIterable.class, iterable2.asLazy());
        IntIterable iterable3 = this.newWith();
        Assert.assertEquals(iterable3.toBag(), iterable3.asLazy().toBag());
        Verify.assertInstanceOf(LazyIntIterable.class, iterable3.asLazy());
        IntIterable iterable4 = this.newWith(1);
        Assert.assertEquals(iterable4.toBag(), iterable4.asLazy().toBag());
        Verify.assertInstanceOf(LazyIntIterable.class, iterable4.asLazy());
    }

    @Test
    public void injectInto() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        Integer sum1 = iterable1.injectInto(Integer.valueOf(0), (Integer result, int value) -> Integer.valueOf((int) (result + value + 1)));
        Assert.assertEquals(Integer.valueOf(36), sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        Integer sum2 = iterable2.injectInto(Integer.valueOf(0), (Integer result, int value) -> Integer.valueOf((int) (result + value + 1)));
        Assert.assertEquals(Integer.valueOf(37), sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        Integer sum3 = iterable3.injectInto(Integer.valueOf(0), (Integer result, int value) -> Integer.valueOf((int) (result + value + 1)));
        Assert.assertEquals(Integer.valueOf(38), sum3);
    }

    @Test
    public void injectIntoBoolean() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        boolean sum1 = iterable1.injectIntoBoolean(false, (boolean result, int value) -> (boolean) (result || value == 0));
        Assert.assertEquals(true, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        boolean sum2 = iterable2.injectIntoBoolean(false, (boolean result, int value) -> (boolean) (result || value == 0));
        Assert.assertEquals(false, sum2);
    }

    @Test
    public void injectIntoByte() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        byte sum1 = iterable1.injectIntoByte((byte) 0, (byte result, int value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 36, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        byte sum2 = iterable2.injectIntoByte((byte) 0, (byte result, int value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 37, sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        byte sum3 = iterable3.injectIntoByte((byte) 0, (byte result, int value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 38, sum3);
    }

    @Test
    public void injectIntoChar() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        char sum1 = iterable1.injectIntoChar((char) 0, (char result, int value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 36, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        char sum2 = iterable2.injectIntoChar((char) 0, (char result, int value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 37, sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        char sum3 = iterable3.injectIntoChar((char) 0, (char result, int value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 38, sum3);
    }

    @Test
    public void injectIntoShort() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        short sum1 = iterable1.injectIntoShort((short) 0, (short result, int value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 36, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        short sum2 = iterable2.injectIntoShort((short) 0, (short result, int value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 37, sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        short sum3 = iterable3.injectIntoShort((short) 0, (short result, int value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 38, sum3);
    }

    @Test
    public void injectIntoInt() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        int sum1 = iterable1.injectIntoInt(0, (int result, int value) -> (int) (result + value + 1));
        Assert.assertEquals(36, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        int sum2 = iterable2.injectIntoInt(0, (int result, int value) -> (int) (result + value + 1));
        Assert.assertEquals(37, sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        int sum3 = iterable3.injectIntoInt(0, (int result, int value) -> (int) (result + value + 1));
        Assert.assertEquals(38, sum3);
    }

    @Test
    public void injectIntoFloat() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        float sum1 = iterable1.injectIntoFloat(0.0f, (float result, int value) -> (float) (result + value + 1));
        Assert.assertEquals(36.0f, sum1, 0.001);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        float sum2 = iterable2.injectIntoFloat(0.0f, (float result, int value) -> (float) (result + value + 1));
        Assert.assertEquals(37.0f, sum2, 0.001);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        float sum3 = iterable3.injectIntoFloat(0.0f, (float result, int value) -> (float) (result + value + 1));
        Assert.assertEquals(38.0f, sum3, 0.001);
    }

    @Test
    public void injectIntoLong() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        long sum1 = iterable1.injectIntoLong(0L, (long result, int value) -> (long) (result + value + 1));
        Assert.assertEquals(36L, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        long sum2 = iterable2.injectIntoLong(0L, (long result, int value) -> (long) (result + value + 1));
        Assert.assertEquals(37L, sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        long sum3 = iterable3.injectIntoLong(0L, (long result, int value) -> (long) (result + value + 1));
        Assert.assertEquals(38L, sum3);
    }

    @Test
    public void injectIntoDouble() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        double sum1 = iterable1.injectIntoDouble(0.0, (double result, int value) -> (double) (result + value + 1));
        Assert.assertEquals(36.0, sum1, 0.001);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        double sum2 = iterable2.injectIntoDouble(0.0, (double result, int value) -> (double) (result + value + 1));
        Assert.assertEquals(37.0, sum2, 0.001);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        double sum3 = iterable3.injectIntoDouble(0.0, (double result, int value) -> (double) (result + value + 1));
        Assert.assertEquals(38.0, sum3, 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void reduceOnEmptyThrows() {
        this.newWith().reduce((long result, int value) -> (long) result + (long) value + 1L);
    }

    @Test
    public void reduce() {
        IntIterable iterable1 = this.newWith(0, 2, 31);
        long sum1 = iterable1.reduce((long result, int value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(35L, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        long sum2 = iterable2.reduce((long result, int value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(36L, sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        long sum3 = iterable3.reduce((long result, int value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void reduceIfEmpty() {
        long empty1 = this.newWith().reduceIfEmpty((long result, int value) -> (long) result + (long) value + 1L, 1L);
        Assert.assertEquals(1L, empty1);
        long empty2 = this.newWith().reduceIfEmpty((long result, int value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(0L, empty2);
        IntIterable iterable1 = this.newWith(0, 2, 31);
        long sum1 = iterable1.reduceIfEmpty((long result, int value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(35L, sum1);
        IntIterable iterable2 = this.newWith(1, 2, 31);
        long sum2 = iterable2.reduceIfEmpty((long result, int value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(36L, sum2);
        IntIterable iterable3 = this.newWith(0, 1, 2, 31);
        long sum3 = iterable3.reduceIfEmpty((long result, int value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void chunk() {
        IntIterable iterable = this.newWith(0, 1, 2, 3, 4, 5);
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0), this.newMutableCollectionWith(1), this.newMutableCollectionWith(2), this.newMutableCollectionWith(3), this.newMutableCollectionWith(4), this.newMutableCollectionWith(5)).toSet(), iterable.chunk(1).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0, 1), this.newMutableCollectionWith(2, 3), this.newMutableCollectionWith(4, 5)).toSet(), iterable.chunk(2).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0, 1, 2), this.newMutableCollectionWith(3, 4, 5)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0, 1, 2, 3), this.newMutableCollectionWith(4, 5)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0, 1, 2, 3, 4, 5)).toSet(), iterable.chunk(6).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0, 1, 2, 3, 4, 5)).toSet(), iterable.chunk(7).toSet());
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0)), this.newWith(0).chunk(1));
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newMutableCollectionWith().chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractIntIterableTestCase instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractIntIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntIterableTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractIntIterableTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractIntIterableTestCase::newCollection;
            this.payloads.isEmpty = AbstractIntIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractIntIterableTestCase::notEmpty;
            this.payloads.tap = AbstractIntIterableTestCase::tap;
            this.payloads.contains = AbstractIntIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractIntIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractIntIterableTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractIntIterableTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractIntIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractIntIterableTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractIntIterableTestCase::containsNoneIterable;
            this.payloads.intIterator = AbstractIntIterableTestCase::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntIterableTestCase::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntIterableTestCase::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractIntIterableTestCase::forEach;
            this.payloads.size = AbstractIntIterableTestCase::size;
            this.payloads.count = AbstractIntIterableTestCase::count;
            this.payloads.anySatisfy = AbstractIntIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractIntIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractIntIterableTestCase::noneSatisfy;
            this.payloads.collect = AbstractIntIterableTestCase::collect;
            this.payloads.collectWithTarget = AbstractIntIterableTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractIntIterableTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractIntIterableTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractIntIterableTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractIntIterableTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractIntIterableTestCase::select;
            this.payloads.selectWithTarget = AbstractIntIterableTestCase::selectWithTarget;
            this.payloads.reject = AbstractIntIterableTestCase::reject;
            this.payloads.rejectWithTarget = AbstractIntIterableTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractIntIterableTestCase::detectIfNone;
            this.payloads.max = AbstractIntIterableTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntIterableTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractIntIterableTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntIterableTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractIntIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractIntIterableTestCase::maxIfEmpty;
            this.payloads.sum = AbstractIntIterableTestCase::sum;
            this.payloads.summaryStatistics = AbstractIntIterableTestCase::summaryStatistics;
            this.payloads.average = AbstractIntIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractIntIterableTestCase::averageIfEmpty;
            this.payloads.median = AbstractIntIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractIntIterableTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractIntIterableTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractIntIterableTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractIntIterableTestCase::toSortedArray;
            this.payloads.testEquals = AbstractIntIterableTestCase::testEquals;
            this.payloads.testHashCode = AbstractIntIterableTestCase::testHashCode;
            this.payloads.testToString = AbstractIntIterableTestCase::testToString;
            this.payloads.makeString = AbstractIntIterableTestCase::makeString;
            this.payloads.appendString = AbstractIntIterableTestCase::appendString;
            this.payloads.toList = AbstractIntIterableTestCase::toList;
            this.payloads.toSortedList = AbstractIntIterableTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractIntIterableTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractIntIterableTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractIntIterableTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractIntIterableTestCase::toSet;
            this.payloads.toBag = AbstractIntIterableTestCase::toBag;
            this.payloads.asLazy = AbstractIntIterableTestCase::asLazy;
            this.payloads.injectInto = AbstractIntIterableTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractIntIterableTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractIntIterableTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractIntIterableTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractIntIterableTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractIntIterableTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractIntIterableTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractIntIterableTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractIntIterableTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntIterableTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractIntIterableTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractIntIterableTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractIntIterableTestCase::chunk;
        }
    }
}
