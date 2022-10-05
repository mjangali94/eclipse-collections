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

import org.eclipse.collections.impl.map.primitive.AbstractDoubleFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link DoubleFloatHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class DoubleFloatHashMapKeyValuesViewTest extends AbstractDoubleFloatMapKeyValuesViewTestCase {

    @Override
    public DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3) {
        return DoubleFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2) {
        return DoubleFloatHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public DoubleFloatHashMap newWithKeysValues(double key1, float value1) {
        return DoubleFloatHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public DoubleFloatHashMap newEmpty() {
        return new DoubleFloatHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleFloatMapKeyValuesViewTestCase._Benchmark {

        private DoubleFloatHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleFloatHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public DoubleFloatHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
