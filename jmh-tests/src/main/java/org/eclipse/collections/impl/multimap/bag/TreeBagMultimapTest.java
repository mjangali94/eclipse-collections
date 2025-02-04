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

import java.util.Collections;
import java.util.Comparator;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.multimap.sortedbag.MutableSortedBagMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link TreeBagMultimap}.
 *
 * @deprecated in 6.0
 */
@Deprecated
public class TreeBagMultimapTest extends org.eclipse.collections.impl.multimap.bag.sorted.TreeBagMultimapTest {

    @Override
    protected <K, V> MutableSortedBagMultimap<K, V> newMultimap(Comparator<V> comparator) {
        return TreeBagMultimap.newMultimap(comparator);
    }

    @Override
    public <K, V> MutableSortedBagMultimap<K, V> newMultimap() {
        return TreeBagMultimap.newMultimap();
    }

    @SafeVarargs
    @Override
    public final <K, V> TreeBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return TreeBagMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> MutableSortedBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        MutableSortedBagMultimap<K, V> mutableMultimap = this.newMultimap();
        Iterate.forEach(inputIterable, mutableMultimap::add);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    protected final <V> TreeBag<V> createCollection(V... args) {
        return TreeBag.newBagWith(args);
    }

    @Override
    @Test
    public void testEmptyConstructor() {
        MutableSortedBagMultimap<Integer, Integer> map = TreeBagMultimap.newMultimap();
        for (int i = 1; i < 6; ++i) {
            for (int j = 1; j < i + 1; ++j) {
                map.put(i, j);
            }
        }
        Verify.assertSize(5, map.keysView().toList());
        for (int i = 1; i < 6; ++i) {
            Verify.assertSortedBagsEqual(TreeBag.newBag(Interval.oneTo(i)), map.get(i));
        }
    }

    @Override
    @Test
    public void testComparatorConstructors() {
        MutableSortedBagMultimap<Boolean, Integer> revMap = TreeBagMultimap.newMultimap(Collections.reverseOrder());
        for (int i = 1; i < 10; ++i) {
            revMap.put(IntegerPredicates.isOdd().accept(i), i);
        }
        Verify.assertSize(2, revMap.keysView().toList());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 9, 7, 5, 3, 1), revMap.get(Boolean.TRUE));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 8, 6, 4, 2), revMap.get(Boolean.FALSE));
        MutableSortedBagMultimap<Boolean, Integer> revMap2 = TreeBagMultimap.newMultimap(revMap);
        Verify.assertMapsEqual(revMap2.toMap(), revMap.toMap());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 9, 7, 5, 3, 1), revMap2.get(Boolean.TRUE));
    }

    @Override
    @Test
    public void testCollection() {
        TreeBagMultimap<Integer, Integer> bagMultimap = TreeBagMultimap.newMultimap(Collections.reverseOrder());
        MutableSortedBag<Integer> collection = bagMultimap.createCollection();
        collection.addAll(FastList.newListWith(1, 4, 2, 3, 5, 5));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 5, 5, 4, 3, 2, 1), collection);
        bagMultimap.putAll(1, collection);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 5, 5, 4, 3, 2, 1), collection);
        bagMultimap.put(1, 0);
        Assert.assertEquals(Integer.valueOf(0), bagMultimap.get(1).getLast());
        bagMultimap.putAll(2, FastList.newListWith(0, 1, 2, 3, 4, 5, 5));
        Verify.assertSortedBagsEqual(bagMultimap.get(1), bagMultimap.get(2));
    }

    @Override
    @Test
    public void testNewEmpty() {
        TreeBagMultimap<Object, Integer> expected = TreeBagMultimap.newMultimap(Collections.reverseOrder());
        TreeBagMultimap<Object, Integer> actual = expected.newEmpty();
        expected.putAll(1, FastList.newListWith(4, 3, 1, 2));
        expected.putAll(2, FastList.newListWith(5, 7, 6, 8));
        actual.putAll(1, FastList.newListWith(4, 3, 1, 2));
        actual.putAll(2, FastList.newListWith(5, 7, 6, 8));
        Verify.assertMapsEqual(expected.toMap(), actual.toMap());
        Verify.assertSortedBagsEqual(expected.get(1), actual.get(1));
        Verify.assertSortedBagsEqual(expected.get(2), actual.get(2));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TreeBagMultimapTest instance;

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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_testEmptyConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEmptyConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testComparatorConstructors() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testComparatorConstructors);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new TreeBagMultimapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testEmptyConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testComparatorConstructors;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagMultimapTest> testNewEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = TreeBagMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = TreeBagMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = TreeBagMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = TreeBagMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = TreeBagMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = TreeBagMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = TreeBagMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = TreeBagMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = TreeBagMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = TreeBagMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = TreeBagMultimapTest::forEachValue;
            this.payloads.valuesView = TreeBagMultimapTest::valuesView;
            this.payloads.multiValuesView = TreeBagMultimapTest::multiValuesView;
            this.payloads.notEmpty = TreeBagMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = TreeBagMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = TreeBagMultimapTest::keyValuePairsView;
            this.payloads.keyBag = TreeBagMultimapTest::keyBag;
            this.payloads.testEquals = TreeBagMultimapTest::testEquals;
            this.payloads.testHashCode = TreeBagMultimapTest::testHashCode;
            this.payloads.newEmpty = TreeBagMultimapTest::newEmpty;
            this.payloads.keysView = TreeBagMultimapTest::keysView;
            this.payloads.keySet = TreeBagMultimapTest::keySet;
            this.payloads.sizeDistinct = TreeBagMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = TreeBagMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = TreeBagMultimapTest::addAndGrowMultimap;
            this.payloads.removeObject = TreeBagMultimapTest::removeObject;
            this.payloads.forEachKey = TreeBagMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = TreeBagMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = TreeBagMultimapTest::putAll;
            this.payloads.putAllPairs = TreeBagMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = TreeBagMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = TreeBagMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = TreeBagMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = TreeBagMultimapTest::removeKey;
            this.payloads.containsValue = TreeBagMultimapTest::containsValue;
            this.payloads.put_createCollection = TreeBagMultimapTest::put_createCollection;
            this.payloads.remove = TreeBagMultimapTest::remove;
            this.payloads.replaceValues = TreeBagMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = TreeBagMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = TreeBagMultimapTest::toMap;
            this.payloads.toImmutable = TreeBagMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = TreeBagMultimapTest::toMapWithTarget;
            this.payloads.toMutable = TreeBagMultimapTest::toMutable;
            this.payloads.testToString = TreeBagMultimapTest::testToString;
            this.payloads.flip = TreeBagMultimapTest::flip;
            this.payloads.serialization = TreeBagMultimapTest::serialization;
            this.payloads.clear = TreeBagMultimapTest::clear;
            this.payloads.selectKeysValues = TreeBagMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = TreeBagMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = TreeBagMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = TreeBagMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = TreeBagMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = TreeBagMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = TreeBagMultimapTest::collectValues;
            this.payloads.testEmptyConstructor = TreeBagMultimapTest::testEmptyConstructor;
            this.payloads.testComparatorConstructors = TreeBagMultimapTest::testComparatorConstructors;
            this.payloads.testCollection = TreeBagMultimapTest::testCollection;
            this.payloads.testNewEmpty = TreeBagMultimapTest::testNewEmpty;
        }
    }
*/
}
