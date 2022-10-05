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

import org.eclipse.collections.api.map.primitive.MutableDoubleLongMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableDoubleLongMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableDoubleLongMapKeyValuesViewTest extends AbstractDoubleLongMapKeyValuesViewTestCase {

    @Override
    public MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3) {
        return DoubleLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2) {
        return DoubleLongHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableDoubleLongMap newWithKeysValues(double key1, long value1) {
        return DoubleLongHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableDoubleLongMap newEmpty() {
        return new DoubleLongHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleLongMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableDoubleLongMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableDoubleLongMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableDoubleLongMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
