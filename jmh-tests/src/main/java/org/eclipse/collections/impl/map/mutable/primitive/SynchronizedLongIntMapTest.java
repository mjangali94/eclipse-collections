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
 * JUnit test for {@link SynchronizedLongIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongIntMapTest extends AbstractMutableLongIntMapTestCase {

    private final SynchronizedLongIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongIntMap classUnderTest() {
        return new SynchronizedLongIntMap(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1) {
        return new SynchronizedLongIntMap(new LongIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2) {
        return new SynchronizedLongIntMap(new LongIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3) {
        return new SynchronizedLongIntMap(new LongIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3, long key4, int value4) {
        return new SynchronizedLongIntMap(new LongIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongIntMap getEmptyMap() {
        return new SynchronizedLongIntMap(new LongIntHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableLongIntMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedLongIntMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongIntMapTest();
        }

        @java.lang.Override
        public SynchronizedLongIntMapTest implementation() {
            return this.implementation;
        }
    }
}
