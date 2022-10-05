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
 * JUnit test for {@link SynchronizedCharObjectMap}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapTest.stg.
 */
public class SynchronizedCharObjectMapTest extends AbstractMutableCharObjectMapTestCase {

    private final SynchronizedCharObjectMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedCharObjectMap<String> classUnderTest() {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo"));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> newWithKeysValues(char key1, T value1) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3) {
        return new SynchronizedCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedCharObjectMap<T> getEmptyMap() {
        return new SynchronizedCharObjectMap<>(new CharObjectHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableCharObjectMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedCharObjectMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharObjectMapTest();
        }

        @java.lang.Override
        public SynchronizedCharObjectMapTest implementation() {
            return this.implementation;
        }
    }
}
