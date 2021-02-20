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

import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;

/**
 * JUnit test for {@link ObjectBooleanHashMap#values()}.
 */
public class ObjectBooleanHashMapValuesTest extends ObjectBooleanHashMapValuesTestCase {

    @Override
    protected MutableBooleanCollection classUnderTest() {
        return ObjectBooleanHashMap.newWithKeysValues(1, true, 2, false, 3, true).values();
    }

    @Override
    protected MutableBooleanCollection newWith(boolean... elements) {
        ObjectBooleanHashMap<Integer> map = new ObjectBooleanHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableBooleanCollection newMutableCollectionWith(boolean... elements) {
        return this.newWith(elements);
    }

    @Override
    protected MutableList<Object> newObjectCollectionWith(Object... elements) {
        return FastList.newListWith(elements);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private ObjectBooleanHashMapValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectBooleanHashMapValuesTest();
        }

        @java.lang.Override
        public ObjectBooleanHashMapValuesTest implementation() {
            return this.implementation;
        }
    }
}
