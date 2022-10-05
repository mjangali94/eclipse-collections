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
 * JUnit test for {@link SynchronizedCharIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharIntMapTest extends AbstractMutableCharIntMapTestCase {

    private final SynchronizedCharIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharIntMap classUnderTest() {
        return new SynchronizedCharIntMap(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32));
    }

    @Override
    protected SynchronizedCharIntMap newWithKeysValues(char key1, int value1) {
        return new SynchronizedCharIntMap(new CharIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2) {
        return new SynchronizedCharIntMap(new CharIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3) {
        return new SynchronizedCharIntMap(new CharIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3, char key4, int value4) {
        return new SynchronizedCharIntMap(new CharIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharIntMap getEmptyMap() {
        return new SynchronizedCharIntMap(new CharIntHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableCharIntMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedCharIntMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharIntMapTest();
        }

        @java.lang.Override
        public SynchronizedCharIntMapTest implementation() {
            return this.implementation;
        }
    }
}
