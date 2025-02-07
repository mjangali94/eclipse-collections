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

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.MultiReaderFastList;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link MultiReaderFastListMultimap}.
 */
public class MultiReaderFastListMultimapTest extends AbstractMutableListMultimapTestCase {

    @Override
    public <K, V> MultiReaderFastListMultimap<K, V> newMultimap() {
        return MultiReaderFastListMultimap.newMultimap();
    }

    @Override
    public <K, V> MultiReaderFastListMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        MultiReaderFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> MultiReaderFastListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        MultiReaderFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> MultiReaderFastListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        MultiReaderFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> MultiReaderFastListMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        MultiReaderFastListMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    public final <K, V> MultiReaderFastListMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return MultiReaderFastListMultimap.newMultimap(pairs);
    }

    @Override
    public <K, V> MultiReaderFastListMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return MultiReaderFastListMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> MultiReaderFastList<V> createCollection(V... args) {
        return MultiReaderFastList.newListWith(args);
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
        MutableList<Pair<Integer, String>> testList = FastList.newListWith(pair1, pair2, pair3, pair4, pair11, pair22, pair33, pair44, pair111, pair222, pair333, pair444);
        MultiReaderFastListMultimap<Integer, String> actual = MultiReaderFastListMultimap.newMultimap(testList);
        Assert.assertEquals(FastList.newListWith(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)), actual.keysView().toList());
        Assert.assertEquals(FastList.newListWith("One", "OneOne", "One"), actual.get(Integer.valueOf(1)).toList());
        Assert.assertEquals(FastList.newListWith("Two", "TwoTwo", "Two"), actual.get(Integer.valueOf(2)).toList());
        Assert.assertEquals(FastList.newListWith("Three", "ThreeThree", "Three"), actual.get(Integer.valueOf(3)).toList());
        Assert.assertEquals(FastList.newListWith("Four", "FourFour", "Four"), actual.get(Integer.valueOf(4)).toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderFastListMultimapTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pairIterableConstructorTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pairIterableConstructorTest);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderFastListMultimapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> forEachKeyMutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListMultimapTest> pairIterableConstructorTest;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = MultiReaderFastListMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = MultiReaderFastListMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = MultiReaderFastListMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = MultiReaderFastListMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = MultiReaderFastListMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = MultiReaderFastListMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = MultiReaderFastListMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = MultiReaderFastListMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = MultiReaderFastListMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = MultiReaderFastListMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = MultiReaderFastListMultimapTest::forEachValue;
            this.payloads.valuesView = MultiReaderFastListMultimapTest::valuesView;
            this.payloads.multiValuesView = MultiReaderFastListMultimapTest::multiValuesView;
            this.payloads.notEmpty = MultiReaderFastListMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = MultiReaderFastListMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = MultiReaderFastListMultimapTest::keyValuePairsView;
            this.payloads.keyBag = MultiReaderFastListMultimapTest::keyBag;
            this.payloads.testEquals = MultiReaderFastListMultimapTest::testEquals;
            this.payloads.testHashCode = MultiReaderFastListMultimapTest::testHashCode;
            this.payloads.serialization = MultiReaderFastListMultimapTest::serialization;
            this.payloads.newEmpty = MultiReaderFastListMultimapTest::newEmpty;
            this.payloads.keysView = MultiReaderFastListMultimapTest::keysView;
            this.payloads.keySet = MultiReaderFastListMultimapTest::keySet;
            this.payloads.sizeDistinct = MultiReaderFastListMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = MultiReaderFastListMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = MultiReaderFastListMultimapTest::addAndGrowMultimap;
            this.payloads.clear = MultiReaderFastListMultimapTest::clear;
            this.payloads.removeObject = MultiReaderFastListMultimapTest::removeObject;
            this.payloads.forEachKey = MultiReaderFastListMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = MultiReaderFastListMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = MultiReaderFastListMultimapTest::putAll;
            this.payloads.putAllPairs = MultiReaderFastListMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = MultiReaderFastListMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = MultiReaderFastListMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = MultiReaderFastListMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = MultiReaderFastListMultimapTest::removeKey;
            this.payloads.containsValue = MultiReaderFastListMultimapTest::containsValue;
            this.payloads.put_createCollection = MultiReaderFastListMultimapTest::put_createCollection;
            this.payloads.remove = MultiReaderFastListMultimapTest::remove;
            this.payloads.replaceValues = MultiReaderFastListMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = MultiReaderFastListMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = MultiReaderFastListMultimapTest::toMap;
            this.payloads.toImmutable = MultiReaderFastListMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = MultiReaderFastListMultimapTest::toMapWithTarget;
            this.payloads.toMutable = MultiReaderFastListMultimapTest::toMutable;
            this.payloads.forEachKeyMutableList = MultiReaderFastListMultimapTest::forEachKeyMutableList;
            this.payloads.flip = MultiReaderFastListMultimapTest::flip;
            this.payloads.testToString = MultiReaderFastListMultimapTest::testToString;
            this.payloads.selectKeysValues = MultiReaderFastListMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = MultiReaderFastListMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = MultiReaderFastListMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = MultiReaderFastListMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = MultiReaderFastListMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = MultiReaderFastListMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = MultiReaderFastListMultimapTest::collectValues;
            this.payloads.pairIterableConstructorTest = MultiReaderFastListMultimapTest::pairIterableConstructorTest;
        }
    }
}
