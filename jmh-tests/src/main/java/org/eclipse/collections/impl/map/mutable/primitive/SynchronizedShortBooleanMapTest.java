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
 * JUnit test for {@link SynchronizedShortBooleanMap}.
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapTest.stg.
 */
public class SynchronizedShortBooleanMapTest extends AbstractMutableShortBooleanMapTestCase {

    @Override
    protected SynchronizedShortBooleanMap classUnderTest() {
        return new SynchronizedShortBooleanMap(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4) {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortBooleanMap getEmptyMap() {
        return new SynchronizedShortBooleanMap(new ShortBooleanHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedShortBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableShortBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedShortBooleanMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedShortBooleanMapTest();
        }

        @java.lang.Override
        public SynchronizedShortBooleanMapTest implementation() {
            return this.implementation;
        }
    }
}
