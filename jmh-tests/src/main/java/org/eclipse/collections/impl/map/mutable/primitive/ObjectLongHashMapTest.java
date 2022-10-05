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

import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;

/**
 * JUnit test for {@link ObjectLongHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectLongHashMapTest extends ObjectLongHashMapTestCase {

    @Override
    protected ObjectLongHashMap<String> classUnderTest() {
        return ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L);
    }

    @Override
    protected <T> ObjectLongHashMap<T> newWithKeysValues(T key1, long value1) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectLongHashMap<T> newWithKeysValues(T key1, long value1, T key2, long value2) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectLongHashMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectLongHashMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectLongHashMap<T> getEmptyMap() {
        return new ObjectLongHashMap<>();
    }

    @Override
    protected MutableObjectLongMap newMapWithInitialCapacity(int size) {
        return new ObjectLongHashMap<>(size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectLongHashMap.class;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMapTestCase._Benchmark {

        private ObjectLongHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectLongHashMapTest();
        }

        @java.lang.Override
        public ObjectLongHashMapTest implementation() {
            return this.implementation;
        }
    }
}
