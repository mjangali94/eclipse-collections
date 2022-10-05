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

import org.eclipse.collections.api.map.primitive.MutableIntCharMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableIntCharMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableIntCharMapKeyValuesViewTest extends AbstractIntCharMapKeyValuesViewTestCase {

    @Override
    public MutableIntCharMap newWithKeysValues(int key1, char value1, int key2, char value2, int key3, char value3) {
        return IntCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableIntCharMap newWithKeysValues(int key1, char value1, int key2, char value2) {
        return IntCharHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableIntCharMap newWithKeysValues(int key1, char value1) {
        return IntCharHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableIntCharMap newEmpty() {
        return new IntCharHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntCharMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableIntCharMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableIntCharMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableIntCharMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
