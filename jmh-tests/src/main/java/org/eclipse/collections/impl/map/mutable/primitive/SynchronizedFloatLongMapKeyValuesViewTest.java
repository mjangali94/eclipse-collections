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

import org.eclipse.collections.api.map.primitive.MutableFloatLongMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedFloatLongMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedFloatLongMapKeyValuesViewTest extends AbstractFloatLongMapKeyValuesViewTestCase {

    @Override
    public MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3) {
        return FloatLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2) {
        return FloatLongHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableFloatLongMap newWithKeysValues(float key1, long value1) {
        return FloatLongHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableFloatLongMap newEmpty() {
        return new FloatLongHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedFloatLongMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatLongMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedFloatLongMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
