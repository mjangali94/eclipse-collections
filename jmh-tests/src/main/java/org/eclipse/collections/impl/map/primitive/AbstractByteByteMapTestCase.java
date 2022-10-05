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
import org.eclipse.collections.api.factory.primitive.ByteByteMaps;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.map.primitive.ByteByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteByteMap;
import org.eclipse.collections.api.map.primitive.MutableByteByteMap;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteByteHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractByteByteMapTestCase {

    protected final ByteByteMap map = this.classUnderTest();

    protected abstract ByteByteMap classUnderTest();

    protected abstract ByteByteMap newWithKeysValues(byte key1, byte value1);

    protected abstract ByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2);

    protected abstract ByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3);

    protected abstract ByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3, byte key4, byte value4);

    protected abstract ByteByteMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0), this.newWithKeysValues((byte) 0, (byte) 0).keySet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 31, (byte) 32), this.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((byte) 0));
        ByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((byte) 0));
        Assert.assertTrue(map1.values().contains((byte) 31));
        Assert.assertTrue(map1.values().contains((byte) 32));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get((byte) 0));
        Assert.assertEquals(31L, this.map.get((byte) 31));
        Assert.assertEquals(32L, this.map.get((byte) 32));
        Assert.assertEquals(0L, this.map.get((byte) 1));
        Assert.assertEquals(0L, this.map.get((byte) 33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent((byte) 0, (byte) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent((byte) 31, (byte) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent((byte) 32, (byte) 5));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow((byte) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((byte) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((byte) 32));
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
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, (byte) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, (byte) 1).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, (byte) 1, (byte) 5, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, (byte) 0, (byte) 5, (byte) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 5, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, (byte) 6, (byte) 5, (byte) 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 1, (byte) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 0, (byte) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 50, (byte) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 1, (byte) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 0, (byte) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 50, (byte) 50).notEmpty());
    }

    @Test
    public void testEquals() {
        ByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 32, (byte) 32);
        ByteByteMap map2 = this.newWithKeysValues((byte) 32, (byte) 32, (byte) 0, (byte) 0, (byte) 1, (byte) 1);
        ByteByteMap map3 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 2, (byte) 32, (byte) 32);
        ByteByteMap map4 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 1, (byte) 1, (byte) 32, (byte) 32);
        ByteByteMap map5 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 32, (byte) 33);
        ByteByteMap map6 = this.newWithKeysValues((byte) 50, (byte) 0, (byte) 60, (byte) 1, (byte) 70, (byte) 33);
        ByteByteMap map7 = this.newWithKeysValues((byte) 50, (byte) 0, (byte) 60, (byte) 1);
        ByteByteMap map8 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        ByteByteMap map9 = this.newWithKeysValues((byte) 0, (byte) 0);
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
        Assert.assertEquals(map1, ByteByteMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ByteByteMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 32, (byte) 32).hashCode(), this.newWithKeysValues((byte) 32, (byte) 32, (byte) 0, (byte) 0, (byte) 1, (byte) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 50, (byte) 0, (byte) 60, (byte) 1, (byte) 70, (byte) 33).hashCode(), this.newWithKeysValues((byte) 50, (byte) 0, (byte) 60, (byte) 1, (byte) 70, (byte) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 1, (byte) 2).hashCode(), this.newWithKeysValues((byte) 1, (byte) 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues((byte) 0, (byte) 0).toString());
        Assert.assertEquals("{1=1}", this.newWithKeysValues((byte) 1, (byte) 1).toString());
        Assert.assertEquals("{5=5}", this.newWithKeysValues((byte) 5, (byte) 5).toString());
        ByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        ByteByteMap map2 = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 32, (byte) 32);
        Assert.assertTrue(map2.toString(), "{1=1, 32=32}".equals(map2.toString()) || "{32=32, 1=1}".equals(map2.toString()));
        ByteByteMap map3 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 32, (byte) 32);
        Assert.assertTrue(map3.toString(), "{0=0, 32=32}".equals(map3.toString()) || "{32=32, 0=0}".equals(map3.toString()));
        ByteByteMap map4 = this.newWithKeysValues((byte) 32, (byte) 32, (byte) 33, (byte) 33);
        Assert.assertTrue(map4.toString(), "{32=32, 33=33}".equals(map4.toString()) || "{33=33, 32=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        ByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 3, (byte) 4);
        byte[] sum0 = new byte[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ByteByteMap map1 = this.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        byte[] sum1 = new byte[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ByteByteMap map01 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 1, (byte) 2);
        byte[] sum01 = new byte[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ByteByteMap map = this.newWithKeysValues((byte) 3, (byte) 4, (byte) 4, (byte) 5);
        byte[] sum = new byte[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ByteByteMap map2 = this.getEmptyMap();
        byte[] sum2 = new byte[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ByteByteMap map3 = this.newWithKeysValues((byte) 1, (byte) 2);
        byte[] sum3 = new byte[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        ByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 3, (byte) 4);
        byte[] sum0 = new byte[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ByteByteMap map1 = this.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        byte[] sum1 = new byte[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ByteByteMap map01 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 1, (byte) 2);
        byte[] sum01 = new byte[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ByteByteMap map = this.newWithKeysValues((byte) 3, (byte) 4, (byte) 4, (byte) 5);
        byte[] sum = new byte[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ByteByteMap map2 = this.getEmptyMap();
        byte[] sum2 = new byte[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ByteByteMap map3 = this.newWithKeysValues((byte) 1, (byte) 2);
        byte[] sum3 = new byte[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        ByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 3, (byte) 4);
        byte[] sum0 = new byte[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        ByteByteMap map1 = this.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        byte[] sum1 = new byte[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        ByteByteMap map01 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 1, (byte) 2);
        byte[] sum01 = new byte[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        ByteByteMap map = this.newWithKeysValues((byte) 3, (byte) 4, (byte) 4, (byte) 5);
        byte[] sum = new byte[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        ByteByteMap map2 = this.getEmptyMap();
        byte[] sum2 = new byte[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ByteByteMap map3 = this.newWithKeysValues((byte) 1, (byte) 1);
        byte[] sum3 = new byte[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        ByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 3, (byte) 4);
        byte[] sumKey0 = new byte[1];
        byte[] sumValue0 = new byte[1];
        map0.forEachKeyValue((byte eachKey, byte eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        ByteByteMap map1 = this.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        byte[] sumKey1 = new byte[1];
        byte[] sumValue1 = new byte[1];
        map1.forEachKeyValue((byte eachKey, byte eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        ByteByteMap map01 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 1, (byte) 2);
        byte[] sumKey01 = new byte[1];
        byte[] sumValue01 = new byte[1];
        map01.forEachKeyValue((byte eachKey, byte eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        ByteByteMap map = this.newWithKeysValues((byte) 3, (byte) 4, (byte) 4, (byte) 5);
        byte[] sumKey = new byte[1];
        byte[] sumValue = new byte[1];
        map.forEachKeyValue((byte eachKey, byte eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        ByteByteMap map2 = this.getEmptyMap();
        byte[] sumKey2 = new byte[1];
        byte[] sumValue2 = new byte[1];
        map2.forEachKeyValue((byte eachKey, byte eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        ByteByteMap map3 = this.newWithKeysValues((byte) 3, (byte) 5);
        byte[] sumKey3 = new byte[1];
        byte[] sumValue3 = new byte[1];
        map3.forEachKeyValue((byte eachKey, byte eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 1, (byte) 3, (byte) 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, byte eachKey, byte eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        ByteByteMap copy = map0.injectIntoKeyValue(ByteByteMaps.mutable.empty(), MutableByteByteMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues((byte) 0, (byte) 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues((byte) 0, (byte) 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues((byte) 0, (byte) 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues((byte) 1, (byte) 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues((byte) 5, (byte) 5).makeString());
        ByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        ByteByteMap map2 = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 32, (byte) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        ByteByteMap map3 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 32, (byte) 32);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        ByteByteMap map4 = this.newWithKeysValues((byte) 32, (byte) 32, (byte) 33, (byte) 33);
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
        this.newWithKeysValues((byte) 0, (byte) 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((byte) 0, (byte) 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((byte) 0, (byte) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((byte) 1, (byte) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((byte) 5, (byte) 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        ByteByteMap map2 = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 32, (byte) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        ByteByteMap map3 = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 32, (byte) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        ByteByteMap actual1 = map.select((byte key, byte value) -> key == (byte) 1 || value == (byte) 3);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 3, (byte) 3), actual1);
        ByteByteMap actual2 = map.select((byte key, byte value) -> key == (byte) 0 || value == (byte) 2);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 2, (byte) 2), actual2);
    }

    @Test
    public void reject() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        ByteByteMap actual1 = map.reject((byte key, byte value) -> key == (byte) 1 || value == (byte) 3);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 2, (byte) 2), actual1);
        ByteByteMap actual2 = map.reject((byte key, byte value) -> key == (byte) 0 || value == (byte) 2);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 3, (byte) 3), actual2);
    }

    @Test
    public void select_value() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        ByteIterable actual1 = map.select(BytePredicates.greaterThan((byte) 1));
        Assert.assertEquals(ByteBags.immutable.with((byte) 2, (byte) 3), actual1);
        ByteIterable actual2 = map.select(BytePredicates.lessThan((byte) 2));
        Assert.assertEquals(ByteBags.immutable.with((byte) 0, (byte) 1), actual2);
    }

    @Test
    public void reject_value() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        ByteIterable actual1 = map.reject(BytePredicates.lessThan((byte) 2));
        Assert.assertEquals(ByteBags.immutable.with((byte) 2, (byte) 3), actual1);
        ByteIterable actual2 = map.reject(BytePredicates.greaterThan((byte) 1));
        Assert.assertEquals(ByteBags.immutable.with((byte) 0, (byte) 1), actual2);
    }

    @Test
    public void collect() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        ByteToObjectFunction<Byte> function = parameter -> (byte) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((byte) 2), this.newWithKeysValues((byte) 1, (byte) 1).collect(function));
    }

    @Test
    public void count() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals(2, map.count(BytePredicates.greaterThan((byte) 1)));
        Assert.assertEquals(2, map.count(BytePredicates.lessThan((byte) 2)));
    }

    @Test
    public void detectIfNone_value() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        byte resultNotFound = map.detectIfNone(BytePredicates.greaterThan((byte) 5), (byte) 5);
        Assert.assertEquals((byte) 5, resultNotFound);
        Assert.assertEquals((byte) 5, this.getEmptyMap().detectIfNone(BytePredicates.equal((byte) 0), (byte) 5));
        Assert.assertEquals((byte) 5, this.newWithKeysValues((byte) 1, (byte) 1).detectIfNone(BytePredicates.equal((byte) 0), (byte) 5));
        Assert.assertEquals((byte) 1, this.newWithKeysValues((byte) 1, (byte) 1).detectIfNone(BytePredicates.equal((byte) 1), (byte) 5));
        Assert.assertEquals((byte) 0, map.detectIfNone(BytePredicates.equal((byte) 0), (byte) 5));
        Assert.assertEquals((byte) 1, map.detectIfNone(BytePredicates.equal((byte) 1), (byte) 5));
        Assert.assertEquals((byte) 2, map.detectIfNone(BytePredicates.equal((byte) 2), (byte) 5));
    }

    @Test
    public void anySatisfy() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, (byte) 1).anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, (byte) 1).anySatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertTrue(map.anySatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(map.anySatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertTrue(map.anySatisfy(BytePredicates.equal((byte) 2)));
        Assert.assertFalse(map.anySatisfy(BytePredicates.greaterThan((byte) 5)));
    }

    @Test
    public void allSatisfy() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, (byte) 1).allSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, (byte) 1).allSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.allSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(map.allSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.allSatisfy(BytePredicates.equal((byte) 2)));
        Assert.assertTrue(map.allSatisfy(BytePredicates.lessThan((byte) 5)));
        ByteByteMap map1 = this.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertFalse(map1.allSatisfy(BytePredicates.equal((byte) 0)));
    }

    @Test
    public void noneSatisfy() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, (byte) 1).noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, (byte) 1).noneSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.noneSatisfy(BytePredicates.equal((byte) 0)));
        Assert.assertFalse(map.noneSatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(map.noneSatisfy(BytePredicates.equal((byte) 2)));
        Assert.assertTrue(map.noneSatisfy(BytePredicates.lessThan((byte) 0)));
    }

    @Test
    public void max() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals((byte) 3, map.max());
        Assert.assertEquals((byte) 3, this.newWithKeysValues((byte) 3, (byte) 3).max());
    }

    @Test
    public void min() {
        ByteByteMap map = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 0, (byte) 0);
        Assert.assertEquals((byte) 0, map.min());
        Assert.assertEquals((byte) 3, this.newWithKeysValues((byte) 3, (byte) 3).min());
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
        ByteByteMap map = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 9, (byte) 9, (byte) 7, (byte) 7);
        Assert.assertEquals(0L, map.minIfEmpty((byte) 5));
        Assert.assertEquals((byte) 3, this.newWithKeysValues((byte) 3, (byte) 3).maxIfEmpty((byte) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((byte) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((byte) 0));
        ByteByteMap map = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 9, (byte) 9, (byte) 7, (byte) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((byte) 5));
        Assert.assertEquals((byte) 3, this.newWithKeysValues((byte) 3, (byte) 3).minIfEmpty((byte) 5));
    }

    @Test
    public void sum() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals((byte) 6, map.sum());
        ByteByteMap map2 = this.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        Assert.assertEquals((byte) 9, map2.sum());
        ByteByteMap map3 = this.newWithKeysValues((byte) 2, (byte) 2);
        Assert.assertEquals((byte) 2, map3.sum());
    }

    @Test
    public void average() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        ByteByteMap map1 = this.newWithKeysValues((byte) 1, (byte) 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        ByteByteMap map2 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        ByteByteMap map3 = this.newWithKeysValues((byte) 1, (byte) 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0), this.newWithKeysValues((byte) 0, (byte) 0).toList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), this.newWithKeysValues((byte) 1, (byte) 1).toList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 2), this.newWithKeysValues((byte) 2, (byte) 2).toList());
        Assert.assertTrue(this.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3).toList().equals(ByteArrayList.newListWith((byte) 2, (byte) 3)) || this.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3).toList().equals(ByteArrayList.newListWith((byte) 3, (byte) 2)));
    }

    @Test
    public void toSortedList() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3), map.toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), this.newWithKeysValues((byte) 1, (byte) 1).toSortedList());
    }

    @Test
    public void toSet() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 2, (byte) 3), map.toSet());
        Assert.assertEquals(ByteHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1), this.newWithKeysValues((byte) 1, (byte) 1).toSet());
    }

    @Test
    public void toBag() {
        ByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2, (byte) 3), map.toBag());
        Assert.assertEquals(ByteHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), this.newWithKeysValues((byte) 1, (byte) 1).toBag());
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
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<ByteBytePair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((byte key, byte value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 31, (byte) 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        ByteByteMap map = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2);
        byte[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 1, (byte) 2 }, array) || Arrays.equals(new byte[] { (byte) 2, (byte) 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 1 }, this.newWithKeysValues((byte) 1, (byte) 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableByteByteMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        ByteIterable iterable = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1), ByteBags.mutable.with((byte) 2), ByteBags.mutable.with((byte) 3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2), ByteBags.mutable.with((byte) 3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ByteBags.mutable.with((byte) 2, (byte) 3), ByteBags.mutable.with((byte) 1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 3), ByteBags.mutable.with((byte) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(ByteBags.mutable.with((byte) 1)).toSet(), this.newWithKeysValues((byte) 1, (byte) 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((byte) 1, (byte) 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteByteMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteByteMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractByteByteMapTestCase::keySet;
            this.payloads.values = AbstractByteByteMapTestCase::values;
            this.payloads.get = AbstractByteByteMapTestCase::get;
            this.payloads.getIfAbsent = AbstractByteByteMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractByteByteMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractByteByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractByteByteMapTestCase::containsValue;
            this.payloads.contains = AbstractByteByteMapTestCase::contains;
            this.payloads.containsAll = AbstractByteByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractByteByteMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractByteByteMapTestCase::size;
            this.payloads.isEmpty = AbstractByteByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractByteByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractByteByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractByteByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractByteByteMapTestCase::testToString;
            this.payloads.forEach = AbstractByteByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractByteByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractByteByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractByteByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractByteByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractByteByteMapTestCase::makeString;
            this.payloads.appendString = AbstractByteByteMapTestCase::appendString;
            this.payloads.select = AbstractByteByteMapTestCase::select;
            this.payloads.reject = AbstractByteByteMapTestCase::reject;
            this.payloads.select_value = AbstractByteByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractByteByteMapTestCase::reject_value;
            this.payloads.collect = AbstractByteByteMapTestCase::collect;
            this.payloads.count = AbstractByteByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractByteByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractByteByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractByteByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractByteByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractByteByteMapTestCase::max;
            this.payloads.min = AbstractByteByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractByteByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractByteByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractByteByteMapTestCase::sum;
            this.payloads.average = AbstractByteByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractByteByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractByteByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractByteByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractByteByteMapTestCase::toSet;
            this.payloads.toBag = AbstractByteByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractByteByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractByteByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractByteByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractByteByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractByteByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractByteByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractByteByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractByteByteMapTestCase::chunk;
        }
    }
}
