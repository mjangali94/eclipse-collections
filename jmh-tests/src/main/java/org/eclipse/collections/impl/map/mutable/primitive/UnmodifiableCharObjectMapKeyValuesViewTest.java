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

import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharObjectMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableCharObjectMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapKeyValuesViewTest.stg.
 */
public class UnmodifiableCharObjectMapKeyValuesViewTest extends AbstractCharObjectMapKeyValuesViewTestCase {

    @Override
    public MutableCharObjectMap<Integer> newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3) {
        return CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableCharObjectMap<Integer> newWithKeysValues(char key1, int value1, char key2, int value2) {
        return CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableCharObjectMap<Integer> newWithKeysValues(char key1, int value1) {
        return CharObjectHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableCharObjectMap<Integer> newEmpty() {
        return CharObjectHashMap.<Integer>newMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharObjectMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableCharObjectMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableCharObjectMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableCharObjectMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
