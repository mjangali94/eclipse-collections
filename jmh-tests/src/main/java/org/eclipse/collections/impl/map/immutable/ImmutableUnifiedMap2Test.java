/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable;

import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iSet;

public class ImmutableUnifiedMap2Test extends MapIterableTestCase {

    @Override
    protected <K, V> ImmutableMap<K, V> newMap() {
        return new ImmutableUnifiedMap<>(UnifiedMap.newMap());
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeyValue(K key1, V value1) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableUnifiedMap<>(UnifiedMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    @Test
    public void partition_value() {
        MapIterable<String, Integer> map = UnifiedMap.newWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

    @Override
    @Test
    public void partitionWith_value() {
        MapIterable<String, Integer> map = UnifiedMap.newWithKeysValues("A", 1, "B", 2, "C", 3, "D", 4);
        PartitionIterable<Integer> partition = map.partitionWith(Predicates2.in(), map.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iSet(2, 4), partition.getSelected().toSet());
        Assert.assertEquals(iSet(1, 3), partition.getRejected().toSet());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableUnifiedMap2Test instance;

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
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedMap2Test();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> selectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> rejectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> collectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detectOptional_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> testAggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> selectInstancesOf_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> nullCollisionWithCastInEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> testNewMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> testNewMapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> newMapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> newMapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> newMapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> test_toString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMap2Test> partitionWith_value;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableUnifiedMap2Test::stream;
            this.payloads.parallelStream = ImmutableUnifiedMap2Test::parallelStream;
            this.payloads.equalsAndHashCode = ImmutableUnifiedMap2Test::equalsAndHashCode;
            this.payloads.serialization = ImmutableUnifiedMap2Test::serialization;
            this.payloads.isEmpty = ImmutableUnifiedMap2Test::isEmpty;
            this.payloads.notEmpty = ImmutableUnifiedMap2Test::notEmpty;
            this.payloads.ifPresentApply = ImmutableUnifiedMap2Test::ifPresentApply;
            this.payloads.getIfAbsent_function = ImmutableUnifiedMap2Test::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableUnifiedMap2Test::getOrDefault;
            this.payloads.getIfAbsent = ImmutableUnifiedMap2Test::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableUnifiedMap2Test::getIfAbsentWith;
            this.payloads.tap = ImmutableUnifiedMap2Test::tap;
            this.payloads.forEach = ImmutableUnifiedMap2Test::forEach;
            this.payloads.forEachWith = ImmutableUnifiedMap2Test::forEachWith;
            this.payloads.forEachWithIndex = ImmutableUnifiedMap2Test::forEachWithIndex;
            this.payloads.forEachKey = ImmutableUnifiedMap2Test::forEachKey;
            this.payloads.forEachValue = ImmutableUnifiedMap2Test::forEachValue;
            this.payloads.forEachKeyValue = ImmutableUnifiedMap2Test::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableUnifiedMap2Test::injectIntoKeyValue;
            this.payloads.flipUniqueValues = ImmutableUnifiedMap2Test::flipUniqueValues;
            this.payloads.collectMap = ImmutableUnifiedMap2Test::collectMap;
            this.payloads.collectBoolean = ImmutableUnifiedMap2Test::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableUnifiedMap2Test::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableUnifiedMap2Test::collectByte;
            this.payloads.collectByteWithTarget = ImmutableUnifiedMap2Test::collectByteWithTarget;
            this.payloads.collectChar = ImmutableUnifiedMap2Test::collectChar;
            this.payloads.collectCharWithTarget = ImmutableUnifiedMap2Test::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableUnifiedMap2Test::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableUnifiedMap2Test::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableUnifiedMap2Test::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableUnifiedMap2Test::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableUnifiedMap2Test::collectInt;
            this.payloads.collectIntWithTarget = ImmutableUnifiedMap2Test::collectIntWithTarget;
            this.payloads.collectLong = ImmutableUnifiedMap2Test::collectLong;
            this.payloads.collectLongWithTarget = ImmutableUnifiedMap2Test::collectLongWithTarget;
            this.payloads.collectShort = ImmutableUnifiedMap2Test::collectShort;
            this.payloads.collectShortWithTarget = ImmutableUnifiedMap2Test::collectShortWithTarget;
            this.payloads.collectValues = ImmutableUnifiedMap2Test::collectValues;
            this.payloads.select = ImmutableUnifiedMap2Test::select;
            this.payloads.selectWith = ImmutableUnifiedMap2Test::selectWith;
            this.payloads.reject = ImmutableUnifiedMap2Test::reject;
            this.payloads.rejectWith = ImmutableUnifiedMap2Test::rejectWith;
            this.payloads.collect = ImmutableUnifiedMap2Test::collect;
            this.payloads.flatCollect = ImmutableUnifiedMap2Test::flatCollect;
            this.payloads.flatCollectWith = ImmutableUnifiedMap2Test::flatCollectWith;
            this.payloads.selectMap = ImmutableUnifiedMap2Test::selectMap;
            this.payloads.rejectMap = ImmutableUnifiedMap2Test::rejectMap;
            this.payloads.flip = ImmutableUnifiedMap2Test::flip;
            this.payloads.detect = ImmutableUnifiedMap2Test::detect;
            this.payloads.detectOptional = ImmutableUnifiedMap2Test::detectOptional;
            this.payloads.anySatisfy = ImmutableUnifiedMap2Test::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableUnifiedMap2Test::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableUnifiedMap2Test::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableUnifiedMap2Test::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableUnifiedMap2Test::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableUnifiedMap2Test::noneSatisfyWith;
            this.payloads.appendString = ImmutableUnifiedMap2Test::appendString;
            this.payloads.toBag = ImmutableUnifiedMap2Test::toBag;
            this.payloads.toSortedBag = ImmutableUnifiedMap2Test::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableUnifiedMap2Test::toSortedBagBy;
            this.payloads.asLazy = ImmutableUnifiedMap2Test::asLazy;
            this.payloads.toList = ImmutableUnifiedMap2Test::toList;
            this.payloads.toMap = ImmutableUnifiedMap2Test::toMap;
            this.payloads.toSet = ImmutableUnifiedMap2Test::toSet;
            this.payloads.toSortedList = ImmutableUnifiedMap2Test::toSortedList;
            this.payloads.toSortedListBy = ImmutableUnifiedMap2Test::toSortedListBy;
            this.payloads.toSortedSet = ImmutableUnifiedMap2Test::toSortedSet;
            this.payloads.toSortedSetBy = ImmutableUnifiedMap2Test::toSortedSetBy;
            this.payloads.toSortedMap = ImmutableUnifiedMap2Test::toSortedMap;
            this.payloads.chunk = ImmutableUnifiedMap2Test::chunk;
            this.payloads.collect_value = ImmutableUnifiedMap2Test::collect_value;
            this.payloads.collectIf = ImmutableUnifiedMap2Test::collectIf;
            this.payloads.collectWith = ImmutableUnifiedMap2Test::collectWith;
            this.payloads.collectWithToTarget = ImmutableUnifiedMap2Test::collectWithToTarget;
            this.payloads.contains = ImmutableUnifiedMap2Test::contains;
            this.payloads.containsAnyIterable = ImmutableUnifiedMap2Test::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableUnifiedMap2Test::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableUnifiedMap2Test::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableUnifiedMap2Test::containsNoneCollection;
            this.payloads.containsAll = ImmutableUnifiedMap2Test::containsAll;
            this.payloads.containsKey = ImmutableUnifiedMap2Test::containsKey;
            this.payloads.containsValue = ImmutableUnifiedMap2Test::containsValue;
            this.payloads.getFirst = ImmutableUnifiedMap2Test::getFirst;
            this.payloads.getLast = ImmutableUnifiedMap2Test::getLast;
            this.payloads.getOnly = ImmutableUnifiedMap2Test::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMap2Test::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMap2Test::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ImmutableUnifiedMap2Test::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableUnifiedMap2Test::containsAllArguments;
            this.payloads.count = ImmutableUnifiedMap2Test::count;
            this.payloads.countWith = ImmutableUnifiedMap2Test::countWith;
            this.payloads.detect_value = ImmutableUnifiedMap2Test::detect_value;
            this.payloads.detectOptional_value = ImmutableUnifiedMap2Test::detectOptional_value;
            this.payloads.detectWith = ImmutableUnifiedMap2Test::detectWith;
            this.payloads.detectWithOptional = ImmutableUnifiedMap2Test::detectWithOptional;
            this.payloads.detectIfNone_value = ImmutableUnifiedMap2Test::detectIfNone_value;
            this.payloads.detectWithIfNone = ImmutableUnifiedMap2Test::detectWithIfNone;
            this.payloads.flatten_value = ImmutableUnifiedMap2Test::flatten_value;
            this.payloads.countBy = ImmutableUnifiedMap2Test::countBy;
            this.payloads.countByWith = ImmutableUnifiedMap2Test::countByWith;
            this.payloads.countByEach = ImmutableUnifiedMap2Test::countByEach;
            this.payloads.groupBy = ImmutableUnifiedMap2Test::groupBy;
            this.payloads.groupByEach = ImmutableUnifiedMap2Test::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableUnifiedMap2Test::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMap2Test::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableUnifiedMap2Test::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedMap2Test::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.injectInto = ImmutableUnifiedMap2Test::injectInto;
            this.payloads.injectIntoInt = ImmutableUnifiedMap2Test::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableUnifiedMap2Test::injectIntoLong;
            this.payloads.injectIntoFloat = ImmutableUnifiedMap2Test::injectIntoFloat;
            this.payloads.injectIntoDouble = ImmutableUnifiedMap2Test::injectIntoDouble;
            this.payloads.sumOfInt = ImmutableUnifiedMap2Test::sumOfInt;
            this.payloads.sumOfLong = ImmutableUnifiedMap2Test::sumOfLong;
            this.payloads.testAggregateBy = ImmutableUnifiedMap2Test::testAggregateBy;
            this.payloads.sumOfFloat = ImmutableUnifiedMap2Test::sumOfFloat;
            this.payloads.sumOfDouble = ImmutableUnifiedMap2Test::sumOfDouble;
            this.payloads.sumByInt = ImmutableUnifiedMap2Test::sumByInt;
            this.payloads.sumByFloat = ImmutableUnifiedMap2Test::sumByFloat;
            this.payloads.sumByLong = ImmutableUnifiedMap2Test::sumByLong;
            this.payloads.sumByDouble = ImmutableUnifiedMap2Test::sumByDouble;
            this.payloads.makeString = ImmutableUnifiedMap2Test::makeString;
            this.payloads.min = ImmutableUnifiedMap2Test::min;
            this.payloads.max = ImmutableUnifiedMap2Test::max;
            this.payloads.minBy = ImmutableUnifiedMap2Test::minBy;
            this.payloads.maxBy = ImmutableUnifiedMap2Test::maxBy;
            this.payloads.reject_value = ImmutableUnifiedMap2Test::reject_value;
            this.payloads.rejectWith_value = ImmutableUnifiedMap2Test::rejectWith_value;
            this.payloads.select_value = ImmutableUnifiedMap2Test::select_value;
            this.payloads.selectWith_value = ImmutableUnifiedMap2Test::selectWith_value;
            this.payloads.selectInstancesOf_value = ImmutableUnifiedMap2Test::selectInstancesOf_value;
            this.payloads.toArray = ImmutableUnifiedMap2Test::toArray;
            this.payloads.zip = ImmutableUnifiedMap2Test::zip;
            this.payloads.zipWithIndex = ImmutableUnifiedMap2Test::zipWithIndex;
            this.payloads.aggregateByMutating = ImmutableUnifiedMap2Test::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableUnifiedMap2Test::aggregateByNonMutating;
            this.payloads.keyValuesView = ImmutableUnifiedMap2Test::keyValuesView;
            this.payloads.nullCollisionWithCastInEquals = ImmutableUnifiedMap2Test::nullCollisionWithCastInEquals;
            this.payloads.testNewMap = ImmutableUnifiedMap2Test::testNewMap;
            this.payloads.testNewMapWithKeyValue = ImmutableUnifiedMap2Test::testNewMapWithKeyValue;
            this.payloads.newMapWithWith = ImmutableUnifiedMap2Test::newMapWithWith;
            this.payloads.newMapWithWithWith = ImmutableUnifiedMap2Test::newMapWithWithWith;
            this.payloads.newMapWithWithWithWith = ImmutableUnifiedMap2Test::newMapWithWithWithWith;
            this.payloads.iterator = ImmutableUnifiedMap2Test::iterator;
            this.payloads.keysView = ImmutableUnifiedMap2Test::keysView;
            this.payloads.valuesView = ImmutableUnifiedMap2Test::valuesView;
            this.payloads.test_toString = ImmutableUnifiedMap2Test::test_toString;
            this.payloads.partition_value = ImmutableUnifiedMap2Test::partition_value;
            this.payloads.partitionWith_value = ImmutableUnifiedMap2Test::partitionWith_value;
        }
    }
*/
}
