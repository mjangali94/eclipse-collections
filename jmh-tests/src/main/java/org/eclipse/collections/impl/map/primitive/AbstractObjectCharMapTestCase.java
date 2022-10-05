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
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectCharMap;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.api.map.primitive.ObjectCharMap;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractObjectCharMapTestCase {

    private final ObjectCharMap<String> map = this.classUnderTest();

    protected abstract ObjectCharMap<String> classUnderTest();

    protected abstract <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1);

    protected abstract <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2);

    protected abstract <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3);

    protected abstract <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4);

    protected abstract <T> ObjectCharMap<T> getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0"), this.newWithKeysValues("0", (char) 0).keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0", "1", "2"), this.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ObjectCharMap<String> map = this.newWithKeysValues("0", (char) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((char) 0));
        ObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((char) 0));
        Assert.assertTrue(map1.values().contains((char) 1));
        Assert.assertTrue(map1.values().contains((char) 2));
    }

    @Test
    public void get() {
        Assert.assertEquals((char) 0, this.map.get("0"));
        Assert.assertEquals((char) 1, this.map.get("1"));
        Assert.assertEquals((char) 2, this.map.get("2"));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals((char) 0, this.map.getOrThrow("0"));
        Assert.assertEquals((char) 1, this.map.getOrThrow("1"));
        Assert.assertEquals((char) 2, this.map.getOrThrow("2"));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("5"));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(null));
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey("0"));
        Assert.assertTrue(this.map.containsKey("1"));
        Assert.assertTrue(this.map.containsKey("2"));
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertFalse(this.map.containsKey(null));
    }

    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue((char) 0));
        Assert.assertTrue(this.map.containsValue((char) 1));
        Assert.assertTrue(this.map.containsValue((char) 2));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, (char) 0));
        Verify.assertSize(1, this.newWithKeysValues(1, (char) 1));
        Verify.assertSize(1, this.newWithKeysValues(null, (char) 2));
        Verify.assertSize(2, this.newWithKeysValues(1, (char) 1, 5, (char) 5));
        Verify.assertSize(2, this.newWithKeysValues(0, (char) 0, 5, (char) 5));
        Verify.assertSize(3, this.newWithKeysValues(1, (char) 1, 0, (char) 0, 5, (char) 5));
        Verify.assertSize(2, this.newWithKeysValues(6, (char) 6, 5, (char) 5));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, (char) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, (char) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, (char) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, (char) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, (char) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, (char) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, (char) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, (char) 50).notEmpty());
    }

    @Test
    public void asLazy() {
        Verify.assertSize(this.map.toList().size(), this.map.asLazy().toList());
        Assert.assertTrue(this.map.asLazy().toList().containsAll(this.map.toList()));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals((char) 0, this.map.getIfAbsent("0", (char) 1));
        Assert.assertEquals((char) 1, this.map.getIfAbsent("1", (char) 2));
        Assert.assertEquals((char) 2, this.map.getIfAbsent("2", (char) 3));
        Assert.assertEquals((char) 1, this.map.getIfAbsent("5", (char) 1));
        Assert.assertEquals((char) 0, this.map.getIfAbsent("5", (char) 0));
        Assert.assertEquals((char) 1, this.map.getIfAbsent(null, (char) 1));
        Assert.assertEquals((char) 0, this.map.getIfAbsent(null, (char) 0));
    }

    @Test
    public void testEquals() {
        ObjectCharMap<Integer> map1 = this.newWithKeysValues(0, (char) 0, 1, (char) 1, null, (char) 2);
        ObjectCharMap<Integer> map2 = this.newWithKeysValues(null, (char) 2, 0, (char) 0, 1, (char) 1);
        ObjectCharMap<Integer> map3 = this.newWithKeysValues(0, (char) 0, 1, (char) 2, null, (char) 2);
        ObjectCharMap<Integer> map5 = this.newWithKeysValues(0, (char) 0, 1, (char) 1, null, (char) 3);
        ObjectCharMap<Integer> map7 = this.newWithKeysValues(null, (char) 2, 1, (char) 1);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map7);
        Assert.assertEquals(map1, ObjectCharMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ObjectCharMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, (char) 0, 1, (char) 1).hashCode(), this.newWithKeysValues(0, (char) 0, 1, (char) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, (char) 0, null, (char) 1).hashCode(), this.newWithKeysValues(50, (char) 0, null, (char) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.<Integer>getEmptyMap().toString());
        Assert.assertEquals("{0=\u0000}", this.newWithKeysValues(0, (char) 0).toString());
        ObjectCharMap<Integer> map1 = this.newWithKeysValues(0, (char) 0, 1, (char) 1);
        Assert.assertTrue(map1.toString(), "{0=\u0000, 1=\u0001}".equals(map1.toString()) || "{1=\u0001, 0=\u0000}".equals(map1.toString()));
        ObjectCharMap<Integer> map2 = this.newWithKeysValues(1, (char) 1, null, (char) 0);
        Assert.assertTrue(map2.toString(), "{1=\u0001, null=\u0000}".equals(map2.toString()) || "{null=\u0000, 1=\u0001}".equals(map2.toString()));
    }

    @Test
    public void charIterator() {
        MutableCharSet expected = CharHashSet.newSetWith((char) 0, (char) 1, (char) 2);
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
        Assert.assertThrows(NoSuchElementException.class, () -> {
            this.getEmptyMap().charIterator().next();
        });
    }

    @Test
    public void forEach() {
        ObjectCharMap<Integer> map01 = this.newWithKeysValues(0, (char) 1, 1, (char) 2);
        char[] sum01 = new char[1];
        map01.forEach(each -> {
            sum01[0] += each;
        });
        Assert.assertEquals((char) 3, sum01[0]);
        ObjectCharMap<Integer> map = this.newWithKeysValues(3, (char) 4, 4, (char) 5);
        char[] sum = new char[1];
        map.forEach(each -> {
            sum[0] += each;
        });
        Assert.assertEquals((char) 9, sum[0]);
        ObjectCharMap<Integer> map1 = this.newWithKeysValues(3, (char) 4, null, (char) 5);
        char[] sum1 = new char[1];
        map1.forEach(each -> {
            sum1[0] += each;
        });
        Assert.assertEquals((char) 9, sum1[0]);
    }

    @Test
    public void forEachValue() {
        ObjectCharMap<Integer> map01 = this.newWithKeysValues(0, (char) 1, 1, (char) 2);
        char[] sum01 = new char[1];
        map01.forEachValue((char each) -> sum01[0] += each);
        Assert.assertEquals((char) 3, sum01[0]);
        ObjectCharMap<Integer> map = this.newWithKeysValues(3, (char) 4, null, (char) 5);
        char[] sum = new char[1];
        map.forEachValue((char each) -> sum[0] += each);
        Assert.assertEquals((char) 9, sum[0]);
    }

    @Test
    public void forEachKey() {
        ObjectCharMap<Integer> map01 = this.newWithKeysValues(0, (char) 1, 1, (char) 2);
        int[] sum01 = new int[1];
        map01.forEachKey((Integer each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        ObjectCharMap<Integer> map = this.newWithKeysValues(3, (char) 4, null, (char) 5);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue() {
        ObjectCharMap<Integer> map01 = this.newWithKeysValues(0, (char) 1, 1, (char) 2);
        int[] sumKey01 = new int[1];
        char[] sumValue01 = new char[1];
        map01.forEachKeyValue((Integer eachKey, char eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals((char) 3, sumValue01[0]);
        ObjectCharMap<Integer> map = this.newWithKeysValues(3, (char) 4, null, (char) 5);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        char[] sumValue = new char[1];
        map.forEachKeyValue((Integer eachKey, char eachValue) -> {
            sumKey[0] += String.valueOf(eachKey);
            sumValue[0] += eachValue;
        });
        Assert.assertTrue("3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertEquals((char) 9, sumValue[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ObjectCharMap<String> map0 = this.newWithKeysValues("2", (char) 3, "4", (char) 5);
        String result0 = map0.injectIntoKeyValue(new String("1"), (result, eachKey, eachValue) -> result + eachKey + String.valueOf(eachValue));
        Assert.assertTrue(result0, "12\u00034\u0005".equals(result0) || "14\u00052\u0003".equals(result0));
        ObjectCharMap copy = map0.injectIntoKeyValue(ObjectCharMaps.mutable.empty(), MutableObjectCharMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("\u0000", this.newWithKeysValues(0, (char) 0).makeString());
        Assert.assertEquals("\u0001", this.newWithKeysValues(1, (char) 1).makeString());
        Assert.assertEquals("\u0005", this.newWithKeysValues(null, (char) 5).makeString());
        ObjectCharMap<Integer> map2 = this.newWithKeysValues(1, (char) 1, 32, (char) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[\u0001/\u0020]".equals(map2.makeString("[", "/", "]")) || "[\u0020/\u0001]".equals(map2.makeString("[", "/", "]")));
        Assert.assertTrue(map2.makeString("/"), "\u0001/\u0020".equals(map2.makeString("/")) || "\u0020/\u0001".equals(map2.makeString("/")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, (char) 0).appendString(appendable0);
        Assert.assertEquals("\u0000", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, (char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, (char) 5).appendString(appendable2);
        Assert.assertEquals("\u0005", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ObjectCharMap<Integer> map1 = this.newWithKeysValues(0, (char) 0, 1, (char) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "\u0000, \u0001".equals(appendable3.toString()) || "\u0001, \u0000".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        map1.appendString(appendable4, "/");
        Assert.assertTrue(appendable4.toString(), "\u0000/\u0001".equals(appendable4.toString()) || "\u0001/\u0000".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        map1.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[\u0000/\u0001]".equals(appendable5.toString()) || "[\u0001/\u0000]".equals(appendable5.toString()));
    }

    @Test
    public void select() {
        Assert.assertEquals(this.map, this.map.select((String object, char value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1), this.map.select((String object, char value) -> Integer.parseInt(object) + value < (char) 4));
        Assert.assertEquals(this.getEmptyMap(), this.map.select((String object, char value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2), this.map.select(value -> value < (char) 3).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1), this.map.select(value -> value < (char) 2).toBag());
        Assert.assertEquals(new CharHashBag(), this.map.select(value -> value > (char) 2).toBag());
    }

    @Test
    public void reject() {
        Assert.assertEquals(this.getEmptyMap(), this.map.reject((String object, char value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 2), this.map.reject((String object, char value) -> Integer.parseInt(object) + value < (char) 4));
        Assert.assertEquals(this.map, this.map.reject((String object, char value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(new CharHashBag(), this.map.reject(value -> value < (char) 3).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 2), this.map.reject(value -> value < (char) 2).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2), this.map.reject(value -> value > (char) 2).toBag());
    }

    @Test
    public void tap() {
        MutableCharList tapResult = CharLists.mutable.empty();
        Assert.assertSame(this.map, this.map.tap(tapResult::add));
        Assert.assertEquals(this.map.toList(), tapResult);
    }

    @Test
    public void count() {
        Assert.assertEquals(3L, this.map.count(value -> value < (char) 3));
        Assert.assertEquals(2L, this.map.count(value -> value < (char) 2));
        Assert.assertEquals(0L, this.map.count(value -> value > (char) 2));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.map.anySatisfy(value -> value < (char) 3));
        Assert.assertTrue(this.map.anySatisfy(value -> value < (char) 2));
        Assert.assertFalse(this.map.anySatisfy(value -> value > (char) 2));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.map.allSatisfy(value -> value < (char) 3));
        Assert.assertFalse(this.map.allSatisfy(value -> value < (char) 2));
        Assert.assertFalse(this.map.allSatisfy(value -> value > (char) 2));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.map.noneSatisfy(value -> value < (char) 0));
        Assert.assertFalse(this.map.noneSatisfy(value -> value < (char) 2));
    }

    @Test
    public void detectIfNone() {
        char detect = this.map.detectIfNone(value -> value < (char) 3, (char) 5);
        Assert.assertTrue(detect == 0 || detect == 1 || detect == 2);
        char detect1 = this.map.detectIfNone(value -> value < (char) 2, (char) 5);
        Assert.assertTrue(detect1 == 0 || detect1 == 1);
        Assert.assertEquals((char) 5, this.map.detectIfNone(value -> value > (char) 2, (char) 5));
    }

    @Test
    public void collect() {
        CharToObjectFunction<String> toString = String::valueOf;
        ObjectCharMap<Integer> map1 = this.newWithKeysValues(0, (char) 0, 1, (char) 1);
        Assert.assertTrue(map1.collect(toString).toString(), FastList.newListWith("\u0001", "\u0000").equals(map1.collect(toString)) || FastList.newListWith("\u0000", "\u0001").equals(map1.collect(toString)));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3L, this.map.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals((char) 2, this.map.max());
        Assert.assertEquals((char) 3, this.newWithKeysValues(null, (char) 3, 0, (char) 0, 2, (char) 2).max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        this.<Integer>getEmptyMap().max();
    }

    @Test
    public void min() {
        Assert.assertEquals((char) 0, this.map.min());
        Assert.assertEquals((char) 0, this.newWithKeysValues(null, (char) 0, 5, (char) 5, 1, (char) 1).min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        this.<Integer>getEmptyMap().min();
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((char) 2, this.map.maxIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.newWithKeysValues(null, (char) 3, 0, (char) 0, 2, (char) 2).maxIfEmpty((char) 5));
        Assert.assertEquals((char) 9, this.getEmptyMap().maxIfEmpty((char) 9));
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((char) 0, this.map.minIfEmpty((char) 6));
        Assert.assertEquals((char) 0, this.newWithKeysValues(null, (char) 0, 5, (char) 5, 1, (char) 1).minIfEmpty((char) 6));
        Assert.assertEquals((char) 5, this.getEmptyMap().minIfEmpty((char) 5));
    }

    @Test
    public void average() {
        Assert.assertEquals(1.0, this.map.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        this.getEmptyMap().average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.0, this.map.median(), 0.0);
        Assert.assertEquals(1.5, this.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2, "3", (char) 3).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new char[] { (char) 0, (char) 1 }, this.newWithKeysValues("0", (char) 0, "1", (char) 1).toArray()) || Arrays.equals(new char[] { (char) 1, (char) 0 }, this.newWithKeysValues("0", (char) 0, "1", (char) 1).toArray()));
        Assert.assertArrayEquals(new char[] {}, this.getEmptyMap().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new char[] { (char) 0, (char) 2, (char) 9 }, this.newWithKeysValues("9", (char) 9, "0", (char) 0, "2", (char) 2).toSortedArray());
        Assert.assertArrayEquals(new char[] {}, this.getEmptyMap().toSortedArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((char) 0));
        Assert.assertTrue(this.map.contains((char) 1));
        Assert.assertTrue(this.map.contains((char) 2));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll((char) 0, (char) 1, (char) 2));
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 1, (char) 5));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 5)));
        Assert.assertTrue(this.map.containsAll(new CharArrayList()));
    }

    @Test
    public void toList() {
        Assert.assertTrue(CharArrayList.newListWith((char) 0, (char) 1).equals(this.newWithKeysValues("0", (char) 0, "1", (char) 1).toList()) || CharArrayList.newListWith((char) 1, (char) 0).equals(this.newWithKeysValues("0", (char) 0, "1", (char) 1).toList()));
        Assert.assertEquals(CharArrayList.newListWith(), this.getEmptyMap().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 2, (char) 9), this.newWithKeysValues("9", (char) 9, "0", (char) 0, "2", (char) 2).toSortedList());
        Assert.assertEquals(CharArrayList.newListWith(), this.getEmptyMap().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2), this.map.toSet());
        Assert.assertEquals(CharHashSet.newSetWith(), this.getEmptyMap().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2), this.map.toBag());
        Assert.assertEquals(CharHashBag.newBagWith(), this.getEmptyMap().toBag());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectCharMap.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectCharMapTestCase instance;

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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectCharMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractObjectCharMapTestCase::keySet;
            this.payloads.values = AbstractObjectCharMapTestCase::values;
            this.payloads.get = AbstractObjectCharMapTestCase::get;
            this.payloads.getOrThrow = AbstractObjectCharMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractObjectCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractObjectCharMapTestCase::containsValue;
            this.payloads.size = AbstractObjectCharMapTestCase::size;
            this.payloads.isEmpty = AbstractObjectCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractObjectCharMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractObjectCharMapTestCase::asLazy;
            this.payloads.getIfAbsent = AbstractObjectCharMapTestCase::getIfAbsent;
            this.payloads.testEquals = AbstractObjectCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractObjectCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractObjectCharMapTestCase::testToString;
            this.payloads.charIterator = AbstractObjectCharMapTestCase::charIterator;
            this.payloads.forEach = AbstractObjectCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractObjectCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractObjectCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractObjectCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractObjectCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractObjectCharMapTestCase::makeString;
            this.payloads.appendString = AbstractObjectCharMapTestCase::appendString;
            this.payloads.select = AbstractObjectCharMapTestCase::select;
            this.payloads.reject = AbstractObjectCharMapTestCase::reject;
            this.payloads.tap = AbstractObjectCharMapTestCase::tap;
            this.payloads.count = AbstractObjectCharMapTestCase::count;
            this.payloads.anySatisfy = AbstractObjectCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractObjectCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractObjectCharMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractObjectCharMapTestCase::detectIfNone;
            this.payloads.collect = AbstractObjectCharMapTestCase::collect;
            this.payloads.sum = AbstractObjectCharMapTestCase::sum;
            this.payloads.max = AbstractObjectCharMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractObjectCharMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractObjectCharMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractObjectCharMapTestCase::minIfEmpty;
            this.payloads.average = AbstractObjectCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractObjectCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractObjectCharMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractObjectCharMapTestCase::toSortedArray;
            this.payloads.contains = AbstractObjectCharMapTestCase::contains;
            this.payloads.containsAll = AbstractObjectCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractObjectCharMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractObjectCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractObjectCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractObjectCharMapTestCase::toSet;
            this.payloads.toBag = AbstractObjectCharMapTestCase::toBag;
            this.payloads.toImmutable = AbstractObjectCharMapTestCase::toImmutable;
        }
    }
}
