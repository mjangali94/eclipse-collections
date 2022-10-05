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

import org.eclipse.collections.api.map.primitive.ImmutableIntByteMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableIntByteHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableIntByteHashMapKeyValuesViewTest extends AbstractIntByteMapKeyValuesViewTestCase {

    @Override
    public ImmutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3) {
        return IntByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2) {
        return IntByteHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableIntByteMap newWithKeysValues(int key1, byte value1) {
        return IntByteHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableIntByteMap newEmpty() {
        return new IntByteHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntByteMapKeyValuesViewTestCase._Benchmark {

        private ImmutableIntByteHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableIntByteHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableIntByteHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
