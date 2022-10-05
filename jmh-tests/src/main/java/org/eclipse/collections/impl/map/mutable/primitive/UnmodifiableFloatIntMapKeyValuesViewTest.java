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

import org.eclipse.collections.api.map.primitive.MutableFloatIntMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableFloatIntMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableFloatIntMapKeyValuesViewTest extends AbstractFloatIntMapKeyValuesViewTestCase {

    @Override
    public MutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3) {
        return FloatIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2) {
        return FloatIntHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableFloatIntMap newWithKeysValues(float key1, int value1) {
        return FloatIntHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableFloatIntMap newEmpty() {
        return new FloatIntHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatIntMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableFloatIntMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableFloatIntMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableFloatIntMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
