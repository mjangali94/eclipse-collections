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

import org.eclipse.collections.impl.map.primitive.AbstractIntIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link IntIntHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class IntIntHashMapKeyValuesViewTest extends AbstractIntIntMapKeyValuesViewTestCase {

    @Override
    public IntIntHashMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3) {
        return IntIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public IntIntHashMap newWithKeysValues(int key1, int value1, int key2, int value2) {
        return IntIntHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public IntIntHashMap newWithKeysValues(int key1, int value1) {
        return IntIntHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public IntIntHashMap newEmpty() {
        return new IntIntHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntIntMapKeyValuesViewTestCase._Benchmark {

        private IntIntHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntIntHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public IntIntHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
