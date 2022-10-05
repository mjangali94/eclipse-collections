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
 * JUnit test for {@link SynchronizedShortIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortIntMapTest extends AbstractMutableShortIntMapTestCase {

    private final SynchronizedShortIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortIntMap classUnderTest() {
        return new SynchronizedShortIntMap(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32));
    }

    @Override
    protected SynchronizedShortIntMap newWithKeysValues(short key1, int value1) {
        return new SynchronizedShortIntMap(new ShortIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2) {
        return new SynchronizedShortIntMap(new ShortIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3) {
        return new SynchronizedShortIntMap(new ShortIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4) {
        return new SynchronizedShortIntMap(new ShortIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortIntMap getEmptyMap() {
        return new SynchronizedShortIntMap(new ShortIntHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableShortIntMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedShortIntMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedShortIntMapTest();
        }

        @java.lang.Override
        public SynchronizedShortIntMapTest implementation() {
            return this.implementation;
        }
    }
}
