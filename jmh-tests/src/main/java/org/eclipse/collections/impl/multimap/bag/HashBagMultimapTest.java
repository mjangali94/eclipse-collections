/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Bags;

/**
 * Test of {@link HashBagMultimap}.
 */
public class HashBagMultimapTest extends AbstractMutableBagMultimapTestCase {

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimap() {
        return HashBagMultimap.newMultimap();
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        return this.<K, V>newMultimap().withKeyValue(key, value);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @SafeVarargs
    @Override
    protected final <K, V> MutableBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return HashBagMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return HashBagMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> MutableBag<V> createCollection(V... args) {
        return Bags.mutable.of(args);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private HashBagMultimapTest instance;

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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyMutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyMutableBag);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putOccurrences);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new HashBagMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> forEachKeyMutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBagMultimapTest> putOccurrences;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = HashBagMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = HashBagMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = HashBagMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = HashBagMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = HashBagMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = HashBagMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = HashBagMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = HashBagMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = HashBagMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = HashBagMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = HashBagMultimapTest::forEachValue;
            this.payloads.valuesView = HashBagMultimapTest::valuesView;
            this.payloads.multiValuesView = HashBagMultimapTest::multiValuesView;
            this.payloads.notEmpty = HashBagMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = HashBagMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = HashBagMultimapTest::keyValuePairsView;
            this.payloads.keyBag = HashBagMultimapTest::keyBag;
            this.payloads.testEquals = HashBagMultimapTest::testEquals;
            this.payloads.testHashCode = HashBagMultimapTest::testHashCode;
            this.payloads.serialization = HashBagMultimapTest::serialization;
            this.payloads.newEmpty = HashBagMultimapTest::newEmpty;
            this.payloads.keysView = HashBagMultimapTest::keysView;
            this.payloads.keySet = HashBagMultimapTest::keySet;
            this.payloads.sizeDistinct = HashBagMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = HashBagMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = HashBagMultimapTest::addAndGrowMultimap;
            this.payloads.clear = HashBagMultimapTest::clear;
            this.payloads.removeObject = HashBagMultimapTest::removeObject;
            this.payloads.forEachKey = HashBagMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = HashBagMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBagMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = HashBagMultimapTest::putAll;
            this.payloads.putAllPairs = HashBagMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = HashBagMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = HashBagMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = HashBagMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = HashBagMultimapTest::removeKey;
            this.payloads.containsValue = HashBagMultimapTest::containsValue;
            this.payloads.put_createCollection = HashBagMultimapTest::put_createCollection;
            this.payloads.remove = HashBagMultimapTest::remove;
            this.payloads.replaceValues = HashBagMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = HashBagMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = HashBagMultimapTest::toMap;
            this.payloads.toImmutable = HashBagMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = HashBagMultimapTest::toMapWithTarget;
            this.payloads.toMutable = HashBagMultimapTest::toMutable;
            this.payloads.testToString = HashBagMultimapTest::testToString;
            this.payloads.forEachKeyMutableBag = HashBagMultimapTest::forEachKeyMutableBag;
            this.payloads.flip = HashBagMultimapTest::flip;
            this.payloads.selectKeysValues = HashBagMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = HashBagMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = HashBagMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = HashBagMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = HashBagMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = HashBagMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = HashBagMultimapTest::collectValues;
            this.payloads.putOccurrences = HashBagMultimapTest::putOccurrences;
        }
    }
*/
}
