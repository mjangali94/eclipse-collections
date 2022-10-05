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
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectDoubleHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectDoubleHashMapWithHashingStrategyValuesTest extends ObjectDoubleHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3, String key4, double value4) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectDoubleMap<String> newEmptyMap() {
        return ObjectDoubleHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMapValuesTestCase._Benchmark {

        private ObjectDoubleHashMapWithHashingStrategyValuesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectDoubleHashMapWithHashingStrategyValuesTest();
        }

        @java.lang.Override
        public ObjectDoubleHashMapWithHashingStrategyValuesTest implementation() {
            return this.implementation;
        }
    }
}
