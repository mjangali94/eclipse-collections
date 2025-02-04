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
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.map.primitive.FloatCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatCharMap;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatCharSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableFloatCharSingletonMapTest extends AbstractImmutableFloatCharMapTestCase {

    @Override
    protected ImmutableFloatCharMap classUnderTest() {
        return FloatCharMaps.immutable.with(0.0f, (char) 0);
    }

    @Test
    public void newWithKeyValue() {
        ImmutableFloatCharMap map1 = this.classUnderTest();
        ImmutableFloatCharMap expected = this.newWithKeysValues(0.0f, (char) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0f, (char) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0f, (char) 0));
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableFloatCharMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0f));
        Assert.assertSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableFloatCharMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0.0f));
        Assert.assertNotSame(map2, map2.newWithoutKey(0.0f));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableFloatCharMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableFloatCharMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(FloatArrayList.newListWith(31.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue((char) 0));
        Assert.assertFalse(this.map.containsValue((char) 31));
        Assert.assertFalse(this.map.containsValue((char) 32));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((char) 0));
        Assert.assertFalse(this.map.contains((char) 31));
        Assert.assertFalse(this.map.contains((char) 32));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0f, (char) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent(31.0f, (char) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent(32.0f, (char) 25));
    }

    @Override
    @Test
    public void asLazy() {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void charIterator() {
        CharIterator iterator = this.map.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(31.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(32.0f));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0.0f));
        Assert.assertEquals(0L, this.map.get(31.0f));
        Assert.assertEquals(0L, this.map.get(32.0f));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 32));
        Assert.assertFalse(this.map.containsAll((char) 31, (char) 35));
        Assert.assertTrue(this.map.containsAll((char) 0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0.0f));
        Assert.assertFalse(this.map.containsKey(31.0f));
        Assert.assertFalse(this.map.containsKey(32.0f));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new char[] { (char) 0 }, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 32)));
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 35)));
        Assert.assertTrue(this.map.containsAll(CharArrayList.newListWith((char) 0)));
        Assert.assertTrue(this.map.containsAll(new CharArrayList()));
    }

    @Override
    @Test
    public void select() {
        FloatCharMap actual1 = this.classUnderTest().select((float key, char value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), actual1);
        FloatCharMap actual2 = this.classUnderTest().select((float key, char value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject() {
        FloatCharMap actual1 = this.classUnderTest().reject((float key, char value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), actual1);
        FloatCharMap actual2 = this.classUnderTest().reject((float key, char value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value() {
        CharIterable actual1 = this.classUnderTest().select(CharPredicates.equal((char) 1));
        Assert.assertEquals(CharBags.immutable.empty(), actual1);
        CharIterable actual2 = this.classUnderTest().select(CharPredicates.equal((char) 0));
        Assert.assertEquals(CharBags.immutable.with((char) 0), actual2);
    }

    @Override
    @Test
    public void reject_value() {
        CharIterable actual1 = this.classUnderTest().reject(CharPredicates.equal((char) 0));
        Assert.assertEquals(CharBags.immutable.empty(), actual1);
        CharIterable actual2 = this.classUnderTest().reject(CharPredicates.equal((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 0), actual2);
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(CharPredicates.equal((char) 1)));
        Assert.assertEquals(1, this.classUnderTest().count(CharPredicates.equal((char) 0)));
    }

    @Test
    public void injectInto() {
        ImmutableFloatCharSingletonMap iterable = new ImmutableFloatCharSingletonMap(1.0f, (char) 1);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 1), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableFloatCharSingletonMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableFloatCharSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatCharSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableFloatCharSingletonMapTest::values;
            this.payloads.size = ImmutableFloatCharSingletonMapTest::size;
            this.payloads.isEmpty = ImmutableFloatCharSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableFloatCharSingletonMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableFloatCharSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableFloatCharSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableFloatCharSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableFloatCharSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableFloatCharSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableFloatCharSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableFloatCharSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableFloatCharSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableFloatCharSingletonMapTest::appendString;
            this.payloads.collect = ImmutableFloatCharSingletonMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableFloatCharSingletonMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableFloatCharSingletonMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableFloatCharSingletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableFloatCharSingletonMapTest::noneSatisfy;
            this.payloads.max = ImmutableFloatCharSingletonMapTest::max;
            this.payloads.min = ImmutableFloatCharSingletonMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatCharSingletonMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatCharSingletonMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableFloatCharSingletonMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableFloatCharSingletonMapTest::maxIfEmpty;
            this.payloads.sum = ImmutableFloatCharSingletonMapTest::sum;
            this.payloads.average = ImmutableFloatCharSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatCharSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableFloatCharSingletonMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatCharSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableFloatCharSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableFloatCharSingletonMapTest::toSortedList;
            this.payloads.toSet = ImmutableFloatCharSingletonMapTest::toSet;
            this.payloads.toBag = ImmutableFloatCharSingletonMapTest::toBag;
            this.payloads.keyValuesView = ImmutableFloatCharSingletonMapTest::keyValuesView;
            this.payloads.toArray = ImmutableFloatCharSingletonMapTest::toArray;
            this.payloads.toImmutable = ImmutableFloatCharSingletonMapTest::toImmutable;
            this.payloads.chunk = ImmutableFloatCharSingletonMapTest::chunk;
            this.payloads.testEquals = ImmutableFloatCharSingletonMapTest::testEquals;
            this.payloads.keySet = ImmutableFloatCharSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableFloatCharSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableFloatCharSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableFloatCharSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableFloatCharSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableFloatCharSingletonMapTest::containsValue;
            this.payloads.contains = ImmutableFloatCharSingletonMapTest::contains;
            this.payloads.getIfAbsent = ImmutableFloatCharSingletonMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableFloatCharSingletonMapTest::asLazy;
            this.payloads.charIterator = ImmutableFloatCharSingletonMapTest::charIterator;
            this.payloads.getOrThrow = ImmutableFloatCharSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableFloatCharSingletonMapTest::get;
            this.payloads.containsAll = ImmutableFloatCharSingletonMapTest::containsAll;
            this.payloads.containsKey = ImmutableFloatCharSingletonMapTest::containsKey;
            this.payloads.keysView = ImmutableFloatCharSingletonMapTest::keysView;
            this.payloads.toSortedArray = ImmutableFloatCharSingletonMapTest::toSortedArray;
            this.payloads.containsAll_Iterable = ImmutableFloatCharSingletonMapTest::containsAll_Iterable;
            this.payloads.select = ImmutableFloatCharSingletonMapTest::select;
            this.payloads.reject = ImmutableFloatCharSingletonMapTest::reject;
            this.payloads.select_value = ImmutableFloatCharSingletonMapTest::select_value;
            this.payloads.reject_value = ImmutableFloatCharSingletonMapTest::reject_value;
            this.payloads.count = ImmutableFloatCharSingletonMapTest::count;
            this.payloads.injectInto = ImmutableFloatCharSingletonMapTest::injectInto;
        }
    }
}
