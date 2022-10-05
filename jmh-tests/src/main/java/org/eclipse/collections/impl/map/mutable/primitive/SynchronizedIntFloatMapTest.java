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
 * JUnit test for {@link SynchronizedIntFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedIntFloatMapTest extends AbstractMutableIntFloatMapTestCase {

    private final SynchronizedIntFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedIntFloatMap classUnderTest() {
        return new SynchronizedIntFloatMap(IntFloatHashMap.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3, int key4, float value4) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntFloatMap getEmptyMap() {
        return new SynchronizedIntFloatMap(new IntFloatHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableIntFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedIntFloatMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedIntFloatMapTest();
        }

        @java.lang.Override
        public SynchronizedIntFloatMapTest implementation() {
            return this.implementation;
        }
    }
}
