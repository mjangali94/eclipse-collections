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
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.factory.primitive.LongCharMaps;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.map.primitive.LongCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongCharMap;
import org.eclipse.collections.api.map.primitive.MutableLongCharMap;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.LongCharPair;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongCharHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractLongCharMapTestCase {

    protected final LongCharMap map = this.classUnderTest();

    protected abstract LongCharMap classUnderTest();

    protected abstract LongCharMap newWithKeysValues(long key1, char value1);

    protected abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2);

    protected abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3);

    protected abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3, long key4, char value4);

    protected abstract LongCharMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L), this.newWithKeysValues(0L, (char) 0).keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L, 31L, 32L), this.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        LongCharMap map = this.newWithKeysValues(0L, (char) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((char) 0));
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((char) 0));
        Assert.assertTrue(map1.values().contains((char) 31));
        Assert.assertTrue(map1.values().contains((char) 32));
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, (char) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31L, (char) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32L, (char) 5));
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
        Assert.assertTrue(this.map.containsValue((char) 0));
        Assert.assertTrue(this.map.containsValue((char) 31));
        Assert.assertTrue(this.map.containsValue((char) 32));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((char) 0));
        Assert.assertTrue(this.map.contains((char) 31));
        Assert.assertTrue(this.map.contains((char) 32));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll((char) 0, (char) 31, (char) 32));
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 32)));
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 35)));
        Assert.assertTrue(this.map.containsAll(new CharArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0L, (char) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, (char) 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1L, (char) 1, 5L, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, (char) 0, 5L, (char) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, (char) 1, 0L, (char) 0, 5L, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, (char) 6, 5L, (char) 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0L, (char) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50L, (char) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0L, (char) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50L, (char) 50).notEmpty());
    }

    @Test
    public void testEquals() {
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 32);
        LongCharMap map2 = this.newWithKeysValues(32L, (char) 32, 0L, (char) 0, 1L, (char) 1);
        LongCharMap map3 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 2, 32L, (char) 32);
        LongCharMap map4 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 1, 32L, (char) 32);
        LongCharMap map5 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 33);
        LongCharMap map6 = this.newWithKeysValues(50L, (char) 0, 60L, (char) 1, 70L, (char) 33);
        LongCharMap map7 = this.newWithKeysValues(50L, (char) 0, 60L, (char) 1);
        LongCharMap map8 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        LongCharMap map9 = this.newWithKeysValues(0L, (char) 0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(CharArrayList.newListWith((char) 0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, LongCharMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, LongCharMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 32).hashCode(), this.newWithKeysValues(32L, (char) 32, 0L, (char) 0, 1L, (char) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50L, (char) 0, 60L, (char) 1, 70L, (char) 33).hashCode(), this.newWithKeysValues(50L, (char) 0, 60L, (char) 1, 70L, (char) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1L, (char) 2).hashCode(), this.newWithKeysValues(1L, (char) 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=\u0000}", this.newWithKeysValues(0L, (char) 0).toString());
        Assert.assertEquals("{1=\u0001}", this.newWithKeysValues(1L, (char) 1).toString());
        Assert.assertEquals("{5=\u0005}", this.newWithKeysValues(5L, (char) 5).toString());
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertTrue(map1.toString(), "{0=\u0000, 1=\u0001}".equals(map1.toString()) || "{1=\u0001, 0=\u0000}".equals(map1.toString()));
        LongCharMap map2 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        Assert.assertTrue(map2.toString(), "{1=\u0001, 32=\u0020}".equals(map2.toString()) || "{32=\u0020, 1=\u0001}".equals(map2.toString()));
        LongCharMap map3 = this.newWithKeysValues(0L, (char) 0, 32L, (char) 32);
        Assert.assertTrue(map3.toString(), "{0=\u0000, 32=\u0020}".equals(map3.toString()) || "{32=\u0020, 0=\u0000}".equals(map3.toString()));
        LongCharMap map4 = this.newWithKeysValues(32L, (char) 32, 33L, (char) 33);
        Assert.assertTrue(map4.toString(), "{32=\u0020, 33=\u0021}".equals(map4.toString()) || "{33=\u0021, 32=\u0020}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        char[] sum0 = new char[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        char[] sum1 = new char[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        char[] sum01 = new char[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        char[] sum = new char[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        LongCharMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        LongCharMap map3 = this.newWithKeysValues(1L, (char) 2);
        char[] sum3 = new char[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        char[] sum0 = new char[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        char[] sum1 = new char[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        char[] sum01 = new char[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        char[] sum = new char[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        LongCharMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        LongCharMap map3 = this.newWithKeysValues(1L, (char) 2);
        char[] sum3 = new char[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        long[] sum0 = new long[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        long[] sum1 = new long[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        long[] sum01 = new long[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        long[] sum = new long[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        LongCharMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        LongCharMap map3 = this.newWithKeysValues(1L, (char) 1);
        long[] sum3 = new long[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        long[] sumKey0 = new long[1];
        char[] sumValue0 = new char[1];
        map0.forEachKeyValue((long eachKey, char eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        long[] sumKey1 = new long[1];
        char[] sumValue1 = new char[1];
        map1.forEachKeyValue((long eachKey, char eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        long[] sumKey01 = new long[1];
        char[] sumValue01 = new char[1];
        map01.forEachKeyValue((long eachKey, char eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        long[] sumKey = new long[1];
        char[] sumValue = new char[1];
        map.forEachKeyValue((long eachKey, char eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        LongCharMap map2 = this.getEmptyMap();
        long[] sumKey2 = new long[1];
        char[] sumValue2 = new char[1];
        map2.forEachKeyValue((long eachKey, char eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        LongCharMap map3 = this.newWithKeysValues(3L, (char) 5);
        long[] sumKey3 = new long[1];
        char[] sumValue3 = new char[1];
        map3.forEachKeyValue((long eachKey, char eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, long eachKey, char eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        LongCharMap copy = map0.injectIntoKeyValue(LongCharMaps.mutable.empty(), MutableLongCharMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("\u0000", this.newWithKeysValues(0L, (char) 0).makeString());
        Assert.assertEquals("\u0000", this.newWithKeysValues(0L, (char) 0).makeString(", "));
        Assert.assertEquals("[\u0000]", this.newWithKeysValues(0L, (char) 0).makeString("[", "/", "]"));
        Assert.assertEquals("\u0001", this.newWithKeysValues(1L, (char) 1).makeString());
        Assert.assertEquals("\u0005", this.newWithKeysValues(5L, (char) 5).makeString());
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertTrue(map1.makeString(), "\u0000, \u0001".equals(map1.makeString()) || "\u0001, \u0000".equals(map1.makeString()));
        LongCharMap map2 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[\u0001/\u0020]".equals(map2.makeString("[", "/", "]")) || "[\u0020/\u0001]".equals(map2.makeString("[", "/", "]")));
        LongCharMap map3 = this.newWithKeysValues(0L, (char) 0, 32L, (char) 32);
        Assert.assertTrue(map3.makeString("~"), "\u0000~\u0020".equals(map3.makeString("~")) || "\u0020~\u0000".equals(map3.makeString("~")));
        LongCharMap map4 = this.newWithKeysValues(32L, (char) 32, 33L, (char) 33);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[\u0020, \u0021]".equals(map4.makeString("[", ", ", "]")) || "[\u0021, \u0020]".equals(map4.makeString("[", ", ", "]")));
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
        this.newWithKeysValues(0L, (char) 0).appendString(appendable0);
        Assert.assertEquals("\u0000", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0L, (char) 0).appendString(appendable01, "/");
        Assert.assertEquals("\u0000", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0L, (char) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{\u0000}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1L, (char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5L, (char) 5).appendString(appendable2);
        Assert.assertEquals("\u0005", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "\u0000, \u0001".equals(appendable3.toString()) || "\u0001, \u0000".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        LongCharMap map2 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[\u0001/\u0020]".equals(appendable4.toString()) || "[\u0020/\u0001]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        LongCharMap map3 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[\u0001/\u0020]".equals(appendable5.toString()) || "[\u0020/\u0001]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "\u0000/\u0001".equals(appendable6.toString()) || "\u0001/\u0000".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        LongCharMap actual1 = map.select((long key, char value) -> key == 1L || value == (char) 3);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 3L, (char) 3), actual1);
        LongCharMap actual2 = map.select((long key, char value) -> key == 0L || value == (char) 2);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 2L, (char) 2), actual2);
    }

    @Test
    public void reject() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        LongCharMap actual1 = map.reject((long key, char value) -> key == 1L || value == (char) 3);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 2L, (char) 2), actual1);
        LongCharMap actual2 = map.reject((long key, char value) -> key == 0L || value == (char) 2);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 3L, (char) 3), actual2);
    }

    @Test
    public void select_value() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        CharIterable actual1 = map.select(CharPredicates.greaterThan((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 2, (char) 3), actual1);
        CharIterable actual2 = map.select(CharPredicates.lessThan((char) 2));
        Assert.assertEquals(CharBags.immutable.with((char) 0, (char) 1), actual2);
    }

    @Test
    public void reject_value() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        CharIterable actual1 = map.reject(CharPredicates.lessThan((char) 2));
        Assert.assertEquals(CharBags.immutable.with((char) 2, (char) 3), actual1);
        CharIterable actual2 = map.reject(CharPredicates.greaterThan((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 0, (char) 1), actual2);
    }

    @Test
    public void collect() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        CharToObjectFunction<Character> function = parameter -> (char) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((char) 1, (char) 2, (char) 3, (char) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((char) 2), this.newWithKeysValues(1L, (char) 1).collect(function));
    }

    @Test
    public void count() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(2, map.count(CharPredicates.greaterThan((char) 1)));
        Assert.assertEquals(2, map.count(CharPredicates.lessThan((char) 2)));
    }

    @Test
    public void detectIfNone_value() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        char resultNotFound = map.detectIfNone(CharPredicates.greaterThan((char) 5), (char) 5);
        Assert.assertEquals((char) 5, resultNotFound);
        Assert.assertEquals((char) 5, this.getEmptyMap().detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 5, this.newWithKeysValues(1L, (char) 1).detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 1, this.newWithKeysValues(1L, (char) 1).detectIfNone(CharPredicates.equal((char) 1), (char) 5));
        Assert.assertEquals((char) 0, map.detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 1, map.detectIfNone(CharPredicates.equal((char) 1), (char) 5));
        Assert.assertEquals((char) 2, map.detectIfNone(CharPredicates.equal((char) 2), (char) 5));
    }

    @Test
    public void anySatisfy() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 2)));
        Assert.assertFalse(map.anySatisfy(CharPredicates.greaterThan((char) 5)));
    }

    @Test
    public void allSatisfy() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).allSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 2)));
        Assert.assertTrue(map.allSatisfy(CharPredicates.lessThan((char) 5)));
        LongCharMap map1 = this.newWithKeysValues(2L, (char) 2, 3L, (char) 3);
        Assert.assertFalse(map1.allSatisfy(CharPredicates.equal((char) 0)));
    }

    @Test
    public void noneSatisfy() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).noneSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 2)));
        Assert.assertTrue(map.noneSatisfy(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void max() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals((char) 3, map.max());
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).max());
    }

    @Test
    public void min() {
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3, 0L, (char) 0);
        Assert.assertEquals((char) 0, map.min());
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).min());
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
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty((char) 5));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty((char) 0));
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 0L, (char) 0, 9L, (char) 9, 7L, (char) 7);
        Assert.assertEquals(0L, map.minIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).maxIfEmpty((char) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((char) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((char) 0));
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 0L, (char) 0, 9L, (char) 9, 7L, (char) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).minIfEmpty((char) 5));
    }

    @Test
    public void sum() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals((char) 6, map.sum());
        LongCharMap map2 = this.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        Assert.assertEquals((char) 9, map2.sum());
        LongCharMap map3 = this.newWithKeysValues(2L, (char) 2);
        Assert.assertEquals((char) 2, map3.sum());
    }

    @Test
    public void average() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        LongCharMap map1 = this.newWithKeysValues(1L, (char) 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        LongCharMap map2 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        LongCharMap map3 = this.newWithKeysValues(1L, (char) 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.newWithKeysValues(0L, (char) 0).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWithKeysValues(1L, (char) 1).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 2), this.newWithKeysValues(2L, (char) 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2L, (char) 2, 3L, (char) 3).toList().equals(CharArrayList.newListWith((char) 2, (char) 3)) || this.newWithKeysValues(2L, (char) 2, 3L, (char) 3).toList().equals(CharArrayList.newListWith((char) 3, (char) 2)));
    }

    @Test
    public void toSortedList() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 1, (char) 2, (char) 3), map.toSortedList());
        Assert.assertEquals(CharArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWithKeysValues(1L, (char) 1).toSortedList());
    }

    @Test
    public void toSet() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 3), map.toSet());
        Assert.assertEquals(CharHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), this.newWithKeysValues(1L, (char) 1).toSet());
    }

    @Test
    public void toBag() {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2, (char) 3), map.toBag());
        Assert.assertEquals(CharHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), this.newWithKeysValues(1L, (char) 1).toBag());
    }

    @Test
    public void charIterator() {
        MutableCharSet expected = CharHashSet.newSetWith((char) 0, (char) 31, (char) 32);
        MutableCharSet actual = CharHashSet.newSetWith();
        CharIterator iterator = this.map.charIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().charIterator().next());
    }

    @Test
    public void asLazy() {
        LazyCharIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll((char) 0, (char) 31, (char) 32));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(LongArrayList.newListWith(0L, 31L, 32L), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<LongCharPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((long key, char value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new char[] { (char) 0, (char) 31, (char) 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 2L, (char) 2);
        char[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new char[] { (char) 1, (char) 2 }, array) || Arrays.equals(new char[] { (char) 2, (char) 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new char[] { (char) 1 }, this.newWithKeysValues(1L, (char) 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableLongCharMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        CharIterable iterable = this.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1), CharBags.mutable.with((char) 2), CharBags.mutable.with((char) 3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2), CharBags.mutable.with((char) 3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(CharBags.mutable.with((char) 2, (char) 3), CharBags.mutable.with((char) 1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 3), CharBags.mutable.with((char) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1)).toSet(), this.newWithKeysValues(1L, (char) 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1L, (char) 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLongCharMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLongCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractLongCharMapTestCase::keySet;
            this.payloads.values = AbstractLongCharMapTestCase::values;
            this.payloads.get = AbstractLongCharMapTestCase::get;
            this.payloads.getIfAbsent = AbstractLongCharMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractLongCharMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractLongCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractLongCharMapTestCase::containsValue;
            this.payloads.contains = AbstractLongCharMapTestCase::contains;
            this.payloads.containsAll = AbstractLongCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractLongCharMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractLongCharMapTestCase::size;
            this.payloads.isEmpty = AbstractLongCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLongCharMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractLongCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractLongCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractLongCharMapTestCase::testToString;
            this.payloads.forEach = AbstractLongCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractLongCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractLongCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractLongCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractLongCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractLongCharMapTestCase::makeString;
            this.payloads.appendString = AbstractLongCharMapTestCase::appendString;
            this.payloads.select = AbstractLongCharMapTestCase::select;
            this.payloads.reject = AbstractLongCharMapTestCase::reject;
            this.payloads.select_value = AbstractLongCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractLongCharMapTestCase::reject_value;
            this.payloads.collect = AbstractLongCharMapTestCase::collect;
            this.payloads.count = AbstractLongCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractLongCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractLongCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLongCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLongCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractLongCharMapTestCase::max;
            this.payloads.min = AbstractLongCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractLongCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLongCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractLongCharMapTestCase::sum;
            this.payloads.average = AbstractLongCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractLongCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractLongCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractLongCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractLongCharMapTestCase::toSet;
            this.payloads.toBag = AbstractLongCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractLongCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractLongCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractLongCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractLongCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractLongCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractLongCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractLongCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractLongCharMapTestCase::chunk;
        }
    }
}
