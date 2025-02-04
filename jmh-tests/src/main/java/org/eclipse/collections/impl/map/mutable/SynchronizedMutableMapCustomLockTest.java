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

import org.eclipse.collections.api.map.MutableMap;

/**
 * JUnit test for {@link SynchronizedMutableMap}.
 */
public class SynchronizedMutableMapCustomLockTest extends MutableMapTestCase {

    private static final Object LOCK = "lock";

    @Override
    public <K, V> MutableMap<K, V> newMap() {
        return new SynchronizedMutableMap<>(UnifiedMap.newMap(), LOCK);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key, value), LOCK);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2), LOCK);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3), LOCK);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4), LOCK);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedMutableMapCustomLockTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
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
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
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
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedMutableMapCustomLockTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapCustomLockTest> testClone;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = SynchronizedMutableMapCustomLockTest::stream;
            this.payloads.parallelStream = SynchronizedMutableMapCustomLockTest::parallelStream;
            this.payloads.equalsAndHashCode = SynchronizedMutableMapCustomLockTest::equalsAndHashCode;
            this.payloads.serialization = SynchronizedMutableMapCustomLockTest::serialization;
            this.payloads.isEmpty = SynchronizedMutableMapCustomLockTest::isEmpty;
            this.payloads.notEmpty = SynchronizedMutableMapCustomLockTest::notEmpty;
            this.payloads.ifPresentApply = SynchronizedMutableMapCustomLockTest::ifPresentApply;
            this.payloads.getIfAbsent_function = SynchronizedMutableMapCustomLockTest::getIfAbsent_function;
            this.payloads.getOrDefault = SynchronizedMutableMapCustomLockTest::getOrDefault;
            this.payloads.getIfAbsent = SynchronizedMutableMapCustomLockTest::getIfAbsent;
            this.payloads.getIfAbsentWith = SynchronizedMutableMapCustomLockTest::getIfAbsentWith;
            this.payloads.tap = SynchronizedMutableMapCustomLockTest::tap;
            this.payloads.forEach = SynchronizedMutableMapCustomLockTest::forEach;
            this.payloads.forEachWith = SynchronizedMutableMapCustomLockTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedMutableMapCustomLockTest::forEachWithIndex;
            this.payloads.forEachKey = SynchronizedMutableMapCustomLockTest::forEachKey;
            this.payloads.forEachValue = SynchronizedMutableMapCustomLockTest::forEachValue;
            this.payloads.forEachKeyValue = SynchronizedMutableMapCustomLockTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedMutableMapCustomLockTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = SynchronizedMutableMapCustomLockTest::flipUniqueValues;
            this.payloads.collectMap = SynchronizedMutableMapCustomLockTest::collectMap;
            this.payloads.collectBoolean = SynchronizedMutableMapCustomLockTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedMutableMapCustomLockTest::collectBooleanWithTarget;
            this.payloads.collectByte = SynchronizedMutableMapCustomLockTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedMutableMapCustomLockTest::collectByteWithTarget;
            this.payloads.collectChar = SynchronizedMutableMapCustomLockTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedMutableMapCustomLockTest::collectCharWithTarget;
            this.payloads.collectDouble = SynchronizedMutableMapCustomLockTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedMutableMapCustomLockTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SynchronizedMutableMapCustomLockTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedMutableMapCustomLockTest::collectFloatWithTarget;
            this.payloads.collectInt = SynchronizedMutableMapCustomLockTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedMutableMapCustomLockTest::collectIntWithTarget;
            this.payloads.collectLong = SynchronizedMutableMapCustomLockTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedMutableMapCustomLockTest::collectLongWithTarget;
            this.payloads.collectShort = SynchronizedMutableMapCustomLockTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedMutableMapCustomLockTest::collectShortWithTarget;
            this.payloads.collectValues = SynchronizedMutableMapCustomLockTest::collectValues;
            this.payloads.select = SynchronizedMutableMapCustomLockTest::select;
            this.payloads.selectWith = SynchronizedMutableMapCustomLockTest::selectWith;
            this.payloads.reject = SynchronizedMutableMapCustomLockTest::reject;
            this.payloads.rejectWith = SynchronizedMutableMapCustomLockTest::rejectWith;
            this.payloads.collect = SynchronizedMutableMapCustomLockTest::collect;
            this.payloads.flatCollect = SynchronizedMutableMapCustomLockTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedMutableMapCustomLockTest::flatCollectWith;
            this.payloads.selectMap = SynchronizedMutableMapCustomLockTest::selectMap;
            this.payloads.rejectMap = SynchronizedMutableMapCustomLockTest::rejectMap;
            this.payloads.flip = SynchronizedMutableMapCustomLockTest::flip;
            this.payloads.detect = SynchronizedMutableMapCustomLockTest::detect;
            this.payloads.detectOptional = SynchronizedMutableMapCustomLockTest::detectOptional;
            this.payloads.anySatisfy = SynchronizedMutableMapCustomLockTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedMutableMapCustomLockTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedMutableMapCustomLockTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedMutableMapCustomLockTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedMutableMapCustomLockTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedMutableMapCustomLockTest::noneSatisfyWith;
            this.payloads.appendString = SynchronizedMutableMapCustomLockTest::appendString;
            this.payloads.toBag = SynchronizedMutableMapCustomLockTest::toBag;
            this.payloads.toSortedBag = SynchronizedMutableMapCustomLockTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedMutableMapCustomLockTest::toSortedBagBy;
            this.payloads.asLazy = SynchronizedMutableMapCustomLockTest::asLazy;
            this.payloads.toList = SynchronizedMutableMapCustomLockTest::toList;
            this.payloads.toMap = SynchronizedMutableMapCustomLockTest::toMap;
            this.payloads.toSet = SynchronizedMutableMapCustomLockTest::toSet;
            this.payloads.toSortedList = SynchronizedMutableMapCustomLockTest::toSortedList;
            this.payloads.toSortedListBy = SynchronizedMutableMapCustomLockTest::toSortedListBy;
            this.payloads.toSortedSet = SynchronizedMutableMapCustomLockTest::toSortedSet;
            this.payloads.toSortedSetBy = SynchronizedMutableMapCustomLockTest::toSortedSetBy;
            this.payloads.toSortedMap = SynchronizedMutableMapCustomLockTest::toSortedMap;
            this.payloads.chunk = SynchronizedMutableMapCustomLockTest::chunk;
            this.payloads.collect_value = SynchronizedMutableMapCustomLockTest::collect_value;
            this.payloads.collectIf = SynchronizedMutableMapCustomLockTest::collectIf;
            this.payloads.collectWith = SynchronizedMutableMapCustomLockTest::collectWith;
            this.payloads.collectWithToTarget = SynchronizedMutableMapCustomLockTest::collectWithToTarget;
            this.payloads.contains = SynchronizedMutableMapCustomLockTest::contains;
            this.payloads.containsAnyIterable = SynchronizedMutableMapCustomLockTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedMutableMapCustomLockTest::containsNoneIterable;
            this.payloads.containsAnyCollection = SynchronizedMutableMapCustomLockTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedMutableMapCustomLockTest::containsNoneCollection;
            this.payloads.containsAll = SynchronizedMutableMapCustomLockTest::containsAll;
            this.payloads.containsKey = SynchronizedMutableMapCustomLockTest::containsKey;
            this.payloads.containsValue = SynchronizedMutableMapCustomLockTest::containsValue;
            this.payloads.getFirst = SynchronizedMutableMapCustomLockTest::getFirst;
            this.payloads.getLast = SynchronizedMutableMapCustomLockTest::getLast;
            this.payloads.getOnly = SynchronizedMutableMapCustomLockTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapCustomLockTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapCustomLockTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedMutableMapCustomLockTest::containsAllIterable;
            this.payloads.containsAllArguments = SynchronizedMutableMapCustomLockTest::containsAllArguments;
            this.payloads.count = SynchronizedMutableMapCustomLockTest::count;
            this.payloads.countWith = SynchronizedMutableMapCustomLockTest::countWith;
            this.payloads.detect_value = SynchronizedMutableMapCustomLockTest::detect_value;
            this.payloads.detectOptional_value = SynchronizedMutableMapCustomLockTest::detectOptional_value;
            this.payloads.detectWith = SynchronizedMutableMapCustomLockTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedMutableMapCustomLockTest::detectWithOptional;
            this.payloads.detectIfNone_value = SynchronizedMutableMapCustomLockTest::detectIfNone_value;
            this.payloads.detectWithIfNone = SynchronizedMutableMapCustomLockTest::detectWithIfNone;
            this.payloads.flatten_value = SynchronizedMutableMapCustomLockTest::flatten_value;
            this.payloads.countBy = SynchronizedMutableMapCustomLockTest::countBy;
            this.payloads.countByWith = SynchronizedMutableMapCustomLockTest::countByWith;
            this.payloads.countByEach = SynchronizedMutableMapCustomLockTest::countByEach;
            this.payloads.groupBy = SynchronizedMutableMapCustomLockTest::groupBy;
            this.payloads.groupByEach = SynchronizedMutableMapCustomLockTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedMutableMapCustomLockTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapCustomLockTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedMutableMapCustomLockTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapCustomLockTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = SynchronizedMutableMapCustomLockTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedMutableMapCustomLockTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedMutableMapCustomLockTest::injectIntoLong;
            this.payloads.injectIntoFloat = SynchronizedMutableMapCustomLockTest::injectIntoFloat;
            this.payloads.injectIntoDouble = SynchronizedMutableMapCustomLockTest::injectIntoDouble;
            this.payloads.sumOfInt = SynchronizedMutableMapCustomLockTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedMutableMapCustomLockTest::sumOfLong;
            this.payloads.testAggregateBy = SynchronizedMutableMapCustomLockTest::testAggregateBy;
            this.payloads.sumOfFloat = SynchronizedMutableMapCustomLockTest::sumOfFloat;
            this.payloads.sumOfDouble = SynchronizedMutableMapCustomLockTest::sumOfDouble;
            this.payloads.sumByInt = SynchronizedMutableMapCustomLockTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedMutableMapCustomLockTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedMutableMapCustomLockTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedMutableMapCustomLockTest::sumByDouble;
            this.payloads.makeString = SynchronizedMutableMapCustomLockTest::makeString;
            this.payloads.min = SynchronizedMutableMapCustomLockTest::min;
            this.payloads.max = SynchronizedMutableMapCustomLockTest::max;
            this.payloads.minBy = SynchronizedMutableMapCustomLockTest::minBy;
            this.payloads.maxBy = SynchronizedMutableMapCustomLockTest::maxBy;
            this.payloads.reject_value = SynchronizedMutableMapCustomLockTest::reject_value;
            this.payloads.rejectWith_value = SynchronizedMutableMapCustomLockTest::rejectWith_value;
            this.payloads.select_value = SynchronizedMutableMapCustomLockTest::select_value;
            this.payloads.selectWith_value = SynchronizedMutableMapCustomLockTest::selectWith_value;
            this.payloads.partition_value = SynchronizedMutableMapCustomLockTest::partition_value;
            this.payloads.partitionWith_value = SynchronizedMutableMapCustomLockTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = SynchronizedMutableMapCustomLockTest::selectInstancesOf_value;
            this.payloads.toArray = SynchronizedMutableMapCustomLockTest::toArray;
            this.payloads.zip = SynchronizedMutableMapCustomLockTest::zip;
            this.payloads.zipWithIndex = SynchronizedMutableMapCustomLockTest::zipWithIndex;
            this.payloads.aggregateByMutating = SynchronizedMutableMapCustomLockTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedMutableMapCustomLockTest::aggregateByNonMutating;
            this.payloads.keyValuesView = SynchronizedMutableMapCustomLockTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = SynchronizedMutableMapCustomLockTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = SynchronizedMutableMapCustomLockTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = SynchronizedMutableMapCustomLockTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = SynchronizedMutableMapCustomLockTest::newMapWithWith;
            this.payloads.newMapWithWithWith = SynchronizedMutableMapCustomLockTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = SynchronizedMutableMapCustomLockTest::newMapWithWithWithWith;
            this.payloads.iterator = SynchronizedMutableMapCustomLockTest::iterator;
            this.payloads.keysView = SynchronizedMutableMapCustomLockTest::keysView;
            this.payloads.valuesView = SynchronizedMutableMapCustomLockTest::valuesView;
            this.payloads.test_toString = SynchronizedMutableMapCustomLockTest::test_toString;
            this.payloads.toImmutable = SynchronizedMutableMapCustomLockTest::toImmutable;
            this.payloads.clear = SynchronizedMutableMapCustomLockTest::clear;
            this.payloads.removeObject = SynchronizedMutableMapCustomLockTest::removeObject;
            this.payloads.removeFromEntrySet = SynchronizedMutableMapCustomLockTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = SynchronizedMutableMapCustomLockTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = SynchronizedMutableMapCustomLockTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = SynchronizedMutableMapCustomLockTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = SynchronizedMutableMapCustomLockTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = SynchronizedMutableMapCustomLockTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = SynchronizedMutableMapCustomLockTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = SynchronizedMutableMapCustomLockTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = SynchronizedMutableMapCustomLockTest::retainAllFromKeySet;
            this.payloads.clearKeySet = SynchronizedMutableMapCustomLockTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = SynchronizedMutableMapCustomLockTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = SynchronizedMutableMapCustomLockTest::keySetToArray;
            this.payloads.removeFromValues = SynchronizedMutableMapCustomLockTest::removeFromValues;
            this.payloads.removeNullFromValues = SynchronizedMutableMapCustomLockTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SynchronizedMutableMapCustomLockTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SynchronizedMutableMapCustomLockTest::retainAllFromValues;
            this.payloads.put = SynchronizedMutableMapCustomLockTest::put;
            this.payloads.putAll = SynchronizedMutableMapCustomLockTest::putAll;
            this.payloads.removeKey = SynchronizedMutableMapCustomLockTest::removeKey;
            this.payloads.removeAllKeys = SynchronizedMutableMapCustomLockTest::removeAllKeys;
            this.payloads.removeIf = SynchronizedMutableMapCustomLockTest::removeIf;
            this.payloads.getIfAbsentPut = SynchronizedMutableMapCustomLockTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = SynchronizedMutableMapCustomLockTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = SynchronizedMutableMapCustomLockTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = SynchronizedMutableMapCustomLockTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = SynchronizedMutableMapCustomLockTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = SynchronizedMutableMapCustomLockTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = SynchronizedMutableMapCustomLockTest::getKeysAndGetValues;
            this.payloads.newEmpty = SynchronizedMutableMapCustomLockTest::newEmpty;
            this.payloads.keysAndValues_toString = SynchronizedMutableMapCustomLockTest::keysAndValues_toString;
            this.payloads.keyPreservation = SynchronizedMutableMapCustomLockTest::keyPreservation;
            this.payloads.asUnmodifiable = SynchronizedMutableMapCustomLockTest::asUnmodifiable;
            this.payloads.asSynchronized = SynchronizedMutableMapCustomLockTest::asSynchronized;
            this.payloads.add = SynchronizedMutableMapCustomLockTest::add;
            this.payloads.putPair = SynchronizedMutableMapCustomLockTest::putPair;
            this.payloads.withKeyValue = SynchronizedMutableMapCustomLockTest::withKeyValue;
            this.payloads.withMap = SynchronizedMutableMapCustomLockTest::withMap;
            this.payloads.withMapEmpty = SynchronizedMutableMapCustomLockTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = SynchronizedMutableMapCustomLockTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = SynchronizedMutableMapCustomLockTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = SynchronizedMutableMapCustomLockTest::withMapNull;
            this.payloads.withMapIterable = SynchronizedMutableMapCustomLockTest::withMapIterable;
            this.payloads.withMapIterableEmpty = SynchronizedMutableMapCustomLockTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = SynchronizedMutableMapCustomLockTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = SynchronizedMutableMapCustomLockTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = SynchronizedMutableMapCustomLockTest::withMapIterableNull;
            this.payloads.putAllMapIterable = SynchronizedMutableMapCustomLockTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = SynchronizedMutableMapCustomLockTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = SynchronizedMutableMapCustomLockTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = SynchronizedMutableMapCustomLockTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = SynchronizedMutableMapCustomLockTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = SynchronizedMutableMapCustomLockTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = SynchronizedMutableMapCustomLockTest::withAllKeyValueArguments;
            this.payloads.withoutKey = SynchronizedMutableMapCustomLockTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedMutableMapCustomLockTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = SynchronizedMutableMapCustomLockTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = SynchronizedMutableMapCustomLockTest::rehash_null_collision;
            this.payloads.updateValue = SynchronizedMutableMapCustomLockTest::updateValue;
            this.payloads.updateValue_collisions = SynchronizedMutableMapCustomLockTest::updateValue_collisions;
            this.payloads.updateValueWith = SynchronizedMutableMapCustomLockTest::updateValueWith;
            this.payloads.updateValueWith_collisions = SynchronizedMutableMapCustomLockTest::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = SynchronizedMutableMapCustomLockTest::collectKeysAndValues;
            this.payloads.testClone = SynchronizedMutableMapCustomLockTest::testClone;
        }
    }
*/
}
