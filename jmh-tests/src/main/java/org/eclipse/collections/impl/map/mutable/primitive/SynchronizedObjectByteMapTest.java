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

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedObjectByteMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectByteMapTest extends AbstractMutableObjectByteMapTestCase {

    private final SynchronizedObjectByteMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectByteMap<String> classUnderTest() {
        return new SynchronizedObjectByteMap<>(ObjectByteHashMap.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2));
    }

    @Override
    protected <T> SynchronizedObjectByteMap<T> newWithKeysValues(T key1, byte value1) {
        return new SynchronizedObjectByteMap<>(ObjectByteHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2) {
        return new SynchronizedObjectByteMap<>(ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3) {
        return new SynchronizedObjectByteMap<>(ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3, T key4, byte value4) {
        return new SynchronizedObjectByteMap<>(ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectByteMap<T> getEmptyMap() {
        return new SynchronizedObjectByteMap<>(new ObjectByteHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableObjectByteMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedObjectByteMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectByteMapTest();
        }

        @java.lang.Override
        public SynchronizedObjectByteMapTest implementation() {
            return this.implementation;
        }
    }
}
