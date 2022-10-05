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

import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongObjectMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableLongObjectMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapKeyValuesViewTest.stg.
 */
public class UnmodifiableLongObjectMapKeyValuesViewTest extends AbstractLongObjectMapKeyValuesViewTestCase {

    @Override
    public MutableLongObjectMap<Integer> newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3) {
        return LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableLongObjectMap<Integer> newWithKeysValues(long key1, int value1, long key2, int value2) {
        return LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableLongObjectMap<Integer> newWithKeysValues(long key1, int value1) {
        return LongObjectHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableLongObjectMap<Integer> newEmpty() {
        return LongObjectHashMap.<Integer>newMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongObjectMapKeyValuesViewTestCase._Benchmark {

        private UnmodifiableLongObjectMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableLongObjectMapKeyValuesViewTest();
        }

        @java.lang.Override
        public UnmodifiableLongObjectMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
