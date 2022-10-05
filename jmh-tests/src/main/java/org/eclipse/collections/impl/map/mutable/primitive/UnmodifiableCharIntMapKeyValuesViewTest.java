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

import org.eclipse.collections.api.map.primitive.MutableCharIntMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableCharIntMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableCharIntMapKeyValuesViewTest extends AbstractCharIntMapKeyValuesViewTestCase {

    @Override
    public MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3) {
        return CharIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2) {
        return CharIntHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableCharIntMap newWithKeysValues(char key1, int value1) {
        return CharIntHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableCharIntMap newEmpty() {
        return new CharIntHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharIntMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableCharIntMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableCharIntMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableCharIntMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
