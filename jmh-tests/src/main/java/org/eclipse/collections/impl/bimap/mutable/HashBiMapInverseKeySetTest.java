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

public class HashBiMapInverseKeySetTest extends AbstractMutableBiMapKeySetTestCase {

    @Override
    protected MutableBiMap<String, Integer> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3).inverse();
    }

    @Override
    protected MutableBiMap<String, Integer> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3, String key4, int value4) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3, value4, key4).inverse();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public HashBiMapInverseKeySetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapInverseKeySetTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseKeySetTest> serialization;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = HashBiMapInverseKeySetTest::contains;
            this.payloads.containsAll = HashBiMapInverseKeySetTest::containsAll;
            this.payloads.isEmpty = HashBiMapInverseKeySetTest::isEmpty;
            this.payloads.size = HashBiMapInverseKeySetTest::size;
            this.payloads.iterator = HashBiMapInverseKeySetTest::iterator;
            this.payloads.removeFromKeySet = HashBiMapInverseKeySetTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = HashBiMapInverseKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = HashBiMapInverseKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = HashBiMapInverseKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = HashBiMapInverseKeySetTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = HashBiMapInverseKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = HashBiMapInverseKeySetTest::keySetToArray;
            this.payloads.serialization = HashBiMapInverseKeySetTest::serialization;
        }
    }
}
