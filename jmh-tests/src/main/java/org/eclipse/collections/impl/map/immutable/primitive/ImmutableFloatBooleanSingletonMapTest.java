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
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.map.primitive.FloatBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatBooleanMap;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.FloatBooleanMaps;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatBooleanSingletonMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanSingletonMapTest.stg.
 */
public class ImmutableFloatBooleanSingletonMapTest extends AbstractImmutableFloatBooleanMapTestCase {

    @Override
    protected ImmutableFloatBooleanMap classUnderTest() {
        return FloatBooleanMaps.immutable.with(0.0f, true);
    }

    @Test
    public void newWithKeyValue() {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        ImmutableFloatBooleanMap expected = this.newWithKeysValues(0.0f, true, 1.0f, true);
        Assert.assertEquals(expected, map1.newWithKeyValue(1.0f, true));
        Assert.assertNotSame(map1, map1.newWithKeyValue(1.0f, true));
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0f));
        Assert.assertSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableFloatBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0.0f));
        Assert.assertNotSame(map2, map2.newWithoutKey(0.0f));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableFloatBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(FloatArrayList.newListWith(31.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertFalse(this.classUnderTest().containsValue(false));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.classUnderTest().contains(true));
        Assert.assertFalse(this.classUnderTest().contains(false));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0.0f, false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(31.0f, true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(32.0f, false));
    }

    @Override
    @Test
    public void asLazy() {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.classUnderTest().asLazy().toList());
    }

    @Override
    @Test
    public void booleanIterator() {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertTrue(this.classUnderTest().getOrThrow(0.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(31.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(32.0f));
    }

    @Override
    @Test
    public void get() {
        Assert.assertTrue(this.classUnderTest().get(0.0f));
        Assert.assertFalse(this.classUnderTest().get(31.0f));
        Assert.assertFalse(this.classUnderTest().get(32.0f));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(true, false));
        Assert.assertFalse(this.classUnderTest().containsAll(false));
        Assert.assertTrue(this.classUnderTest().containsAll(true));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey(0.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(31.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(32.0f));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.classUnderTest().keysView().toSortedList());
    }

    @Override
    @Test
    public void containsAllIterable() {
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void select() {
        FloatBooleanMap actual1 = this.classUnderTest().select((float key, boolean value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(0.0f, true), actual1);
        FloatBooleanMap actual2 = this.classUnderTest().select((float key, boolean value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject() {
        FloatBooleanMap actual1 = this.classUnderTest().reject((float key, boolean value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(0.0f, true), actual1);
        FloatBooleanMap actual2 = this.classUnderTest().reject((float key, boolean value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value() {
        BooleanIterable actual1 = this.classUnderTest().select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.empty(), actual1);
        BooleanIterable actual2 = this.classUnderTest().select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true), actual2);
    }

    @Override
    @Test
    public void reject_value() {
        BooleanIterable actual1 = this.classUnderTest().reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.empty(), actual1);
        BooleanIterable actual2 = this.classUnderTest().reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true), actual2);
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(BooleanPredicates.isFalse()));
        Assert.assertEquals(1, this.classUnderTest().count(BooleanPredicates.isTrue()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableFloatBooleanSingletonMapTest instance;

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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableFloatBooleanSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatBooleanSingletonMapTest> count;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.size = ImmutableFloatBooleanSingletonMapTest::size;
            this.payloads.isEmpty = ImmutableFloatBooleanSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableFloatBooleanSingletonMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableFloatBooleanSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableFloatBooleanSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableFloatBooleanSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableFloatBooleanSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableFloatBooleanSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableFloatBooleanSingletonMapTest::forEachKeyValue;
            this.payloads.makeString = ImmutableFloatBooleanSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableFloatBooleanSingletonMapTest::appendString;
            this.payloads.collect = ImmutableFloatBooleanSingletonMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableFloatBooleanSingletonMapTest::detectIfNone_value;
            this.payloads.toList = ImmutableFloatBooleanSingletonMapTest::toList;
            this.payloads.toSet = ImmutableFloatBooleanSingletonMapTest::toSet;
            this.payloads.toBag = ImmutableFloatBooleanSingletonMapTest::toBag;
            this.payloads.keyValuesView = ImmutableFloatBooleanSingletonMapTest::keyValuesView;
            this.payloads.toArray = ImmutableFloatBooleanSingletonMapTest::toArray;
            this.payloads.toImmutable = ImmutableFloatBooleanSingletonMapTest::toImmutable;
            this.payloads.testEquals = ImmutableFloatBooleanSingletonMapTest::testEquals;
            this.payloads.newWithKeyValue = ImmutableFloatBooleanSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableFloatBooleanSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableFloatBooleanSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableFloatBooleanSingletonMapTest::containsValue;
            this.payloads.contains = ImmutableFloatBooleanSingletonMapTest::contains;
            this.payloads.getIfAbsent = ImmutableFloatBooleanSingletonMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableFloatBooleanSingletonMapTest::asLazy;
            this.payloads.booleanIterator = ImmutableFloatBooleanSingletonMapTest::booleanIterator;
            this.payloads.getOrThrow = ImmutableFloatBooleanSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableFloatBooleanSingletonMapTest::get;
            this.payloads.containsAll = ImmutableFloatBooleanSingletonMapTest::containsAll;
            this.payloads.containsKey = ImmutableFloatBooleanSingletonMapTest::containsKey;
            this.payloads.keysView = ImmutableFloatBooleanSingletonMapTest::keysView;
            this.payloads.containsAllIterable = ImmutableFloatBooleanSingletonMapTest::containsAllIterable;
            this.payloads.anySatisfy = ImmutableFloatBooleanSingletonMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableFloatBooleanSingletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableFloatBooleanSingletonMapTest::noneSatisfy;
            this.payloads.select = ImmutableFloatBooleanSingletonMapTest::select;
            this.payloads.reject = ImmutableFloatBooleanSingletonMapTest::reject;
            this.payloads.select_value = ImmutableFloatBooleanSingletonMapTest::select_value;
            this.payloads.reject_value = ImmutableFloatBooleanSingletonMapTest::reject_value;
            this.payloads.count = ImmutableFloatBooleanSingletonMapTest::count;
        }
    }
}
