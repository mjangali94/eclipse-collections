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
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectByteMap;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.api.map.primitive.ObjectByteMap;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.ObjectByteMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractObjectByteMapTestCase {

    private final ObjectByteMap<String> map = this.classUnderTest();

    protected abstract ObjectByteMap<String> classUnderTest();

    protected abstract <T> ObjectByteMap<T> newWithKeysValues(T key1, byte value1);

    protected abstract <T> ObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2);

    protected abstract <T> ObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3);

    protected abstract <T> ObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3, T key4, byte value4);

    protected abstract <T> ObjectByteMap<T> getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0"), this.newWithKeysValues("0", (byte) 0).keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0", "1", "2"), this.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ObjectByteMap<String> map = this.newWithKeysValues("0", (byte) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((byte) 0));
        ObjectByteMap<String> map1 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((byte) 0));
        Assert.assertTrue(map1.values().contains((byte) 1));
        Assert.assertTrue(map1.values().contains((byte) 2));
    }

    @Test
    public void get() {
        Assert.assertEquals((byte) 0, this.map.get("0"));
        Assert.assertEquals((byte) 1, this.map.get("1"));
        Assert.assertEquals((byte) 2, this.map.get("2"));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals((byte) 0, this.map.getOrThrow("0"));
        Assert.assertEquals((byte) 1, this.map.getOrThrow("1"));
        Assert.assertEquals((byte) 2, this.map.getOrThrow("2"));
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
        Assert.assertTrue(this.map.containsValue((byte) 0));
        Assert.assertTrue(this.map.containsValue((byte) 1));
        Assert.assertTrue(this.map.containsValue((byte) 2));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, (byte) 0));
        Verify.assertSize(1, this.newWithKeysValues(1, (byte) 1));
        Verify.assertSize(1, this.newWithKeysValues(null, (byte) 2));
        Verify.assertSize(2, this.newWithKeysValues(1, (byte) 1, 5, (byte) 5));
        Verify.assertSize(2, this.newWithKeysValues(0, (byte) 0, 5, (byte) 5));
        Verify.assertSize(3, this.newWithKeysValues(1, (byte) 1, 0, (byte) 0, 5, (byte) 5));
        Verify.assertSize(2, this.newWithKeysValues(6, (byte) 6, 5, (byte) 5));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, (byte) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, (byte) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, (byte) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, (byte) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, (byte) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, (byte) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, (byte) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, (byte) 50).notEmpty());
    }

    @Test
    public void asLazy() {
        Verify.assertSize(this.map.toList().size(), this.map.asLazy().toList());
        Assert.assertTrue(this.map.asLazy().toList().containsAll(this.map.toList()));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals((byte) 0, this.map.getIfAbsent("0", (byte) 1));
        Assert.assertEquals((byte) 1, this.map.getIfAbsent("1", (byte) 2));
        Assert.assertEquals((byte) 2, this.map.getIfAbsent("2", (byte) 3));
        Assert.assertEquals((byte) 1, this.map.getIfAbsent("5", (byte) 1));
        Assert.assertEquals((byte) 0, this.map.getIfAbsent("5", (byte) 0));
        Assert.assertEquals((byte) 1, this.map.getIfAbsent(null, (byte) 1));
        Assert.assertEquals((byte) 0, this.map.getIfAbsent(null, (byte) 0));
    }

    @Test
    public void testEquals() {
        ObjectByteMap<Integer> map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, null, (byte) 2);
        ObjectByteMap<Integer> map2 = this.newWithKeysValues(null, (byte) 2, 0, (byte) 0, 1, (byte) 1);
        ObjectByteMap<Integer> map3 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 2, null, (byte) 2);
        ObjectByteMap<Integer> map5 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, null, (byte) 3);
        ObjectByteMap<Integer> map7 = this.newWithKeysValues(null, (byte) 2, 1, (byte) 1);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map7);
        Assert.assertEquals(map1, ObjectByteMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ObjectByteMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1).hashCode(), this.newWithKeysValues(0, (byte) 0, 1, (byte) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, (byte) 0, null, (byte) 1).hashCode(), this.newWithKeysValues(50, (byte) 0, null, (byte) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.<Integer>getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues(0, (byte) 0).toString());
        ObjectByteMap<Integer> map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        ObjectByteMap<Integer> map2 = this.newWithKeysValues(1, (byte) 1, null, (byte) 0);
        Assert.assertTrue(map2.toString(), "{1=1, null=0}".equals(map2.toString()) || "{null=0, 1=1}".equals(map2.toString()));
    }

    @Test
    public void byteIterator() {
        MutableByteSet expected = ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 2);
        MutableByteSet actual = ByteHashSet.newSetWith();
        ByteIterator iterator = this.map.byteIterator();
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
            this.getEmptyMap().byteIterator().next();
        });
    }

    @Test
    public void forEach() {
        ObjectByteMap<Integer> map01 = this.newWithKeysValues(0, (byte) 1, 1, (byte) 2);
        byte[] sum01 = new byte[1];
        map01.forEach(each -> {
            sum01[0] += each;
        });
        Assert.assertEquals((byte) 3, sum01[0]);
        ObjectByteMap<Integer> map = this.newWithKeysValues(3, (byte) 4, 4, (byte) 5);
        byte[] sum = new byte[1];
        map.forEach(each -> {
            sum[0] += each;
        });
        Assert.assertEquals((byte) 9, sum[0]);
        ObjectByteMap<Integer> map1 = this.newWithKeysValues(3, (byte) 4, null, (byte) 5);
        byte[] sum1 = new byte[1];
        map1.forEach(each -> {
            sum1[0] += each;
        });
        Assert.assertEquals((byte) 9, sum1[0]);
    }

    @Test
    public void forEachValue() {
        ObjectByteMap<Integer> map01 = this.newWithKeysValues(0, (byte) 1, 1, (byte) 2);
        byte[] sum01 = new byte[1];
        map01.forEachValue((byte each) -> sum01[0] += each);
        Assert.assertEquals((byte) 3, sum01[0]);
        ObjectByteMap<Integer> map = this.newWithKeysValues(3, (byte) 4, null, (byte) 5);
        byte[] sum = new byte[1];
        map.forEachValue((byte each) -> sum[0] += each);
        Assert.assertEquals((byte) 9, sum[0]);
    }

    @Test
    public void forEachKey() {
        ObjectByteMap<Integer> map01 = this.newWithKeysValues(0, (byte) 1, 1, (byte) 2);
        int[] sum01 = new int[1];
        map01.forEachKey((Integer each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        ObjectByteMap<Integer> map = this.newWithKeysValues(3, (byte) 4, null, (byte) 5);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue() {
        ObjectByteMap<Integer> map01 = this.newWithKeysValues(0, (byte) 1, 1, (byte) 2);
        int[] sumKey01 = new int[1];
        byte[] sumValue01 = new byte[1];
        map01.forEachKeyValue((Integer eachKey, byte eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals((byte) 3, sumValue01[0]);
        ObjectByteMap<Integer> map = this.newWithKeysValues(3, (byte) 4, null, (byte) 5);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        byte[] sumValue = new byte[1];
        map.forEachKeyValue((Integer eachKey, byte eachValue) -> {
            sumKey[0] += String.valueOf(eachKey);
            sumValue[0] += eachValue;
        });
        Assert.assertTrue("3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertEquals((byte) 9, sumValue[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ObjectByteMap<String> map0 = this.newWithKeysValues("2", (byte) 3, "4", (byte) 5);
        String result0 = map0.injectIntoKeyValue(new String("1"), (result, eachKey, eachValue) -> result + eachKey + String.valueOf(eachValue));
        Assert.assertTrue(result0, "12345".equals(result0) || "14523".equals(result0));
        ObjectByteMap copy = map0.injectIntoKeyValue(ObjectByteMaps.mutable.empty(), MutableObjectByteMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0, (byte) 0).makeString());
        Assert.assertEquals("1", this.newWithKeysValues(1, (byte) 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(null, (byte) 5).makeString());
        ObjectByteMap<Integer> map2 = this.newWithKeysValues(1, (byte) 1, 32, (byte) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        Assert.assertTrue(map2.makeString("/"), "1/32".equals(map2.makeString("/")) || "32/1".equals(map2.makeString("/")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, (byte) 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, (byte) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, (byte) 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ObjectByteMap<Integer> map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0, 1".equals(appendable3.toString()) || "1, 0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        map1.appendString(appendable4, "/");
        Assert.assertTrue(appendable4.toString(), "0/1".equals(appendable4.toString()) || "1/0".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        map1.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[0/1]".equals(appendable5.toString()) || "[1/0]".equals(appendable5.toString()));
    }

    @Test
    public void select() {
        Assert.assertEquals(this.map, this.map.select((String object, byte value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("0", (byte) 0, "1", (byte) 1), this.map.select((String object, byte value) -> Integer.parseInt(object) + value < (byte) 4));
        Assert.assertEquals(this.getEmptyMap(), this.map.select((String object, byte value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2), this.map.select(value -> value < (byte) 3).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1), this.map.select(value -> value < (byte) 2).toBag());
        Assert.assertEquals(new ByteHashBag(), this.map.select(value -> value > (byte) 2).toBag());
    }

    @Test
    public void reject() {
        Assert.assertEquals(this.getEmptyMap(), this.map.reject((String object, byte value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 2), this.map.reject((String object, byte value) -> Integer.parseInt(object) + value < (byte) 4));
        Assert.assertEquals(this.map, this.map.reject((String object, byte value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(new ByteHashBag(), this.map.reject(value -> value < (byte) 3).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 2), this.map.reject(value -> value < (byte) 2).toBag());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2), this.map.reject(value -> value > (byte) 2).toBag());
    }

    @Test
    public void tap() {
        MutableByteList tapResult = ByteLists.mutable.empty();
        Assert.assertSame(this.map, this.map.tap(tapResult::add));
        Assert.assertEquals(this.map.toList(), tapResult);
    }

    @Test
    public void count() {
        Assert.assertEquals(3L, this.map.count(value -> value < (byte) 3));
        Assert.assertEquals(2L, this.map.count(value -> value < (byte) 2));
        Assert.assertEquals(0L, this.map.count(value -> value > (byte) 2));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.map.anySatisfy(value -> value < (byte) 3));
        Assert.assertTrue(this.map.anySatisfy(value -> value < (byte) 2));
        Assert.assertFalse(this.map.anySatisfy(value -> value > (byte) 2));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.map.allSatisfy(value -> value < (byte) 3));
        Assert.assertFalse(this.map.allSatisfy(value -> value < (byte) 2));
        Assert.assertFalse(this.map.allSatisfy(value -> value > (byte) 2));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.map.noneSatisfy(value -> value < (byte) 0));
        Assert.assertFalse(this.map.noneSatisfy(value -> value < (byte) 2));
    }

    @Test
    public void detectIfNone() {
        byte detect = this.map.detectIfNone(value -> value < (byte) 3, (byte) 5);
        Assert.assertTrue(detect == 0 || detect == 1 || detect == 2);
        byte detect1 = this.map.detectIfNone(value -> value < (byte) 2, (byte) 5);
        Assert.assertTrue(detect1 == 0 || detect1 == 1);
        Assert.assertEquals((byte) 5, this.map.detectIfNone(value -> value > (byte) 2, (byte) 5));
    }

    @Test
    public void collect() {
        ByteToObjectFunction<String> toString = String::valueOf;
        ObjectByteMap<Integer> map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        Assert.assertTrue(map1.collect(toString).toString(), FastList.newListWith("1", "0").equals(map1.collect(toString)) || FastList.newListWith("0", "1").equals(map1.collect(toString)));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3L, this.map.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals((byte) 2, this.map.max());
        Assert.assertEquals((byte) 3, this.newWithKeysValues(null, (byte) 3, 0, (byte) 0, 2, (byte) 2).max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        this.<Integer>getEmptyMap().max();
    }

    @Test
    public void min() {
        Assert.assertEquals((byte) 0, this.map.min());
        Assert.assertEquals((byte) 0, this.newWithKeysValues(null, (byte) 0, 5, (byte) 5, 1, (byte) 1).min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        this.<Integer>getEmptyMap().min();
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((byte) 2, this.map.maxIfEmpty((byte) 5));
        Assert.assertEquals((byte) 3, this.newWithKeysValues(null, (byte) 3, 0, (byte) 0, 2, (byte) 2).maxIfEmpty((byte) 5));
        Assert.assertEquals((byte) 9, this.getEmptyMap().maxIfEmpty((byte) 9));
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((byte) 0, this.map.minIfEmpty((byte) 6));
        Assert.assertEquals((byte) 0, this.newWithKeysValues(null, (byte) 0, 5, (byte) 5, 1, (byte) 1).minIfEmpty((byte) 6));
        Assert.assertEquals((byte) 5, this.getEmptyMap().minIfEmpty((byte) 5));
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
        Assert.assertEquals(1.5, this.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2, "3", (byte) 3).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new byte[] { (byte) 0, (byte) 1 }, this.newWithKeysValues("0", (byte) 0, "1", (byte) 1).toArray()) || Arrays.equals(new byte[] { (byte) 1, (byte) 0 }, this.newWithKeysValues("0", (byte) 0, "1", (byte) 1).toArray()));
        Assert.assertArrayEquals(new byte[] {}, this.getEmptyMap().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 0, (byte) 2, (byte) 9 }, this.newWithKeysValues("9", (byte) 9, "0", (byte) 0, "2", (byte) 2).toSortedArray());
        Assert.assertArrayEquals(new byte[] {}, this.getEmptyMap().toSortedArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((byte) 0));
        Assert.assertTrue(this.map.contains((byte) 1));
        Assert.assertTrue(this.map.contains((byte) 2));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll((byte) 0, (byte) 1, (byte) 2));
        Assert.assertFalse(this.map.containsAll((byte) 0, (byte) 1, (byte) 5));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
        Assert.assertFalse(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 5)));
        Assert.assertTrue(this.map.containsAll(new ByteArrayList()));
    }

    @Test
    public void toList() {
        Assert.assertTrue(ByteArrayList.newListWith((byte) 0, (byte) 1).equals(this.newWithKeysValues("0", (byte) 0, "1", (byte) 1).toList()) || ByteArrayList.newListWith((byte) 1, (byte) 0).equals(this.newWithKeysValues("0", (byte) 0, "1", (byte) 1).toList()));
        Assert.assertEquals(ByteArrayList.newListWith(), this.getEmptyMap().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 2, (byte) 9), this.newWithKeysValues("9", (byte) 9, "0", (byte) 0, "2", (byte) 2).toSortedList());
        Assert.assertEquals(ByteArrayList.newListWith(), this.getEmptyMap().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 0, (byte) 1, (byte) 2), this.map.toSet());
        Assert.assertEquals(ByteHashSet.newSetWith(), this.getEmptyMap().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 2), this.map.toBag());
        Assert.assertEquals(ByteHashBag.newBagWith(), this.getEmptyMap().toBag());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectByteMap.class, this.classUnderTest().toImmutable());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectByteMapTestCase instance;

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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectByteMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractObjectByteMapTestCase::keySet;
            this.payloads.values = AbstractObjectByteMapTestCase::values;
            this.payloads.get = AbstractObjectByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractObjectByteMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractObjectByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractObjectByteMapTestCase::containsValue;
            this.payloads.size = AbstractObjectByteMapTestCase::size;
            this.payloads.isEmpty = AbstractObjectByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractObjectByteMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractObjectByteMapTestCase::asLazy;
            this.payloads.getIfAbsent = AbstractObjectByteMapTestCase::getIfAbsent;
            this.payloads.testEquals = AbstractObjectByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractObjectByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractObjectByteMapTestCase::testToString;
            this.payloads.byteIterator = AbstractObjectByteMapTestCase::byteIterator;
            this.payloads.forEach = AbstractObjectByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractObjectByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractObjectByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractObjectByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractObjectByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractObjectByteMapTestCase::makeString;
            this.payloads.appendString = AbstractObjectByteMapTestCase::appendString;
            this.payloads.select = AbstractObjectByteMapTestCase::select;
            this.payloads.reject = AbstractObjectByteMapTestCase::reject;
            this.payloads.tap = AbstractObjectByteMapTestCase::tap;
            this.payloads.count = AbstractObjectByteMapTestCase::count;
            this.payloads.anySatisfy = AbstractObjectByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractObjectByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractObjectByteMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractObjectByteMapTestCase::detectIfNone;
            this.payloads.collect = AbstractObjectByteMapTestCase::collect;
            this.payloads.sum = AbstractObjectByteMapTestCase::sum;
            this.payloads.max = AbstractObjectByteMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectByteMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractObjectByteMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectByteMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractObjectByteMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractObjectByteMapTestCase::minIfEmpty;
            this.payloads.average = AbstractObjectByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractObjectByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractObjectByteMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractObjectByteMapTestCase::toSortedArray;
            this.payloads.contains = AbstractObjectByteMapTestCase::contains;
            this.payloads.containsAll = AbstractObjectByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractObjectByteMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractObjectByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractObjectByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractObjectByteMapTestCase::toSet;
            this.payloads.toBag = AbstractObjectByteMapTestCase::toBag;
            this.payloads.toImmutable = AbstractObjectByteMapTestCase::toImmutable;
        }
    }
*/
}
