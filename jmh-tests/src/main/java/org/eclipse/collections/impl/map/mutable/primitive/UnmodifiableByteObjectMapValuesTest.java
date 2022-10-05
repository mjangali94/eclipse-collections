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
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteObjectMap#values()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapValuesTest.stg.
 */
public class UnmodifiableByteObjectMapValuesTest {

    private UnmodifiableByteObjectMap<String> newMapWithKeysValues(byte key1, String value1, byte key2, String value2) {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    private UnmodifiableByteObjectMap<Integer> newMapWithKeysValues(byte key1, Integer value1, byte key2, Integer value2, byte key3, Integer value3) {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private UnmodifiableByteObjectMap<Integer> newMapWithKeysValues(byte key1, Integer value1, byte key2, Integer value2, byte key3, Integer value3, byte key4, Integer value4) {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void contains() {
        UnmodifiableByteObjectMap<Integer> map = this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
    }

    @Test
    public void containsAll() {
        UnmodifiableByteObjectMap<Integer> map = this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
    }

    @Test
    public void isEmpty() {
        UnmodifiableByteObjectMap<Integer> map = this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3, (byte) 1, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        ByteObjectHashMap<Integer> map1 = ByteObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put((byte) 1, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size() {
        UnmodifiableByteObjectMap<Integer> map = this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3, (byte) 4, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
    }

    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, null).iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void values() {
        UnmodifiableByteObjectMap<Integer> map = this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void valuesToArray() {
        UnmodifiableByteObjectMap<Integer> map = this.newMapWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, null);
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

        private UnmodifiableByteObjectMapValuesTest instance;

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
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableByteObjectMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableByteObjectMapValuesTest> valuesToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableByteObjectMapValuesTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableByteObjectMapValuesTest::contains;
            this.payloads.containsAll = UnmodifiableByteObjectMapValuesTest::containsAll;
            this.payloads.isEmpty = UnmodifiableByteObjectMapValuesTest::isEmpty;
            this.payloads.size = UnmodifiableByteObjectMapValuesTest::size;
            this.payloads.iterator = UnmodifiableByteObjectMapValuesTest::iterator;
            this.payloads.values = UnmodifiableByteObjectMapValuesTest::values;
            this.payloads.valuesToArray = UnmodifiableByteObjectMapValuesTest::valuesToArray;
        }
    }
}
