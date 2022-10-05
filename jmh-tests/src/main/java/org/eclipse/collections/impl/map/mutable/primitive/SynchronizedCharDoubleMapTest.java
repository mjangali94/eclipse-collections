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
 * JUnit test for {@link SynchronizedCharDoubleMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharDoubleMapTest extends AbstractMutableCharDoubleMapTestCase {

    private final SynchronizedCharDoubleMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharDoubleMap classUnderTest() {
        return new SynchronizedCharDoubleMap(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0));
    }

    @Override
    protected SynchronizedCharDoubleMap newWithKeysValues(char key1, double value1) {
        return new SynchronizedCharDoubleMap(new CharDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2) {
        return new SynchronizedCharDoubleMap(new CharDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3) {
        return new SynchronizedCharDoubleMap(new CharDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3, char key4, double value4) {
        return new SynchronizedCharDoubleMap(new CharDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharDoubleMap getEmptyMap() {
        return new SynchronizedCharDoubleMap(new CharDoubleHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableCharDoubleMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedCharDoubleMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharDoubleMapTest();
        }

        @java.lang.Override
        public SynchronizedCharDoubleMapTest implementation() {
            return this.implementation;
        }
    }
}
