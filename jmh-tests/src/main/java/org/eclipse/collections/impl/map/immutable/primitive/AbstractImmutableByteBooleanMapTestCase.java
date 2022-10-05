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

import org.eclipse.collections.api.map.primitive.ByteBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteBooleanMap;
import org.eclipse.collections.impl.factory.primitive.ByteBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableByteBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableByteBooleanMapTestCase extends AbstractByteBooleanMapTestCase {

    @Override
    protected ImmutableByteBooleanMap classUnderTest() {
        return ByteBooleanMaps.immutable.withAll(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true));
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1) {
        return ByteBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2) {
        return ByteBooleanMaps.immutable.withAll(new ByteBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3) {
        return ByteBooleanMaps.immutable.withAll(new ByteBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3, byte key4, boolean value4) {
        return ByteBooleanMaps.immutable.withAll(new ByteBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableByteBooleanMap getEmptyMap() {
        return ByteBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ByteBooleanMap map1 = this.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true);
        ByteBooleanMap map2 = this.newWithKeysValues((byte) 32, true, (byte) 0, true, (byte) 31, false);
        ByteBooleanMap map3 = this.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true, (byte) 2, true);
        ByteBooleanMap map4 = this.newWithKeysValues((byte) 0, false, (byte) 31, false, (byte) 32, true);
        ByteBooleanMap map5 = this.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, false);
        ByteBooleanMap map6 = this.newWithKeysValues((byte) 50, true, (byte) 60, true, (byte) 70, false);
        ByteBooleanMap map7 = this.newWithKeysValues((byte) 50, true, (byte) 60, true);
        ByteBooleanMap map8 = this.newWithKeysValues((byte) 0, true, (byte) 1, false);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedIdentity(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableByteBooleanMapTestCase instance;

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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableByteBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableByteBooleanMapTestCase> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractImmutableByteBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableByteBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableByteBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableByteBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableByteBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableByteBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableByteBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractImmutableByteBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractImmutableByteBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableByteBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableByteBooleanMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableByteBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableByteBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableByteBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableByteBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableByteBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableByteBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractImmutableByteBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableByteBooleanMapTestCase::appendString;
            this.payloads.select = AbstractImmutableByteBooleanMapTestCase::select;
            this.payloads.reject = AbstractImmutableByteBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableByteBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableByteBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableByteBooleanMapTestCase::collect;
            this.payloads.count = AbstractImmutableByteBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableByteBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableByteBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableByteBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableByteBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractImmutableByteBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractImmutableByteBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableByteBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractImmutableByteBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractImmutableByteBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableByteBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableByteBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractImmutableByteBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableByteBooleanMapTestCase::toImmutable;
            this.payloads.testEquals = AbstractImmutableByteBooleanMapTestCase::testEquals;
        }
    }
}
