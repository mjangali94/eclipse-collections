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
 * JUnit test for {@link SynchronizedShortShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortShortMapTest extends AbstractMutableShortShortMapTestCase {

    private final SynchronizedShortShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortShortMap classUnderTest() {
        return new SynchronizedShortShortMap(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32));
    }

    @Override
    protected SynchronizedShortShortMap newWithKeysValues(short key1, short value1) {
        return new SynchronizedShortShortMap(new ShortShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2) {
        return new SynchronizedShortShortMap(new ShortShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3) {
        return new SynchronizedShortShortMap(new ShortShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3, short key4, short value4) {
        return new SynchronizedShortShortMap(new ShortShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortShortMap getEmptyMap() {
        return new SynchronizedShortShortMap(new ShortShortHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableShortShortMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedShortShortMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedShortShortMapTest();
        }

        @java.lang.Override
        public SynchronizedShortShortMapTest implementation() {
            return this.implementation;
        }
    }
}
