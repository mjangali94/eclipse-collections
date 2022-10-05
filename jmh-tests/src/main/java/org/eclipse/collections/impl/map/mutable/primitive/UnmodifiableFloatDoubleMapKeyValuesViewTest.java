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

import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableFloatDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableFloatDoubleMapKeyValuesViewTest extends AbstractFloatDoubleMapKeyValuesViewTestCase {

    @Override
    public MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3) {
        return FloatDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2) {
        return FloatDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableFloatDoubleMap newWithKeysValues(float key1, double value1) {
        return FloatDoubleHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableFloatDoubleMap newEmpty() {
        return new FloatDoubleHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatDoubleMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableFloatDoubleMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableFloatDoubleMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableFloatDoubleMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
