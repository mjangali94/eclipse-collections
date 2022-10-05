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

import org.eclipse.collections.impl.map.primitive.AbstractShortShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ShortShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ShortShortHashMapKeyValuesViewTest extends AbstractShortShortMapKeyValuesViewTestCase {

    @Override
    public ShortShortHashMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3) {
        return ShortShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ShortShortHashMap newWithKeysValues(short key1, short value1, short key2, short value2) {
        return ShortShortHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ShortShortHashMap newWithKeysValues(short key1, short value1) {
        return ShortShortHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ShortShortHashMap newEmpty() {
        return new ShortShortHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortShortMapKeyValuesViewTestCase._Benchmark {

        private ShortShortHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortShortHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ShortShortHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
