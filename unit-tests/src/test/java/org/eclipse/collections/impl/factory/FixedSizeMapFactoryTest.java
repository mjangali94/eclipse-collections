/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Key;
import org.junit.Assert;
import org.junit.Test;

public class FixedSizeMapFactoryTest {

    @Test
    public void create0() {
        MutableMap<String, String> map = Maps.fixedSize.of();
        Verify.assertEmpty(map);
    }

    @Test
    public void create1() {
        MutableMap<String, String> map1 = Maps.fixedSize.of("key1", "value1");
        Verify.assertSize(1, map1);
        Verify.assertContainsKeyValue("key1", "value1", map1);
        MutableMap<String, String> map2 = Maps.fixedSize.of(null, null);
        Verify.assertSize(1, map2);
        Verify.assertContainsKeyValue(null, null, map2);
        MutableMap<String, String> map3 = Maps.fixedSize.of(null, "value1");
        Verify.assertSize(1, map3);
        Verify.assertContainsKeyValue(null, "value1", map3);
    }

    @Test
    public void create2() {
        MutableMap<String, String> map1 = Maps.fixedSize.of("key1", "value1", "key2", "value2");
        Verify.assertSize(2, map1);
        Verify.assertContainsAllKeyValues(map1, "key1", "value1", "key2", "value2");
        MutableMap<String, String> map2 = Maps.fixedSize.of(null, "value1", "key2", "value2");
        Verify.assertSize(2, map2);
        Verify.assertContainsKeyValue(null, "value1", map2);
        Verify.assertContainsKeyValue("key2", "value2", map2);
    }

    @Test
    public void create3() {
        MutableMap<String, String> map1 = Maps.fixedSize.of("key1", "value1", "key2", "value2", "key3", "value3");
        Verify.assertSize(3, map1);
        Verify.assertContainsAllKeyValues(map1, "key1", "value1", "key2", "value2", "key3", "value3");
        MutableMap<String, String> map2 = Maps.fixedSize.of("key1", "value1", "key2", null, null, "value3");
        Verify.assertContainsKeyValue("key2", null, map2);
        Verify.assertContainsKeyValue(null, "value3", map2);
    }

    @Test
    public void createWithDuplicates() {
        MutableMap<String, String> map1 = Maps.fixedSize.of("k1", "v1", "k1", "v2");
        Verify.assertSize(1, map1);
        Verify.assertContainsKey("k1", map1);
        Verify.assertContainsKeyValue("k1", "v2", map1);
        MutableMap<String, String> map2 = Maps.fixedSize.of("k1", "v1", "k1", "v2", "k1", "v3");
        Verify.assertSize(1, map2);
        Verify.assertContainsKey("k1", map2);
        Verify.assertContainsKeyValue("k1", "v3", map2);
        MutableMap<String, String> map3 = Maps.fixedSize.of("k2", "v1", "k3", "v2", "k2", "v3");
        Verify.assertSize(2, map3);
        Verify.assertContainsKey("k2", map3);
        Verify.assertContainsKey("k3", map3);
        Verify.assertContainsKeyValue("k2", "v3", map3);
        MutableMap<String, String> map4 = Maps.fixedSize.of("k3", "v1", "k4", "v2", "k4", "v3");
        Verify.assertSize(2, map4);
        Verify.assertContainsKey("k3", map4);
        Verify.assertContainsKey("k4", map4);
        Verify.assertContainsKeyValue("k4", "v3", map4);
    }

    @Test
    public void keyPreservation() {
        Key key = new Key("key");
        Key duplicateKey1 = new Key("key");
        MutableMap<Key, Integer> map1 = Maps.fixedSize.of(key, 1, duplicateKey1, 2);
        Verify.assertSize(1, map1);
        Verify.assertContainsKeyValue(key, 2, map1);
        Assert.assertSame(key, map1.keysView().getFirst());
        Key duplicateKey2 = new Key("key");
        MutableMap<Key, Integer> map2 = Maps.fixedSize.of(key, 1, duplicateKey1, 2, duplicateKey2, 3);
        Verify.assertSize(1, map2);
        Verify.assertContainsKeyValue(key, 3, map2);
        Assert.assertSame(key, map1.keysView().getFirst());
        Key duplicateKey3 = new Key("key");
        MutableMap<Key, Integer> map3 = Maps.fixedSize.of(key, 1, new Key("not a dupe"), 2, duplicateKey3, 3);
        Verify.assertSize(2, map3);
        Verify.assertContainsAllKeyValues(map3, key, 3, new Key("not a dupe"), 2);
        Assert.assertSame(key, map3.keysView().detect(key::equals));
    }

    @Test
    public void testWithMap() {
        MutableMap<String, String> map = Maps.fixedSize.of("key1", "value1", "key2", "value2", "key3", "value3");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.withMap(Maps.fixedSize.of("key4", "value4")));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create0() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::create0, this.description("create0"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create1() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::create1, this.description("create1"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::create2, this.description("create2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_create3() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::create3, this.description("create3"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_createWithDuplicates() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::createWithDuplicates, this.description("createWithDuplicates"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyPreservation() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keyPreservation, this.description("keyPreservation"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testWithMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testWithMap, this.description("testWithMap"));
        }

        private FixedSizeMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FixedSizeMapFactoryTest();
        }

        @java.lang.Override
        public FixedSizeMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
