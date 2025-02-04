/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.immutable;

import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;

public class ImmutableTreeMap2Test extends MapIterableTestCase {

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMap() {
        return new ImmutableTreeMap<>(TreeSortedMap.newMap());
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeyValue(K key1, V value1) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1));
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2));
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3, key4, value4));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableTreeMap2Test instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> payload) throws java.lang.Throwable {
            this.instance = new ImmutableTreeMap2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeMap2Test> test_toString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableTreeMap2Test::stream;
            this.payloads.parallelStream = ImmutableTreeMap2Test::parallelStream;
            this.payloads.equalsAndHashCode = ImmutableTreeMap2Test::equalsAndHashCode;
            this.payloads.serialization = ImmutableTreeMap2Test::serialization;
            this.payloads.isEmpty = ImmutableTreeMap2Test::isEmpty;
            this.payloads.notEmpty = ImmutableTreeMap2Test::notEmpty;
            this.payloads.ifPresentApply = ImmutableTreeMap2Test::ifPresentApply;
            this.payloads.getIfAbsent_function = ImmutableTreeMap2Test::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableTreeMap2Test::getOrDefault;
            this.payloads.getIfAbsent = ImmutableTreeMap2Test::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableTreeMap2Test::getIfAbsentWith;
            this.payloads.tap = ImmutableTreeMap2Test::tap;
            this.payloads.forEach = ImmutableTreeMap2Test::forEach;
            this.payloads.forEachWith = ImmutableTreeMap2Test::forEachWith;
            this.payloads.forEachWithIndex = ImmutableTreeMap2Test::forEachWithIndex;
            this.payloads.forEachKey = ImmutableTreeMap2Test::forEachKey;
            this.payloads.forEachValue = ImmutableTreeMap2Test::forEachValue;
            this.payloads.forEachKeyValue = ImmutableTreeMap2Test::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableTreeMap2Test::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ImmutableTreeMap2Test::flipUniqueValues;
            this.payloads.collectMap = ImmutableTreeMap2Test::collectMap;
            this.payloads.collectBoolean = ImmutableTreeMap2Test::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableTreeMap2Test::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableTreeMap2Test::collectByte;
            this.payloads.collectByteWithTarget = ImmutableTreeMap2Test::collectByteWithTarget;
            this.payloads.collectChar = ImmutableTreeMap2Test::collectChar;
            this.payloads.collectCharWithTarget = ImmutableTreeMap2Test::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableTreeMap2Test::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableTreeMap2Test::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableTreeMap2Test::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableTreeMap2Test::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableTreeMap2Test::collectInt;
            this.payloads.collectIntWithTarget = ImmutableTreeMap2Test::collectIntWithTarget;
            this.payloads.collectLong = ImmutableTreeMap2Test::collectLong;
            this.payloads.collectLongWithTarget = ImmutableTreeMap2Test::collectLongWithTarget;
            this.payloads.collectShort = ImmutableTreeMap2Test::collectShort;
            this.payloads.collectShortWithTarget = ImmutableTreeMap2Test::collectShortWithTarget;
            this.payloads.collectValues = ImmutableTreeMap2Test::collectValues;
            this.payloads.select = ImmutableTreeMap2Test::select;
            this.payloads.selectWith = ImmutableTreeMap2Test::selectWith;
            this.payloads.reject = ImmutableTreeMap2Test::reject;
            this.payloads.rejectWith = ImmutableTreeMap2Test::rejectWith;
            this.payloads.collect = ImmutableTreeMap2Test::collect;
            this.payloads.flatCollect = ImmutableTreeMap2Test::flatCollect;
            this.payloads.flatCollectWith = ImmutableTreeMap2Test::flatCollectWith;
            this.payloads.selectMap = ImmutableTreeMap2Test::selectMap;
            this.payloads.rejectMap = ImmutableTreeMap2Test::rejectMap;
            this.payloads.flip = ImmutableTreeMap2Test::flip;
            this.payloads.detect = ImmutableTreeMap2Test::detect;
            this.payloads.detectOptional = ImmutableTreeMap2Test::detectOptional;
            this.payloads.anySatisfy = ImmutableTreeMap2Test::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableTreeMap2Test::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableTreeMap2Test::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableTreeMap2Test::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableTreeMap2Test::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableTreeMap2Test::noneSatisfyWith;
            this.payloads.appendString = ImmutableTreeMap2Test::appendString;
            this.payloads.toBag = ImmutableTreeMap2Test::toBag;
            this.payloads.toSortedBag = ImmutableTreeMap2Test::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableTreeMap2Test::toSortedBagBy;
            this.payloads.asLazy = ImmutableTreeMap2Test::asLazy;
            this.payloads.toList = ImmutableTreeMap2Test::toList;
            this.payloads.toMap = ImmutableTreeMap2Test::toMap;
            this.payloads.toSet = ImmutableTreeMap2Test::toSet;
            this.payloads.toSortedList = ImmutableTreeMap2Test::toSortedList;
            this.payloads.toSortedListBy = ImmutableTreeMap2Test::toSortedListBy;
            this.payloads.toSortedSet = ImmutableTreeMap2Test::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableTreeMap2Test::toSortedSetBy;
            this.payloads.toSortedMap = ImmutableTreeMap2Test::toSortedMap;
            this.payloads.chunk = ImmutableTreeMap2Test::chunk;
            this.payloads.collect_value = ImmutableTreeMap2Test::collect_value;
            this.payloads.collectIf = ImmutableTreeMap2Test::collectIf;
            this.payloads.collectWith = ImmutableTreeMap2Test::collectWith;
            this.payloads.collectWithToTarget = ImmutableTreeMap2Test::collectWithToTarget;
            this.payloads.contains = ImmutableTreeMap2Test::contains;
            this.payloads.containsAnyIterable = ImmutableTreeMap2Test::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableTreeMap2Test::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableTreeMap2Test::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableTreeMap2Test::containsNoneCollection;
            this.payloads.containsAll = ImmutableTreeMap2Test::containsAll;
            this.payloads.containsKey = ImmutableTreeMap2Test::containsKey;
            this.payloads.containsValue = ImmutableTreeMap2Test::containsValue;
            this.payloads.getFirst = ImmutableTreeMap2Test::getFirst;
            this.payloads.getLast = ImmutableTreeMap2Test::getLast;
            this.payloads.getOnly = ImmutableTreeMap2Test::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMap2Test::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMap2Test::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ImmutableTreeMap2Test::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableTreeMap2Test::containsAllArguments;
            this.payloads.count = ImmutableTreeMap2Test::count;
            this.payloads.countWith = ImmutableTreeMap2Test::countWith;
            this.payloads.detect_value = ImmutableTreeMap2Test::detect_value;
            this.payloads.detectOptional_value = ImmutableTreeMap2Test::detectOptional_value;
            this.payloads.detectWith = ImmutableTreeMap2Test::detectWith;
            this.payloads.detectWithOptional = ImmutableTreeMap2Test::detectWithOptional;
            this.payloads.detectIfNone_value = ImmutableTreeMap2Test::detectIfNone_value;
            this.payloads.detectWithIfNone = ImmutableTreeMap2Test::detectWithIfNone;
            this.payloads.flatten_value = ImmutableTreeMap2Test::flatten_value;
            this.payloads.countBy = ImmutableTreeMap2Test::countBy;
            this.payloads.countByWith = ImmutableTreeMap2Test::countByWith;
            this.payloads.countByEach = ImmutableTreeMap2Test::countByEach;
            this.payloads.groupBy = ImmutableTreeMap2Test::groupBy;
            this.payloads.groupByEach = ImmutableTreeMap2Test::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableTreeMap2Test::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMap2Test::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableTreeMap2Test::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeMap2Test::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ImmutableTreeMap2Test::injectInto;
            this.payloads.injectIntoInt = ImmutableTreeMap2Test::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableTreeMap2Test::injectIntoLong;
            this.payloads.injectIntoFloat = ImmutableTreeMap2Test::injectIntoFloat;
            this.payloads.injectIntoDouble = ImmutableTreeMap2Test::injectIntoDouble;
            this.payloads.sumOfInt = ImmutableTreeMap2Test::sumOfInt;
            this.payloads.sumOfLong = ImmutableTreeMap2Test::sumOfLong;
            this.payloads.testAggregateBy = ImmutableTreeMap2Test::testAggregateBy;
            this.payloads.sumOfFloat = ImmutableTreeMap2Test::sumOfFloat;
            this.payloads.sumOfDouble = ImmutableTreeMap2Test::sumOfDouble;
            this.payloads.sumByInt = ImmutableTreeMap2Test::sumByInt;
            this.payloads.sumByFloat = ImmutableTreeMap2Test::sumByFloat;
            this.payloads.sumByLong = ImmutableTreeMap2Test::sumByLong;
            this.payloads.sumByDouble = ImmutableTreeMap2Test::sumByDouble;
            this.payloads.makeString = ImmutableTreeMap2Test::makeString;
            this.payloads.min = ImmutableTreeMap2Test::min;
            this.payloads.max = ImmutableTreeMap2Test::max;
            this.payloads.minBy = ImmutableTreeMap2Test::minBy;
            this.payloads.maxBy = ImmutableTreeMap2Test::maxBy;
            this.payloads.reject_value = ImmutableTreeMap2Test::reject_value;
            this.payloads.rejectWith_value = ImmutableTreeMap2Test::rejectWith_value;
            this.payloads.select_value = ImmutableTreeMap2Test::select_value;
            this.payloads.selectWith_value = ImmutableTreeMap2Test::selectWith_value;
            this.payloads.partition_value = ImmutableTreeMap2Test::partition_value;
            this.payloads.partitionWith_value = ImmutableTreeMap2Test::partitionWith_value;
            this.payloads.selectInstancesOf_value = ImmutableTreeMap2Test::selectInstancesOf_value;
            this.payloads.toArray = ImmutableTreeMap2Test::toArray;
            this.payloads.zip = ImmutableTreeMap2Test::zip;
            this.payloads.zipWithIndex = ImmutableTreeMap2Test::zipWithIndex;
            this.payloads.aggregateByMutating = ImmutableTreeMap2Test::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableTreeMap2Test::aggregateByNonMutating;
            this.payloads.keyValuesView = ImmutableTreeMap2Test::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ImmutableTreeMap2Test::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ImmutableTreeMap2Test::testNewMap;
            this.payloads.testNewMapWithKeyValue = ImmutableTreeMap2Test::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ImmutableTreeMap2Test::newMapWithWith;
            this.payloads.newMapWithWithWith = ImmutableTreeMap2Test::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ImmutableTreeMap2Test::newMapWithWithWithWith;
            this.payloads.iterator = ImmutableTreeMap2Test::iterator;
            this.payloads.keysView = ImmutableTreeMap2Test::keysView;
            this.payloads.valuesView = ImmutableTreeMap2Test::valuesView;
            this.payloads.test_toString = ImmutableTreeMap2Test::test_toString;
        }
    }
*/
}
