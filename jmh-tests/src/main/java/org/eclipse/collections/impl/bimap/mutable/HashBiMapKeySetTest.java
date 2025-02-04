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

public class HashBiMapKeySetTest extends AbstractMutableBiMapKeySetTestCase {

    @Override
    public HashBiMap<String, Integer> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public HashBiMap<String, Integer> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3, String key4, int value4) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private HashBiMapKeySetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> keySetToArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapKeySetTest> serialization;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = HashBiMapKeySetTest::contains;
            this.payloads.containsAll = HashBiMapKeySetTest::containsAll;
            this.payloads.isEmpty = HashBiMapKeySetTest::isEmpty;
            this.payloads.size = HashBiMapKeySetTest::size;
            this.payloads.iterator = HashBiMapKeySetTest::iterator;
            this.payloads.removeFromKeySet = HashBiMapKeySetTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = HashBiMapKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = HashBiMapKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = HashBiMapKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = HashBiMapKeySetTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = HashBiMapKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = HashBiMapKeySetTest::keySetToArray;
            this.payloads.serialization = HashBiMapKeySetTest::serialization;
        }
    }
}
