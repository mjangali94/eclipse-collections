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

import org.eclipse.collections.impl.map.primitive.AbstractByteShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ByteShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ByteShortHashMapKeyValuesViewTest extends AbstractByteShortMapKeyValuesViewTestCase {

    @Override
    public ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3) {
        return ByteShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2) {
        return ByteShortHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ByteShortHashMap newWithKeysValues(byte key1, short value1) {
        return ByteShortHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ByteShortHashMap newEmpty() {
        return new ByteShortHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteShortMapKeyValuesViewTestCase._Benchmark {

        private ByteShortHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteShortHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ByteShortHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
