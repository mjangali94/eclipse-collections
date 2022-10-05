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

import org.eclipse.collections.api.map.primitive.CharBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.impl.factory.primitive.CharBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharBooleanMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractImmutableCharBooleanMapTestCase extends AbstractCharBooleanMapTestCase {

    @Override
    protected ImmutableCharBooleanMap classUnderTest() {
        return CharBooleanMaps.immutable.withAll(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true));
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1) {
        return CharBooleanMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2) {
        return CharBooleanMaps.immutable.withAll(new CharBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3) {
        return CharBooleanMaps.immutable.withAll(new CharBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3, char key4, boolean value4) {
        return CharBooleanMaps.immutable.withAll(new CharBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharBooleanMap getEmptyMap() {
        return CharBooleanMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharBooleanMap map1 = this.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true);
        CharBooleanMap map2 = this.newWithKeysValues((char) 32, true, (char) 0, true, (char) 31, false);
        CharBooleanMap map3 = this.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true, (char) 2, true);
        CharBooleanMap map4 = this.newWithKeysValues((char) 0, false, (char) 31, false, (char) 32, true);
        CharBooleanMap map5 = this.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, false);
        CharBooleanMap map6 = this.newWithKeysValues((char) 50, true, (char) 60, true, (char) 70, false);
        CharBooleanMap map7 = this.newWithKeysValues((char) 50, true, (char) 60, true);
        CharBooleanMap map8 = this.newWithKeysValues((char) 0, true, (char) 1, false);
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

        private AbstractImmutableCharBooleanMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableCharBooleanMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharBooleanMapTestCase> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = AbstractImmutableCharBooleanMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableCharBooleanMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableCharBooleanMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableCharBooleanMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableCharBooleanMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableCharBooleanMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableCharBooleanMapTestCase::containsAll;
            this.payloads.containsAllIterable = AbstractImmutableCharBooleanMapTestCase::containsAllIterable;
            this.payloads.size = AbstractImmutableCharBooleanMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableCharBooleanMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableCharBooleanMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableCharBooleanMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableCharBooleanMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableCharBooleanMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableCharBooleanMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableCharBooleanMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableCharBooleanMapTestCase::forEachKeyValue;
            this.payloads.makeString = AbstractImmutableCharBooleanMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableCharBooleanMapTestCase::appendString;
            this.payloads.select = AbstractImmutableCharBooleanMapTestCase::select;
            this.payloads.reject = AbstractImmutableCharBooleanMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableCharBooleanMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableCharBooleanMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableCharBooleanMapTestCase::collect;
            this.payloads.count = AbstractImmutableCharBooleanMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableCharBooleanMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableCharBooleanMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableCharBooleanMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableCharBooleanMapTestCase::noneSatisfy;
            this.payloads.toList = AbstractImmutableCharBooleanMapTestCase::toList;
            this.payloads.toSet = AbstractImmutableCharBooleanMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableCharBooleanMapTestCase::toBag;
            this.payloads.booleanIterator = AbstractImmutableCharBooleanMapTestCase::booleanIterator;
            this.payloads.asLazy = AbstractImmutableCharBooleanMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableCharBooleanMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableCharBooleanMapTestCase::keyValuesView;
            this.payloads.toArray = AbstractImmutableCharBooleanMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableCharBooleanMapTestCase::toImmutable;
            this.payloads.testEquals = AbstractImmutableCharBooleanMapTestCase::testEquals;
        }
    }
}
