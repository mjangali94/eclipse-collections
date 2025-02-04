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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableDoubleObjectHashMapTest extends AbstractImmutableDoubleObjectMapTestCase {

    @Override
    protected ImmutableDoubleObjectMap<String> classUnderTest() {
        return DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableDoubleObjectMap<String> map1 = this.classUnderTest();
        ImmutableDoubleObjectMap<String> expected = DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo").withKeyValue(33.0, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableDoubleObjectMap<String> map1 = this.classUnderTest();
        ImmutableDoubleObjectMap<String> expected = this.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableDoubleObjectMap<String> map1 = this.classUnderTest();
        ImmutableDoubleObjectMap<String> expected = this.newWithKeysValues(31.0, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubleObjectHashMapTest instance;

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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubleObjectHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleObjectHashMapTest> newWithoutAllKeys;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableDoubleObjectHashMapTest::values;
            this.payloads.select = ImmutableDoubleObjectHashMapTest::select;
            this.payloads.selectWith = ImmutableDoubleObjectHashMapTest::selectWith;
            this.payloads.selectWith_withTarget = ImmutableDoubleObjectHashMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = ImmutableDoubleObjectHashMapTest::selectInstancesOf;
            this.payloads.collect = ImmutableDoubleObjectHashMapTest::collect;
            this.payloads.collectBoolean = ImmutableDoubleObjectHashMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ImmutableDoubleObjectHashMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ImmutableDoubleObjectHashMapTest::collectByte;
            this.payloads.collectByte_withTarget = ImmutableDoubleObjectHashMapTest::collectByte_withTarget;
            this.payloads.collectChar = ImmutableDoubleObjectHashMapTest::collectChar;
            this.payloads.collectChar_withTarget = ImmutableDoubleObjectHashMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ImmutableDoubleObjectHashMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ImmutableDoubleObjectHashMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ImmutableDoubleObjectHashMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ImmutableDoubleObjectHashMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ImmutableDoubleObjectHashMapTest::collectInt;
            this.payloads.collectInt_withTarget = ImmutableDoubleObjectHashMapTest::collectInt_withTarget;
            this.payloads.collectLong = ImmutableDoubleObjectHashMapTest::collectLong;
            this.payloads.collectLong_withTarget = ImmutableDoubleObjectHashMapTest::collectLong_withTarget;
            this.payloads.collectShort = ImmutableDoubleObjectHashMapTest::collectShort;
            this.payloads.collectShort_withTarget = ImmutableDoubleObjectHashMapTest::collectShort_withTarget;
            this.payloads.collectWith = ImmutableDoubleObjectHashMapTest::collectWith;
            this.payloads.collectWithTarget = ImmutableDoubleObjectHashMapTest::collectWithTarget;
            this.payloads.collectIf = ImmutableDoubleObjectHashMapTest::collectIf;
            this.payloads.flatCollect = ImmutableDoubleObjectHashMapTest::flatCollect;
            this.payloads.detect = ImmutableDoubleObjectHashMapTest::detect;
            this.payloads.detectWith = ImmutableDoubleObjectHashMapTest::detectWith;
            this.payloads.detectOptional = ImmutableDoubleObjectHashMapTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableDoubleObjectHashMapTest::detectWithOptional;
            this.payloads.detectIfNone = ImmutableDoubleObjectHashMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ImmutableDoubleObjectHashMapTest::detectWithIfNone;
            this.payloads.count = ImmutableDoubleObjectHashMapTest::count;
            this.payloads.countWith = ImmutableDoubleObjectHashMapTest::countWith;
            this.payloads.anySatisfy = ImmutableDoubleObjectHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableDoubleObjectHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableDoubleObjectHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableDoubleObjectHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableDoubleObjectHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableDoubleObjectHashMapTest::noneSatisfyWith;
            this.payloads.injectInto = ImmutableDoubleObjectHashMapTest::injectInto;
            this.payloads.intInjectInto = ImmutableDoubleObjectHashMapTest::intInjectInto;
            this.payloads.longInjectInto = ImmutableDoubleObjectHashMapTest::longInjectInto;
            this.payloads.floatInjectInto = ImmutableDoubleObjectHashMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ImmutableDoubleObjectHashMapTest::doubleInjectInto;
            this.payloads.toList = ImmutableDoubleObjectHashMapTest::toList;
            this.payloads.toSortedList = ImmutableDoubleObjectHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableDoubleObjectHashMapTest::toSet;
            this.payloads.toSortedSet = ImmutableDoubleObjectHashMapTest::toSortedSet;
            this.payloads.toBag = ImmutableDoubleObjectHashMapTest::toBag;
            this.payloads.toMap = ImmutableDoubleObjectHashMapTest::toMap;
            this.payloads.toMapTarget = ImmutableDoubleObjectHashMapTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableDoubleObjectHashMapTest::toSortedMap;
            this.payloads.toImmutableList = ImmutableDoubleObjectHashMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ImmutableDoubleObjectHashMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ImmutableDoubleObjectHashMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ImmutableDoubleObjectHashMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ImmutableDoubleObjectHashMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ImmutableDoubleObjectHashMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ImmutableDoubleObjectHashMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ImmutableDoubleObjectHashMapTest::toArray;
            this.payloads.min = ImmutableDoubleObjectHashMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = ImmutableDoubleObjectHashMapTest::maxBy;
            this.payloads.max = ImmutableDoubleObjectHashMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = ImmutableDoubleObjectHashMapTest::minBy;
            this.payloads.sumOfInt = ImmutableDoubleObjectHashMapTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableDoubleObjectHashMapTest::sumOfLong;
            this.payloads.sumOfDouble = ImmutableDoubleObjectHashMapTest::sumOfDouble;
            this.payloads.sumOfFloat = ImmutableDoubleObjectHashMapTest::sumOfFloat;
            this.payloads.sumByInt = ImmutableDoubleObjectHashMapTest::sumByInt;
            this.payloads.sumByFloat = ImmutableDoubleObjectHashMapTest::sumByFloat;
            this.payloads.sumByLong = ImmutableDoubleObjectHashMapTest::sumByLong;
            this.payloads.sumByDouble = ImmutableDoubleObjectHashMapTest::sumByDouble;
            this.payloads.keysView = ImmutableDoubleObjectHashMapTest::keysView;
            this.payloads.reject = ImmutableDoubleObjectHashMapTest::reject;
            this.payloads.rejectWith = ImmutableDoubleObjectHashMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = ImmutableDoubleObjectHashMapTest::rejectWith_withTarget;
            this.payloads.partition = ImmutableDoubleObjectHashMapTest::partition;
            this.payloads.partitionWith = ImmutableDoubleObjectHashMapTest::partitionWith;
            this.payloads.get = ImmutableDoubleObjectHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableDoubleObjectHashMapTest::getIfAbsent;
            this.payloads.containsKey = ImmutableDoubleObjectHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableDoubleObjectHashMapTest::containsValue;
            this.payloads.forEachValue = ImmutableDoubleObjectHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableDoubleObjectHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableDoubleObjectHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableDoubleObjectHashMapTest::injectIntoKeyValue;
            this.payloads.size = ImmutableDoubleObjectHashMapTest::size;
            this.payloads.isEmpty = ImmutableDoubleObjectHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableDoubleObjectHashMapTest::notEmpty;
            this.payloads.getFirst = ImmutableDoubleObjectHashMapTest::getFirst;
            this.payloads.getLast = ImmutableDoubleObjectHashMapTest::getLast;
            this.payloads.getOnly = ImmutableDoubleObjectHashMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.contains = ImmutableDoubleObjectHashMapTest::contains;
            this.payloads.containsAllIterable = ImmutableDoubleObjectHashMapTest::containsAllIterable;
            this.payloads.containsAll = ImmutableDoubleObjectHashMapTest::containsAll;
            this.payloads.containsAnyIterable = ImmutableDoubleObjectHashMapTest::containsAnyIterable;
            this.payloads.containsAny = ImmutableDoubleObjectHashMapTest::containsAny;
            this.payloads.containsNoneIterable = ImmutableDoubleObjectHashMapTest::containsNoneIterable;
            this.payloads.containsNone = ImmutableDoubleObjectHashMapTest::containsNone;
            this.payloads.containsAllArguments = ImmutableDoubleObjectHashMapTest::containsAllArguments;
            this.payloads.testEquals = ImmutableDoubleObjectHashMapTest::testEquals;
            this.payloads.testHashCode = ImmutableDoubleObjectHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableDoubleObjectHashMapTest::testToString;
            this.payloads.zip = ImmutableDoubleObjectHashMapTest::zip;
            this.payloads.zipWithIndex = ImmutableDoubleObjectHashMapTest::zipWithIndex;
            this.payloads.chunk = ImmutableDoubleObjectHashMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ImmutableDoubleObjectHashMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ImmutableDoubleObjectHashMapTest::aggregateBy;
            this.payloads.groupBy = ImmutableDoubleObjectHashMapTest::groupBy;
            this.payloads.groupByEach = ImmutableDoubleObjectHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableDoubleObjectHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableDoubleObjectHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleObjectHashMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ImmutableDoubleObjectHashMapTest::makeString;
            this.payloads.appendString = ImmutableDoubleObjectHashMapTest::appendString;
            this.payloads.tap = ImmutableDoubleObjectHashMapTest::tap;
            this.payloads.forEach = ImmutableDoubleObjectHashMapTest::forEach;
            this.payloads.forEachWithIndex = ImmutableDoubleObjectHashMapTest::forEachWithIndex;
            this.payloads.forEachWith = ImmutableDoubleObjectHashMapTest::forEachWith;
            this.payloads.toSortedBag = ImmutableDoubleObjectHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableDoubleObjectHashMapTest::toSortedBagBy;
            this.payloads.stream = ImmutableDoubleObjectHashMapTest::stream;
            this.payloads.parallelStream = ImmutableDoubleObjectHashMapTest::parallelStream;
            this.payloads.toImmutable = ImmutableDoubleObjectHashMapTest::toImmutable;
            this.payloads.iterator = ImmutableDoubleObjectHashMapTest::iterator;
            this.payloads.keySet = ImmutableDoubleObjectHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableDoubleObjectHashMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableDoubleObjectHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableDoubleObjectHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableDoubleObjectHashMapTest::newWithoutAllKeys;
        }
    }
}
