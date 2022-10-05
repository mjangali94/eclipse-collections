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

import org.eclipse.collections.impl.map.primitive.AbstractByteByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ByteByteHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ByteByteHashMapKeyValuesViewTest extends AbstractByteByteMapKeyValuesViewTestCase {

    @Override
    public ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3) {
        return ByteByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2) {
        return ByteByteHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ByteByteHashMap newWithKeysValues(byte key1, byte value1) {
        return ByteByteHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ByteByteHashMap newEmpty() {
        return new ByteByteHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteByteMapKeyValuesViewTestCase._Benchmark {

        private ByteByteHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteByteHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ByteByteHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
