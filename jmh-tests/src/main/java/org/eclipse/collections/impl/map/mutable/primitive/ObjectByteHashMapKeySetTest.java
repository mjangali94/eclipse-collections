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
 * JUnit test for {@link ObjectByteHashMap#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeySetTest.stg.
 */
public class ObjectByteHashMapKeySetTest extends ObjectByteHashMapKeySetTestCase {

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3, String key4, byte value4) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectByteMap<String> newEmptyMap() {
        return ObjectByteHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMapKeySetTestCase._Benchmark {

        private ObjectByteHashMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectByteHashMapKeySetTest();
        }

        @java.lang.Override
        public ObjectByteHashMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
