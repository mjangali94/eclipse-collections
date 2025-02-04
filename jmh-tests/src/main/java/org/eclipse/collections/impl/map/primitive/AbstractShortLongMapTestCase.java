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
import org.eclipse.collections.api.factory.primitive.ShortLongMaps;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.ShortLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.ShortLongPair;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractShortLongMapTestCase {

    protected final ShortLongMap map = this.classUnderTest();

    protected abstract ShortLongMap classUnderTest();

    protected abstract ShortLongMap newWithKeysValues(short key1, long value1);

    protected abstract ShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2);

    protected abstract ShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3);

    protected abstract ShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4);

    protected abstract ShortLongMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0), this.newWithKeysValues((short) 0, 0L).keySet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 31, (short) 32), this.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0L));
        ShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0L));
        Assert.assertTrue(map1.values().contains(31L));
        Assert.assertTrue(map1.values().contains(32L));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get((short) 0));
        Assert.assertEquals(31L, this.map.get((short) 31));
        Assert.assertEquals(32L, this.map.get((short) 32));
        Assert.assertEquals(0L, this.map.get((short) 1));
        Assert.assertEquals(0L, this.map.get((short) 33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent((short) 0, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent((short) 31, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent((short) 32, 5L));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow((short) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((short) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((short) 32));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 1));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey((short) 0));
        Assert.assertTrue(this.map.containsKey((short) 31));
        Assert.assertTrue(this.map.containsKey((short) 32));
        Assert.assertFalse(this.map.containsKey((short) 1));
        Assert.assertFalse(this.map.containsKey((short) 5));
        Assert.assertFalse(this.map.containsKey((short) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, 1L).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 1, 1L, (short) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, 0L, (short) 5, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, 1L, (short) 0, 0L, (short) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, 6L, (short) 5, 5L).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 0, 0L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 50, 50L).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 0, 0L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 50, 50L).notEmpty());
    }

    @Test
    public void testEquals() {
        ShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 32, 32L);
        ShortLongMap map2 = this.newWithKeysValues((short) 32, 32L, (short) 0, 0L, (short) 1, 1L);
        ShortLongMap map3 = this.newWithKeysValues((short) 0, 0L, (short) 1, 2L, (short) 32, 32L);
        ShortLongMap map4 = this.newWithKeysValues((short) 0, 1L, (short) 1, 1L, (short) 32, 32L);
        ShortLongMap map5 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 32, 33L);
        ShortLongMap map6 = this.newWithKeysValues((short) 50, 0L, (short) 60, 1L, (short) 70, 33L);
        ShortLongMap map7 = this.newWithKeysValues((short) 50, 0L, (short) 60, 1L);
        ShortLongMap map8 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        ShortLongMap map9 = this.newWithKeysValues((short) 0, 0L);
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
        Assert.assertEquals(map1, ShortLongMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ShortLongMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 32, 32L).hashCode(), this.newWithKeysValues((short) 32, 32L, (short) 0, 0L, (short) 1, 1L).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 50, 0L, (short) 60, 1L, (short) 70, 33L).hashCode(), this.newWithKeysValues((short) 50, 0L, (short) 60, 1L, (short) 70, 33L).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 1, 2L).hashCode(), this.newWithKeysValues((short) 1, 2L).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues((short) 0, 0L).toString());
        Assert.assertEquals("{1=1}", this.newWithKeysValues((short) 1, 1L).toString());
        Assert.assertEquals("{5=5}", this.newWithKeysValues((short) 5, 5L).toString());
        ShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        ShortLongMap map2 = this.newWithKeysValues((short) 1, 1L, (short) 32, 32L);
        Assert.assertTrue(map2.toString(), "{1=1, 32=32}".equals(map2.toString()) || "{32=32, 1=1}".equals(map2.toString()));
        ShortLongMap map3 = this.newWithKeysValues((short) 0, 0L, (short) 32, 32L);
        Assert.assertTrue(map3.toString(), "{0=0, 32=32}".equals(map3.toString()) || "{32=32, 0=0}".equals(map3.toString()));
        ShortLongMap map4 = this.newWithKeysValues((short) 32, 32L, (short) 33, 33L);
        Assert.assertTrue(map4.toString(), "{32=32, 33=33}".equals(map4.toString()) || "{33=33, 32=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        ShortLongMap map0 = this.newWithKeysValues((short) 0, 1L, (short) 3, 4L);
        long[] sum0 = new long[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ShortLongMap map1 = this.newWithKeysValues((short) 1, 2L, (short) 3, 4L);
        long[] sum1 = new long[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ShortLongMap map01 = this.newWithKeysValues((short) 0, 1L, (short) 1, 2L);
        long[] sum01 = new long[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ShortLongMap map = this.newWithKeysValues((short) 3, 4L, (short) 4, 5L);
        long[] sum = new long[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ShortLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ShortLongMap map3 = this.newWithKeysValues((short) 1, 2L);
        long[] sum3 = new long[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        ShortLongMap map0 = this.newWithKeysValues((short) 0, 1L, (short) 3, 4L);
        long[] sum0 = new long[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ShortLongMap map1 = this.newWithKeysValues((short) 1, 2L, (short) 3, 4L);
        long[] sum1 = new long[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ShortLongMap map01 = this.newWithKeysValues((short) 0, 1L, (short) 1, 2L);
        long[] sum01 = new long[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ShortLongMap map = this.newWithKeysValues((short) 3, 4L, (short) 4, 5L);
        long[] sum = new long[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ShortLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ShortLongMap map3 = this.newWithKeysValues((short) 1, 2L);
        long[] sum3 = new long[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        ShortLongMap map0 = this.newWithKeysValues((short) 0, 1L, (short) 3, 4L);
        short[] sum0 = new short[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        ShortLongMap map1 = this.newWithKeysValues((short) 1, 2L, (short) 3, 4L);
        short[] sum1 = new short[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        ShortLongMap map01 = this.newWithKeysValues((short) 0, 1L, (short) 1, 2L);
        short[] sum01 = new short[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        ShortLongMap map = this.newWithKeysValues((short) 3, 4L, (short) 4, 5L);
        short[] sum = new short[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        ShortLongMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ShortLongMap map3 = this.newWithKeysValues((short) 1, 1L);
        short[] sum3 = new short[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        ShortLongMap map0 = this.newWithKeysValues((short) 0, 1L, (short) 3, 4L);
        short[] sumKey0 = new short[1];
        long[] sumValue0 = new long[1];
        map0.forEachKeyValue((short eachKey, long eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        ShortLongMap map1 = this.newWithKeysValues((short) 1, 2L, (short) 3, 4L);
        short[] sumKey1 = new short[1];
        long[] sumValue1 = new long[1];
        map1.forEachKeyValue((short eachKey, long eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        ShortLongMap map01 = this.newWithKeysValues((short) 0, 1L, (short) 1, 2L);
        short[] sumKey01 = new short[1];
        long[] sumValue01 = new long[1];
        map01.forEachKeyValue((short eachKey, long eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        ShortLongMap map = this.newWithKeysValues((short) 3, 4L, (short) 4, 5L);
        short[] sumKey = new short[1];
        long[] sumValue = new long[1];
        map.forEachKeyValue((short eachKey, long eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        ShortLongMap map2 = this.getEmptyMap();
        short[] sumKey2 = new short[1];
        long[] sumValue2 = new long[1];
        map2.forEachKeyValue((short eachKey, long eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        ShortLongMap map3 = this.newWithKeysValues((short) 3, 5L);
        short[] sumKey3 = new short[1];
        long[] sumValue3 = new long[1];
        map3.forEachKeyValue((short eachKey, long eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ShortLongMap map0 = this.newWithKeysValues((short) 0, 1L, (short) 3, 4L);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, short eachKey, long eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        ShortLongMap copy = map0.injectIntoKeyValue(ShortLongMaps.mutable.empty(), MutableShortLongMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues((short) 0, 0L).makeString());
        Assert.assertEquals("0", this.newWithKeysValues((short) 0, 0L).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues((short) 0, 0L).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues((short) 1, 1L).makeString());
        Assert.assertEquals("5", this.newWithKeysValues((short) 5, 5L).makeString());
        ShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        ShortLongMap map2 = this.newWithKeysValues((short) 1, 1L, (short) 32, 32L);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        ShortLongMap map3 = this.newWithKeysValues((short) 0, 0L, (short) 32, 32L);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        ShortLongMap map4 = this.newWithKeysValues((short) 32, 32L, (short) 33, 33L);
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
        this.newWithKeysValues((short) 0, 0L).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((short) 0, 0L).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((short) 0, 0L).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((short) 1, 1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((short) 5, 5L).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        ShortLongMap map2 = this.newWithKeysValues((short) 1, 1L, (short) 32, 32L);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        ShortLongMap map3 = this.newWithKeysValues((short) 1, 1L, (short) 32, 32L);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        ShortLongMap actual1 = map.select((short key, long value) -> key == (short) 1 || value == 3L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 3, 3L), actual1);
        ShortLongMap actual2 = map.select((short key, long value) -> key == (short) 0 || value == 2L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 2, 2L), actual2);
    }

    @Test
    public void reject() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        ShortLongMap actual1 = map.reject((short key, long value) -> key == (short) 1 || value == 3L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 2, 2L), actual1);
        ShortLongMap actual2 = map.reject((short key, long value) -> key == (short) 0 || value == 2L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 3, 3L), actual2);
    }

    @Test
    public void select_value() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        LongIterable actual1 = map.select(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.select(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void reject_value() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        LongIterable actual1 = map.reject(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.reject(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void collect() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        LongToObjectFunction<Long> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1L, 2L, 3L, 4L), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2L), this.newWithKeysValues((short) 1, 1L).collect(function));
    }

    @Test
    public void count() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(2, map.count(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(2, map.count(LongPredicates.lessThan(2L)));
    }

    @Test
    public void detectIfNone_value() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        long resultNotFound = map.detectIfNone(LongPredicates.greaterThan(5L), 5L);
        Assert.assertEquals(5L, resultNotFound);
        Assert.assertEquals(5L, this.getEmptyMap().detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(5L, this.newWithKeysValues((short) 1, 1L).detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, this.newWithKeysValues((short) 1, 1L).detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(0L, map.detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, map.detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(2L, map.detectIfNone(LongPredicates.equal(2L), 5L));
    }

    @Test
    public void anySatisfy() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1L).anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1L).anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(2L)));
        Assert.assertFalse(map.anySatisfy(LongPredicates.greaterThan(5L)));
    }

    @Test
    public void allSatisfy() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1L).allSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1L).allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.allSatisfy(LongPredicates.lessThan(5L)));
        ShortLongMap map1 = this.newWithKeysValues((short) 2, 2L, (short) 3, 3L);
        Assert.assertFalse(map1.allSatisfy(LongPredicates.equal(0L)));
    }

    @Test
    public void noneSatisfy() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1L).noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1L).noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.noneSatisfy(LongPredicates.lessThan(0L)));
    }

    @Test
    public void max() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(3L, map.max());
        Assert.assertEquals(3L, this.newWithKeysValues((short) 3, 3L).max());
    }

    @Test
    public void min() {
        ShortLongMap map = this.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L, (short) 0, 0L);
        Assert.assertEquals(0L, map.min());
        Assert.assertEquals(3L, this.newWithKeysValues((short) 3, 3L).min());
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
        ShortLongMap map = this.newWithKeysValues((short) 1, 1L, (short) 0, 0L, (short) 9, 9L, (short) 7, 7L);
        Assert.assertEquals(0L, map.minIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues((short) 3, 3L).maxIfEmpty(5L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5L));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0L));
        ShortLongMap map = this.newWithKeysValues((short) 1, 1L, (short) 0, 0L, (short) 9, 9L, (short) 7, 7L);
        Assert.assertEquals(9L, map.maxIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues((short) 3, 3L).minIfEmpty(5L));
    }

    @Test
    public void sum() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(6L, map.sum());
        ShortLongMap map2 = this.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        Assert.assertEquals(9L, map2.sum());
        ShortLongMap map3 = this.newWithKeysValues((short) 2, 2L);
        Assert.assertEquals(2L, map3.sum());
    }

    @Test
    public void average() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(1.5, map.average(), 0.0);
        ShortLongMap map1 = this.newWithKeysValues((short) 1, 1L);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(1.5, map.median(), 0.0);
        ShortLongMap map2 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        ShortLongMap map3 = this.newWithKeysValues((short) 1, 1L);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(LongArrayList.newListWith(0L), this.newWithKeysValues((short) 0, 0L).toList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues((short) 1, 1L).toList());
        Assert.assertEquals(LongArrayList.newListWith(2L), this.newWithKeysValues((short) 2, 2L).toList());
        Assert.assertTrue(this.newWithKeysValues((short) 2, 2L, (short) 3, 3L).toList().equals(LongArrayList.newListWith(2L, 3L)) || this.newWithKeysValues((short) 2, 2L, (short) 3, 3L).toList().equals(LongArrayList.newListWith(3L, 2L)));
    }

    @Test
    public void toSortedList() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 2L, 3L), map.toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues((short) 1, 1L).toSortedList());
    }

    @Test
    public void toSet() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 3L), map.toSet());
        Assert.assertEquals(LongHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(LongHashSet.newSetWith(1L), this.newWithKeysValues((short) 1, 1L).toSet());
    }

    @Test
    public void toBag() {
        ShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 2L, 3L), map.toBag());
        Assert.assertEquals(LongHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(1L), this.newWithKeysValues((short) 1, 1L).toBag());
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
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<ShortLongPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((short key, long value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new long[] { 0L, 31L, 32L }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        ShortLongMap map = this.newWithKeysValues((short) 1, 1L, (short) 2, 2L);
        long[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new long[] { 1L, 2L }, array) || Arrays.equals(new long[] { 2L, 1L }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new long[] { 1L }, this.newWithKeysValues((short) 1, 1L).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableShortLongMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        LongIterable iterable = this.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L), LongBags.mutable.with(2L), LongBags.mutable.with(3L)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(LongBags.mutable.with(1L, 2L), LongBags.mutable.with(3L)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(LongBags.mutable.with(2L, 3L), LongBags.mutable.with(1L)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(LongBags.mutable.with(1L, 3L), LongBags.mutable.with(2L)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L)).toSet(), this.newWithKeysValues((short) 1, 1L).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((short) 1, 1L).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractShortLongMapTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortLongMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractShortLongMapTestCase::keySet;
            this.payloads.values = AbstractShortLongMapTestCase::values;
            this.payloads.get = AbstractShortLongMapTestCase::get;
            this.payloads.getIfAbsent = AbstractShortLongMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractShortLongMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractShortLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractShortLongMapTestCase::containsValue;
            this.payloads.contains = AbstractShortLongMapTestCase::contains;
            this.payloads.containsAll = AbstractShortLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractShortLongMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractShortLongMapTestCase::size;
            this.payloads.isEmpty = AbstractShortLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractShortLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractShortLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractShortLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractShortLongMapTestCase::testToString;
            this.payloads.forEach = AbstractShortLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractShortLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractShortLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractShortLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractShortLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractShortLongMapTestCase::makeString;
            this.payloads.appendString = AbstractShortLongMapTestCase::appendString;
            this.payloads.select = AbstractShortLongMapTestCase::select;
            this.payloads.reject = AbstractShortLongMapTestCase::reject;
            this.payloads.select_value = AbstractShortLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractShortLongMapTestCase::reject_value;
            this.payloads.collect = AbstractShortLongMapTestCase::collect;
            this.payloads.count = AbstractShortLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractShortLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractShortLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractShortLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractShortLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractShortLongMapTestCase::max;
            this.payloads.min = AbstractShortLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractShortLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractShortLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractShortLongMapTestCase::sum;
            this.payloads.average = AbstractShortLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractShortLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractShortLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractShortLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractShortLongMapTestCase::toSet;
            this.payloads.toBag = AbstractShortLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractShortLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractShortLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractShortLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractShortLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractShortLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractShortLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractShortLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractShortLongMapTestCase::chunk;
        }
    }
}
