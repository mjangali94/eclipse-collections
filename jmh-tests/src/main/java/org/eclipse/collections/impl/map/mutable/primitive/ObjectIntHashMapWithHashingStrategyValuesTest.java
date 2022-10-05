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
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectIntHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectIntHashMapWithHashingStrategyValuesTest extends ObjectIntHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3, String key4, int value4) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectIntMap<String> newEmptyMap() {
        return ObjectIntHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMapValuesTestCase._Benchmark {

        private ObjectIntHashMapWithHashingStrategyValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectIntHashMapWithHashingStrategyValuesTest();
        }

        @java.lang.Override
        public ObjectIntHashMapWithHashingStrategyValuesTest implementation() {
            return this.implementation;
        }
    }
}
