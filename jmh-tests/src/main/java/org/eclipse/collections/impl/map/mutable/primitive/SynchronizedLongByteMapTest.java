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
 * JUnit test for {@link SynchronizedLongByteMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongByteMapTest extends AbstractMutableLongByteMapTestCase {

    private final SynchronizedLongByteMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongByteMap classUnderTest() {
        return new SynchronizedLongByteMap(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1) {
        return new SynchronizedLongByteMap(new LongByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2) {
        return new SynchronizedLongByteMap(new LongByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3) {
        return new SynchronizedLongByteMap(new LongByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3, long key4, byte value4) {
        return new SynchronizedLongByteMap(new LongByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongByteMap getEmptyMap() {
        return new SynchronizedLongByteMap(new LongByteHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableLongByteMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedLongByteMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongByteMapTest();
        }

        @java.lang.Override
        public SynchronizedLongByteMapTest implementation() {
            return this.implementation;
        }
    }
}
