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
import org.eclipse.collections.api.factory.primitive.CharCharMaps;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.map.primitive.CharCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharCharMap;
import org.eclipse.collections.api.map.primitive.MutableCharCharMap;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharCharHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractCharCharMapTestCase {

    protected final CharCharMap map = this.classUnderTest();

    protected abstract CharCharMap classUnderTest();

    protected abstract CharCharMap newWithKeysValues(char key1, char value1);

    protected abstract CharCharMap newWithKeysValues(char key1, char value1, char key2, char value2);

    protected abstract CharCharMap newWithKeysValues(char key1, char value1, char key2, char value2, char key3, char value3);

    protected abstract CharCharMap newWithKeysValues(char key1, char value1, char key2, char value2, char key3, char value3, char key4, char value4);

    protected abstract CharCharMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0), this.newWithKeysValues((char) 0, (char) 0).keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 31, (char) 32), this.newWithKeysValues((char) 0, (char) 0, (char) 31, (char) 31, (char) 32, (char) 32).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((char) 0));
        CharCharMap map1 = this.newWithKeysValues((char) 0, (char) 0, (char) 31, (char) 31, (char) 32, (char) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((char) 0));
        Assert.assertTrue(map1.values().contains((char) 31));
        Assert.assertTrue(map1.values().contains((char) 32));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get((char) 0));
        Assert.assertEquals(31L, this.map.get((char) 31));
        Assert.assertEquals(32L, this.map.get((char) 32));
        Assert.assertEquals(0L, this.map.get((char) 1));
        Assert.assertEquals(0L, this.map.get((char) 33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent((char) 0, (char) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent((char) 31, (char) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent((char) 32, (char) 5));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow((char) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((char) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((char) 32));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 1));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey((char) 0));
        Assert.assertTrue(this.map.containsKey((char) 31));
        Assert.assertTrue(this.map.containsKey((char) 32));
        Assert.assertFalse(this.map.containsKey((char) 1));
        Assert.assertFalse(this.map.containsKey((char) 5));
        Assert.assertFalse(this.map.containsKey((char) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, (char) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, (char) 1).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 1, (char) 1, (char) 5, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, (char) 0, (char) 5, (char) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, (char) 1, (char) 0, (char) 0, (char) 5, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, (char) 6, (char) 5, (char) 5).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 1, (char) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 0, (char) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 50, (char) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 1, (char) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 0, (char) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 50, (char) 50).notEmpty());
    }

    @Test
    public void testEquals() {
        CharCharMap map1 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 32, (char) 32);
        CharCharMap map2 = this.newWithKeysValues((char) 32, (char) 32, (char) 0, (char) 0, (char) 1, (char) 1);
        CharCharMap map3 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 2, (char) 32, (char) 32);
        CharCharMap map4 = this.newWithKeysValues((char) 0, (char) 1, (char) 1, (char) 1, (char) 32, (char) 32);
        CharCharMap map5 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 32, (char) 33);
        CharCharMap map6 = this.newWithKeysValues((char) 50, (char) 0, (char) 60, (char) 1, (char) 70, (char) 33);
        CharCharMap map7 = this.newWithKeysValues((char) 50, (char) 0, (char) 60, (char) 1);
        CharCharMap map8 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1);
        CharCharMap map9 = this.newWithKeysValues((char) 0, (char) 0);
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
        Assert.assertEquals(map1, CharCharMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, CharCharMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 32, (char) 32).hashCode(), this.newWithKeysValues((char) 32, (char) 32, (char) 0, (char) 0, (char) 1, (char) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 50, (char) 0, (char) 60, (char) 1, (char) 70, (char) 33).hashCode(), this.newWithKeysValues((char) 50, (char) 0, (char) 60, (char) 1, (char) 70, (char) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 1, (char) 2).hashCode(), this.newWithKeysValues((char) 1, (char) 2).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{\u0000=\u0000}", this.newWithKeysValues((char) 0, (char) 0).toString());
        Assert.assertEquals("{\u0001=\u0001}", this.newWithKeysValues((char) 1, (char) 1).toString());
        Assert.assertEquals("{\u0005=\u0005}", this.newWithKeysValues((char) 5, (char) 5).toString());
        CharCharMap map1 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1);
        Assert.assertTrue(map1.toString(), "{\u0000=\u0000, \u0001=\u0001}".equals(map1.toString()) || "{\u0001=\u0001, \u0000=\u0000}".equals(map1.toString()));
        CharCharMap map2 = this.newWithKeysValues((char) 1, (char) 1, (char) 32, (char) 32);
        Assert.assertTrue(map2.toString(), "{\u0001=\u0001, \u0020=\u0020}".equals(map2.toString()) || "{\u0020=\u0020, \u0001=\u0001}".equals(map2.toString()));
        CharCharMap map3 = this.newWithKeysValues((char) 0, (char) 0, (char) 32, (char) 32);
        Assert.assertTrue(map3.toString(), "{\u0000=\u0000, \u0020=\u0020}".equals(map3.toString()) || "{\u0020=\u0020, \u0000=\u0000}".equals(map3.toString()));
        CharCharMap map4 = this.newWithKeysValues((char) 32, (char) 32, (char) 33, (char) 33);
        Assert.assertTrue(map4.toString(), "{\u0020=\u0020, \u0021=\u0021}".equals(map4.toString()) || "{\u0021=\u0021, \u0020=\u0020}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        CharCharMap map0 = this.newWithKeysValues((char) 0, (char) 1, (char) 3, (char) 4);
        char[] sum0 = new char[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        CharCharMap map1 = this.newWithKeysValues((char) 1, (char) 2, (char) 3, (char) 4);
        char[] sum1 = new char[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        CharCharMap map01 = this.newWithKeysValues((char) 0, (char) 1, (char) 1, (char) 2);
        char[] sum01 = new char[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        CharCharMap map = this.newWithKeysValues((char) 3, (char) 4, (char) 4, (char) 5);
        char[] sum = new char[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        CharCharMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        CharCharMap map3 = this.newWithKeysValues((char) 1, (char) 2);
        char[] sum3 = new char[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue() {
        CharCharMap map0 = this.newWithKeysValues((char) 0, (char) 1, (char) 3, (char) 4);
        char[] sum0 = new char[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);
        CharCharMap map1 = this.newWithKeysValues((char) 1, (char) 2, (char) 3, (char) 4);
        char[] sum1 = new char[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);
        CharCharMap map01 = this.newWithKeysValues((char) 0, (char) 1, (char) 1, (char) 2);
        char[] sum01 = new char[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        CharCharMap map = this.newWithKeysValues((char) 3, (char) 4, (char) 4, (char) 5);
        char[] sum = new char[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
        CharCharMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        CharCharMap map3 = this.newWithKeysValues((char) 1, (char) 2);
        char[] sum3 = new char[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey() {
        CharCharMap map0 = this.newWithKeysValues((char) 0, (char) 1, (char) 3, (char) 4);
        char[] sum0 = new char[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        CharCharMap map1 = this.newWithKeysValues((char) 1, (char) 2, (char) 3, (char) 4);
        char[] sum1 = new char[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        CharCharMap map01 = this.newWithKeysValues((char) 0, (char) 1, (char) 1, (char) 2);
        char[] sum01 = new char[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        CharCharMap map = this.newWithKeysValues((char) 3, (char) 4, (char) 4, (char) 5);
        char[] sum = new char[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        CharCharMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        CharCharMap map3 = this.newWithKeysValues((char) 1, (char) 1);
        char[] sum3 = new char[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        CharCharMap map0 = this.newWithKeysValues((char) 0, (char) 1, (char) 3, (char) 4);
        char[] sumKey0 = new char[1];
        char[] sumValue0 = new char[1];
        map0.forEachKeyValue((char eachKey, char eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);
        CharCharMap map1 = this.newWithKeysValues((char) 1, (char) 2, (char) 3, (char) 4);
        char[] sumKey1 = new char[1];
        char[] sumValue1 = new char[1];
        map1.forEachKeyValue((char eachKey, char eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);
        CharCharMap map01 = this.newWithKeysValues((char) 0, (char) 1, (char) 1, (char) 2);
        char[] sumKey01 = new char[1];
        char[] sumValue01 = new char[1];
        map01.forEachKeyValue((char eachKey, char eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        CharCharMap map = this.newWithKeysValues((char) 3, (char) 4, (char) 4, (char) 5);
        char[] sumKey = new char[1];
        char[] sumValue = new char[1];
        map.forEachKeyValue((char eachKey, char eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);
        CharCharMap map2 = this.getEmptyMap();
        char[] sumKey2 = new char[1];
        char[] sumValue2 = new char[1];
        map2.forEachKeyValue((char eachKey, char eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);
        CharCharMap map3 = this.newWithKeysValues((char) 3, (char) 5);
        char[] sumKey3 = new char[1];
        char[] sumValue3 = new char[1];
        map3.forEachKeyValue((char eachKey, char eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        CharCharMap map0 = this.newWithKeysValues((char) 0, (char) 1, (char) 3, (char) 4);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, char eachKey, char eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        CharCharMap copy = map0.injectIntoKeyValue(CharCharMaps.mutable.empty(), MutableCharCharMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("\u0000", this.newWithKeysValues((char) 0, (char) 0).makeString());
        Assert.assertEquals("\u0000", this.newWithKeysValues((char) 0, (char) 0).makeString(", "));
        Assert.assertEquals("[\u0000]", this.newWithKeysValues((char) 0, (char) 0).makeString("[", "/", "]"));
        Assert.assertEquals("\u0001", this.newWithKeysValues((char) 1, (char) 1).makeString());
        Assert.assertEquals("\u0005", this.newWithKeysValues((char) 5, (char) 5).makeString());
        CharCharMap map1 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1);
        Assert.assertTrue(map1.makeString(), "\u0000, \u0001".equals(map1.makeString()) || "\u0001, \u0000".equals(map1.makeString()));
        CharCharMap map2 = this.newWithKeysValues((char) 1, (char) 1, (char) 32, (char) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[\u0001/\u0020]".equals(map2.makeString("[", "/", "]")) || "[\u0020/\u0001]".equals(map2.makeString("[", "/", "]")));
        CharCharMap map3 = this.newWithKeysValues((char) 0, (char) 0, (char) 32, (char) 32);
        Assert.assertTrue(map3.makeString("~"), "\u0000~\u0020".equals(map3.makeString("~")) || "\u0020~\u0000".equals(map3.makeString("~")));
        CharCharMap map4 = this.newWithKeysValues((char) 32, (char) 32, (char) 33, (char) 33);
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
        this.newWithKeysValues((char) 0, (char) 0).appendString(appendable0);
        Assert.assertEquals("\u0000", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((char) 0, (char) 0).appendString(appendable01, "/");
        Assert.assertEquals("\u0000", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((char) 0, (char) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{\u0000}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((char) 1, (char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((char) 5, (char) 5).appendString(appendable2);
        Assert.assertEquals("\u0005", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        CharCharMap map1 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "\u0000, \u0001".equals(appendable3.toString()) || "\u0001, \u0000".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        CharCharMap map2 = this.newWithKeysValues((char) 1, (char) 1, (char) 32, (char) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[\u0001/\u0020]".equals(appendable4.toString()) || "[\u0020/\u0001]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        CharCharMap map3 = this.newWithKeysValues((char) 1, (char) 1, (char) 32, (char) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[\u0001/\u0020]".equals(appendable5.toString()) || "[\u0020/\u0001]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "\u0000/\u0001".equals(appendable6.toString()) || "\u0001/\u0000".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        CharCharMap actual1 = map.select((char key, char value) -> key == (char) 1 || value == (char) 3);
        Assert.assertEquals(CharCharHashMap.newWithKeysValues((char) 1, (char) 1, (char) 3, (char) 3), actual1);
        CharCharMap actual2 = map.select((char key, char value) -> key == (char) 0 || value == (char) 2);
        Assert.assertEquals(CharCharHashMap.newWithKeysValues((char) 0, (char) 0, (char) 2, (char) 2), actual2);
    }

    @Test
    public void reject() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        CharCharMap actual1 = map.reject((char key, char value) -> key == (char) 1 || value == (char) 3);
        Assert.assertEquals(CharCharHashMap.newWithKeysValues((char) 0, (char) 0, (char) 2, (char) 2), actual1);
        CharCharMap actual2 = map.reject((char key, char value) -> key == (char) 0 || value == (char) 2);
        Assert.assertEquals(CharCharHashMap.newWithKeysValues((char) 1, (char) 1, (char) 3, (char) 3), actual2);
    }

    @Test
    public void select_value() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        CharIterable actual1 = map.select(CharPredicates.greaterThan((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 2, (char) 3), actual1);
        CharIterable actual2 = map.select(CharPredicates.lessThan((char) 2));
        Assert.assertEquals(CharBags.immutable.with((char) 0, (char) 1), actual2);
    }

    @Test
    public void reject_value() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        CharIterable actual1 = map.reject(CharPredicates.lessThan((char) 2));
        Assert.assertEquals(CharBags.immutable.with((char) 2, (char) 3), actual1);
        CharIterable actual2 = map.reject(CharPredicates.greaterThan((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 0, (char) 1), actual2);
    }

    @Test
    public void collect() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        CharToObjectFunction<Character> function = parameter -> (char) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((char) 1, (char) 2, (char) 3, (char) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((char) 2), this.newWithKeysValues((char) 1, (char) 1).collect(function));
    }

    @Test
    public void count() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals(2, map.count(CharPredicates.greaterThan((char) 1)));
        Assert.assertEquals(2, map.count(CharPredicates.lessThan((char) 2)));
    }

    @Test
    public void detectIfNone_value() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        char resultNotFound = map.detectIfNone(CharPredicates.greaterThan((char) 5), (char) 5);
        Assert.assertEquals((char) 5, resultNotFound);
        Assert.assertEquals((char) 5, this.getEmptyMap().detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 5, this.newWithKeysValues((char) 1, (char) 1).detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 1, this.newWithKeysValues((char) 1, (char) 1).detectIfNone(CharPredicates.equal((char) 1), (char) 5));
        Assert.assertEquals((char) 0, map.detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 1, map.detectIfNone(CharPredicates.equal((char) 1), (char) 5));
        Assert.assertEquals((char) 2, map.detectIfNone(CharPredicates.equal((char) 2), (char) 5));
    }

    @Test
    public void anySatisfy() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, (char) 1).anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, (char) 1).anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 2)));
        Assert.assertFalse(map.anySatisfy(CharPredicates.greaterThan((char) 5)));
    }

    @Test
    public void allSatisfy() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, (char) 1).allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, (char) 1).allSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 2)));
        Assert.assertTrue(map.allSatisfy(CharPredicates.lessThan((char) 5)));
        CharCharMap map1 = this.newWithKeysValues((char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertFalse(map1.allSatisfy(CharPredicates.equal((char) 0)));
    }

    @Test
    public void noneSatisfy() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, (char) 1).noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, (char) 1).noneSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 2)));
        Assert.assertTrue(map.noneSatisfy(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void max() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals((char) 3, map.max());
        Assert.assertEquals((char) 3, this.newWithKeysValues((char) 3, (char) 3).max());
    }

    @Test
    public void min() {
        CharCharMap map = this.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 0, (char) 0);
        Assert.assertEquals((char) 0, map.min());
        Assert.assertEquals((char) 3, this.newWithKeysValues((char) 3, (char) 3).min());
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
        CharCharMap map = this.newWithKeysValues((char) 1, (char) 1, (char) 0, (char) 0, (char) 9, (char) 9, (char) 7, (char) 7);
        Assert.assertEquals(0L, map.minIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.newWithKeysValues((char) 3, (char) 3).maxIfEmpty((char) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((char) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((char) 0));
        CharCharMap map = this.newWithKeysValues((char) 1, (char) 1, (char) 0, (char) 0, (char) 9, (char) 9, (char) 7, (char) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.newWithKeysValues((char) 3, (char) 3).minIfEmpty((char) 5));
    }

    @Test
    public void sum() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals((char) 6, map.sum());
        CharCharMap map2 = this.newWithKeysValues((char) 2, (char) 2, (char) 3, (char) 3, (char) 4, (char) 4);
        Assert.assertEquals((char) 9, map2.sum());
        CharCharMap map3 = this.newWithKeysValues((char) 2, (char) 2);
        Assert.assertEquals((char) 2, map3.sum());
    }

    @Test
    public void average() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        CharCharMap map1 = this.newWithKeysValues((char) 1, (char) 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        CharCharMap map2 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        CharCharMap map3 = this.newWithKeysValues((char) 1, (char) 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.newWithKeysValues((char) 0, (char) 0).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWithKeysValues((char) 1, (char) 1).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 2), this.newWithKeysValues((char) 2, (char) 2).toList());
        Assert.assertTrue(this.newWithKeysValues((char) 2, (char) 2, (char) 3, (char) 3).toList().equals(CharArrayList.newListWith((char) 2, (char) 3)) || this.newWithKeysValues((char) 2, (char) 2, (char) 3, (char) 3).toList().equals(CharArrayList.newListWith((char) 3, (char) 2)));
    }

    @Test
    public void toSortedList() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 1, (char) 2, (char) 3), map.toSortedList());
        Assert.assertEquals(CharArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWithKeysValues((char) 1, (char) 1).toSortedList());
    }

    @Test
    public void toSet() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 3), map.toSet());
        Assert.assertEquals(CharHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), this.newWithKeysValues((char) 1, (char) 1).toSet());
    }

    @Test
    public void toBag() {
        CharCharMap map = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2, (char) 3), map.toBag());
        Assert.assertEquals(CharHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), this.newWithKeysValues((char) 1, (char) 1).toBag());
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
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 31, (char) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<CharCharPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((char key, char value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new char[] { (char) 0, (char) 31, (char) 32 }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        CharCharMap map = this.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 2);
        char[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new char[] { (char) 1, (char) 2 }, array) || Arrays.equals(new char[] { (char) 2, (char) 1 }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new char[] { (char) 1 }, this.newWithKeysValues((char) 1, (char) 1).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableCharCharMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        CharIterable iterable = this.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3);
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1), CharBags.mutable.with((char) 2), CharBags.mutable.with((char) 3)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2), CharBags.mutable.with((char) 3)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(CharBags.mutable.with((char) 2, (char) 3), CharBags.mutable.with((char) 1)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 3), CharBags.mutable.with((char) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(CharBags.mutable.with((char) 1)).toSet(), this.newWithKeysValues((char) 1, (char) 1).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((char) 1, (char) 1).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharCharMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharCharMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractCharCharMapTestCase::keySet;
            this.payloads.values = AbstractCharCharMapTestCase::values;
            this.payloads.get = AbstractCharCharMapTestCase::get;
            this.payloads.getIfAbsent = AbstractCharCharMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractCharCharMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractCharCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractCharCharMapTestCase::containsValue;
            this.payloads.contains = AbstractCharCharMapTestCase::contains;
            this.payloads.containsAll = AbstractCharCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractCharCharMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractCharCharMapTestCase::size;
            this.payloads.isEmpty = AbstractCharCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractCharCharMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractCharCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractCharCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractCharCharMapTestCase::testToString;
            this.payloads.forEach = AbstractCharCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractCharCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractCharCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractCharCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractCharCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractCharCharMapTestCase::makeString;
            this.payloads.appendString = AbstractCharCharMapTestCase::appendString;
            this.payloads.select = AbstractCharCharMapTestCase::select;
            this.payloads.reject = AbstractCharCharMapTestCase::reject;
            this.payloads.select_value = AbstractCharCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractCharCharMapTestCase::reject_value;
            this.payloads.collect = AbstractCharCharMapTestCase::collect;
            this.payloads.count = AbstractCharCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractCharCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractCharCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractCharCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractCharCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractCharCharMapTestCase::max;
            this.payloads.min = AbstractCharCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractCharCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractCharCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractCharCharMapTestCase::sum;
            this.payloads.average = AbstractCharCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractCharCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractCharCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractCharCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractCharCharMapTestCase::toSet;
            this.payloads.toBag = AbstractCharCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractCharCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractCharCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractCharCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractCharCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractCharCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractCharCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractCharCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractCharCharMapTestCase::chunk;
        }
    }
}
