/*
 * Copyright (c) 2022 Shotaro Sano and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.set;

import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

public class SynchronizedSetMultimapTest extends AbstractMutableSetMultimapTestCase {

    @Override
    public <K, V> MutableSetMultimap<K, V> newMultimap() {
        return new SynchronizedSetMultimap<>(UnifiedSetMultimap.newMultimap());
    }

    @Override
    public <K, V> MutableSetMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        return this.<K, V>newMultimap().withKeyValue(key, value);
    }

    @Override
    public <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    public <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    public <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @Override
    public <K, V> MutableSetMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return new SynchronizedSetMultimap<>(UnifiedSetMultimap.newMultimap(pairs));
    }

    @Override
    public <K, V> MutableSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return new SynchronizedSetMultimap<>(UnifiedSetMultimap.newMultimap(inputIterable));
    }

    @SafeVarargs
    @Override
    protected final <V> MutableSet<V> createCollection(V... args) {
        return UnifiedSet.newSetWith(args);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedSetMultimapTest instance;

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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllPairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllPairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedSetMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> forEachKeyMutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSetMultimapTest> collectValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = SynchronizedSetMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = SynchronizedSetMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = SynchronizedSetMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = SynchronizedSetMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = SynchronizedSetMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = SynchronizedSetMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = SynchronizedSetMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = SynchronizedSetMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = SynchronizedSetMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = SynchronizedSetMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = SynchronizedSetMultimapTest::forEachValue;
            this.payloads.valuesView = SynchronizedSetMultimapTest::valuesView;
            this.payloads.multiValuesView = SynchronizedSetMultimapTest::multiValuesView;
            this.payloads.notEmpty = SynchronizedSetMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = SynchronizedSetMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = SynchronizedSetMultimapTest::keyValuePairsView;
            this.payloads.keyBag = SynchronizedSetMultimapTest::keyBag;
            this.payloads.testEquals = SynchronizedSetMultimapTest::testEquals;
            this.payloads.testHashCode = SynchronizedSetMultimapTest::testHashCode;
            this.payloads.serialization = SynchronizedSetMultimapTest::serialization;
            this.payloads.newEmpty = SynchronizedSetMultimapTest::newEmpty;
            this.payloads.keysView = SynchronizedSetMultimapTest::keysView;
            this.payloads.keySet = SynchronizedSetMultimapTest::keySet;
            this.payloads.sizeDistinct = SynchronizedSetMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = SynchronizedSetMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = SynchronizedSetMultimapTest::addAndGrowMultimap;
            this.payloads.clear = SynchronizedSetMultimapTest::clear;
            this.payloads.removeObject = SynchronizedSetMultimapTest::removeObject;
            this.payloads.forEachKey = SynchronizedSetMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = SynchronizedSetMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSetMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = SynchronizedSetMultimapTest::putAll;
            this.payloads.putAllFromCollection = SynchronizedSetMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = SynchronizedSetMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = SynchronizedSetMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = SynchronizedSetMultimapTest::removeKey;
            this.payloads.containsValue = SynchronizedSetMultimapTest::containsValue;
            this.payloads.put_createCollection = SynchronizedSetMultimapTest::put_createCollection;
            this.payloads.remove = SynchronizedSetMultimapTest::remove;
            this.payloads.replaceValues = SynchronizedSetMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = SynchronizedSetMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = SynchronizedSetMultimapTest::toMap;
            this.payloads.toImmutable = SynchronizedSetMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = SynchronizedSetMultimapTest::toMapWithTarget;
            this.payloads.toMutable = SynchronizedSetMultimapTest::toMutable;
            this.payloads.testToString = SynchronizedSetMultimapTest::testToString;
            this.payloads.forEachKeyMutableSet = SynchronizedSetMultimapTest::forEachKeyMutableSet;
            this.payloads.putAllPairs = SynchronizedSetMultimapTest::putAllPairs;
            this.payloads.flip = SynchronizedSetMultimapTest::flip;
            this.payloads.selectKeysValues = SynchronizedSetMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = SynchronizedSetMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = SynchronizedSetMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = SynchronizedSetMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = SynchronizedSetMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = SynchronizedSetMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = SynchronizedSetMultimapTest::collectValues;
        }
    }
*/
}
