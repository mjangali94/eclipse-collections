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

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit TestCase for {@link MutableMap}s.
 */
public abstract class MutableMapTestCase extends MutableMapIterableTestCase {

    @Override
    protected abstract <K, V> MutableMap<K, V> newMap();

    @Override
    protected abstract <K, V> MutableMap<K, V> newMapWithKeyValue(K key, V value);

    @Override
    protected abstract <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2);

    @Override
    protected abstract <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3);

    @Override
    protected abstract <K, V> MutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4);

    @Test
    public void collectKeysAndValues() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "1", 2, "Two");
        MutableList<Integer> toAdd = FastList.newListWith(2, 3);
        map.collectKeysAndValues(toAdd, Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertSize(3, map);
        Verify.assertContainsAllKeyValues(map, 1, "1", 2, "2", 3, "3");
    }

    @Test
    public void testClone() {
        MutableMap<Integer, String> map = this.newMapWithKeysValues(1, "One", 2, "Two");
        MutableMap<Integer, String> clone = map.clone();
        Assert.assertNotSame(map, clone);
        Verify.assertEqualsAndHashCode(map, clone);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_nullCollisionWithCastInEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCollisionWithCastInEquals);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
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
        public void benchmark_collectKeysAndValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new MutableMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> retainAllFromEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> clearEntrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> entrySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsentPutValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsentPut_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getIfAbsentPutWith_block_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> getKeysAndGetValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> keysAndValues_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> keyPreservation;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> putAllMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> putAllMapIterableEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> putAllMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> putAllMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> putAllMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> retainAllFromKeySet_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> rehash_null_collision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> updateValue_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> updateValueWith_collisions;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> collectKeysAndValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableMapTestCase> testClone;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = MutableMapTestCase::stream;
            this.payloads.parallelStream = MutableMapTestCase::parallelStream;
            this.payloads.equalsAndHashCode = MutableMapTestCase::equalsAndHashCode;
            this.payloads.serialization = MutableMapTestCase::serialization;
            this.payloads.isEmpty = MutableMapTestCase::isEmpty;
            this.payloads.notEmpty = MutableMapTestCase::notEmpty;
            this.payloads.ifPresentApply = MutableMapTestCase::ifPresentApply;
            this.payloads.getIfAbsent_function = MutableMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = MutableMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = MutableMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = MutableMapTestCase::getIfAbsentWith;
            this.payloads.tap = MutableMapTestCase::tap;
            this.payloads.forEach = MutableMapTestCase::forEach;
            this.payloads.forEachWith = MutableMapTestCase::forEachWith;
            this.payloads.forEachWithIndex = MutableMapTestCase::forEachWithIndex;
            this.payloads.forEachKey = MutableMapTestCase::forEachKey;
            this.payloads.forEachValue = MutableMapTestCase::forEachValue;
            this.payloads.forEachKeyValue = MutableMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = MutableMapTestCase::injectIntoKeyValue;
            this.payloads.flipUniqueValues = MutableMapTestCase::flipUniqueValues;
            this.payloads.collectMap = MutableMapTestCase::collectMap;
            this.payloads.collectBoolean = MutableMapTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = MutableMapTestCase::collectBooleanWithTarget;
            this.payloads.collectByte = MutableMapTestCase::collectByte;
            this.payloads.collectByteWithTarget = MutableMapTestCase::collectByteWithTarget;
            this.payloads.collectChar = MutableMapTestCase::collectChar;
            this.payloads.collectCharWithTarget = MutableMapTestCase::collectCharWithTarget;
            this.payloads.collectDouble = MutableMapTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = MutableMapTestCase::collectDoubleWithTarget;
            this.payloads.collectFloat = MutableMapTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = MutableMapTestCase::collectFloatWithTarget;
            this.payloads.collectInt = MutableMapTestCase::collectInt;
            this.payloads.collectIntWithTarget = MutableMapTestCase::collectIntWithTarget;
            this.payloads.collectLong = MutableMapTestCase::collectLong;
            this.payloads.collectLongWithTarget = MutableMapTestCase::collectLongWithTarget;
            this.payloads.collectShort = MutableMapTestCase::collectShort;
            this.payloads.collectShortWithTarget = MutableMapTestCase::collectShortWithTarget;
            this.payloads.collectValues = MutableMapTestCase::collectValues;
            this.payloads.select = MutableMapTestCase::select;
            this.payloads.selectWith = MutableMapTestCase::selectWith;
            this.payloads.reject = MutableMapTestCase::reject;
            this.payloads.rejectWith = MutableMapTestCase::rejectWith;
            this.payloads.collect = MutableMapTestCase::collect;
            this.payloads.flatCollect = MutableMapTestCase::flatCollect;
            this.payloads.flatCollectWith = MutableMapTestCase::flatCollectWith;
            this.payloads.selectMap = MutableMapTestCase::selectMap;
            this.payloads.rejectMap = MutableMapTestCase::rejectMap;
            this.payloads.flip = MutableMapTestCase::flip;
            this.payloads.detect = MutableMapTestCase::detect;
            this.payloads.detectOptional = MutableMapTestCase::detectOptional;
            this.payloads.anySatisfy = MutableMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = MutableMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = MutableMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = MutableMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = MutableMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = MutableMapTestCase::noneSatisfyWith;
            this.payloads.appendString = MutableMapTestCase::appendString;
            this.payloads.toBag = MutableMapTestCase::toBag;
            this.payloads.toSortedBag = MutableMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = MutableMapTestCase::toSortedBagBy;
            this.payloads.asLazy = MutableMapTestCase::asLazy;
            this.payloads.toList = MutableMapTestCase::toList;
            this.payloads.toMap = MutableMapTestCase::toMap;
            this.payloads.toSet = MutableMapTestCase::toSet;
            this.payloads.toSortedList = MutableMapTestCase::toSortedList;
            this.payloads.toSortedListBy = MutableMapTestCase::toSortedListBy;
            this.payloads.toSortedSet = MutableMapTestCase::toSortedSet;
            this.payloads.toSortedSetBy = MutableMapTestCase::toSortedSetBy;
            this.payloads.toSortedMap = MutableMapTestCase::toSortedMap;
            this.payloads.chunk = MutableMapTestCase::chunk;
            this.payloads.collect_value = MutableMapTestCase::collect_value;
            this.payloads.collectIf = MutableMapTestCase::collectIf;
            this.payloads.collectWith = MutableMapTestCase::collectWith;
            this.payloads.collectWithToTarget = MutableMapTestCase::collectWithToTarget;
            this.payloads.contains = MutableMapTestCase::contains;
            this.payloads.containsAnyIterable = MutableMapTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = MutableMapTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = MutableMapTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = MutableMapTestCase::containsNoneCollection;
            this.payloads.containsAll = MutableMapTestCase::containsAll;
            this.payloads.containsKey = MutableMapTestCase::containsKey;
            this.payloads.containsValue = MutableMapTestCase::containsValue;
            this.payloads.getFirst = MutableMapTestCase::getFirst;
            this.payloads.getLast = MutableMapTestCase::getLast;
            this.payloads.getOnly = MutableMapTestCase::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapTestCase::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapTestCase::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = MutableMapTestCase::containsAllIterable;
            this.payloads.containsAllArguments = MutableMapTestCase::containsAllArguments;
            this.payloads.count = MutableMapTestCase::count;
            this.payloads.countWith = MutableMapTestCase::countWith;
            this.payloads.detect_value = MutableMapTestCase::detect_value;
            this.payloads.detectOptional_value = MutableMapTestCase::detectOptional_value;
            this.payloads.detectWith = MutableMapTestCase::detectWith;
            this.payloads.detectWithOptional = MutableMapTestCase::detectWithOptional;
            this.payloads.detectIfNone_value = MutableMapTestCase::detectIfNone_value;
            this.payloads.detectWithIfNone = MutableMapTestCase::detectWithIfNone;
            this.payloads.flatten_value = MutableMapTestCase::flatten_value;
            this.payloads.countBy = MutableMapTestCase::countBy;
            this.payloads.countByWith = MutableMapTestCase::countByWith;
            this.payloads.countByEach = MutableMapTestCase::countByEach;
            this.payloads.groupBy = MutableMapTestCase::groupBy;
            this.payloads.groupByEach = MutableMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = MutableMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MutableMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableMapTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = MutableMapTestCase::injectInto;
            this.payloads.injectIntoInt = MutableMapTestCase::injectIntoInt;
            this.payloads.injectIntoLong = MutableMapTestCase::injectIntoLong;
            this.payloads.injectIntoFloat = MutableMapTestCase::injectIntoFloat;
            this.payloads.injectIntoDouble = MutableMapTestCase::injectIntoDouble;
            this.payloads.sumOfInt = MutableMapTestCase::sumOfInt;
            this.payloads.sumOfLong = MutableMapTestCase::sumOfLong;
            this.payloads.testAggregateBy = MutableMapTestCase::testAggregateBy;
            this.payloads.sumOfFloat = MutableMapTestCase::sumOfFloat;
            this.payloads.sumOfDouble = MutableMapTestCase::sumOfDouble;
            this.payloads.sumByInt = MutableMapTestCase::sumByInt;
            this.payloads.sumByFloat = MutableMapTestCase::sumByFloat;
            this.payloads.sumByLong = MutableMapTestCase::sumByLong;
            this.payloads.sumByDouble = MutableMapTestCase::sumByDouble;
            this.payloads.makeString = MutableMapTestCase::makeString;
            this.payloads.min = MutableMapTestCase::min;
            this.payloads.max = MutableMapTestCase::max;
            this.payloads.minBy = MutableMapTestCase::minBy;
            this.payloads.maxBy = MutableMapTestCase::maxBy;
            this.payloads.reject_value = MutableMapTestCase::reject_value;
            this.payloads.rejectWith_value = MutableMapTestCase::rejectWith_value;
            this.payloads.select_value = MutableMapTestCase::select_value;
            this.payloads.selectWith_value = MutableMapTestCase::selectWith_value;
            this.payloads.partition_value = MutableMapTestCase::partition_value;
            this.payloads.partitionWith_value = MutableMapTestCase::partitionWith_value;
            this.payloads.selectInstancesOf_value = MutableMapTestCase::selectInstancesOf_value;
            this.payloads.toArray = MutableMapTestCase::toArray;
            this.payloads.zip = MutableMapTestCase::zip;
            this.payloads.zipWithIndex = MutableMapTestCase::zipWithIndex;
            this.payloads.aggregateByMutating = MutableMapTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MutableMapTestCase::aggregateByNonMutating;
            this.payloads.keyValuesView = MutableMapTestCase::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = MutableMapTestCase::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = MutableMapTestCase::testNewMap;
            this.payloads.testNewMapWithKeyValue = MutableMapTestCase::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = MutableMapTestCase::newMapWithWith;
            this.payloads.newMapWithWithWith = MutableMapTestCase::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = MutableMapTestCase::newMapWithWithWithWith;
            this.payloads.iterator = MutableMapTestCase::iterator;
            this.payloads.keysView = MutableMapTestCase::keysView;
            this.payloads.valuesView = MutableMapTestCase::valuesView;
            this.payloads.test_toString = MutableMapTestCase::test_toString;
            this.payloads.toImmutable = MutableMapTestCase::toImmutable;
            this.payloads.clear = MutableMapTestCase::clear;
            this.payloads.removeObject = MutableMapTestCase::removeObject;
            this.payloads.removeFromEntrySet = MutableMapTestCase::removeFromEntrySet;
            this.payloads.removeAllFromEntrySet = MutableMapTestCase::removeAllFromEntrySet;
            this.payloads.retainAllFromEntrySet = MutableMapTestCase::retainAllFromEntrySet;
            this.payloads.clearEntrySet = MutableMapTestCase::clearEntrySet;
            this.payloads.entrySetEqualsAndHashCode = MutableMapTestCase::entrySetEqualsAndHashCode;
            this.payloads.removeFromKeySet = MutableMapTestCase::removeFromKeySet;
            this.payloads.removeNullFromKeySet = MutableMapTestCase::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = MutableMapTestCase::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = MutableMapTestCase::retainAllFromKeySet;
            this.payloads.clearKeySet = MutableMapTestCase::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = MutableMapTestCase::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = MutableMapTestCase::keySetToArray;
            this.payloads.removeFromValues = MutableMapTestCase::removeFromValues;
            this.payloads.removeNullFromValues = MutableMapTestCase::removeNullFromValues;
            this.payloads.removeAllFromValues = MutableMapTestCase::removeAllFromValues;
            this.payloads.retainAllFromValues = MutableMapTestCase::retainAllFromValues;
            this.payloads.put = MutableMapTestCase::put;
            this.payloads.putAll = MutableMapTestCase::putAll;
            this.payloads.removeKey = MutableMapTestCase::removeKey;
            this.payloads.removeAllKeys = MutableMapTestCase::removeAllKeys;
            this.payloads.removeIf = MutableMapTestCase::removeIf;
            this.payloads.getIfAbsentPut = MutableMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPutValue = MutableMapTestCase::getIfAbsentPutValue;
            this.payloads.getIfAbsentPutWithKey = MutableMapTestCase::getIfAbsentPutWithKey;
            this.payloads.getIfAbsentPutWith = MutableMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPut_block_throws = MutableMapTestCase::getIfAbsentPut_block_throws;
            this.payloads.getIfAbsentPutWith_block_throws = MutableMapTestCase::getIfAbsentPutWith_block_throws;
            this.payloads.getKeysAndGetValues = MutableMapTestCase::getKeysAndGetValues;
            this.payloads.newEmpty = MutableMapTestCase::newEmpty;
            this.payloads.keysAndValues_toString = MutableMapTestCase::keysAndValues_toString;
            this.payloads.keyPreservation = MutableMapTestCase::keyPreservation;
            this.payloads.asUnmodifiable = MutableMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = MutableMapTestCase::asSynchronized;
            this.payloads.add = MutableMapTestCase::add;
            this.payloads.putPair = MutableMapTestCase::putPair;
            this.payloads.withKeyValue = MutableMapTestCase::withKeyValue;
            this.payloads.withMap = MutableMapTestCase::withMap;
            this.payloads.withMapEmpty = MutableMapTestCase::withMapEmpty;
            this.payloads.withMapTargetEmpty = MutableMapTestCase::withMapTargetEmpty;
            this.payloads.withMapEmptyAndTargetEmpty = MutableMapTestCase::withMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = MutableMapTestCase::withMapNull;
            this.payloads.withMapIterable = MutableMapTestCase::withMapIterable;
            this.payloads.withMapIterableEmpty = MutableMapTestCase::withMapIterableEmpty;
            this.payloads.withMapIterableTargetEmpty = MutableMapTestCase::withMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = MutableMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = MutableMapTestCase::withMapIterableNull;
            this.payloads.putAllMapIterable = MutableMapTestCase::putAllMapIterable;
            this.payloads.putAllMapIterableEmpty = MutableMapTestCase::putAllMapIterableEmpty;
            this.payloads.putAllMapIterableTargetEmpty = MutableMapTestCase::putAllMapIterableTargetEmpty;
            this.payloads.putAllMapIterableEmptyAndTargetEmpty = MutableMapTestCase::putAllMapIterableEmptyAndTargetEmpty;
            this.payloads.putAllMapIterableNull = MutableMapTestCase::putAllMapIterableNull;
            this.payloads.withAllKeyValues = MutableMapTestCase::withAllKeyValues;
            this.payloads.withAllKeyValueArguments = MutableMapTestCase::withAllKeyValueArguments;
            this.payloads.withoutKey = MutableMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = MutableMapTestCase::withoutAllKeys;
            this.payloads.retainAllFromKeySet_null_collision = MutableMapTestCase::retainAllFromKeySet_null_collision;
            this.payloads.rehash_null_collision = MutableMapTestCase::rehash_null_collision;
            this.payloads.updateValue = MutableMapTestCase::updateValue;
            this.payloads.updateValue_collisions = MutableMapTestCase::updateValue_collisions;
            this.payloads.updateValueWith = MutableMapTestCase::updateValueWith;
            this.payloads.updateValueWith_collisions = MutableMapTestCase::updateValueWith_collisions;
            this.payloads.collectKeysAndValues = MutableMapTestCase::collectKeysAndValues;
            this.payloads.testClone = MutableMapTestCase::testClone;
        }
    }
}
