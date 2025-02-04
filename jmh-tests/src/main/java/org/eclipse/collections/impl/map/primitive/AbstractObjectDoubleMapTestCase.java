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
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.ObjectDoubleMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractObjectDoubleMapTestCase {

    private final ObjectDoubleMap<String> map = this.classUnderTest();

    protected abstract ObjectDoubleMap<String> classUnderTest();

    protected abstract <T> ObjectDoubleMap<T> newWithKeysValues(T key1, double value1);

    protected abstract <T> ObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2);

    protected abstract <T> ObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3);

    protected abstract <T> ObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3, T key4, double value4);

    protected abstract <T> ObjectDoubleMap<T> getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0"), this.newWithKeysValues("0", 0.0).keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0", "1", "2"), this.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ObjectDoubleMap<String> map = this.newWithKeysValues("0", 0.0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0));
        ObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0));
        Assert.assertTrue(map1.values().contains(1.0));
        Assert.assertTrue(map1.values().contains(2.0));
    }

    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get("0"), 0.0);
        Assert.assertEquals(1.0, this.map.get("1"), 0.0);
        Assert.assertEquals(2.0, this.map.get("2"), 0.0);
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow("0"), 0.0);
        Assert.assertEquals(1.0, this.map.getOrThrow("1"), 0.0);
        Assert.assertEquals(2.0, this.map.getOrThrow("2"), 0.0);
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
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertTrue(this.map.containsValue(1.0));
        Assert.assertTrue(this.map.containsValue(2.0));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, 0.0));
        Verify.assertSize(1, this.newWithKeysValues(1, 1.0));
        Verify.assertSize(1, this.newWithKeysValues(null, 2.0));
        Verify.assertSize(2, this.newWithKeysValues(1, 1.0, 5, 5.0));
        Verify.assertSize(2, this.newWithKeysValues(0, 0.0, 5, 5.0));
        Verify.assertSize(3, this.newWithKeysValues(1, 1.0, 0, 0.0, 5, 5.0));
        Verify.assertSize(2, this.newWithKeysValues(6, 6.0, 5, 5.0));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, 1.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, 1.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, 0.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, 50.0).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, 1.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, 1.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, 0.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, 50.0).notEmpty());
    }

    @Test
    public void asLazy() {
        Verify.assertSize(this.map.toList().size(), this.map.asLazy().toList());
        Assert.assertTrue(this.map.asLazy().toList().containsAll(this.map.toList()));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent("0", 1.0), 0.0);
        Assert.assertEquals(1.0, this.map.getIfAbsent("1", 2.0), 0.0);
        Assert.assertEquals(2.0, this.map.getIfAbsent("2", 3.0), 0.0);
        Assert.assertEquals(1.0, this.map.getIfAbsent("5", 1.0), 0.0);
        Assert.assertEquals(0.0, this.map.getIfAbsent("5", 0.0), 0.0);
        Assert.assertEquals(1.0, this.map.getIfAbsent(null, 1.0), 0.0);
        Assert.assertEquals(0.0, this.map.getIfAbsent(null, 0.0), 0.0);
    }

    @Test
    public void testEquals() {
        ObjectDoubleMap<Integer> map1 = this.newWithKeysValues(0, 0.0, 1, 1.0, null, 2.0);
        ObjectDoubleMap<Integer> map2 = this.newWithKeysValues(null, 2.0, 0, 0.0, 1, 1.0);
        ObjectDoubleMap<Integer> map3 = this.newWithKeysValues(0, 0.0, 1, 2.0, null, 2.0);
        ObjectDoubleMap<Integer> map5 = this.newWithKeysValues(0, 0.0, 1, 1.0, null, 3.0);
        ObjectDoubleMap<Integer> map7 = this.newWithKeysValues(null, 2.0, 1, 1.0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map7);
        Assert.assertEquals(map1, ObjectDoubleMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ObjectDoubleMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0.0, 1, 1.0).hashCode(), this.newWithKeysValues(0, 0.0, 1, 1.0).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, 0.0, null, 1.0).hashCode(), this.newWithKeysValues(50, 0.0, null, 1.0).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.<Integer>getEmptyMap().toString());
        Assert.assertEquals("{0=0.0}", this.newWithKeysValues(0, 0.0).toString());
        ObjectDoubleMap<Integer> map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertTrue(map1.toString(), "{0=0.0, 1=1.0}".equals(map1.toString()) || "{1=1.0, 0=0.0}".equals(map1.toString()));
        ObjectDoubleMap<Integer> map2 = this.newWithKeysValues(1, 1.0, null, 0.0);
        Assert.assertTrue(map2.toString(), "{1=1.0, null=0.0}".equals(map2.toString()) || "{null=0.0, 1=1.0}".equals(map2.toString()));
    }

    @Test
    public void doubleIterator() {
        MutableDoubleSet expected = DoubleHashSet.newSetWith(0.0, 1.0, 2.0);
        MutableDoubleSet actual = DoubleHashSet.newSetWith();
        DoubleIterator iterator = this.map.doubleIterator();
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
            this.getEmptyMap().doubleIterator().next();
        });
    }

    @Test
    public void forEach() {
        ObjectDoubleMap<Integer> map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        double[] sum01 = new double[1];
        map01.forEach(each -> {
            sum01[0] += each;
        });
        Assert.assertEquals(3.0, sum01[0], 0.0);
        ObjectDoubleMap<Integer> map = this.newWithKeysValues(3, 4.0, 4, 5.0);
        double[] sum = new double[1];
        map.forEach(each -> {
            sum[0] += each;
        });
        Assert.assertEquals(9.0, sum[0], 0.0);
        ObjectDoubleMap<Integer> map1 = this.newWithKeysValues(3, 4.0, null, 5.0);
        double[] sum1 = new double[1];
        map1.forEach(each -> {
            sum1[0] += each;
        });
        Assert.assertEquals(9.0, sum1[0], 0.0);
    }

    @Test
    public void forEachValue() {
        ObjectDoubleMap<Integer> map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        double[] sum01 = new double[1];
        map01.forEachValue((double each) -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);
        ObjectDoubleMap<Integer> map = this.newWithKeysValues(3, 4.0, null, 5.0);
        double[] sum = new double[1];
        map.forEachValue((double each) -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    @Test
    public void forEachKey() {
        ObjectDoubleMap<Integer> map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        int[] sum01 = new int[1];
        map01.forEachKey((Integer each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        ObjectDoubleMap<Integer> map = this.newWithKeysValues(3, 4.0, null, 5.0);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue() {
        ObjectDoubleMap<Integer> map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        int[] sumKey01 = new int[1];
        double[] sumValue01 = new double[1];
        map01.forEachKeyValue((Integer eachKey, double eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals(3.0, sumValue01[0], 0.0);
        ObjectDoubleMap<Integer> map = this.newWithKeysValues(3, 4.0, null, 5.0);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        double[] sumValue = new double[1];
        map.forEachKeyValue((Integer eachKey, double eachValue) -> {
            sumKey[0] += String.valueOf(eachKey);
            sumValue[0] += eachValue;
        });
        Assert.assertTrue("3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertEquals(9.0, sumValue[0], 0.0);
    }

    @Test
    public void injectIntoKeyValue() {
        ObjectDoubleMap<String> map0 = this.newWithKeysValues("2", 3.0, "4", 5.0);
        String result0 = map0.injectIntoKeyValue(new String("1"), (result, eachKey, eachValue) -> result + eachKey + String.valueOf(eachValue));
        Assert.assertTrue(result0, "123.045.0".equals(result0) || "145.023.0".equals(result0));
        ObjectDoubleMap copy = map0.injectIntoKeyValue(ObjectDoubleMaps.mutable.empty(), MutableObjectDoubleMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues(0, 0.0).makeString());
        Assert.assertEquals("1.0", this.newWithKeysValues(1, 1.0).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues(null, 5.0).makeString());
        ObjectDoubleMap<Integer> map2 = this.newWithKeysValues(1, 1.0, 32, 32.0);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1.0/32.0]".equals(map2.makeString("[", "/", "]")) || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));
        Assert.assertTrue(map2.makeString("/"), "1.0/32.0".equals(map2.makeString("/")) || "32.0/1.0".equals(map2.makeString("/")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, 0.0).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, 1.0).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, 5.0).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ObjectDoubleMap<Integer> map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
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
        Assert.assertEquals(this.map, this.map.select((String object, double value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0), this.map.select((String object, double value) -> Double.compare(Integer.parseInt(object) + value, 4.0) < 0));
        Assert.assertEquals(this.getEmptyMap(), this.map.select((String object, double value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 2.0), this.map.select(value -> Double.compare(value, 3.0) < 0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0), this.map.select(value -> Double.compare(value, 2.0) < 0).toBag());
        Assert.assertEquals(new DoubleHashBag(), this.map.select(value -> value > 2.0).toBag());
    }

    @Test
    public void reject() {
        Assert.assertEquals(this.getEmptyMap(), this.map.reject((String object, double value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 2.0), this.map.reject((String object, double value) -> Double.compare(Integer.parseInt(object) + value, 4.0) < 0));
        Assert.assertEquals(this.map, this.map.reject((String object, double value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(new DoubleHashBag(), this.map.reject(value -> Double.compare(value, 3.0) < 0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(2.0), this.map.reject(value -> Double.compare(value, 2.0) < 0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 2.0), this.map.reject(value -> value > 2.0).toBag());
    }

    @Test
    public void tap() {
        MutableDoubleList tapResult = DoubleLists.mutable.empty();
        Assert.assertSame(this.map, this.map.tap(tapResult::add));
        Assert.assertEquals(this.map.toList(), tapResult);
    }

    @Test
    public void count() {
        Assert.assertEquals(3L, this.map.count(value -> Double.compare(value, 3.0) < 0));
        Assert.assertEquals(2L, this.map.count(value -> Double.compare(value, 2.0) < 0));
        Assert.assertEquals(0L, this.map.count(value -> value > 2.0));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.map.anySatisfy(value -> Double.compare(value, 3.0) < 0));
        Assert.assertTrue(this.map.anySatisfy(value -> Double.compare(value, 2.0) < 0));
        Assert.assertFalse(this.map.anySatisfy(value -> value > 2.0));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.map.allSatisfy(value -> Double.compare(value, 3.0) < 0));
        Assert.assertFalse(this.map.allSatisfy(value -> Double.compare(value, 2.0) < 0));
        Assert.assertFalse(this.map.allSatisfy(value -> value > 2.0));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.map.noneSatisfy(value -> Double.compare(value, 0.0) < 0));
        Assert.assertFalse(this.map.noneSatisfy(value -> Double.compare(value, 2.0) < 0));
    }

    @Test
    public void detectIfNone() {
        double detect = this.map.detectIfNone(value -> Double.compare(value, 3.0) < 0, 5.0);
        Assert.assertTrue(Double.compare(detect, 0) == 0 || Double.compare(detect, 1) == 0 || Double.compare(detect, 2) == 0);
        double detect1 = this.map.detectIfNone(value -> Double.compare(value, 2.0) < 0, 5.0);
        Assert.assertTrue(Double.compare(detect1, 0) == 0 || Double.compare(detect1, 1) == 0);
        Assert.assertEquals(5.0, this.map.detectIfNone(value -> value > 2.0, 5.0), 0.0);
    }

    @Test
    public void collect() {
        DoubleToObjectFunction<String> toString = String::valueOf;
        ObjectDoubleMap<Integer> map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertTrue(map1.collect(toString).toString(), FastList.newListWith("1.0", "0.0").equals(map1.collect(toString)) || FastList.newListWith("0.0", "1.0").equals(map1.collect(toString)));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3.0, this.map.sum(), 0.0);
    }

    @Test
    public void max() {
        Assert.assertEquals(2.0, this.map.max(), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(null, 3.0, 0, 0.0, 2, 2.0).max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        this.<Integer>getEmptyMap().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0, this.map.min(), 0.0);
        Assert.assertEquals(0.0, this.newWithKeysValues(null, 0.0, 5, 5.0, 1, 1.0).min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        this.<Integer>getEmptyMap().min();
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2.0, this.map.maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(null, 3.0, 0, 0.0, 2, 2.0).maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(9.0, this.getEmptyMap().maxIfEmpty(9.0), 0.0);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(0.0, this.map.minIfEmpty(6.0), 0.0);
        Assert.assertEquals(0.0, this.newWithKeysValues(null, 0.0, 5, 5.0, 1, 1.0).minIfEmpty(6.0), 0.0);
        Assert.assertEquals(5.0, this.getEmptyMap().minIfEmpty(5.0), 0.0);
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
        Assert.assertEquals(1.5, this.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0, "3", 3.0).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new double[] { 0.0, 1.0 }, this.newWithKeysValues("0", 0.0, "1", 1.0).toArray()) || Arrays.equals(new double[] { 1.0, 0.0 }, this.newWithKeysValues("0", 0.0, "1", 1.0).toArray()));
        Assert.assertArrayEquals(new double[] {}, this.getEmptyMap().toArray(), 0.0);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new double[] { 0.0, 2.0, 9.0 }, this.newWithKeysValues("9", 9.0, "0", 0.0, "2", 2.0).toSortedArray(), 0.0);
        Assert.assertArrayEquals(new double[] {}, this.getEmptyMap().toSortedArray(), 0.0);
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0.0));
        Assert.assertTrue(this.map.contains(1.0));
        Assert.assertTrue(this.map.contains(2.0));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0.0, 1.0, 2.0));
        Assert.assertFalse(this.map.containsAll(0.0, 1.0, 5.0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
        Assert.assertFalse(this.map.containsAll(DoubleArrayList.newListWith(0.0, 1.0, 5.0)));
        Assert.assertTrue(this.map.containsAll(new DoubleArrayList()));
    }

    @Test
    public void toList() {
        Assert.assertTrue(DoubleArrayList.newListWith(0.0, 1.0).equals(this.newWithKeysValues("0", 0.0, "1", 1.0).toList()) || DoubleArrayList.newListWith(1.0, 0.0).equals(this.newWithKeysValues("0", 0.0, "1", 1.0).toList()));
        Assert.assertEquals(DoubleArrayList.newListWith(), this.getEmptyMap().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 2.0, 9.0), this.newWithKeysValues("9", 9.0, "0", 0.0, "2", 2.0).toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(), this.getEmptyMap().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0), this.map.toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(), this.getEmptyMap().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 2.0), this.map.toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(), this.getEmptyMap().toBag());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectDoubleMap.class, this.classUnderTest().toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectDoubleMapTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectDoubleMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractObjectDoubleMapTestCase::keySet;
            this.payloads.values = AbstractObjectDoubleMapTestCase::values;
            this.payloads.get = AbstractObjectDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractObjectDoubleMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractObjectDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractObjectDoubleMapTestCase::containsValue;
            this.payloads.size = AbstractObjectDoubleMapTestCase::size;
            this.payloads.isEmpty = AbstractObjectDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractObjectDoubleMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractObjectDoubleMapTestCase::asLazy;
            this.payloads.getIfAbsent = AbstractObjectDoubleMapTestCase::getIfAbsent;
            this.payloads.testEquals = AbstractObjectDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractObjectDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractObjectDoubleMapTestCase::testToString;
            this.payloads.doubleIterator = AbstractObjectDoubleMapTestCase::doubleIterator;
            this.payloads.forEach = AbstractObjectDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractObjectDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractObjectDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractObjectDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractObjectDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractObjectDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractObjectDoubleMapTestCase::appendString;
            this.payloads.select = AbstractObjectDoubleMapTestCase::select;
            this.payloads.reject = AbstractObjectDoubleMapTestCase::reject;
            this.payloads.tap = AbstractObjectDoubleMapTestCase::tap;
            this.payloads.count = AbstractObjectDoubleMapTestCase::count;
            this.payloads.anySatisfy = AbstractObjectDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractObjectDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractObjectDoubleMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractObjectDoubleMapTestCase::detectIfNone;
            this.payloads.collect = AbstractObjectDoubleMapTestCase::collect;
            this.payloads.sum = AbstractObjectDoubleMapTestCase::sum;
            this.payloads.max = AbstractObjectDoubleMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectDoubleMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractObjectDoubleMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectDoubleMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractObjectDoubleMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractObjectDoubleMapTestCase::minIfEmpty;
            this.payloads.average = AbstractObjectDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractObjectDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractObjectDoubleMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractObjectDoubleMapTestCase::toSortedArray;
            this.payloads.contains = AbstractObjectDoubleMapTestCase::contains;
            this.payloads.containsAll = AbstractObjectDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractObjectDoubleMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractObjectDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractObjectDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractObjectDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractObjectDoubleMapTestCase::toBag;
            this.payloads.toImmutable = AbstractObjectDoubleMapTestCase::toImmutable;
        }
    }
}
