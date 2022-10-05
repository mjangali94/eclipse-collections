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
 * JUnit test for {@link SynchronizedFloatIntMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedFloatIntMapKeyValuesViewTest extends AbstractFloatIntMapKeyValuesViewTestCase {

    @Override
    public MutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3) {
        return FloatIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2) {
        return FloatIntHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableFloatIntMap newWithKeysValues(float key1, int value1) {
        return FloatIntHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableFloatIntMap newEmpty() {
        return new FloatIntHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatIntMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedFloatIntMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedFloatIntMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedFloatIntMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
