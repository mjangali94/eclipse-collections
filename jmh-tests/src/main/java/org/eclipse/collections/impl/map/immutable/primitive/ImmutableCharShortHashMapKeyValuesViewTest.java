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

import org.eclipse.collections.api.map.primitive.ImmutableCharShortMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableCharShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableCharShortHashMapKeyValuesViewTest extends AbstractCharShortMapKeyValuesViewTestCase {

    @Override
    public ImmutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3) {
        return CharShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2) {
        return CharShortHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableCharShortMap newWithKeysValues(char key1, short value1) {
        return CharShortHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableCharShortMap newEmpty() {
        return new CharShortHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharShortMapKeyValuesViewTestCase._Benchmark {

        private ImmutableCharShortHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableCharShortHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableCharShortHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
