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

import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;

/**
 * JUnit test for {@link ObjectIntHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectIntHashMapTest extends ObjectIntHashMapTestCase {

    @Override
    protected ObjectIntHashMap<String> classUnderTest() {
        return ObjectIntHashMap.newWithKeysValues("0", 0, "1", 1, "2", 2);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1, T key2, int value2) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3, T key4, int value4) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectIntHashMap<T> getEmptyMap() {
        return new ObjectIntHashMap<>();
    }

    @Override
    protected MutableObjectIntMap newMapWithInitialCapacity(int size) {
        return new ObjectIntHashMap<>(size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectIntHashMap.class;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMapTestCase._Benchmark {

        private ObjectIntHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectIntHashMapTest();
        }

        @java.lang.Override
        public ObjectIntHashMapTest implementation() {
            return this.implementation;
        }
    }
}
