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

import org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ShortDoubleHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ShortDoubleHashMapKeyValuesViewTest extends AbstractShortDoubleMapKeyValuesViewTestCase {

    @Override
    public ShortDoubleHashMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ShortDoubleHashMap newWithKeysValues(short key1, double value1, short key2, double value2) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ShortDoubleHashMap newWithKeysValues(short key1, double value1) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ShortDoubleHashMap newEmpty() {
        return new ShortDoubleHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapKeyValuesViewTestCase._Benchmark {

        private ShortDoubleHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortDoubleHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ShortDoubleHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
