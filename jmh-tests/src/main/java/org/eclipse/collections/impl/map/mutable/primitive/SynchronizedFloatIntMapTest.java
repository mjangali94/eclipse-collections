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
 * JUnit test for {@link SynchronizedFloatIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedFloatIntMapTest extends AbstractMutableFloatIntMapTestCase {

    private final SynchronizedFloatIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedFloatIntMap classUnderTest() {
        return new SynchronizedFloatIntMap(FloatIntHashMap.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32));
    }

    @Override
    protected SynchronizedFloatIntMap newWithKeysValues(float key1, int value1) {
        return new SynchronizedFloatIntMap(new FloatIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2) {
        return new SynchronizedFloatIntMap(new FloatIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3) {
        return new SynchronizedFloatIntMap(new FloatIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4) {
        return new SynchronizedFloatIntMap(new FloatIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedFloatIntMap getEmptyMap() {
        return new SynchronizedFloatIntMap(new FloatIntHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableFloatIntMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedFloatIntMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatIntMapTest();
        }

        @java.lang.Override
        public SynchronizedFloatIntMapTest implementation() {
            return this.implementation;
        }
    }
}
