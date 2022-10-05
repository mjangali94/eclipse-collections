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

import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;

/**
 * JUnit test for {@link ObjectShortHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectShortHashMapTest extends ObjectShortHashMapTestCase {

    @Override
    protected ObjectShortHashMap<String> classUnderTest() {
        return ObjectShortHashMap.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1, T key2, short value2) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3, T key4, short value4) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectShortHashMap<T> getEmptyMap() {
        return new ObjectShortHashMap<>();
    }

    @Override
    protected MutableObjectShortMap newMapWithInitialCapacity(int size) {
        return new ObjectShortHashMap<>(size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectShortHashMap.class;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMapTestCase._Benchmark {

        private ObjectShortHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectShortHashMapTest();
        }

        @java.lang.Override
        public ObjectShortHashMapTest implementation() {
            return this.implementation;
        }
    }
}
