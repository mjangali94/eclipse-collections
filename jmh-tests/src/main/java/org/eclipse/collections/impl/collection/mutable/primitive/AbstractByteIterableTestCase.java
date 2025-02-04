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
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
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
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ByteIterable}s
 * This file was automatically generated from template file abstractPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractByteIterableTestCase {

    protected abstract ByteIterable classUnderTest();

    protected abstract ByteIterable newWith(byte... elements);

    protected abstract ByteIterable newMutableCollectionWith(byte... elements);

    protected abstract RichIterable<Byte> newObjectCollectionWith(Byte... elements);

    @Test
    public void newCollectionWith() {
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Verify.assertSize(3, iterable);
        Verify.assertSize(4, this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2, (byte) 3));
        ByteIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll((byte) 1, (byte) 2, (byte) 3));
        ByteIterable iterable2 = this.newWith((byte) 1);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll((byte) 1, (byte) 2, (byte) 3));
    }

    @Test
    public void newCollection() {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 31, (byte) 32), this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32));
        Verify.assertNotEmpty(this.newWith((byte) 0, (byte) 1, (byte) 2));
        Verify.assertNotEmpty(this.newWith((byte) 0, (byte) 31));
        Verify.assertNotEmpty(this.newWith((byte) 31, (byte) 32));
        Verify.assertNotEmpty(this.newWith((byte) 32, (byte) 33));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32).notEmpty());
        Assert.assertTrue(this.newWith((byte) 0, (byte) 1, (byte) 2).notEmpty());
        Assert.assertTrue(this.newWith((byte) 0, (byte) 31).notEmpty());
        Assert.assertTrue(this.newWith((byte) 31, (byte) 32).notEmpty());
        Assert.assertTrue(this.newWith((byte) 32, (byte) 33).notEmpty());
    }

    @Test
    public void tap() {
        MutableByteList tapResult = ByteLists.mutable.empty();
        ByteIterable collection = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void contains() {
        ByteIterable iterable = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertFalse(iterable.contains((byte) 29));
        Assert.assertFalse(iterable.contains((byte) 49));
        byte[] numbers = { (byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1 };
        for (byte number : numbers) {
            Assert.assertTrue(iterable.contains(number));
        }
        Assert.assertFalse(iterable.contains((byte) -1));
        Assert.assertFalse(iterable.contains((byte) 29));
        Assert.assertFalse(iterable.contains((byte) 49));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(iterable1.contains((byte) 0));
        Assert.assertTrue(iterable1.contains((byte) 1));
        Assert.assertTrue(iterable1.contains((byte) 2));
        Assert.assertFalse(iterable1.contains((byte) 3));
        ByteIterable iterable2 = this.classUnderTest();
        for (byte each = 1; each <= iterable2.size(); each++) {
            Assert.assertTrue(iterable2.contains(each));
        }
        Assert.assertFalse(iterable2.contains((byte) (iterable2.size() + 1)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toArray()));
        Assert.assertFalse(this.classUnderTest().containsAll((byte) (this.classUnderTest().size() + 1)));
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertTrue(iterable.containsAll((byte) 1));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(iterable.containsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertFalse(iterable.containsAll((byte) 1, (byte) 2, (byte) 4));
        Assert.assertFalse(iterable.containsAll((byte) 4, (byte) 5, (byte) 6));
        ByteIterable iterable1 = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertTrue(iterable1.containsAll((byte) 14));
        Assert.assertTrue(iterable1.containsAll((byte) 35));
        Assert.assertFalse(iterable1.containsAll((byte) -1));
        Assert.assertTrue(iterable1.containsAll((byte) 14, (byte) 1, (byte) 30));
        Assert.assertTrue(iterable1.containsAll((byte) 14, (byte) 1, (byte) 32));
        Assert.assertTrue(iterable1.containsAll((byte) 14, (byte) 1, (byte) 35));
        Assert.assertFalse(iterable1.containsAll((byte) 0, (byte) 2, (byte) 35, (byte) -1));
        Assert.assertFalse(iterable1.containsAll((byte) 31, (byte) -1));
        ByteIterable iterable2 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(iterable2.containsAll((byte) 0));
        Assert.assertTrue(iterable2.containsAll((byte) 0, (byte) 0, (byte) 0));
        Assert.assertTrue(iterable2.containsAll((byte) 0, (byte) 1, (byte) 1));
        Assert.assertTrue(iterable2.containsAll((byte) 0, (byte) 1, (byte) 2));
        Assert.assertFalse(iterable2.containsAll((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertFalse(iterable2.containsAll((byte) 3, (byte) 4));
        int size = 33;
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) (i + 1);
        }
        ByteIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertTrue(iterable3.containsAll());
        Assert.assertFalse(iterable3.containsAll((byte) 3, (byte) 4, (byte) 5, (byte) 33, (byte) 34));
        Assert.assertTrue(iterable3.containsAll(array));
        ByteIterable iterable4 = ByteSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertTrue(iterable4.containsAll());
        Assert.assertFalse(iterable4.containsAll((byte) 3, (byte) 4, (byte) 5, (byte) 33, (byte) 34));
        Assert.assertTrue(iterable4.containsAll(array));
    }

    @Test
    public void containsAllIterable() {
        ByteIterable source = this.classUnderTest();
        Assert.assertTrue(source.containsAll(this.classUnderTest()));
        Assert.assertFalse(source.containsAll(ByteArrayList.newListWith((byte) (source.size() + 1))));
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertTrue(this.newWith().containsAll(new ByteArrayList()));
        Assert.assertFalse(this.newWith().containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4)));
        Assert.assertFalse(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 4)));
        Assert.assertFalse(iterable.containsAll(ByteArrayList.newListWith((byte) 4, (byte) 5, (byte) 6)));
        ByteIterable iterable1 = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertTrue(iterable1.containsAll(ByteHashSet.newSetWith((byte) 14)));
        Assert.assertTrue(iterable1.containsAll(ByteHashSet.newSetWith((byte) 35)));
        Assert.assertFalse(iterable1.containsAll(ByteHashSet.newSetWith((byte) -1)));
        Assert.assertTrue(iterable1.containsAll(ByteHashSet.newSetWith((byte) 14, (byte) 1, (byte) 30)));
        Assert.assertTrue(iterable1.containsAll(ByteHashSet.newSetWith((byte) 14, (byte) 1, (byte) 32)));
        Assert.assertTrue(iterable1.containsAll(ByteHashSet.newSetWith((byte) 14, (byte) 1, (byte) 35)));
        Assert.assertFalse(iterable1.containsAll(ByteHashSet.newSetWith((byte) 0, (byte) 2, (byte) 35, (byte) -1)));
        Assert.assertFalse(iterable1.containsAll(ByteHashSet.newSetWith((byte) 31, (byte) -1)));
        ByteIterable iterable2 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(iterable2.containsAll(ByteArrayList.newListWith((byte) 0)));
        Assert.assertTrue(iterable2.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 0, (byte) 0)));
        Assert.assertTrue(iterable2.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 1)));
        Assert.assertTrue(iterable2.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
        Assert.assertFalse(iterable2.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4)));
        Assert.assertFalse(iterable2.containsAll(ByteArrayList.newListWith((byte) 3, (byte) 4)));
        int size = 33;
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) (i + 1);
        }
        ByteIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(ByteLists.immutable.with((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertTrue(iterable3.containsAll(ByteLists.mutable.empty()));
        Assert.assertFalse(iterable3.containsAll(ByteLists.mutable.with((byte) 3, (byte) 4, (byte) 5, (byte) 33, (byte) 34)));
        Assert.assertTrue(iterable3.containsAll(ByteLists.immutable.with(array)));
        ByteIterable iterable4 = ByteSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(ByteLists.immutable.with((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertTrue(iterable4.containsAll(ByteLists.mutable.empty()));
        Assert.assertFalse(iterable4.containsAll(ByteLists.mutable.with((byte) 3, (byte) 4, (byte) 5, (byte) 33, (byte) 34)));
        Assert.assertTrue(iterable4.containsAll(ByteLists.immutable.with(array)));
    }

    @Test
    public void containsAnyArray() {
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        Assert.assertTrue(iterable.containsAny((byte) 1, (byte) 1, (byte) 1));
        Assert.assertFalse(iterable.containsAny());
        Assert.assertTrue(iterable.containsAny((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(iterable.containsAny((byte) 6, (byte) 7, (byte) 8));
        ByteIterable iterable2 = this.newWith((byte) 0, (byte) 1, (byte) 3, (byte) 7);
        Assert.assertTrue(iterable2.containsAny((byte) 3, (byte) 3, (byte) 1, (byte) 9));
        Assert.assertFalse(iterable2.containsAny());
        Assert.assertTrue(iterable2.containsAny((byte) -1, (byte) 3, (byte) 5));
        Assert.assertFalse(iterable2.containsAny((byte) 2, (byte) 4, (byte) 6));
        int size = 33;
        byte[] array = new byte[size];
        byte[] unmatched = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) (i + 1);
            unmatched[i] = (byte) (i + 34);
        }
        ByteIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(array));
        Assert.assertFalse(iterable3.containsAny(unmatched));
        ByteIterable iterable4 = ByteSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(array));
        Assert.assertFalse(iterable4.containsAny(unmatched));
        ByteIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny());
        Assert.assertFalse(emptyIterable.containsAny((byte) 0, (byte) 0));
        Assert.assertFalse(emptyIterable.containsAny((byte) -1));
        Assert.assertFalse(emptyIterable.containsAny((byte) 1, (byte) 2, (byte) 3));
    }

    @Test
    public void containsAnyIterable() {
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        Assert.assertTrue(iterable.containsAny(ByteLists.immutable.with((byte) 1, (byte) 1, (byte) 1)));
        Assert.assertFalse(iterable.containsAny(ByteLists.mutable.empty()));
        Assert.assertTrue(iterable.containsAny(ByteLists.immutable.with((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(iterable.containsAny(ByteLists.mutable.with((byte) 6, (byte) 7, (byte) 8)));
        ByteIterable iterable2 = this.newWith((byte) 0, (byte) 1, (byte) 3, (byte) 7);
        Assert.assertTrue(iterable2.containsAny(ByteSets.immutable.with((byte) 3, (byte) 3, (byte) 1, (byte) 9)));
        Assert.assertFalse(iterable2.containsAny(ByteSets.mutable.empty()));
        Assert.assertTrue(iterable2.containsAny(ByteSets.immutable.with((byte) -1, (byte) 3, (byte) 5)));
        Assert.assertFalse(iterable2.containsAny(ByteSets.mutable.with((byte) 2, (byte) 4, (byte) 6)));
        ByteIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny(ByteLists.mutable.empty()));
        Assert.assertFalse(emptyIterable.containsAny(ByteLists.immutable.with((byte) 0, (byte) 0)));
        Assert.assertFalse(emptyIterable.containsAny(ByteLists.mutable.with((byte) -1)));
        Assert.assertFalse(emptyIterable.containsAny(ByteLists.immutable.with((byte) 1, (byte) 2, (byte) 3)));
        int size = 33;
        byte[] array = new byte[size];
        byte[] unmatched = new byte[size];
        byte[] bigger = new byte[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) (i + 1);
            bigger[i] = (byte) (i + 1);
            unmatched[i] = (byte) (i + 34);
        }
        bigger[size - 1] = (byte) 33;
        ByteIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(ByteLists.immutable.with(array)));
        Assert.assertFalse(iterable3.containsAny(ByteLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsAny(ByteSets.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsAny(ByteSets.mutable.with(bigger)));
        ByteIterable iterable4 = ByteSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(ByteLists.immutable.with(array)));
        Assert.assertFalse(iterable4.containsAny(ByteLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable4.containsAny(ByteSets.immutable.with(array)));
        Assert.assertTrue(iterable4.containsAny(ByteSets.immutable.with(bigger)));
    }

    @Test
    public void containsNoneArray() {
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertFalse(iterable.containsNone((byte) 1, (byte) 1));
        Assert.assertTrue(iterable.containsNone());
        Assert.assertFalse(iterable.containsNone((byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertTrue(iterable.containsNone((byte) 7, (byte) 8, (byte) 11));
        ByteIterable iterable2 = this.newWith((byte) 0, (byte) 1, (byte) 3, (byte) 7);
        Assert.assertTrue(iterable2.containsNone((byte) 2, (byte) 4, (byte) 6));
        Assert.assertTrue(iterable2.containsNone());
        Assert.assertFalse(iterable2.containsNone((byte) -1, (byte) 1, (byte) 3));
        Assert.assertFalse(iterable2.containsNone((byte) 7, (byte) 3, (byte) 1, (byte) 0));
        int size = 33;
        byte[] array = new byte[size];
        byte[] unmatched = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) (i + 1);
            unmatched[i] = (byte) (i + 34);
        }
        ByteIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(array));
        Assert.assertTrue(iterable3.containsNone(unmatched));
        ByteIterable iterable4 = ByteSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(array));
        Assert.assertTrue(iterable4.containsNone(unmatched));
        ByteIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone((byte) 1, (byte) 2, (byte) 3));
        Assert.assertTrue(emptyIterable.containsNone());
        Assert.assertTrue(emptyIterable.containsNone((byte) -1, (byte) 5));
        Assert.assertTrue(emptyIterable.containsNone((byte) 0));
    }

    @Test
    public void containsNoneIterable() {
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertFalse(iterable.containsNone(ByteLists.immutable.with((byte) 1, (byte) 1)));
        Assert.assertTrue(iterable.containsNone(ByteLists.mutable.empty()));
        Assert.assertFalse(iterable.containsNone(ByteLists.mutable.with((byte) 3, (byte) 4, (byte) 5, (byte) 6)));
        Assert.assertTrue(iterable.containsNone(ByteLists.immutable.with((byte) 7, (byte) 8, (byte) 11)));
        ByteIterable iterable2 = this.newWith((byte) 0, (byte) 1, (byte) 3, (byte) 7);
        Assert.assertTrue(iterable2.containsNone(ByteSets.immutable.with((byte) 2, (byte) 4, (byte) 6)));
        Assert.assertTrue(iterable2.containsNone(ByteSets.mutable.empty()));
        Assert.assertFalse(iterable2.containsNone(ByteSets.immutable.with((byte) -1, (byte) 1, (byte) 3)));
        Assert.assertFalse(iterable2.containsNone(ByteSets.mutable.with((byte) 7, (byte) 3, (byte) 1, (byte) 0)));
        ByteIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(ByteLists.immutable.with((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertTrue(emptyIterable.containsNone(ByteLists.mutable.empty()));
        Assert.assertTrue(emptyIterable.containsNone(ByteLists.immutable.with((byte) -1, (byte) 5)));
        Assert.assertTrue(emptyIterable.containsNone(ByteLists.mutable.with((byte) 0)));
        int size = 33;
        byte[] array = new byte[size];
        byte[] unmatched = new byte[size];
        byte[] bigger = new byte[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) (i + 1);
            bigger[i] = (byte) (i + 1);
            unmatched[i] = (byte) (i + 34);
        }
        bigger[size - 1] = (byte) 33;
        ByteIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(ByteLists.immutable.with(array)));
        Assert.assertTrue(iterable3.containsNone(ByteLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsNone(ByteSets.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsNone(ByteSets.mutable.with(bigger)));
        ByteIterable iterable4 = ByteSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(ByteLists.immutable.with(array)));
        Assert.assertTrue(iterable4.containsNone(ByteLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable4.containsNone(ByteSets.immutable.with(array)));
        Assert.assertFalse(iterable4.containsNone(ByteSets.immutable.with(bigger)));
    }

    @Test
    public abstract void byteIterator();

    @Test(expected = NoSuchElementException.class)
    public void byteIterator_throws() {
        ByteIterator iterator = this.classUnderTest().byteIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void byteIterator_throws_non_empty_collection() {
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        ByteIterator iterator = iterable.byteIterator();
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
        Verify.assertSize(1, this.newWith((byte) 3));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Test
    public void count() {
        ByteIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 3 ? 3 : size, iterable.count(BytePredicates.lessThan((byte) 4)));
        Assert.assertEquals(2L, this.newWith((byte) 1, (byte) 0, (byte) 2).count(BytePredicates.greaterThan((byte) 0)));
        Assert.assertEquals(1, this.newWith((byte) 1).count(BytePredicates.alwaysTrue()));
        Assert.assertEquals(0, this.newWith((byte) 1).count(BytePredicates.alwaysFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, (byte) -1, (byte) 2).anySatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) -1, (byte) 2).anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWith((byte) -1, (byte) -1, (byte) -2, (byte) 31, (byte) 32).anySatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 2, (byte) -1, (byte) -2, (byte) 31, (byte) 32).anySatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) -1, (byte) 31, (byte) 32).anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 32).anySatisfy(BytePredicates.greaterThan((byte) 0)));
        ByteIterable iterable = this.newWith((byte) 0, (byte) 1, (byte) 2);
        Assert.assertTrue(iterable.anySatisfy(value -> value < (byte) 3));
        Assert.assertFalse(iterable.anySatisfy(BytePredicates.greaterThan((byte) 3)));
        ByteIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(BytePredicates.greaterThan((byte) 3)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newWith((byte) 1, (byte) 0, (byte) 2).allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 3).allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 0, (byte) 31, (byte) 32).allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 0, (byte) 31, (byte) 32).allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 31, (byte) 32).allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 32).allSatisfy(BytePredicates.equal((byte) 33)));
        Assert.assertFalse(this.newWith((byte) -32).allSatisfy(BytePredicates.equal((byte) 33)));
        ByteIterable iterable = this.newWith((byte) 0, (byte) 1, (byte) 2);
        Assert.assertFalse(iterable.allSatisfy(value -> (byte) 3 < value));
        Assert.assertTrue(iterable.allSatisfy(BytePredicates.lessThan((byte) 3)));
        ByteIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(BytePredicates.greaterThan((byte) 3)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newWith((byte) 1, (byte) 0, (byte) 2).noneSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 0, (byte) 2).noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 3).noneSatisfy(BytePredicates.greaterThan((byte) 3)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 0, (byte) 31, (byte) 32).noneSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 1, (byte) 0, (byte) 31, (byte) 32).noneSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(this.newWith((byte) 1, (byte) 2, (byte) 31, (byte) 32).noneSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(this.newWith((byte) 32).noneSatisfy(BytePredicates.greaterThan((byte) 0)));
        ByteIterable iterable = this.newWith((byte) 0, (byte) 1, (byte) 2);
        Assert.assertFalse(iterable.noneSatisfy(value -> (byte) 1 < value));
        Assert.assertTrue(iterable.noneSatisfy(BytePredicates.greaterThan((byte) 3)));
        ByteIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size <= 3, iterable1.noneSatisfy(BytePredicates.greaterThan((byte) 3)));
        Assert.assertEquals(size == 0, iterable1.noneSatisfy(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void collect() {
        ByteToObjectFunction<Byte> function = parameter -> (byte) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 3).collect(function));
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2), iterable.collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((byte) 2), this.newWith((byte) 3).collect(function));
    }

    @Test
    public void collectWithTarget() {
        ByteToObjectFunction<Byte> function = parameter -> (byte) (parameter - 1);
        Assert.assertEquals(Bags.mutable.with((byte) 0, (byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 3).collect(function, Bags.mutable.empty()));
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(Sets.mutable.with((byte) 0, (byte) 1, (byte) 2), iterable.collect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().collect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((byte) 2), this.newWith((byte) 3).collect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectWithTarget() {
        ByteToObjectFunction<List<Byte>> function = parameter -> Lists.mutable.with((byte) (parameter - 1));
        Assert.assertEquals(Bags.mutable.with((byte) 0, (byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 3).flatCollect(function, Bags.mutable.empty()));
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(Sets.mutable.with((byte) 0, (byte) 1, (byte) 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((byte) 2), this.newWith((byte) 3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectIterableWithTarget() {
        ByteToObjectFunction<Iterable<Byte>> function = parameter -> Lists.mutable.with((byte) (parameter - 1)).asLazy();
        Assert.assertEquals(Bags.mutable.with((byte) 0, (byte) 1, (byte) 2), this.newWith((byte) 1, (byte) 2, (byte) 3).flatCollect(function, Bags.mutable.empty()));
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(Sets.mutable.with((byte) 0, (byte) 1, (byte) 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((byte) 2), this.newWith((byte) 3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToLists() {
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2);
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
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2);
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
        ByteIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(BytePredicates.lessThan((byte) 3)));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 0, (byte) 1), iterable1.select(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), iterable1.select(BytePredicates.greaterThan((byte) 1)));
        ByteIterable iterable2 = this.newWith((byte) 0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.select(BytePredicates.alwaysTrue()));
        Verify.assertSize(0, iterable2.select(BytePredicates.alwaysFalse()));
    }

    @Test
    public void selectWithTarget() {
        ByteIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(BytePredicates.lessThan((byte) 4), ByteSets.mutable.empty()));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(BytePredicates.lessThan((byte) 3), ByteSets.mutable.empty()));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(ByteSets.mutable.with((byte) 0, (byte) 1), iterable1.select(BytePredicates.lessThan((byte) 2), ByteSets.mutable.empty()));
        Assert.assertEquals(ByteSets.mutable.with((byte) 2, (byte) 3), iterable1.select(BytePredicates.greaterThan((byte) 1), ByteSets.mutable.empty()));
    }

    @Test
    public void reject() {
        ByteIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(BytePredicates.lessThan((byte) 3)));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), iterable1.reject(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 0, (byte) 1), iterable1.reject(BytePredicates.greaterThan((byte) 1)));
        ByteIterable iterable2 = this.newWith((byte) 0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.reject(BytePredicates.alwaysFalse()));
        Verify.assertSize(0, iterable2.reject(BytePredicates.alwaysTrue()));
    }

    @Test
    public void rejectWithTarget() {
        ByteIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(BytePredicates.lessThan((byte) 4), ByteSets.mutable.empty()));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(BytePredicates.lessThan((byte) 3), ByteSets.mutable.empty()));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(ByteSets.mutable.with((byte) 2, (byte) 3), iterable1.reject(BytePredicates.lessThan((byte) 2), ByteSets.mutable.empty()));
        Assert.assertEquals(ByteSets.mutable.with((byte) 0, (byte) 1), iterable1.reject(BytePredicates.greaterThan((byte) 1), ByteSets.mutable.empty()));
    }

    @Test
    public void detectIfNone() {
        ByteIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(BytePredicates.equal((byte) 4), (byte) 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(BytePredicates.equal((byte) 2), (byte) 0));
        Assert.assertEquals(size > 0 ? 1L : 0L, iterable.detectIfNone(BytePredicates.lessThan((byte) 2), (byte) 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(BytePredicates.lessThan((byte) 1), (byte) 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(BytePredicates.greaterThan((byte) 2), (byte) 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(BytePredicates.greaterThan((byte) 4), (byte) 4));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, this.newWith((byte) -1, (byte) -2, (byte) 9).max());
        Assert.assertEquals(-1L, this.newWith((byte) -1, (byte) -2, (byte) -9).max());
        Assert.assertEquals(32L, this.newWith((byte) 1, (byte) 0, (byte) 9, (byte) 30, (byte) 31, (byte) 32).max());
        Assert.assertEquals(32L, this.newWith((byte) -1, (byte) 0, (byte) 9, (byte) 30, (byte) 31, (byte) 32).max());
        Assert.assertEquals(31L, this.newWith((byte) 31, (byte) 0, (byte) 30).max());
        Assert.assertEquals(39L, this.newWith((byte) 32, (byte) 39, (byte) 35).max());
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyCollection() {
        this.newWith().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(-2L, this.newWith((byte) -1, (byte) -2, (byte) 9).min());
        Assert.assertEquals(0L, this.newWith((byte) 1, (byte) 0, (byte) 9, (byte) 30, (byte) 31, (byte) 32).min());
        Assert.assertEquals(-1L, this.newWith((byte) -1, (byte) 0, (byte) 9, (byte) 30, (byte) 31, (byte) 32).min());
        Assert.assertEquals(31L, this.newWith((byte) 31, (byte) 32, (byte) 33).min());
        Assert.assertEquals(32L, this.newWith((byte) 32, (byte) 39, (byte) 35).min());
        Assert.assertEquals(1L, this.classUnderTest().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyCollection() {
        this.newWith().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, this.newWith().minIfEmpty((byte) 5));
        Assert.assertEquals(0L, this.newWith().minIfEmpty((byte) 0));
        Assert.assertEquals(0L, this.newWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).minIfEmpty((byte) 5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? (byte) 5 : (byte) 1, this.classUnderTest().minIfEmpty((byte) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.newWith().maxIfEmpty((byte) 5));
        Assert.assertEquals(0L, this.newWith().maxIfEmpty((byte) 0));
        Assert.assertEquals(9L, this.newWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).maxIfEmpty((byte) 5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? (byte) 5 : size, this.classUnderTest().maxIfEmpty((byte) 5));
    }

    @Test
    public void sum() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().sum());
        Assert.assertEquals(10L, this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4).sum());
        Assert.assertEquals(93L, this.newWith((byte) 30, (byte) 31, (byte) 32).sum());
    }

    @Test
    public void summaryStatistics() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().summaryStatistics().getSum());
        Assert.assertEquals(10L, this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4).summaryStatistics().getSum());
        Assert.assertEquals(93L, this.newWith((byte) 30, (byte) 31, (byte) 32).summaryStatistics().getSum());
    }

    @Test
    public void average() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().average(), 0.0);
        Assert.assertEquals(2.5, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).average(), 0.0);
        Assert.assertEquals(2.5, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).average(), 0.0);
        Assert.assertEquals(31.0, this.newWith((byte) 30, (byte) 30, (byte) 31, (byte) 31, (byte) 32, (byte) 32).average(), 0.0);
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
        Assert.assertEquals(2.5, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith((byte) 30, (byte) 30, (byte) 31, (byte) 31, (byte) 32, (byte) 32).averageIfEmpty(0.0), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(1.0, this.newWith((byte) 1).median(), 0.0);
        Assert.assertEquals(2.5, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).median(), 0.0);
        Assert.assertEquals(3.0, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).median(), 0.0);
        Assert.assertEquals(31.0, this.newWith((byte) 30, (byte) 30, (byte) 31, (byte) 31, (byte) 32).median(), 0.0);
        Assert.assertEquals(30.5, this.newWith((byte) 1, (byte) 30, (byte) 30, (byte) 31, (byte) 31, (byte) 32).median(), 0.0);
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
        Assert.assertEquals(1.0, this.newWith((byte) 1).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(3.0, this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith((byte) 30, (byte) 30, (byte) 31, (byte) 31, (byte) 32).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(30.5, this.newWith((byte) 1, (byte) 30, (byte) 30, (byte) 31, (byte) 31, (byte) 32).medianIfEmpty(0.0), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().toArray().length);
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2);
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 1, (byte) 2 }, iterable.toArray()) || Arrays.equals(new byte[] { (byte) 2, (byte) 1 }, iterable.toArray()));
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 1 }, this.newWith((byte) 0, (byte) 1).toArray()) || Arrays.equals(new byte[] { (byte) 1, (byte) 0 }, this.newWith((byte) 0, (byte) 1).toArray()));
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 1, (byte) 31 }, this.newWith((byte) 1, (byte) 31).toArray()) || Arrays.equals(new byte[] { (byte) 31, (byte) 1 }, this.newWith((byte) 1, (byte) 31).toArray()));
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 31, (byte) 35 }, this.newWith((byte) 31, (byte) 35).toArray()) || Arrays.equals(new byte[] { (byte) 35, (byte) 31 }, this.newWith((byte) 31, (byte) 35).toArray()));
        Assert.assertArrayEquals(new byte[] {}, this.newWith().toArray());
        Assert.assertArrayEquals(new byte[] { (byte) 32 }, this.newWith((byte) 32).toArray());
    }

    @Test
    public void toArrayWithTargetArray() {
        byte[] originalAsSortedArray = this.classUnderTest().toSortedArray();
        byte[] target = new byte[this.classUnderTest().size()];
        Assert.assertSame(target, this.classUnderTest().toArray(target));
        Arrays.sort(target);
        Assert.assertTrue(Arrays.equals(originalAsSortedArray, target));
        if (this.classUnderTest().size() > 0) {
            byte[] targetTooSmall = new byte[this.classUnderTest().size() - 1];
            byte[] result = this.classUnderTest().toArray(targetTooSmall);
            Assert.assertNotSame(targetTooSmall, result);
            Arrays.sort(result);
            Assert.assertTrue(Arrays.equals(this.classUnderTest().toSortedArray(), result));
        }
        byte[] targetTooBig = new byte[this.classUnderTest().size() + 1];
        byte[] bigResult = this.classUnderTest().toArray(targetTooBig);
        Assert.assertSame(targetTooBig, bigResult);
        Arrays.sort(targetTooBig);
        for (int i = 0; i < originalAsSortedArray.length; i++) {
            Assert.assertEquals(originalAsSortedArray[i], bigResult[i + 1]);
        }
    }

    @Test
    public void toSortedArray() {
        ByteIterable iterable = this.classUnderTest();
        int size = iterable.size();
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) (i + 1);
        }
        Assert.assertArrayEquals(array, iterable.toSortedArray());
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 3, (byte) 7, (byte) 9 }, this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).toSortedArray());
    }

    @Test
    public void testEquals() {
        ByteIterable iterable1 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        ByteIterable iterable3 = this.newWith((byte) 5, (byte) 6, (byte) 7, (byte) 8);
        ByteIterable iterable4 = this.newWith((byte) 5, (byte) 6, (byte) 7);
        ByteIterable iterable5 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        ByteIterable iterable6 = this.newWith((byte) 1, (byte) 31, (byte) 32);
        ByteIterable iterable7 = this.newWith((byte) 35, (byte) 31, (byte) 1);
        ByteIterable iterable8 = this.newWith((byte) 32, (byte) 31, (byte) 1, (byte) 50);
        ByteIterable iterable9 = this.newWith((byte) 0, (byte) 1, (byte) 2);
        ByteIterable iterable10 = this.newWith((byte) 0, (byte) 1, (byte) 3);
        ByteIterable iterable11 = this.newWith((byte) 3, (byte) 1, (byte) 2);
        ByteIterable iterable12 = this.newWith((byte) 3);
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
        Assert.assertNotEquals(this.newWith(), this.newWith((byte) 100));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(this.newObjectCollectionWith((byte) 1, (byte) 2, (byte) 3).hashCode(), this.newWith((byte) 1, (byte) 2, (byte) 3).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 31).hashCode(), this.newWith((byte) 0, (byte) 1, (byte) 31).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((byte) 32).hashCode(), this.newWith((byte) 32).hashCode());
        Assert.assertNotEquals(this.newObjectCollectionWith((byte) 32).hashCode(), this.newWith((byte) 0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((byte) 31, (byte) 32, (byte) 50).hashCode(), this.newWith((byte) 31, (byte) 32, (byte) 50).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((byte) 32, (byte) 50, (byte) 60).hashCode(), this.newWith((byte) 32, (byte) 50, (byte) 60).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[1]", this.newWith((byte) 1).toString());
        Assert.assertEquals("[31]", this.newWith((byte) 31).toString());
        Assert.assertEquals("[32]", this.newWith((byte) 32).toString());
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2);
        Assert.assertTrue("[1, 2]".equals(iterable.toString()) || "[2, 1]".equals(iterable.toString()));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0, 31]") || iterable1.toString().equals("[31, 0]"));
        ByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31, 32]") || iterable2.toString().equals("[32, 31]"));
        ByteIterable iterable3 = this.newWith((byte) 32, (byte) 33);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32, 33]") || iterable3.toString().equals("[33, 32]"));
        ByteIterable iterable4 = this.newWith((byte) 0, (byte) 1);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0, 1]") || iterable4.toString().equals("[1, 0]"));
    }

    @Test
    public void makeString() {
        ByteIterable iterable = this.classUnderTest();
        Assert.assertEquals("1", this.newWith((byte) 1).makeString("/"));
        Assert.assertEquals("31", this.newWith((byte) 31).makeString());
        Assert.assertEquals("32", this.newWith((byte) 32).makeString());
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0, 31") || iterable1.makeString().equals("31, 0"));
        ByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31/32]") || iterable2.makeString("[", "/", "]").equals("[32/31]"));
        ByteIterable iterable3 = this.newWith((byte) 32, (byte) 33);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32/33") || iterable3.makeString("/").equals("33/32"));
        ByteIterable iterable4 = this.newWith((byte) 1, (byte) 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString()) || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/")) || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]")) || "[2/1]".equals(iterable4.makeString("[", "/", "]")));
        ByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
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
        this.newWith((byte) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString()) || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString()) || "2/1".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable5 = new StringBuilder();
        this.newWith((byte) 31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith((byte) 32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString()) || "31, 0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        ByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString()) || "32/31".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        ByteIterable iterable4 = this.newWith((byte) 32, (byte) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString()) || "[33/32]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        ByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
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
        ByteIterable iterable = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(ByteArrayList.newListWith((byte) 31, (byte) 32).equals(iterable.toList()) || ByteArrayList.newListWith((byte) 32, (byte) 31).equals(iterable.toList()));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0), this.newWith((byte) 0).toList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 31), this.newWith((byte) 31).toList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 32), this.newWith((byte) 32).toList());
        Assert.assertEquals(new ByteArrayList(), this.newWith().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ByteArrayList.newListWith(), this.newWith().toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), this.newWith((byte) 1).toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 31), this.newWith((byte) 0, (byte) 31, (byte) 1).toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 31, (byte) 32), this.newWith((byte) 0, (byte) 31, (byte) 32, (byte) 1).toSortedList());
    }

    @Test
    public void toSortedListByComparator() {
        ByteIterable iterable = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9);
        // odd/even comparator
        MutableByteList result = iterable.toSortedList((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertNotSame(iterable, result);
        result.collectBoolean(e -> e % 2 == 0, BooleanLists.mutable.of()).forEachWithIndex((e, i) -> Assert.assertEquals("index " + i, i < 5, e));
    }

    @Test
    public void toSortedListByFunctionNaturalOrder() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        ByteIterable index = this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableByteList result = index.toSortedListBy(i -> list.get((int) i));
        Assert.assertNotSame(index, result);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 0, (byte) 4, (byte) 3), result);
    }

    @Test
    public void toSortedListByFunctionWithComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        ByteIterable index = this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableByteList result = index.toSortedListBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertNotSame(index, result);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 4, (byte) 0, (byte) 2, (byte) 1), result);
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), this.newWith((byte) 1).toSet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 3).toSet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31), this.newWith((byte) 0, (byte) 1, (byte) 31).toSet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 31, (byte) 32), this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32).toSet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(new ByteHashBag(), this.newWith().toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), this.newWith((byte) 1).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 3).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 31, (byte) 32), this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32).toBag());
    }

    @Test
    public void asLazy() {
        ByteIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable.asLazy());
        ByteIterable iterable1 = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(iterable1.toBag(), iterable1.asLazy().toBag());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable1.asLazy());
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(iterable2.toBag(), iterable2.asLazy().toBag());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable2.asLazy());
        ByteIterable iterable3 = this.newWith();
        Assert.assertEquals(iterable3.toBag(), iterable3.asLazy().toBag());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable3.asLazy());
        ByteIterable iterable4 = this.newWith((byte) 1);
        Assert.assertEquals(iterable4.toBag(), iterable4.asLazy().toBag());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable4.asLazy());
    }

    @Test
    public void injectInto() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        Byte sum1 = iterable1.injectInto(Byte.valueOf((byte) 0), (Byte result, byte value) -> Byte.valueOf((byte) (result + value + 1)));
        Assert.assertEquals(Byte.valueOf((byte) 36), sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        Byte sum2 = iterable2.injectInto(Byte.valueOf((byte) 0), (Byte result, byte value) -> Byte.valueOf((byte) (result + value + 1)));
        Assert.assertEquals(Byte.valueOf((byte) 37), sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        Byte sum3 = iterable3.injectInto(Byte.valueOf((byte) 0), (Byte result, byte value) -> Byte.valueOf((byte) (result + value + 1)));
        Assert.assertEquals(Byte.valueOf((byte) 38), sum3);
    }

    @Test
    public void injectIntoBoolean() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        boolean sum1 = iterable1.injectIntoBoolean(false, (boolean result, byte value) -> (boolean) (result || value == (byte) 0));
        Assert.assertEquals(true, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        boolean sum2 = iterable2.injectIntoBoolean(false, (boolean result, byte value) -> (boolean) (result || value == (byte) 0));
        Assert.assertEquals(false, sum2);
    }

    @Test
    public void injectIntoByte() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        byte sum1 = iterable1.injectIntoByte((byte) 0, (byte result, byte value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 36, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        byte sum2 = iterable2.injectIntoByte((byte) 0, (byte result, byte value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 37, sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        byte sum3 = iterable3.injectIntoByte((byte) 0, (byte result, byte value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 38, sum3);
    }

    @Test
    public void injectIntoChar() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        char sum1 = iterable1.injectIntoChar((char) 0, (char result, byte value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 36, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        char sum2 = iterable2.injectIntoChar((char) 0, (char result, byte value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 37, sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        char sum3 = iterable3.injectIntoChar((char) 0, (char result, byte value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 38, sum3);
    }

    @Test
    public void injectIntoShort() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        short sum1 = iterable1.injectIntoShort((short) 0, (short result, byte value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 36, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        short sum2 = iterable2.injectIntoShort((short) 0, (short result, byte value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 37, sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        short sum3 = iterable3.injectIntoShort((short) 0, (short result, byte value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 38, sum3);
    }

    @Test
    public void injectIntoInt() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        int sum1 = iterable1.injectIntoInt(0, (int result, byte value) -> (int) (result + value + 1));
        Assert.assertEquals(36, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        int sum2 = iterable2.injectIntoInt(0, (int result, byte value) -> (int) (result + value + 1));
        Assert.assertEquals(37, sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        int sum3 = iterable3.injectIntoInt(0, (int result, byte value) -> (int) (result + value + 1));
        Assert.assertEquals(38, sum3);
    }

    @Test
    public void injectIntoFloat() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        float sum1 = iterable1.injectIntoFloat(0.0f, (float result, byte value) -> (float) (result + value + 1));
        Assert.assertEquals(36.0f, sum1, 0.001);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        float sum2 = iterable2.injectIntoFloat(0.0f, (float result, byte value) -> (float) (result + value + 1));
        Assert.assertEquals(37.0f, sum2, 0.001);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        float sum3 = iterable3.injectIntoFloat(0.0f, (float result, byte value) -> (float) (result + value + 1));
        Assert.assertEquals(38.0f, sum3, 0.001);
    }

    @Test
    public void injectIntoLong() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        long sum1 = iterable1.injectIntoLong(0L, (long result, byte value) -> (long) (result + value + 1));
        Assert.assertEquals(36L, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        long sum2 = iterable2.injectIntoLong(0L, (long result, byte value) -> (long) (result + value + 1));
        Assert.assertEquals(37L, sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        long sum3 = iterable3.injectIntoLong(0L, (long result, byte value) -> (long) (result + value + 1));
        Assert.assertEquals(38L, sum3);
    }

    @Test
    public void injectIntoDouble() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        double sum1 = iterable1.injectIntoDouble(0.0, (double result, byte value) -> (double) (result + value + 1));
        Assert.assertEquals(36.0, sum1, 0.001);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        double sum2 = iterable2.injectIntoDouble(0.0, (double result, byte value) -> (double) (result + value + 1));
        Assert.assertEquals(37.0, sum2, 0.001);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        double sum3 = iterable3.injectIntoDouble(0.0, (double result, byte value) -> (double) (result + value + 1));
        Assert.assertEquals(38.0, sum3, 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void reduceOnEmptyThrows() {
        this.newWith().reduce((long result, byte value) -> (long) result + (long) value + 1L);
    }

    @Test
    public void reduce() {
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        long sum1 = iterable1.reduce((long result, byte value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(35L, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        long sum2 = iterable2.reduce((long result, byte value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(36L, sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        long sum3 = iterable3.reduce((long result, byte value) -> (long) result + (long) value + 1L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void reduceIfEmpty() {
        long empty1 = this.newWith().reduceIfEmpty((long result, byte value) -> (long) result + (long) value + 1L, 1L);
        Assert.assertEquals(1L, empty1);
        long empty2 = this.newWith().reduceIfEmpty((long result, byte value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(0L, empty2);
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 2, (byte) 31);
        long sum1 = iterable1.reduceIfEmpty((long result, byte value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(35L, sum1);
        ByteIterable iterable2 = this.newWith((byte) 1, (byte) 2, (byte) 31);
        long sum2 = iterable2.reduceIfEmpty((long result, byte value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(36L, sum2);
        ByteIterable iterable3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 31);
        long sum3 = iterable3.reduceIfEmpty((long result, byte value) -> (long) result + (long) value + 1L, 0L);
        Assert.assertEquals(37L, sum3);
    }

    @Test
    public void chunk() {
        ByteIterable iterable = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((byte) 0), this.newMutableCollectionWith((byte) 1), this.newMutableCollectionWith((byte) 2), this.newMutableCollectionWith((byte) 3), this.newMutableCollectionWith((byte) 4), this.newMutableCollectionWith((byte) 5)).toSet(), iterable.chunk(1).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((byte) 0, (byte) 1), this.newMutableCollectionWith((byte) 2, (byte) 3), this.newMutableCollectionWith((byte) 4, (byte) 5)).toSet(), iterable.chunk(2).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2), this.newMutableCollectionWith((byte) 3, (byte) 4, (byte) 5)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3), this.newMutableCollectionWith((byte) 4, (byte) 5)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5)).toSet(), iterable.chunk(6).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5)).toSet(), iterable.chunk(7).toSet());
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((byte) 0)), this.newWith((byte) 0).chunk(1));
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newMutableCollectionWith().chunk(-1));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteIterableTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteIterableTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractByteIterableTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractByteIterableTestCase::newCollection;
            this.payloads.isEmpty = AbstractByteIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractByteIterableTestCase::notEmpty;
            this.payloads.tap = AbstractByteIterableTestCase::tap;
            this.payloads.contains = AbstractByteIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractByteIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractByteIterableTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractByteIterableTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractByteIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractByteIterableTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractByteIterableTestCase::containsNoneIterable;
            this.payloads.byteIterator = AbstractByteIterableTestCase::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteIterableTestCase::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteIterableTestCase::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractByteIterableTestCase::forEach;
            this.payloads.size = AbstractByteIterableTestCase::size;
            this.payloads.count = AbstractByteIterableTestCase::count;
            this.payloads.anySatisfy = AbstractByteIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractByteIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractByteIterableTestCase::noneSatisfy;
            this.payloads.collect = AbstractByteIterableTestCase::collect;
            this.payloads.collectWithTarget = AbstractByteIterableTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractByteIterableTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractByteIterableTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractByteIterableTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractByteIterableTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractByteIterableTestCase::select;
            this.payloads.selectWithTarget = AbstractByteIterableTestCase::selectWithTarget;
            this.payloads.reject = AbstractByteIterableTestCase::reject;
            this.payloads.rejectWithTarget = AbstractByteIterableTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractByteIterableTestCase::detectIfNone;
            this.payloads.max = AbstractByteIterableTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteIterableTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractByteIterableTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteIterableTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractByteIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractByteIterableTestCase::maxIfEmpty;
            this.payloads.sum = AbstractByteIterableTestCase::sum;
            this.payloads.summaryStatistics = AbstractByteIterableTestCase::summaryStatistics;
            this.payloads.average = AbstractByteIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractByteIterableTestCase::averageIfEmpty;
            this.payloads.median = AbstractByteIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractByteIterableTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractByteIterableTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractByteIterableTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractByteIterableTestCase::toSortedArray;
            this.payloads.testEquals = AbstractByteIterableTestCase::testEquals;
            this.payloads.testHashCode = AbstractByteIterableTestCase::testHashCode;
            this.payloads.testToString = AbstractByteIterableTestCase::testToString;
            this.payloads.makeString = AbstractByteIterableTestCase::makeString;
            this.payloads.appendString = AbstractByteIterableTestCase::appendString;
            this.payloads.toList = AbstractByteIterableTestCase::toList;
            this.payloads.toSortedList = AbstractByteIterableTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractByteIterableTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractByteIterableTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractByteIterableTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractByteIterableTestCase::toSet;
            this.payloads.toBag = AbstractByteIterableTestCase::toBag;
            this.payloads.asLazy = AbstractByteIterableTestCase::asLazy;
            this.payloads.injectInto = AbstractByteIterableTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractByteIterableTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractByteIterableTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractByteIterableTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractByteIterableTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractByteIterableTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractByteIterableTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractByteIterableTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractByteIterableTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteIterableTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractByteIterableTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractByteIterableTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractByteIterableTestCase::chunk;
        }
    }
*/
}
