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

import org.eclipse.collections.impl.map.primitive.AbstractShortCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ShortCharHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ShortCharHashMapKeyValuesViewTest extends AbstractShortCharMapKeyValuesViewTestCase {

    @Override
    public ShortCharHashMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3) {
        return ShortCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ShortCharHashMap newWithKeysValues(short key1, char value1, short key2, char value2) {
        return ShortCharHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ShortCharHashMap newWithKeysValues(short key1, char value1) {
        return ShortCharHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ShortCharHashMap newEmpty() {
        return new ShortCharHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortCharMapKeyValuesViewTestCase._Benchmark {

        private ShortCharHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortCharHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ShortCharHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
