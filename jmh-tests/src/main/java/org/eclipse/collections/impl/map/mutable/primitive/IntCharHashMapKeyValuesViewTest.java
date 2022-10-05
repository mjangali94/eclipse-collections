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

import org.eclipse.collections.impl.map.primitive.AbstractIntCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link IntCharHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class IntCharHashMapKeyValuesViewTest extends AbstractIntCharMapKeyValuesViewTestCase {

    @Override
    public IntCharHashMap newWithKeysValues(int key1, char value1, int key2, char value2, int key3, char value3) {
        return IntCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public IntCharHashMap newWithKeysValues(int key1, char value1, int key2, char value2) {
        return IntCharHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public IntCharHashMap newWithKeysValues(int key1, char value1) {
        return IntCharHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public IntCharHashMap newEmpty() {
        return new IntCharHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntCharMapKeyValuesViewTestCase._Benchmark {

        private IntCharHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntCharHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public IntCharHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
