/*
 * Copyright (c) 2016 Shotaro Sano.
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
import org.eclipse.collections.impl.bag.mutable.HashBag;

public class SynchronizedBagMultimapTest extends AbstractMutableBagMultimapTestCase {

    @Override
    public <K, V> MutableBagMultimap<K, V> newMultimap() {
        return new SynchronizedBagMultimap<>(HashBagMultimap.newMultimap());
    }

    @Override
    public <K, V> MutableBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        MutableBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return new SynchronizedBagMultimap<>(HashBagMultimap.newMultimap(pairs));
    }

    @Override
    public <K, V> MutableBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return new SynchronizedBagMultimap<>(HashBagMultimap.newMultimap(inputIterable));
    }

    @SafeVarargs
    @Override
    protected final <V> MutableBag<V> createCollection(V... args) {
        return HashBag.newBagWith(args);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private SynchronizedBagMultimapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedBagMultimapTest();
        }

        @java.lang.Override
        public SynchronizedBagMultimapTest implementation() {
            return this.implementation;
        }
    }
}
