/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.set;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.set.mutable.MultiReaderUnifiedSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link MultiReaderUnifiedSetMultimap}.
 */
public class MultiReaderUnifiedSetMultimapTest extends AbstractMutableSetMultimapTestCase {

    @Override
    protected <K, V> MultiReaderUnifiedSetMultimap<K, V> newMultimap() {
        return MultiReaderUnifiedSetMultimap.newMultimap();
    }

    @Override
    protected <K, V> MultiReaderUnifiedSetMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        MultiReaderUnifiedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    protected <K, V> MultiReaderUnifiedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        MultiReaderUnifiedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    protected <K, V> MultiReaderUnifiedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        MultiReaderUnifiedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    protected <K, V> MultiReaderUnifiedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        MultiReaderUnifiedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    protected final <K, V> MultiReaderUnifiedSetMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return MultiReaderUnifiedSetMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> MultiReaderUnifiedSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return MultiReaderUnifiedSetMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> MultiReaderUnifiedSet<V> createCollection(V... args) {
        return MultiReaderUnifiedSet.newSetWith(args);
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
        MutableSet<Pair<Integer, String>> testBag = UnifiedSet.newSetWith(pair1, pair2, pair3, pair4, pair11, pair22, pair33, pair44, pair111, pair222, pair333, pair444);
        MultiReaderUnifiedSetMultimap<Integer, String> actual = MultiReaderUnifiedSetMultimap.newMultimap(testBag);
        Assert.assertEquals(UnifiedSet.newSetWith(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)), actual.keysView().toSet());
        Assert.assertEquals(UnifiedSet.newSetWith("One", "OneOne", "One"), actual.get(Integer.valueOf(1)));
        Assert.assertEquals(UnifiedSet.newSetWith("Two", "TwoTwo", "Two"), actual.get(Integer.valueOf(2)));
        Assert.assertEquals(UnifiedSet.newSetWith("Three", "ThreeThree", "Three"), actual.get(Integer.valueOf(3)));
        Assert.assertEquals(UnifiedSet.newSetWith("Four", "FourFour", "Four"), actual.get(Integer.valueOf(4)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderUnifiedSetMultimapTest instance;

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_pairIterableConstructorTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.pairIterableConstructorTest);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderUnifiedSetMultimapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> forEachKeyMutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderUnifiedSetMultimapTest> pairIterableConstructorTest;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = MultiReaderUnifiedSetMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = MultiReaderUnifiedSetMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = MultiReaderUnifiedSetMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = MultiReaderUnifiedSetMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = MultiReaderUnifiedSetMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = MultiReaderUnifiedSetMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = MultiReaderUnifiedSetMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = MultiReaderUnifiedSetMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = MultiReaderUnifiedSetMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = MultiReaderUnifiedSetMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = MultiReaderUnifiedSetMultimapTest::forEachValue;
            this.payloads.valuesView = MultiReaderUnifiedSetMultimapTest::valuesView;
            this.payloads.multiValuesView = MultiReaderUnifiedSetMultimapTest::multiValuesView;
            this.payloads.notEmpty = MultiReaderUnifiedSetMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = MultiReaderUnifiedSetMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = MultiReaderUnifiedSetMultimapTest::keyValuePairsView;
            this.payloads.keyBag = MultiReaderUnifiedSetMultimapTest::keyBag;
            this.payloads.testEquals = MultiReaderUnifiedSetMultimapTest::testEquals;
            this.payloads.testHashCode = MultiReaderUnifiedSetMultimapTest::testHashCode;
            this.payloads.serialization = MultiReaderUnifiedSetMultimapTest::serialization;
            this.payloads.newEmpty = MultiReaderUnifiedSetMultimapTest::newEmpty;
            this.payloads.keysView = MultiReaderUnifiedSetMultimapTest::keysView;
            this.payloads.keySet = MultiReaderUnifiedSetMultimapTest::keySet;
            this.payloads.sizeDistinct = MultiReaderUnifiedSetMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = MultiReaderUnifiedSetMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = MultiReaderUnifiedSetMultimapTest::addAndGrowMultimap;
            this.payloads.clear = MultiReaderUnifiedSetMultimapTest::clear;
            this.payloads.removeObject = MultiReaderUnifiedSetMultimapTest::removeObject;
            this.payloads.forEachKey = MultiReaderUnifiedSetMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = MultiReaderUnifiedSetMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderUnifiedSetMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = MultiReaderUnifiedSetMultimapTest::putAll;
            this.payloads.putAllFromCollection = MultiReaderUnifiedSetMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = MultiReaderUnifiedSetMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = MultiReaderUnifiedSetMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = MultiReaderUnifiedSetMultimapTest::removeKey;
            this.payloads.containsValue = MultiReaderUnifiedSetMultimapTest::containsValue;
            this.payloads.put_createCollection = MultiReaderUnifiedSetMultimapTest::put_createCollection;
            this.payloads.remove = MultiReaderUnifiedSetMultimapTest::remove;
            this.payloads.replaceValues = MultiReaderUnifiedSetMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = MultiReaderUnifiedSetMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = MultiReaderUnifiedSetMultimapTest::toMap;
            this.payloads.toImmutable = MultiReaderUnifiedSetMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = MultiReaderUnifiedSetMultimapTest::toMapWithTarget;
            this.payloads.toMutable = MultiReaderUnifiedSetMultimapTest::toMutable;
            this.payloads.testToString = MultiReaderUnifiedSetMultimapTest::testToString;
            this.payloads.forEachKeyMutableSet = MultiReaderUnifiedSetMultimapTest::forEachKeyMutableSet;
            this.payloads.putAllPairs = MultiReaderUnifiedSetMultimapTest::putAllPairs;
            this.payloads.flip = MultiReaderUnifiedSetMultimapTest::flip;
            this.payloads.selectKeysValues = MultiReaderUnifiedSetMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = MultiReaderUnifiedSetMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = MultiReaderUnifiedSetMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = MultiReaderUnifiedSetMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = MultiReaderUnifiedSetMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = MultiReaderUnifiedSetMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = MultiReaderUnifiedSetMultimapTest::collectValues;
            this.payloads.pairIterableConstructorTest = MultiReaderUnifiedSetMultimapTest::pairIterableConstructorTest;
        }
    }
}
