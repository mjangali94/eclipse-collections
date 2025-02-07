/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.mutable;

import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Key;
import org.junit.Test;

public class HashBiMapInverseTest extends AbstractMutableBiMapTestCase {

    @Override
    public MutableBiMap<Integer, Character> classUnderTest() {
        HashBiMap<Character, Integer> biMap = HashBiMap.newMap();
        biMap.put(null, 1);
        biMap.put('b', null);
        biMap.put('c', 3);
        return biMap.inverse();
    }

    @Override
    public MutableBiMap<Integer, Character> getEmptyMap() {
        return HashBiMap.<Character, Integer>newMap().inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMap() {
        return HashBiMap.<V, K>newMap().inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return HashBiMap.newWithKeysValues(value, key).inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2).inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3).inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3, value4, key4).inverse();
    }

    @Override
    @Test
    public void keyPreservation() {
        Key key = new Key("key");
        Key duplicateKey1 = new Key("key");
        MutableBiMap<Integer, Key> map1 = HashBiMap.newWithKeysValues(key, 1, duplicateKey1, 2).inverse();
        Verify.assertSize(1, map1);
        Verify.assertContainsKeyValue(2, key, map1);
        Key duplicateKey2 = new Key("key");
        MutableBiMap<Integer, Key> map2 = HashBiMap.newWithKeysValues(key, 1, duplicateKey1, 2, duplicateKey2, 3).inverse();
        Verify.assertSize(1, map2);
        Verify.assertContainsKeyValue(3, key, map2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public HashBiMapInverseTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyPreservation);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapInverseTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> forcePut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> into;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseTest> keyPreservation;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = HashBiMapInverseTest::stream;
            this.payloads.parallelStream = HashBiMapInverseTest::parallelStream;
            this.payloads.serialization = HashBiMapInverseTest::serialization;
            this.payloads.isEmpty = HashBiMapInverseTest::isEmpty;
            this.payloads.notEmpty = HashBiMapInverseTest::notEmpty;
            this.payloads.ifPresentApply = HashBiMapInverseTest::ifPresentApply;
            this.payloads.getIfAbsent_function = HashBiMapInverseTest::getIfAbsent_function;
            this.payloads.getOrDefault = HashBiMapInverseTest::getOrDefault;
            this.payloads.getIfAbsent = HashBiMapInverseTest::getIfAbsent;
            this.payloads.getIfAbsentWith = HashBiMapInverseTest::getIfAbsentWith;
            this.payloads.tap = HashBiMapInverseTest::tap;
            this.payloads.forEach = HashBiMapInverseTest::forEach;
            this.payloads.forEachWith = HashBiMapInverseTest::forEachWith;
            this.payloads.forEachWithIndex = HashBiMapInverseTest::forEachWithIndex;
            this.payloads.forEachKey = HashBiMapInverseTest::forEachKey;
            this.payloads.forEachValue = HashBiMapInverseTest::forEachValue;
            this.payloads.forEachKeyValue = HashBiMapInverseTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = HashBiMapInverseTest::injectIntoKeyValue;
            this.payloads.collectMap = HashBiMapInverseTest::collectMap;
            this.payloads.collectBoolean = HashBiMapInverseTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = HashBiMapInverseTest::collectBooleanWithTarget;
            this.payloads.collectByte = HashBiMapInverseTest::collectByte;
            this.payloads.collectByteWithTarget = HashBiMapInverseTest::collectByteWithTarget;
            this.payloads.collectChar = HashBiMapInverseTest::collectChar;
            this.payloads.collectCharWithTarget = HashBiMapInverseTest::collectCharWithTarget;
            this.payloads.collectDouble = HashBiMapInverseTest::collectDouble;
            this.payloads.collectDoubleWithTarget = HashBiMapInverseTest::collectDoubleWithTarget;
            this.payloads.collectFloat = HashBiMapInverseTest::collectFloat;
            this.payloads.collectFloatWithTarget = HashBiMapInverseTest::collectFloatWithTarget;
            this.payloads.collectInt = HashBiMapInverseTest::collectInt;
            this.payloads.collectIntWithTarget = HashBiMapInverseTest::collectIntWithTarget;
            this.payloads.collectLong = HashBiMapInverseTest::collectLong;
            this.payloads.collectLongWithTarget = HashBiMapInverseTest::collectLongWithTarget;
            this.payloads.collectShort = HashBiMapInverseTest::collectShort;
            this.payloads.collectShortWithTarget = HashBiMapInverseTest::collectShortWithTarget;
            this.payloads.collectValues = HashBiMapInverseTest::collectValues;
            this.payloads.select = HashBiMapInverseTest::select;
            this.payloads.selectWith = HashBiMapInverseTest::selectWith;
            this.payloads.reject = HashBiMapInverseTest::reject;
            this.payloads.rejectWith = HashBiMapInverseTest::rejectWith;
            this.payloads.collect = HashBiMapInverseTest::collect;
            this.payloads.flatCollect = HashBiMapInverseTest::flatCollect;
            this.payloads.flatCollectWith = HashBiMapInverseTest::flatCollectWith;
            this.payloads.selectMap = HashBiMapInverseTest::selectMap;
            this.payloads.rejectMap = HashBiMapInverseTest::rejectMap;
            this.payloads.detect = HashBiMapInverseTest::detect;
            this.payloads.detectOptional = HashBiMapInverseTest::detectOptional;
            this.payloads.anySatisfy = HashBiMapInverseTest::anySatisfy;
            this.payloads.anySatisfyWith = HashBiMapInverseTest::anySatisfyWith;
            this.payloads.allSatisfy = HashBiMapInverseTest::allSatisfy;
            this.payloads.allSatisfyWith = HashBiMapInverseTest::allSatisfyWith;
            this.payloads.noneSatisfy = HashBiMapInverseTest::noneSatisfy;
            this.payloads.noneSatisfyWith = HashBiMapInverseTest::noneSatisfyWith;
            this.payloads.appendString = HashBiMapInverseTest::appendString;
            this.payloads.toBag = HashBiMapInverseTest::toBag;
            this.payloads.toSortedBag = HashBiMapInverseTest::toSortedBag;
            this.payloads.toSortedBagBy = HashBiMapInverseTest::toSortedBagBy;
            this.payloads.asLazy = HashBiMapInverseTest::asLazy;
            this.payloads.toList = HashBiMapInverseTest::toList;
            this.payloads.toMap = HashBiMapInverseTest::toMap;
            this.payloads.toSet = HashBiMapInverseTest::toSet;
            this.payloads.toSortedList = HashBiMapInverseTest::toSortedList;
            this.payloads.toSortedListBy = HashBiMapInverseTest::toSortedListBy;
            this.payloads.toSortedSet = HashBiMapInverseTest::toSortedSet;
            this.payloads.toSortedSetBy = HashBiMapInverseTest::toSortedSetBy;
            this.payloads.toSortedMap = HashBiMapInverseTest::toSortedMap;
            this.payloads.chunk = HashBiMapInverseTest::chunk;
            this.payloads.collect_value = HashBiMapInverseTest::collect_value;
            this.payloads.collectIf = HashBiMapInverseTest::collectIf;
            this.payloads.collectWith = HashBiMapInverseTest::collectWith;
            this.payloads.collectWithToTarget = HashBiMapInverseTest::collectWithToTarget;
            this.payloads.contains = HashBiMapInverseTest::contains;
            this.payloads.containsAnyIterable = HashBiMapInverseTest::containsAnyIterable;
            this.payloads.containsNoneIterable = HashBiMapInverseTest::containsNoneIterable;
            this.payloads.containsAnyCollection = HashBiMapInverseTest::containsAnyCollection;
            this.payloads.containsNoneCollection = HashBiMapInverseTest::containsNoneCollection;
            this.payloads.containsAll = HashBiMapInverseTest::containsAll;
            this.payloads.getFirst = HashBiMapInverseTest::getFirst;
            this.payloads.getLast = HashBiMapInverseTest::getLast;
            this.payloads.getOnly = HashBiMapInverseTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = HashBiMapInverseTest::containsAllIterable;
            this.payloads.containsAllArguments = HashBiMapInverseTest::containsAllArguments;
            this.payloads.count = HashBiMapInverseTest::count;
            this.payloads.countWith = HashBiMapInverseTest::countWith;
            this.payloads.detect_value = HashBiMapInverseTest::detect_value;
            this.payloads.detectOptional_value = HashBiMapInverseTest::detectOptional_value;
            this.payloads.detectWith = HashBiMapInverseTest::detectWith;
            this.payloads.detectWithOptional = HashBiMapInverseTest::detectWithOptional;
            this.payloads.detectIfNone_value = HashBiMapInverseTest::detectIfNone_value;
            this.payloads.detectWithIfNone = HashBiMapInverseTest::detectWithIfNone;
            this.payloads.flatten_value = HashBiMapInverseTest::flatten_value;
            this.payloads.countBy = HashBiMapInverseTest::countBy;
            this.payloads.countByWith = HashBiMapInverseTest::countByWith;
            this.payloads.countByEach = HashBiMapInverseTest::countByEach;
            this.payloads.groupBy = HashBiMapInverseTest::groupBy;
            this.payloads.groupByEach = HashBiMapInverseTest::groupByEach;
            this.payloads.groupByUniqueKey = HashBiMapInverseTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = HashBiMapInverseTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = HashBiMapInverseTest::injectInto;
            this.payloads.injectIntoInt = HashBiMapInverseTest::injectIntoInt;
            this.payloads.injectIntoLong = HashBiMapInverseTest::injectIntoLong;
            this.payloads.injectIntoFloat = HashBiMapInverseTest::injectIntoFloat;
            this.payloads.injectIntoDouble = HashBiMapInverseTest::injectIntoDouble;
            this.payloads.sumOfInt = HashBiMapInverseTest::sumOfInt;
            this.payloads.sumOfLong = HashBiMapInverseTest::sumOfLong;
            this.payloads.testAggregateBy = HashBiMapInverseTest::testAggregateBy;
            this.payloads.sumOfFloat = HashBiMapInverseTest::sumOfFloat;
            this.payloads.sumOfDouble = HashBiMapInverseTest::sumOfDouble;
            this.payloads.sumByInt = HashBiMapInverseTest::sumByInt;
            this.payloads.sumByFloat = HashBiMapInverseTest::sumByFloat;
            this.payloads.sumByLong = HashBiMapInverseTest::sumByLong;
            this.payloads.sumByDouble = HashBiMapInverseTest::sumByDouble;
            this.payloads.makeString = HashBiMapInverseTest::makeString;
            this.payloads.min = HashBiMapInverseTest::min;
            this.payloads.max = HashBiMapInverseTest::max;
            this.payloads.minBy = HashBiMapInverseTest::minBy;
            this.payloads.maxBy = HashBiMapInverseTest::maxBy;
            this.payloads.reject_value = HashBiMapInverseTest::reject_value;
            this.payloads.rejectWith_value = HashBiMapInverseTest::rejectWith_value;
            this.payloads.select_value = HashBiMapInverseTest::select_value;
            this.payloads.selectWith_value = HashBiMapInverseTest::selectWith_value;
            this.payloads.partition_value = HashBiMapInverseTest::partition_value;
            this.payloads.partitionWith_value = HashBiMapInverseTest::partitionWith_value;
            this.payloads.selectInstancesOf_value = HashBiMapInverseTest::selectInstancesOf_value;
            this.payloads.toArray = HashBiMapInverseTest::toArray;
            this.payloads.zip = HashBiMapInverseTest::zip;
            this.payloads.zipWithIndex = HashBiMapInverseTest::zipWithIndex;
            this.payloads.aggregateByMutating = HashBiMapInverseTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = HashBiMapInverseTest::aggregateByNonMutating;
            this.payloads.keyValuesView = HashBiMapInverseTest::keyValuesView;
            this.payloads.testNewMap = HashBiMapInverseTest::testNewMap;
            this.payloads.testNewMapWithKeyValue = HashBiMapInverseTest::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = HashBiMapInverseTest::newMapWithWith;
            this.payloads.newMapWithWithWith = HashBiMapInverseTest::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = HashBiMapInverseTest::newMapWithWithWithWith;
            this.payloads.keysView = HashBiMapInverseTest::keysView;
            this.payloads.valuesView = HashBiMapInverseTest::valuesView;
            this.payloads.test_toString = HashBiMapInverseTest::test_toString;
            this.payloads.toImmutable = HashBiMapInverseTest::toImmutable;
            this.payloads.removeObject = HashBiMapInverseTest::removeObject;
            this.payloads.removeFromEntrySet = HashBiMapInverseTest::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = HashBiMapInverseTest::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = HashBiMapInverseTest::retainAllFromEntrySet;
            this.payloads.clearEntrySet = HashBiMapInverseTest::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = HashBiMapInverseTest::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = HashBiMapInverseTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = HashBiMapInverseTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = HashBiMapInverseTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = HashBiMapInverseTest::retainAllFromKeySet;
            this.payloads.clearKeySet = HashBiMapInverseTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = HashBiMapInverseTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = HashBiMapInverseTest::keySetToArray;
            this.payloads.removeFromValues = HashBiMapInverseTest::removeFromValues;
            this.payloads.removeNullFromValues = HashBiMapInverseTest::removeNullFromValues;
            this.payloads.removeAllFromValues = HashBiMapInverseTest::removeAllFromValues;
            this.payloads.retainAllFromValues = HashBiMapInverseTest::retainAllFromValues;
            this.payloads.removeKey = HashBiMapInverseTest::removeKey;
            this.payloads.removeAllKeys = HashBiMapInverseTest::removeAllKeys;
            this.payloads.removeIf = HashBiMapInverseTest::removeIf;
            this.payloads.getIfAbsentPut = HashBiMapInverseTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = HashBiMapInverseTest::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = HashBiMapInverseTest::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = HashBiMapInverseTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = HashBiMapInverseTest::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = HashBiMapInverseTest::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = HashBiMapInverseTest::getKeysAndGetValues;
            this.payloads.newEmpty = HashBiMapInverseTest::newEmpty;
            this.payloads.keysAndValues_toString = HashBiMapInverseTest::keysAndValues_toString;
            this.payloads.asUnmodifiable = HashBiMapInverseTest::asUnmodifiable;
            this.payloads.asSynchronized = HashBiMapInverseTest::asSynchronized;
            this.payloads.add = HashBiMapInverseTest::add;
            this.payloads.putPair = HashBiMapInverseTest::putPair;
            this.payloads.withKeyValue = HashBiMapInverseTest::withKeyValue;
            this.payloads.withMap = HashBiMapInverseTest::withMap;
            this.payloads.withMapEmpty = HashBiMapInverseTest::withMapEmpty;
            this.payloads.withMapTargetEmpty = HashBiMapInverseTest::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = HashBiMapInverseTest::withMapEmptyAndTargetEmpty;
            this.payloads.withMapIterable = HashBiMapInverseTest::withMapIterable;
            this.payloads.withMapIterableEmpty = HashBiMapInverseTest::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = HashBiMapInverseTest::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = HashBiMapInverseTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = HashBiMapInverseTest::withMapIterableNull;
            this.payloads.putAllMapIterable = HashBiMapInverseTest::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = HashBiMapInverseTest::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = HashBiMapInverseTest::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = HashBiMapInverseTest::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = HashBiMapInverseTest::putAllMapIterableNull;
            this.payloads.withAllKeyValues = HashBiMapInverseTest::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = HashBiMapInverseTest::withAllKeyValueArguments;
            this.payloads.withoutKey = HashBiMapInverseTest::withoutKey;
            this.payloads.withoutAllKeys = HashBiMapInverseTest::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = HashBiMapInverseTest::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = HashBiMapInverseTest::rehash_null_collision;
            this.payloads.flip = HashBiMapInverseTest::flip;
            this.payloads.size = HashBiMapInverseTest::size;
            this.payloads.forcePut = HashBiMapInverseTest::forcePut;
            this.payloads.put = HashBiMapInverseTest::put;
            this.payloads.flipUniqueValues = HashBiMapInverseTest::flipUniqueValues;
            this.payloads.get = HashBiMapInverseTest::get;
            this.payloads.containsKey = HashBiMapInverseTest::containsKey;
            this.payloads.containsValue = HashBiMapInverseTest::containsValue;
            this.payloads.putAll = HashBiMapInverseTest::putAll;
            this.payloads.remove = HashBiMapInverseTest::remove;
            this.payloads.clear = HashBiMapInverseTest::clear;
            this.payloads.testToString = HashBiMapInverseTest::testToString;
            this.payloads.equalsAndHashCode = HashBiMapInverseTest::equalsAndHashCode;
            this.payloads.nullCollisionWithCastInEquals = HashBiMapInverseTest::nullCollisionWithCastInEquals;
            this.payloads.iterator = HashBiMapInverseTest::iterator;
            this.payloads.withMapNull = HashBiMapInverseTest::withMapNull;
            this.payloads.updateValueWith = HashBiMapInverseTest::updateValueWith;
            this.payloads.updateValue = HashBiMapInverseTest::updateValue;
            this.payloads.updateValue_collisions = HashBiMapInverseTest::updateValue_collisions;
            this.payloads.updateValueWith_collisions = HashBiMapInverseTest::updateValueWith_collisions;
            this.payloads.testClone = HashBiMapInverseTest::testClone;
            this.payloads.into = HashBiMapInverseTest::into;
            this.payloads.keyPreservation = HashBiMapInverseTest::keyPreservation;
        }
    }
}
