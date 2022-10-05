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
 * JUnit test for {@link SynchronizedLongObjectMap}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapTest.stg.
 */
public class SynchronizedLongObjectMapTest extends AbstractMutableLongObjectMapTestCase {

    private final SynchronizedLongObjectMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedLongObjectMap<String> classUnderTest() {
        return new SynchronizedLongObjectMap<>(LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo"));
    }

    @Override
    protected <T> SynchronizedLongObjectMap<T> newWithKeysValues(long key1, T value1) {
        return new SynchronizedLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedLongObjectMap<T> newWithKeysValues(long key1, T value1, long key2, T value2) {
        return new SynchronizedLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedLongObjectMap<T> newWithKeysValues(long key1, T value1, long key2, T value2, long key3, T value3) {
        return new SynchronizedLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedLongObjectMap<T> getEmptyMap() {
        return new SynchronizedLongObjectMap<>(new LongObjectHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableLongObjectMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedLongObjectMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongObjectMapTest();
        }

        @java.lang.Override
        public SynchronizedLongObjectMapTest implementation() {
            return this.implementation;
        }
    }
}
