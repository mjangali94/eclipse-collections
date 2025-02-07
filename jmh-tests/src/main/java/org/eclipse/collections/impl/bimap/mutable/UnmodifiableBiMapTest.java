/*
 * Copyright (c) 2021 Goldman Sachs.
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
    public static class _Benchmark {

        public _Payloads payloads;

        public UnmodifiableBiMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_into() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.into);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forcePut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forcePut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
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
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableBiMapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> into;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> newMap_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> forcePut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableBiMapTest> getIfAbsentPutWith_block_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = UnmodifiableBiMapTest::stream;
            this.payloads.parallelStream = UnmodifiableBiMapTest::parallelStream;
            this.payloads.serialization = UnmodifiableBiMapTest::serialization;
            this.payloads.isEmpty = UnmodifiableBiMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableBiMapTest::notEmpty;
            this.payloads.ifPresentApply = UnmodifiableBiMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = UnmodifiableBiMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = UnmodifiableBiMapTest::getOrDefault;
            this.payloads.getIfAbsent = UnmodifiableBiMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = UnmodifiableBiMapTest::getIfAbsentWith;
            this.payloads.tap = UnmodifiableBiMapTest::tap;
            this.payloads.forEach = UnmodifiableBiMapTest::forEach;
            this.payloads.forEachWith = UnmodifiableBiMapTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableBiMapTest::forEachWithIndex;
            this.payloads.forEachKey = UnmodifiableBiMapTest::forEachKey;
            this.payloads.forEachValue = UnmodifiableBiMapTest::forEachValue;
            this.payloads.forEachKeyValue = UnmodifiableBiMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableBiMapTest::injectIntoKeyValue;
            this.payloads.collectMap = UnmodifiableBiMapTest::collectMap;
            this.payloads.collectBoolean = UnmodifiableBiMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableBiMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnmodifiableBiMapTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableBiMapTest::collectByteWithTarget;
            this.payloads.collectChar = UnmodifiableBiMapTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableBiMapTest::collectCharWithTarget;
            this.payloads.collectDouble = UnmodifiableBiMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableBiMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnmodifiableBiMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableBiMapTest::collectFloatWithTarget;
            this.payloads.collectInt = UnmodifiableBiMapTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableBiMapTest::collectIntWithTarget;
            this.payloads.collectLong = UnmodifiableBiMapTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableBiMapTest::collectLongWithTarget;
            this.payloads.collectShort = UnmodifiableBiMapTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableBiMapTest::collectShortWithTarget;
            this.payloads.collectValues = UnmodifiableBiMapTest::collectValues;
            this.payloads.select = UnmodifiableBiMapTest::select;
            this.payloads.selectWith = UnmodifiableBiMapTest::selectWith;
            this.payloads.reject = UnmodifiableBiMapTest::reject;
            this.payloads.rejectWith = UnmodifiableBiMapTest::rejectWith;
            this.payloads.collect = UnmodifiableBiMapTest::collect;
            this.payloads.flatCollect = UnmodifiableBiMapTest::flatCollect;
            this.payloads.flatCollectWith = UnmodifiableBiMapTest::flatCollectWith;
            this.payloads.selectMap = UnmodifiableBiMapTest::selectMap;
            this.payloads.rejectMap = UnmodifiableBiMapTest::rejectMap;
            this.payloads.detect = UnmodifiableBiMapTest::detect;
            this.payloads.detectOptional = UnmodifiableBiMapTest::detectOptional;
            this.payloads.anySatisfy = UnmodifiableBiMapTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableBiMapTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableBiMapTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableBiMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableBiMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableBiMapTest::noneSatisfyWith;
            this.payloads.appendString = UnmodifiableBiMapTest::appendString;
            this.payloads.toBag = UnmodifiableBiMapTest::toBag;
            this.payloads.toSortedBag = UnmodifiableBiMapTest::toSortedBag;
            this.payloads.toSortedBagBy = UnmodifiableBiMapTest::toSortedBagBy;
            this.payloads.asLazy = UnmodifiableBiMapTest::asLazy;
            this.payloads.toList = UnmodifiableBiMapTest::toList;
            this.payloads.toMap = UnmodifiableBiMapTest::toMap;
            this.payloads.toSet = UnmodifiableBiMapTest::toSet;
            this.payloads.toSortedList = UnmodifiableBiMapTest::toSortedList;
            this.payloads.toSortedListBy = UnmodifiableBiMapTest::toSortedListBy;
            this.payloads.toSortedSet = UnmodifiableBiMapTest::toSortedSet;
            this.payloads.toSortedSetBy = UnmodifiableBiMapTest::toSortedSetBy;
            this.payloads.toSortedMap = UnmodifiableBiMapTest::toSortedMap;
            this.payloads.chunk = UnmodifiableBiMapTest::chunk;
            this.payloads.collect_value = UnmodifiableBiMapTest::collect_value;
            this.payloads.collectIf = UnmodifiableBiMapTest::collectIf;
            this.payloads.collectWith = UnmodifiableBiMapTest::collectWith;
            this.payloads.collectWithToTarget = UnmodifiableBiMapTest::collectWithToTarget;
            this.payloads.contains = UnmodifiableBiMapTest::contains;
            this.payloads.containsAnyIterable = UnmodifiableBiMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnmodifiableBiMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = UnmodifiableBiMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnmodifiableBiMapTest::containsNoneCollection;
            this.payloads.containsAll = UnmodifiableBiMapTest::containsAll;
            this.payloads.getFirst = UnmodifiableBiMapTest::getFirst;
            this.payloads.getLast = UnmodifiableBiMapTest::getLast;
            this.payloads.getOnly = UnmodifiableBiMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBiMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBiMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnmodifiableBiMapTest::containsAllIterable;
            this.payloads.containsAllArguments = UnmodifiableBiMapTest::containsAllArguments;
            this.payloads.count = UnmodifiableBiMapTest::count;
            this.payloads.countWith = UnmodifiableBiMapTest::countWith;
            this.payloads.detect_value = UnmodifiableBiMapTest::detect_value;
            this.payloads.detectOptional_value = UnmodifiableBiMapTest::detectOptional_value;
            this.payloads.detectWith = UnmodifiableBiMapTest::detectWith;
            this.payloads.detectWithOptional = UnmodifiableBiMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = UnmodifiableBiMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = UnmodifiableBiMapTest::detectWithIfNone;
            this.payloads.flatten_value = UnmodifiableBiMapTest::flatten_value;
            this.payloads.countBy = UnmodifiableBiMapTest::countBy;
            this.payloads.countByWith = UnmodifiableBiMapTest::countByWith;
            this.payloads.countByEach = UnmodifiableBiMapTest::countByEach;
            this.payloads.groupBy = UnmodifiableBiMapTest::groupBy;
            this.payloads.groupByEach = UnmodifiableBiMapTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableBiMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBiMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableBiMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableBiMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = UnmodifiableBiMapTest::injectInto;
            this.payloads.injectIntoInt = UnmodifiableBiMapTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableBiMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = UnmodifiableBiMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = UnmodifiableBiMapTest::injectIntoDouble;
            this.payloads.sumOfInt = UnmodifiableBiMapTest::sumOfInt;
            this.payloads.sumOfLong = UnmodifiableBiMapTest::sumOfLong;
            this.payloads.testAggregateBy = UnmodifiableBiMapTest::testAggregateBy;
            this.payloads.sumOfFloat = UnmodifiableBiMapTest::sumOfFloat;
            this.payloads.sumOfDouble = UnmodifiableBiMapTest::sumOfDouble;
            this.payloads.sumByInt = UnmodifiableBiMapTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableBiMapTest::sumByFloat;
            this.payloads.sumByLong = UnmodifiableBiMapTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableBiMapTest::sumByDouble;
            this.payloads.makeString = UnmodifiableBiMapTest::makeString;
            this.payloads.min = UnmodifiableBiMapTest::min;
            this.payloads.max = UnmodifiableBiMapTest::max;
            this.payloads.minBy = UnmodifiableBiMapTest::minBy;
            this.payloads.maxBy = UnmodifiableBiMapTest::maxBy;
            this.payloads.reject_value = UnmodifiableBiMapTest::reject_value;
            this.payloads.rejectWith_value = UnmodifiableBiMapTest::rejectWith_value;
            this.payloads.select_value = UnmodifiableBiMapTest::select_value;
            this.payloads.selectWith_value = UnmodifiableBiMapTest::selectWith_value;
            this.payloads.partition_value = UnmodifiableBiMapTest::partition_value;
            this.payloads.partitionWith_value = UnmodifiableBiMapTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = UnmodifiableBiMapTest::selectInstancesOf_value;
            this.payloads.toArray = UnmodifiableBiMapTest::toArray;
            this.payloads.zip = UnmodifiableBiMapTest::zip;
            this.payloads.zipWithIndex = UnmodifiableBiMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = UnmodifiableBiMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableBiMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = UnmodifiableBiMapTest::keyValuesView;
            this.payloads.testNewMap = UnmodifiableBiMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = UnmodifiableBiMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = UnmodifiableBiMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = UnmodifiableBiMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = UnmodifiableBiMapTest::newMapWithWithWithWith;
            this.payloads.keysView = UnmodifiableBiMapTest::keysView;
            this.payloads.valuesView = UnmodifiableBiMapTest::valuesView;
            this.payloads.test_toString = UnmodifiableBiMapTest::test_toString;
            this.payloads.toImmutable = UnmodifiableBiMapTest::toImmutable;
            this.payloads.entrySetEqualsAndHashCode = UnmodifiableBiMapTest::entrySetEqualsAndHashCode;
            this.payloads.keySetEqualsAndHashCode = UnmodifiableBiMapTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = UnmodifiableBiMapTest::keySetToArray;
            this.payloads.getKeysAndGetValues = UnmodifiableBiMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = UnmodifiableBiMapTest::newEmpty;
            this.payloads.keysAndValues_toString = UnmodifiableBiMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = UnmodifiableBiMapTest::keyPreservation;
            this.payloads.asUnmodifiable = UnmodifiableBiMapTest::asUnmodifiable;
            this.payloads.asSynchronized = UnmodifiableBiMapTest::asSynchronized;
            this.payloads.retainAllFromKeySet_null_collision = UnmodifiableBiMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnmodifiableBiMapTest::rehash_null_collision;
            this.payloads.flip = UnmodifiableBiMapTest::flip;
            this.payloads.size = UnmodifiableBiMapTest::size;
            this.payloads.flipUniqueValues = UnmodifiableBiMapTest::flipUniqueValues;
            this.payloads.testToString = UnmodifiableBiMapTest::testToString;
            this.payloads.equalsAndHashCode = UnmodifiableBiMapTest::equalsAndHashCode;
            this.payloads.nullCollisionWithCastInEquals = UnmodifiableBiMapTest::nullCollisionWithCastInEquals;
            this.payloads.updateValue_collisions = UnmodifiableBiMapTest::updateValue_collisions;
            this.payloads.updateValueWith_collisions = UnmodifiableBiMapTest::updateValueWith_collisions;
            this.payloads.into = UnmodifiableBiMapTest::into;
            this.payloads.newMap_throws = UnmodifiableBiMapTest::newMap_throws;
            this.payloads.containsKey = UnmodifiableBiMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableBiMapTest::containsValue;
            this.payloads.get = UnmodifiableBiMapTest::get;
            this.payloads.iterator = UnmodifiableBiMapTest::iterator;
            this.payloads.testClone = UnmodifiableBiMapTest::testClone;
            this.payloads.withKeyValue = UnmodifiableBiMapTest::withKeyValue;
            this.payloads.withMap = UnmodifiableBiMapTest::withMap;
            this.payloads.withMapEmpty = UnmodifiableBiMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = UnmodifiableBiMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = UnmodifiableBiMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = UnmodifiableBiMapTest::withMapNull;
            this.payloads.withMapIterable = UnmodifiableBiMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = UnmodifiableBiMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = UnmodifiableBiMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = UnmodifiableBiMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = UnmodifiableBiMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = UnmodifiableBiMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = UnmodifiableBiMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = UnmodifiableBiMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = UnmodifiableBiMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = UnmodifiableBiMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValueArguments = UnmodifiableBiMapTest::withAllKeyValueArguments;
            this.payloads.add = UnmodifiableBiMapTest::add;
            this.payloads.put = UnmodifiableBiMapTest::put;
            this.payloads.putPair = UnmodifiableBiMapTest::putPair;
            this.payloads.putAll = UnmodifiableBiMapTest::putAll;
            this.payloads.forcePut = UnmodifiableBiMapTest::forcePut;
            this.payloads.updateValue = UnmodifiableBiMapTest::updateValue;
            this.payloads.updateValueWith = UnmodifiableBiMapTest::updateValueWith;
            this.payloads.getIfAbsentPut = UnmodifiableBiMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutWith = UnmodifiableBiMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = UnmodifiableBiMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutValue = UnmodifiableBiMapTest::getIfAbsentPutValue;
            this.payloads.withoutKey = UnmodifiableBiMapTest::withoutKey;
            this.payloads.withoutAllKeys = UnmodifiableBiMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = UnmodifiableBiMapTest::withAllKeyValues;
            this.payloads.clear = UnmodifiableBiMapTest::clear;
            this.payloads.clearEntrySet = UnmodifiableBiMapTest::clearEntrySet;
            this.payloads.clearKeySet = UnmodifiableBiMapTest::clearKeySet;
            this.payloads.remove = UnmodifiableBiMapTest::remove;
            this.payloads.removeObject = UnmodifiableBiMapTest::removeObject;
            this.payloads.removeFromEntrySet = UnmodifiableBiMapTest::removeFromEntrySet;
            this.payloads.removeFromKeySet = UnmodifiableBiMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = UnmodifiableBiMapTest::removeNullFromKeySet;
            this.payloads.removeKey = UnmodifiableBiMapTest::removeKey;
            this.payloads.removeAllKeys = UnmodifiableBiMapTest::removeAllKeys;
            this.payloads.removeIf = UnmodifiableBiMapTest::removeIf;
            this.payloads.removeNullFromValues = UnmodifiableBiMapTest::removeNullFromValues;
            this.payloads.removeFromValues = UnmodifiableBiMapTest::removeFromValues;
            this.payloads.retainAllFromEntrySet = UnmodifiableBiMapTest::retainAllFromEntrySet;
            this.payloads.retainAllFromKeySet = UnmodifiableBiMapTest::retainAllFromKeySet;
            this.payloads.retainAllFromValues = UnmodifiableBiMapTest::retainAllFromValues;
            this.payloads.removeAllFromEntrySet = UnmodifiableBiMapTest::removeAllFromEntrySet;
            this.payloads.removeAllFromKeySet = UnmodifiableBiMapTest::removeAllFromKeySet;
            this.payloads.removeAllFromValues = UnmodifiableBiMapTest::removeAllFromValues;
            this.payloads.getIfAbsentPut_block_throws = UnmodifiableBiMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = UnmodifiableBiMapTest::getIfAbsentPutWith_block_throws;
        }
    }
}
