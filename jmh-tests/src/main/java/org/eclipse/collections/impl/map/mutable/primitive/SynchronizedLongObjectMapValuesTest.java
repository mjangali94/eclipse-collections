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
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedLongObjectMap#values()}.
 *
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapValuesTest.stg.
 */
public class SynchronizedLongObjectMapValuesTest {

    private SynchronizedLongObjectMap<String> newMapWithKeysValues(long key1, String value1, long key2, String value2) {
        return new SynchronizedLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    private SynchronizedLongObjectMap<Integer> newMapWithKeysValues(long key1, Integer value1, long key2, Integer value2, long key3, Integer value3) {
        return new SynchronizedLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private SynchronizedLongObjectMap<Integer> newMapWithKeysValues(long key1, Integer value1, long key2, Integer value2, long key3, Integer value3, long key4, Integer value4) {
        return new SynchronizedLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void clear() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        map.values().clear();
        Verify.assertIterableEmpty(map);
        Verify.assertEmpty(map.values());
    }

    @Test
    public void contains() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
        values.remove(null);
        Assert.assertFalse(values.contains(null));
        map.removeKey(1L);
        Assert.assertFalse(values.contains(1));
    }

    @Test
    public void containsAll() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
        values.remove(null);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        map.removeKey(1L);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(2)));
    }

    @Test
    public void isEmpty() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3, 1L, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        LongObjectHashMap<Integer> map1 = LongObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put(1L, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3, 4L, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
        map.remove(1L);
        Verify.assertSize(3, values);
        map.put(5L, 5);
        Verify.assertSize(4, values);
        LongObjectHashMap<Integer> map1 = LongObjectHashMap.newMap();
        Collection<Integer> keySet1 = map1.values();
        Verify.assertSize(0, keySet1);
        map1.put(1L, null);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, null).iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        MutableLongObjectMap<String> map1 = this.newMapWithKeysValues(0L, "zero", 1L, null);
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), LongObjectHashMap.newWithKeysValues(0L, "zero").equals(map1) || LongObjectHashMap.newWithKeysValues(1L, null).equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableLongObjectMap<String> map2 = this.newMapWithKeysValues(0L, null, 9L, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), LongObjectHashMap.newWithKeysValues(0L, null).equals(map2) || LongObjectHashMap.newWithKeysValues(9L, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map2);
        MutableLongObjectMap<String> map3 = this.newMapWithKeysValues(8L, "eight", 9L, null);
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), LongObjectHashMap.newWithKeysValues(8L, "eight").equals(map3) || LongObjectHashMap.newWithKeysValues(9L, null).equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map3);
    }

    @Test
    public void values() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void removeFromValues() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().remove(4));
        Assert.assertTrue(map.values().remove(2));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 3L, 3), map);
    }

    @Test
    public void removeNullFromValues() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().remove(null));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3), map);
        map.put(4L, null);
        Assert.assertTrue(map.values().remove(null));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3), map);
    }

    @Test
    public void removeAllFromValues() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().removeAll(FastList.newListWith(4)));
        Assert.assertTrue(map.values().removeAll(FastList.newListWith(2, 4)));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 3L, 3), map);
    }

    @Test
    public void retainAllFromValues() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().retainAll(FastList.newListWith(1, 2, 3, 4)));
        Assert.assertTrue(map.values().retainAll(FastList.newListWith(1, 3)));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 3L, 3), map);
    }

    @Test
    public void valuesToArray() {
        SynchronizedLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        HashBag<Integer> expected = HashBag.newBagWith(1, 2, null);
        Collection<Integer> values = map.values();
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size() + 1])));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedLongObjectMapValuesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedLongObjectMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongObjectMapValuesTest> valuesToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongObjectMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongObjectMapValuesTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = SynchronizedLongObjectMapValuesTest::clear;
            this.payloads.contains = SynchronizedLongObjectMapValuesTest::contains;
            this.payloads.containsAll = SynchronizedLongObjectMapValuesTest::containsAll;
            this.payloads.isEmpty = SynchronizedLongObjectMapValuesTest::isEmpty;
            this.payloads.size = SynchronizedLongObjectMapValuesTest::size;
            this.payloads.iterator = SynchronizedLongObjectMapValuesTest::iterator;
            this.payloads.values = SynchronizedLongObjectMapValuesTest::values;
            this.payloads.removeFromValues = SynchronizedLongObjectMapValuesTest::removeFromValues;
            this.payloads.removeNullFromValues = SynchronizedLongObjectMapValuesTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SynchronizedLongObjectMapValuesTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SynchronizedLongObjectMapValuesTest::retainAllFromValues;
            this.payloads.valuesToArray = SynchronizedLongObjectMapValuesTest::valuesToArray;
        }
    }
*/
}
