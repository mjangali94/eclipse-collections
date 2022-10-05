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
 * JUnit test for {@link SynchronizedObjectIntMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectIntMapTest extends AbstractMutableObjectIntMapTestCase {

    private final SynchronizedObjectIntMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectIntMap<String> classUnderTest() {
        return new SynchronizedObjectIntMap<>(ObjectIntHashMap.newWithKeysValues("0", 0, "1", 1, "2", 2));
    }

    @Override
    protected <T> SynchronizedObjectIntMap<T> newWithKeysValues(T key1, int value1) {
        return new SynchronizedObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2) {
        return new SynchronizedObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3) {
        return new SynchronizedObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3, T key4, int value4) {
        return new SynchronizedObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectIntMap<T> getEmptyMap() {
        return new SynchronizedObjectIntMap<>(new ObjectIntHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableObjectIntMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedObjectIntMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectIntMapTest();
        }

        @java.lang.Override
        public SynchronizedObjectIntMapTest implementation() {
            return this.implementation;
        }
    }
}
