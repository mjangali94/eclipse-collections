/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableByteCharMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableByteCharHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableByteCharHashMapKeyValuesViewTest extends AbstractByteCharMapKeyValuesViewTestCase {

    @Override
    public ImmutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3) {
        return ByteCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2) {
        return ByteCharHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableByteCharMap newWithKeysValues(byte key1, char value1) {
        return ByteCharHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableByteCharMap newEmpty() {
        return new ByteCharHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteCharMapKeyValuesViewTestCase._Benchmark {

        private ImmutableByteCharHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableByteCharHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableByteCharHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
