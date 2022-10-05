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

import org.eclipse.collections.impl.map.primitive.AbstractByteDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ByteDoubleHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ByteDoubleHashMapKeyValuesViewTest extends AbstractByteDoubleMapKeyValuesViewTestCase {

    @Override
    public ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3) {
        return ByteDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2) {
        return ByteDoubleHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ByteDoubleHashMap newWithKeysValues(byte key1, double value1) {
        return ByteDoubleHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ByteDoubleHashMap newEmpty() {
        return new ByteDoubleHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteDoubleMapKeyValuesViewTestCase._Benchmark {

        private ByteDoubleHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteDoubleHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ByteDoubleHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
