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
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
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
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ShortIterable}s
 * This file was automatically generated from template file abstractPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractShortIterableTestCase {

    protected abstract ShortIterable classUnderTest();

    protected abstract ShortIterable newWith(short... elements);

    protected abstract ShortIterable newMutableCollectionWith(short... elements);

    protected abstract RichIterable<Short> newObjectCollectionWith(Short... elements);

    @Test
    public void newCollectionWith() {
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3);
        Verify.assertSize(3, iterable);
        Verify.assertSize(4, this.newWith((short) 0, (short) 1, (short) 31, (short) 32));
        Assert.assertTrue(iterable.containsAll((short) 1, (short) 2, (short) 3));
        ShortIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll((short) 1, (short) 2, (short) 3));
        ShortIterable iterable2 = this.newWith((short) 1);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll((short) 1, (short) 2, (short) 3));
    }

    @Test
    public void newCollection() {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(this.newMutableCollectionWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 1, (short) 31, (short) 32));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith((short) 0, (short) 1, (short) 31, (short) 32));
        Verify.assertNotEmpty(this.newWith((short) 0, (short) 1, (short) 2));
        Verify.assertNotEmpty(this.newWith((short) 0, (short) 31));
        Verify.assertNotEmpty(this.newWith((short) 31, (short) 32));
        Verify.assertNotEmpty(this.newWith((short) 32, (short) 33));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith((short) 0, (short) 1, (short) 31, (short) 32).notEmpty());
        Assert.assertTrue(this.newWith((short) 0, (short) 1, (short) 2).notEmpty());
        Assert.assertTrue(this.newWith((short) 0, (short) 31).notEmpty());
        Assert.assertTrue(this.newWith((short) 31, (short) 32).notEmpty());
        Assert.assertTrue(this.newWith((short) 32, (short) 33).notEmpty());
    }

    @Test
    public void tap() {
        MutableShortList tapResult = ShortLists.mutable.empty();
        ShortIterable collection = this.newWith((short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void contains() {
        ShortIterable iterable = this.newWith((short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertFalse(iterable.contains((short) 29));
        Assert.assertFalse(iterable.contains((short) 49));
        short[] numbers = { (short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1 };
        for (short number : numbers) {
            Assert.assertTrue(iterable.contains(number));
        }
        Assert.assertFalse(iterable.contains((short) -1));
        Assert.assertFalse(iterable.contains((short) 29));
        Assert.assertFalse(iterable.contains((short) 49));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(iterable1.contains((short) 0));
        Assert.assertTrue(iterable1.contains((short) 1));
        Assert.assertTrue(iterable1.contains((short) 2));
        Assert.assertFalse(iterable1.contains((short) 3));
        ShortIterable iterable2 = this.classUnderTest();
        for (short each = 1; each <= iterable2.size(); each++) {
            Assert.assertTrue(iterable2.contains(each));
        }
        Assert.assertFalse(iterable2.contains((short) (iterable2.size() + 1)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toArray()));
        Assert.assertFalse(this.classUnderTest().containsAll((short) (this.classUnderTest().size() + 1)));
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertTrue(iterable.containsAll((short) 1));
        Assert.assertTrue(iterable.containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertFalse(iterable.containsAll((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertFalse(iterable.containsAll((short) 1, (short) 2, (short) 4));
        Assert.assertFalse(iterable.containsAll((short) 4, (short) 5, (short) 6));
        ShortIterable iterable1 = this.newWith((short) 14, (short) 2, (short) 30, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertTrue(iterable1.containsAll((short) 14));
        Assert.assertTrue(iterable1.containsAll((short) 35));
        Assert.assertFalse(iterable1.containsAll((short) -1));
        Assert.assertTrue(iterable1.containsAll((short) 14, (short) 1, (short) 30));
        Assert.assertTrue(iterable1.containsAll((short) 14, (short) 1, (short) 32));
        Assert.assertTrue(iterable1.containsAll((short) 14, (short) 1, (short) 35));
        Assert.assertFalse(iterable1.containsAll((short) 0, (short) 2, (short) 35, (short) -1));
        Assert.assertFalse(iterable1.containsAll((short) 31, (short) -1));
        ShortIterable iterable2 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(iterable2.containsAll((short) 0));
        Assert.assertTrue(iterable2.containsAll((short) 0, (short) 0, (short) 0));
        Assert.assertTrue(iterable2.containsAll((short) 0, (short) 1, (short) 1));
        Assert.assertTrue(iterable2.containsAll((short) 0, (short) 1, (short) 2));
        Assert.assertFalse(iterable2.containsAll((short) 0, (short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertFalse(iterable2.containsAll((short) 3, (short) 4));
        int size = 33;
        short[] array = new short[size];
        for (int i = 0; i < size; i++) {
            array[i] = (short) (i + 1);
        }
        ShortIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertTrue(iterable3.containsAll());
        Assert.assertFalse(iterable3.containsAll((short) 3, (short) 4, (short) 5, (short) 33, (short) 34));
        Assert.assertTrue(iterable3.containsAll(array));
        ShortIterable iterable4 = ShortSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertTrue(iterable4.containsAll());
        Assert.assertFalse(iterable4.containsAll((short) 3, (short) 4, (short) 5, (short) 33, (short) 34));
        Assert.assertTrue(iterable4.containsAll(array));
    }

    @Test
    public void containsAllIterable() {
        ShortIterable source = this.classUnderTest();
        Assert.assertTrue(source.containsAll(this.classUnderTest()));
        Assert.assertFalse(source.containsAll(ShortArrayList.newListWith((short) (source.size() + 1))));
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertTrue(this.newWith().containsAll(new ShortArrayList()));
        Assert.assertFalse(this.newWith().containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Assert.assertFalse(iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4)));
        Assert.assertFalse(iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 4)));
        Assert.assertFalse(iterable.containsAll(ShortArrayList.newListWith((short) 4, (short) 5, (short) 6)));
        ShortIterable iterable1 = this.newWith((short) 14, (short) 2, (short) 30, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertTrue(iterable1.containsAll(ShortHashSet.newSetWith((short) 14)));
        Assert.assertTrue(iterable1.containsAll(ShortHashSet.newSetWith((short) 35)));
        Assert.assertFalse(iterable1.containsAll(ShortHashSet.newSetWith((short) -1)));
        Assert.assertTrue(iterable1.containsAll(ShortHashSet.newSetWith((short) 14, (short) 1, (short) 30)));
        Assert.assertTrue(iterable1.containsAll(ShortHashSet.newSetWith((short) 14, (short) 1, (short) 32)));
        Assert.assertTrue(iterable1.containsAll(ShortHashSet.newSetWith((short) 14, (short) 1, (short) 35)));
        Assert.assertFalse(iterable1.containsAll(ShortHashSet.newSetWith((short) 0, (short) 2, (short) 35, (short) -1)));
        Assert.assertFalse(iterable1.containsAll(ShortHashSet.newSetWith((short) 31, (short) -1)));
        ShortIterable iterable2 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(iterable2.containsAll(ShortArrayList.newListWith((short) 0)));
        Assert.assertTrue(iterable2.containsAll(ShortArrayList.newListWith((short) 0, (short) 0, (short) 0)));
        Assert.assertTrue(iterable2.containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 1)));
        Assert.assertTrue(iterable2.containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
        Assert.assertFalse(iterable2.containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4)));
        Assert.assertFalse(iterable2.containsAll(ShortArrayList.newListWith((short) 3, (short) 4)));
        int size = 33;
        short[] array = new short[size];
        for (int i = 0; i < size; i++) {
            array[i] = (short) (i + 1);
        }
        ShortIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(ShortLists.immutable.with((short) 1, (short) 2, (short) 3)));
        Assert.assertTrue(iterable3.containsAll(ShortLists.mutable.empty()));
        Assert.assertFalse(iterable3.containsAll(ShortLists.mutable.with((short) 3, (short) 4, (short) 5, (short) 33, (short) 34)));
        Assert.assertTrue(iterable3.containsAll(ShortLists.immutable.with(array)));
        ShortIterable iterable4 = ShortSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(ShortLists.immutable.with((short) 1, (short) 2, (short) 3)));
        Assert.assertTrue(iterable4.containsAll(ShortLists.mutable.empty()));
        Assert.assertFalse(iterable4.containsAll(ShortLists.mutable.with((short) 3, (short) 4, (short) 5, (short) 33, (short) 34)));
        Assert.assertTrue(iterable4.containsAll(ShortLists.immutable.with(array)));
    }

    @Test
    public void containsAnyArray() {
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        Assert.assertTrue(iterable.containsAny((short) 1, (short) 1, (short) 1));
        Assert.assertFalse(iterable.containsAny());
        Assert.assertTrue(iterable.containsAny((short) 1, (short) 2, (short) 3));
        Assert.assertFalse(iterable.containsAny((short) 6, (short) 7, (short) 8));
        ShortIterable iterable2 = this.newWith((short) 0, (short) 1, (short) 3, (short) 7);
        Assert.assertTrue(iterable2.containsAny((short) 3, (short) 3, (short) 1, (short) 9));
        Assert.assertFalse(iterable2.containsAny());
        Assert.assertTrue(iterable2.containsAny((short) -1, (short) 3, (short) 5));
        Assert.assertFalse(iterable2.containsAny((short) 2, (short) 4, (short) 6));
        int size = 33;
        short[] array = new short[size];
        short[] unmatched = new short[size];
        for (int i = 0; i < size; i++) {
            array[i] = (short) (i + 1);
            unmatched[i] = (short) (i + 34);
        }
        ShortIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(array));
        Assert.assertFalse(iterable3.containsAny(unmatched));
        ShortIterable iterable4 = ShortSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(array));
        Assert.assertFalse(iterable4.containsAny(unmatched));
        ShortIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny());
        Assert.assertFalse(emptyIterable.containsAny((short) 0, (short) 0));
        Assert.assertFalse(emptyIterable.containsAny((short) -1));
        Assert.assertFalse(emptyIterable.containsAny((short) 1, (short) 2, (short) 3));
    }

    @Test
    public void containsAnyIterable() {
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        Assert.assertTrue(iterable.containsAny(ShortLists.immutable.with((short) 1, (short) 1, (short) 1)));
        Assert.assertFalse(iterable.containsAny(ShortLists.mutable.empty()));
        Assert.assertTrue(iterable.containsAny(ShortLists.immutable.with((short) 1, (short) 2, (short) 3)));
        Assert.assertFalse(iterable.containsAny(ShortLists.mutable.with((short) 6, (short) 7, (short) 8)));
        ShortIterable iterable2 = this.newWith((short) 0, (short) 1, (short) 3, (short) 7);
        Assert.assertTrue(iterable2.containsAny(ShortSets.immutable.with((short) 3, (short) 3, (short) 1, (short) 9)));
        Assert.assertFalse(iterable2.containsAny(ShortSets.mutable.empty()));
        Assert.assertTrue(iterable2.containsAny(ShortSets.immutable.with((short) -1, (short) 3, (short) 5)));
        Assert.assertFalse(iterable2.containsAny(ShortSets.mutable.with((short) 2, (short) 4, (short) 6)));
        ShortIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny(ShortLists.mutable.empty()));
        Assert.assertFalse(emptyIterable.containsAny(ShortLists.immutable.with((short) 0, (short) 0)));
        Assert.assertFalse(emptyIterable.containsAny(ShortLists.mutable.with((short) -1)));
        Assert.assertFalse(emptyIterable.containsAny(ShortLists.immutable.with((short) 1, (short) 2, (short) 3)));
        int size = 33;
        short[] array = new short[size];
        short[] unmatched = new short[size];
        short[] bigger = new short[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = (short) (i + 1);
            bigger[i] = (short) (i + 1);
            unmatched[i] = (short) (i + 34);
        }
        bigger[size - 1] = (short) 33;
        ShortIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(ShortLists.immutable.with(array)));
        Assert.assertFalse(iterable3.containsAny(ShortLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsAny(ShortSets.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsAny(ShortSets.mutable.with(bigger)));
        ShortIterable iterable4 = ShortSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(ShortLists.immutable.with(array)));
        Assert.assertFalse(iterable4.containsAny(ShortLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable4.containsAny(ShortSets.immutable.with(array)));
        Assert.assertTrue(iterable4.containsAny(ShortSets.immutable.with(bigger)));
    }

    @Test
    public void containsNoneArray() {
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertFalse(iterable.containsNone((short) 1, (short) 1));
        Assert.assertTrue(iterable.containsNone());
        Assert.assertFalse(iterable.containsNone((short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertTrue(iterable.containsNone((short) 7, (short) 8, (short) 11));
        ShortIterable iterable2 = this.newWith((short) 0, (short) 1, (short) 3, (short) 7);
        Assert.assertTrue(iterable2.containsNone((short) 2, (short) 4, (short) 6));
        Assert.assertTrue(iterable2.containsNone());
        Assert.assertFalse(iterable2.containsNone((short) -1, (short) 1, (short) 3));
        Assert.assertFalse(iterable2.containsNone((short) 7, (short) 3, (short) 1, (short) 0));
        int size = 33;
        short[] array = new short[size];
        short[] unmatched = new short[size];
        for (int i = 0; i < size; i++) {
            array[i] = (short) (i + 1);
            unmatched[i] = (short) (i + 34);
        }
        ShortIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(array));
        Assert.assertTrue(iterable3.containsNone(unmatched));
        ShortIterable iterable4 = ShortSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(array));
        Assert.assertTrue(iterable4.containsNone(unmatched));
        ShortIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone((short) 1, (short) 2, (short) 3));
        Assert.assertTrue(emptyIterable.containsNone());
        Assert.assertTrue(emptyIterable.containsNone((short) -1, (short) 5));
        Assert.assertTrue(emptyIterable.containsNone((short) 0));
    }

    @Test
    public void containsNoneIterable() {
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertFalse(iterable.containsNone(ShortLists.immutable.with((short) 1, (short) 1)));
        Assert.assertTrue(iterable.containsNone(ShortLists.mutable.empty()));
        Assert.assertFalse(iterable.containsNone(ShortLists.mutable.with((short) 3, (short) 4, (short) 5, (short) 6)));
        Assert.assertTrue(iterable.containsNone(ShortLists.immutable.with((short) 7, (short) 8, (short) 11)));
        ShortIterable iterable2 = this.newWith((short) 0, (short) 1, (short) 3, (short) 7);
        Assert.assertTrue(iterable2.containsNone(ShortSets.immutable.with((short) 2, (short) 4, (short) 6)));
        Assert.assertTrue(iterable2.containsNone(ShortSets.mutable.empty()));
        Assert.assertFalse(iterable2.containsNone(ShortSets.immutable.with((short) -1, (short) 1, (short) 3)));
        Assert.assertFalse(iterable2.containsNone(ShortSets.mutable.with((short) 7, (short) 3, (short) 1, (short) 0)));
        ShortIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(ShortLists.immutable.with((short) 1, (short) 2, (short) 3)));
        Assert.assertTrue(emptyIterable.containsNone(ShortLists.mutable.empty()));
        Assert.assertTrue(emptyIterable.containsNone(ShortLists.immutable.with((short) -1, (short) 5)));
        Assert.assertTrue(emptyIterable.containsNone(ShortLists.mutable.with((short) 0)));
        int size = 33;
        short[] array = new short[size];
        short[] unmatched = new short[size];
        short[] bigger = new short[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = (short) (i + 1);
            bigger[i] = (short) (i + 1);
            unmatched[i] = (short) (i + 34);
        }
        bigger[size - 1] = (short) 33;
        ShortIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(ShortLists.immutable.with(array)));
        Assert.assertTrue(iterable3.containsNone(ShortLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsNone(ShortSets.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsNone(ShortSets.mutable.with(bigger)));
        ShortIterable iterable4 = ShortSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(ShortLists.immutable.with(array)));
        Assert.assertTrue(iterable4.containsNone(ShortLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable4.containsNone(ShortSets.immutable.with(array)));
        Assert.assertFalse(iterable4.containsNone(ShortSets.immutable.with(bigger)));
    }

    @Test
    public abstract void shortIterator();

    @Test(expected = NoSuchElementException.class)
    public void shortIterator_throws() {
        ShortIterator iterator = this.classUnderTest().shortIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void shortIterator_throws_non_empty_collection() {
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 3);
        ShortIterator iterator = iterable.shortIterator();
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
        Verify.assertSize(1, this.newWith((short) 3));
        Verify.assertSize(3, this.newWith((short) 1, (short) 2, (short) 3));
    }

    @Test
    public void count() {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 3 ? 3 : size, iterable.count(ShortPredicates.lessThan((short) 4)));
        Assert.assertEquals(2L, this.newWith((short) 1, (short) 0, (short) 2).count(ShortPredicates.greaterThan((short) 0)));
        Assert.assertEquals(1, this.newWith((short) 1).count(ShortPredicates.alwaysTrue()));
        Assert.assertEquals(0, this.newWith((short) 1).count(ShortPredicates.alwaysFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((short) 1, (short) -1, (short) 2).anySatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 1, (short) -1, (short) 2).anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWith((short) -1, (short) -1, (short) -2, (short) 31, (short) 32).anySatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertTrue(this.newWith((short) 2, (short) -1, (short) -2, (short) 31, (short) 32).anySatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 1, (short) -1, (short) 31, (short) 32).anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWith((short) 32).anySatisfy(ShortPredicates.greaterThan((short) 0)));
        ShortIterable iterable = this.newWith((short) 0, (short) 1, (short) 2);
        Assert.assertTrue(iterable.anySatisfy(value -> value < (short) 3));
        Assert.assertFalse(iterable.anySatisfy(ShortPredicates.greaterThan((short) 3)));
        ShortIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(ShortPredicates.greaterThan((short) 3)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(ShortPredicates.lessThan((short) 3)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newWith((short) 1, (short) 0, (short) 2).allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertTrue(this.newWith((short) 1, (short) 2, (short) 3).allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 1, (short) 0, (short) 31, (short) 32).allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 1, (short) 0, (short) 31, (short) 32).allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertTrue(this.newWith((short) 1, (short) 2, (short) 31, (short) 32).allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 32).allSatisfy(ShortPredicates.equal((short) 33)));
        Assert.assertFalse(this.newWith((short) -32).allSatisfy(ShortPredicates.equal((short) 33)));
        ShortIterable iterable = this.newWith((short) 0, (short) 1, (short) 2);
        Assert.assertFalse(iterable.allSatisfy(value -> (short) 3 < value));
        Assert.assertTrue(iterable.allSatisfy(ShortPredicates.lessThan((short) 3)));
        ShortIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(ShortPredicates.greaterThan((short) 3)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(ShortPredicates.lessThan((short) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newWith((short) 1, (short) 0, (short) 2).noneSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 1, (short) 0, (short) 2).noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWith((short) 1, (short) 2, (short) 3).noneSatisfy(ShortPredicates.greaterThan((short) 3)));
        Assert.assertFalse(this.newWith((short) 1, (short) 0, (short) 31, (short) 32).noneSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 1, (short) 0, (short) 31, (short) 32).noneSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertTrue(this.newWith((short) 1, (short) 2, (short) 31, (short) 32).noneSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(this.newWith((short) 32).noneSatisfy(ShortPredicates.greaterThan((short) 0)));
        ShortIterable iterable = this.newWith((short) 0, (short) 1, (short) 2);
        Assert.assertFalse(iterable.noneSatisfy(value -> (short) 1 < value));
        Assert.assertTrue(iterable.noneSatisfy(ShortPredicates.greaterThan((short) 3)));
        ShortIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size <= 3, iterable1.noneSatisfy(ShortPredicates.greaterThan((short) 3)));
        Assert.assertEquals(size == 0, iterable1.noneSatisfy(ShortPredicates.lessThan((short) 3)));
    }

    @Test
    public void collect() {
        ShortToObjectFunction<Short> function = parameter -> (short) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((short) 0, (short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3).collect(function));
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(this.newObjectCollectionWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2), iterable.collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((short) 2), this.newWith((short) 3).collect(function));
    }

    @Test
    public void collectWithTarget() {
        ShortToObjectFunction<Short> function = parameter -> (short) (parameter - 1);
        Assert.assertEquals(Bags.mutable.with((short) 0, (short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3).collect(function, Bags.mutable.empty()));
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(Sets.mutable.with((short) 0, (short) 1, (short) 2), iterable.collect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().collect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((short) 2), this.newWith((short) 3).collect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectWithTarget() {
        ShortToObjectFunction<List<Short>> function = parameter -> Lists.mutable.with((short) (parameter - 1));
        Assert.assertEquals(Bags.mutable.with((short) 0, (short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3).flatCollect(function, Bags.mutable.empty()));
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(Sets.mutable.with((short) 0, (short) 1, (short) 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((short) 2), this.newWith((short) 3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectIterableWithTarget() {
        ShortToObjectFunction<Iterable<Short>> function = parameter -> Lists.mutable.with((short) (parameter - 1)).asLazy();
        Assert.assertEquals(Bags.mutable.with((short) 0, (short) 1, (short) 2), this.newWith((short) 1, (short) 2, (short) 3).flatCollect(function, Bags.mutable.empty()));
        ShortIterable iterable = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(Sets.mutable.with((short) 0, (short) 1, (short) 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((short) 2), this.newWith((short) 3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToLists() {
        ShortIterable iterable = this.newWith((short) 1, (short) 2);
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
        ShortIterable iterable = this.newWith((short) 1, (short) 2);
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
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(ShortPredicates.lessThan((short) 4)));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(ShortPredicates.lessThan((short) 3)));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(this.newMutableCollectionWith((short) 0, (short) 1), iterable1.select(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 3, (short) 3, (short) 3), iterable1.select(ShortPredicates.greaterThan((short) 1)));
        ShortIterable iterable2 = this.newWith((short) 0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.select(ShortPredicates.alwaysTrue()));
        Verify.assertSize(0, iterable2.select(ShortPredicates.alwaysFalse()));
    }

    @Test
    public void selectWithTarget() {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(ShortPredicates.lessThan((short) 4), ShortSets.mutable.empty()));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(ShortPredicates.lessThan((short) 3), ShortSets.mutable.empty()));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(ShortSets.mutable.with((short) 0, (short) 1), iterable1.select(ShortPredicates.lessThan((short) 2), ShortSets.mutable.empty()));
        Assert.assertEquals(ShortSets.mutable.with((short) 2, (short) 3), iterable1.select(ShortPredicates.greaterThan((short) 1), ShortSets.mutable.empty()));
    }

    @Test
    public void reject() {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(ShortPredicates.lessThan((short) 4)));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(ShortPredicates.lessThan((short) 3)));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(this.newMutableCollectionWith((short) 2, (short) 2, (short) 3, (short) 3, (short) 3), iterable1.reject(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 0, (short) 1), iterable1.reject(ShortPredicates.greaterThan((short) 1)));
        ShortIterable iterable2 = this.newWith((short) 0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.reject(ShortPredicates.alwaysFalse()));
        Verify.assertSize(0, iterable2.reject(ShortPredicates.alwaysTrue()));
    }

    @Test
    public void rejectWithTarget() {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(ShortPredicates.lessThan((short) 4), ShortSets.mutable.empty()));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(ShortPredicates.lessThan((short) 3), ShortSets.mutable.empty()));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(ShortSets.mutable.with((short) 2, (short) 3), iterable1.reject(ShortPredicates.lessThan((short) 2), ShortSets.mutable.empty()));
        Assert.assertEquals(ShortSets.mutable.with((short) 0, (short) 1), iterable1.reject(ShortPredicates.greaterThan((short) 1), ShortSets.mutable.empty()));
    }

    @Test
    public void detectIfNone() {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(ShortPredicates.equal((short) 4), (short) 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(ShortPredicates.equal((short) 2), (short) 0));
        Assert.assertEquals(size > 0 ? 1L : 0L, iterable.detectIfNone(ShortPredicates.lessThan((short) 2), (short) 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(ShortPredicates.greaterThan((short) 2), (short) 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(ShortPredicates.greaterThan((short) 4), (short) 4));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, this.newWith((short) -1, (short) -2, (short) 9).max());
        Assert.assertEquals(-1L, this.newWith((short) -1, (short) -2, (short) -9).max());
        Assert.assertEquals(32L, this.newWith((short) 1, (short) 0, (short) 9, (short) 30, (short) 31, (short) 32).max());
        Assert.assertEquals(32L, this.newWith((short) -1, (short) 0, (short) 9, (short) 30, (short) 31, (short) 32).max());
        Assert.assertEquals(31L, this.newWith((short) 31, (short) 0, (short) 30).max());
        Assert.assertEquals(39L, this.newWith((short) 32, (short) 39, (short) 35).max());
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyCollection() {
        this.newWith().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(-2L, this.newWith((short) -1, (short) -2, (short) 9).min());
        Assert.assertEquals(0L, this.newWith((short) 1, (short) 0, (short) 9, (short) 30, (short) 31, (short) 32).min());
        Assert.assertEquals(-1L, this.newWith((short) -1, (short) 0, (short) 9, (short) 30, (short) 31, (short) 32).min());
        Assert.assertEquals(31L, this.newWith((short) 31, (short) 32, (short) 33).min());
        Assert.assertEquals(32L, this.newWith((short) 32, (short) 39, (short) 35).min());
        Assert.assertEquals(1L, this.classUnderTest().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyCollection() {
        this.newWith().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, this.newWith().minIfEmpty((short) 5));
        Assert.assertEquals(0L, this.newWith().minIfEmpty((short) 0));
        Assert.assertEquals(0L, this.newWith((short) 1, (short) 0, (short) 9, (short) 7).minIfEmpty((short) 5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? (short) 5 : (short) 1, this.classUnderTest().minIfEmpty((short) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.newWith().maxIfEmpty((short) 5));
        Assert.assertEquals(0L, this.newWith().maxIfEmpty((short) 0));
        Assert.assertEquals(9L, this.newWith((short) 1, (short) 0, (short) 9, (short) 7).maxIfEmpty((short) 5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? (short) 5 : size, this.classUnderTest().maxIfEmpty((short) 5));
    }

    @Test
    public void sum() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().sum());
        Assert.assertEquals(10L, this.newWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4).sum());
        Assert.assertEquals(93L, this.newWith((short) 30, (short) 31, (short) 32).sum());
    }

    @Test
    public void summaryStatistics() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().summaryStatistics().getSum());
        Assert.assertEquals(10L, this.newWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4).summaryStatistics().getSum());
        Assert.assertEquals(93L, this.newWith((short) 30, (short) 31, (short) 32).summaryStatistics().getSum());
    }

    @Test
    public void average() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().average(), 0.0);
        Assert.assertEquals(2.5, this.newWith((short) 1, (short) 2, (short) 3, (short) 4).average(), 0.0);
        Assert.assertEquals(2.5, this.newWith((short) 1, (short) 2, (short) 3, (short) 4).average(), 0.0);
        Assert.assertEquals(31.0, this.newWith((short) 30, (short) 30, (short) 31, (short) 31, (short) 32, (short) 32).average(), 0.0);
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
        Assert.assertEquals(2.5, this.newWith((short) 1, (short) 2, (short) 3, (short) 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith((short) 1, (short) 2, (short) 3, (short) 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith((short) 30, (short) 30, (short) 31, (short) 31, (short) 32, (short) 32).averageIfEmpty(0.0), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(1.0, this.newWith((short) 1).median(), 0.0);
        Assert.assertEquals(2.5, this.newWith((short) 1, (short) 2, (short) 3, (short) 4).median(), 0.0);
        Assert.assertEquals(3.0, this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5).median(), 0.0);
        Assert.assertEquals(31.0, this.newWith((short) 30, (short) 30, (short) 31, (short) 31, (short) 32).median(), 0.0);
        Assert.assertEquals(30.5, this.newWith((short) 1, (short) 30, (short) 30, (short) 31, (short) 31, (short) 32).median(), 0.0);
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
        Assert.assertEquals(1.0, this.newWith((short) 1).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith((short) 1, (short) 2, (short) 3, (short) 4).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(3.0, this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith((short) 30, (short) 30, (short) 31, (short) 31, (short) 32).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(30.5, this.newWith((short) 1, (short) 30, (short) 30, (short) 31, (short) 31, (short) 32).medianIfEmpty(0.0), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().toArray().length);
        ShortIterable iterable = this.newWith((short) 1, (short) 2);
        Assert.assertTrue(Arrays.equals(new short[] { (short) 1, (short) 2 }, iterable.toArray()) || Arrays.equals(new short[] { (short) 2, (short) 1 }, iterable.toArray()));
        Assert.assertTrue(Arrays.equals(new short[] { (short) 0, (short) 1 }, this.newWith((short) 0, (short) 1).toArray()) || Arrays.equals(new short[] { (short) 1, (short) 0 }, this.newWith((short) 0, (short) 1).toArray()));
        Assert.assertTrue(Arrays.equals(new short[] { (short) 1, (short) 31 }, this.newWith((short) 1, (short) 31).toArray()) || Arrays.equals(new short[] { (short) 31, (short) 1 }, this.newWith((short) 1, (short) 31).toArray()));
        Assert.assertTrue(Arrays.equals(new short[] { (short) 31, (short) 35 }, this.newWith((short) 31, (short) 35).toArray()) || Arrays.equals(new short[] { (short) 35, (short) 31 }, this.newWith((short) 31, (short) 35).toArray()));
        Assert.assertArrayEquals(new short[] {}, this.newWith().toArray());
        Assert.assertArrayEquals(new short[] { (short) 32 }, this.newWith((short) 32).toArray());
    }

    @Test
    public void toArrayWithTargetArray() {
        short[] originalAsSortedArray = this.classUnderTest().toSortedArray();
        short[] target = new short[this.classUnderTest().size()];
        Assert.assertSame(target, this.classUnderTest().toArray(target));
        Arrays.sort(target);
        Assert.assertTrue(Arrays.equals(originalAsSortedArray, target));
        if (this.classUnderTest().size() > 0) {
            short[] targetTooSmall = new short[this.classUnderTest().size() - 1];
            short[] result = this.classUnderTest().toArray(targetTooSmall);
            Assert.assertNotSame(targetTooSmall, result);
            Arrays.sort(result);
            Assert.assertTrue(Arrays.equals(this.classUnderTest().toSortedArray(), result));
        }
        short[] targetTooBig = new short[this.classUnderTest().size() + 1];
        short[] bigResult = this.classUnderTest().toArray(targetTooBig);
        Assert.assertSame(targetTooBig, bigResult);
        Arrays.sort(targetTooBig);
        for (int i = 0; i < originalAsSortedArray.length; i++) {
            Assert.assertEquals(originalAsSortedArray[i], bigResult[i + 1]);
        }
    }

    @Test
    public void toSortedArray() {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        short[] array = new short[size];
        for (int i = 0; i < size; i++) {
            array[i] = (short) (i + 1);
        }
        Assert.assertArrayEquals(array, iterable.toSortedArray());
        Assert.assertArrayEquals(new short[] { (short) 1, (short) 3, (short) 7, (short) 9 }, this.newWith((short) 3, (short) 1, (short) 9, (short) 7).toSortedArray());
    }

    @Test
    public void testEquals() {
        ShortIterable iterable1 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
        ShortIterable iterable3 = this.newWith((short) 5, (short) 6, (short) 7, (short) 8);
        ShortIterable iterable4 = this.newWith((short) 5, (short) 6, (short) 7);
        ShortIterable iterable5 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        ShortIterable iterable6 = this.newWith((short) 1, (short) 31, (short) 32);
        ShortIterable iterable7 = this.newWith((short) 35, (short) 31, (short) 1);
        ShortIterable iterable8 = this.newWith((short) 32, (short) 31, (short) 1, (short) 50);
        ShortIterable iterable9 = this.newWith((short) 0, (short) 1, (short) 2);
        ShortIterable iterable10 = this.newWith((short) 0, (short) 1, (short) 3);
        ShortIterable iterable11 = this.newWith((short) 3, (short) 1, (short) 2);
        ShortIterable iterable12 = this.newWith((short) 3);
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
        Assert.assertNotEquals(this.newWith(), this.newWith((short) 100));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(this.newObjectCollectionWith((short) 1, (short) 2, (short) 3).hashCode(), this.newWith((short) 1, (short) 2, (short) 3).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((short) 0, (short) 1, (short) 31).hashCode(), this.newWith((short) 0, (short) 1, (short) 31).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((short) 32).hashCode(), this.newWith((short) 32).hashCode());
        Assert.assertNotEquals(this.newObjectCollectionWith((short) 32).hashCode(), this.newWith((short) 0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((short) 31, (short) 32, (short) 50).hashCode(), this.newWith((short) 31, (short) 32, (short) 50).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((short) 32, (short) 50, (short) 60).hashCode(), this.newWith((short) 32, (short) 50, (short) 60).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[1]", this.newWith((short) 1).toString());
        Assert.assertEquals("[31]", this.newWith((short) 31).toString());
        Assert.assertEquals("[32]", this.newWith((short) 32).toString());
        ShortIterable iterable = this.newWith((short) 1, (short) 2);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        ShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        ShortIterable iterable3 = this.newWith((short) 32, (short) 33);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        ShortIterable iterable4 = this.newWith((short) 0, (short) 1);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        ShortIterable iterable = this.classUnderTest();
        Assert.assertEquals("1", this.newWith((short) 1).makeString("/"));
        Assert.assertEquals("31", this.newWith((short) 31).makeString());
        Assert.assertEquals("32", this.newWith((short) 32).makeString());
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        ShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        ShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        ShortIterable iterable3 = this.newWith((short) 32, (short) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        ShortIterable iterable4 = this.newWith((short) 1, (short) 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        ShortIterable iterable5 = this.newWith((short) 0, (short) 1);
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
        this.newWith((short) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        ShortIterable iterable = this.newWith((short) 1, (short) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable5 = new StringBuilder();
        this.newWith((short) 31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith((short) 32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        ShortIterable iterable1 = this.newWith((short) 0, (short) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        ShortIterable iterable2 = this.newWith((short) 31, (short) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        ShortIterable iterable4 = this.newWith((short) 32, (short) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        ShortIterable iterable5 = this.newWith((short) 0, (short) 1);
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
        ShortIterable iterable = this.newWith((short) 31, (short) 32);
        Assert.assertTrue(ShortArrayList.newListWith((short) 31, (short) 32).equals(iterable.toList()) || ShortArrayList.newListWith((short) 32, (short) 31).equals(iterable.toList()));
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.newWith((short) 0).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 31), this.newWith((short) 31).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 32), this.newWith((short) 32).toList());
        Assert.assertEquals(new ShortArrayList(), this.newWith().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ShortArrayList.newListWith(), this.newWith().toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), this.newWith((short) 1).toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 1, (short) 31), this.newWith((short) 0, (short) 31, (short) 1).toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 31, (short) 32, (short) 1).toSortedList());
    }

    @Test
    public void toSortedListByComparator() {
        ShortIterable iterable = this.newWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9);
        // odd/even comparator
        MutableShortList result = iterable.toSortedList((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertNotSame(iterable, result);
        result.collectBoolean(e -> e % 2 == 0, BooleanLists.mutable.of()).forEachWithIndex((e, i) -> Assert.assertEquals("index " + i, i < 5, e));
    }

    @Test
    public void toSortedListByFunctionNaturalOrder() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        ShortIterable index = this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4);
        MutableShortList result = index.toSortedListBy(i -> list.get((int) i));
        Assert.assertNotSame(index, result);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 0, (short) 4, (short) 3), result);
    }

    @Test
    public void toSortedListByFunctionWithComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        ShortIterable index = this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4);
        MutableShortList result = index.toSortedListBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertNotSame(index, result);
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 4, (short) 0, (short) 2, (short) 1), result);
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), this.newWith((short) 1).toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3).toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31), this.newWith((short) 0, (short) 1, (short) 31).toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 1, (short) 31, (short) 32).toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3).toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(new ShortHashBag(), this.newWith().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), this.newWith((short) 1).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), this.newWith((short) 1, (short) 2, (short) 3).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3), this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 1, (short) 31, (short) 32).toBag());
    }

    @Test
    public void asLazy() {
        ShortIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyShortIterable.class, iterable.asLazy());
        ShortIterable iterable1 = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(iterable1.toBag(), iterable1.asLazy().toBag());
        Verify.assertInstanceOf(LazyShortIterable.class, iterable1.asLazy());
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(iterable2.toBag(), iterable2.asLazy().toBag());
        Verify.assertInstanceOf(LazyShortIterable.class, iterable2.asLazy());
        ShortIterable iterable3 = this.newWith();
        Assert.assertEquals(iterable3.toBag(), iterable3.asLazy().toBag());
        Verify.assertInstanceOf(LazyShortIterable.class, iterable3.asLazy());
        ShortIterable iterable4 = this.newWith((short) 1);
        Assert.assertEquals(iterable4.toBag(), iterable4.asLazy().toBag());
        Verify.assertInstanceOf(LazyShortIterable.class, iterable4.asLazy());
    }

    @Test
    public void injectInto() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        Short sum1 = iterable1.injectInto(Short.valueOf((short) 0), (Short result, short value) -> Short.valueOf((short) (result + value + 1)));
        Assert.assertEquals(Short.valueOf((short) 36), sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        Short sum2 = iterable2.injectInto(Short.valueOf((short) 0), (Short result, short value) -> Short.valueOf((short) (result + value + 1)));
        Assert.assertEquals(Short.valueOf((short) 37), sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        Short sum3 = iterable3.injectInto(Short.valueOf((short) 0), (Short result, short value) -> Short.valueOf((short) (result + value + 1)));
        Assert.assertEquals(Short.valueOf((short) 38), sum3);
    }

    @Test
    public void injectIntoBoolean() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        boolean sum1 = iterable1.injectIntoBoolean(false, (boolean result, short value) -> (boolean) (result || value == (short) 0));
        Assert.assertEquals(true, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        boolean sum2 = iterable2.injectIntoBoolean(false, (boolean result, short value) -> (boolean) (result || value == (short) 0));
        Assert.assertEquals(false, sum2);
    }

    @Test
    public void injectIntoByte() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        byte sum1 = iterable1.injectIntoByte((byte) 0, (byte result, short value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 36, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        byte sum2 = iterable2.injectIntoByte((byte) 0, (byte result, short value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 37, sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        byte sum3 = iterable3.injectIntoByte((byte) 0, (byte result, short value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 38, sum3);
    }

    @Test
    public void injectIntoChar() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        char sum1 = iterable1.injectIntoChar((char) 0, (char result, short value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 36, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        char sum2 = iterable2.injectIntoChar((char) 0, (char result, short value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 37, sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        char sum3 = iterable3.injectIntoChar((char) 0, (char result, short value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 38, sum3);
    }

    @Test
    public void injectIntoShort() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        short sum1 = iterable1.injectIntoShort((short) 0, (short result, short value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 36, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        short sum2 = iterable2.injectIntoShort((short) 0, (short result, short value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 37, sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        short sum3 = iterable3.injectIntoShort((short) 0, (short result, short value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 38, sum3);
    }

    @Test
    public void injectIntoInt() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        int sum1 = iterable1.injectIntoInt(0, (int result, short value) -> (int) (result + value + 1));
        Assert.assertEquals(36, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        int sum2 = iterable2.injectIntoInt(0, (int result, short value) -> (int) (result + value + 1));
        Assert.assertEquals(37, sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        int sum3 = iterable3.injectIntoInt(0, (int result, short value) -> (int) (result + value + 1));
        Assert.assertEquals(38, sum3);
    }

    @Test
    public void injectIntoFloat() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        float sum1 = iterable1.injectIntoFloat(0.0f, (float result, short value) -> (float) (result + value + 1));
        Assert.assertEquals(36.0f, sum1, 0.001);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        float sum2 = iterable2.injectIntoFloat(0.0f, (float result, short value) -> (float) (result + value + 1));
        Assert.assertEquals(37.0f, sum2, 0.001);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        float sum3 = iterable3.injectIntoFloat(0.0f, (float result, short value) -> (float) (result + value + 1));
        Assert.assertEquals(38.0f, sum3, 0.001);
    }

    @Test
    public void injectIntoLong() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        long sum1 = iterable1.injectIntoLong(0L, (long result, short value) -> (long) (result + value + 1));
        Assert.assertEquals(36L, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        long sum2 = iterable2.injectIntoLong(0L, (long result, short value) -> (long) (result + value + 1));
        Assert.assertEquals(37L, sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        long sum3 = iterable3.injectIntoLong(0L, (long result, short value) -> (long) (result + value + 1));
        Assert.assertEquals(38L, sum3);
    }

    @Test
    public void injectIntoDouble() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        double sum1 = iterable1.injectIntoDouble(0.0, (double result, short value) -> (double) (result + value + 1));
        Assert.assertEquals(36.0, sum1, 0.001);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        double sum2 = iterable2.injectIntoDouble(0.0, (double result, short value) -> (double) (result + value + 1));
        Assert.assertEquals(37.0, sum2, 0.001);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        double sum3 = iterable3.injectIntoDouble(0.0, (double result, short value) -> (double) (result + value + 1));
        Assert.assertEquals(38.0, sum3, 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void reduceOnEmptyThrows() {
        this.newWith().reduce((long result, short value) -> (long) result + (long) value + 1L);
    }

    @Test
    public void reduce() {
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        long sum1 = iterable1.reduce((long result, short value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(35L, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        long sum2 = iterable2.reduce((long result, short value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(36L, sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        long sum3 = iterable3.reduce((long result, short value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void reduceIfEmpty() {
        long empty1 = this.newWith().reduceIfEmpty((long result, short value) -> (long) result + (long) value + 1L, 1L);
        Assert.assertEquals(1L, empty1);
        long empty2 = this.newWith().reduceIfEmpty((long result, short value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(0L, empty2);
        ShortIterable iterable1 = this.newWith((short) 0, (short) 2, (short) 31);
        long sum1 = iterable1.reduceIfEmpty((long result, short value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(35L, sum1);
        ShortIterable iterable2 = this.newWith((short) 1, (short) 2, (short) 31);
        long sum2 = iterable2.reduceIfEmpty((long result, short value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(36L, sum2);
        ShortIterable iterable3 = this.newWith((short) 0, (short) 1, (short) 2, (short) 31);
        long sum3 = iterable3.reduceIfEmpty((long result, short value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void chunk() {
        ShortIterable iterable = this.newWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((short) 0), this.newMutableCollectionWith((short) 1), this.newMutableCollectionWith((short) 2), this.newMutableCollectionWith((short) 3), this.newMutableCollectionWith((short) 4), this.newMutableCollectionWith((short) 5)).toSet(), iterable.chunk(1).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((short) 0, (short) 1), this.newMutableCollectionWith((short) 2, (short) 3), this.newMutableCollectionWith((short) 4, (short) 5)).toSet(), iterable.chunk(2).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((short) 0, (short) 1, (short) 2), this.newMutableCollectionWith((short) 3, (short) 4, (short) 5)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3), this.newMutableCollectionWith((short) 4, (short) 5)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5)).toSet(), iterable.chunk(6).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5)).toSet(), iterable.chunk(7).toSet());
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((short) 0)), this.newWith((short) 0).chunk(1));
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator, this.description("shortIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::shortIterator_throws, this.description("shortIterator_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::shortIterator_throws_non_empty_collection, this.description("shortIterator_throws_non_empty_collection"), java.util.NoSuchElementException.class);
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
        public abstract AbstractShortIterableTestCase implementation();
    }
}
