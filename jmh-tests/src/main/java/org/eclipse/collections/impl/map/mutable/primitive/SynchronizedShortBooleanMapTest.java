/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortBooleanMap}.
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapTest.stg.
 */
public class SynchronizedShortBooleanMapTest extends AbstractMutableShortBooleanMapTestCase {

    @Override
    protected SynchronizedShortBooleanMap classUnderTest() {
        return new SynchronizedShortBooleanMap(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortBooleanMap getEmptyMap() {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedShortBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedShortBooleanMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

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
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
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
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortBooleanMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortBooleanMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = SynchronizedShortBooleanMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortBooleanMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedShortBooleanMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedShortBooleanMapTest::testHashCode;
            this.payloads.testToString = SynchronizedShortBooleanMapTest::testToString;
            this.payloads.forEach = SynchronizedShortBooleanMapTest::forEach;
            this.payloads.forEachValue = SynchronizedShortBooleanMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedShortBooleanMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedShortBooleanMapTest::forEachKeyValue;
            this.payloads.makeString = SynchronizedShortBooleanMapTest::makeString;
            this.payloads.appendString = SynchronizedShortBooleanMapTest::appendString;
            this.payloads.select = SynchronizedShortBooleanMapTest::select;
            this.payloads.reject = SynchronizedShortBooleanMapTest::reject;
            this.payloads.select_value = SynchronizedShortBooleanMapTest::select_value;
            this.payloads.reject_value = SynchronizedShortBooleanMapTest::reject_value;
            this.payloads.collect = SynchronizedShortBooleanMapTest::collect;
            this.payloads.count = SynchronizedShortBooleanMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedShortBooleanMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedShortBooleanMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedShortBooleanMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedShortBooleanMapTest::noneSatisfy;
            this.payloads.toList = SynchronizedShortBooleanMapTest::toList;
            this.payloads.toSet = SynchronizedShortBooleanMapTest::toSet;
            this.payloads.toBag = SynchronizedShortBooleanMapTest::toBag;
            this.payloads.booleanIterator = SynchronizedShortBooleanMapTest::booleanIterator;
            this.payloads.asLazy = SynchronizedShortBooleanMapTest::asLazy;
            this.payloads.keysView = SynchronizedShortBooleanMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedShortBooleanMapTest::keyValuesView;
            this.payloads.toArray = SynchronizedShortBooleanMapTest::toArray;
            this.payloads.toImmutable = SynchronizedShortBooleanMapTest::toImmutable;
            this.payloads.clear = SynchronizedShortBooleanMapTest::clear;
            this.payloads.removeKey = SynchronizedShortBooleanMapTest::removeKey;
            this.payloads.removeKeyIfAbsent = SynchronizedShortBooleanMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedShortBooleanMapTest::put;
            this.payloads.updateValues = SynchronizedShortBooleanMapTest::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedShortBooleanMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = SynchronizedShortBooleanMapTest::get;
            this.payloads.getIfAbsent = SynchronizedShortBooleanMapTest::getIfAbsent;
            this.payloads.getOrThrow = SynchronizedShortBooleanMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = SynchronizedShortBooleanMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedShortBooleanMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedShortBooleanMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedShortBooleanMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedShortBooleanMapTest::updateValue;
            this.payloads.containsKey = SynchronizedShortBooleanMapTest::containsKey;
            this.payloads.containsValue = SynchronizedShortBooleanMapTest::containsValue;
            this.payloads.contains = SynchronizedShortBooleanMapTest::contains;
            this.payloads.containsAll = SynchronizedShortBooleanMapTest::containsAll;
            this.payloads.containsAllIterable = SynchronizedShortBooleanMapTest::containsAllIterable;
            this.payloads.size = SynchronizedShortBooleanMapTest::size;
            this.payloads.withoutKey = SynchronizedShortBooleanMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedShortBooleanMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedShortBooleanMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedShortBooleanMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedShortBooleanMapTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = SynchronizedShortBooleanMapTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedShortBooleanMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedShortBooleanMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.asSynchronized = SynchronizedShortBooleanMapTest::asSynchronized;
        }
    }
}
