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
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.factory.primitive.ByteLongMaps;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.ByteLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteLongMap;
import org.eclipse.collections.api.map.primitive.MutableByteLongMap;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.ByteLongPair;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteLongHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractByteLongMapTestCase {

    protected final ByteLongMap map = this.classUnderTest();

    protected abstract ByteLongMap classUnderTest();

    protected abstract ByteLongMap newWithKeysValues(byte key1, long value1);

    protected abstract ByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2);

    protected abstract ByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3);

    protected abstract ByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3, byte key4, long value4);

    protected abstract ByteLongMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0), this.newWithKeysValues((byte) 0, 0L).keySet());
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 31, (byte) 32), this.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0L));
        ByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0L));
        Assert.assertTrue(map1.values().contains(31L));
        Assert.assertTrue(map1.values().contains(32L));
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
        Assert.assertEquals(0L, this.map.getIfAbsent((byte) 0, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent((byte) 31, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent((byte) 32, 5L));
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
        Assert.assertTrue(this.map.containsValue(0L));
        Assert.assertTrue(this.map.containsValue(31L));
        Assert.assertTrue(this.map.containsValue(32L));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0L));
        Assert.assertTrue(this.map.contains(31L));
        Assert.assertTrue(this.map.contains(32L));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0L, 31L, 32L));
        Assert.assertFalse(this.map.containsAll(0L, 31L, 35L));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 32L)));
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 35L)));
        Assert.assertTrue(this.map.containsAll(new LongArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, 1L).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, 1L, (byte) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, 0L, (byte) 5, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, 1L, (byte) 0, 0L, (byte) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, 6L, (byte) 5, 5L).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 0, 0L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((byte) 50, 50L).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 0, 0L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((byte) 50, 50L).notEmpty());
    }

    @Test
    public void testEquals() {
        ByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 32, 32L);
        ByteLongMap map2 = this.newWithKeysValues((byte) 32, 32L, (byte) 0, 0L, (byte) 1, 1L);
        ByteLongMap map3 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 2L, (byte) 32, 32L);
        ByteLongMap map4 = this.newWithKeysValues((byte) 0, 1L, (byte) 1, 1L, (byte) 32, 32L);
        ByteLongMap map5 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 32, 33L);
        ByteLongMap map6 = this.newWithKeysValues((byte) 50, 0L, (byte) 60, 1L, (byte) 70, 33L);
        ByteLongMap map7 = this.newWithKeysValues((byte) 50, 0L, (byte) 60, 1L);
        ByteLongMap map8 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        ByteLongMap map9 = this.newWithKeysValues((byte) 0, 0L);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(LongArrayList.newListWith(0L), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, ByteLongMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ByteLongMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 32, 32L).hashCode(), this.newWithKeysValues((byte) 32, 32L, (byte) 0, 0L, (byte) 1, 1L).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 50, 0L, (byte) 60, 1L, (byte) 70, 33L).hashCode(), this.newWithKeysValues((byte) 50, 0L, (byte) 60, 1L, (byte) 70, 33L).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((byte) 1, 2L).hashCode(), this.newWithKeysValues((byte) 1, 2L).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues((byte) 0, 0L).toString());
        Assert.assertEquals("{1=1}", this.newWithKeysValues((byte) 1, 1L).toString());
        Assert.assertEquals("{5=5}", this.newWithKeysValues((byte) 5, 5L).toString());
        ByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        ByteLongMap map2 = this.newWithKeysValues((byte) 1, 1L, (byte) 32, 32L);
        Assert.assertTrue(map2.toString(), "{1=1, 32=32}".equals(map2.toString()) || "{32=32, 1=1}".equals(map2.toString()));
        ByteLongMap map3 = this.newWithKeysValues((byte) 0, 0L, (byte) 32, 32L);
        Assert.assertTrue(map3.toString(), "{0=0, 32=32}".equals(map3.toString()) || "{32=32, 0=0}".equals(map3.toString()));
        ByteLongMap map4 = this.newWithKeysValues((byte) 32, 32L, (byte) 33, 33L);
        Assert.assertTrue(map4.toString(), "{32=32, 33=33}".equals(map4.toString()) || "{33=33, 32=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        ByteLongMap map0 = this.newWithKeysValues((byte) 0, 1L, (byte) 3, 4L);
        long[] sum0 = new long[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ByteLongMap map1 = this.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L);
        long[] sum1 = new long[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ByteLongMap map01 = this.newWithKeysValues((byte) 0, 1L, (byte) 1, 2L);
        long[] sum01 = new long[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ByteLongMap map = this.newWithKeysValues((byte) 3, 4L, (byte) 4, 5L);
        long[] sum = new long[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ByteLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ByteLongMap map3 = this.newWithKeysValues((byte) 1, 2L);
        long[] sum3 = new long[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        ByteLongMap map0 = this.newWithKeysValues((byte) 0, 1L, (byte) 3, 4L);
        long[] sum0 = new long[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ByteLongMap map1 = this.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L);
        long[] sum1 = new long[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ByteLongMap map01 = this.newWithKeysValues((byte) 0, 1L, (byte) 1, 2L);
        long[] sum01 = new long[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ByteLongMap map = this.newWithKeysValues((byte) 3, 4L, (byte) 4, 5L);
        long[] sum = new long[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ByteLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ByteLongMap map3 = this.newWithKeysValues((byte) 1, 2L);
        long[] sum3 = new long[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        ByteLongMap map0 = this.newWithKeysValues((byte) 0, 1L, (byte) 3, 4L);
        byte[] sum0 = new byte[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        ByteLongMap map1 = this.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L);
        byte[] sum1 = new byte[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        ByteLongMap map01 = this.newWithKeysValues((byte) 0, 1L, (byte) 1, 2L);
        byte[] sum01 = new byte[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        ByteLongMap map = this.newWithKeysValues((byte) 3, 4L, (byte) 4, 5L);
        byte[] sum = new byte[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        ByteLongMap map2 = this.getEmptyMap();
        byte[] sum2 = new byte[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ByteLongMap map3 = this.newWithKeysValues((byte) 1, 1L);
        byte[] sum3 = new byte[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        ByteLongMap map0 = this.newWithKeysValues((byte) 0, 1L, (byte) 3, 4L);
        byte[] sumKey0 = new byte[1];
        long[] sumValue0 = new long[1];
        map0.forEachKeyValue((byte eachKey, long eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        ByteLongMap map1 = this.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L);
        byte[] sumKey1 = new byte[1];
        long[] sumValue1 = new long[1];
        map1.forEachKeyValue((byte eachKey, long eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        ByteLongMap map01 = this.newWithKeysValues((byte) 0, 1L, (byte) 1, 2L);
        byte[] sumKey01 = new byte[1];
        long[] sumValue01 = new long[1];
        map01.forEachKeyValue((byte eachKey, long eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        ByteLongMap map = this.newWithKeysValues((byte) 3, 4L, (byte) 4, 5L);
        byte[] sumKey = new byte[1];
        long[] sumValue = new long[1];
        map.forEachKeyValue((byte eachKey, long eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        ByteLongMap map2 = this.getEmptyMap();
        byte[] sumKey2 = new byte[1];
        long[] sumValue2 = new long[1];
        map2.forEachKeyValue((byte eachKey, long eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        ByteLongMap map3 = this.newWithKeysValues((byte) 3, 5L);
        byte[] sumKey3 = new byte[1];
        long[] sumValue3 = new long[1];
        map3.forEachKeyValue((byte eachKey, long eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ByteLongMap map0 = this.newWithKeysValues((byte) 0, 1L, (byte) 3, 4L);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, byte eachKey, long eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        ByteLongMap copy = map0.injectIntoKeyValue(ByteLongMaps.mutable.empty(), MutableByteLongMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues((byte) 0, 0L).makeString());
        Assert.assertEquals("0", this.newWithKeysValues((byte) 0, 0L).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues((byte) 0, 0L).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues((byte) 1, 1L).makeString());
        Assert.assertEquals("5", this.newWithKeysValues((byte) 5, 5L).makeString());
        ByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        ByteLongMap map2 = this.newWithKeysValues((byte) 1, 1L, (byte) 32, 32L);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        ByteLongMap map3 = this.newWithKeysValues((byte) 0, 0L, (byte) 32, 32L);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        ByteLongMap map4 = this.newWithKeysValues((byte) 32, 32L, (byte) 33, 33L);
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
        this.newWithKeysValues((byte) 0, 0L).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((byte) 0, 0L).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((byte) 0, 0L).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((byte) 1, 1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((byte) 5, 5L).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        ByteLongMap map2 = this.newWithKeysValues((byte) 1, 1L, (byte) 32, 32L);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        ByteLongMap map3 = this.newWithKeysValues((byte) 1, 1L, (byte) 32, 32L);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        ByteLongMap actual1 = map.select((byte key, long value) -> key == (byte) 1 || value == 3L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 3, 3L), actual1);
        ByteLongMap actual2 = map.select((byte key, long value) -> key == (byte) 0 || value == 2L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 2, 2L), actual2);
    }

    @Test
    public void reject() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        ByteLongMap actual1 = map.reject((byte key, long value) -> key == (byte) 1 || value == 3L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 2, 2L), actual1);
        ByteLongMap actual2 = map.reject((byte key, long value) -> key == (byte) 0 || value == 2L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 3, 3L), actual2);
    }

    @Test
    public void select_value() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        LongIterable actual1 = map.select(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.select(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void reject_value() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        LongIterable actual1 = map.reject(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.reject(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void collect() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        LongToObjectFunction<Long> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1L, 2L, 3L, 4L), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2L), this.newWithKeysValues((byte) 1, 1L).collect(function));
    }

    @Test
    public void count() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(2, map.count(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(2, map.count(LongPredicates.lessThan(2L)));
    }

    @Test
    public void detectIfNone_value() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        long resultNotFound = map.detectIfNone(LongPredicates.greaterThan(5L), 5L);
        Assert.assertEquals(5L, resultNotFound);
        Assert.assertEquals(5L, this.getEmptyMap().detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(5L, this.newWithKeysValues((byte) 1, 1L).detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, this.newWithKeysValues((byte) 1, 1L).detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(0L, map.detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, map.detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(2L, map.detectIfNone(LongPredicates.equal(2L), 5L));
    }

    @Test
    public void anySatisfy() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1L).anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1L).anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(2L)));
        Assert.assertFalse(map.anySatisfy(LongPredicates.greaterThan(5L)));
    }

    @Test
    public void allSatisfy() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1L).allSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1L).allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.allSatisfy(LongPredicates.lessThan(5L)));
        ByteLongMap map1 = this.newWithKeysValues((byte) 2, 2L, (byte) 3, 3L);
        Assert.assertFalse(map1.allSatisfy(LongPredicates.equal(0L)));
    }

    @Test
    public void noneSatisfy() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((byte) 1, 1L).noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((byte) 1, 1L).noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.noneSatisfy(LongPredicates.lessThan(0L)));
    }

    @Test
    public void max() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(3L, map.max());
        Assert.assertEquals(3L, this.newWithKeysValues((byte) 3, 3L).max());
    }

    @Test
    public void min() {
        ByteLongMap map = this.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 0, 0L);
        Assert.assertEquals(0L, map.min());
        Assert.assertEquals(3L, this.newWithKeysValues((byte) 3, 3L).min());
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
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty(5L));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty(0L));
        ByteLongMap map = this.newWithKeysValues((byte) 1, 1L, (byte) 0, 0L, (byte) 9, 9L, (byte) 7, 7L);
        Assert.assertEquals(0L, map.minIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues((byte) 3, 3L).maxIfEmpty(5L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5L));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0L));
        ByteLongMap map = this.newWithKeysValues((byte) 1, 1L, (byte) 0, 0L, (byte) 9, 9L, (byte) 7, 7L);
        Assert.assertEquals(9L, map.maxIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues((byte) 3, 3L).minIfEmpty(5L));
    }

    @Test
    public void sum() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(6L, map.sum());
        ByteLongMap map2 = this.newWithKeysValues((byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L);
        Assert.assertEquals(9L, map2.sum());
        ByteLongMap map3 = this.newWithKeysValues((byte) 2, 2L);
        Assert.assertEquals(2L, map3.sum());
    }

    @Test
    public void average() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(1.5, map.average(), 0.0);
        ByteLongMap map1 = this.newWithKeysValues((byte) 1, 1L);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(1.5, map.median(), 0.0);
        ByteLongMap map2 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        ByteLongMap map3 = this.newWithKeysValues((byte) 1, 1L);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(LongArrayList.newListWith(0L), this.newWithKeysValues((byte) 0, 0L).toList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues((byte) 1, 1L).toList());
        Assert.assertEquals(LongArrayList.newListWith(2L), this.newWithKeysValues((byte) 2, 2L).toList());
        Assert.assertTrue(this.newWithKeysValues((byte) 2, 2L, (byte) 3, 3L).toList().equals(LongArrayList.newListWith(2L, 3L)) || this.newWithKeysValues((byte) 2, 2L, (byte) 3, 3L).toList().equals(LongArrayList.newListWith(3L, 2L)));
    }

    @Test
    public void toSortedList() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 2L, 3L), map.toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues((byte) 1, 1L).toSortedList());
    }

    @Test
    public void toSet() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 3L), map.toSet());
        Assert.assertEquals(LongHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(LongHashSet.newSetWith(1L), this.newWithKeysValues((byte) 1, 1L).toSet());
    }

    @Test
    public void toBag() {
        ByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 2L, 3L), map.toBag());
        Assert.assertEquals(LongHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(1L), this.newWithKeysValues((byte) 1, 1L).toBag());
    }

    @Test
    public void longIterator() {
        MutableLongSet expected = LongHashSet.newSetWith(0L, 31L, 32L);
        MutableLongSet actual = LongHashSet.newSetWith();
        LongIterator iterator = this.map.longIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().longIterator().next());
    }

    @Test
    public void asLazy() {
        LazyLongIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0L, 31L, 32L));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<ByteLongPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((byte key, long value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new long[] { 0L, 31L, 32L }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        ByteLongMap map = this.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L);
        long[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new long[] { 1L, 2L }, array) || Arrays.equals(new long[] { 2L, 1L }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new long[] { 1L }, this.newWithKeysValues((byte) 1, 1L).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableByteLongMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        LongIterable iterable = this.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L);
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L), LongBags.mutable.with(2L), LongBags.mutable.with(3L)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(LongBags.mutable.with(1L, 2L), LongBags.mutable.with(3L)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(LongBags.mutable.with(2L, 3L), LongBags.mutable.with(1L)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(LongBags.mutable.with(1L, 3L), LongBags.mutable.with(2L)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L)).toSet(), this.newWithKeysValues((byte) 1, 1L).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((byte) 1, 1L).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteLongMapTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractByteLongMapTestCase::keySet;
            this.payloads.values = AbstractByteLongMapTestCase::values;
            this.payloads.get = AbstractByteLongMapTestCase::get;
            this.payloads.getIfAbsent = AbstractByteLongMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractByteLongMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractByteLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractByteLongMapTestCase::containsValue;
            this.payloads.contains = AbstractByteLongMapTestCase::contains;
            this.payloads.containsAll = AbstractByteLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractByteLongMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractByteLongMapTestCase::size;
            this.payloads.isEmpty = AbstractByteLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractByteLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractByteLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractByteLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractByteLongMapTestCase::testToString;
            this.payloads.forEach = AbstractByteLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractByteLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractByteLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractByteLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractByteLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractByteLongMapTestCase::makeString;
            this.payloads.appendString = AbstractByteLongMapTestCase::appendString;
            this.payloads.select = AbstractByteLongMapTestCase::select;
            this.payloads.reject = AbstractByteLongMapTestCase::reject;
            this.payloads.select_value = AbstractByteLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractByteLongMapTestCase::reject_value;
            this.payloads.collect = AbstractByteLongMapTestCase::collect;
            this.payloads.count = AbstractByteLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractByteLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractByteLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractByteLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractByteLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractByteLongMapTestCase::max;
            this.payloads.min = AbstractByteLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractByteLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractByteLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractByteLongMapTestCase::sum;
            this.payloads.average = AbstractByteLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractByteLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractByteLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractByteLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractByteLongMapTestCase::toSet;
            this.payloads.toBag = AbstractByteLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractByteLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractByteLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractByteLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractByteLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractByteLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractByteLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractByteLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractByteLongMapTestCase::chunk;
        }
    }
}
