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

import org.eclipse.collections.api.map.primitive.ImmutableIntIntMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableIntIntHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableIntIntHashMapKeyValuesViewTest extends AbstractIntIntMapKeyValuesViewTestCase {

    @Override
    public ImmutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3) {
        return IntIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2) {
        return IntIntHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableIntIntMap newWithKeysValues(int key1, int value1) {
        return IntIntHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableIntIntMap newEmpty() {
        return new IntIntHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntIntMapKeyValuesViewTestCase._Benchmark {

        private ImmutableIntIntHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableIntIntHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableIntIntHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
