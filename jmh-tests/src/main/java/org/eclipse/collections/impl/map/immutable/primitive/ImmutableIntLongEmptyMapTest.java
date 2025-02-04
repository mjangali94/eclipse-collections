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

import java.util.NoSuchElementException;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.ImmutableIntLongMap;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.factory.primitive.IntLongMaps;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntLongEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableIntLongEmptyMapTest extends AbstractImmutableIntLongMapTestCase {

    @Override
    protected ImmutableIntLongMap classUnderTest() {
        return IntLongMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableIntLongMap map1 = this.classUnderTest();
        ImmutableIntLongMap expected = this.newWithKeysValues(0, 0L);
        Assert.assertEquals(expected, map1.newWithKeyValue(0, 0L));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0, 0L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableIntLongMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32));
        Assert.assertSame(map1, map1.newWithoutKey(32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableIntLongMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.map.containsValue(0L));
        Assert.assertFalse(this.map.containsValue(31L));
        Assert.assertFalse(this.map.containsValue(32L));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.map.contains(0L));
        Assert.assertFalse(this.map.contains(31L));
        Assert.assertFalse(this.map.contains(32L));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(5L, this.map.getIfAbsent(0, 5L));
        Assert.assertEquals(15L, this.map.getIfAbsent(31, 15L));
        Assert.assertEquals(25L, this.map.getIfAbsent(32, 25L));
    }

    @Override
    @Test
    public void asLazy() {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void longIterator() {
        LongIterator iterator = this.map.longIterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(0));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(32));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0));
        Assert.assertEquals(0L, this.map.get(31));
        Assert.assertEquals(0L, this.map.get(32));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.map.containsAll(0L, 31L, 32L));
        Assert.assertFalse(this.map.containsAll(0L, 31L, 35L));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.map.containsKey(0));
        Assert.assertFalse(this.map.containsKey(31));
        Assert.assertFalse(this.map.containsKey(32));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(IntArrayList.newListWith(), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray() {
        Assert.assertEquals(this.map.toSortedArray().length, 0);
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 32L)));
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 35L)));
        Assert.assertTrue(this.map.containsAll(new LongArrayList()));
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((int value1, long value2) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((int value1, long value2) -> false));
    }

    @Override
    @Test
    public void select_value() {
        Assert.assertEquals(LongBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value() {
        Assert.assertEquals(LongBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count((long value) -> true));
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Test
    public void injectInto() {
        ImmutableIntLongEmptyMap iterable = new ImmutableIntLongEmptyMap();
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(0L), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableIntLongEmptyMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableIntLongEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntLongEmptyMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableIntLongEmptyMapTest::values;
            this.payloads.size = ImmutableIntLongEmptyMapTest::size;
            this.payloads.testHashCode = ImmutableIntLongEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableIntLongEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableIntLongEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableIntLongEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableIntLongEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableIntLongEmptyMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableIntLongEmptyMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableIntLongEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableIntLongEmptyMapTest::appendString;
            this.payloads.select = ImmutableIntLongEmptyMapTest::select;
            this.payloads.collect = ImmutableIntLongEmptyMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableIntLongEmptyMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableIntLongEmptyMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableIntLongEmptyMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableIntLongEmptyMapTest::noneSatisfy;
            this.payloads.max = ImmutableIntLongEmptyMapTest::max;
            this.payloads.min = ImmutableIntLongEmptyMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntLongEmptyMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntLongEmptyMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableIntLongEmptyMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableIntLongEmptyMapTest::maxIfEmpty;
            this.payloads.average = ImmutableIntLongEmptyMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntLongEmptyMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableIntLongEmptyMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntLongEmptyMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableIntLongEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableIntLongEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableIntLongEmptyMapTest::toSet;
            this.payloads.toBag = ImmutableIntLongEmptyMapTest::toBag;
            this.payloads.keyValuesView = ImmutableIntLongEmptyMapTest::keyValuesView;
            this.payloads.toArray = ImmutableIntLongEmptyMapTest::toArray;
            this.payloads.toImmutable = ImmutableIntLongEmptyMapTest::toImmutable;
            this.payloads.chunk = ImmutableIntLongEmptyMapTest::chunk;
            this.payloads.testEquals = ImmutableIntLongEmptyMapTest::testEquals;
            this.payloads.keySet = ImmutableIntLongEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableIntLongEmptyMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableIntLongEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableIntLongEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableIntLongEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableIntLongEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableIntLongEmptyMapTest::contains;
            this.payloads.getIfAbsent = ImmutableIntLongEmptyMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableIntLongEmptyMapTest::asLazy;
            this.payloads.longIterator = ImmutableIntLongEmptyMapTest::longIterator;
            this.payloads.getOrThrow = ImmutableIntLongEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableIntLongEmptyMapTest::get;
            this.payloads.containsAll = ImmutableIntLongEmptyMapTest::containsAll;
            this.payloads.containsKey = ImmutableIntLongEmptyMapTest::containsKey;
            this.payloads.keysView = ImmutableIntLongEmptyMapTest::keysView;
            this.payloads.toSortedArray = ImmutableIntLongEmptyMapTest::toSortedArray;
            this.payloads.notEmpty = ImmutableIntLongEmptyMapTest::notEmpty;
            this.payloads.containsAll_Iterable = ImmutableIntLongEmptyMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ImmutableIntLongEmptyMapTest::isEmpty;
            this.payloads.reject = ImmutableIntLongEmptyMapTest::reject;
            this.payloads.select_value = ImmutableIntLongEmptyMapTest::select_value;
            this.payloads.reject_value = ImmutableIntLongEmptyMapTest::reject_value;
            this.payloads.count = ImmutableIntLongEmptyMapTest::count;
            this.payloads.sum = ImmutableIntLongEmptyMapTest::sum;
            this.payloads.injectInto = ImmutableIntLongEmptyMapTest::injectInto;
        }
    }
}
