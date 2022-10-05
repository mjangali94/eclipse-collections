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
 * JUnit test for {@link SynchronizedByteFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedByteFloatMapTest extends AbstractMutableByteFloatMapTestCase {

    private final SynchronizedByteFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedByteFloatMap classUnderTest() {
        return new SynchronizedByteFloatMap(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f));
    }

    @Override
    protected SynchronizedByteFloatMap newWithKeysValues(byte key1, float value1) {
        return new SynchronizedByteFloatMap(new ByteFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2) {
        return new SynchronizedByteFloatMap(new ByteFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3) {
        return new SynchronizedByteFloatMap(new ByteFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3, byte key4, float value4) {
        return new SynchronizedByteFloatMap(new ByteFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteFloatMap getEmptyMap() {
        return new SynchronizedByteFloatMap(new ByteFloatHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableByteFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedByteFloatMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedByteFloatMapTest();
        }

        @java.lang.Override
        public SynchronizedByteFloatMapTest implementation() {
            return this.implementation;
        }
    }
}
