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
 * JUnit test for {@link SynchronizedObjectLongMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectLongMapTest extends AbstractMutableObjectLongMapTestCase {

    private final SynchronizedObjectLongMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectLongMap<String> classUnderTest() {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> getEmptyMap() {
        return new SynchronizedObjectLongMap<>(new ObjectLongHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableObjectLongMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedObjectLongMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectLongMapTest();
        }

        @java.lang.Override
        public SynchronizedObjectLongMapTest implementation() {
            return this.implementation;
        }
    }
}
