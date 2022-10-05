/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable;

import org.eclipse.collections.api.map.ConcurrentMutableMap;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iSet;

/**
 * JUnit test for {@link ConcurrentMutableHashMap}.
 */
public class ConcurrentMutableHashMapTest extends ConcurrentHashMapTestCase {

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMap() {
        return ConcurrentMutableHashMap.newMap();
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return ConcurrentMutableHashMap.<K, V>newMap().withKeyValue(key, value);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return ConcurrentMutableHashMap.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return ConcurrentMutableHashMap.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    public <K, V> ConcurrentMutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return ConcurrentMutableHashMap.<K, V>newMap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @Test
    public void putIfAbsent() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertEquals(Integer.valueOf(1), map.putIfAbsent(1, 1));
        Assert.assertNull(map.putIfAbsent(3, 3));
    }

    @Test
    public void replace() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertEquals(Integer.valueOf(1), map.replace(1, 1));
        Assert.assertNull(map.replace(3, 3));
    }

    @Test
    public void replaceWithOldValue() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertTrue(map.replace(1, 1, 1));
        Assert.assertFalse(map.replace(2, 3, 3));
    }

    @Test
    public void removeWithKeyValue() {
        ConcurrentMutableMap<Integer, Integer> map = this.newMapWithKeysValues(1, 1, 2, 2);
        Assert.assertTrue(map.remove(1, 1));
        Assert.assertFalse(map.remove(2, 3));
    }

    @Override
    @Test
    public void removeFromEntrySet() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().remove(ImmutableEntry.of("Two", 2)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
        Assert.assertFalse(map.entrySet().remove(ImmutableEntry.of("Four", 4)));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Three", 3), map);
    }

    @Override
    @Test
    public void removeAllFromEntrySet() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Assert.assertTrue(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("One", 1), ImmutableEntry.of("Three", 3))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("Two", 2), map);
        Assert.assertFalse(map.entrySet().removeAll(FastList.newListWith(ImmutableEntry.of("Four", 4))));
        Assert.assertEquals(UnifiedMap.newWithKeysValues("Two", 2), map);
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode() {
        MutableMap<String, Integer> map = this.newMapWithKeysValues("One", 1, "Two", 2, "Three", 3);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Override
    @Test
    public void partition_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

    @Override
    @Test
    public void partitionWith_value() {
        MapIterable<String, Integer> map = this.newMapWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partitionWith(Predicates2.in(), map.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

    @Override
    public void equalsAndHashCode() {
        // java.util.concurrent.ConcurrentHashMap doesn't support null keys OR values
        MapIterable<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        Verify.assertPostSerializedEqualsAndHashCode(map);
        Verify.assertEqualsAndHashCode(Maps.mutable.of(1, "1", 2, "2", 3, "3"), map);
        Verify.assertEqualsAndHashCode(Maps.immutable.of(1, "1", 2, "2", 3, "3"), map);
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
        Assert.assertNotEquals(map, this.newMapWithKeysValues(1, "1", 2, "2", 4, "4"));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ConcurrentMutableHashMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
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
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
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
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replace() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replace);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceWithOldValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceWithOldValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithKeyValue);
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
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ConcurrentMutableHashMapTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> putIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> replace;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> replaceWithOldValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ConcurrentMutableHashMapTest> partitionWith_value;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ConcurrentMutableHashMapTest::stream;
            this.payloads.parallelStream = ConcurrentMutableHashMapTest::parallelStream;
            this.payloads.equalsAndHashCode = ConcurrentMutableHashMapTest::equalsAndHashCode;
            this.payloads.serialization = ConcurrentMutableHashMapTest::serialization;
            this.payloads.isEmpty = ConcurrentMutableHashMapTest::isEmpty;
            this.payloads.notEmpty = ConcurrentMutableHashMapTest::notEmpty;
            this.payloads.ifPresentApply = ConcurrentMutableHashMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = ConcurrentMutableHashMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ConcurrentMutableHashMapTest::getOrDefault;
            this.payloads.getIfAbsent = ConcurrentMutableHashMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ConcurrentMutableHashMapTest::getIfAbsentWith;
            this.payloads.tap = ConcurrentMutableHashMapTest::tap;
            this.payloads.forEach = ConcurrentMutableHashMapTest::forEach;
            this.payloads.forEachWith = ConcurrentMutableHashMapTest::forEachWith;
            this.payloads.forEachWithIndex = ConcurrentMutableHashMapTest::forEachWithIndex;
            this.payloads.forEachKey = ConcurrentMutableHashMapTest::forEachKey;
            this.payloads.forEachValue = ConcurrentMutableHashMapTest::forEachValue;
            this.payloads.forEachKeyValue = ConcurrentMutableHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ConcurrentMutableHashMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ConcurrentMutableHashMapTest::flipUniqueValues;
            this.payloads.collectMap = ConcurrentMutableHashMapTest::collectMap;
            this.payloads.collectBoolean = ConcurrentMutableHashMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ConcurrentMutableHashMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = ConcurrentMutableHashMapTest::collectByte;
            this.payloads.collectByteWithTarget = ConcurrentMutableHashMapTest::collectByteWithTarget;
            this.payloads.collectChar = ConcurrentMutableHashMapTest::collectChar;
            this.payloads.collectCharWithTarget = ConcurrentMutableHashMapTest::collectCharWithTarget;
            this.payloads.collectDouble = ConcurrentMutableHashMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ConcurrentMutableHashMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ConcurrentMutableHashMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = ConcurrentMutableHashMapTest::collectFloatWithTarget;
            this.payloads.collectInt = ConcurrentMutableHashMapTest::collectInt;
            this.payloads.collectIntWithTarget = ConcurrentMutableHashMapTest::collectIntWithTarget;
            this.payloads.collectLong = ConcurrentMutableHashMapTest::collectLong;
            this.payloads.collectLongWithTarget = ConcurrentMutableHashMapTest::collectLongWithTarget;
            this.payloads.collectShort = ConcurrentMutableHashMapTest::collectShort;
            this.payloads.collectShortWithTarget = ConcurrentMutableHashMapTest::collectShortWithTarget;
            this.payloads.collectValues = ConcurrentMutableHashMapTest::collectValues;
            this.payloads.select = ConcurrentMutableHashMapTest::select;
            this.payloads.selectWith = ConcurrentMutableHashMapTest::selectWith;
            this.payloads.reject = ConcurrentMutableHashMapTest::reject;
            this.payloads.rejectWith = ConcurrentMutableHashMapTest::rejectWith;
            this.payloads.collect = ConcurrentMutableHashMapTest::collect;
            this.payloads.flatCollect = ConcurrentMutableHashMapTest::flatCollect;
            this.payloads.flatCollectWith = ConcurrentMutableHashMapTest::flatCollectWith;
            this.payloads.selectMap = ConcurrentMutableHashMapTest::selectMap;
            this.payloads.rejectMap = ConcurrentMutableHashMapTest::rejectMap;
            this.payloads.flip = ConcurrentMutableHashMapTest::flip;
            this.payloads.detect = ConcurrentMutableHashMapTest::detect;
            this.payloads.detectOptional = ConcurrentMutableHashMapTest::detectOptional;
            this.payloads.anySatisfy = ConcurrentMutableHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ConcurrentMutableHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ConcurrentMutableHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ConcurrentMutableHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ConcurrentMutableHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ConcurrentMutableHashMapTest::noneSatisfyWith;
            this.payloads.appendString = ConcurrentMutableHashMapTest::appendString;
            this.payloads.toBag = ConcurrentMutableHashMapTest::toBag;
            this.payloads.toSortedBag = ConcurrentMutableHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ConcurrentMutableHashMapTest::toSortedBagBy;
            this.payloads.asLazy = ConcurrentMutableHashMapTest::asLazy;
            this.payloads.toList = ConcurrentMutableHashMapTest::toList;
            this.payloads.toMap = ConcurrentMutableHashMapTest::toMap;
            this.payloads.toSet = ConcurrentMutableHashMapTest::toSet;
            this.payloads.toSortedList = ConcurrentMutableHashMapTest::toSortedList;
            this.payloads.toSortedListBy = ConcurrentMutableHashMapTest::toSortedListBy;
            this.payloads.toSortedSet = ConcurrentMutableHashMapTest::toSortedSet;
            this.payloads.toSortedSetBy = ConcurrentMutableHashMapTest::toSortedSetBy;
            this.payloads.toSortedMap = ConcurrentMutableHashMapTest::toSortedMap;
            this.payloads.chunk = ConcurrentMutableHashMapTest::chunk;
            this.payloads.collect_value = ConcurrentMutableHashMapTest::collect_value;
            this.payloads.collectIf = ConcurrentMutableHashMapTest::collectIf;
            this.payloads.collectWith = ConcurrentMutableHashMapTest::collectWith;
            this.payloads.collectWithToTarget = ConcurrentMutableHashMapTest::collectWithToTarget;
            this.payloads.contains = ConcurrentMutableHashMapTest::contains;
            this.payloads.containsAnyIterable = ConcurrentMutableHashMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ConcurrentMutableHashMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ConcurrentMutableHashMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ConcurrentMutableHashMapTest::containsNoneCollection;
            this.payloads.containsAll = ConcurrentMutableHashMapTest::containsAll;
            this.payloads.containsKey = ConcurrentMutableHashMapTest::containsKey;
            this.payloads.containsValue = ConcurrentMutableHashMapTest::containsValue;
            this.payloads.getFirst = ConcurrentMutableHashMapTest::getFirst;
            this.payloads.getLast = ConcurrentMutableHashMapTest::getLast;
            this.payloads.getOnly = ConcurrentMutableHashMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentMutableHashMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentMutableHashMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ConcurrentMutableHashMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ConcurrentMutableHashMapTest::containsAllArguments;
            this.payloads.count = ConcurrentMutableHashMapTest::count;
            this.payloads.countWith = ConcurrentMutableHashMapTest::countWith;
            this.payloads.detect_value = ConcurrentMutableHashMapTest::detect_value;
            this.payloads.detectOptional_value = ConcurrentMutableHashMapTest::detectOptional_value;
            this.payloads.detectWith = ConcurrentMutableHashMapTest::detectWith;
            this.payloads.detectWithOptional = ConcurrentMutableHashMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = ConcurrentMutableHashMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = ConcurrentMutableHashMapTest::detectWithIfNone;
            this.payloads.flatten_value = ConcurrentMutableHashMapTest::flatten_value;
            this.payloads.countBy = ConcurrentMutableHashMapTest::countBy;
            this.payloads.countByWith = ConcurrentMutableHashMapTest::countByWith;
            this.payloads.countByEach = ConcurrentMutableHashMapTest::countByEach;
            this.payloads.groupBy = ConcurrentMutableHashMapTest::groupBy;
            this.payloads.groupByEach = ConcurrentMutableHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ConcurrentMutableHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentMutableHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ConcurrentMutableHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ConcurrentMutableHashMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ConcurrentMutableHashMapTest::injectInto;
            this.payloads.injectIntoInt = ConcurrentMutableHashMapTest::injectIntoInt;
            this.payloads.injectIntoLong = ConcurrentMutableHashMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = ConcurrentMutableHashMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = ConcurrentMutableHashMapTest::injectIntoDouble;
            this.payloads.sumOfInt = ConcurrentMutableHashMapTest::sumOfInt;
            this.payloads.sumOfLong = ConcurrentMutableHashMapTest::sumOfLong;
            this.payloads.testAggregateBy = ConcurrentMutableHashMapTest::testAggregateBy;
            this.payloads.sumOfFloat = ConcurrentMutableHashMapTest::sumOfFloat;
            this.payloads.sumOfDouble = ConcurrentMutableHashMapTest::sumOfDouble;
            this.payloads.sumByInt = ConcurrentMutableHashMapTest::sumByInt;
            this.payloads.sumByFloat = ConcurrentMutableHashMapTest::sumByFloat;
            this.payloads.sumByLong = ConcurrentMutableHashMapTest::sumByLong;
            this.payloads.sumByDouble = ConcurrentMutableHashMapTest::sumByDouble;
            this.payloads.makeString = ConcurrentMutableHashMapTest::makeString;
            this.payloads.min = ConcurrentMutableHashMapTest::min;
            this.payloads.max = ConcurrentMutableHashMapTest::max;
            this.payloads.minBy = ConcurrentMutableHashMapTest::minBy;
            this.payloads.maxBy = ConcurrentMutableHashMapTest::maxBy;
            this.payloads.reject_value = ConcurrentMutableHashMapTest::reject_value;
            this.payloads.rejectWith_value = ConcurrentMutableHashMapTest::rejectWith_value;
            this.payloads.select_value = ConcurrentMutableHashMapTest::select_value;
            this.payloads.selectWith_value = ConcurrentMutableHashMapTest::selectWith_value;
            this.payloads.selectInstancesOf_value = ConcurrentMutableHashMapTest::selectInstancesOf_value;
            this.payloads.toArray = ConcurrentMutableHashMapTest::toArray;
            this.payloads.zip = ConcurrentMutableHashMapTest::zip;
            this.payloads.zipWithIndex = ConcurrentMutableHashMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = ConcurrentMutableHashMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ConcurrentMutableHashMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = ConcurrentMutableHashMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ConcurrentMutableHashMapTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ConcurrentMutableHashMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = ConcurrentMutableHashMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ConcurrentMutableHashMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = ConcurrentMutableHashMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ConcurrentMutableHashMapTest::newMapWithWithWithWith;
            this.payloads.iterator = ConcurrentMutableHashMapTest::iterator;
            this.payloads.keysView = ConcurrentMutableHashMapTest::keysView;
            this.payloads.valuesView = ConcurrentMutableHashMapTest::valuesView;
            this.payloads.test_toString = ConcurrentMutableHashMapTest::test_toString;
            this.payloads.toImmutable = ConcurrentMutableHashMapTest::toImmutable;
            this.payloads.clear = ConcurrentMutableHashMapTest::clear;
            this.payloads.removeObject = ConcurrentMutableHashMapTest::removeObject;
            this.payloads.retainAllFromEntrySet = ConcurrentMutableHashMapTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = ConcurrentMutableHashMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = ConcurrentMutableHashMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = ConcurrentMutableHashMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ConcurrentMutableHashMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ConcurrentMutableHashMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ConcurrentMutableHashMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ConcurrentMutableHashMapTest::clearKeySet;
            this.payloads.keySetToArray = ConcurrentMutableHashMapTest::keySetToArray;
            this.payloads.removeFromValues = ConcurrentMutableHashMapTest::removeFromValues;
            this.payloads.removeNullFromValues = ConcurrentMutableHashMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = ConcurrentMutableHashMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = ConcurrentMutableHashMapTest::retainAllFromValues;
            this.payloads.put = ConcurrentMutableHashMapTest::put;
            this.payloads.putAll = ConcurrentMutableHashMapTest::putAll;
            this.payloads.removeKey = ConcurrentMutableHashMapTest::removeKey;
            this.payloads.removeAllKeys = ConcurrentMutableHashMapTest::removeAllKeys;
            this.payloads.removeIf = ConcurrentMutableHashMapTest::removeIf;
            this.payloads.getIfAbsentPut = ConcurrentMutableHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = ConcurrentMutableHashMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = ConcurrentMutableHashMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = ConcurrentMutableHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = ConcurrentMutableHashMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = ConcurrentMutableHashMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = ConcurrentMutableHashMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = ConcurrentMutableHashMapTest::newEmpty;
            this.payloads.keysAndValues_toString = ConcurrentMutableHashMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = ConcurrentMutableHashMapTest::keyPreservation;
            this.payloads.asUnmodifiable = ConcurrentMutableHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = ConcurrentMutableHashMapTest::asSynchronized;
            this.payloads.add = ConcurrentMutableHashMapTest::add;
            this.payloads.putPair = ConcurrentMutableHashMapTest::putPair;
            this.payloads.withKeyValue = ConcurrentMutableHashMapTest::withKeyValue;
            this.payloads.withMap = ConcurrentMutableHashMapTest::withMap;
            this.payloads.withMapEmpty = ConcurrentMutableHashMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = ConcurrentMutableHashMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = ConcurrentMutableHashMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ConcurrentMutableHashMapTest::withMapNull;
            this.payloads.withMapIterable = ConcurrentMutableHashMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = ConcurrentMutableHashMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = ConcurrentMutableHashMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ConcurrentMutableHashMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ConcurrentMutableHashMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = ConcurrentMutableHashMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = ConcurrentMutableHashMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = ConcurrentMutableHashMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = ConcurrentMutableHashMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = ConcurrentMutableHashMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = ConcurrentMutableHashMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = ConcurrentMutableHashMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = ConcurrentMutableHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ConcurrentMutableHashMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = ConcurrentMutableHashMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = ConcurrentMutableHashMapTest::rehash_null_collision;
            this.payloads.collectKeysAndValues = ConcurrentMutableHashMapTest::collectKeysAndValues;
            this.payloads.testClone = ConcurrentMutableHashMapTest::testClone;
            this.payloads.updateValue = ConcurrentMutableHashMapTest::updateValue;
            this.payloads.updateValue_collisions = ConcurrentMutableHashMapTest::updateValue_collisions;
            this.payloads.updateValueWith = ConcurrentMutableHashMapTest::updateValueWith;
            this.payloads.updateValueWith_collisions = ConcurrentMutableHashMapTest::updateValueWith_collisions;
            this.payloads.putIfAbsent = ConcurrentMutableHashMapTest::putIfAbsent;
            this.payloads.replace = ConcurrentMutableHashMapTest::replace;
            this.payloads.replaceWithOldValue = ConcurrentMutableHashMapTest::replaceWithOldValue;
            this.payloads.removeWithKeyValue = ConcurrentMutableHashMapTest::removeWithKeyValue;
            this.payloads.removeFromEntrySet = ConcurrentMutableHashMapTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = ConcurrentMutableHashMapTest::removeAllFromEntrySet;
            this.payloads.keySetEqualsAndHashCode = ConcurrentMutableHashMapTest::keySetEqualsAndHashCode;
            this.payloads.partition_value = ConcurrentMutableHashMapTest::partition_value;
            this.payloads.partitionWith_value = ConcurrentMutableHashMapTest::partitionWith_value;
        }
    }
}
