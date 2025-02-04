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

public class HashBiMapEntrySetTest extends AbstractMutableBiMapEntrySetTest {

    @Override
    protected <K, V> MutableBiMap<K, V> newMap() {
        return HashBiMap.newMap();
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <K, V> MutableBiMap<K, V> newMapWithKeyValue(K key, V value) {
        return HashBiMap.newWithKeysValues(key, value);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private HashBiMapEntrySetTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_setValue_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_setValue_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_equals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet_Iterator_incrementPastEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet_Iterator_incrementPastEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_hashCodeForNullKeyAndValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_hashCodeForNullKeyAndValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_equalsWithNonEntry() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_equalsWithNonEntry);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entry_toString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entry_toString);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapEntrySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_setValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_setValue_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entrySet_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entrySet_contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entrySet_containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entrySet_add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entrySet_addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entrySet_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entrySet_Iterator_incrementPastEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_hashCodeForNullKeyAndValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_equals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_equalsWithNonEntry;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapEntrySetTest> entry_toString;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.entry_clear = HashBiMapEntrySetTest::entry_clear;
            this.payloads.entry_isEmpty = HashBiMapEntrySetTest::entry_isEmpty;
            this.payloads.entry_toArray = HashBiMapEntrySetTest::entry_toArray;
            this.payloads.entry_setValue = HashBiMapEntrySetTest::entry_setValue;
            this.payloads.entry_setValue_throws = HashBiMapEntrySetTest::entry_setValue_throws;
            this.payloads.entrySet_remove = HashBiMapEntrySetTest::entrySet_remove;
            this.payloads.entrySet_contains = HashBiMapEntrySetTest::entrySet_contains;
            this.payloads.entrySet_containsAll = HashBiMapEntrySetTest::entrySet_containsAll;
            this.payloads.entrySet_add = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapEntrySetTest::entrySet_add, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapEntrySetTest::entrySet_addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.entrySet_equals = HashBiMapEntrySetTest::entrySet_equals;
            this.payloads.entrySet_Iterator_incrementPastEnd = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapEntrySetTest::entrySet_Iterator_incrementPastEnd, java.util.NoSuchElementException.class);
            this.payloads.entry_hashCodeForNullKeyAndValue = HashBiMapEntrySetTest::entry_hashCodeForNullKeyAndValue;
            this.payloads.entry_equals = HashBiMapEntrySetTest::entry_equals;
            this.payloads.entry_equalsWithNonEntry = HashBiMapEntrySetTest::entry_equalsWithNonEntry;
            this.payloads.entry_toString = HashBiMapEntrySetTest::entry_toString;
        }
    }
*/
}
