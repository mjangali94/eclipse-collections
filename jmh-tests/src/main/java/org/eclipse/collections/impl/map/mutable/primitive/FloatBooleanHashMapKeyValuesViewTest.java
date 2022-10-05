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

import org.eclipse.collections.impl.map.primitive.AbstractFloatBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link FloatBooleanHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class FloatBooleanHashMapKeyValuesViewTest extends AbstractFloatBooleanMapKeyValuesViewTestCase {

    @Override
    public FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3) {
        return FloatBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2) {
        return FloatBooleanHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public FloatBooleanHashMap newWithKeysValues(float key1, boolean value1) {
        return FloatBooleanHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public FloatBooleanHashMap newEmpty() {
        return new FloatBooleanHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatBooleanMapKeyValuesViewTestCase._Benchmark {

        private FloatBooleanHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatBooleanHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public FloatBooleanHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
