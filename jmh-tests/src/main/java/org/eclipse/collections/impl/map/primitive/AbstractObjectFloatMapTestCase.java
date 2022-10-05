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
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.ObjectFloatMap;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractObjectFloatMapTestCase {

    private final ObjectFloatMap<String> map = this.classUnderTest();

    protected abstract ObjectFloatMap<String> classUnderTest();

    protected abstract <T> ObjectFloatMap<T> newWithKeysValues(T key1, float value1);

    protected abstract <T> ObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2);

    protected abstract <T> ObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3);

    protected abstract <T> ObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3, T key4, float value4);

    protected abstract <T> ObjectFloatMap<T> getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0"), this.newWithKeysValues("0", 0.0f).keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0", "1", "2"), this.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ObjectFloatMap<String> map = this.newWithKeysValues("0", 0.0f);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0f));
        ObjectFloatMap<String> map1 = this.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0f));
        Assert.assertTrue(map1.values().contains(1.0f));
        Assert.assertTrue(map1.values().contains(2.0f));
    }

    @Test
    public void get() {
        Assert.assertEquals(0.0f, this.map.get("0"), 0.0f);
        Assert.assertEquals(1.0f, this.map.get("1"), 0.0f);
        Assert.assertEquals(2.0f, this.map.get("2"), 0.0f);
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0f, this.map.getOrThrow("0"), 0.0f);
        Assert.assertEquals(1.0f, this.map.getOrThrow("1"), 0.0f);
        Assert.assertEquals(2.0f, this.map.getOrThrow("2"), 0.0f);
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
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(1.0f));
        Assert.assertTrue(this.map.containsValue(2.0f));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, 0.0f));
        Verify.assertSize(1, this.newWithKeysValues(1, 1.0f));
        Verify.assertSize(1, this.newWithKeysValues(null, 2.0f));
        Verify.assertSize(2, this.newWithKeysValues(1, 1.0f, 5, 5.0f));
        Verify.assertSize(2, this.newWithKeysValues(0, 0.0f, 5, 5.0f));
        Verify.assertSize(3, this.newWithKeysValues(1, 1.0f, 0, 0.0f, 5, 5.0f));
        Verify.assertSize(2, this.newWithKeysValues(6, 6.0f, 5, 5.0f));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, 1.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, 1.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, 0.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, 50.0f).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, 1.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, 1.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, 0.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, 50.0f).notEmpty());
    }

    @Test
    public void asLazy() {
        Verify.assertSize(this.map.toList().size(), this.map.asLazy().toList());
        Assert.assertTrue(this.map.asLazy().toList().containsAll(this.map.toList()));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0f, this.map.getIfAbsent("0", 1.0f), 0.0f);
        Assert.assertEquals(1.0f, this.map.getIfAbsent("1", 2.0f), 0.0f);
        Assert.assertEquals(2.0f, this.map.getIfAbsent("2", 3.0f), 0.0f);
        Assert.assertEquals(1.0f, this.map.getIfAbsent("5", 1.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.getIfAbsent("5", 0.0f), 0.0f);
        Assert.assertEquals(1.0f, this.map.getIfAbsent(null, 1.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.getIfAbsent(null, 0.0f), 0.0f);
    }

    @Test
    public void testEquals() {
        ObjectFloatMap<Integer> map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f, null, 2.0f);
        ObjectFloatMap<Integer> map2 = this.newWithKeysValues(null, 2.0f, 0, 0.0f, 1, 1.0f);
        ObjectFloatMap<Integer> map3 = this.newWithKeysValues(0, 0.0f, 1, 2.0f, null, 2.0f);
        ObjectFloatMap<Integer> map5 = this.newWithKeysValues(0, 0.0f, 1, 1.0f, null, 3.0f);
        ObjectFloatMap<Integer> map7 = this.newWithKeysValues(null, 2.0f, 1, 1.0f);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map7);
        Assert.assertEquals(map1, ObjectFloatMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ObjectFloatMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0.0f, 1, 1.0f).hashCode(), this.newWithKeysValues(0, 0.0f, 1, 1.0f).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, 0.0f, null, 1.0f).hashCode(), this.newWithKeysValues(50, 0.0f, null, 1.0f).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.<Integer>getEmptyMap().toString());
        Assert.assertEquals("{0=0.0}", this.newWithKeysValues(0, 0.0f).toString());
        ObjectFloatMap<Integer> map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        Assert.assertTrue(map1.toString(), "{0=0.0, 1=1.0}".equals(map1.toString()) || "{1=1.0, 0=0.0}".equals(map1.toString()));
        ObjectFloatMap<Integer> map2 = this.newWithKeysValues(1, 1.0f, null, 0.0f);
        Assert.assertTrue(map2.toString(), "{1=1.0, null=0.0}".equals(map2.toString()) || "{null=0.0, 1=1.0}".equals(map2.toString()));
    }

    @Test
    public void floatIterator() {
        MutableFloatSet expected = FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f);
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
        Assert.assertThrows(NoSuchElementException.class, () -> {
            this.getEmptyMap().floatIterator().next();
        });
    }

    @Test
    public void forEach() {
        ObjectFloatMap<Integer> map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEach(each -> {
            sum01[0] += each;
        });
        Assert.assertEquals(3.0f, sum01[0], 0.0f);
        ObjectFloatMap<Integer> map = this.newWithKeysValues(3, 4.0f, 4, 5.0f);
        float[] sum = new float[1];
        map.forEach(each -> {
            sum[0] += each;
        });
        Assert.assertEquals(9.0f, sum[0], 0.0f);
        ObjectFloatMap<Integer> map1 = this.newWithKeysValues(3, 4.0f, null, 5.0f);
        float[] sum1 = new float[1];
        map1.forEach(each -> {
            sum1[0] += each;
        });
        Assert.assertEquals(9.0f, sum1[0], 0.0f);
    }

    @Test
    public void forEachValue() {
        ObjectFloatMap<Integer> map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEachValue((float each) -> sum01[0] += each);
        Assert.assertEquals(3.0f, sum01[0], 0.0f);
        ObjectFloatMap<Integer> map = this.newWithKeysValues(3, 4.0f, null, 5.0f);
        float[] sum = new float[1];
        map.forEachValue((float each) -> sum[0] += each);
        Assert.assertEquals(9.0f, sum[0], 0.0f);
    }

    @Test
    public void forEachKey() {
        ObjectFloatMap<Integer> map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        int[] sum01 = new int[1];
        map01.forEachKey((Integer each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        ObjectFloatMap<Integer> map = this.newWithKeysValues(3, 4.0f, null, 5.0f);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue() {
        ObjectFloatMap<Integer> map01 = this.newWithKeysValues(0, 1.0f, 1, 2.0f);
        int[] sumKey01 = new int[1];
        float[] sumValue01 = new float[1];
        map01.forEachKeyValue((Integer eachKey, float eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals(3.0f, sumValue01[0], 0.0f);
        ObjectFloatMap<Integer> map = this.newWithKeysValues(3, 4.0f, null, 5.0f);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        float[] sumValue = new float[1];
        map.forEachKeyValue((Integer eachKey, float eachValue) -> {
            sumKey[0] += String.valueOf(eachKey);
            sumValue[0] += eachValue;
        });
        Assert.assertTrue("3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertEquals(9.0f, sumValue[0], 0.0f);
    }

    @Test
    public void injectIntoKeyValue() {
        ObjectFloatMap<String> map0 = this.newWithKeysValues("2", 3.0f, "4", 5.0f);
        String result0 = map0.injectIntoKeyValue(new String("1"), (result, eachKey, eachValue) -> result + eachKey + String.valueOf(eachValue));
        Assert.assertTrue(result0, "123.045.0".equals(result0) || "145.023.0".equals(result0));
        ObjectFloatMap copy = map0.injectIntoKeyValue(ObjectFloatMaps.mutable.empty(), MutableObjectFloatMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues(0, 0.0f).makeString());
        Assert.assertEquals("1.0", this.newWithKeysValues(1, 1.0f).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues(null, 5.0f).makeString());
        ObjectFloatMap<Integer> map2 = this.newWithKeysValues(1, 1.0f, 32, 32.0f);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1.0/32.0]".equals(map2.makeString("[", "/", "]")) || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));
        Assert.assertTrue(map2.makeString("/"), "1.0/32.0".equals(map2.makeString("/")) || "32.0/1.0".equals(map2.makeString("/")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, 0.0f).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, 1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, 5.0f).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ObjectFloatMap<Integer> map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        map1.appendString(appendable3);
        Assert.assertTrue(appendable3.toString(), "0.0, 1.0".equals(appendable3.toString()) || "1.0, 0.0".equals(appendable3.toString()));
        Appendable appendable4 = new StringBuilder();
        map1.appendString(appendable4, "/");
        Assert.assertTrue(appendable4.toString(), "0.0/1.0".equals(appendable4.toString()) || "1.0/0.0".equals(appendable4.toString()));
        Appendable appendable5 = new StringBuilder();
        map1.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(appendable5.toString(), "[0.0/1.0]".equals(appendable5.toString()) || "[1.0/0.0]".equals(appendable5.toString()));
    }

    @Test
    public void select() {
        Assert.assertEquals(this.map, this.map.select((String object, float value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f), this.map.select((String object, float value) -> Float.compare(Integer.parseInt(object) + value, 4.0f) < 0));
        Assert.assertEquals(this.getEmptyMap(), this.map.select((String object, float value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f), this.map.select(value -> Float.compare(value, 3.0f) < 0).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f), this.map.select(value -> Float.compare(value, 2.0f) < 0).toBag());
        Assert.assertEquals(new FloatHashBag(), this.map.select(value -> value > 2.0f).toBag());
    }

    @Test
    public void reject() {
        Assert.assertEquals(this.getEmptyMap(), this.map.reject((String object, float value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 2.0f), this.map.reject((String object, float value) -> Float.compare(Integer.parseInt(object) + value, 4.0f) < 0));
        Assert.assertEquals(this.map, this.map.reject((String object, float value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(new FloatHashBag(), this.map.reject(value -> Float.compare(value, 3.0f) < 0).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(2.0f), this.map.reject(value -> Float.compare(value, 2.0f) < 0).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f), this.map.reject(value -> value > 2.0f).toBag());
    }

    @Test
    public void tap() {
        MutableFloatList tapResult = FloatLists.mutable.empty();
        Assert.assertSame(this.map, this.map.tap(tapResult::add));
        Assert.assertEquals(this.map.toList(), tapResult);
    }

    @Test
    public void count() {
        Assert.assertEquals(3L, this.map.count(value -> Float.compare(value, 3.0f) < 0));
        Assert.assertEquals(2L, this.map.count(value -> Float.compare(value, 2.0f) < 0));
        Assert.assertEquals(0L, this.map.count(value -> value > 2.0f));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.map.anySatisfy(value -> Float.compare(value, 3.0f) < 0));
        Assert.assertTrue(this.map.anySatisfy(value -> Float.compare(value, 2.0f) < 0));
        Assert.assertFalse(this.map.anySatisfy(value -> value > 2.0f));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.map.allSatisfy(value -> Float.compare(value, 3.0f) < 0));
        Assert.assertFalse(this.map.allSatisfy(value -> Float.compare(value, 2.0f) < 0));
        Assert.assertFalse(this.map.allSatisfy(value -> value > 2.0f));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.map.noneSatisfy(value -> Float.compare(value, 0.0f) < 0));
        Assert.assertFalse(this.map.noneSatisfy(value -> Float.compare(value, 2.0f) < 0));
    }

    @Test
    public void detectIfNone() {
        float detect = this.map.detectIfNone(value -> Float.compare(value, 3.0f) < 0, 5.0f);
        Assert.assertTrue(Float.compare(detect, 0) == 0 || Float.compare(detect, 1) == 0 || Float.compare(detect, 2) == 0);
        float detect1 = this.map.detectIfNone(value -> Float.compare(value, 2.0f) < 0, 5.0f);
        Assert.assertTrue(Float.compare(detect1, 0) == 0 || Float.compare(detect1, 1) == 0);
        Assert.assertEquals(5.0f, this.map.detectIfNone(value -> value > 2.0f, 5.0f), 0.0f);
    }

    @Test
    public void collect() {
        FloatToObjectFunction<String> toString = String::valueOf;
        ObjectFloatMap<Integer> map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        Assert.assertTrue(map1.collect(toString).toString(), FastList.newListWith("1.0", "0.0").equals(map1.collect(toString)) || FastList.newListWith("0.0", "1.0").equals(map1.collect(toString)));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3.0, this.map.sum(), 0.0);
    }

    @Test
    public void max() {
        Assert.assertEquals(2.0f, this.map.max(), 0.0f);
        Assert.assertEquals(3.0f, this.newWithKeysValues(null, 3.0f, 0, 0.0f, 2, 2.0f).max(), 0.0f);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        this.<Integer>getEmptyMap().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0f, this.map.min(), 0.0f);
        Assert.assertEquals(0.0f, this.newWithKeysValues(null, 0.0f, 5, 5.0f, 1, 1.0f).min(), 0.0f);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        this.<Integer>getEmptyMap().min();
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2.0f, this.map.maxIfEmpty(5.0f), 0.0f);
        Assert.assertEquals(3.0f, this.newWithKeysValues(null, 3.0f, 0, 0.0f, 2, 2.0f).maxIfEmpty(5.0f), 0.0f);
        Assert.assertEquals(9.0f, this.getEmptyMap().maxIfEmpty(9.0f), 0.0f);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(0.0f, this.map.minIfEmpty(6.0f), 0.0f);
        Assert.assertEquals(0.0f, this.newWithKeysValues(null, 0.0f, 5, 5.0f, 1, 1.0f).minIfEmpty(6.0f), 0.0f);
        Assert.assertEquals(5.0f, this.getEmptyMap().minIfEmpty(5.0f), 0.0f);
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
        Assert.assertEquals(1.5, this.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f, "3", 3.0f).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new float[] { 0.0f, 1.0f }, this.newWithKeysValues("0", 0.0f, "1", 1.0f).toArray()) || Arrays.equals(new float[] { 1.0f, 0.0f }, this.newWithKeysValues("0", 0.0f, "1", 1.0f).toArray()));
        Assert.assertArrayEquals(new float[] {}, this.getEmptyMap().toArray(), 0.0f);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 0.0f, 2.0f, 9.0f }, this.newWithKeysValues("9", 9.0f, "0", 0.0f, "2", 2.0f).toSortedArray(), 0.0f);
        Assert.assertArrayEquals(new float[] {}, this.getEmptyMap().toSortedArray(), 0.0f);
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertTrue(this.map.contains(1.0f));
        Assert.assertTrue(this.map.contains(2.0f));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0.0f, 1.0f, 2.0f));
        Assert.assertFalse(this.map.containsAll(0.0f, 1.0f, 5.0f));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 5.0f)));
        Assert.assertTrue(this.map.containsAll(new FloatArrayList()));
    }

    @Test
    public void toList() {
        Assert.assertTrue(FloatArrayList.newListWith(0.0f, 1.0f).equals(this.newWithKeysValues("0", 0.0f, "1", 1.0f).toList()) || FloatArrayList.newListWith(1.0f, 0.0f).equals(this.newWithKeysValues("0", 0.0f, "1", 1.0f).toList()));
        Assert.assertEquals(FloatArrayList.newListWith(), this.getEmptyMap().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 2.0f, 9.0f), this.newWithKeysValues("9", 9.0f, "0", 0.0f, "2", 2.0f).toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(), this.getEmptyMap().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f), this.map.toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(), this.getEmptyMap().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f), this.map.toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(), this.getEmptyMap().toBag());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectFloatMap.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySet, this.description("keySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::values, this.description("values"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrThrow, this.description("getOrThrow"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testHashCode, this.description("testHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachValue, this.description("forEachValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKey, this.description("forEachKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValue, this.description("forEachKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoKeyValue, this.description("injectIntoKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::tap, this.description("tap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_throws_emptyList, this.description("max_throws_emptyList"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_throws_emptyList, this.description("min_throws_emptyList"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxIfEmpty, this.description("maxIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minIfEmpty, this.description("minIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::average, this.description("average"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::averageThrowsOnEmpty, this.description("averageThrowsOnEmpty"), java.lang.ArithmeticException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::median, this.description("median"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::medianThrowsOnEmpty, this.description("medianThrowsOnEmpty"), java.lang.ArithmeticException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll, this.description("containsAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll_Iterable, this.description("containsAll_Iterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractObjectFloatMapTestCase implementation();
    }
}
