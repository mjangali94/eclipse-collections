/*
 * Copyright (c) 2016 Bhavana Hindupur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.mutable;

import org.eclipse.collections.api.bimap.MutableBiMap;

/**
 * JUnit test for {@link SynchronizedBiMap}.
 */
public class SynchronizedBiMapTest extends AbstractMutableBiMapTestCase {

    @Override
    public MutableBiMap<Integer, Character> classUnderTest() {
        HashBiMap<Integer, Character> map = HashBiMap.newMap();
        map.put(1, null);
        map.put(null, 'b');
        map.put(3, 'c');
        return new SynchronizedBiMap<>(map);
    }

    @Override
    public MutableBiMap<Integer, Character> getEmptyMap() {
        return new SynchronizedBiMap<>(HashBiMap.newMap());
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMap() {
        return new SynchronizedBiMap<>(HashBiMap.newMap());
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key, value));
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        HashBiMap<K, V> map = HashBiMap.newWithKeysValues(key1, value1, key2, value2);
        return new SynchronizedBiMap<>(map);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new SynchronizedBiMap<>(HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private SynchronizedBiMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedBiMapTest();
        }

        @java.lang.Override
        public SynchronizedBiMapTest implementation() {
            return this.implementation;
        }
    }
}
