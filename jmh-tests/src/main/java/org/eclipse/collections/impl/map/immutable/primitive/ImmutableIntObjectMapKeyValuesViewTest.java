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

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntObjectMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableIntObjectHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapKeyValuesViewTest.stg.
 */
public class ImmutableIntObjectMapKeyValuesViewTest extends AbstractIntObjectMapKeyValuesViewTestCase {

    @Override
    public ImmutableIntObjectMap<Integer> newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3) {
        return IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableIntObjectMap<Integer> newWithKeysValues(int key1, int value1, int key2, int value2) {
        return IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableIntObjectMap<Integer> newWithKeysValues(int key1, int value1) {
        return IntObjectHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableIntObjectMap<Integer> newEmpty() {
        return IntObjectHashMap.<Integer>newMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntObjectMapKeyValuesViewTestCase._Benchmark {

        private ImmutableIntObjectMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableIntObjectMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableIntObjectMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
