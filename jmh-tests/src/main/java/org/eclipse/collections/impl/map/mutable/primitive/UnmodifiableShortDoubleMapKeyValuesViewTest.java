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

import org.eclipse.collections.api.map.primitive.MutableShortDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableShortDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableShortDoubleMapKeyValuesViewTest extends AbstractShortDoubleMapKeyValuesViewTestCase {

    @Override
    public MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableShortDoubleMap newWithKeysValues(short key1, double value1) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableShortDoubleMap newEmpty() {
        return new ShortDoubleHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableShortDoubleMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableShortDoubleMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableShortDoubleMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
