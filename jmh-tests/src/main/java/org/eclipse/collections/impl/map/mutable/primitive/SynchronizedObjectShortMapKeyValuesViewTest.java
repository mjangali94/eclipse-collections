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

import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedObjectShortMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedObjectShortMapKeyValuesViewTest extends AbstractObjectShortMapKeyValuesViewTestCase {

    @Override
    public <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableObjectShortMap<Object> newEmpty() {
        return ObjectShortHashMap.newMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectShortMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedObjectShortMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectShortMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedObjectShortMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
