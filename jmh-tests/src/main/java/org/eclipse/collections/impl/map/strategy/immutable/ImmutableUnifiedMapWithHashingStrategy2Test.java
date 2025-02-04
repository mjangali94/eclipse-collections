/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.strategy.immutable;

import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.map.strategy.mutable.UnifiedMapWithHashingStrategy;
import org.eclipse.collections.impl.tuple.Tuples;

public class ImmutableUnifiedMapWithHashingStrategy2Test extends MapIterableTestCase {

    @Override
    protected <K, V> ImmutableMap<K, V> newMap() {
        return new ImmutableUnifiedMapWithHashingStrategy<>(UnifiedMapWithHashingStrategy.newMap(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy())));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeyValue(K key1, V value1) {
        return new ImmutableUnifiedMapWithHashingStrategy<>(UnifiedMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), key1, value1));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new ImmutableUnifiedMapWithHashingStrategy<>(UnifiedMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), key1, value1, key2, value2));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new ImmutableUnifiedMapWithHashingStrategy<>(UnifiedMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableUnifiedMapWithHashingStrategy<>(UnifiedMapWithHashingStrategy.newMapWith(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), Tuples.pair(key1, value1), Tuples.pair(key2, value2), Tuples.pair(key3, value3), Tuples.pair(key4, value4)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableUnifiedMapWithHashingStrategy2Test instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedMapWithHashingStrategy2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategy2Test> test_toString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableUnifiedMapWithHashingStrategy2Test::stream;
            this.payloads.parallelStream = ImmutableUnifiedMapWithHashingStrategy2Test::parallelStream;
            this.payloads.equalsAndHashCode = ImmutableUnifiedMapWithHashingStrategy2Test::equalsAndHashCode;
            this.payloads.serialization = ImmutableUnifiedMapWithHashingStrategy2Test::serialization;
            this.payloads.isEmpty = ImmutableUnifiedMapWithHashingStrategy2Test::isEmpty;
            this.payloads.notEmpty = ImmutableUnifiedMapWithHashingStrategy2Test::notEmpty;
            this.payloads.ifPresentApply = ImmutableUnifiedMapWithHashingStrategy2Test::ifPresentApply;
            this.payloads.getIfAbsent_function = ImmutableUnifiedMapWithHashingStrategy2Test::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableUnifiedMapWithHashingStrategy2Test::getOrDefault;
            this.payloads.getIfAbsent = ImmutableUnifiedMapWithHashingStrategy2Test::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableUnifiedMapWithHashingStrategy2Test::getIfAbsentWith;
            this.payloads.tap = ImmutableUnifiedMapWithHashingStrategy2Test::tap;
            this.payloads.forEach = ImmutableUnifiedMapWithHashingStrategy2Test::forEach;
            this.payloads.forEachWith = ImmutableUnifiedMapWithHashingStrategy2Test::forEachWith;
            this.payloads.forEachWithIndex = ImmutableUnifiedMapWithHashingStrategy2Test::forEachWithIndex;
            this.payloads.forEachKey = ImmutableUnifiedMapWithHashingStrategy2Test::forEachKey;
            this.payloads.forEachValue = ImmutableUnifiedMapWithHashingStrategy2Test::forEachValue;
            this.payloads.forEachKeyValue = ImmutableUnifiedMapWithHashingStrategy2Test::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableUnifiedMapWithHashingStrategy2Test::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ImmutableUnifiedMapWithHashingStrategy2Test::flipUniqueValues;
            this.payloads.collectMap = ImmutableUnifiedMapWithHashingStrategy2Test::collectMap;
            this.payloads.collectBoolean = ImmutableUnifiedMapWithHashingStrategy2Test::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableUnifiedMapWithHashingStrategy2Test::collectByte;
            this.payloads.collectByteWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectByteWithTarget;
            this.payloads.collectChar = ImmutableUnifiedMapWithHashingStrategy2Test::collectChar;
            this.payloads.collectCharWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableUnifiedMapWithHashingStrategy2Test::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableUnifiedMapWithHashingStrategy2Test::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableUnifiedMapWithHashingStrategy2Test::collectInt;
            this.payloads.collectIntWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectIntWithTarget;
            this.payloads.collectLong = ImmutableUnifiedMapWithHashingStrategy2Test::collectLong;
            this.payloads.collectLongWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectLongWithTarget;
            this.payloads.collectShort = ImmutableUnifiedMapWithHashingStrategy2Test::collectShort;
            this.payloads.collectShortWithTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectShortWithTarget;
            this.payloads.collectValues = ImmutableUnifiedMapWithHashingStrategy2Test::collectValues;
            this.payloads.select = ImmutableUnifiedMapWithHashingStrategy2Test::select;
            this.payloads.selectWith = ImmutableUnifiedMapWithHashingStrategy2Test::selectWith;
            this.payloads.reject = ImmutableUnifiedMapWithHashingStrategy2Test::reject;
            this.payloads.rejectWith = ImmutableUnifiedMapWithHashingStrategy2Test::rejectWith;
            this.payloads.collect = ImmutableUnifiedMapWithHashingStrategy2Test::collect;
            this.payloads.flatCollect = ImmutableUnifiedMapWithHashingStrategy2Test::flatCollect;
            this.payloads.flatCollectWith = ImmutableUnifiedMapWithHashingStrategy2Test::flatCollectWith;
            this.payloads.selectMap = ImmutableUnifiedMapWithHashingStrategy2Test::selectMap;
            this.payloads.rejectMap = ImmutableUnifiedMapWithHashingStrategy2Test::rejectMap;
            this.payloads.flip = ImmutableUnifiedMapWithHashingStrategy2Test::flip;
            this.payloads.detect = ImmutableUnifiedMapWithHashingStrategy2Test::detect;
            this.payloads.detectOptional = ImmutableUnifiedMapWithHashingStrategy2Test::detectOptional;
            this.payloads.anySatisfy = ImmutableUnifiedMapWithHashingStrategy2Test::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableUnifiedMapWithHashingStrategy2Test::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableUnifiedMapWithHashingStrategy2Test::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableUnifiedMapWithHashingStrategy2Test::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableUnifiedMapWithHashingStrategy2Test::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableUnifiedMapWithHashingStrategy2Test::noneSatisfyWith;
            this.payloads.appendString = ImmutableUnifiedMapWithHashingStrategy2Test::appendString;
            this.payloads.toBag = ImmutableUnifiedMapWithHashingStrategy2Test::toBag;
            this.payloads.toSortedBag = ImmutableUnifiedMapWithHashingStrategy2Test::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableUnifiedMapWithHashingStrategy2Test::toSortedBagBy;
            this.payloads.asLazy = ImmutableUnifiedMapWithHashingStrategy2Test::asLazy;
            this.payloads.toList = ImmutableUnifiedMapWithHashingStrategy2Test::toList;
            this.payloads.toMap = ImmutableUnifiedMapWithHashingStrategy2Test::toMap;
            this.payloads.toSet = ImmutableUnifiedMapWithHashingStrategy2Test::toSet;
            this.payloads.toSortedList = ImmutableUnifiedMapWithHashingStrategy2Test::toSortedList;
            this.payloads.toSortedListBy = ImmutableUnifiedMapWithHashingStrategy2Test::toSortedListBy;
            this.payloads.toSortedSet = ImmutableUnifiedMapWithHashingStrategy2Test::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableUnifiedMapWithHashingStrategy2Test::toSortedSetBy;
            this.payloads.toSortedMap = ImmutableUnifiedMapWithHashingStrategy2Test::toSortedMap;
            this.payloads.chunk = ImmutableUnifiedMapWithHashingStrategy2Test::chunk;
            this.payloads.collect_value = ImmutableUnifiedMapWithHashingStrategy2Test::collect_value;
            this.payloads.collectIf = ImmutableUnifiedMapWithHashingStrategy2Test::collectIf;
            this.payloads.collectWith = ImmutableUnifiedMapWithHashingStrategy2Test::collectWith;
            this.payloads.collectWithToTarget = ImmutableUnifiedMapWithHashingStrategy2Test::collectWithToTarget;
            this.payloads.contains = ImmutableUnifiedMapWithHashingStrategy2Test::contains;
            this.payloads.containsAnyIterable = ImmutableUnifiedMapWithHashingStrategy2Test::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableUnifiedMapWithHashingStrategy2Test::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableUnifiedMapWithHashingStrategy2Test::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableUnifiedMapWithHashingStrategy2Test::containsNoneCollection;
            this.payloads.containsAll = ImmutableUnifiedMapWithHashingStrategy2Test::containsAll;
            this.payloads.containsKey = ImmutableUnifiedMapWithHashingStrategy2Test::containsKey;
            this.payloads.containsValue = ImmutableUnifiedMapWithHashingStrategy2Test::containsValue;
            this.payloads.getFirst = ImmutableUnifiedMapWithHashingStrategy2Test::getFirst;
            this.payloads.getLast = ImmutableUnifiedMapWithHashingStrategy2Test::getLast;
            this.payloads.getOnly = ImmutableUnifiedMapWithHashingStrategy2Test::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMapWithHashingStrategy2Test::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMapWithHashingStrategy2Test::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ImmutableUnifiedMapWithHashingStrategy2Test::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableUnifiedMapWithHashingStrategy2Test::containsAllArguments;
            this.payloads.count = ImmutableUnifiedMapWithHashingStrategy2Test::count;
            this.payloads.countWith = ImmutableUnifiedMapWithHashingStrategy2Test::countWith;
            this.payloads.detect_value = ImmutableUnifiedMapWithHashingStrategy2Test::detect_value;
            this.payloads.detectOptional_value = ImmutableUnifiedMapWithHashingStrategy2Test::detectOptional_value;
            this.payloads.detectWith = ImmutableUnifiedMapWithHashingStrategy2Test::detectWith;
            this.payloads.detectWithOptional = ImmutableUnifiedMapWithHashingStrategy2Test::detectWithOptional;
            this.payloads.detectIfNone_value = ImmutableUnifiedMapWithHashingStrategy2Test::detectIfNone_value;
            this.payloads.detectWithIfNone = ImmutableUnifiedMapWithHashingStrategy2Test::detectWithIfNone;
            this.payloads.flatten_value = ImmutableUnifiedMapWithHashingStrategy2Test::flatten_value;
            this.payloads.countBy = ImmutableUnifiedMapWithHashingStrategy2Test::countBy;
            this.payloads.countByWith = ImmutableUnifiedMapWithHashingStrategy2Test::countByWith;
            this.payloads.countByEach = ImmutableUnifiedMapWithHashingStrategy2Test::countByEach;
            this.payloads.groupBy = ImmutableUnifiedMapWithHashingStrategy2Test::groupBy;
            this.payloads.groupByEach = ImmutableUnifiedMapWithHashingStrategy2Test::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableUnifiedMapWithHashingStrategy2Test::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMapWithHashingStrategy2Test::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableUnifiedMapWithHashingStrategy2Test::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMapWithHashingStrategy2Test::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ImmutableUnifiedMapWithHashingStrategy2Test::injectInto;
            this.payloads.injectIntoInt = ImmutableUnifiedMapWithHashingStrategy2Test::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableUnifiedMapWithHashingStrategy2Test::injectIntoLong;
            this.payloads.injectIntoFloat = ImmutableUnifiedMapWithHashingStrategy2Test::injectIntoFloat;
            this.payloads.injectIntoDouble = ImmutableUnifiedMapWithHashingStrategy2Test::injectIntoDouble;
            this.payloads.sumOfInt = ImmutableUnifiedMapWithHashingStrategy2Test::sumOfInt;
            this.payloads.sumOfLong = ImmutableUnifiedMapWithHashingStrategy2Test::sumOfLong;
            this.payloads.testAggregateBy = ImmutableUnifiedMapWithHashingStrategy2Test::testAggregateBy;
            this.payloads.sumOfFloat = ImmutableUnifiedMapWithHashingStrategy2Test::sumOfFloat;
            this.payloads.sumOfDouble = ImmutableUnifiedMapWithHashingStrategy2Test::sumOfDouble;
            this.payloads.sumByInt = ImmutableUnifiedMapWithHashingStrategy2Test::sumByInt;
            this.payloads.sumByFloat = ImmutableUnifiedMapWithHashingStrategy2Test::sumByFloat;
            this.payloads.sumByLong = ImmutableUnifiedMapWithHashingStrategy2Test::sumByLong;
            this.payloads.sumByDouble = ImmutableUnifiedMapWithHashingStrategy2Test::sumByDouble;
            this.payloads.makeString = ImmutableUnifiedMapWithHashingStrategy2Test::makeString;
            this.payloads.min = ImmutableUnifiedMapWithHashingStrategy2Test::min;
            this.payloads.max = ImmutableUnifiedMapWithHashingStrategy2Test::max;
            this.payloads.minBy = ImmutableUnifiedMapWithHashingStrategy2Test::minBy;
            this.payloads.maxBy = ImmutableUnifiedMapWithHashingStrategy2Test::maxBy;
            this.payloads.reject_value = ImmutableUnifiedMapWithHashingStrategy2Test::reject_value;
            this.payloads.rejectWith_value = ImmutableUnifiedMapWithHashingStrategy2Test::rejectWith_value;
            this.payloads.select_value = ImmutableUnifiedMapWithHashingStrategy2Test::select_value;
            this.payloads.selectWith_value = ImmutableUnifiedMapWithHashingStrategy2Test::selectWith_value;
            this.payloads.partition_value = ImmutableUnifiedMapWithHashingStrategy2Test::partition_value;
            this.payloads.partitionWith_value = ImmutableUnifiedMapWithHashingStrategy2Test::partitionWith_value;
            this.payloads.selectInstancesOf_value = ImmutableUnifiedMapWithHashingStrategy2Test::selectInstancesOf_value;
            this.payloads.toArray = ImmutableUnifiedMapWithHashingStrategy2Test::toArray;
            this.payloads.zip = ImmutableUnifiedMapWithHashingStrategy2Test::zip;
            this.payloads.zipWithIndex = ImmutableUnifiedMapWithHashingStrategy2Test::zipWithIndex;
            this.payloads.aggregateByMutating = ImmutableUnifiedMapWithHashingStrategy2Test::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableUnifiedMapWithHashingStrategy2Test::aggregateByNonMutating;
            this.payloads.keyValuesView = ImmutableUnifiedMapWithHashingStrategy2Test::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ImmutableUnifiedMapWithHashingStrategy2Test::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ImmutableUnifiedMapWithHashingStrategy2Test::testNewMap;
            this.payloads.testNewMapWithKeyValue = ImmutableUnifiedMapWithHashingStrategy2Test::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ImmutableUnifiedMapWithHashingStrategy2Test::newMapWithWith;
            this.payloads.newMapWithWithWith = ImmutableUnifiedMapWithHashingStrategy2Test::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ImmutableUnifiedMapWithHashingStrategy2Test::newMapWithWithWithWith;
            this.payloads.iterator = ImmutableUnifiedMapWithHashingStrategy2Test::iterator;
            this.payloads.keysView = ImmutableUnifiedMapWithHashingStrategy2Test::keysView;
            this.payloads.valuesView = ImmutableUnifiedMapWithHashingStrategy2Test::valuesView;
            this.payloads.test_toString = ImmutableUnifiedMapWithHashingStrategy2Test::test_toString;
        }
    }
}
