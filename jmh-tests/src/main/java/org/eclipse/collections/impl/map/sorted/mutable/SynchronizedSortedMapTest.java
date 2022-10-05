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

/**
 * JUnit test for {@link SynchronizedSortedMap}.
 */
public class SynchronizedSortedMapTest extends MutableSortedMapTestCase {

    @Override
    public <K, V> MutableSortedMap<K, V> newMap(Comparator<? super K> comparator) {
        return new SynchronizedSortedMap<>(TreeSortedMap.newMap(comparator));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(Comparator<? super K> comparator, K key, V value) {
        return new SynchronizedSortedMap<>(TreeSortedMap.<K, V>newMap(comparator).with(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2) {
        return new SynchronizedSortedMap<>(TreeSortedMap.<K, V>newMap(comparator).with(key1, value1, key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SynchronizedSortedMap<>(TreeSortedMap.<K, V>newMap(comparator).with(key1, value1, key2, value2, key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new SynchronizedSortedMap<>(TreeSortedMap.<K, V>newMap(comparator).with(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMap() {
        return new SynchronizedSortedMap<>(TreeSortedMap.newMap());
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(K key, V value) {
        return new SynchronizedSortedMap<>(TreeSortedMap.newMapWith(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new SynchronizedSortedMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SynchronizedSortedMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new SynchronizedSortedMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedSortedMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
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
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
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
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMapWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_3);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWith_4() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWith_4);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
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
        public void benchmark_forEachWith_reverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith_reverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex_reverse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex_reverse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
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
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectMap);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_entrySet_sorted() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_sorted);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
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
        public void benchmark_putAllFromCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.firstKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedSortedMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> newMapWith_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> newMapWith_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> newMapWith_4;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEachWith_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEachWithIndex_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> entrySet_sorted;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> firstKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> lastKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> headMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> tailMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> subMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedMapTest> drop_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = SynchronizedSortedMapTest::stream;
            this.payloads.parallelStream = SynchronizedSortedMapTest::parallelStream;
            this.payloads.isEmpty = SynchronizedSortedMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedSortedMapTest::notEmpty;
            this.payloads.ifPresentApply = SynchronizedSortedMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = SynchronizedSortedMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = SynchronizedSortedMapTest::getOrDefault;
            this.payloads.getIfAbsent = SynchronizedSortedMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = SynchronizedSortedMapTest::getIfAbsentWith;
            this.payloads.forEachValue = SynchronizedSortedMapTest::forEachValue;
            this.payloads.injectIntoKeyValue = SynchronizedSortedMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = SynchronizedSortedMapTest::flipUniqueValues;
            this.payloads.collectBoolean = SynchronizedSortedMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedSortedMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = SynchronizedSortedMapTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedSortedMapTest::collectByteWithTarget;
            this.payloads.collectChar = SynchronizedSortedMapTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedSortedMapTest::collectCharWithTarget;
            this.payloads.collectDouble = SynchronizedSortedMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedSortedMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SynchronizedSortedMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedSortedMapTest::collectFloatWithTarget;
            this.payloads.collectInt = SynchronizedSortedMapTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedSortedMapTest::collectIntWithTarget;
            this.payloads.collectLong = SynchronizedSortedMapTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedSortedMapTest::collectLongWithTarget;
            this.payloads.collectShort = SynchronizedSortedMapTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedSortedMapTest::collectShortWithTarget;
            this.payloads.select = SynchronizedSortedMapTest::select;
            this.payloads.selectWith = SynchronizedSortedMapTest::selectWith;
            this.payloads.reject = SynchronizedSortedMapTest::reject;
            this.payloads.rejectWith = SynchronizedSortedMapTest::rejectWith;
            this.payloads.collect = SynchronizedSortedMapTest::collect;
            this.payloads.flatCollect = SynchronizedSortedMapTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedSortedMapTest::flatCollectWith;
            this.payloads.detect = SynchronizedSortedMapTest::detect;
            this.payloads.detectOptional = SynchronizedSortedMapTest::detectOptional;
            this.payloads.anySatisfy = SynchronizedSortedMapTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedSortedMapTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedSortedMapTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedSortedMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedSortedMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedSortedMapTest::noneSatisfyWith;
            this.payloads.appendString = SynchronizedSortedMapTest::appendString;
            this.payloads.toBag = SynchronizedSortedMapTest::toBag;
            this.payloads.toSortedBag = SynchronizedSortedMapTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedSortedMapTest::toSortedBagBy;
            this.payloads.asLazy = SynchronizedSortedMapTest::asLazy;
            this.payloads.toList = SynchronizedSortedMapTest::toList;
            this.payloads.toMap = SynchronizedSortedMapTest::toMap;
            this.payloads.toSet = SynchronizedSortedMapTest::toSet;
            this.payloads.toSortedList = SynchronizedSortedMapTest::toSortedList;
            this.payloads.toSortedListBy = SynchronizedSortedMapTest::toSortedListBy;
            this.payloads.toSortedSet = SynchronizedSortedMapTest::toSortedSet;
            this.payloads.toSortedSetBy = SynchronizedSortedMapTest::toSortedSetBy;
            this.payloads.toSortedMap = SynchronizedSortedMapTest::toSortedMap;
            this.payloads.chunk = SynchronizedSortedMapTest::chunk;
            this.payloads.collectWith = SynchronizedSortedMapTest::collectWith;
            this.payloads.collectWithToTarget = SynchronizedSortedMapTest::collectWithToTarget;
            this.payloads.contains = SynchronizedSortedMapTest::contains;
            this.payloads.containsAnyIterable = SynchronizedSortedMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedSortedMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = SynchronizedSortedMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedSortedMapTest::containsNoneCollection;
            this.payloads.containsAll = SynchronizedSortedMapTest::containsAll;
            this.payloads.containsKey = SynchronizedSortedMapTest::containsKey;
            this.payloads.containsValue = SynchronizedSortedMapTest::containsValue;
            this.payloads.getFirst = SynchronizedSortedMapTest::getFirst;
            this.payloads.getLast = SynchronizedSortedMapTest::getLast;
            this.payloads.getOnly = SynchronizedSortedMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedSortedMapTest::containsAllIterable;
            this.payloads.containsAllArguments = SynchronizedSortedMapTest::containsAllArguments;
            this.payloads.count = SynchronizedSortedMapTest::count;
            this.payloads.countWith = SynchronizedSortedMapTest::countWith;
            this.payloads.detect_value = SynchronizedSortedMapTest::detect_value;
            this.payloads.detectOptional_value = SynchronizedSortedMapTest::detectOptional_value;
            this.payloads.detectWith = SynchronizedSortedMapTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedSortedMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = SynchronizedSortedMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = SynchronizedSortedMapTest::detectWithIfNone;
            this.payloads.countBy = SynchronizedSortedMapTest::countBy;
            this.payloads.countByWith = SynchronizedSortedMapTest::countByWith;
            this.payloads.countByEach = SynchronizedSortedMapTest::countByEach;
            this.payloads.groupBy = SynchronizedSortedMapTest::groupBy;
            this.payloads.groupByEach = SynchronizedSortedMapTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedSortedMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedSortedMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = SynchronizedSortedMapTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedSortedMapTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedSortedMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = SynchronizedSortedMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = SynchronizedSortedMapTest::injectIntoDouble;
            this.payloads.sumOfInt = SynchronizedSortedMapTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedSortedMapTest::sumOfLong;
            this.payloads.testAggregateBy = SynchronizedSortedMapTest::testAggregateBy;
            this.payloads.sumOfFloat = SynchronizedSortedMapTest::sumOfFloat;
            this.payloads.sumOfDouble = SynchronizedSortedMapTest::sumOfDouble;
            this.payloads.sumByInt = SynchronizedSortedMapTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedSortedMapTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedSortedMapTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedSortedMapTest::sumByDouble;
            this.payloads.makeString = SynchronizedSortedMapTest::makeString;
            this.payloads.min = SynchronizedSortedMapTest::min;
            this.payloads.max = SynchronizedSortedMapTest::max;
            this.payloads.minBy = SynchronizedSortedMapTest::minBy;
            this.payloads.maxBy = SynchronizedSortedMapTest::maxBy;
            this.payloads.rejectWith_value = SynchronizedSortedMapTest::rejectWith_value;
            this.payloads.selectWith_value = SynchronizedSortedMapTest::selectWith_value;
            this.payloads.selectInstancesOf_value = SynchronizedSortedMapTest::selectInstancesOf_value;
            this.payloads.toArray = SynchronizedSortedMapTest::toArray;
            this.payloads.aggregateByMutating = SynchronizedSortedMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedSortedMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = SynchronizedSortedMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = SynchronizedSortedMapTest::nullCollisionWithCastInEquals;
            this.payloads.newMapWithWith = SynchronizedSortedMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = SynchronizedSortedMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = SynchronizedSortedMapTest::newMapWithWithWithWith;
            this.payloads.keysView = SynchronizedSortedMapTest::keysView;
            this.payloads.valuesView = SynchronizedSortedMapTest::valuesView;
            this.payloads.test_toString = SynchronizedSortedMapTest::test_toString;
            this.payloads.clear = SynchronizedSortedMapTest::clear;
            this.payloads.removeObject = SynchronizedSortedMapTest::removeObject;
            this.payloads.clearEntrySet = SynchronizedSortedMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = SynchronizedSortedMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = SynchronizedSortedMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = SynchronizedSortedMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = SynchronizedSortedMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = SynchronizedSortedMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = SynchronizedSortedMapTest::clearKeySet;
            this.payloads.keySetToArray = SynchronizedSortedMapTest::keySetToArray;
            this.payloads.removeFromValues = SynchronizedSortedMapTest::removeFromValues;
            this.payloads.removeNullFromValues = SynchronizedSortedMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SynchronizedSortedMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SynchronizedSortedMapTest::retainAllFromValues;
            this.payloads.removeKey = SynchronizedSortedMapTest::removeKey;
            this.payloads.removeAllKeys = SynchronizedSortedMapTest::removeAllKeys;
            this.payloads.removeIf = SynchronizedSortedMapTest::removeIf;
            this.payloads.getIfAbsentPut = SynchronizedSortedMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = SynchronizedSortedMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = SynchronizedSortedMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = SynchronizedSortedMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = SynchronizedSortedMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = SynchronizedSortedMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = SynchronizedSortedMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = SynchronizedSortedMapTest::newEmpty;
            this.payloads.keysAndValues_toString = SynchronizedSortedMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = SynchronizedSortedMapTest::keyPreservation;
            this.payloads.add = SynchronizedSortedMapTest::add;
            this.payloads.putPair = SynchronizedSortedMapTest::putPair;
            this.payloads.withKeyValue = SynchronizedSortedMapTest::withKeyValue;
            this.payloads.withMap = SynchronizedSortedMapTest::withMap;
            this.payloads.withMapEmpty = SynchronizedSortedMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = SynchronizedSortedMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = SynchronizedSortedMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = SynchronizedSortedMapTest::withMapNull;
            this.payloads.withMapIterable = SynchronizedSortedMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = SynchronizedSortedMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = SynchronizedSortedMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = SynchronizedSortedMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = SynchronizedSortedMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = SynchronizedSortedMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = SynchronizedSortedMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = SynchronizedSortedMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = SynchronizedSortedMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = SynchronizedSortedMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = SynchronizedSortedMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = SynchronizedSortedMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = SynchronizedSortedMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedSortedMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = SynchronizedSortedMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = SynchronizedSortedMapTest::rehash_null_collision;
            this.payloads.updateValue = SynchronizedSortedMapTest::updateValue;
            this.payloads.updateValue_collisions = SynchronizedSortedMapTest::updateValue_collisions;
            this.payloads.updateValueWith = SynchronizedSortedMapTest::updateValueWith;
            this.payloads.updateValueWith_collisions = SynchronizedSortedMapTest::updateValueWith_collisions;
            this.payloads.testNewEmpty = SynchronizedSortedMapTest::testNewEmpty;
            this.payloads.testNewMap = SynchronizedSortedMapTest::testNewMap;
            this.payloads.toImmutable = SynchronizedSortedMapTest::toImmutable;
            this.payloads.testNewMapWithKeyValue = SynchronizedSortedMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWith_2 = SynchronizedSortedMapTest::newMapWith_2;
            this.payloads.newMapWith_3 = SynchronizedSortedMapTest::newMapWith_3;
            this.payloads.newMapWith_4 = SynchronizedSortedMapTest::newMapWith_4;
            this.payloads.with = SynchronizedSortedMapTest::with;
            this.payloads.tap = SynchronizedSortedMapTest::tap;
            this.payloads.forEach = SynchronizedSortedMapTest::forEach;
            this.payloads.forEachWith = SynchronizedSortedMapTest::forEachWith;
            this.payloads.forEachWith_reverse = SynchronizedSortedMapTest::forEachWith_reverse;
            this.payloads.forEachWithIndex = SynchronizedSortedMapTest::forEachWithIndex;
            this.payloads.forEachWithIndex_reverse = SynchronizedSortedMapTest::forEachWithIndex_reverse;
            this.payloads.forEachKeyValue = SynchronizedSortedMapTest::forEachKeyValue;
            this.payloads.forEachKey = SynchronizedSortedMapTest::forEachKey;
            this.payloads.collectValues = SynchronizedSortedMapTest::collectValues;
            this.payloads.zipWithIndex = SynchronizedSortedMapTest::zipWithIndex;
            this.payloads.zip = SynchronizedSortedMapTest::zip;
            this.payloads.select_value = SynchronizedSortedMapTest::select_value;
            this.payloads.reject_value = SynchronizedSortedMapTest::reject_value;
            this.payloads.partition_value = SynchronizedSortedMapTest::partition_value;
            this.payloads.partitionWith_value = SynchronizedSortedMapTest::partitionWith_value;
            this.payloads.collect_value = SynchronizedSortedMapTest::collect_value;
            this.payloads.collectWithIndex = SynchronizedSortedMapTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedSortedMapTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = SynchronizedSortedMapTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = SynchronizedSortedMapTest::rejectWithIndexWithTarget;
            this.payloads.flatten_value = SynchronizedSortedMapTest::flatten_value;
            this.payloads.collectMap = SynchronizedSortedMapTest::collectMap;
            this.payloads.selectMap = SynchronizedSortedMapTest::selectMap;
            this.payloads.rejectMap = SynchronizedSortedMapTest::rejectMap;
            this.payloads.flip = SynchronizedSortedMapTest::flip;
            this.payloads.collectIf = SynchronizedSortedMapTest::collectIf;
            this.payloads.iterator = SynchronizedSortedMapTest::iterator;
            this.payloads.removeFromEntrySet = SynchronizedSortedMapTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = SynchronizedSortedMapTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = SynchronizedSortedMapTest::retainAllFromEntrySet;
            this.payloads.entrySet_sorted = SynchronizedSortedMapTest::entrySet_sorted;
            this.payloads.keySet = SynchronizedSortedMapTest::keySet;
            this.payloads.keySetEqualsAndHashCode = SynchronizedSortedMapTest::keySetEqualsAndHashCode;
            this.payloads.put = SynchronizedSortedMapTest::put;
            this.payloads.putAll = SynchronizedSortedMapTest::putAll;
            this.payloads.putAllFromCollection = SynchronizedSortedMapTest::putAllFromCollection;
            this.payloads.testEquals = SynchronizedSortedMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedSortedMapTest::testHashCode;
            this.payloads.equalsAndHashCode = SynchronizedSortedMapTest::equalsAndHashCode;
            this.payloads.serialization = SynchronizedSortedMapTest::serialization;
            this.payloads.asUnmodifiable = SynchronizedSortedMapTest::asUnmodifiable;
            this.payloads.asSynchronized = SynchronizedSortedMapTest::asSynchronized;
            this.payloads.firstKey = SynchronizedSortedMapTest::firstKey;
            this.payloads.lastKey = SynchronizedSortedMapTest::lastKey;
            this.payloads.headMap = SynchronizedSortedMapTest::headMap;
            this.payloads.tailMap = SynchronizedSortedMapTest::tailMap;
            this.payloads.subMap = SynchronizedSortedMapTest::subMap;
            this.payloads.testToString = SynchronizedSortedMapTest::testToString;
            this.payloads.testClone = SynchronizedSortedMapTest::testClone;
            this.payloads.take = SynchronizedSortedMapTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedMapTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = SynchronizedSortedMapTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedMapTest::drop_throws, java.lang.IllegalArgumentException.class);
        }
    }
}
