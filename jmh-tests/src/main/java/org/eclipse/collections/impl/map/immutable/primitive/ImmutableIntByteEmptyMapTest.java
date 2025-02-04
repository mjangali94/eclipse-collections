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
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.map.primitive.ImmutableIntByteMap;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.factory.primitive.IntByteMaps;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntByteEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableIntByteEmptyMapTest extends AbstractImmutableIntByteMapTestCase {

    @Override
    protected ImmutableIntByteMap classUnderTest() {
        return IntByteMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableIntByteMap map1 = this.classUnderTest();
        ImmutableIntByteMap expected = this.newWithKeysValues(0, (byte) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0, (byte) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0, (byte) 0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableIntByteMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32));
        Assert.assertSame(map1, map1.newWithoutKey(32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableIntByteMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.map.containsValue((byte) 0));
        Assert.assertFalse(this.map.containsValue((byte) 31));
        Assert.assertFalse(this.map.containsValue((byte) 32));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.map.contains((byte) 0));
        Assert.assertFalse(this.map.contains((byte) 31));
        Assert.assertFalse(this.map.contains((byte) 32));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(5L, this.map.getIfAbsent(0, (byte) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent(31, (byte) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent(32, (byte) 25));
    }

    @Override
    @Test
    public void asLazy() {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void byteIterator() {
        ByteIterator iterator = this.map.byteIterator();
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
        Assert.assertFalse(this.map.containsAll((byte) 0, (byte) 31, (byte) 32));
        Assert.assertFalse(this.map.containsAll((byte) 0, (byte) 31, (byte) 35));
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
        Assert.assertFalse(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 32)));
        Assert.assertFalse(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 35)));
        Assert.assertTrue(this.map.containsAll(new ByteArrayList()));
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((int value1, byte value2) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((int value1, byte value2) -> false));
    }

    @Override
    @Test
    public void select_value() {
        Assert.assertEquals(ByteBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value() {
        Assert.assertEquals(ByteBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count((byte value) -> true));
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Test
    public void injectInto() {
        ImmutableIntByteEmptyMap iterable = new ImmutableIntByteEmptyMap();
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableIntByteEmptyMapTest instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableIntByteEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntByteEmptyMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableIntByteEmptyMapTest::values;
            this.payloads.size = ImmutableIntByteEmptyMapTest::size;
            this.payloads.testHashCode = ImmutableIntByteEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableIntByteEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableIntByteEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableIntByteEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableIntByteEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableIntByteEmptyMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableIntByteEmptyMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableIntByteEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableIntByteEmptyMapTest::appendString;
            this.payloads.select = ImmutableIntByteEmptyMapTest::select;
            this.payloads.collect = ImmutableIntByteEmptyMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableIntByteEmptyMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableIntByteEmptyMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableIntByteEmptyMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableIntByteEmptyMapTest::noneSatisfy;
            this.payloads.max = ImmutableIntByteEmptyMapTest::max;
            this.payloads.min = ImmutableIntByteEmptyMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntByteEmptyMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntByteEmptyMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableIntByteEmptyMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableIntByteEmptyMapTest::maxIfEmpty;
            this.payloads.average = ImmutableIntByteEmptyMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntByteEmptyMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableIntByteEmptyMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntByteEmptyMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableIntByteEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableIntByteEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableIntByteEmptyMapTest::toSet;
            this.payloads.toBag = ImmutableIntByteEmptyMapTest::toBag;
            this.payloads.keyValuesView = ImmutableIntByteEmptyMapTest::keyValuesView;
            this.payloads.toArray = ImmutableIntByteEmptyMapTest::toArray;
            this.payloads.toImmutable = ImmutableIntByteEmptyMapTest::toImmutable;
            this.payloads.chunk = ImmutableIntByteEmptyMapTest::chunk;
            this.payloads.testEquals = ImmutableIntByteEmptyMapTest::testEquals;
            this.payloads.keySet = ImmutableIntByteEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableIntByteEmptyMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableIntByteEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableIntByteEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableIntByteEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableIntByteEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableIntByteEmptyMapTest::contains;
            this.payloads.getIfAbsent = ImmutableIntByteEmptyMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableIntByteEmptyMapTest::asLazy;
            this.payloads.byteIterator = ImmutableIntByteEmptyMapTest::byteIterator;
            this.payloads.getOrThrow = ImmutableIntByteEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableIntByteEmptyMapTest::get;
            this.payloads.containsAll = ImmutableIntByteEmptyMapTest::containsAll;
            this.payloads.containsKey = ImmutableIntByteEmptyMapTest::containsKey;
            this.payloads.keysView = ImmutableIntByteEmptyMapTest::keysView;
            this.payloads.toSortedArray = ImmutableIntByteEmptyMapTest::toSortedArray;
            this.payloads.notEmpty = ImmutableIntByteEmptyMapTest::notEmpty;
            this.payloads.containsAll_Iterable = ImmutableIntByteEmptyMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ImmutableIntByteEmptyMapTest::isEmpty;
            this.payloads.reject = ImmutableIntByteEmptyMapTest::reject;
            this.payloads.select_value = ImmutableIntByteEmptyMapTest::select_value;
            this.payloads.reject_value = ImmutableIntByteEmptyMapTest::reject_value;
            this.payloads.count = ImmutableIntByteEmptyMapTest::count;
            this.payloads.sum = ImmutableIntByteEmptyMapTest::sum;
            this.payloads.injectInto = ImmutableIntByteEmptyMapTest::injectInto;
        }
    }
}
