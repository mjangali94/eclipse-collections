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
 * JUnit test for {@link SynchronizedObjectFloatMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectFloatMapTest extends AbstractMutableObjectFloatMapTestCase {

    private final SynchronizedObjectFloatMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectFloatMap<String> classUnderTest() {
        return new SynchronizedObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f));
    }

    @Override
    protected <T> SynchronizedObjectFloatMap<T> newWithKeysValues(T key1, float value1) {
        return new SynchronizedObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2) {
        return new SynchronizedObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3) {
        return new SynchronizedObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3, T key4, float value4) {
        return new SynchronizedObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectFloatMap<T> getEmptyMap() {
        return new SynchronizedObjectFloatMap<>(new ObjectFloatHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableObjectFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedObjectFloatMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectFloatMapTest();
        }

        @java.lang.Override
        public SynchronizedObjectFloatMapTest implementation() {
            return this.implementation;
        }
    }
}
