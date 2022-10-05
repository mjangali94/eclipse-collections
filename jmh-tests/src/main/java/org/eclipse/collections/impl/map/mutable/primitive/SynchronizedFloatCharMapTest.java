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
 * JUnit test for {@link SynchronizedFloatCharMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedFloatCharMapTest extends AbstractMutableFloatCharMapTestCase {

    private final SynchronizedFloatCharMap map = this.classUnderTest();

    @Override
    protected SynchronizedFloatCharMap classUnderTest() {
        return new SynchronizedFloatCharMap(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32));
    }

    @Override
    protected SynchronizedFloatCharMap newWithKeysValues(float key1, char value1) {
        return new SynchronizedFloatCharMap(new FloatCharHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2) {
        return new SynchronizedFloatCharMap(new FloatCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3) {
        return new SynchronizedFloatCharMap(new FloatCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4) {
        return new SynchronizedFloatCharMap(new FloatCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedFloatCharMap getEmptyMap() {
        return new SynchronizedFloatCharMap(new FloatCharHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableFloatCharMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedFloatCharMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatCharMapTest();
        }

        @java.lang.Override
        public SynchronizedFloatCharMapTest implementation() {
            return this.implementation;
        }
    }
}
