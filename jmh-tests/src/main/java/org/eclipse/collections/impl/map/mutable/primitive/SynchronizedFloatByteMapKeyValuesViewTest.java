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

import org.eclipse.collections.api.map.primitive.MutableFloatByteMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedFloatByteMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedFloatByteMapKeyValuesViewTest extends AbstractFloatByteMapKeyValuesViewTestCase {

    @Override
    public MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3) {
        return FloatByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2) {
        return FloatByteHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableFloatByteMap newWithKeysValues(float key1, byte value1) {
        return FloatByteHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableFloatByteMap newEmpty() {
        return new FloatByteHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatByteMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedFloatByteMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatByteMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedFloatByteMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
