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
import org.eclipse.collections.api.factory.primitive.LongIntMaps;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.LongIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongIntMap;
import org.eclipse.collections.api.map.primitive.MutableLongIntMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractLongIntMapTestCase {

    protected final LongIntMap map = this.classUnderTest();

    protected abstract LongIntMap classUnderTest();

    protected abstract LongIntMap newWithKeysValues(long key1, int value1);

    protected abstract LongIntMap newWithKeysValues(long key1, int value1, long key2, int value2);

    protected abstract LongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3);

    protected abstract LongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3, long key4, int value4);

    protected abstract LongIntMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L), this.newWithKeysValues(0L, 0).keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L, 31L, 32L), this.newWithKeysValues(0L, 0, 31L, 31, 32L, 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        LongIntMap map = this.newWithKeysValues(0L, 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0));
        LongIntMap map1 = this.newWithKeysValues(0L, 0, 31L, 31, 32L, 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0));
        Assert.assertTrue(map1.values().contains(31));
        Assert.assertTrue(map1.values().contains(32));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0L));
        Assert.assertEquals(31L, this.map.get(31L));
        Assert.assertEquals(32L, this.map.get(32L));
        Assert.assertEquals(0L, this.map.get(1L));
        Assert.assertEquals(0L, this.map.get(33L));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31L, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32L, 5));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0L));
        Assert.assertEquals(31L, this.map.getOrThrow(31L));
        Assert.assertEquals(32L, this.map.getOrThrow(32L));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1L));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33L));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0L));
        Assert.assertTrue(this.map.containsKey(31L));
        Assert.assertTrue(this.map.containsKey(32L));
        Assert.assertFalse(this.map.containsKey(1L));
        Assert.assertFalse(this.map.containsKey(5L));
        Assert.assertFalse(this.map.containsKey(35L));
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
        Assert.assertEquals(1, this.newWithKeysValues(0L, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1L, 1, 5L, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, 0, 5L, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, 1, 0L, 0, 5L, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, 6, 5L, 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1L, 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0L, 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50L, 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1L, 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0L, 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50L, 50).notEmpty());
    }

    @Test
    public void testEquals() {
        LongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1, 32L, 32);
        LongIntMap map2 = this.newWithKeysValues(32L, 32, 0L, 0, 1L, 1);
        LongIntMap map3 = this.newWithKeysValues(0L, 0, 1L, 2, 32L, 32);
        LongIntMap map4 = this.newWithKeysValues(0L, 1, 1L, 1, 32L, 32);
        LongIntMap map5 = this.newWithKeysValues(0L, 0, 1L, 1, 32L, 33);
        LongIntMap map6 = this.newWithKeysValues(50L, 0, 60L, 1, 70L, 33);
        LongIntMap map7 = this.newWithKeysValues(50L, 0, 60L, 1);
        LongIntMap map8 = this.newWithKeysValues(0L, 0, 1L, 1);
        LongIntMap map9 = this.newWithKeysValues(0L, 0);
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
        Assert.assertEquals(map1, LongIntMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, LongIntMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0L, 0, 1L, 1, 32L, 32).hashCode(), this.newWithKeysValues(32L, 32, 0L, 0, 1L, 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50L, 0, 60L, 1, 70L, 33).hashCode(), this.newWithKeysValues(50L, 0, 60L, 1, 70L, 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1L, 2).hashCode(), this.newWithKeysValues(1L, 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues(0L, 0).toString());
        Assert.assertEquals("{1=1}", this.newWithKeysValues(1L, 1).toString());
        Assert.assertEquals("{5=5}", this.newWithKeysValues(5L, 5).toString());
        LongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        LongIntMap map2 = this.newWithKeysValues(1L, 1, 32L, 32);
        Assert.assertTrue(map2.toString(), "{1=1, 32=32}".equals(map2.toString()) || "{32=32, 1=1}".equals(map2.toString()));
        LongIntMap map3 = this.newWithKeysValues(0L, 0, 32L, 32);
        Assert.assertTrue(map3.toString(), "{0=0, 32=32}".equals(map3.toString()) || "{32=32, 0=0}".equals(map3.toString()));
        LongIntMap map4 = this.newWithKeysValues(32L, 32, 33L, 33);
        Assert.assertTrue(map4.toString(), "{32=32, 33=33}".equals(map4.toString()) || "{33=33, 32=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        LongIntMap map0 = this.newWithKeysValues(0L, 1, 3L, 4);
        int[] sum0 = new int[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        LongIntMap map1 = this.newWithKeysValues(1L, 2, 3L, 4);
        int[] sum1 = new int[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        LongIntMap map01 = this.newWithKeysValues(0L, 1, 1L, 2);
        int[] sum01 = new int[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        LongIntMap map = this.newWithKeysValues(3L, 4, 4L, 5);
        int[] sum = new int[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        LongIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        LongIntMap map3 = this.newWithKeysValues(1L, 2);
        int[] sum3 = new int[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        LongIntMap map0 = this.newWithKeysValues(0L, 1, 3L, 4);
        int[] sum0 = new int[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        LongIntMap map1 = this.newWithKeysValues(1L, 2, 3L, 4);
        int[] sum1 = new int[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        LongIntMap map01 = this.newWithKeysValues(0L, 1, 1L, 2);
        int[] sum01 = new int[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        LongIntMap map = this.newWithKeysValues(3L, 4, 4L, 5);
        int[] sum = new int[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        LongIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        LongIntMap map3 = this.newWithKeysValues(1L, 2);
        int[] sum3 = new int[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        LongIntMap map0 = this.newWithKeysValues(0L, 1, 3L, 4);
        long[] sum0 = new long[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        LongIntMap map1 = this.newWithKeysValues(1L, 2, 3L, 4);
        long[] sum1 = new long[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        LongIntMap map01 = this.newWithKeysValues(0L, 1, 1L, 2);
        long[] sum01 = new long[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        LongIntMap map = this.newWithKeysValues(3L, 4, 4L, 5);
        long[] sum = new long[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        LongIntMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        LongIntMap map3 = this.newWithKeysValues(1L, 1);
        long[] sum3 = new long[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        LongIntMap map0 = this.newWithKeysValues(0L, 1, 3L, 4);
        long[] sumKey0 = new long[1];
        int[] sumValue0 = new int[1];
        map0.forEachKeyValue((long eachKey, int eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        LongIntMap map1 = this.newWithKeysValues(1L, 2, 3L, 4);
        long[] sumKey1 = new long[1];
        int[] sumValue1 = new int[1];
        map1.forEachKeyValue((long eachKey, int eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        LongIntMap map01 = this.newWithKeysValues(0L, 1, 1L, 2);
        long[] sumKey01 = new long[1];
        int[] sumValue01 = new int[1];
        map01.forEachKeyValue((long eachKey, int eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        LongIntMap map = this.newWithKeysValues(3L, 4, 4L, 5);
        long[] sumKey = new long[1];
        int[] sumValue = new int[1];
        map.forEachKeyValue((long eachKey, int eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        LongIntMap map2 = this.getEmptyMap();
        long[] sumKey2 = new long[1];
        int[] sumValue2 = new int[1];
        map2.forEachKeyValue((long eachKey, int eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        LongIntMap map3 = this.newWithKeysValues(3L, 5);
        long[] sumKey3 = new long[1];
        int[] sumValue3 = new int[1];
        map3.forEachKeyValue((long eachKey, int eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        LongIntMap map0 = this.newWithKeysValues(0L, 1, 3L, 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, long eachKey, int eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        LongIntMap copy = map0.injectIntoKeyValue(LongIntMaps.mutable.empty(), MutableLongIntMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0L, 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0L, 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0L, 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1L, 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5L, 5).makeString());
        LongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        LongIntMap map2 = this.newWithKeysValues(1L, 1, 32L, 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        LongIntMap map3 = this.newWithKeysValues(0L, 0, 32L, 32);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        LongIntMap map4 = this.newWithKeysValues(32L, 32, 33L, 33);
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
        this.newWithKeysValues(0L, 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0L, 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0L, 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1L, 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5L, 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        LongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        LongIntMap map2 = this.newWithKeysValues(1L, 1, 32L, 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        LongIntMap map3 = this.newWithKeysValues(1L, 1, 32L, 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        LongIntMap actual1 = map.select((long key, int value) -> key == 1L || value == 3);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 3L, 3), actual1);
        LongIntMap actual2 = map.select((long key, int value) -> key == 0L || value == 2);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 2L, 2), actual2);
    }

    @Test
    public void reject() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        LongIntMap actual1 = map.reject((long key, int value) -> key == 1L || value == 3);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 2L, 2), actual1);
        LongIntMap actual2 = map.reject((long key, int value) -> key == 0L || value == 2);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 3L, 3), actual2);
    }

    @Test
    public void select_value() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        IntIterable actual1 = map.select(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.select(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void reject_value() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        IntIterable actual1 = map.reject(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.reject(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void collect() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        IntToObjectFunction<Integer> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1, 2, 3, 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2), this.newWithKeysValues(1L, 1).collect(function));
    }

    @Test
    public void count() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(2, map.count(IntPredicates.greaterThan(1)));
        Assert.assertEquals(2, map.count(IntPredicates.lessThan(2)));
    }

    @Test
    public void detectIfNone_value() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        int resultNotFound = map.detectIfNone(IntPredicates.greaterThan(5), 5);
        Assert.assertEquals(5, resultNotFound);
        Assert.assertEquals(5, this.getEmptyMap().detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(5, this.newWithKeysValues(1L, 1).detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, this.newWithKeysValues(1L, 1).detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(0, map.detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, map.detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(2, map.detectIfNone(IntPredicates.equal(2), 5));
    }

    @Test
    public void anySatisfy() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1L, 1).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1L, 1).anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(2)));
        Assert.assertFalse(map.anySatisfy(IntPredicates.greaterThan(5)));
    }

    @Test
    public void allSatisfy() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1L, 1).allSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1L, 1).allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.allSatisfy(IntPredicates.lessThan(5)));
        LongIntMap map1 = this.newWithKeysValues(2L, 2, 3L, 3);
        Assert.assertFalse(map1.allSatisfy(IntPredicates.equal(0)));
    }

    @Test
    public void noneSatisfy() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1L, 1).noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1L, 1).noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.noneSatisfy(IntPredicates.lessThan(0)));
    }

    @Test
    public void max() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(3, map.max());
        Assert.assertEquals(3, this.newWithKeysValues(3L, 3).max());
    }

    @Test
    public void min() {
        LongIntMap map = this.newWithKeysValues(1L, 1, 2L, 2, 3L, 3, 0L, 0);
        Assert.assertEquals(0, map.min());
        Assert.assertEquals(3, this.newWithKeysValues(3L, 3).min());
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
        LongIntMap map = this.newWithKeysValues(1L, 1, 0L, 0, 9L, 9, 7L, 7);
        Assert.assertEquals(0L, map.minIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues(3L, 3).maxIfEmpty(5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0));
        LongIntMap map = this.newWithKeysValues(1L, 1, 0L, 0, 9L, 9, 7L, 7);
        Assert.assertEquals(9L, map.maxIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues(3L, 3).minIfEmpty(5));
    }

    @Test
    public void sum() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(6, map.sum());
        LongIntMap map2 = this.newWithKeysValues(2L, 2, 3L, 3, 4L, 4);
        Assert.assertEquals(9, map2.sum());
        LongIntMap map3 = this.newWithKeysValues(2L, 2);
        Assert.assertEquals(2, map3.sum());
    }

    @Test
    public void average() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        LongIntMap map1 = this.newWithKeysValues(1L, 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        LongIntMap map2 = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        LongIntMap map3 = this.newWithKeysValues(1L, 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(IntArrayList.newListWith(0), this.newWithKeysValues(0L, 0).toList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues(1L, 1).toList());
        Assert.assertEquals(IntArrayList.newListWith(2), this.newWithKeysValues(2L, 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2L, 2, 3L, 3).toList().equals(IntArrayList.newListWith(2, 3)) || this.newWithKeysValues(2L, 2, 3L, 3).toList().equals(IntArrayList.newListWith(3, 2)));
    }

    @Test
    public void toSortedList() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 2, 3), map.toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues(1L, 1).toSortedList());
    }

    @Test
    public void toSet() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 3), map.toSet());
        Assert.assertEquals(IntHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(IntHashSet.newSetWith(1), this.newWithKeysValues(1L, 1).toSet());
    }

    @Test
    public void toBag() {
        LongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 2, 3), map.toBag());
        Assert.assertEquals(IntHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1), this.newWithKeysValues(1L, 1).toBag());
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
        Assert.assertEquals(LongArrayList.newListWith(0L, 31L, 32L), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<LongIntPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((long key, int value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new int[] { 0, 31, 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        LongIntMap map = this.newWithKeysValues(1L, 1, 2L, 2);
        int[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new int[] { 1, 2 }, array) || Arrays.equals(new int[] { 2, 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new int[] { 1 }, this.newWithKeysValues(1L, 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableLongIntMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        IntIterable iterable = this.newWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1), IntBags.mutable.with(2), IntBags.mutable.with(3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(IntBags.mutable.with(1, 2), IntBags.mutable.with(3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(IntBags.mutable.with(2, 3), IntBags.mutable.with(1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(IntBags.mutable.with(1, 3), IntBags.mutable.with(2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1)).toSet(), this.newWithKeysValues(1L, 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1L, 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLongIntMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLongIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongIntMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractLongIntMapTestCase::keySet;
            this.payloads.values = AbstractLongIntMapTestCase::values;
            this.payloads.get = AbstractLongIntMapTestCase::get;
            this.payloads.getIfAbsent = AbstractLongIntMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractLongIntMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractLongIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractLongIntMapTestCase::containsValue;
            this.payloads.contains = AbstractLongIntMapTestCase::contains;
            this.payloads.containsAll = AbstractLongIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractLongIntMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractLongIntMapTestCase::size;
            this.payloads.isEmpty = AbstractLongIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLongIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractLongIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractLongIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractLongIntMapTestCase::testToString;
            this.payloads.forEach = AbstractLongIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractLongIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractLongIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractLongIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractLongIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractLongIntMapTestCase::makeString;
            this.payloads.appendString = AbstractLongIntMapTestCase::appendString;
            this.payloads.select = AbstractLongIntMapTestCase::select;
            this.payloads.reject = AbstractLongIntMapTestCase::reject;
            this.payloads.select_value = AbstractLongIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractLongIntMapTestCase::reject_value;
            this.payloads.collect = AbstractLongIntMapTestCase::collect;
            this.payloads.count = AbstractLongIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractLongIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractLongIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLongIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLongIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractLongIntMapTestCase::max;
            this.payloads.min = AbstractLongIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractLongIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLongIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractLongIntMapTestCase::sum;
            this.payloads.average = AbstractLongIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractLongIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractLongIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractLongIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractLongIntMapTestCase::toSet;
            this.payloads.toBag = AbstractLongIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractLongIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractLongIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractLongIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractLongIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractLongIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractLongIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractLongIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractLongIntMapTestCase::chunk;
        }
    }
}
