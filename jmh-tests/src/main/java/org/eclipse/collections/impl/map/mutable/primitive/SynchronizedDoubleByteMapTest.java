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
 * JUnit test for {@link SynchronizedDoubleByteMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedDoubleByteMapTest extends AbstractMutableDoubleByteMapTestCase {

    private final SynchronizedDoubleByteMap map = this.classUnderTest();

    @Override
    protected SynchronizedDoubleByteMap classUnderTest() {
        return new SynchronizedDoubleByteMap(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32));
    }

    @Override
    protected SynchronizedDoubleByteMap newWithKeysValues(double key1, byte value1) {
        return new SynchronizedDoubleByteMap(new DoubleByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2) {
        return new SynchronizedDoubleByteMap(new DoubleByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3) {
        return new SynchronizedDoubleByteMap(new DoubleByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3, double key4, byte value4) {
        return new SynchronizedDoubleByteMap(new DoubleByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedDoubleByteMap getEmptyMap() {
        return new SynchronizedDoubleByteMap(new DoubleByteHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableDoubleByteMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedDoubleByteMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedDoubleByteMapTest();
        }

        @java.lang.Override
        public SynchronizedDoubleByteMapTest implementation() {
            return this.implementation;
        }
    }
}
