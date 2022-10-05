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
import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedCharObjectMap#values()}.
 *
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapValuesTest.stg.
 */
public class SynchronizedCharObjectMapValuesTest {

    private SynchronizedCharObjectMap<String> newMapWithKeysValues(char key1, String value1, char key2, String value2) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    private SynchronizedCharObjectMap<Integer> newMapWithKeysValues(char key1, Integer value1, char key2, Integer value2, char key3, Integer value3) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private SynchronizedCharObjectMap<Integer> newMapWithKeysValues(char key1, Integer value1, char key2, Integer value2, char key3, Integer value3, char key4, Integer value4) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void clear() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        map.values().clear();
        Verify.assertIterableEmpty(map);
        Verify.assertEmpty(map.values());
    }

    @Test
    public void contains() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
        values.remove(null);
        Assert.assertFalse(values.contains(null));
        map.removeKey((char) 1);
        Assert.assertFalse(values.contains(1));
    }

    @Test
    public void containsAll() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
        values.remove(null);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        map.removeKey((char) 1);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(2)));
    }

    @Test
    public void isEmpty() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3, (char) 1, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        CharObjectHashMap<Integer> map1 = CharObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put((char) 1, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3, (char) 4, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
        map.remove((char) 1);
        Verify.assertSize(3, values);
        map.put((char) 5, 5);
        Verify.assertSize(4, values);
        CharObjectHashMap<Integer> map1 = CharObjectHashMap.newMap();
        Collection<Integer> keySet1 = map1.values();
        Verify.assertSize(0, keySet1);
        map1.put((char) 1, null);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, null).iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        MutableCharObjectMap<String> map1 = this.newMapWithKeysValues((char) 0, "zero", (char) 1, null);
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), CharObjectHashMap.newWithKeysValues((char) 0, "zero").equals(map1) || CharObjectHashMap.newWithKeysValues((char) 1, null).equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(CharObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableCharObjectMap<String> map2 = this.newMapWithKeysValues((char) 0, null, (char) 9, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), CharObjectHashMap.newWithKeysValues((char) 0, null).equals(map2) || CharObjectHashMap.newWithKeysValues((char) 9, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(CharObjectHashMap.newMap(), map2);
        MutableCharObjectMap<String> map3 = this.newMapWithKeysValues((char) 8, "eight", (char) 9, null);
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), CharObjectHashMap.newWithKeysValues((char) 8, "eight").equals(map3) || CharObjectHashMap.newWithKeysValues((char) 9, null).equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(CharObjectHashMap.newMap(), map3);
    }

    @Test
    public void values() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void removeFromValues() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        Assert.assertFalse(map.values().remove(4));
        Assert.assertTrue(map.values().remove(2));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 3, 3), map);
    }

    @Test
    public void removeNullFromValues() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        Assert.assertFalse(map.values().remove(null));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3), map);
        map.put((char) 4, null);
        Assert.assertTrue(map.values().remove(null));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3), map);
    }

    @Test
    public void removeAllFromValues() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        Assert.assertFalse(map.values().removeAll(FastList.newListWith(4)));
        Assert.assertTrue(map.values().removeAll(FastList.newListWith(2, 4)));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 3, 3), map);
    }

    @Test
    public void retainAllFromValues() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        Assert.assertFalse(map.values().retainAll(FastList.newListWith(1, 2, 3, 4)));
        Assert.assertTrue(map.values().retainAll(FastList.newListWith(1, 3)));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 3, 3), map);
    }

    @Test
    public void valuesToArray() {
        SynchronizedCharObjectMap<Integer> map = this.newMapWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, null);
        HashBag<Integer> expected = HashBag.newBagWith(1, 2, null);
        Collection<Integer> values = map.values();
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size() + 1])));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::add, this.description("add"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAll, this.description("addAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::values, this.description("values"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeFromValues, this.description("removeFromValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeNullFromValues, this.description("removeNullFromValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllFromValues, this.description("removeAllFromValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAllFromValues, this.description("retainAllFromValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesToArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::valuesToArray, this.description("valuesToArray"));
        }

        private SynchronizedCharObjectMapValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharObjectMapValuesTest();
        }

        @java.lang.Override
        public SynchronizedCharObjectMapValuesTest implementation() {
            return this.implementation;
        }
    }
}
