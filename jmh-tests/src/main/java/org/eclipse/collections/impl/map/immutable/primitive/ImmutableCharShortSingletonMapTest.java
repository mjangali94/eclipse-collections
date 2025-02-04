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

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.CharShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharShortMap;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.primitive.CharShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharShortSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableCharShortSingletonMapTest extends AbstractImmutableCharShortMapTestCase {

    @Override
    protected ImmutableCharShortMap classUnderTest() {
        return CharShortMaps.immutable.with((char) 0, (short) 0);
    }

    @Test
    public void newWithKeyValue() {
        ImmutableCharShortMap map1 = this.classUnderTest();
        ImmutableCharShortMap expected = this.newWithKeysValues((char) 0, (short) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 0, (short) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 0, (short) 0));
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableCharShortMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((char) 32));
        Assert.assertSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableCharShortMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((char) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((char) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableCharShortMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableCharShortMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(CharArrayList.newListWith((char) 31, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertFalse(this.map.containsValue((short) 31));
        Assert.assertFalse(this.map.containsValue((short) 32));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((short) 0));
        Assert.assertFalse(this.map.contains((short) 31));
        Assert.assertFalse(this.map.contains((short) 32));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent((char) 0, (short) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((char) 31, (short) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((char) 32, (short) 25));
    }

    @Override
    @Test
    public void asLazy() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void shortIterator() {
        ShortIterator iterator = this.map.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow((char) 0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 31));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 32));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get((char) 0));
        Assert.assertEquals(0L, this.map.get((char) 31));
        Assert.assertEquals(0L, this.map.get((char) 32));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.map.containsAll((short) 0, (short) 31, (short) 32));
        Assert.assertFalse(this.map.containsAll((short) 31, (short) 35));
        Assert.assertTrue(this.map.containsAll((short) 0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey((char) 0));
        Assert.assertFalse(this.map.containsKey((char) 31));
        Assert.assertFalse(this.map.containsKey((char) 32));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new short[] { (short) 0 }, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32)));
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 35)));
        Assert.assertTrue(this.map.containsAll(ShortArrayList.newListWith((short) 0)));
        Assert.assertTrue(this.map.containsAll(new ShortArrayList()));
    }

    @Override
    @Test
    public void select() {
        CharShortMap actual1 = this.classUnderTest().select((char key, short value) -> key == (char) 0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0), actual1);
        CharShortMap actual2 = this.classUnderTest().select((char key, short value) -> key == (char) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject() {
        CharShortMap actual1 = this.classUnderTest().reject((char key, short value) -> key == (char) 1);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0), actual1);
        CharShortMap actual2 = this.classUnderTest().reject((char key, short value) -> key == (char) 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value() {
        ShortIterable actual1 = this.classUnderTest().select(ShortPredicates.equal((short) 1));
        Assert.assertEquals(ShortBags.immutable.empty(), actual1);
        ShortIterable actual2 = this.classUnderTest().select(ShortPredicates.equal((short) 0));
        Assert.assertEquals(ShortBags.immutable.with((short) 0), actual2);
    }

    @Override
    @Test
    public void reject_value() {
        ShortIterable actual1 = this.classUnderTest().reject(ShortPredicates.equal((short) 0));
        Assert.assertEquals(ShortBags.immutable.empty(), actual1);
        ShortIterable actual2 = this.classUnderTest().reject(ShortPredicates.equal((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 0), actual2);
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(ShortPredicates.equal((short) 1)));
        Assert.assertEquals(1, this.classUnderTest().count(ShortPredicates.equal((short) 0)));
    }

    @Test
    public void injectInto() {
        ImmutableCharShortSingletonMap iterable = new ImmutableCharShortSingletonMap((char) 1, (short) 1);
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 1), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharShortSingletonMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharShortSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableCharShortSingletonMapTest::values;
            this.payloads.size = ImmutableCharShortSingletonMapTest::size;
            this.payloads.isEmpty = ImmutableCharShortSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharShortSingletonMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableCharShortSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableCharShortSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableCharShortSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableCharShortSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableCharShortSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableCharShortSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableCharShortSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableCharShortSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableCharShortSingletonMapTest::appendString;
            this.payloads.collect = ImmutableCharShortSingletonMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableCharShortSingletonMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableCharShortSingletonMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharShortSingletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharShortSingletonMapTest::noneSatisfy;
            this.payloads.max = ImmutableCharShortSingletonMapTest::max;
            this.payloads.min = ImmutableCharShortSingletonMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortSingletonMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortSingletonMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharShortSingletonMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharShortSingletonMapTest::maxIfEmpty;
            this.payloads.sum = ImmutableCharShortSingletonMapTest::sum;
            this.payloads.average = ImmutableCharShortSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableCharShortSingletonMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableCharShortSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableCharShortSingletonMapTest::toSortedList;
            this.payloads.toSet = ImmutableCharShortSingletonMapTest::toSet;
            this.payloads.toBag = ImmutableCharShortSingletonMapTest::toBag;
            this.payloads.keyValuesView = ImmutableCharShortSingletonMapTest::keyValuesView;
            this.payloads.toArray = ImmutableCharShortSingletonMapTest::toArray;
            this.payloads.toImmutable = ImmutableCharShortSingletonMapTest::toImmutable;
            this.payloads.chunk = ImmutableCharShortSingletonMapTest::chunk;
            this.payloads.testEquals = ImmutableCharShortSingletonMapTest::testEquals;
            this.payloads.keySet = ImmutableCharShortSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableCharShortSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableCharShortSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableCharShortSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableCharShortSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableCharShortSingletonMapTest::containsValue;
            this.payloads.contains = ImmutableCharShortSingletonMapTest::contains;
            this.payloads.getIfAbsent = ImmutableCharShortSingletonMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableCharShortSingletonMapTest::asLazy;
            this.payloads.shortIterator = ImmutableCharShortSingletonMapTest::shortIterator;
            this.payloads.getOrThrow = ImmutableCharShortSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableCharShortSingletonMapTest::get;
            this.payloads.containsAll = ImmutableCharShortSingletonMapTest::containsAll;
            this.payloads.containsKey = ImmutableCharShortSingletonMapTest::containsKey;
            this.payloads.keysView = ImmutableCharShortSingletonMapTest::keysView;
            this.payloads.toSortedArray = ImmutableCharShortSingletonMapTest::toSortedArray;
            this.payloads.containsAll_Iterable = ImmutableCharShortSingletonMapTest::containsAll_Iterable;
            this.payloads.select = ImmutableCharShortSingletonMapTest::select;
            this.payloads.reject = ImmutableCharShortSingletonMapTest::reject;
            this.payloads.select_value = ImmutableCharShortSingletonMapTest::select_value;
            this.payloads.reject_value = ImmutableCharShortSingletonMapTest::reject_value;
            this.payloads.count = ImmutableCharShortSingletonMapTest::count;
            this.payloads.injectInto = ImmutableCharShortSingletonMapTest::injectInto;
        }
    }
}
