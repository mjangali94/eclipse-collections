/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.mutable;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SortedMapAdapter}.
 */
public class SortedMapAdapterTest extends MutableSortedMapTestCase {

    @Override
    public <K, V> MutableSortedMap<K, V> newMap(Comparator<? super K> comparator) {
        return SortedMapAdapter.adapt(new TreeMap<>(comparator));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(Comparator<? super K> comparator, K key, V value) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>(comparator)).with(Tuples.pair(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>(comparator)).with(Tuples.pair(key1, value1), Tuples.pair(key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>(comparator)).with(Tuples.pair(key1, value1), Tuples.pair(key2, value2), Tuples.pair(key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>(comparator)).with(Tuples.pair(key1, value1), Tuples.pair(key2, value2), Tuples.pair(key3, value3), Tuples.pair(key4, value4));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMap() {
        return SortedMapAdapter.adapt(new TreeMap<>());
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeyValue(K key, V value) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>()).with(Tuples.pair(key, value));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>()).with(Tuples.pair(key1, value1), Tuples.pair(key2, value2));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>()).with(Tuples.pair(key1, value1), Tuples.pair(key2, value2), Tuples.pair(key3, value3));
    }

    @Override
    public <K, V> MutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return SortedMapAdapter.adapt(new TreeMap<K, V>()).with(Tuples.pair(key1, value1), Tuples.pair(key2, value2), Tuples.pair(key3, value3), Tuples.pair(key4, value4));
    }

    @Test(expected = NullPointerException.class)
    public void testNewNull() {
        SortedMapAdapter.adapt(null);
    }

    @Test
    public void testAdapt() {
        TreeSortedMap<Integer, String> sortedMap = TreeSortedMap.newMapWith(1, "1", 2, "2");
        MutableSortedMap<Integer, String> adapt = SortedMapAdapter.adapt(sortedMap);
        Assert.assertSame(sortedMap, adapt);
        SortedMap<Integer, String> treeMap = new TreeMap<>(sortedMap);
        MutableSortedMap<Integer, String> treeAdapt = SortedMaps.adapt(treeMap);
        Assert.assertNotSame(treeMap, treeAdapt);
        Assert.assertEquals(treeMap, treeAdapt);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SortedMapAdapterTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAdapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAdapt);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new SortedMapAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> newMapWith_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> newMapWith_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> newMapWith_4;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEachWith_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEachWithIndex_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> entrySet_sorted;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> firstKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> lastKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> headMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> tailMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> subMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testNewNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedMapAdapterTest> testAdapt;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = SortedMapAdapterTest::stream;
            this.payloads.parallelStream = SortedMapAdapterTest::parallelStream;
            this.payloads.isEmpty = SortedMapAdapterTest::isEmpty;
            this.payloads.notEmpty = SortedMapAdapterTest::notEmpty;
            this.payloads.ifPresentApply = SortedMapAdapterTest::ifPresentApply;
            this.payloads.getIfAbsent_function = SortedMapAdapterTest::getIfAbsent_function;
            this.payloads.getOrDefault = SortedMapAdapterTest::getOrDefault;
            this.payloads.getIfAbsent = SortedMapAdapterTest::getIfAbsent;
            this.payloads.getIfAbsentWith = SortedMapAdapterTest::getIfAbsentWith;
            this.payloads.forEachValue = SortedMapAdapterTest::forEachValue;
            this.payloads.injectIntoKeyValue = SortedMapAdapterTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = SortedMapAdapterTest::flipUniqueValues;
            this.payloads.collectBoolean = SortedMapAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SortedMapAdapterTest::collectBooleanWithTarget;
            this.payloads.collectByte = SortedMapAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = SortedMapAdapterTest::collectByteWithTarget;
            this.payloads.collectChar = SortedMapAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = SortedMapAdapterTest::collectCharWithTarget;
            this.payloads.collectDouble = SortedMapAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SortedMapAdapterTest::collectDoubleWithTarget;
            this.payloads.collectFloat = SortedMapAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = SortedMapAdapterTest::collectFloatWithTarget;
            this.payloads.collectInt = SortedMapAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = SortedMapAdapterTest::collectIntWithTarget;
            this.payloads.collectLong = SortedMapAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = SortedMapAdapterTest::collectLongWithTarget;
            this.payloads.collectShort = SortedMapAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = SortedMapAdapterTest::collectShortWithTarget;
            this.payloads.select = SortedMapAdapterTest::select;
            this.payloads.selectWith = SortedMapAdapterTest::selectWith;
            this.payloads.reject = SortedMapAdapterTest::reject;
            this.payloads.rejectWith = SortedMapAdapterTest::rejectWith;
            this.payloads.collect = SortedMapAdapterTest::collect;
            this.payloads.flatCollect = SortedMapAdapterTest::flatCollect;
            this.payloads.flatCollectWith = SortedMapAdapterTest::flatCollectWith;
            this.payloads.detect = SortedMapAdapterTest::detect;
            this.payloads.detectOptional = SortedMapAdapterTest::detectOptional;
            this.payloads.anySatisfy = SortedMapAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = SortedMapAdapterTest::anySatisfyWith;
            this.payloads.allSatisfy = SortedMapAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = SortedMapAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = SortedMapAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SortedMapAdapterTest::noneSatisfyWith;
            this.payloads.appendString = SortedMapAdapterTest::appendString;
            this.payloads.toBag = SortedMapAdapterTest::toBag;
            this.payloads.toSortedBag = SortedMapAdapterTest::toSortedBag;
            this.payloads.toSortedBagBy = SortedMapAdapterTest::toSortedBagBy;
            this.payloads.asLazy = SortedMapAdapterTest::asLazy;
            this.payloads.toList = SortedMapAdapterTest::toList;
            this.payloads.toMap = SortedMapAdapterTest::toMap;
            this.payloads.toSet = SortedMapAdapterTest::toSet;
            this.payloads.toSortedList = SortedMapAdapterTest::toSortedList;
            this.payloads.toSortedListBy = SortedMapAdapterTest::toSortedListBy;
            this.payloads.toSortedSet = SortedMapAdapterTest::toSortedSet;
            this.payloads.toSortedSetBy = SortedMapAdapterTest::toSortedSetBy;
            this.payloads.toSortedMap = SortedMapAdapterTest::toSortedMap;
            this.payloads.chunk = SortedMapAdapterTest::chunk;
            this.payloads.collectWith = SortedMapAdapterTest::collectWith;
            this.payloads.collectWithToTarget = SortedMapAdapterTest::collectWithToTarget;
            this.payloads.contains = SortedMapAdapterTest::contains;
            this.payloads.containsAnyIterable = SortedMapAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SortedMapAdapterTest::containsNoneIterable;
            this.payloads.containsAnyCollection = SortedMapAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SortedMapAdapterTest::containsNoneCollection;
            this.payloads.containsAll = SortedMapAdapterTest::containsAll;
            this.payloads.containsKey = SortedMapAdapterTest::containsKey;
            this.payloads.containsValue = SortedMapAdapterTest::containsValue;
            this.payloads.getFirst = SortedMapAdapterTest::getFirst;
            this.payloads.getLast = SortedMapAdapterTest::getLast;
            this.payloads.getOnly = SortedMapAdapterTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedMapAdapterTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedMapAdapterTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SortedMapAdapterTest::containsAllIterable;
            this.payloads.containsAllArguments = SortedMapAdapterTest::containsAllArguments;
            this.payloads.count = SortedMapAdapterTest::count;
            this.payloads.countWith = SortedMapAdapterTest::countWith;
            this.payloads.detect_value = SortedMapAdapterTest::detect_value;
            this.payloads.detectOptional_value = SortedMapAdapterTest::detectOptional_value;
            this.payloads.detectWith = SortedMapAdapterTest::detectWith;
            this.payloads.detectWithOptional = SortedMapAdapterTest::detectWithOptional;
            this.payloads.detectIfNone_value = SortedMapAdapterTest::detectIfNone_value;
            this.payloads.detectWithIfNone = SortedMapAdapterTest::detectWithIfNone;
            this.payloads.countBy = SortedMapAdapterTest::countBy;
            this.payloads.countByWith = SortedMapAdapterTest::countByWith;
            this.payloads.countByEach = SortedMapAdapterTest::countByEach;
            this.payloads.groupBy = SortedMapAdapterTest::groupBy;
            this.payloads.groupByEach = SortedMapAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = SortedMapAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedMapAdapterTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SortedMapAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedMapAdapterTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = SortedMapAdapterTest::injectInto;
            this.payloads.injectIntoInt = SortedMapAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = SortedMapAdapterTest::injectIntoLong;
            this.payloads.injectIntoFloat = SortedMapAdapterTest::injectIntoFloat;
            this.payloads.injectIntoDouble = SortedMapAdapterTest::injectIntoDouble;
            this.payloads.sumOfInt = SortedMapAdapterTest::sumOfInt;
            this.payloads.sumOfLong = SortedMapAdapterTest::sumOfLong;
            this.payloads.testAggregateBy = SortedMapAdapterTest::testAggregateBy;
            this.payloads.sumOfFloat = SortedMapAdapterTest::sumOfFloat;
            this.payloads.sumOfDouble = SortedMapAdapterTest::sumOfDouble;
            this.payloads.sumByInt = SortedMapAdapterTest::sumByInt;
            this.payloads.sumByFloat = SortedMapAdapterTest::sumByFloat;
            this.payloads.sumByLong = SortedMapAdapterTest::sumByLong;
            this.payloads.sumByDouble = SortedMapAdapterTest::sumByDouble;
            this.payloads.makeString = SortedMapAdapterTest::makeString;
            this.payloads.min = SortedMapAdapterTest::min;
            this.payloads.max = SortedMapAdapterTest::max;
            this.payloads.minBy = SortedMapAdapterTest::minBy;
            this.payloads.maxBy = SortedMapAdapterTest::maxBy;
            this.payloads.rejectWith_value = SortedMapAdapterTest::rejectWith_value;
            this.payloads.selectWith_value = SortedMapAdapterTest::selectWith_value;
            this.payloads.selectInstancesOf_value = SortedMapAdapterTest::selectInstancesOf_value;
            this.payloads.toArray = SortedMapAdapterTest::toArray;
            this.payloads.aggregateByMutating = SortedMapAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SortedMapAdapterTest::aggregateByNonMutating;
            this.payloads.keyValuesView = SortedMapAdapterTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = SortedMapAdapterTest::nullCollisionWithCastInEquals;
            this.payloads.newMapWithWith = SortedMapAdapterTest::newMapWithWith;
            this.payloads.newMapWithWithWith = SortedMapAdapterTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = SortedMapAdapterTest::newMapWithWithWithWith;
            this.payloads.keysView = SortedMapAdapterTest::keysView;
            this.payloads.valuesView = SortedMapAdapterTest::valuesView;
            this.payloads.test_toString = SortedMapAdapterTest::test_toString;
            this.payloads.clear = SortedMapAdapterTest::clear;
            this.payloads.removeObject = SortedMapAdapterTest::removeObject;
            this.payloads.clearEntrySet = SortedMapAdapterTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = SortedMapAdapterTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = SortedMapAdapterTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = SortedMapAdapterTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = SortedMapAdapterTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = SortedMapAdapterTest::retainAllFromKeySet;
            this.payloads.clearKeySet = SortedMapAdapterTest::clearKeySet;
            this.payloads.keySetToArray = SortedMapAdapterTest::keySetToArray;
            this.payloads.removeFromValues = SortedMapAdapterTest::removeFromValues;
            this.payloads.removeNullFromValues = SortedMapAdapterTest::removeNullFromValues;
            this.payloads.removeAllFromValues = SortedMapAdapterTest::removeAllFromValues;
            this.payloads.retainAllFromValues = SortedMapAdapterTest::retainAllFromValues;
            this.payloads.removeKey = SortedMapAdapterTest::removeKey;
            this.payloads.removeAllKeys = SortedMapAdapterTest::removeAllKeys;
            this.payloads.removeIf = SortedMapAdapterTest::removeIf;
            this.payloads.getIfAbsentPut = SortedMapAdapterTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = SortedMapAdapterTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = SortedMapAdapterTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = SortedMapAdapterTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = SortedMapAdapterTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = SortedMapAdapterTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = SortedMapAdapterTest::getKeysAndGetValues;
            this.payloads.newEmpty = SortedMapAdapterTest::newEmpty;
            this.payloads.keysAndValues_toString = SortedMapAdapterTest::keysAndValues_toString;
            this.payloads.keyPreservation = SortedMapAdapterTest::keyPreservation;
            this.payloads.add = SortedMapAdapterTest::add;
            this.payloads.putPair = SortedMapAdapterTest::putPair;
            this.payloads.withKeyValue = SortedMapAdapterTest::withKeyValue;
            this.payloads.withMap = SortedMapAdapterTest::withMap;
            this.payloads.withMapEmpty = SortedMapAdapterTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = SortedMapAdapterTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = SortedMapAdapterTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = SortedMapAdapterTest::withMapNull;
            this.payloads.withMapIterable = SortedMapAdapterTest::withMapIterable;
            this.payloads.withMapIterableEmpty = SortedMapAdapterTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = SortedMapAdapterTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = SortedMapAdapterTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = SortedMapAdapterTest::withMapIterableNull;
            this.payloads.putAllMapIterable = SortedMapAdapterTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = SortedMapAdapterTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = SortedMapAdapterTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = SortedMapAdapterTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = SortedMapAdapterTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = SortedMapAdapterTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = SortedMapAdapterTest::withAllKeyValueArguments;
            this.payloads.withoutKey = SortedMapAdapterTest::withoutKey;
            this.payloads.withoutAllKeys = SortedMapAdapterTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = SortedMapAdapterTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = SortedMapAdapterTest::rehash_null_collision;
            this.payloads.updateValue = SortedMapAdapterTest::updateValue;
            this.payloads.updateValue_collisions = SortedMapAdapterTest::updateValue_collisions;
            this.payloads.updateValueWith = SortedMapAdapterTest::updateValueWith;
            this.payloads.updateValueWith_collisions = SortedMapAdapterTest::updateValueWith_collisions;
            this.payloads.testNewEmpty = SortedMapAdapterTest::testNewEmpty;
            this.payloads.testNewMap = SortedMapAdapterTest::testNewMap;
            this.payloads.toImmutable = SortedMapAdapterTest::toImmutable;
            this.payloads.testNewMapWithKeyValue = SortedMapAdapterTest::testNewMapWithKeyValue;
            this.payloads.newMapWith_2 = SortedMapAdapterTest::newMapWith_2;
            this.payloads.newMapWith_3 = SortedMapAdapterTest::newMapWith_3;
            this.payloads.newMapWith_4 = SortedMapAdapterTest::newMapWith_4;
            this.payloads.with = SortedMapAdapterTest::with;
            this.payloads.tap = SortedMapAdapterTest::tap;
            this.payloads.forEach = SortedMapAdapterTest::forEach;
            this.payloads.forEachWith = SortedMapAdapterTest::forEachWith;
            this.payloads.forEachWith_reverse = SortedMapAdapterTest::forEachWith_reverse;
            this.payloads.forEachWithIndex = SortedMapAdapterTest::forEachWithIndex;
            this.payloads.forEachWithIndex_reverse = SortedMapAdapterTest::forEachWithIndex_reverse;
            this.payloads.forEachKeyValue = SortedMapAdapterTest::forEachKeyValue;
            this.payloads.forEachKey = SortedMapAdapterTest::forEachKey;
            this.payloads.collectValues = SortedMapAdapterTest::collectValues;
            this.payloads.zipWithIndex = SortedMapAdapterTest::zipWithIndex;
            this.payloads.zip = SortedMapAdapterTest::zip;
            this.payloads.select_value = SortedMapAdapterTest::select_value;
            this.payloads.reject_value = SortedMapAdapterTest::reject_value;
            this.payloads.partition_value = SortedMapAdapterTest::partition_value;
            this.payloads.partitionWith_value = SortedMapAdapterTest::partitionWith_value;
            this.payloads.collect_value = SortedMapAdapterTest::collect_value;
            this.payloads.collectWithIndex = SortedMapAdapterTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SortedMapAdapterTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = SortedMapAdapterTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = SortedMapAdapterTest::rejectWithIndexWithTarget;
            this.payloads.flatten_value = SortedMapAdapterTest::flatten_value;
            this.payloads.collectMap = SortedMapAdapterTest::collectMap;
            this.payloads.selectMap = SortedMapAdapterTest::selectMap;
            this.payloads.rejectMap = SortedMapAdapterTest::rejectMap;
            this.payloads.flip = SortedMapAdapterTest::flip;
            this.payloads.collectIf = SortedMapAdapterTest::collectIf;
            this.payloads.iterator = SortedMapAdapterTest::iterator;
            this.payloads.removeFromEntrySet = SortedMapAdapterTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = SortedMapAdapterTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = SortedMapAdapterTest::retainAllFromEntrySet;
            this.payloads.entrySet_sorted = SortedMapAdapterTest::entrySet_sorted;
            this.payloads.keySet = SortedMapAdapterTest::keySet;
            this.payloads.keySetEqualsAndHashCode = SortedMapAdapterTest::keySetEqualsAndHashCode;
            this.payloads.put = SortedMapAdapterTest::put;
            this.payloads.putAll = SortedMapAdapterTest::putAll;
            this.payloads.putAllFromCollection = SortedMapAdapterTest::putAllFromCollection;
            this.payloads.testEquals = SortedMapAdapterTest::testEquals;
            this.payloads.testHashCode = SortedMapAdapterTest::testHashCode;
            this.payloads.equalsAndHashCode = SortedMapAdapterTest::equalsAndHashCode;
            this.payloads.serialization = SortedMapAdapterTest::serialization;
            this.payloads.asUnmodifiable = SortedMapAdapterTest::asUnmodifiable;
            this.payloads.asSynchronized = SortedMapAdapterTest::asSynchronized;
            this.payloads.firstKey = SortedMapAdapterTest::firstKey;
            this.payloads.lastKey = SortedMapAdapterTest::lastKey;
            this.payloads.headMap = SortedMapAdapterTest::headMap;
            this.payloads.tailMap = SortedMapAdapterTest::tailMap;
            this.payloads.subMap = SortedMapAdapterTest::subMap;
            this.payloads.testToString = SortedMapAdapterTest::testToString;
            this.payloads.testClone = SortedMapAdapterTest::testClone;
            this.payloads.take = SortedMapAdapterTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedMapAdapterTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = SortedMapAdapterTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedMapAdapterTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.testNewNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedMapAdapterTest::testNewNull, java.lang.NullPointerException.class);
            this.payloads.testAdapt = SortedMapAdapterTest::testAdapt;
        }
    }
}
