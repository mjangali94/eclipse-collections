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
public class SynchronizedMutableMapTest extends MutableMapTestCase {

    @Override
    public <K, V> MutableMap<K, V> newMap() {
        return new SynchronizedMutableMap<>(UnifiedMap.newMap());
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key, value));
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new SynchronizedMutableMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedMutableMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedMutableMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedMutableMapTest> testClone;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = SynchronizedMutableMapTest::stream;
            this.payloads.parallelStream = SynchronizedMutableMapTest::parallelStream;
            this.payloads.equalsAndHashCode = SynchronizedMutableMapTest::equalsAndHashCode;
            this.payloads.serialization = SynchronizedMutableMapTest::serialization;
            this.payloads.isEmpty = SynchronizedMutableMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedMutableMapTest::notEmpty;
            this.payloads.ifPresentApply = SynchronizedMutableMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = SynchronizedMutableMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = SynchronizedMutableMapTest::getOrDefault;
            this.payloads.getIfAbsent = SynchronizedMutableMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = SynchronizedMutableMapTest::getIfAbsentWith;
            this.payloads.tap = SynchronizedMutableMapTest::tap;
            this.payloads.forEach = SynchronizedMutableMapTest::forEach;
            this.payloads.forEachWith = SynchronizedMutableMapTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedMutableMapTest::forEachWithIndex;
            this.payloads.forEachKey = SynchronizedMutableMapTest::forEachKey;
            this.payloads.forEachValue = SynchronizedMutableMapTest::forEachValue;
            this.payloads.forEachKeyValue = SynchronizedMutableMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedMutableMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = SynchronizedMutableMapTest::flipUniqueValues;
            this.payloads.collectMap = SynchronizedMutableMapTest::collectMap;
            this.payloads.collectBoolean = SynchronizedMutableMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedMutableMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = SynchronizedMutableMapTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedMutableMapTest::collectByteWithTarget;
            this.payloads.collectChar = SynchronizedMutableMapTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedMutableMapTest::collectCharWithTarget;
            this.payloads.collectDouble = SynchronizedMutableMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedMutableMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SynchronizedMutableMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedMutableMapTest::collectFloatWithTarget;
            this.payloads.collectInt = SynchronizedMutableMapTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedMutableMapTest::collectIntWithTarget;
            this.payloads.collectLong = SynchronizedMutableMapTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedMutableMapTest::collectLongWithTarget;
            this.payloads.collectShort = SynchronizedMutableMapTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedMutableMapTest::collectShortWithTarget;
            this.payloads.collectValues = SynchronizedMutableMapTest::collectValues;
            this.payloads.select = SynchronizedMutableMapTest::select;
            this.payloads.selectWith = SynchronizedMutableMapTest::selectWith;
            this.payloads.reject = SynchronizedMutableMapTest::reject;
            this.payloads.rejectWith = SynchronizedMutableMapTest::rejectWith;
            this.payloads.collect = SynchronizedMutableMapTest::collect;
            this.payloads.flatCollect = SynchronizedMutableMapTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedMutableMapTest::flatCollectWith;
            this.payloads.selectMap = SynchronizedMutableMapTest::selectMap;
            this.payloads.rejectMap = SynchronizedMutableMapTest::rejectMap;
            this.payloads.flip = SynchronizedMutableMapTest::flip;
            this.payloads.detect = SynchronizedMutableMapTest::detect;
            this.payloads.detectOptional = SynchronizedMutableMapTest::detectOptional;
            this.payloads.anySatisfy = SynchronizedMutableMapTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedMutableMapTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedMutableMapTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedMutableMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedMutableMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedMutableMapTest::noneSatisfyWith;
            this.payloads.appendString = SynchronizedMutableMapTest::appendString;
            this.payloads.toBag = SynchronizedMutableMapTest::toBag;
            this.payloads.toSortedBag = SynchronizedMutableMapTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedMutableMapTest::toSortedBagBy;
            this.payloads.asLazy = SynchronizedMutableMapTest::asLazy;
            this.payloads.toList = SynchronizedMutableMapTest::toList;
            this.payloads.toMap = SynchronizedMutableMapTest::toMap;
            this.payloads.toSet = SynchronizedMutableMapTest::toSet;
            this.payloads.toSortedList = SynchronizedMutableMapTest::toSortedList;
            this.payloads.toSortedListBy = SynchronizedMutableMapTest::toSortedListBy;
            this.payloads.toSortedSet = SynchronizedMutableMapTest::toSortedSet;
            this.payloads.toSortedSetBy = SynchronizedMutableMapTest::toSortedSetBy;
            this.payloads.toSortedMap = SynchronizedMutableMapTest::toSortedMap;
            this.payloads.chunk = SynchronizedMutableMapTest::chunk;
            this.payloads.collect_value = SynchronizedMutableMapTest::collect_value;
            this.payloads.collectIf = SynchronizedMutableMapTest::collectIf;
            this.payloads.collectWith = SynchronizedMutableMapTest::collectWith;
            this.payloads.collectWithToTarget = SynchronizedMutableMapTest::collectWithToTarget;
            this.payloads.contains = SynchronizedMutableMapTest::contains;
            this.payloads.containsAnyIterable = SynchronizedMutableMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedMutableMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = SynchronizedMutableMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedMutableMapTest::containsNoneCollection;
            this.payloads.containsAll = SynchronizedMutableMapTest::containsAll;
            this.payloads.containsKey = SynchronizedMutableMapTest::containsKey;
            this.payloads.containsValue = SynchronizedMutableMapTest::containsValue;
            this.payloads.getFirst = SynchronizedMutableMapTest::getFirst;
            this.payloads.getLast = SynchronizedMutableMapTest::getLast;
            this.payloads.getOnly = SynchronizedMutableMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedMutableMapTest::containsAllIterable;
            this.payloads.containsAllArguments = SynchronizedMutableMapTest::containsAllArguments;
            this.payloads.count = SynchronizedMutableMapTest::count;
            this.payloads.countWith = SynchronizedMutableMapTest::countWith;
            this.payloads.detect_value = SynchronizedMutableMapTest::detect_value;
            this.payloads.detectOptional_value = SynchronizedMutableMapTest::detectOptional_value;
            this.payloads.detectWith = SynchronizedMutableMapTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedMutableMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = SynchronizedMutableMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = SynchronizedMutableMapTest::detectWithIfNone;
            this.payloads.flatten_value = SynchronizedMutableMapTest::flatten_value;
            this.payloads.countBy = SynchronizedMutableMapTest::countBy;
            this.payloads.countByWith = SynchronizedMutableMapTest::countByWith;
            this.payloads.countByEach = SynchronizedMutableMapTest::countByEach;
            this.payloads.groupBy = SynchronizedMutableMapTest::groupBy;
            this.payloads.groupByEach = SynchronizedMutableMapTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedMutableMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedMutableMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedMutableMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = SynchronizedMutableMapTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedMutableMapTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedMutableMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = SynchronizedMutableMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = SynchronizedMutableMapTest::injectIntoDouble;
            this.payloads.sumOfInt = SynchronizedMutableMapTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedMutableMapTest::sumOfLong;
            this.payloads.testAggregateBy = SynchronizedMutableMapTest::testAggregateBy;
            this.payloads.sumOfFloat = SynchronizedMutableMapTest::sumOfFloat;
            this.payloads.sumOfDouble = SynchronizedMutableMapTest::sumOfDouble;
            this.payloads.sumByInt = SynchronizedMutableMapTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedMutableMapTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedMutableMapTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedMutableMapTest::sumByDouble;
            this.payloads.makeString = SynchronizedMutableMapTest::makeString;
            this.payloads.min = SynchronizedMutableMapTest::min;
            this.payloads.max = SynchronizedMutableMapTest::max;
            this.payloads.minBy = SynchronizedMutableMapTest::minBy;
            this.payloads.maxBy = SynchronizedMutableMapTest::maxBy;
            this.payloads.reject_value = SynchronizedMutableMapTest::reject_value;
            this.payloads.rejectWith_value = SynchronizedMutableMapTest::rejectWith_value;
            this.payloads.select_value = SynchronizedMutableMapTest::select_value;
            this.payloads.selectWith_value = SynchronizedMutableMapTest::selectWith_value;
            this.payloads.partition_value = SynchronizedMutableMapTest::partition_value;
            this.payloads.partitionWith_value = SynchronizedMutableMapTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = SynchronizedMutableMapTest::selectInstancesOf_value;
            this.payloads.toArray = SynchronizedMutableMapTest::toArray;
            this.payloads.zip = SynchronizedMutableMapTest::zip;
            this.payloads.zipWithIndex = SynchronizedMutableMapTest::zipWithIndex;
            this.payloads.aggregateByMutating = SynchronizedMutableMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedMutableMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = SynchronizedMutableMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = SynchronizedMutableMapTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = SynchronizedMutableMapTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = SynchronizedMutableMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = SynchronizedMutableMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = SynchronizedMutableMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = SynchronizedMutableMapTest::newMapWithWithWithWith;
            this.payloads.iterator = SynchronizedMutableMapTest::iterator;
            this.payloads.keysView = SynchronizedMutableMapTest::keysView;
            this.payloads.valuesView = SynchronizedMutableMapTest::valuesView;
            this.payloads.test_toString = SynchronizedMutableMapTest::test_toString;
            this.payloads.toImmutable = SynchronizedMutableMapTest::toImmutable;
            this.payloads.clear = SynchronizedMutableMapTest::clear;
            this.payloads.removeObject = SynchronizedMutableMapTest::removeObject;
            this.payloads.removeFromEntrySet = SynchronizedMutableMapTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = SynchronizedMutableMapTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = SynchronizedMutableMapTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = SynchronizedMutableMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = SynchronizedMutableMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = SynchronizedMutableMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = SynchronizedMutableMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = SynchronizedMutableMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = SynchronizedMutableMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = SynchronizedMutableMapTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = SynchronizedMutableMapTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = SynchronizedMutableMapTest::keySetToArray;
            this.payloads.removeFromValues = SynchronizedMutableMapTest::removeFromValues;
            this.payloads.removeNullFromValues = SynchronizedMutableMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SynchronizedMutableMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SynchronizedMutableMapTest::retainAllFromValues;
            this.payloads.put = SynchronizedMutableMapTest::put;
            this.payloads.putAll = SynchronizedMutableMapTest::putAll;
            this.payloads.removeKey = SynchronizedMutableMapTest::removeKey;
            this.payloads.removeAllKeys = SynchronizedMutableMapTest::removeAllKeys;
            this.payloads.removeIf = SynchronizedMutableMapTest::removeIf;
            this.payloads.getIfAbsentPut = SynchronizedMutableMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = SynchronizedMutableMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = SynchronizedMutableMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = SynchronizedMutableMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = SynchronizedMutableMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = SynchronizedMutableMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = SynchronizedMutableMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = SynchronizedMutableMapTest::newEmpty;
            this.payloads.keysAndValues_toString = SynchronizedMutableMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = SynchronizedMutableMapTest::keyPreservation;
            this.payloads.asUnmodifiable = SynchronizedMutableMapTest::asUnmodifiable;
            this.payloads.asSynchronized = SynchronizedMutableMapTest::asSynchronized;
            this.payloads.add = SynchronizedMutableMapTest::add;
            this.payloads.putPair = SynchronizedMutableMapTest::putPair;
            this.payloads.withKeyValue = SynchronizedMutableMapTest::withKeyValue;
            this.payloads.withMap = SynchronizedMutableMapTest::withMap;
            this.payloads.withMapEmpty = SynchronizedMutableMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = SynchronizedMutableMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = SynchronizedMutableMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = SynchronizedMutableMapTest::withMapNull;
            this.payloads.withMapIterable = SynchronizedMutableMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = SynchronizedMutableMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = SynchronizedMutableMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = SynchronizedMutableMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = SynchronizedMutableMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = SynchronizedMutableMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = SynchronizedMutableMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = SynchronizedMutableMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = SynchronizedMutableMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = SynchronizedMutableMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = SynchronizedMutableMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = SynchronizedMutableMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = SynchronizedMutableMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedMutableMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = SynchronizedMutableMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = SynchronizedMutableMapTest::rehash_null_collision;
            this.payloads.updateValue = SynchronizedMutableMapTest::updateValue;
            this.payloads.updateValue_collisions = SynchronizedMutableMapTest::updateValue_collisions;
            this.payloads.updateValueWith = SynchronizedMutableMapTest::updateValueWith;
            this.payloads.updateValueWith_collisions = SynchronizedMutableMapTest::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = SynchronizedMutableMapTest::collectKeysAndValues;
            this.payloads.testClone = SynchronizedMutableMapTest::testClone;
        }
    }
*/
}
