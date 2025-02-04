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
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ObjectLongMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractObjectLongMapTestCase {

    private final ObjectLongMap<String> map = this.classUnderTest();

    protected abstract ObjectLongMap<String> classUnderTest();

    protected abstract <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1);

    protected abstract <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2);

    protected abstract <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3);

    protected abstract <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4);

    protected abstract <T> ObjectLongMap<T> getEmptyMap();

    @Test
    public void keySet() {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0"), this.newWithKeysValues("0", 0L).keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0", "1", "2"), this.newWithKeysValues("0", 0L, "1", 1L, "2", 2L).keySet());
    }

    @Test
    public void values() {
        Verify.assertEmpty(this.getEmptyMap().values());
        ObjectLongMap<String> map = this.newWithKeysValues("0", 0L);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0L));
        ObjectLongMap<String> map1 = this.newWithKeysValues("0", 0L, "1", 1L, "2", 2L);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0L));
        Assert.assertTrue(map1.values().contains(1L));
        Assert.assertTrue(map1.values().contains(2L));
    }

    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get("0"));
        Assert.assertEquals(1L, this.map.get("1"));
        Assert.assertEquals(2L, this.map.get("2"));
    }

    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow("0"));
        Assert.assertEquals(1L, this.map.getOrThrow("1"));
        Assert.assertEquals(2L, this.map.getOrThrow("2"));
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
        Assert.assertTrue(this.map.containsValue(0L));
        Assert.assertTrue(this.map.containsValue(1L));
        Assert.assertTrue(this.map.containsValue(2L));
    }

    @Test
    public void size() {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, 0L));
        Verify.assertSize(1, this.newWithKeysValues(1, 1L));
        Verify.assertSize(1, this.newWithKeysValues(null, 2L));
        Verify.assertSize(2, this.newWithKeysValues(1, 1L, 5, 5L));
        Verify.assertSize(2, this.newWithKeysValues(0, 0L, 5, 5L));
        Verify.assertSize(3, this.newWithKeysValues(1, 1L, 0, 0L, 5, 5L));
        Verify.assertSize(2, this.newWithKeysValues(6, 6L, 5, 5L));
    }

    @Test
    public void isEmpty() {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, 1L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, 1L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, 0L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, 50L).isEmpty());
    }

    @Test
    public void notEmpty() {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, 1L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, 1L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, 0L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, 50L).notEmpty());
    }

    @Test
    public void asLazy() {
        Verify.assertSize(this.map.toList().size(), this.map.asLazy().toList());
        Assert.assertTrue(this.map.asLazy().toList().containsAll(this.map.toList()));
    }

    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent("0", 1L));
        Assert.assertEquals(1L, this.map.getIfAbsent("1", 2L));
        Assert.assertEquals(2L, this.map.getIfAbsent("2", 3L));
        Assert.assertEquals(1L, this.map.getIfAbsent("5", 1L));
        Assert.assertEquals(0L, this.map.getIfAbsent("5", 0L));
        Assert.assertEquals(1L, this.map.getIfAbsent(null, 1L));
        Assert.assertEquals(0L, this.map.getIfAbsent(null, 0L));
    }

    @Test
    public void testEquals() {
        ObjectLongMap<Integer> map1 = this.newWithKeysValues(0, 0L, 1, 1L, null, 2L);
        ObjectLongMap<Integer> map2 = this.newWithKeysValues(null, 2L, 0, 0L, 1, 1L);
        ObjectLongMap<Integer> map3 = this.newWithKeysValues(0, 0L, 1, 2L, null, 2L);
        ObjectLongMap<Integer> map5 = this.newWithKeysValues(0, 0L, 1, 1L, null, 3L);
        ObjectLongMap<Integer> map7 = this.newWithKeysValues(null, 2L, 1, 1L);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map7);
        Assert.assertEquals(map1, ObjectLongMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ObjectLongMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0L, 1, 1L).hashCode(), this.newWithKeysValues(0, 0L, 1, 1L).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(50, 0L, null, 1L).hashCode(), this.newWithKeysValues(50, 0L, null, 1L).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("{}", this.<Integer>getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues(0, 0L).toString());
        ObjectLongMap<Integer> map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertTrue(map1.toString(), "{0=0, 1=1}".equals(map1.toString()) || "{1=1, 0=0}".equals(map1.toString()));
        ObjectLongMap<Integer> map2 = this.newWithKeysValues(1, 1L, null, 0L);
        Assert.assertTrue(map2.toString(), "{1=1, null=0}".equals(map2.toString()) || "{null=0, 1=1}".equals(map2.toString()));
    }

    @Test
    public void longIterator() {
        MutableLongSet expected = LongHashSet.newSetWith(0L, 1L, 2L);
        MutableLongSet actual = LongHashSet.newSetWith();
        LongIterator iterator = this.map.longIterator();
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
            this.getEmptyMap().longIterator().next();
        });
    }

    @Test
    public void forEach() {
        ObjectLongMap<Integer> map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        long[] sum01 = new long[1];
        map01.forEach(each -> {
            sum01[0] += each;
        });
        Assert.assertEquals(3L, sum01[0]);
        ObjectLongMap<Integer> map = this.newWithKeysValues(3, 4L, 4, 5L);
        long[] sum = new long[1];
        map.forEach(each -> {
            sum[0] += each;
        });
        Assert.assertEquals(9L, sum[0]);
        ObjectLongMap<Integer> map1 = this.newWithKeysValues(3, 4L, null, 5L);
        long[] sum1 = new long[1];
        map1.forEach(each -> {
            sum1[0] += each;
        });
        Assert.assertEquals(9L, sum1[0]);
    }

    @Test
    public void forEachValue() {
        ObjectLongMap<Integer> map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        long[] sum01 = new long[1];
        map01.forEachValue((long each) -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);
        ObjectLongMap<Integer> map = this.newWithKeysValues(3, 4L, null, 5L);
        long[] sum = new long[1];
        map.forEachValue((long each) -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);
    }

    @Test
    public void forEachKey() {
        ObjectLongMap<Integer> map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        int[] sum01 = new int[1];
        map01.forEachKey((Integer each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);
        ObjectLongMap<Integer> map = this.newWithKeysValues(3, 4L, null, 5L);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue() {
        ObjectLongMap<Integer> map01 = this.newWithKeysValues(0, 1L, 1, 2L);
        int[] sumKey01 = new int[1];
        long[] sumValue01 = new long[1];
        map01.forEachKeyValue((Integer eachKey, long eachValue) -> {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);
        ObjectLongMap<Integer> map = this.newWithKeysValues(3, 4L, null, 5L);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        long[] sumValue = new long[1];
        map.forEachKeyValue((Integer eachKey, long eachValue) -> {
            sumKey[0] += String.valueOf(eachKey);
            sumValue[0] += eachValue;
        });
        Assert.assertTrue("3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertEquals(9L, sumValue[0]);
    }

    @Test
    public void injectIntoKeyValue() {
        ObjectLongMap<String> map0 = this.newWithKeysValues("2", 3L, "4", 5L);
        String result0 = map0.injectIntoKeyValue(new String("1"), (result, eachKey, eachValue) -> result + eachKey + String.valueOf(eachValue));
        Assert.assertTrue(result0, "12345".equals(result0) || "14523".equals(result0));
        ObjectLongMap copy = map0.injectIntoKeyValue(ObjectLongMaps.mutable.empty(), MutableObjectLongMap::withKeyValue);
        Assert.assertEquals(map0, copy);
    }

    @Test
    public void makeString() {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0, 0L).makeString());
        Assert.assertEquals("1", this.newWithKeysValues(1, 1L).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(null, 5L).makeString());
        ObjectLongMap<Integer> map2 = this.newWithKeysValues(1, 1L, 32, 32L);
        Assert.assertTrue(map2.makeString("[", "/", "]"), "[1/32]".equals(map2.makeString("[", "/", "]")) || "[32/1]".equals(map2.makeString("[", "/", "]")));
        Assert.assertTrue(map2.makeString("/"), "1/32".equals(map2.makeString("/")) || "32/1".equals(map2.makeString("/")));
    }

    @Test
    public void appendString() {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, 0L).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());
        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, 1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, 5L).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());
        Appendable appendable3 = new StringBuilder();
        ObjectLongMap<Integer> map1 = this.newWithKeysValues(0, 0L, 1, 1L);
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
        Assert.assertEquals(this.map, this.map.select((String object, long value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L), this.map.select((String object, long value) -> Integer.parseInt(object) + value < 4L));
        Assert.assertEquals(this.getEmptyMap(), this.map.select((String object, long value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 2L), this.map.select(value -> value < 3L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L), this.map.select(value -> value < 2L).toBag());
        Assert.assertEquals(new LongHashBag(), this.map.select(value -> value > 2L).toBag());
    }

    @Test
    public void reject() {
        Assert.assertEquals(this.getEmptyMap(), this.map.reject((String object, long value) -> ((Integer.parseInt(object) + value) % 2) == 0));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 2L), this.map.reject((String object, long value) -> Integer.parseInt(object) + value < 4L));
        Assert.assertEquals(this.map, this.map.reject((String object, long value) -> ((Integer.parseInt(object) + value) % 2) != 0));
        Assert.assertEquals(new LongHashBag(), this.map.reject(value -> value < 3L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(2L), this.map.reject(value -> value < 2L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 2L), this.map.reject(value -> value > 2L).toBag());
    }

    @Test
    public void tap() {
        MutableLongList tapResult = LongLists.mutable.empty();
        Assert.assertSame(this.map, this.map.tap(tapResult::add));
        Assert.assertEquals(this.map.toList(), tapResult);
    }

    @Test
    public void count() {
        Assert.assertEquals(3L, this.map.count(value -> value < 3L));
        Assert.assertEquals(2L, this.map.count(value -> value < 2L));
        Assert.assertEquals(0L, this.map.count(value -> value > 2L));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.map.anySatisfy(value -> value < 3L));
        Assert.assertTrue(this.map.anySatisfy(value -> value < 2L));
        Assert.assertFalse(this.map.anySatisfy(value -> value > 2L));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.map.allSatisfy(value -> value < 3L));
        Assert.assertFalse(this.map.allSatisfy(value -> value < 2L));
        Assert.assertFalse(this.map.allSatisfy(value -> value > 2L));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.map.noneSatisfy(value -> value < 0L));
        Assert.assertFalse(this.map.noneSatisfy(value -> value < 2L));
    }

    @Test
    public void detectIfNone() {
        long detect = this.map.detectIfNone(value -> value < 3L, 5L);
        Assert.assertTrue(detect == 0 || detect == 1 || detect == 2);
        long detect1 = this.map.detectIfNone(value -> value < 2L, 5L);
        Assert.assertTrue(detect1 == 0 || detect1 == 1);
        Assert.assertEquals(5L, this.map.detectIfNone(value -> value > 2L, 5L));
    }

    @Test
    public void collect() {
        LongToObjectFunction<String> toString = String::valueOf;
        ObjectLongMap<Integer> map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertTrue(map1.collect(toString).toString(), FastList.newListWith("1", "0").equals(map1.collect(toString)) || FastList.newListWith("0", "1").equals(map1.collect(toString)));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3L, this.map.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals(2L, this.map.max());
        Assert.assertEquals(3L, this.newWithKeysValues(null, 3L, 0, 0L, 2, 2L).max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        this.<Integer>getEmptyMap().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0L, this.map.min());
        Assert.assertEquals(0L, this.newWithKeysValues(null, 0L, 5, 5L, 1, 1L).min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        this.<Integer>getEmptyMap().min();
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2L, this.map.maxIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues(null, 3L, 0, 0L, 2, 2L).maxIfEmpty(5L));
        Assert.assertEquals(9L, this.getEmptyMap().maxIfEmpty(9L));
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(0L, this.map.minIfEmpty(6L));
        Assert.assertEquals(0L, this.newWithKeysValues(null, 0L, 5, 5L, 1, 1L).minIfEmpty(6L));
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty(5L));
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
        Assert.assertEquals(1.5, this.newWithKeysValues("0", 0L, "1", 1L, "2", 2L, "3", 3L).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        this.getEmptyMap().median();
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new long[] { 0L, 1L }, this.newWithKeysValues("0", 0L, "1", 1L).toArray()) || Arrays.equals(new long[] { 1L, 0L }, this.newWithKeysValues("0", 0L, "1", 1L).toArray()));
        Assert.assertArrayEquals(new long[] {}, this.getEmptyMap().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new long[] { 0L, 2L, 9L }, this.newWithKeysValues("9", 9L, "0", 0L, "2", 2L).toSortedArray());
        Assert.assertArrayEquals(new long[] {}, this.getEmptyMap().toSortedArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0L));
        Assert.assertTrue(this.map.contains(1L));
        Assert.assertTrue(this.map.contains(2L));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.map.containsAll(0L, 1L, 2L));
        Assert.assertFalse(this.map.containsAll(0L, 1L, 5L));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable() {
        Assert.assertTrue(this.map.containsAll(LongArrayList.newListWith(0L, 1L, 2L)));
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 1L, 5L)));
        Assert.assertTrue(this.map.containsAll(new LongArrayList()));
    }

    @Test
    public void toList() {
        Assert.assertTrue(LongArrayList.newListWith(0L, 1L).equals(this.newWithKeysValues("0", 0L, "1", 1L).toList()) || LongArrayList.newListWith(1L, 0L).equals(this.newWithKeysValues("0", 0L, "1", 1L).toList()));
        Assert.assertEquals(LongArrayList.newListWith(), this.getEmptyMap().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(LongArrayList.newListWith(0L, 2L, 9L), this.newWithKeysValues("9", 9L, "0", 0L, "2", 2L).toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(), this.getEmptyMap().toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L), this.map.toSet());
        Assert.assertEquals(LongHashSet.newSetWith(), this.getEmptyMap().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 2L), this.map.toBag());
        Assert.assertEquals(LongHashBag.newBagWith(), this.getEmptyMap().toBag());
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectLongMap.class, this.classUnderTest().toImmutable());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractObjectLongMapTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractObjectLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractObjectLongMapTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractObjectLongMapTestCase::keySet;
            this.payloads.values = AbstractObjectLongMapTestCase::values;
            this.payloads.get = AbstractObjectLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractObjectLongMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractObjectLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractObjectLongMapTestCase::containsValue;
            this.payloads.size = AbstractObjectLongMapTestCase::size;
            this.payloads.isEmpty = AbstractObjectLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractObjectLongMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractObjectLongMapTestCase::asLazy;
            this.payloads.getIfAbsent = AbstractObjectLongMapTestCase::getIfAbsent;
            this.payloads.testEquals = AbstractObjectLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractObjectLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractObjectLongMapTestCase::testToString;
            this.payloads.longIterator = AbstractObjectLongMapTestCase::longIterator;
            this.payloads.forEach = AbstractObjectLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractObjectLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractObjectLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractObjectLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractObjectLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractObjectLongMapTestCase::makeString;
            this.payloads.appendString = AbstractObjectLongMapTestCase::appendString;
            this.payloads.select = AbstractObjectLongMapTestCase::select;
            this.payloads.reject = AbstractObjectLongMapTestCase::reject;
            this.payloads.tap = AbstractObjectLongMapTestCase::tap;
            this.payloads.count = AbstractObjectLongMapTestCase::count;
            this.payloads.anySatisfy = AbstractObjectLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractObjectLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractObjectLongMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractObjectLongMapTestCase::detectIfNone;
            this.payloads.collect = AbstractObjectLongMapTestCase::collect;
            this.payloads.sum = AbstractObjectLongMapTestCase::sum;
            this.payloads.max = AbstractObjectLongMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectLongMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractObjectLongMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectLongMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractObjectLongMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractObjectLongMapTestCase::minIfEmpty;
            this.payloads.average = AbstractObjectLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractObjectLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractObjectLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractObjectLongMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractObjectLongMapTestCase::toSortedArray;
            this.payloads.contains = AbstractObjectLongMapTestCase::contains;
            this.payloads.containsAll = AbstractObjectLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractObjectLongMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractObjectLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractObjectLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractObjectLongMapTestCase::toSet;
            this.payloads.toBag = AbstractObjectLongMapTestCase::toBag;
            this.payloads.toImmutable = AbstractObjectLongMapTestCase::toImmutable;
        }
    }
*/
}
