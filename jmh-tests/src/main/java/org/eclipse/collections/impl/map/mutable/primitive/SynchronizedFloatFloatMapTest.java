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
 * JUnit test for {@link SynchronizedFloatFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedFloatFloatMapTest extends AbstractMutableFloatFloatMapTestCase {

    private final SynchronizedFloatFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedFloatFloatMap classUnderTest() {
        return new SynchronizedFloatFloatMap(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f));
    }

    @Override
    protected SynchronizedFloatFloatMap newWithKeysValues(float key1, float value1) {
        return new SynchronizedFloatFloatMap(new FloatFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2) {
        return new SynchronizedFloatFloatMap(new FloatFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3) {
        return new SynchronizedFloatFloatMap(new FloatFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4) {
        return new SynchronizedFloatFloatMap(new FloatFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedFloatFloatMap getEmptyMap() {
        return new SynchronizedFloatFloatMap(new FloatFloatHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableFloatFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedFloatFloatMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatFloatMapTest();
        }

        @java.lang.Override
        public SynchronizedFloatFloatMapTest implementation() {
            return this.implementation;
        }
    }
}
