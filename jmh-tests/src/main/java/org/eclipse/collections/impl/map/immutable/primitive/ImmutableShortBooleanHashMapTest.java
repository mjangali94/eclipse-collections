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

import org.eclipse.collections.api.map.primitive.ImmutableShortBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortBooleanHashMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanHashMapTest.stg.
 */
public class ImmutableShortBooleanHashMapTest extends AbstractImmutableShortBooleanMapTestCase {

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue() {
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        ImmutableShortBooleanMap expected = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true, (short) 33, false);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, false));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, false));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        ImmutableShortBooleanMap expected = this.newWithKeysValues((short) 0, true, (short) 31, false);
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        ImmutableShortBooleanMap expected = this.newWithKeysValues((short) 31, false);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableShortBooleanHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableShortBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortBooleanHashMapTest> newWithoutAllKeys;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = ImmutableShortBooleanHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableShortBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = ImmutableShortBooleanHashMapTest::getOrThrow;
            this.payloads.containsKey = ImmutableShortBooleanHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableShortBooleanHashMapTest::containsValue;
            this.payloads.contains = ImmutableShortBooleanHashMapTest::contains;
            this.payloads.containsAll = ImmutableShortBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = ImmutableShortBooleanHashMapTest::containsAllIterable;
            this.payloads.size = ImmutableShortBooleanHashMapTest::size;
            this.payloads.isEmpty = ImmutableShortBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableShortBooleanHashMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableShortBooleanHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableShortBooleanHashMapTest::testToString;
            this.payloads.forEach = ImmutableShortBooleanHashMapTest::forEach;
            this.payloads.forEachValue = ImmutableShortBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableShortBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableShortBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = ImmutableShortBooleanHashMapTest::makeString;
            this.payloads.appendString = ImmutableShortBooleanHashMapTest::appendString;
            this.payloads.select = ImmutableShortBooleanHashMapTest::select;
            this.payloads.reject = ImmutableShortBooleanHashMapTest::reject;
            this.payloads.select_value = ImmutableShortBooleanHashMapTest::select_value;
            this.payloads.reject_value = ImmutableShortBooleanHashMapTest::reject_value;
            this.payloads.collect = ImmutableShortBooleanHashMapTest::collect;
            this.payloads.count = ImmutableShortBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = ImmutableShortBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableShortBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableShortBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableShortBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = ImmutableShortBooleanHashMapTest::toList;
            this.payloads.toSet = ImmutableShortBooleanHashMapTest::toSet;
            this.payloads.toBag = ImmutableShortBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = ImmutableShortBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = ImmutableShortBooleanHashMapTest::asLazy;
            this.payloads.keysView = ImmutableShortBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = ImmutableShortBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = ImmutableShortBooleanHashMapTest::toArray;
            this.payloads.testEquals = ImmutableShortBooleanHashMapTest::testEquals;
            this.payloads.toImmutable = ImmutableShortBooleanHashMapTest::toImmutable;
            this.payloads.newWithKeyValue = ImmutableShortBooleanHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableShortBooleanHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableShortBooleanHashMapTest::newWithoutAllKeys;
        }
    }
}
