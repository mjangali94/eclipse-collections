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
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.map.primitive.LongBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongBooleanMap;
import org.eclipse.collections.api.tuple.primitive.LongBooleanPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongBooleanHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractLongBooleanMapTestCase {

    protected abstract LongBooleanMap classUnderTest();

    protected abstract LongBooleanMap newWithKeysValues(long key1, boolean value1);

    protected abstract LongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2);

    protected abstract LongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3);

    protected abstract LongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3, long key4, boolean value4);

    protected abstract LongBooleanMap getEmptyMap();

    @Test
    public void get() {
        Assert.assertTrue(this.classUnderTest().get(0L));
        Assert.assertFalse(this.classUnderTest().get(31L));
        Assert.assertTrue(this.classUnderTest().get(32L));
        Assert.assertFalse(this.classUnderTest().get(1L));
        Assert.assertFalse(this.classUnderTest().get(33L));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0L, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(31L, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(32L, false));
    }

    @Test
    public void getOrThrow() {
        Assert.assertTrue(this.classUnderTest().getOrThrow(0L));
        Assert.assertFalse(this.classUnderTest().getOrThrow(31L));
        Assert.assertTrue(this.classUnderTest().getOrThrow(32L));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(1L));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(33L));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey(0L));
        Assert.assertTrue(this.classUnderTest().containsKey(31L));
        Assert.assertTrue(this.classUnderTest().containsKey(32L));
        Assert.assertFalse(this.classUnderTest().containsKey(1L));
        Assert.assertFalse(this.classUnderTest().containsKey(5L));
        Assert.assertFalse(this.classUnderTest().containsKey(35L));
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
        Verify.assertSize(1, this.newWithKeysValues(0L, false));
        Verify.assertSize(1, this.newWithKeysValues(1L, true));
        Verify.assertSize(2, this.newWithKeysValues(1L, true, 5L, false));
        Verify.assertSize(2, this.newWithKeysValues(0L, false, 5L, false));
        Verify.assertSize(3, this.newWithKeysValues(1L, true, 0L, true, 5L, true));
        Verify.assertSize(2, this.newWithKeysValues(6L, false, 5L, true));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1L, true).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0L, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50L, true).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1L, false).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0L, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50L, false).notEmpty());
    }

    @Test
    public void testEquals() {
        LongBooleanMap map1 = this.newWithKeysValues(0L, true, 1L, false, 32L, true);
        LongBooleanMap map2 = this.newWithKeysValues(32L, true, 0L, true, 1L, false);
        LongBooleanMap map3 = this.newWithKeysValues(0L, true, 1L, true, 32L, true);
        LongBooleanMap map4 = this.newWithKeysValues(0L, false, 1L, false, 32L, true);
        LongBooleanMap map5 = this.newWithKeysValues(0L, true, 1L, false, 32L, false);
        LongBooleanMap map6 = this.newWithKeysValues(50L, true, 60L, false, 70L, false);
        LongBooleanMap map7 = this.newWithKeysValues(50L, true, 60L, false);
        LongBooleanMap map8 = this.newWithKeysValues(0L, true, 1L, false);
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
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0L, true, 1L, false, 32L, true).hashCode(), this.newWithKeysValues(32L, true, 0L, true, 1L, false).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50L, true, 60L, false, 70L, false).hashCode(), this.newWithKeysValues(50L, true, 60L, false, 70L, false).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=true}", this.newWithKeysValues(0L, true).toString());
        Assert.assertEquals("{1=false}", this.newWithKeysValues(1L, false).toString());
        Assert.assertEquals("{5=false}", this.newWithKeysValues(5L, false).toString());
        LongBooleanMap map1 = this.newWithKeysValues(0L, true, 1L, false);
        Assert.assertTrue(map1.toString(), "{0=true, 1=false}".equals(map1.toString()) || "{1=false, 0=true}".equals(map1.toString()));
        LongBooleanMap map2 = this.newWithKeysValues(1L, false, 32L, true);
        Assert.assertTrue(map2.toString(), "{1=false, 32=true}".equals(map2.toString()) || "{32=true, 1=false}".equals(map2.toString()));
        LongBooleanMap map3 = this.newWithKeysValues(0L, true, 32L, true);
        Assert.assertTrue(map3.toString(), "{0=true, 32=true}".equals(map3.toString()) || "{32=true, 0=true}".equals(map3.toString()));
        LongBooleanMap map4 = this.newWithKeysValues(32L, true, 33L, false);
        Assert.assertTrue(map4.toString(), "{32=true, 33=false}".equals(map4.toString()) || "{33=false, 32=true}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        LongBooleanMap map0 = this.newWithKeysValues(0L, false, 3L, true);
        String[] sum0 = { "" };
        map0.forEach((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        LongBooleanMap map1 = this.newWithKeysValues(1L, true, 3L, true);
        String[] sum1 = { "" };
        map1.forEach((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        LongBooleanMap map01 = this.newWithKeysValues(0L, false, 1L, true);
        String[] sum01 = { "" };
        map01.forEach((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        LongBooleanMap map = this.newWithKeysValues(3L, false, 4L, false);
        String[] sum = { "" };
        map.forEach((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachValue() {
        LongBooleanMap map0 = this.newWithKeysValues(0L, false, 3L, true);
        String[] sum0 = { "" };
        map0.forEachValue((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        LongBooleanMap map1 = this.newWithKeysValues(1L, true, 3L, true);
        String[] sum1 = { "" };
        map1.forEachValue((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        LongBooleanMap map01 = this.newWithKeysValues(0L, false, 1L, true);
        String[] sum01 = { "" };
        map01.forEachValue((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        LongBooleanMap map = this.newWithKeysValues(3L, false, 4L, false);
        String[] sum = { "" };
        map.forEachValue((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachKey() {
        LongBooleanMap map0 = this.newWithKeysValues(0L, true, 3L, false);
        long[] sum0 = new long[1];
        map0.forEachKey((long each) -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        LongBooleanMap map1 = this.newWithKeysValues(1L, false, 3L, false);
        long[] sum1 = new long[1];
        map1.forEachKey((long each) -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        LongBooleanMap map01 = this.newWithKeysValues(0L, true, 1L, true);
        long[] sum01 = new long[1];
        map01.forEachKey((long each) -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        LongBooleanMap map = this.newWithKeysValues(3L, false, 4L, true);
        long[] sum = new long[1];
        map.forEachKey((long each) -> sum[0] += each);
        Assert.assertEquals(7, sum[0]);
    }

    @Test
    public void forEachKeyValue() {
        LongBooleanMap map0 = this.newWithKeysValues(0L, true, 3L, true);
        long[] sumKey0 = new long[1];
        String[] sumValue0 = { "" };
        map0.forEachKeyValue((long eachKey, boolean eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals("truetrue", sumValue0[0]);
        LongBooleanMap map1 = this.newWithKeysValues(1L, true, 3L, false);
        long[] sumKey1 = new long[1];
        String[] sumValue1 = { "" };
        map1.forEachKeyValue((long eachKey, boolean eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertTrue("truefalse".equals(sumValue1[0]) || "falsetrue".equals(sumValue1[0]));
        LongBooleanMap map01 = this.newWithKeysValues(0L, false, 1L, false);
        long[] sumKey01 = new long[1];
        String[] sumValue01 = { "" };
        map01.forEachKeyValue((long eachKey, boolean eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals("falsefalse", sumValue01[0]);
        LongBooleanMap map = this.newWithKeysValues(3L, false, 4L, true);
        long[] sumKey = new long[1];
        String[] sumValue = { "" };
        map.forEachKeyValue((long eachKey, boolean eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7, sumKey[0]);
        Assert.assertTrue("truefalse".equals(sumValue[0]) || "falsetrue".equals(sumValue[0]));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("true", this.newWithKeysValues(0L, true).makeString());
        Assert.assertEquals("false", this.newWithKeysValues(1L, false).makeString());
        Assert.assertEquals("false", this.newWithKeysValues(5L, false).makeString());
        LongBooleanMap map1 = this.newWithKeysValues(0L, true, 1L, false);
        Assert.assertTrue(map1.makeString(), "true, false".equals(map1.makeString()) || "false, true".equals(map1.makeString()));
        LongBooleanMap map2 = this.newWithKeysValues(1L, false, 32L, true);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[false/true]".equals(map2.makeString("[", "/", "]")) || "true/false]".equals(map2.makeString("[", "/", "]")));
        LongBooleanMap map3 = this.newWithKeysValues(0L, true, 32L, true);
        Assert.assertTrue(map3.makeString("~"), "true~true".equals(map3.makeString("~")) || "true~true".equals(map3.makeString("~")));
        LongBooleanMap map4 = this.newWithKeysValues(32L, true, 33L, false);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[true, false]".equals(map4.makeString("[", ", ", "]")) || "[false, true]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0L, true).appendString(appendable0);
        Assert.assertEquals("true", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1L, false).appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5L, false).appendString(appendable2);
        Assert.assertEquals("false", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        LongBooleanMap map1 = this.newWithKeysValues(0L, true, 1L, false);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "true, false".equals(appendable3.toString()) || "false, true".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        LongBooleanMap map2 = this.newWithKeysValues(1L, false, 32L, true);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[false/true]".equals(appendable4.toString()) || "[true/false]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        LongBooleanMap map3 = this.newWithKeysValues(1L, false, 32L, true);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[false/true]".equals(appendable5.toString()) || "[true/false]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "true/false".equals(appendable6.toString()) || "false/true".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, false, 3L, true);
        LongBooleanMap actual1 = map.select((long key, boolean value) -> key == 1L || value);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 3L, true, 0L, true), actual1);
        LongBooleanMap actual2 = map.select((long key, boolean value) -> key == 0L || !value);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 2L, false, 1L, false), actual2);
    }

    @Test
    public void reject() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, false, 3L, true);
        LongBooleanMap actual1 = map.reject((long key, boolean value) -> key == 2L || !value);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 3L, true), actual1);
        LongBooleanMap actual2 = map.reject((long key, boolean value) -> key == 3L || value);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, false), actual2);
    }

    @Test
    public void select_value() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, true, 3L, false);
        BooleanIterable actual1 = map.select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual1);
        BooleanIterable actual2 = map.select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual2);
    }

    @Test
    public void reject_value() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, true, 3L, false);
        BooleanIterable actual1 = map.reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual1);
        BooleanIterable actual2 = map.reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual2);
    }

    @Test
    public void collect() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, true);
        RichIterable<Boolean> objects = map.collect((boolean booleanParameter) -> !booleanParameter);
        Assert.assertEquals(HashBag.newBagWith(false, true, false), objects.toBag());
    }

    @Test
    public void count() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, true);
        Assert.assertEquals(2, map.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1, map.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone_value() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, false);
        LongBooleanMap map2 = this.newWithKeysValues(0L, true, 1L, true, 2L, false);
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
        Assert.assertTrue(this.newWithKeysValues(1L, false, 2L, true).anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues(1L, true, 2L, false).allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues(1L, false, 2L, true).noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void toList() {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues(0L, true).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.newWithKeysValues(1L, false).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues(2L, true).toList());
    }

    @Test
    public void toSet() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, true, 3L, false);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), map.toSet());
    }

    @Test
    public void toBag() {
        LongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 2L, true, 3L, false);
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
        LongBooleanMap map = this.newWithKeysValues(1L, true, 2L, true, 3L, false);
        LazyBooleanIterable lazy = map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(true, true, false));
    }

    @Test
    public void keysView() {
        MutableLongList keys = this.newWithKeysValues(1L, true, 2L, false).keysView().toSortedList();
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), keys);
    }

    @Test
    public void keyValuesView() {
        MutableBag<LongBooleanPair> expected = Bags.mutable.of();
        this.classUnderTest().forEachKeyValue((long key, boolean value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.classUnderTest().keyValuesView().toBag());
    }

    @Test
    public void toArray() {
        LongBooleanMap map = this.newWithKeysValues(1L, false, 2L, true);
        boolean[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new boolean[] { false, true }, array) || Arrays.equals(new boolean[] { true, false }, array));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableLongBooleanMap.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLongBooleanMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLongBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongBooleanMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractLongBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractLongBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractLongBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractLongBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractLongBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractLongBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractLongBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractLongBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractLongBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractLongBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLongBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractLongBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractLongBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractLongBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractLongBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractLongBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractLongBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractLongBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractLongBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractLongBooleanMapTestCase::appendString;
            this.payloads.select = AbstractLongBooleanMapTestCase::select;
            this.payloads.reject = AbstractLongBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractLongBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractLongBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractLongBooleanMapTestCase::collect;
            this.payloads.count = AbstractLongBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractLongBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractLongBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLongBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLongBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractLongBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractLongBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractLongBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractLongBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractLongBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractLongBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractLongBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractLongBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractLongBooleanMapTestCase::toImmutable;
        }
    }
}
