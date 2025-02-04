/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectBooleanMap;
import org.eclipse.collections.api.map.primitive.ObjectBooleanMap;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractObjectBooleanMapTestCase {

    protected abstract ObjectBooleanMap<String> classUnderTest();

    protected abstract <T> ObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1);

    protected abstract <T> ObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2);

    protected abstract <T> ObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3);

    protected abstract <T> ObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3, T key4, boolean value4);

    protected abstract <T> ObjectBooleanMap<T> getEmptyMap();

    @Test
    public void get() {
        Assert.assertTrue(this.classUnderTest().get("0"));
        Assert.assertTrue(this.classUnderTest().get("1"));
        Assert.assertFalse(this.classUnderTest().get("2"));
        Assert.assertFalse(this.classUnderTest().get("5"));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent("0", false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent("1", false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent("2", true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent("5", true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent("5", false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(null, true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(null, false));
    }

    @Test
    public void getOrThrow() {
        Assert.assertTrue(this.classUnderTest().getOrThrow("0"));
        Assert.assertTrue(this.classUnderTest().getOrThrow("1"));
        Assert.assertFalse(this.classUnderTest().getOrThrow("2"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey("0"));
        Assert.assertTrue(this.classUnderTest().containsKey("1"));
        Assert.assertTrue(this.classUnderTest().containsKey("2"));
        Assert.assertFalse(this.classUnderTest().containsKey("3"));
        Assert.assertFalse(this.classUnderTest().containsKey(null));
    }

    @Test
    public void containsValue() {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertTrue(this.classUnderTest().containsValue(false));
    }

    @Test
    public void size() {
        Verify.assertEmpty(this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, false));
        Verify.assertSize(1, this.newWithKeysValues(1, true));
        Verify.assertSize(1, this.newWithKeysValues(null, false));
        Verify.assertSize(2, this.newWithKeysValues(1, false, 5, false));
        Verify.assertSize(2, this.newWithKeysValues(0, true, 5, true));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, true).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, true).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, false).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, false).notEmpty());
    }

    @Test
    public void testEquals() {
        ObjectBooleanMap<Integer> map1 = this.newWithKeysValues(0, true, 1, false, null, false);
        ObjectBooleanMap<Integer> map2 = this.newWithKeysValues(null, false, 0, true, 1, false);
        ObjectBooleanMap<Integer> map3 = this.newWithKeysValues(0, true, 1, true, null, false);
        ObjectBooleanMap<Integer> map4 = this.newWithKeysValues(0, false, 1, false, null, false);
        ObjectBooleanMap<Integer> map5 = this.newWithKeysValues(0, true, 1, false, null, true);
        ObjectBooleanMap<Integer> map6 = this.newWithKeysValues(null, true, 60, false, 70, true);
        ObjectBooleanMap<Integer> map7 = this.newWithKeysValues(null, true, 60, false);
        ObjectBooleanMap<Integer> map8 = this.newWithKeysValues(0, true, 1, false);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, false, 1, true, 32, true).hashCode(), this.newWithKeysValues(32, true, 0, false, 1, true).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, true, 60, true, null, false).hashCode(), this.newWithKeysValues(50, true, 60, true, null, false).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=false}", this.newWithKeysValues(0, false).toString());
        Assert.assertEquals("{1=true}", this.newWithKeysValues(1, true).toString());
        Assert.assertEquals("{5=true}", this.newWithKeysValues(5, true).toString());
        ObjectBooleanMap<Integer> map1 = this.newWithKeysValues(0, true, 1, false);
        Assert.assertTrue(map1.toString(), "{0=true, 1=false}".equals(map1.toString()) || "{1=false, 0=true}".equals(map1.toString()));
        ObjectBooleanMap<Integer> map2 = this.newWithKeysValues(1, false, null, true);
        Assert.assertTrue(map2.toString(), "{1=false, null=true}".equals(map2.toString()) || "{null=true, 1=false}".equals(map2.toString()));
        ObjectBooleanMap<Integer> map3 = this.newWithKeysValues(1, true, null, true);
        Assert.assertTrue(map3.toString(), "{1=true, null=true}".equals(map3.toString()) || "{null=true, 1=true}".equals(map3.toString()));
    }

    @Test
    public void forEachValue() {
        ObjectBooleanMap<Integer> map01 = this.newWithKeysValues(0, true, 1, false);
        String[] sum01 = new String[1];
        sum01[0] = "";
        map01.forEachValue(each -> sum01[0] += String.valueOf(each));
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        ObjectBooleanMap<Integer> map = this.newWithKeysValues(3, true, 4, true);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachValue(each -> sum[0] += String.valueOf(each));
        Assert.assertEquals("truetrue", sum[0]);
        ObjectBooleanMap<Integer> map1 = this.newWithKeysValues(3, false, null, true);
        String[] sum1 = new String[1];
        sum1[0] = "";
        map1.forEachValue(each -> sum1[0] += String.valueOf(each));
        Assert.assertTrue("truefalse".equals(sum1[0]) || "falsetrue".equals(sum1[0]));
    }

    @Test
    public void forEach() {
        ObjectBooleanMap<Integer> map01 = this.newWithKeysValues(0, true, 1, false);
        String[] sum01 = new String[1];
        sum01[0] = "";
        map01.forEach(each -> sum01[0] += String.valueOf(each));
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));
        ObjectBooleanMap<Integer> map = this.newWithKeysValues(3, true, 4, true);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEach(each -> sum[0] += String.valueOf(each));
        Assert.assertEquals("truetrue", sum[0]);
        ObjectBooleanMap<Integer> map1 = this.newWithKeysValues(3, false, null, true);
        String[] sum1 = new String[1];
        sum1[0] = "";
        map1.forEach(each -> sum1[0] += String.valueOf(each));
        Assert.assertTrue("truefalse".equals(sum1[0]) || "falsetrue".equals(sum1[0]));
    }

    @Test
    public void forEachKey() {
        ObjectBooleanMap<Integer> map01 = this.newWithKeysValues(0, true, 1, false);
        int[] sum01 = new int[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        ObjectBooleanMap<Integer> map = this.newWithKeysValues(3, false, null, true);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue() {
        ObjectBooleanMap<Integer> map01 = this.newWithKeysValues(0, true, 1, false);
        String[] sumValue01 = new String[1];
        sumValue01[0] = "";
        int[] sumKey01 = new int[1];
        map01.forEachKeyValue((eachKey, eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertTrue("truefalse".equals(sumValue01[0]) || "falsetrue".equals(sumValue01[0]));
        ObjectBooleanMap<Integer> map = this.newWithKeysValues(3, true, null, false);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        String[] sumValue = new String[1];
        sumValue[0] = "";
        map.forEachKeyValue((eachKey, eachValue) -> {
            sumKey[0] += String.valueOf(eachKey);
            sumValue[0] += eachValue;
        });
        Assert.assertTrue(sumKey[0], "3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertTrue("truefalse".equals(sumValue[0]) || "falsetrue".equals(sumValue[0]));
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("true", this.newWithKeysValues(0, true).makeString());
        Assert.assertEquals("false", this.newWithKeysValues(1, false).makeString());
        Assert.assertEquals("true", this.newWithKeysValues(null, true).makeString());
        ObjectBooleanMap<Integer> map2 = this.newWithKeysValues(1, true, 32, false);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[true/false]".equals(map2.makeString("[", "/", "]")) || "[false/true]".equals(map2.makeString("[", "/", "]")));
        Assert.assertTrue(map2.makeString("/"), "true/false".equals(map2.makeString("/")) || "false/true".equals(map2.makeString("/")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, true).appendString(appendable0);
        Assert.assertEquals("true", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, false).appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, false).appendString(appendable2);
        Assert.assertEquals("false", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ObjectBooleanMap<Integer> map1 = this.newWithKeysValues(0, true, 1, false);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "true, false".equals(appendable3.toString()) || "false, true".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        map1.appendString(appendable4, "/");
        Assert.assertTrue(appendable4.toString(), "true/false".equals(appendable4.toString()) || "false/true".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        map1.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[true/false]".equals(appendable5.toString()) || "[false/true]".equals(appendable5.toString()));
    }

    @Test
    public void select() {
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true), this.classUnderTest().select(BooleanPredicates.isTrue()).toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(false), this.classUnderTest().select(BooleanPredicates.isFalse()).toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true, false), this.classUnderTest().select(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())).toBag());
        Assert.assertEquals(new BooleanHashBag(), this.classUnderTest().select(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())).toBag());
        Assert.assertEquals(this.newWithKeysValues("0", true), this.classUnderTest().select((object, value) -> (Integer.parseInt(object) & 1) == 0 && value));
        Assert.assertEquals(this.newWithKeysValues("2", false), this.classUnderTest().select((object, value) -> (Integer.parseInt(object) & 1) == 0 && !value));
        Assert.assertEquals(ObjectBooleanHashMap.newMap(), this.classUnderTest().select((object, value) -> (Integer.parseInt(object) & 1) != 0 && !value));
    }

    @Test
    public void reject() {
        Assert.assertEquals(BooleanHashBag.newBagWith(false), this.classUnderTest().reject(BooleanPredicates.isTrue()).toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true), this.classUnderTest().reject(BooleanPredicates.isFalse()).toBag());
        Assert.assertEquals(new BooleanHashBag(), this.classUnderTest().reject(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())).toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(true, true, false), this.classUnderTest().reject(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())).toBag());
        Assert.assertEquals(this.newWithKeysValues("1", true, "2", false), this.classUnderTest().reject((object, value) -> (Integer.parseInt(object) & 1) == 0 && value));
        Assert.assertEquals(this.newWithKeysValues("0", true, "1", true), this.classUnderTest().reject((object, value) -> (Integer.parseInt(object) & 1) == 0 && !value));
        Assert.assertEquals(this.newWithKeysValues("0", true, "1", true, "2", false), this.classUnderTest().reject((object, value) -> (Integer.parseInt(object) & 1) != 0 && !value));
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, this.classUnderTest().count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1L, this.classUnderTest().count(BooleanPredicates.isFalse()));
        Assert.assertEquals(3L, this.classUnderTest().count(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Assert.assertEquals(0L, this.classUnderTest().count(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void detectIfNone() {
        Assert.assertTrue(this.classUnderTest().detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(this.classUnderTest().detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(this.newWithKeysValues("0", true, "1", true).detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), false));
    }

    @Test
    public void collect() {
        ObjectBooleanMap<String> map1 = this.newWithKeysValues("0", true, "1", false);
        ObjectBooleanMap<String> map2 = this.newWithKeysValues("0", true);
        ObjectBooleanMap<String> map3 = this.newWithKeysValues("0", false);
        Assert.assertTrue(FastList.newListWith("true", "false").equals(map1.collect(String::valueOf)) || FastList.newListWith("false", "true").equals(map1.collect(String::valueOf)));
        Assert.assertEquals(FastList.newListWith("true"), map2.collect(String::valueOf));
        Assert.assertEquals(FastList.newListWith("false"), map3.collect(String::valueOf));
    }

    @Test
    public void toArray() {
        ObjectBooleanMap<String> map1 = this.newWithKeysValues(null, true, "1", false);
        ObjectBooleanMap<String> map2 = this.newWithKeysValues("0", true);
        ObjectBooleanMap<String> map3 = this.newWithKeysValues("0", false);
        Assert.assertTrue(Arrays.equals(new boolean[] { true, false }, map1.toArray()) || Arrays.equals(new boolean[] { false, true }, map1.toArray()));
        Assert.assertTrue(Arrays.equals(new boolean[] { true }, map2.toArray()));
        Assert.assertTrue(Arrays.equals(new boolean[] { false }, map3.toArray()));
    }

    @Test
    public void toArrayWithTargetArray() {
        ObjectBooleanMap<String> map1 = this.newWithKeysValues(null, true, "1", false);
        ObjectBooleanMap<String> map2 = this.newWithKeysValues("0", true);
        ObjectBooleanMap<String> map3 = this.newWithKeysValues("0", false);
        Assert.assertTrue(Arrays.equals(new boolean[] { true, false }, map1.toArray(new boolean[] {})) || Arrays.equals(new boolean[] { false, true }, map1.toArray(new boolean[] {})));
        Assert.assertTrue(Arrays.equals(new boolean[] { true, false }, map1.toArray(new boolean[map1.size()])) || Arrays.equals(new boolean[] { false, true }, map1.toArray(new boolean[map1.size()])));
        Assert.assertTrue(Arrays.equals(new boolean[] { true }, map2.toArray(new boolean[] {})));
        Assert.assertTrue(Arrays.equals(new boolean[] { true }, map2.toArray(new boolean[map2.size()])));
        Assert.assertTrue(Arrays.equals(new boolean[] { false }, map3.toArray(new boolean[] {})));
        Assert.assertTrue(Arrays.equals(new boolean[] { false }, map3.toArray(new boolean[map3.size()])));
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
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false, false)));
    }

    @Test
    public void toList() {
        ObjectBooleanMap<String> map1 = this.newWithKeysValues(null, true, "1", false);
        ObjectBooleanMap<String> map2 = this.newWithKeysValues("0", true);
        ObjectBooleanMap<String> map3 = this.newWithKeysValues("0", false);
        Assert.assertTrue(map1.toList().toString(), BooleanArrayList.newListWith(true, false).equals(map1.toList()) || BooleanArrayList.newListWith(false, true).equals(map1.toList()));
        Assert.assertEquals(BooleanArrayList.newListWith(true), map2.toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), map3.toList());
    }

    @Test
    public void toSet() {
        ObjectBooleanMap<String> map1 = this.newWithKeysValues("1", false, null, true, "2", false);
        ObjectBooleanMap<String> map0 = this.newWithKeysValues("1", false, null, true, "2", true);
        ObjectBooleanMap<String> map2 = this.newWithKeysValues("0", true);
        ObjectBooleanMap<String> map3 = this.newWithKeysValues("0", false);
        Assert.assertEquals(BooleanHashSet.newSetWith(false, true), map1.toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(false, true), map0.toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(true), map2.toSet());
        Assert.assertEquals(BooleanHashSet.newSetWith(false), map3.toSet());
    }

    @Test
    public void toBag() {
        ObjectBooleanMap<String> map1 = this.newWithKeysValues("1", false, null, true, "2", false);
        ObjectBooleanMap<String> map0 = this.newWithKeysValues("1", false, null, true, "2", true);
        ObjectBooleanMap<String> map2 = this.newWithKeysValues("0", true);
        ObjectBooleanMap<String> map3 = this.newWithKeysValues("0", false);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, false, true), map1.toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(false, true, true), map0.toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(true), map2.toBag());
        Assert.assertEquals(BooleanHashBag.newBagWith(false), map3.toBag());
    }

    @Test
    public void asLazy() {
        Verify.assertSize(this.classUnderTest().toList().size(), this.classUnderTest().asLazy().toList());
        Assert.assertTrue(this.classUnderTest().asLazy().toList().containsAll(this.classUnderTest().toList()));
    }

    @Test
    public void iterator() {
        ObjectBooleanMap<String> map1 = this.newWithKeysValues(null, true, "EclipseCollections", false);
        ObjectBooleanMap<String> map2 = this.newWithKeysValues("0", true);
        ObjectBooleanMap<String> map3 = this.newWithKeysValues("0", false);
        BooleanIterator iterator1 = map1.booleanIterator();
        Assert.assertTrue(iterator1.hasNext());
        boolean first = iterator1.next();
        Assert.assertTrue(iterator1.hasNext());
        boolean second = iterator1.next();
        Assert.assertEquals(first, !second);
        Assert.assertFalse(iterator1.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator1::next);
        BooleanIterator iterator2 = map2.booleanIterator();
        Assert.assertTrue(iterator2.hasNext());
        Assert.assertTrue(iterator2.next());
        Assert.assertFalse(iterator2.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator2::next);
        BooleanIterator iterator3 = map3.booleanIterator();
        Assert.assertTrue(iterator3.hasNext());
        Assert.assertFalse(iterator3.next());
        Assert.assertFalse(iterator3.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator3::next);
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectBooleanMap.class, this.classUnderTest().toImmutable());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectBooleanMapTestCase instance;

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
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectBooleanMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractObjectBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractObjectBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractObjectBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractObjectBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractObjectBooleanMapTestCase::containsValue;
            this.payloads.size = AbstractObjectBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractObjectBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractObjectBooleanMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractObjectBooleanMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractObjectBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractObjectBooleanMapTestCase::testToString;
            this.payloads.forEachValue = AbstractObjectBooleanMapTestCase::forEachValue;
            this.payloads.forEach = AbstractObjectBooleanMapTestCase::forEach;
            this.payloads.forEachKey = AbstractObjectBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractObjectBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractObjectBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractObjectBooleanMapTestCase::appendString;
            this.payloads.select = AbstractObjectBooleanMapTestCase::select;
            this.payloads.reject = AbstractObjectBooleanMapTestCase::reject;
            this.payloads.count = AbstractObjectBooleanMapTestCase::count;
            this.payloads.anySatisfy = AbstractObjectBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractObjectBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractObjectBooleanMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractObjectBooleanMapTestCase::detectIfNone;
            this.payloads.collect = AbstractObjectBooleanMapTestCase::collect;
            this.payloads.toArray = AbstractObjectBooleanMapTestCase::toArray;
            this.payloads.toArrayWithTargetArray = AbstractObjectBooleanMapTestCase::toArrayWithTargetArray;
            this.payloads.contains = AbstractObjectBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractObjectBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractObjectBooleanMapTestCase::containsAllIterable;
            this.payloads.toList = AbstractObjectBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractObjectBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractObjectBooleanMapTestCase::toBag;
            this.payloads.asLazy = AbstractObjectBooleanMapTestCase::asLazy;
            this.payloads.iterator = AbstractObjectBooleanMapTestCase::iterator;
            this.payloads.toImmutable = AbstractObjectBooleanMapTestCase::toImmutable;
        }
    }
*/
}
