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

import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;

/**
 * JUnit test for {@link ObjectByteHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectByteHashMapTest extends ObjectByteHashMapTestCase {

    @Override
    protected ObjectByteHashMap<String> classUnderTest() {
        return ObjectByteHashMap.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2);
    }

    @Override
    protected <T> ObjectByteHashMap<T> newWithKeysValues(T key1, byte value1) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectByteHashMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectByteHashMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectByteHashMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3, T key4, byte value4) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectByteHashMap<T> getEmptyMap() {
        return new ObjectByteHashMap<>();
    }

    @Override
    protected MutableObjectByteMap newMapWithInitialCapacity(int size) {
        return new ObjectByteHashMap<>(size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectByteHashMap.class;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMapTestCase._Benchmark {

        private ObjectByteHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectByteHashMapTest();
        }

        @java.lang.Override
        public ObjectByteHashMapTest implementation() {
            return this.implementation;
        }
    }
}
