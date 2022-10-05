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
 * JUnit test for {@link SynchronizedIntLongMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedIntLongMapTest extends AbstractMutableIntLongMapTestCase {

    private final SynchronizedIntLongMap map = this.classUnderTest();

    @Override
    protected SynchronizedIntLongMap classUnderTest() {
        return new SynchronizedIntLongMap(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L));
    }

    @Override
    protected SynchronizedIntLongMap newWithKeysValues(int key1, long value1) {
        return new SynchronizedIntLongMap(new IntLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2) {
        return new SynchronizedIntLongMap(new IntLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3) {
        return new SynchronizedIntLongMap(new IntLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3, int key4, long value4) {
        return new SynchronizedIntLongMap(new IntLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntLongMap getEmptyMap() {
        return new SynchronizedIntLongMap(new IntLongHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableIntLongMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedIntLongMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedIntLongMapTest();
        }

        @java.lang.Override
        public SynchronizedIntLongMapTest implementation() {
            return this.implementation;
        }
    }
}
