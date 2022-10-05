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
 * JUnit test for {@link SynchronizedDoubleLongMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedDoubleLongMapTest extends AbstractMutableDoubleLongMapTestCase {

    private final SynchronizedDoubleLongMap map = this.classUnderTest();

    @Override
    protected SynchronizedDoubleLongMap classUnderTest() {
        return new SynchronizedDoubleLongMap(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L));
    }

    @Override
    protected SynchronizedDoubleLongMap newWithKeysValues(double key1, long value1) {
        return new SynchronizedDoubleLongMap(new DoubleLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2) {
        return new SynchronizedDoubleLongMap(new DoubleLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3) {
        return new SynchronizedDoubleLongMap(new DoubleLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3, double key4, long value4) {
        return new SynchronizedDoubleLongMap(new DoubleLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedDoubleLongMap getEmptyMap() {
        return new SynchronizedDoubleLongMap(new DoubleLongHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableDoubleLongMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedDoubleLongMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedDoubleLongMapTest();
        }

        @java.lang.Override
        public SynchronizedDoubleLongMapTest implementation() {
            return this.implementation;
        }
    }
}
