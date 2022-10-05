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

import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;

/**
 * JUnit test for {@link ObjectFloatHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectFloatHashMapTest extends ObjectFloatHashMapTestCase {

    @Override
    protected ObjectFloatHashMap<String> classUnderTest() {
        return ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f);
    }

    @Override
    protected <T> ObjectFloatHashMap<T> newWithKeysValues(T key1, float value1) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectFloatHashMap<T> newWithKeysValues(T key1, float value1, T key2, float value2) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectFloatHashMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectFloatHashMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3, T key4, float value4) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectFloatHashMap<T> getEmptyMap() {
        return new ObjectFloatHashMap<>();
    }

    @Override
    protected MutableObjectFloatMap newMapWithInitialCapacity(int size) {
        return new ObjectFloatHashMap<>(size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectFloatHashMap.class;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMapTestCase._Benchmark {

        private ObjectFloatHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectFloatHashMapTest();
        }

        @java.lang.Override
        public ObjectFloatHashMapTest implementation() {
            return this.implementation;
        }
    }
}
