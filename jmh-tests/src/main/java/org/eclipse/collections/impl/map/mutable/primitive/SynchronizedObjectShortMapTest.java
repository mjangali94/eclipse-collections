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
 * JUnit test for {@link SynchronizedObjectShortMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectShortMapTest extends AbstractMutableObjectShortMapTestCase {

    private final SynchronizedObjectShortMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectShortMap<String> classUnderTest() {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3, T key4, short value4) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> getEmptyMap() {
        return new SynchronizedObjectShortMap<>(new ObjectShortHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableObjectShortMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedObjectShortMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectShortMapTest();
        }

        @java.lang.Override
        public SynchronizedObjectShortMapTest implementation() {
            return this.implementation;
        }
    }
}
