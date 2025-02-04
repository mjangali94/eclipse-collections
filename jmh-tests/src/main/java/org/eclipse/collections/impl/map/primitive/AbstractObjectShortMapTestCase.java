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
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectShortMap;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.ObjectShortMap;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.ObjectShortMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractObjectShortMapTestCase {

    private final ObjectShortMap<String> map = this.classUnderTest();

    protected abstract ObjectShortMap<String> classUnderTest();

    protected abstract <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1);

    protected abstract <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2);

    protected abstract <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3);

    protected abstract <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3, T key4, short value4);

    protected abstract <T> ObjectShortMap<T> getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0"), this.newWithKeysValues("0", (short) 0).keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0", "1", "2"), this.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ObjectShortMap<String> map = this.newWithKeysValues("0", (short) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((short) 0));
        ObjectShortMap<String> map1 = this.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((short) 0));
        Assert.assertTrue(map1.values().contains((short) 1));
        Assert.assertTrue(map1.values().contains((short) 2));
    }

    @Test
    public void get() {
        Assert.assertEquals((short) 0, this.map.get("0"));
        Assert.assertEquals((short) 1, this.map.get("1"));
        Assert.assertEquals((short) 2, this.map.get("2"));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals((short) 0, this.map.getOrThrow("0"));
        Assert.assertEquals((short) 1, this.map.getOrThrow("1"));
        Assert.assertEquals((short) 2, this.map.getOrThrow("2"));
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
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertTrue(this.map.containsValue((short) 1));
        Assert.assertTrue(this.map.containsValue((short) 2));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, (short) 0));
        Verify.assertSize(1, this.newWithKeysValues(1, (short) 1));
        Verify.assertSize(1, this.newWithKeysValues(null, (short) 2));
        Verify.assertSize(2, this.newWithKeysValues(1, (short) 1, 5, (short) 5));
        Verify.assertSize(2, this.newWithKeysValues(0, (short) 0, 5, (short) 5));
        Verify.assertSize(3, this.newWithKeysValues(1, (short) 1, 0, (short) 0, 5, (short) 5));
        Verify.assertSize(2, this.newWithKeysValues(6, (short) 6, 5, (short) 5));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, (short) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, (short) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, (short) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, (short) 50).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, (short) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, (short) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, (short) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, (short) 50).notEmpty());
    }

    @Test
    public void asLazy() {
        Verify.assertSize(this.map.toList().size(), this.map.asLazy().toList());
        Assert.assertTrue(this.map.asLazy().toList().containsAll(this.map.toList()));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals((short) 0, this.map.getIfAbsent("0", (short) 1));
        Assert.assertEquals((short) 1, this.map.getIfAbsent("1", (short) 2));
        Assert.assertEquals((short) 2, this.map.getIfAbsent("2", (short) 3));
        Assert.assertEquals((short) 1, this.map.getIfAbsent("5", (short) 1));
        Assert.assertEquals((short) 0, this.map.getIfAbsent("5", (short) 0));
        Assert.assertEquals((short) 1, this.map.getIfAbsent(null, (short) 1));
        Assert.assertEquals((short) 0, this.map.getIfAbsent(null, (short) 0));
    }

    @Test
    public void testEquals() {
        ObjectShortMap<Integer> map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1, null, (short) 2);
        ObjectShortMap<Integer> map2 = this.newWithKeysValues(null, (short) 2, 0, (short) 0, 1, (short) 1);
        ObjectShortMap<Integer> map3 = this.newWithKeysValues(0, (short) 0, 1, (short) 2, null, (short) 2);
        ObjectShortMap<Integer> map5 = this.newWithKeysValues(0, (short) 0, 1, (short) 1, null, (short) 3);
        ObjectShortMap<Integer> map7 = this.newWithKeysValues(null, (short) 2, 1, (short) 1);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map7);
        Assert.assertEquals(map1, ObjectShortMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ObjectShortMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, (short) 0, 1, (short) 1).hashCode(), this.newWithKeysValues(0, (short) 0, 1, (short) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, (short) 0, null, (short) 1).hashCode(), this.newWithKeysValues(50, (short) 0, null, (short) 1).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.<Integer>getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues(0, (short) 0).toString());
        ObjectShortMap<Integer> map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        ObjectShortMap<Integer> map2 = this.newWithKeysValues(1, (short) 1, null, (short) 0);
        Assert.assertTrue(map2.toString(), "{1=1, null=0}".equals(map2.toString()) || "{null=0, 1=1}".equals(map2.toString()));
    }

    @Test
    public void shortIterator() {
        MutableShortSet expected = ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2);
        MutableShortSet actual = ShortHashSet.newSetWith();
        ShortIterator iterator = this.map.shortIterator();
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
            this.getEmptyMap().shortIterator().next();
        });
    }

    @Test
    public void forEach() {
        ObjectShortMap<Integer> map01 = this.newWithKeysValues(0, (short) 1, 1, (short) 2);
        short[] sum01 = new short[1];
        map01.forEach(each -> {
            sum01[0] += each;
        });
        Assert.assertEquals((short) 3, sum01[0]);
        ObjectShortMap<Integer> map = this.newWithKeysValues(3, (short) 4, 4, (short) 5);
        short[] sum = new short[1];
        map.forEach(each -> {
            sum[0] += each;
        });
        Assert.assertEquals((short) 9, sum[0]);
        ObjectShortMap<Integer> map1 = this.newWithKeysValues(3, (short) 4, null, (short) 5);
        short[] sum1 = new short[1];
        map1.forEach(each -> {
            sum1[0] += each;
        });
        Assert.assertEquals((short) 9, sum1[0]);
    }

    @Test
    public void forEachValue() {
        ObjectShortMap<Integer> map01 = this.newWithKeysValues(0, (short) 1, 1, (short) 2);
        short[] sum01 = new short[1];
        map01.forEachValue((short each) -> sum01[0] += each);
        Assert.assertEquals((short) 3, sum01[0]);
        ObjectShortMap<Integer> map = this.newWithKeysValues(3, (short) 4, null, (short) 5);
        short[] sum = new short[1];
        map.forEachValue((short each) -> sum[0] += each);
        Assert.assertEquals((short) 9, sum[0]);
    }

    @Test
    public void forEachKey() {
        ObjectShortMap<Integer> map01 = this.newWithKeysValues(0, (short) 1, 1, (short) 2);
        int[] sum01 = new int[1];
        map01.forEachKey((Integer each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        ObjectShortMap<Integer> map = this.newWithKeysValues(3, (short) 4, null, (short) 5);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue() {
        ObjectShortMap<Integer> map01 = this.newWithKeysValues(0, (short) 1, 1, (short) 2);
        int[] sumKey01 = new int[1];
        short[] sumValue01 = new short[1];
        map01.forEachKeyValue((Integer eachKey, short eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals((short) 3, sumValue01[0]);
        ObjectShortMap<Integer> map = this.newWithKeysValues(3, (short) 4, null, (short) 5);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        short[] sumValue = new short[1];
        map.forEachKeyValue((Integer eachKey, short eachValue) -> {
            sumKey[0] += String.valueOf(eachKey);
            sumValue[0] += eachValue;
        });
        Assert.assertTrue("3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertEquals((short) 9, sumValue[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ObjectShortMap<String> map0 = this.newWithKeysValues("2", (short) 3, "4", (short) 5);
        String result0 = map0.injectIntoKeyValue(new String("1"), (result, eachKey, eachValue) -> result + eachKey + String.valueOf(eachValue));
        Assert.assertTrue(result0, "12345".equals(result0) || "14523".equals(result0));
        ObjectShortMap copy = map0.injectIntoKeyValue(ObjectShortMaps.mutable.empty(), MutableObjectShortMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0, (short) 0).makeString());
        Assert.assertEquals("1", this.newWithKeysValues(1, (short) 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(null, (short) 5).makeString());
        ObjectShortMap<Integer> map2 = this.newWithKeysValues(1, (short) 1, 32, (short) 32);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        Assert.assertTrue(map2.makeString("/"), "1/32".equals(map2.makeString("/")) || "32/1".equals(map2.makeString("/")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, (short) 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, (short) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, (short) 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ObjectShortMap<Integer> map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
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
        Assert.assertEquals(this.map, this.map.select((String object, short value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("0", (short) 0, "1", (short) 1), this.map.select((String object, short value) -> Integer.parseInt(object) + value < (short) 4));
        Assert.assertEquals(this.getEmptyMap(), this.map.select((String object, short value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2), this.map.select(value -> value < (short) 3).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1), this.map.select(value -> value < (short) 2).toBag());
        Assert.assertEquals(new ShortHashBag(), this.map.select(value -> value > (short) 2).toBag());
    }

    @Test
    public void reject() {
        Assert.assertEquals(this.getEmptyMap(), this.map.reject((String object, short value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 2), this.map.reject((String object, short value) -> Integer.parseInt(object) + value < (short) 4));
        Assert.assertEquals(this.map, this.map.reject((String object, short value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(new ShortHashBag(), this.map.reject(value -> value < (short) 3).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 2), this.map.reject(value -> value < (short) 2).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2), this.map.reject(value -> value > (short) 2).toBag());
    }

    @Test
    public void tap() {
        MutableShortList tapResult = ShortLists.mutable.empty();
        Assert.assertSame(this.map, this.map.tap(tapResult::add));
        Assert.assertEquals(this.map.toList(), tapResult);
    }

    @Test
    public void count() {
        Assert.assertEquals(3L, this.map.count(value -> value < (short) 3));
        Assert.assertEquals(2L, this.map.count(value -> value < (short) 2));
        Assert.assertEquals(0L, this.map.count(value -> value > (short) 2));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.map.anySatisfy(value -> value < (short) 3));
        Assert.assertTrue(this.map.anySatisfy(value -> value < (short) 2));
        Assert.assertFalse(this.map.anySatisfy(value -> value > (short) 2));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.map.allSatisfy(value -> value < (short) 3));
        Assert.assertFalse(this.map.allSatisfy(value -> value < (short) 2));
        Assert.assertFalse(this.map.allSatisfy(value -> value > (short) 2));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.map.noneSatisfy(value -> value < (short) 0));
        Assert.assertFalse(this.map.noneSatisfy(value -> value < (short) 2));
    }

    @Test
    public void detectIfNone() {
        short detect = this.map.detectIfNone(value -> value < (short) 3, (short) 5);
        Assert.assertTrue(detect == 0 || detect == 1 || detect == 2);
        short detect1 = this.map.detectIfNone(value -> value < (short) 2, (short) 5);
        Assert.assertTrue(detect1 == 0 || detect1 == 1);
        Assert.assertEquals((short) 5, this.map.detectIfNone(value -> value > (short) 2, (short) 5));
    }

    @Test
    public void collect() {
        ShortToObjectFunction<String> toString = String::valueOf;
        ObjectShortMap<Integer> map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        Assert.assertTrue(map1.collect(toString).toString(), FastList.newListWith("1", "0").equals(map1.collect(toString)) || FastList.newListWith("0", "1").equals(map1.collect(toString)));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3L, this.map.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals((short) 2, this.map.max());
        Assert.assertEquals((short) 3, this.newWithKeysValues(null, (short) 3, 0, (short) 0, 2, (short) 2).max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        this.<Integer>getEmptyMap().max();
    }

    @Test
    public void min() {
        Assert.assertEquals((short) 0, this.map.min());
        Assert.assertEquals((short) 0, this.newWithKeysValues(null, (short) 0, 5, (short) 5, 1, (short) 1).min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        this.<Integer>getEmptyMap().min();
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((short) 2, this.map.maxIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.newWithKeysValues(null, (short) 3, 0, (short) 0, 2, (short) 2).maxIfEmpty((short) 5));
        Assert.assertEquals((short) 9, this.getEmptyMap().maxIfEmpty((short) 9));
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((short) 0, this.map.minIfEmpty((short) 6));
        Assert.assertEquals((short) 0, this.newWithKeysValues(null, (short) 0, 5, (short) 5, 1, (short) 1).minIfEmpty((short) 6));
        Assert.assertEquals((short) 5, this.getEmptyMap().minIfEmpty((short) 5));
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
        Assert.assertEquals(1.5, this.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2, "3", (short) 3).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new short[] { (short) 0, (short) 1 }, this.newWithKeysValues("0", (short) 0, "1", (short) 1).toArray()) || Arrays.equals(new short[] { (short) 1, (short) 0 }, this.newWithKeysValues("0", (short) 0, "1", (short) 1).toArray()));
        Assert.assertArrayEquals(new short[] {}, this.getEmptyMap().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new short[] { (short) 0, (short) 2, (short) 9 }, this.newWithKeysValues("9", (short) 9, "0", (short) 0, "2", (short) 2).toSortedArray());
        Assert.assertArrayEquals(new short[] {}, this.getEmptyMap().toSortedArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((short) 0));
        Assert.assertTrue(this.map.contains((short) 1));
        Assert.assertTrue(this.map.contains((short) 2));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll((short) 0, (short) 1, (short) 2));
        Assert.assertFalse(this.map.containsAll((short) 0, (short) 1, (short) 5));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 5)));
        Assert.assertTrue(this.map.containsAll(new ShortArrayList()));
    }

    @Test
    public void toList() {
        Assert.assertTrue(ShortArrayList.newListWith((short) 0, (short) 1).equals(this.newWithKeysValues("0", (short) 0, "1", (short) 1).toList()) || ShortArrayList.newListWith((short) 1, (short) 0).equals(this.newWithKeysValues("0", (short) 0, "1", (short) 1).toList()));
        Assert.assertEquals(ShortArrayList.newListWith(), this.getEmptyMap().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 2, (short) 9), this.newWithKeysValues("9", (short) 9, "0", (short) 0, "2", (short) 2).toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith(), this.getEmptyMap().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2), this.map.toSet());
        Assert.assertEquals(ShortHashSet.newSetWith(), this.getEmptyMap().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2), this.map.toBag());
        Assert.assertEquals(ShortHashBag.newBagWith(), this.getEmptyMap().toBag());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectShortMap.class, this.classUnderTest().toImmutable());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectShortMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractObjectShortMapTestCase::keySet;
            this.payloads.values = AbstractObjectShortMapTestCase::values;
            this.payloads.get = AbstractObjectShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractObjectShortMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractObjectShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractObjectShortMapTestCase::containsValue;
            this.payloads.size = AbstractObjectShortMapTestCase::size;
            this.payloads.isEmpty = AbstractObjectShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractObjectShortMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractObjectShortMapTestCase::asLazy;
            this.payloads.getIfAbsent = AbstractObjectShortMapTestCase::getIfAbsent;
            this.payloads.testEquals = AbstractObjectShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractObjectShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractObjectShortMapTestCase::testToString;
            this.payloads.shortIterator = AbstractObjectShortMapTestCase::shortIterator;
            this.payloads.forEach = AbstractObjectShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractObjectShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractObjectShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractObjectShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractObjectShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractObjectShortMapTestCase::makeString;
            this.payloads.appendString = AbstractObjectShortMapTestCase::appendString;
            this.payloads.select = AbstractObjectShortMapTestCase::select;
            this.payloads.reject = AbstractObjectShortMapTestCase::reject;
            this.payloads.tap = AbstractObjectShortMapTestCase::tap;
            this.payloads.count = AbstractObjectShortMapTestCase::count;
            this.payloads.anySatisfy = AbstractObjectShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractObjectShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractObjectShortMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractObjectShortMapTestCase::detectIfNone;
            this.payloads.collect = AbstractObjectShortMapTestCase::collect;
            this.payloads.sum = AbstractObjectShortMapTestCase::sum;
            this.payloads.max = AbstractObjectShortMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractObjectShortMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractObjectShortMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractObjectShortMapTestCase::minIfEmpty;
            this.payloads.average = AbstractObjectShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractObjectShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractObjectShortMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractObjectShortMapTestCase::toSortedArray;
            this.payloads.contains = AbstractObjectShortMapTestCase::contains;
            this.payloads.containsAll = AbstractObjectShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractObjectShortMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractObjectShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractObjectShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractObjectShortMapTestCase::toSet;
            this.payloads.toBag = AbstractObjectShortMapTestCase::toBag;
            this.payloads.toImmutable = AbstractObjectShortMapTestCase::toImmutable;
        }
    }
*/
}
