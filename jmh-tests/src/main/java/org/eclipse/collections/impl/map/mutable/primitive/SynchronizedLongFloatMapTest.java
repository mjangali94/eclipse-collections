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
 * JUnit test for {@link SynchronizedLongFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongFloatMapTest extends AbstractMutableLongFloatMapTestCase {

    private final SynchronizedLongFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongFloatMap classUnderTest() {
        return new SynchronizedLongFloatMap(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 31L, 31.0f, 32L, 32.0f));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongFloatMap getEmptyMap() {
        return new SynchronizedLongFloatMap(new LongFloatHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableLongFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedLongFloatMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongFloatMapTest();
        }

        @java.lang.Override
        public SynchronizedLongFloatMapTest implementation() {
            return this.implementation;
        }
    }
}
