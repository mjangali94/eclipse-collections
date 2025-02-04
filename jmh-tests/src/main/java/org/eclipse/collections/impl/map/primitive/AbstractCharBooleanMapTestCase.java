/*
 * Copyright (c) 2022 Goldman Sachs.
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
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.map.primitive.CharBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.api.tuple.primitive.CharBooleanPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractCharBooleanMapTestCase {

    protected abstract CharBooleanMap classUnderTest();

    protected abstract CharBooleanMap newWithKeysValues(char key1, boolean value1);

    protected abstract CharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2);

    protected abstract CharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3);

    protected abstract CharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3, char key4, boolean value4);

    protected abstract CharBooleanMap getEmptyMap();

    @Test
    public void get() {
        Assert.assertTrue(this.classUnderTest().get((char) 0));
        Assert.assertFalse(this.classUnderTest().get((char) 31));
        Assert.assertTrue(this.classUnderTest().get((char) 32));
        Assert.assertFalse(this.classUnderTest().get((char) 1));
        Assert.assertFalse(this.classUnderTest().get((char) 33));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent((char) 0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent((char) 31, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((char) 32, false));
    }

    @Test
    public void getOrThrow() {
        Assert.assertTrue(this.classUnderTest().getOrThrow((char) 0));
        Assert.assertFalse(this.classUnderTest().getOrThrow((char) 31));
        Assert.assertTrue(this.classUnderTest().getOrThrow((char) 32));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((char) 1));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((char) 33));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey((char) 0));
        Assert.assertTrue(this.classUnderTest().containsKey((char) 31));
        Assert.assertTrue(this.classUnderTest().containsKey((char) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 35));
    }

    @Test
    public void containsValue() {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertTrue(this.classUnderTest().containsValue(false));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(true));
        Assert.assertTrue(this.classUnderTest().contains(false));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.classUnderTest().containsAll(true, false));
        Assert.assertTrue(this.classUnderTest().containsAll(true, true));
        Assert.assertTrue(this.classUnderTest().containsAll(false, false));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues((char) 0, false));
        Verify.assertSize(1, this.newWithKeysValues((char) 1, true));
        Verify.assertSize(2, this.newWithKeysValues((char) 1, true, (char) 5, false));
        Verify.assertSize(2, this.newWithKeysValues((char) 0, false, (char) 5, false));
        Verify.assertSize(3, this.newWithKeysValues((char) 1, true, (char) 0, true, (char) 5, true));
        Verify.assertSize(2, this.newWithKeysValues((char) 6, false, (char) 5, true));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 1, true).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 0, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 50, true).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 1, false).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 0, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 50, false).notEmpty());
    }

    @Test
    public void testEquals() {
        CharBooleanMap map1 = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 32, true);
        CharBooleanMap map2 = this.newWithKeysValues((char) 32, true, (char) 0, true, (char) 1, false);
        CharBooleanMap map3 = this.newWithKeysValues((char) 0, true, (char) 1, true, (char) 32, true);
        CharBooleanMap map4 = this.newWithKeysValues((char) 0, false, (char) 1, false, (char) 32, true);
        CharBooleanMap map5 = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 32, false);
        CharBooleanMap map6 = this.newWithKeysValues((char) 50, true, (char) 60, false, (char) 70, false);
        CharBooleanMap map7 = this.newWithKeysValues((char) 50, true, (char) 60, false);
        CharBooleanMap map8 = this.newWithKeysValues((char) 0, true, (char) 1, false);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 0, true, (char) 1, false, (char) 32, true).hashCode(), this.newWithKeysValues((char) 32, true, (char) 0, true, (char) 1, false).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 50, true, (char) 60, false, (char) 70, false).hashCode(), this.newWithKeysValues((char) 50, true, (char) 60, false, (char) 70, false).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{\u0000=true}", this.newWithKeysValues((char) 0, true).toString());
        Assert.assertEquals("{\u0001=false}", this.newWithKeysValues((char) 1, false).toString());
        Assert.assertEquals("{\u0005=false}", this.newWithKeysValues((char) 5, false).toString());
        CharBooleanMap map1 = this.newWithKeysValues((char) 0, true, (char) 1, false);
        Assert.assertTrue(map1.toString(), "{\u0000=true, \u0001=false}".equals(map1.toString()) || "{\u0001=false, \u0000=true}".equals(map1.toString()));
        CharBooleanMap map2 = this.newWithKeysValues((char) 1, false, (char) 32, true);
        Assert.assertTrue(map2.toString(), "{\u0001=false, \u0020=true}".equals(map2.toString()) || "{\u0020=true, \u0001=false}".equals(map2.toString()));
        CharBooleanMap map3 = this.newWithKeysValues((char) 0, true, (char) 32, true);
        Assert.assertTrue(map3.toString(), "{\u0000=true, \u0020=true}".equals(map3.toString()) || "{\u0020=true, \u0000=true}".equals(map3.toString()));
        CharBooleanMap map4 = this.newWithKeysValues((char) 32, true, (char) 33, false);
        Assert.assertTrue(map4.toString(), "{\u0020=true, \u0021=false}".equals(map4.toString()) || "{\u0021=false, \u0020=true}".equals(map4.toString()));
    }

    @Test
    public void forEach() {
        CharBooleanMap map0 = this.newWithKeysValues((char) 0, false, (char) 3, true);
        String[] sum0 = { "" };
        map0.forEach((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        CharBooleanMap map1 = this.newWithKeysValues((char) 1, true, (char) 3, true);
        String[] sum1 = { "" };
        map1.forEach((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        CharBooleanMap map01 = this.newWithKeysValues((char) 0, false, (char) 1, true);
        String[] sum01 = { "" };
        map01.forEach((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        CharBooleanMap map = this.newWithKeysValues((char) 3, false, (char) 4, false);
        String[] sum = { "" };
        map.forEach((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachValue() {
        CharBooleanMap map0 = this.newWithKeysValues((char) 0, false, (char) 3, true);
        String[] sum0 = { "" };
        map0.forEachValue((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));
        CharBooleanMap map1 = this.newWithKeysValues((char) 1, true, (char) 3, true);
        String[] sum1 = { "" };
        map1.forEachValue((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);
        CharBooleanMap map01 = this.newWithKeysValues((char) 0, false, (char) 1, true);
        String[] sum01 = { "" };
        map01.forEachValue((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        CharBooleanMap map = this.newWithKeysValues((char) 3, false, (char) 4, false);
        String[] sum = { "" };
        map.forEachValue((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachKey() {
        CharBooleanMap map0 = this.newWithKeysValues((char) 0, true, (char) 3, false);
        char[] sum0 = new char[1];
        map0.forEachKey((char each) -> sum0[0] += each);
        Assert.assertEquals((char) 3, sum0[0]);
        CharBooleanMap map1 = this.newWithKeysValues((char) 1, false, (char) 3, false);
        char[] sum1 = new char[1];
        map1.forEachKey((char each) -> sum1[0] += each);
        Assert.assertEquals((char) 4, sum1[0]);
        CharBooleanMap map01 = this.newWithKeysValues((char) 0, true, (char) 1, true);
        char[] sum01 = new char[1];
        map01.forEachKey((char each) -> sum01[0] += each);
        Assert.assertEquals((char) 1, sum01[0]);
        CharBooleanMap map = this.newWithKeysValues((char) 3, false, (char) 4, true);
        char[] sum = new char[1];
        map.forEachKey((char each) -> sum[0] += each);
        Assert.assertEquals(7, sum[0]);
    }

    @Test
    public void forEachKeyValue() {
        CharBooleanMap map0 = this.newWithKeysValues((char) 0, true, (char) 3, true);
        char[] sumKey0 = new char[1];
        String[] sumValue0 = { "" };
        map0.forEachKeyValue((char eachKey, boolean eachValue) -> {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals((char) 3, sumKey0[0]);
        Assert.assertEquals("truetrue", sumValue0[0]);
        CharBooleanMap map1 = this.newWithKeysValues((char) 1, true, (char) 3, false);
        char[] sumKey1 = new char[1];
        String[] sumValue1 = { "" };
        map1.forEachKeyValue((char eachKey, boolean eachValue) -> {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals((char) 4, sumKey1[0]);
        Assert.assertTrue("truefalse".equals(sumValue1[0]) || "falsetrue".equals(sumValue1[0]));
        CharBooleanMap map01 = this.newWithKeysValues((char) 0, false, (char) 1, false);
        char[] sumKey01 = new char[1];
        String[] sumValue01 = { "" };
        map01.forEachKeyValue((char eachKey, boolean eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals((char) 1, sumKey01[0]);
        Assert.assertEquals("falsefalse", sumValue01[0]);
        CharBooleanMap map = this.newWithKeysValues((char) 3, false, (char) 4, true);
        char[] sumKey = new char[1];
        String[] sumValue = { "" };
        map.forEachKeyValue((char eachKey, boolean eachValue) -> {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7, sumKey[0]);
        Assert.assertTrue("truefalse".equals(sumValue[0]) || "falsetrue".equals(sumValue[0]));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("true", this.newWithKeysValues((char) 0, true).makeString());
        Assert.assertEquals("false", this.newWithKeysValues((char) 1, false).makeString());
        Assert.assertEquals("false", this.newWithKeysValues((char) 5, false).makeString());
        CharBooleanMap map1 = this.newWithKeysValues((char) 0, true, (char) 1, false);
        Assert.assertTrue(map1.makeString(), "true, false".equals(map1.makeString()) || "false, true".equals(map1.makeString()));
        CharBooleanMap map2 = this.newWithKeysValues((char) 1, false, (char) 32, true);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[false/true]".equals(map2.makeString("[", "/", "]")) || "true/false]".equals(map2.makeString("[", "/", "]")));
        CharBooleanMap map3 = this.newWithKeysValues((char) 0, true, (char) 32, true);
        Assert.assertTrue(map3.makeString("~"), "true~true".equals(map3.makeString("~")) || "true~true".equals(map3.makeString("~")));
        CharBooleanMap map4 = this.newWithKeysValues((char) 32, true, (char) 33, false);
        Assert.assertTrue(map4.makeString("[", ", ", "]"), "[true, false]".equals(map4.makeString("[", ", ", "]")) || "[false, true]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues((char) 0, true).appendString(appendable0);
        Assert.assertEquals("true", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((char) 1, false).appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((char) 5, false).appendString(appendable2);
        Assert.assertEquals("false", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        CharBooleanMap map1 = this.newWithKeysValues((char) 0, true, (char) 1, false);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "true, false".equals(appendable3.toString()) || "false, true".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        CharBooleanMap map2 = this.newWithKeysValues((char) 1, false, (char) 32, true);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[false/true]".equals(appendable4.toString()) || "[true/false]".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        CharBooleanMap map3 = this.newWithKeysValues((char) 1, false, (char) 32, true);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[false/true]".equals(appendable5.toString()) || "[true/false]".equals(appendable5.toString()));
        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(appendable6.toString(), "true/false".equals(appendable6.toString()) || "false/true".equals(appendable6.toString()));
    }

    @Test
    public void select() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, false, (char) 3, true);
        CharBooleanMap actual1 = map.select((char key, boolean value) -> key == (char) 1 || value);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 3, true, (char) 0, true), actual1);
        CharBooleanMap actual2 = map.select((char key, boolean value) -> key == (char) 0 || !value);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 2, false, (char) 1, false), actual2);
    }

    @Test
    public void reject() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, false, (char) 3, true);
        CharBooleanMap actual1 = map.reject((char key, boolean value) -> key == (char) 2 || !value);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 3, true), actual1);
        CharBooleanMap actual2 = map.reject((char key, boolean value) -> key == (char) 3 || value);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 2, false), actual2);
    }

    @Test
    public void select_value() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, true, (char) 3, false);
        BooleanIterable actual1 = map.select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual1);
        BooleanIterable actual2 = map.select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual2);
    }

    @Test
    public void reject_value() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, true, (char) 3, false);
        BooleanIterable actual1 = map.reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual1);
        BooleanIterable actual2 = map.reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual2);
    }

    @Test
    public void collect() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, true);
        RichIterable<Boolean> objects = map.collect((boolean booleanParameter) -> !booleanParameter);
        Assert.assertEquals(HashBag.newBagWith(false, true, false), objects.toBag());
    }

    @Test
    public void count() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, true);
        Assert.assertEquals(2, map.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1, map.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone_value() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, false);
        CharBooleanMap map2 = this.newWithKeysValues((char) 0, true, (char) 1, true, (char) 2, false);
        boolean resultNotFound = map.detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), true);
        Assert.assertTrue(resultNotFound);
        boolean resultNotFound2 = map.detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), false);
        Assert.assertFalse(resultNotFound2);
        Assert.assertTrue(map.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(map.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(map2.detectIfNone(BooleanPredicates.isFalse(), true));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.newWithKeysValues((char) 1, false, (char) 2, true).anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues((char) 1, true, (char) 2, false).allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues((char) 1, false, (char) 2, true).noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void toList() {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues((char) 0, true).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.newWithKeysValues((char) 1, false).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues((char) 2, true).toList());
    }

    @Test
    public void toSet() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), map.toSet());
    }

    @Test
    public void toBag() {
        CharBooleanMap map = this.newWithKeysValues((char) 0, true, (char) 1, false, (char) 2, true, (char) 3, false);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false), map.toBag());
    }

    @Test
    public void booleanIterator() {
        MutableBooleanBag expected = BooleanHashBag.newBagWith(true, false, true);
        MutableBooleanBag actual = BooleanHashBag.newBagWith();
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().booleanIterator().next());
    }

    @Test
    public void asLazy() {
        CharBooleanMap map = this.newWithKeysValues((char) 1, true, (char) 2, true, (char) 3, false);
        LazyBooleanIterable lazy = map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(true, true, false));
    }

    @Test
    public void keysView() {
        MutableCharList keys = this.newWithKeysValues((char) 1, true, (char) 2, false).keysView().toSortedList();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), keys);
    }

    @Test
    public void keyValuesView() {
        MutableBag<CharBooleanPair> expected = Bags.mutable.of();
        this.classUnderTest().forEachKeyValue((char key, boolean value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.classUnderTest().keyValuesView().toBag());
    }

    @Test
    public void toArray() {
        CharBooleanMap map = this.newWithKeysValues((char) 1, false, (char) 2, true);
        boolean[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new boolean[] { false, true }, array) || Arrays.equals(new boolean[] { true, false }, array));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableCharBooleanMap.class, this.classUnderTest().toImmutable());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharBooleanMapTestCase instance;

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
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharBooleanMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractCharBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractCharBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractCharBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractCharBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractCharBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractCharBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractCharBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractCharBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractCharBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractCharBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractCharBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractCharBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractCharBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractCharBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractCharBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractCharBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractCharBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractCharBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractCharBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractCharBooleanMapTestCase::appendString;
            this.payloads.select = AbstractCharBooleanMapTestCase::select;
            this.payloads.reject = AbstractCharBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractCharBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractCharBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractCharBooleanMapTestCase::collect;
            this.payloads.count = AbstractCharBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractCharBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractCharBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractCharBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractCharBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractCharBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractCharBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractCharBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractCharBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractCharBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractCharBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractCharBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractCharBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractCharBooleanMapTestCase::toImmutable;
        }
    }
*/
}
