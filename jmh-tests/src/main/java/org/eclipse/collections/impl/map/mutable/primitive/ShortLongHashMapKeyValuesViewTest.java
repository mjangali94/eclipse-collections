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

import org.eclipse.collections.impl.map.primitive.AbstractShortLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ShortLongHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ShortLongHashMapKeyValuesViewTest extends AbstractShortLongMapKeyValuesViewTestCase {

    @Override
    public ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3) {
        return ShortLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2) {
        return ShortLongHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ShortLongHashMap newWithKeysValues(short key1, long value1) {
        return ShortLongHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ShortLongHashMap newEmpty() {
        return new ShortLongHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortLongMapKeyValuesViewTestCase._Benchmark {

        private ShortLongHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortLongHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ShortLongHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
