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
import org.eclipse.collections.api.factory.primitive.ShortIntMaps;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.ShortIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortIntMap;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractShortIntMapTestCase {

    protected final ShortIntMap map = this.classUnderTest();

    protected abstract ShortIntMap classUnderTest();

    protected abstract ShortIntMap newWithKeysValues(short key1, int value1);

    protected abstract ShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2);

    protected abstract ShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3);

    protected abstract ShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4);

    protected abstract ShortIntMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0), this.newWithKeysValues((short) 0, 0).keySet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 31, (short) 32), this.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ShortIntMap map = this.newWithKeysValues((short) 0, 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0));
        ShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0));
        Assert.assertTrue(map1.values().contains(31));
        Assert.assertTrue(map1.values().contains(32));
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
        Assert.assertEquals(0L, this.map.getIfAbsent((short) 0, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent((short) 31, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent((short) 32, 5));
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
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, 1).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 1, 1, (short) 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, 0, (short) 5, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, 1, (short) 0, 0, (short) 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, 6, (short) 5, 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 0, 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 50, 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 0, 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 50, 50).notEmpty());
    }

    @Test
    public void testEquals() {
        ShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 32, 32);
        ShortIntMap map2 = this.newWithKeysValues((short) 32, 32, (short) 0, 0, (short) 1, 1);
        ShortIntMap map3 = this.newWithKeysValues((short) 0, 0, (short) 1, 2, (short) 32, 32);
        ShortIntMap map4 = this.newWithKeysValues((short) 0, 1, (short) 1, 1, (short) 32, 32);
        ShortIntMap map5 = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 32, 33);
        ShortIntMap map6 = this.newWithKeysValues((short) 50, 0, (short) 60, 1, (short) 70, 33);
        ShortIntMap map7 = this.newWithKeysValues((short) 50, 0, (short) 60, 1);
        ShortIntMap map8 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        ShortIntMap map9 = this.newWithKeysValues((short) 0, 0);
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
        Assert.assertEquals(map1, ShortIntMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ShortIntMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 32, 32).hashCode(), this.newWithKeysValues((short) 32, 32, (short) 0, 0, (short) 1, 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 50, 0, (short) 60, 1, (short) 70, 33).hashCode(), this.newWithKeysValues((short) 50, 0, (short) 60, 1, (short) 70, 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 1, 2).hashCode(), this.newWithKeysValues((short) 1, 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues((short) 0, 0).toString());
        Assert.assertEquals("{1=1}", this.newWithKeysValues((short) 1, 1).toString());
        Assert.assertEquals("{5=5}", this.newWithKeysValues((short) 5, 5).toString());
        ShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        ShortIntMap map2 = this.newWithKeysValues((short) 1, 1, (short) 32, 32);
        Assert.assertTrue(map2.toString(), "{1=1, 32=32}".equals(map2.toString()) || "{32=32, 1=1}".equals(map2.toString()));
        ShortIntMap map3 = this.newWithKeysValues((short) 0, 0, (short) 32, 32);
        Assert.assertTrue(map3.toString(), "{0=0, 32=32}".equals(map3.toString()) || "{32=32, 0=0}".equals(map3.toString()));
        ShortIntMap map4 = this.newWithKeysValues((short) 32, 32, (short) 33, 33);
        Assert.assertTrue(map4.toString(), "{32=32, 33=33}".equals(map4.toString()) || "{33=33, 32=32}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        ShortIntMap map0 = this.newWithKeysValues((short) 0, 1, (short) 3, 4);
        int[] sum0 = new int[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ShortIntMap map1 = this.newWithKeysValues((short) 1, 2, (short) 3, 4);
        int[] sum1 = new int[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ShortIntMap map01 = this.newWithKeysValues((short) 0, 1, (short) 1, 2);
        int[] sum01 = new int[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ShortIntMap map = this.newWithKeysValues((short) 3, 4, (short) 4, 5);
        int[] sum = new int[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ShortIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ShortIntMap map3 = this.newWithKeysValues((short) 1, 2);
        int[] sum3 = new int[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        ShortIntMap map0 = this.newWithKeysValues((short) 0, 1, (short) 3, 4);
        int[] sum0 = new int[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        ShortIntMap map1 = this.newWithKeysValues((short) 1, 2, (short) 3, 4);
        int[] sum1 = new int[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        ShortIntMap map01 = this.newWithKeysValues((short) 0, 1, (short) 1, 2);
        int[] sum01 = new int[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ShortIntMap map = this.newWithKeysValues((short) 3, 4, (short) 4, 5);
        int[] sum = new int[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        ShortIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ShortIntMap map3 = this.newWithKeysValues((short) 1, 2);
        int[] sum3 = new int[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        ShortIntMap map0 = this.newWithKeysValues((short) 0, 1, (short) 3, 4);
        short[] sum0 = new short[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        ShortIntMap map1 = this.newWithKeysValues((short) 1, 2, (short) 3, 4);
        short[] sum1 = new short[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        ShortIntMap map01 = this.newWithKeysValues((short) 0, 1, (short) 1, 2);
        short[] sum01 = new short[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        ShortIntMap map = this.newWithKeysValues((short) 3, 4, (short) 4, 5);
        short[] sum = new short[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        ShortIntMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        ShortIntMap map3 = this.newWithKeysValues((short) 1, 1);
        short[] sum3 = new short[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        ShortIntMap map0 = this.newWithKeysValues((short) 0, 1, (short) 3, 4);
        short[] sumKey0 = new short[1];
        int[] sumValue0 = new int[1];
        map0.forEachKeyValue((short eachKey, int eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        ShortIntMap map1 = this.newWithKeysValues((short) 1, 2, (short) 3, 4);
        short[] sumKey1 = new short[1];
        int[] sumValue1 = new int[1];
        map1.forEachKeyValue((short eachKey, int eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        ShortIntMap map01 = this.newWithKeysValues((short) 0, 1, (short) 1, 2);
        short[] sumKey01 = new short[1];
        int[] sumValue01 = new int[1];
        map01.forEachKeyValue((short eachKey, int eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        ShortIntMap map = this.newWithKeysValues((short) 3, 4, (short) 4, 5);
        short[] sumKey = new short[1];
        int[] sumValue = new int[1];
        map.forEachKeyValue((short eachKey, int eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        ShortIntMap map2 = this.getEmptyMap();
        short[] sumKey2 = new short[1];
        int[] sumValue2 = new int[1];
        map2.forEachKeyValue((short eachKey, int eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        ShortIntMap map3 = this.newWithKeysValues((short) 3, 5);
        short[] sumKey3 = new short[1];
        int[] sumValue3 = new int[1];
        map3.forEachKeyValue((short eachKey, int eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ShortIntMap map0 = this.newWithKeysValues((short) 0, 1, (short) 3, 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, short eachKey, int eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        ShortIntMap copy = map0.injectIntoKeyValue(ShortIntMaps.mutable.empty(), MutableShortIntMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues((short) 0, 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues((short) 0, 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues((short) 0, 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues((short) 1, 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues((short) 5, 5).makeString());
        ShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        Assert.assertTrue(map1.makeString(), "0, 1".equals(map1.makeString()) || "1, 0".equals(map1.makeString()));
        ShortIntMap map2 = this.newWithKeysValues((short) 1, 1, (short) 32, 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        ShortIntMap map3 = this.newWithKeysValues((short) 0, 0, (short) 32, 32);
        Assert.assertTrue(map3.makeString("~"), "0~32".equals(map3.makeString("~")) || "32~0".equals(map3.makeString("~")));
        ShortIntMap map4 = this.newWithKeysValues((short) 32, 32, (short) 33, 33);
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
        this.newWithKeysValues((short) 0, 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((short) 0, 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((short) 0, 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((short) 1, 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((short) 5, 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        ShortIntMap map2 = this.newWithKeysValues((short) 1, 1, (short) 32, 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1/32]".equals(appendable4.toString()) || "[32/1]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        ShortIntMap map3 = this.newWithKeysValues((short) 1, 1, (short) 32, 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1/32]".equals(appendable5.toString()) || "[32/1]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0/1".equals(appendable6.toString()) || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        ShortIntMap actual1 = map.select((short key, int value) -> key == (short) 1 || value == 3);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 3, 3), actual1);
        ShortIntMap actual2 = map.select((short key, int value) -> key == (short) 0 || value == 2);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 2, 2), actual2);
    }

    @Test
    public void reject() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        ShortIntMap actual1 = map.reject((short key, int value) -> key == (short) 1 || value == 3);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 2, 2), actual1);
        ShortIntMap actual2 = map.reject((short key, int value) -> key == (short) 0 || value == 2);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 3, 3), actual2);
    }

    @Test
    public void select_value() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        IntIterable actual1 = map.select(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.select(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void reject_value() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        IntIterable actual1 = map.reject(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.reject(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void collect() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        IntToObjectFunction<Integer> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1, 2, 3, 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2), this.newWithKeysValues((short) 1, 1).collect(function));
    }

    @Test
    public void count() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(2, map.count(IntPredicates.greaterThan(1)));
        Assert.assertEquals(2, map.count(IntPredicates.lessThan(2)));
    }

    @Test
    public void detectIfNone_value() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        int resultNotFound = map.detectIfNone(IntPredicates.greaterThan(5), 5);
        Assert.assertEquals(5, resultNotFound);
        Assert.assertEquals(5, this.getEmptyMap().detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(5, this.newWithKeysValues((short) 1, 1).detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, 1).detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(0, map.detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, map.detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(2, map.detectIfNone(IntPredicates.equal(2), 5));
    }

    @Test
    public void anySatisfy() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1).anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(2)));
        Assert.assertFalse(map.anySatisfy(IntPredicates.greaterThan(5)));
    }

    @Test
    public void allSatisfy() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1).allSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1).allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.allSatisfy(IntPredicates.lessThan(5)));
        ShortIntMap map1 = this.newWithKeysValues((short) 2, 2, (short) 3, 3);
        Assert.assertFalse(map1.allSatisfy(IntPredicates.equal(0)));
    }

    @Test
    public void noneSatisfy() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1).noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1).noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.noneSatisfy(IntPredicates.lessThan(0)));
    }

    @Test
    public void max() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(3, map.max());
        Assert.assertEquals(3, this.newWithKeysValues((short) 3, 3).max());
    }

    @Test
    public void min() {
        ShortIntMap map = this.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3, (short) 0, 0);
        Assert.assertEquals(0, map.min());
        Assert.assertEquals(3, this.newWithKeysValues((short) 3, 3).min());
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
        ShortIntMap map = this.newWithKeysValues((short) 1, 1, (short) 0, 0, (short) 9, 9, (short) 7, 7);
        Assert.assertEquals(0L, map.minIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues((short) 3, 3).maxIfEmpty(5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0));
        ShortIntMap map = this.newWithKeysValues((short) 1, 1, (short) 0, 0, (short) 9, 9, (short) 7, 7);
        Assert.assertEquals(9L, map.maxIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues((short) 3, 3).minIfEmpty(5));
    }

    @Test
    public void sum() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(6, map.sum());
        ShortIntMap map2 = this.newWithKeysValues((short) 2, 2, (short) 3, 3, (short) 4, 4);
        Assert.assertEquals(9, map2.sum());
        ShortIntMap map3 = this.newWithKeysValues((short) 2, 2);
        Assert.assertEquals(2, map3.sum());
    }

    @Test
    public void average() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        ShortIntMap map1 = this.newWithKeysValues((short) 1, 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        ShortIntMap map2 = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        ShortIntMap map3 = this.newWithKeysValues((short) 1, 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(IntArrayList.newListWith(0), this.newWithKeysValues((short) 0, 0).toList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues((short) 1, 1).toList());
        Assert.assertEquals(IntArrayList.newListWith(2), this.newWithKeysValues((short) 2, 2).toList());
        Assert.assertTrue(this.newWithKeysValues((short) 2, 2, (short) 3, 3).toList().equals(IntArrayList.newListWith(2, 3)) || this.newWithKeysValues((short) 2, 2, (short) 3, 3).toList().equals(IntArrayList.newListWith(3, 2)));
    }

    @Test
    public void toSortedList() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 2, 3), map.toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues((short) 1, 1).toSortedList());
    }

    @Test
    public void toSet() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 3), map.toSet());
        Assert.assertEquals(IntHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(IntHashSet.newSetWith(1), this.newWithKeysValues((short) 1, 1).toSet());
    }

    @Test
    public void toBag() {
        ShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 2, 3), map.toBag());
        Assert.assertEquals(IntHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1), this.newWithKeysValues((short) 1, 1).toBag());
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
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<ShortIntPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((short key, int value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new int[] { 0, 31, 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        ShortIntMap map = this.newWithKeysValues((short) 1, 1, (short) 2, 2);
        int[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new int[] { 1, 2 }, array) || Arrays.equals(new int[] { 2, 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new int[] { 1 }, this.newWithKeysValues((short) 1, 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableShortIntMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        IntIterable iterable = this.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1), IntBags.mutable.with(2), IntBags.mutable.with(3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(IntBags.mutable.with(1, 2), IntBags.mutable.with(3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(IntBags.mutable.with(2, 3), IntBags.mutable.with(1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(IntBags.mutable.with(1, 3), IntBags.mutable.with(2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(IntBags.mutable.with(1)).toSet(), this.newWithKeysValues((short) 1, 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((short) 1, 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractShortIntMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortIntMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractShortIntMapTestCase::keySet;
            this.payloads.values = AbstractShortIntMapTestCase::values;
            this.payloads.get = AbstractShortIntMapTestCase::get;
            this.payloads.getIfAbsent = AbstractShortIntMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractShortIntMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractShortIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractShortIntMapTestCase::containsValue;
            this.payloads.contains = AbstractShortIntMapTestCase::contains;
            this.payloads.containsAll = AbstractShortIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractShortIntMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractShortIntMapTestCase::size;
            this.payloads.isEmpty = AbstractShortIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractShortIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractShortIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractShortIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractShortIntMapTestCase::testToString;
            this.payloads.forEach = AbstractShortIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractShortIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractShortIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractShortIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractShortIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractShortIntMapTestCase::makeString;
            this.payloads.appendString = AbstractShortIntMapTestCase::appendString;
            this.payloads.select = AbstractShortIntMapTestCase::select;
            this.payloads.reject = AbstractShortIntMapTestCase::reject;
            this.payloads.select_value = AbstractShortIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractShortIntMapTestCase::reject_value;
            this.payloads.collect = AbstractShortIntMapTestCase::collect;
            this.payloads.count = AbstractShortIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractShortIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractShortIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractShortIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractShortIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractShortIntMapTestCase::max;
            this.payloads.min = AbstractShortIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractShortIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractShortIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractShortIntMapTestCase::sum;
            this.payloads.average = AbstractShortIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractShortIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractShortIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractShortIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractShortIntMapTestCase::toSet;
            this.payloads.toBag = AbstractShortIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractShortIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractShortIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractShortIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractShortIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractShortIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractShortIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractShortIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractShortIntMapTestCase::chunk;
        }
    }
}
