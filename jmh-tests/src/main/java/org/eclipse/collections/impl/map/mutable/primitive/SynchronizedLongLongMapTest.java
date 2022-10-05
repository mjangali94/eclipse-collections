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
 * JUnit test for {@link SynchronizedLongLongMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongLongMapTest extends AbstractMutableLongLongMapTestCase {

    private final SynchronizedLongLongMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongLongMap classUnderTest() {
        return new SynchronizedLongLongMap(LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L));
    }

    @Override
    protected SynchronizedLongLongMap newWithKeysValues(long key1, long value1) {
        return new SynchronizedLongLongMap(new LongLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2) {
        return new SynchronizedLongLongMap(new LongLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3) {
        return new SynchronizedLongLongMap(new LongLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4) {
        return new SynchronizedLongLongMap(new LongLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongLongMap getEmptyMap() {
        return new SynchronizedLongLongMap(new LongLongHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableLongLongMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedLongLongMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongLongMapTest();
        }

        @java.lang.Override
        public SynchronizedLongLongMapTest implementation() {
            return this.implementation;
        }
    }
}
