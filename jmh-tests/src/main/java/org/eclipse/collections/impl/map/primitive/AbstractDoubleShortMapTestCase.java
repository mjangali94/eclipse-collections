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
import org.eclipse.collections.api.factory.primitive.DoubleShortMaps;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.DoubleShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleShortMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleShortMap;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.DoubleShortPair;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleShortHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractDoubleShortMapTestCase {

    protected final DoubleShortMap map = this.classUnderTest();

    protected abstract DoubleShortMap classUnderTest();

    protected abstract DoubleShortMap newWithKeysValues(double key1, short value1);

    protected abstract DoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2);

    protected abstract DoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3);

    protected abstract DoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3, double key4, short value4);

    protected abstract DoubleShortMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0), this.newWithKeysValues(0.0, (short) 0).keySet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 31.0, 32.0), this.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((short) 0));
        DoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((short) 0));
        Assert.assertTrue(map1.values().contains((short) 31));
        Assert.assertTrue(map1.values().contains((short) 32));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0.0));
        Assert.assertEquals(31L, this.map.get(31.0));
        Assert.assertEquals(32L, this.map.get(32.0));
        Assert.assertEquals(0L, this.map.get(1.0));
        Assert.assertEquals(0L, this.map.get(33.0));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0, (short) 5));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0));
        Assert.assertEquals(31L, this.map.getOrThrow(31.0));
        Assert.assertEquals(32L, this.map.getOrThrow(32.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0.0));
        Assert.assertTrue(this.map.containsKey(31.0));
        Assert.assertTrue(this.map.containsKey(32.0));
        Assert.assertFalse(this.map.containsKey(1.0));
        Assert.assertFalse(this.map.containsKey(5.0));
        Assert.assertFalse(this.map.containsKey(35.0));
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
        Assert.assertEquals(1, this.newWithKeysValues(0.0, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0, (short) 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0, (short) 1, 5.0, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0, (short) 0, 5.0, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0, (short) 1, 0.0, (short) 0, 5.0, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0, (short) 6, 5.0, (short) 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0, (short) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0, (short) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0, (short) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0, (short) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0, (short) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0, (short) 50).notEmpty());
    }

    @Test
    public void testEquals() {
        DoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 32.0, (short) 32);
        DoubleShortMap map2 = this.newWithKeysValues(32.0, (short) 32, 0.0, (short) 0, 1.0, (short) 1);
        DoubleShortMap map3 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 2, 32.0, (short) 32);
        DoubleShortMap map4 = this.newWithKeysValues(0.0, (short) 1, 1.0, (short) 1, 32.0, (short) 32);
        DoubleShortMap map5 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 32.0, (short) 33);
        DoubleShortMap map6 = this.newWithKeysValues(50.0, (short) 0, 60.0, (short) 1, 70.0, (short) 33);
        DoubleShortMap map7 = this.newWithKeysValues(50.0, (short) 0, 60.0, (short) 1);
        DoubleShortMap map8 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        DoubleShortMap map9 = this.newWithKeysValues(0.0, (short) 0);
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
        Assert.assertEquals(map1, DoubleShortMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, DoubleShortMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 32.0, (short) 32).hashCode(), this.newWithKeysValues(32.0, (short) 32, 0.0, (short) 0, 1.0, (short) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50.0, (short) 0, 60.0, (short) 1, 70.0, (short) 33).hashCode(), this.newWithKeysValues(50.0, (short) 0, 60.0, (short) 1, 70.0, (short) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1.0, (short) 2).hashCode(), this.newWithKeysValues(1.0, (short) 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=0}", this.newWithKeysValues(0.0, (short) 0).toString());
        Assert.assertEquals("{1.0=1}", this.newWithKeysValues(1.0, (short) 1).toString());
        Assert.assertEquals("{5.0=5}", this.newWithKeysValues(5.0, (short) 5).toString());
        DoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        Assert.assertTrue(map1.toString(), "{0.0=0, 1.0=1}".equals(map1.toString()) || "{1.0=1, 0.0=0}".equals(map1.toString()));
        DoubleShortMap map2 = this.newWithKeysValues(1.0, (short) 1, 32.0, (short) 32);
        Assert.assertTrue(map2.toString(), "{1.0=1, 32.0=32}".equals(map2.toString()) || "{32.0=32, 1.0=1}".equals(map2.toString()));
        DoubleShortMap map3 = this.newWithKeysValues(0.0, (short) 0, 32.0, (short) 32);
        Assert.assertTrue(map3.toString(), "{0.0=0, 32.0=32}".equals(map3.toString()) || "{32.0=32, 0.0=0}".equals(map3.toString()));
        DoubleShortMap map4 = this.newWithKeysValues(32.0, (short) 32, 33.0, (short) 33);
        Assert.assertTrue(map4.toString(), "{32.0=32, 33.0=33}".equals(map4.toString()) || "{33.0=33, 32.0=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        DoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 1, 3.0, (short) 4);
        short[] sum0 = new short[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        DoubleShortMap map1 = this.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4);
        short[] sum1 = new short[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        DoubleShortMap map01 = this.newWithKeysValues(0.0, (short) 1, 1.0, (short) 2);
        short[] sum01 = new short[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        DoubleShortMap map = this.newWithKeysValues(3.0, (short) 4, 4.0, (short) 5);
        short[] sum = new short[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        DoubleShortMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        DoubleShortMap map3 = this.newWithKeysValues(1.0, (short) 2);
        short[] sum3 = new short[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        DoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 1, 3.0, (short) 4);
        short[] sum0 = new short[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        DoubleShortMap map1 = this.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4);
        short[] sum1 = new short[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        DoubleShortMap map01 = this.newWithKeysValues(0.0, (short) 1, 1.0, (short) 2);
        short[] sum01 = new short[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        DoubleShortMap map = this.newWithKeysValues(3.0, (short) 4, 4.0, (short) 5);
        short[] sum = new short[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        DoubleShortMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        DoubleShortMap map3 = this.newWithKeysValues(1.0, (short) 2);
        short[] sum3 = new short[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        DoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 1, 3.0, (short) 4);
        double[] sum0 = new double[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3.0, sum0[0], 0.0);
        DoubleShortMap map1 = this.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4);
        double[] sum1 = new double[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4.0, sum1[0], 0.0);
        DoubleShortMap map01 = this.newWithKeysValues(0.0, (short) 1, 1.0, (short) 2);
        double[] sum01 = new double[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1.0, sum01[0], 0.0);
        DoubleShortMap map = this.newWithKeysValues(3.0, (short) 4, 4.0, (short) 5);
        double[] sum = new double[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7.0, sum[0], 0.0);
        DoubleShortMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        DoubleShortMap map3 = this.newWithKeysValues(1.0, (short) 1);
        double[] sum3 = new double[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKeyValue() {
        DoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 1, 3.0, (short) 4);
        double[] sumKey0 = new double[1];
        short[] sumValue0 = new short[1];
        map0.forEachKeyValue((double eachKey, short eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey0[0], 0.0);
        Assert.assertEquals(5L, sumValue0[0]);
        DoubleShortMap map1 = this.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4);
        double[] sumKey1 = new double[1];
        short[] sumValue1 = new short[1];
        map1.forEachKeyValue((double eachKey, short eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4.0, sumKey1[0], 0.0);
        Assert.assertEquals(6L, sumValue1[0]);
        DoubleShortMap map01 = this.newWithKeysValues(0.0, (short) 1, 1.0, (short) 2);
        double[] sumKey01 = new double[1];
        short[] sumValue01 = new short[1];
        map01.forEachKeyValue((double eachKey, short eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1.0, sumKey01[0], 0.0);
        Assert.assertEquals(3L, sumValue01[0]);
        DoubleShortMap map = this.newWithKeysValues(3.0, (short) 4, 4.0, (short) 5);
        double[] sumKey = new double[1];
        short[] sumValue = new short[1];
        map.forEachKeyValue((double eachKey, short eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7.0, sumKey[0], 0.0);
        Assert.assertEquals(9L, sumValue[0]);
        DoubleShortMap map2 = this.getEmptyMap();
        double[] sumKey2 = new double[1];
        short[] sumValue2 = new short[1];
        map2.forEachKeyValue((double eachKey, short eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0.0, sumKey2[0], 0.0);
        Assert.assertEquals(0L, sumValue2[0]);
        DoubleShortMap map3 = this.newWithKeysValues(3.0, (short) 5);
        double[] sumKey3 = new double[1];
        short[] sumValue3 = new short[1];
        map3.forEachKeyValue((double eachKey, short eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey3[0], 0.0);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        DoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 1, 3.0, (short) 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, double eachKey, short eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        DoubleShortMap copy = map0.injectIntoKeyValue(DoubleShortMaps.mutable.empty(), MutableDoubleShortMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0.0, (short) 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0.0, (short) 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0.0, (short) 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1.0, (short) 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5.0, (short) 5).makeString());
        DoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        DoubleShortMap map2 = this.newWithKeysValues(1.0, (short) 1, 32.0, (short) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        DoubleShortMap map3 = this.newWithKeysValues(0.0, (short) 0, 32.0, (short) 32);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        DoubleShortMap map4 = this.newWithKeysValues(32.0, (short) 32, 33.0, (short) 33);
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
        this.newWithKeysValues(0.0, (short) 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0.0, (short) 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0.0, (short) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0, (short) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0, (short) 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        DoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        DoubleShortMap map2 = this.newWithKeysValues(1.0, (short) 1, 32.0, (short) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        DoubleShortMap map3 = this.newWithKeysValues(1.0, (short) 1, 32.0, (short) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        DoubleShortMap actual1 = map.select((double key, short value) -> Double.compare(key, 1.0) == 0 || value == (short) 3);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1, 3.0, (short) 3), actual1);
        DoubleShortMap actual2 = map.select((double key, short value) -> Double.compare(key, 0.0) == 0 || value == (short) 2);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 2.0, (short) 2), actual2);
    }

    @Test
    public void reject() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        DoubleShortMap actual1 = map.reject((double key, short value) -> Double.compare(key, 1.0) == 0 || value == (short) 3);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 2.0, (short) 2), actual1);
        DoubleShortMap actual2 = map.reject((double key, short value) -> Double.compare(key, 0.0) == 0 || value == (short) 2);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1, 3.0, (short) 3), actual2);
    }

    @Test
    public void select_value() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        ShortIterable actual1 = map.select(ShortPredicates.greaterThan((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 2, (short) 3), actual1);
        ShortIterable actual2 = map.select(ShortPredicates.lessThan((short) 2));
        Assert.assertEquals(ShortBags.immutable.with((short) 0, (short) 1), actual2);
    }

    @Test
    public void reject_value() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        ShortIterable actual1 = map.reject(ShortPredicates.lessThan((short) 2));
        Assert.assertEquals(ShortBags.immutable.with((short) 2, (short) 3), actual1);
        ShortIterable actual2 = map.reject(ShortPredicates.greaterThan((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 0, (short) 1), actual2);
    }

    @Test
    public void collect() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        ShortToObjectFunction<Short> function = parameter -> (short) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((short) 1, (short) 2, (short) 3, (short) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((short) 2), this.newWithKeysValues(1.0, (short) 1).collect(function));
    }

    @Test
    public void count() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals(2, map.count(ShortPredicates.greaterThan((short) 1)));
        Assert.assertEquals(2, map.count(ShortPredicates.lessThan((short) 2)));
    }

    @Test
    public void detectIfNone_value() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        short resultNotFound = map.detectIfNone(ShortPredicates.greaterThan((short) 5), (short) 5);
        Assert.assertEquals((short) 5, resultNotFound);
        Assert.assertEquals((short) 5, this.getEmptyMap().detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 5, this.newWithKeysValues(1.0, (short) 1).detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 1, this.newWithKeysValues(1.0, (short) 1).detectIfNone(ShortPredicates.equal((short) 1), (short) 5));
        Assert.assertEquals((short) 0, map.detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 1, map.detectIfNone(ShortPredicates.equal((short) 1), (short) 5));
        Assert.assertEquals((short) 2, map.detectIfNone(ShortPredicates.equal((short) 2), (short) 5));
    }

    @Test
    public void anySatisfy() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, (short) 1).anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, (short) 1).anySatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertFalse(map.anySatisfy(ShortPredicates.greaterThan((short) 5)));
    }

    @Test
    public void allSatisfy() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, (short) 1).allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, (short) 1).allSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertTrue(map.allSatisfy(ShortPredicates.lessThan((short) 5)));
        DoubleShortMap map1 = this.newWithKeysValues(2.0, (short) 2, 3.0, (short) 3);
        Assert.assertFalse(map1.allSatisfy(ShortPredicates.equal((short) 0)));
    }

    @Test
    public void noneSatisfy() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, (short) 1).noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, (short) 1).noneSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertTrue(map.noneSatisfy(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void max() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals((short) 3, map.max());
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0, (short) 3).max());
    }

    @Test
    public void min() {
        DoubleShortMap map = this.newWithKeysValues(1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3, 0.0, (short) 0);
        Assert.assertEquals((short) 0, map.min());
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0, (short) 3).min());
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
        DoubleShortMap map = this.newWithKeysValues(1.0, (short) 1, 0.0, (short) 0, 9.0, (short) 9, 7.0, (short) 7);
        Assert.assertEquals(0L, map.minIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0, (short) 3).maxIfEmpty((short) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((short) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((short) 0));
        DoubleShortMap map = this.newWithKeysValues(1.0, (short) 1, 0.0, (short) 0, 9.0, (short) 9, 7.0, (short) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.newWithKeysValues(3.0, (short) 3).minIfEmpty((short) 5));
    }

    @Test
    public void sum() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals((short) 6, map.sum());
        DoubleShortMap map2 = this.newWithKeysValues(2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4);
        Assert.assertEquals((short) 9, map2.sum());
        DoubleShortMap map3 = this.newWithKeysValues(2.0, (short) 2);
        Assert.assertEquals((short) 2, map3.sum());
    }

    @Test
    public void average() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        DoubleShortMap map1 = this.newWithKeysValues(1.0, (short) 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        DoubleShortMap map2 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        DoubleShortMap map3 = this.newWithKeysValues(1.0, (short) 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.newWithKeysValues(0.0, (short) 0).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), this.newWithKeysValues(1.0, (short) 1).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 2), this.newWithKeysValues(2.0, (short) 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2.0, (short) 2, 3.0, (short) 3).toList().equals(ShortArrayList.newListWith((short) 2, (short) 3)) || this.newWithKeysValues(2.0, (short) 2, 3.0, (short) 3).toList().equals(ShortArrayList.newListWith((short) 3, (short) 2)));
    }

    @Test
    public void toSortedList() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3), map.toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), this.newWithKeysValues(1.0, (short) 1).toSortedList());
    }

    @Test
    public void toSet() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 3), map.toSet());
        Assert.assertEquals(ShortHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), this.newWithKeysValues(1.0, (short) 1).toSet());
    }

    @Test
    public void toBag() {
        DoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2, (short) 3), map.toBag());
        Assert.assertEquals(ShortHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), this.newWithKeysValues(1.0, (short) 1).toBag());
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
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 31.0, 32.0), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<DoubleShortPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((double key, short value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new short[] { (short) 0, (short) 31, (short) 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        DoubleShortMap map = this.newWithKeysValues(1.0, (short) 1, 2.0, (short) 2);
        short[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new short[] { (short) 1, (short) 2 }, array) || Arrays.equals(new short[] { (short) 2, (short) 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new short[] { (short) 1 }, this.newWithKeysValues(1.0, (short) 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableDoubleShortMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        ShortIterable iterable = this.newWithKeysValues(1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3);
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1), ShortBags.mutable.with((short) 2), ShortBags.mutable.with((short) 3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2), ShortBags.mutable.with((short) 3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ShortBags.mutable.with((short) 2, (short) 3), ShortBags.mutable.with((short) 1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 3), ShortBags.mutable.with((short) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(ShortBags.mutable.with((short) 1)).toSet(), this.newWithKeysValues(1.0, (short) 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1.0, (short) 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractDoubleShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractDoubleShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleShortMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractDoubleShortMapTestCase::keySet;
            this.payloads.values = AbstractDoubleShortMapTestCase::values;
            this.payloads.get = AbstractDoubleShortMapTestCase::get;
            this.payloads.getIfAbsent = AbstractDoubleShortMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractDoubleShortMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractDoubleShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractDoubleShortMapTestCase::containsValue;
            this.payloads.contains = AbstractDoubleShortMapTestCase::contains;
            this.payloads.containsAll = AbstractDoubleShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractDoubleShortMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractDoubleShortMapTestCase::size;
            this.payloads.isEmpty = AbstractDoubleShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractDoubleShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractDoubleShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractDoubleShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractDoubleShortMapTestCase::testToString;
            this.payloads.forEach = AbstractDoubleShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractDoubleShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractDoubleShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractDoubleShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractDoubleShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractDoubleShortMapTestCase::makeString;
            this.payloads.appendString = AbstractDoubleShortMapTestCase::appendString;
            this.payloads.select = AbstractDoubleShortMapTestCase::select;
            this.payloads.reject = AbstractDoubleShortMapTestCase::reject;
            this.payloads.select_value = AbstractDoubleShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractDoubleShortMapTestCase::reject_value;
            this.payloads.collect = AbstractDoubleShortMapTestCase::collect;
            this.payloads.count = AbstractDoubleShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractDoubleShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractDoubleShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractDoubleShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractDoubleShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractDoubleShortMapTestCase::max;
            this.payloads.min = AbstractDoubleShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractDoubleShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractDoubleShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractDoubleShortMapTestCase::sum;
            this.payloads.average = AbstractDoubleShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractDoubleShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractDoubleShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractDoubleShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractDoubleShortMapTestCase::toSet;
            this.payloads.toBag = AbstractDoubleShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractDoubleShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractDoubleShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractDoubleShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractDoubleShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractDoubleShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractDoubleShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractDoubleShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractDoubleShortMapTestCase::chunk;
        }
    }
}
