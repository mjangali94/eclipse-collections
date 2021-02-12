/*
 * Copyright (c) 2016 Shotaro Sano.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.multimap.set.sorted;

import java.util.Comparator;
import org.eclipse.collections.api.multimap.sortedset.MutableSortedSetMultimap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

public class SynchronizedSortedSetMultimapTest extends AbstractMutableSortedSetMultimapTestCase {

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimap(Comparator<? super V> comparator) {
        return new SynchronizedSortedSetMultimap<>(TreeSortedSetMultimap.newMultimap(comparator));
    }

    @Override
    protected <K, V> MutableSortedSetMultimap<K, V> newMultimap() {
        return new SynchronizedSortedSetMultimap<>(TreeSortedSetMultimap.newMultimap());
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeyValue(K key, V value) {
        MutableSortedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key, value);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2) {
        MutableSortedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        MutableSortedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        MutableSortedSetMultimap<K, V> mutableMultimap = this.newMultimap();
        mutableMultimap.put(key1, value1);
        mutableMultimap.put(key2, value2);
        mutableMultimap.put(key3, value3);
        mutableMultimap.put(key4, value4);
        return mutableMultimap;
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimap(Pair<K, V>... pairs) {
        return new SynchronizedSortedSetMultimap<>(TreeSortedSetMultimap.newMultimap(pairs));
    }

    @Override
    public <K, V> MutableSortedSetMultimap<K, V> newMultimapFromPairs(Iterable<Pair<K, V>> inputIterable) {
        return new SynchronizedSortedSetMultimap<>(TreeSortedSetMultimap.newMultimap(inputIterable));
    }

    @SafeVarargs
    @Override
    protected final <V> TreeSortedSet<V> createCollection(V... args) {
        return TreeSortedSet.newSetWith(args);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private SynchronizedSortedSetMultimapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedSortedSetMultimapTest();
        }

        @java.lang.Override
        public SynchronizedSortedSetMultimapTest implementation() {
            return this.implementation;
        }
    }
}
