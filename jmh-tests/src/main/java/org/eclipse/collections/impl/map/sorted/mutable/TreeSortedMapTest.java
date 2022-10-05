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
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class TreeSortedMapTest extends MutableSortedMapTestCase {

    @Override
    public <K, V> TreeSortedMap<K, V> newMap() {
        return TreeSortedMap.newMap();
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeyValue(K key, V value) {
        return TreeSortedMap.newMapWith(key, value);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return TreeSortedMap.newMapWith(key1, value1, key2, value2);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMap(Comparator<? super K> comparator) {
        return TreeSortedMap.newMap(comparator);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeyValue(Comparator<? super K> comparator, K key, V value) {
        return TreeSortedMap.<K, V>newMap(comparator).with(key, value);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2) {
        return TreeSortedMap.<K, V>newMap(comparator).with(key1, value1, key2, value2);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3) {
        return TreeSortedMap.<K, V>newMap(comparator).with(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <K, V> TreeSortedMap<K, V> newMapWithKeysValues(Comparator<? super K> comparator, K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return TreeSortedMap.<K, V>newMap(comparator).with(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Test
    public void testConstructors() {
        UnifiedMap<Integer, String> unifiedMap = UnifiedMap.newWithKeysValues(1, "One", 2, "Two", 3, "Three");
        TreeSortedMap<Integer, String> sortedMap = TreeSortedMap.newMap(unifiedMap);
        TreeSortedMap<Integer, String> revSortedMap = TreeSortedMap.newMap(Comparators.reverseNaturalOrder(), unifiedMap);
        Verify.assertMapsEqual(unifiedMap, sortedMap);
        Verify.assertMapsEqual(unifiedMap, revSortedMap);
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3), sortedMap.keySet().toList());
        Verify.assertListsEqual(FastList.newListWith(3, 2, 1), revSortedMap.keySet().toList());
        TreeSortedMap<Integer, String> sortedMap2 = TreeSortedMap.newMap(revSortedMap);
        Assert.assertEquals(revSortedMap.comparator(), sortedMap2.comparator());
        Verify.assertMapsEqual(revSortedMap, sortedMap2);
    }

    @Test
    public void newMapWithPairs() {
        TreeSortedMap<Integer, Integer> revSortedMap = TreeSortedMap.newMapWith(Comparators.<Integer>reverseNaturalOrder(), Tuples.pair(1, 4), Tuples.pair(2, 3), Tuples.pair(3, 2), Tuples.pair(4, 1));
        Verify.assertSize(4, revSortedMap);
        Verify.assertMapsEqual(UnifiedMap.newMapWith(Tuples.pair(1, 4), Tuples.pair(2, 3), Tuples.pair(3, 2), Tuples.pair(4, 1)), revSortedMap);
        Verify.assertListsEqual(FastList.newListWith(4, 3, 2, 1), revSortedMap.keySet().toList());
        Verify.assertListsEqual(FastList.newListWith(1, 2, 3, 4), revSortedMap.valuesView().toList());
    }

    @Override
    @Test
    public void testClone() {
        super.testClone();
        TreeSortedMap<Integer, Integer> sortedMap = TreeSortedMap.<Integer, Integer>newMapWith(Tuples.pair(1, 4), Tuples.pair(2, 3), Tuples.pair(3, 2), Tuples.pair(4, 1));
        MutableSortedMap<Integer, Integer> clone = sortedMap.clone();
        Assert.assertNotSame(sortedMap, clone);
        Assert.assertEquals(sortedMap, clone);
        sortedMap.removeKey(1);
        Assert.assertTrue(clone.containsKey(1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TreeSortedMapTest instance;

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
        public void benchmark_testConstructors() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testConstructors);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> payload) throws java.lang.Throwable {
            this.instance = new TreeSortedMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newMapWith_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newMapWith_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newMapWith_4;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEachWith_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEachWithIndex_reverse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> entrySet_sorted;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> firstKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> lastKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> headMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> tailMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> subMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testConstructors;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> newMapWithPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedMapTest> testClone;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = TreeSortedMapTest::stream;
            this.payloads.parallelStream = TreeSortedMapTest::parallelStream;
            this.payloads.isEmpty = TreeSortedMapTest::isEmpty;
            this.payloads.notEmpty = TreeSortedMapTest::notEmpty;
            this.payloads.ifPresentApply = TreeSortedMapTest::ifPresentApply;
            this.payloads.getIfAbsent_function = TreeSortedMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = TreeSortedMapTest::getOrDefault;
            this.payloads.getIfAbsent = TreeSortedMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = TreeSortedMapTest::getIfAbsentWith;
            this.payloads.forEachValue = TreeSortedMapTest::forEachValue;
            this.payloads.injectIntoKeyValue = TreeSortedMapTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = TreeSortedMapTest::flipUniqueValues;
            this.payloads.collectBoolean = TreeSortedMapTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = TreeSortedMapTest::collectBooleanWithTarget;
            this.payloads.collectByte = TreeSortedMapTest::collectByte;
            this.payloads.collectByteWithTarget = TreeSortedMapTest::collectByteWithTarget;
            this.payloads.collectChar = TreeSortedMapTest::collectChar;
            this.payloads.collectCharWithTarget = TreeSortedMapTest::collectCharWithTarget;
            this.payloads.collectDouble = TreeSortedMapTest::collectDouble;
            this.payloads.collectDoubleWithTarget = TreeSortedMapTest::collectDoubleWithTarget;
            this.payloads.collectFloat = TreeSortedMapTest::collectFloat;
            this.payloads.collectFloatWithTarget = TreeSortedMapTest::collectFloatWithTarget;
            this.payloads.collectInt = TreeSortedMapTest::collectInt;
            this.payloads.collectIntWithTarget = TreeSortedMapTest::collectIntWithTarget;
            this.payloads.collectLong = TreeSortedMapTest::collectLong;
            this.payloads.collectLongWithTarget = TreeSortedMapTest::collectLongWithTarget;
            this.payloads.collectShort = TreeSortedMapTest::collectShort;
            this.payloads.collectShortWithTarget = TreeSortedMapTest::collectShortWithTarget;
            this.payloads.select = TreeSortedMapTest::select;
            this.payloads.selectWith = TreeSortedMapTest::selectWith;
            this.payloads.reject = TreeSortedMapTest::reject;
            this.payloads.rejectWith = TreeSortedMapTest::rejectWith;
            this.payloads.collect = TreeSortedMapTest::collect;
            this.payloads.flatCollect = TreeSortedMapTest::flatCollect;
            this.payloads.flatCollectWith = TreeSortedMapTest::flatCollectWith;
            this.payloads.detect = TreeSortedMapTest::detect;
            this.payloads.detectOptional = TreeSortedMapTest::detectOptional;
            this.payloads.anySatisfy = TreeSortedMapTest::anySatisfy;
            this.payloads.anySatisfyWith = TreeSortedMapTest::anySatisfyWith;
            this.payloads.allSatisfy = TreeSortedMapTest::allSatisfy;
            this.payloads.allSatisfyWith = TreeSortedMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = TreeSortedMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = TreeSortedMapTest::noneSatisfyWith;
            this.payloads.appendString = TreeSortedMapTest::appendString;
            this.payloads.toBag = TreeSortedMapTest::toBag;
            this.payloads.toSortedBag = TreeSortedMapTest::toSortedBag;
            this.payloads.toSortedBagBy = TreeSortedMapTest::toSortedBagBy;
            this.payloads.asLazy = TreeSortedMapTest::asLazy;
            this.payloads.toList = TreeSortedMapTest::toList;
            this.payloads.toMap = TreeSortedMapTest::toMap;
            this.payloads.toSet = TreeSortedMapTest::toSet;
            this.payloads.toSortedList = TreeSortedMapTest::toSortedList;
            this.payloads.toSortedListBy = TreeSortedMapTest::toSortedListBy;
            this.payloads.toSortedSet = TreeSortedMapTest::toSortedSet;
            this.payloads.toSortedSetBy = TreeSortedMapTest::toSortedSetBy;
            this.payloads.toSortedMap = TreeSortedMapTest::toSortedMap;
            this.payloads.chunk = TreeSortedMapTest::chunk;
            this.payloads.collectWith = TreeSortedMapTest::collectWith;
            this.payloads.collectWithToTarget = TreeSortedMapTest::collectWithToTarget;
            this.payloads.contains = TreeSortedMapTest::contains;
            this.payloads.containsAnyIterable = TreeSortedMapTest::containsAnyIterable;
            this.payloads.containsNoneIterable = TreeSortedMapTest::containsNoneIterable;
            this.payloads.containsAnyCollection = TreeSortedMapTest::containsAnyCollection;
            this.payloads.containsNoneCollection = TreeSortedMapTest::containsNoneCollection;
            this.payloads.containsAll = TreeSortedMapTest::containsAll;
            this.payloads.containsKey = TreeSortedMapTest::containsKey;
            this.payloads.containsValue = TreeSortedMapTest::containsValue;
            this.payloads.getFirst = TreeSortedMapTest::getFirst;
            this.payloads.getLast = TreeSortedMapTest::getLast;
            this.payloads.getOnly = TreeSortedMapTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedMapTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedMapTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = TreeSortedMapTest::containsAllIterable;
            this.payloads.containsAllArguments = TreeSortedMapTest::containsAllArguments;
            this.payloads.count = TreeSortedMapTest::count;
            this.payloads.countWith = TreeSortedMapTest::countWith;
            this.payloads.detect_value = TreeSortedMapTest::detect_value;
            this.payloads.detectOptional_value = TreeSortedMapTest::detectOptional_value;
            this.payloads.detectWith = TreeSortedMapTest::detectWith;
            this.payloads.detectWithOptional = TreeSortedMapTest::detectWithOptional;
            this.payloads.detectIfNone_value = TreeSortedMapTest::detectIfNone_value;
            this.payloads.detectWithIfNone = TreeSortedMapTest::detectWithIfNone;
            this.payloads.countBy = TreeSortedMapTest::countBy;
            this.payloads.countByWith = TreeSortedMapTest::countByWith;
            this.payloads.countByEach = TreeSortedMapTest::countByEach;
            this.payloads.groupBy = TreeSortedMapTest::groupBy;
            this.payloads.groupByEach = TreeSortedMapTest::groupByEach;
            this.payloads.groupByUniqueKey = TreeSortedMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = TreeSortedMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedMapTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = TreeSortedMapTest::injectInto;
            this.payloads.injectIntoInt = TreeSortedMapTest::injectIntoInt;
            this.payloads.injectIntoLong = TreeSortedMapTest::injectIntoLong;
            this.payloads.injectIntoFloat = TreeSortedMapTest::injectIntoFloat;
            this.payloads.injectIntoDouble = TreeSortedMapTest::injectIntoDouble;
            this.payloads.sumOfInt = TreeSortedMapTest::sumOfInt;
            this.payloads.sumOfLong = TreeSortedMapTest::sumOfLong;
            this.payloads.testAggregateBy = TreeSortedMapTest::testAggregateBy;
            this.payloads.sumOfFloat = TreeSortedMapTest::sumOfFloat;
            this.payloads.sumOfDouble = TreeSortedMapTest::sumOfDouble;
            this.payloads.sumByInt = TreeSortedMapTest::sumByInt;
            this.payloads.sumByFloat = TreeSortedMapTest::sumByFloat;
            this.payloads.sumByLong = TreeSortedMapTest::sumByLong;
            this.payloads.sumByDouble = TreeSortedMapTest::sumByDouble;
            this.payloads.makeString = TreeSortedMapTest::makeString;
            this.payloads.min = TreeSortedMapTest::min;
            this.payloads.max = TreeSortedMapTest::max;
            this.payloads.minBy = TreeSortedMapTest::minBy;
            this.payloads.maxBy = TreeSortedMapTest::maxBy;
            this.payloads.rejectWith_value = TreeSortedMapTest::rejectWith_value;
            this.payloads.selectWith_value = TreeSortedMapTest::selectWith_value;
            this.payloads.selectInstancesOf_value = TreeSortedMapTest::selectInstancesOf_value;
            this.payloads.toArray = TreeSortedMapTest::toArray;
            this.payloads.aggregateByMutating = TreeSortedMapTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = TreeSortedMapTest::aggregateByNonMutating;
            this.payloads.keyValuesView = TreeSortedMapTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = TreeSortedMapTest::nullCollisionWithCastInEquals;
            this.payloads.newMapWithWith = TreeSortedMapTest::newMapWithWith;
            this.payloads.newMapWithWithWith = TreeSortedMapTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = TreeSortedMapTest::newMapWithWithWithWith;
            this.payloads.keysView = TreeSortedMapTest::keysView;
            this.payloads.valuesView = TreeSortedMapTest::valuesView;
            this.payloads.test_toString = TreeSortedMapTest::test_toString;
            this.payloads.clear = TreeSortedMapTest::clear;
            this.payloads.removeObject = TreeSortedMapTest::removeObject;
            this.payloads.clearEntrySet = TreeSortedMapTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = TreeSortedMapTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = TreeSortedMapTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = TreeSortedMapTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = TreeSortedMapTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = TreeSortedMapTest::retainAllFromKeySet;
            this.payloads.clearKeySet = TreeSortedMapTest::clearKeySet;
            this.payloads.keySetToArray = TreeSortedMapTest::keySetToArray;
            this.payloads.removeFromValues = TreeSortedMapTest::removeFromValues;
            this.payloads.removeNullFromValues = TreeSortedMapTest::removeNullFromValues;
            this.payloads.removeAllFromValues = TreeSortedMapTest::removeAllFromValues;
            this.payloads.retainAllFromValues = TreeSortedMapTest::retainAllFromValues;
            this.payloads.removeKey = TreeSortedMapTest::removeKey;
            this.payloads.removeAllKeys = TreeSortedMapTest::removeAllKeys;
            this.payloads.removeIf = TreeSortedMapTest::removeIf;
            this.payloads.getIfAbsentPut = TreeSortedMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = TreeSortedMapTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = TreeSortedMapTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = TreeSortedMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = TreeSortedMapTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = TreeSortedMapTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = TreeSortedMapTest::getKeysAndGetValues;
            this.payloads.newEmpty = TreeSortedMapTest::newEmpty;
            this.payloads.keysAndValues_toString = TreeSortedMapTest::keysAndValues_toString;
            this.payloads.keyPreservation = TreeSortedMapTest::keyPreservation;
            this.payloads.add = TreeSortedMapTest::add;
            this.payloads.putPair = TreeSortedMapTest::putPair;
            this.payloads.withKeyValue = TreeSortedMapTest::withKeyValue;
            this.payloads.withMap = TreeSortedMapTest::withMap;
            this.payloads.withMapEmpty = TreeSortedMapTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = TreeSortedMapTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = TreeSortedMapTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = TreeSortedMapTest::withMapNull;
            this.payloads.withMapIterable = TreeSortedMapTest::withMapIterable;
            this.payloads.withMapIterableEmpty = TreeSortedMapTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = TreeSortedMapTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = TreeSortedMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = TreeSortedMapTest::withMapIterableNull;
            this.payloads.putAllMapIterable = TreeSortedMapTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = TreeSortedMapTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = TreeSortedMapTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = TreeSortedMapTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = TreeSortedMapTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = TreeSortedMapTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = TreeSortedMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = TreeSortedMapTest::withoutKey;
            this.payloads.withoutAllKeys = TreeSortedMapTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = TreeSortedMapTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = TreeSortedMapTest::rehash_null_collision;
            this.payloads.updateValue = TreeSortedMapTest::updateValue;
            this.payloads.updateValue_collisions = TreeSortedMapTest::updateValue_collisions;
            this.payloads.updateValueWith = TreeSortedMapTest::updateValueWith;
            this.payloads.updateValueWith_collisions = TreeSortedMapTest::updateValueWith_collisions;
            this.payloads.testNewEmpty = TreeSortedMapTest::testNewEmpty;
            this.payloads.testNewMap = TreeSortedMapTest::testNewMap;
            this.payloads.toImmutable = TreeSortedMapTest::toImmutable;
            this.payloads.testNewMapWithKeyValue = TreeSortedMapTest::testNewMapWithKeyValue;
            this.payloads.newMapWith_2 = TreeSortedMapTest::newMapWith_2;
            this.payloads.newMapWith_3 = TreeSortedMapTest::newMapWith_3;
            this.payloads.newMapWith_4 = TreeSortedMapTest::newMapWith_4;
            this.payloads.with = TreeSortedMapTest::with;
            this.payloads.tap = TreeSortedMapTest::tap;
            this.payloads.forEach = TreeSortedMapTest::forEach;
            this.payloads.forEachWith = TreeSortedMapTest::forEachWith;
            this.payloads.forEachWith_reverse = TreeSortedMapTest::forEachWith_reverse;
            this.payloads.forEachWithIndex = TreeSortedMapTest::forEachWithIndex;
            this.payloads.forEachWithIndex_reverse = TreeSortedMapTest::forEachWithIndex_reverse;
            this.payloads.forEachKeyValue = TreeSortedMapTest::forEachKeyValue;
            this.payloads.forEachKey = TreeSortedMapTest::forEachKey;
            this.payloads.collectValues = TreeSortedMapTest::collectValues;
            this.payloads.zipWithIndex = TreeSortedMapTest::zipWithIndex;
            this.payloads.zip = TreeSortedMapTest::zip;
            this.payloads.select_value = TreeSortedMapTest::select_value;
            this.payloads.reject_value = TreeSortedMapTest::reject_value;
            this.payloads.partition_value = TreeSortedMapTest::partition_value;
            this.payloads.partitionWith_value = TreeSortedMapTest::partitionWith_value;
            this.payloads.collect_value = TreeSortedMapTest::collect_value;
            this.payloads.collectWithIndex = TreeSortedMapTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = TreeSortedMapTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = TreeSortedMapTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = TreeSortedMapTest::rejectWithIndexWithTarget;
            this.payloads.flatten_value = TreeSortedMapTest::flatten_value;
            this.payloads.collectMap = TreeSortedMapTest::collectMap;
            this.payloads.selectMap = TreeSortedMapTest::selectMap;
            this.payloads.rejectMap = TreeSortedMapTest::rejectMap;
            this.payloads.flip = TreeSortedMapTest::flip;
            this.payloads.collectIf = TreeSortedMapTest::collectIf;
            this.payloads.iterator = TreeSortedMapTest::iterator;
            this.payloads.removeFromEntrySet = TreeSortedMapTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = TreeSortedMapTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = TreeSortedMapTest::retainAllFromEntrySet;
            this.payloads.entrySet_sorted = TreeSortedMapTest::entrySet_sorted;
            this.payloads.keySet = TreeSortedMapTest::keySet;
            this.payloads.keySetEqualsAndHashCode = TreeSortedMapTest::keySetEqualsAndHashCode;
            this.payloads.put = TreeSortedMapTest::put;
            this.payloads.putAll = TreeSortedMapTest::putAll;
            this.payloads.putAllFromCollection = TreeSortedMapTest::putAllFromCollection;
            this.payloads.testEquals = TreeSortedMapTest::testEquals;
            this.payloads.testHashCode = TreeSortedMapTest::testHashCode;
            this.payloads.equalsAndHashCode = TreeSortedMapTest::equalsAndHashCode;
            this.payloads.serialization = TreeSortedMapTest::serialization;
            this.payloads.asUnmodifiable = TreeSortedMapTest::asUnmodifiable;
            this.payloads.asSynchronized = TreeSortedMapTest::asSynchronized;
            this.payloads.firstKey = TreeSortedMapTest::firstKey;
            this.payloads.lastKey = TreeSortedMapTest::lastKey;
            this.payloads.headMap = TreeSortedMapTest::headMap;
            this.payloads.tailMap = TreeSortedMapTest::tailMap;
            this.payloads.subMap = TreeSortedMapTest::subMap;
            this.payloads.testToString = TreeSortedMapTest::testToString;
            this.payloads.take = TreeSortedMapTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedMapTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = TreeSortedMapTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedMapTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.testConstructors = TreeSortedMapTest::testConstructors;
            this.payloads.newMapWithPairs = TreeSortedMapTest::newMapWithPairs;
            this.payloads.testClone = TreeSortedMapTest::testClone;
        }
    }
}
