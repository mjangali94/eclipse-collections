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

import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;

/**
 * JUnit test for {@link ObjectFloatHashMap#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeySetTest.stg.
 */
public class ObjectFloatHashMapKeySetTest extends ObjectFloatHashMapKeySetTestCase {

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3, String key4, float value4) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectFloatMap<String> newEmptyMap() {
        return ObjectFloatHashMap.newMap();
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectFloatHashMapKeySetTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clearKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clearKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySetToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySetToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatHashMapKeySetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> removeFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> removeNullFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> removeAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> retainAllFromKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> clearKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> keySetEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapKeySetTest> keySetToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapKeySetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapKeySetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = ObjectFloatHashMapKeySetTest::contains;
            this.payloads.containsAll = ObjectFloatHashMapKeySetTest::containsAll;
            this.payloads.isEmpty = ObjectFloatHashMapKeySetTest::isEmpty;
            this.payloads.size = ObjectFloatHashMapKeySetTest::size;
            this.payloads.iterator = ObjectFloatHashMapKeySetTest::iterator;
            this.payloads.removeFromKeySet = ObjectFloatHashMapKeySetTest::removeFromKeySet;
            this.payloads.removeNullFromKeySet = ObjectFloatHashMapKeySetTest::removeNullFromKeySet;
            this.payloads.removeAllFromKeySet = ObjectFloatHashMapKeySetTest::removeAllFromKeySet;
            this.payloads.retainAllFromKeySet = ObjectFloatHashMapKeySetTest::retainAllFromKeySet;
            this.payloads.clearKeySet = ObjectFloatHashMapKeySetTest::clearKeySet;
            this.payloads.keySetEqualsAndHashCode = ObjectFloatHashMapKeySetTest::keySetEqualsAndHashCode;
            this.payloads.keySetToArray = ObjectFloatHashMapKeySetTest::keySetToArray;
        }
    }
*/
}
