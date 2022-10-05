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
 * JUnit test for {@link SynchronizedIntShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedIntShortMapTest extends AbstractMutableIntShortMapTestCase {

    private final SynchronizedIntShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedIntShortMap classUnderTest() {
        return new SynchronizedIntShortMap(IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32));
    }

    @Override
    protected SynchronizedIntShortMap newWithKeysValues(int key1, short value1) {
        return new SynchronizedIntShortMap(new IntShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2) {
        return new SynchronizedIntShortMap(new IntShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3) {
        return new SynchronizedIntShortMap(new IntShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3, int key4, short value4) {
        return new SynchronizedIntShortMap(new IntShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntShortMap getEmptyMap() {
        return new SynchronizedIntShortMap(new IntShortHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableIntShortMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedIntShortMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedIntShortMapTest();
        }

        @java.lang.Override
        public SynchronizedIntShortMapTest implementation() {
            return this.implementation;
        }
    }
}
