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
 * JUnit test for {@link SynchronizedDoubleFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedDoubleFloatMapTest extends AbstractMutableDoubleFloatMapTestCase {

    private final SynchronizedDoubleFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedDoubleFloatMap classUnderTest() {
        return new SynchronizedDoubleFloatMap(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f));
    }

    @Override
    protected SynchronizedDoubleFloatMap newWithKeysValues(double key1, float value1) {
        return new SynchronizedDoubleFloatMap(new DoubleFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2) {
        return new SynchronizedDoubleFloatMap(new DoubleFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3) {
        return new SynchronizedDoubleFloatMap(new DoubleFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3, double key4, float value4) {
        return new SynchronizedDoubleFloatMap(new DoubleFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedDoubleFloatMap getEmptyMap() {
        return new SynchronizedDoubleFloatMap(new DoubleFloatHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableDoubleFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedDoubleFloatMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedDoubleFloatMapTest();
        }

        @java.lang.Override
        public SynchronizedDoubleFloatMapTest implementation() {
            return this.implementation;
        }
    }
}
