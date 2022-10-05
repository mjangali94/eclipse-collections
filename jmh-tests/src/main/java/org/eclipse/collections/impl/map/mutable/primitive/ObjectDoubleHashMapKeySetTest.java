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

import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;

/**
 * JUnit test for {@link ObjectDoubleHashMap#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeySetTest.stg.
 */
public class ObjectDoubleHashMapKeySetTest extends ObjectDoubleHashMapKeySetTestCase {

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectDoubleHashMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3, String key4, double value4) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectDoubleMap<String> newEmptyMap() {
        return ObjectDoubleHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMapKeySetTestCase._Benchmark {

        private ObjectDoubleHashMapKeySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectDoubleHashMapKeySetTest();
        }

        @java.lang.Override
        public ObjectDoubleHashMapKeySetTest implementation() {
            return this.implementation;
        }
    }
}
