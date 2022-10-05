/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.map.primitive.IntBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntBooleanMap;
import org.eclipse.collections.api.tuple.primitive.IntBooleanPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractIntBooleanMapTestCase {

    protected abstract IntBooleanMap classUnderTest();

    protected abstract IntBooleanMap newWithKeysValues(int key1, boolean value1);

    protected abstract IntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2);

    protected abstract IntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3);

    protected abstract IntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3, int key4, boolean value4);

    protected abstract IntBooleanMap getEmptyMap();

    @Test
    public void get() {
        Assert.assertTrue(this.classUnderTest().get(0));
        Assert.assertFalse(this.classUnderTest().get(31));
        Assert.assertTrue(this.classUnderTest().get(32));
        Assert.assertFalse(this.classUnderTest().get(1));
        Assert.assertFalse(this.classUnderTest().get(33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(31, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(32, false));
    }

    @Test
    public void getOrThrow() {
        Assert.assertTrue(this.classUnderTest().getOrThrow(0));
        Assert.assertFalse(this.classUnderTest().getOrThrow(31));
        Assert.assertTrue(this.classUnderTest().getOrThrow(32));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(1));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey(0));
        Assert.assertTrue(this.classUnderTest().containsKey(31));
        Assert.assertTrue(this.classUnderTest().containsKey(32));
        Assert.assertFalse(this.classUnderTest().containsKey(1));
        Assert.assertFalse(this.classUnderTest().containsKey(5));
        Assert.assertFalse(this.classUnderTest().containsKey(35));
    }

    @Test
    public void containsValue() {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertTrue(this.classUnderTest().containsValue(false));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(true));
        Assert.assertTrue(this.classUnderTest().contains(false));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.classUnderTest().containsAll(true, false));
        Assert.assertTrue(this.classUnderTest().containsAll(true, true));
        Assert.assertTrue(this.classUnderTest().containsAll(false, false));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, false));
        Verify.assertSize(1, this.newWithKeysValues(1, true));
        Verify.assertSize(2, this.newWithKeysValues(1, true, 5, false));
        Verify.assertSize(2, this.newWithKeysValues(0, false, 5, false));
        Verify.assertSize(3, this.newWithKeysValues(1, true, 0, true, 5, true));
        Verify.assertSize(2, this.newWithKeysValues(6, false, 5, true));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, true).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, true).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, false).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, false).notEmpty());
    }

    @Test
    public void testEquals() {
        IntBooleanMap map1 = this.newWithKeysValues(0, true, 1, false, 32, true);
        IntBooleanMap map2 = this.newWithKeysValues(32, true, 0, true, 1, false);
        IntBooleanMap map3 = this.newWithKeysValues(0, true, 1, true, 32, true);
        IntBooleanMap map4 = this.newWithKeysValues(0, false, 1, false, 32, true);
        IntBooleanMap map5 = this.newWithKeysValues(0, true, 1, false, 32, false);
        IntBooleanMap map6 = this.newWithKeysValues(50, true, 60, false, 70, false);
        IntBooleanMap map7 = this.newWithKeysValues(50, true, 60, false);
        IntBooleanMap map8 = this.newWithKeysValues(0, true, 1, false);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, true, 1, false, 32, true).hashCode(), this.newWithKeysValues(32, true, 0, true, 1, false).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, true, 60, false, 70, false).hashCode(), this.newWithKeysValues(50, true, 60, false, 70, false).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=true}", this.newWithKeysValues(0, true).toString());
        Assert.assertEquals("{1=false}", this.newWithKeysValues(1, false).toString());
        Assert.assertEquals("{5=false}", this.newWithKeysValues(5, false).toString());
        IntBooleanMap map1 = this.newWithKeysValues(0, true, 1, false);
        Assert.assertTrue(map1.toString(), "{0=true, 1=false}".equals(map1.toString()) || "{1=false, 0=true}".equals(map1.toString()));
        IntBooleanMap map2 = this.newWithKeysValues(1, false, 32, true);
        Assert.assertTrue(map2.toString(), "{1=false, 32=true}".equals(map2.toString()) || "{32=true, 1=false}".equals(map2.toString()));
        IntBooleanMap map3 = this.newWithKeysValues(0, true, 32, true);
        Assert.assertTrue(map3.toString(), "{0=true, 32=true}".equals(map3.toString()) || "{32=true, 0=true}".equals(map3.toString()));
        IntBooleanMap map4 = this.newWithKeysValues(32, true, 33, false);
        Assert.assertTrue(map4.toString(), "{32=true, 33=false}".equals(map4.toString()) || "{33=false, 32=true}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        IntBooleanMap map0 = this.newWithKeysValues(0, false, 3, true);
        String[] sum0 = { "" };
        map0.forEach((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        IntBooleanMap map1 = this.newWithKeysValues(1, true, 3, true);
        String[] sum1 = { "" };
        map1.forEach((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        IntBooleanMap map01 = this.newWithKeysValues(0, false, 1, true);
        String[] sum01 = { "" };
        map01.forEach((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        IntBooleanMap map = this.newWithKeysValues(3, false, 4, false);
        String[] sum = { "" };
        map.forEach((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachValue() {
        IntBooleanMap map0 = this.newWithKeysValues(0, false, 3, true);
        String[] sum0 = { "" };
        map0.forEachValue((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        IntBooleanMap map1 = this.newWithKeysValues(1, true, 3, true);
        String[] sum1 = { "" };
        map1.forEachValue((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        IntBooleanMap map01 = this.newWithKeysValues(0, false, 1, true);
        String[] sum01 = { "" };
        map01.forEachValue((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        IntBooleanMap map = this.newWithKeysValues(3, false, 4, false);
        String[] sum = { "" };
        map.forEachValue((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachKey() {
        IntBooleanMap map0 = this.newWithKeysValues(0, true, 3, false);
        int[] sum0 = new int[1];
        map0.forEachKey((int each) -> sum0[0] += each);
        Assert.assertEquals(3, sum0[0]);
        IntBooleanMap map1 = this.newWithKeysValues(1, false, 3, false);
        int[] sum1 = new int[1];
        map1.forEachKey((int each) -> sum1[0] += each);
        Assert.assertEquals(4, sum1[0]);
        IntBooleanMap map01 = this.newWithKeysValues(0, true, 1, true);
        int[] sum01 = new int[1];
        map01.forEachKey((int each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        IntBooleanMap map = this.newWithKeysValues(3, false, 4, true);
        int[] sum = new int[1];
        map.forEachKey((int each) -> sum[0] += each);
        Assert.assertEquals(7, sum[0]);
    }

    @Test
    public void forEachKeyValue() {
        IntBooleanMap map0 = this.newWithKeysValues(0, true, 3, true);
        int[] sumKey0 = new int[1];
        String[] sumValue0 = { "" };
        map0.forEachKeyValue((int eachKey, boolean eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3, sumKey0[0]);
        Assert.assertEquals("truetrue", sumValue0[0]);
        IntBooleanMap map1 = this.newWithKeysValues(1, true, 3, false);
        int[] sumKey1 = new int[1];
        String[] sumValue1 = { "" };
        map1.forEachKeyValue((int eachKey, boolean eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4, sumKey1[0]);
        Assert.assertTrue("truefalse".equals(sumValue1[0]) || "falsetrue".equals(sumValue1[0]));
        IntBooleanMap map01 = this.newWithKeysValues(0, false, 1, false);
        int[] sumKey01 = new int[1];
        String[] sumValue01 = { "" };
        map01.forEachKeyValue((int eachKey, boolean eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals("falsefalse", sumValue01[0]);
        IntBooleanMap map = this.newWithKeysValues(3, false, 4, true);
        int[] sumKey = new int[1];
        String[] sumValue = { "" };
        map.forEachKeyValue((int eachKey, boolean eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7, sumKey[0]);
        Assert.assertTrue("truefalse".equals(sumValue[0]) || "falsetrue".equals(sumValue[0]));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("true", this.newWithKeysValues(0, true).makeString());
        Assert.assertEquals("false", this.newWithKeysValues(1, false).makeString());
        Assert.assertEquals("false", this.newWithKeysValues(5, false).makeString());
        IntBooleanMap map1 = this.newWithKeysValues(0, true, 1, false);
        Assert.assertTrue(map1.makeString(), "true, false".equals(map1.makeString()) || "false, true".equals(map1.makeString()));
        IntBooleanMap map2 = this.newWithKeysValues(1, false, 32, true);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[false/true]".equals(map2.makeString("[", "/", "]")) || "true/false]".equals(map2.makeString("[", "/", "]")));
        IntBooleanMap map3 = this.newWithKeysValues(0, true, 32, true);
        Assert.assertTrue(map3.makeString("~"), "true~true".equals(map3.makeString("~")) || "true~true".equals(map3.makeString("~")));
        IntBooleanMap map4 = this.newWithKeysValues(32, true, 33, false);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[true, false]".equals(map4.makeString("[", ", ", "]")) || "[false, true]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, true).appendString(appendable0);
        Assert.assertEquals("true", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, false).appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5, false).appendString(appendable2);
        Assert.assertEquals("false", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        IntBooleanMap map1 = this.newWithKeysValues(0, true, 1, false);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "true, false".equals(appendable3.toString()) || "false, true".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        IntBooleanMap map2 = this.newWithKeysValues(1, false, 32, true);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[false/true]".equals(appendable4.toString()) || "[true/false]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        IntBooleanMap map3 = this.newWithKeysValues(1, false, 32, true);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[false/true]".equals(appendable5.toString()) || "[true/false]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "true/false".equals(appendable6.toString()) || "false/true".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, false, 3, true);
        IntBooleanMap actual1 = map.select((int key, boolean value) -> key == 1 || value);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, false, 3, true, 0, true), actual1);
        IntBooleanMap actual2 = map.select((int key, boolean value) -> key == 0 || !value);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(0, true, 2, false, 1, false), actual2);
    }

    @Test
    public void reject() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, false, 3, true);
        IntBooleanMap actual1 = map.reject((int key, boolean value) -> key == 2 || !value);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(0, true, 3, true), actual1);
        IntBooleanMap actual2 = map.reject((int key, boolean value) -> key == 3 || value);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, false, 2, false), actual2);
    }

    @Test
    public void select_value() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, true, 3, false);
        BooleanIterable actual1 = map.select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual1);
        BooleanIterable actual2 = map.select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual2);
    }

    @Test
    public void reject_value() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, true, 3, false);
        BooleanIterable actual1 = map.reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual1);
        BooleanIterable actual2 = map.reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual2);
    }

    @Test
    public void collect() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, true);
        RichIterable<Boolean> objects = map.collect((boolean booleanParameter) -> !booleanParameter);
        Assert.assertEquals(HashBag.newBagWith(false, true, false), objects.toBag());
    }

    @Test
    public void count() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, true);
        Assert.assertEquals(2, map.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1, map.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone_value() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, false);
        IntBooleanMap map2 = this.newWithKeysValues(0, true, 1, true, 2, false);
        boolean resultNotFound = map.detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), true);
        Assert.assertTrue(resultNotFound);
        boolean resultNotFound2 = map.detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), false);
        Assert.assertFalse(resultNotFound2);
        Assert.assertTrue(map.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(map.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(map2.detectIfNone(BooleanPredicates.isFalse(), true));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.newWithKeysValues(1, false, 2, true).anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues(1, true, 2, false).allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues(1, false, 2, true).noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void toList() {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues(0, true).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.newWithKeysValues(1, false).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues(2, true).toList());
    }

    @Test
    public void toSet() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, true, 3, false);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), map.toSet());
    }

    @Test
    public void toBag() {
        IntBooleanMap map = this.newWithKeysValues(0, true, 1, false, 2, true, 3, false);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false), map.toBag());
    }

    @Test
    public void booleanIterator() {
        MutableBooleanBag expected = BooleanHashBag.newBagWith(true, false, true);
        MutableBooleanBag actual = BooleanHashBag.newBagWith();
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().booleanIterator().next());
    }

    @Test
    public void asLazy() {
        IntBooleanMap map = this.newWithKeysValues(1, true, 2, true, 3, false);
        LazyBooleanIterable lazy = map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(true, true, false));
    }

    @Test
    public void keysView() {
        MutableIntList keys = this.newWithKeysValues(1, true, 2, false).keysView().toSortedList();
        Assert.assertEquals(IntArrayList.newListWith(1, 2), keys);
    }

    @Test
    public void keyValuesView() {
        MutableBag<IntBooleanPair> expected = Bags.mutable.of();
        this.classUnderTest().forEachKeyValue((int key, boolean value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.classUnderTest().keyValuesView().toBag());
    }

    @Test
    public void toArray() {
        IntBooleanMap map = this.newWithKeysValues(1, false, 2, true);
        boolean[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new boolean[] { false, true }, array) || Arrays.equals(new boolean[] { true, false }, array));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableIntBooleanMap.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrThrow, this.description("getOrThrow"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll, this.description("containsAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachValue, this.description("forEachValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKey, this.description("forEachKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValue, this.description("forEachKeyValue"));
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
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select_value, this.description("select_value"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject_value, this.description("reject_value"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone_value, this.description("detectIfNone_value"));
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanIterator, this.description("booleanIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keysView, this.description("keysView"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keyValuesView, this.description("keyValuesView"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractIntBooleanMapTestCase implementation();
    }
}
