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
 * JUnit test for {@link SynchronizedFloatObjectMap}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapTest.stg.
 */
public class SynchronizedFloatObjectMapTest extends AbstractMutableFloatObjectMapTestCase {

    private final SynchronizedFloatObjectMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedFloatObjectMap<String> classUnderTest() {
        return new SynchronizedFloatObjectMap<>(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo"));
    }

    @Override
    protected <T> SynchronizedFloatObjectMap<T> newWithKeysValues(float key1, T value1) {
        return new SynchronizedFloatObjectMap<>(FloatObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedFloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2) {
        return new SynchronizedFloatObjectMap<>(FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedFloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2, float key3, T value3) {
        return new SynchronizedFloatObjectMap<>(FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedFloatObjectMap<T> getEmptyMap() {
        return new SynchronizedFloatObjectMap<>(new FloatObjectHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableFloatObjectMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedFloatObjectMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatObjectMapTest();
        }

        @java.lang.Override
        public SynchronizedFloatObjectMapTest implementation() {
            return this.implementation;
        }
    }
}
