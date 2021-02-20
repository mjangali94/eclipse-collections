/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Bags;

/**
 * Test of {@link HashBagMultimap}.
 */
public class HashBagMultimapTest extends AbstractMutableBagMultimapTestCase {

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimap() {
        return HashBagMultimap.newMultimap();
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    protected final <K, V> MutableBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return HashBagMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> MutableBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return HashBagMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> MutableBag<V> createCollection(V... args) {
        return Bags.mutable.of(args);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private HashBagMultimapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new HashBagMultimapTest();
        }

        @java.lang.Override
        public HashBagMultimapTest implementation() {
            return this.implementation;
        }
    }
}
