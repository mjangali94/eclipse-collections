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

import org.eclipse.collections.impl.map.primitive.AbstractByteIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ByteIntHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ByteIntHashMapKeyValuesViewTest extends AbstractByteIntMapKeyValuesViewTestCase {

    @Override
    public ByteIntHashMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3) {
        return ByteIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ByteIntHashMap newWithKeysValues(byte key1, int value1, byte key2, int value2) {
        return ByteIntHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ByteIntHashMap newWithKeysValues(byte key1, int value1) {
        return ByteIntHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ByteIntHashMap newEmpty() {
        return new ByteIntHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteIntMapKeyValuesViewTestCase._Benchmark {

        private ByteIntHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteIntHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ByteIntHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
