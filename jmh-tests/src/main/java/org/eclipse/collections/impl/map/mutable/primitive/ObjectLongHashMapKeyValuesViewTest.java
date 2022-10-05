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

import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ObjectLongHashMap#keyValuesView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ObjectLongHashMapKeyValuesViewTest extends AbstractObjectLongMapKeyValuesViewTestCase {

    @Override
    public <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectLongMap<Integer> newEmpty() {
        return ObjectLongHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapKeyValuesViewTestCase._Benchmark {

        private ObjectLongHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectLongHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ObjectLongHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
