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

import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ObjectDoubleHashMap#keyValuesView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ObjectDoubleHashMapKeyValuesViewTest extends AbstractObjectDoubleMapKeyValuesViewTestCase {

    @Override
    public <T> ObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <T> ObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public <T> ObjectDoubleMap<T> newWithKeysValues(T key1, double value1) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectDoubleMap<Integer> newEmpty() {
        return ObjectDoubleHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapKeyValuesViewTestCase._Benchmark {

        private ObjectDoubleHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectDoubleHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ObjectDoubleHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
