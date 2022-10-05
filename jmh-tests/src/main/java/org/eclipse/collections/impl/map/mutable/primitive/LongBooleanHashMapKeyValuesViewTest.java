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

import org.eclipse.collections.impl.map.primitive.AbstractLongBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link LongBooleanHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class LongBooleanHashMapKeyValuesViewTest extends AbstractLongBooleanMapKeyValuesViewTestCase {

    @Override
    public LongBooleanHashMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3) {
        return LongBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public LongBooleanHashMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2) {
        return LongBooleanHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public LongBooleanHashMap newWithKeysValues(long key1, boolean value1) {
        return LongBooleanHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public LongBooleanHashMap newEmpty() {
        return new LongBooleanHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongBooleanMapKeyValuesViewTestCase._Benchmark {

        private LongBooleanHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongBooleanHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public LongBooleanHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
