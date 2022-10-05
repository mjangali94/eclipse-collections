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
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.factory.primitive.DoubleByteMaps;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.map.primitive.DoubleByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleByteMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleByteMap;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.tuple.primitive.DoubleBytePair;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleByteHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractDoubleByteMapTestCase {

    protected final DoubleByteMap map = this.classUnderTest();

    protected abstract DoubleByteMap classUnderTest();

    protected abstract DoubleByteMap newWithKeysValues(double key1, byte value1);

    protected abstract DoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2);

    protected abstract DoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3);

    protected abstract DoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3, double key4, byte value4);

    protected abstract DoubleByteMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0), this.newWithKeysValues(0.0, (byte) 0).keySet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 31.0, 32.0), this.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((byte) 0));
        DoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((byte) 0));
        Assert.assertTrue(map1.values().contains((byte) 31));
        Assert.assertTrue(map1.values().contains((byte) 32));
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0, (byte) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0, (byte) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0, (byte) 5));
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
        Assert.assertTrue(this.map.containsValue((byte) 0));
        Assert.assertTrue(this.map.containsValue((byte) 31));
        Assert.assertTrue(this.map.containsValue((byte) 32));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((byte) 0));
        Assert.assertTrue(this.map.contains((byte) 31));
        Assert.assertTrue(this.map.contains((byte) 32));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll((byte) 0, (byte) 31, (byte) 32));
        Assert.assertFalse(this.map.containsAll((byte) 0, (byte) 31, (byte) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 32)));
        Assert.assertFalse(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 35)));
        Assert.assertTrue(this.map.containsAll(new ByteArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0, (byte) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0, (byte) 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0, (byte) 1, 5.0, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0, (byte) 0, 5.0, (byte) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0, (byte) 1, 0.0, (byte) 0, 5.0, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0, (byte) 6, 5.0, (byte) 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0, (byte) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0, (byte) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0, (byte) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0, (byte) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0, (byte) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0, (byte) 50).notEmpty());
    }

    @Test
    public void testEquals() {
        DoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 32.0, (byte) 32);
        DoubleByteMap map2 = this.newWithKeysValues(32.0, (byte) 32, 0.0, (byte) 0, 1.0, (byte) 1);
        DoubleByteMap map3 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 2, 32.0, (byte) 32);
        DoubleByteMap map4 = this.newWithKeysValues(0.0, (byte) 1, 1.0, (byte) 1, 32.0, (byte) 32);
        DoubleByteMap map5 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 32.0, (byte) 33);
        DoubleByteMap map6 = this.newWithKeysValues(50.0, (byte) 0, 60.0, (byte) 1, 70.0, (byte) 33);
        DoubleByteMap map7 = this.newWithKeysValues(50.0, (byte) 0, 60.0, (byte) 1);
        DoubleByteMap map8 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        DoubleByteMap map9 = this.newWithKeysValues(0.0, (byte) 0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(ByteArrayList.newListWith((byte) 0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, DoubleByteMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, DoubleByteMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 32.0, (byte) 32).hashCode(), this.newWithKeysValues(32.0, (byte) 32, 0.0, (byte) 0, 1.0, (byte) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50.0, (byte) 0, 60.0, (byte) 1, 70.0, (byte) 33).hashCode(), this.newWithKeysValues(50.0, (byte) 0, 60.0, (byte) 1, 70.0, (byte) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1.0, (byte) 2).hashCode(), this.newWithKeysValues(1.0, (byte) 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=0}", this.newWithKeysValues(0.0, (byte) 0).toString());
        Assert.assertEquals("{1.0=1}", this.newWithKeysValues(1.0, (byte) 1).toString());
        Assert.assertEquals("{5.0=5}", this.newWithKeysValues(5.0, (byte) 5).toString());
        DoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        Assert.assertTrue(map1.toString(), "{0.0=0, 1.0=1}".equals(map1.toString()) || "{1.0=1, 0.0=0}".equals(map1.toString()));
        DoubleByteMap map2 = this.newWithKeysValues(1.0, (byte) 1, 32.0, (byte) 32);
        Assert.assertTrue(map2.toString(), "{1.0=1, 32.0=32}".equals(map2.toString()) || "{32.0=32, 1.0=1}".equals(map2.toString()));
        DoubleByteMap map3 = this.newWithKeysValues(0.0, (byte) 0, 32.0, (byte) 32);
        Assert.assertTrue(map3.toString(), "{0.0=0, 32.0=32}".equals(map3.toString()) || "{32.0=32, 0.0=0}".equals(map3.toString()));
        DoubleByteMap map4 = this.newWithKeysValues(32.0, (byte) 32, 33.0, (byte) 33);
        Assert.assertTrue(map4.toString(), "{32.0=32, 33.0=33}".equals(map4.toString()) || "{33.0=33, 32.0=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        DoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 1, 3.0, (byte) 4);
        byte[] sum0 = new byte[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        DoubleByteMap map1 = this.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4);
        byte[] sum1 = new byte[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        DoubleByteMap map01 = this.newWithKeysValues(0.0, (byte) 1, 1.0, (byte) 2);
        byte[] sum01 = new byte[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        DoubleByteMap map = this.newWithKeysValues(3.0, (byte) 4, 4.0, (byte) 5);
        byte[] sum = new byte[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        DoubleByteMap map2 = this.getEmptyMap();
        byte[] sum2 = new byte[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        DoubleByteMap map3 = this.newWithKeysValues(1.0, (byte) 2);
        byte[] sum3 = new byte[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        DoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 1, 3.0, (byte) 4);
        byte[] sum0 = new byte[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        DoubleByteMap map1 = this.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4);
        byte[] sum1 = new byte[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        DoubleByteMap map01 = this.newWithKeysValues(0.0, (byte) 1, 1.0, (byte) 2);
        byte[] sum01 = new byte[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        DoubleByteMap map = this.newWithKeysValues(3.0, (byte) 4, 4.0, (byte) 5);
        byte[] sum = new byte[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        DoubleByteMap map2 = this.getEmptyMap();
        byte[] sum2 = new byte[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        DoubleByteMap map3 = this.newWithKeysValues(1.0, (byte) 2);
        byte[] sum3 = new byte[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        DoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 1, 3.0, (byte) 4);
        double[] sum0 = new double[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3.0, sum0[0], 0.0);
        DoubleByteMap map1 = this.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4);
        double[] sum1 = new double[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4.0, sum1[0], 0.0);
        DoubleByteMap map01 = this.newWithKeysValues(0.0, (byte) 1, 1.0, (byte) 2);
        double[] sum01 = new double[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1.0, sum01[0], 0.0);
        DoubleByteMap map = this.newWithKeysValues(3.0, (byte) 4, 4.0, (byte) 5);
        double[] sum = new double[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7.0, sum[0], 0.0);
        DoubleByteMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        DoubleByteMap map3 = this.newWithKeysValues(1.0, (byte) 1);
        double[] sum3 = new double[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKeyValue() {
        DoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 1, 3.0, (byte) 4);
        double[] sumKey0 = new double[1];
        byte[] sumValue0 = new byte[1];
        map0.forEachKeyValue((double eachKey, byte eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey0[0], 0.0);
        Assert.assertEquals(5L, sumValue0[0]);
        DoubleByteMap map1 = this.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4);
        double[] sumKey1 = new double[1];
        byte[] sumValue1 = new byte[1];
        map1.forEachKeyValue((double eachKey, byte eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4.0, sumKey1[0], 0.0);
        Assert.assertEquals(6L, sumValue1[0]);
        DoubleByteMap map01 = this.newWithKeysValues(0.0, (byte) 1, 1.0, (byte) 2);
        double[] sumKey01 = new double[1];
        byte[] sumValue01 = new byte[1];
        map01.forEachKeyValue((double eachKey, byte eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1.0, sumKey01[0], 0.0);
        Assert.assertEquals(3L, sumValue01[0]);
        DoubleByteMap map = this.newWithKeysValues(3.0, (byte) 4, 4.0, (byte) 5);
        double[] sumKey = new double[1];
        byte[] sumValue = new byte[1];
        map.forEachKeyValue((double eachKey, byte eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7.0, sumKey[0], 0.0);
        Assert.assertEquals(9L, sumValue[0]);
        DoubleByteMap map2 = this.getEmptyMap();
        double[] sumKey2 = new double[1];
        byte[] sumValue2 = new byte[1];
        map2.forEachKeyValue((double eachKey, byte eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0.0, sumKey2[0], 0.0);
        Assert.assertEquals(0L, sumValue2[0]);
        DoubleByteMap map3 = this.newWithKeysValues(3.0, (byte) 5);
        double[] sumKey3 = new double[1];
        byte[] sumValue3 = new byte[1];
        map3.forEachKeyValue((double eachKey, byte eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey3[0], 0.0);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        DoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 1, 3.0, (byte) 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, double eachKey, byte eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        DoubleByteMap copy = map0.injectIntoKeyValue(DoubleByteMaps.mutable.empty(), MutableDoubleByteMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0.0, (byte) 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0.0, (byte) 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0.0, (byte) 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1.0, (byte) 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5.0, (byte) 5).makeString());
        DoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        DoubleByteMap map2 = this.newWithKeysValues(1.0, (byte) 1, 32.0, (byte) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        DoubleByteMap map3 = this.newWithKeysValues(0.0, (byte) 0, 32.0, (byte) 32);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        DoubleByteMap map4 = this.newWithKeysValues(32.0, (byte) 32, 33.0, (byte) 33);
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
        this.newWithKeysValues(0.0, (byte) 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0.0, (byte) 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0.0, (byte) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0, (byte) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0, (byte) 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        DoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        DoubleByteMap map2 = this.newWithKeysValues(1.0, (byte) 1, 32.0, (byte) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        DoubleByteMap map3 = this.newWithKeysValues(1.0, (byte) 1, 32.0, (byte) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        DoubleByteMap actual1 = map.select((double key, byte value) -> Double.compare(key, 1.0) == 0 || value == (byte) 3);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 3.0, (byte) 3), actual1);
        DoubleByteMap actual2 = map.select((double key, byte value) -> Double.compare(key, 0.0) == 0 || value == (byte) 2);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 2.0, (byte) 2), actual2);
    }

    @Test
    public void reject() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        DoubleByteMap actual1 = map.reject((double key, byte value) -> Double.compare(key, 1.0) == 0 || value == (byte) 3);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 2.0, (byte) 2), actual1);
        DoubleByteMap actual2 = map.reject((double key, byte value) -> Double.compare(key, 0.0) == 0 || value == (byte) 2);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 3.0, (byte) 3), actual2);
    }

    @Test
    public void select_value() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        ByteIterable actual1 = map.select(BytePredicates.greaterThan((byte) 1));
        Assert.assertEquals(ByteBags.immutable.with((byte) 2, (byte) 3), actual1);
        ByteIterable actual2 = map.select(BytePredicates.lessThan((byte) 2));
        Assert.assertEquals(ByteBags.immutable.with((byte) 0, (byte) 1), actual2);
    }

    @Test
    public void reject_value() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        ByteIterable actual1 = map.reject(BytePredicates.lessThan((byte) 2));
        Assert.assertEquals(ByteBags.immutable.with((byte) 2, (byte) 3), actual1);
        ByteIterable actual2 = map.reject(BytePredicates.greaterThan((byte) 1));
        Assert.assertEquals(ByteBags.immutable.with((byte) 0, (byte) 1), actual2);
    }

    @Test
    public void collect() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        ByteToObjectFunction<Byte> function = parameter -> (byte) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((byte) 2), this.newWithKeysValues(1.0, (byte) 1).collect(function));
    }

    @Test
    public void count() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals(2, map.count(BytePredicates.greaterThan((byte) 1)));
        Assert.assertEquals(2, map.count(BytePredicates.lessThan((byte) 2)));
    }

    @Test
    public void detectIfNone_value() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        byte resultNotFound = map.detectIfNone(BytePredicates.greaterThan((byte) 5), (byte) 5);
        Assert.assertEquals((byte) 5, resultNotFound);
        Assert.assertEquals((byte) 5, this.getEmptyMap().detectIfNone(BytePredicates.equal((byte) 0), (byte) 5));
        Assert.assertEquals((byte) 5, this.newWithKeysValues(1.0, (byte) 1).detectIfNone(BytePredicates.equal((byte) 0), (byte) 5));
        Assert.assertEquals((byte) 1, this.newWithKeysValues(1.0, (byte) 1).detectIfNone(BytePredicates.equal((byte) 1), (byte) 5));
        Assert.assertEquals((byte) 0, map.detectIfNone(BytePredicates.equal((byte) 0), (byte) 5));
        Assert.assertEquals((byte) 1, map.detectIfNone(BytePredicates.equal((byte) 1), (byte) 5));
        Assert.assertEquals((byte) 2, map.detectIfNone(BytePredicates.equal((byte) 2), (byte) 5));
    }

    @Test
    public void anySatisfy() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, (byte) 1).anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, (byte) 1).anySatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertTrue(map.anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(map.anySatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertTrue(map.anySatisfy(BytePredicates.equal((byte) 2)));
        Assert.assertFalse(map.anySatisfy(BytePredicates.greaterThan((byte) 5)));
    }

    @Test
    public void allSatisfy() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, (byte) 1).allSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, (byte) 1).allSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.allSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(map.allSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.allSatisfy(BytePredicates.equal((byte) 2)));
        Assert.assertTrue(map.allSatisfy(BytePredicates.lessThan((byte) 5)));
        DoubleByteMap map1 = this.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertFalse(map1.allSatisfy(BytePredicates.equal((byte) 0)));
    }

    @Test
    public void noneSatisfy() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, (byte) 1).noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, (byte) 1).noneSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(map.noneSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.noneSatisfy(BytePredicates.equal((byte) 2)));
        Assert.assertTrue(map.noneSatisfy(BytePredicates.lessThan((byte) 0)));
    }

    @Test
    public void max() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals((byte) 3, map.max());
        Assert.assertEquals((byte) 3, this.newWithKeysValues(3.0, (byte) 3).max());
    }

    @Test
    public void min() {
        DoubleByteMap map = this.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 0.0, (byte) 0);
        Assert.assertEquals((byte) 0, map.min());
        Assert.assertEquals((byte) 3, this.newWithKeysValues(3.0, (byte) 3).min());
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
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty((byte) 5));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty((byte) 0));
        DoubleByteMap map = this.newWithKeysValues(1.0, (byte) 1, 0.0, (byte) 0, 9.0, (byte) 9, 7.0, (byte) 7);
        Assert.assertEquals(0L, map.minIfEmpty((byte) 5));
        Assert.assertEquals((byte) 3, this.newWithKeysValues(3.0, (byte) 3).maxIfEmpty((byte) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((byte) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((byte) 0));
        DoubleByteMap map = this.newWithKeysValues(1.0, (byte) 1, 0.0, (byte) 0, 9.0, (byte) 9, 7.0, (byte) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((byte) 5));
        Assert.assertEquals((byte) 3, this.newWithKeysValues(3.0, (byte) 3).minIfEmpty((byte) 5));
    }

    @Test
    public void sum() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals((byte) 6, map.sum());
        DoubleByteMap map2 = this.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);
        Assert.assertEquals((byte) 9, map2.sum());
        DoubleByteMap map3 = this.newWithKeysValues(2.0, (byte) 2);
        Assert.assertEquals((byte) 2, map3.sum());
    }

    @Test
    public void average() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        DoubleByteMap map1 = this.newWithKeysValues(1.0, (byte) 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        DoubleByteMap map2 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        DoubleByteMap map3 = this.newWithKeysValues(1.0, (byte) 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0), this.newWithKeysValues(0.0, (byte) 0).toList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), this.newWithKeysValues(1.0, (byte) 1).toList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 2), this.newWithKeysValues(2.0, (byte) 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3).toList().equals(ByteArrayList.newListWith((byte) 2, (byte) 3)) || this.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3).toList().equals(ByteArrayList.newListWith((byte) 3, (byte) 2)));
    }

    @Test
    public void toSortedList() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3), map.toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), this.newWithKeysValues(1.0, (byte) 1).toSortedList());
    }

    @Test
    public void toSet() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 2, (byte) 3), map.toSet());
        Assert.assertEquals(ByteHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), this.newWithKeysValues(1.0, (byte) 1).toSet());
    }

    @Test
    public void toBag() {
        DoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2, (byte) 3), map.toBag());
        Assert.assertEquals(ByteHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), this.newWithKeysValues(1.0, (byte) 1).toBag());
    }

    @Test
    public void byteIterator() {
        MutableByteSet expected = ByteHashSet.newSetWith((byte) 0, (byte) 31, (byte) 32);
        MutableByteSet actual = ByteHashSet.newSetWith();
        ByteIterator iterator = this.map.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().byteIterator().next());
    }

    @Test
    public void asLazy() {
        LazyByteIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll((byte) 0, (byte) 31, (byte) 32));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 31.0, 32.0), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<DoubleBytePair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((double key, byte value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 31, (byte) 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        DoubleByteMap map = this.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2);
        byte[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 1, (byte) 2 }, array) || Arrays.equals(new byte[] { (byte) 2, (byte) 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 1 }, this.newWithKeysValues(1.0, (byte) 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableDoubleByteMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        ByteIterable iterable = this.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1), ByteBags.mutable.with((byte) 2), ByteBags.mutable.with((byte) 3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2), ByteBags.mutable.with((byte) 3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ByteBags.mutable.with((byte) 2, (byte) 3), ByteBags.mutable.with((byte) 1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 3), ByteBags.mutable.with((byte) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1)).toSet(), this.newWithKeysValues(1.0, (byte) 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1.0, (byte) 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractDoubleByteMapTestCase instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractDoubleByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleByteMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractDoubleByteMapTestCase::keySet;
            this.payloads.values = AbstractDoubleByteMapTestCase::values;
            this.payloads.get = AbstractDoubleByteMapTestCase::get;
            this.payloads.getIfAbsent = AbstractDoubleByteMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractDoubleByteMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractDoubleByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractDoubleByteMapTestCase::containsValue;
            this.payloads.contains = AbstractDoubleByteMapTestCase::contains;
            this.payloads.containsAll = AbstractDoubleByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractDoubleByteMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractDoubleByteMapTestCase::size;
            this.payloads.isEmpty = AbstractDoubleByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractDoubleByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractDoubleByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractDoubleByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractDoubleByteMapTestCase::testToString;
            this.payloads.forEach = AbstractDoubleByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractDoubleByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractDoubleByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractDoubleByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractDoubleByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractDoubleByteMapTestCase::makeString;
            this.payloads.appendString = AbstractDoubleByteMapTestCase::appendString;
            this.payloads.select = AbstractDoubleByteMapTestCase::select;
            this.payloads.reject = AbstractDoubleByteMapTestCase::reject;
            this.payloads.select_value = AbstractDoubleByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractDoubleByteMapTestCase::reject_value;
            this.payloads.collect = AbstractDoubleByteMapTestCase::collect;
            this.payloads.count = AbstractDoubleByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractDoubleByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractDoubleByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractDoubleByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractDoubleByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractDoubleByteMapTestCase::max;
            this.payloads.min = AbstractDoubleByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractDoubleByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractDoubleByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractDoubleByteMapTestCase::sum;
            this.payloads.average = AbstractDoubleByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractDoubleByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractDoubleByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractDoubleByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractDoubleByteMapTestCase::toSet;
            this.payloads.toBag = AbstractDoubleByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractDoubleByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractDoubleByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractDoubleByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractDoubleByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractDoubleByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractDoubleByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractDoubleByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractDoubleByteMapTestCase::chunk;
        }
    }
}
