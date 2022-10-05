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
 * JUnit test for {@link SynchronizedByteDoubleMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedByteDoubleMapTest extends AbstractMutableByteDoubleMapTestCase {

    private final SynchronizedByteDoubleMap map = this.classUnderTest();

    @Override
    protected SynchronizedByteDoubleMap classUnderTest() {
        return new SynchronizedByteDoubleMap(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0));
    }

    @Override
    protected SynchronizedByteDoubleMap newWithKeysValues(byte key1, double value1) {
        return new SynchronizedByteDoubleMap(new ByteDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2) {
        return new SynchronizedByteDoubleMap(new ByteDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3) {
        return new SynchronizedByteDoubleMap(new ByteDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3, byte key4, double value4) {
        return new SynchronizedByteDoubleMap(new ByteDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteDoubleMap getEmptyMap() {
        return new SynchronizedByteDoubleMap(new ByteDoubleHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableByteDoubleMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedByteDoubleMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedByteDoubleMapTest();
        }

        @java.lang.Override
        public SynchronizedByteDoubleMapTest implementation() {
            return this.implementation;
        }
    }
}
