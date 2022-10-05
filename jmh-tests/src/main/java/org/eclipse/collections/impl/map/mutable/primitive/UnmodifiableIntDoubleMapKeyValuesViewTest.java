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

import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableIntDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableIntDoubleMapKeyValuesViewTest extends AbstractIntDoubleMapKeyValuesViewTestCase {

    @Override
    public MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3) {
        return IntDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2) {
        return IntDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableIntDoubleMap newWithKeysValues(int key1, double value1) {
        return IntDoubleHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableIntDoubleMap newEmpty() {
        return new IntDoubleHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntDoubleMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableIntDoubleMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableIntDoubleMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableIntDoubleMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
