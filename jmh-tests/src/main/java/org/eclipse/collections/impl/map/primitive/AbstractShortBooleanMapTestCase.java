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
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.map.primitive.ShortBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortBooleanMap;
import org.eclipse.collections.api.tuple.primitive.ShortBooleanPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractShortBooleanMapTestCase {

    protected abstract ShortBooleanMap classUnderTest();

    protected abstract ShortBooleanMap newWithKeysValues(short key1, boolean value1);

    protected abstract ShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2);

    protected abstract ShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3);

    protected abstract ShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4);

    protected abstract ShortBooleanMap getEmptyMap();

    @Test
    public void get() {
        Assert.assertTrue(this.classUnderTest().get((short) 0));
        Assert.assertFalse(this.classUnderTest().get((short) 31));
        Assert.assertTrue(this.classUnderTest().get((short) 32));
        Assert.assertFalse(this.classUnderTest().get((short) 1));
        Assert.assertFalse(this.classUnderTest().get((short) 33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent((short) 0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent((short) 31, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((short) 32, false));
    }

    @Test
    public void getOrThrow() {
        Assert.assertTrue(this.classUnderTest().getOrThrow((short) 0));
        Assert.assertFalse(this.classUnderTest().getOrThrow((short) 31));
        Assert.assertTrue(this.classUnderTest().getOrThrow((short) 32));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((short) 1));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((short) 33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey((short) 0));
        Assert.assertTrue(this.classUnderTest().containsKey((short) 31));
        Assert.assertTrue(this.classUnderTest().containsKey((short) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((short) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((short) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((short) 35));
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
        Verify.assertSize(1, this.newWithKeysValues((short) 0, false));
        Verify.assertSize(1, this.newWithKeysValues((short) 1, true));
        Verify.assertSize(2, this.newWithKeysValues((short) 1, true, (short) 5, false));
        Verify.assertSize(2, this.newWithKeysValues((short) 0, false, (short) 5, false));
        Verify.assertSize(3, this.newWithKeysValues((short) 1, true, (short) 0, true, (short) 5, true));
        Verify.assertSize(2, this.newWithKeysValues((short) 6, false, (short) 5, true));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 1, true).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 0, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 50, true).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 1, false).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 0, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 50, false).notEmpty());
    }

    @Test
    public void testEquals() {
        ShortBooleanMap map1 = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 32, true);
        ShortBooleanMap map2 = this.newWithKeysValues((short) 32, true, (short) 0, true, (short) 1, false);
        ShortBooleanMap map3 = this.newWithKeysValues((short) 0, true, (short) 1, true, (short) 32, true);
        ShortBooleanMap map4 = this.newWithKeysValues((short) 0, false, (short) 1, false, (short) 32, true);
        ShortBooleanMap map5 = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 32, false);
        ShortBooleanMap map6 = this.newWithKeysValues((short) 50, true, (short) 60, false, (short) 70, false);
        ShortBooleanMap map7 = this.newWithKeysValues((short) 50, true, (short) 60, false);
        ShortBooleanMap map8 = this.newWithKeysValues((short) 0, true, (short) 1, false);
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
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 0, true, (short) 1, false, (short) 32, true).hashCode(), this.newWithKeysValues((short) 32, true, (short) 0, true, (short) 1, false).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 50, true, (short) 60, false, (short) 70, false).hashCode(), this.newWithKeysValues((short) 50, true, (short) 60, false, (short) 70, false).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=true}", this.newWithKeysValues((short) 0, true).toString());
        Assert.assertEquals("{1=false}", this.newWithKeysValues((short) 1, false).toString());
        Assert.assertEquals("{5=false}", this.newWithKeysValues((short) 5, false).toString());
        ShortBooleanMap map1 = this.newWithKeysValues((short) 0, true, (short) 1, false);
        Assert.assertTrue(map1.toString(), "{0=true, 1=false}".equals(map1.toString()) || "{1=false, 0=true}".equals(map1.toString()));
        ShortBooleanMap map2 = this.newWithKeysValues((short) 1, false, (short) 32, true);
        Assert.assertTrue(map2.toString(), "{1=false, 32=true}".equals(map2.toString()) || "{32=true, 1=false}".equals(map2.toString()));
        ShortBooleanMap map3 = this.newWithKeysValues((short) 0, true, (short) 32, true);
        Assert.assertTrue(map3.toString(), "{0=true, 32=true}".equals(map3.toString()) || "{32=true, 0=true}".equals(map3.toString()));
        ShortBooleanMap map4 = this.newWithKeysValues((short) 32, true, (short) 33, false);
        Assert.assertTrue(map4.toString(), "{32=true, 33=false}".equals(map4.toString()) || "{33=false, 32=true}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        ShortBooleanMap map0 = this.newWithKeysValues((short) 0, false, (short) 3, true);
        String[] sum0 = { "" };
        map0.forEach((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        ShortBooleanMap map1 = this.newWithKeysValues((short) 1, true, (short) 3, true);
        String[] sum1 = { "" };
        map1.forEach((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        ShortBooleanMap map01 = this.newWithKeysValues((short) 0, false, (short) 1, true);
        String[] sum01 = { "" };
        map01.forEach((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        ShortBooleanMap map = this.newWithKeysValues((short) 3, false, (short) 4, false);
        String[] sum = { "" };
        map.forEach((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachValue() {
        ShortBooleanMap map0 = this.newWithKeysValues((short) 0, false, (short) 3, true);
        String[] sum0 = { "" };
        map0.forEachValue((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        ShortBooleanMap map1 = this.newWithKeysValues((short) 1, true, (short) 3, true);
        String[] sum1 = { "" };
        map1.forEachValue((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        ShortBooleanMap map01 = this.newWithKeysValues((short) 0, false, (short) 1, true);
        String[] sum01 = { "" };
        map01.forEachValue((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        ShortBooleanMap map = this.newWithKeysValues((short) 3, false, (short) 4, false);
        String[] sum = { "" };
        map.forEachValue((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachKey() {
        ShortBooleanMap map0 = this.newWithKeysValues((short) 0, true, (short) 3, false);
        short[] sum0 = new short[1];
        map0.forEachKey((short each) -> sum0[0] += each);
        Assert.assertEquals((short) 3, sum0[0]);
        ShortBooleanMap map1 = this.newWithKeysValues((short) 1, false, (short) 3, false);
        short[] sum1 = new short[1];
        map1.forEachKey((short each) -> sum1[0] += each);
        Assert.assertEquals((short) 4, sum1[0]);
        ShortBooleanMap map01 = this.newWithKeysValues((short) 0, true, (short) 1, true);
        short[] sum01 = new short[1];
        map01.forEachKey((short each) -> sum01[0] += each);
        Assert.assertEquals((short) 1, sum01[0]);
        ShortBooleanMap map = this.newWithKeysValues((short) 3, false, (short) 4, true);
        short[] sum = new short[1];
        map.forEachKey((short each) -> sum[0] += each);
        Assert.assertEquals(7, sum[0]);
    }

    @Test
    public void forEachKeyValue() {
        ShortBooleanMap map0 = this.newWithKeysValues((short) 0, true, (short) 3, true);
        short[] sumKey0 = new short[1];
        String[] sumValue0 = { "" };
        map0.forEachKeyValue((short eachKey, boolean eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals((short) 3, sumKey0[0]);
        Assert.assertEquals("truetrue", sumValue0[0]);
        ShortBooleanMap map1 = this.newWithKeysValues((short) 1, true, (short) 3, false);
        short[] sumKey1 = new short[1];
        String[] sumValue1 = { "" };
        map1.forEachKeyValue((short eachKey, boolean eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals((short) 4, sumKey1[0]);
        Assert.assertTrue("truefalse".equals(sumValue1[0]) || "falsetrue".equals(sumValue1[0]));
        ShortBooleanMap map01 = this.newWithKeysValues((short) 0, false, (short) 1, false);
        short[] sumKey01 = new short[1];
        String[] sumValue01 = { "" };
        map01.forEachKeyValue((short eachKey, boolean eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals((short) 1, sumKey01[0]);
        Assert.assertEquals("falsefalse", sumValue01[0]);
        ShortBooleanMap map = this.newWithKeysValues((short) 3, false, (short) 4, true);
        short[] sumKey = new short[1];
        String[] sumValue = { "" };
        map.forEachKeyValue((short eachKey, boolean eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7, sumKey[0]);
        Assert.assertTrue("truefalse".equals(sumValue[0]) || "falsetrue".equals(sumValue[0]));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("true", this.newWithKeysValues((short) 0, true).makeString());
        Assert.assertEquals("false", this.newWithKeysValues((short) 1, false).makeString());
        Assert.assertEquals("false", this.newWithKeysValues((short) 5, false).makeString());
        ShortBooleanMap map1 = this.newWithKeysValues((short) 0, true, (short) 1, false);
        Assert.assertTrue(map1.makeString(), "true, false".equals(map1.makeString()) || "false, true".equals(map1.makeString()));
        ShortBooleanMap map2 = this.newWithKeysValues((short) 1, false, (short) 32, true);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[false/true]".equals(map2.makeString("[", "/", "]")) || "true/false]".equals(map2.makeString("[", "/", "]")));
        ShortBooleanMap map3 = this.newWithKeysValues((short) 0, true, (short) 32, true);
        Assert.assertTrue(map3.makeString("~"), "true~true".equals(map3.makeString("~")) || "true~true".equals(map3.makeString("~")));
        ShortBooleanMap map4 = this.newWithKeysValues((short) 32, true, (short) 33, false);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[true, false]".equals(map4.makeString("[", ", ", "]")) || "[false, true]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues((short) 0, true).appendString(appendable0);
        Assert.assertEquals("true", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((short) 1, false).appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((short) 5, false).appendString(appendable2);
        Assert.assertEquals("false", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ShortBooleanMap map1 = this.newWithKeysValues((short) 0, true, (short) 1, false);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "true, false".equals(appendable3.toString()) || "false, true".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        ShortBooleanMap map2 = this.newWithKeysValues((short) 1, false, (short) 32, true);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[false/true]".equals(appendable4.toString()) || "[true/false]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        ShortBooleanMap map3 = this.newWithKeysValues((short) 1, false, (short) 32, true);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[false/true]".equals(appendable5.toString()) || "[true/false]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "true/false".equals(appendable6.toString()) || "false/true".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, false, (short) 3, true);
        ShortBooleanMap actual1 = map.select((short key, boolean value) -> key == (short) 1 || value);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 3, true, (short) 0, true), actual1);
        ShortBooleanMap actual2 = map.select((short key, boolean value) -> key == (short) 0 || !value);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 2, false, (short) 1, false), actual2);
    }

    @Test
    public void reject() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, false, (short) 3, true);
        ShortBooleanMap actual1 = map.reject((short key, boolean value) -> key == (short) 2 || !value);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 3, true), actual1);
        ShortBooleanMap actual2 = map.reject((short key, boolean value) -> key == (short) 3 || value);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 2, false), actual2);
    }

    @Test
    public void select_value() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, true, (short) 3, false);
        BooleanIterable actual1 = map.select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual1);
        BooleanIterable actual2 = map.select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual2);
    }

    @Test
    public void reject_value() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, true, (short) 3, false);
        BooleanIterable actual1 = map.reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual1);
        BooleanIterable actual2 = map.reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual2);
    }

    @Test
    public void collect() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, true);
        RichIterable<Boolean> objects = map.collect((boolean booleanParameter) -> !booleanParameter);
        Assert.assertEquals(HashBag.newBagWith(false, true, false), objects.toBag());
    }

    @Test
    public void count() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, true);
        Assert.assertEquals(2, map.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1, map.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone_value() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, false);
        ShortBooleanMap map2 = this.newWithKeysValues((short) 0, true, (short) 1, true, (short) 2, false);
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
        Assert.assertTrue(this.newWithKeysValues((short) 1, false, (short) 2, true).anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues((short) 1, true, (short) 2, false).allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues((short) 1, false, (short) 2, true).noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void toList() {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues((short) 0, true).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.newWithKeysValues((short) 1, false).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues((short) 2, true).toList());
    }

    @Test
    public void toSet() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, true, (short) 3, false);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), map.toSet());
    }

    @Test
    public void toBag() {
        ShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 2, true, (short) 3, false);
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
        ShortBooleanMap map = this.newWithKeysValues((short) 1, true, (short) 2, true, (short) 3, false);
        LazyBooleanIterable lazy = map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(true, true, false));
    }

    @Test
    public void keysView() {
        MutableShortList keys = this.newWithKeysValues((short) 1, true, (short) 2, false).keysView().toSortedList();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), keys);
    }

    @Test
    public void keyValuesView() {
        MutableBag<ShortBooleanPair> expected = Bags.mutable.of();
        this.classUnderTest().forEachKeyValue((short key, boolean value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.classUnderTest().keyValuesView().toBag());
    }

    @Test
    public void toArray() {
        ShortBooleanMap map = this.newWithKeysValues((short) 1, false, (short) 2, true);
        boolean[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new boolean[] { false, true }, array) || Arrays.equals(new boolean[] { true, false }, array));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableShortBooleanMap.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractShortBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortBooleanMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractShortBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractShortBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractShortBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractShortBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractShortBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractShortBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractShortBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractShortBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractShortBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractShortBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractShortBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractShortBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractShortBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractShortBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractShortBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractShortBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractShortBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractShortBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractShortBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractShortBooleanMapTestCase::appendString;
            this.payloads.select = AbstractShortBooleanMapTestCase::select;
            this.payloads.reject = AbstractShortBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractShortBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractShortBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractShortBooleanMapTestCase::collect;
            this.payloads.count = AbstractShortBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractShortBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractShortBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractShortBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractShortBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractShortBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractShortBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractShortBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractShortBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractShortBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractShortBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractShortBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractShortBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractShortBooleanMapTestCase::toImmutable;
        }
    }
}
