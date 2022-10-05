/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableCharBooleanHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableCharBooleanHashMapKeyValuesViewTest extends AbstractCharBooleanMapKeyValuesViewTestCase {

    @Override
    public ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3) {
        return CharBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2) {
        return CharBooleanHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableCharBooleanMap newWithKeysValues(char key1, boolean value1) {
        return CharBooleanHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableCharBooleanMap newEmpty() {
        return new CharBooleanHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharBooleanMapKeyValuesViewTestCase._Benchmark {

        private ImmutableCharBooleanHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableCharBooleanHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableCharBooleanHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
