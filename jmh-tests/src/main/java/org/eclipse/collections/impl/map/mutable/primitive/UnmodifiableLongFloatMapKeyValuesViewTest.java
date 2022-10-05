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

import org.eclipse.collections.api.map.primitive.MutableLongFloatMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableLongFloatMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableLongFloatMapKeyValuesViewTest extends AbstractLongFloatMapKeyValuesViewTestCase {

    @Override
    public MutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3) {
        return LongFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2) {
        return LongFloatHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableLongFloatMap newWithKeysValues(long key1, float value1) {
        return LongFloatHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableLongFloatMap newEmpty() {
        return new LongFloatHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongFloatMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableLongFloatMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableLongFloatMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableLongFloatMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
