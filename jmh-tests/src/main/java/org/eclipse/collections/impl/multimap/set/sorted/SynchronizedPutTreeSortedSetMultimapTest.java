/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.set.sorted;

import java.util.Comparator;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.sortedset.MutableSortedSetMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link SynchronizedPutTreeSortedSetMultimap}.
 */
public class SynchronizedPutTreeSortedSetMultimapTest extends AbstractMutableSortedSetMultimapTestCase {

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimap() {
        return SynchronizedPutTreeSortedSetMultimap.newMultimap(Comparators.reverseNaturalOrder());
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimap(Comparator<? super V> comparator) {
        return SynchronizedPutTreeSortedSetMultimap.newMultimap(comparator);
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        return this.<K, V>newMultimap().withKeyValue(key, value);
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @SafeVarargs
    @Override
    protected final <K, V> MutableSortedSetMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        MutableSortedSetMultimap<K, V> result = this.newMultimap();
        for (Pair<K, V> pair : pairs) {
            result.add(pair);
        }
        return result;
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        MutableSortedSetMultimap<K, V> result = this.newMultimap();
        for (Pair<K, V> pair : inputIterable) {
            result.add(pair);
        }
        return result;
    }

    @SafeVarargs
    @Override
    protected final <V> TreeSortedSet<V> createCollection(V... args) {
        return TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), args);
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

        private SynchronizedPutTreeSortedSetMultimapTest instance;

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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedPutTreeSortedSetMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedPutTreeSortedSetMultimapTest> testToString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = SynchronizedPutTreeSortedSetMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = SynchronizedPutTreeSortedSetMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = SynchronizedPutTreeSortedSetMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = SynchronizedPutTreeSortedSetMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = SynchronizedPutTreeSortedSetMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = SynchronizedPutTreeSortedSetMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = SynchronizedPutTreeSortedSetMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = SynchronizedPutTreeSortedSetMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = SynchronizedPutTreeSortedSetMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = SynchronizedPutTreeSortedSetMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = SynchronizedPutTreeSortedSetMultimapTest::forEachValue;
            this.payloads.valuesView = SynchronizedPutTreeSortedSetMultimapTest::valuesView;
            this.payloads.multiValuesView = SynchronizedPutTreeSortedSetMultimapTest::multiValuesView;
            this.payloads.notEmpty = SynchronizedPutTreeSortedSetMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = SynchronizedPutTreeSortedSetMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = SynchronizedPutTreeSortedSetMultimapTest::keyValuePairsView;
            this.payloads.keyBag = SynchronizedPutTreeSortedSetMultimapTest::keyBag;
            this.payloads.testEquals = SynchronizedPutTreeSortedSetMultimapTest::testEquals;
            this.payloads.testHashCode = SynchronizedPutTreeSortedSetMultimapTest::testHashCode;
            this.payloads.newEmpty = SynchronizedPutTreeSortedSetMultimapTest::newEmpty;
            this.payloads.keysView = SynchronizedPutTreeSortedSetMultimapTest::keysView;
            this.payloads.keySet = SynchronizedPutTreeSortedSetMultimapTest::keySet;
            this.payloads.sizeDistinct = SynchronizedPutTreeSortedSetMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = SynchronizedPutTreeSortedSetMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = SynchronizedPutTreeSortedSetMultimapTest::addAndGrowMultimap;
            this.payloads.clear = SynchronizedPutTreeSortedSetMultimapTest::clear;
            this.payloads.removeObject = SynchronizedPutTreeSortedSetMultimapTest::removeObject;
            this.payloads.forEachKey = SynchronizedPutTreeSortedSetMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = SynchronizedPutTreeSortedSetMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedPutTreeSortedSetMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = SynchronizedPutTreeSortedSetMultimapTest::putAll;
            this.payloads.putAllPairs = SynchronizedPutTreeSortedSetMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = SynchronizedPutTreeSortedSetMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = SynchronizedPutTreeSortedSetMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = SynchronizedPutTreeSortedSetMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = SynchronizedPutTreeSortedSetMultimapTest::removeKey;
            this.payloads.containsValue = SynchronizedPutTreeSortedSetMultimapTest::containsValue;
            this.payloads.put_createCollection = SynchronizedPutTreeSortedSetMultimapTest::put_createCollection;
            this.payloads.remove = SynchronizedPutTreeSortedSetMultimapTest::remove;
            this.payloads.replaceValues = SynchronizedPutTreeSortedSetMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = SynchronizedPutTreeSortedSetMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = SynchronizedPutTreeSortedSetMultimapTest::toMap;
            this.payloads.toImmutable = SynchronizedPutTreeSortedSetMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = SynchronizedPutTreeSortedSetMultimapTest::toMapWithTarget;
            this.payloads.toMutable = SynchronizedPutTreeSortedSetMultimapTest::toMutable;
            this.payloads.flip = SynchronizedPutTreeSortedSetMultimapTest::flip;
            this.payloads.serialization = SynchronizedPutTreeSortedSetMultimapTest::serialization;
            this.payloads.selectKeysValues = SynchronizedPutTreeSortedSetMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = SynchronizedPutTreeSortedSetMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = SynchronizedPutTreeSortedSetMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = SynchronizedPutTreeSortedSetMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = SynchronizedPutTreeSortedSetMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = SynchronizedPutTreeSortedSetMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = SynchronizedPutTreeSortedSetMultimapTest::collectValues;
            this.payloads.testToString = SynchronizedPutTreeSortedSetMultimapTest::testToString;
        }
    }
}
