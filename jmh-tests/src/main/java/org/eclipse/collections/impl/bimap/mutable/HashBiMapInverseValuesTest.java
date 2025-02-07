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

public class HashBiMapInverseValuesTest extends AbstractMutableBiMapValuesTestCase {

    @Override
    public MutableBiMap<Float, String> newMapWithKeysValues(float key1, String value1, float key2, String value2) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2).inverse();
    }

    @Override
    public MutableBiMap<Float, Integer> newMapWithKeysValues(float key1, Integer value1, float key2, Integer value2, float key3, Integer value3) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3).inverse();
    }

    @Override
    public MutableBiMap<Float, Integer> newMapWithKeysValues(float key1, Integer value1, float key2, Integer value2, float key3, Integer value3, float key4, Integer value4) {
        return HashBiMap.newWithKeysValues(value1, key1, value2, key2, value3, key3, value4, key4).inverse();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public HashBiMapInverseValuesTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> payload) throws java.lang.Throwable {
            this.instance = new HashBiMapInverseValuesTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> removeFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> removeNullFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> removeAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> retainAllFromValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<HashBiMapInverseValuesTest> valuesToArray;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(HashBiMapInverseValuesTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = HashBiMapInverseValuesTest::clear;
            this.payloads.contains = HashBiMapInverseValuesTest::contains;
            this.payloads.containsAll = HashBiMapInverseValuesTest::containsAll;
            this.payloads.isEmpty = HashBiMapInverseValuesTest::isEmpty;
            this.payloads.size = HashBiMapInverseValuesTest::size;
            this.payloads.iterator = HashBiMapInverseValuesTest::iterator;
            this.payloads.values = HashBiMapInverseValuesTest::values;
            this.payloads.removeFromValues = HashBiMapInverseValuesTest::removeFromValues;
            this.payloads.removeNullFromValues = HashBiMapInverseValuesTest::removeNullFromValues;
            this.payloads.removeAllFromValues = HashBiMapInverseValuesTest::removeAllFromValues;
            this.payloads.retainAllFromValues = HashBiMapInverseValuesTest::retainAllFromValues;
            this.payloads.valuesToArray = HashBiMapInverseValuesTest::valuesToArray;
        }
    }
}
