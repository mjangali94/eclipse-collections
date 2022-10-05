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

import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedDoubleDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedDoubleDoubleMapKeyValuesViewTest extends AbstractDoubleDoubleMapKeyValuesViewTestCase {

    @Override
    public MutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3) {
        return DoubleDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2) {
        return DoubleDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableDoubleDoubleMap newWithKeysValues(double key1, double value1) {
        return DoubleDoubleHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableDoubleDoubleMap newEmpty() {
        return new DoubleDoubleHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleDoubleMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedDoubleDoubleMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedDoubleDoubleMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedDoubleDoubleMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
