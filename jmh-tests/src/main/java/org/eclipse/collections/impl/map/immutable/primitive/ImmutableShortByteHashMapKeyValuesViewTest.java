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

import org.eclipse.collections.api.map.primitive.ImmutableShortByteMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableShortByteHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableShortByteHashMapKeyValuesViewTest extends AbstractShortByteMapKeyValuesViewTestCase {

    @Override
    public ImmutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3) {
        return ShortByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2) {
        return ShortByteHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableShortByteMap newWithKeysValues(short key1, byte value1) {
        return ShortByteHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableShortByteMap newEmpty() {
        return new ShortByteHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortByteMapKeyValuesViewTestCase._Benchmark {

        private ImmutableShortByteHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableShortByteHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableShortByteHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
