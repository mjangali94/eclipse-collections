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

import org.eclipse.collections.api.map.primitive.MutableByteByteMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedByteByteMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedByteByteMapKeyValuesViewTest extends AbstractByteByteMapKeyValuesViewTestCase {

    @Override
    public MutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3) {
        return ByteByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2) {
        return ByteByteHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableByteByteMap newWithKeysValues(byte key1, byte value1) {
        return ByteByteHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableByteByteMap newEmpty() {
        return new ByteByteHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteByteMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedByteByteMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedByteByteMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedByteByteMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
