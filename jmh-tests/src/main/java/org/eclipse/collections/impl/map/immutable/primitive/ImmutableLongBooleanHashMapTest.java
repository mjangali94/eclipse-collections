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

import org.eclipse.collections.api.map.primitive.ImmutableLongBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongBooleanHashMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanHashMapTest.stg.
 */
public class ImmutableLongBooleanHashMapTest extends AbstractImmutableLongBooleanMapTestCase {

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue() {
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        ImmutableLongBooleanMap expected = this.newWithKeysValues(0L, true, 31L, false, 32L, true, 33L, false);
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, false));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, false));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        ImmutableLongBooleanMap expected = this.newWithKeysValues(0L, true, 31L, false);
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        ImmutableLongBooleanMap expected = this.newWithKeysValues(31L, false);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongBooleanHashMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongBooleanHashMapTest> newWithoutAllKeys;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = ImmutableLongBooleanHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableLongBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = ImmutableLongBooleanHashMapTest::getOrThrow;
            this.payloads.containsKey = ImmutableLongBooleanHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableLongBooleanHashMapTest::containsValue;
            this.payloads.contains = ImmutableLongBooleanHashMapTest::contains;
            this.payloads.containsAll = ImmutableLongBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = ImmutableLongBooleanHashMapTest::containsAllIterable;
            this.payloads.size = ImmutableLongBooleanHashMapTest::size;
            this.payloads.isEmpty = ImmutableLongBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableLongBooleanHashMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableLongBooleanHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableLongBooleanHashMapTest::testToString;
            this.payloads.forEach = ImmutableLongBooleanHashMapTest::forEach;
            this.payloads.forEachValue = ImmutableLongBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableLongBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableLongBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = ImmutableLongBooleanHashMapTest::makeString;
            this.payloads.appendString = ImmutableLongBooleanHashMapTest::appendString;
            this.payloads.select = ImmutableLongBooleanHashMapTest::select;
            this.payloads.reject = ImmutableLongBooleanHashMapTest::reject;
            this.payloads.select_value = ImmutableLongBooleanHashMapTest::select_value;
            this.payloads.reject_value = ImmutableLongBooleanHashMapTest::reject_value;
            this.payloads.collect = ImmutableLongBooleanHashMapTest::collect;
            this.payloads.count = ImmutableLongBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = ImmutableLongBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableLongBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableLongBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableLongBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = ImmutableLongBooleanHashMapTest::toList;
            this.payloads.toSet = ImmutableLongBooleanHashMapTest::toSet;
            this.payloads.toBag = ImmutableLongBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = ImmutableLongBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = ImmutableLongBooleanHashMapTest::asLazy;
            this.payloads.keysView = ImmutableLongBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = ImmutableLongBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = ImmutableLongBooleanHashMapTest::toArray;
            this.payloads.testEquals = ImmutableLongBooleanHashMapTest::testEquals;
            this.payloads.toImmutable = ImmutableLongBooleanHashMapTest::toImmutable;
            this.payloads.newWithKeyValue = ImmutableLongBooleanHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableLongBooleanHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableLongBooleanHashMapTest::newWithoutAllKeys;
        }
    }
}
