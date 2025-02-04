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

import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.domain.Key;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

public class HashBiMapTest extends AbstractMutableBiMapTestCase {

    @Override
    public HashBiMap<Integer, Character> classUnderTest() {
        HashBiMap<Integer, Character> map = HashBiMap.newMap();
        map.put(1, null);
        map.put(null, 'b');
        map.put(3, 'c');
        return map;
    }

    @Override
    public HashBiMap<Integer, Character> getEmptyMap() {
        return HashBiMap.newMap();
    }

    @Override
    protected <K, V> HashBiMap<K, V> newMap() {
        return HashBiMap.newMap();
    }

    @Override
    protected <K, V> HashBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return HashBiMap.newWithKeysValues(key, value);
    }

    @Override
    protected <K, V> HashBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <K, V> HashBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <K, V> HashBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Test
    public void newMap_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new HashBiMap<>(UnifiedMap.newMap(), null));
        Assert.assertThrows(IllegalArgumentException.class, () -> new HashBiMap<>(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> new HashBiMap<>(null, UnifiedMap.newMap()));
        UnifiedMap<Object, Object> map = UnifiedMap.newMap();
        Assert.assertThrows(IllegalArgumentException.class, () -> new HashBiMap<>(map, map));
    }

    @Test
    public void withKeysValues() {
        HashBiMap<Integer, Character> map = this.getEmptyMap();
        HashBiMap<Integer, Character> map1 = map.withKeysValues(1, 'a');
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'a'), map1);
        Assert.assertSame(map, map1);
        HashBiMap<Integer, Character> map2 = map1.withKeysValues(2, 'b');
        HashBiMap<Integer, Character> map22 = map.withKeysValues(1, 'a', 2, 'b');
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'a', 2, 'b'), map2);
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'a', 2, 'b'), map22);
        Assert.assertSame(map, map22);
        Assert.assertSame(map1, map2);
        HashBiMap<Integer, Character> map3 = map2.withKeysValues(3, 'c');
        HashBiMap<Integer, Character> map33 = map.withKeysValues(1, 'a', 2, 'b', 3, 'c');
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'a', 2, 'b', 3, 'c'), map3);
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'a', 2, 'b', 3, 'c'), map33);
        Assert.assertSame(map, map33);
        Assert.assertSame(map2, map3);
        HashBiMap<Integer, Character> map4 = map3.withKeysValues(4, 'd');
        HashBiMap<Integer, Character> map44 = map.withKeysValues(1, 'a', 2, 'b', 3, 'c', 4, 'd');
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'a', 2, 'b', 3, 'c', 4, 'd'), map4);
        AbstractMutableBiMapTestCase.assertBiMapsEqual(HashBiMap.newWithKeysValues(1, 'a', 2, 'b', 3, 'c', 4, 'd'), map44);
        Assert.assertSame(map, map44);
        Assert.assertSame(map3, map4);
    }

    @Test
    public void inverseKeyPreservation() {
        Key key = new Key("key");
        Key duplicateKey = new Key("key");
        MutableBiMap<Key, Integer> biMap = this.newMapWithKeysValues(key, 1, duplicateKey, 2);
        Assert.assertSame(key, Iterate.getFirst(biMap.entrySet()).getKey());
        Assert.assertSame(key, Iterate.getFirst(biMap.inverse().entrySet()).getValue());
    }

    @Test
    public void valuePreservation() {
        Key value = new Key("value");
        Key duplicateValue = new Key("value");
        MutableBiMap<Integer, Key> biMap = this.newMapWithKeyValue(1, value);
        biMap.forcePut(2, duplicateValue);
        Assert.assertSame(value, Iterate.getFirst(biMap.entrySet()).getValue());
        Assert.assertSame(value, Iterate.getFirst(biMap.inverse().entrySet()).getKey());
    }

    @Test
    public void forcePut_inverseKeyAndValuePreservation() {
        Key key1 = new Key("1");
        Key value2 = new Key("xyz");
        HashBiMap<Key, Key> biMap = this.newMapWithKeysValues(key1, new Key("abc"), new Key("2"), value2);
        Key duplicateOfKey1 = new Key("1");
        Key duplicateOfValue2 = new Key("xyz");
        biMap.forcePut(duplicateOfKey1, duplicateOfValue2);
        Assert.assertSame(key1, Iterate.getFirst(biMap.entrySet()).getKey());
        Assert.assertSame(key1, Iterate.getFirst(biMap.inverse().entrySet()).getValue());
        Assert.assertSame(value2, Iterate.getFirst(biMap.entrySet()).getValue());
        Assert.assertSame(value2, Iterate.getFirst(biMap.inverse().entrySet()).getKey());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private HashBiMapTest instance;

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
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
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
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_block_throws);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
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
        public void benchmark_forcePut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forcePut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
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
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_inverseKeyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.inverseKeyPreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuePreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuePreservation);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forcePut_inverseKeyAndValuePreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forcePut_inverseKeyAndValuePreservation);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forcePut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> into;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> newMap_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> inverseKeyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> valuePreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapTest> forcePut_inverseKeyAndValuePreservation;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = HashBiMapTest::stream;
            this.payloads.parallelStream = HashBiMapTest::parallelStream;
            this.payloads.serialization = HashBiMapTest::serialization;
            this.payloads.isEmpty = HashBiMapTest::isEmpty;
            this.payloads.notEmpty = HashBiMapTest::notEmpty;
            this.payloads.ifPresentApply = HashBiMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = HashBiMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = HashBiMapTest::getOrDefault;
            this.payloads.getIfAbsent = HashBiMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = HashBiMapTest::getIfAbsentWith;
            this.payloads.tap = HashBiMapTest::tap;
            this.payloads.forEach = HashBiMapTest::forEach;
            this.payloads.forEachWith = HashBiMapTest::forEachWith;
            this.payloads.forEachWithIndex = HashBiMapTest::forEachWithIndex;
            this.payloads.forEachKey = HashBiMapTest::forEachKey;
            this.payloads.forEachValue = HashBiMapTest::forEachValue;
            this.payloads.forEachKeyValue = HashBiMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = HashBiMapTest::injectIntoKeyValue;
            this.payloads.collectMap = HashBiMapTest::collectMap;
            this.payloads.collectBoolean = HashBiMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = HashBiMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = HashBiMapTest::collectByte;
            this.payloads.collectByteWithTarget = HashBiMapTest::collectByteWithTarget;
            this.payloads.collectChar = HashBiMapTest::collectChar;
            this.payloads.collectCharWithTarget = HashBiMapTest::collectCharWithTarget;
            this.payloads.collectDouble = HashBiMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = HashBiMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = HashBiMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = HashBiMapTest::collectFloatWithTarget;
            this.payloads.collectInt = HashBiMapTest::collectInt;
            this.payloads.collectIntWithTarget = HashBiMapTest::collectIntWithTarget;
            this.payloads.collectLong = HashBiMapTest::collectLong;
            this.payloads.collectLongWithTarget = HashBiMapTest::collectLongWithTarget;
            this.payloads.collectShort = HashBiMapTest::collectShort;
            this.payloads.collectShortWithTarget = HashBiMapTest::collectShortWithTarget;
            this.payloads.collectValues = HashBiMapTest::collectValues;
            this.payloads.select = HashBiMapTest::select;
            this.payloads.selectWith = HashBiMapTest::selectWith;
            this.payloads.reject = HashBiMapTest::reject;
            this.payloads.rejectWith = HashBiMapTest::rejectWith;
            this.payloads.collect = HashBiMapTest::collect;
            this.payloads.flatCollect = HashBiMapTest::flatCollect;
            this.payloads.flatCollectWith = HashBiMapTest::flatCollectWith;
            this.payloads.selectMap = HashBiMapTest::selectMap;
            this.payloads.rejectMap = HashBiMapTest::rejectMap;
            this.payloads.detect = HashBiMapTest::detect;
            this.payloads.detectOptional = HashBiMapTest::detectOptional;
            this.payloads.anySatisfy = HashBiMapTest::anySatisfy;
            this.payloads.anySatisfyWith = HashBiMapTest::anySatisfyWith;
            this.payloads.allSatisfy = HashBiMapTest::allSatisfy;
            this.payloads.allSatisfyWith = HashBiMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = HashBiMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = HashBiMapTest::noneSatisfyWith;
            this.payloads.appendString = HashBiMapTest::appendString;
            this.payloads.toBag = HashBiMapTest::toBag;
            this.payloads.toSortedBag = HashBiMapTest::toSortedBag;
            this.payloads.toSortedBagBy = HashBiMapTest::toSortedBagBy;
            this.payloads.asLazy = HashBiMapTest::asLazy;
            this.payloads.toList = HashBiMapTest::toList;
            this.payloads.toMap = HashBiMapTest::toMap;
            this.payloads.toSet = HashBiMapTest::toSet;
            this.payloads.toSortedList = HashBiMapTest::toSortedList;
            this.payloads.toSortedListBy = HashBiMapTest::toSortedListBy;
            this.payloads.toSortedSet = HashBiMapTest::toSortedSet;
            this.payloads.toSortedSetBy = HashBiMapTest::toSortedSetBy;
            this.payloads.toSortedMap = HashBiMapTest::toSortedMap;
            this.payloads.chunk = HashBiMapTest::chunk;
            this.payloads.collect_value = HashBiMapTest::collect_value;
            this.payloads.collectIf = HashBiMapTest::collectIf;
            this.payloads.collectWith = HashBiMapTest::collectWith;
            this.payloads.collectWithToTarget = HashBiMapTest::collectWithToTarget;
            this.payloads.contains = HashBiMapTest::contains;
            this.payloads.containsAnyIterable = HashBiMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = HashBiMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = HashBiMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = HashBiMapTest::containsNoneCollection;
            this.payloads.containsAll = HashBiMapTest::containsAll;
            this.payloads.getFirst = HashBiMapTest::getFirst;
            this.payloads.getLast = HashBiMapTest::getLast;
            this.payloads.getOnly = HashBiMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = HashBiMapTest::containsAllIterable;
            this.payloads.containsAllArguments = HashBiMapTest::containsAllArguments;
            this.payloads.count = HashBiMapTest::count;
            this.payloads.countWith = HashBiMapTest::countWith;
            this.payloads.detect_value = HashBiMapTest::detect_value;
            this.payloads.detectOptional_value = HashBiMapTest::detectOptional_value;
            this.payloads.detectWith = HashBiMapTest::detectWith;
            this.payloads.detectWithOptional = HashBiMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = HashBiMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = HashBiMapTest::detectWithIfNone;
            this.payloads.flatten_value = HashBiMapTest::flatten_value;
            this.payloads.countBy = HashBiMapTest::countBy;
            this.payloads.countByWith = HashBiMapTest::countByWith;
            this.payloads.countByEach = HashBiMapTest::countByEach;
            this.payloads.groupBy = HashBiMapTest::groupBy;
            this.payloads.groupByEach = HashBiMapTest::groupByEach;
            this.payloads.groupByUniqueKey = HashBiMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = HashBiMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = HashBiMapTest::injectInto;
            this.payloads.injectIntoInt = HashBiMapTest::injectIntoInt;
            this.payloads.injectIntoLong = HashBiMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = HashBiMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = HashBiMapTest::injectIntoDouble;
            this.payloads.sumOfInt = HashBiMapTest::sumOfInt;
            this.payloads.sumOfLong = HashBiMapTest::sumOfLong;
            this.payloads.testAggregateBy = HashBiMapTest::testAggregateBy;
            this.payloads.sumOfFloat = HashBiMapTest::sumOfFloat;
            this.payloads.sumOfDouble = HashBiMapTest::sumOfDouble;
            this.payloads.sumByInt = HashBiMapTest::sumByInt;
            this.payloads.sumByFloat = HashBiMapTest::sumByFloat;
            this.payloads.sumByLong = HashBiMapTest::sumByLong;
            this.payloads.sumByDouble = HashBiMapTest::sumByDouble;
            this.payloads.makeString = HashBiMapTest::makeString;
            this.payloads.min = HashBiMapTest::min;
            this.payloads.max = HashBiMapTest::max;
            this.payloads.minBy = HashBiMapTest::minBy;
            this.payloads.maxBy = HashBiMapTest::maxBy;
            this.payloads.reject_value = HashBiMapTest::reject_value;
            this.payloads.rejectWith_value = HashBiMapTest::rejectWith_value;
            this.payloads.select_value = HashBiMapTest::select_value;
            this.payloads.selectWith_value = HashBiMapTest::selectWith_value;
            this.payloads.partition_value = HashBiMapTest::partition_value;
            this.payloads.partitionWith_value = HashBiMapTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = HashBiMapTest::selectInstancesOf_value;
            this.payloads.toArray = HashBiMapTest::toArray;
            this.payloads.zip = HashBiMapTest::zip;
            this.payloads.zipWithIndex = HashBiMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = HashBiMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = HashBiMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = HashBiMapTest::keyValuesView;
            this.payloads.testNewMap = HashBiMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = HashBiMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = HashBiMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = HashBiMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = HashBiMapTest::newMapWithWithWithWith;
            this.payloads.keysView = HashBiMapTest::keysView;
            this.payloads.valuesView = HashBiMapTest::valuesView;
            this.payloads.test_toString = HashBiMapTest::test_toString;
            this.payloads.toImmutable = HashBiMapTest::toImmutable;
            this.payloads.removeObject = HashBiMapTest::removeObject;
            this.payloads.removeFromEntrySet = HashBiMapTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = HashBiMapTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = HashBiMapTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = HashBiMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = HashBiMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = HashBiMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = HashBiMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = HashBiMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = HashBiMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = HashBiMapTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = HashBiMapTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = HashBiMapTest::keySetToArray;
            this.payloads.removeFromValues = HashBiMapTest::removeFromValues;
            this.payloads.removeNullFromValues = HashBiMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = HashBiMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = HashBiMapTest::retainAllFromValues;
            this.payloads.removeKey = HashBiMapTest::removeKey;
            this.payloads.removeAllKeys = HashBiMapTest::removeAllKeys;
            this.payloads.removeIf = HashBiMapTest::removeIf;
            this.payloads.getIfAbsentPut = HashBiMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = HashBiMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = HashBiMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = HashBiMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = HashBiMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = HashBiMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = HashBiMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = HashBiMapTest::newEmpty;
            this.payloads.keysAndValues_toString = HashBiMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = HashBiMapTest::keyPreservation;
            this.payloads.asUnmodifiable = HashBiMapTest::asUnmodifiable;
            this.payloads.asSynchronized = HashBiMapTest::asSynchronized;
            this.payloads.add = HashBiMapTest::add;
            this.payloads.putPair = HashBiMapTest::putPair;
            this.payloads.withKeyValue = HashBiMapTest::withKeyValue;
            this.payloads.withMap = HashBiMapTest::withMap;
            this.payloads.withMapEmpty = HashBiMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = HashBiMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = HashBiMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapIterable = HashBiMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = HashBiMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = HashBiMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = HashBiMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = HashBiMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = HashBiMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = HashBiMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = HashBiMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = HashBiMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = HashBiMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = HashBiMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = HashBiMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = HashBiMapTest::withoutKey;
            this.payloads.withoutAllKeys = HashBiMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = HashBiMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = HashBiMapTest::rehash_null_collision;
            this.payloads.flip = HashBiMapTest::flip;
            this.payloads.size = HashBiMapTest::size;
            this.payloads.forcePut = HashBiMapTest::forcePut;
            this.payloads.put = HashBiMapTest::put;
            this.payloads.flipUniqueValues = HashBiMapTest::flipUniqueValues;
            this.payloads.get = HashBiMapTest::get;
            this.payloads.containsKey = HashBiMapTest::containsKey;
            this.payloads.containsValue = HashBiMapTest::containsValue;
            this.payloads.putAll = HashBiMapTest::putAll;
            this.payloads.remove = HashBiMapTest::remove;
            this.payloads.clear = HashBiMapTest::clear;
            this.payloads.testToString = HashBiMapTest::testToString;
            this.payloads.equalsAndHashCode = HashBiMapTest::equalsAndHashCode;
            this.payloads.nullCollisionWithCastInEquals = HashBiMapTest::nullCollisionWithCastInEquals;
            this.payloads.iterator = HashBiMapTest::iterator;
            this.payloads.withMapNull = HashBiMapTest::withMapNull;
            this.payloads.updateValueWith = HashBiMapTest::updateValueWith;
            this.payloads.updateValue = HashBiMapTest::updateValue;
            this.payloads.updateValue_collisions = HashBiMapTest::updateValue_collisions;
            this.payloads.updateValueWith_collisions = HashBiMapTest::updateValueWith_collisions;
            this.payloads.testClone = HashBiMapTest::testClone;
            this.payloads.into = HashBiMapTest::into;
            this.payloads.newMap_throws = HashBiMapTest::newMap_throws;
            this.payloads.withKeysValues = HashBiMapTest::withKeysValues;
            this.payloads.inverseKeyPreservation = HashBiMapTest::inverseKeyPreservation;
            this.payloads.valuePreservation = HashBiMapTest::valuePreservation;
            this.payloads.forcePut_inverseKeyAndValuePreservation = HashBiMapTest::forcePut_inverseKeyAndValuePreservation;
        }
    }
}
