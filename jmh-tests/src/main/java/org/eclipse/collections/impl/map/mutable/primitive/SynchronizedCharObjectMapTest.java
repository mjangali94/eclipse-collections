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
 * JUnit test for {@link SynchronizedCharObjectMap}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapTest.stg.
 */
public class SynchronizedCharObjectMapTest extends AbstractMutableCharObjectMapTestCase {

    private final SynchronizedCharObjectMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedCharObjectMap<String> classUnderTest() {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo"));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> newWithKeysValues(char key1, T value1) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> getEmptyMap() {
        return new SynchronizedCharObjectMap<>(new CharObjectHashMap<>());
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

        private SynchronizedCharObjectMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
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
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
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
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
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
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
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
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedCharObjectMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharObjectMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedCharObjectMapTest::keySet;
            this.payloads.values = SynchronizedCharObjectMapTest::values;
            this.payloads.select = SynchronizedCharObjectMapTest::select;
            this.payloads.selectWith = SynchronizedCharObjectMapTest::selectWith;
            this.payloads.selectWith_withTarget = SynchronizedCharObjectMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = SynchronizedCharObjectMapTest::selectInstancesOf;
            this.payloads.collect = SynchronizedCharObjectMapTest::collect;
            this.payloads.collectBoolean = SynchronizedCharObjectMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = SynchronizedCharObjectMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = SynchronizedCharObjectMapTest::collectByte;
            this.payloads.collectByte_withTarget = SynchronizedCharObjectMapTest::collectByte_withTarget;
            this.payloads.collectChar = SynchronizedCharObjectMapTest::collectChar;
            this.payloads.collectChar_withTarget = SynchronizedCharObjectMapTest::collectChar_withTarget;
            this.payloads.collectDouble = SynchronizedCharObjectMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = SynchronizedCharObjectMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = SynchronizedCharObjectMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = SynchronizedCharObjectMapTest::collectFloat_withTarget;
            this.payloads.collectInt = SynchronizedCharObjectMapTest::collectInt;
            this.payloads.collectInt_withTarget = SynchronizedCharObjectMapTest::collectInt_withTarget;
            this.payloads.collectLong = SynchronizedCharObjectMapTest::collectLong;
            this.payloads.collectLong_withTarget = SynchronizedCharObjectMapTest::collectLong_withTarget;
            this.payloads.collectShort = SynchronizedCharObjectMapTest::collectShort;
            this.payloads.collectShort_withTarget = SynchronizedCharObjectMapTest::collectShort_withTarget;
            this.payloads.collectWith = SynchronizedCharObjectMapTest::collectWith;
            this.payloads.collectWithTarget = SynchronizedCharObjectMapTest::collectWithTarget;
            this.payloads.collectIf = SynchronizedCharObjectMapTest::collectIf;
            this.payloads.flatCollect = SynchronizedCharObjectMapTest::flatCollect;
            this.payloads.detect = SynchronizedCharObjectMapTest::detect;
            this.payloads.detectWith = SynchronizedCharObjectMapTest::detectWith;
            this.payloads.detectOptional = SynchronizedCharObjectMapTest::detectOptional;
            this.payloads.detectWithOptional = SynchronizedCharObjectMapTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedCharObjectMapTest::detectIfNone;
            this.payloads.detectWithIfNone = SynchronizedCharObjectMapTest::detectWithIfNone;
            this.payloads.count = SynchronizedCharObjectMapTest::count;
            this.payloads.countWith = SynchronizedCharObjectMapTest::countWith;
            this.payloads.anySatisfy = SynchronizedCharObjectMapTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedCharObjectMapTest::anySatisfyWith;
            this.payloads.allSatisfy = SynchronizedCharObjectMapTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedCharObjectMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedCharObjectMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedCharObjectMapTest::noneSatisfyWith;
            this.payloads.injectInto = SynchronizedCharObjectMapTest::injectInto;
            this.payloads.intInjectInto = SynchronizedCharObjectMapTest::intInjectInto;
            this.payloads.longInjectInto = SynchronizedCharObjectMapTest::longInjectInto;
            this.payloads.floatInjectInto = SynchronizedCharObjectMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = SynchronizedCharObjectMapTest::doubleInjectInto;
            this.payloads.toList = SynchronizedCharObjectMapTest::toList;
            this.payloads.toSortedList = SynchronizedCharObjectMapTest::toSortedList;
            this.payloads.toSet = SynchronizedCharObjectMapTest::toSet;
            this.payloads.toSortedSet = SynchronizedCharObjectMapTest::toSortedSet;
            this.payloads.toBag = SynchronizedCharObjectMapTest::toBag;
            this.payloads.toMap = SynchronizedCharObjectMapTest::toMap;
            this.payloads.toMapTarget = SynchronizedCharObjectMapTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedCharObjectMapTest::toSortedMap;
            this.payloads.toImmutableList = SynchronizedCharObjectMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = SynchronizedCharObjectMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = SynchronizedCharObjectMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = SynchronizedCharObjectMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = SynchronizedCharObjectMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = SynchronizedCharObjectMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = SynchronizedCharObjectMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = SynchronizedCharObjectMapTest::toArray;
            this.payloads.min = SynchronizedCharObjectMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = SynchronizedCharObjectMapTest::maxBy;
            this.payloads.max = SynchronizedCharObjectMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = SynchronizedCharObjectMapTest::minBy;
            this.payloads.sumOfInt = SynchronizedCharObjectMapTest::sumOfInt;
            this.payloads.sumOfLong = SynchronizedCharObjectMapTest::sumOfLong;
            this.payloads.sumOfDouble = SynchronizedCharObjectMapTest::sumOfDouble;
            this.payloads.sumOfFloat = SynchronizedCharObjectMapTest::sumOfFloat;
            this.payloads.sumByInt = SynchronizedCharObjectMapTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedCharObjectMapTest::sumByFloat;
            this.payloads.sumByLong = SynchronizedCharObjectMapTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedCharObjectMapTest::sumByDouble;
            this.payloads.keysView = SynchronizedCharObjectMapTest::keysView;
            this.payloads.reject = SynchronizedCharObjectMapTest::reject;
            this.payloads.rejectWith = SynchronizedCharObjectMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = SynchronizedCharObjectMapTest::rejectWith_withTarget;
            this.payloads.partition = SynchronizedCharObjectMapTest::partition;
            this.payloads.partitionWith = SynchronizedCharObjectMapTest::partitionWith;
            this.payloads.forEachValue = SynchronizedCharObjectMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedCharObjectMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedCharObjectMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedCharObjectMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = SynchronizedCharObjectMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedCharObjectMapTest::notEmpty;
            this.payloads.getFirst = SynchronizedCharObjectMapTest::getFirst;
            this.payloads.getLast = SynchronizedCharObjectMapTest::getLast;
            this.payloads.getOnly = SynchronizedCharObjectMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = SynchronizedCharObjectMapTest::containsAllIterable;
            this.payloads.containsAll = SynchronizedCharObjectMapTest::containsAll;
            this.payloads.containsAnyIterable = SynchronizedCharObjectMapTest::containsAnyIterable;
            this.payloads.containsAny = SynchronizedCharObjectMapTest::containsAny;
            this.payloads.containsNoneIterable = SynchronizedCharObjectMapTest::containsNoneIterable;
            this.payloads.containsNone = SynchronizedCharObjectMapTest::containsNone;
            this.payloads.containsAllArguments = SynchronizedCharObjectMapTest::containsAllArguments;
            this.payloads.testEquals = SynchronizedCharObjectMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedCharObjectMapTest::testHashCode;
            this.payloads.testToString = SynchronizedCharObjectMapTest::testToString;
            this.payloads.zip = SynchronizedCharObjectMapTest::zip;
            this.payloads.zipWithIndex = SynchronizedCharObjectMapTest::zipWithIndex;
            this.payloads.chunk = SynchronizedCharObjectMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = SynchronizedCharObjectMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = SynchronizedCharObjectMapTest::aggregateBy;
            this.payloads.groupBy = SynchronizedCharObjectMapTest::groupBy;
            this.payloads.groupByEach = SynchronizedCharObjectMapTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedCharObjectMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedCharObjectMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharObjectMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = SynchronizedCharObjectMapTest::makeString;
            this.payloads.appendString = SynchronizedCharObjectMapTest::appendString;
            this.payloads.tap = SynchronizedCharObjectMapTest::tap;
            this.payloads.forEach = SynchronizedCharObjectMapTest::forEach;
            this.payloads.forEachWithIndex = SynchronizedCharObjectMapTest::forEachWithIndex;
            this.payloads.forEachWith = SynchronizedCharObjectMapTest::forEachWith;
            this.payloads.toImmutable = SynchronizedCharObjectMapTest::toImmutable;
            this.payloads.toSortedBag = SynchronizedCharObjectMapTest::toSortedBag;
            this.payloads.toSortedBagBy = SynchronizedCharObjectMapTest::toSortedBagBy;
            this.payloads.stream = SynchronizedCharObjectMapTest::stream;
            this.payloads.parallelStream = SynchronizedCharObjectMapTest::parallelStream;
            this.payloads.clear = SynchronizedCharObjectMapTest::clear;
            this.payloads.removeKey = SynchronizedCharObjectMapTest::removeKey;
            this.payloads.remove = SynchronizedCharObjectMapTest::remove;
            this.payloads.put = SynchronizedCharObjectMapTest::put;
            this.payloads.putPair = SynchronizedCharObjectMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedCharObjectMapTest::putDuplicateWithRemovedSlot;
            this.payloads.putAll = SynchronizedCharObjectMapTest::putAll;
            this.payloads.getIfAbsentPut_Value = SynchronizedCharObjectMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = SynchronizedCharObjectMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedCharObjectMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedCharObjectMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedCharObjectMapTest::updateValue;
            this.payloads.updateValueWith = SynchronizedCharObjectMapTest::updateValueWith;
            this.payloads.freeze = SynchronizedCharObjectMapTest::freeze;
            this.payloads.withoutKey = SynchronizedCharObjectMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedCharObjectMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = SynchronizedCharObjectMapTest::withAllKeyValues;
            this.payloads.get = SynchronizedCharObjectMapTest::get;
            this.payloads.getIfAbsent = SynchronizedCharObjectMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedCharObjectMapTest::containsKey;
            this.payloads.containsValue = SynchronizedCharObjectMapTest::containsValue;
            this.payloads.size = SynchronizedCharObjectMapTest::size;
            this.payloads.contains = SynchronizedCharObjectMapTest::contains;
            this.payloads.withKeysValues = SynchronizedCharObjectMapTest::withKeysValues;
            this.payloads.iterator = SynchronizedCharObjectMapTest::iterator;
            this.payloads.asUnmodifiable = SynchronizedCharObjectMapTest::asUnmodifiable;
            this.payloads.flipUniqueValues = SynchronizedCharObjectMapTest::flipUniqueValues;
            this.payloads.asSynchronized = SynchronizedCharObjectMapTest::asSynchronized;
        }
    }
}
