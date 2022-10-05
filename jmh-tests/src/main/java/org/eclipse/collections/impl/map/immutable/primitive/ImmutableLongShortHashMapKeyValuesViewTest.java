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

import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableLongShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableLongShortHashMapKeyValuesViewTest extends AbstractLongShortMapKeyValuesViewTestCase {

    @Override
    public ImmutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3) {
        return LongShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2) {
        return LongShortHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableLongShortMap newWithKeysValues(long key1, short value1) {
        return LongShortHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableLongShortMap newEmpty() {
        return new LongShortHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongShortMapKeyValuesViewTestCase._Benchmark {

        private ImmutableLongShortHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableLongShortHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableLongShortHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
