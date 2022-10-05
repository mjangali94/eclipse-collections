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

import org.eclipse.collections.impl.map.primitive.AbstractShortBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ShortBooleanHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ShortBooleanHashMapKeyValuesViewTest extends AbstractShortBooleanMapKeyValuesViewTestCase {

    @Override
    public ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3) {
        return ShortBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2) {
        return ShortBooleanHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ShortBooleanHashMap newWithKeysValues(short key1, boolean value1) {
        return ShortBooleanHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ShortBooleanHashMap newEmpty() {
        return new ShortBooleanHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortBooleanMapKeyValuesViewTestCase._Benchmark {

        private ShortBooleanHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortBooleanHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ShortBooleanHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
