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

import org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ByteFloatHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ByteFloatHashMapKeyValuesViewTest extends AbstractByteFloatMapKeyValuesViewTestCase {

    @Override
    public ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3) {
        return ByteFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2) {
        return ByteFloatHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ByteFloatHashMap newWithKeysValues(byte key1, float value1) {
        return ByteFloatHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ByteFloatHashMap newEmpty() {
        return new ByteFloatHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapKeyValuesViewTestCase._Benchmark {

        private ByteFloatHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteFloatHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ByteFloatHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
