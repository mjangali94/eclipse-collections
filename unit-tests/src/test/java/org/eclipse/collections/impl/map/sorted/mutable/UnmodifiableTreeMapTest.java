/*
 * Copyright (c) 2019 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.mutable;

import java.util.Comparator;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableTreeMap}.
 */
public class UnmodifiableTreeMapTest extends MutableSortedMapTestCase {

    @Override
    public <K, V> MutableSortedMap<K, V> newMap() {
        return new UnmodifiableTreeMap<>(new TreeSortedMap<>());
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(K key, V value) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMap(Comparator<? super K> comparator) {
        return new UnmodifiableTreeMap<>(new TreeSortedMap<>(comparator));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(Comparator<? super K> comparator, K key, V value) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(comparator, key1, value1, key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(comparator, key1, value1, key2, value2, key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new UnmodifiableTreeMap<>(TreeSortedMap.newMapWith(comparator, key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeObject() {
        MutableSortedMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        map.remove("One");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.removeKey(1);
    }

    @Override
    @Test
    public void removeAllKeys() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues(1, "1", 2, "Two").removeAllKeys(null));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.removeIf(null);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeFromEntrySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.entrySet().remove(ImmutableEntry.of(2, "Two"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAllFromEntrySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of(2, "Two")));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAllFromEntrySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.entrySet().retainAll(FastList.newListWith(ImmutableEntry.of(2, "Two")));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clearEntrySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.entrySet().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeFromKeySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.keySet().remove(2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAllFromKeySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.keySet().removeAll(FastList.newListWith(1, 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAllFromKeySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.keySet().retainAll(Lists.mutable.of());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clearKeySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.keySet().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeFromValues() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.values().remove("Two");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAllFromValues() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.values().removeAll(FastList.newListWith("One", "Two"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeNullFromValues() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.values().remove(null);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAllFromValues() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        map.values().retainAll(Lists.mutable.of());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut() {
        this.newMapWithKeysValues(1, "1", 2, "2", 3, "3").getIfAbsentPut(4, new PassThruFunction0<>("4"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutValue() {
        this.newMapWithKeysValues(1, "1", 2, "2", 3, "3").getIfAbsentPut(4, "4");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKey() {
        this.newMapWithKeysValues(1, 1, 2, 2, 3, 3).getIfAbsentPutWithKey(4, Functions.getIntegerPassThru());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWith() {
        this.newMapWithKeysValues(1, "1", 2, "2", 3, "3").getIfAbsentPutWith(4, String::valueOf, 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll() {
        this.newMapWithKeysValues(1, "One", 2, "2").putAll(null);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAllFromCollection() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        map.collectKeysAndValues(null, null, null);
    }

    @Override
    @Test
    public void clear() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        Assert.assertThrows(UnsupportedOperationException.class, map::clear);
    }

    @Override
    @Test
    public void asUnmodifiable() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2");
        Assert.assertSame(map, map.asUnmodifiable());
    }

    @Test
    public void entrySet() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "2").asUnmodifiable();
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().remove(null));
        Assert.assertThrows(UnsupportedOperationException.class, () -> Iterate.getFirst(map.entrySet()).setValue("Three"));
        Assert.assertEquals(this.newMapWithKeysValues(1, "One", 2, "2"), map);
    }

    @Test
    public void entrySetToArray() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeyValue(1, "One").asUnmodifiable();
        Object[] entries = map.entrySet().toArray();
        Assert.assertEquals(ImmutableEntry.of(1, "One"), entries[0]);
    }

    @Test
    public void entrySetToArrayWithTarget() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeyValue(1, "One").asUnmodifiable();
        Object[] entries = map.entrySet().toArray(new Object[] {});
        Assert.assertEquals(ImmutableEntry.of(1, "One"), entries[0]);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.newMapWithKeysValues(1, "One", 2, "Two").put(3, "Three");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newMapWithKeyValue("A", 1).add(Tuples.pair("A", 3));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.newMapWithKeyValue("A", 1).putPair(Tuples.pair("A", 3));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeyValue() {
        this.newMapWithKeysValues(1, "One", 2, "2").withKeyValue(null, null);
    }

    @Override
    @Test
    public void withMap() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').withMap(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void withMapEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').withMap(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void withMapTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().withMap(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void withMapEmptyAndTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().withMap(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void withMapNull() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().withMap(null));
    }

    @Override
    @Test
    public void withMapIterable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').withMapIterable(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void withMapIterableEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').withMapIterable(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void withMapIterableTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().withMapIterable(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void withMapIterableEmptyAndTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().withMapIterable(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void withMapIterableNull() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().withMapIterable(null));
    }

    @Override
    @Test
    public void putAllMapIterable() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').putAllMapIterable(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void putAllMapIterableEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').putAllMapIterable(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void putAllMapIterableTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().putAllMapIterable(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void putAllMapIterableEmptyAndTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().putAllMapIterable(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void putAllMapIterableNull() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().putAllMapIterable(null));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.newMapWithKeysValues("A", 1, "B", 2).withAllKeyValues(FastList.newListWith(Tuples.pair("B", 22), Tuples.pair("C", 3)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValueArguments() {
        this.newMapWithKeysValues("A", 1, "B", 2).withAllKeyValueArguments(Tuples.pair("B", 22), Tuples.pair("C", 3));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.newMapWithKeysValues("A", 1, "B", 2).withoutKey("B");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.newMapWithKeysValues("A", 1, "B", 2, "C", 3).withoutAllKeys(FastList.newListWith("A", "C"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.newMapWithKeysValues(1, "1", 2, "2").with(Tuples.pair(3, "3"));
    }

    @Override
    @Test
    public void headMap() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.headMap(3));
        this.checkMutability(map.headMap(3));
    }

    @Override
    @Test
    public void tailMap() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.tailMap(2));
        this.checkMutability(map.tailMap(2));
    }

    @Override
    @Test
    public void subMap() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.subMap(1, 3));
        this.checkMutability(map.subMap(1, 3));
    }

    @Override
    @Test
    public void testClone() {
        MutableSortedMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4");
        Assert.assertSame(map, map.clone());
        Verify.assertInstanceOf(UnmodifiableTreeMap.class, map.clone());
    }

    private void checkMutability(MutableSortedMap<Integer, String> map) {
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.put(3, "3"));
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.putAll(TreeSortedMap.newMapWith(1, "1", 2, "2")));
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.remove(2));
        Assert.assertThrows(UnsupportedOperationException.class, map::clear);
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.with(Tuples.pair(1, "1")));
    }

    @Override
    @Test
    public void getIfAbsentPut_block_throws() {
    // Not applicable for unmodifiable adapter
    }

    @Override
    @Test
    public void getIfAbsentPutWith_block_throws() {
    // Not applicable for unmodifiable adapter
    }

    @Test(expected = UnsupportedOperationException.class)
    @Override
    public void updateValue() {
        this.<Integer, Integer>newMap().updateValue(0, () -> 0, Functions.identity());
    }

    @Test(expected = UnsupportedOperationException.class)
    @Override
    public void updateValue_collisions() {
        this.<Integer, Integer>newMap().updateValue(0, () -> 0, Functions.identity());
    }

    @Test(expected = UnsupportedOperationException.class)
    @Override
    public void updateValueWith() {
        this.<Integer, Integer>newMap().updateValueWith(0, () -> 0, (integer, parameter) -> 0, "test");
    }

    @Test(expected = UnsupportedOperationException.class)
    @Override
    public void updateValueWith_collisions() {
        this.<Integer, Integer>newMap().updateValueWith(0, () -> 0, (integer, parameter) -> 0, "test");
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeObject, this.description("removeObject"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeKey, this.description("removeKey"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllKeys, this.description("removeAllKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeIf, this.description("removeIf"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeFromEntrySet, this.description("removeFromEntrySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAllFromEntrySet, this.description("removeAllFromEntrySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAllFromEntrySet, this.description("retainAllFromEntrySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::clearEntrySet, this.description("clearEntrySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeFromKeySet, this.description("removeFromKeySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAllFromKeySet, this.description("removeAllFromKeySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAllFromKeySet, this.description("retainAllFromKeySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::clearKeySet, this.description("clearKeySet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeFromValues, this.description("removeFromValues"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAllFromValues, this.description("removeAllFromValues"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeNullFromValues, this.description("removeNullFromValues"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAllFromValues, this.description("retainAllFromValues"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getIfAbsentPutValue, this.description("getIfAbsentPutValue"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getIfAbsentPutWithKey, this.description("getIfAbsentPutWithKey"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::putAll, this.description("putAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::putAllFromCollection, this.description("putAllFromCollection"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::entrySet, this.description("entrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetToArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::entrySetToArray, this.description("entrySetToArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetToArrayWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::entrySetToArrayWithTarget, this.description("entrySetToArrayWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::put, this.description("put"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::add, this.description("add"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::putPair, this.description("putPair"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withKeyValue, this.description("withKeyValue"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMap, this.description("withMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapEmpty, this.description("withMapEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapTargetEmpty, this.description("withMapTargetEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapEmptyAndTargetEmpty, this.description("withMapEmptyAndTargetEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapNull, this.description("withMapNull"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapIterable, this.description("withMapIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapIterableEmpty, this.description("withMapIterableEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapIterableTargetEmpty, this.description("withMapIterableTargetEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapIterableEmptyAndTargetEmpty, this.description("withMapIterableEmptyAndTargetEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withMapIterableNull, this.description("withMapIterableNull"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putAllMapIterable, this.description("putAllMapIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putAllMapIterableEmpty, this.description("putAllMapIterableEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putAllMapIterableTargetEmpty, this.description("putAllMapIterableTargetEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putAllMapIterableEmptyAndTargetEmpty, this.description("putAllMapIterableEmptyAndTargetEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putAllMapIterableNull, this.description("putAllMapIterableNull"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withAllKeyValues, this.description("withAllKeyValues"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withAllKeyValueArguments, this.description("withAllKeyValueArguments"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withoutKey, this.description("withoutKey"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withoutAllKeys, this.description("withoutAllKeys"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::with, this.description("with"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::headMap, this.description("headMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::tailMap, this.description("tailMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subMap, this.description("subMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_block_throws, this.description("getIfAbsentPut_block_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith_block_throws, this.description("getIfAbsentPutWith_block_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::updateValue, this.description("updateValue"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::updateValue_collisions, this.description("updateValue_collisions"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::updateValueWith, this.description("updateValueWith"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::updateValueWith_collisions, this.description("updateValueWith_collisions"), java.lang.UnsupportedOperationException.class);
        }

        private UnmodifiableTreeMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableTreeMapTest();
        }

        @java.lang.Override
        public UnmodifiableTreeMapTest implementation() {
            return this.implementation;
        }
    }
}
