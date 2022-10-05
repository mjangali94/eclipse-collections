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

import org.eclipse.collections.api.map.primitive.ImmutableFloatCharMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableFloatCharHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableFloatCharHashMapKeyValuesViewTest extends AbstractFloatCharMapKeyValuesViewTestCase {

    @Override
    public ImmutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3) {
        return FloatCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2) {
        return FloatCharHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableFloatCharMap newWithKeysValues(float key1, char value1) {
        return FloatCharHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableFloatCharMap newEmpty() {
        return new FloatCharHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatCharMapKeyValuesViewTestCase._Benchmark {

        private ImmutableFloatCharHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableFloatCharHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableFloatCharHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
