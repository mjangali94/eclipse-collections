/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortObjectMap}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapTest.stg.
 */
public class SynchronizedShortObjectMapTest extends AbstractMutableShortObjectMapTestCase {

    private final SynchronizedShortObjectMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedShortObjectMap<String> classUnderTest() {
        return new SynchronizedShortObjectMap<>(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo"));
    }

    @Override
    protected <T> SynchronizedShortObjectMap<T> newWithKeysValues(short key1, T value1) {
        return new SynchronizedShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2) {
        return new SynchronizedShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2, short key3, T value3) {
        return new SynchronizedShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedShortObjectMap<T> getEmptyMap() {
        return new SynchronizedShortObjectMap<>(new ShortObjectHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedShortObjectMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
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
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
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
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
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
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
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
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortObjectMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortObjectMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedShortObjectMapTest::keySet;
            this.payloads.values = SynchronizedShortObjectMapTest::values;
            this.payloads.select = SynchronizedShortObjectMapTest::select;
            this.payloads.selectWith = SynchronizedShortObjectMapTest::selectWith;
            this.payloads.selectWith_withTarget = SynchronizedShortObjectMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = SynchronizedShortObjectMapTest::selectInstancesOf;
            this.payloads.collect = SynchronizedShortObjectMapTest::collect;
            this.payloads.collectBoolean = SynchronizedShortObjectMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = SynchronizedShortObjectMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = SynchronizedShortObjectMapTest::collectByte;
            this.payloads.collectByte_withTarget = SynchronizedShortObjectMapTest::collectByte_withTarget;
            this.payloads.collectChar = SynchronizedShortObjectMapTest::collectChar;
            this.payloads.collectChar_withTarget = SynchronizedShortObjectMapTest::collectChar_withTarget;
            this.payloads.collectDouble = SynchronizedShortObjectMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = SynchronizedShortObjectMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = SynchronizedShortObjectMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = SynchronizedShortObjectMapTest::collectFloat_withTarget;
            this.payloads.collectInt = SynchronizedShortObjectMapTest::collectInt;
            this.payloads.collectInt_withTarget = SynchronizedShortObjectMapTest::collectInt_withTarget;
            this.payloads.collectLong = SynchronizedShortObjectMapTest::collectLong;
            this.payloads.collectLong_withTarget = SynchronizedShortObjectMapTest::collectLong_withTarget;
            this.payloads.collectShort = SynchronizedShortObjectMapTest::collectShort;
            this.payloads.collectShort_withTarget = SynchronizedShortObjectMapTest::collectShort_withTarget;
            this.payloads.collectWith = SynchronizedShortObjectMapTest::collectWith;
            this.payloads.collectWithTarget = SynchronizedShortObjectMapTest::collectWithTarget;
            this.payloads.collectIf = SynchronizedShortObjectMapTest::collectIf;
            this.payloads.flatCollect = SynchronizedShortObjectMapTest::flatCollect;
            this.payloads.detect = SynchronizedShortObjectMapTest::detect;
            this.payloads.detectWith = SynchronizedShortObjectMapTest::detectWith;
            this.payloads.detectOptional = SynchronizedShortObjectMapTest::detectOptional;
            this.payloads.detectWithOptional = SynchronizedShortObjectMapTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedShortObjectMapTest::detectIfNone;
            this.payloads.detectWithIfNone = SynchronizedShortObjectMapTest::detectWithIfNone;
            this.payloads.count = SynchronizedShortObjectMapTest::count;
            this.payloads.countWith = SynchronizedShortObjectMapTest::countWith;
            this.payloads.anySatisfy = SynchronizedShortObjectMapTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedShortObjectMapTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedShortObjectMapTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedShortObjectMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedShortObjectMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedShortObjectMapTest::noneSatisfyWith;
            this.payloads.injectInto = SynchronizedShortObjectMapTest::injectInto;
            this.payloads.intInjectInto = SynchronizedShortObjectMapTest::intInjectInto;
            this.payloads.longInjectInto = SynchronizedShortObjectMapTest::longInjectInto;
            this.payloads.floatInjectInto = SynchronizedShortObjectMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = SynchronizedShortObjectMapTest::doubleInjectInto;
            this.payloads.toList = SynchronizedShortObjectMapTest::toList;
            this.payloads.toSortedList = SynchronizedShortObjectMapTest::toSortedList;
            this.payloads.toSet = SynchronizedShortObjectMapTest::toSet;
            this.payloads.toSortedSet = SynchronizedShortObjectMapTest::toSortedSet;
            this.payloads.toBag = SynchronizedShortObjectMapTest::toBag;
            this.payloads.toMap = SynchronizedShortObjectMapTest::toMap;
            this.payloads.toMapTarget = SynchronizedShortObjectMapTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedShortObjectMapTest::toSortedMap;
            this.payloads.toImmutableList = SynchronizedShortObjectMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = SynchronizedShortObjectMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = SynchronizedShortObjectMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = SynchronizedShortObjectMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = SynchronizedShortObjectMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = SynchronizedShortObjectMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = SynchronizedShortObjectMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = SynchronizedShortObjectMapTest::toArray;
            this.payloads.min = SynchronizedShortObjectMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = SynchronizedShortObjectMapTest::maxBy;
            this.payloads.max = SynchronizedShortObjectMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = SynchronizedShortObjectMapTest::minBy;
            this.payloads.sumOfInt = SynchronizedShortObjectMapTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedShortObjectMapTest::sumOfLong;
            this.payloads.sumOfDouble = SynchronizedShortObjectMapTest::sumOfDouble;
            this.payloads.sumOfFloat = SynchronizedShortObjectMapTest::sumOfFloat;
            this.payloads.sumByInt = SynchronizedShortObjectMapTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedShortObjectMapTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedShortObjectMapTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedShortObjectMapTest::sumByDouble;
            this.payloads.keysView = SynchronizedShortObjectMapTest::keysView;
            this.payloads.reject = SynchronizedShortObjectMapTest::reject;
            this.payloads.rejectWith = SynchronizedShortObjectMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = SynchronizedShortObjectMapTest::rejectWith_withTarget;
            this.payloads.partition = SynchronizedShortObjectMapTest::partition;
            this.payloads.partitionWith = SynchronizedShortObjectMapTest::partitionWith;
            this.payloads.forEachValue = SynchronizedShortObjectMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedShortObjectMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedShortObjectMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedShortObjectMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = SynchronizedShortObjectMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortObjectMapTest::notEmpty;
            this.payloads.getFirst = SynchronizedShortObjectMapTest::getFirst;
            this.payloads.getLast = SynchronizedShortObjectMapTest::getLast;
            this.payloads.getOnly = SynchronizedShortObjectMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedShortObjectMapTest::containsAllIterable;
            this.payloads.containsAll = SynchronizedShortObjectMapTest::containsAll;
            this.payloads.containsAnyIterable = SynchronizedShortObjectMapTest::containsAnyIterable;
            this.payloads.containsAny = SynchronizedShortObjectMapTest::containsAny;
            this.payloads.containsNoneIterable = SynchronizedShortObjectMapTest::containsNoneIterable;
            this.payloads.containsNone = SynchronizedShortObjectMapTest::containsNone;
            this.payloads.containsAllArguments = SynchronizedShortObjectMapTest::containsAllArguments;
            this.payloads.testEquals = SynchronizedShortObjectMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedShortObjectMapTest::testHashCode;
            this.payloads.testToString = SynchronizedShortObjectMapTest::testToString;
            this.payloads.zip = SynchronizedShortObjectMapTest::zip;
            this.payloads.zipWithIndex = SynchronizedShortObjectMapTest::zipWithIndex;
            this.payloads.chunk = SynchronizedShortObjectMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = SynchronizedShortObjectMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = SynchronizedShortObjectMapTest::aggregateBy;
            this.payloads.groupBy = SynchronizedShortObjectMapTest::groupBy;
            this.payloads.groupByEach = SynchronizedShortObjectMapTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedShortObjectMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedShortObjectMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortObjectMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = SynchronizedShortObjectMapTest::makeString;
            this.payloads.appendString = SynchronizedShortObjectMapTest::appendString;
            this.payloads.tap = SynchronizedShortObjectMapTest::tap;
            this.payloads.forEach = SynchronizedShortObjectMapTest::forEach;
            this.payloads.forEachWithIndex = SynchronizedShortObjectMapTest::forEachWithIndex;
            this.payloads.forEachWith = SynchronizedShortObjectMapTest::forEachWith;
            this.payloads.toImmutable = SynchronizedShortObjectMapTest::toImmutable;
            this.payloads.toSortedBag = SynchronizedShortObjectMapTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedShortObjectMapTest::toSortedBagBy;
            this.payloads.stream = SynchronizedShortObjectMapTest::stream;
            this.payloads.parallelStream = SynchronizedShortObjectMapTest::parallelStream;
            this.payloads.clear = SynchronizedShortObjectMapTest::clear;
            this.payloads.removeKey = SynchronizedShortObjectMapTest::removeKey;
            this.payloads.remove = SynchronizedShortObjectMapTest::remove;
            this.payloads.put = SynchronizedShortObjectMapTest::put;
            this.payloads.putPair = SynchronizedShortObjectMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedShortObjectMapTest::putDuplicateWithRemovedSlot;
            this.payloads.putAll = SynchronizedShortObjectMapTest::putAll;
            this.payloads.getIfAbsentPut_Value = SynchronizedShortObjectMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = SynchronizedShortObjectMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedShortObjectMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedShortObjectMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedShortObjectMapTest::updateValue;
            this.payloads.updateValueWith = SynchronizedShortObjectMapTest::updateValueWith;
            this.payloads.freeze = SynchronizedShortObjectMapTest::freeze;
            this.payloads.withoutKey = SynchronizedShortObjectMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedShortObjectMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = SynchronizedShortObjectMapTest::withAllKeyValues;
            this.payloads.get = SynchronizedShortObjectMapTest::get;
            this.payloads.getIfAbsent = SynchronizedShortObjectMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedShortObjectMapTest::containsKey;
            this.payloads.containsValue = SynchronizedShortObjectMapTest::containsValue;
            this.payloads.size = SynchronizedShortObjectMapTest::size;
            this.payloads.contains = SynchronizedShortObjectMapTest::contains;
            this.payloads.withKeysValues = SynchronizedShortObjectMapTest::withKeysValues;
            this.payloads.iterator = SynchronizedShortObjectMapTest::iterator;
            this.payloads.asUnmodifiable = SynchronizedShortObjectMapTest::asUnmodifiable;
            this.payloads.flipUniqueValues = SynchronizedShortObjectMapTest::flipUniqueValues;
            this.payloads.asSynchronized = SynchronizedShortObjectMapTest::asSynchronized;
        }
    }
}
