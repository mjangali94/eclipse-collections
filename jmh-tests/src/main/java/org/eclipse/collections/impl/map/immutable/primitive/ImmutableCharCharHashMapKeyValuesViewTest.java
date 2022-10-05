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

import org.eclipse.collections.api.map.primitive.ImmutableCharCharMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableCharCharHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableCharCharHashMapKeyValuesViewTest extends AbstractCharCharMapKeyValuesViewTestCase {

    @Override
    public ImmutableCharCharMap newWithKeysValues(char key1, char value1, char key2, char value2, char key3, char value3) {
        return CharCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableCharCharMap newWithKeysValues(char key1, char value1, char key2, char value2) {
        return CharCharHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableCharCharMap newWithKeysValues(char key1, char value1) {
        return CharCharHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableCharCharMap newEmpty() {
        return new CharCharHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharCharMapKeyValuesViewTestCase._Benchmark {

        private ImmutableCharCharHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableCharCharHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableCharCharHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
