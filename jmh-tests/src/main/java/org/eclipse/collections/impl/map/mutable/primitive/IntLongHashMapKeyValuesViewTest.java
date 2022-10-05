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

import org.eclipse.collections.impl.map.primitive.AbstractIntLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link IntLongHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class IntLongHashMapKeyValuesViewTest extends AbstractIntLongMapKeyValuesViewTestCase {

    @Override
    public IntLongHashMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3) {
        return IntLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public IntLongHashMap newWithKeysValues(int key1, long value1, int key2, long value2) {
        return IntLongHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public IntLongHashMap newWithKeysValues(int key1, long value1) {
        return IntLongHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public IntLongHashMap newEmpty() {
        return new IntLongHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntLongMapKeyValuesViewTestCase._Benchmark {

        private IntLongHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntLongHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public IntLongHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
