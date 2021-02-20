/*
 * Copyright (c) 2019 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.mutable;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.map.MutableMapIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class UnmodifiableBiMapTest extends AbstractMutableBiMapTestCase {

    @Override
    public MutableBiMap<Integer, Character> classUnderTest() {
        HashBiMap<Integer, Character> map = HashBiMap.newMap();
        map.put(1, null);
        map.put(null, 'b');
        map.put(3, 'c');
        return map.asUnmodifiable();
    }

    @Override
    public MutableBiMap<Integer, Character> getEmptyMap() {
        return HashBiMap.<Integer, Character>newMap().asUnmodifiable();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMap() {
        return HashBiMap.<K, V>newMap().asUnmodifiable();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return UnmodifiableBiMap.of(Maps.mutable.of(key, value));
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4).asUnmodifiable();
    }

    @Test
    public void newMap_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new UnmodifiableBiMap<>(null));
        MutableBiMap<String, String> biMap = null;
        Assert.assertThrows(IllegalArgumentException.class, () -> UnmodifiableBiMap.of(biMap));
        Map<String, String> map = null;
        Assert.assertThrows(IllegalArgumentException.class, () -> UnmodifiableBiMap.of(map));
    }

    @Override
    @Test
    public void containsKey() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertTrue(biMap.containsKey(1));
        Assert.assertTrue(biMap.containsKey(null));
        Assert.assertTrue(biMap.containsKey(3));
        Assert.assertFalse(biMap.containsKey(4));
    }

    @Override
    @Test
    public void containsValue() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertTrue(biMap.containsValue(null));
        Assert.assertTrue(biMap.containsValue('b'));
        Assert.assertTrue(biMap.containsValue('c'));
        Assert.assertFalse(biMap.containsValue('d'));
    }

    @Override
    @Test
    public void get() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Assert.assertNull(biMap.get(1));
        Assert.assertEquals(Character.valueOf('b'), biMap.get(null));
        Assert.assertEquals(Character.valueOf('c'), biMap.get(3));
        Assert.assertNull(biMap.get(4));
    }

    @Override
    @Test
    public void iterator() {
        MutableSet<Character> expected = UnifiedSet.newSetWith(null, 'b', 'c');
        MutableSet<Character> actual = UnifiedSet.newSet();
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Iterator<Character> iterator = biMap.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
        Verify.assertSize(3, biMap);
        Verify.assertSize(3, biMap.inverse());
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void testClone() {
        MutableBiMap<Object, Object> biMap = this.newMap();
        MutableBiMap<Object, Object> clone = biMap.clone();
        Assert.assertSame(biMap, clone);
    }

    @Override
    @Test
    public void withKeyValue() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getEmptyMap().withKeyValue(1, 'a'));
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').withMap(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void withMapEmptyAndTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getEmptyMap().withMap(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void withMapNull() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getEmptyMap().withMap(null));
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').withMapIterable(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void withMapIterableEmptyAndTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getEmptyMap().withMapIterable(Maps.mutable.empty()));
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue(1, 'a').putAllMapIterable(Maps.mutable.with(1, Character.valueOf('a'))));
    }

    @Override
    @Test
    public void putAllMapIterableEmptyAndTargetEmpty() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.getEmptyMap().putAllMapIterable(Maps.mutable.empty()));
    }

    @Override
    @Test
    public void putAllMapIterableNull() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMap().putAllMapIterable(null));
    }

    @Override
    @Test
    public void withAllKeyValueArguments() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("A", 1, "B", 2).withAllKeyValueArguments(Tuples.pair("B", 22), Tuples.pair("C", 3)));
    }

    @Override
    @Test
    public void add() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeyValue("A", 1).add(Tuples.pair("A", 3)));
    }

    @Override
    @Test
    public void put() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().put(4, 'd'));
    }

    @Override
    @Test
    public void putPair() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().putPair(Tuples.pair(4, 'd')));
    }

    @Override
    @Test
    public void putAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("key1", "value1", "key2", "value2").putAll(UnifiedMap.newMap()));
    }

    @Override
    @Test
    public void forcePut() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("key1", "value1", "key2", "value2").forcePut("value2", "key1"));
    }

    @Override
    @Test
    public void updateValue() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("key1", "value1", "key2", "value2").updateValue("key1", () -> "value3", String::toUpperCase));
    }

    @Override
    @Test
    public void updateValueWith() {
        MutableBiMap<Integer, Character> biMap = this.classUnderTest();
        Function2<Character, Boolean, Character> toUpperOrLowerCase = (character, parameter) -> parameter ? Character.toUpperCase(character) : Character.toLowerCase(character);
        Assert.assertThrows(UnsupportedOperationException.class, () -> biMap.updateValueWith(4, () -> 'd', toUpperOrLowerCase, true));
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPut(4, () -> "4"));
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPut(4, "4"));
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPutWith(4, object -> "4", null));
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        MutableMapIterable<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2, 3, 3);
        Assert.assertNull(map.get(4));
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPutWithKey(4, Functions.getIntegerPassThru()));
    }

    @Override
    @Test
    public void getIfAbsentPutValue() {
        MutableMapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Assert.assertNull(map.get(4));
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPut(4, "4"));
    }

    @Override
    @Test
    public void withoutKey() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("A", 1, "B", 2).withoutKey("B"));
    }

    @Override
    @Test
    public void withoutAllKeys() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("A", 1, "B", 2, "C", 3).withoutAllKeys(FastList.newListWith("A", "C")));
    }

    @Override
    @Test
    public void withAllKeyValues() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("A", 1, "B", 2).withAllKeyValues(FastList.newListWith(Tuples.pair("B", 22), Tuples.pair("C", 3))));
    }

    @Override
    @Test
    public void clear() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().clear());
    }

    @Override
    @Test
    public void clearEntrySet() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).entrySet().clear());
    }

    @Override
    @Test
    public void clearKeySet() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).keySet().clear());
    }

    @Override
    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("key1", "value1", "key2", "value2").remove("key1"));
    }

    @Override
    @Test
    public void removeObject() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).remove("Two"));
    }

    @Override
    @Test
    public void removeFromEntrySet() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).entrySet().remove(ImmutableEntry.of("Two", 2)));
    }

    @Override
    @Test
    public void removeFromKeySet() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).keySet().remove("Four"));
    }

    @Override
    @Test
    public void removeNullFromKeySet() {
        MutableBiMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.values().remove(null));
    }

    @Override
    @Test
    public void removeKey() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues(1, "1", 2, "Two").removeKey(1));
    }

    @Override
    @Test
    public void removeAllKeys() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues(1, "1", 2, "Two").removeAllKeys(Sets.mutable.empty()));
    }

    @Override
    @Test
    public void removeIf() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues(1, "1", 2, "Two").removeIf(null));
    }

    @Override
    @Test
    public void removeNullFromValues() {
        MutableBiMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.values().remove(null));
    }

    @Override
    @Test
    public void removeFromValues() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).values().remove(4));
    }

    @Override
    @Test
    public void retainAllFromEntrySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().retainAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Two", 2), ImmutableEntry.of("Three", 3), ImmutableEntry.of("Four", 4))));
    }

    @Override
    @Test
    public void retainAllFromKeySet() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).keySet().retainAll(FastList.newListWith("One", "Two", "Three", "Four")));
    }

    @Override
    @Test
    public void retainAllFromValues() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).values().retainAll(FastList.newListWith(1, 2, 3, 4)));
    }

    @Override
    @Test
    public void removeAllFromEntrySet() {
        MutableMapIterable<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Three", 3))));
    }

    @Override
    @Test
    public void removeAllFromKeySet() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).keySet().removeAll(FastList.newListWith("Four")));
    }

    @Override
    @Test
    public void removeAllFromValues() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3).values().removeAll(FastList.newListWith(4)));
    }

    @Override
    @Test
    public void getIfAbsentPut_block_throws() {
    // Not applicable for unmodifiable maps
    }

    @Override
    @Test
    public void getIfAbsentPutWith_block_throws() {
    // Not applicable for unmodifiable maps
    }

    @Override
    public void retainAllFromKeySet_null_collision() {
    // Not applicable for unmodifiable maps
    }

    @Override
    public void rehash_null_collision() {
    // Not applicable for unmodifiable maps
    }

    @Override
    public void nullCollisionWithCastInEquals() {
    // Not applicable for unmodifiable maps
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMap_throws, this.description("newMap_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeyValue, this.description("withKeyValue"));
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
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAllKeyValueArguments, this.description("withAllKeyValueArguments"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::add, this.description("add"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put, this.description("put"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putPair, this.description("putPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putAll, this.description("putAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forcePut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forcePut, this.description("forcePut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue, this.description("updateValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValueWith, this.description("updateValueWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWithKey, this.description("getIfAbsentPutWithKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutValue, this.description("getIfAbsentPutValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutKey, this.description("withoutKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutAllKeys, this.description("withoutAllKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAllKeyValues, this.description("withAllKeyValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clearEntrySet, this.description("clearEntrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clearKeySet, this.description("clearKeySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeObject, this.description("removeObject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeFromEntrySet, this.description("removeFromEntrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeFromKeySet, this.description("removeFromKeySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeNullFromKeySet, this.description("removeNullFromKeySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeKey, this.description("removeKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllKeys, this.description("removeAllKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeIf, this.description("removeIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeNullFromValues, this.description("removeNullFromValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeFromValues, this.description("removeFromValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAllFromEntrySet, this.description("retainAllFromEntrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAllFromKeySet, this.description("retainAllFromKeySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::retainAllFromValues, this.description("retainAllFromValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllFromEntrySet, this.description("removeAllFromEntrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllFromKeySet, this.description("removeAllFromKeySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllFromValues, this.description("removeAllFromValues"));
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

        private UnmodifiableBiMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableBiMapTest();
        }

        @java.lang.Override
        public UnmodifiableBiMapTest implementation() {
            return this.implementation;
        }
    }
}
