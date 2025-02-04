/*
 * Copyright (c) 2021 Goldman Sachs.
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableTreeMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_test_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.test_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeysAndGetValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getKeysAndGetValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysAndValues_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysAndValues_toString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_3);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_4() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_4);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith_reverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith_reverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex_reverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex_reverse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_sorted() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_sorted);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
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
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetToArrayWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetToArrayWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableTreeMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> newMapWith_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> newMapWith_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> newMapWith_4;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEachWith_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEachWithIndex_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> entrySet_sorted;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> firstKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> lastKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> entrySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> entrySetToArrayWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> headMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> tailMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> subMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableTreeMapTest> updateValueWith_collisions;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = UnmodifiableTreeMapTest::stream;
            this.payloads.parallelStream = UnmodifiableTreeMapTest::parallelStream;
            this.payloads.isEmpty = UnmodifiableTreeMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableTreeMapTest::notEmpty;
            this.payloads.ifPresentApply = UnmodifiableTreeMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = UnmodifiableTreeMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = UnmodifiableTreeMapTest::getOrDefault;
            this.payloads.getIfAbsent = UnmodifiableTreeMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = UnmodifiableTreeMapTest::getIfAbsentWith;
            this.payloads.forEachValue = UnmodifiableTreeMapTest::forEachValue;
            this.payloads.injectIntoKeyValue = UnmodifiableTreeMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = UnmodifiableTreeMapTest::flipUniqueValues;
            this.payloads.collectBoolean = UnmodifiableTreeMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableTreeMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnmodifiableTreeMapTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableTreeMapTest::collectByteWithTarget;
            this.payloads.collectChar = UnmodifiableTreeMapTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableTreeMapTest::collectCharWithTarget;
            this.payloads.collectDouble = UnmodifiableTreeMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableTreeMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnmodifiableTreeMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableTreeMapTest::collectFloatWithTarget;
            this.payloads.collectInt = UnmodifiableTreeMapTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableTreeMapTest::collectIntWithTarget;
            this.payloads.collectLong = UnmodifiableTreeMapTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableTreeMapTest::collectLongWithTarget;
            this.payloads.collectShort = UnmodifiableTreeMapTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableTreeMapTest::collectShortWithTarget;
            this.payloads.select = UnmodifiableTreeMapTest::select;
            this.payloads.selectWith = UnmodifiableTreeMapTest::selectWith;
            this.payloads.reject = UnmodifiableTreeMapTest::reject;
            this.payloads.rejectWith = UnmodifiableTreeMapTest::rejectWith;
            this.payloads.collect = UnmodifiableTreeMapTest::collect;
            this.payloads.flatCollect = UnmodifiableTreeMapTest::flatCollect;
            this.payloads.flatCollectWith = UnmodifiableTreeMapTest::flatCollectWith;
            this.payloads.detect = UnmodifiableTreeMapTest::detect;
            this.payloads.detectOptional = UnmodifiableTreeMapTest::detectOptional;
            this.payloads.anySatisfy = UnmodifiableTreeMapTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableTreeMapTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableTreeMapTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableTreeMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableTreeMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableTreeMapTest::noneSatisfyWith;
            this.payloads.appendString = UnmodifiableTreeMapTest::appendString;
            this.payloads.toBag = UnmodifiableTreeMapTest::toBag;
            this.payloads.toSortedBag = UnmodifiableTreeMapTest::toSortedBag;
            this.payloads.toSortedBagBy = UnmodifiableTreeMapTest::toSortedBagBy;
            this.payloads.asLazy = UnmodifiableTreeMapTest::asLazy;
            this.payloads.toList = UnmodifiableTreeMapTest::toList;
            this.payloads.toMap = UnmodifiableTreeMapTest::toMap;
            this.payloads.toSet = UnmodifiableTreeMapTest::toSet;
            this.payloads.toSortedList = UnmodifiableTreeMapTest::toSortedList;
            this.payloads.toSortedListBy = UnmodifiableTreeMapTest::toSortedListBy;
            this.payloads.toSortedSet = UnmodifiableTreeMapTest::toSortedSet;
            this.payloads.toSortedSetBy = UnmodifiableTreeMapTest::toSortedSetBy;
            this.payloads.toSortedMap = UnmodifiableTreeMapTest::toSortedMap;
            this.payloads.chunk = UnmodifiableTreeMapTest::chunk;
            this.payloads.collectWith = UnmodifiableTreeMapTest::collectWith;
            this.payloads.collectWithToTarget = UnmodifiableTreeMapTest::collectWithToTarget;
            this.payloads.contains = UnmodifiableTreeMapTest::contains;
            this.payloads.containsAnyIterable = UnmodifiableTreeMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnmodifiableTreeMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = UnmodifiableTreeMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnmodifiableTreeMapTest::containsNoneCollection;
            this.payloads.containsAll = UnmodifiableTreeMapTest::containsAll;
            this.payloads.containsKey = UnmodifiableTreeMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableTreeMapTest::containsValue;
            this.payloads.getFirst = UnmodifiableTreeMapTest::getFirst;
            this.payloads.getLast = UnmodifiableTreeMapTest::getLast;
            this.payloads.getOnly = UnmodifiableTreeMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnmodifiableTreeMapTest::containsAllIterable;
            this.payloads.containsAllArguments = UnmodifiableTreeMapTest::containsAllArguments;
            this.payloads.count = UnmodifiableTreeMapTest::count;
            this.payloads.countWith = UnmodifiableTreeMapTest::countWith;
            this.payloads.detect_value = UnmodifiableTreeMapTest::detect_value;
            this.payloads.detectOptional_value = UnmodifiableTreeMapTest::detectOptional_value;
            this.payloads.detectWith = UnmodifiableTreeMapTest::detectWith;
            this.payloads.detectWithOptional = UnmodifiableTreeMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = UnmodifiableTreeMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = UnmodifiableTreeMapTest::detectWithIfNone;
            this.payloads.countBy = UnmodifiableTreeMapTest::countBy;
            this.payloads.countByWith = UnmodifiableTreeMapTest::countByWith;
            this.payloads.countByEach = UnmodifiableTreeMapTest::countByEach;
            this.payloads.groupBy = UnmodifiableTreeMapTest::groupBy;
            this.payloads.groupByEach = UnmodifiableTreeMapTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableTreeMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableTreeMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = UnmodifiableTreeMapTest::injectInto;
            this.payloads.injectIntoInt = UnmodifiableTreeMapTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableTreeMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = UnmodifiableTreeMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = UnmodifiableTreeMapTest::injectIntoDouble;
            this.payloads.sumOfInt = UnmodifiableTreeMapTest::sumOfInt;
            this.payloads.sumOfLong = UnmodifiableTreeMapTest::sumOfLong;
            this.payloads.testAggregateBy = UnmodifiableTreeMapTest::testAggregateBy;
            this.payloads.sumOfFloat = UnmodifiableTreeMapTest::sumOfFloat;
            this.payloads.sumOfDouble = UnmodifiableTreeMapTest::sumOfDouble;
            this.payloads.sumByInt = UnmodifiableTreeMapTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableTreeMapTest::sumByFloat;
            this.payloads.sumByLong = UnmodifiableTreeMapTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableTreeMapTest::sumByDouble;
            this.payloads.makeString = UnmodifiableTreeMapTest::makeString;
            this.payloads.min = UnmodifiableTreeMapTest::min;
            this.payloads.max = UnmodifiableTreeMapTest::max;
            this.payloads.minBy = UnmodifiableTreeMapTest::minBy;
            this.payloads.maxBy = UnmodifiableTreeMapTest::maxBy;
            this.payloads.rejectWith_value = UnmodifiableTreeMapTest::rejectWith_value;
            this.payloads.selectWith_value = UnmodifiableTreeMapTest::selectWith_value;
            this.payloads.selectInstancesOf_value = UnmodifiableTreeMapTest::selectInstancesOf_value;
            this.payloads.toArray = UnmodifiableTreeMapTest::toArray;
            this.payloads.aggregateByMutating = UnmodifiableTreeMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableTreeMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = UnmodifiableTreeMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = UnmodifiableTreeMapTest::nullCollisionWithCastInEquals;
            this.payloads.newMapWithWith = UnmodifiableTreeMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = UnmodifiableTreeMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = UnmodifiableTreeMapTest::newMapWithWithWithWith;
            this.payloads.keysView = UnmodifiableTreeMapTest::keysView;
            this.payloads.valuesView = UnmodifiableTreeMapTest::valuesView;
            this.payloads.test_toString = UnmodifiableTreeMapTest::test_toString;
            this.payloads.entrySetEqualsAndHashCode = UnmodifiableTreeMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeNullFromKeySet = UnmodifiableTreeMapTest::removeNullFromKeySet;
            this.payloads.keySetToArray = UnmodifiableTreeMapTest::keySetToArray;
            this.payloads.getKeysAndGetValues = UnmodifiableTreeMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = UnmodifiableTreeMapTest::newEmpty;
            this.payloads.keysAndValues_toString = UnmodifiableTreeMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = UnmodifiableTreeMapTest::keyPreservation;
            this.payloads.retainAllFromKeySet_null_collision = UnmodifiableTreeMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnmodifiableTreeMapTest::rehash_null_collision;
            this.payloads.testNewEmpty = UnmodifiableTreeMapTest::testNewEmpty;
            this.payloads.testNewMap = UnmodifiableTreeMapTest::testNewMap;
            this.payloads.toImmutable = UnmodifiableTreeMapTest::toImmutable;
            this.payloads.testNewMapWithKeyValue = UnmodifiableTreeMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWith_2 = UnmodifiableTreeMapTest::newMapWith_2;
            this.payloads.newMapWith_3 = UnmodifiableTreeMapTest::newMapWith_3;
            this.payloads.newMapWith_4 = UnmodifiableTreeMapTest::newMapWith_4;
            this.payloads.tap = UnmodifiableTreeMapTest::tap;
            this.payloads.forEach = UnmodifiableTreeMapTest::forEach;
            this.payloads.forEachWith = UnmodifiableTreeMapTest::forEachWith;
            this.payloads.forEachWith_reverse = UnmodifiableTreeMapTest::forEachWith_reverse;
            this.payloads.forEachWithIndex = UnmodifiableTreeMapTest::forEachWithIndex;
            this.payloads.forEachWithIndex_reverse = UnmodifiableTreeMapTest::forEachWithIndex_reverse;
            this.payloads.forEachKeyValue = UnmodifiableTreeMapTest::forEachKeyValue;
            this.payloads.forEachKey = UnmodifiableTreeMapTest::forEachKey;
            this.payloads.collectValues = UnmodifiableTreeMapTest::collectValues;
            this.payloads.zipWithIndex = UnmodifiableTreeMapTest::zipWithIndex;
            this.payloads.zip = UnmodifiableTreeMapTest::zip;
            this.payloads.select_value = UnmodifiableTreeMapTest::select_value;
            this.payloads.reject_value = UnmodifiableTreeMapTest::reject_value;
            this.payloads.partition_value = UnmodifiableTreeMapTest::partition_value;
            this.payloads.partitionWith_value = UnmodifiableTreeMapTest::partitionWith_value;
            this.payloads.collect_value = UnmodifiableTreeMapTest::collect_value;
            this.payloads.collectWithIndex = UnmodifiableTreeMapTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = UnmodifiableTreeMapTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = UnmodifiableTreeMapTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = UnmodifiableTreeMapTest::rejectWithIndexWithTarget;
            this.payloads.flatten_value = UnmodifiableTreeMapTest::flatten_value;
            this.payloads.collectMap = UnmodifiableTreeMapTest::collectMap;
            this.payloads.selectMap = UnmodifiableTreeMapTest::selectMap;
            this.payloads.rejectMap = UnmodifiableTreeMapTest::rejectMap;
            this.payloads.flip = UnmodifiableTreeMapTest::flip;
            this.payloads.collectIf = UnmodifiableTreeMapTest::collectIf;
            this.payloads.iterator = UnmodifiableTreeMapTest::iterator;
            this.payloads.entrySet_sorted = UnmodifiableTreeMapTest::entrySet_sorted;
            this.payloads.keySet = UnmodifiableTreeMapTest::keySet;
            this.payloads.keySetEqualsAndHashCode = UnmodifiableTreeMapTest::keySetEqualsAndHashCode;
            this.payloads.testEquals = UnmodifiableTreeMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableTreeMapTest::testHashCode;
            this.payloads.equalsAndHashCode = UnmodifiableTreeMapTest::equalsAndHashCode;
            this.payloads.serialization = UnmodifiableTreeMapTest::serialization;
            this.payloads.asSynchronized = UnmodifiableTreeMapTest::asSynchronized;
            this.payloads.firstKey = UnmodifiableTreeMapTest::firstKey;
            this.payloads.lastKey = UnmodifiableTreeMapTest::lastKey;
            this.payloads.testToString = UnmodifiableTreeMapTest::testToString;
            this.payloads.take = UnmodifiableTreeMapTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = UnmodifiableTreeMapTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeObject = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeObject, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllKeys = UnmodifiableTreeMapTest::removeAllKeys;
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeFromEntrySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeFromEntrySet, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllFromEntrySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeAllFromEntrySet, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllFromEntrySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::retainAllFromEntrySet, java.lang.UnsupportedOperationException.class);
            this.payloads.clearEntrySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::clearEntrySet, java.lang.UnsupportedOperationException.class);
            this.payloads.removeFromKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeFromKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllFromKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeAllFromKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllFromKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::retainAllFromKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.clearKeySet = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::clearKeySet, java.lang.UnsupportedOperationException.class);
            this.payloads.removeFromValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeFromValues, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllFromValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeAllFromValues, java.lang.UnsupportedOperationException.class);
            this.payloads.removeNullFromValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::removeNullFromValues, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAllFromValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::retainAllFromValues, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::getIfAbsentPut, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::getIfAbsentPutValue, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::getIfAbsentPutWithKey, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::getIfAbsentPutWith, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::putAll, java.lang.UnsupportedOperationException.class);
            this.payloads.putAllFromCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::putAllFromCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = UnmodifiableTreeMapTest::clear;
            this.payloads.asUnmodifiable = UnmodifiableTreeMapTest::asUnmodifiable;
            this.payloads.entrySet = UnmodifiableTreeMapTest::entrySet;
            this.payloads.entrySetToArray = UnmodifiableTreeMapTest::entrySetToArray;
            this.payloads.entrySetToArrayWithTarget = UnmodifiableTreeMapTest::entrySetToArrayWithTarget;
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeyValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::withKeyValue, java.lang.UnsupportedOperationException.class);
            this.payloads.withMap = UnmodifiableTreeMapTest::withMap;
            this.payloads.withMapEmpty = UnmodifiableTreeMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = UnmodifiableTreeMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = UnmodifiableTreeMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = UnmodifiableTreeMapTest::withMapNull;
            this.payloads.withMapIterable = UnmodifiableTreeMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = UnmodifiableTreeMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = UnmodifiableTreeMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = UnmodifiableTreeMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = UnmodifiableTreeMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = UnmodifiableTreeMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = UnmodifiableTreeMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = UnmodifiableTreeMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = UnmodifiableTreeMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = UnmodifiableTreeMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValueArguments = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::withAllKeyValueArguments, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.headMap = UnmodifiableTreeMapTest::headMap;
            this.payloads.tailMap = UnmodifiableTreeMapTest::tailMap;
            this.payloads.subMap = UnmodifiableTreeMapTest::subMap;
            this.payloads.testClone = UnmodifiableTreeMapTest::testClone;
            this.payloads.getIfAbsentPut_block_throws = UnmodifiableTreeMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = UnmodifiableTreeMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue_collisions = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::updateValue_collisions, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith_collisions = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableTreeMapTest::updateValueWith_collisions, java.lang.UnsupportedOperationException.class);
        }
    }
*/
}
