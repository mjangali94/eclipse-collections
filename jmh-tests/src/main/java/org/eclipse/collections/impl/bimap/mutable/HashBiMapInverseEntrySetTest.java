/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.mutable;

import org.eclipse.collections.api.bimap.MutableBiMap;

public class HashBiMapInverseEntrySetTest extends AbstractMutableBiMapEntrySetTest {

    @Override
    protected <K, V> MutableBiMap<K, V> newMap() {
        return HashBiMap.<V, K>newMap().inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2).inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3).inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3, value4, key4).inverse();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return HashBiMap.newWithKeysValues(value, key).inverse();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private HashBiMapInverseEntrySetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_Iterator_incrementPastEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_Iterator_incrementPastEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_hashCodeForNullKeyAndValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_hashCodeForNullKeyAndValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equalsWithNonEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equalsWithNonEntry);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_toString);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapInverseEntrySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_setValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_setValue_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entrySet_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entrySet_contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entrySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entrySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entrySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entrySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entrySet_Iterator_incrementPastEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_hashCodeForNullKeyAndValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_equalsWithNonEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseEntrySetTest> entry_toString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.entry_clear = HashBiMapInverseEntrySetTest::entry_clear;
            this.payloads.entry_isEmpty = HashBiMapInverseEntrySetTest::entry_isEmpty;
            this.payloads.entry_toArray = HashBiMapInverseEntrySetTest::entry_toArray;
            this.payloads.entry_setValue = HashBiMapInverseEntrySetTest::entry_setValue;
            this.payloads.entry_setValue_throws = HashBiMapInverseEntrySetTest::entry_setValue_throws;
            this.payloads.entrySet_remove = HashBiMapInverseEntrySetTest::entrySet_remove;
            this.payloads.entrySet_contains = HashBiMapInverseEntrySetTest::entrySet_contains;
            this.payloads.entrySet_containsAll = HashBiMapInverseEntrySetTest::entrySet_containsAll;
            this.payloads.entrySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseEntrySetTest::entrySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseEntrySetTest::entrySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_equals = HashBiMapInverseEntrySetTest::entrySet_equals;
            this.payloads.entrySet_Iterator_incrementPastEnd = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseEntrySetTest::entrySet_Iterator_incrementPastEnd, java.util.NoSuchElementException.class);
            this.payloads.entry_hashCodeForNullKeyAndValue = HashBiMapInverseEntrySetTest::entry_hashCodeForNullKeyAndValue;
            this.payloads.entry_equals = HashBiMapInverseEntrySetTest::entry_equals;
            this.payloads.entry_equalsWithNonEntry = HashBiMapInverseEntrySetTest::entry_equalsWithNonEntry;
            this.payloads.entry_toString = HashBiMapInverseEntrySetTest::entry_toString;
        }
    }
}
