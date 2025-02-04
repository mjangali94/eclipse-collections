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
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.ImmutableShortIntMap;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortIntEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableShortIntEmptyMapTest extends AbstractImmutableShortIntMapTestCase {

    @Override
    protected ImmutableShortIntMap classUnderTest() {
        return ShortIntMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableShortIntMap map1 = this.classUnderTest();
        ImmutableShortIntMap expected = this.newWithKeysValues((short) 0, 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 0, 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 0, 0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableShortIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((short) 32));
        Assert.assertSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableShortIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.map.containsValue(0));
        Assert.assertFalse(this.map.containsValue(31));
        Assert.assertFalse(this.map.containsValue(32));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.map.contains(0));
        Assert.assertFalse(this.map.contains(31));
        Assert.assertFalse(this.map.contains(32));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(5L, this.map.getIfAbsent((short) 0, 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((short) 31, 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((short) 32, 25));
    }

    @Override
    @Test
    public void asLazy() {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void intIterator() {
        IntIterator iterator = this.map.intIterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((short) 0));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((short) 32));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get((short) 0));
        Assert.assertEquals(0L, this.map.get((short) 31));
        Assert.assertEquals(0L, this.map.get((short) 32));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.map.containsAll(0, 31, 32));
        Assert.assertFalse(this.map.containsAll(0, 31, 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertFalse(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.containsKey((short) 31));
        Assert.assertFalse(this.map.containsKey((short) 32));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(ShortArrayList.newListWith(), this.map.keysView().toSortedList());
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
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 32)));
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 35)));
        Assert.assertTrue(this.map.containsAll(new IntArrayList()));
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((short value1, int value2) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((short value1, int value2) -> false));
    }

    @Override
    @Test
    public void select_value() {
        Assert.assertEquals(IntBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value() {
        Assert.assertEquals(IntBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count((int value) -> true));
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Test
    public void injectInto() {
        ImmutableShortIntEmptyMap iterable = new ImmutableShortIntEmptyMap();
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableShortIntEmptyMapTest instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableShortIntEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortIntEmptyMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableShortIntEmptyMapTest::values;
            this.payloads.size = ImmutableShortIntEmptyMapTest::size;
            this.payloads.testHashCode = ImmutableShortIntEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableShortIntEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableShortIntEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableShortIntEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableShortIntEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableShortIntEmptyMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableShortIntEmptyMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableShortIntEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableShortIntEmptyMapTest::appendString;
            this.payloads.select = ImmutableShortIntEmptyMapTest::select;
            this.payloads.collect = ImmutableShortIntEmptyMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableShortIntEmptyMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableShortIntEmptyMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableShortIntEmptyMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableShortIntEmptyMapTest::noneSatisfy;
            this.payloads.max = ImmutableShortIntEmptyMapTest::max;
            this.payloads.min = ImmutableShortIntEmptyMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortIntEmptyMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortIntEmptyMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableShortIntEmptyMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableShortIntEmptyMapTest::maxIfEmpty;
            this.payloads.average = ImmutableShortIntEmptyMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortIntEmptyMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableShortIntEmptyMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortIntEmptyMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableShortIntEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableShortIntEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableShortIntEmptyMapTest::toSet;
            this.payloads.toBag = ImmutableShortIntEmptyMapTest::toBag;
            this.payloads.keyValuesView = ImmutableShortIntEmptyMapTest::keyValuesView;
            this.payloads.toArray = ImmutableShortIntEmptyMapTest::toArray;
            this.payloads.toImmutable = ImmutableShortIntEmptyMapTest::toImmutable;
            this.payloads.chunk = ImmutableShortIntEmptyMapTest::chunk;
            this.payloads.testEquals = ImmutableShortIntEmptyMapTest::testEquals;
            this.payloads.keySet = ImmutableShortIntEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableShortIntEmptyMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableShortIntEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableShortIntEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableShortIntEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableShortIntEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableShortIntEmptyMapTest::contains;
            this.payloads.getIfAbsent = ImmutableShortIntEmptyMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableShortIntEmptyMapTest::asLazy;
            this.payloads.intIterator = ImmutableShortIntEmptyMapTest::intIterator;
            this.payloads.getOrThrow = ImmutableShortIntEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableShortIntEmptyMapTest::get;
            this.payloads.containsAll = ImmutableShortIntEmptyMapTest::containsAll;
            this.payloads.containsKey = ImmutableShortIntEmptyMapTest::containsKey;
            this.payloads.keysView = ImmutableShortIntEmptyMapTest::keysView;
            this.payloads.toSortedArray = ImmutableShortIntEmptyMapTest::toSortedArray;
            this.payloads.notEmpty = ImmutableShortIntEmptyMapTest::notEmpty;
            this.payloads.containsAll_Iterable = ImmutableShortIntEmptyMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ImmutableShortIntEmptyMapTest::isEmpty;
            this.payloads.reject = ImmutableShortIntEmptyMapTest::reject;
            this.payloads.select_value = ImmutableShortIntEmptyMapTest::select_value;
            this.payloads.reject_value = ImmutableShortIntEmptyMapTest::reject_value;
            this.payloads.count = ImmutableShortIntEmptyMapTest::count;
            this.payloads.sum = ImmutableShortIntEmptyMapTest::sum;
            this.payloads.injectInto = ImmutableShortIntEmptyMapTest::injectInto;
        }
    }
}
