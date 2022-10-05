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
 * JUnit test for {@link UnmodifiableObjectIntMap#keySet()}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableObjectIntMapKeySetTest {

    private UnmodifiableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3) {
        return new UnmodifiableObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private UnmodifiableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3, String key4, int value4) {
        return new UnmodifiableObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).keySet().add("Four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).keySet().addAll(FastList.newListWith("Four"));
    }

    @Test
    public void contains() {
        UnmodifiableObjectIntMap<String> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, null, 4);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.contains("One"));
        Assert.assertTrue(keySet.contains("Two"));
        Assert.assertTrue(keySet.contains("Three"));
        Assert.assertFalse(keySet.contains("Four"));
        Assert.assertTrue(keySet.contains(null));
    }

    @Test
    public void containsAll() {
        UnmodifiableObjectIntMap<String> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, null, 4);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two")));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two", "Three", null)));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Four")));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("Five", "Four")));
    }

    @Test
    public void isEmpty() {
        UnmodifiableObjectIntMap<String> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, null, 4);
        Set<String> keySet = map.keySet();
        Assert.assertFalse(keySet.isEmpty());
        ObjectIntHashMap<String> map1 = ObjectIntHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Assert.assertTrue(keySet1.isEmpty());
        map1.put("One", 1);
        Assert.assertFalse(keySet1.isEmpty());
    }

    @Test
    public void size() {
        UnmodifiableObjectIntMap<String> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, null, 4);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
    }

    @Test
    public void iterator() {
        UnmodifiableObjectIntMap<String> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, null, 4);
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three", null);
        HashBag<String> actual = HashBag.newBag();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void keySetEqualsAndHashCode() {
        UnmodifiableObjectIntMap<String> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3, null, 0);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray() {
        UnmodifiableObjectIntMap<String> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
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

        private UnmodifiableObjectIntMapKeySetTest instance;

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
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableObjectIntMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectIntMapKeySetTest> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectIntMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectIntMapKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableObjectIntMapKeySetTest::contains;
            this.payloads.containsAll = UnmodifiableObjectIntMapKeySetTest::containsAll;
            this.payloads.isEmpty = UnmodifiableObjectIntMapKeySetTest::isEmpty;
            this.payloads.size = UnmodifiableObjectIntMapKeySetTest::size;
            this.payloads.iterator = UnmodifiableObjectIntMapKeySetTest::iterator;
            this.payloads.keySetEqualsAndHashCode = UnmodifiableObjectIntMapKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = UnmodifiableObjectIntMapKeySetTest::keySetToArray;
        }
    }
}
