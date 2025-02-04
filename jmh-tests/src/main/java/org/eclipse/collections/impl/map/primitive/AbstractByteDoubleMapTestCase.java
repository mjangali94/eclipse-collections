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
import org.eclipse.collections.api.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.map.primitive.ByteDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableByteDoubleMap;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.ByteDoublePair;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteDoubleHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractByteDoubleMapTestCase {

    protected final ByteDoubleMap map = this.classUnderTest();

    protected abstract ByteDoubleMap classUnderTest();

    protected abstract ByteDoubleMap newWithKeysValues(byte key1, double value1);

    protected abstract ByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2);

    protected abstract ByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3);

    protected abstract ByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3, byte key4, double value4);

    protected abstract ByteDoubleMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0), this.newWithKeysValues((byte) 0, 0.0).keySet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 31, (byte) 32), this.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0));
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0));
        Assert.assertTrue(map1.values().contains(31.0));
        Assert.assertTrue(map1.values().contains(32.0));
    }

    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get((byte) 0), 0.0);
        Assert.assertEquals(31.0, this.map.get((byte) 31), 0.0);
        Assert.assertEquals(32.0, this.map.get((byte) 32), 0.0);
        Assert.assertEquals(0.0, this.map.get((byte) 1), 0.0);
        Assert.assertEquals(0.0, this.map.get((byte) 33), 0.0);
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent((byte) 0, 5.0), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent((byte) 31, 5.0), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent((byte) 32, 5.0), 0.0);
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow((byte) 0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow((byte) 31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow((byte) 32), 0.0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 1));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey((byte) 0));
        Assert.assertTrue(this.map.containsKey((byte) 31));
        Assert.assertTrue(this.map.containsKey((byte) 32));
        Assert.assertFalse(this.map.containsKey((byte) 1));
        Assert.assertFalse(this.map.containsKey((byte) 5));
        Assert.assertFalse(this.map.containsKey((byte) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, 0.0).size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, 1.0).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, 1.0, (byte) 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, 0.0, (byte) 5, 5.0).size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, 1.0, (byte) 0, 0.0, (byte) 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, 6.0, (byte) 5, 5.0).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 0, 0.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 50, 50.0).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 0, 0.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 50, 50.0).notEmpty());
    }

    @Test
    public void testEquals() {
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 32, 32.0);
        ByteDoubleMap map2 = this.newWithKeysValues((byte) 32, 32.0, (byte) 0, 0.0, (byte) 1, 1.0);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 2.0, (byte) 32, 32.0);
        ByteDoubleMap map4 = this.newWithKeysValues((byte) 0, 1.0, (byte) 1, 1.0, (byte) 32, 32.0);
        ByteDoubleMap map5 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 32, 33.0);
        ByteDoubleMap map6 = this.newWithKeysValues((byte) 50, 0.0, (byte) 60, 1.0, (byte) 70, 33.0);
        ByteDoubleMap map7 = this.newWithKeysValues((byte) 50, 0.0, (byte) 60, 1.0);
        ByteDoubleMap map8 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        ByteDoubleMap map9 = this.newWithKeysValues((byte) 0, 0.0);
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
        Assert.assertEquals(map1, ByteDoubleMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ByteDoubleMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 32, 32.0).hashCode(), this.newWithKeysValues((byte) 32, 32.0, (byte) 0, 0.0, (byte) 1, 1.0).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 50, 0.0, (byte) 60, 1.0, (byte) 70, 33.0).hashCode(), this.newWithKeysValues((byte) 50, 0.0, (byte) 60, 1.0, (byte) 70, 33.0).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 1, 2.0).hashCode(), this.newWithKeysValues((byte) 1, 2.0).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0.0}", this.newWithKeysValues((byte) 0, 0.0).toString());
        Assert.assertEquals("{1=1.0}", this.newWithKeysValues((byte) 1, 1.0).toString());
        Assert.assertEquals("{5=5.0}", this.newWithKeysValues((byte) 5, 5.0).toString());
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        Assert.assertTrue(map1.toString(), "{0=0.0, 1=1.0}".equals(map1.toString()) || "{1=1.0, 0=0.0}".equals(map1.toString()));
        ByteDoubleMap map2 = this.newWithKeysValues((byte) 1, 1.0, (byte) 32, 32.0);
        Assert.assertTrue(map2.toString(), "{1=1.0, 32=32.0}".equals(map2.toString()) || "{32=32.0, 1=1.0}".equals(map2.toString()));
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 0, 0.0, (byte) 32, 32.0);
        Assert.assertTrue(map3.toString(), "{0=0.0, 32=32.0}".equals(map3.toString()) || "{32=32.0, 0=0.0}".equals(map3.toString()));
        ByteDoubleMap map4 = this.newWithKeysValues((byte) 32, 32.0, (byte) 33, 33.0);
        Assert.assertTrue(map4.toString(), "{32=32.0, 33=33.0}".equals(map4.toString()) || "{33=33.0, 32=32.0}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        ByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 1.0, (byte) 3, 4.0);
        double[] sum0 = new double[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0);
        double[] sum1 = new double[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        ByteDoubleMap map01 = this.newWithKeysValues((byte) 0, 1.0, (byte) 1, 2.0);
        double[] sum01 = new double[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        ByteDoubleMap map = this.newWithKeysValues((byte) 3, 4.0, (byte) 4, 5.0);
        double[] sum = new double[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        ByteDoubleMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 1, 2.0);
        double[] sum3 = new double[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachValue() {
        ByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 1.0, (byte) 3, 4.0);
        double[] sum0 = new double[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0);
        double[] sum1 = new double[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        ByteDoubleMap map01 = this.newWithKeysValues((byte) 0, 1.0, (byte) 1, 2.0);
        double[] sum01 = new double[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        ByteDoubleMap map = this.newWithKeysValues((byte) 3, 4.0, (byte) 4, 5.0);
        double[] sum = new double[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        ByteDoubleMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 1, 2.0);
        double[] sum3 = new double[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKey() {
        ByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 1.0, (byte) 3, 4.0);
        byte[] sum0 = new byte[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0);
        byte[] sum1 = new byte[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        ByteDoubleMap map01 = this.newWithKeysValues((byte) 0, 1.0, (byte) 1, 2.0);
        byte[] sum01 = new byte[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        ByteDoubleMap map = this.newWithKeysValues((byte) 3, 4.0, (byte) 4, 5.0);
        byte[] sum = new byte[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        ByteDoubleMap map2 = this.getEmptyMap();
        byte[] sum2 = new byte[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 1, 1.0);
        byte[] sum3 = new byte[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        ByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 1.0, (byte) 3, 4.0);
        byte[] sumKey0 = new byte[1];
        double[] sumValue0 = new double[1];
        map0.forEachKeyValue((byte eachKey, double eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5.0, sumValue0[0], 0.0);
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0);
        byte[] sumKey1 = new byte[1];
        double[] sumValue1 = new double[1];
        map1.forEachKeyValue((byte eachKey, double eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6.0, sumValue1[0], 0.0);
        ByteDoubleMap map01 = this.newWithKeysValues((byte) 0, 1.0, (byte) 1, 2.0);
        byte[] sumKey01 = new byte[1];
        double[] sumValue01 = new double[1];
        map01.forEachKeyValue((byte eachKey, double eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3.0, sumValue01[0], 0.0);
        ByteDoubleMap map = this.newWithKeysValues((byte) 3, 4.0, (byte) 4, 5.0);
        byte[] sumKey = new byte[1];
        double[] sumValue = new double[1];
        map.forEachKeyValue((byte eachKey, double eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9.0, sumValue[0], 0.0);
        ByteDoubleMap map2 = this.getEmptyMap();
        byte[] sumKey2 = new byte[1];
        double[] sumValue2 = new double[1];
        map2.forEachKeyValue((byte eachKey, double eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0.0, sumValue2[0], 0.0);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 3, 5.0);
        byte[] sumKey3 = new byte[1];
        double[] sumValue3 = new double[1];
        map3.forEachKeyValue((byte eachKey, double eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5.0, sumValue3[0], 0.0);
    }

    @Test
    public void injectIntoKeyValue() {
        ByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 1.0, (byte) 3, 4.0);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, byte eachKey, double eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        ByteDoubleMap copy = map0.injectIntoKeyValue(ByteDoubleMaps.mutable.empty(), MutableByteDoubleMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0.0", this.newWithKeysValues((byte) 0, 0.0).makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues((byte) 0, 0.0).makeString(", "));
        Assert.assertEquals("[0.0]", this.newWithKeysValues((byte) 0, 0.0).makeString("[", "/", "]"));
        Assert.assertEquals("1.0", this.newWithKeysValues((byte) 1, 1.0).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues((byte) 5, 5.0).makeString());
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        Assert.assertTrue(map1.makeString(), "0.0, 1.0".equals(map1.makeString()) || "1.0, 0.0".equals(map1.makeString()));
        ByteDoubleMap map2 = this.newWithKeysValues((byte) 1, 1.0, (byte) 32, 32.0);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1.0/32.0]".equals(map2.makeString("[", "/", "]")) || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 0, 0.0, (byte) 32, 32.0);
        Assert.assertTrue(map3.makeString("~"), "0.0~32.0".equals(map3.makeString("~")) || "32.0~0.0".equals(map3.makeString("~")));
        ByteDoubleMap map4 = this.newWithKeysValues((byte) 32, 32.0, (byte) 33, 33.0);
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
        this.newWithKeysValues((byte) 0, 0.0).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((byte) 0, 0.0).appendString(appendable01, "/");
        Assert.assertEquals("0.0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((byte) 0, 0.0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0.0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((byte) 1, 1.0).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((byte) 5, 5.0).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0.0, 1.0".equals(appendable3.toString()) || "1.0, 0.0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        ByteDoubleMap map2 = this.newWithKeysValues((byte) 1, 1.0, (byte) 32, 32.0);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1.0/32.0]".equals(appendable4.toString()) || "[32.0/1.0]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 1, 1.0, (byte) 32, 32.0);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1.0/32.0]".equals(appendable5.toString()) || "[32.0/1.0]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0.0/1.0".equals(appendable6.toString()) || "1.0/0.0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        ByteDoubleMap actual1 = map.select((byte key, double value) -> key == (byte) 1 || Double.compare(value, 3.0) == 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 3, 3.0), actual1);
        ByteDoubleMap actual2 = map.select((byte key, double value) -> key == (byte) 0 || Double.compare(value, 2.0) == 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 2, 2.0), actual2);
    }

    @Test
    public void reject() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        ByteDoubleMap actual1 = map.reject((byte key, double value) -> key == (byte) 1 || Double.compare(value, 3.0) == 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 2, 2.0), actual1);
        ByteDoubleMap actual2 = map.reject((byte key, double value) -> key == (byte) 0 || Double.compare(value, 2.0) == 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 3, 3.0), actual2);
    }

    @Test
    public void select_value() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        DoubleIterable actual1 = map.select(DoublePredicates.greaterThan(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(2.0, 3.0), actual1);
        DoubleIterable actual2 = map.select(DoublePredicates.lessThan(2.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0, 1.0), actual2);
    }

    @Test
    public void reject_value() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        DoubleIterable actual1 = map.reject(DoublePredicates.lessThan(2.0));
        Assert.assertEquals(DoubleBags.immutable.with(2.0, 3.0), actual1);
        DoubleIterable actual2 = map.reject(DoublePredicates.greaterThan(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0, 1.0), actual2);
    }

    @Test
    public void collect() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        DoubleToObjectFunction<Double> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1.0, 2.0, 3.0, 4.0), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2.0), this.newWithKeysValues((byte) 1, 1.0).collect(function));
    }

    @Test
    public void count() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(2, map.count(DoublePredicates.greaterThan(1.0)));
        Assert.assertEquals(2, map.count(DoublePredicates.lessThan(2.0)));
    }

    @Test
    public void detectIfNone_value() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        double resultNotFound = map.detectIfNone(DoublePredicates.greaterThan(5.0), 5.0);
        Assert.assertEquals(5.0, resultNotFound, 0.0);
        Assert.assertEquals(5.0, this.getEmptyMap().detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(5.0, this.newWithKeysValues((byte) 1, 1.0).detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(1.0, this.newWithKeysValues((byte) 1, 1.0).detectIfNone(DoublePredicates.equal(1.0), 5.0), 0.0);
        Assert.assertEquals(0.0, map.detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(1.0, map.detectIfNone(DoublePredicates.equal(1.0), 5.0), 0.0);
        Assert.assertEquals(2.0, map.detectIfNone(DoublePredicates.equal(2.0), 5.0), 0.0);
    }

    @Test
    public void anySatisfy() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1.0).anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1.0).anySatisfy(DoublePredicates.equal(1.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(1.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(2.0)));
        Assert.assertFalse(map.anySatisfy(DoublePredicates.greaterThan(5.0)));
    }

    @Test
    public void allSatisfy() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1.0).allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1.0).allSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(2.0)));
        Assert.assertTrue(map.allSatisfy(DoublePredicates.lessThan(5.0)));
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertFalse(map1.allSatisfy(DoublePredicates.equal(0.0)));
    }

    @Test
    public void noneSatisfy() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1.0).noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1.0).noneSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(2.0)));
        Assert.assertTrue(map.noneSatisfy(DoublePredicates.lessThan(0.0)));
    }

    @Test
    public void max() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(3.0, map.max(), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues((byte) 3, 3.0).max(), 0.0);
    }

    @Test
    public void min() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 0, 0.0);
        Assert.assertEquals(0.0, map.min(), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues((byte) 3, 3.0).min(), 0.0);
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
        ByteDoubleMap map = this.newWithKeysValues((byte) 1, 1.0, (byte) 0, 0.0, (byte) 9, 9.0, (byte) 7, 7.0);
        Assert.assertEquals(0.0, map.minIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues((byte) 3, 3.0).maxIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, this.getEmptyMap().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().maxIfEmpty(0.0), 0.0);
        ByteDoubleMap map = this.newWithKeysValues((byte) 1, 1.0, (byte) 0, 0.0, (byte) 9, 9.0, (byte) 7, 7.0);
        Assert.assertEquals(9.0, map.maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues((byte) 3, 3.0).minIfEmpty(5.0), 0.0);
    }

    @Test
    public void sum() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(6.0, map.sum(), 0.0);
        ByteDoubleMap map2 = this.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        Assert.assertEquals(9.0, map2.sum(), 0.0);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 2, 2.0);
        Assert.assertEquals(2.0, map3.sum(), 0.0);
    }

    @Test
    public void average() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(1.5, map.average(), 0.0);
        ByteDoubleMap map1 = this.newWithKeysValues((byte) 1, 1.0);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(1.5, map.median(), 0.0);
        ByteDoubleMap map2 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        ByteDoubleMap map3 = this.newWithKeysValues((byte) 1, 1.0);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), this.newWithKeysValues((byte) 0, 0.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), this.newWithKeysValues((byte) 1, 1.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(2.0), this.newWithKeysValues((byte) 2, 2.0).toList());
        Assert.assertTrue(this.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0).toList().equals(DoubleArrayList.newListWith(2.0, 3.0)) || this.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0).toList().equals(DoubleArrayList.newListWith(3.0, 2.0)));
    }

    @Test
    public void toSortedList() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0), map.toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), this.newWithKeysValues((byte) 1, 1.0).toSortedList());
    }

    @Test
    public void toSet() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 3.0), map.toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), this.newWithKeysValues((byte) 1, 1.0).toSet());
    }

    @Test
    public void toBag() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 2.0, 3.0), map.toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), this.newWithKeysValues((byte) 1, 1.0).toBag());
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
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<ByteDoublePair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((byte key, double value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new double[] { 0.0, 31.0, 32.0 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        ByteDoubleMap map = this.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0);
        double[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new double[] { 1.0, 2.0 }, array) || Arrays.equals(new double[] { 2.0, 1.0 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new double[] { 1.0 }, this.newWithKeysValues((byte) 1, 1.0).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableByteDoubleMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        DoubleIterable iterable = this.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0), DoubleBags.mutable.with(2.0), DoubleBags.mutable.with(3.0)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0), DoubleBags.mutable.with(3.0)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(DoubleBags.mutable.with(2.0, 3.0), DoubleBags.mutable.with(1.0)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(DoubleBags.mutable.with(1.0, 3.0), DoubleBags.mutable.with(2.0)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(DoubleBags.mutable.with(1.0)).toSet(), this.newWithKeysValues((byte) 1, 1.0).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((byte) 1, 1.0).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteDoubleMapTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteDoubleMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractByteDoubleMapTestCase::keySet;
            this.payloads.values = AbstractByteDoubleMapTestCase::values;
            this.payloads.get = AbstractByteDoubleMapTestCase::get;
            this.payloads.getIfAbsent = AbstractByteDoubleMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractByteDoubleMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractByteDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractByteDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractByteDoubleMapTestCase::contains;
            this.payloads.containsAll = AbstractByteDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractByteDoubleMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractByteDoubleMapTestCase::size;
            this.payloads.isEmpty = AbstractByteDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractByteDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractByteDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractByteDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractByteDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractByteDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractByteDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractByteDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractByteDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractByteDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractByteDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractByteDoubleMapTestCase::appendString;
            this.payloads.select = AbstractByteDoubleMapTestCase::select;
            this.payloads.reject = AbstractByteDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractByteDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractByteDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractByteDoubleMapTestCase::collect;
            this.payloads.count = AbstractByteDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractByteDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractByteDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractByteDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractByteDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractByteDoubleMapTestCase::max;
            this.payloads.min = AbstractByteDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractByteDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractByteDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractByteDoubleMapTestCase::sum;
            this.payloads.average = AbstractByteDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractByteDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractByteDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractByteDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractByteDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractByteDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractByteDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractByteDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractByteDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractByteDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractByteDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractByteDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractByteDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractByteDoubleMapTestCase::chunk;
        }
    }
}
