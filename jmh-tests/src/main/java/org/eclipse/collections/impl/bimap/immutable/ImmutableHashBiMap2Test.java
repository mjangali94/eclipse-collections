/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.immutable;

import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.multimap.set.ImmutableSetMultimap;
import org.eclipse.collections.impl.IntegerWithCast;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableHashBiMap2Test extends MapIterableTestCase {

    @Override
    protected <K, V> ImmutableBiMap<K, V> newMap() {
        return BiMaps.immutable.empty();
    }

    @Override
    protected <K, V> ImmutableBiMap<K, V> newMapWithKeyValue(K key1, V value1) {
        return BiMaps.immutable.with(key1, value1);
    }

    @Override
    protected <K, V> ImmutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return BiMaps.immutable.with(key1, value1, key2, value2);
    }

    @Override
    protected <K, V> ImmutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return BiMaps.immutable.with(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <K, V> ImmutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return BiMaps.immutable.with(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    @Test
    public void flipUniqueValues() {
        ImmutableBiMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        ImmutableBiMap<String, Integer> result = map.flipUniqueValues();
        ImmutableBiMap<String, Integer> expectedMap = this.newMapWithKeysValues("1", 1, "2", 2, "3", 3);
        Assert.assertEquals(expectedMap, result);
    }

    @Override
    @Test
    public void flip() {
        ImmutableBiMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "2", 3, "3");
        ImmutableSetMultimap<String, Integer> result = map.flip();
        UnifiedSetMultimap<String, Integer> expected = UnifiedSetMultimap.newMultimap(Tuples.pair("1", 1), Tuples.pair("2", 2), Tuples.pair("3", 3));
        Assert.assertEquals(expected, result);
    }

    @Override
    @Test
    public void nullCollisionWithCastInEquals() {
        ImmutableBiMap<IntegerWithCast, String> map = this.newMapWithKeysValues(new IntegerWithCast(0), "Test 2", null, "Test 1");
        Assert.assertEquals(this.newMapWithKeysValues(new IntegerWithCast(0), "Test 2", null, "Test 1"), map);
        Assert.assertEquals("Test 2", map.get(new IntegerWithCast(0)));
        Assert.assertEquals("Test 1", map.get(null));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableHashBiMap2Test instance;

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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> payload) throws java.lang.Throwable {
            this.instance = new ImmutableHashBiMap2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMap2Test> nullCollisionWithCastInEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableHashBiMap2Test::stream;
            this.payloads.parallelStream = ImmutableHashBiMap2Test::parallelStream;
            this.payloads.equalsAndHashCode = ImmutableHashBiMap2Test::equalsAndHashCode;
            this.payloads.serialization = ImmutableHashBiMap2Test::serialization;
            this.payloads.isEmpty = ImmutableHashBiMap2Test::isEmpty;
            this.payloads.notEmpty = ImmutableHashBiMap2Test::notEmpty;
            this.payloads.ifPresentApply = ImmutableHashBiMap2Test::ifPresentApply;
            this.payloads.getIfAbsent_function = ImmutableHashBiMap2Test::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableHashBiMap2Test::getOrDefault;
            this.payloads.getIfAbsent = ImmutableHashBiMap2Test::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableHashBiMap2Test::getIfAbsentWith;
            this.payloads.tap = ImmutableHashBiMap2Test::tap;
            this.payloads.forEach = ImmutableHashBiMap2Test::forEach;
            this.payloads.forEachWith = ImmutableHashBiMap2Test::forEachWith;
            this.payloads.forEachWithIndex = ImmutableHashBiMap2Test::forEachWithIndex;
            this.payloads.forEachKey = ImmutableHashBiMap2Test::forEachKey;
            this.payloads.forEachValue = ImmutableHashBiMap2Test::forEachValue;
            this.payloads.forEachKeyValue = ImmutableHashBiMap2Test::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableHashBiMap2Test::injectIntoKeyValue;
            this.payloads.collectMap = ImmutableHashBiMap2Test::collectMap;
            this.payloads.collectBoolean = ImmutableHashBiMap2Test::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableHashBiMap2Test::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableHashBiMap2Test::collectByte;
            this.payloads.collectByteWithTarget = ImmutableHashBiMap2Test::collectByteWithTarget;
            this.payloads.collectChar = ImmutableHashBiMap2Test::collectChar;
            this.payloads.collectCharWithTarget = ImmutableHashBiMap2Test::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableHashBiMap2Test::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableHashBiMap2Test::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableHashBiMap2Test::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableHashBiMap2Test::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableHashBiMap2Test::collectInt;
            this.payloads.collectIntWithTarget = ImmutableHashBiMap2Test::collectIntWithTarget;
            this.payloads.collectLong = ImmutableHashBiMap2Test::collectLong;
            this.payloads.collectLongWithTarget = ImmutableHashBiMap2Test::collectLongWithTarget;
            this.payloads.collectShort = ImmutableHashBiMap2Test::collectShort;
            this.payloads.collectShortWithTarget = ImmutableHashBiMap2Test::collectShortWithTarget;
            this.payloads.collectValues = ImmutableHashBiMap2Test::collectValues;
            this.payloads.select = ImmutableHashBiMap2Test::select;
            this.payloads.selectWith = ImmutableHashBiMap2Test::selectWith;
            this.payloads.reject = ImmutableHashBiMap2Test::reject;
            this.payloads.rejectWith = ImmutableHashBiMap2Test::rejectWith;
            this.payloads.collect = ImmutableHashBiMap2Test::collect;
            this.payloads.flatCollect = ImmutableHashBiMap2Test::flatCollect;
            this.payloads.flatCollectWith = ImmutableHashBiMap2Test::flatCollectWith;
            this.payloads.selectMap = ImmutableHashBiMap2Test::selectMap;
            this.payloads.rejectMap = ImmutableHashBiMap2Test::rejectMap;
            this.payloads.detect = ImmutableHashBiMap2Test::detect;
            this.payloads.detectOptional = ImmutableHashBiMap2Test::detectOptional;
            this.payloads.anySatisfy = ImmutableHashBiMap2Test::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableHashBiMap2Test::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableHashBiMap2Test::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableHashBiMap2Test::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableHashBiMap2Test::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableHashBiMap2Test::noneSatisfyWith;
            this.payloads.appendString = ImmutableHashBiMap2Test::appendString;
            this.payloads.toBag = ImmutableHashBiMap2Test::toBag;
            this.payloads.toSortedBag = ImmutableHashBiMap2Test::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableHashBiMap2Test::toSortedBagBy;
            this.payloads.asLazy = ImmutableHashBiMap2Test::asLazy;
            this.payloads.toList = ImmutableHashBiMap2Test::toList;
            this.payloads.toMap = ImmutableHashBiMap2Test::toMap;
            this.payloads.toSet = ImmutableHashBiMap2Test::toSet;
            this.payloads.toSortedList = ImmutableHashBiMap2Test::toSortedList;
            this.payloads.toSortedListBy = ImmutableHashBiMap2Test::toSortedListBy;
            this.payloads.toSortedSet = ImmutableHashBiMap2Test::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableHashBiMap2Test::toSortedSetBy;
            this.payloads.toSortedMap = ImmutableHashBiMap2Test::toSortedMap;
            this.payloads.chunk = ImmutableHashBiMap2Test::chunk;
            this.payloads.collect_value = ImmutableHashBiMap2Test::collect_value;
            this.payloads.collectIf = ImmutableHashBiMap2Test::collectIf;
            this.payloads.collectWith = ImmutableHashBiMap2Test::collectWith;
            this.payloads.collectWithToTarget = ImmutableHashBiMap2Test::collectWithToTarget;
            this.payloads.contains = ImmutableHashBiMap2Test::contains;
            this.payloads.containsAnyIterable = ImmutableHashBiMap2Test::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableHashBiMap2Test::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableHashBiMap2Test::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableHashBiMap2Test::containsNoneCollection;
            this.payloads.containsAll = ImmutableHashBiMap2Test::containsAll;
            this.payloads.containsKey = ImmutableHashBiMap2Test::containsKey;
            this.payloads.containsValue = ImmutableHashBiMap2Test::containsValue;
            this.payloads.getFirst = ImmutableHashBiMap2Test::getFirst;
            this.payloads.getLast = ImmutableHashBiMap2Test::getLast;
            this.payloads.getOnly = ImmutableHashBiMap2Test::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBiMap2Test::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBiMap2Test::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ImmutableHashBiMap2Test::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableHashBiMap2Test::containsAllArguments;
            this.payloads.count = ImmutableHashBiMap2Test::count;
            this.payloads.countWith = ImmutableHashBiMap2Test::countWith;
            this.payloads.detect_value = ImmutableHashBiMap2Test::detect_value;
            this.payloads.detectOptional_value = ImmutableHashBiMap2Test::detectOptional_value;
            this.payloads.detectWith = ImmutableHashBiMap2Test::detectWith;
            this.payloads.detectWithOptional = ImmutableHashBiMap2Test::detectWithOptional;
            this.payloads.detectIfNone_value = ImmutableHashBiMap2Test::detectIfNone_value;
            this.payloads.detectWithIfNone = ImmutableHashBiMap2Test::detectWithIfNone;
            this.payloads.flatten_value = ImmutableHashBiMap2Test::flatten_value;
            this.payloads.countBy = ImmutableHashBiMap2Test::countBy;
            this.payloads.countByWith = ImmutableHashBiMap2Test::countByWith;
            this.payloads.countByEach = ImmutableHashBiMap2Test::countByEach;
            this.payloads.groupBy = ImmutableHashBiMap2Test::groupBy;
            this.payloads.groupByEach = ImmutableHashBiMap2Test::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableHashBiMap2Test::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBiMap2Test::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableHashBiMap2Test::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBiMap2Test::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ImmutableHashBiMap2Test::injectInto;
            this.payloads.injectIntoInt = ImmutableHashBiMap2Test::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableHashBiMap2Test::injectIntoLong;
            this.payloads.injectIntoFloat = ImmutableHashBiMap2Test::injectIntoFloat;
            this.payloads.injectIntoDouble = ImmutableHashBiMap2Test::injectIntoDouble;
            this.payloads.sumOfInt = ImmutableHashBiMap2Test::sumOfInt;
            this.payloads.sumOfLong = ImmutableHashBiMap2Test::sumOfLong;
            this.payloads.testAggregateBy = ImmutableHashBiMap2Test::testAggregateBy;
            this.payloads.sumOfFloat = ImmutableHashBiMap2Test::sumOfFloat;
            this.payloads.sumOfDouble = ImmutableHashBiMap2Test::sumOfDouble;
            this.payloads.sumByInt = ImmutableHashBiMap2Test::sumByInt;
            this.payloads.sumByFloat = ImmutableHashBiMap2Test::sumByFloat;
            this.payloads.sumByLong = ImmutableHashBiMap2Test::sumByLong;
            this.payloads.sumByDouble = ImmutableHashBiMap2Test::sumByDouble;
            this.payloads.makeString = ImmutableHashBiMap2Test::makeString;
            this.payloads.min = ImmutableHashBiMap2Test::min;
            this.payloads.max = ImmutableHashBiMap2Test::max;
            this.payloads.minBy = ImmutableHashBiMap2Test::minBy;
            this.payloads.maxBy = ImmutableHashBiMap2Test::maxBy;
            this.payloads.reject_value = ImmutableHashBiMap2Test::reject_value;
            this.payloads.rejectWith_value = ImmutableHashBiMap2Test::rejectWith_value;
            this.payloads.select_value = ImmutableHashBiMap2Test::select_value;
            this.payloads.selectWith_value = ImmutableHashBiMap2Test::selectWith_value;
            this.payloads.partition_value = ImmutableHashBiMap2Test::partition_value;
            this.payloads.partitionWith_value = ImmutableHashBiMap2Test::partitionWith_value;
            this.payloads.selectInstancesOf_value = ImmutableHashBiMap2Test::selectInstancesOf_value;
            this.payloads.toArray = ImmutableHashBiMap2Test::toArray;
            this.payloads.zip = ImmutableHashBiMap2Test::zip;
            this.payloads.zipWithIndex = ImmutableHashBiMap2Test::zipWithIndex;
            this.payloads.aggregateByMutating = ImmutableHashBiMap2Test::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableHashBiMap2Test::aggregateByNonMutating;
            this.payloads.keyValuesView = ImmutableHashBiMap2Test::keyValuesView;
            this.payloads.testNewMap = ImmutableHashBiMap2Test::testNewMap;
            this.payloads.testNewMapWithKeyValue = ImmutableHashBiMap2Test::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ImmutableHashBiMap2Test::newMapWithWith;
            this.payloads.newMapWithWithWith = ImmutableHashBiMap2Test::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ImmutableHashBiMap2Test::newMapWithWithWithWith;
            this.payloads.iterator = ImmutableHashBiMap2Test::iterator;
            this.payloads.keysView = ImmutableHashBiMap2Test::keysView;
            this.payloads.valuesView = ImmutableHashBiMap2Test::valuesView;
            this.payloads.test_toString = ImmutableHashBiMap2Test::test_toString;
            this.payloads.flipUniqueValues = ImmutableHashBiMap2Test::flipUniqueValues;
            this.payloads.flip = ImmutableHashBiMap2Test::flip;
            this.payloads.nullCollisionWithCastInEquals = ImmutableHashBiMap2Test::nullCollisionWithCastInEquals;
        }
    }
*/
}
