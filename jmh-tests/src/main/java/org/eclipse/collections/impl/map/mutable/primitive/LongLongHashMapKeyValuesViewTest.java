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

import org.eclipse.collections.impl.map.primitive.AbstractLongLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link LongLongHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class LongLongHashMapKeyValuesViewTest extends AbstractLongLongMapKeyValuesViewTestCase {

    @Override
    public LongLongHashMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3) {
        return LongLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public LongLongHashMap newWithKeysValues(long key1, long value1, long key2, long value2) {
        return LongLongHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public LongLongHashMap newWithKeysValues(long key1, long value1) {
        return LongLongHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public LongLongHashMap newEmpty() {
        return new LongLongHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongLongMapKeyValuesViewTestCase._Benchmark {

        private LongLongHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongLongHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public LongLongHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
