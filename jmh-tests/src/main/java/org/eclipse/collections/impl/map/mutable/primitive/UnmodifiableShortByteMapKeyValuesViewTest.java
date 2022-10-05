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

import org.eclipse.collections.api.map.primitive.MutableShortByteMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableShortByteMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableShortByteMapKeyValuesViewTest extends AbstractShortByteMapKeyValuesViewTestCase {

    @Override
    public MutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3) {
        return ShortByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2) {
        return ShortByteHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableShortByteMap newWithKeysValues(short key1, byte value1) {
        return ShortByteHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableShortByteMap newEmpty() {
        return new ShortByteHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortByteMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableShortByteMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableShortByteMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableShortByteMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
