/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable;

import java.util.HashMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Maps;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link MapAdapter}.
 */
public class MapAdapterTest extends MutableMapTestCase {

    @Override
    public <K, V> MutableMap<K, V> newMap() {
        return MapAdapter.adapt(new HashMap<>());
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value) {
        return MapAdapter.adapt(new HashMap<K, V>()).withKeyValue(key, value);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return MapAdapter.adapt(new HashMap<K, V>()).withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return MapAdapter.adapt(new HashMap<K, V>()).withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    public <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return MapAdapter.adapt(new HashMap<K, V>()).withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @Test
    public void adapt() {
        MutableMap<Integer, Integer> map = Maps.mutable.with(1, 1, 2, 2, 3, 3);
        Assert.assertEquals(MapAdapter.adapt(new HashMap<>(map)), Maps.adapt(new HashMap<>(map)));
    }

    @Test
    public void adaptNull() {
        Assert.assertThrows(NullPointerException.class, () -> new MapAdapter<>(null));
        Assert.assertThrows(NullPointerException.class, () -> MapAdapter.adapt(null));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MapAdapterTest instance;

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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adapt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adapt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_adaptNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.adaptNull);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new MapAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> adapt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MapAdapterTest> adaptNull;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = MapAdapterTest::stream;
            this.payloads.parallelStream = MapAdapterTest::parallelStream;
            this.payloads.equalsAndHashCode = MapAdapterTest::equalsAndHashCode;
            this.payloads.serialization = MapAdapterTest::serialization;
            this.payloads.isEmpty = MapAdapterTest::isEmpty;
            this.payloads.notEmpty = MapAdapterTest::notEmpty;
            this.payloads.ifPresentApply = MapAdapterTest::ifPresentApply;
            this.payloads.getIfAbsent_function = MapAdapterTest::getIfAbsent_function;
            this.payloads.getOrDefault = MapAdapterTest::getOrDefault;
            this.payloads.getIfAbsent = MapAdapterTest::getIfAbsent;
            this.payloads.getIfAbsentWith = MapAdapterTest::getIfAbsentWith;
            this.payloads.tap = MapAdapterTest::tap;
            this.payloads.forEach = MapAdapterTest::forEach;
            this.payloads.forEachWith = MapAdapterTest::forEachWith;
            this.payloads.forEachWithIndex = MapAdapterTest::forEachWithIndex;
            this.payloads.forEachKey = MapAdapterTest::forEachKey;
            this.payloads.forEachValue = MapAdapterTest::forEachValue;
            this.payloads.forEachKeyValue = MapAdapterTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = MapAdapterTest::injectIntoKeyValue;
            this.payloads.flipUniqueValues = MapAdapterTest::flipUniqueValues;
            this.payloads.collectMap = MapAdapterTest::collectMap;
            this.payloads.collectBoolean = MapAdapterTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = MapAdapterTest::collectBooleanWithTarget;
            this.payloads.collectByte = MapAdapterTest::collectByte;
            this.payloads.collectByteWithTarget = MapAdapterTest::collectByteWithTarget;
            this.payloads.collectChar = MapAdapterTest::collectChar;
            this.payloads.collectCharWithTarget = MapAdapterTest::collectCharWithTarget;
            this.payloads.collectDouble = MapAdapterTest::collectDouble;
            this.payloads.collectDoubleWithTarget = MapAdapterTest::collectDoubleWithTarget;
            this.payloads.collectFloat = MapAdapterTest::collectFloat;
            this.payloads.collectFloatWithTarget = MapAdapterTest::collectFloatWithTarget;
            this.payloads.collectInt = MapAdapterTest::collectInt;
            this.payloads.collectIntWithTarget = MapAdapterTest::collectIntWithTarget;
            this.payloads.collectLong = MapAdapterTest::collectLong;
            this.payloads.collectLongWithTarget = MapAdapterTest::collectLongWithTarget;
            this.payloads.collectShort = MapAdapterTest::collectShort;
            this.payloads.collectShortWithTarget = MapAdapterTest::collectShortWithTarget;
            this.payloads.collectValues = MapAdapterTest::collectValues;
            this.payloads.select = MapAdapterTest::select;
            this.payloads.selectWith = MapAdapterTest::selectWith;
            this.payloads.reject = MapAdapterTest::reject;
            this.payloads.rejectWith = MapAdapterTest::rejectWith;
            this.payloads.collect = MapAdapterTest::collect;
            this.payloads.flatCollect = MapAdapterTest::flatCollect;
            this.payloads.flatCollectWith = MapAdapterTest::flatCollectWith;
            this.payloads.selectMap = MapAdapterTest::selectMap;
            this.payloads.rejectMap = MapAdapterTest::rejectMap;
            this.payloads.flip = MapAdapterTest::flip;
            this.payloads.detect = MapAdapterTest::detect;
            this.payloads.detectOptional = MapAdapterTest::detectOptional;
            this.payloads.anySatisfy = MapAdapterTest::anySatisfy;
            this.payloads.anySatisfyWith = MapAdapterTest::anySatisfyWith;
            this.payloads.allSatisfy = MapAdapterTest::allSatisfy;
            this.payloads.allSatisfyWith = MapAdapterTest::allSatisfyWith;
            this.payloads.noneSatisfy = MapAdapterTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MapAdapterTest::noneSatisfyWith;
            this.payloads.appendString = MapAdapterTest::appendString;
            this.payloads.toBag = MapAdapterTest::toBag;
            this.payloads.toSortedBag = MapAdapterTest::toSortedBag;
            this.payloads.toSortedBagBy = MapAdapterTest::toSortedBagBy;
            this.payloads.asLazy = MapAdapterTest::asLazy;
            this.payloads.toList = MapAdapterTest::toList;
            this.payloads.toMap = MapAdapterTest::toMap;
            this.payloads.toSet = MapAdapterTest::toSet;
            this.payloads.toSortedList = MapAdapterTest::toSortedList;
            this.payloads.toSortedListBy = MapAdapterTest::toSortedListBy;
            this.payloads.toSortedSet = MapAdapterTest::toSortedSet;
            this.payloads.toSortedSetBy = MapAdapterTest::toSortedSetBy;
            this.payloads.toSortedMap = MapAdapterTest::toSortedMap;
            this.payloads.chunk = MapAdapterTest::chunk;
            this.payloads.collect_value = MapAdapterTest::collect_value;
            this.payloads.collectIf = MapAdapterTest::collectIf;
            this.payloads.collectWith = MapAdapterTest::collectWith;
            this.payloads.collectWithToTarget = MapAdapterTest::collectWithToTarget;
            this.payloads.contains = MapAdapterTest::contains;
            this.payloads.containsAnyIterable = MapAdapterTest::containsAnyIterable;
            this.payloads.containsNoneIterable = MapAdapterTest::containsNoneIterable;
            this.payloads.containsAnyCollection = MapAdapterTest::containsAnyCollection;
            this.payloads.containsNoneCollection = MapAdapterTest::containsNoneCollection;
            this.payloads.containsAll = MapAdapterTest::containsAll;
            this.payloads.containsKey = MapAdapterTest::containsKey;
            this.payloads.containsValue = MapAdapterTest::containsValue;
            this.payloads.getFirst = MapAdapterTest::getFirst;
            this.payloads.getLast = MapAdapterTest::getLast;
            this.payloads.getOnly = MapAdapterTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapAdapterTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapAdapterTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = MapAdapterTest::containsAllIterable;
            this.payloads.containsAllArguments = MapAdapterTest::containsAllArguments;
            this.payloads.count = MapAdapterTest::count;
            this.payloads.countWith = MapAdapterTest::countWith;
            this.payloads.detect_value = MapAdapterTest::detect_value;
            this.payloads.detectOptional_value = MapAdapterTest::detectOptional_value;
            this.payloads.detectWith = MapAdapterTest::detectWith;
            this.payloads.detectWithOptional = MapAdapterTest::detectWithOptional;
            this.payloads.detectIfNone_value = MapAdapterTest::detectIfNone_value;
            this.payloads.detectWithIfNone = MapAdapterTest::detectWithIfNone;
            this.payloads.flatten_value = MapAdapterTest::flatten_value;
            this.payloads.countBy = MapAdapterTest::countBy;
            this.payloads.countByWith = MapAdapterTest::countByWith;
            this.payloads.countByEach = MapAdapterTest::countByEach;
            this.payloads.groupBy = MapAdapterTest::groupBy;
            this.payloads.groupByEach = MapAdapterTest::groupByEach;
            this.payloads.groupByUniqueKey = MapAdapterTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapAdapterTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MapAdapterTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MapAdapterTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = MapAdapterTest::injectInto;
            this.payloads.injectIntoInt = MapAdapterTest::injectIntoInt;
            this.payloads.injectIntoLong = MapAdapterTest::injectIntoLong;
            this.payloads.injectIntoFloat = MapAdapterTest::injectIntoFloat;
            this.payloads.injectIntoDouble = MapAdapterTest::injectIntoDouble;
            this.payloads.sumOfInt = MapAdapterTest::sumOfInt;
            this.payloads.sumOfLong = MapAdapterTest::sumOfLong;
            this.payloads.testAggregateBy = MapAdapterTest::testAggregateBy;
            this.payloads.sumOfFloat = MapAdapterTest::sumOfFloat;
            this.payloads.sumOfDouble = MapAdapterTest::sumOfDouble;
            this.payloads.sumByInt = MapAdapterTest::sumByInt;
            this.payloads.sumByFloat = MapAdapterTest::sumByFloat;
            this.payloads.sumByLong = MapAdapterTest::sumByLong;
            this.payloads.sumByDouble = MapAdapterTest::sumByDouble;
            this.payloads.makeString = MapAdapterTest::makeString;
            this.payloads.min = MapAdapterTest::min;
            this.payloads.max = MapAdapterTest::max;
            this.payloads.minBy = MapAdapterTest::minBy;
            this.payloads.maxBy = MapAdapterTest::maxBy;
            this.payloads.reject_value = MapAdapterTest::reject_value;
            this.payloads.rejectWith_value = MapAdapterTest::rejectWith_value;
            this.payloads.select_value = MapAdapterTest::select_value;
            this.payloads.selectWith_value = MapAdapterTest::selectWith_value;
            this.payloads.partition_value = MapAdapterTest::partition_value;
            this.payloads.partitionWith_value = MapAdapterTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = MapAdapterTest::selectInstancesOf_value;
            this.payloads.toArray = MapAdapterTest::toArray;
            this.payloads.zip = MapAdapterTest::zip;
            this.payloads.zipWithIndex = MapAdapterTest::zipWithIndex;
            this.payloads.aggregateByMutating = MapAdapterTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MapAdapterTest::aggregateByNonMutating;
            this.payloads.keyValuesView = MapAdapterTest::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = MapAdapterTest::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = MapAdapterTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = MapAdapterTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = MapAdapterTest::newMapWithWith;
            this.payloads.newMapWithWithWith = MapAdapterTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = MapAdapterTest::newMapWithWithWithWith;
            this.payloads.iterator = MapAdapterTest::iterator;
            this.payloads.keysView = MapAdapterTest::keysView;
            this.payloads.valuesView = MapAdapterTest::valuesView;
            this.payloads.test_toString = MapAdapterTest::test_toString;
            this.payloads.toImmutable = MapAdapterTest::toImmutable;
            this.payloads.clear = MapAdapterTest::clear;
            this.payloads.removeObject = MapAdapterTest::removeObject;
            this.payloads.removeFromEntrySet = MapAdapterTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = MapAdapterTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = MapAdapterTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = MapAdapterTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = MapAdapterTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = MapAdapterTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = MapAdapterTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = MapAdapterTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = MapAdapterTest::retainAllFromKeySet;
            this.payloads.clearKeySet = MapAdapterTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = MapAdapterTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = MapAdapterTest::keySetToArray;
            this.payloads.removeFromValues = MapAdapterTest::removeFromValues;
            this.payloads.removeNullFromValues = MapAdapterTest::removeNullFromValues;
            this.payloads.removeAllFromValues = MapAdapterTest::removeAllFromValues;
            this.payloads.retainAllFromValues = MapAdapterTest::retainAllFromValues;
            this.payloads.put = MapAdapterTest::put;
            this.payloads.putAll = MapAdapterTest::putAll;
            this.payloads.removeKey = MapAdapterTest::removeKey;
            this.payloads.removeAllKeys = MapAdapterTest::removeAllKeys;
            this.payloads.removeIf = MapAdapterTest::removeIf;
            this.payloads.getIfAbsentPut = MapAdapterTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = MapAdapterTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = MapAdapterTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = MapAdapterTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = MapAdapterTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = MapAdapterTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = MapAdapterTest::getKeysAndGetValues;
            this.payloads.newEmpty = MapAdapterTest::newEmpty;
            this.payloads.keysAndValues_toString = MapAdapterTest::keysAndValues_toString;
            this.payloads.keyPreservation = MapAdapterTest::keyPreservation;
            this.payloads.asUnmodifiable = MapAdapterTest::asUnmodifiable;
            this.payloads.asSynchronized = MapAdapterTest::asSynchronized;
            this.payloads.add = MapAdapterTest::add;
            this.payloads.putPair = MapAdapterTest::putPair;
            this.payloads.withKeyValue = MapAdapterTest::withKeyValue;
            this.payloads.withMap = MapAdapterTest::withMap;
            this.payloads.withMapEmpty = MapAdapterTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = MapAdapterTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = MapAdapterTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = MapAdapterTest::withMapNull;
            this.payloads.withMapIterable = MapAdapterTest::withMapIterable;
            this.payloads.withMapIterableEmpty = MapAdapterTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = MapAdapterTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = MapAdapterTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = MapAdapterTest::withMapIterableNull;
            this.payloads.putAllMapIterable = MapAdapterTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = MapAdapterTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = MapAdapterTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = MapAdapterTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = MapAdapterTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = MapAdapterTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = MapAdapterTest::withAllKeyValueArguments;
            this.payloads.withoutKey = MapAdapterTest::withoutKey;
            this.payloads.withoutAllKeys = MapAdapterTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = MapAdapterTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = MapAdapterTest::rehash_null_collision;
            this.payloads.updateValue = MapAdapterTest::updateValue;
            this.payloads.updateValue_collisions = MapAdapterTest::updateValue_collisions;
            this.payloads.updateValueWith = MapAdapterTest::updateValueWith;
            this.payloads.updateValueWith_collisions = MapAdapterTest::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = MapAdapterTest::collectKeysAndValues;
            this.payloads.testClone = MapAdapterTest::testClone;
            this.payloads.adapt = MapAdapterTest::adapt;
            this.payloads.adaptNull = MapAdapterTest::adaptNull;
        }
    }
*/
}
