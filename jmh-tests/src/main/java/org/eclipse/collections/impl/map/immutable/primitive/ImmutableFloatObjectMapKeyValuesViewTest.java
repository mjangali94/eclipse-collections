/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableFloatObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatObjectMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableFloatObjectHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapKeyValuesViewTest.stg.
 */
public class ImmutableFloatObjectMapKeyValuesViewTest extends AbstractFloatObjectMapKeyValuesViewTestCase {

    @Override
    public ImmutableFloatObjectMap<Integer> newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3) {
        return FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableFloatObjectMap<Integer> newWithKeysValues(float key1, int value1, float key2, int value2) {
        return FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableFloatObjectMap<Integer> newWithKeysValues(float key1, int value1) {
        return FloatObjectHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableFloatObjectMap<Integer> newEmpty() {
        return FloatObjectHashMap.<Integer>newMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatObjectMapKeyValuesViewTestCase._Benchmark {

        private ImmutableFloatObjectMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableFloatObjectMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableFloatObjectMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
