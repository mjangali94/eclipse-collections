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
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.factory.primitive.FloatShortMaps;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.FloatShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatShortMap;
import org.eclipse.collections.api.map.primitive.MutableFloatShortMap;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.FloatShortPair;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractFloatShortMapTestCase {

    protected final FloatShortMap map = this.classUnderTest();

    protected abstract FloatShortMap classUnderTest();

    protected abstract FloatShortMap newWithKeysValues(float key1, short value1);

    protected abstract FloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2);

    protected abstract FloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3);

    protected abstract FloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3, float key4, short value4);

    protected abstract FloatShortMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f), this.newWithKeysValues(0.0f, (short) 0).keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 31.0f, 32.0f), this.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((short) 0));
        FloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((short) 0));
        Assert.assertTrue(map1.values().contains((short) 31));
        Assert.assertTrue(map1.values().contains((short) 32));
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0f, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0f, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0f, (short) 5));
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
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertTrue(this.map.containsValue((short) 31));
        Assert.assertTrue(this.map.containsValue((short) 32));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((short) 0));
        Assert.assertTrue(this.map.contains((short) 31));
        Assert.assertTrue(this.map.contains((short) 32));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll((short) 0, (short) 31, (short) 32));
        Assert.assertFalse(this.map.containsAll((short) 0, (short) 31, (short) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32)));
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 35)));
        Assert.assertTrue(this.map.containsAll(new ShortArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0f, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, (short) 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0f, (short) 1, 5.0f, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, (short) 0, 5.0f, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, (short) 1, 0.0f, (short) 0, 5.0f, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, (short) 6, 5.0f, (short) 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0f, (short) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0f, (short) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0f, (short) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0f, (short) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0f, (short) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0f, (short) 50).notEmpty());
    }

    @Test
    public void testEquals() {
        FloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 32.0f, (short) 32);
        FloatShortMap map2 = this.newWithKeysValues(32.0f, (short) 32, 0.0f, (short) 0, 1.0f, (short) 1);
        FloatShortMap map3 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 2, 32.0f, (short) 32);
        FloatShortMap map4 = this.newWithKeysValues(0.0f, (short) 1, 1.0f, (short) 1, 32.0f, (short) 32);
        FloatShortMap map5 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 32.0f, (short) 33);
        FloatShortMap map6 = this.newWithKeysValues(50.0f, (short) 0, 60.0f, (short) 1, 70.0f, (short) 33);
        FloatShortMap map7 = this.newWithKeysValues(50.0f, (short) 0, 60.0f, (short) 1);
        FloatShortMap map8 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        FloatShortMap map9 = this.newWithKeysValues(0.0f, (short) 0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(ShortArrayList.newListWith((short) 0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, FloatShortMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, FloatShortMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 32.0f, (short) 32).hashCode(), this.newWithKeysValues(32.0f, (short) 32, 0.0f, (short) 0, 1.0f, (short) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50.0f, (short) 0, 60.0f, (short) 1, 70.0f, (short) 33).hashCode(), this.newWithKeysValues(50.0f, (short) 0, 60.0f, (short) 1, 70.0f, (short) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1.0f, (short) 2).hashCode(), this.newWithKeysValues(1.0f, (short) 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=0}", this.newWithKeysValues(0.0f, (short) 0).toString());
        Assert.assertEquals("{1.0=1}", this.newWithKeysValues(1.0f, (short) 1).toString());
        Assert.assertEquals("{5.0=5}", this.newWithKeysValues(5.0f, (short) 5).toString());
        FloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        Assert.assertTrue(map1.toString(), "{0.0=0, 1.0=1}".equals(map1.toString()) || "{1.0=1, 0.0=0}".equals(map1.toString()));
        FloatShortMap map2 = this.newWithKeysValues(1.0f, (short) 1, 32.0f, (short) 32);
        Assert.assertTrue(map2.toString(), "{1.0=1, 32.0=32}".equals(map2.toString()) || "{32.0=32, 1.0=1}".equals(map2.toString()));
        FloatShortMap map3 = this.newWithKeysValues(0.0f, (short) 0, 32.0f, (short) 32);
        Assert.assertTrue(map3.toString(), "{0.0=0, 32.0=32}".equals(map3.toString()) || "{32.0=32, 0.0=0}".equals(map3.toString()));
        FloatShortMap map4 = this.newWithKeysValues(32.0f, (short) 32, 33.0f, (short) 33);
        Assert.assertTrue(map4.toString(), "{32.0=32, 33.0=33}".equals(map4.toString()) || "{33.0=33, 32.0=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        FloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 1, 3.0f, (short) 4);
        short[] sum0 = new short[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        FloatShortMap map1 = this.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4);
        short[] sum1 = new short[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        FloatShortMap map01 = this.newWithKeysValues(0.0f, (short) 1, 1.0f, (short) 2);
        short[] sum01 = new short[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        FloatShortMap map = this.newWithKeysValues(3.0f, (short) 4, 4.0f, (short) 5);
        short[] sum = new short[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        FloatShortMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        FloatShortMap map3 = this.newWithKeysValues(1.0f, (short) 2);
        short[] sum3 = new short[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        FloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 1, 3.0f, (short) 4);
        short[] sum0 = new short[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        FloatShortMap map1 = this.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4);
        short[] sum1 = new short[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        FloatShortMap map01 = this.newWithKeysValues(0.0f, (short) 1, 1.0f, (short) 2);
        short[] sum01 = new short[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        FloatShortMap map = this.newWithKeysValues(3.0f, (short) 4, 4.0f, (short) 5);
        short[] sum = new short[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        FloatShortMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        FloatShortMap map3 = this.newWithKeysValues(1.0f, (short) 2);
        short[] sum3 = new short[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        FloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 1, 3.0f, (short) 4);
        float[] sum0 = new float[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3.0, sum0[0], 0.0);
        FloatShortMap map1 = this.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4);
        float[] sum1 = new float[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4.0, sum1[0], 0.0);
        FloatShortMap map01 = this.newWithKeysValues(0.0f, (short) 1, 1.0f, (short) 2);
        float[] sum01 = new float[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1.0, sum01[0], 0.0);
        FloatShortMap map = this.newWithKeysValues(3.0f, (short) 4, 4.0f, (short) 5);
        float[] sum = new float[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7.0, sum[0], 0.0);
        FloatShortMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        FloatShortMap map3 = this.newWithKeysValues(1.0f, (short) 1);
        float[] sum3 = new float[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKeyValue() {
        FloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 1, 3.0f, (short) 4);
        float[] sumKey0 = new float[1];
        short[] sumValue0 = new short[1];
        map0.forEachKeyValue((float eachKey, short eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey0[0], 0.0);
        Assert.assertEquals(5L, sumValue0[0]);
        FloatShortMap map1 = this.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4);
        float[] sumKey1 = new float[1];
        short[] sumValue1 = new short[1];
        map1.forEachKeyValue((float eachKey, short eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4.0, sumKey1[0], 0.0);
        Assert.assertEquals(6L, sumValue1[0]);
        FloatShortMap map01 = this.newWithKeysValues(0.0f, (short) 1, 1.0f, (short) 2);
        float[] sumKey01 = new float[1];
        short[] sumValue01 = new short[1];
        map01.forEachKeyValue((float eachKey, short eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1.0, sumKey01[0], 0.0);
        Assert.assertEquals(3L, sumValue01[0]);
        FloatShortMap map = this.newWithKeysValues(3.0f, (short) 4, 4.0f, (short) 5);
        float[] sumKey = new float[1];
        short[] sumValue = new short[1];
        map.forEachKeyValue((float eachKey, short eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7.0, sumKey[0], 0.0);
        Assert.assertEquals(9L, sumValue[0]);
        FloatShortMap map2 = this.getEmptyMap();
        float[] sumKey2 = new float[1];
        short[] sumValue2 = new short[1];
        map2.forEachKeyValue((float eachKey, short eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0.0, sumKey2[0], 0.0);
        Assert.assertEquals(0L, sumValue2[0]);
        FloatShortMap map3 = this.newWithKeysValues(3.0f, (short) 5);
        float[] sumKey3 = new float[1];
        short[] sumValue3 = new short[1];
        map3.forEachKeyValue((float eachKey, short eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey3[0], 0.0);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        FloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 1, 3.0f, (short) 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, float eachKey, short eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        FloatShortMap copy = map0.injectIntoKeyValue(FloatShortMaps.mutable.empty(), MutableFloatShortMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0.0f, (short) 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0.0f, (short) 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0.0f, (short) 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1.0f, (short) 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5.0f, (short) 5).makeString());
        FloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        FloatShortMap map2 = this.newWithKeysValues(1.0f, (short) 1, 32.0f, (short) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        FloatShortMap map3 = this.newWithKeysValues(0.0f, (short) 0, 32.0f, (short) 32);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        FloatShortMap map4 = this.newWithKeysValues(32.0f, (short) 32, 33.0f, (short) 33);
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
        this.newWithKeysValues(0.0f, (short) 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0.0f, (short) 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0.0f, (short) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0f, (short) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0f, (short) 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        FloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        FloatShortMap map2 = this.newWithKeysValues(1.0f, (short) 1, 32.0f, (short) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        FloatShortMap map3 = this.newWithKeysValues(1.0f, (short) 1, 32.0f, (short) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        FloatShortMap actual1 = map.select((float key, short value) -> Float.compare(key, 1.0f) == 0 || value == (short) 3);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 3.0f, (short) 3), actual1);
        FloatShortMap actual2 = map.select((float key, short value) -> Float.compare(key, 0.0f) == 0 || value == (short) 2);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 2.0f, (short) 2), actual2);
    }

    @Test
    public void reject() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        FloatShortMap actual1 = map.reject((float key, short value) -> Float.compare(key, 1.0f) == 0 || value == (short) 3);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 2.0f, (short) 2), actual1);
        FloatShortMap actual2 = map.reject((float key, short value) -> Float.compare(key, 0.0f) == 0 || value == (short) 2);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 3.0f, (short) 3), actual2);
    }

    @Test
    public void select_value() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        ShortIterable actual1 = map.select(ShortPredicates.greaterThan((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 2, (short) 3), actual1);
        ShortIterable actual2 = map.select(ShortPredicates.lessThan((short) 2));
        Assert.assertEquals(ShortBags.immutable.with((short) 0, (short) 1), actual2);
    }

    @Test
    public void reject_value() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        ShortIterable actual1 = map.reject(ShortPredicates.lessThan((short) 2));
        Assert.assertEquals(ShortBags.immutable.with((short) 2, (short) 3), actual1);
        ShortIterable actual2 = map.reject(ShortPredicates.greaterThan((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 0, (short) 1), actual2);
    }

    @Test
    public void collect() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        ShortToObjectFunction<Short> function = parameter -> (short) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((short) 1, (short) 2, (short) 3, (short) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((short) 2), this.newWithKeysValues(1.0f, (short) 1).collect(function));
    }

    @Test
    public void count() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(2, map.count(ShortPredicates.greaterThan((short) 1)));
        Assert.assertEquals(2, map.count(ShortPredicates.lessThan((short) 2)));
    }

    @Test
    public void detectIfNone_value() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        short resultNotFound = map.detectIfNone(ShortPredicates.greaterThan((short) 5), (short) 5);
        Assert.assertEquals((short) 5, resultNotFound);
        Assert.assertEquals((short) 5, this.getEmptyMap().detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 5, this.newWithKeysValues(1.0f, (short) 1).detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 1, this.newWithKeysValues(1.0f, (short) 1).detectIfNone(ShortPredicates.equal((short) 1), (short) 5));
        Assert.assertEquals((short) 0, map.detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 1, map.detectIfNone(ShortPredicates.equal((short) 1), (short) 5));
        Assert.assertEquals((short) 2, map.detectIfNone(ShortPredicates.equal((short) 2), (short) 5));
    }

    @Test
    public void anySatisfy() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, (short) 1).anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, (short) 1).anySatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertFalse(map.anySatisfy(ShortPredicates.greaterThan((short) 5)));
    }

    @Test
    public void allSatisfy() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, (short) 1).allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, (short) 1).allSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertTrue(map.allSatisfy(ShortPredicates.lessThan((short) 5)));
        FloatShortMap map1 = this.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertFalse(map1.allSatisfy(ShortPredicates.equal((short) 0)));
    }

    @Test
    public void noneSatisfy() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, (short) 1).noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, (short) 1).noneSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertTrue(map.noneSatisfy(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void max() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals((short) 3, map.max());
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0f, (short) 3).max());
    }

    @Test
    public void min() {
        FloatShortMap map = this.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 0.0f, (short) 0);
        Assert.assertEquals((short) 0, map.min());
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0f, (short) 3).min());
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
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty((short) 5));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty((short) 0));
        FloatShortMap map = this.newWithKeysValues(1.0f, (short) 1, 0.0f, (short) 0, 9.0f, (short) 9, 7.0f, (short) 7);
        Assert.assertEquals(0L, map.minIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0f, (short) 3).maxIfEmpty((short) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((short) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((short) 0));
        FloatShortMap map = this.newWithKeysValues(1.0f, (short) 1, 0.0f, (short) 0, 9.0f, (short) 9, 7.0f, (short) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0f, (short) 3).minIfEmpty((short) 5));
    }

    @Test
    public void sum() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals((short) 6, map.sum());
        FloatShortMap map2 = this.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        Assert.assertEquals((short) 9, map2.sum());
        FloatShortMap map3 = this.newWithKeysValues(2.0f, (short) 2);
        Assert.assertEquals((short) 2, map3.sum());
    }

    @Test
    public void average() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        FloatShortMap map1 = this.newWithKeysValues(1.0f, (short) 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        FloatShortMap map2 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        FloatShortMap map3 = this.newWithKeysValues(1.0f, (short) 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.newWithKeysValues(0.0f, (short) 0).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), this.newWithKeysValues(1.0f, (short) 1).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 2), this.newWithKeysValues(2.0f, (short) 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3).toList().equals(ShortArrayList.newListWith((short) 2, (short) 3)) || this.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3).toList().equals(ShortArrayList.newListWith((short) 3, (short) 2)));
    }

    @Test
    public void toSortedList() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3), map.toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), this.newWithKeysValues(1.0f, (short) 1).toSortedList());
    }

    @Test
    public void toSet() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 3), map.toSet());
        Assert.assertEquals(ShortHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), this.newWithKeysValues(1.0f, (short) 1).toSet());
    }

    @Test
    public void toBag() {
        FloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2, (short) 3), map.toBag());
        Assert.assertEquals(ShortHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), this.newWithKeysValues(1.0f, (short) 1).toBag());
    }

    @Test
    public void shortIterator() {
        MutableShortSet expected = ShortHashSet.newSetWith((short) 0, (short) 31, (short) 32);
        MutableShortSet actual = ShortHashSet.newSetWith();
        ShortIterator iterator = this.map.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().shortIterator().next());
    }

    @Test
    public void asLazy() {
        LazyShortIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll((short) 0, (short) 31, (short) 32));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<FloatShortPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((float key, short value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new short[] { (short) 0, (short) 31, (short) 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        FloatShortMap map = this.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2);
        short[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new short[] { (short) 1, (short) 2 }, array) || Arrays.equals(new short[] { (short) 2, (short) 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new short[] { (short) 1 }, this.newWithKeysValues(1.0f, (short) 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableFloatShortMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        ShortIterable iterable = this.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1), ShortBags.mutable.with((short) 2), ShortBags.mutable.with((short) 3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2), ShortBags.mutable.with((short) 3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ShortBags.mutable.with((short) 2, (short) 3), ShortBags.mutable.with((short) 1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 3), ShortBags.mutable.with((short) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1)).toSet(), this.newWithKeysValues(1.0f, (short) 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1.0f, (short) 1).chunk(-1));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatShortMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractFloatShortMapTestCase::keySet;
            this.payloads.values = AbstractFloatShortMapTestCase::values;
            this.payloads.get = AbstractFloatShortMapTestCase::get;
            this.payloads.getIfAbsent = AbstractFloatShortMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractFloatShortMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractFloatShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractFloatShortMapTestCase::containsValue;
            this.payloads.contains = AbstractFloatShortMapTestCase::contains;
            this.payloads.containsAll = AbstractFloatShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractFloatShortMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractFloatShortMapTestCase::size;
            this.payloads.isEmpty = AbstractFloatShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractFloatShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractFloatShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractFloatShortMapTestCase::testToString;
            this.payloads.forEach = AbstractFloatShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractFloatShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractFloatShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractFloatShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractFloatShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractFloatShortMapTestCase::makeString;
            this.payloads.appendString = AbstractFloatShortMapTestCase::appendString;
            this.payloads.select = AbstractFloatShortMapTestCase::select;
            this.payloads.reject = AbstractFloatShortMapTestCase::reject;
            this.payloads.select_value = AbstractFloatShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractFloatShortMapTestCase::reject_value;
            this.payloads.collect = AbstractFloatShortMapTestCase::collect;
            this.payloads.count = AbstractFloatShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractFloatShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractFloatShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractFloatShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractFloatShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractFloatShortMapTestCase::max;
            this.payloads.min = AbstractFloatShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractFloatShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractFloatShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractFloatShortMapTestCase::sum;
            this.payloads.average = AbstractFloatShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractFloatShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractFloatShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractFloatShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractFloatShortMapTestCase::toSet;
            this.payloads.toBag = AbstractFloatShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractFloatShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractFloatShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractFloatShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractFloatShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractFloatShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractFloatShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractFloatShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractFloatShortMapTestCase::chunk;
        }
    }
*/
}
