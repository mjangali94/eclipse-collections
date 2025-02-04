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
import org.eclipse.collections.api.factory.primitive.IntLongMaps;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.IntLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntLongMap;
import org.eclipse.collections.api.map.primitive.MutableIntLongMap;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.IntLongPair;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntLongHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractIntLongMapTestCase {

    protected final IntLongMap map = this.classUnderTest();

    protected abstract IntLongMap classUnderTest();

    protected abstract IntLongMap newWithKeysValues(int key1, long value1);

    protected abstract IntLongMap newWithKeysValues(int key1, long value1, int key2, long value2);

    protected abstract IntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3);

    protected abstract IntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3, int key4, long value4);

    protected abstract IntLongMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(IntHashSet.newSetWith(0), this.newWithKeysValues(0, 0L).keySet());
        Assert.assertEquals(IntHashSet.newSetWith(0, 31, 32), this.newWithKeysValues(0, 0L, 31, 31L, 32, 32L).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        IntLongMap map = this.newWithKeysValues(0, 0L);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0L));
        IntLongMap map1 = this.newWithKeysValues(0, 0L, 31, 31L, 32, 32L);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0L));
        Assert.assertTrue(map1.values().contains(31L));
        Assert.assertTrue(map1.values().contains(32L));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0));
        Assert.assertEquals(31L, this.map.get(31));
        Assert.assertEquals(32L, this.map.get(32));
        Assert.assertEquals(0L, this.map.get(1));
        Assert.assertEquals(0L, this.map.get(33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent(31, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent(32, 5L));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0));
        Assert.assertEquals(31L, this.map.getOrThrow(31));
        Assert.assertEquals(32L, this.map.getOrThrow(32));
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
        Assert.assertEquals(1, this.newWithKeysValues(0, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues(1, 1L).size());
        Assert.assertEquals(2, this.newWithKeysValues(1, 1L, 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues(0, 0L, 5, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues(1, 1L, 0, 0L, 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues(6, 6L, 5, 5L).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, 1L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, 0L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, 50L).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, 1L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, 0L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, 50L).notEmpty());
    }

    @Test
    public void testEquals() {
        IntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L, 32, 32L);
        IntLongMap map2 = this.newWithKeysValues(32, 32L, 0, 0L, 1, 1L);
        IntLongMap map3 = this.newWithKeysValues(0, 0L, 1, 2L, 32, 32L);
        IntLongMap map4 = this.newWithKeysValues(0, 1L, 1, 1L, 32, 32L);
        IntLongMap map5 = this.newWithKeysValues(0, 0L, 1, 1L, 32, 33L);
        IntLongMap map6 = this.newWithKeysValues(50, 0L, 60, 1L, 70, 33L);
        IntLongMap map7 = this.newWithKeysValues(50, 0L, 60, 1L);
        IntLongMap map8 = this.newWithKeysValues(0, 0L, 1, 1L);
        IntLongMap map9 = this.newWithKeysValues(0, 0L);
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
        Assert.assertEquals(map1, IntLongMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, IntLongMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0L, 1, 1L, 32, 32L).hashCode(), this.newWithKeysValues(32, 32L, 0, 0L, 1, 1L).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, 0L, 60, 1L, 70, 33L).hashCode(), this.newWithKeysValues(50, 0L, 60, 1L, 70, 33L).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 2L).hashCode(), this.newWithKeysValues(1, 2L).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues(0, 0L).toString());
        Assert.assertEquals("{1=1}", this.newWithKeysValues(1, 1L).toString());
        Assert.assertEquals("{5=5}", this.newWithKeysValues(5, 5L).toString());
        IntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        IntLongMap map2 = this.newWithKeysValues(1, 1L, 32, 32L);
        Assert.assertTrue(map2.toString(), "{1=1, 32=32}".equals(map2.toString()) || "{32=32, 1=1}".equals(map2.toString()));
        IntLongMap map3 = this.newWithKeysValues(0, 0L, 32, 32L);
        Assert.assertTrue(map3.toString(), "{0=0, 32=32}".equals(map3.toString()) || "{32=32, 0=0}".equals(map3.toString()));
        IntLongMap map4 = this.newWithKeysValues(32, 32L, 33, 33L);
        Assert.assertTrue(map4.toString(), "{32=32, 33=33}".equals(map4.toString()) || "{33=33, 32=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        IntLongMap map0 = this.newWithKeysValues(0, 1L, 3, 4L);
        long[] sum0 = new long[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        IntLongMap map1 = this.newWithKeysValues(1, 2L, 3, 4L);
        long[] sum1 = new long[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        IntLongMap map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        long[] sum01 = new long[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        IntLongMap map = this.newWithKeysValues(3, 4L, 4, 5L);
        long[] sum = new long[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        IntLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        IntLongMap map3 = this.newWithKeysValues(1, 2L);
        long[] sum3 = new long[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        IntLongMap map0 = this.newWithKeysValues(0, 1L, 3, 4L);
        long[] sum0 = new long[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        IntLongMap map1 = this.newWithKeysValues(1, 2L, 3, 4L);
        long[] sum1 = new long[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        IntLongMap map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        long[] sum01 = new long[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        IntLongMap map = this.newWithKeysValues(3, 4L, 4, 5L);
        long[] sum = new long[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        IntLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        IntLongMap map3 = this.newWithKeysValues(1, 2L);
        long[] sum3 = new long[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        IntLongMap map0 = this.newWithKeysValues(0, 1L, 3, 4L);
        int[] sum0 = new int[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        IntLongMap map1 = this.newWithKeysValues(1, 2L, 3, 4L);
        int[] sum1 = new int[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        IntLongMap map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        int[] sum01 = new int[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        IntLongMap map = this.newWithKeysValues(3, 4L, 4, 5L);
        int[] sum = new int[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        IntLongMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        IntLongMap map3 = this.newWithKeysValues(1, 1L);
        int[] sum3 = new int[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        IntLongMap map0 = this.newWithKeysValues(0, 1L, 3, 4L);
        int[] sumKey0 = new int[1];
        long[] sumValue0 = new long[1];
        map0.forEachKeyValue((int eachKey, long eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        IntLongMap map1 = this.newWithKeysValues(1, 2L, 3, 4L);
        int[] sumKey1 = new int[1];
        long[] sumValue1 = new long[1];
        map1.forEachKeyValue((int eachKey, long eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        IntLongMap map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        int[] sumKey01 = new int[1];
        long[] sumValue01 = new long[1];
        map01.forEachKeyValue((int eachKey, long eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        IntLongMap map = this.newWithKeysValues(3, 4L, 4, 5L);
        int[] sumKey = new int[1];
        long[] sumValue = new long[1];
        map.forEachKeyValue((int eachKey, long eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        IntLongMap map2 = this.getEmptyMap();
        int[] sumKey2 = new int[1];
        long[] sumValue2 = new long[1];
        map2.forEachKeyValue((int eachKey, long eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        IntLongMap map3 = this.newWithKeysValues(3, 5L);
        int[] sumKey3 = new int[1];
        long[] sumValue3 = new long[1];
        map3.forEachKeyValue((int eachKey, long eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        IntLongMap map0 = this.newWithKeysValues(0, 1L, 3, 4L);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, int eachKey, long eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        IntLongMap copy = map0.injectIntoKeyValue(IntLongMaps.mutable.empty(), MutableIntLongMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0, 0L).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0, 0L).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0, 0L).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1, 1L).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5, 5L).makeString());
        IntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        IntLongMap map2 = this.newWithKeysValues(1, 1L, 32, 32L);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        IntLongMap map3 = this.newWithKeysValues(0, 0L, 32, 32L);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        IntLongMap map4 = this.newWithKeysValues(32, 32L, 33, 33L);
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
        this.newWithKeysValues(0, 0L).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0, 0L).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0, 0L).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, 1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5, 5L).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        IntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        IntLongMap map2 = this.newWithKeysValues(1, 1L, 32, 32L);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        IntLongMap map3 = this.newWithKeysValues(1, 1L, 32, 32L);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        IntLongMap actual1 = map.select((int key, long value) -> key == 1 || value == 3L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L, 3, 3L), actual1);
        IntLongMap actual2 = map.select((int key, long value) -> key == 0 || value == 2L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 2, 2L), actual2);
    }

    @Test
    public void reject() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        IntLongMap actual1 = map.reject((int key, long value) -> key == 1 || value == 3L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 2, 2L), actual1);
        IntLongMap actual2 = map.reject((int key, long value) -> key == 0 || value == 2L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L, 3, 3L), actual2);
    }

    @Test
    public void select_value() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        LongIterable actual1 = map.select(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.select(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void reject_value() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        LongIterable actual1 = map.reject(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.reject(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void collect() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        LongToObjectFunction<Long> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1L, 2L, 3L, 4L), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2L), this.newWithKeysValues(1, 1L).collect(function));
    }

    @Test
    public void count() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(2, map.count(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(2, map.count(LongPredicates.lessThan(2L)));
    }

    @Test
    public void detectIfNone_value() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        long resultNotFound = map.detectIfNone(LongPredicates.greaterThan(5L), 5L);
        Assert.assertEquals(5L, resultNotFound);
        Assert.assertEquals(5L, this.getEmptyMap().detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(5L, this.newWithKeysValues(1, 1L).detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, this.newWithKeysValues(1, 1L).detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(0L, map.detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, map.detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(2L, map.detectIfNone(LongPredicates.equal(2L), 5L));
    }

    @Test
    public void anySatisfy() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues(1, 1L).anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues(1, 1L).anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(2L)));
        Assert.assertFalse(map.anySatisfy(LongPredicates.greaterThan(5L)));
    }

    @Test
    public void allSatisfy() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues(1, 1L).allSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues(1, 1L).allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.allSatisfy(LongPredicates.lessThan(5L)));
        IntLongMap map1 = this.newWithKeysValues(2, 2L, 3, 3L);
        Assert.assertFalse(map1.allSatisfy(LongPredicates.equal(0L)));
    }

    @Test
    public void noneSatisfy() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues(1, 1L).noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues(1, 1L).noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.noneSatisfy(LongPredicates.lessThan(0L)));
    }

    @Test
    public void max() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(3L, map.max());
        Assert.assertEquals(3L, this.newWithKeysValues(3, 3L).max());
    }

    @Test
    public void min() {
        IntLongMap map = this.newWithKeysValues(1, 1L, 2, 2L, 3, 3L, 0, 0L);
        Assert.assertEquals(0L, map.min());
        Assert.assertEquals(3L, this.newWithKeysValues(3, 3L).min());
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
        IntLongMap map = this.newWithKeysValues(1, 1L, 0, 0L, 9, 9L, 7, 7L);
        Assert.assertEquals(0L, map.minIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues(3, 3L).maxIfEmpty(5L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5L));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0L));
        IntLongMap map = this.newWithKeysValues(1, 1L, 0, 0L, 9, 9L, 7, 7L);
        Assert.assertEquals(9L, map.maxIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues(3, 3L).minIfEmpty(5L));
    }

    @Test
    public void sum() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(6L, map.sum());
        IntLongMap map2 = this.newWithKeysValues(2, 2L, 3, 3L, 4, 4L);
        Assert.assertEquals(9L, map2.sum());
        IntLongMap map3 = this.newWithKeysValues(2, 2L);
        Assert.assertEquals(2L, map3.sum());
    }

    @Test
    public void average() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(1.5, map.average(), 0.0);
        IntLongMap map1 = this.newWithKeysValues(1, 1L);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(1.5, map.median(), 0.0);
        IntLongMap map2 = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        IntLongMap map3 = this.newWithKeysValues(1, 1L);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(LongArrayList.newListWith(0L), this.newWithKeysValues(0, 0L).toList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues(1, 1L).toList());
        Assert.assertEquals(LongArrayList.newListWith(2L), this.newWithKeysValues(2, 2L).toList());
        Assert.assertTrue(this.newWithKeysValues(2, 2L, 3, 3L).toList().equals(LongArrayList.newListWith(2L, 3L)) || this.newWithKeysValues(2, 2L, 3, 3L).toList().equals(LongArrayList.newListWith(3L, 2L)));
    }

    @Test
    public void toSortedList() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 2L, 3L), map.toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues(1, 1L).toSortedList());
    }

    @Test
    public void toSet() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 3L), map.toSet());
        Assert.assertEquals(LongHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(LongHashSet.newSetWith(1L), this.newWithKeysValues(1, 1L).toSet());
    }

    @Test
    public void toBag() {
        IntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 2L, 3L), map.toBag());
        Assert.assertEquals(LongHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(1L), this.newWithKeysValues(1, 1L).toBag());
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
        Assert.assertEquals(IntArrayList.newListWith(0, 31, 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<IntLongPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((int key, long value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new long[] { 0L, 31L, 32L }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        IntLongMap map = this.newWithKeysValues(1, 1L, 2, 2L);
        long[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new long[] { 1L, 2L }, array) || Arrays.equals(new long[] { 2L, 1L }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new long[] { 1L }, this.newWithKeysValues(1, 1L).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableIntLongMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        LongIterable iterable = this.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L), LongBags.mutable.with(2L), LongBags.mutable.with(3L)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(LongBags.mutable.with(1L, 2L), LongBags.mutable.with(3L)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(LongBags.mutable.with(2L, 3L), LongBags.mutable.with(1L)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(LongBags.mutable.with(1L, 3L), LongBags.mutable.with(2L)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(LongBags.mutable.with(1L)).toSet(), this.newWithKeysValues(1, 1L).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1, 1L).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractIntLongMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractIntLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntLongMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractIntLongMapTestCase::keySet;
            this.payloads.values = AbstractIntLongMapTestCase::values;
            this.payloads.get = AbstractIntLongMapTestCase::get;
            this.payloads.getIfAbsent = AbstractIntLongMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractIntLongMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractIntLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractIntLongMapTestCase::containsValue;
            this.payloads.contains = AbstractIntLongMapTestCase::contains;
            this.payloads.containsAll = AbstractIntLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractIntLongMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractIntLongMapTestCase::size;
            this.payloads.isEmpty = AbstractIntLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractIntLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractIntLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractIntLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractIntLongMapTestCase::testToString;
            this.payloads.forEach = AbstractIntLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractIntLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractIntLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractIntLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractIntLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractIntLongMapTestCase::makeString;
            this.payloads.appendString = AbstractIntLongMapTestCase::appendString;
            this.payloads.select = AbstractIntLongMapTestCase::select;
            this.payloads.reject = AbstractIntLongMapTestCase::reject;
            this.payloads.select_value = AbstractIntLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractIntLongMapTestCase::reject_value;
            this.payloads.collect = AbstractIntLongMapTestCase::collect;
            this.payloads.count = AbstractIntLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractIntLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractIntLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractIntLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractIntLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractIntLongMapTestCase::max;
            this.payloads.min = AbstractIntLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractIntLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractIntLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractIntLongMapTestCase::sum;
            this.payloads.average = AbstractIntLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractIntLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractIntLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractIntLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractIntLongMapTestCase::toSet;
            this.payloads.toBag = AbstractIntLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractIntLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractIntLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractIntLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractIntLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractIntLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractIntLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractIntLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractIntLongMapTestCase::chunk;
        }
    }
}
