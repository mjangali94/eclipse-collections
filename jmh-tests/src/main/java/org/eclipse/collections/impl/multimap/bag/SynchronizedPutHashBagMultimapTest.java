/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag;

import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link SynchronizedPutHashBagMultimap}.
 */
public class SynchronizedPutHashBagMultimapTest extends AbstractMutableBagMultimapTestCase {

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimap() {
        return SynchronizedPutHashBagMultimap.newMultimap();
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    public final <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return SynchronizedPutHashBagMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return SynchronizedPutHashBagMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> HashBag<V> createCollection(V... args) {
        return HashBag.newBagWith(args);
    }

    @Test
    @Override
    public void testToString() {
        super.testToString();
        MutableMultimap<String, Integer> multimap = this.newMultimapWithKeysValues("One", 1, "One", 2);
        String toString = multimap.toString();
        Assert.assertTrue("{One=[1, 2]}".equals(toString) || "{One=[2, 1]}".equals(toString));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedPutHashBagMultimapTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedPutHashBagMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> forEachKeyMutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> putOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutHashBagMultimapTest> testToString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = SynchronizedPutHashBagMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = SynchronizedPutHashBagMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = SynchronizedPutHashBagMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = SynchronizedPutHashBagMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = SynchronizedPutHashBagMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = SynchronizedPutHashBagMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = SynchronizedPutHashBagMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = SynchronizedPutHashBagMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = SynchronizedPutHashBagMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = SynchronizedPutHashBagMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = SynchronizedPutHashBagMultimapTest::forEachValue;
            this.payloads.valuesView = SynchronizedPutHashBagMultimapTest::valuesView;
            this.payloads.multiValuesView = SynchronizedPutHashBagMultimapTest::multiValuesView;
            this.payloads.notEmpty = SynchronizedPutHashBagMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = SynchronizedPutHashBagMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = SynchronizedPutHashBagMultimapTest::keyValuePairsView;
            this.payloads.keyBag = SynchronizedPutHashBagMultimapTest::keyBag;
            this.payloads.testEquals = SynchronizedPutHashBagMultimapTest::testEquals;
            this.payloads.testHashCode = SynchronizedPutHashBagMultimapTest::testHashCode;
            this.payloads.serialization = SynchronizedPutHashBagMultimapTest::serialization;
            this.payloads.newEmpty = SynchronizedPutHashBagMultimapTest::newEmpty;
            this.payloads.keysView = SynchronizedPutHashBagMultimapTest::keysView;
            this.payloads.keySet = SynchronizedPutHashBagMultimapTest::keySet;
            this.payloads.sizeDistinct = SynchronizedPutHashBagMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = SynchronizedPutHashBagMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = SynchronizedPutHashBagMultimapTest::addAndGrowMultimap;
            this.payloads.clear = SynchronizedPutHashBagMultimapTest::clear;
            this.payloads.removeObject = SynchronizedPutHashBagMultimapTest::removeObject;
            this.payloads.forEachKey = SynchronizedPutHashBagMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = SynchronizedPutHashBagMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedPutHashBagMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = SynchronizedPutHashBagMultimapTest::putAll;
            this.payloads.putAllPairs = SynchronizedPutHashBagMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = SynchronizedPutHashBagMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = SynchronizedPutHashBagMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = SynchronizedPutHashBagMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = SynchronizedPutHashBagMultimapTest::removeKey;
            this.payloads.containsValue = SynchronizedPutHashBagMultimapTest::containsValue;
            this.payloads.put_createCollection = SynchronizedPutHashBagMultimapTest::put_createCollection;
            this.payloads.remove = SynchronizedPutHashBagMultimapTest::remove;
            this.payloads.replaceValues = SynchronizedPutHashBagMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = SynchronizedPutHashBagMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = SynchronizedPutHashBagMultimapTest::toMap;
            this.payloads.toImmutable = SynchronizedPutHashBagMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = SynchronizedPutHashBagMultimapTest::toMapWithTarget;
            this.payloads.toMutable = SynchronizedPutHashBagMultimapTest::toMutable;
            this.payloads.forEachKeyMutableBag = SynchronizedPutHashBagMultimapTest::forEachKeyMutableBag;
            this.payloads.flip = SynchronizedPutHashBagMultimapTest::flip;
            this.payloads.selectKeysValues = SynchronizedPutHashBagMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = SynchronizedPutHashBagMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = SynchronizedPutHashBagMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = SynchronizedPutHashBagMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = SynchronizedPutHashBagMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = SynchronizedPutHashBagMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = SynchronizedPutHashBagMultimapTest::collectValues;
            this.payloads.putOccurrences = SynchronizedPutHashBagMultimapTest::putOccurrences;
            this.payloads.testToString = SynchronizedPutHashBagMultimapTest::testToString;
        }
    }
}
