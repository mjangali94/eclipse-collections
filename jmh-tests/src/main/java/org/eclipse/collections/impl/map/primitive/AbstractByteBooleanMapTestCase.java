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
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.map.primitive.ByteBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteBooleanMap;
import org.eclipse.collections.api.tuple.primitive.ByteBooleanPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteBooleanHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractByteBooleanMapTestCase {

    protected abstract ByteBooleanMap classUnderTest();

    protected abstract ByteBooleanMap newWithKeysValues(byte key1, boolean value1);

    protected abstract ByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2);

    protected abstract ByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3);

    protected abstract ByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3, byte key4, boolean value4);

    protected abstract ByteBooleanMap getEmptyMap();

    @Test
    public void get() {
        Assert.assertTrue(this.classUnderTest().get((byte) 0));
        Assert.assertFalse(this.classUnderTest().get((byte) 31));
        Assert.assertTrue(this.classUnderTest().get((byte) 32));
        Assert.assertFalse(this.classUnderTest().get((byte) 1));
        Assert.assertFalse(this.classUnderTest().get((byte) 33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent((byte) 0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent((byte) 31, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((byte) 32, false));
    }

    @Test
    public void getOrThrow() {
        Assert.assertTrue(this.classUnderTest().getOrThrow((byte) 0));
        Assert.assertFalse(this.classUnderTest().getOrThrow((byte) 31));
        Assert.assertTrue(this.classUnderTest().getOrThrow((byte) 32));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((byte) 1));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((byte) 33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey((byte) 0));
        Assert.assertTrue(this.classUnderTest().containsKey((byte) 31));
        Assert.assertTrue(this.classUnderTest().containsKey((byte) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 35));
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
        Verify.assertSize(1, this.newWithKeysValues((byte) 0, false));
        Verify.assertSize(1, this.newWithKeysValues((byte) 1, true));
        Verify.assertSize(2, this.newWithKeysValues((byte) 1, true, (byte) 5, false));
        Verify.assertSize(2, this.newWithKeysValues((byte) 0, false, (byte) 5, false));
        Verify.assertSize(3, this.newWithKeysValues((byte) 1, true, (byte) 0, true, (byte) 5, true));
        Verify.assertSize(2, this.newWithKeysValues((byte) 6, false, (byte) 5, true));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 1, true).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 0, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 50, true).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 1, false).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 0, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 50, false).notEmpty());
    }

    @Test
    public void testEquals() {
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 32, true);
        ByteBooleanMap map2 = this.newWithKeysValues((byte) 32, true, (byte) 0, true, (byte) 1, false);
        ByteBooleanMap map3 = this.newWithKeysValues((byte) 0, true, (byte) 1, true, (byte) 32, true);
        ByteBooleanMap map4 = this.newWithKeysValues((byte) 0, false, (byte) 1, false, (byte) 32, true);
        ByteBooleanMap map5 = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 32, false);
        ByteBooleanMap map6 = this.newWithKeysValues((byte) 50, true, (byte) 60, false, (byte) 70, false);
        ByteBooleanMap map7 = this.newWithKeysValues((byte) 50, true, (byte) 60, false);
        ByteBooleanMap map8 = this.newWithKeysValues((byte) 0, true, (byte) 1, false);
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
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 32, true).hashCode(), this.newWithKeysValues((byte) 32, true, (byte) 0, true, (byte) 1, false).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 50, true, (byte) 60, false, (byte) 70, false).hashCode(), this.newWithKeysValues((byte) 50, true, (byte) 60, false, (byte) 70, false).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=true}", this.newWithKeysValues((byte) 0, true).toString());
        Assert.assertEquals("{1=false}", this.newWithKeysValues((byte) 1, false).toString());
        Assert.assertEquals("{5=false}", this.newWithKeysValues((byte) 5, false).toString());
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 0, true, (byte) 1, false);
        Assert.assertTrue(map1.toString(), "{0=true, 1=false}".equals(map1.toString()) || "{1=false, 0=true}".equals(map1.toString()));
        ByteBooleanMap map2 = this.newWithKeysValues((byte) 1, false, (byte) 32, true);
        Assert.assertTrue(map2.toString(), "{1=false, 32=true}".equals(map2.toString()) || "{32=true, 1=false}".equals(map2.toString()));
        ByteBooleanMap map3 = this.newWithKeysValues((byte) 0, true, (byte) 32, true);
        Assert.assertTrue(map3.toString(), "{0=true, 32=true}".equals(map3.toString()) || "{32=true, 0=true}".equals(map3.toString()));
        ByteBooleanMap map4 = this.newWithKeysValues((byte) 32, true, (byte) 33, false);
        Assert.assertTrue(map4.toString(), "{32=true, 33=false}".equals(map4.toString()) || "{33=false, 32=true}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        ByteBooleanMap map0 = this.newWithKeysValues((byte) 0, false, (byte) 3, true);
        String[] sum0 = { "" };
        map0.forEach((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 1, true, (byte) 3, true);
        String[] sum1 = { "" };
        map1.forEach((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        ByteBooleanMap map01 = this.newWithKeysValues((byte) 0, false, (byte) 1, true);
        String[] sum01 = { "" };
        map01.forEach((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        ByteBooleanMap map = this.newWithKeysValues((byte) 3, false, (byte) 4, false);
        String[] sum = { "" };
        map.forEach((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachValue() {
        ByteBooleanMap map0 = this.newWithKeysValues((byte) 0, false, (byte) 3, true);
        String[] sum0 = { "" };
        map0.forEachValue((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 1, true, (byte) 3, true);
        String[] sum1 = { "" };
        map1.forEachValue((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        ByteBooleanMap map01 = this.newWithKeysValues((byte) 0, false, (byte) 1, true);
        String[] sum01 = { "" };
        map01.forEachValue((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        ByteBooleanMap map = this.newWithKeysValues((byte) 3, false, (byte) 4, false);
        String[] sum = { "" };
        map.forEachValue((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachKey() {
        ByteBooleanMap map0 = this.newWithKeysValues((byte) 0, true, (byte) 3, false);
        byte[] sum0 = new byte[1];
        map0.forEachKey((byte each) -> sum0[0] += each);
        Assert.assertEquals((byte) 3, sum0[0]);
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 1, false, (byte) 3, false);
        byte[] sum1 = new byte[1];
        map1.forEachKey((byte each) -> sum1[0] += each);
        Assert.assertEquals((byte) 4, sum1[0]);
        ByteBooleanMap map01 = this.newWithKeysValues((byte) 0, true, (byte) 1, true);
        byte[] sum01 = new byte[1];
        map01.forEachKey((byte each) -> sum01[0] += each);
        Assert.assertEquals((byte) 1, sum01[0]);
        ByteBooleanMap map = this.newWithKeysValues((byte) 3, false, (byte) 4, true);
        byte[] sum = new byte[1];
        map.forEachKey((byte each) -> sum[0] += each);
        Assert.assertEquals(7, sum[0]);
    }

    @Test
    public void forEachKeyValue() {
        ByteBooleanMap map0 = this.newWithKeysValues((byte) 0, true, (byte) 3, true);
        byte[] sumKey0 = new byte[1];
        String[] sumValue0 = { "" };
        map0.forEachKeyValue((byte eachKey, boolean eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals((byte) 3, sumKey0[0]);
        Assert.assertEquals("truetrue", sumValue0[0]);
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 1, true, (byte) 3, false);
        byte[] sumKey1 = new byte[1];
        String[] sumValue1 = { "" };
        map1.forEachKeyValue((byte eachKey, boolean eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals((byte) 4, sumKey1[0]);
        Assert.assertTrue("truefalse".equals(sumValue1[0]) || "falsetrue".equals(sumValue1[0]));
        ByteBooleanMap map01 = this.newWithKeysValues((byte) 0, false, (byte) 1, false);
        byte[] sumKey01 = new byte[1];
        String[] sumValue01 = { "" };
        map01.forEachKeyValue((byte eachKey, boolean eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals((byte) 1, sumKey01[0]);
        Assert.assertEquals("falsefalse", sumValue01[0]);
        ByteBooleanMap map = this.newWithKeysValues((byte) 3, false, (byte) 4, true);
        byte[] sumKey = new byte[1];
        String[] sumValue = { "" };
        map.forEachKeyValue((byte eachKey, boolean eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7, sumKey[0]);
        Assert.assertTrue("truefalse".equals(sumValue[0]) || "falsetrue".equals(sumValue[0]));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("true", this.newWithKeysValues((byte) 0, true).makeString());
        Assert.assertEquals("false", this.newWithKeysValues((byte) 1, false).makeString());
        Assert.assertEquals("false", this.newWithKeysValues((byte) 5, false).makeString());
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 0, true, (byte) 1, false);
        Assert.assertTrue(map1.makeString(), "true, false".equals(map1.makeString()) || "false, true".equals(map1.makeString()));
        ByteBooleanMap map2 = this.newWithKeysValues((byte) 1, false, (byte) 32, true);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[false/true]".equals(map2.makeString("[", "/", "]")) || "true/false]".equals(map2.makeString("[", "/", "]")));
        ByteBooleanMap map3 = this.newWithKeysValues((byte) 0, true, (byte) 32, true);
        Assert.assertTrue(map3.makeString("~"), "true~true".equals(map3.makeString("~")) || "true~true".equals(map3.makeString("~")));
        ByteBooleanMap map4 = this.newWithKeysValues((byte) 32, true, (byte) 33, false);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[true, false]".equals(map4.makeString("[", ", ", "]")) || "[false, true]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues((byte) 0, true).appendString(appendable0);
        Assert.assertEquals("true", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((byte) 1, false).appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((byte) 5, false).appendString(appendable2);
        Assert.assertEquals("false", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 0, true, (byte) 1, false);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "true, false".equals(appendable3.toString()) || "false, true".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        ByteBooleanMap map2 = this.newWithKeysValues((byte) 1, false, (byte) 32, true);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[false/true]".equals(appendable4.toString()) || "[true/false]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        ByteBooleanMap map3 = this.newWithKeysValues((byte) 1, false, (byte) 32, true);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[false/true]".equals(appendable5.toString()) || "[true/false]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "true/false".equals(appendable6.toString()) || "false/true".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, false, (byte) 3, true);
        ByteBooleanMap actual1 = map.select((byte key, boolean value) -> key == (byte) 1 || value);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 3, true, (byte) 0, true), actual1);
        ByteBooleanMap actual2 = map.select((byte key, boolean value) -> key == (byte) 0 || !value);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 2, false, (byte) 1, false), actual2);
    }

    @Test
    public void reject() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, false, (byte) 3, true);
        ByteBooleanMap actual1 = map.reject((byte key, boolean value) -> key == (byte) 2 || !value);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 3, true), actual1);
        ByteBooleanMap actual2 = map.reject((byte key, boolean value) -> key == (byte) 3 || value);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 2, false), actual2);
    }

    @Test
    public void select_value() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, true, (byte) 3, false);
        BooleanIterable actual1 = map.select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual1);
        BooleanIterable actual2 = map.select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual2);
    }

    @Test
    public void reject_value() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, true, (byte) 3, false);
        BooleanIterable actual1 = map.reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual1);
        BooleanIterable actual2 = map.reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual2);
    }

    @Test
    public void collect() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, true);
        RichIterable<Boolean> objects = map.collect((boolean booleanParameter) -> !booleanParameter);
        Assert.assertEquals(HashBag.newBagWith(false, true, false), objects.toBag());
    }

    @Test
    public void count() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, true);
        Assert.assertEquals(2, map.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1, map.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone_value() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, false);
        ByteBooleanMap map2 = this.newWithKeysValues((byte) 0, true, (byte) 1, true, (byte) 2, false);
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
        Assert.assertTrue(this.newWithKeysValues((byte) 1, false, (byte) 2, true).anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, true, (byte) 2, false).allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, false, (byte) 2, true).noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void toList() {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues((byte) 0, true).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.newWithKeysValues((byte) 1, false).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues((byte) 2, true).toList());
    }

    @Test
    public void toSet() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, true, (byte) 3, false);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), map.toSet());
    }

    @Test
    public void toBag() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 0, true, (byte) 1, false, (byte) 2, true, (byte) 3, false);
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
        ByteBooleanMap map = this.newWithKeysValues((byte) 1, true, (byte) 2, true, (byte) 3, false);
        LazyBooleanIterable lazy = map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(true, true, false));
    }

    @Test
    public void keysView() {
        MutableByteList keys = this.newWithKeysValues((byte) 1, true, (byte) 2, false).keysView().toSortedList();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), keys);
    }

    @Test
    public void keyValuesView() {
        MutableBag<ByteBooleanPair> expected = Bags.mutable.of();
        this.classUnderTest().forEachKeyValue((byte key, boolean value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.classUnderTest().keyValuesView().toBag());
    }

    @Test
    public void toArray() {
        ByteBooleanMap map = this.newWithKeysValues((byte) 1, false, (byte) 2, true);
        boolean[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new boolean[] { false, true }, array) || Arrays.equals(new boolean[] { true, false }, array));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableByteBooleanMap.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteBooleanMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractByteBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractByteBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractByteBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractByteBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractByteBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractByteBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractByteBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractByteBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractByteBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractByteBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractByteBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractByteBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractByteBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractByteBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractByteBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractByteBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractByteBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractByteBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractByteBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractByteBooleanMapTestCase::appendString;
            this.payloads.select = AbstractByteBooleanMapTestCase::select;
            this.payloads.reject = AbstractByteBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractByteBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractByteBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractByteBooleanMapTestCase::collect;
            this.payloads.count = AbstractByteBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractByteBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractByteBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractByteBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractByteBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractByteBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractByteBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractByteBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractByteBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractByteBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractByteBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractByteBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractByteBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractByteBooleanMapTestCase::toImmutable;
        }
    }
}
