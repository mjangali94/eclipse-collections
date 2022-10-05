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

import org.eclipse.collections.api.map.primitive.MutableByteBooleanMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedByteBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedByteBooleanMapKeyValuesViewTest extends AbstractByteBooleanMapKeyValuesViewTestCase {

    @Override
    public MutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3) {
        return ByteBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2) {
        return ByteBooleanHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableByteBooleanMap newWithKeysValues(byte key1, boolean value1) {
        return ByteBooleanHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableByteBooleanMap newEmpty() {
        return new ByteBooleanHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteBooleanMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedByteBooleanMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedByteBooleanMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedByteBooleanMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
