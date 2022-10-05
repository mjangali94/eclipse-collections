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

import org.eclipse.collections.api.map.primitive.ImmutableIntShortMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableIntShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableIntShortHashMapKeyValuesViewTest extends AbstractIntShortMapKeyValuesViewTestCase {

    @Override
    public ImmutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3) {
        return IntShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2) {
        return IntShortHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableIntShortMap newWithKeysValues(int key1, short value1) {
        return IntShortHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableIntShortMap newEmpty() {
        return new IntShortHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntShortMapKeyValuesViewTestCase._Benchmark {

        private ImmutableIntShortHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableIntShortHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableIntShortHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
