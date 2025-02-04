/*
 * Copyright (c) 2022 Shotaro Sano and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.list;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.list.mutable.FastList;

public class SynchronizedListMultimapTest extends AbstractMutableListMultimapTestCase {

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimap() {
        return new SynchronizedListMultimap<>(FastListMultimap.newMultimap());
    }

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        return this.<K, V>newMultimap().withKeyValue(key, value);
    }

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return new SynchronizedListMultimap<>(FastListMultimap.newMultimap(pairs));
    }

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return new SynchronizedListMultimap<>(FastListMultimap.newMultimap(inputIterable));
    }

    @SafeVarargs
    @Override
    protected final <V> MutableList<V> createCollection(V... args) {
        return FastList.newListWith(args);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedListMultimapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedListMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> forEachKeyMutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedListMultimapTest> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = SynchronizedListMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = SynchronizedListMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = SynchronizedListMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = SynchronizedListMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = SynchronizedListMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = SynchronizedListMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = SynchronizedListMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = SynchronizedListMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = SynchronizedListMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = SynchronizedListMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = SynchronizedListMultimapTest::forEachValue;
            this.payloads.valuesView = SynchronizedListMultimapTest::valuesView;
            this.payloads.multiValuesView = SynchronizedListMultimapTest::multiValuesView;
            this.payloads.notEmpty = SynchronizedListMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = SynchronizedListMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = SynchronizedListMultimapTest::keyValuePairsView;
            this.payloads.keyBag = SynchronizedListMultimapTest::keyBag;
            this.payloads.testEquals = SynchronizedListMultimapTest::testEquals;
            this.payloads.testHashCode = SynchronizedListMultimapTest::testHashCode;
            this.payloads.serialization = SynchronizedListMultimapTest::serialization;
            this.payloads.newEmpty = SynchronizedListMultimapTest::newEmpty;
            this.payloads.keysView = SynchronizedListMultimapTest::keysView;
            this.payloads.keySet = SynchronizedListMultimapTest::keySet;
            this.payloads.sizeDistinct = SynchronizedListMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = SynchronizedListMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = SynchronizedListMultimapTest::addAndGrowMultimap;
            this.payloads.clear = SynchronizedListMultimapTest::clear;
            this.payloads.removeObject = SynchronizedListMultimapTest::removeObject;
            this.payloads.forEachKey = SynchronizedListMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = SynchronizedListMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedListMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = SynchronizedListMultimapTest::putAll;
            this.payloads.putAllPairs = SynchronizedListMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = SynchronizedListMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = SynchronizedListMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = SynchronizedListMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = SynchronizedListMultimapTest::removeKey;
            this.payloads.containsValue = SynchronizedListMultimapTest::containsValue;
            this.payloads.put_createCollection = SynchronizedListMultimapTest::put_createCollection;
            this.payloads.remove = SynchronizedListMultimapTest::remove;
            this.payloads.replaceValues = SynchronizedListMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = SynchronizedListMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = SynchronizedListMultimapTest::toMap;
            this.payloads.toImmutable = SynchronizedListMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = SynchronizedListMultimapTest::toMapWithTarget;
            this.payloads.toMutable = SynchronizedListMultimapTest::toMutable;
            this.payloads.forEachKeyMutableList = SynchronizedListMultimapTest::forEachKeyMutableList;
            this.payloads.flip = SynchronizedListMultimapTest::flip;
            this.payloads.testToString = SynchronizedListMultimapTest::testToString;
            this.payloads.selectKeysValues = SynchronizedListMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = SynchronizedListMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = SynchronizedListMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = SynchronizedListMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = SynchronizedListMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = SynchronizedListMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = SynchronizedListMultimapTest::collectValues;
        }
    }
}
