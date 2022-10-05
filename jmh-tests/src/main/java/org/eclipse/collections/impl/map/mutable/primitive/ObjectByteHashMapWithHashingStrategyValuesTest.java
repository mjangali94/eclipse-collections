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

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectByteHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectByteHashMapWithHashingStrategyValuesTest extends ObjectByteHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3, String key4, byte value4) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectByteMap<String> newEmptyMap() {
        return ObjectByteHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMapValuesTestCase._Benchmark {

        private ObjectByteHashMapWithHashingStrategyValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectByteHashMapWithHashingStrategyValuesTest();
        }

        @java.lang.Override
        public ObjectByteHashMapWithHashingStrategyValuesTest implementation() {
            return this.implementation;
        }
    }
}
