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

public class HashBiMapValuesTest extends AbstractMutableBiMapValuesTestCase {

    @Override
    public MutableBiMap<Float, String> newMapWithKeysValues(float key1, String value1, float key2, String value2) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public HashBiMap<Float, Integer> newMapWithKeysValues(float key1, Integer value1, float key2, Integer value2, float key3, Integer value3) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public HashBiMap<Float, Integer> newMapWithKeysValues(float key1, Integer value1, float key2, Integer value2, float key3, Integer value3, float key4, Integer value4) {
        return HashBiMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public HashBiMapValuesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeNullFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeNullFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllFromValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllFromValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesToArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesToArray);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapValuesTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapValuesTest> valuesToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapValuesTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = HashBiMapValuesTest::clear;
            this.payloads.contains = HashBiMapValuesTest::contains;
            this.payloads.containsAll = HashBiMapValuesTest::containsAll;
            this.payloads.isEmpty = HashBiMapValuesTest::isEmpty;
            this.payloads.size = HashBiMapValuesTest::size;
            this.payloads.iterator = HashBiMapValuesTest::iterator;
            this.payloads.values = HashBiMapValuesTest::values;
            this.payloads.removeFromValues = HashBiMapValuesTest::removeFromValues;
            this.payloads.removeNullFromValues = HashBiMapValuesTest::removeNullFromValues;
            this.payloads.removeAllFromValues = HashBiMapValuesTest::removeAllFromValues;
            this.payloads.retainAllFromValues = HashBiMapValuesTest::retainAllFromValues;
            this.payloads.valuesToArray = HashBiMapValuesTest::valuesToArray;
        }
    }
}
