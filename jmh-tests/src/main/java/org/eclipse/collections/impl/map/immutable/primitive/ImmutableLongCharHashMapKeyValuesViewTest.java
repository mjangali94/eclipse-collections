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

import org.eclipse.collections.api.map.primitive.ImmutableLongCharMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableLongCharHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableLongCharHashMapKeyValuesViewTest extends AbstractLongCharMapKeyValuesViewTestCase {

    @Override
    public ImmutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3) {
        return LongCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2) {
        return LongCharHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableLongCharMap newWithKeysValues(long key1, char value1) {
        return LongCharHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableLongCharMap newEmpty() {
        return new LongCharHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongCharMapKeyValuesViewTestCase._Benchmark {

        private ImmutableLongCharHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableLongCharHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableLongCharHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
