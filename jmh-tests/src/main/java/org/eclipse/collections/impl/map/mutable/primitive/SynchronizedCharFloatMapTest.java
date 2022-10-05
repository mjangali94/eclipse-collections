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
 * JUnit test for {@link SynchronizedCharFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharFloatMapTest extends AbstractMutableCharFloatMapTestCase {

    private final SynchronizedCharFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharFloatMap classUnderTest() {
        return new SynchronizedCharFloatMap(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3, char key4, float value4) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharFloatMap getEmptyMap() {
        return new SynchronizedCharFloatMap(new CharFloatHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableCharFloatMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedCharFloatMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharFloatMapTest();
        }

        @java.lang.Override
        public SynchronizedCharFloatMapTest implementation() {
            return this.implementation;
        }
    }
}
