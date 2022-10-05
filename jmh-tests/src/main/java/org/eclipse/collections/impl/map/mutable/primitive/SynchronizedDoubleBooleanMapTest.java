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
 * JUnit test for {@link SynchronizedDoubleBooleanMap}.
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapTest.stg.
 */
public class SynchronizedDoubleBooleanMapTest extends AbstractMutableDoubleBooleanMapTestCase {

    @Override
    protected SynchronizedDoubleBooleanMap classUnderTest() {
        return new SynchronizedDoubleBooleanMap(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false, 32.0, true));
    }

    @Override
    protected SynchronizedDoubleBooleanMap newWithKeysValues(double key1, boolean value1) {
        return new SynchronizedDoubleBooleanMap(new DoubleBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2) {
        return new SynchronizedDoubleBooleanMap(new DoubleBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3) {
        return new SynchronizedDoubleBooleanMap(new DoubleBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3, double key4, boolean value4) {
        return new SynchronizedDoubleBooleanMap(new DoubleBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedDoubleBooleanMap getEmptyMap() {
        return new SynchronizedDoubleBooleanMap(new DoubleBooleanHashMap());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedDoubleBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableDoubleBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        private SynchronizedDoubleBooleanMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedDoubleBooleanMapTest();
        }

        @java.lang.Override
        public SynchronizedDoubleBooleanMapTest implementation() {
            return this.implementation;
        }
    }
}
