/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.factory.primitive.IntFloatMaps;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.map.primitive.IntFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntFloatMap;
import org.eclipse.collections.api.map.primitive.MutableIntFloatMap;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.IntFloatPair;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntFloatHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractIntFloatMapTestCase {

    protected final IntFloatMap map = this.classUnderTest();

    protected abstract IntFloatMap classUnderTest();

    protected abstract IntFloatMap newWithKeysValues(int key1, float value1);

    protected abstract IntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2);

    protected abstract IntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3);

    protected abstract IntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3, int key4, float value4);

    protected abstract IntFloatMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(IntHashSet.newSetWith(0), this.newWithKeysValues(0, 0.0f).keySet());
        Assert.assertEquals(IntHashSet.newSetWith(0, 31, 32), this.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        IntFloatMap map = this.newWithKeysValues(0, 0.0f);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0f));
        IntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0f));
        Assert.assertTrue(map1.values().contains(31.0f));
        Assert.assertTrue(map1.values().contains(32.0f));
    }

    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get(0), 0.0);
        Assert.assertEquals(31.0, this.map.get(31), 0.0);
        Assert.assertEquals(32.0, this.map.get(32), 0.0);
        Assert.assertEquals(0.0, this.map.get(1), 0.0);
        Assert.assertEquals(0.0, this.map.get(33), 0.0);
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0, 5.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent(31, 5.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent(32, 5.0f), 0.0);
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow(0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow(31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow(32), 0.0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0));
        Assert.assertTrue(this.map.containsKey(31));
        Assert.assertTrue(this.map.containsKey(32));
        Assert.assertFalse(this.map.containsKey(1));
        Assert.assertFalse(this.map.containsKey(5));
        Assert.assertFalse(this.map.containsKey(35));
    }

    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(31.0f));
        Assert.assertTrue(this.map.containsValue(32.0f));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertTrue(this.map.contains(31.0f));
        Assert.assertTrue(this.map.contains(32.0f));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0.0f, 31.0f, 32.0f));
        Assert.assertFalse(this.map.containsAll(0.0f, 31.0f, 35.0f));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f)));
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 35.0f)));
        Assert.assertTrue(this.map.containsAll(new FloatArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0, 0.0f).size());
        Assert.assertEquals(1, this.newWithKeysValues(1, 1.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(1, 1.0f, 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(0, 0.0f, 5, 5.0f).size());
        Assert.assertEquals(3, this.newWithKeysValues(1, 1.0f, 0, 0.0f, 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(6, 6.0f, 5, 5.0f).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, 1.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, 0.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, 50.0f).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, 1.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, 0.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, 50.0f).notEmpty());
    }

    @Test
    public void testEquals() {
        IntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 32, 32.0f);
        IntFloatMap map2 = this.newWithKeysValues(32, 32.0f, 0, 0.0f, 1, 1.0f);
        IntFloatMap map3 = this.newWithKeysValues(0, 0.0f, 1, 2.0f, 32, 32.0f);
        IntFloatMap map4 = this.newWithKeysValues(0, 1.0f, 1, 1.0f, 32, 32.0f);
        IntFloatMap map5 = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 32, 33.0f);
        IntFloatMap map6 = this.newWithKeysValues(50, 0.0f, 60, 1.0f, 70, 33.0f);
        IntFloatMap map7 = this.newWithKeysValues(50, 0.0f, 60, 1.0f);
        IntFloatMap map8 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        IntFloatMap map9 = this.newWithKeysValues(0, 0.0f);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(FloatArrayList.newListWith(0.0f), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, IntFloatMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, IntFloatMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0.0f, 1, 1.0f, 32, 32.0f).hashCode(), this.newWithKeysValues(32, 32.0f, 0, 0.0f, 1, 1.0f).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, 0.0f, 60, 1.0f, 70, 33.0f).hashCode(), this.newWithKeysValues(50, 0.0f, 60, 1.0f, 70, 33.0f).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 2.0f).hashCode(), this.newWithKeysValues(1, 2.0f).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0.0}", this.newWithKeysValues(0, 0.0f).toString());
        Assert.assertEquals("{1=1.0}", this.newWithKeysValues(1, 1.0f).toString());
        Assert.assertEquals("{5=5.0}", this.newWithKeysValues(5, 5.0f).toString());
        IntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        Assert.assertTrue(map1.toString(), "{0=0.0, 1=1.0}".equals(map1.toString()) || "{1=1.0, 0=0.0}".equals(map1.toString()));
        IntFloatMap map2 = this.newWithKeysValues(1, 1.0f, 32, 32.0f);
        Assert.assertTrue(map2.toString(), "{1=1.0, 32=32.0}".equals(map2.toString()) || "{32=32.0, 1=1.0}".equals(map2.toString()));
        IntFloatMap map3 = this.newWithKeysValues(0, 0.0f, 32, 32.0f);
        Assert.assertTrue(map3.toString(), "{0=0.0, 32=32.0}".equals(map3.toString()) || "{32=32.0, 0=0.0}".equals(map3.toString()));
        IntFloatMap map4 = this.newWithKeysValues(32, 32.0f, 33, 33.0f);
        Assert.assertTrue(map4.toString(), "{32=32.0, 33=33.0}".equals(map4.toString()) || "{33=33.0, 32=32.0}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        IntFloatMap map0 = this.newWithKeysValues(0, 1.0f, 3, 4.0f);
        float[] sum0 = new float[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        IntFloatMap map1 = this.newWithKeysValues(1, 2.0f, 3, 4.0f);
        float[] sum1 = new float[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        IntFloatMap map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        IntFloatMap map = this.newWithKeysValues(3, 4.0f, 4, 5.0f);
        float[] sum = new float[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        IntFloatMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        IntFloatMap map3 = this.newWithKeysValues(1, 2.0f);
        float[] sum3 = new float[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachValue() {
        IntFloatMap map0 = this.newWithKeysValues(0, 1.0f, 3, 4.0f);
        float[] sum0 = new float[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        IntFloatMap map1 = this.newWithKeysValues(1, 2.0f, 3, 4.0f);
        float[] sum1 = new float[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        IntFloatMap map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        IntFloatMap map = this.newWithKeysValues(3, 4.0f, 4, 5.0f);
        float[] sum = new float[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        IntFloatMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        IntFloatMap map3 = this.newWithKeysValues(1, 2.0f);
        float[] sum3 = new float[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKey() {
        IntFloatMap map0 = this.newWithKeysValues(0, 1.0f, 3, 4.0f);
        int[] sum0 = new int[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        IntFloatMap map1 = this.newWithKeysValues(1, 2.0f, 3, 4.0f);
        int[] sum1 = new int[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        IntFloatMap map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        int[] sum01 = new int[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        IntFloatMap map = this.newWithKeysValues(3, 4.0f, 4, 5.0f);
        int[] sum = new int[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        IntFloatMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        IntFloatMap map3 = this.newWithKeysValues(1, 1.0f);
        int[] sum3 = new int[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        IntFloatMap map0 = this.newWithKeysValues(0, 1.0f, 3, 4.0f);
        int[] sumKey0 = new int[1];
        float[] sumValue0 = new float[1];
        map0.forEachKeyValue((int eachKey, float eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5.0, sumValue0[0], 0.0);
        IntFloatMap map1 = this.newWithKeysValues(1, 2.0f, 3, 4.0f);
        int[] sumKey1 = new int[1];
        float[] sumValue1 = new float[1];
        map1.forEachKeyValue((int eachKey, float eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6.0, sumValue1[0], 0.0);
        IntFloatMap map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        int[] sumKey01 = new int[1];
        float[] sumValue01 = new float[1];
        map01.forEachKeyValue((int eachKey, float eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3.0, sumValue01[0], 0.0);
        IntFloatMap map = this.newWithKeysValues(3, 4.0f, 4, 5.0f);
        int[] sumKey = new int[1];
        float[] sumValue = new float[1];
        map.forEachKeyValue((int eachKey, float eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9.0, sumValue[0], 0.0);
        IntFloatMap map2 = this.getEmptyMap();
        int[] sumKey2 = new int[1];
        float[] sumValue2 = new float[1];
        map2.forEachKeyValue((int eachKey, float eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0.0, sumValue2[0], 0.0);
        IntFloatMap map3 = this.newWithKeysValues(3, 5.0f);
        int[] sumKey3 = new int[1];
        float[] sumValue3 = new float[1];
        map3.forEachKeyValue((int eachKey, float eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5.0, sumValue3[0], 0.0);
    }

    @Test
    public void injectIntoKeyValue() {
        IntFloatMap map0 = this.newWithKeysValues(0, 1.0f, 3, 4.0f);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, int eachKey, float eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        IntFloatMap copy = map0.injectIntoKeyValue(IntFloatMaps.mutable.empty(), MutableIntFloatMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0.0", this.newWithKeysValues(0, 0.0f).makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues(0, 0.0f).makeString(", "));
        Assert.assertEquals("[0.0]", this.newWithKeysValues(0, 0.0f).makeString("[", "/", "]"));
        Assert.assertEquals("1.0", this.newWithKeysValues(1, 1.0f).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues(5, 5.0f).makeString());
        IntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        Assert.assertTrue(map1.makeString(), "0.0, 1.0".equals(map1.makeString()) || "1.0, 0.0".equals(map1.makeString()));
        IntFloatMap map2 = this.newWithKeysValues(1, 1.0f, 32, 32.0f);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1.0/32.0]".equals(map2.makeString("[", "/", "]")) || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));
        IntFloatMap map3 = this.newWithKeysValues(0, 0.0f, 32, 32.0f);
        Assert.assertTrue(map3.makeString("~"), "0.0~32.0".equals(map3.makeString("~")) || "32.0~0.0".equals(map3.makeString("~")));
        IntFloatMap map4 = this.newWithKeysValues(32, 32.0f, 33, 33.0f);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[32.0, 33.0]".equals(map4.makeString("[", ", ", "]")) || "[33.0, 32.0]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.getEmptyMap().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.getEmptyMap().appendString(appendable, "{", "/", "}");
        Assert.assertEquals("{}", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, 0.0f).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0, 0.0f).appendString(appendable01, "/");
        Assert.assertEquals("0.0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0, 0.0f).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0.0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, 1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5, 5.0f).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        IntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0.0, 1.0".equals(appendable3.toString()) || "1.0, 0.0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        IntFloatMap map2 = this.newWithKeysValues(1, 1.0f, 32, 32.0f);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1.0/32.0]".equals(appendable4.toString()) || "[32.0/1.0]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        IntFloatMap map3 = this.newWithKeysValues(1, 1.0f, 32, 32.0f);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1.0/32.0]".equals(appendable5.toString()) || "[32.0/1.0]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0.0/1.0".equals(appendable6.toString()) || "1.0/0.0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        IntFloatMap actual1 = map.select((int key, float value) -> key == 1 || Float.compare(value, 3.0f) == 0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f, 3, 3.0f), actual1);
        IntFloatMap actual2 = map.select((int key, float value) -> key == 0 || Float.compare(value, 2.0f) == 0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 2, 2.0f), actual2);
    }

    @Test
    public void reject() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        IntFloatMap actual1 = map.reject((int key, float value) -> key == 1 || Float.compare(value, 3.0f) == 0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 2, 2.0f), actual1);
        IntFloatMap actual2 = map.reject((int key, float value) -> key == 0 || Float.compare(value, 2.0f) == 0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f, 3, 3.0f), actual2);
    }

    @Test
    public void select_value() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        FloatIterable actual1 = map.select(FloatPredicates.greaterThan(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(2.0f, 3.0f), actual1);
        FloatIterable actual2 = map.select(FloatPredicates.lessThan(2.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f, 1.0f), actual2);
    }

    @Test
    public void reject_value() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        FloatIterable actual1 = map.reject(FloatPredicates.lessThan(2.0f));
        Assert.assertEquals(FloatBags.immutable.with(2.0f, 3.0f), actual1);
        FloatIterable actual2 = map.reject(FloatPredicates.greaterThan(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f, 1.0f), actual2);
    }

    @Test
    public void collect() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        FloatToObjectFunction<Float> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1.0f, 2.0f, 3.0f, 4.0f), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2.0f), this.newWithKeysValues(1, 1.0f).collect(function));
    }

    @Test
    public void count() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(2, map.count(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(2, map.count(FloatPredicates.lessThan(2.0f)));
    }

    @Test
    public void detectIfNone_value() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        float resultNotFound = map.detectIfNone(FloatPredicates.greaterThan(5.0f), 5.0f);
        Assert.assertEquals(5.0f, resultNotFound, 0.0);
        Assert.assertEquals(5.0f, this.getEmptyMap().detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(5.0f, this.newWithKeysValues(1, 1.0f).detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(1.0f, this.newWithKeysValues(1, 1.0f).detectIfNone(FloatPredicates.equal(1.0f), 5.0f), 0.0);
        Assert.assertEquals(0.0f, map.detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(1.0f, map.detectIfNone(FloatPredicates.equal(1.0f), 5.0f), 0.0);
        Assert.assertEquals(2.0f, map.detectIfNone(FloatPredicates.equal(2.0f), 5.0f), 0.0);
    }

    @Test
    public void anySatisfy() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues(1, 1.0f).anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues(1, 1.0f).anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertFalse(map.anySatisfy(FloatPredicates.greaterThan(5.0f)));
    }

    @Test
    public void allSatisfy() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues(1, 1.0f).allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues(1, 1.0f).allSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertTrue(map.allSatisfy(FloatPredicates.lessThan(5.0f)));
        IntFloatMap map1 = this.newWithKeysValues(2, 2.0f, 3, 3.0f);
        Assert.assertFalse(map1.allSatisfy(FloatPredicates.equal(0.0f)));
    }

    @Test
    public void noneSatisfy() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues(1, 1.0f).noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues(1, 1.0f).noneSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertTrue(map.noneSatisfy(FloatPredicates.lessThan(0.0f)));
    }

    @Test
    public void max() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(3.0f, map.max(), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues(3, 3.0f).max(), 0.0);
    }

    @Test
    public void min() {
        IntFloatMap map = this.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f, 0, 0.0f);
        Assert.assertEquals(0.0f, map.min(), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues(3, 3.0f).min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws() {
        this.getEmptyMap().max();
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws() {
        this.getEmptyMap().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, this.getEmptyMap().minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().minIfEmpty(0.0f), 0.0);
        IntFloatMap map = this.newWithKeysValues(1, 1.0f, 0, 0.0f, 9, 9.0f, 7, 7.0f);
        Assert.assertEquals(0.0, map.minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues(3, 3.0f).maxIfEmpty(5.0f), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, this.getEmptyMap().maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().maxIfEmpty(0.0f), 0.0);
        IntFloatMap map = this.newWithKeysValues(1, 1.0f, 0, 0.0f, 9, 9.0f, 7, 7.0f);
        Assert.assertEquals(9.0, map.maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues(3, 3.0f).minIfEmpty(5.0f), 0.0);
    }

    @Test
    public void sum() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(6.0f, map.sum(), 0.0);
        IntFloatMap map2 = this.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);
        Assert.assertEquals(9.0f, map2.sum(), 0.0);
        IntFloatMap map3 = this.newWithKeysValues(2, 2.0f);
        Assert.assertEquals(2.0f, map3.sum(), 0.0);
    }

    @Test
    public void average() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(1.5, map.average(), 0.0);
        IntFloatMap map1 = this.newWithKeysValues(1, 1.0f);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(1.5, map.median(), 0.0);
        IntFloatMap map2 = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        IntFloatMap map3 = this.newWithKeysValues(1, 1.0f);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.newWithKeysValues(0, 0.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWithKeysValues(1, 1.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(2.0f), this.newWithKeysValues(2, 2.0f).toList());
        Assert.assertTrue(this.newWithKeysValues(2, 2.0f, 3, 3.0f).toList().equals(FloatArrayList.newListWith(2.0f, 3.0f)) || this.newWithKeysValues(2, 2.0f, 3, 3.0f).toList().equals(FloatArrayList.newListWith(3.0f, 2.0f)));
    }

    @Test
    public void toSortedList() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f), map.toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWithKeysValues(1, 1.0f).toSortedList());
    }

    @Test
    public void toSet() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 3.0f), map.toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), this.newWithKeysValues(1, 1.0f).toSet());
    }

    @Test
    public void toBag() {
        IntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f, 3.0f), map.toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.newWithKeysValues(1, 1.0f).toBag());
    }

    @Test
    public void floatIterator() {
        MutableFloatSet expected = FloatHashSet.newSetWith(0.0f, 31.0f, 32.0f);
        MutableFloatSet actual = FloatHashSet.newSetWith();
        FloatIterator iterator = this.map.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().floatIterator().next());
    }

    @Test
    public void asLazy() {
        LazyFloatIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0.0f, 31.0f, 32.0f));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(IntArrayList.newListWith(0, 31, 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<IntFloatPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((int key, float value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new float[] { 0.0f, 31.0f, 32.0f }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        IntFloatMap map = this.newWithKeysValues(1, 1.0f, 2, 2.0f);
        float[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new float[] { 1.0f, 2.0f }, array) || Arrays.equals(new float[] { 2.0f, 1.0f }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new float[] { 1.0f }, this.newWithKeysValues(1, 1.0f).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableIntFloatMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        FloatIterable iterable = this.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f);
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f), FloatBags.mutable.with(2.0f), FloatBags.mutable.with(3.0f)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f), FloatBags.mutable.with(3.0f)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(FloatBags.mutable.with(2.0f, 3.0f), FloatBags.mutable.with(1.0f)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(FloatBags.mutable.with(1.0f, 3.0f), FloatBags.mutable.with(2.0f)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f)).toSet(), this.newWithKeysValues(1, 1.0f).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1, 1.0f).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySet, this.description("keySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::values, this.description("values"));
        }

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
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll_Iterable, this.description("containsAll_Iterable"));
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
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoKeyValue, this.description("injectIntoKeyValue"));
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
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_empty_throws, this.description("max_empty_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_empty_throws, this.description("min_empty_throws"), java.util.NoSuchElementException.class);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk, this.description("chunk"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractIntFloatMapTestCase implementation();
    }
}
