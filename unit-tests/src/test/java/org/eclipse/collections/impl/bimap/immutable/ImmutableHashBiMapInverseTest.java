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

public class ImmutableHashBiMapInverseTest extends AbstractImmutableBiMapTestCase {

    @Override
    protected ImmutableBiMap<Integer, String> classUnderTest() {
        return BiMaps.immutable.with("1", 1, "2", 2, "3", 3, "4", 4).inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newEmpty() {
        return BiMaps.immutable.<String, Integer>empty().inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithMap() {
        return BiMaps.immutable.withAll(UnifiedMap.newWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4)).inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithHashBiMap() {
        return BiMaps.immutable.withAll(HashBiMap.newWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4)).inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithImmutableMap() {
        return BiMaps.immutable.withAll(Maps.immutable.of("1", 1, "2", 2, "3", 3, "4", 4)).inverse();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private ImmutableHashBiMapInverseTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableHashBiMapInverseTest();
        }

        @java.lang.Override
        public ImmutableHashBiMapInverseTest implementation() {
            return this.implementation;
        }
    }
}
