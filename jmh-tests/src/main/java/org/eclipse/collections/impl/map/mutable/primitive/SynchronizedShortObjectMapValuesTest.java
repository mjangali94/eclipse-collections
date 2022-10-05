/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortObjectMap#values()}.
 *
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapValuesTest.stg.
 */
public class SynchronizedShortObjectMapValuesTest {

    private SynchronizedShortObjectMap<String> newMapWithKeysValues(short key1, String value1, short key2, String value2) {
        return new SynchronizedShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    private SynchronizedShortObjectMap<Integer> newMapWithKeysValues(short key1, Integer value1, short key2, Integer value2, short key3, Integer value3) {
        return new SynchronizedShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private SynchronizedShortObjectMap<Integer> newMapWithKeysValues(short key1, Integer value1, short key2, Integer value2, short key3, Integer value3, short key4, Integer value4) {
        return new SynchronizedShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void clear() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        map.values().clear();
        Verify.assertIterableEmpty(map);
        Verify.assertEmpty(map.values());
    }

    @Test
    public void contains() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
        values.remove(null);
        Assert.assertFalse(values.contains(null));
        map.removeKey((short) 1);
        Assert.assertFalse(values.contains(1));
    }

    @Test
    public void containsAll() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
        values.remove(null);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        map.removeKey((short) 1);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(2)));
    }

    @Test
    public void isEmpty() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3, (short) 1, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        ShortObjectHashMap<Integer> map1 = ShortObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put((short) 1, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3, (short) 4, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
        map.remove((short) 1);
        Verify.assertSize(3, values);
        map.put((short) 5, 5);
        Verify.assertSize(4, values);
        ShortObjectHashMap<Integer> map1 = ShortObjectHashMap.newMap();
        Collection<Integer> keySet1 = map1.values();
        Verify.assertSize(0, keySet1);
        map1.put((short) 1, null);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, null).iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        MutableShortObjectMap<String> map1 = this.newMapWithKeysValues((short) 0, "zero", (short) 1, null);
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), ShortObjectHashMap.newWithKeysValues((short) 0, "zero").equals(map1) || ShortObjectHashMap.newWithKeysValues((short) 1, null).equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(ShortObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableShortObjectMap<String> map2 = this.newMapWithKeysValues((short) 0, null, (short) 9, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), ShortObjectHashMap.newWithKeysValues((short) 0, null).equals(map2) || ShortObjectHashMap.newWithKeysValues((short) 9, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(ShortObjectHashMap.newMap(), map2);
        MutableShortObjectMap<String> map3 = this.newMapWithKeysValues((short) 8, "eight", (short) 9, null);
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), ShortObjectHashMap.newWithKeysValues((short) 8, "eight").equals(map3) || ShortObjectHashMap.newWithKeysValues((short) 9, null).equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(ShortObjectHashMap.newMap(), map3);
    }

    @Test
    public void values() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void removeFromValues() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertFalse(map.values().remove(4));
        Assert.assertTrue(map.values().remove(2));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 1, (short) 3, 3), map);
    }

    @Test
    public void removeNullFromValues() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertFalse(map.values().remove(null));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3), map);
        map.put((short) 4, null);
        Assert.assertTrue(map.values().remove(null));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3), map);
    }

    @Test
    public void removeAllFromValues() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertFalse(map.values().removeAll(FastList.newListWith(4)));
        Assert.assertTrue(map.values().removeAll(FastList.newListWith(2, 4)));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 1, (short) 3, 3), map);
    }

    @Test
    public void retainAllFromValues() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        Assert.assertFalse(map.values().retainAll(FastList.newListWith(1, 2, 3, 4)));
        Assert.assertTrue(map.values().retainAll(FastList.newListWith(1, 3)));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 1, (short) 3, 3), map);
    }

    @Test
    public void valuesToArray() {
        SynchronizedShortObjectMap<Integer> map = this.newMapWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, null);
        HashBag<Integer> expected = HashBag.newBagWith(1, 2, null);
        Collection<Integer> values = map.values();
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size() + 1])));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedShortObjectMapValuesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortObjectMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapValuesTest> valuesToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapValuesTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = SynchronizedShortObjectMapValuesTest::clear;
            this.payloads.contains = SynchronizedShortObjectMapValuesTest::contains;
            this.payloads.containsAll = SynchronizedShortObjectMapValuesTest::containsAll;
            this.payloads.isEmpty = SynchronizedShortObjectMapValuesTest::isEmpty;
            this.payloads.size = SynchronizedShortObjectMapValuesTest::size;
            this.payloads.iterator = SynchronizedShortObjectMapValuesTest::iterator;
            this.payloads.values = SynchronizedShortObjectMapValuesTest::values;
            this.payloads.removeFromValues = SynchronizedShortObjectMapValuesTest::removeFromValues;
            this.payloads.removeNullFromValues = SynchronizedShortObjectMapValuesTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SynchronizedShortObjectMapValuesTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SynchronizedShortObjectMapValuesTest::retainAllFromValues;
            this.payloads.valuesToArray = SynchronizedShortObjectMapValuesTest::valuesToArray;
        }
    }
}
