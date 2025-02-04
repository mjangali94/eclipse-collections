/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link BooleanIterable}s.
 */
public abstract class AbstractBooleanIterableTestCase {

    protected abstract BooleanIterable classUnderTest();

    protected abstract BooleanIterable newWith(boolean... elements);

    protected abstract BooleanIterable newMutableCollectionWith(boolean... elements);

    protected abstract RichIterable<Object> newObjectCollectionWith(Object... elements);

    @Test
    public void newCollectionWith() {
        BooleanIterable iterable = this.newWith(true, false, true);
        Verify.assertSize(3, iterable);
        Assert.assertTrue(iterable.containsAll(true, false, true));
        BooleanIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll(true, false, true));
        BooleanIterable iterable2 = this.newWith(true);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll(true, false, true));
        Assert.assertTrue(iterable2.containsAll(true, true));
    }

    @Test
    public void newCollection() {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith(true, false, true), this.newWith(true, false, true));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith(false));
        Verify.assertNotEmpty(this.newWith(true));
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith(false).notEmpty());
        Assert.assertTrue(this.newWith(true).notEmpty());
    }

    @Test
    public void contains() {
        BooleanIterable emptyCollection = this.newWith();
        Assert.assertFalse(emptyCollection.contains(true));
        Assert.assertFalse(emptyCollection.contains(false));
        BooleanIterable booleanIterable = this.classUnderTest();
        int size = booleanIterable.size();
        Assert.assertEquals(size >= 1, booleanIterable.contains(true));
        Assert.assertEquals(size >= 2, booleanIterable.contains(false));
        Assert.assertFalse(this.newWith(true, true, true).contains(false));
        Assert.assertFalse(this.newWith(false, false, false).contains(true));
    }

    @Test
    public void containsAllArray() {
        BooleanIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 1, iterable.containsAll(true));
        Assert.assertEquals(size >= 2, iterable.containsAll(true, false, true));
        Assert.assertEquals(size >= 2, iterable.containsAll(true, false));
        Assert.assertEquals(size >= 1, iterable.containsAll(true, true));
        Assert.assertEquals(size >= 2, iterable.containsAll(false, false));
        BooleanIterable emptyCollection = this.newWith();
        Assert.assertFalse(emptyCollection.containsAll(true));
        Assert.assertFalse(emptyCollection.containsAll(false));
        Assert.assertFalse(emptyCollection.containsAll(false, true, false));
        Assert.assertFalse(this.newWith(true, true).containsAll(false, true, false));
        BooleanIterable trueCollection = this.newWith(true, true, true, true);
        Assert.assertFalse(trueCollection.containsAll(true, false));
        BooleanIterable falseCollection = this.newWith(false, false, false, false);
        Assert.assertFalse(falseCollection.containsAll(true, false));
    }

    @Test
    public void containsAllIterable() {
        BooleanIterable emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.containsAll(new BooleanArrayList()));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(false)));
        BooleanIterable booleanIterable = this.classUnderTest();
        int size = booleanIterable.size();
        Assert.assertTrue(booleanIterable.containsAll(new BooleanArrayList()));
        Assert.assertEquals(size >= 1, booleanIterable.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertEquals(size >= 2, booleanIterable.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertEquals(size >= 2, booleanIterable.containsAll(BooleanArrayList.newListWith(true, false)));
        BooleanIterable iterable = this.newWith(true, true, false, false, false);
        Assert.assertTrue(iterable.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(iterable.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(iterable.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(iterable.containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(iterable.containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertTrue(iterable.containsAll(BooleanArrayList.newListWith(true, false, true)));
        Assert.assertFalse(this.newWith(true, true).containsAll(BooleanArrayList.newListWith(false, true, false)));
        BooleanIterable trueCollection = this.newWith(true, true, true, true);
        Assert.assertFalse(trueCollection.containsAll(BooleanArrayList.newListWith(true, false)));
        BooleanIterable falseCollection = this.newWith(false, false, false, false);
        Assert.assertFalse(falseCollection.containsAll(BooleanArrayList.newListWith(true, false)));
    }

    @Test
    public void containsAnyArray() {
        BooleanIterable iterable = this.newWith(true);
        Assert.assertTrue(iterable.containsAny(true, false));
        Assert.assertFalse(iterable.containsAny());
        Assert.assertTrue(iterable.containsAny(true));
        Assert.assertFalse(iterable.containsAny(false, false, false));
        BooleanIterable iterable2 = this.newWith(true, false);
        Assert.assertTrue(iterable2.containsAny(true));
        Assert.assertFalse(iterable2.containsAny());
        Assert.assertTrue(iterable2.containsAny(false, false));
        Assert.assertTrue(iterable2.containsAny(true, false, true, false));
        BooleanIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny(true, true));
        Assert.assertFalse(emptyIterable.containsAny());
        Assert.assertFalse(emptyIterable.containsAny(false, true, true));
        Assert.assertFalse(emptyIterable.containsAny(false));
    }

    @Test
    public void containsAnyIterable() {
        BooleanIterable iterable = this.newWith(true);
        Assert.assertTrue(iterable.containsAny(BooleanLists.immutable.with(true, false)));
        Assert.assertFalse(iterable.containsAny(BooleanLists.mutable.empty()));
        Assert.assertTrue(iterable.containsAny(BooleanLists.immutable.with(true)));
        Assert.assertFalse(iterable.containsAny(BooleanLists.immutable.with(false, false, false)));
        BooleanIterable iterable2 = this.newWith(true, false);
        Assert.assertTrue(iterable2.containsAny(BooleanSets.immutable.with(true)));
        Assert.assertFalse(iterable2.containsAny(BooleanSets.mutable.empty()));
        Assert.assertTrue(iterable2.containsAny(BooleanSets.immutable.with(false, false)));
        Assert.assertTrue(iterable2.containsAny(BooleanSets.mutable.with(true, false, true, false)));
        BooleanIterable emptyIterable = this.newWith();
        Assert.assertFalse(emptyIterable.containsAny(BooleanLists.immutable.with(true, true)));
        Assert.assertFalse(emptyIterable.containsAny(BooleanLists.mutable.empty()));
        Assert.assertFalse(emptyIterable.containsAny(BooleanLists.immutable.with(false, true, true)));
        Assert.assertFalse(emptyIterable.containsAny(BooleanLists.mutable.with(false)));
    }

    @Test
    public void containsNoneArray() {
        BooleanIterable iterable = this.newWith(false);
        Assert.assertTrue(iterable.containsNone(true, true));
        Assert.assertTrue(iterable.containsNone());
        Assert.assertFalse(iterable.containsNone(true, false));
        Assert.assertFalse(iterable.containsNone(false));
        BooleanIterable iterable2 = this.newWith(true, false, false);
        Assert.assertFalse(iterable2.containsNone(true, false));
        Assert.assertTrue(iterable2.containsNone());
        Assert.assertFalse(iterable2.containsNone(false, false, false));
        Assert.assertFalse(iterable2.containsNone(false));
        BooleanIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(true, true));
        Assert.assertTrue(emptyIterable.containsNone());
        Assert.assertTrue(emptyIterable.containsNone(true, false));
        Assert.assertTrue(emptyIterable.containsNone(false));
    }

    @Test
    public void containsNoneIterable() {
        BooleanIterable iterable = this.newWith(false);
        Assert.assertTrue(iterable.containsNone(BooleanLists.immutable.with(true, true)));
        Assert.assertTrue(iterable.containsNone(BooleanLists.mutable.empty()));
        Assert.assertFalse(iterable.containsNone(BooleanLists.immutable.with(true, false)));
        Assert.assertFalse(iterable.containsNone(BooleanLists.mutable.with(false)));
        BooleanIterable iterable2 = this.newWith(true, false, false);
        Assert.assertFalse(iterable2.containsNone(BooleanSets.immutable.with(true, false)));
        Assert.assertTrue(iterable2.containsNone(BooleanSets.mutable.empty()));
        Assert.assertFalse(iterable2.containsNone(BooleanSets.immutable.with(false, false, false)));
        Assert.assertFalse(iterable2.containsNone(BooleanSets.mutable.with(false)));
        BooleanIterable emptyIterable = this.newWith();
        Assert.assertTrue(emptyIterable.containsNone(BooleanLists.immutable.with(true, true)));
        Assert.assertTrue(emptyIterable.containsNone(BooleanLists.mutable.empty()));
        Assert.assertTrue(emptyIterable.containsNone(BooleanLists.immutable.with(true, false)));
        Assert.assertTrue(emptyIterable.containsNone(BooleanLists.mutable.with(false)));
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws_non_empty_collection() {
        BooleanIterable iterable = this.newWith(true, true, true);
        BooleanIterator iterator = iterable.booleanIterator();
        while (iterator.hasNext()) {
            Assert.assertTrue(iterator.next());
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws_emptyList() {
        this.newWith().booleanIterator().next();
    }

    @Test
    public void booleanIterator() {
        BooleanArrayList list = BooleanArrayList.newListWith(true, false, true);
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.classUnderTest().forEach(each -> sum[0] += each ? 1 : 0);
        int size = this.classUnderTest().size();
        int halfSize = size / 2;
        Assert.assertEquals((size & 1) == 0 ? halfSize : halfSize + 1, sum[0]);
        long[] sum1 = new long[1];
        this.newWith(true, false, false, true, true, true).forEach(each -> sum1[0] += each ? 1 : 2);
        Assert.assertEquals(8L, sum1[0]);
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.newWith());
        Verify.assertSize(1, this.newWith(true));
        Verify.assertSize(1, this.newWith(false));
        Verify.assertSize(2, this.newWith(true, false));
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, this.newWith(true, false, true).count(BooleanPredicates.isTrue()));
        Assert.assertEquals(0L, this.newWith().count(BooleanPredicates.isFalse()));
        BooleanIterable iterable = this.newWith(true, false, false, true, true, true);
        Assert.assertEquals(4L, iterable.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(2L, iterable.count(BooleanPredicates.isFalse()));
        Assert.assertEquals(6L, iterable.count(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        BooleanIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        int halfSize = size / 2;
        Assert.assertEquals((size & 1) == 1 ? halfSize + 1 : halfSize, iterable1.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(halfSize, iterable1.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void anySatisfy() {
        BooleanIterable booleanIterable = this.classUnderTest();
        int size = booleanIterable.size();
        Assert.assertEquals(size >= 1, booleanIterable.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertEquals(size >= 2, booleanIterable.anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWith(true, true).anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWith().anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWith().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith(true).anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.newWith(false).anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith(false, false, false).anySatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void allSatisfy() {
        BooleanIterable booleanIterable = this.classUnderTest();
        int size = booleanIterable.size();
        Assert.assertEquals(size <= 1, booleanIterable.allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertEquals(size == 0, booleanIterable.allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.newWith().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.newWith(false, false).allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWith(true, false).allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith(true, true, true).allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith(false, false, false).allSatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void noneSatisfy() {
        BooleanIterable booleanIterable = this.classUnderTest();
        int size = booleanIterable.size();
        Assert.assertEquals(size == 0, booleanIterable.noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertEquals(size <= 1, booleanIterable.noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.newWith().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.newWith(false, false).noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith(true, true).noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWith(true, true).noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.newWith(false, false, false).noneSatisfy(BooleanPredicates.isTrue()));
    }

    @Test
    public void select() {
        BooleanIterable iterable = this.classUnderTest();
        int size = iterable.size();
        int halfSize = size / 2;
        Verify.assertSize((size & 1) == 1 ? halfSize + 1 : halfSize, iterable.select(BooleanPredicates.isTrue()));
        Verify.assertSize(halfSize, iterable.select(BooleanPredicates.isFalse()));
        BooleanIterable iterable1 = this.newWith(false, true, false, false, true, true, true);
        Assert.assertEquals(this.newMutableCollectionWith(true, true, true, true), iterable1.select(BooleanPredicates.isTrue()));
        Assert.assertEquals(this.newMutableCollectionWith(false, false, false), iterable1.select(BooleanPredicates.isFalse()));
    }

    @Test
    public void reject() {
        BooleanIterable iterable = this.classUnderTest();
        int size = iterable.size();
        int halfSize = size / 2;
        Verify.assertSize(halfSize, iterable.reject(BooleanPredicates.isTrue()));
        Verify.assertSize((size & 1) == 1 ? halfSize + 1 : halfSize, iterable.reject(BooleanPredicates.isFalse()));
        BooleanIterable iterable1 = this.newWith(false, true, false, false, true, true, true);
        Assert.assertEquals(this.newMutableCollectionWith(false, false, false), iterable1.reject(BooleanPredicates.isTrue()));
        Assert.assertEquals(this.newMutableCollectionWith(true, true, true, true), iterable1.reject(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone() {
        BooleanIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size < 2, iterable.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertTrue(iterable.detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), true));
        BooleanIterable iterable1 = this.newWith(true, true, true);
        Assert.assertFalse(iterable1.detectIfNone(BooleanPredicates.isFalse(), false));
        Assert.assertTrue(iterable1.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertTrue(iterable1.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertTrue(iterable1.detectIfNone(BooleanPredicates.isTrue(), true));
        BooleanIterable iterable2 = this.newWith(false, false, false);
        Assert.assertTrue(iterable2.detectIfNone(BooleanPredicates.isTrue(), true));
        Assert.assertFalse(iterable2.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(iterable2.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(iterable2.detectIfNone(BooleanPredicates.isFalse(), false));
    }

    @Test
    public void collect() {
        FastList<Object> objects = FastList.newListWith();
        for (int i = 0; i < this.classUnderTest().size(); i++) {
            objects.add((i & 1) == 0 ? 1 : 0);
        }
        RichIterable<Object> expected = this.newObjectCollectionWith(objects.toArray());
        Assert.assertEquals(expected, this.classUnderTest().collect(value -> Integer.valueOf(value ? 1 : 0)));
        Assert.assertEquals(this.newObjectCollectionWith(false, true, false), this.newWith(true, false, true).collect(parameter -> !parameter));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(parameter -> !parameter));
        Assert.assertEquals(this.newObjectCollectionWith(true), this.newWith(false).collect(parameter -> !parameter));
    }

    @Test
    public void injectInto() {
        BooleanIterable iterable = this.newWith(true, false, true);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), (object, value) -> object.add(value ? 1 : 0));
        Assert.assertEquals(new MutableInteger(2), result);
    }

    @Test(expected = NoSuchElementException.class)
    public void reduceOnEmptyThrows() {
        this.newWith().reduce((boolean result, boolean value) -> result && value);
    }

    @Test
    public void reduce() {
        BooleanIterable iterable1 = this.newWith(true, false, true);
        boolean and = iterable1.reduce((boolean result, boolean value) -> result && value);
        Assert.assertFalse(and);
        BooleanIterable iterable2 = this.newWith(true, true, true);
        boolean and2 = iterable2.reduce((boolean result, boolean value) -> result && value);
        Assert.assertTrue(and2);
        BooleanIterable iterable3 = this.newWith(true, false, true);
        boolean or = iterable3.reduce((boolean result, boolean value) -> result || value);
        Assert.assertTrue(or);
        BooleanIterable iterable4 = this.newWith(false, false, false);
        boolean or2 = iterable4.reduce((boolean result, boolean value) -> result || value);
        Assert.assertFalse(or2);
    }

    @Test
    public void reduceIfEmpty() {
        Assert.assertTrue(this.newWith().reduceIfEmpty((boolean result, boolean value) -> result && value, true));
        Assert.assertFalse(this.newWith().reduceIfEmpty((boolean result, boolean value) -> result && value, false));
        BooleanIterable iterable1 = this.newWith(true, false, true);
        boolean and = iterable1.reduceIfEmpty((boolean result, boolean value) -> result && value, true);
        Assert.assertFalse(and);
        BooleanIterable iterable2 = this.newWith(true, true, true);
        boolean and2 = iterable2.reduceIfEmpty((boolean result, boolean value) -> result && value, false);
        Assert.assertTrue(and2);
        BooleanIterable iterable3 = this.newWith(true, false, true);
        boolean or = iterable3.reduceIfEmpty((boolean result, boolean value) -> result || value, false);
        Assert.assertTrue(or);
        BooleanIterable iterable4 = this.newWith(false, false, false);
        boolean or2 = iterable4.reduceIfEmpty((boolean result, boolean value) -> result || value, true);
        Assert.assertFalse(or2);
    }

    @Test
    public void toArray() {
        Assert.assertEquals(0L, this.newWith().toArray().length);
        Assert.assertTrue(Arrays.equals(new boolean[] { true }, this.newWith(true).toArray()));
        Assert.assertTrue(Arrays.equals(new boolean[] { false, true }, this.newWith(true, false).toArray()) || Arrays.equals(new boolean[] { true, false }, this.newWith(true, false).toArray()));
    }

    @Test
    public void testEquals() {
        BooleanIterable iterable1 = this.newWith(true, false, true, false);
        BooleanIterable iterable2 = this.newWith(true, false, true, false);
        BooleanIterable iterable3 = this.newWith(false, false, false, true);
        BooleanIterable iterable4 = this.newWith(true, true, true);
        BooleanIterable iterable5 = this.newWith(true, true, false, false, false);
        BooleanIterable iterable6 = this.newWith(true);
        Verify.assertEqualsAndHashCode(iterable1, iterable2);
        Verify.assertEqualsAndHashCode(this.newWith(), this.newWith());
        Verify.assertPostSerializedEqualsAndHashCode(iterable6);
        Verify.assertPostSerializedEqualsAndHashCode(iterable1);
        Verify.assertPostSerializedEqualsAndHashCode(iterable5);
        Assert.assertNotEquals(iterable1, iterable3);
        Assert.assertNotEquals(iterable1, iterable4);
        Assert.assertNotEquals(this.newWith(), this.newWith(true));
        Assert.assertNotEquals(iterable6, this.newWith(true, false));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(true, false, true).hashCode(), this.newWith(true, false, true).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(true).hashCode(), this.newWith(true).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(false).hashCode(), this.newWith(false).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[true]", this.newWith(true).toString());
        BooleanIterable iterable = this.newWith(true, false);
        Assert.assertTrue("[true, false]".equals(iterable.toString()) || "[false, true]".equals(iterable.toString()));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("true", this.newWith(true).makeString("/"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", "/", "]"));
        BooleanIterable iterable = this.newWith(true, false);
        Assert.assertTrue("true, false".equals(iterable.makeString()) || "false, true".equals(iterable.makeString()));
        Assert.assertTrue(iterable.makeString("/"), "true/false".equals(iterable.makeString("/")) || "false/true".equals(iterable.makeString("/")));
        Assert.assertTrue(iterable.makeString("[", "/", "]"), "[true/false]".equals(iterable.makeString("[", "/", "]")) || "[false/true]".equals(iterable.makeString("[", "/", "]")));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", "/", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(true).appendString(appendable1);
        Assert.assertEquals("true", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        BooleanIterable iterable = this.newWith(true, false);
        iterable.appendString(appendable2);
        Assert.assertTrue("true, false".equals(appendable2.toString()) || "false, true".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("true/false".equals(appendable3.toString()) || "false/true".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList() {
        BooleanIterable iterable = this.newWith(true, false);
        Assert.assertTrue(BooleanArrayList.newListWith(false, true).equals(iterable.toList()) || BooleanArrayList.newListWith(true, false).equals(iterable.toList()));
        BooleanIterable iterable1 = this.newWith(true);
        Assert.assertEquals(BooleanArrayList.newListWith(true), iterable1.toList());
        BooleanIterable iterable0 = this.newWith();
        Assert.assertEquals(BooleanArrayList.newListWith(), iterable0.toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(BooleanHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(true), this.newWith(true).toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.newWith(true, false, false, true, true, true).toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(BooleanHashBag.newBagWith(), this.newWith().toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(true), this.newWith(true).toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true), this.newWith(true, false, true).toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, true, true, true, true), this.newWith(true, false, false, true, true, true).toBag());
    }

    @Test
    public void asLazy() {
        BooleanIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyBooleanIterable.class, iterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractBooleanIterableTestCase instance;

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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractBooleanIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> iterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> iterator_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractBooleanIterableTestCase> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractBooleanIterableTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractBooleanIterableTestCase::newCollection;
            this.payloads.isEmpty = AbstractBooleanIterableTestCase::isEmpty;
            this.payloads.notEmpty = AbstractBooleanIterableTestCase::notEmpty;
            this.payloads.contains = AbstractBooleanIterableTestCase::contains;
            this.payloads.containsAllArray = AbstractBooleanIterableTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractBooleanIterableTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractBooleanIterableTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractBooleanIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractBooleanIterableTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractBooleanIterableTestCase::containsNoneIterable;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanIterableTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanIterableTestCase::iterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.iterator_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanIterableTestCase::iterator_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.booleanIterator = AbstractBooleanIterableTestCase::booleanIterator;
            this.payloads.forEach = AbstractBooleanIterableTestCase::forEach;
            this.payloads.size = AbstractBooleanIterableTestCase::size;
            this.payloads.count = AbstractBooleanIterableTestCase::count;
            this.payloads.anySatisfy = AbstractBooleanIterableTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractBooleanIterableTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractBooleanIterableTestCase::noneSatisfy;
            this.payloads.select = AbstractBooleanIterableTestCase::select;
            this.payloads.reject = AbstractBooleanIterableTestCase::reject;
            this.payloads.detectIfNone = AbstractBooleanIterableTestCase::detectIfNone;
            this.payloads.collect = AbstractBooleanIterableTestCase::collect;
            this.payloads.injectInto = AbstractBooleanIterableTestCase::injectInto;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractBooleanIterableTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractBooleanIterableTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractBooleanIterableTestCase::reduceIfEmpty;
            this.payloads.toArray = AbstractBooleanIterableTestCase::toArray;
            this.payloads.testEquals = AbstractBooleanIterableTestCase::testEquals;
            this.payloads.testHashCode = AbstractBooleanIterableTestCase::testHashCode;
            this.payloads.testToString = AbstractBooleanIterableTestCase::testToString;
            this.payloads.makeString = AbstractBooleanIterableTestCase::makeString;
            this.payloads.appendString = AbstractBooleanIterableTestCase::appendString;
            this.payloads.toList = AbstractBooleanIterableTestCase::toList;
            this.payloads.toSet = AbstractBooleanIterableTestCase::toSet;
            this.payloads.toBag = AbstractBooleanIterableTestCase::toBag;
            this.payloads.asLazy = AbstractBooleanIterableTestCase::asLazy;
        }
    }
}
