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

import org.eclipse.collections.impl.map.primitive.AbstractIntShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link IntShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class IntShortHashMapKeyValuesViewTest extends AbstractIntShortMapKeyValuesViewTestCase {

    @Override
    public IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3) {
        return IntShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2) {
        return IntShortHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public IntShortHashMap newWithKeysValues(int key1, short value1) {
        return IntShortHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public IntShortHashMap newEmpty() {
        return new IntShortHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntShortMapKeyValuesViewTestCase._Benchmark {

        private IntShortHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntShortHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public IntShortHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
