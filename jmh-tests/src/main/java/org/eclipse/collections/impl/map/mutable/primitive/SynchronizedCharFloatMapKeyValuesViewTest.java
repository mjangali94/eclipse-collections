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

import org.eclipse.collections.api.map.primitive.MutableCharFloatMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedCharFloatMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedCharFloatMapKeyValuesViewTest extends AbstractCharFloatMapKeyValuesViewTestCase {

    @Override
    public MutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3) {
        return CharFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2) {
        return CharFloatHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableCharFloatMap newWithKeysValues(char key1, float value1) {
        return CharFloatHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableCharFloatMap newEmpty() {
        return new CharFloatHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharFloatMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedCharFloatMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharFloatMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedCharFloatMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
