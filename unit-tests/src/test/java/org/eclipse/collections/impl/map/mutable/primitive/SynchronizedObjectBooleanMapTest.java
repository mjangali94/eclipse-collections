/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.junit.Assert;
import org.junit.Test;

public class SynchronizedObjectBooleanMapTest extends AbstractMutableObjectBooleanMapTestCase {

    private final SynchronizedObjectBooleanMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectBooleanMap<String> classUnderTest() {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues("0", true, "1", true, "2", false));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> newWithKeysValues(T key1, boolean value1, T key2, boolean value2, T key3, boolean value3, T key4, boolean value4) {
        return new SynchronizedObjectBooleanMap<>(ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectBooleanMap<T> getEmptyMap() {
        return new SynchronizedObjectBooleanMap<>(new ObjectBooleanHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedObjectBooleanMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectBooleanMapTest();
        }

        @java.lang.Override
        public SynchronizedObjectBooleanMapTest implementation() {
            return this.implementation;
        }
    }
}
