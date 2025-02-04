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
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.impl.factory.primitive.IntObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntObjectMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntObjectMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractImmutableIntObjectMapTestCase extends AbstractIntObjectMapTestCase {

    @Override
    protected abstract ImmutableIntObjectMap<String> classUnderTest();

    @Override
    protected <T> ImmutableIntObjectMap<T> newWithKeysValues(int key1, T value1) {
        return IntObjectMaps.immutable.with(key1, value1);
    }

    @Override
    protected <T> ImmutableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2) {
        return IntObjectMaps.immutable.withAll(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> ImmutableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2, int key3, T value3) {
        return IntObjectMaps.immutable.withAll(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> ImmutableIntObjectMap<T> getEmptyMap() {
        return IntObjectMaps.immutable.with();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableIntObjectMap<String> map = this.classUnderTest();
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
            this.classUnderTest().keySet().remove(0);
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
        Assert.assertEquals(ObjectIntMaps.immutable.empty(), IntObjectMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableObjectIntEmptyMap.class, IntObjectMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(ObjectIntMaps.immutable.with("2", 1), this.newWithKeysValues(1, "2").flipUniqueValues());
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 1, "3", 2).toImmutable(), this.newWithKeysValues(1, "2", 2, "3").flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, "1", 2, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableIntObjectMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableIntObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableIntObjectMapTestCase::values;
            this.payloads.select = AbstractImmutableIntObjectMapTestCase::select;
            this.payloads.selectWith = AbstractImmutableIntObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractImmutableIntObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractImmutableIntObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractImmutableIntObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractImmutableIntObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractImmutableIntObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractImmutableIntObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractImmutableIntObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractImmutableIntObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractImmutableIntObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractImmutableIntObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractImmutableIntObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractImmutableIntObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractImmutableIntObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractImmutableIntObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractImmutableIntObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractImmutableIntObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractImmutableIntObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractImmutableIntObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractImmutableIntObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractImmutableIntObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractImmutableIntObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractImmutableIntObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractImmutableIntObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractImmutableIntObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractImmutableIntObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractImmutableIntObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractImmutableIntObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractImmutableIntObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractImmutableIntObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractImmutableIntObjectMapTestCase::count;
            this.payloads.countWith = AbstractImmutableIntObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractImmutableIntObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractImmutableIntObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractImmutableIntObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractImmutableIntObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractImmutableIntObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractImmutableIntObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractImmutableIntObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractImmutableIntObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractImmutableIntObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractImmutableIntObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractImmutableIntObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractImmutableIntObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableIntObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableIntObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractImmutableIntObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractImmutableIntObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractImmutableIntObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractImmutableIntObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractImmutableIntObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractImmutableIntObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractImmutableIntObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractImmutableIntObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractImmutableIntObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractImmutableIntObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractImmutableIntObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractImmutableIntObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractImmutableIntObjectMapTestCase::toArray;
            this.payloads.min = AbstractImmutableIntObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractImmutableIntObjectMapTestCase::maxBy;
            this.payloads.max = AbstractImmutableIntObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractImmutableIntObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractImmutableIntObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractImmutableIntObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractImmutableIntObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractImmutableIntObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractImmutableIntObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractImmutableIntObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractImmutableIntObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractImmutableIntObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractImmutableIntObjectMapTestCase::keysView;
            this.payloads.reject = AbstractImmutableIntObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractImmutableIntObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractImmutableIntObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractImmutableIntObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableIntObjectMapTestCase::partitionWith;
            this.payloads.get = AbstractImmutableIntObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableIntObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractImmutableIntObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableIntObjectMapTestCase::containsValue;
            this.payloads.forEachValue = AbstractImmutableIntObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableIntObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableIntObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableIntObjectMapTestCase::injectIntoKeyValue;
            this.payloads.size = AbstractImmutableIntObjectMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableIntObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableIntObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractImmutableIntObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableIntObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractImmutableIntObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.contains = AbstractImmutableIntObjectMapTestCase::contains;
            this.payloads.containsAllIterable = AbstractImmutableIntObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractImmutableIntObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractImmutableIntObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractImmutableIntObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractImmutableIntObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractImmutableIntObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractImmutableIntObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractImmutableIntObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableIntObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableIntObjectMapTestCase::testToString;
            this.payloads.zip = AbstractImmutableIntObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableIntObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractImmutableIntObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractImmutableIntObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractImmutableIntObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractImmutableIntObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableIntObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractImmutableIntObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractImmutableIntObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableIntObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractImmutableIntObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableIntObjectMapTestCase::appendString;
            this.payloads.tap = AbstractImmutableIntObjectMapTestCase::tap;
            this.payloads.forEach = AbstractImmutableIntObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractImmutableIntObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractImmutableIntObjectMapTestCase::forEachWith;
            this.payloads.toSortedBag = AbstractImmutableIntObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractImmutableIntObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractImmutableIntObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableIntObjectMapTestCase::parallelStream;
            this.payloads.toImmutable = AbstractImmutableIntObjectMapTestCase::toImmutable;
            this.payloads.iterator = AbstractImmutableIntObjectMapTestCase::iterator;
            this.payloads.keySet = AbstractImmutableIntObjectMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableIntObjectMapTestCase::flipUniqueValues;
        }
    }
}
