/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.immutable;

import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.impl.bimap.mutable.HashBiMap;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableHashBiMapTest extends AbstractImmutableBiMapTestCase {

    @Override
    protected ImmutableBiMap<Integer, String> classUnderTest() {
        return BiMaps.immutable.with(1, "1", 2, "2", 3, "3", 4, "4");
    }

    @Override
    protected ImmutableBiMap<Integer, String> newEmpty() {
        return BiMaps.immutable.empty();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithMap() {
        return BiMaps.immutable.withAll(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithHashBiMap() {
        return BiMaps.immutable.withAll(HashBiMap.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithImmutableMap() {
        return BiMaps.immutable.withAll(Maps.immutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
    }

    @Test
    public void keySet() {
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, 2, 3, 4), this.classUnderTest().castToMap().keySet());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySet, this.description("keySet"));
        }

        private ImmutableHashBiMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableHashBiMapTest();
        }

        @java.lang.Override
        public ImmutableHashBiMapTest implementation() {
            return this.implementation;
        }
    }
}
