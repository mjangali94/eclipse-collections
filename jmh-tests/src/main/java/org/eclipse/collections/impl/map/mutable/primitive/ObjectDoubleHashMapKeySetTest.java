/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;

/**
 * JUnit test for {@link ObjectDoubleHashMap#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeySetTest.stg.
 */
public class ObjectDoubleHashMapKeySetTest extends ObjectDoubleHashMapKeySetTestCase {

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3, String key4, double value4) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectDoubleMap<String> newEmptyMap() {
        return ObjectDoubleHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectDoubleHashMapKeySetTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectDoubleHashMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapKeySetTest> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = ObjectDoubleHashMapKeySetTest::contains;
            this.payloads.containsAll = ObjectDoubleHashMapKeySetTest::containsAll;
            this.payloads.isEmpty = ObjectDoubleHashMapKeySetTest::isEmpty;
            this.payloads.size = ObjectDoubleHashMapKeySetTest::size;
            this.payloads.iterator = ObjectDoubleHashMapKeySetTest::iterator;
            this.payloads.removeFromKeySet = ObjectDoubleHashMapKeySetTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ObjectDoubleHashMapKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ObjectDoubleHashMapKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ObjectDoubleHashMapKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ObjectDoubleHashMapKeySetTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = ObjectDoubleHashMapKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ObjectDoubleHashMapKeySetTest::keySetToArray;
        }
    }
}
