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
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.factory.primitive.FloatIntMaps;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.FloatIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatIntMap;
import org.eclipse.collections.api.map.primitive.MutableFloatIntMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatIntHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractFloatIntMapTestCase {

    protected final FloatIntMap map = this.classUnderTest();

    protected abstract FloatIntMap classUnderTest();

    protected abstract FloatIntMap newWithKeysValues(float key1, int value1);

    protected abstract FloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2);

    protected abstract FloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3);

    protected abstract FloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4);

    protected abstract FloatIntMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f), this.newWithKeysValues(0.0f, 0).keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 31.0f, 32.0f), this.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        FloatIntMap map = this.newWithKeysValues(0.0f, 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0));
        FloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0));
        Assert.assertTrue(map1.values().contains(31));
        Assert.assertTrue(map1.values().contains(32));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0.0f));
        Assert.assertEquals(31L, this.map.get(31.0f));
        Assert.assertEquals(32L, this.map.get(32.0f));
        Assert.assertEquals(0L, this.map.get(1.0f));
        Assert.assertEquals(0L, this.map.get(33.0f));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0f, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0f, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0f, 5));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0f));
        Assert.assertEquals(31L, this.map.getOrThrow(31.0f));
        Assert.assertEquals(32L, this.map.getOrThrow(32.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0f));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0.0f));
        Assert.assertTrue(this.map.containsKey(31.0f));
        Assert.assertTrue(this.map.containsKey(32.0f));
        Assert.assertFalse(this.map.containsKey(1.0f));
        Assert.assertFalse(this.map.containsKey(5.0f));
        Assert.assertFalse(this.map.containsKey(35.0f));
    }

    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertTrue(this.map.containsValue(31));
        Assert.assertTrue(this.map.containsValue(32));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0));
        Assert.assertTrue(this.map.contains(31));
        Assert.assertTrue(this.map.contains(32));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0, 31, 32));
        Assert.assertFalse(this.map.containsAll(0, 31, 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(IntArrayList.newListWith(0, 31, 32)));
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 35)));
        Assert.assertTrue(this.map.containsAll(new IntArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0f, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0f, 1, 5.0f, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, 0, 5.0f, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, 1, 0.0f, 0, 5.0f, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, 6, 5.0f, 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0f, 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0f, 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0f, 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0f, 50).notEmpty());
    }

    @Test
    public void testEquals() {
        FloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 32.0f, 32);
        FloatIntMap map2 = this.newWithKeysValues(32.0f, 32, 0.0f, 0, 1.0f, 1);
        FloatIntMap map3 = this.newWithKeysValues(0.0f, 0, 1.0f, 2, 32.0f, 32);
        FloatIntMap map4 = this.newWithKeysValues(0.0f, 1, 1.0f, 1, 32.0f, 32);
        FloatIntMap map5 = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 32.0f, 33);
        FloatIntMap map6 = this.newWithKeysValues(50.0f, 0, 60.0f, 1, 70.0f, 33);
        FloatIntMap map7 = this.newWithKeysValues(50.0f, 0, 60.0f, 1);
        FloatIntMap map8 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        FloatIntMap map9 = this.newWithKeysValues(0.0f, 0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(IntArrayList.newListWith(0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, FloatIntMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, FloatIntMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0.0f, 0, 1.0f, 1, 32.0f, 32).hashCode(), this.newWithKeysValues(32.0f, 32, 0.0f, 0, 1.0f, 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50.0f, 0, 60.0f, 1, 70.0f, 33).hashCode(), this.newWithKeysValues(50.0f, 0, 60.0f, 1, 70.0f, 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1.0f, 2).hashCode(), this.newWithKeysValues(1.0f, 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=0}", this.newWithKeysValues(0.0f, 0).toString());
        Assert.assertEquals("{1.0=1}", this.newWithKeysValues(1.0f, 1).toString());
        Assert.assertEquals("{5.0=5}", this.newWithKeysValues(5.0f, 5).toString());
        FloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        Assert.assertTrue(map1.toString(), "{0.0=0, 1.0=1}".equals(map1.toString()) || "{1.0=1, 0.0=0}".equals(map1.toString()));
        FloatIntMap map2 = this.newWithKeysValues(1.0f, 1, 32.0f, 32);
        Assert.assertTrue(map2.toString(), "{1.0=1, 32.0=32}".equals(map2.toString()) || "{32.0=32, 1.0=1}".equals(map2.toString()));
        FloatIntMap map3 = this.newWithKeysValues(0.0f, 0, 32.0f, 32);
        Assert.assertTrue(map3.toString(), "{0.0=0, 32.0=32}".equals(map3.toString()) || "{32.0=32, 0.0=0}".equals(map3.toString()));
        FloatIntMap map4 = this.newWithKeysValues(32.0f, 32, 33.0f, 33);
        Assert.assertTrue(map4.toString(), "{32.0=32, 33.0=33}".equals(map4.toString()) || "{33.0=33, 32.0=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        FloatIntMap map0 = this.newWithKeysValues(0.0f, 1, 3.0f, 4);
        int[] sum0 = new int[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        FloatIntMap map1 = this.newWithKeysValues(1.0f, 2, 3.0f, 4);
        int[] sum1 = new int[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        FloatIntMap map01 = this.newWithKeysValues(0.0f, 1, 1.0f, 2);
        int[] sum01 = new int[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        FloatIntMap map = this.newWithKeysValues(3.0f, 4, 4.0f, 5);
        int[] sum = new int[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        FloatIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        FloatIntMap map3 = this.newWithKeysValues(1.0f, 2);
        int[] sum3 = new int[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        FloatIntMap map0 = this.newWithKeysValues(0.0f, 1, 3.0f, 4);
        int[] sum0 = new int[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        FloatIntMap map1 = this.newWithKeysValues(1.0f, 2, 3.0f, 4);
        int[] sum1 = new int[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        FloatIntMap map01 = this.newWithKeysValues(0.0f, 1, 1.0f, 2);
        int[] sum01 = new int[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        FloatIntMap map = this.newWithKeysValues(3.0f, 4, 4.0f, 5);
        int[] sum = new int[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        FloatIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        FloatIntMap map3 = this.newWithKeysValues(1.0f, 2);
        int[] sum3 = new int[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        FloatIntMap map0 = this.newWithKeysValues(0.0f, 1, 3.0f, 4);
        float[] sum0 = new float[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3.0, sum0[0], 0.0);
        FloatIntMap map1 = this.newWithKeysValues(1.0f, 2, 3.0f, 4);
        float[] sum1 = new float[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4.0, sum1[0], 0.0);
        FloatIntMap map01 = this.newWithKeysValues(0.0f, 1, 1.0f, 2);
        float[] sum01 = new float[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1.0, sum01[0], 0.0);
        FloatIntMap map = this.newWithKeysValues(3.0f, 4, 4.0f, 5);
        float[] sum = new float[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7.0, sum[0], 0.0);
        FloatIntMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        FloatIntMap map3 = this.newWithKeysValues(1.0f, 1);
        float[] sum3 = new float[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKeyValue() {
        FloatIntMap map0 = this.newWithKeysValues(0.0f, 1, 3.0f, 4);
        float[] sumKey0 = new float[1];
        int[] sumValue0 = new int[1];
        map0.forEachKeyValue((float eachKey, int eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey0[0], 0.0);
        Assert.assertEquals(5L, sumValue0[0]);
        FloatIntMap map1 = this.newWithKeysValues(1.0f, 2, 3.0f, 4);
        float[] sumKey1 = new float[1];
        int[] sumValue1 = new int[1];
        map1.forEachKeyValue((float eachKey, int eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4.0, sumKey1[0], 0.0);
        Assert.assertEquals(6L, sumValue1[0]);
        FloatIntMap map01 = this.newWithKeysValues(0.0f, 1, 1.0f, 2);
        float[] sumKey01 = new float[1];
        int[] sumValue01 = new int[1];
        map01.forEachKeyValue((float eachKey, int eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1.0, sumKey01[0], 0.0);
        Assert.assertEquals(3L, sumValue01[0]);
        FloatIntMap map = this.newWithKeysValues(3.0f, 4, 4.0f, 5);
        float[] sumKey = new float[1];
        int[] sumValue = new int[1];
        map.forEachKeyValue((float eachKey, int eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7.0, sumKey[0], 0.0);
        Assert.assertEquals(9L, sumValue[0]);
        FloatIntMap map2 = this.getEmptyMap();
        float[] sumKey2 = new float[1];
        int[] sumValue2 = new int[1];
        map2.forEachKeyValue((float eachKey, int eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0.0, sumKey2[0], 0.0);
        Assert.assertEquals(0L, sumValue2[0]);
        FloatIntMap map3 = this.newWithKeysValues(3.0f, 5);
        float[] sumKey3 = new float[1];
        int[] sumValue3 = new int[1];
        map3.forEachKeyValue((float eachKey, int eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey3[0], 0.0);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        FloatIntMap map0 = this.newWithKeysValues(0.0f, 1, 3.0f, 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, float eachKey, int eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        FloatIntMap copy = map0.injectIntoKeyValue(FloatIntMaps.mutable.empty(), MutableFloatIntMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0.0f, 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0.0f, 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0.0f, 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1.0f, 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5.0f, 5).makeString());
        FloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        FloatIntMap map2 = this.newWithKeysValues(1.0f, 1, 32.0f, 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        FloatIntMap map3 = this.newWithKeysValues(0.0f, 0, 32.0f, 32);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        FloatIntMap map4 = this.newWithKeysValues(32.0f, 32, 33.0f, 33);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[32, 33]".equals(map4.makeString("[", ", ", "]")) || "[33, 32]".equals(map4.makeString("[", ", ", "]")));
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
        this.newWithKeysValues(0.0f, 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0.0f, 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0.0f, 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0f, 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0f, 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        FloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        FloatIntMap map2 = this.newWithKeysValues(1.0f, 1, 32.0f, 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        FloatIntMap map3 = this.newWithKeysValues(1.0f, 1, 32.0f, 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        FloatIntMap actual1 = map.select((float key, int value) -> Float.compare(key, 1.0f) == 0 || value == 3);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 3.0f, 3), actual1);
        FloatIntMap actual2 = map.select((float key, int value) -> Float.compare(key, 0.0f) == 0 || value == 2);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 2.0f, 2), actual2);
    }

    @Test
    public void reject() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        FloatIntMap actual1 = map.reject((float key, int value) -> Float.compare(key, 1.0f) == 0 || value == 3);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 2.0f, 2), actual1);
        FloatIntMap actual2 = map.reject((float key, int value) -> Float.compare(key, 0.0f) == 0 || value == 2);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 3.0f, 3), actual2);
    }

    @Test
    public void select_value() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        IntIterable actual1 = map.select(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.select(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void reject_value() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        IntIterable actual1 = map.reject(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.reject(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void collect() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        IntToObjectFunction<Integer> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1, 2, 3, 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2), this.newWithKeysValues(1.0f, 1).collect(function));
    }

    @Test
    public void count() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(2, map.count(IntPredicates.greaterThan(1)));
        Assert.assertEquals(2, map.count(IntPredicates.lessThan(2)));
    }

    @Test
    public void detectIfNone_value() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        int resultNotFound = map.detectIfNone(IntPredicates.greaterThan(5), 5);
        Assert.assertEquals(5, resultNotFound);
        Assert.assertEquals(5, this.getEmptyMap().detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(5, this.newWithKeysValues(1.0f, 1).detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, 1).detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(0, map.detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, map.detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(2, map.detectIfNone(IntPredicates.equal(2), 5));
    }

    @Test
    public void anySatisfy() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1).anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(2)));
        Assert.assertFalse(map.anySatisfy(IntPredicates.greaterThan(5)));
    }

    @Test
    public void allSatisfy() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1).allSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1).allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.allSatisfy(IntPredicates.lessThan(5)));
        FloatIntMap map1 = this.newWithKeysValues(2.0f, 2, 3.0f, 3);
        Assert.assertFalse(map1.allSatisfy(IntPredicates.equal(0)));
    }

    @Test
    public void noneSatisfy() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1).noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1).noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.noneSatisfy(IntPredicates.lessThan(0)));
    }

    @Test
    public void max() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(3, map.max());
        Assert.assertEquals(3, this.newWithKeysValues(3.0f, 3).max());
    }

    @Test
    public void min() {
        FloatIntMap map = this.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3, 0.0f, 0);
        Assert.assertEquals(0, map.min());
        Assert.assertEquals(3, this.newWithKeysValues(3.0f, 3).min());
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
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty(5));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty(0));
        FloatIntMap map = this.newWithKeysValues(1.0f, 1, 0.0f, 0, 9.0f, 9, 7.0f, 7);
        Assert.assertEquals(0L, map.minIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues(3.0f, 3).maxIfEmpty(5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0));
        FloatIntMap map = this.newWithKeysValues(1.0f, 1, 0.0f, 0, 9.0f, 9, 7.0f, 7);
        Assert.assertEquals(9L, map.maxIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues(3.0f, 3).minIfEmpty(5));
    }

    @Test
    public void sum() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(6, map.sum());
        FloatIntMap map2 = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);
        Assert.assertEquals(9, map2.sum());
        FloatIntMap map3 = this.newWithKeysValues(2.0f, 2);
        Assert.assertEquals(2, map3.sum());
    }

    @Test
    public void average() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        FloatIntMap map1 = this.newWithKeysValues(1.0f, 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        FloatIntMap map2 = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        FloatIntMap map3 = this.newWithKeysValues(1.0f, 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(IntArrayList.newListWith(0), this.newWithKeysValues(0.0f, 0).toList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues(1.0f, 1).toList());
        Assert.assertEquals(IntArrayList.newListWith(2), this.newWithKeysValues(2.0f, 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2.0f, 2, 3.0f, 3).toList().equals(IntArrayList.newListWith(2, 3)) || this.newWithKeysValues(2.0f, 2, 3.0f, 3).toList().equals(IntArrayList.newListWith(3, 2)));
    }

    @Test
    public void toSortedList() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 2, 3), map.toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues(1.0f, 1).toSortedList());
    }

    @Test
    public void toSet() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 3), map.toSet());
        Assert.assertEquals(IntHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(IntHashSet.newSetWith(1), this.newWithKeysValues(1.0f, 1).toSet());
    }

    @Test
    public void toBag() {
        FloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 2, 3), map.toBag());
        Assert.assertEquals(IntHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1), this.newWithKeysValues(1.0f, 1).toBag());
    }

    @Test
    public void intIterator() {
        MutableIntSet expected = IntHashSet.newSetWith(0, 31, 32);
        MutableIntSet actual = IntHashSet.newSetWith();
        IntIterator iterator = this.map.intIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().intIterator().next());
    }

    @Test
    public void asLazy() {
        LazyIntIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0, 31, 32));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<FloatIntPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((float key, int value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new int[] { 0, 31, 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        FloatIntMap map = this.newWithKeysValues(1.0f, 1, 2.0f, 2);
        int[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new int[] { 1, 2 }, array) || Arrays.equals(new int[] { 2, 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new int[] { 1 }, this.newWithKeysValues(1.0f, 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableFloatIntMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        IntIterable iterable = this.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1), IntBags.mutable.with(2), IntBags.mutable.with(3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(IntBags.mutable.with(1, 2), IntBags.mutable.with(3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(IntBags.mutable.with(2, 3), IntBags.mutable.with(1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(IntBags.mutable.with(1, 3), IntBags.mutable.with(2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1)).toSet(), this.newWithKeysValues(1.0f, 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1.0f, 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatIntMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

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
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
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
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatIntMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractFloatIntMapTestCase::keySet;
            this.payloads.values = AbstractFloatIntMapTestCase::values;
            this.payloads.get = AbstractFloatIntMapTestCase::get;
            this.payloads.getIfAbsent = AbstractFloatIntMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractFloatIntMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractFloatIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractFloatIntMapTestCase::containsValue;
            this.payloads.contains = AbstractFloatIntMapTestCase::contains;
            this.payloads.containsAll = AbstractFloatIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractFloatIntMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractFloatIntMapTestCase::size;
            this.payloads.isEmpty = AbstractFloatIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractFloatIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractFloatIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractFloatIntMapTestCase::testToString;
            this.payloads.forEach = AbstractFloatIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractFloatIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractFloatIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractFloatIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractFloatIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractFloatIntMapTestCase::makeString;
            this.payloads.appendString = AbstractFloatIntMapTestCase::appendString;
            this.payloads.select = AbstractFloatIntMapTestCase::select;
            this.payloads.reject = AbstractFloatIntMapTestCase::reject;
            this.payloads.select_value = AbstractFloatIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractFloatIntMapTestCase::reject_value;
            this.payloads.collect = AbstractFloatIntMapTestCase::collect;
            this.payloads.count = AbstractFloatIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractFloatIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractFloatIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractFloatIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractFloatIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractFloatIntMapTestCase::max;
            this.payloads.min = AbstractFloatIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractFloatIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractFloatIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractFloatIntMapTestCase::sum;
            this.payloads.average = AbstractFloatIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractFloatIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractFloatIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractFloatIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractFloatIntMapTestCase::toSet;
            this.payloads.toBag = AbstractFloatIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractFloatIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractFloatIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractFloatIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractFloatIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractFloatIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractFloatIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractFloatIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractFloatIntMapTestCase::chunk;
        }
    }
}
