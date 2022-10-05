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
 * JUnit test for {@link SynchronizedFloatBooleanMap}.
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapTest.stg.
 */
public class SynchronizedFloatBooleanMapTest extends AbstractMutableFloatBooleanMapTestCase {

    @Override
    protected SynchronizedFloatBooleanMap classUnderTest() {
        return new SynchronizedFloatBooleanMap(FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, true));
    }

    @Override
    protected SynchronizedFloatBooleanMap newWithKeysValues(float key1, boolean value1) {
        return new SynchronizedFloatBooleanMap(new FloatBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedFloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2) {
        return new SynchronizedFloatBooleanMap(new FloatBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedFloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3) {
        return new SynchronizedFloatBooleanMap(new FloatBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedFloatBooleanMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3, float key4, boolean value4) {
        return new SynchronizedFloatBooleanMap(new FloatBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedFloatBooleanMap getEmptyMap() {
        return new SynchronizedFloatBooleanMap(new FloatBooleanHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableFloatBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedFloatBooleanMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatBooleanMapTest();
        }

        @java.lang.Override
        public SynchronizedFloatBooleanMapTest implementation() {
            return this.implementation;
        }
    }
}
