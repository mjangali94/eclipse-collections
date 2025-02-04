/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.strategy.mutable;

import java.util.Map;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

public class UnifiedMapWithHashingStrategyOverridesTest extends UnifiedMapWithHashingStrategyTest {

    public static class UnifiedMapWithHashingStrategyOverrides<K, V> extends UnifiedMapWithHashingStrategy<K, V> {

        public UnifiedMapWithHashingStrategyOverrides() {
        }

        public UnifiedMapWithHashingStrategyOverrides(HashingStrategy<? super K> strategy) {
            super(strategy);
        }

        public UnifiedMapWithHashingStrategyOverrides(HashingStrategy<? super K> hashingStrategy, Map<? extends K, ? extends V> map) {
            super(hashingStrategy, map);
        }

        public UnifiedMapWithHashingStrategyOverrides(HashingStrategy<? super K> hashingStrategy, int capacity, float loadFactor) {
            super(hashingStrategy, capacity, loadFactor);
        }

        @Override
        protected int index(K key) {
            int h = this.hashingStrategy.computeHashCode(key);
            return (h & (this.table.length >> 1) - 1) << 1;
        }

        @Override
        public UnifiedMapWithHashingStrategyOverrides<K, V> clone() {
            return new UnifiedMapWithHashingStrategyOverrides<>(this.hashingStrategy, this);
        }

        @Override
        public UnifiedMapWithHashingStrategyOverrides<K, V> newEmpty() {
            return new UnifiedMapWithHashingStrategyOverrides<>(this.hashingStrategy);
        }

        @Override
        public UnifiedMapWithHashingStrategyOverrides<K, V> newEmpty(int capacity) {
            return new UnifiedMapWithHashingStrategyOverrides<>(this.hashingStrategy, capacity, this.loadFactor);
        }
    }

    @Override
    public <K, V> UnifiedMapWithHashingStrategyOverrides<K, V> newMap() {
        HashingStrategy<K> nshs = HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy());
        return new UnifiedMapWithHashingStrategyOverrides<>(nshs);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value) {
        UnifiedMapWithHashingStrategy<K, V> map = this.newMap();
        return map.withKeysValues(key, value);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        UnifiedMapWithHashingStrategy<K, V> map = this.newMap();
        return map.withKeysValues(key1, value1, key2, value2);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        UnifiedMapWithHashingStrategy<K, V> map = this.newMap();
        return map.withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        UnifiedMapWithHashingStrategy<K, V> map = this.newMap();
        return map.withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedMapWithHashingStrategyOverridesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
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
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
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
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
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
        public void benchmark_selectInstancesOf_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
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
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
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
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
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
        public void benchmark_retainAllFromKeySet_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet_null_collision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rehash_null_collision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rehash_null_collision);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_WithEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_WithEmptyTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withPreSizedTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_toArray_withLargeTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_toArray_withSmallTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_toArray_withSmallTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_ToArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_ToArray_withLargeTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noInstanceOfEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noInstanceOfEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_hashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_hashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_copyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_copyKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withEmptyTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withEmptyTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withPreSizedTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withPreSizedTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_toArray_withLargeTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_toArray_withLargeTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_PostSerializedEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_key_and_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_key_and_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutValueWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutValueWithCollisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithWithCollisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithWithCollisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromEntrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromEntrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_equals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_Iterator_incrementPastEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_Iterator_incrementPastEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator_removeBeforeIncrement() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator_removeBeforeIncrement);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_many_collisions() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_many_collisions);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_hashCodeForNullKeyAndValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_hashCodeForNullKeyAndValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equalsWithNonEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equalsWithNonEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_equals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_Iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_Iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valueCollection_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valueCollection_equals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_frequentCollision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.frequentCollision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfPairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorOfIterableOfPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorOfIterableOfPairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap_throws);
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
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet_Iterator_removeFromNonChain() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet_Iterator_removeFromNonChain);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_weakEntryToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.weakEntryToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_Iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_Iterator_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equals_with_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equals_with_hashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesCollection_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesCollection_containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_chains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_null_handling);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEachEntry_emptySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_chains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_chains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_null_handling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_null_handling);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchIterable_forEachEntry_emptySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchIterable_forEachEntry_emptySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getMapMemoryUsedInWords() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getMapMemoryUsedInWords);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getHashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCollidingBuckets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCollidingBuckets);
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
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equals_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equals_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_get_with_hashing_strategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_get_with_hashing_strategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedMapWithHashingStrategyOverridesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_toArray_WithEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_toArray_withSmallTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_ToArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> noInstanceOfEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_hashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_copyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_toArray_withEmptyTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_toArray_withPreSizedTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_toArray_withLargeTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_PostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_PostSerializedEquality;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_PostSerializedEquality_chainedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> contains_key_and_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPutValueWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPutWithWithCollisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_Iterator_incrementPastEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_Iterator_removeBeforeIncrement;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> iterator_many_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entry_setValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entry_hashCodeForNullKeyAndValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entry_equalsWithNonEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valueCollection_Iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valueCollection_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> frequentCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> constructorOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> constructorOfIterableOfPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> newMap_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> contains_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> remove_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> keySet_Iterator_removeFromNonChain;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> weakEntryToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_Iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entry_equals_with_hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> entrySet_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> valuesCollection_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchForEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchForEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchForEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchForEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchForEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchForEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchIterable_forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchIterable_forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchIterable_forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchIterable_forEachEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchIterable_forEachEntry_chains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchIterable_forEachEntry_null_handling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> batchIterable_forEachEntry_emptySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getMapMemoryUsedInWords;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getCollidingBuckets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> equals_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> put_get_with_hashing_strategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> hashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedMapWithHashingStrategyOverridesTest> trimToSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = UnifiedMapWithHashingStrategyOverridesTest::stream;
            this.payloads.parallelStream = UnifiedMapWithHashingStrategyOverridesTest::parallelStream;
            this.payloads.serialization = UnifiedMapWithHashingStrategyOverridesTest::serialization;
            this.payloads.isEmpty = UnifiedMapWithHashingStrategyOverridesTest::isEmpty;
            this.payloads.notEmpty = UnifiedMapWithHashingStrategyOverridesTest::notEmpty;
            this.payloads.ifPresentApply = UnifiedMapWithHashingStrategyOverridesTest::ifPresentApply;
            this.payloads.getIfAbsent_function = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsent_function;
            this.payloads.getOrDefault = UnifiedMapWithHashingStrategyOverridesTest::getOrDefault;
            this.payloads.getIfAbsent = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsent;
            this.payloads.getIfAbsentWith = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentWith;
            this.payloads.tap = UnifiedMapWithHashingStrategyOverridesTest::tap;
            this.payloads.forEach = UnifiedMapWithHashingStrategyOverridesTest::forEach;
            this.payloads.injectIntoKeyValue = UnifiedMapWithHashingStrategyOverridesTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = UnifiedMapWithHashingStrategyOverridesTest::flipUniqueValues;
            this.payloads.collectBoolean = UnifiedMapWithHashingStrategyOverridesTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnifiedMapWithHashingStrategyOverridesTest::collectByte;
            this.payloads.collectByteWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectByteWithTarget;
            this.payloads.collectChar = UnifiedMapWithHashingStrategyOverridesTest::collectChar;
            this.payloads.collectCharWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectCharWithTarget;
            this.payloads.collectDouble = UnifiedMapWithHashingStrategyOverridesTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnifiedMapWithHashingStrategyOverridesTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectFloatWithTarget;
            this.payloads.collectInt = UnifiedMapWithHashingStrategyOverridesTest::collectInt;
            this.payloads.collectIntWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectIntWithTarget;
            this.payloads.collectLong = UnifiedMapWithHashingStrategyOverridesTest::collectLong;
            this.payloads.collectLongWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectLongWithTarget;
            this.payloads.collectShort = UnifiedMapWithHashingStrategyOverridesTest::collectShort;
            this.payloads.collectShortWithTarget = UnifiedMapWithHashingStrategyOverridesTest::collectShortWithTarget;
            this.payloads.collectValues = UnifiedMapWithHashingStrategyOverridesTest::collectValues;
            this.payloads.select = UnifiedMapWithHashingStrategyOverridesTest::select;
            this.payloads.selectWith = UnifiedMapWithHashingStrategyOverridesTest::selectWith;
            this.payloads.reject = UnifiedMapWithHashingStrategyOverridesTest::reject;
            this.payloads.rejectWith = UnifiedMapWithHashingStrategyOverridesTest::rejectWith;
            this.payloads.collect = UnifiedMapWithHashingStrategyOverridesTest::collect;
            this.payloads.flatCollect = UnifiedMapWithHashingStrategyOverridesTest::flatCollect;
            this.payloads.flatCollectWith = UnifiedMapWithHashingStrategyOverridesTest::flatCollectWith;
            this.payloads.flip = UnifiedMapWithHashingStrategyOverridesTest::flip;
            this.payloads.detect = UnifiedMapWithHashingStrategyOverridesTest::detect;
            this.payloads.detectOptional = UnifiedMapWithHashingStrategyOverridesTest::detectOptional;
            this.payloads.anySatisfy = UnifiedMapWithHashingStrategyOverridesTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedMapWithHashingStrategyOverridesTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedMapWithHashingStrategyOverridesTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedMapWithHashingStrategyOverridesTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedMapWithHashingStrategyOverridesTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedMapWithHashingStrategyOverridesTest::noneSatisfyWith;
            this.payloads.appendString = UnifiedMapWithHashingStrategyOverridesTest::appendString;
            this.payloads.toBag = UnifiedMapWithHashingStrategyOverridesTest::toBag;
            this.payloads.toSortedBag = UnifiedMapWithHashingStrategyOverridesTest::toSortedBag;
            this.payloads.toSortedBagBy = UnifiedMapWithHashingStrategyOverridesTest::toSortedBagBy;
            this.payloads.asLazy = UnifiedMapWithHashingStrategyOverridesTest::asLazy;
            this.payloads.toList = UnifiedMapWithHashingStrategyOverridesTest::toList;
            this.payloads.toMap = UnifiedMapWithHashingStrategyOverridesTest::toMap;
            this.payloads.toSet = UnifiedMapWithHashingStrategyOverridesTest::toSet;
            this.payloads.toSortedList = UnifiedMapWithHashingStrategyOverridesTest::toSortedList;
            this.payloads.toSortedListBy = UnifiedMapWithHashingStrategyOverridesTest::toSortedListBy;
            this.payloads.toSortedSet = UnifiedMapWithHashingStrategyOverridesTest::toSortedSet;
            this.payloads.toSortedSetBy = UnifiedMapWithHashingStrategyOverridesTest::toSortedSetBy;
            this.payloads.toSortedMap = UnifiedMapWithHashingStrategyOverridesTest::toSortedMap;
            this.payloads.chunk = UnifiedMapWithHashingStrategyOverridesTest::chunk;
            this.payloads.collect_value = UnifiedMapWithHashingStrategyOverridesTest::collect_value;
            this.payloads.collectIf = UnifiedMapWithHashingStrategyOverridesTest::collectIf;
            this.payloads.collectWith = UnifiedMapWithHashingStrategyOverridesTest::collectWith;
            this.payloads.collectWithToTarget = UnifiedMapWithHashingStrategyOverridesTest::collectWithToTarget;
            this.payloads.contains = UnifiedMapWithHashingStrategyOverridesTest::contains;
            this.payloads.containsAnyIterable = UnifiedMapWithHashingStrategyOverridesTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnifiedMapWithHashingStrategyOverridesTest::containsNoneIterable;
            this.payloads.containsAnyCollection = UnifiedMapWithHashingStrategyOverridesTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnifiedMapWithHashingStrategyOverridesTest::containsNoneCollection;
            this.payloads.containsAll = UnifiedMapWithHashingStrategyOverridesTest::containsAll;
            this.payloads.containsKey = UnifiedMapWithHashingStrategyOverridesTest::containsKey;
            this.payloads.containsValue = UnifiedMapWithHashingStrategyOverridesTest::containsValue;
            this.payloads.getFirst = UnifiedMapWithHashingStrategyOverridesTest::getFirst;
            this.payloads.getLast = UnifiedMapWithHashingStrategyOverridesTest::getLast;
            this.payloads.getOnly = UnifiedMapWithHashingStrategyOverridesTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = UnifiedMapWithHashingStrategyOverridesTest::containsAllIterable;
            this.payloads.containsAllArguments = UnifiedMapWithHashingStrategyOverridesTest::containsAllArguments;
            this.payloads.count = UnifiedMapWithHashingStrategyOverridesTest::count;
            this.payloads.countWith = UnifiedMapWithHashingStrategyOverridesTest::countWith;
            this.payloads.detect_value = UnifiedMapWithHashingStrategyOverridesTest::detect_value;
            this.payloads.detectOptional_value = UnifiedMapWithHashingStrategyOverridesTest::detectOptional_value;
            this.payloads.detectWith = UnifiedMapWithHashingStrategyOverridesTest::detectWith;
            this.payloads.detectWithOptional = UnifiedMapWithHashingStrategyOverridesTest::detectWithOptional;
            this.payloads.detectIfNone_value = UnifiedMapWithHashingStrategyOverridesTest::detectIfNone_value;
            this.payloads.detectWithIfNone = UnifiedMapWithHashingStrategyOverridesTest::detectWithIfNone;
            this.payloads.flatten_value = UnifiedMapWithHashingStrategyOverridesTest::flatten_value;
            this.payloads.countBy = UnifiedMapWithHashingStrategyOverridesTest::countBy;
            this.payloads.countByWith = UnifiedMapWithHashingStrategyOverridesTest::countByWith;
            this.payloads.countByEach = UnifiedMapWithHashingStrategyOverridesTest::countByEach;
            this.payloads.groupBy = UnifiedMapWithHashingStrategyOverridesTest::groupBy;
            this.payloads.groupByEach = UnifiedMapWithHashingStrategyOverridesTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedMapWithHashingStrategyOverridesTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnifiedMapWithHashingStrategyOverridesTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = UnifiedMapWithHashingStrategyOverridesTest::injectInto;
            this.payloads.injectIntoInt = UnifiedMapWithHashingStrategyOverridesTest::injectIntoInt;
            this.payloads.injectIntoLong = UnifiedMapWithHashingStrategyOverridesTest::injectIntoLong;
            this.payloads.injectIntoFloat = UnifiedMapWithHashingStrategyOverridesTest::injectIntoFloat;
            this.payloads.injectIntoDouble = UnifiedMapWithHashingStrategyOverridesTest::injectIntoDouble;
            this.payloads.sumOfInt = UnifiedMapWithHashingStrategyOverridesTest::sumOfInt;
            this.payloads.sumOfLong = UnifiedMapWithHashingStrategyOverridesTest::sumOfLong;
            this.payloads.testAggregateBy = UnifiedMapWithHashingStrategyOverridesTest::testAggregateBy;
            this.payloads.sumOfFloat = UnifiedMapWithHashingStrategyOverridesTest::sumOfFloat;
            this.payloads.sumOfDouble = UnifiedMapWithHashingStrategyOverridesTest::sumOfDouble;
            this.payloads.sumByInt = UnifiedMapWithHashingStrategyOverridesTest::sumByInt;
            this.payloads.sumByFloat = UnifiedMapWithHashingStrategyOverridesTest::sumByFloat;
            this.payloads.sumByLong = UnifiedMapWithHashingStrategyOverridesTest::sumByLong;
            this.payloads.sumByDouble = UnifiedMapWithHashingStrategyOverridesTest::sumByDouble;
            this.payloads.makeString = UnifiedMapWithHashingStrategyOverridesTest::makeString;
            this.payloads.min = UnifiedMapWithHashingStrategyOverridesTest::min;
            this.payloads.max = UnifiedMapWithHashingStrategyOverridesTest::max;
            this.payloads.minBy = UnifiedMapWithHashingStrategyOverridesTest::minBy;
            this.payloads.maxBy = UnifiedMapWithHashingStrategyOverridesTest::maxBy;
            this.payloads.reject_value = UnifiedMapWithHashingStrategyOverridesTest::reject_value;
            this.payloads.rejectWith_value = UnifiedMapWithHashingStrategyOverridesTest::rejectWith_value;
            this.payloads.select_value = UnifiedMapWithHashingStrategyOverridesTest::select_value;
            this.payloads.selectWith_value = UnifiedMapWithHashingStrategyOverridesTest::selectWith_value;
            this.payloads.partition_value = UnifiedMapWithHashingStrategyOverridesTest::partition_value;
            this.payloads.partitionWith_value = UnifiedMapWithHashingStrategyOverridesTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = UnifiedMapWithHashingStrategyOverridesTest::selectInstancesOf_value;
            this.payloads.toArray = UnifiedMapWithHashingStrategyOverridesTest::toArray;
            this.payloads.zip = UnifiedMapWithHashingStrategyOverridesTest::zip;
            this.payloads.zipWithIndex = UnifiedMapWithHashingStrategyOverridesTest::zipWithIndex;
            this.payloads.aggregateByMutating = UnifiedMapWithHashingStrategyOverridesTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnifiedMapWithHashingStrategyOverridesTest::aggregateByNonMutating;
            this.payloads.keyValuesView = UnifiedMapWithHashingStrategyOverridesTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = UnifiedMapWithHashingStrategyOverridesTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = UnifiedMapWithHashingStrategyOverridesTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = UnifiedMapWithHashingStrategyOverridesTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = UnifiedMapWithHashingStrategyOverridesTest::newMapWithWith;
            this.payloads.newMapWithWithWith = UnifiedMapWithHashingStrategyOverridesTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = UnifiedMapWithHashingStrategyOverridesTest::newMapWithWithWithWith;
            this.payloads.iterator = UnifiedMapWithHashingStrategyOverridesTest::iterator;
            this.payloads.keysView = UnifiedMapWithHashingStrategyOverridesTest::keysView;
            this.payloads.valuesView = UnifiedMapWithHashingStrategyOverridesTest::valuesView;
            this.payloads.test_toString = UnifiedMapWithHashingStrategyOverridesTest::test_toString;
            this.payloads.toImmutable = UnifiedMapWithHashingStrategyOverridesTest::toImmutable;
            this.payloads.clear = UnifiedMapWithHashingStrategyOverridesTest::clear;
            this.payloads.removeObject = UnifiedMapWithHashingStrategyOverridesTest::removeObject;
            this.payloads.removeAllFromEntrySet = UnifiedMapWithHashingStrategyOverridesTest::removeAllFromEntrySet;
            this.payloads.clearEntrySet = UnifiedMapWithHashingStrategyOverridesTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = UnifiedMapWithHashingStrategyOverridesTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = UnifiedMapWithHashingStrategyOverridesTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = UnifiedMapWithHashingStrategyOverridesTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = UnifiedMapWithHashingStrategyOverridesTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = UnifiedMapWithHashingStrategyOverridesTest::retainAllFromKeySet;
            this.payloads.clearKeySet = UnifiedMapWithHashingStrategyOverridesTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = UnifiedMapWithHashingStrategyOverridesTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = UnifiedMapWithHashingStrategyOverridesTest::keySetToArray;
            this.payloads.removeFromValues = UnifiedMapWithHashingStrategyOverridesTest::removeFromValues;
            this.payloads.removeNullFromValues = UnifiedMapWithHashingStrategyOverridesTest::removeNullFromValues;
            this.payloads.removeAllFromValues = UnifiedMapWithHashingStrategyOverridesTest::removeAllFromValues;
            this.payloads.retainAllFromValues = UnifiedMapWithHashingStrategyOverridesTest::retainAllFromValues;
            this.payloads.putAll = UnifiedMapWithHashingStrategyOverridesTest::putAll;
            this.payloads.removeKey = UnifiedMapWithHashingStrategyOverridesTest::removeKey;
            this.payloads.removeAllKeys = UnifiedMapWithHashingStrategyOverridesTest::removeAllKeys;
            this.payloads.removeIf = UnifiedMapWithHashingStrategyOverridesTest::removeIf;
            this.payloads.getIfAbsentPutWithKey = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPut_block_throws = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = UnifiedMapWithHashingStrategyOverridesTest::getKeysAndGetValues;
            this.payloads.newEmpty = UnifiedMapWithHashingStrategyOverridesTest::newEmpty;
            this.payloads.keysAndValues_toString = UnifiedMapWithHashingStrategyOverridesTest::keysAndValues_toString;
            this.payloads.keyPreservation = UnifiedMapWithHashingStrategyOverridesTest::keyPreservation;
            this.payloads.asUnmodifiable = UnifiedMapWithHashingStrategyOverridesTest::asUnmodifiable;
            this.payloads.asSynchronized = UnifiedMapWithHashingStrategyOverridesTest::asSynchronized;
            this.payloads.add = UnifiedMapWithHashingStrategyOverridesTest::add;
            this.payloads.putPair = UnifiedMapWithHashingStrategyOverridesTest::putPair;
            this.payloads.withKeyValue = UnifiedMapWithHashingStrategyOverridesTest::withKeyValue;
            this.payloads.withMap = UnifiedMapWithHashingStrategyOverridesTest::withMap;
            this.payloads.withMapEmpty = UnifiedMapWithHashingStrategyOverridesTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = UnifiedMapWithHashingStrategyOverridesTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = UnifiedMapWithHashingStrategyOverridesTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = UnifiedMapWithHashingStrategyOverridesTest::withMapNull;
            this.payloads.withMapIterable = UnifiedMapWithHashingStrategyOverridesTest::withMapIterable;
            this.payloads.withMapIterableEmpty = UnifiedMapWithHashingStrategyOverridesTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = UnifiedMapWithHashingStrategyOverridesTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = UnifiedMapWithHashingStrategyOverridesTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = UnifiedMapWithHashingStrategyOverridesTest::withMapIterableNull;
            this.payloads.putAllMapIterable = UnifiedMapWithHashingStrategyOverridesTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = UnifiedMapWithHashingStrategyOverridesTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = UnifiedMapWithHashingStrategyOverridesTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = UnifiedMapWithHashingStrategyOverridesTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = UnifiedMapWithHashingStrategyOverridesTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = UnifiedMapWithHashingStrategyOverridesTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = UnifiedMapWithHashingStrategyOverridesTest::withAllKeyValueArguments;
            this.payloads.withoutKey = UnifiedMapWithHashingStrategyOverridesTest::withoutKey;
            this.payloads.withoutAllKeys = UnifiedMapWithHashingStrategyOverridesTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = UnifiedMapWithHashingStrategyOverridesTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = UnifiedMapWithHashingStrategyOverridesTest::rehash_null_collision;
            this.payloads.updateValue = UnifiedMapWithHashingStrategyOverridesTest::updateValue;
            this.payloads.updateValue_collisions = UnifiedMapWithHashingStrategyOverridesTest::updateValue_collisions;
            this.payloads.updateValueWith = UnifiedMapWithHashingStrategyOverridesTest::updateValueWith;
            this.payloads.updateValueWith_collisions = UnifiedMapWithHashingStrategyOverridesTest::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = UnifiedMapWithHashingStrategyOverridesTest::collectKeysAndValues;
            this.payloads.testClone = UnifiedMapWithHashingStrategyOverridesTest::testClone;
            this.payloads.valuesCollection_toArray = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_toArray;
            this.payloads.valuesCollection_toArray_WithEmptyTarget = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_toArray_WithEmptyTarget;
            this.payloads.valuesCollection_toArray_withPreSizedTarget = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_toArray_withPreSizedTarget;
            this.payloads.valuesCollection_toArray_withLargeTarget = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_toArray_withLargeTarget;
            this.payloads.entrySet_clear = UnifiedMapWithHashingStrategyOverridesTest::entrySet_clear;
            this.payloads.valuesCollection_clear = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_clear;
            this.payloads.keySet_toArray_withSmallTarget = UnifiedMapWithHashingStrategyOverridesTest::keySet_toArray_withSmallTarget;
            this.payloads.keySet_ToArray_withLargeTarget = UnifiedMapWithHashingStrategyOverridesTest::keySet_ToArray_withLargeTarget;
            this.payloads.noInstanceOfEquals = UnifiedMapWithHashingStrategyOverridesTest::noInstanceOfEquals;
            this.payloads.keySet_hashCode = UnifiedMapWithHashingStrategyOverridesTest::keySet_hashCode;
            this.payloads.keySet_copyKeys = UnifiedMapWithHashingStrategyOverridesTest::keySet_copyKeys;
            this.payloads.entrySet_toArray = UnifiedMapWithHashingStrategyOverridesTest::entrySet_toArray;
            this.payloads.entrySet_toArray_withEmptyTarget = UnifiedMapWithHashingStrategyOverridesTest::entrySet_toArray_withEmptyTarget;
            this.payloads.entrySet_toArray_withPreSizedTarget = UnifiedMapWithHashingStrategyOverridesTest::entrySet_toArray_withPreSizedTarget;
            this.payloads.entrySet_toArray_withLargeTarget = UnifiedMapWithHashingStrategyOverridesTest::entrySet_toArray_withLargeTarget;
            this.payloads.entrySet_PostSerializedEqualsAndHashCode = UnifiedMapWithHashingStrategyOverridesTest::entrySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode = UnifiedMapWithHashingStrategyOverridesTest::keySet_PostSerializedEqualsAndHashCode;
            this.payloads.keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot = UnifiedMapWithHashingStrategyOverridesTest::keySet_PostSerializedEqualsAndHashCode_chainWithEmptySlot;
            this.payloads.valuesCollection_PostSerializedEquality = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_PostSerializedEquality;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMap = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_PostSerializedEquality_chainedMap;
            this.payloads.valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_PostSerializedEquality_chainedMapWithEmptySlot;
            this.payloads.contains_key_and_value = UnifiedMapWithHashingStrategyOverridesTest::contains_key_and_value;
            this.payloads.remove = UnifiedMapWithHashingStrategyOverridesTest::remove;
            this.payloads.getIfAbsentPutValueWithCollisions = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPutValueWithCollisions;
            this.payloads.getIfAbsentPutWithWithCollisions = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPutWithWithCollisions;
            this.payloads.removeFromEntrySet = UnifiedMapWithHashingStrategyOverridesTest::removeFromEntrySet;
            this.payloads.retainAllFromEntrySet = UnifiedMapWithHashingStrategyOverridesTest::retainAllFromEntrySet;
            this.payloads.forEachWith = UnifiedMapWithHashingStrategyOverridesTest::forEachWith;
            this.payloads.keySet_retainAll = UnifiedMapWithHashingStrategyOverridesTest::keySet_retainAll;
            this.payloads.keySet_containsAll = UnifiedMapWithHashingStrategyOverridesTest::keySet_containsAll;
            this.payloads.keySet_equals = UnifiedMapWithHashingStrategyOverridesTest::keySet_equals;
            this.payloads.keySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::keySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::keySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.keySet_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::keySet_Iterator, java.util.NoSuchElementException.class);
            this.payloads.entrySet_Iterator_incrementPastEnd = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::entrySet_Iterator_incrementPastEnd, java.util.NoSuchElementException.class);
            this.payloads.keySet_Iterator_removeBeforeIncrement = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::keySet_Iterator_removeBeforeIncrement, java.lang.IllegalStateException.class);
            this.payloads.iterator_many_collisions = UnifiedMapWithHashingStrategyOverridesTest::iterator_many_collisions;
            this.payloads.entry_setValue = UnifiedMapWithHashingStrategyOverridesTest::entry_setValue;
            this.payloads.entry_hashCodeForNullKeyAndValue = UnifiedMapWithHashingStrategyOverridesTest::entry_hashCodeForNullKeyAndValue;
            this.payloads.entry_equalsWithNonEntry = UnifiedMapWithHashingStrategyOverridesTest::entry_equalsWithNonEntry;
            this.payloads.entrySet_remove = UnifiedMapWithHashingStrategyOverridesTest::entrySet_remove;
            this.payloads.entrySet_contains = UnifiedMapWithHashingStrategyOverridesTest::entrySet_contains;
            this.payloads.entrySet_containsAll = UnifiedMapWithHashingStrategyOverridesTest::entrySet_containsAll;
            this.payloads.entrySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::entrySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::entrySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_equals = UnifiedMapWithHashingStrategyOverridesTest::entrySet_equals;
            this.payloads.valuesCollection_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_add, java.lang.UnsupportedOperationException.class);
            this.payloads.valuesCollection_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.valueCollection_Iterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedMapWithHashingStrategyOverridesTest::valueCollection_Iterator, java.util.NoSuchElementException.class);
            this.payloads.valueCollection_equals = UnifiedMapWithHashingStrategyOverridesTest::valueCollection_equals;
            this.payloads.forEachWithIndex = UnifiedMapWithHashingStrategyOverridesTest::forEachWithIndex;
            this.payloads.forEachKey = UnifiedMapWithHashingStrategyOverridesTest::forEachKey;
            this.payloads.forEachValue = UnifiedMapWithHashingStrategyOverridesTest::forEachValue;
            this.payloads.equalsAndHashCode = UnifiedMapWithHashingStrategyOverridesTest::equalsAndHashCode;
            this.payloads.frequentCollision = UnifiedMapWithHashingStrategyOverridesTest::frequentCollision;
            this.payloads.constructorOfPairs = UnifiedMapWithHashingStrategyOverridesTest::constructorOfPairs;
            this.payloads.constructorOfIterableOfPairs = UnifiedMapWithHashingStrategyOverridesTest::constructorOfIterableOfPairs;
            this.payloads.newMap_throws = UnifiedMapWithHashingStrategyOverridesTest::newMap_throws;
            this.payloads.selectMap = UnifiedMapWithHashingStrategyOverridesTest::selectMap;
            this.payloads.rejectMap = UnifiedMapWithHashingStrategyOverridesTest::rejectMap;
            this.payloads.collectMap = UnifiedMapWithHashingStrategyOverridesTest::collectMap;
            this.payloads.contains_with_hashing_strategy = UnifiedMapWithHashingStrategyOverridesTest::contains_with_hashing_strategy;
            this.payloads.remove_with_hashing_strategy = UnifiedMapWithHashingStrategyOverridesTest::remove_with_hashing_strategy;
            this.payloads.keySet_isEmpty = UnifiedMapWithHashingStrategyOverridesTest::keySet_isEmpty;
            this.payloads.keySet_with_hashing_strategy = UnifiedMapWithHashingStrategyOverridesTest::keySet_with_hashing_strategy;
            this.payloads.keySet_Iterator_removeFromNonChain = UnifiedMapWithHashingStrategyOverridesTest::keySet_Iterator_removeFromNonChain;
            this.payloads.weakEntryToString = UnifiedMapWithHashingStrategyOverridesTest::weakEntryToString;
            this.payloads.valuesCollection_Iterator_remove = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_Iterator_remove;
            this.payloads.entry_equals_with_hashingStrategy = UnifiedMapWithHashingStrategyOverridesTest::entry_equals_with_hashingStrategy;
            this.payloads.entrySet_with_hashing_strategy = UnifiedMapWithHashingStrategyOverridesTest::entrySet_with_hashing_strategy;
            this.payloads.valuesCollection_containsAll = UnifiedMapWithHashingStrategyOverridesTest::valuesCollection_containsAll;
            this.payloads.batchForEach = UnifiedMapWithHashingStrategyOverridesTest::batchForEach;
            this.payloads.batchForEachKey = UnifiedMapWithHashingStrategyOverridesTest::batchForEachKey;
            this.payloads.batchForEachValue = UnifiedMapWithHashingStrategyOverridesTest::batchForEachValue;
            this.payloads.batchForEachEntry = UnifiedMapWithHashingStrategyOverridesTest::batchForEachEntry;
            this.payloads.batchForEachEntry_chains = UnifiedMapWithHashingStrategyOverridesTest::batchForEachEntry_chains;
            this.payloads.batchForEachEntry_null_handling = UnifiedMapWithHashingStrategyOverridesTest::batchForEachEntry_null_handling;
            this.payloads.batchForEachEntry_emptySet = UnifiedMapWithHashingStrategyOverridesTest::batchForEachEntry_emptySet;
            this.payloads.batchIterable_forEach = UnifiedMapWithHashingStrategyOverridesTest::batchIterable_forEach;
            this.payloads.batchIterable_forEachKey = UnifiedMapWithHashingStrategyOverridesTest::batchIterable_forEachKey;
            this.payloads.batchIterable_forEachValue = UnifiedMapWithHashingStrategyOverridesTest::batchIterable_forEachValue;
            this.payloads.batchIterable_forEachEntry = UnifiedMapWithHashingStrategyOverridesTest::batchIterable_forEachEntry;
            this.payloads.batchIterable_forEachEntry_chains = UnifiedMapWithHashingStrategyOverridesTest::batchIterable_forEachEntry_chains;
            this.payloads.batchIterable_forEachEntry_null_handling = UnifiedMapWithHashingStrategyOverridesTest::batchIterable_forEachEntry_null_handling;
            this.payloads.batchIterable_forEachEntry_emptySet = UnifiedMapWithHashingStrategyOverridesTest::batchIterable_forEachEntry_emptySet;
            this.payloads.forEachKeyValue = UnifiedMapWithHashingStrategyOverridesTest::forEachKeyValue;
            this.payloads.getMapMemoryUsedInWords = UnifiedMapWithHashingStrategyOverridesTest::getMapMemoryUsedInWords;
            this.payloads.getHashingStrategy = UnifiedMapWithHashingStrategyOverridesTest::getHashingStrategy;
            this.payloads.getCollidingBuckets = UnifiedMapWithHashingStrategyOverridesTest::getCollidingBuckets;
            this.payloads.getIfAbsentPut = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWith = UnifiedMapWithHashingStrategyOverridesTest::getIfAbsentPutWith;
            this.payloads.equals_with_hashing_strategy = UnifiedMapWithHashingStrategyOverridesTest::equals_with_hashing_strategy;
            this.payloads.put = UnifiedMapWithHashingStrategyOverridesTest::put;
            this.payloads.put_get_with_hashing_strategy = UnifiedMapWithHashingStrategyOverridesTest::put_get_with_hashing_strategy;
            this.payloads.hashingStrategy = UnifiedMapWithHashingStrategyOverridesTest::hashingStrategy;
            this.payloads.trimToSize = UnifiedMapWithHashingStrategyOverridesTest::trimToSize;
        }
    }
*/
}
