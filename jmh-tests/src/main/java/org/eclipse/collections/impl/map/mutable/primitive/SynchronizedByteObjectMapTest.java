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
 * JUnit test for {@link SynchronizedByteObjectMap}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapTest.stg.
 */
public class SynchronizedByteObjectMapTest extends AbstractMutableByteObjectMapTestCase {

    private final SynchronizedByteObjectMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedByteObjectMap<String> classUnderTest() {
        return new SynchronizedByteObjectMap<>(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"));
    }

    @Override
    protected <T> SynchronizedByteObjectMap<T> newWithKeysValues(byte key1, T value1) {
        return new SynchronizedByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2) {
        return new SynchronizedByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2, byte key3, T value3) {
        return new SynchronizedByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedByteObjectMap<T> getEmptyMap() {
        return new SynchronizedByteObjectMap<>(new ByteObjectHashMap<>());
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

        private SynchronizedByteObjectMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteObjectMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteObjectMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedByteObjectMapTest::keySet;
            this.payloads.values = SynchronizedByteObjectMapTest::values;
            this.payloads.select = SynchronizedByteObjectMapTest::select;
            this.payloads.selectWith = SynchronizedByteObjectMapTest::selectWith;
            this.payloads.selectWith_withTarget = SynchronizedByteObjectMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = SynchronizedByteObjectMapTest::selectInstancesOf;
            this.payloads.collect = SynchronizedByteObjectMapTest::collect;
            this.payloads.collectBoolean = SynchronizedByteObjectMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = SynchronizedByteObjectMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = SynchronizedByteObjectMapTest::collectByte;
            this.payloads.collectByte_withTarget = SynchronizedByteObjectMapTest::collectByte_withTarget;
            this.payloads.collectChar = SynchronizedByteObjectMapTest::collectChar;
            this.payloads.collectChar_withTarget = SynchronizedByteObjectMapTest::collectChar_withTarget;
            this.payloads.collectDouble = SynchronizedByteObjectMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = SynchronizedByteObjectMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = SynchronizedByteObjectMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = SynchronizedByteObjectMapTest::collectFloat_withTarget;
            this.payloads.collectInt = SynchronizedByteObjectMapTest::collectInt;
            this.payloads.collectInt_withTarget = SynchronizedByteObjectMapTest::collectInt_withTarget;
            this.payloads.collectLong = SynchronizedByteObjectMapTest::collectLong;
            this.payloads.collectLong_withTarget = SynchronizedByteObjectMapTest::collectLong_withTarget;
            this.payloads.collectShort = SynchronizedByteObjectMapTest::collectShort;
            this.payloads.collectShort_withTarget = SynchronizedByteObjectMapTest::collectShort_withTarget;
            this.payloads.collectWith = SynchronizedByteObjectMapTest::collectWith;
            this.payloads.collectWithTarget = SynchronizedByteObjectMapTest::collectWithTarget;
            this.payloads.collectIf = SynchronizedByteObjectMapTest::collectIf;
            this.payloads.flatCollect = SynchronizedByteObjectMapTest::flatCollect;
            this.payloads.detect = SynchronizedByteObjectMapTest::detect;
            this.payloads.detectWith = SynchronizedByteObjectMapTest::detectWith;
            this.payloads.detectOptional = SynchronizedByteObjectMapTest::detectOptional;
            this.payloads.detectWithOptional = SynchronizedByteObjectMapTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedByteObjectMapTest::detectIfNone;
            this.payloads.detectWithIfNone = SynchronizedByteObjectMapTest::detectWithIfNone;
            this.payloads.count = SynchronizedByteObjectMapTest::count;
            this.payloads.countWith = SynchronizedByteObjectMapTest::countWith;
            this.payloads.anySatisfy = SynchronizedByteObjectMapTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedByteObjectMapTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedByteObjectMapTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedByteObjectMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedByteObjectMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedByteObjectMapTest::noneSatisfyWith;
            this.payloads.injectInto = SynchronizedByteObjectMapTest::injectInto;
            this.payloads.intInjectInto = SynchronizedByteObjectMapTest::intInjectInto;
            this.payloads.longInjectInto = SynchronizedByteObjectMapTest::longInjectInto;
            this.payloads.floatInjectInto = SynchronizedByteObjectMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = SynchronizedByteObjectMapTest::doubleInjectInto;
            this.payloads.toList = SynchronizedByteObjectMapTest::toList;
            this.payloads.toSortedList = SynchronizedByteObjectMapTest::toSortedList;
            this.payloads.toSet = SynchronizedByteObjectMapTest::toSet;
            this.payloads.toSortedSet = SynchronizedByteObjectMapTest::toSortedSet;
            this.payloads.toBag = SynchronizedByteObjectMapTest::toBag;
            this.payloads.toMap = SynchronizedByteObjectMapTest::toMap;
            this.payloads.toMapTarget = SynchronizedByteObjectMapTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedByteObjectMapTest::toSortedMap;
            this.payloads.toImmutableList = SynchronizedByteObjectMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = SynchronizedByteObjectMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = SynchronizedByteObjectMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = SynchronizedByteObjectMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = SynchronizedByteObjectMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = SynchronizedByteObjectMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = SynchronizedByteObjectMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = SynchronizedByteObjectMapTest::toArray;
            this.payloads.min = SynchronizedByteObjectMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = SynchronizedByteObjectMapTest::maxBy;
            this.payloads.max = SynchronizedByteObjectMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = SynchronizedByteObjectMapTest::minBy;
            this.payloads.sumOfInt = SynchronizedByteObjectMapTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedByteObjectMapTest::sumOfLong;
            this.payloads.sumOfDouble = SynchronizedByteObjectMapTest::sumOfDouble;
            this.payloads.sumOfFloat = SynchronizedByteObjectMapTest::sumOfFloat;
            this.payloads.sumByInt = SynchronizedByteObjectMapTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedByteObjectMapTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedByteObjectMapTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedByteObjectMapTest::sumByDouble;
            this.payloads.keysView = SynchronizedByteObjectMapTest::keysView;
            this.payloads.reject = SynchronizedByteObjectMapTest::reject;
            this.payloads.rejectWith = SynchronizedByteObjectMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = SynchronizedByteObjectMapTest::rejectWith_withTarget;
            this.payloads.partition = SynchronizedByteObjectMapTest::partition;
            this.payloads.partitionWith = SynchronizedByteObjectMapTest::partitionWith;
            this.payloads.forEachValue = SynchronizedByteObjectMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedByteObjectMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedByteObjectMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedByteObjectMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = SynchronizedByteObjectMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteObjectMapTest::notEmpty;
            this.payloads.getFirst = SynchronizedByteObjectMapTest::getFirst;
            this.payloads.getLast = SynchronizedByteObjectMapTest::getLast;
            this.payloads.getOnly = SynchronizedByteObjectMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedByteObjectMapTest::containsAllIterable;
            this.payloads.containsAll = SynchronizedByteObjectMapTest::containsAll;
            this.payloads.containsAnyIterable = SynchronizedByteObjectMapTest::containsAnyIterable;
            this.payloads.containsAny = SynchronizedByteObjectMapTest::containsAny;
            this.payloads.containsNoneIterable = SynchronizedByteObjectMapTest::containsNoneIterable;
            this.payloads.containsNone = SynchronizedByteObjectMapTest::containsNone;
            this.payloads.containsAllArguments = SynchronizedByteObjectMapTest::containsAllArguments;
            this.payloads.testEquals = SynchronizedByteObjectMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedByteObjectMapTest::testHashCode;
            this.payloads.testToString = SynchronizedByteObjectMapTest::testToString;
            this.payloads.zip = SynchronizedByteObjectMapTest::zip;
            this.payloads.zipWithIndex = SynchronizedByteObjectMapTest::zipWithIndex;
            this.payloads.chunk = SynchronizedByteObjectMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = SynchronizedByteObjectMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = SynchronizedByteObjectMapTest::aggregateBy;
            this.payloads.groupBy = SynchronizedByteObjectMapTest::groupBy;
            this.payloads.groupByEach = SynchronizedByteObjectMapTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedByteObjectMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedByteObjectMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteObjectMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = SynchronizedByteObjectMapTest::makeString;
            this.payloads.appendString = SynchronizedByteObjectMapTest::appendString;
            this.payloads.tap = SynchronizedByteObjectMapTest::tap;
            this.payloads.forEach = SynchronizedByteObjectMapTest::forEach;
            this.payloads.forEachWithIndex = SynchronizedByteObjectMapTest::forEachWithIndex;
            this.payloads.forEachWith = SynchronizedByteObjectMapTest::forEachWith;
            this.payloads.toImmutable = SynchronizedByteObjectMapTest::toImmutable;
            this.payloads.toSortedBag = SynchronizedByteObjectMapTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedByteObjectMapTest::toSortedBagBy;
            this.payloads.stream = SynchronizedByteObjectMapTest::stream;
            this.payloads.parallelStream = SynchronizedByteObjectMapTest::parallelStream;
            this.payloads.clear = SynchronizedByteObjectMapTest::clear;
            this.payloads.removeKey = SynchronizedByteObjectMapTest::removeKey;
            this.payloads.remove = SynchronizedByteObjectMapTest::remove;
            this.payloads.put = SynchronizedByteObjectMapTest::put;
            this.payloads.putPair = SynchronizedByteObjectMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedByteObjectMapTest::putDuplicateWithRemovedSlot;
            this.payloads.putAll = SynchronizedByteObjectMapTest::putAll;
            this.payloads.getIfAbsentPut_Value = SynchronizedByteObjectMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = SynchronizedByteObjectMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedByteObjectMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedByteObjectMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedByteObjectMapTest::updateValue;
            this.payloads.updateValueWith = SynchronizedByteObjectMapTest::updateValueWith;
            this.payloads.freeze = SynchronizedByteObjectMapTest::freeze;
            this.payloads.withoutKey = SynchronizedByteObjectMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedByteObjectMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = SynchronizedByteObjectMapTest::withAllKeyValues;
            this.payloads.get = SynchronizedByteObjectMapTest::get;
            this.payloads.getIfAbsent = SynchronizedByteObjectMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedByteObjectMapTest::containsKey;
            this.payloads.containsValue = SynchronizedByteObjectMapTest::containsValue;
            this.payloads.size = SynchronizedByteObjectMapTest::size;
            this.payloads.contains = SynchronizedByteObjectMapTest::contains;
            this.payloads.withKeysValues = SynchronizedByteObjectMapTest::withKeysValues;
            this.payloads.iterator = SynchronizedByteObjectMapTest::iterator;
            this.payloads.asUnmodifiable = SynchronizedByteObjectMapTest::asUnmodifiable;
            this.payloads.flipUniqueValues = SynchronizedByteObjectMapTest::flipUniqueValues;
            this.payloads.asSynchronized = SynchronizedByteObjectMapTest::asSynchronized;
        }
    }
}
