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
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectShortHashMapKeySetTestCase {

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1);

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2);

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3);

    public abstract MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3, String key4, short value4);

    public abstract MutableObjectShortMap<String> newEmptyMap();

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3).keySet().add("Four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3).keySet().addAll(FastList.newListWith("Four"));
    }

    @Test
    public void contains() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
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
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
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
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
        Set<String> keySet = map.keySet();
        Assert.assertFalse(keySet.isEmpty());
        MutableObjectShortMap<String> map1 = this.newEmptyMap();
        Set<String> keySet1 = map1.keySet();
        Assert.assertTrue(keySet1.isEmpty());
        map1.put("One", (short) 1);
        Assert.assertFalse(keySet1.isEmpty());
    }

    @Test
    public void size() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
        map.remove("One");
        Verify.assertSize(3, keySet);
        map.put("Five", (short) 5);
        Verify.assertSize(4, keySet);
        MutableObjectShortMap<String> map1 = this.newEmptyMap();
        Set<String> keySet1 = map1.keySet();
        Verify.assertSize(0, keySet1);
        map1.put(null, (short) 1);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator() {
        MutableObjectShortMap<String> map1 = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
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
        MutableObjectShortMap<String> map3 = this.newEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
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
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3);
        Assert.assertFalse(map.keySet().remove("Four"));
        Assert.assertTrue(map.keySet().remove("Two"));
        Assert.assertEquals(this.newMapWithKeysValues("One", (short) 1, "Three", (short) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void removeNullFromKeySet() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3);
        Assert.assertFalse(map.keySet().remove(null));
        Assert.assertEquals(this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        map.put(null, (short) 4);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertTrue(map.keySet().remove(null));
        Assert.assertEquals(this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Test
    public void removeAllFromKeySet() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3);
        Assert.assertFalse(map.keySet().removeAll(FastList.newListWith("Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertTrue(map.keySet().removeAll(FastList.newListWith("Two", "Four")));
        Assert.assertEquals(this.newMapWithKeysValues("One", (short) 1, "Three", (short) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void retainAllFromKeySet() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3);
        Assert.assertFalse(map.keySet().retainAll(FastList.newListWith("One", "Two", "Three", "Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertTrue(map.keySet().retainAll(FastList.newListWith("One", "Three")));
        Assert.assertEquals(this.newMapWithKeysValues("One", (short) 1, "Three", (short) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void clearKeySet() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3);
        map.keySet().clear();
        Verify.assertEmpty(map);
        Verify.assertEmpty(map.keySet());
    }

    @Test
    public void keySetEqualsAndHashCode() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 0);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray() {
        MutableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3);
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three");
        Set<String> keySet = map.keySet();
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size() + 1])));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortHashMapKeySetTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortHashMapKeySetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapKeySetTestCase> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapKeySetTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapKeySetTestCase::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = ObjectShortHashMapKeySetTestCase::contains;
            this.payloads.containsAll = ObjectShortHashMapKeySetTestCase::containsAll;
            this.payloads.isEmpty = ObjectShortHashMapKeySetTestCase::isEmpty;
            this.payloads.size = ObjectShortHashMapKeySetTestCase::size;
            this.payloads.iterator = ObjectShortHashMapKeySetTestCase::iterator;
            this.payloads.removeFromKeySet = ObjectShortHashMapKeySetTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ObjectShortHashMapKeySetTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ObjectShortHashMapKeySetTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ObjectShortHashMapKeySetTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = ObjectShortHashMapKeySetTestCase::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = ObjectShortHashMapKeySetTestCase::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ObjectShortHashMapKeySetTestCase::keySetToArray;
        }
    }
*/
}
