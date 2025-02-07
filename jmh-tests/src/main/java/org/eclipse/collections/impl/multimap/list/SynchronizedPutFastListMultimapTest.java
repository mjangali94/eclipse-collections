/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.list;

import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.list.mutable.FastList;

/**
 * Test of {@link SynchronizedPutFastListMultimap}.
 */
public class SynchronizedPutFastListMultimapTest extends AbstractMutableListMultimapTestCase {

    @Override
    public <K, V> SynchronizedPutFastListMultimap<K, V> newMultimap() {
        return SynchronizedPutFastListMultimap.newMultimap();
    }

    @Override
    public <K, V> SynchronizedPutFastListMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        SynchronizedPutFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutFastListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        SynchronizedPutFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutFastListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        SynchronizedPutFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutFastListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        SynchronizedPutFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    public final <K, V> SynchronizedPutFastListMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return SynchronizedPutFastListMultimap.newMultimap(pairs);
    }

    @Override
    public <K, V> SynchronizedPutFastListMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return SynchronizedPutFastListMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> FastList<V> createCollection(V... args) {
        return FastList.newListWith(args);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SynchronizedPutFastListMultimapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWithWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWithWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewMultimapWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewMultimapWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMultimapFromPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMultimapFromPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMultiValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMultiValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_multiValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.multiValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysWithMultiValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysWithMultiValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuePairsView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuePairsView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyBag);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAndGrowMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAndGrowMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAndGrowMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAndGrowMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyMultiValuesNullValueHandling() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyMultiValuesNullValueHandling);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllFromIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllFromIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_createCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_createCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceValues_absent_key() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceValues_absent_key);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectKeysMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectKeysMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectKeysMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectKeysMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeyMultiValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeyMultiValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedPutFastListMultimapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> forEachKeyMutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutFastListMultimapTest> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = SynchronizedPutFastListMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = SynchronizedPutFastListMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = SynchronizedPutFastListMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = SynchronizedPutFastListMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = SynchronizedPutFastListMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = SynchronizedPutFastListMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = SynchronizedPutFastListMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = SynchronizedPutFastListMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = SynchronizedPutFastListMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = SynchronizedPutFastListMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = SynchronizedPutFastListMultimapTest::forEachValue;
            this.payloads.valuesView = SynchronizedPutFastListMultimapTest::valuesView;
            this.payloads.multiValuesView = SynchronizedPutFastListMultimapTest::multiValuesView;
            this.payloads.notEmpty = SynchronizedPutFastListMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = SynchronizedPutFastListMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = SynchronizedPutFastListMultimapTest::keyValuePairsView;
            this.payloads.keyBag = SynchronizedPutFastListMultimapTest::keyBag;
            this.payloads.testEquals = SynchronizedPutFastListMultimapTest::testEquals;
            this.payloads.testHashCode = SynchronizedPutFastListMultimapTest::testHashCode;
            this.payloads.serialization = SynchronizedPutFastListMultimapTest::serialization;
            this.payloads.newEmpty = SynchronizedPutFastListMultimapTest::newEmpty;
            this.payloads.keysView = SynchronizedPutFastListMultimapTest::keysView;
            this.payloads.keySet = SynchronizedPutFastListMultimapTest::keySet;
            this.payloads.sizeDistinct = SynchronizedPutFastListMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = SynchronizedPutFastListMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = SynchronizedPutFastListMultimapTest::addAndGrowMultimap;
            this.payloads.clear = SynchronizedPutFastListMultimapTest::clear;
            this.payloads.removeObject = SynchronizedPutFastListMultimapTest::removeObject;
            this.payloads.forEachKey = SynchronizedPutFastListMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = SynchronizedPutFastListMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedPutFastListMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = SynchronizedPutFastListMultimapTest::putAll;
            this.payloads.putAllPairs = SynchronizedPutFastListMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = SynchronizedPutFastListMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = SynchronizedPutFastListMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = SynchronizedPutFastListMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = SynchronizedPutFastListMultimapTest::removeKey;
            this.payloads.containsValue = SynchronizedPutFastListMultimapTest::containsValue;
            this.payloads.put_createCollection = SynchronizedPutFastListMultimapTest::put_createCollection;
            this.payloads.remove = SynchronizedPutFastListMultimapTest::remove;
            this.payloads.replaceValues = SynchronizedPutFastListMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = SynchronizedPutFastListMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = SynchronizedPutFastListMultimapTest::toMap;
            this.payloads.toImmutable = SynchronizedPutFastListMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = SynchronizedPutFastListMultimapTest::toMapWithTarget;
            this.payloads.toMutable = SynchronizedPutFastListMultimapTest::toMutable;
            this.payloads.forEachKeyMutableList = SynchronizedPutFastListMultimapTest::forEachKeyMutableList;
            this.payloads.flip = SynchronizedPutFastListMultimapTest::flip;
            this.payloads.testToString = SynchronizedPutFastListMultimapTest::testToString;
            this.payloads.selectKeysValues = SynchronizedPutFastListMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = SynchronizedPutFastListMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = SynchronizedPutFastListMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = SynchronizedPutFastListMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = SynchronizedPutFastListMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = SynchronizedPutFastListMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = SynchronizedPutFastListMultimapTest::collectValues;
        }
    }
}
