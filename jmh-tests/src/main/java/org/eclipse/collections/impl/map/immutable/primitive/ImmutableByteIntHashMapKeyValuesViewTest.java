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

import org.eclipse.collections.api.map.primitive.ImmutableByteIntMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableByteIntHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableByteIntHashMapKeyValuesViewTest extends AbstractByteIntMapKeyValuesViewTestCase {

    @Override
    public ImmutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3) {
        return ByteIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2) {
        return ByteIntHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableByteIntMap newWithKeysValues(byte key1, int value1) {
        return ByteIntHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableByteIntMap newEmpty() {
        return new ByteIntHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteIntMapKeyValuesViewTestCase._Benchmark {

        private ImmutableByteIntHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableByteIntHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableByteIntHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
