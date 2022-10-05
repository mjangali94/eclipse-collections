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

import org.eclipse.collections.api.map.primitive.MutableByteLongMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableByteLongMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableByteLongMapKeyValuesViewTest extends AbstractByteLongMapKeyValuesViewTestCase {

    @Override
    public MutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3) {
        return ByteLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2) {
        return ByteLongHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableByteLongMap newWithKeysValues(byte key1, long value1) {
        return ByteLongHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableByteLongMap newEmpty() {
        return new ByteLongHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteLongMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableByteLongMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableByteLongMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableByteLongMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
