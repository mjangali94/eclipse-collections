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
 * JUnit test for {@link UnmodifiableDoubleObjectMap#values()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapValuesTest.stg.
 */
public class UnmodifiableDoubleObjectMapValuesTest {

    private UnmodifiableDoubleObjectMap<String> newMapWithKeysValues(double key1, String value1, double key2, String value2) {
        return new UnmodifiableDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    private UnmodifiableDoubleObjectMap<Integer> newMapWithKeysValues(double key1, Integer value1, double key2, Integer value2, double key3, Integer value3) {
        return new UnmodifiableDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private UnmodifiableDoubleObjectMap<Integer> newMapWithKeysValues(double key1, Integer value1, double key2, Integer value2, double key3, Integer value3, double key4, Integer value4) {
        return new UnmodifiableDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void contains() {
        UnmodifiableDoubleObjectMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
    }

    @Test
    public void containsAll() {
        UnmodifiableDoubleObjectMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
    }

    @Test
    public void isEmpty() {
        UnmodifiableDoubleObjectMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 1.0, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        DoubleObjectHashMap<Integer> map1 = DoubleObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put(1.0, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size() {
        UnmodifiableDoubleObjectMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 4.0, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
    }

    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, null).iterator();
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
        UnmodifiableDoubleObjectMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void valuesToArray() {
        UnmodifiableDoubleObjectMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, null);
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

        private UnmodifiableDoubleObjectMapValuesTest instance;

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
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableDoubleObjectMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleObjectMapValuesTest> valuesToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleObjectMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleObjectMapValuesTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableDoubleObjectMapValuesTest::contains;
            this.payloads.containsAll = UnmodifiableDoubleObjectMapValuesTest::containsAll;
            this.payloads.isEmpty = UnmodifiableDoubleObjectMapValuesTest::isEmpty;
            this.payloads.size = UnmodifiableDoubleObjectMapValuesTest::size;
            this.payloads.iterator = UnmodifiableDoubleObjectMapValuesTest::iterator;
            this.payloads.values = UnmodifiableDoubleObjectMapValuesTest::values;
            this.payloads.valuesToArray = UnmodifiableDoubleObjectMapValuesTest::valuesToArray;
        }
    }
}
