/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.bag;

import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of {@link SynchronizedPutHashBagMultimap}.
 */
public class SynchronizedPutHashBagMultimapTest extends AbstractMutableBagMultimapTestCase {

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimap() {
        return SynchronizedPutHashBagMultimap.newMultimap();
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        SynchronizedPutHashBagMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @SafeVarargs
    @Override
    public final <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return SynchronizedPutHashBagMultimap.newMultimap(pairs);
    }

    @Override
    protected <K, V> SynchronizedPutHashBagMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return SynchronizedPutHashBagMultimap.newMultimap(inputIterable);
    }

    @SafeVarargs
    @Override
    protected final <V> HashBag<V> createCollection(V... args) {
        return HashBag.newBagWith(args);
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
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        private SynchronizedPutHashBagMultimapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedPutHashBagMultimapTest();
        }

        @java.lang.Override
        public SynchronizedPutHashBagMultimapTest implementation() {
            return this.implementation;
        }
    }
}
