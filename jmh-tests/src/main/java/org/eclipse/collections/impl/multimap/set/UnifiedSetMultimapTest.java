/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.set;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link UnifiedSetMultimap}.
 */
public class UnifiedSetMultimapTest extends AbstractMutableSetMultimapTestCase {

    @Override
    protected <K, V> MutableSetMultimap<K, V> newMultimap() {
        return UnifiedSetMultimap.newMultimap();
    }

    @Override
    protected <K, V> MutableSetMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        return this.<K, V>newMultimap().withKeyValue(key, value);
    }

    @Override
    protected <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    protected <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    protected <K, V> MutableSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @SafeVarargs
    @Override
    protected final <K, V> UnifiedSetMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return UnifiedSetMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> UnifiedSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return UnifiedSetMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> UnifiedSet<V> createCollection(V... args) {
        return UnifiedSet.newSetWith(args);
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
        UnifiedSetMultimap<Integer, String> actual = UnifiedSetMultimap.newMultimap(testList);
        Assert.assertEquals(FastList.newListWith(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)), actual.keysView().toList());
        Assert.assertEquals(FastList.newListWith("OneOne", "One"), actual.get(Integer.valueOf(1)).toList());
        Assert.assertEquals(FastList.newListWith("TwoTwo", "Two"), actual.get(Integer.valueOf(2)).toList());
        Assert.assertEquals(FastList.newListWith("ThreeThree", "Three"), actual.get(Integer.valueOf(3)).toList());
        Assert.assertEquals(FastList.newListWith("FourFour", "Four"), actual.get(Integer.valueOf(4)).toList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetMultimapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> forEachKeyMutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetMultimapTest> pairIterableConstructorTest;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = UnifiedSetMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = UnifiedSetMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = UnifiedSetMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = UnifiedSetMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = UnifiedSetMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = UnifiedSetMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = UnifiedSetMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = UnifiedSetMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = UnifiedSetMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = UnifiedSetMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = UnifiedSetMultimapTest::forEachValue;
            this.payloads.valuesView = UnifiedSetMultimapTest::valuesView;
            this.payloads.multiValuesView = UnifiedSetMultimapTest::multiValuesView;
            this.payloads.notEmpty = UnifiedSetMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = UnifiedSetMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = UnifiedSetMultimapTest::keyValuePairsView;
            this.payloads.keyBag = UnifiedSetMultimapTest::keyBag;
            this.payloads.testEquals = UnifiedSetMultimapTest::testEquals;
            this.payloads.testHashCode = UnifiedSetMultimapTest::testHashCode;
            this.payloads.serialization = UnifiedSetMultimapTest::serialization;
            this.payloads.newEmpty = UnifiedSetMultimapTest::newEmpty;
            this.payloads.keysView = UnifiedSetMultimapTest::keysView;
            this.payloads.keySet = UnifiedSetMultimapTest::keySet;
            this.payloads.sizeDistinct = UnifiedSetMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = UnifiedSetMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = UnifiedSetMultimapTest::addAndGrowMultimap;
            this.payloads.clear = UnifiedSetMultimapTest::clear;
            this.payloads.removeObject = UnifiedSetMultimapTest::removeObject;
            this.payloads.forEachKey = UnifiedSetMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = UnifiedSetMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = UnifiedSetMultimapTest::putAll;
            this.payloads.putAllFromCollection = UnifiedSetMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = UnifiedSetMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = UnifiedSetMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = UnifiedSetMultimapTest::removeKey;
            this.payloads.containsValue = UnifiedSetMultimapTest::containsValue;
            this.payloads.put_createCollection = UnifiedSetMultimapTest::put_createCollection;
            this.payloads.remove = UnifiedSetMultimapTest::remove;
            this.payloads.replaceValues = UnifiedSetMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = UnifiedSetMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = UnifiedSetMultimapTest::toMap;
            this.payloads.toImmutable = UnifiedSetMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = UnifiedSetMultimapTest::toMapWithTarget;
            this.payloads.toMutable = UnifiedSetMultimapTest::toMutable;
            this.payloads.testToString = UnifiedSetMultimapTest::testToString;
            this.payloads.forEachKeyMutableSet = UnifiedSetMultimapTest::forEachKeyMutableSet;
            this.payloads.putAllPairs = UnifiedSetMultimapTest::putAllPairs;
            this.payloads.flip = UnifiedSetMultimapTest::flip;
            this.payloads.selectKeysValues = UnifiedSetMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = UnifiedSetMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = UnifiedSetMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = UnifiedSetMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = UnifiedSetMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = UnifiedSetMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = UnifiedSetMultimapTest::collectValues;
            this.payloads.pairIterableConstructorTest = UnifiedSetMultimapTest::pairIterableConstructorTest;
        }
    }
*/
}
