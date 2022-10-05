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

import org.eclipse.collections.api.map.primitive.ShortBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortBooleanMap;
import org.eclipse.collections.impl.factory.primitive.ShortBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableShortBooleanMapTestCase extends AbstractShortBooleanMapTestCase {

    @Override
    protected ImmutableShortBooleanMap classUnderTest() {
        return ShortBooleanMaps.immutable.withAll(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true));
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1) {
        return ShortBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2) {
        return ShortBooleanMaps.immutable.withAll(new ShortBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3) {
        return ShortBooleanMaps.immutable.withAll(new ShortBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4) {
        return ShortBooleanMaps.immutable.withAll(new ShortBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortBooleanMap getEmptyMap() {
        return ShortBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortBooleanMap map1 = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true);
        ShortBooleanMap map2 = this.newWithKeysValues((short) 32, true, (short) 0, true, (short) 31, false);
        ShortBooleanMap map3 = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true, (short) 2, true);
        ShortBooleanMap map4 = this.newWithKeysValues((short) 0, false, (short) 31, false, (short) 32, true);
        ShortBooleanMap map5 = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, false);
        ShortBooleanMap map6 = this.newWithKeysValues((short) 50, true, (short) 60, true, (short) 70, false);
        ShortBooleanMap map7 = this.newWithKeysValues((short) 50, true, (short) 60, true);
        ShortBooleanMap map8 = this.newWithKeysValues((short) 0, true, (short) 1, false);
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

        private AbstractImmutableShortBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableShortBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortBooleanMapTestCase> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractImmutableShortBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableShortBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableShortBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableShortBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableShortBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableShortBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableShortBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractImmutableShortBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractImmutableShortBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableShortBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableShortBooleanMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableShortBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableShortBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableShortBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableShortBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableShortBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableShortBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractImmutableShortBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableShortBooleanMapTestCase::appendString;
            this.payloads.select = AbstractImmutableShortBooleanMapTestCase::select;
            this.payloads.reject = AbstractImmutableShortBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableShortBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableShortBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableShortBooleanMapTestCase::collect;
            this.payloads.count = AbstractImmutableShortBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableShortBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableShortBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableShortBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableShortBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractImmutableShortBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractImmutableShortBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableShortBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractImmutableShortBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractImmutableShortBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableShortBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableShortBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractImmutableShortBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableShortBooleanMapTestCase::toImmutable;
            this.payloads.testEquals = AbstractImmutableShortBooleanMapTestCase::testEquals;
        }
    }
}
