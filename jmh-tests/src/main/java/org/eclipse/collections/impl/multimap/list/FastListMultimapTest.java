/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link FastListMultimap}.
 */
public class FastListMultimapTest extends AbstractMutableListMultimapTestCase {

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimap() {
        return FastListMultimap.newMultimap();
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

    @SafeVarargs
    @Override
    public final <K, V> MutableListMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return FastListMultimap.newMultimap(pairs);
    }

    @Override
    public <K, V> MutableListMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return FastListMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> FastList<V> createCollection(V... args) {
        return FastList.newListWith(args);
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
        MutableListMultimap<Integer, String> actual = FastListMultimap.newMultimap(testList);
        Assert.assertEquals(FastList.newListWith(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)), actual.keysView().toList());
        Assert.assertEquals(FastList.newListWith("One", "OneOne", "One"), actual.get(Integer.valueOf(1)).toList());
        Assert.assertEquals(FastList.newListWith("Two", "TwoTwo", "Two"), actual.get(Integer.valueOf(2)).toList());
        Assert.assertEquals(FastList.newListWith("Three", "ThreeThree", "Three"), actual.get(Integer.valueOf(3)).toList());
        Assert.assertEquals(FastList.newListWith("Four", "FourFour", "Four"), actual.get(Integer.valueOf(4)).toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public FastListMultimapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new FastListMultimapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> forEachKeyMutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FastListMultimapTest> pairIterableConstructorTest;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = FastListMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = FastListMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = FastListMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = FastListMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = FastListMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = FastListMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = FastListMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = FastListMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = FastListMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = FastListMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = FastListMultimapTest::forEachValue;
            this.payloads.valuesView = FastListMultimapTest::valuesView;
            this.payloads.multiValuesView = FastListMultimapTest::multiValuesView;
            this.payloads.notEmpty = FastListMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = FastListMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = FastListMultimapTest::keyValuePairsView;
            this.payloads.keyBag = FastListMultimapTest::keyBag;
            this.payloads.testEquals = FastListMultimapTest::testEquals;
            this.payloads.testHashCode = FastListMultimapTest::testHashCode;
            this.payloads.serialization = FastListMultimapTest::serialization;
            this.payloads.newEmpty = FastListMultimapTest::newEmpty;
            this.payloads.keysView = FastListMultimapTest::keysView;
            this.payloads.keySet = FastListMultimapTest::keySet;
            this.payloads.sizeDistinct = FastListMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = FastListMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = FastListMultimapTest::addAndGrowMultimap;
            this.payloads.clear = FastListMultimapTest::clear;
            this.payloads.removeObject = FastListMultimapTest::removeObject;
            this.payloads.forEachKey = FastListMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = FastListMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(FastListMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = FastListMultimapTest::putAll;
            this.payloads.putAllPairs = FastListMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = FastListMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = FastListMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = FastListMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = FastListMultimapTest::removeKey;
            this.payloads.containsValue = FastListMultimapTest::containsValue;
            this.payloads.put_createCollection = FastListMultimapTest::put_createCollection;
            this.payloads.remove = FastListMultimapTest::remove;
            this.payloads.replaceValues = FastListMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = FastListMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = FastListMultimapTest::toMap;
            this.payloads.toImmutable = FastListMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = FastListMultimapTest::toMapWithTarget;
            this.payloads.toMutable = FastListMultimapTest::toMutable;
            this.payloads.forEachKeyMutableList = FastListMultimapTest::forEachKeyMutableList;
            this.payloads.flip = FastListMultimapTest::flip;
            this.payloads.testToString = FastListMultimapTest::testToString;
            this.payloads.selectKeysValues = FastListMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = FastListMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = FastListMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = FastListMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = FastListMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = FastListMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = FastListMultimapTest::collectValues;
            this.payloads.pairIterableConstructorTest = FastListMultimapTest::pairIterableConstructorTest;
        }
    }
}
