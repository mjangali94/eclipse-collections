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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedObjectLongMap#keySet()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeySetTest.stg.
 */
public class SynchronizedObjectLongMapKeySetTest {

    private SynchronizedObjectLongMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2, String key3, long value3) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private SynchronizedObjectLongMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2, String key3, long value3, String key4, long value4) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L).keySet().add("Four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L).keySet().addAll(FastList.newListWith("Four"));
    }

    @Test
    public void contains() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.contains("One"));
        Assert.assertTrue(keySet.contains("Two"));
        Assert.assertTrue(keySet.contains("Three"));
        Assert.assertFalse(keySet.contains("Four"));
        Assert.assertTrue(keySet.contains(null));
        keySet.remove(null);
        Assert.assertFalse(keySet.contains(null));
        map.removeKey("One");
        Assert.assertFalse(keySet.contains("One"));
    }

    @Test
    public void containsAll() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two")));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two", "Three", null)));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Four")));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("Five", "Four")));
        keySet.remove(null);
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Two", "Three", null)));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two", "Three")));
        map.removeKey("One");
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Two")));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("Three", "Two")));
    }

    @Test
    public void isEmpty() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map.keySet();
        Assert.assertFalse(keySet.isEmpty());
        ObjectLongHashMap<String> map1 = ObjectLongHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Assert.assertTrue(keySet1.isEmpty());
        map1.put("One", 1L);
        Assert.assertFalse(keySet1.isEmpty());
    }

    @Test
    public void size() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
        map.remove("One");
        Verify.assertSize(3, keySet);
        map.put("Five", 5L);
        Verify.assertSize(4, keySet);
        ObjectLongHashMap<String> map1 = ObjectLongHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Verify.assertSize(0, keySet1);
        map1.put(null, 1L);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three", null);
        HashBag<String> actual = HashBag.newBag();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertEquals(expected, actual);
        Iterator<String> iterator1 = keySet.iterator();
        for (int i = 4; i > 0; i--) {
            Assert.assertTrue(iterator1.hasNext());
            iterator1.next();
            iterator1.remove();
            Assert.assertThrows(IllegalStateException.class, iterator1::remove);
            Verify.assertSize(i - 1, keySet);
            Verify.assertSize(i - 1, map);
        }
        Assert.assertFalse(iterator1.hasNext());
        Verify.assertEmpty(map);
        Verify.assertEmpty(keySet);
    }

    @Test
    public void removeFromKeySet() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().remove("Four"));
        Assert.assertTrue(map.keySet().remove("Two"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("One", 1L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void removeNullFromKeySet() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().remove(null));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("One", 1L, "Two", 2L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        map.put(null, 4L);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertTrue(map.keySet().remove(null));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("One", 1L, "Two", 2L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Test
    public void removeAllFromKeySet() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().removeAll(FastList.newListWith("Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertTrue(map.keySet().removeAll(FastList.newListWith("Two", "Four")));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("One", 1L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void retainAllFromKeySet() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().retainAll(FastList.newListWith("One", "Two", "Three", "Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertTrue(map.keySet().retainAll(FastList.newListWith("One", "Three")));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("One", 1L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void clearKeySet() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        map.keySet().clear();
        Verify.assertEmpty(map);
        Verify.assertEmpty(map.keySet());
    }

    @Test
    public void keySetEqualsAndHashCode() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 0L);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray() {
        SynchronizedObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three");
        Set<String> keySet = map.keySet();
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size() + 1])));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedObjectLongMapKeySetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
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
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedObjectLongMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapKeySetTest> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectLongMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectLongMapKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = SynchronizedObjectLongMapKeySetTest::contains;
            this.payloads.containsAll = SynchronizedObjectLongMapKeySetTest::containsAll;
            this.payloads.isEmpty = SynchronizedObjectLongMapKeySetTest::isEmpty;
            this.payloads.size = SynchronizedObjectLongMapKeySetTest::size;
            this.payloads.iterator = SynchronizedObjectLongMapKeySetTest::iterator;
            this.payloads.removeFromKeySet = SynchronizedObjectLongMapKeySetTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = SynchronizedObjectLongMapKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = SynchronizedObjectLongMapKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = SynchronizedObjectLongMapKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = SynchronizedObjectLongMapKeySetTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = SynchronizedObjectLongMapKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = SynchronizedObjectLongMapKeySetTest::keySetToArray;
        }
    }
}
