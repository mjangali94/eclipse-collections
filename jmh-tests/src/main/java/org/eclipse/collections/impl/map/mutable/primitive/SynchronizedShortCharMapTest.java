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
 * JUnit test for {@link SynchronizedShortCharMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortCharMapTest extends AbstractMutableShortCharMapTestCase {

    private final SynchronizedShortCharMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortCharMap classUnderTest() {
        return new SynchronizedShortCharMap(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3, short key4, char value4) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortCharMap getEmptyMap() {
        return new SynchronizedShortCharMap(new ShortCharHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableShortCharMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedShortCharMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedShortCharMapTest();
        }

        @java.lang.Override
        public SynchronizedShortCharMapTest implementation() {
            return this.implementation;
        }
    }
}
