/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.map.primitive.MutableObjectBooleanMap;

/**
 * Abstract JUnit test for {@link SynchronizedObjectBooleanMap#keyValuesView()}.
 */
public class SynchronizedObjectBooleanHashMapKeyValuesViewTest extends AbstractObjectBooleanMapKeyValuesViewTestCase {

    @Override
    public <K> MutableObjectBooleanMap<K> newWithKeysValues(K key1, boolean value1, K key2, boolean value2, K key3, boolean value3) {
        return ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public <K> MutableObjectBooleanMap<K> newWithKeysValues(K key1, boolean value1, K key2, boolean value2) {
        return ObjectBooleanHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public <K> MutableObjectBooleanMap<K> newWithKeysValues(K key1, boolean value1) {
        return ObjectBooleanHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableObjectBooleanMap<Object> newEmpty() {
        return ObjectBooleanHashMap.newMap().asSynchronized();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private SynchronizedObjectBooleanHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectBooleanHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedObjectBooleanHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
