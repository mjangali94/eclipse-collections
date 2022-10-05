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
 * JUnit test for {@link SynchronizedFloatDoubleMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedFloatDoubleMapTest extends AbstractMutableFloatDoubleMapTestCase {

    private final SynchronizedFloatDoubleMap map = this.classUnderTest();

    @Override
    protected SynchronizedFloatDoubleMap classUnderTest() {
        return new SynchronizedFloatDoubleMap(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedFloatDoubleMap getEmptyMap() {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableFloatDoubleMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedFloatDoubleMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatDoubleMapTest();
        }

        @java.lang.Override
        public SynchronizedFloatDoubleMapTest implementation() {
            return this.implementation;
        }
    }
}
