/*
 * Copyright (c) 2021 Bhavana Hindupur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.mutable;

import org.eclipse.collections.api.bimap.MutableBiMap;

/**
 * JUnit test for {@link SynchronizedBiMap}.
 */
public class SynchronizedBiMapCustomLockTest extends AbstractMutableBiMapTestCase {

    private static final Object LOCK = "lock";

    @Override
    public MutableBiMap<Integer, Character> classUnderTest() {
        HashBiMap<Integer, Character> map = HashBiMap.newMap();
        map.put(1, null);
        map.put(null, 'b');
        map.put(3, 'c');
        return new SynchronizedBiMap<>(map, LOCK);
    }

    @Override
    public MutableBiMap<Integer, Character> getEmptyMap() {
        return new SynchronizedBiMap<>(HashBiMap.newMap(), LOCK);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMap() {
        return new SynchronizedBiMap<>(HashBiMap.newMap(), LOCK);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key, value), LOCK);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        HashBiMap<K, V> map = HashBiMap.newWithKeysValues(key1, value1, key2, value2);
        return new SynchronizedBiMap<>(map, LOCK);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3), LOCK);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4), LOCK);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SynchronizedBiMapCustomLockTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedBiMapCustomLockTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> forcePut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapCustomLockTest> into;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = SynchronizedBiMapCustomLockTest::stream;
            this.payloads.parallelStream = SynchronizedBiMapCustomLockTest::parallelStream;
            this.payloads.serialization = SynchronizedBiMapCustomLockTest::serialization;
            this.payloads.isEmpty = SynchronizedBiMapCustomLockTest::isEmpty;
            this.payloads.notEmpty = SynchronizedBiMapCustomLockTest::notEmpty;
            this.payloads.ifPresentApply = SynchronizedBiMapCustomLockTest::ifPresentApply;
            this.payloads.getIfAbsent_function = SynchronizedBiMapCustomLockTest::getIfAbsent_function;
            this.payloads.getOrDefault = SynchronizedBiMapCustomLockTest::getOrDefault;
            this.payloads.getIfAbsent = SynchronizedBiMapCustomLockTest::getIfAbsent;
            this.payloads.getIfAbsentWith = SynchronizedBiMapCustomLockTest::getIfAbsentWith;
            this.payloads.tap = SynchronizedBiMapCustomLockTest::tap;
            this.payloads.forEach = SynchronizedBiMapCustomLockTest::forEach;
            this.payloads.forEachWith = SynchronizedBiMapCustomLockTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedBiMapCustomLockTest::forEachWithIndex;
            this.payloads.forEachKey = SynchronizedBiMapCustomLockTest::forEachKey;
            this.payloads.forEachValue = SynchronizedBiMapCustomLockTest::forEachValue;
            this.payloads.forEachKeyValue = SynchronizedBiMapCustomLockTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedBiMapCustomLockTest::injectIntoKeyValue;
            this.payloads.collectMap = SynchronizedBiMapCustomLockTest::collectMap;
            this.payloads.collectBoolean = SynchronizedBiMapCustomLockTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedBiMapCustomLockTest::collectBooleanWithTarget;
            this.payloads.collectByte = SynchronizedBiMapCustomLockTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedBiMapCustomLockTest::collectByteWithTarget;
            this.payloads.collectChar = SynchronizedBiMapCustomLockTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedBiMapCustomLockTest::collectCharWithTarget;
            this.payloads.collectDouble = SynchronizedBiMapCustomLockTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedBiMapCustomLockTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SynchronizedBiMapCustomLockTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedBiMapCustomLockTest::collectFloatWithTarget;
            this.payloads.collectInt = SynchronizedBiMapCustomLockTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedBiMapCustomLockTest::collectIntWithTarget;
            this.payloads.collectLong = SynchronizedBiMapCustomLockTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedBiMapCustomLockTest::collectLongWithTarget;
            this.payloads.collectShort = SynchronizedBiMapCustomLockTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedBiMapCustomLockTest::collectShortWithTarget;
            this.payloads.collectValues = SynchronizedBiMapCustomLockTest::collectValues;
            this.payloads.select = SynchronizedBiMapCustomLockTest::select;
            this.payloads.selectWith = SynchronizedBiMapCustomLockTest::selectWith;
            this.payloads.reject = SynchronizedBiMapCustomLockTest::reject;
            this.payloads.rejectWith = SynchronizedBiMapCustomLockTest::rejectWith;
            this.payloads.collect = SynchronizedBiMapCustomLockTest::collect;
            this.payloads.flatCollect = SynchronizedBiMapCustomLockTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedBiMapCustomLockTest::flatCollectWith;
            this.payloads.selectMap = SynchronizedBiMapCustomLockTest::selectMap;
            this.payloads.rejectMap = SynchronizedBiMapCustomLockTest::rejectMap;
            this.payloads.detect = SynchronizedBiMapCustomLockTest::detect;
            this.payloads.detectOptional = SynchronizedBiMapCustomLockTest::detectOptional;
            this.payloads.anySatisfy = SynchronizedBiMapCustomLockTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedBiMapCustomLockTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedBiMapCustomLockTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedBiMapCustomLockTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedBiMapCustomLockTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedBiMapCustomLockTest::noneSatisfyWith;
            this.payloads.appendString = SynchronizedBiMapCustomLockTest::appendString;
            this.payloads.toBag = SynchronizedBiMapCustomLockTest::toBag;
            this.payloads.toSortedBag = SynchronizedBiMapCustomLockTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedBiMapCustomLockTest::toSortedBagBy;
            this.payloads.asLazy = SynchronizedBiMapCustomLockTest::asLazy;
            this.payloads.toList = SynchronizedBiMapCustomLockTest::toList;
            this.payloads.toMap = SynchronizedBiMapCustomLockTest::toMap;
            this.payloads.toSet = SynchronizedBiMapCustomLockTest::toSet;
            this.payloads.toSortedList = SynchronizedBiMapCustomLockTest::toSortedList;
            this.payloads.toSortedListBy = SynchronizedBiMapCustomLockTest::toSortedListBy;
            this.payloads.toSortedSet = SynchronizedBiMapCustomLockTest::toSortedSet;
            this.payloads.toSortedSetBy = SynchronizedBiMapCustomLockTest::toSortedSetBy;
            this.payloads.toSortedMap = SynchronizedBiMapCustomLockTest::toSortedMap;
            this.payloads.chunk = SynchronizedBiMapCustomLockTest::chunk;
            this.payloads.collect_value = SynchronizedBiMapCustomLockTest::collect_value;
            this.payloads.collectIf = SynchronizedBiMapCustomLockTest::collectIf;
            this.payloads.collectWith = SynchronizedBiMapCustomLockTest::collectWith;
            this.payloads.collectWithToTarget = SynchronizedBiMapCustomLockTest::collectWithToTarget;
            this.payloads.contains = SynchronizedBiMapCustomLockTest::contains;
            this.payloads.containsAnyIterable = SynchronizedBiMapCustomLockTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedBiMapCustomLockTest::containsNoneIterable;
            this.payloads.containsAnyCollection = SynchronizedBiMapCustomLockTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedBiMapCustomLockTest::containsNoneCollection;
            this.payloads.containsAll = SynchronizedBiMapCustomLockTest::containsAll;
            this.payloads.getFirst = SynchronizedBiMapCustomLockTest::getFirst;
            this.payloads.getLast = SynchronizedBiMapCustomLockTest::getLast;
            this.payloads.getOnly = SynchronizedBiMapCustomLockTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapCustomLockTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapCustomLockTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedBiMapCustomLockTest::containsAllIterable;
            this.payloads.containsAllArguments = SynchronizedBiMapCustomLockTest::containsAllArguments;
            this.payloads.count = SynchronizedBiMapCustomLockTest::count;
            this.payloads.countWith = SynchronizedBiMapCustomLockTest::countWith;
            this.payloads.detect_value = SynchronizedBiMapCustomLockTest::detect_value;
            this.payloads.detectOptional_value = SynchronizedBiMapCustomLockTest::detectOptional_value;
            this.payloads.detectWith = SynchronizedBiMapCustomLockTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedBiMapCustomLockTest::detectWithOptional;
            this.payloads.detectIfNone_value = SynchronizedBiMapCustomLockTest::detectIfNone_value;
            this.payloads.detectWithIfNone = SynchronizedBiMapCustomLockTest::detectWithIfNone;
            this.payloads.flatten_value = SynchronizedBiMapCustomLockTest::flatten_value;
            this.payloads.countBy = SynchronizedBiMapCustomLockTest::countBy;
            this.payloads.countByWith = SynchronizedBiMapCustomLockTest::countByWith;
            this.payloads.countByEach = SynchronizedBiMapCustomLockTest::countByEach;
            this.payloads.groupBy = SynchronizedBiMapCustomLockTest::groupBy;
            this.payloads.groupByEach = SynchronizedBiMapCustomLockTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedBiMapCustomLockTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapCustomLockTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedBiMapCustomLockTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapCustomLockTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = SynchronizedBiMapCustomLockTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedBiMapCustomLockTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedBiMapCustomLockTest::injectIntoLong;
            this.payloads.injectIntoFloat = SynchronizedBiMapCustomLockTest::injectIntoFloat;
            this.payloads.injectIntoDouble = SynchronizedBiMapCustomLockTest::injectIntoDouble;
            this.payloads.sumOfInt = SynchronizedBiMapCustomLockTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedBiMapCustomLockTest::sumOfLong;
            this.payloads.testAggregateBy = SynchronizedBiMapCustomLockTest::testAggregateBy;
            this.payloads.sumOfFloat = SynchronizedBiMapCustomLockTest::sumOfFloat;
            this.payloads.sumOfDouble = SynchronizedBiMapCustomLockTest::sumOfDouble;
            this.payloads.sumByInt = SynchronizedBiMapCustomLockTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedBiMapCustomLockTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedBiMapCustomLockTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedBiMapCustomLockTest::sumByDouble;
            this.payloads.makeString = SynchronizedBiMapCustomLockTest::makeString;
            this.payloads.min = SynchronizedBiMapCustomLockTest::min;
            this.payloads.max = SynchronizedBiMapCustomLockTest::max;
            this.payloads.minBy = SynchronizedBiMapCustomLockTest::minBy;
            this.payloads.maxBy = SynchronizedBiMapCustomLockTest::maxBy;
            this.payloads.reject_value = SynchronizedBiMapCustomLockTest::reject_value;
            this.payloads.rejectWith_value = SynchronizedBiMapCustomLockTest::rejectWith_value;
            this.payloads.select_value = SynchronizedBiMapCustomLockTest::select_value;
            this.payloads.selectWith_value = SynchronizedBiMapCustomLockTest::selectWith_value;
            this.payloads.partition_value = SynchronizedBiMapCustomLockTest::partition_value;
            this.payloads.partitionWith_value = SynchronizedBiMapCustomLockTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = SynchronizedBiMapCustomLockTest::selectInstancesOf_value;
            this.payloads.toArray = SynchronizedBiMapCustomLockTest::toArray;
            this.payloads.zip = SynchronizedBiMapCustomLockTest::zip;
            this.payloads.zipWithIndex = SynchronizedBiMapCustomLockTest::zipWithIndex;
            this.payloads.aggregateByMutating = SynchronizedBiMapCustomLockTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedBiMapCustomLockTest::aggregateByNonMutating;
            this.payloads.keyValuesView = SynchronizedBiMapCustomLockTest::keyValuesView;
            this.payloads.testNewMap = SynchronizedBiMapCustomLockTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = SynchronizedBiMapCustomLockTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = SynchronizedBiMapCustomLockTest::newMapWithWith;
            this.payloads.newMapWithWithWith = SynchronizedBiMapCustomLockTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = SynchronizedBiMapCustomLockTest::newMapWithWithWithWith;
            this.payloads.keysView = SynchronizedBiMapCustomLockTest::keysView;
            this.payloads.valuesView = SynchronizedBiMapCustomLockTest::valuesView;
            this.payloads.test_toString = SynchronizedBiMapCustomLockTest::test_toString;
            this.payloads.toImmutable = SynchronizedBiMapCustomLockTest::toImmutable;
            this.payloads.removeObject = SynchronizedBiMapCustomLockTest::removeObject;
            this.payloads.removeFromEntrySet = SynchronizedBiMapCustomLockTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = SynchronizedBiMapCustomLockTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = SynchronizedBiMapCustomLockTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = SynchronizedBiMapCustomLockTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = SynchronizedBiMapCustomLockTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = SynchronizedBiMapCustomLockTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = SynchronizedBiMapCustomLockTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = SynchronizedBiMapCustomLockTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = SynchronizedBiMapCustomLockTest::retainAllFromKeySet;
            this.payloads.clearKeySet = SynchronizedBiMapCustomLockTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = SynchronizedBiMapCustomLockTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = SynchronizedBiMapCustomLockTest::keySetToArray;
            this.payloads.removeFromValues = SynchronizedBiMapCustomLockTest::removeFromValues;
            this.payloads.removeNullFromValues = SynchronizedBiMapCustomLockTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SynchronizedBiMapCustomLockTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SynchronizedBiMapCustomLockTest::retainAllFromValues;
            this.payloads.removeKey = SynchronizedBiMapCustomLockTest::removeKey;
            this.payloads.removeAllKeys = SynchronizedBiMapCustomLockTest::removeAllKeys;
            this.payloads.removeIf = SynchronizedBiMapCustomLockTest::removeIf;
            this.payloads.getIfAbsentPut = SynchronizedBiMapCustomLockTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = SynchronizedBiMapCustomLockTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = SynchronizedBiMapCustomLockTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = SynchronizedBiMapCustomLockTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = SynchronizedBiMapCustomLockTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = SynchronizedBiMapCustomLockTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = SynchronizedBiMapCustomLockTest::getKeysAndGetValues;
            this.payloads.newEmpty = SynchronizedBiMapCustomLockTest::newEmpty;
            this.payloads.keysAndValues_toString = SynchronizedBiMapCustomLockTest::keysAndValues_toString;
            this.payloads.keyPreservation = SynchronizedBiMapCustomLockTest::keyPreservation;
            this.payloads.asUnmodifiable = SynchronizedBiMapCustomLockTest::asUnmodifiable;
            this.payloads.asSynchronized = SynchronizedBiMapCustomLockTest::asSynchronized;
            this.payloads.add = SynchronizedBiMapCustomLockTest::add;
            this.payloads.putPair = SynchronizedBiMapCustomLockTest::putPair;
            this.payloads.withKeyValue = SynchronizedBiMapCustomLockTest::withKeyValue;
            this.payloads.withMap = SynchronizedBiMapCustomLockTest::withMap;
            this.payloads.withMapEmpty = SynchronizedBiMapCustomLockTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = SynchronizedBiMapCustomLockTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = SynchronizedBiMapCustomLockTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapIterable = SynchronizedBiMapCustomLockTest::withMapIterable;
            this.payloads.withMapIterableEmpty = SynchronizedBiMapCustomLockTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = SynchronizedBiMapCustomLockTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = SynchronizedBiMapCustomLockTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = SynchronizedBiMapCustomLockTest::withMapIterableNull;
            this.payloads.putAllMapIterable = SynchronizedBiMapCustomLockTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = SynchronizedBiMapCustomLockTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = SynchronizedBiMapCustomLockTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = SynchronizedBiMapCustomLockTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = SynchronizedBiMapCustomLockTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = SynchronizedBiMapCustomLockTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = SynchronizedBiMapCustomLockTest::withAllKeyValueArguments;
            this.payloads.withoutKey = SynchronizedBiMapCustomLockTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedBiMapCustomLockTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = SynchronizedBiMapCustomLockTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = SynchronizedBiMapCustomLockTest::rehash_null_collision;
            this.payloads.flip = SynchronizedBiMapCustomLockTest::flip;
            this.payloads.size = SynchronizedBiMapCustomLockTest::size;
            this.payloads.forcePut = SynchronizedBiMapCustomLockTest::forcePut;
            this.payloads.put = SynchronizedBiMapCustomLockTest::put;
            this.payloads.flipUniqueValues = SynchronizedBiMapCustomLockTest::flipUniqueValues;
            this.payloads.get = SynchronizedBiMapCustomLockTest::get;
            this.payloads.containsKey = SynchronizedBiMapCustomLockTest::containsKey;
            this.payloads.containsValue = SynchronizedBiMapCustomLockTest::containsValue;
            this.payloads.putAll = SynchronizedBiMapCustomLockTest::putAll;
            this.payloads.remove = SynchronizedBiMapCustomLockTest::remove;
            this.payloads.clear = SynchronizedBiMapCustomLockTest::clear;
            this.payloads.testToString = SynchronizedBiMapCustomLockTest::testToString;
            this.payloads.equalsAndHashCode = SynchronizedBiMapCustomLockTest::equalsAndHashCode;
            this.payloads.nullCollisionWithCastInEquals = SynchronizedBiMapCustomLockTest::nullCollisionWithCastInEquals;
            this.payloads.iterator = SynchronizedBiMapCustomLockTest::iterator;
            this.payloads.withMapNull = SynchronizedBiMapCustomLockTest::withMapNull;
            this.payloads.updateValueWith = SynchronizedBiMapCustomLockTest::updateValueWith;
            this.payloads.updateValue = SynchronizedBiMapCustomLockTest::updateValue;
            this.payloads.updateValue_collisions = SynchronizedBiMapCustomLockTest::updateValue_collisions;
            this.payloads.updateValueWith_collisions = SynchronizedBiMapCustomLockTest::updateValueWith_collisions;
            this.payloads.testClone = SynchronizedBiMapCustomLockTest::testClone;
            this.payloads.into = SynchronizedBiMapCustomLockTest::into;
        }
    }
}
