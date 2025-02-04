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
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectLongHashMapKeySetTestCase {

    public abstract MutableObjectLongMap<String> newMapWithKeysValues(String key1, long value1);

    public abstract MutableObjectLongMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2);

    public abstract MutableObjectLongMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2, String key3, long value3);

    public abstract MutableObjectLongMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2, String key3, long value3, String key4, long value4);

    public abstract MutableObjectLongMap<String> newEmptyMap();

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
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
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
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
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
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map.keySet();
        Assert.assertFalse(keySet.isEmpty());
        MutableObjectLongMap<String> map1 = this.newEmptyMap();
        Set<String> keySet1 = map1.keySet();
        Assert.assertTrue(keySet1.isEmpty());
        map1.put("One", 1L);
        Assert.assertFalse(keySet1.isEmpty());
    }

    @Test
    public void size() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
        map.remove("One");
        Verify.assertSize(3, keySet);
        map.put("Five", 5L);
        Verify.assertSize(4, keySet);
        MutableObjectLongMap<String> map1 = this.newEmptyMap();
        Set<String> keySet1 = map1.keySet();
        Verify.assertSize(0, keySet1);
        map1.put(null, 1L);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator() {
        MutableObjectLongMap<String> map1 = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 4L);
        Set<String> keySet = map1.keySet();
        Iterator<String> iterator1 = keySet.iterator();
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three", null);
        HashBag<String> actual = HashBag.newBag();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator1.hasNext());
            actual.add(iterator1.next());
        }
        Assert.assertFalse(iterator1.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator1::next);
        Assert.assertEquals(expected, actual);
        Iterator<String> iterator2 = keySet.iterator();
        for (int i = 4; i > 0; i--) {
            Assert.assertTrue(iterator2.hasNext());
            iterator2.next();
            iterator2.remove();
            Assert.assertThrows(IllegalStateException.class, iterator2::remove);
            Verify.assertSize(i - 1, keySet);
            Verify.assertSize(i - 1, map1);
        }
        Assert.assertFalse(iterator2.hasNext());
        Verify.assertEmpty(map1);
        Verify.assertEmpty(keySet);
        MutableObjectLongMap<String> map3 = this.newEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            map3.put(String.valueOf(each), each);
        }
        Iterator<String> iterator3 = map3.keySet().iterator();
        while (iterator3.hasNext()) {
            iterator3.next();
            iterator3.remove();
        }
        Assert.assertTrue(map3.isEmpty());
    }

    @Test
    public void removeFromKeySet() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().remove("Four"));
        Assert.assertTrue(map.keySet().remove("Two"));
        Assert.assertEquals(this.newMapWithKeysValues("One", 1L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void removeNullFromKeySet() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().remove(null));
        Assert.assertEquals(this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        map.put(null, 4L);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertTrue(map.keySet().remove(null));
        Assert.assertEquals(this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Test
    public void removeAllFromKeySet() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().removeAll(FastList.newListWith("Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertTrue(map.keySet().removeAll(FastList.newListWith("Two", "Four")));
        Assert.assertEquals(this.newMapWithKeysValues("One", 1L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void retainAllFromKeySet() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        Assert.assertFalse(map.keySet().retainAll(FastList.newListWith("One", "Two", "Three", "Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertTrue(map.keySet().retainAll(FastList.newListWith("One", "Three")));
        Assert.assertEquals(this.newMapWithKeysValues("One", 1L, "Three", 3L), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void clearKeySet() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
        map.keySet().clear();
        Verify.assertEmpty(map);
        Verify.assertEmpty(map.keySet());
    }

    @Test
    public void keySetEqualsAndHashCode() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L, null, 0L);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray() {
        MutableObjectLongMap<String> map = this.newMapWithKeysValues("One", 1L, "Two", 2L, "Three", 3L);
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

        private ObjectLongHashMapKeySetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
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
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectLongHashMapKeySetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeySetTestCase> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeySetTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeySetTestCase::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = ObjectLongHashMapKeySetTestCase::contains;
            this.payloads.containsAll = ObjectLongHashMapKeySetTestCase::containsAll;
            this.payloads.isEmpty = ObjectLongHashMapKeySetTestCase::isEmpty;
            this.payloads.size = ObjectLongHashMapKeySetTestCase::size;
            this.payloads.iterator = ObjectLongHashMapKeySetTestCase::iterator;
            this.payloads.removeFromKeySet = ObjectLongHashMapKeySetTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ObjectLongHashMapKeySetTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ObjectLongHashMapKeySetTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ObjectLongHashMapKeySetTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = ObjectLongHashMapKeySetTestCase::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = ObjectLongHashMapKeySetTestCase::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ObjectLongHashMapKeySetTestCase::keySetToArray;
        }
    }
}
