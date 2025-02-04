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
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.ImmutableByteShortMap;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.factory.primitive.ByteShortMaps;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteShortEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableByteShortEmptyMapTest extends AbstractImmutableByteShortMapTestCase {

    @Override
    protected ImmutableByteShortMap classUnderTest() {
        return ByteShortMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableByteShortMap map1 = this.classUnderTest();
        ImmutableByteShortMap expected = this.newWithKeysValues((byte) 0, (short) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 0, (short) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 0, (short) 0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableByteShortMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((byte) 32));
        Assert.assertSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableByteShortMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.map.containsValue((short) 0));
        Assert.assertFalse(this.map.containsValue((short) 31));
        Assert.assertFalse(this.map.containsValue((short) 32));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.map.contains((short) 0));
        Assert.assertFalse(this.map.contains((short) 31));
        Assert.assertFalse(this.map.contains((short) 32));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(5L, this.map.getIfAbsent((byte) 0, (short) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((byte) 31, (short) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((byte) 32, (short) 25));
    }

    @Override
    @Test
    public void asLazy() {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void shortIterator() {
        ShortIterator iterator = this.map.shortIterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((byte) 0));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((byte) 32));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get((byte) 0));
        Assert.assertEquals(0L, this.map.get((byte) 31));
        Assert.assertEquals(0L, this.map.get((byte) 32));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.map.containsAll((short) 0, (short) 31, (short) 32));
        Assert.assertFalse(this.map.containsAll((short) 0, (short) 31, (short) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.map.containsKey((byte) 0));
        Assert.assertFalse(this.map.containsKey((byte) 31));
        Assert.assertFalse(this.map.containsKey((byte) 32));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(ByteArrayList.newListWith(), this.map.keysView().toSortedList());
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
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32)));
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 35)));
        Assert.assertTrue(this.map.containsAll(new ShortArrayList()));
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((byte value1, short value2) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((byte value1, short value2) -> false));
    }

    @Override
    @Test
    public void select_value() {
        Assert.assertEquals(ShortBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value() {
        Assert.assertEquals(ShortBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count((short value) -> true));
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Test
    public void injectInto() {
        ImmutableByteShortEmptyMap iterable = new ImmutableByteShortEmptyMap();
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteShortEmptyMapTest instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteShortEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteShortEmptyMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableByteShortEmptyMapTest::values;
            this.payloads.size = ImmutableByteShortEmptyMapTest::size;
            this.payloads.testHashCode = ImmutableByteShortEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableByteShortEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableByteShortEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableByteShortEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableByteShortEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableByteShortEmptyMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableByteShortEmptyMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableByteShortEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableByteShortEmptyMapTest::appendString;
            this.payloads.select = ImmutableByteShortEmptyMapTest::select;
            this.payloads.collect = ImmutableByteShortEmptyMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableByteShortEmptyMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableByteShortEmptyMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteShortEmptyMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteShortEmptyMapTest::noneSatisfy;
            this.payloads.max = ImmutableByteShortEmptyMapTest::max;
            this.payloads.min = ImmutableByteShortEmptyMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteShortEmptyMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteShortEmptyMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableByteShortEmptyMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteShortEmptyMapTest::maxIfEmpty;
            this.payloads.average = ImmutableByteShortEmptyMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteShortEmptyMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableByteShortEmptyMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteShortEmptyMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableByteShortEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableByteShortEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableByteShortEmptyMapTest::toSet;
            this.payloads.toBag = ImmutableByteShortEmptyMapTest::toBag;
            this.payloads.keyValuesView = ImmutableByteShortEmptyMapTest::keyValuesView;
            this.payloads.toArray = ImmutableByteShortEmptyMapTest::toArray;
            this.payloads.toImmutable = ImmutableByteShortEmptyMapTest::toImmutable;
            this.payloads.chunk = ImmutableByteShortEmptyMapTest::chunk;
            this.payloads.testEquals = ImmutableByteShortEmptyMapTest::testEquals;
            this.payloads.keySet = ImmutableByteShortEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableByteShortEmptyMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableByteShortEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableByteShortEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableByteShortEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableByteShortEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableByteShortEmptyMapTest::contains;
            this.payloads.getIfAbsent = ImmutableByteShortEmptyMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableByteShortEmptyMapTest::asLazy;
            this.payloads.shortIterator = ImmutableByteShortEmptyMapTest::shortIterator;
            this.payloads.getOrThrow = ImmutableByteShortEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableByteShortEmptyMapTest::get;
            this.payloads.containsAll = ImmutableByteShortEmptyMapTest::containsAll;
            this.payloads.containsKey = ImmutableByteShortEmptyMapTest::containsKey;
            this.payloads.keysView = ImmutableByteShortEmptyMapTest::keysView;
            this.payloads.toSortedArray = ImmutableByteShortEmptyMapTest::toSortedArray;
            this.payloads.notEmpty = ImmutableByteShortEmptyMapTest::notEmpty;
            this.payloads.containsAll_Iterable = ImmutableByteShortEmptyMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ImmutableByteShortEmptyMapTest::isEmpty;
            this.payloads.reject = ImmutableByteShortEmptyMapTest::reject;
            this.payloads.select_value = ImmutableByteShortEmptyMapTest::select_value;
            this.payloads.reject_value = ImmutableByteShortEmptyMapTest::reject_value;
            this.payloads.count = ImmutableByteShortEmptyMapTest::count;
            this.payloads.sum = ImmutableByteShortEmptyMapTest::sum;
            this.payloads.injectInto = ImmutableByteShortEmptyMapTest::injectInto;
        }
    }
}
