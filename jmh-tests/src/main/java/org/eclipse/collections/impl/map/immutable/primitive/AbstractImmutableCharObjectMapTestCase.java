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
import org.eclipse.collections.api.map.primitive.ImmutableCharObjectMap;
import org.eclipse.collections.impl.factory.primitive.CharObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharObjectMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharObjectMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractImmutableCharObjectMapTestCase extends AbstractCharObjectMapTestCase {

    @Override
    protected abstract ImmutableCharObjectMap<String> classUnderTest();

    @Override
    protected <T> ImmutableCharObjectMap<T> newWithKeysValues(char key1, T value1) {
        return CharObjectMaps.immutable.with(key1, value1);
    }

    @Override
    protected <T> ImmutableCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2) {
        return CharObjectMaps.immutable.withAll(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> ImmutableCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3) {
        return CharObjectMaps.immutable.withAll(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> ImmutableCharObjectMap<T> getEmptyMap() {
        return CharObjectMaps.immutable.with();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableCharObjectMap<String> map = this.classUnderTest();
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
            this.classUnderTest().keySet().remove((char) 0);
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
        Assert.assertEquals(ObjectCharMaps.immutable.empty(), CharObjectMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableObjectCharEmptyMap.class, CharObjectMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ObjectCharMaps.immutable.with("2", (char) 1), this.newWithKeysValues((char) 1, "2").flipUniqueValues());
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 1, "3", (char) 2).toImmutable(), this.newWithKeysValues((char) 1, "2", (char) 2, "3").flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, "1", (char) 2, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableCharObjectMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableCharObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableCharObjectMapTestCase::values;
            this.payloads.select = AbstractImmutableCharObjectMapTestCase::select;
            this.payloads.selectWith = AbstractImmutableCharObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractImmutableCharObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractImmutableCharObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractImmutableCharObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractImmutableCharObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractImmutableCharObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractImmutableCharObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractImmutableCharObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractImmutableCharObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractImmutableCharObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractImmutableCharObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractImmutableCharObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractImmutableCharObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractImmutableCharObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractImmutableCharObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractImmutableCharObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractImmutableCharObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractImmutableCharObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractImmutableCharObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractImmutableCharObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractImmutableCharObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractImmutableCharObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractImmutableCharObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractImmutableCharObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractImmutableCharObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractImmutableCharObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractImmutableCharObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractImmutableCharObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractImmutableCharObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractImmutableCharObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractImmutableCharObjectMapTestCase::count;
            this.payloads.countWith = AbstractImmutableCharObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractImmutableCharObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractImmutableCharObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractImmutableCharObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractImmutableCharObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractImmutableCharObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractImmutableCharObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractImmutableCharObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractImmutableCharObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractImmutableCharObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractImmutableCharObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractImmutableCharObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractImmutableCharObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableCharObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableCharObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractImmutableCharObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractImmutableCharObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractImmutableCharObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractImmutableCharObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractImmutableCharObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractImmutableCharObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractImmutableCharObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractImmutableCharObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractImmutableCharObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractImmutableCharObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractImmutableCharObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractImmutableCharObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractImmutableCharObjectMapTestCase::toArray;
            this.payloads.min = AbstractImmutableCharObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractImmutableCharObjectMapTestCase::maxBy;
            this.payloads.max = AbstractImmutableCharObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractImmutableCharObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractImmutableCharObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractImmutableCharObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractImmutableCharObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractImmutableCharObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractImmutableCharObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractImmutableCharObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractImmutableCharObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractImmutableCharObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractImmutableCharObjectMapTestCase::keysView;
            this.payloads.reject = AbstractImmutableCharObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractImmutableCharObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractImmutableCharObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractImmutableCharObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableCharObjectMapTestCase::partitionWith;
            this.payloads.get = AbstractImmutableCharObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableCharObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractImmutableCharObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableCharObjectMapTestCase::containsValue;
            this.payloads.forEachValue = AbstractImmutableCharObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableCharObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableCharObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableCharObjectMapTestCase::injectIntoKeyValue;
            this.payloads.size = AbstractImmutableCharObjectMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableCharObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableCharObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractImmutableCharObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableCharObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractImmutableCharObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.contains = AbstractImmutableCharObjectMapTestCase::contains;
            this.payloads.containsAllIterable = AbstractImmutableCharObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractImmutableCharObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractImmutableCharObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractImmutableCharObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractImmutableCharObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractImmutableCharObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractImmutableCharObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractImmutableCharObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableCharObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableCharObjectMapTestCase::testToString;
            this.payloads.zip = AbstractImmutableCharObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableCharObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractImmutableCharObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractImmutableCharObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractImmutableCharObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractImmutableCharObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableCharObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractImmutableCharObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractImmutableCharObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractImmutableCharObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableCharObjectMapTestCase::appendString;
            this.payloads.tap = AbstractImmutableCharObjectMapTestCase::tap;
            this.payloads.forEach = AbstractImmutableCharObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractImmutableCharObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractImmutableCharObjectMapTestCase::forEachWith;
            this.payloads.toSortedBag = AbstractImmutableCharObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractImmutableCharObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractImmutableCharObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableCharObjectMapTestCase::parallelStream;
            this.payloads.toImmutable = AbstractImmutableCharObjectMapTestCase::toImmutable;
            this.payloads.iterator = AbstractImmutableCharObjectMapTestCase::iterator;
            this.payloads.keySet = AbstractImmutableCharObjectMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableCharObjectMapTestCase::flipUniqueValues;
        }
    }
}
