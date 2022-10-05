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

import org.eclipse.collections.api.map.primitive.MutableFloatFloatMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableFloatFloatMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableFloatFloatMapKeyValuesViewTest extends AbstractFloatFloatMapKeyValuesViewTestCase {

    @Override
    public MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3) {
        return FloatFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2) {
        return FloatFloatHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableFloatFloatMap newWithKeysValues(float key1, float value1) {
        return FloatFloatHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableFloatFloatMap newEmpty() {
        return new FloatFloatHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatFloatMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableFloatFloatMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableFloatFloatMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableFloatFloatMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
