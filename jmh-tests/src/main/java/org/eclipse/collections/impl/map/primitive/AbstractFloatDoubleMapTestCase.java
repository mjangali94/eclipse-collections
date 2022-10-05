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
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.factory.primitive.FloatDoubleMaps;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.map.primitive.FloatDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.FloatDoublePair;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatDoubleHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractFloatDoubleMapTestCase {

    protected final FloatDoubleMap map = this.classUnderTest();

    protected abstract FloatDoubleMap classUnderTest();

    protected abstract FloatDoubleMap newWithKeysValues(float key1, double value1);

    protected abstract FloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2);

    protected abstract FloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3);

    protected abstract FloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4);

    protected abstract FloatDoubleMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f), this.newWithKeysValues(0.0f, 0.0).keySet());
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 31.0f, 32.0f), this.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0));
        FloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0));
        Assert.assertTrue(map1.values().contains(31.0));
        Assert.assertTrue(map1.values().contains(32.0));
    }

    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get(0.0f), 0.0);
        Assert.assertEquals(31.0, this.map.get(31.0f), 0.0);
        Assert.assertEquals(32.0, this.map.get(32.0f), 0.0);
        Assert.assertEquals(0.0, this.map.get(1.0f), 0.0);
        Assert.assertEquals(0.0, this.map.get(33.0f), 0.0);
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0.0f, 5.0), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent(31.0f, 5.0), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent(32.0f, 5.0), 0.0);
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow(0.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow(31.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow(32.0f), 0.0);
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
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertTrue(this.map.containsValue(31.0));
        Assert.assertTrue(this.map.containsValue(32.0));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0.0));
        Assert.assertTrue(this.map.contains(31.0));
        Assert.assertTrue(this.map.contains(32.0));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0.0, 31.0, 32.0));
        Assert.assertFalse(this.map.containsAll(0.0, 31.0, 35.0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 32.0)));
        Assert.assertFalse(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 35.0)));
        Assert.assertTrue(this.map.containsAll(new DoubleArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0f, 0.0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, 1.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0f, 1.0, 5.0f, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, 0.0, 5.0f, 5.0).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, 1.0, 0.0f, 0.0, 5.0f, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, 6.0, 5.0f, 5.0).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0f, 0.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0f, 50.0).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0f, 0.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0f, 50.0).notEmpty());
    }

    @Test
    public void testEquals() {
        FloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 32.0f, 32.0);
        FloatDoubleMap map2 = this.newWithKeysValues(32.0f, 32.0, 0.0f, 0.0, 1.0f, 1.0);
        FloatDoubleMap map3 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 2.0, 32.0f, 32.0);
        FloatDoubleMap map4 = this.newWithKeysValues(0.0f, 1.0, 1.0f, 1.0, 32.0f, 32.0);
        FloatDoubleMap map5 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 32.0f, 33.0);
        FloatDoubleMap map6 = this.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0, 70.0f, 33.0);
        FloatDoubleMap map7 = this.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0);
        FloatDoubleMap map8 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        FloatDoubleMap map9 = this.newWithKeysValues(0.0f, 0.0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(DoubleArrayList.newListWith(0.0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, FloatDoubleMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, FloatDoubleMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 32.0f, 32.0).hashCode(), this.newWithKeysValues(32.0f, 32.0, 0.0f, 0.0, 1.0f, 1.0).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0, 70.0f, 33.0).hashCode(), this.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0, 70.0f, 33.0).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1.0f, 2.0).hashCode(), this.newWithKeysValues(1.0f, 2.0).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=0.0}", this.newWithKeysValues(0.0f, 0.0).toString());
        Assert.assertEquals("{1.0=1.0}", this.newWithKeysValues(1.0f, 1.0).toString());
        Assert.assertEquals("{5.0=5.0}", this.newWithKeysValues(5.0f, 5.0).toString());
        FloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        Assert.assertTrue(map1.toString(), "{0.0=0.0, 1.0=1.0}".equals(map1.toString()) || "{1.0=1.0, 0.0=0.0}".equals(map1.toString()));
        FloatDoubleMap map2 = this.newWithKeysValues(1.0f, 1.0, 32.0f, 32.0);
        Assert.assertTrue(map2.toString(), "{1.0=1.0, 32.0=32.0}".equals(map2.toString()) || "{32.0=32.0, 1.0=1.0}".equals(map2.toString()));
        FloatDoubleMap map3 = this.newWithKeysValues(0.0f, 0.0, 32.0f, 32.0);
        Assert.assertTrue(map3.toString(), "{0.0=0.0, 32.0=32.0}".equals(map3.toString()) || "{32.0=32.0, 0.0=0.0}".equals(map3.toString()));
        FloatDoubleMap map4 = this.newWithKeysValues(32.0f, 32.0, 33.0f, 33.0);
        Assert.assertTrue(map4.toString(), "{32.0=32.0, 33.0=33.0}".equals(map4.toString()) || "{33.0=33.0, 32.0=32.0}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        FloatDoubleMap map0 = this.newWithKeysValues(0.0f, 1.0, 3.0f, 4.0);
        double[] sum0 = new double[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        FloatDoubleMap map1 = this.newWithKeysValues(1.0f, 2.0, 3.0f, 4.0);
        double[] sum1 = new double[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        FloatDoubleMap map01 = this.newWithKeysValues(0.0f, 1.0, 1.0f, 2.0);
        double[] sum01 = new double[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        FloatDoubleMap map = this.newWithKeysValues(3.0f, 4.0, 4.0f, 5.0);
        double[] sum = new double[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        FloatDoubleMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        FloatDoubleMap map3 = this.newWithKeysValues(1.0f, 2.0);
        double[] sum3 = new double[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachValue() {
        FloatDoubleMap map0 = this.newWithKeysValues(0.0f, 1.0, 3.0f, 4.0);
        double[] sum0 = new double[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        FloatDoubleMap map1 = this.newWithKeysValues(1.0f, 2.0, 3.0f, 4.0);
        double[] sum1 = new double[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        FloatDoubleMap map01 = this.newWithKeysValues(0.0f, 1.0, 1.0f, 2.0);
        double[] sum01 = new double[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        FloatDoubleMap map = this.newWithKeysValues(3.0f, 4.0, 4.0f, 5.0);
        double[] sum = new double[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        FloatDoubleMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        FloatDoubleMap map3 = this.newWithKeysValues(1.0f, 2.0);
        double[] sum3 = new double[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKey() {
        FloatDoubleMap map0 = this.newWithKeysValues(0.0f, 1.0, 3.0f, 4.0);
        float[] sum0 = new float[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3.0, sum0[0], 0.0);
        FloatDoubleMap map1 = this.newWithKeysValues(1.0f, 2.0, 3.0f, 4.0);
        float[] sum1 = new float[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4.0, sum1[0], 0.0);
        FloatDoubleMap map01 = this.newWithKeysValues(0.0f, 1.0, 1.0f, 2.0);
        float[] sum01 = new float[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1.0, sum01[0], 0.0);
        FloatDoubleMap map = this.newWithKeysValues(3.0f, 4.0, 4.0f, 5.0);
        float[] sum = new float[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7.0, sum[0], 0.0);
        FloatDoubleMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        FloatDoubleMap map3 = this.newWithKeysValues(1.0f, 1.0);
        float[] sum3 = new float[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKeyValue() {
        FloatDoubleMap map0 = this.newWithKeysValues(0.0f, 1.0, 3.0f, 4.0);
        float[] sumKey0 = new float[1];
        double[] sumValue0 = new double[1];
        map0.forEachKeyValue((float eachKey, double eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey0[0], 0.0);
        Assert.assertEquals(5.0, sumValue0[0], 0.0);
        FloatDoubleMap map1 = this.newWithKeysValues(1.0f, 2.0, 3.0f, 4.0);
        float[] sumKey1 = new float[1];
        double[] sumValue1 = new double[1];
        map1.forEachKeyValue((float eachKey, double eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4.0, sumKey1[0], 0.0);
        Assert.assertEquals(6.0, sumValue1[0], 0.0);
        FloatDoubleMap map01 = this.newWithKeysValues(0.0f, 1.0, 1.0f, 2.0);
        float[] sumKey01 = new float[1];
        double[] sumValue01 = new double[1];
        map01.forEachKeyValue((float eachKey, double eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1.0, sumKey01[0], 0.0);
        Assert.assertEquals(3.0, sumValue01[0], 0.0);
        FloatDoubleMap map = this.newWithKeysValues(3.0f, 4.0, 4.0f, 5.0);
        float[] sumKey = new float[1];
        double[] sumValue = new double[1];
        map.forEachKeyValue((float eachKey, double eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7.0, sumKey[0], 0.0);
        Assert.assertEquals(9.0, sumValue[0], 0.0);
        FloatDoubleMap map2 = this.getEmptyMap();
        float[] sumKey2 = new float[1];
        double[] sumValue2 = new double[1];
        map2.forEachKeyValue((float eachKey, double eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0.0, sumKey2[0], 0.0);
        Assert.assertEquals(0.0, sumValue2[0], 0.0);
        FloatDoubleMap map3 = this.newWithKeysValues(3.0f, 5.0);
        float[] sumKey3 = new float[1];
        double[] sumValue3 = new double[1];
        map3.forEachKeyValue((float eachKey, double eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey3[0], 0.0);
        Assert.assertEquals(5.0, sumValue3[0], 0.0);
    }

    @Test
    public void injectIntoKeyValue() {
        FloatDoubleMap map0 = this.newWithKeysValues(0.0f, 1.0, 3.0f, 4.0);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, float eachKey, double eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        FloatDoubleMap copy = map0.injectIntoKeyValue(FloatDoubleMaps.mutable.empty(), MutableFloatDoubleMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0.0", this.newWithKeysValues(0.0f, 0.0).makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues(0.0f, 0.0).makeString(", "));
        Assert.assertEquals("[0.0]", this.newWithKeysValues(0.0f, 0.0).makeString("[", "/", "]"));
        Assert.assertEquals("1.0", this.newWithKeysValues(1.0f, 1.0).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues(5.0f, 5.0).makeString());
        FloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        Assert.assertTrue(map1.makeString(), "0.0, 1.0".equals(map1.makeString()) || "1.0, 0.0".equals(map1.makeString()));
        FloatDoubleMap map2 = this.newWithKeysValues(1.0f, 1.0, 32.0f, 32.0);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1.0/32.0]".equals(map2.makeString("[", "/", "]")) || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));
        FloatDoubleMap map3 = this.newWithKeysValues(0.0f, 0.0, 32.0f, 32.0);
        Assert.assertTrue(map3.makeString("~"), "0.0~32.0".equals(map3.makeString("~")) || "32.0~0.0".equals(map3.makeString("~")));
        FloatDoubleMap map4 = this.newWithKeysValues(32.0f, 32.0, 33.0f, 33.0);
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
        this.newWithKeysValues(0.0f, 0.0).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0.0f, 0.0).appendString(appendable01, "/");
        Assert.assertEquals("0.0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0.0f, 0.0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0.0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0f, 1.0).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0f, 5.0).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        FloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0.0, 1.0".equals(appendable3.toString()) || "1.0, 0.0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        FloatDoubleMap map2 = this.newWithKeysValues(1.0f, 1.0, 32.0f, 32.0);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1.0/32.0]".equals(appendable4.toString()) || "[32.0/1.0]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        FloatDoubleMap map3 = this.newWithKeysValues(1.0f, 1.0, 32.0f, 32.0);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1.0/32.0]".equals(appendable5.toString()) || "[32.0/1.0]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0.0/1.0".equals(appendable6.toString()) || "1.0/0.0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        FloatDoubleMap actual1 = map.select((float key, double value) -> Float.compare(key, 1.0f) == 0 || Double.compare(value, 3.0) == 0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 3.0f, 3.0), actual1);
        FloatDoubleMap actual2 = map.select((float key, double value) -> Float.compare(key, 0.0f) == 0 || Double.compare(value, 2.0) == 0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 2.0f, 2.0), actual2);
    }

    @Test
    public void reject() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        FloatDoubleMap actual1 = map.reject((float key, double value) -> Float.compare(key, 1.0f) == 0 || Double.compare(value, 3.0) == 0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 2.0f, 2.0), actual1);
        FloatDoubleMap actual2 = map.reject((float key, double value) -> Float.compare(key, 0.0f) == 0 || Double.compare(value, 2.0) == 0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 3.0f, 3.0), actual2);
    }

    @Test
    public void select_value() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        DoubleIterable actual1 = map.select(DoublePredicates.greaterThan(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(2.0, 3.0), actual1);
        DoubleIterable actual2 = map.select(DoublePredicates.lessThan(2.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0, 1.0), actual2);
    }

    @Test
    public void reject_value() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        DoubleIterable actual1 = map.reject(DoublePredicates.lessThan(2.0));
        Assert.assertEquals(DoubleBags.immutable.with(2.0, 3.0), actual1);
        DoubleIterable actual2 = map.reject(DoublePredicates.greaterThan(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0, 1.0), actual2);
    }

    @Test
    public void collect() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        DoubleToObjectFunction<Double> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1.0, 2.0, 3.0, 4.0), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2.0), this.newWithKeysValues(1.0f, 1.0).collect(function));
    }

    @Test
    public void count() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(2, map.count(DoublePredicates.greaterThan(1.0)));
        Assert.assertEquals(2, map.count(DoublePredicates.lessThan(2.0)));
    }

    @Test
    public void detectIfNone_value() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        double resultNotFound = map.detectIfNone(DoublePredicates.greaterThan(5.0), 5.0);
        Assert.assertEquals(5.0, resultNotFound, 0.0);
        Assert.assertEquals(5.0, this.getEmptyMap().detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(5.0, this.newWithKeysValues(1.0f, 1.0).detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(1.0, this.newWithKeysValues(1.0f, 1.0).detectIfNone(DoublePredicates.equal(1.0), 5.0), 0.0);
        Assert.assertEquals(0.0, map.detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(1.0, map.detectIfNone(DoublePredicates.equal(1.0), 5.0), 0.0);
        Assert.assertEquals(2.0, map.detectIfNone(DoublePredicates.equal(2.0), 5.0), 0.0);
    }

    @Test
    public void anySatisfy() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1.0).anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1.0).anySatisfy(DoublePredicates.equal(1.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(1.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(2.0)));
        Assert.assertFalse(map.anySatisfy(DoublePredicates.greaterThan(5.0)));
    }

    @Test
    public void allSatisfy() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1.0).allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1.0).allSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(2.0)));
        Assert.assertTrue(map.allSatisfy(DoublePredicates.lessThan(5.0)));
        FloatDoubleMap map1 = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0);
        Assert.assertFalse(map1.allSatisfy(DoublePredicates.equal(0.0)));
    }

    @Test
    public void noneSatisfy() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues(1.0f, 1.0).noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues(1.0f, 1.0).noneSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(2.0)));
        Assert.assertTrue(map.noneSatisfy(DoublePredicates.lessThan(0.0)));
    }

    @Test
    public void max() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(3.0, map.max(), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3.0f, 3.0).max(), 0.0);
    }

    @Test
    public void min() {
        FloatDoubleMap map = this.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0, 0.0f, 0.0);
        Assert.assertEquals(0.0, map.min(), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3.0f, 3.0).min(), 0.0);
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
        Assert.assertEquals(5.0, this.getEmptyMap().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().minIfEmpty(0.0), 0.0);
        FloatDoubleMap map = this.newWithKeysValues(1.0f, 1.0, 0.0f, 0.0, 9.0f, 9.0, 7.0f, 7.0);
        Assert.assertEquals(0.0, map.minIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3.0f, 3.0).maxIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, this.getEmptyMap().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().maxIfEmpty(0.0), 0.0);
        FloatDoubleMap map = this.newWithKeysValues(1.0f, 1.0, 0.0f, 0.0, 9.0f, 9.0, 7.0f, 7.0);
        Assert.assertEquals(9.0, map.maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3.0f, 3.0).minIfEmpty(5.0), 0.0);
    }

    @Test
    public void sum() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(6.0, map.sum(), 0.0);
        FloatDoubleMap map2 = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        Assert.assertEquals(9.0, map2.sum(), 0.0);
        FloatDoubleMap map3 = this.newWithKeysValues(2.0f, 2.0);
        Assert.assertEquals(2.0, map3.sum(), 0.0);
    }

    @Test
    public void average() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(1.5, map.average(), 0.0);
        FloatDoubleMap map1 = this.newWithKeysValues(1.0f, 1.0);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(1.5, map.median(), 0.0);
        FloatDoubleMap map2 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        FloatDoubleMap map3 = this.newWithKeysValues(1.0f, 1.0);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), this.newWithKeysValues(0.0f, 0.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), this.newWithKeysValues(1.0f, 1.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(2.0), this.newWithKeysValues(2.0f, 2.0).toList());
        Assert.assertTrue(this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0).toList().equals(DoubleArrayList.newListWith(2.0, 3.0)) || this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0).toList().equals(DoubleArrayList.newListWith(3.0, 2.0)));
    }

    @Test
    public void toSortedList() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0), map.toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), this.newWithKeysValues(1.0f, 1.0).toSortedList());
    }

    @Test
    public void toSet() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 3.0), map.toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), this.newWithKeysValues(1.0f, 1.0).toSet());
    }

    @Test
    public void toBag() {
        FloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 2.0, 3.0), map.toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), this.newWithKeysValues(1.0f, 1.0).toBag());
    }

    @Test
    public void doubleIterator() {
        MutableDoubleSet expected = DoubleHashSet.newSetWith(0.0, 31.0, 32.0);
        MutableDoubleSet actual = DoubleHashSet.newSetWith();
        DoubleIterator iterator = this.map.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().doubleIterator().next());
    }

    @Test
    public void asLazy() {
        LazyDoubleIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0.0, 31.0, 32.0));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<FloatDoublePair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((float key, double value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new double[] { 0.0, 31.0, 32.0 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        FloatDoubleMap map = this.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0);
        double[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new double[] { 1.0, 2.0 }, array) || Arrays.equals(new double[] { 2.0, 1.0 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new double[] { 1.0 }, this.newWithKeysValues(1.0f, 1.0).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableFloatDoubleMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        DoubleIterable iterable = this.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0), DoubleBags.mutable.with(2.0), DoubleBags.mutable.with(3.0)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0), DoubleBags.mutable.with(3.0)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(DoubleBags.mutable.with(2.0, 3.0), DoubleBags.mutable.with(1.0)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(DoubleBags.mutable.with(1.0, 3.0), DoubleBags.mutable.with(2.0)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0)).toSet(), this.newWithKeysValues(1.0f, 1.0).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1.0f, 1.0).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatDoubleMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatDoubleMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractFloatDoubleMapTestCase::keySet;
            this.payloads.values = AbstractFloatDoubleMapTestCase::values;
            this.payloads.get = AbstractFloatDoubleMapTestCase::get;
            this.payloads.getIfAbsent = AbstractFloatDoubleMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractFloatDoubleMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractFloatDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractFloatDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractFloatDoubleMapTestCase::contains;
            this.payloads.containsAll = AbstractFloatDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractFloatDoubleMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractFloatDoubleMapTestCase::size;
            this.payloads.isEmpty = AbstractFloatDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractFloatDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractFloatDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractFloatDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractFloatDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractFloatDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractFloatDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractFloatDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractFloatDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractFloatDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractFloatDoubleMapTestCase::appendString;
            this.payloads.select = AbstractFloatDoubleMapTestCase::select;
            this.payloads.reject = AbstractFloatDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractFloatDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractFloatDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractFloatDoubleMapTestCase::collect;
            this.payloads.count = AbstractFloatDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractFloatDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractFloatDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractFloatDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractFloatDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractFloatDoubleMapTestCase::max;
            this.payloads.min = AbstractFloatDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractFloatDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractFloatDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractFloatDoubleMapTestCase::sum;
            this.payloads.average = AbstractFloatDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractFloatDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractFloatDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractFloatDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractFloatDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractFloatDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractFloatDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractFloatDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractFloatDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractFloatDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractFloatDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractFloatDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractFloatDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractFloatDoubleMapTestCase::chunk;
        }
    }
}
