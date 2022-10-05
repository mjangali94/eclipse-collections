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

import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableByteFloatMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableByteFloatMapKeyValuesViewTest extends AbstractByteFloatMapKeyValuesViewTestCase {

    @Override
    public MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3) {
        return ByteFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2) {
        return ByteFloatHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableByteFloatMap newWithKeysValues(byte key1, float value1) {
        return ByteFloatHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableByteFloatMap newEmpty() {
        return new ByteFloatHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableByteFloatMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableByteFloatMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableByteFloatMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
