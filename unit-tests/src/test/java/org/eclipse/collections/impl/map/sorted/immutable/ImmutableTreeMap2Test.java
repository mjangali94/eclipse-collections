/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.immutable;

import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.impl.map.MapIterableTestCase;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;

public class ImmutableTreeMap2Test extends MapIterableTestCase {

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMap() {
        return new ImmutableTreeMap<>(TreeSortedMap.newMap());
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeyValue(K key1, V value1) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1));
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2));
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <K, V> ImmutableSortedMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableTreeMap<>(TreeSortedMap.newMapWith(key1, value1, key2, value2, key3, value3, key4, value4));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private ImmutableTreeMap2Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableTreeMap2Test();
        }

        @java.lang.Override
        public ImmutableTreeMap2Test implementation() {
            return this.implementation;
        }
    }
}
