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

import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedLongDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedLongDoubleMapKeyValuesViewTest extends AbstractLongDoubleMapKeyValuesViewTestCase {

    @Override
    public MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableLongDoubleMap newWithKeysValues(long key1, double value1) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableLongDoubleMap newEmpty() {
        return new LongDoubleHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedLongDoubleMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongDoubleMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedLongDoubleMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
