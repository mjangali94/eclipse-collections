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

import java.util.Iterator;
import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.impl.factory.primitive.LongObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongObjectMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongObjectMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractImmutableLongObjectMapTestCase extends AbstractLongObjectMapTestCase {

    @Override
    protected abstract ImmutableLongObjectMap<String> classUnderTest();

    @Override
    protected <T> ImmutableLongObjectMap<T> newWithKeysValues(long key1, T value1) {
        return LongObjectMaps.immutable.with(key1, value1);
    }

    @Override
    protected <T> ImmutableLongObjectMap<T> newWithKeysValues(long key1, T value1, long key2, T value2) {
        return LongObjectMaps.immutable.withAll(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> ImmutableLongObjectMap<T> newWithKeysValues(long key1, T value1, long key2, T value2, long key3, T value3) {
        return LongObjectMaps.immutable.withAll(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> ImmutableLongObjectMap<T> getEmptyMap() {
        return LongObjectMaps.immutable.with();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableLongObjectMap<String> map = this.classUnderTest();
        Assert.assertSame(map, map.toImmutable());
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        Iterator<String> iterator = this.classUnderTest().iterator();
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void keySet() {
        super.keySet();
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            this.classUnderTest().keySet().remove(0L);
        });
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            this.classUnderTest().values().remove("zero");
        });
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(ObjectLongMaps.immutable.empty(), LongObjectMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableObjectLongEmptyMap.class, LongObjectMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ObjectLongMaps.immutable.with("2", 1L), this.newWithKeysValues(1L, "2").flipUniqueValues());
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 1L, "3", 2L).toImmutable(), this.newWithKeysValues(1L, "2", 2L, "3").flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, "1", 2L, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableLongObjectMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableLongObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableLongObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableLongObjectMapTestCase::values;
            this.payloads.select = AbstractImmutableLongObjectMapTestCase::select;
            this.payloads.selectWith = AbstractImmutableLongObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractImmutableLongObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractImmutableLongObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractImmutableLongObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractImmutableLongObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractImmutableLongObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractImmutableLongObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractImmutableLongObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractImmutableLongObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractImmutableLongObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractImmutableLongObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractImmutableLongObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractImmutableLongObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractImmutableLongObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractImmutableLongObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractImmutableLongObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractImmutableLongObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractImmutableLongObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractImmutableLongObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractImmutableLongObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractImmutableLongObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractImmutableLongObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractImmutableLongObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractImmutableLongObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractImmutableLongObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractImmutableLongObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractImmutableLongObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractImmutableLongObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractImmutableLongObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractImmutableLongObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractImmutableLongObjectMapTestCase::count;
            this.payloads.countWith = AbstractImmutableLongObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractImmutableLongObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractImmutableLongObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractImmutableLongObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractImmutableLongObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractImmutableLongObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractImmutableLongObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractImmutableLongObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractImmutableLongObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractImmutableLongObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractImmutableLongObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractImmutableLongObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractImmutableLongObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableLongObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableLongObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractImmutableLongObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractImmutableLongObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractImmutableLongObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractImmutableLongObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractImmutableLongObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractImmutableLongObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractImmutableLongObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractImmutableLongObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractImmutableLongObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractImmutableLongObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractImmutableLongObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractImmutableLongObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractImmutableLongObjectMapTestCase::toArray;
            this.payloads.min = AbstractImmutableLongObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractImmutableLongObjectMapTestCase::maxBy;
            this.payloads.max = AbstractImmutableLongObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractImmutableLongObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractImmutableLongObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractImmutableLongObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractImmutableLongObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractImmutableLongObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractImmutableLongObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractImmutableLongObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractImmutableLongObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractImmutableLongObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractImmutableLongObjectMapTestCase::keysView;
            this.payloads.reject = AbstractImmutableLongObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractImmutableLongObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractImmutableLongObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractImmutableLongObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableLongObjectMapTestCase::partitionWith;
            this.payloads.get = AbstractImmutableLongObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableLongObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractImmutableLongObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableLongObjectMapTestCase::containsValue;
            this.payloads.forEachValue = AbstractImmutableLongObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableLongObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableLongObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableLongObjectMapTestCase::injectIntoKeyValue;
            this.payloads.size = AbstractImmutableLongObjectMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableLongObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableLongObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractImmutableLongObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableLongObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractImmutableLongObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.contains = AbstractImmutableLongObjectMapTestCase::contains;
            this.payloads.containsAllIterable = AbstractImmutableLongObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractImmutableLongObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractImmutableLongObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractImmutableLongObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractImmutableLongObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractImmutableLongObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractImmutableLongObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractImmutableLongObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableLongObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableLongObjectMapTestCase::testToString;
            this.payloads.zip = AbstractImmutableLongObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableLongObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractImmutableLongObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractImmutableLongObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractImmutableLongObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractImmutableLongObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableLongObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractImmutableLongObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractImmutableLongObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableLongObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractImmutableLongObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableLongObjectMapTestCase::appendString;
            this.payloads.tap = AbstractImmutableLongObjectMapTestCase::tap;
            this.payloads.forEach = AbstractImmutableLongObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractImmutableLongObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractImmutableLongObjectMapTestCase::forEachWith;
            this.payloads.toSortedBag = AbstractImmutableLongObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractImmutableLongObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractImmutableLongObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableLongObjectMapTestCase::parallelStream;
            this.payloads.toImmutable = AbstractImmutableLongObjectMapTestCase::toImmutable;
            this.payloads.iterator = AbstractImmutableLongObjectMapTestCase::iterator;
            this.payloads.keySet = AbstractImmutableLongObjectMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableLongObjectMapTestCase::flipUniqueValues;
        }
    }
}
