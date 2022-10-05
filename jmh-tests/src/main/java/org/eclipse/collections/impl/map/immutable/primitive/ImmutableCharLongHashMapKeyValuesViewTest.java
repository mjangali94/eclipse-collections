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

import org.eclipse.collections.api.map.primitive.ImmutableCharLongMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableCharLongHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableCharLongHashMapKeyValuesViewTest extends AbstractCharLongMapKeyValuesViewTestCase {

    @Override
    public ImmutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3) {
        return CharLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2) {
        return CharLongHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableCharLongMap newWithKeysValues(char key1, long value1) {
        return CharLongHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableCharLongMap newEmpty() {
        return new CharLongHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharLongMapKeyValuesViewTestCase._Benchmark {

        private ImmutableCharLongHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableCharLongHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableCharLongHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
