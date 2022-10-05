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

import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;

/**
 * JUnit test for {@link ObjectCharHashMap#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeySetTest.stg.
 */
public class ObjectCharHashMapKeySetTest extends ObjectCharHashMapKeySetTestCase {

    @Override
    public ObjectCharHashMap<String> newMapWithKeysValues(String key1, char value1) {
        return ObjectCharHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectCharHashMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2) {
        return ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectCharHashMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2, String key3, char value3) {
        return ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectCharHashMap<String> newMapWithKeysValues(String key1, char value1, String key2, char value2, String key3, char value3, String key4, char value4) {
        return ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectCharMap<String> newEmptyMap() {
        return ObjectCharHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMapKeySetTestCase._Benchmark {

        private ObjectCharHashMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectCharHashMapKeySetTest();
        }

        @java.lang.Override
        public ObjectCharHashMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
