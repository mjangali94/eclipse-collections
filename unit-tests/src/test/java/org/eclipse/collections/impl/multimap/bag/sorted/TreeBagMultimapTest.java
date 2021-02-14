/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag.sorted;

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
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link TreeBagMultimap}.
 *
 * @deprecated in 7.0
 */
@Deprecated
public class TreeBagMultimapTest extends AbstractMutableSortedBagMultimapTestCase {

    @Override
    protected <K, V> MutableSortedBagMultimap<K, V> newMultimap(Comparator<V> comparator) {
        return TreeBagMultimap.newMultimap(comparator);
    }

    @Override
    public <K, V> MutableSortedBagMultimap<K, V> newMultimap() {
        return TreeBagMultimap.newMultimap();
    }

    @Override
    public <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        MutableSortedBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        MutableSortedBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        MutableSortedBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        MutableSortedBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return TreeBagMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> MutableSortedBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return TreeBagMultimap.newMultimap(inputIterable);
    }

    @Override
    protected <V> TreeBag<V> createCollection(V... args) {
        return TreeBag.newBagWith(args);
    }

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

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEmptyConstructor() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEmptyConstructor, this.description("testEmptyConstructor"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testComparatorConstructors() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testComparatorConstructors, this.description("testComparatorConstructors"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testCollection, this.description("testCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewEmpty, this.description("testNewEmpty"));
        }

        private TreeBagMultimapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TreeBagMultimapTest();
        }

        @java.lang.Override
        public TreeBagMultimapTest implementation() {
            return this.implementation;
        }
    }
}
