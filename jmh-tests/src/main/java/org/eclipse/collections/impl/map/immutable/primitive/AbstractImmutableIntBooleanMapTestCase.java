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

import org.eclipse.collections.api.map.primitive.IntBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntBooleanMap;
import org.eclipse.collections.impl.factory.primitive.IntBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableIntBooleanMapTestCase extends AbstractIntBooleanMapTestCase {

    @Override
    protected ImmutableIntBooleanMap classUnderTest() {
        return IntBooleanMaps.immutable.withAll(IntBooleanHashMap.newWithKeysValues(0, true, 31, false, 32, true));
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1) {
        return IntBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2) {
        return IntBooleanMaps.immutable.withAll(new IntBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3) {
        return IntBooleanMaps.immutable.withAll(new IntBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3, int key4, boolean value4) {
        return IntBooleanMaps.immutable.withAll(new IntBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntBooleanMap getEmptyMap() {
        return IntBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        IntBooleanMap map1 = this.newWithKeysValues(0, true, 31, false, 32, true);
        IntBooleanMap map2 = this.newWithKeysValues(32, true, 0, true, 31, false);
        IntBooleanMap map3 = this.newWithKeysValues(0, true, 31, false, 32, true, 2, true);
        IntBooleanMap map4 = this.newWithKeysValues(0, false, 31, false, 32, true);
        IntBooleanMap map5 = this.newWithKeysValues(0, true, 31, false, 32, false);
        IntBooleanMap map6 = this.newWithKeysValues(50, true, 60, true, 70, false);
        IntBooleanMap map7 = this.newWithKeysValues(50, true, 60, true);
        IntBooleanMap map8 = this.newWithKeysValues(0, true, 1, false);
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

        private AbstractImmutableIntBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableIntBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableIntBooleanMapTestCase> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractImmutableIntBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableIntBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableIntBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableIntBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableIntBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableIntBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableIntBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractImmutableIntBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractImmutableIntBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableIntBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableIntBooleanMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableIntBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableIntBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableIntBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableIntBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableIntBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableIntBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractImmutableIntBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableIntBooleanMapTestCase::appendString;
            this.payloads.select = AbstractImmutableIntBooleanMapTestCase::select;
            this.payloads.reject = AbstractImmutableIntBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableIntBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableIntBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableIntBooleanMapTestCase::collect;
            this.payloads.count = AbstractImmutableIntBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableIntBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableIntBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableIntBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableIntBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractImmutableIntBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractImmutableIntBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableIntBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractImmutableIntBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractImmutableIntBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableIntBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableIntBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractImmutableIntBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableIntBooleanMapTestCase::toImmutable;
            this.payloads.testEquals = AbstractImmutableIntBooleanMapTestCase::testEquals;
        }
    }
}
