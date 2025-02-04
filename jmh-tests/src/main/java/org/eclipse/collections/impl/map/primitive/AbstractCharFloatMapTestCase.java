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
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.factory.primitive.CharFloatMaps;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.map.primitive.CharFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharFloatMap;
import org.eclipse.collections.api.map.primitive.MutableCharFloatMap;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.CharFloatPair;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharFloatHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractCharFloatMapTestCase {

    protected final CharFloatMap map = this.classUnderTest();

    protected abstract CharFloatMap classUnderTest();

    protected abstract CharFloatMap newWithKeysValues(char key1, float value1);

    protected abstract CharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2);

    protected abstract CharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3);

    protected abstract CharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3, char key4, float value4);

    protected abstract CharFloatMap getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0), this.newWithKeysValues((char) 0, 0.0f).keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 31, (char) 32), this.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0f));
        CharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0f));
        Assert.assertTrue(map1.values().contains(31.0f));
        Assert.assertTrue(map1.values().contains(32.0f));
    }

    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get((char) 0), 0.0);
        Assert.assertEquals(31.0, this.map.get((char) 31), 0.0);
        Assert.assertEquals(32.0, this.map.get((char) 32), 0.0);
        Assert.assertEquals(0.0, this.map.get((char) 1), 0.0);
        Assert.assertEquals(0.0, this.map.get((char) 33), 0.0);
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent((char) 0, 5.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent((char) 31, 5.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent((char) 32, 5.0f), 0.0);
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow((char) 0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow((char) 31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow((char) 32), 0.0);
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
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(31.0f));
        Assert.assertTrue(this.map.containsValue(32.0f));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertTrue(this.map.contains(31.0f));
        Assert.assertTrue(this.map.contains(32.0f));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0.0f, 31.0f, 32.0f));
        Assert.assertFalse(this.map.containsAll(0.0f, 31.0f, 35.0f));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f)));
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 35.0f)));
        Assert.assertTrue(this.map.containsAll(new FloatArrayList()));
    }

    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, 0.0f).size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, 1.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 1, 1.0f, (char) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, 0.0f, (char) 5, 5.0f).size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, 1.0f, (char) 0, 0.0f, (char) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, 6.0f, (char) 5, 5.0f).size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 0, 0.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 50, 50.0f).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 0, 0.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 50, 50.0f).notEmpty());
    }

    @Test
    public void testEquals() {
        CharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 32, 32.0f);
        CharFloatMap map2 = this.newWithKeysValues((char) 32, 32.0f, (char) 0, 0.0f, (char) 1, 1.0f);
        CharFloatMap map3 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 2.0f, (char) 32, 32.0f);
        CharFloatMap map4 = this.newWithKeysValues((char) 0, 1.0f, (char) 1, 1.0f, (char) 32, 32.0f);
        CharFloatMap map5 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 32, 33.0f);
        CharFloatMap map6 = this.newWithKeysValues((char) 50, 0.0f, (char) 60, 1.0f, (char) 70, 33.0f);
        CharFloatMap map7 = this.newWithKeysValues((char) 50, 0.0f, (char) 60, 1.0f);
        CharFloatMap map8 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        CharFloatMap map9 = this.newWithKeysValues((char) 0, 0.0f);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(FloatArrayList.newListWith(0.0f), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
        Assert.assertEquals(map1, CharFloatMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, CharFloatMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 32, 32.0f).hashCode(), this.newWithKeysValues((char) 32, 32.0f, (char) 0, 0.0f, (char) 1, 1.0f).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 50, 0.0f, (char) 60, 1.0f, (char) 70, 33.0f).hashCode(), this.newWithKeysValues((char) 50, 0.0f, (char) 60, 1.0f, (char) 70, 33.0f).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 1, 2.0f).hashCode(), this.newWithKeysValues((char) 1, 2.0f).hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{\u0000=0.0}", this.newWithKeysValues((char) 0, 0.0f).toString());
        Assert.assertEquals("{\u0001=1.0}", this.newWithKeysValues((char) 1, 1.0f).toString());
        Assert.assertEquals("{\u0005=5.0}", this.newWithKeysValues((char) 5, 5.0f).toString());
        CharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        Assert.assertTrue(map1.toString(), "{\u0000=0.0, \u0001=1.0}".equals(map1.toString()) || "{\u0001=1.0, \u0000=0.0}".equals(map1.toString()));
        CharFloatMap map2 = this.newWithKeysValues((char) 1, 1.0f, (char) 32, 32.0f);
        Assert.assertTrue(map2.toString(), "{\u0001=1.0, \u0020=32.0}".equals(map2.toString()) || "{\u0020=32.0, \u0001=1.0}".equals(map2.toString()));
        CharFloatMap map3 = this.newWithKeysValues((char) 0, 0.0f, (char) 32, 32.0f);
        Assert.assertTrue(map3.toString(), "{\u0000=0.0, \u0020=32.0}".equals(map3.toString()) || "{\u0020=32.0, \u0000=0.0}".equals(map3.toString()));
        CharFloatMap map4 = this.newWithKeysValues((char) 32, 32.0f, (char) 33, 33.0f);
        Assert.assertTrue(map4.toString(), "{\u0020=32.0, \u0021=33.0}".equals(map4.toString()) || "{\u0021=33.0, \u0020=32.0}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        CharFloatMap map0 = this.newWithKeysValues((char) 0, 1.0f, (char) 3, 4.0f);
        float[] sum0 = new float[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        CharFloatMap map1 = this.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f);
        float[] sum1 = new float[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        CharFloatMap map01 = this.newWithKeysValues((char) 0, 1.0f, (char) 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        CharFloatMap map = this.newWithKeysValues((char) 3, 4.0f, (char) 4, 5.0f);
        float[] sum = new float[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        CharFloatMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        CharFloatMap map3 = this.newWithKeysValues((char) 1, 2.0f);
        float[] sum3 = new float[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachValue() {
        CharFloatMap map0 = this.newWithKeysValues((char) 0, 1.0f, (char) 3, 4.0f);
        float[] sum0 = new float[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);
        CharFloatMap map1 = this.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f);
        float[] sum1 = new float[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);
        CharFloatMap map01 = this.newWithKeysValues((char) 0, 1.0f, (char) 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        CharFloatMap map = this.newWithKeysValues((char) 3, 4.0f, (char) 4, 5.0f);
        float[] sum = new float[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
        CharFloatMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);
        CharFloatMap map3 = this.newWithKeysValues((char) 1, 2.0f);
        float[] sum3 = new float[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKey() {
        CharFloatMap map0 = this.newWithKeysValues((char) 0, 1.0f, (char) 3, 4.0f);
        char[] sum0 = new char[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);
        CharFloatMap map1 = this.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f);
        char[] sum1 = new char[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);
        CharFloatMap map01 = this.newWithKeysValues((char) 0, 1.0f, (char) 1, 2.0f);
        char[] sum01 = new char[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);
        CharFloatMap map = this.newWithKeysValues((char) 3, 4.0f, (char) 4, 5.0f);
        char[] sum = new char[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);
        CharFloatMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);
        CharFloatMap map3 = this.newWithKeysValues((char) 1, 1.0f);
        char[] sum3 = new char[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue() {
        CharFloatMap map0 = this.newWithKeysValues((char) 0, 1.0f, (char) 3, 4.0f);
        char[] sumKey0 = new char[1];
        float[] sumValue0 = new float[1];
        map0.forEachKeyValue((char eachKey, float eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5.0, sumValue0[0], 0.0);
        CharFloatMap map1 = this.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f);
        char[] sumKey1 = new char[1];
        float[] sumValue1 = new float[1];
        map1.forEachKeyValue((char eachKey, float eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6.0, sumValue1[0], 0.0);
        CharFloatMap map01 = this.newWithKeysValues((char) 0, 1.0f, (char) 1, 2.0f);
        char[] sumKey01 = new char[1];
        float[] sumValue01 = new float[1];
        map01.forEachKeyValue((char eachKey, float eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3.0, sumValue01[0], 0.0);
        CharFloatMap map = this.newWithKeysValues((char) 3, 4.0f, (char) 4, 5.0f);
        char[] sumKey = new char[1];
        float[] sumValue = new float[1];
        map.forEachKeyValue((char eachKey, float eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9.0, sumValue[0], 0.0);
        CharFloatMap map2 = this.getEmptyMap();
        char[] sumKey2 = new char[1];
        float[] sumValue2 = new float[1];
        map2.forEachKeyValue((char eachKey, float eachValue) -> {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0.0, sumValue2[0], 0.0);
        CharFloatMap map3 = this.newWithKeysValues((char) 3, 5.0f);
        char[] sumKey3 = new char[1];
        float[] sumValue3 = new float[1];
        map3.forEachKeyValue((char eachKey, float eachValue) -> {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5.0, sumValue3[0], 0.0);
    }

    @Test
    public void injectIntoKeyValue() {
        CharFloatMap map0 = this.newWithKeysValues((char) 0, 1.0f, (char) 3, 4.0f);
        Long sum0 = map0.injectIntoKeyValue(new Long(0), (Long sum, char eachKey, float eachValue) -> {
            return new Long((long) (sum + eachKey + eachValue));
        });
        Assert.assertEquals(new Long(8), sum0);
        CharFloatMap copy = map0.injectIntoKeyValue(CharFloatMaps.mutable.empty(), MutableCharFloatMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0.0", this.newWithKeysValues((char) 0, 0.0f).makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues((char) 0, 0.0f).makeString(", "));
        Assert.assertEquals("[0.0]", this.newWithKeysValues((char) 0, 0.0f).makeString("[", "/", "]"));
        Assert.assertEquals("1.0", this.newWithKeysValues((char) 1, 1.0f).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues((char) 5, 5.0f).makeString());
        CharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        Assert.assertTrue(map1.makeString(), "0.0, 1.0".equals(map1.makeString()) || "1.0, 0.0".equals(map1.makeString()));
        CharFloatMap map2 = this.newWithKeysValues((char) 1, 1.0f, (char) 32, 32.0f);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1.0/32.0]".equals(map2.makeString("[", "/", "]")) || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));
        CharFloatMap map3 = this.newWithKeysValues((char) 0, 0.0f, (char) 32, 32.0f);
        Assert.assertTrue(map3.makeString("~"), "0.0~32.0".equals(map3.makeString("~")) || "32.0~0.0".equals(map3.makeString("~")));
        CharFloatMap map4 = this.newWithKeysValues((char) 32, 32.0f, (char) 33, 33.0f);
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
        this.newWithKeysValues((char) 0, 0.0f).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());
        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((char) 0, 0.0f).appendString(appendable01, "/");
        Assert.assertEquals("0.0", appendable01.toString());
        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((char) 0, 0.0f).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0.0}", appendable02.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((char) 1, 1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((char) 5, 5.0f).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        CharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0.0, 1.0".equals(appendable3.toString()) || "1.0, 0.0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        CharFloatMap map2 = this.newWithKeysValues((char) 1, 1.0f, (char) 32, 32.0f);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[1.0/32.0]".equals(appendable4.toString()) || "[32.0/1.0]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        CharFloatMap map3 = this.newWithKeysValues((char) 1, 1.0f, (char) 32, 32.0f);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[1.0/32.0]".equals(appendable5.toString()) || "[32.0/1.0]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "0.0/1.0".equals(appendable6.toString()) || "1.0/0.0".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        CharFloatMap actual1 = map.select((char key, float value) -> key == (char) 1 || Float.compare(value, 3.0f) == 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 3, 3.0f), actual1);
        CharFloatMap actual2 = map.select((char key, float value) -> key == (char) 0 || Float.compare(value, 2.0f) == 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 2, 2.0f), actual2);
    }

    @Test
    public void reject() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        CharFloatMap actual1 = map.reject((char key, float value) -> key == (char) 1 || Float.compare(value, 3.0f) == 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 2, 2.0f), actual1);
        CharFloatMap actual2 = map.reject((char key, float value) -> key == (char) 0 || Float.compare(value, 2.0f) == 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 3, 3.0f), actual2);
    }

    @Test
    public void select_value() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        FloatIterable actual1 = map.select(FloatPredicates.greaterThan(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(2.0f, 3.0f), actual1);
        FloatIterable actual2 = map.select(FloatPredicates.lessThan(2.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f, 1.0f), actual2);
    }

    @Test
    public void reject_value() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        FloatIterable actual1 = map.reject(FloatPredicates.lessThan(2.0f));
        Assert.assertEquals(FloatBags.immutable.with(2.0f, 3.0f), actual1);
        FloatIterable actual2 = map.reject(FloatPredicates.greaterThan(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f, 1.0f), actual2);
    }

    @Test
    public void collect() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        FloatToObjectFunction<Float> function = parameter -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1.0f, 2.0f, 3.0f, 4.0f), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2.0f), this.newWithKeysValues((char) 1, 1.0f).collect(function));
    }

    @Test
    public void count() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(2, map.count(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(2, map.count(FloatPredicates.lessThan(2.0f)));
    }

    @Test
    public void detectIfNone_value() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        float resultNotFound = map.detectIfNone(FloatPredicates.greaterThan(5.0f), 5.0f);
        Assert.assertEquals(5.0f, resultNotFound, 0.0);
        Assert.assertEquals(5.0f, this.getEmptyMap().detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(5.0f, this.newWithKeysValues((char) 1, 1.0f).detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(1.0f, this.newWithKeysValues((char) 1, 1.0f).detectIfNone(FloatPredicates.equal(1.0f), 5.0f), 0.0);
        Assert.assertEquals(0.0f, map.detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(1.0f, map.detectIfNone(FloatPredicates.equal(1.0f), 5.0f), 0.0);
        Assert.assertEquals(2.0f, map.detectIfNone(FloatPredicates.equal(2.0f), 5.0f), 0.0);
    }

    @Test
    public void anySatisfy() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1.0f).anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1.0f).anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertFalse(map.anySatisfy(FloatPredicates.greaterThan(5.0f)));
    }

    @Test
    public void allSatisfy() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1.0f).allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1.0f).allSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertTrue(map.allSatisfy(FloatPredicates.lessThan(5.0f)));
        CharFloatMap map1 = this.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertFalse(map1.allSatisfy(FloatPredicates.equal(0.0f)));
    }

    @Test
    public void noneSatisfy() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1.0f).noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1.0f).noneSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertTrue(map.noneSatisfy(FloatPredicates.lessThan(0.0f)));
    }

    @Test
    public void max() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(3.0f, map.max(), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((char) 3, 3.0f).max(), 0.0);
    }

    @Test
    public void min() {
        CharFloatMap map = this.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 0, 0.0f);
        Assert.assertEquals(0.0f, map.min(), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((char) 3, 3.0f).min(), 0.0);
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
        Assert.assertEquals(5.0, this.getEmptyMap().minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().minIfEmpty(0.0f), 0.0);
        CharFloatMap map = this.newWithKeysValues((char) 1, 1.0f, (char) 0, 0.0f, (char) 9, 9.0f, (char) 7, 7.0f);
        Assert.assertEquals(0.0, map.minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((char) 3, 3.0f).maxIfEmpty(5.0f), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, this.getEmptyMap().maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().maxIfEmpty(0.0f), 0.0);
        CharFloatMap map = this.newWithKeysValues((char) 1, 1.0f, (char) 0, 0.0f, (char) 9, 9.0f, (char) 7, 7.0f);
        Assert.assertEquals(9.0, map.maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((char) 3, 3.0f).minIfEmpty(5.0f), 0.0);
    }

    @Test
    public void sum() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(6.0f, map.sum(), 0.0);
        CharFloatMap map2 = this.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Assert.assertEquals(9.0f, map2.sum(), 0.0);
        CharFloatMap map3 = this.newWithKeysValues((char) 2, 2.0f);
        Assert.assertEquals(2.0f, map3.sum(), 0.0);
    }

    @Test
    public void average() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(1.5, map.average(), 0.0);
        CharFloatMap map1 = this.newWithKeysValues((char) 1, 1.0f);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(1.5, map.median(), 0.0);
        CharFloatMap map2 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        CharFloatMap map3 = this.newWithKeysValues((char) 1, 1.0f);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toList() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.newWithKeysValues((char) 0, 0.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWithKeysValues((char) 1, 1.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(2.0f), this.newWithKeysValues((char) 2, 2.0f).toList());
        Assert.assertTrue(this.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f).toList().equals(FloatArrayList.newListWith(2.0f, 3.0f)) || this.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f).toList().equals(FloatArrayList.newListWith(3.0f, 2.0f)));
    }

    @Test
    public void toSortedList() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f), map.toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWithKeysValues((char) 1, 1.0f).toSortedList());
    }

    @Test
    public void toSet() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 3.0f), map.toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), this.newWithKeysValues((char) 1, 1.0f).toSet());
    }

    @Test
    public void toBag() {
        CharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f, 3.0f), map.toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.newWithKeysValues((char) 1, 1.0f).toBag());
    }

    @Test
    public void floatIterator() {
        MutableFloatSet expected = FloatHashSet.newSetWith(0.0f, 31.0f, 32.0f);
        MutableFloatSet actual = FloatHashSet.newSetWith();
        FloatIterator iterator = this.map.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().floatIterator().next());
    }

    @Test
    public void asLazy() {
        LazyFloatIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0.0f, 31.0f, 32.0f));
    }

    @Test
    public void keysView() {
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 31, (char) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView() {
        MutableBag<CharFloatPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((char key, float value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new float[] { 0.0f, 31.0f, 32.0f }, this.map.toSortedArray()));
    }

    @Test
    public void toArray() {
        CharFloatMap map = this.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f);
        float[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new float[] { 1.0f, 2.0f }, array) || Arrays.equals(new float[] { 2.0f, 1.0f }, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new float[] { 1.0f }, this.newWithKeysValues((char) 1, 1.0f).toArray()));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableCharFloatMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk() {
        FloatIterable iterable = this.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f), FloatBags.mutable.with(2.0f), FloatBags.mutable.with(3.0f)).toSet(), iterable.chunk(1).toSet());
        Assert.assertTrue(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f), FloatBags.mutable.with(3.0f)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(FloatBags.mutable.with(2.0f, 3.0f), FloatBags.mutable.with(1.0f)).toSet().equals(iterable.chunk(2).toSet()) || Lists.mutable.with(FloatBags.mutable.with(1.0f, 3.0f), FloatBags.mutable.with(2.0f)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(3).toSet());
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(), iterable.chunk(4).toSet());
        Assert.assertEquals(Lists.mutable.with(FloatBags.mutable.with(1.0f)).toSet(), this.newWithKeysValues((char) 1, 1.0f).chunk(1).toSet());
        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((char) 1, 1.0f).chunk(-1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharFloatMapTestCase instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharFloatMapTestCase> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractCharFloatMapTestCase::keySet;
            this.payloads.values = AbstractCharFloatMapTestCase::values;
            this.payloads.get = AbstractCharFloatMapTestCase::get;
            this.payloads.getIfAbsent = AbstractCharFloatMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractCharFloatMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractCharFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractCharFloatMapTestCase::containsValue;
            this.payloads.contains = AbstractCharFloatMapTestCase::contains;
            this.payloads.containsAll = AbstractCharFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractCharFloatMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractCharFloatMapTestCase::size;
            this.payloads.isEmpty = AbstractCharFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractCharFloatMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractCharFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractCharFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractCharFloatMapTestCase::testToString;
            this.payloads.forEach = AbstractCharFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractCharFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractCharFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractCharFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractCharFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractCharFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractCharFloatMapTestCase::appendString;
            this.payloads.select = AbstractCharFloatMapTestCase::select;
            this.payloads.reject = AbstractCharFloatMapTestCase::reject;
            this.payloads.select_value = AbstractCharFloatMapTestCase::select_value;
            this.payloads.reject_value = AbstractCharFloatMapTestCase::reject_value;
            this.payloads.collect = AbstractCharFloatMapTestCase::collect;
            this.payloads.count = AbstractCharFloatMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractCharFloatMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractCharFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractCharFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractCharFloatMapTestCase::noneSatisfy;
            this.payloads.max = AbstractCharFloatMapTestCase::max;
            this.payloads.min = AbstractCharFloatMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractCharFloatMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractCharFloatMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractCharFloatMapTestCase::sum;
            this.payloads.average = AbstractCharFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractCharFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractCharFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractCharFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractCharFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractCharFloatMapTestCase::toBag;
            this.payloads.floatIterator = AbstractCharFloatMapTestCase::floatIterator;
            this.payloads.asLazy = AbstractCharFloatMapTestCase::asLazy;
            this.payloads.keysView = AbstractCharFloatMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractCharFloatMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractCharFloatMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractCharFloatMapTestCase::toArray;
            this.payloads.toImmutable = AbstractCharFloatMapTestCase::toImmutable;
            this.payloads.chunk = AbstractCharFloatMapTestCase::chunk;
        }
    }
}
