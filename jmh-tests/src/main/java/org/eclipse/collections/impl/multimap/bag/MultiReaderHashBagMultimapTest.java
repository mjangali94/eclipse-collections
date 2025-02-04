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

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.MultiReaderHashBag;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link MultiReaderHashBagMultimap}.
 */
public class MultiReaderHashBagMultimapTest extends AbstractMutableBagMultimapTestCase {

    @Override
    public <K, V> MultiReaderHashBagMultimap<K, V> newMultimap() {
        return MultiReaderHashBagMultimap.newMultimap();
    }

    @Override
    public <K, V> MultiReaderHashBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        MultiReaderHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> MultiReaderHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        MultiReaderHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> MultiReaderHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        MultiReaderHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> MultiReaderHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        MultiReaderHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    public final <K, V> MultiReaderHashBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return MultiReaderHashBagMultimap.newMultimap(pairs);
    }

    @Override
    public <K, V> MultiReaderHashBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return MultiReaderHashBagMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> MultiReaderHashBag<V> createCollection(V... args) {
        return MultiReaderHashBag.newBagWith(args);
    }

    @Test
    public void pairIterableConstructorTest() {
        Pair<Integer, String> pair1 = Tuples.pair(Integer.valueOf(1), "One");
        Pair<Integer, String> pair2 = Tuples.pair(Integer.valueOf(2), "Two");
        Pair<Integer, String> pair3 = Tuples.pair(Integer.valueOf(3), "Three");
        Pair<Integer, String> pair4 = Tuples.pair(Integer.valueOf(4), "Four");
        Pair<Integer, String> pair11 = Tuples.pair(Integer.valueOf(1), "OneOne");
        Pair<Integer, String> pair22 = Tuples.pair(Integer.valueOf(2), "TwoTwo");
        Pair<Integer, String> pair33 = Tuples.pair(Integer.valueOf(3), "ThreeThree");
        Pair<Integer, String> pair44 = Tuples.pair(Integer.valueOf(4), "FourFour");
        Pair<Integer, String> pair111 = Tuples.pair(Integer.valueOf(1), "One");
        Pair<Integer, String> pair222 = Tuples.pair(Integer.valueOf(2), "Two");
        Pair<Integer, String> pair333 = Tuples.pair(Integer.valueOf(3), "Three");
        Pair<Integer, String> pair444 = Tuples.pair(Integer.valueOf(4), "Four");
        MutableBag<Pair<Integer, String>> testBag = HashBag.newBagWith(pair1, pair2, pair3, pair4, pair11, pair22, pair33, pair44, pair111, pair222, pair333, pair444);
        MultiReaderHashBagMultimap<Integer, String> actual = MultiReaderHashBagMultimap.newMultimap(testBag);
        Assert.assertEquals(HashBag.newBagWith(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)), actual.keysView().toBag());
        Assert.assertEquals(HashBag.newBagWith("One", "OneOne", "One"), actual.get(Integer.valueOf(1)));
        Assert.assertEquals(HashBag.newBagWith("Two", "TwoTwo", "Two"), actual.get(Integer.valueOf(2)));
        Assert.assertEquals(HashBag.newBagWith("Three", "ThreeThree", "Three"), actual.get(Integer.valueOf(3)));
        Assert.assertEquals(HashBag.newBagWith("Four", "FourFour", "Four"), actual.get(Integer.valueOf(4)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MultiReaderHashBagMultimapTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pairIterableConstructorTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pairIterableConstructorTest);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderHashBagMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> forEachKeyMutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> putOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagMultimapTest> pairIterableConstructorTest;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = MultiReaderHashBagMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = MultiReaderHashBagMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = MultiReaderHashBagMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = MultiReaderHashBagMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = MultiReaderHashBagMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = MultiReaderHashBagMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = MultiReaderHashBagMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = MultiReaderHashBagMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = MultiReaderHashBagMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = MultiReaderHashBagMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = MultiReaderHashBagMultimapTest::forEachValue;
            this.payloads.valuesView = MultiReaderHashBagMultimapTest::valuesView;
            this.payloads.multiValuesView = MultiReaderHashBagMultimapTest::multiValuesView;
            this.payloads.notEmpty = MultiReaderHashBagMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = MultiReaderHashBagMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = MultiReaderHashBagMultimapTest::keyValuePairsView;
            this.payloads.keyBag = MultiReaderHashBagMultimapTest::keyBag;
            this.payloads.testEquals = MultiReaderHashBagMultimapTest::testEquals;
            this.payloads.testHashCode = MultiReaderHashBagMultimapTest::testHashCode;
            this.payloads.serialization = MultiReaderHashBagMultimapTest::serialization;
            this.payloads.newEmpty = MultiReaderHashBagMultimapTest::newEmpty;
            this.payloads.keysView = MultiReaderHashBagMultimapTest::keysView;
            this.payloads.keySet = MultiReaderHashBagMultimapTest::keySet;
            this.payloads.sizeDistinct = MultiReaderHashBagMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = MultiReaderHashBagMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = MultiReaderHashBagMultimapTest::addAndGrowMultimap;
            this.payloads.clear = MultiReaderHashBagMultimapTest::clear;
            this.payloads.removeObject = MultiReaderHashBagMultimapTest::removeObject;
            this.payloads.forEachKey = MultiReaderHashBagMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = MultiReaderHashBagMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = MultiReaderHashBagMultimapTest::putAll;
            this.payloads.putAllPairs = MultiReaderHashBagMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = MultiReaderHashBagMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = MultiReaderHashBagMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = MultiReaderHashBagMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = MultiReaderHashBagMultimapTest::removeKey;
            this.payloads.containsValue = MultiReaderHashBagMultimapTest::containsValue;
            this.payloads.put_createCollection = MultiReaderHashBagMultimapTest::put_createCollection;
            this.payloads.remove = MultiReaderHashBagMultimapTest::remove;
            this.payloads.replaceValues = MultiReaderHashBagMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = MultiReaderHashBagMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = MultiReaderHashBagMultimapTest::toMap;
            this.payloads.toImmutable = MultiReaderHashBagMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = MultiReaderHashBagMultimapTest::toMapWithTarget;
            this.payloads.toMutable = MultiReaderHashBagMultimapTest::toMutable;
            this.payloads.testToString = MultiReaderHashBagMultimapTest::testToString;
            this.payloads.forEachKeyMutableBag = MultiReaderHashBagMultimapTest::forEachKeyMutableBag;
            this.payloads.flip = MultiReaderHashBagMultimapTest::flip;
            this.payloads.selectKeysValues = MultiReaderHashBagMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = MultiReaderHashBagMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = MultiReaderHashBagMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = MultiReaderHashBagMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = MultiReaderHashBagMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = MultiReaderHashBagMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = MultiReaderHashBagMultimapTest::collectValues;
            this.payloads.putOccurrences = MultiReaderHashBagMultimapTest::putOccurrences;
            this.payloads.pairIterableConstructorTest = MultiReaderHashBagMultimapTest::pairIterableConstructorTest;
        }
    }
}
