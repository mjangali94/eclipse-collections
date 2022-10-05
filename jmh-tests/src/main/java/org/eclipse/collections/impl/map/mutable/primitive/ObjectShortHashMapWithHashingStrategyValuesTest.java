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
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectShortHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectShortHashMapWithHashingStrategyValuesTest extends ObjectShortHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3, String key4, short value4) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectShortMap<String> newEmptyMap() {
        return ObjectShortHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMapValuesTestCase._Benchmark {

        private ObjectShortHashMapWithHashingStrategyValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectShortHashMapWithHashingStrategyValuesTest();
        }

        @java.lang.Override
        public ObjectShortHashMapWithHashingStrategyValuesTest implementation() {
            return this.implementation;
        }
    }
}
