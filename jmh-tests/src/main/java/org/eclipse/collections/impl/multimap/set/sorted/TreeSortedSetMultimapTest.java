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

import java.util.Collections;
import java.util.Comparator;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.multimap.sortedset.MutableSortedSetMultimap;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.set.UnifiedSetMultimap;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link TreeSortedSetMultimap}.
 */
public class TreeSortedSetMultimapTest extends AbstractMutableSortedSetMultimapTestCase {

    public <K, V> MutableSortedSetMultimap<K, V> newMultimap(Comparator<? super V> comparator) {
        return TreeSortedSetMultimap.newMultimap(comparator);
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimap() {
        return TreeSortedSetMultimap.newMultimap();
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        return this.<K, V>newMultimap().withKeyValue(key, value);
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2);
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3);
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return this.<K, V>newMultimap().withKeyValue(key1, value1).withKeyValue(key2, value2).withKeyValue(key3, value3).withKeyValue(key4, value4);
    }

    @SafeVarargs
    @Override
    public final <K, V> MutableSortedSetMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return TreeSortedSetMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return TreeSortedSetMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> TreeSortedSet<V> createCollection(V... args) {
        return TreeSortedSet.newSetWith(args);
    }

    @Test
    public void testEmptyConstructor() {
        MutableSortedSetMultimap<Integer, Integer> map = TreeSortedSetMultimap.newMultimap();
        for (int i = 1; i < 6; ++i) {
            for (int j = 1; j < i + 1; ++j) {
                map.put(i, j);
            }
        }
        Verify.assertSize(5, map.keysView().toList());
        for (int i = 1; i < 6; ++i) {
            Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Interval.oneTo(i)), map.get(i));
        }
    }

    @Test
    public void testComparatorConstructors() {
        MutableSortedSetMultimap<Boolean, Integer> revMap = TreeSortedSetMultimap.newMultimap(Collections.reverseOrder());
        for (int i = 1; i < 10; ++i) {
            revMap.put(IntegerPredicates.isOdd().accept(i), i);
        }
        Verify.assertSize(2, revMap.keysView().toList());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 9, 7, 5, 3, 1), revMap.get(Boolean.TRUE));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 8, 6, 4, 2), revMap.get(Boolean.FALSE));
        MutableSortedSetMultimap<Boolean, Integer> revMap2 = TreeSortedSetMultimap.newMultimap(revMap);
        Verify.assertMapsEqual(revMap2.toMap(), revMap.toMap());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 9, 7, 5, 3, 1), revMap2.get(Boolean.TRUE));
    }

    @Test
    public void testMultimapConstructor() {
        MutableSetMultimap<Integer, Integer> map = UnifiedSetMultimap.newMultimap();
        TreeSortedSetMultimap<Integer, Integer> map2 = TreeSortedSetMultimap.newMultimap();
        for (int i = 1; i < 6; ++i) {
            map.putAll(i, Interval.oneTo(i));
            map2.putAll(i, Interval.oneTo(i));
        }
        TreeSortedSetMultimap<Integer, Integer> sortedMap = TreeSortedSetMultimap.newMultimap(map);
        TreeSortedSetMultimap<Integer, Integer> sortedMap2 = TreeSortedSetMultimap.newMultimap(map2);
        for (int i = 1; i < 6; ++i) {
            Verify.assertSortedSetsEqual(map.get(i).toSortedSet(), sortedMap.get(i));
            Verify.assertSortedSetsEqual(map.get(i).toSortedSet(), sortedMap2.get(i));
        }
    }

    @Test
    public void testCollection() {
        TreeSortedSetMultimap<Integer, Integer> setMultimap = TreeSortedSetMultimap.newMultimap(Collections.reverseOrder());
        MutableSortedSet<Integer> collection = setMultimap.createCollection();
        collection.addAll(FastList.newListWith(1, 4, 2, 3, 5));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 5, 4, 3, 2, 1), collection);
        setMultimap.putAll(1, collection);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 5, 4, 3, 2, 1), collection);
        setMultimap.put(1, 0);
        Assert.assertEquals(Integer.valueOf(0), setMultimap.get(1).getLast());
        setMultimap.putAll(2, FastList.newListWith(0, 1, 2, 4, 2, 1, 4, 5, 3, 4, 5));
        Verify.assertSortedSetsEqual(setMultimap.get(1), setMultimap.get(2));
    }

    @Test
    public void testNewEmpty() {
        TreeSortedSetMultimap<Object, Integer> expected = TreeSortedSetMultimap.newMultimap(Collections.reverseOrder());
        TreeSortedSetMultimap<Object, Integer> actual = expected.newEmpty();
        expected.putAll(1, FastList.newListWith(4, 3, 1, 2));
        expected.putAll(2, FastList.newListWith(5, 7, 6, 8));
        actual.putAll(1, FastList.newListWith(4, 3, 1, 2));
        actual.putAll(2, FastList.newListWith(5, 7, 6, 8));
        Verify.assertMapsEqual(expected.toMap(), actual.toMap());
        Verify.assertSortedSetsEqual(expected.get(1), actual.get(1));
        Verify.assertSortedSetsEqual(expected.get(2), actual.get(2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public TreeSortedSetMultimapTest instance;

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
        public void benchmark_testMultimapConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testMultimapConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> payload) throws java.lang.Throwable {
            this.instance = new TreeSortedSetMultimapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testNewMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testNewMultimapWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testNewMultimapWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testNewMultimapWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testNewMultimapWithWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testNewMultimapWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> newMultimapFromPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> forEachKeyMultiValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> multiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> keysWithMultiValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> keyValuePairsView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> keyBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> putAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> addAndGrowMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> withKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> withKeyMultiValuesNullValueHandling;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> putAllPairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> putAllFromCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> putAllFromIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> getIfAbsentPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> put_createCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> replaceValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> replaceValues_absent_key;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> toMapWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> toMutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> selectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> rejectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> selectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> rejectKeysMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> collectKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> collectKeyMultiValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testEmptyConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testComparatorConstructors;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testMultimapConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeSortedSetMultimapTest> testNewEmpty;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewMultimap = TreeSortedSetMultimapTest::testNewMultimap;
            this.payloads.testNewMultimapWithKeyValue = TreeSortedSetMultimapTest::testNewMultimapWithKeyValue;
            this.payloads.testNewMultimapWithWith = TreeSortedSetMultimapTest::testNewMultimapWithWith;
            this.payloads.testNewMultimapWithWithWith = TreeSortedSetMultimapTest::testNewMultimapWithWithWith;
            this.payloads.testNewMultimapWithWithWithWith = TreeSortedSetMultimapTest::testNewMultimapWithWithWithWith;
            this.payloads.testNewMultimapWith = TreeSortedSetMultimapTest::testNewMultimapWith;
            this.payloads.newMultimapFromPairs = TreeSortedSetMultimapTest::newMultimapFromPairs;
            this.payloads.isEmpty = TreeSortedSetMultimapTest::isEmpty;
            this.payloads.forEachKeyValue = TreeSortedSetMultimapTest::forEachKeyValue;
            this.payloads.forEachKeyMultiValue = TreeSortedSetMultimapTest::forEachKeyMultiValue;
            this.payloads.forEachValue = TreeSortedSetMultimapTest::forEachValue;
            this.payloads.valuesView = TreeSortedSetMultimapTest::valuesView;
            this.payloads.multiValuesView = TreeSortedSetMultimapTest::multiValuesView;
            this.payloads.notEmpty = TreeSortedSetMultimapTest::notEmpty;
            this.payloads.keysWithMultiValuesView = TreeSortedSetMultimapTest::keysWithMultiValuesView;
            this.payloads.keyValuePairsView = TreeSortedSetMultimapTest::keyValuePairsView;
            this.payloads.keyBag = TreeSortedSetMultimapTest::keyBag;
            this.payloads.testEquals = TreeSortedSetMultimapTest::testEquals;
            this.payloads.testHashCode = TreeSortedSetMultimapTest::testHashCode;
            this.payloads.newEmpty = TreeSortedSetMultimapTest::newEmpty;
            this.payloads.keysView = TreeSortedSetMultimapTest::keysView;
            this.payloads.keySet = TreeSortedSetMultimapTest::keySet;
            this.payloads.sizeDistinct = TreeSortedSetMultimapTest::sizeDistinct;
            this.payloads.putAndGrowMultimap = TreeSortedSetMultimapTest::putAndGrowMultimap;
            this.payloads.addAndGrowMultimap = TreeSortedSetMultimapTest::addAndGrowMultimap;
            this.payloads.clear = TreeSortedSetMultimapTest::clear;
            this.payloads.removeObject = TreeSortedSetMultimapTest::removeObject;
            this.payloads.forEachKey = TreeSortedSetMultimapTest::forEachKey;
            this.payloads.withKeyMultiValues = TreeSortedSetMultimapTest::withKeyMultiValues;
            this.payloads.withKeyMultiValuesNullValueHandling = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeSortedSetMultimapTest::withKeyMultiValuesNullValueHandling, java.lang.NullPointerException.class);
            this.payloads.putAll = TreeSortedSetMultimapTest::putAll;
            this.payloads.putAllPairs = TreeSortedSetMultimapTest::putAllPairs;
            this.payloads.putAllFromCollection = TreeSortedSetMultimapTest::putAllFromCollection;
            this.payloads.putAllFromIterable = TreeSortedSetMultimapTest::putAllFromIterable;
            this.payloads.getIfAbsentPutAll = TreeSortedSetMultimapTest::getIfAbsentPutAll;
            this.payloads.removeKey = TreeSortedSetMultimapTest::removeKey;
            this.payloads.containsValue = TreeSortedSetMultimapTest::containsValue;
            this.payloads.put_createCollection = TreeSortedSetMultimapTest::put_createCollection;
            this.payloads.remove = TreeSortedSetMultimapTest::remove;
            this.payloads.replaceValues = TreeSortedSetMultimapTest::replaceValues;
            this.payloads.replaceValues_absent_key = TreeSortedSetMultimapTest::replaceValues_absent_key;
            this.payloads.toMap = TreeSortedSetMultimapTest::toMap;
            this.payloads.toImmutable = TreeSortedSetMultimapTest::toImmutable;
            this.payloads.toMapWithTarget = TreeSortedSetMultimapTest::toMapWithTarget;
            this.payloads.toMutable = TreeSortedSetMultimapTest::toMutable;
            this.payloads.testToString = TreeSortedSetMultimapTest::testToString;
            this.payloads.flip = TreeSortedSetMultimapTest::flip;
            this.payloads.serialization = TreeSortedSetMultimapTest::serialization;
            this.payloads.selectKeysValues = TreeSortedSetMultimapTest::selectKeysValues;
            this.payloads.rejectKeysValues = TreeSortedSetMultimapTest::rejectKeysValues;
            this.payloads.selectKeysMultiValues = TreeSortedSetMultimapTest::selectKeysMultiValues;
            this.payloads.rejectKeysMultiValues = TreeSortedSetMultimapTest::rejectKeysMultiValues;
            this.payloads.collectKeysValues = TreeSortedSetMultimapTest::collectKeysValues;
            this.payloads.collectKeyMultiValues = TreeSortedSetMultimapTest::collectKeyMultiValues;
            this.payloads.collectValues = TreeSortedSetMultimapTest::collectValues;
            this.payloads.testEmptyConstructor = TreeSortedSetMultimapTest::testEmptyConstructor;
            this.payloads.testComparatorConstructors = TreeSortedSetMultimapTest::testComparatorConstructors;
            this.payloads.testMultimapConstructor = TreeSortedSetMultimapTest::testMultimapConstructor;
            this.payloads.testCollection = TreeSortedSetMultimapTest::testCollection;
            this.payloads.testNewEmpty = TreeSortedSetMultimapTest::testNewEmpty;
        }
    }
}
