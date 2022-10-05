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
 * JUnit test for {@link ObjectFloatHashMap#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapValuesTest.stg.
 */
public class ObjectFloatHashMapValuesTest extends ObjectFloatHashMapValuesTestCase {

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectFloatHashMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3, String key4, float value4) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectFloatMap<String> newEmptyMap() {
        return ObjectFloatHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMapValuesTestCase._Benchmark {

        private ObjectFloatHashMapValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectFloatHashMapValuesTest();
        }

        @java.lang.Override
        public ObjectFloatHashMapValuesTest implementation() {
            return this.implementation;
        }
    }
}
