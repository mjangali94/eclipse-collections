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

import org.eclipse.collections.api.map.primitive.ImmutableShortObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableShortObjectHashMapTest extends AbstractImmutableShortObjectMapTestCase {

    @Override
    protected ImmutableShortObjectMap<String> classUnderTest() {
        return ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableShortObjectMap<String> map1 = this.classUnderTest();
        ImmutableShortObjectMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo").withKeyValue((short) 33, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableShortObjectMap<String> map1 = this.classUnderTest();
        ImmutableShortObjectMap<String> expected = this.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableShortObjectMap<String> map1 = this.classUnderTest();
        ImmutableShortObjectMap<String> expected = this.newWithKeysValues((short) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableShortObjectHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableShortObjectHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortObjectHashMapTest> newWithoutAllKeys;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableShortObjectHashMapTest::values;
            this.payloads.select = ImmutableShortObjectHashMapTest::select;
            this.payloads.selectWith = ImmutableShortObjectHashMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableShortObjectHashMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = ImmutableShortObjectHashMapTest::selectInstancesOf;
            this.payloads.collect = ImmutableShortObjectHashMapTest::collect;
            this.payloads.collectBoolean = ImmutableShortObjectHashMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableShortObjectHashMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableShortObjectHashMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableShortObjectHashMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableShortObjectHashMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableShortObjectHashMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableShortObjectHashMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableShortObjectHashMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableShortObjectHashMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableShortObjectHashMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableShortObjectHashMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableShortObjectHashMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableShortObjectHashMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableShortObjectHashMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableShortObjectHashMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableShortObjectHashMapTest::collectShort_withTarget;
            this.payloads.collectWith = ImmutableShortObjectHashMapTest::collectWith;
            this.payloads.collectWithTarget = ImmutableShortObjectHashMapTest::collectWithTarget;
            this.payloads.collectIf = ImmutableShortObjectHashMapTest::collectIf;
            this.payloads.flatCollect = ImmutableShortObjectHashMapTest::flatCollect;
            this.payloads.detect = ImmutableShortObjectHashMapTest::detect;
            this.payloads.detectWith = ImmutableShortObjectHashMapTest::detectWith;
            this.payloads.detectOptional = ImmutableShortObjectHashMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableShortObjectHashMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableShortObjectHashMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableShortObjectHashMapTest::detectWithIfNone;
            this.payloads.count = ImmutableShortObjectHashMapTest::count;
            this.payloads.countWith = ImmutableShortObjectHashMapTest::countWith;
            this.payloads.anySatisfy = ImmutableShortObjectHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableShortObjectHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableShortObjectHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableShortObjectHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableShortObjectHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableShortObjectHashMapTest::noneSatisfyWith;
            this.payloads.injectInto = ImmutableShortObjectHashMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableShortObjectHashMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableShortObjectHashMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableShortObjectHashMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableShortObjectHashMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableShortObjectHashMapTest::toList;
            this.payloads.toSortedList = ImmutableShortObjectHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableShortObjectHashMapTest::toSet;
            this.payloads.toSortedSet = ImmutableShortObjectHashMapTest::toSortedSet;
            this.payloads.toBag = ImmutableShortObjectHashMapTest::toBag;
            this.payloads.toMap = ImmutableShortObjectHashMapTest::toMap;
            this.payloads.toMapTarget = ImmutableShortObjectHashMapTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableShortObjectHashMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableShortObjectHashMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableShortObjectHashMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableShortObjectHashMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableShortObjectHashMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableShortObjectHashMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableShortObjectHashMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableShortObjectHashMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableShortObjectHashMapTest::toArray;
            this.payloads.min = ImmutableShortObjectHashMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = ImmutableShortObjectHashMapTest::maxBy;
            this.payloads.max = ImmutableShortObjectHashMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = ImmutableShortObjectHashMapTest::minBy;
            this.payloads.sumOfInt = ImmutableShortObjectHashMapTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableShortObjectHashMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableShortObjectHashMapTest::sumOfDouble;
            this.payloads.sumOfFloat = ImmutableShortObjectHashMapTest::sumOfFloat;
            this.payloads.sumByInt = ImmutableShortObjectHashMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableShortObjectHashMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableShortObjectHashMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableShortObjectHashMapTest::sumByDouble;
            this.payloads.keysView = ImmutableShortObjectHashMapTest::keysView;
            this.payloads.reject = ImmutableShortObjectHashMapTest::reject;
            this.payloads.rejectWith = ImmutableShortObjectHashMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = ImmutableShortObjectHashMapTest::rejectWith_withTarget;
            this.payloads.partition = ImmutableShortObjectHashMapTest::partition;
            this.payloads.partitionWith = ImmutableShortObjectHashMapTest::partitionWith;
            this.payloads.get = ImmutableShortObjectHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableShortObjectHashMapTest::getIfAbsent;
            this.payloads.containsKey = ImmutableShortObjectHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableShortObjectHashMapTest::containsValue;
            this.payloads.forEachValue = ImmutableShortObjectHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableShortObjectHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableShortObjectHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableShortObjectHashMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableShortObjectHashMapTest::size;
            this.payloads.isEmpty = ImmutableShortObjectHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableShortObjectHashMapTest::notEmpty;
            this.payloads.getFirst = ImmutableShortObjectHashMapTest::getFirst;
            this.payloads.getLast = ImmutableShortObjectHashMapTest::getLast;
            this.payloads.getOnly = ImmutableShortObjectHashMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.contains = ImmutableShortObjectHashMapTest::contains;
            this.payloads.containsAllIterable = ImmutableShortObjectHashMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableShortObjectHashMapTest::containsAll;
            this.payloads.containsAnyIterable = ImmutableShortObjectHashMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableShortObjectHashMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableShortObjectHashMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableShortObjectHashMapTest::containsNone;
            this.payloads.containsAllArguments = ImmutableShortObjectHashMapTest::containsAllArguments;
            this.payloads.testEquals = ImmutableShortObjectHashMapTest::testEquals;
            this.payloads.testHashCode = ImmutableShortObjectHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableShortObjectHashMapTest::testToString;
            this.payloads.zip = ImmutableShortObjectHashMapTest::zip;
            this.payloads.zipWithIndex = ImmutableShortObjectHashMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableShortObjectHashMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableShortObjectHashMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableShortObjectHashMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableShortObjectHashMapTest::groupBy;
            this.payloads.groupByEach = ImmutableShortObjectHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableShortObjectHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableShortObjectHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortObjectHashMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableShortObjectHashMapTest::makeString;
            this.payloads.appendString = ImmutableShortObjectHashMapTest::appendString;
            this.payloads.tap = ImmutableShortObjectHashMapTest::tap;
            this.payloads.forEach = ImmutableShortObjectHashMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableShortObjectHashMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableShortObjectHashMapTest::forEachWith;
            this.payloads.toSortedBag = ImmutableShortObjectHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableShortObjectHashMapTest::toSortedBagBy;
            this.payloads.stream = ImmutableShortObjectHashMapTest::stream;
            this.payloads.parallelStream = ImmutableShortObjectHashMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableShortObjectHashMapTest::toImmutable;
            this.payloads.iterator = ImmutableShortObjectHashMapTest::iterator;
            this.payloads.keySet = ImmutableShortObjectHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableShortObjectHashMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableShortObjectHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableShortObjectHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableShortObjectHashMapTest::newWithoutAllKeys;
        }
    }
}
