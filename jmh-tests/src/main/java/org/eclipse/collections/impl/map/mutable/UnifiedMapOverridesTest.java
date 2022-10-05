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

import java.util.Map;
import org.eclipse.collections.api.map.MutableMap;

public class UnifiedMapOverridesTest extends UnifiedMapTest {

    public static class UnifiedMapOverrides<K, V> extends UnifiedMap<K, V> {

        public UnifiedMapOverrides() {
        }

        public UnifiedMapOverrides(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }

        public UnifiedMapOverrides(Map<? extends K, ? extends V> map) {
            super(map);
        }

        @Override
        protected int index(Object key) {
            int h = key == null ? 0 : key.hashCode();
            return (h & (this.table.length >> 1) - 1) << 1;
        }

        @Override
        public UnifiedMapOverrides<K, V> clone() {
            return new UnifiedMapOverrides<>(this);
        }

        @Override
        public UnifiedMapOverrides<K, V> newEmpty() {
            return new UnifiedMapOverrides<>();
        }

        @Override
        public UnifiedMapOverrides<K, V> newEmpty(int capacity) {
            return new UnifiedMapOverrides<>(capacity, this.loadFactor);
        }
    }

    @Override
    public <K, V> UnifiedMapOverrides<K, V> newMap() {
        return new UnifiedMapOverrides<>();
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value) {
        UnifiedMap<K, V> map = this.newMap();
        return map.withKeysValues(key, value);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        UnifiedMap<K, V> map = this.newMap();
        return map.withKeysValues(key1, value1, key2, value2);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        UnifiedMap<K, V> map = this.newMap();
        return map.withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        UnifiedMap<K, V> map = this.newMap();
        return map.withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedMapOverridesTest instance;

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
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
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
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_WithEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_WithEmptyTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withPreSizedTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_toArray_withSmallTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_toArray_withSmallTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_ToArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_ToArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noInstanceOfEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noInstanceOfEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_hashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_hashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_copyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_copyKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withEmptyTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withPreSizedTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withLargeTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_PostSerializedEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_key_and_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_key_and_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValueWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValueWithCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithWithCollisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_Iterator_incrementPastEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_Iterator_incrementPastEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator_removeBeforeIncrement() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator_removeBeforeIncrement);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_Iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_Iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_many_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_many_collisions);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_hashCodeForNullKeyAndValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_hashCodeForNullKeyAndValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equalsWithNonEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equalsWithNonEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_Iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_equals);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapTest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfIterableOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfIterableOfPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unifiedMapProperSuperSetOfHashMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unifiedMapProperSuperSetOfHashMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_chains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_null_handling);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_emptySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_chains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_null_handling);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_emptySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getMapMemoryUsedInWords() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getMapMemoryUsedInWords);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCollidingBuckets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCollidingBuckets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_block_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_block_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
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
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedMapOverridesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_toArray_WithEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_toArray_withSmallTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_ToArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> noInstanceOfEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_hashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_copyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_toArray_withEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_PostSerializedEquality;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_PostSerializedEquality_chainedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> contains_key_and_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPutValueWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPutWithWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_Iterator_incrementPastEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> keySet_Iterator_removeBeforeIncrement;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_Iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> iterator_many_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entry_setValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entry_hashCodeForNullKeyAndValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entry_equalsWithNonEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> entrySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valuesCollection_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valueCollection_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> valueCollection_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> frequentCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> newMap_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> newMapTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> constructorOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> constructorOfIterableOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> unifiedMapProperSuperSetOfHashMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchForEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchForEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchForEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchForEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchForEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchForEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchIterable_forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchIterable_forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchIterable_forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchIterable_forEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchIterable_forEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchIterable_forEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> batchIterable_forEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getMapMemoryUsedInWords;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getCollidingBuckets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapOverridesTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = UnifiedMapOverridesTest::stream;
            this.payloads.parallelStream = UnifiedMapOverridesTest::parallelStream;
            this.payloads.serialization = UnifiedMapOverridesTest::serialization;
            this.payloads.isEmpty = UnifiedMapOverridesTest::isEmpty;
            this.payloads.notEmpty = UnifiedMapOverridesTest::notEmpty;
            this.payloads.ifPresentApply = UnifiedMapOverridesTest::ifPresentApply;
            this.payloads.getIfAbsent_function = UnifiedMapOverridesTest::getIfAbsent_function;
            this.payloads.getOrDefault = UnifiedMapOverridesTest::getOrDefault;
            this.payloads.getIfAbsent = UnifiedMapOverridesTest::getIfAbsent;
            this.payloads.getIfAbsentWith = UnifiedMapOverridesTest::getIfAbsentWith;
            this.payloads.tap = UnifiedMapOverridesTest::tap;
            this.payloads.forEach = UnifiedMapOverridesTest::forEach;
            this.payloads.forEachKeyValue = UnifiedMapOverridesTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnifiedMapOverridesTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = UnifiedMapOverridesTest::flipUniqueValues;
            this.payloads.collectMap = UnifiedMapOverridesTest::collectMap;
            this.payloads.collectBoolean = UnifiedMapOverridesTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedMapOverridesTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnifiedMapOverridesTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedMapOverridesTest::collectByteWithTarget;
            this.payloads.collectChar = UnifiedMapOverridesTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedMapOverridesTest::collectCharWithTarget;
            this.payloads.collectDouble = UnifiedMapOverridesTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedMapOverridesTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnifiedMapOverridesTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedMapOverridesTest::collectFloatWithTarget;
            this.payloads.collectInt = UnifiedMapOverridesTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedMapOverridesTest::collectIntWithTarget;
            this.payloads.collectLong = UnifiedMapOverridesTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedMapOverridesTest::collectLongWithTarget;
            this.payloads.collectShort = UnifiedMapOverridesTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedMapOverridesTest::collectShortWithTarget;
            this.payloads.select = UnifiedMapOverridesTest::select;
            this.payloads.selectWith = UnifiedMapOverridesTest::selectWith;
            this.payloads.reject = UnifiedMapOverridesTest::reject;
            this.payloads.rejectWith = UnifiedMapOverridesTest::rejectWith;
            this.payloads.collect = UnifiedMapOverridesTest::collect;
            this.payloads.flatCollect = UnifiedMapOverridesTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedMapOverridesTest::flatCollectWith;
            this.payloads.selectMap = UnifiedMapOverridesTest::selectMap;
            this.payloads.rejectMap = UnifiedMapOverridesTest::rejectMap;
            this.payloads.flip = UnifiedMapOverridesTest::flip;
            this.payloads.appendString = UnifiedMapOverridesTest::appendString;
            this.payloads.toBag = UnifiedMapOverridesTest::toBag;
            this.payloads.toSortedBag = UnifiedMapOverridesTest::toSortedBag;
            this.payloads.toSortedBagBy = UnifiedMapOverridesTest::toSortedBagBy;
            this.payloads.asLazy = UnifiedMapOverridesTest::asLazy;
            this.payloads.toList = UnifiedMapOverridesTest::toList;
            this.payloads.toMap = UnifiedMapOverridesTest::toMap;
            this.payloads.toSet = UnifiedMapOverridesTest::toSet;
            this.payloads.toSortedList = UnifiedMapOverridesTest::toSortedList;
            this.payloads.toSortedListBy = UnifiedMapOverridesTest::toSortedListBy;
            this.payloads.toSortedSet = UnifiedMapOverridesTest::toSortedSet;
            this.payloads.toSortedSetBy = UnifiedMapOverridesTest::toSortedSetBy;
            this.payloads.toSortedMap = UnifiedMapOverridesTest::toSortedMap;
            this.payloads.chunk = UnifiedMapOverridesTest::chunk;
            this.payloads.collect_value = UnifiedMapOverridesTest::collect_value;
            this.payloads.collectIf = UnifiedMapOverridesTest::collectIf;
            this.payloads.collectWith = UnifiedMapOverridesTest::collectWith;
            this.payloads.collectWithToTarget = UnifiedMapOverridesTest::collectWithToTarget;
            this.payloads.contains = UnifiedMapOverridesTest::contains;
            this.payloads.containsAnyIterable = UnifiedMapOverridesTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedMapOverridesTest::containsNoneIterable;
            this.payloads.containsAnyCollection = UnifiedMapOverridesTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedMapOverridesTest::containsNoneCollection;
            this.payloads.containsAll = UnifiedMapOverridesTest::containsAll;
            this.payloads.containsKey = UnifiedMapOverridesTest::containsKey;
            this.payloads.containsValue = UnifiedMapOverridesTest::containsValue;
            this.payloads.getFirst = UnifiedMapOverridesTest::getFirst;
            this.payloads.getLast = UnifiedMapOverridesTest::getLast;
            this.payloads.getOnly = UnifiedMapOverridesTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnifiedMapOverridesTest::containsAllIterable;
            this.payloads.containsAllArguments = UnifiedMapOverridesTest::containsAllArguments;
            this.payloads.count = UnifiedMapOverridesTest::count;
            this.payloads.countWith = UnifiedMapOverridesTest::countWith;
            this.payloads.flatten_value = UnifiedMapOverridesTest::flatten_value;
            this.payloads.countBy = UnifiedMapOverridesTest::countBy;
            this.payloads.countByWith = UnifiedMapOverridesTest::countByWith;
            this.payloads.countByEach = UnifiedMapOverridesTest::countByEach;
            this.payloads.groupBy = UnifiedMapOverridesTest::groupBy;
            this.payloads.groupByEach = UnifiedMapOverridesTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedMapOverridesTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedMapOverridesTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = UnifiedMapOverridesTest::injectInto;
            this.payloads.injectIntoInt = UnifiedMapOverridesTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedMapOverridesTest::injectIntoLong;
            this.payloads.injectIntoFloat = UnifiedMapOverridesTest::injectIntoFloat;
            this.payloads.injectIntoDouble = UnifiedMapOverridesTest::injectIntoDouble;
            this.payloads.sumOfInt = UnifiedMapOverridesTest::sumOfInt;
            this.payloads.sumOfLong = UnifiedMapOverridesTest::sumOfLong;
            this.payloads.testAggregateBy = UnifiedMapOverridesTest::testAggregateBy;
            this.payloads.sumOfFloat = UnifiedMapOverridesTest::sumOfFloat;
            this.payloads.sumOfDouble = UnifiedMapOverridesTest::sumOfDouble;
            this.payloads.sumByInt = UnifiedMapOverridesTest::sumByInt;
            this.payloads.sumByFloat = UnifiedMapOverridesTest::sumByFloat;
            this.payloads.sumByLong = UnifiedMapOverridesTest::sumByLong;
            this.payloads.sumByDouble = UnifiedMapOverridesTest::sumByDouble;
            this.payloads.makeString = UnifiedMapOverridesTest::makeString;
            this.payloads.min = UnifiedMapOverridesTest::min;
            this.payloads.max = UnifiedMapOverridesTest::max;
            this.payloads.minBy = UnifiedMapOverridesTest::minBy;
            this.payloads.maxBy = UnifiedMapOverridesTest::maxBy;
            this.payloads.reject_value = UnifiedMapOverridesTest::reject_value;
            this.payloads.rejectWith_value = UnifiedMapOverridesTest::rejectWith_value;
            this.payloads.select_value = UnifiedMapOverridesTest::select_value;
            this.payloads.selectWith_value = UnifiedMapOverridesTest::selectWith_value;
            this.payloads.partition_value = UnifiedMapOverridesTest::partition_value;
            this.payloads.partitionWith_value = UnifiedMapOverridesTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = UnifiedMapOverridesTest::selectInstancesOf_value;
            this.payloads.toArray = UnifiedMapOverridesTest::toArray;
            this.payloads.zip = UnifiedMapOverridesTest::zip;
            this.payloads.zipWithIndex = UnifiedMapOverridesTest::zipWithIndex;
            this.payloads.aggregateByMutating = UnifiedMapOverridesTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedMapOverridesTest::aggregateByNonMutating;
            this.payloads.keyValuesView = UnifiedMapOverridesTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = UnifiedMapOverridesTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = UnifiedMapOverridesTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = UnifiedMapOverridesTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = UnifiedMapOverridesTest::newMapWithWith;
            this.payloads.newMapWithWithWith = UnifiedMapOverridesTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = UnifiedMapOverridesTest::newMapWithWithWithWith;
            this.payloads.iterator = UnifiedMapOverridesTest::iterator;
            this.payloads.keysView = UnifiedMapOverridesTest::keysView;
            this.payloads.valuesView = UnifiedMapOverridesTest::valuesView;
            this.payloads.test_toString = UnifiedMapOverridesTest::test_toString;
            this.payloads.toImmutable = UnifiedMapOverridesTest::toImmutable;
            this.payloads.clear = UnifiedMapOverridesTest::clear;
            this.payloads.removeObject = UnifiedMapOverridesTest::removeObject;
            this.payloads.removeAllFromEntrySet = UnifiedMapOverridesTest::removeAllFromEntrySet;
            this.payloads.clearEntrySet = UnifiedMapOverridesTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = UnifiedMapOverridesTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = UnifiedMapOverridesTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = UnifiedMapOverridesTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = UnifiedMapOverridesTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = UnifiedMapOverridesTest::retainAllFromKeySet;
            this.payloads.clearKeySet = UnifiedMapOverridesTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = UnifiedMapOverridesTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = UnifiedMapOverridesTest::keySetToArray;
            this.payloads.removeFromValues = UnifiedMapOverridesTest::removeFromValues;
            this.payloads.removeNullFromValues = UnifiedMapOverridesTest::removeNullFromValues;
            this.payloads.removeAllFromValues = UnifiedMapOverridesTest::removeAllFromValues;
            this.payloads.retainAllFromValues = UnifiedMapOverridesTest::retainAllFromValues;
            this.payloads.putAll = UnifiedMapOverridesTest::putAll;
            this.payloads.removeKey = UnifiedMapOverridesTest::removeKey;
            this.payloads.removeAllKeys = UnifiedMapOverridesTest::removeAllKeys;
            this.payloads.removeIf = UnifiedMapOverridesTest::removeIf;
            this.payloads.getIfAbsentPutValue = UnifiedMapOverridesTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = UnifiedMapOverridesTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = UnifiedMapOverridesTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWith_block_throws = UnifiedMapOverridesTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = UnifiedMapOverridesTest::getKeysAndGetValues;
            this.payloads.newEmpty = UnifiedMapOverridesTest::newEmpty;
            this.payloads.keysAndValues_toString = UnifiedMapOverridesTest::keysAndValues_toString;
            this.payloads.keyPreservation = UnifiedMapOverridesTest::keyPreservation;
            this.payloads.asUnmodifiable = UnifiedMapOverridesTest::asUnmodifiable;
            this.payloads.asSynchronized = UnifiedMapOverridesTest::asSynchronized;
            this.payloads.add = UnifiedMapOverridesTest::add;
            this.payloads.putPair = UnifiedMapOverridesTest::putPair;
            this.payloads.withKeyValue = UnifiedMapOverridesTest::withKeyValue;
            this.payloads.withMap = UnifiedMapOverridesTest::withMap;
            this.payloads.withMapEmpty = UnifiedMapOverridesTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = UnifiedMapOverridesTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = UnifiedMapOverridesTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = UnifiedMapOverridesTest::withMapNull;
            this.payloads.withMapIterable = UnifiedMapOverridesTest::withMapIterable;
            this.payloads.withMapIterableEmpty = UnifiedMapOverridesTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = UnifiedMapOverridesTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = UnifiedMapOverridesTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = UnifiedMapOverridesTest::withMapIterableNull;
            this.payloads.putAllMapIterable = UnifiedMapOverridesTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = UnifiedMapOverridesTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = UnifiedMapOverridesTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = UnifiedMapOverridesTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = UnifiedMapOverridesTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = UnifiedMapOverridesTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = UnifiedMapOverridesTest::withAllKeyValueArguments;
            this.payloads.withoutKey = UnifiedMapOverridesTest::withoutKey;
            this.payloads.withoutAllKeys = UnifiedMapOverridesTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = UnifiedMapOverridesTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnifiedMapOverridesTest::rehash_null_collision;
            this.payloads.updateValue = UnifiedMapOverridesTest::updateValue;
            this.payloads.updateValue_collisions = UnifiedMapOverridesTest::updateValue_collisions;
            this.payloads.updateValueWith = UnifiedMapOverridesTest::updateValueWith;
            this.payloads.updateValueWith_collisions = UnifiedMapOverridesTest::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = UnifiedMapOverridesTest::collectKeysAndValues;
            this.payloads.testClone = UnifiedMapOverridesTest::testClone;
            this.payloads.valuesCollection_toArray = UnifiedMapOverridesTest::valuesCollection_toArray;
            this.payloads.valuesCollection_toArray_WithEmptyTarget = UnifiedMapOverridesTest::valuesCollection_toArray_WithEmptyTarget;
            this.payloads.valuesCollection_toArray_withPreSizedTarget = UnifiedMapOverridesTest::valuesCollection_toArray_withPreSizedTarget;
            this.payloads.valuesCollection_toArray_withLargeTarget = UnifiedMapOverridesTest::valuesCollection_toArray_withLargeTarget;
            this.payloads.entrySet_clear = UnifiedMapOverridesTest::entrySet_clear;
            this.payloads.valuesCollection_clear = UnifiedMapOverridesTest::valuesCollection_clear;
            this.payloads.keySet_toArray_withSmallTarget = UnifiedMapOverridesTest::keySet_toArray_withSmallTarget;
            this.payloads.keySet_ToArray_withLargeTarget = UnifiedMapOverridesTest::keySet_ToArray_withLargeTarget;
            this.payloads.noInstanceOfEquals = UnifiedMapOverridesTest::noInstanceOfEquals;
            this.payloads.keySet_hashCode = UnifiedMapOverridesTest::keySet_hashCode;
            this.payloads.keySet_copyKeys = UnifiedMapOverridesTest::keySet_copyKeys;
            this.payloads.entrySet_toArray = UnifiedMapOverridesTest::entrySet_toArray;
            this.payloads.entrySet_toArray_withEmptyTarget = UnifiedMapOverridesTest::entrySet_toArray_withEmptyTarget;
            this.payloads.entrySet_toArray_withPreSizedTarget = UnifiedMapOverridesTest::entrySet_toArray_withPreSizedTarget;
            this.payloads.entrySet_toArray_withLargeTarget = UnifiedMapOverridesTest::entrySet_toArray_withLargeTarget;
            this.payloads.entrySet_PostSerializedEqualsAndHashCode = UnifiedMapOverridesTest::entrySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode = UnifiedMapOverridesTest::keySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot = UnifiedMapOverridesTest::keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;
            this.payloads.valuesCollection_PostSerializedEquality = UnifiedMapOverridesTest::valuesCollection_PostSerializedEquality;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMap = UnifiedMapOverridesTest::valuesCollection_PostSerializedEquality_chainedMap;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot = UnifiedMapOverridesTest::valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;
            this.payloads.contains_key_and_value = UnifiedMapOverridesTest::contains_key_and_value;
            this.payloads.remove = UnifiedMapOverridesTest::remove;
            this.payloads.getIfAbsentPutValueWithCollisions = UnifiedMapOverridesTest::getIfAbsentPutValueWithCollisions;
            this.payloads.getIfAbsentPutWithWithCollisions = UnifiedMapOverridesTest::getIfAbsentPutWithWithCollisions;
            this.payloads.removeFromEntrySet = UnifiedMapOverridesTest::removeFromEntrySet;
            this.payloads.retainAllFromEntrySet = UnifiedMapOverridesTest::retainAllFromEntrySet;
            this.payloads.forEachWith = UnifiedMapOverridesTest::forEachWith;
            this.payloads.keySet_retainAll = UnifiedMapOverridesTest::keySet_retainAll;
            this.payloads.keySet_containsAll = UnifiedMapOverridesTest::keySet_containsAll;
            this.payloads.keySet_equals = UnifiedMapOverridesTest::keySet_equals;
            this.payloads.keySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::keySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::keySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::keySet_Iterator, java.util.NoSuchElementException.class);
            this.payloads.entrySet_Iterator_incrementPastEnd = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::entrySet_Iterator_incrementPastEnd, java.util.NoSuchElementException.class);
            this.payloads.keySet_Iterator_removeBeforeIncrement = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::keySet_Iterator_removeBeforeIncrement, java.lang.IllegalStateException.class);
            this.payloads.valuesCollection_Iterator_remove = UnifiedMapOverridesTest::valuesCollection_Iterator_remove;
            this.payloads.iterator_many_collisions = UnifiedMapOverridesTest::iterator_many_collisions;
            this.payloads.entry_setValue = UnifiedMapOverridesTest::entry_setValue;
            this.payloads.entry_hashCodeForNullKeyAndValue = UnifiedMapOverridesTest::entry_hashCodeForNullKeyAndValue;
            this.payloads.entry_equalsWithNonEntry = UnifiedMapOverridesTest::entry_equalsWithNonEntry;
            this.payloads.entrySet_remove = UnifiedMapOverridesTest::entrySet_remove;
            this.payloads.entrySet_contains = UnifiedMapOverridesTest::entrySet_contains;
            this.payloads.entrySet_containsAll = UnifiedMapOverridesTest::entrySet_containsAll;
            this.payloads.entrySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::entrySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::entrySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_equals = UnifiedMapOverridesTest::entrySet_equals;
            this.payloads.valuesCollection_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::valuesCollection_add, java.lang.UnsupportedOperationException.class);
            this.payloads.valuesCollection_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::valuesCollection_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.valueCollection_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapOverridesTest::valueCollection_Iterator, java.util.NoSuchElementException.class);
            this.payloads.valueCollection_equals = UnifiedMapOverridesTest::valueCollection_equals;
            this.payloads.forEachWithIndex = UnifiedMapOverridesTest::forEachWithIndex;
            this.payloads.forEachKey = UnifiedMapOverridesTest::forEachKey;
            this.payloads.forEachValue = UnifiedMapOverridesTest::forEachValue;
            this.payloads.equalsAndHashCode = UnifiedMapOverridesTest::equalsAndHashCode;
            this.payloads.frequentCollision = UnifiedMapOverridesTest::frequentCollision;
            this.payloads.newMap_throws = UnifiedMapOverridesTest::newMap_throws;
            this.payloads.newMapTest = UnifiedMapOverridesTest::newMapTest;
            this.payloads.constructorOfPairs = UnifiedMapOverridesTest::constructorOfPairs;
            this.payloads.constructorOfIterableOfPairs = UnifiedMapOverridesTest::constructorOfIterableOfPairs;
            this.payloads.unifiedMapProperSuperSetOfHashMap = UnifiedMapOverridesTest::unifiedMapProperSuperSetOfHashMap;
            this.payloads.batchForEach = UnifiedMapOverridesTest::batchForEach;
            this.payloads.batchForEachKey = UnifiedMapOverridesTest::batchForEachKey;
            this.payloads.batchForEachValue = UnifiedMapOverridesTest::batchForEachValue;
            this.payloads.batchForEachEntry = UnifiedMapOverridesTest::batchForEachEntry;
            this.payloads.batchForEachEntry_chains = UnifiedMapOverridesTest::batchForEachEntry_chains;
            this.payloads.batchForEachEntry_null_handling = UnifiedMapOverridesTest::batchForEachEntry_null_handling;
            this.payloads.batchForEachEntry_emptySet = UnifiedMapOverridesTest::batchForEachEntry_emptySet;
            this.payloads.batchIterable_forEach = UnifiedMapOverridesTest::batchIterable_forEach;
            this.payloads.batchIterable_forEachKey = UnifiedMapOverridesTest::batchIterable_forEachKey;
            this.payloads.batchIterable_forEachValue = UnifiedMapOverridesTest::batchIterable_forEachValue;
            this.payloads.batchIterable_forEachEntry = UnifiedMapOverridesTest::batchIterable_forEachEntry;
            this.payloads.batchIterable_forEachEntry_chains = UnifiedMapOverridesTest::batchIterable_forEachEntry_chains;
            this.payloads.batchIterable_forEachEntry_null_handling = UnifiedMapOverridesTest::batchIterable_forEachEntry_null_handling;
            this.payloads.batchIterable_forEachEntry_emptySet = UnifiedMapOverridesTest::batchIterable_forEachEntry_emptySet;
            this.payloads.getMapMemoryUsedInWords = UnifiedMapOverridesTest::getMapMemoryUsedInWords;
            this.payloads.getCollidingBuckets = UnifiedMapOverridesTest::getCollidingBuckets;
            this.payloads.getIfAbsentPut = UnifiedMapOverridesTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_block_throws = UnifiedMapOverridesTest::getIfAbsentPut_block_throws;
            this.payloads.put = UnifiedMapOverridesTest::put;
            this.payloads.collectValues = UnifiedMapOverridesTest::collectValues;
            this.payloads.detect = UnifiedMapOverridesTest::detect;
            this.payloads.detectOptional = UnifiedMapOverridesTest::detectOptional;
            this.payloads.detect_value = UnifiedMapOverridesTest::detect_value;
            this.payloads.detectOptional_value = UnifiedMapOverridesTest::detectOptional_value;
            this.payloads.detectWith = UnifiedMapOverridesTest::detectWith;
            this.payloads.detectWithOptional = UnifiedMapOverridesTest::detectWithOptional;
            this.payloads.detectIfNone_value = UnifiedMapOverridesTest::detectIfNone_value;
            this.payloads.detectWithIfNone = UnifiedMapOverridesTest::detectWithIfNone;
            this.payloads.anySatisfy = UnifiedMapOverridesTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedMapOverridesTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedMapOverridesTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedMapOverridesTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedMapOverridesTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedMapOverridesTest::noneSatisfyWith;
            this.payloads.trimToSize = UnifiedMapOverridesTest::trimToSize;
        }
    }
}
