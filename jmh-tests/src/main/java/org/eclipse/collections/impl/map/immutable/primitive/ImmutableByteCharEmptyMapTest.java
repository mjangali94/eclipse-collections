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
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.map.primitive.ImmutableByteCharMap;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.factory.primitive.ByteCharMaps;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteCharEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableByteCharEmptyMapTest extends AbstractImmutableByteCharMapTestCase {

    @Override
    protected ImmutableByteCharMap classUnderTest() {
        return ByteCharMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableByteCharMap map1 = this.classUnderTest();
        ImmutableByteCharMap expected = this.newWithKeysValues((byte) 0, (char) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 0, (char) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 0, (char) 0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableByteCharMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((byte) 32));
        Assert.assertSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableByteCharMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertFalse(this.map.containsValue((char) 0));
        Assert.assertFalse(this.map.containsValue((char) 31));
        Assert.assertFalse(this.map.containsValue((char) 32));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.map.contains((char) 0));
        Assert.assertFalse(this.map.contains((char) 31));
        Assert.assertFalse(this.map.contains((char) 32));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(5L, this.map.getIfAbsent((byte) 0, (char) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((byte) 31, (char) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((byte) 32, (char) 25));
    }

    @Override
    @Test
    public void asLazy() {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void charIterator() {
        CharIterator iterator = this.map.charIterator();
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
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 32));
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 35));
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
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 32)));
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 35)));
        Assert.assertTrue(this.map.containsAll(new CharArrayList()));
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((byte value1, char value2) -> true));
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((byte value1, char value2) -> false));
    }

    @Override
    @Test
    public void select_value() {
        Assert.assertEquals(CharBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value() {
        Assert.assertEquals(CharBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count((char value) -> true));
    }

    @Override
    @Test
    public void sum() {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Test
    public void injectInto() {
        ImmutableByteCharEmptyMap iterable = new ImmutableByteCharEmptyMap();
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteCharEmptyMapTest instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteCharEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteCharEmptyMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableByteCharEmptyMapTest::values;
            this.payloads.size = ImmutableByteCharEmptyMapTest::size;
            this.payloads.testHashCode = ImmutableByteCharEmptyMapTest::testHashCode;
            this.payloads.testToString = ImmutableByteCharEmptyMapTest::testToString;
            this.payloads.forEach = ImmutableByteCharEmptyMapTest::forEach;
            this.payloads.forEachValue = ImmutableByteCharEmptyMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableByteCharEmptyMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableByteCharEmptyMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableByteCharEmptyMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableByteCharEmptyMapTest::makeString;
            this.payloads.appendString = ImmutableByteCharEmptyMapTest::appendString;
            this.payloads.select = ImmutableByteCharEmptyMapTest::select;
            this.payloads.collect = ImmutableByteCharEmptyMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableByteCharEmptyMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableByteCharEmptyMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteCharEmptyMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteCharEmptyMapTest::noneSatisfy;
            this.payloads.max = ImmutableByteCharEmptyMapTest::max;
            this.payloads.min = ImmutableByteCharEmptyMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteCharEmptyMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteCharEmptyMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableByteCharEmptyMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteCharEmptyMapTest::maxIfEmpty;
            this.payloads.average = ImmutableByteCharEmptyMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteCharEmptyMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableByteCharEmptyMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteCharEmptyMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableByteCharEmptyMapTest::toList;
            this.payloads.toSortedList = ImmutableByteCharEmptyMapTest::toSortedList;
            this.payloads.toSet = ImmutableByteCharEmptyMapTest::toSet;
            this.payloads.toBag = ImmutableByteCharEmptyMapTest::toBag;
            this.payloads.keyValuesView = ImmutableByteCharEmptyMapTest::keyValuesView;
            this.payloads.toArray = ImmutableByteCharEmptyMapTest::toArray;
            this.payloads.toImmutable = ImmutableByteCharEmptyMapTest::toImmutable;
            this.payloads.chunk = ImmutableByteCharEmptyMapTest::chunk;
            this.payloads.testEquals = ImmutableByteCharEmptyMapTest::testEquals;
            this.payloads.keySet = ImmutableByteCharEmptyMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableByteCharEmptyMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableByteCharEmptyMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableByteCharEmptyMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableByteCharEmptyMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableByteCharEmptyMapTest::containsValue;
            this.payloads.contains = ImmutableByteCharEmptyMapTest::contains;
            this.payloads.getIfAbsent = ImmutableByteCharEmptyMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableByteCharEmptyMapTest::asLazy;
            this.payloads.charIterator = ImmutableByteCharEmptyMapTest::charIterator;
            this.payloads.getOrThrow = ImmutableByteCharEmptyMapTest::getOrThrow;
            this.payloads.get = ImmutableByteCharEmptyMapTest::get;
            this.payloads.containsAll = ImmutableByteCharEmptyMapTest::containsAll;
            this.payloads.containsKey = ImmutableByteCharEmptyMapTest::containsKey;
            this.payloads.keysView = ImmutableByteCharEmptyMapTest::keysView;
            this.payloads.toSortedArray = ImmutableByteCharEmptyMapTest::toSortedArray;
            this.payloads.notEmpty = ImmutableByteCharEmptyMapTest::notEmpty;
            this.payloads.containsAll_Iterable = ImmutableByteCharEmptyMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ImmutableByteCharEmptyMapTest::isEmpty;
            this.payloads.reject = ImmutableByteCharEmptyMapTest::reject;
            this.payloads.select_value = ImmutableByteCharEmptyMapTest::select_value;
            this.payloads.reject_value = ImmutableByteCharEmptyMapTest::reject_value;
            this.payloads.count = ImmutableByteCharEmptyMapTest::count;
            this.payloads.sum = ImmutableByteCharEmptyMapTest::sum;
            this.payloads.injectInto = ImmutableByteCharEmptyMapTest::injectInto;
        }
    }
}
