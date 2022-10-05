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

import org.eclipse.collections.api.map.primitive.ImmutableByteByteMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableByteByteHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableByteByteHashMapKeyValuesViewTest extends AbstractByteByteMapKeyValuesViewTestCase {

    @Override
    public ImmutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3) {
        return ByteByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2) {
        return ByteByteHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableByteByteMap newWithKeysValues(byte key1, byte value1) {
        return ByteByteHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableByteByteMap newEmpty() {
        return new ByteByteHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteByteMapKeyValuesViewTestCase._Benchmark {

        private ImmutableByteByteHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableByteByteHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableByteByteHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
