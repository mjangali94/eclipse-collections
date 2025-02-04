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
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
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
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link FloatIterable}s
 * This file was automatically generated from template file abstractPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractFloatIterableTestCase {

    protected abstract FloatIterable classUnderTest();

    protected abstract FloatIterable newWith(float... elements);

    protected abstract FloatIterable newMutableCollectionWith(float... elements);

    protected abstract RichIterable<Float> newObjectCollectionWith(Float... elements);

    @Test
    public void newCollectionWith() {
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Verify.assertSize(3, iterable);
        Verify.assertSize(4, this.newWith(0.0f, 1.0f, 31.0f, 32.0f));
        Assert.assertTrue(iterable.containsAll(1.0f, 2.0f, 3.0f));
        FloatIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll(1.0f, 2.0f, 3.0f));
        FloatIterable iterable2 = this.newWith(1.0f);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll(1.0f, 2.0f, 3.0f));
    }

    @Test
    public void newCollection() {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(this.newMutableCollectionWith(0.0f, 1.0f, 31.0f, 32.0f), this.newWith(0.0f, 1.0f, 31.0f, 32.0f));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith(0.0f, 1.0f, 31.0f, 32.0f));
        Verify.assertNotEmpty(this.newWith(0.0f, 1.0f, 2.0f));
        Verify.assertNotEmpty(this.newWith(0.0f, 31.0f));
        Verify.assertNotEmpty(this.newWith(31.0f, 32.0f));
        Verify.assertNotEmpty(this.newWith(32.0f, 33.0f));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith(0.0f, 1.0f, 31.0f, 32.0f).notEmpty());
        Assert.assertTrue(this.newWith(0.0f, 1.0f, 2.0f).notEmpty());
        Assert.assertTrue(this.newWith(0.0f, 31.0f).notEmpty());
        Assert.assertTrue(this.newWith(31.0f, 32.0f).notEmpty());
        Assert.assertTrue(this.newWith(32.0f, 33.0f).notEmpty());
    }

    @Test
    public void tap() {
        MutableFloatList tapResult = FloatLists.mutable.empty();
        FloatIterable collection = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void contains() {
        FloatIterable iterable = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertFalse(iterable.contains(29.0f));
        Assert.assertFalse(iterable.contains(49.0f));
        float[] numbers = { 14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f };
        for (float number : numbers) {
            Assert.assertTrue(iterable.contains(number));
        }
        Assert.assertFalse(iterable.contains(-1.0f));
        Assert.assertFalse(iterable.contains(29.0f));
        Assert.assertFalse(iterable.contains(49.0f));
        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(iterable1.contains(0.0f));
        Assert.assertTrue(iterable1.contains(1.0f));
        Assert.assertTrue(iterable1.contains(2.0f));
        Assert.assertFalse(iterable1.contains(3.0f));
        FloatIterable iterable2 = this.classUnderTest();
        for (float each = 1; each <= iterable2.size(); each++) {
            Assert.assertTrue(iterable2.contains(each));
        }
        Assert.assertFalse(iterable2.contains(iterable2.size() + 1));
    }

    @Test
    public void contains_NaN() {
        FloatIterable primitiveIterable = this.newWith(Float.NaN);
        Set<Float> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Float.NaN));
        Assert.assertTrue(hashSet.contains(Float.NaN));
        Assert.assertTrue(primitiveIterable.contains(Float.NaN));
    }

    @Test
    public void contains_NEGATIVE_INFINITY() {
        FloatIterable primitiveIterable = this.newWith(Float.NEGATIVE_INFINITY);
        Set<Float> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Float.NEGATIVE_INFINITY));
        Assert.assertTrue(hashSet.contains(Float.NEGATIVE_INFINITY));
        Assert.assertTrue(primitiveIterable.contains(Float.NEGATIVE_INFINITY));
    }

    @Test
    public void contains_POSITIVE_INFINITY() {
        FloatIterable primitiveIterable = this.newWith(Float.POSITIVE_INFINITY);
        Set<Float> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Float.POSITIVE_INFINITY));
        Assert.assertTrue(hashSet.contains(Float.POSITIVE_INFINITY));
        Assert.assertTrue(primitiveIterable.contains(Float.POSITIVE_INFINITY));
    }

    @Test
    public void contains_zero() {
        FloatIterable iterable = this.newWith(0.0f);
        Set<Float> hashSet = new HashSet<>();
        hashSet.add(0.0f);
        Assert.assertTrue(hashSet.contains(0.0f));
        Assert.assertFalse(hashSet.contains(-0.0f));
        Assert.assertTrue(iterable.contains(0.0f));
        Assert.assertFalse(iterable.contains(-0.0f));
    }

    @Test
    public void testEquals_NaN() {
        FloatIterable iterable1 = this.newWith(Float.NaN);
        Set<Float> hashSet1 = new HashSet<>();
        hashSet1.add(Float.NaN);
        FloatIterable iterable2 = this.newWith(Float.NaN);
        Set<Float> hashSet2 = new HashSet<>();
        hashSet2.add(Float.NaN);
        FloatIterable iterable3 = this.newWith(Float.POSITIVE_INFINITY);
        Set<Float> hashSet3 = new HashSet<>();
        hashSet3.add(Float.POSITIVE_INFINITY);
        FloatIterable iterable4 = this.newWith(Float.POSITIVE_INFINITY);
        Set<Float> hashSet4 = new HashSet<>();
        hashSet4.add(Float.POSITIVE_INFINITY);
        FloatIterable iterable5 = this.newWith(Float.NEGATIVE_INFINITY);
        Set<Float> hashSet5 = new HashSet<>();
        hashSet5.add(Float.NEGATIVE_INFINITY);
        FloatIterable iterable6 = this.newWith(Float.NEGATIVE_INFINITY);
        Set<Float> hashSet6 = new HashSet<>();
        hashSet6.add(Float.NEGATIVE_INFINITY);
        Assert.assertEquals(hashSet1, hashSet2);
        Assert.assertEquals(iterable1, iterable2);
        Assert.assertEquals(hashSet3, hashSet4);
        Assert.assertEquals(iterable3, iterable4);
        Assert.assertEquals(hashSet5, hashSet6);
        Assert.assertEquals(iterable5, iterable6);
        Assert.assertNotEquals(hashSet1, hashSet3);
        Assert.assertNotEquals(iterable1, iterable3);
        Assert.assertNotEquals(hashSet3, hashSet5);
        Assert.assertNotEquals(iterable3, iterable5);
        Assert.assertNotEquals(hashSet5, hashSet1);
        Assert.assertNotEquals(iterable5, iterable1);
    }

    @Test
    public void contains_different_NaNs() {
        int nan1 = 0x7f800001;
        FloatIterable primitiveIterable = this.newWith(Float.intBitsToFloat(nan1));
        Set<Float> hashSet = new HashSet<>();
        hashSet.add(Float.intBitsToFloat(nan1));
        int nan2 = 0xff800001;
        Assert.assertEquals(hashSet.contains(Float.intBitsToFloat(nan2)), primitiveIterable.contains(Float.intBitsToFloat(nan2)));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toArray()));
        Assert.assertFalse(this.classUnderTest().containsAll(this.classUnderTest().size() + 1));
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertTrue(iterable.containsAll(1.0f));
        Assert.assertTrue(iterable.containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertFalse(iterable.containsAll(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertFalse(iterable.containsAll(1.0f, 2.0f, 4.0f));
        Assert.assertFalse(iterable.containsAll(4.0f, 5.0f, 6.0f));
        FloatIterable iterable1 = this.newWith(14.0f, 2.0f, 30.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertTrue(iterable1.containsAll(14.0f));
        Assert.assertTrue(iterable1.containsAll(35.0f));
        Assert.assertFalse(iterable1.containsAll(-1.0f));
        Assert.assertTrue(iterable1.containsAll(14.0f, 1.0f, 30.0f));
        Assert.assertTrue(iterable1.containsAll(14.0f, 1.0f, 32.0f));
        Assert.assertTrue(iterable1.containsAll(14.0f, 1.0f, 35.0f));
        Assert.assertFalse(iterable1.containsAll(0.0f, 2.0f, 35.0f, -1.0f));
        Assert.assertFalse(iterable1.containsAll(31.0f, -1.0f));
        FloatIterable iterable2 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(iterable2.containsAll(0.0f));
        Assert.assertTrue(iterable2.containsAll(0.0f, 0.0f, 0.0f));
        Assert.assertTrue(iterable2.containsAll(0.0f, 1.0f, 1.0f));
        Assert.assertTrue(iterable2.containsAll(0.0f, 1.0f, 2.0f));
        Assert.assertFalse(iterable2.containsAll(0.0f, 1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertFalse(iterable2.containsAll(3.0f, 4.0f));
        int size = 33;
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        FloatIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertTrue(iterable3.containsAll());
        Assert.assertFalse(iterable3.containsAll(3.0f, 4.0f, 5.0f, 33.0f, 34.0f));
        Assert.assertTrue(iterable3.containsAll(array));
        FloatIterable iterable4 = FloatSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertTrue(iterable4.containsAll());
        Assert.assertFalse(iterable4.containsAll(3.0f, 4.0f, 5.0f, 33.0f, 34.0f));
        Assert.assertTrue(iterable4.containsAll(array));
    }

    @Test
    public void containsAllIterable() {
        FloatIterable source = this.classUnderTest();
        Assert.assertTrue(source.containsAll(this.classUnderTest()));
        Assert.assertFalse(source.containsAll(FloatArrayList.newListWith(source.size() + 1)));
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertTrue(this.newWith().containsAll(new FloatArrayList()));
        Assert.assertFalse(this.newWith().containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Assert.assertFalse(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f)));
        Assert.assertFalse(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 4.0f)));
        Assert.assertFalse(iterable.containsAll(FloatArrayList.newListWith(4.0f, 5.0f, 6.0f)));
        FloatIterable iterable1 = this.newWith(14.0f, 2.0f, 30.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertTrue(iterable1.containsAll(FloatHashSet.newSetWith(14.0f)));
        Assert.assertTrue(iterable1.containsAll(FloatHashSet.newSetWith(35.0f)));
        Assert.assertFalse(iterable1.containsAll(FloatHashSet.newSetWith(-1.0f)));
        Assert.assertTrue(iterable1.containsAll(FloatHashSet.newSetWith(14.0f, 1.0f, 30.0f)));
        Assert.assertTrue(iterable1.containsAll(FloatHashSet.newSetWith(14.0f, 1.0f, 32.0f)));
        Assert.assertTrue(iterable1.containsAll(FloatHashSet.newSetWith(14.0f, 1.0f, 35.0f)));
        Assert.assertFalse(iterable1.containsAll(FloatHashSet.newSetWith(0.0f, 2.0f, 35.0f, -1.0f)));
        Assert.assertFalse(iterable1.containsAll(FloatHashSet.newSetWith(31.0f, -1.0f)));
        FloatIterable iterable2 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(iterable2.containsAll(FloatArrayList.newListWith(0.0f)));
        Assert.assertTrue(iterable2.containsAll(FloatArrayList.newListWith(0.0f, 0.0f, 0.0f)));
        Assert.assertTrue(iterable2.containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 1.0f)));
        Assert.assertTrue(iterable2.containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
        Assert.assertFalse(iterable2.containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f)));
        Assert.assertFalse(iterable2.containsAll(FloatArrayList.newListWith(3.0f, 4.0f)));
        int size = 33;
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        FloatIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAll(FloatLists.immutable.with(1.0f, 2.0f, 3.0f)));
        Assert.assertTrue(iterable3.containsAll(FloatLists.mutable.empty()));
        Assert.assertFalse(iterable3.containsAll(FloatLists.mutable.with(3.0f, 4.0f, 5.0f, 33.0f, 34.0f)));
        Assert.assertTrue(iterable3.containsAll(FloatLists.immutable.with(array)));
        FloatIterable iterable4 = FloatSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAll(FloatLists.immutable.with(1.0f, 2.0f, 3.0f)));
        Assert.assertTrue(iterable4.containsAll(FloatLists.mutable.empty()));
        Assert.assertFalse(iterable4.containsAll(FloatLists.mutable.with(3.0f, 4.0f, 5.0f, 33.0f, 34.0f)));
        Assert.assertTrue(iterable4.containsAll(FloatLists.immutable.with(array)));
    }

    @Test
    public void containsAnyArray() {
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assert.assertTrue(iterable.containsAny(1.0f, 1.0f, 1.0f));
        Assert.assertFalse(iterable.containsAny());
        Assert.assertTrue(iterable.containsAny(1.0f, 2.0f, 3.0f));
        Assert.assertFalse(iterable.containsAny(6.0f, 7.0f, 8.0f));
        FloatIterable iterable2 = this.newWith(0.0f, 1.0f, 3.0f, 7.0f);
        Assert.assertTrue(iterable2.containsAny(3.0f, 3.0f, 1.0f, 9.0f));
        Assert.assertFalse(iterable2.containsAny());
        Assert.assertTrue(iterable2.containsAny(-1.0f, 3.0f, 5.0f));
        Assert.assertFalse(iterable2.containsAny(2.0f, 4.0f, 6.0f));
        int size = 33;
        float[] array = new float[size];
        float[] unmatched = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            unmatched[i] = i + 34;
        }
        FloatIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(array));
        Assert.assertFalse(iterable3.containsAny(unmatched));
        FloatIterable iterable4 = FloatSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(array));
        Assert.assertFalse(iterable4.containsAny(unmatched));
        FloatIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny());
        Assert.assertFalse(emptyIterable.containsAny(0.0f, 0.0f));
        Assert.assertFalse(emptyIterable.containsAny(-1.0f));
        Assert.assertFalse(emptyIterable.containsAny(1.0f, 2.0f, 3.0f));
    }

    @Test
    public void containsAnyIterable() {
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assert.assertTrue(iterable.containsAny(FloatLists.immutable.with(1.0f, 1.0f, 1.0f)));
        Assert.assertFalse(iterable.containsAny(FloatLists.mutable.empty()));
        Assert.assertTrue(iterable.containsAny(FloatLists.immutable.with(1.0f, 2.0f, 3.0f)));
        Assert.assertFalse(iterable.containsAny(FloatLists.mutable.with(6.0f, 7.0f, 8.0f)));
        FloatIterable iterable2 = this.newWith(0.0f, 1.0f, 3.0f, 7.0f);
        Assert.assertTrue(iterable2.containsAny(FloatSets.immutable.with(3.0f, 3.0f, 1.0f, 9.0f)));
        Assert.assertFalse(iterable2.containsAny(FloatSets.mutable.empty()));
        Assert.assertTrue(iterable2.containsAny(FloatSets.immutable.with(-1.0f, 3.0f, 5.0f)));
        Assert.assertFalse(iterable2.containsAny(FloatSets.mutable.with(2.0f, 4.0f, 6.0f)));
        FloatIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny(FloatLists.mutable.empty()));
        Assert.assertFalse(emptyIterable.containsAny(FloatLists.immutable.with(0.0f, 0.0f)));
        Assert.assertFalse(emptyIterable.containsAny(FloatLists.mutable.with(-1.0f)));
        Assert.assertFalse(emptyIterable.containsAny(FloatLists.immutable.with(1.0f, 2.0f, 3.0f)));
        int size = 33;
        float[] array = new float[size];
        float[] unmatched = new float[size];
        float[] bigger = new float[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            bigger[i] = i + 1;
            unmatched[i] = i + 34;
        }
        bigger[size - 1] = 33.0f;
        FloatIterable iterable3 = this.newWith(array);
        Assert.assertTrue(iterable3.containsAny(FloatLists.immutable.with(array)));
        Assert.assertFalse(iterable3.containsAny(FloatLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsAny(FloatSets.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsAny(FloatSets.mutable.with(bigger)));
        FloatIterable iterable4 = FloatSets.mutable.with(array);
        Assert.assertTrue(iterable4.containsAny(FloatLists.immutable.with(array)));
        Assert.assertFalse(iterable4.containsAny(FloatLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable4.containsAny(FloatSets.immutable.with(array)));
        Assert.assertTrue(iterable4.containsAny(FloatSets.immutable.with(bigger)));
    }

    @Test
    public void containsNoneArray() {
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertFalse(iterable.containsNone(1.0f, 1.0f));
        Assert.assertTrue(iterable.containsNone());
        Assert.assertFalse(iterable.containsNone(3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertTrue(iterable.containsNone(7.0f, 8.0f, 11.0f));
        FloatIterable iterable2 = this.newWith(0.0f, 1.0f, 3.0f, 7.0f);
        Assert.assertTrue(iterable2.containsNone(2.0f, 4.0f, 6.0f));
        Assert.assertTrue(iterable2.containsNone());
        Assert.assertFalse(iterable2.containsNone(-1.0f, 1.0f, 3.0f));
        Assert.assertFalse(iterable2.containsNone(7.0f, 3.0f, 1.0f, 0.0f));
        int size = 33;
        float[] array = new float[size];
        float[] unmatched = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            unmatched[i] = i + 34;
        }
        FloatIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(array));
        Assert.assertTrue(iterable3.containsNone(unmatched));
        FloatIterable iterable4 = FloatSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(array));
        Assert.assertTrue(iterable4.containsNone(unmatched));
        FloatIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(1.0f, 2.0f, 3.0f));
        Assert.assertTrue(emptyIterable.containsNone());
        Assert.assertTrue(emptyIterable.containsNone(-1.0f, 5.0f));
        Assert.assertTrue(emptyIterable.containsNone(0.0f));
    }

    @Test
    public void containsNoneIterable() {
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertFalse(iterable.containsNone(FloatLists.immutable.with(1.0f, 1.0f)));
        Assert.assertTrue(iterable.containsNone(FloatLists.mutable.empty()));
        Assert.assertFalse(iterable.containsNone(FloatLists.mutable.with(3.0f, 4.0f, 5.0f, 6.0f)));
        Assert.assertTrue(iterable.containsNone(FloatLists.immutable.with(7.0f, 8.0f, 11.0f)));
        FloatIterable iterable2 = this.newWith(0.0f, 1.0f, 3.0f, 7.0f);
        Assert.assertTrue(iterable2.containsNone(FloatSets.immutable.with(2.0f, 4.0f, 6.0f)));
        Assert.assertTrue(iterable2.containsNone(FloatSets.mutable.empty()));
        Assert.assertFalse(iterable2.containsNone(FloatSets.immutable.with(-1.0f, 1.0f, 3.0f)));
        Assert.assertFalse(iterable2.containsNone(FloatSets.mutable.with(7.0f, 3.0f, 1.0f, 0.0f)));
        FloatIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(FloatLists.immutable.with(1.0f, 2.0f, 3.0f)));
        Assert.assertTrue(emptyIterable.containsNone(FloatLists.mutable.empty()));
        Assert.assertTrue(emptyIterable.containsNone(FloatLists.immutable.with(-1.0f, 5.0f)));
        Assert.assertTrue(emptyIterable.containsNone(FloatLists.mutable.with(0.0f)));
        int size = 33;
        float[] array = new float[size];
        float[] unmatched = new float[size];
        float[] bigger = new float[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
            bigger[i] = i + 1;
            unmatched[i] = i + 34;
        }
        bigger[size - 1] = 33.0f;
        FloatIterable iterable3 = this.newWith(array);
        Assert.assertFalse(iterable3.containsNone(FloatLists.immutable.with(array)));
        Assert.assertTrue(iterable3.containsNone(FloatLists.mutable.with(unmatched)));
        Assert.assertTrue(iterable3.containsNone(FloatSets.mutable.with(unmatched)));
        Assert.assertFalse(iterable3.containsNone(FloatSets.mutable.with(bigger)));
        FloatIterable iterable4 = FloatSets.mutable.with(array);
        Assert.assertFalse(iterable4.containsNone(FloatLists.immutable.with(array)));
        Assert.assertTrue(iterable4.containsNone(FloatLists.mutable.with(unmatched)));
        Assert.assertFalse(iterable4.containsNone(FloatSets.immutable.with(array)));
        Assert.assertFalse(iterable4.containsNone(FloatSets.immutable.with(bigger)));
    }

    @Test
    public abstract void floatIterator();

    @Test(expected = NoSuchElementException.class)
    public void floatIterator_throws() {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void floatIterator_throws_non_empty_collection() {
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        FloatIterator iterator = iterable.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        double[] sum = new double[1];
        this.classUnderTest().forEach(each -> sum[0] += each);
        int size = this.classUnderTest().size();
        long sum1 = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum1, sum[0], 0.0);
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.newWith());
        Verify.assertSize(1, this.newWith(3.0f));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f));
    }

    @Test
    public void count() {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 3 ? 3 : size, iterable.count(FloatPredicates.lessThan(4.0f)));
        Assert.assertEquals(2L, this.newWith(1.0f, 0.0f, 2.0f).count(FloatPredicates.greaterThan(0.0f)));
        Assert.assertEquals(1, this.newWith(1.0f).count(FloatPredicates.alwaysTrue()));
        Assert.assertEquals(0, this.newWith(1.0f).count(FloatPredicates.alwaysFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1.0f, -1.0f, 2.0f).anySatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.newWith(1.0f, -1.0f, 2.0f).anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWith(-1.0f, -1.0f, -2.0f, 31.0f, 32.0f).anySatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(this.newWith(2.0f, -1.0f, -2.0f, 31.0f, 32.0f).anySatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.newWith(1.0f, -1.0f, 31.0f, 32.0f).anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWith(32.0f).anySatisfy(FloatPredicates.greaterThan(0.0f)));
        FloatIterable iterable = this.newWith(0.0f, 1.0f, 2.0f);
        Assert.assertTrue(iterable.anySatisfy(value -> Float.compare(value, 3.0f) < 0));
        Assert.assertFalse(iterable.anySatisfy(FloatPredicates.greaterThan(3.0f)));
        FloatIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(FloatPredicates.greaterThan(3.0f)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.newWith(1.0f, 0.0f, 2.0f).allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(this.newWith(1.0f, 2.0f, 3.0f).allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.newWith(1.0f, 0.0f, 31.0f, 32.0f).allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.newWith(1.0f, 0.0f, 31.0f, 32.0f).allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(this.newWith(1.0f, 2.0f, 31.0f, 32.0f).allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.newWith(32.0f).allSatisfy(FloatPredicates.equal(33.0f)));
        Assert.assertFalse(this.newWith(-32.0f).allSatisfy(FloatPredicates.equal(33.0f)));
        FloatIterable iterable = this.newWith(0.0f, 1.0f, 2.0f);
        Assert.assertFalse(iterable.allSatisfy(value -> Float.compare(3.0f, value) < 0));
        Assert.assertTrue(iterable.allSatisfy(FloatPredicates.lessThan(3.0f)));
        FloatIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(FloatPredicates.greaterThan(3.0f)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.newWith(1.0f, 0.0f, 2.0f).noneSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.newWith(1.0f, 0.0f, 2.0f).noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWith(1.0f, 2.0f, 3.0f).noneSatisfy(FloatPredicates.greaterThan(3.0f)));
        Assert.assertFalse(this.newWith(1.0f, 0.0f, 31.0f, 32.0f).noneSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.newWith(1.0f, 0.0f, 31.0f, 32.0f).noneSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(this.newWith(1.0f, 2.0f, 31.0f, 32.0f).noneSatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertFalse(this.newWith(32.0f).noneSatisfy(FloatPredicates.greaterThan(0.0f)));
        FloatIterable iterable = this.newWith(0.0f, 1.0f, 2.0f);
        Assert.assertFalse(iterable.noneSatisfy(value -> Float.compare(1.0f, value) < 0));
        Assert.assertTrue(iterable.noneSatisfy(FloatPredicates.greaterThan(3.0f)));
        FloatIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size <= 3, iterable1.noneSatisfy(FloatPredicates.greaterThan(3.0f)));
        Assert.assertEquals(size == 0, iterable1.noneSatisfy(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void collect() {
        FloatToObjectFunction<Float> function = parameter -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f).collect(function));
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f), iterable.collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2.0f), this.newWith(3.0f).collect(function));
    }

    @Test
    public void collectWithTarget() {
        FloatToObjectFunction<Float> function = parameter -> parameter - 1;
        Assert.assertEquals(Bags.mutable.with(0.0f, 1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f).collect(function, Bags.mutable.empty()));
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(Sets.mutable.with(0.0f, 1.0f, 2.0f), iterable.collect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().collect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2.0f), this.newWith(3.0f).collect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectWithTarget() {
        FloatToObjectFunction<List<Float>> function = parameter -> Lists.mutable.with(parameter - 1);
        Assert.assertEquals(Bags.mutable.with(0.0f, 1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f).flatCollect(function, Bags.mutable.empty()));
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(Sets.mutable.with(0.0f, 1.0f, 2.0f), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2.0f), this.newWith(3.0f).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectIterableWithTarget() {
        FloatToObjectFunction<Iterable<Float>> function = parameter -> Lists.mutable.with(parameter - 1).asLazy();
        Assert.assertEquals(Bags.mutable.with(0.0f, 1.0f, 2.0f), this.newWith(1.0f, 2.0f, 3.0f).flatCollect(function, Bags.mutable.empty()));
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(Sets.mutable.with(0.0f, 1.0f, 2.0f), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2.0f), this.newWith(3.0f).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToLists() {
        FloatIterable iterable = this.newWith(1.0f, 2.0f);
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
        FloatIterable iterable = this.newWith(1.0f, 2.0f);
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
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(FloatPredicates.lessThan(3.0f)));
        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(this.newMutableCollectionWith(0.0f, 1.0f), iterable1.select(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 3.0f, 3.0f, 3.0f), iterable1.select(FloatPredicates.greaterThan(1.0f)));
        FloatIterable iterable2 = this.newWith(0.0f);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.select(FloatPredicates.alwaysTrue()));
        Verify.assertSize(0, iterable2.select(FloatPredicates.alwaysFalse()));
    }

    @Test
    public void selectWithTarget() {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(FloatPredicates.lessThan(4.0f), FloatSets.mutable.empty()));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(FloatPredicates.lessThan(3.0f), FloatSets.mutable.empty()));
        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(FloatSets.mutable.with(0.0f, 1.0f), iterable1.select(FloatPredicates.lessThan(2.0f), FloatSets.mutable.empty()));
        Assert.assertEquals(FloatSets.mutable.with(2.0f, 3.0f), iterable1.select(FloatPredicates.greaterThan(1.0f), FloatSets.mutable.empty()));
    }

    @Test
    public void reject() {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(FloatPredicates.lessThan(3.0f)));
        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(this.newMutableCollectionWith(2.0f, 2.0f, 3.0f, 3.0f, 3.0f), iterable1.reject(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(0.0f, 1.0f), iterable1.reject(FloatPredicates.greaterThan(1.0f)));
        FloatIterable iterable2 = this.newWith(0.0f);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.reject(FloatPredicates.alwaysFalse()));
        Verify.assertSize(0, iterable2.reject(FloatPredicates.alwaysTrue()));
    }

    @Test
    public void rejectWithTarget() {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(FloatPredicates.lessThan(4.0f), FloatSets.mutable.empty()));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(FloatPredicates.lessThan(3.0f), FloatSets.mutable.empty()));
        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(FloatSets.mutable.with(2.0f, 3.0f), iterable1.reject(FloatPredicates.lessThan(2.0f), FloatSets.mutable.empty()));
        Assert.assertEquals(FloatSets.mutable.with(0.0f, 1.0f), iterable1.reject(FloatPredicates.greaterThan(1.0f), FloatSets.mutable.empty()));
    }

    @Test
    public void detectIfNone() {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4.0 : 0.0, iterable.detectIfNone(FloatPredicates.equal(4.0f), 0.0f), 0.0);
        Assert.assertEquals(size >= 2 ? 2.0 : 0.0, iterable.detectIfNone(FloatPredicates.equal(2.0f), 0.0f), 0.0);
        Assert.assertEquals(size > 0 ? 1.0 : 0.0, iterable.detectIfNone(FloatPredicates.lessThan(2.0f), 0.0f), 0.0);
        Assert.assertEquals(size > 3 ? 4.0 : 0.0, iterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);
        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(0.0, iterable1.detectIfNone(FloatPredicates.lessThan(1.0f), 4.0f), 0.0f);
        Assert.assertEquals(3.0, iterable1.detectIfNone(FloatPredicates.greaterThan(2.0f), 4.0f), 0.0f);
        Assert.assertEquals(4.0, iterable1.detectIfNone(FloatPredicates.greaterThan(4.0f), 4.0f), 0.0f);
    }

    @Test
    public void max() {
        Assert.assertEquals(9.0, this.newWith(-1.0f, -2.0f, 9.0f).max(), 0.0);
        Assert.assertEquals(-1.0, this.newWith(-1.0f, -2.0f, -9.0f).max(), 0.0);
        Assert.assertEquals(32.0, this.newWith(1.0f, 0.0f, 9.0f, 30.0f, 31.0f, 32.0f).max(), 0.0);
        Assert.assertEquals(32.0, this.newWith(-1.0f, 0.0f, 9.0f, 30.0f, 31.0f, 32.0f).max(), 0.0);
        Assert.assertEquals(31.0, this.newWith(31.0f, 0.0f, 30.0f).max(), 0.0);
        Assert.assertEquals(39.0, this.newWith(32.0f, 39.0f, 35.0f).max(), 0.0);
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max(), 0.0f);
        Assert.assertEquals(32.5, this.newWith(-1.5f, 31.8f, 32.5f).max(), 0.0);
        Assert.assertEquals(-1.5, this.newWith(-1.5f, -31.8f, -32.5f).max(), 0.0);
        Assert.assertEquals(Float.POSITIVE_INFINITY, this.newWith(-1.5f, 31.8f, 32.5f, Float.POSITIVE_INFINITY).max(), 0.0);
        Assert.assertEquals(Float.NaN, this.newWith(-1.5f, 31.8f, 32.5f, Float.NaN, 31.5f).max(), 0.0);
        Assert.assertEquals(32.5, this.newWith(-1.5f, 31.8f, 32.5f, Float.NEGATIVE_INFINITY, 31.5f).max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyCollection() {
        this.newWith().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(-2.0, this.newWith(-1.0f, -2.0f, 9.0f).min(), 0.0);
        Assert.assertEquals(0.0, this.newWith(1.0f, 0.0f, 9.0f, 30.0f, 31.0f, 32.0f).min(), 0.0);
        Assert.assertEquals(-1.0, this.newWith(-1.0f, 0.0f, 9.0f, 30.0f, 31.0f, 32.0f).min(), 0.0);
        Assert.assertEquals(31.0, this.newWith(31.0f, 32.0f, 33.0f).min(), 0.0);
        Assert.assertEquals(32.0, this.newWith(32.0f, 39.0f, 35.0f).min(), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().min(), 0.0);
        Assert.assertEquals(-1.5, this.newWith(-1.5f, 31.5f, 32.5f).min(), 0.0);
        Assert.assertEquals(1.5, this.newWith(1.5f, 31.0f, 30.0f, Float.POSITIVE_INFINITY).min(), 0.0);
        Assert.assertEquals(31.5, this.newWith(31.5f, 32.5f, Float.NaN).min(), 0.0);
        Assert.assertEquals(Float.NEGATIVE_INFINITY, this.newWith(-1.5f, 31.5f, 32.5f, Float.NEGATIVE_INFINITY, 31.5f).min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyCollection() {
        this.newWith().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, this.newWith().minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.newWith().minIfEmpty(0.0f), 0.0);
        Assert.assertEquals(0.0, this.newWith(1.0f, 0.0f, 9.0f, 7.0f).minIfEmpty(5.0f), 0.0);
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5.0f : 1.0f, this.classUnderTest().minIfEmpty(5.0f), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, this.newWith().maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.newWith().maxIfEmpty(0.0f), 0.0);
        Assert.assertEquals(9.0, this.newWith(1.0f, 0.0f, 9.0f, 7.0f).maxIfEmpty(5.0f), 0.0);
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5.0f : size, this.classUnderTest().maxIfEmpty(5.0f), 0.0);
    }

    @Test
    public void sum() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().sum(), 0.0);
        Assert.assertEquals(10.0, this.newWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f).sum(), 0.0);
        Assert.assertEquals(93.0, this.newWith(30.0f, 31.0f, 32.0f).sum(), 0.0);
    }

    @Test
    public void summaryStatistics() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().summaryStatistics().getSum(), 0.0);
        Assert.assertEquals(10.0, this.newWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f).summaryStatistics().getSum(), 0.0);
        Assert.assertEquals(93.0, this.newWith(30.0f, 31.0f, 32.0f).summaryStatistics().getSum(), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        FloatIterable iterable = this.newWith(Interval.oneTo(100_000).toList().shuffleThis().collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())).toArray());
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, iterable.sum(), 1.0e-15);
    }

    @Test
    public void average() {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0f, 2.0f, 3.0f, 4.0f).average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0f, 2.0f, 3.0f, 4.0f).average(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0f, 30.0f, 31.0f, 31.0f, 32.0f, 32.0f).average(), 0.0);
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
        Assert.assertEquals(2.5, this.newWith(1.0f, 2.0f, 3.0f, 4.0f).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0f, 2.0f, 3.0f, 4.0f).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0f, 30.0f, 31.0f, 31.0f, 32.0f, 32.0f).averageIfEmpty(0.0), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(1.0, this.newWith(1.0f).median(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0f, 2.0f, 3.0f, 4.0f).median(), 0.0);
        Assert.assertEquals(3.0, this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).median(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0f, 30.0f, 31.0f, 31.0f, 32.0f).median(), 0.0);
        Assert.assertEquals(30.5, this.newWith(1.0f, 30.0f, 30.0f, 31.0f, 31.0f, 32.0f).median(), 0.0);
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
        Assert.assertEquals(1.0, this.newWith(1.0f).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0f, 2.0f, 3.0f, 4.0f).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(3.0, this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0f, 30.0f, 31.0f, 31.0f, 32.0f).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(30.5, this.newWith(1.0f, 30.0f, 30.0f, 31.0f, 31.0f, 32.0f).medianIfEmpty(0.0), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().toArray().length);
        FloatIterable iterable = this.newWith(1.0f, 2.0f);
        Assert.assertTrue(Arrays.equals(new float[] { 1.0f, 2.0f }, iterable.toArray()) || Arrays.equals(new float[] { 2.0f, 1.0f }, iterable.toArray()));
        Assert.assertTrue(Arrays.equals(new float[] { 0.0f, 1.0f }, this.newWith(0.0f, 1.0f).toArray()) || Arrays.equals(new float[] { 1.0f, 0.0f }, this.newWith(0.0f, 1.0f).toArray()));
        Assert.assertTrue(Arrays.equals(new float[] { 1.0f, 31.0f }, this.newWith(1.0f, 31.0f).toArray()) || Arrays.equals(new float[] { 31.0f, 1.0f }, this.newWith(1.0f, 31.0f).toArray()));
        Assert.assertTrue(Arrays.equals(new float[] { 31.0f, 35.0f }, this.newWith(31.0f, 35.0f).toArray()) || Arrays.equals(new float[] { 35.0f, 31.0f }, this.newWith(31.0f, 35.0f).toArray()));
        Assert.assertArrayEquals(new float[] {}, this.newWith().toArray(), 0.0f);
        Assert.assertArrayEquals(new float[] { 32.0f }, this.newWith(32.0f).toArray(), 0.0f);
    }

    @Test
    public void toArrayWithTargetArray() {
        float[] originalAsSortedArray = this.classUnderTest().toSortedArray();
        float[] target = new float[this.classUnderTest().size()];
        Assert.assertSame(target, this.classUnderTest().toArray(target));
        Arrays.sort(target);
        Assert.assertTrue(Arrays.equals(originalAsSortedArray, target));
        if (this.classUnderTest().size() > 0) {
            float[] targetTooSmall = new float[this.classUnderTest().size() - 1];
            float[] result = this.classUnderTest().toArray(targetTooSmall);
            Assert.assertNotSame(targetTooSmall, result);
            Arrays.sort(result);
            Assert.assertTrue(Arrays.equals(this.classUnderTest().toSortedArray(), result));
        }
        float[] targetTooBig = new float[this.classUnderTest().size() + 1];
        float[] bigResult = this.classUnderTest().toArray(targetTooBig);
        Assert.assertSame(targetTooBig, bigResult);
        Arrays.sort(targetTooBig);
        for (int i = 0; i < originalAsSortedArray.length; i++) {
            Assert.assertEquals(originalAsSortedArray[i], bigResult[i + 1], 0.0f);
        }
    }

    @Test
    public void toSortedArray() {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        Assert.assertArrayEquals(array, iterable.toSortedArray(), 0.0f);
        Assert.assertArrayEquals(new float[] { 1.0f, 3.0f, 7.0f, 9.0f }, this.newWith(3.0f, 1.0f, 9.0f, 7.0f).toSortedArray(), 0.0f);
    }

    @Test
    public void testEquals() {
        FloatIterable iterable1 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
        FloatIterable iterable3 = this.newWith(5.0f, 6.0f, 7.0f, 8.0f);
        FloatIterable iterable4 = this.newWith(5.0f, 6.0f, 7.0f);
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        FloatIterable iterable6 = this.newWith(1.0f, 31.0f, 32.0f);
        FloatIterable iterable7 = this.newWith(35.0f, 31.0f, 1.0f);
        FloatIterable iterable8 = this.newWith(32.0f, 31.0f, 1.0f, 50.0f);
        FloatIterable iterable9 = this.newWith(0.0f, 1.0f, 2.0f);
        FloatIterable iterable10 = this.newWith(0.0f, 1.0f, 3.0f);
        FloatIterable iterable11 = this.newWith(3.0f, 1.0f, 2.0f);
        FloatIterable iterable12 = this.newWith(3.0f);
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
        Assert.assertNotEquals(this.newWith(), this.newWith(100.0f));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(this.newObjectCollectionWith(1.0f, 2.0f, 3.0f).hashCode(), this.newWith(1.0f, 2.0f, 3.0f).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 31.0f).hashCode(), this.newWith(0.0f, 1.0f, 31.0f).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32.0f).hashCode(), this.newWith(32.0f).hashCode());
        Assert.assertNotEquals(this.newObjectCollectionWith(32.0f).hashCode(), this.newWith(0.0f).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(31.0f, 32.0f, 50.0f).hashCode(), this.newWith(31.0f, 32.0f, 50.0f).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32.0f, 50.0f, 60.0f).hashCode(), this.newWith(32.0f, 50.0f, 60.0f).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[1.0]", this.newWith(1.0f).toString());
        Assert.assertEquals("[31.0]", this.newWith(31.0f).toString());
        Assert.assertEquals("[32.0]", this.newWith(32.0f).toString());
        FloatIterable iterable = this.newWith(1.0f, 2.0f);
        Assert.assertTrue("[1.0, 2.0]".equals(iterable.toString()) || "[2.0, 1.0]".equals(iterable.toString()));
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        Assert.assertTrue(iterable1.toString(), iterable1.toString().equals("[0.0, 31.0]") || iterable1.toString().equals("[31.0, 0.0]"));
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(iterable2.toString(), iterable2.toString().equals("[31.0, 32.0]") || iterable2.toString().equals("[32.0, 31.0]"));
        FloatIterable iterable3 = this.newWith(32.0f, 33.0f);
        Assert.assertTrue(iterable3.toString(), iterable3.toString().equals("[32.0, 33.0]") || iterable3.toString().equals("[33.0, 32.0]"));
        FloatIterable iterable4 = this.newWith(0.0f, 1.0f);
        Assert.assertTrue(iterable4.toString(), iterable4.toString().equals("[0.0, 1.0]") || iterable4.toString().equals("[1.0, 0.0]"));
    }

    @Test
    public void makeString() {
        FloatIterable iterable = this.classUnderTest();
        Assert.assertEquals("1.0", this.newWith(1.0f).makeString("/"));
        Assert.assertEquals("31.0", this.newWith(31.0f).makeString());
        Assert.assertEquals("32.0", this.newWith(32.0f).makeString());
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        Assert.assertTrue(iterable1.makeString(), iterable1.makeString().equals("0.0, 31.0") || iterable1.makeString().equals("31.0, 0.0"));
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(iterable2.makeString("[", "/", "]"), iterable2.makeString("[", "/", "]").equals("[31.0/32.0]") || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));
        FloatIterable iterable3 = this.newWith(32.0f, 33.0f);
        Assert.assertTrue(iterable3.makeString("/"), iterable3.makeString("/").equals("32.0/33.0") || iterable3.makeString("/").equals("33.0/32.0"));
        FloatIterable iterable4 = this.newWith(1.0f, 2.0f);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString()) || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/")) || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]")) || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
        Assert.assertTrue(iterable5.makeString(), iterable5.makeString().equals("0.0, 1.0") || iterable5.makeString().equals("1.0, 0.0"));
        Assert.assertTrue(iterable5.makeString("[", "/", "]"), iterable5.makeString("[", "/", "]").equals("[0.0/1.0]") || iterable5.makeString("[", "/", "]").equals("[1.0/0.0]"));
        Assert.assertTrue(iterable5.makeString("/"), iterable5.makeString("/").equals("0.0/1.0") || iterable5.makeString("/").equals("1.0/0.0"));
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
        this.newWith(1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        FloatIterable iterable = this.newWith(1.0f, 2.0f);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString()) || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString()) || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31.0f).appendString(appendable5);
        Assert.assertEquals("31.0", appendable5.toString());
        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32.0f).appendString(appendable6);
        Assert.assertEquals("32.0", appendable6.toString());
        StringBuilder appendable7 = new StringBuilder();
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString()) || "31.0, 0.0".equals(appendable7.toString()));
        StringBuilder appendable8 = new StringBuilder();
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString()) || "32.0/31.0".equals(appendable8.toString()));
        StringBuilder appendable9 = new StringBuilder();
        FloatIterable iterable4 = this.newWith(32.0f, 33.0f);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString()) || "[33.0/32.0]".equals(appendable9.toString()));
        StringBuilder appendable10 = new StringBuilder();
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0.0, 1.0".equals(appendable10.toString()) || "1.0, 0.0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0.0/1.0".equals(appendable11.toString()) || "1.0/0.0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0.0/1.0]".equals(appendable12.toString()) || "[1.0/0.0]".equals(appendable12.toString()));
    }

    @Test
    public void toList() {
        FloatIterable iterable = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(FloatArrayList.newListWith(31.0f, 32.0f).equals(iterable.toList()) || FloatArrayList.newListWith(32.0f, 31.0f).equals(iterable.toList()));
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.newWith(0.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(31.0f), this.newWith(31.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(32.0f), this.newWith(32.0f).toList());
        Assert.assertEquals(new FloatArrayList(), this.newWith().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(), this.newWith().toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWith(1.0f).toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 1.0f, 31.0f), this.newWith(0.0f, 31.0f, 1.0f).toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 1.0f, 31.0f, 32.0f), this.newWith(0.0f, 31.0f, 32.0f, 1.0f).toSortedList());
    }

    @Test
    public void toSortedListByComparator() {
        FloatIterable iterable = this.newWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        // odd/even comparator
        MutableFloatList result = iterable.toSortedList((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertNotSame(iterable, result);
        result.collectBoolean(e -> e % 2 == 0, BooleanLists.mutable.of()).forEachWithIndex((e, i) -> Assert.assertEquals("index " + i, i < 5, e));
    }

    @Test
    public void toSortedListByFunctionNaturalOrder() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        FloatIterable index = this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f);
        MutableFloatList result = index.toSortedListBy(i -> list.get((int) i));
        Assert.assertNotSame(index, result);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 0.0f, 4.0f, 3.0f), result);
    }

    @Test
    public void toSortedListByFunctionWithComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        FloatIterable index = this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f);
        MutableFloatList result = index.toSortedListBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertNotSame(index, result);
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 4.0f, 0.0f, 2.0f, 1.0f), result);
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), this.newWith(1.0f).toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f).toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f), this.newWith(0.0f, 1.0f, 31.0f).toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, 32.0f), this.newWith(0.0f, 1.0f, 31.0f, 32.0f).toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(new FloatHashBag(), this.newWith().toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.newWith(1.0f).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), this.newWith(1.0f, 2.0f, 3.0f).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f), this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f, 32.0f), this.newWith(0.0f, 1.0f, 31.0f, 32.0f).toBag());
    }

    @Test
    public void asLazy() {
        FloatIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyFloatIterable.class, iterable.asLazy());
        FloatIterable iterable1 = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(iterable1.toBag(), iterable1.asLazy().toBag());
        Verify.assertInstanceOf(LazyFloatIterable.class, iterable1.asLazy());
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(iterable2.toBag(), iterable2.asLazy().toBag());
        Verify.assertInstanceOf(LazyFloatIterable.class, iterable2.asLazy());
        FloatIterable iterable3 = this.newWith();
        Assert.assertEquals(iterable3.toBag(), iterable3.asLazy().toBag());
        Verify.assertInstanceOf(LazyFloatIterable.class, iterable3.asLazy());
        FloatIterable iterable4 = this.newWith(1.0f);
        Assert.assertEquals(iterable4.toBag(), iterable4.asLazy().toBag());
        Verify.assertInstanceOf(LazyFloatIterable.class, iterable4.asLazy());
    }

    @Test
    public void injectInto() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        Float sum1 = iterable1.injectInto(Float.valueOf(0.0f), (Float result, float value) -> Float.valueOf((float) (result + value + 1)));
        Assert.assertEquals(Float.valueOf(36.0f), sum1);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        Float sum2 = iterable2.injectInto(Float.valueOf(0.0f), (Float result, float value) -> Float.valueOf((float) (result + value + 1)));
        Assert.assertEquals(Float.valueOf(37.0f), sum2);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        Float sum3 = iterable3.injectInto(Float.valueOf(0.0f), (Float result, float value) -> Float.valueOf((float) (result + value + 1)));
        Assert.assertEquals(Float.valueOf(38.0f), sum3);
    }

    @Test
    public void injectIntoBoolean() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        boolean sum1 = iterable1.injectIntoBoolean(false, (boolean result, float value) -> (boolean) (result || value == 0.0f));
        Assert.assertEquals(true, sum1);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        boolean sum2 = iterable2.injectIntoBoolean(false, (boolean result, float value) -> (boolean) (result || value == 0.0f));
        Assert.assertEquals(false, sum2);
    }

    @Test
    public void injectIntoByte() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        byte sum1 = iterable1.injectIntoByte((byte) 0, (byte result, float value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 36, sum1);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        byte sum2 = iterable2.injectIntoByte((byte) 0, (byte result, float value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 37, sum2);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        byte sum3 = iterable3.injectIntoByte((byte) 0, (byte result, float value) -> (byte) (result + value + 1));
        Assert.assertEquals((byte) 38, sum3);
    }

    @Test
    public void injectIntoChar() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        char sum1 = iterable1.injectIntoChar((char) 0, (char result, float value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 36, sum1);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        char sum2 = iterable2.injectIntoChar((char) 0, (char result, float value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 37, sum2);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        char sum3 = iterable3.injectIntoChar((char) 0, (char result, float value) -> (char) (result + value + 1));
        Assert.assertEquals((char) 38, sum3);
    }

    @Test
    public void injectIntoShort() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        short sum1 = iterable1.injectIntoShort((short) 0, (short result, float value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 36, sum1);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        short sum2 = iterable2.injectIntoShort((short) 0, (short result, float value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 37, sum2);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        short sum3 = iterable3.injectIntoShort((short) 0, (short result, float value) -> (short) (result + value + 1));
        Assert.assertEquals((short) 38, sum3);
    }

    @Test
    public void injectIntoInt() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        int sum1 = iterable1.injectIntoInt(0, (int result, float value) -> (int) (result + value + 1));
        Assert.assertEquals(36, sum1);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        int sum2 = iterable2.injectIntoInt(0, (int result, float value) -> (int) (result + value + 1));
        Assert.assertEquals(37, sum2);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        int sum3 = iterable3.injectIntoInt(0, (int result, float value) -> (int) (result + value + 1));
        Assert.assertEquals(38, sum3);
    }

    @Test
    public void injectIntoFloat() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        float sum1 = iterable1.injectIntoFloat(0.0f, (float result, float value) -> (float) (result + value + 1));
        Assert.assertEquals(36.0f, sum1, 0.001);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        float sum2 = iterable2.injectIntoFloat(0.0f, (float result, float value) -> (float) (result + value + 1));
        Assert.assertEquals(37.0f, sum2, 0.001);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        float sum3 = iterable3.injectIntoFloat(0.0f, (float result, float value) -> (float) (result + value + 1));
        Assert.assertEquals(38.0f, sum3, 0.001);
    }

    @Test
    public void injectIntoLong() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        long sum1 = iterable1.injectIntoLong(0L, (long result, float value) -> (long) (result + value + 1));
        Assert.assertEquals(36L, sum1);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        long sum2 = iterable2.injectIntoLong(0L, (long result, float value) -> (long) (result + value + 1));
        Assert.assertEquals(37L, sum2);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        long sum3 = iterable3.injectIntoLong(0L, (long result, float value) -> (long) (result + value + 1));
        Assert.assertEquals(38L, sum3);
    }

    @Test
    public void injectIntoDouble() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        double sum1 = iterable1.injectIntoDouble(0.0, (double result, float value) -> (double) (result + value + 1));
        Assert.assertEquals(36.0, sum1, 0.001);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        double sum2 = iterable2.injectIntoDouble(0.0, (double result, float value) -> (double) (result + value + 1));
        Assert.assertEquals(37.0, sum2, 0.001);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        double sum3 = iterable3.injectIntoDouble(0.0, (double result, float value) -> (double) (result + value + 1));
        Assert.assertEquals(38.0, sum3, 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void reduceOnEmptyThrows() {
        this.newWith().reduce((double result, float value) -> (double) result + (double) value + 1.0);
    }

    @Test
    public void reduce() {
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        double sum1 = iterable1.reduce((double result, float value) -> (double) result + (double) value + 1.0);
        Assert.assertEquals(35.0, sum1, 0.001);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        double sum2 = iterable2.reduce((double result, float value) -> (double) result + (double) value + 1.0);
        Assert.assertEquals(36.0, sum2, 0.001);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        double sum3 = iterable3.reduce((double result, float value) -> (double) result + (double) value + 1.0);
        Assert.assertEquals(37.0, sum3, 0.001);
    }

    @Test
    public void reduceIfEmpty() {
        double empty1 = this.newWith().reduceIfEmpty((double result, float value) -> (double) result + (double) value + 1.0, 1.0);
        Assert.assertEquals(1.0, empty1, 0.001);
        double empty2 = this.newWith().reduceIfEmpty((double result, float value) -> (double) result + (double) value + 1.0, 0.0);
        Assert.assertEquals(0.0, empty2, 0.001);
        FloatIterable iterable1 = this.newWith(0.0f, 2.0f, 31.0f);
        double sum1 = iterable1.reduceIfEmpty((double result, float value) -> (double) result + (double) value + 1.0, 0.0);
        Assert.assertEquals(35.0, sum1, 0.001);
        FloatIterable iterable2 = this.newWith(1.0f, 2.0f, 31.0f);
        double sum2 = iterable2.reduceIfEmpty((double result, float value) -> (double) result + (double) value + 1.0, 0.0);
        Assert.assertEquals(36.0, sum2, 0.001);
        FloatIterable iterable3 = this.newWith(0.0f, 1.0f, 2.0f, 31.0f);
        double sum3 = iterable3.reduceIfEmpty((double result, float value) -> (double) result + (double) value + 1.0, 0.0);
        Assert.assertEquals(37.0, sum3, 0.001);
    }

    @Test
    public void chunk() {
        FloatIterable iterable = this.newWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0f), this.newMutableCollectionWith(1.0f), this.newMutableCollectionWith(2.0f), this.newMutableCollectionWith(3.0f), this.newMutableCollectionWith(4.0f), this.newMutableCollectionWith(5.0f)).toSet(), iterable.chunk(1).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0f, 1.0f), this.newMutableCollectionWith(2.0f, 3.0f), this.newMutableCollectionWith(4.0f, 5.0f)).toSet(), iterable.chunk(2).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0f, 1.0f, 2.0f), this.newMutableCollectionWith(3.0f, 4.0f, 5.0f)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f), this.newMutableCollectionWith(4.0f, 5.0f)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f)).toSet(), iterable.chunk(6).toSet());
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f)).toSet(), iterable.chunk(7).toSet());
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0f)), this.newWith(0.0f).chunk(1));
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newMutableCollectionWith().chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatIterableTestCase instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIterableTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractFloatIterableTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractFloatIterableTestCase::newCollection;
            this.payloads.isEmpty = AbstractFloatIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatIterableTestCase::notEmpty;
            this.payloads.tap = AbstractFloatIterableTestCase::tap;
            this.payloads.contains = AbstractFloatIterableTestCase::contains;
            this.payloads.contains_NaN = AbstractFloatIterableTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractFloatIterableTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractFloatIterableTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractFloatIterableTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractFloatIterableTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractFloatIterableTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractFloatIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractFloatIterableTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractFloatIterableTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractFloatIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractFloatIterableTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractFloatIterableTestCase::containsNoneIterable;
            this.payloads.floatIterator = AbstractFloatIterableTestCase::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIterableTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIterableTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractFloatIterableTestCase::forEach;
            this.payloads.size = AbstractFloatIterableTestCase::size;
            this.payloads.count = AbstractFloatIterableTestCase::count;
            this.payloads.anySatisfy = AbstractFloatIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractFloatIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractFloatIterableTestCase::noneSatisfy;
            this.payloads.collect = AbstractFloatIterableTestCase::collect;
            this.payloads.collectWithTarget = AbstractFloatIterableTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractFloatIterableTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractFloatIterableTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractFloatIterableTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractFloatIterableTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractFloatIterableTestCase::select;
            this.payloads.selectWithTarget = AbstractFloatIterableTestCase::selectWithTarget;
            this.payloads.reject = AbstractFloatIterableTestCase::reject;
            this.payloads.rejectWithTarget = AbstractFloatIterableTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractFloatIterableTestCase::detectIfNone;
            this.payloads.max = AbstractFloatIterableTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIterableTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractFloatIterableTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIterableTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractFloatIterableTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractFloatIterableTestCase::maxIfEmpty;
            this.payloads.sum = AbstractFloatIterableTestCase::sum;
            this.payloads.summaryStatistics = AbstractFloatIterableTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractFloatIterableTestCase::sumConsistentRounding;
            this.payloads.average = AbstractFloatIterableTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIterableTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractFloatIterableTestCase::averageIfEmpty;
            this.payloads.median = AbstractFloatIterableTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIterableTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractFloatIterableTestCase::medianIfEmpty;
            this.payloads.toArray = AbstractFloatIterableTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractFloatIterableTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractFloatIterableTestCase::toSortedArray;
            this.payloads.testEquals = AbstractFloatIterableTestCase::testEquals;
            this.payloads.testHashCode = AbstractFloatIterableTestCase::testHashCode;
            this.payloads.testToString = AbstractFloatIterableTestCase::testToString;
            this.payloads.makeString = AbstractFloatIterableTestCase::makeString;
            this.payloads.appendString = AbstractFloatIterableTestCase::appendString;
            this.payloads.toList = AbstractFloatIterableTestCase::toList;
            this.payloads.toSortedList = AbstractFloatIterableTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractFloatIterableTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractFloatIterableTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractFloatIterableTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractFloatIterableTestCase::toSet;
            this.payloads.toBag = AbstractFloatIterableTestCase::toBag;
            this.payloads.asLazy = AbstractFloatIterableTestCase::asLazy;
            this.payloads.injectInto = AbstractFloatIterableTestCase::injectInto;
            this.payloads.injectIntoBoolean = AbstractFloatIterableTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractFloatIterableTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractFloatIterableTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractFloatIterableTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractFloatIterableTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractFloatIterableTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractFloatIterableTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractFloatIterableTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIterableTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractFloatIterableTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractFloatIterableTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractFloatIterableTestCase::chunk;
        }
    }
}
