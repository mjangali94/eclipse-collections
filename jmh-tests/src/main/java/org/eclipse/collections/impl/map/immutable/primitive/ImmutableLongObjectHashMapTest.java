/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableLongObjectHashMapTest extends AbstractImmutableLongObjectMapTestCase {

    @Override
    protected ImmutableLongObjectMap<String> classUnderTest() {
        return LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();
        ImmutableLongObjectMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo").withKeyValue(33L, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();
        ImmutableLongObjectMap<String> expected = this.newWithKeysValues(0L, "zero", 31L, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();
        ImmutableLongObjectMap<String> expected = this.newWithKeysValues(31L, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongObjectHashMapTest instance;

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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongObjectHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapTest> newWithoutAllKeys;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableLongObjectHashMapTest::values;
            this.payloads.select = ImmutableLongObjectHashMapTest::select;
            this.payloads.selectWith = ImmutableLongObjectHashMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableLongObjectHashMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = ImmutableLongObjectHashMapTest::selectInstancesOf;
            this.payloads.collect = ImmutableLongObjectHashMapTest::collect;
            this.payloads.collectBoolean = ImmutableLongObjectHashMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableLongObjectHashMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableLongObjectHashMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableLongObjectHashMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableLongObjectHashMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableLongObjectHashMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableLongObjectHashMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableLongObjectHashMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableLongObjectHashMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableLongObjectHashMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableLongObjectHashMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableLongObjectHashMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableLongObjectHashMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableLongObjectHashMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableLongObjectHashMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableLongObjectHashMapTest::collectShort_withTarget;
            this.payloads.collectWith = ImmutableLongObjectHashMapTest::collectWith;
            this.payloads.collectWithTarget = ImmutableLongObjectHashMapTest::collectWithTarget;
            this.payloads.collectIf = ImmutableLongObjectHashMapTest::collectIf;
            this.payloads.flatCollect = ImmutableLongObjectHashMapTest::flatCollect;
            this.payloads.detect = ImmutableLongObjectHashMapTest::detect;
            this.payloads.detectWith = ImmutableLongObjectHashMapTest::detectWith;
            this.payloads.detectOptional = ImmutableLongObjectHashMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableLongObjectHashMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableLongObjectHashMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableLongObjectHashMapTest::detectWithIfNone;
            this.payloads.count = ImmutableLongObjectHashMapTest::count;
            this.payloads.countWith = ImmutableLongObjectHashMapTest::countWith;
            this.payloads.anySatisfy = ImmutableLongObjectHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableLongObjectHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableLongObjectHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableLongObjectHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableLongObjectHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableLongObjectHashMapTest::noneSatisfyWith;
            this.payloads.injectInto = ImmutableLongObjectHashMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableLongObjectHashMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableLongObjectHashMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableLongObjectHashMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableLongObjectHashMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableLongObjectHashMapTest::toList;
            this.payloads.toSortedList = ImmutableLongObjectHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableLongObjectHashMapTest::toSet;
            this.payloads.toSortedSet = ImmutableLongObjectHashMapTest::toSortedSet;
            this.payloads.toBag = ImmutableLongObjectHashMapTest::toBag;
            this.payloads.toMap = ImmutableLongObjectHashMapTest::toMap;
            this.payloads.toMapTarget = ImmutableLongObjectHashMapTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableLongObjectHashMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableLongObjectHashMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableLongObjectHashMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableLongObjectHashMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableLongObjectHashMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableLongObjectHashMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableLongObjectHashMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableLongObjectHashMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableLongObjectHashMapTest::toArray;
            this.payloads.min = ImmutableLongObjectHashMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = ImmutableLongObjectHashMapTest::maxBy;
            this.payloads.max = ImmutableLongObjectHashMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = ImmutableLongObjectHashMapTest::minBy;
            this.payloads.sumOfInt = ImmutableLongObjectHashMapTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableLongObjectHashMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableLongObjectHashMapTest::sumOfDouble;
            this.payloads.sumOfFloat = ImmutableLongObjectHashMapTest::sumOfFloat;
            this.payloads.sumByInt = ImmutableLongObjectHashMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableLongObjectHashMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableLongObjectHashMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableLongObjectHashMapTest::sumByDouble;
            this.payloads.keysView = ImmutableLongObjectHashMapTest::keysView;
            this.payloads.reject = ImmutableLongObjectHashMapTest::reject;
            this.payloads.rejectWith = ImmutableLongObjectHashMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = ImmutableLongObjectHashMapTest::rejectWith_withTarget;
            this.payloads.partition = ImmutableLongObjectHashMapTest::partition;
            this.payloads.partitionWith = ImmutableLongObjectHashMapTest::partitionWith;
            this.payloads.get = ImmutableLongObjectHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableLongObjectHashMapTest::getIfAbsent;
            this.payloads.containsKey = ImmutableLongObjectHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableLongObjectHashMapTest::containsValue;
            this.payloads.forEachValue = ImmutableLongObjectHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableLongObjectHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableLongObjectHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableLongObjectHashMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableLongObjectHashMapTest::size;
            this.payloads.isEmpty = ImmutableLongObjectHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableLongObjectHashMapTest::notEmpty;
            this.payloads.getFirst = ImmutableLongObjectHashMapTest::getFirst;
            this.payloads.getLast = ImmutableLongObjectHashMapTest::getLast;
            this.payloads.getOnly = ImmutableLongObjectHashMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.contains = ImmutableLongObjectHashMapTest::contains;
            this.payloads.containsAllIterable = ImmutableLongObjectHashMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableLongObjectHashMapTest::containsAll;
            this.payloads.containsAnyIterable = ImmutableLongObjectHashMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableLongObjectHashMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableLongObjectHashMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableLongObjectHashMapTest::containsNone;
            this.payloads.containsAllArguments = ImmutableLongObjectHashMapTest::containsAllArguments;
            this.payloads.testEquals = ImmutableLongObjectHashMapTest::testEquals;
            this.payloads.testHashCode = ImmutableLongObjectHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableLongObjectHashMapTest::testToString;
            this.payloads.zip = ImmutableLongObjectHashMapTest::zip;
            this.payloads.zipWithIndex = ImmutableLongObjectHashMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableLongObjectHashMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableLongObjectHashMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableLongObjectHashMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableLongObjectHashMapTest::groupBy;
            this.payloads.groupByEach = ImmutableLongObjectHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableLongObjectHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableLongObjectHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableLongObjectHashMapTest::makeString;
            this.payloads.appendString = ImmutableLongObjectHashMapTest::appendString;
            this.payloads.tap = ImmutableLongObjectHashMapTest::tap;
            this.payloads.forEach = ImmutableLongObjectHashMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableLongObjectHashMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableLongObjectHashMapTest::forEachWith;
            this.payloads.toSortedBag = ImmutableLongObjectHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableLongObjectHashMapTest::toSortedBagBy;
            this.payloads.stream = ImmutableLongObjectHashMapTest::stream;
            this.payloads.parallelStream = ImmutableLongObjectHashMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableLongObjectHashMapTest::toImmutable;
            this.payloads.iterator = ImmutableLongObjectHashMapTest::iterator;
            this.payloads.keySet = ImmutableLongObjectHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableLongObjectHashMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableLongObjectHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableLongObjectHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableLongObjectHashMapTest::newWithoutAllKeys;
        }
    }
}
