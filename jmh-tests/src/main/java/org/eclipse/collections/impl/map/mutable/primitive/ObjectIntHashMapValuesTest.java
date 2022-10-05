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
 * JUnit test for {@link ObjectIntHashMap#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapValuesTest.stg.
 */
public class ObjectIntHashMapValuesTest extends ObjectIntHashMapValuesTestCase {

    @Override
    public ObjectIntHashMap<String> newMapWithKeysValues(String key1, int value1) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectIntHashMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectIntHashMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectIntHashMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3, String key4, int value4) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectIntMap<String> newEmptyMap() {
        return ObjectIntHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMapValuesTestCase._Benchmark {

        private ObjectIntHashMapValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectIntHashMapValuesTest();
        }

        @java.lang.Override
        public ObjectIntHashMapValuesTest implementation() {
            return this.implementation;
        }
    }
}
