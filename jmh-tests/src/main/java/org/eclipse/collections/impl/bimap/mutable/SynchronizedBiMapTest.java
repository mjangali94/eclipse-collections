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
public class SynchronizedBiMapTest extends AbstractMutableBiMapTestCase {

    @Override
    public MutableBiMap<Integer, Character> classUnderTest() {
        HashBiMap<Integer, Character> map = HashBiMap.newMap();
        map.put(1, null);
        map.put(null, 'b');
        map.put(3, 'c');
        return new SynchronizedBiMap<>(map);
    }

    @Override
    public MutableBiMap<Integer, Character> getEmptyMap() {
        return new SynchronizedBiMap<>(HashBiMap.newMap());
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMap() {
        return new SynchronizedBiMap<>(HashBiMap.newMap());
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key, value));
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        HashBiMap<K, V> map = HashBiMap.newWithKeysValues(key1, value1, key2, value2);
        return new SynchronizedBiMap<>(map);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SynchronizedBiMapTest instance;

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

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedBiMapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> forcePut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBiMapTest> into;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = SynchronizedBiMapTest::stream;
            this.payloads.parallelStream = SynchronizedBiMapTest::parallelStream;
            this.payloads.serialization = SynchronizedBiMapTest::serialization;
            this.payloads.isEmpty = SynchronizedBiMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedBiMapTest::notEmpty;
            this.payloads.ifPresentApply = SynchronizedBiMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = SynchronizedBiMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = SynchronizedBiMapTest::getOrDefault;
            this.payloads.getIfAbsent = SynchronizedBiMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = SynchronizedBiMapTest::getIfAbsentWith;
            this.payloads.tap = SynchronizedBiMapTest::tap;
            this.payloads.forEach = SynchronizedBiMapTest::forEach;
            this.payloads.forEachWith = SynchronizedBiMapTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedBiMapTest::forEachWithIndex;
            this.payloads.forEachKey = SynchronizedBiMapTest::forEachKey;
            this.payloads.forEachValue = SynchronizedBiMapTest::forEachValue;
            this.payloads.forEachKeyValue = SynchronizedBiMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedBiMapTest::injectIntoKeyValue;
            this.payloads.collectMap = SynchronizedBiMapTest::collectMap;
            this.payloads.collectBoolean = SynchronizedBiMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedBiMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = SynchronizedBiMapTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedBiMapTest::collectByteWithTarget;
            this.payloads.collectChar = SynchronizedBiMapTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedBiMapTest::collectCharWithTarget;
            this.payloads.collectDouble = SynchronizedBiMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedBiMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SynchronizedBiMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedBiMapTest::collectFloatWithTarget;
            this.payloads.collectInt = SynchronizedBiMapTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedBiMapTest::collectIntWithTarget;
            this.payloads.collectLong = SynchronizedBiMapTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedBiMapTest::collectLongWithTarget;
            this.payloads.collectShort = SynchronizedBiMapTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedBiMapTest::collectShortWithTarget;
            this.payloads.collectValues = SynchronizedBiMapTest::collectValues;
            this.payloads.select = SynchronizedBiMapTest::select;
            this.payloads.selectWith = SynchronizedBiMapTest::selectWith;
            this.payloads.reject = SynchronizedBiMapTest::reject;
            this.payloads.rejectWith = SynchronizedBiMapTest::rejectWith;
            this.payloads.collect = SynchronizedBiMapTest::collect;
            this.payloads.flatCollect = SynchronizedBiMapTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedBiMapTest::flatCollectWith;
            this.payloads.selectMap = SynchronizedBiMapTest::selectMap;
            this.payloads.rejectMap = SynchronizedBiMapTest::rejectMap;
            this.payloads.detect = SynchronizedBiMapTest::detect;
            this.payloads.detectOptional = SynchronizedBiMapTest::detectOptional;
            this.payloads.anySatisfy = SynchronizedBiMapTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedBiMapTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedBiMapTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedBiMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedBiMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedBiMapTest::noneSatisfyWith;
            this.payloads.appendString = SynchronizedBiMapTest::appendString;
            this.payloads.toBag = SynchronizedBiMapTest::toBag;
            this.payloads.toSortedBag = SynchronizedBiMapTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedBiMapTest::toSortedBagBy;
            this.payloads.asLazy = SynchronizedBiMapTest::asLazy;
            this.payloads.toList = SynchronizedBiMapTest::toList;
            this.payloads.toMap = SynchronizedBiMapTest::toMap;
            this.payloads.toSet = SynchronizedBiMapTest::toSet;
            this.payloads.toSortedList = SynchronizedBiMapTest::toSortedList;
            this.payloads.toSortedListBy = SynchronizedBiMapTest::toSortedListBy;
            this.payloads.toSortedSet = SynchronizedBiMapTest::toSortedSet;
            this.payloads.toSortedSetBy = SynchronizedBiMapTest::toSortedSetBy;
            this.payloads.toSortedMap = SynchronizedBiMapTest::toSortedMap;
            this.payloads.chunk = SynchronizedBiMapTest::chunk;
            this.payloads.collect_value = SynchronizedBiMapTest::collect_value;
            this.payloads.collectIf = SynchronizedBiMapTest::collectIf;
            this.payloads.collectWith = SynchronizedBiMapTest::collectWith;
            this.payloads.collectWithToTarget = SynchronizedBiMapTest::collectWithToTarget;
            this.payloads.contains = SynchronizedBiMapTest::contains;
            this.payloads.containsAnyIterable = SynchronizedBiMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedBiMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = SynchronizedBiMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedBiMapTest::containsNoneCollection;
            this.payloads.containsAll = SynchronizedBiMapTest::containsAll;
            this.payloads.getFirst = SynchronizedBiMapTest::getFirst;
            this.payloads.getLast = SynchronizedBiMapTest::getLast;
            this.payloads.getOnly = SynchronizedBiMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedBiMapTest::containsAllIterable;
            this.payloads.containsAllArguments = SynchronizedBiMapTest::containsAllArguments;
            this.payloads.count = SynchronizedBiMapTest::count;
            this.payloads.countWith = SynchronizedBiMapTest::countWith;
            this.payloads.detect_value = SynchronizedBiMapTest::detect_value;
            this.payloads.detectOptional_value = SynchronizedBiMapTest::detectOptional_value;
            this.payloads.detectWith = SynchronizedBiMapTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedBiMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = SynchronizedBiMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = SynchronizedBiMapTest::detectWithIfNone;
            this.payloads.flatten_value = SynchronizedBiMapTest::flatten_value;
            this.payloads.countBy = SynchronizedBiMapTest::countBy;
            this.payloads.countByWith = SynchronizedBiMapTest::countByWith;
            this.payloads.countByEach = SynchronizedBiMapTest::countByEach;
            this.payloads.groupBy = SynchronizedBiMapTest::groupBy;
            this.payloads.groupByEach = SynchronizedBiMapTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedBiMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedBiMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBiMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = SynchronizedBiMapTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedBiMapTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedBiMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = SynchronizedBiMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = SynchronizedBiMapTest::injectIntoDouble;
            this.payloads.sumOfInt = SynchronizedBiMapTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedBiMapTest::sumOfLong;
            this.payloads.testAggregateBy = SynchronizedBiMapTest::testAggregateBy;
            this.payloads.sumOfFloat = SynchronizedBiMapTest::sumOfFloat;
            this.payloads.sumOfDouble = SynchronizedBiMapTest::sumOfDouble;
            this.payloads.sumByInt = SynchronizedBiMapTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedBiMapTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedBiMapTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedBiMapTest::sumByDouble;
            this.payloads.makeString = SynchronizedBiMapTest::makeString;
            this.payloads.min = SynchronizedBiMapTest::min;
            this.payloads.max = SynchronizedBiMapTest::max;
            this.payloads.minBy = SynchronizedBiMapTest::minBy;
            this.payloads.maxBy = SynchronizedBiMapTest::maxBy;
            this.payloads.reject_value = SynchronizedBiMapTest::reject_value;
            this.payloads.rejectWith_value = SynchronizedBiMapTest::rejectWith_value;
            this.payloads.select_value = SynchronizedBiMapTest::select_value;
            this.payloads.selectWith_value = SynchronizedBiMapTest::selectWith_value;
            this.payloads.partition_value = SynchronizedBiMapTest::partition_value;
            this.payloads.partitionWith_value = SynchronizedBiMapTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = SynchronizedBiMapTest::selectInstancesOf_value;
            this.payloads.toArray = SynchronizedBiMapTest::toArray;
            this.payloads.zip = SynchronizedBiMapTest::zip;
            this.payloads.zipWithIndex = SynchronizedBiMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = SynchronizedBiMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedBiMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = SynchronizedBiMapTest::keyValuesView;
            this.payloads.testNewMap = SynchronizedBiMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = SynchronizedBiMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = SynchronizedBiMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = SynchronizedBiMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = SynchronizedBiMapTest::newMapWithWithWithWith;
            this.payloads.keysView = SynchronizedBiMapTest::keysView;
            this.payloads.valuesView = SynchronizedBiMapTest::valuesView;
            this.payloads.test_toString = SynchronizedBiMapTest::test_toString;
            this.payloads.toImmutable = SynchronizedBiMapTest::toImmutable;
            this.payloads.removeObject = SynchronizedBiMapTest::removeObject;
            this.payloads.removeFromEntrySet = SynchronizedBiMapTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = SynchronizedBiMapTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = SynchronizedBiMapTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = SynchronizedBiMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = SynchronizedBiMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = SynchronizedBiMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = SynchronizedBiMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = SynchronizedBiMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = SynchronizedBiMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = SynchronizedBiMapTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = SynchronizedBiMapTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = SynchronizedBiMapTest::keySetToArray;
            this.payloads.removeFromValues = SynchronizedBiMapTest::removeFromValues;
            this.payloads.removeNullFromValues = SynchronizedBiMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SynchronizedBiMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SynchronizedBiMapTest::retainAllFromValues;
            this.payloads.removeKey = SynchronizedBiMapTest::removeKey;
            this.payloads.removeAllKeys = SynchronizedBiMapTest::removeAllKeys;
            this.payloads.removeIf = SynchronizedBiMapTest::removeIf;
            this.payloads.getIfAbsentPut = SynchronizedBiMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = SynchronizedBiMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = SynchronizedBiMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = SynchronizedBiMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = SynchronizedBiMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = SynchronizedBiMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = SynchronizedBiMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = SynchronizedBiMapTest::newEmpty;
            this.payloads.keysAndValues_toString = SynchronizedBiMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = SynchronizedBiMapTest::keyPreservation;
            this.payloads.asUnmodifiable = SynchronizedBiMapTest::asUnmodifiable;
            this.payloads.asSynchronized = SynchronizedBiMapTest::asSynchronized;
            this.payloads.add = SynchronizedBiMapTest::add;
            this.payloads.putPair = SynchronizedBiMapTest::putPair;
            this.payloads.withKeyValue = SynchronizedBiMapTest::withKeyValue;
            this.payloads.withMap = SynchronizedBiMapTest::withMap;
            this.payloads.withMapEmpty = SynchronizedBiMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = SynchronizedBiMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = SynchronizedBiMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapIterable = SynchronizedBiMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = SynchronizedBiMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = SynchronizedBiMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = SynchronizedBiMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = SynchronizedBiMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = SynchronizedBiMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = SynchronizedBiMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = SynchronizedBiMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = SynchronizedBiMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = SynchronizedBiMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = SynchronizedBiMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = SynchronizedBiMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = SynchronizedBiMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedBiMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = SynchronizedBiMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = SynchronizedBiMapTest::rehash_null_collision;
            this.payloads.flip = SynchronizedBiMapTest::flip;
            this.payloads.size = SynchronizedBiMapTest::size;
            this.payloads.forcePut = SynchronizedBiMapTest::forcePut;
            this.payloads.put = SynchronizedBiMapTest::put;
            this.payloads.flipUniqueValues = SynchronizedBiMapTest::flipUniqueValues;
            this.payloads.get = SynchronizedBiMapTest::get;
            this.payloads.containsKey = SynchronizedBiMapTest::containsKey;
            this.payloads.containsValue = SynchronizedBiMapTest::containsValue;
            this.payloads.putAll = SynchronizedBiMapTest::putAll;
            this.payloads.remove = SynchronizedBiMapTest::remove;
            this.payloads.clear = SynchronizedBiMapTest::clear;
            this.payloads.testToString = SynchronizedBiMapTest::testToString;
            this.payloads.equalsAndHashCode = SynchronizedBiMapTest::equalsAndHashCode;
            this.payloads.nullCollisionWithCastInEquals = SynchronizedBiMapTest::nullCollisionWithCastInEquals;
            this.payloads.iterator = SynchronizedBiMapTest::iterator;
            this.payloads.withMapNull = SynchronizedBiMapTest::withMapNull;
            this.payloads.updateValueWith = SynchronizedBiMapTest::updateValueWith;
            this.payloads.updateValue = SynchronizedBiMapTest::updateValue;
            this.payloads.updateValue_collisions = SynchronizedBiMapTest::updateValue_collisions;
            this.payloads.updateValueWith_collisions = SynchronizedBiMapTest::updateValueWith_collisions;
            this.payloads.testClone = SynchronizedBiMapTest::testClone;
            this.payloads.into = SynchronizedBiMapTest::into;
        }
    }
}
