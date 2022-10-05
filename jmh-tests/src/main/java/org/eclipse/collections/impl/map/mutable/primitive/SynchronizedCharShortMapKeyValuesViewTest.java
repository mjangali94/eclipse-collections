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

import org.eclipse.collections.api.map.primitive.MutableCharShortMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedCharShortMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedCharShortMapKeyValuesViewTest extends AbstractCharShortMapKeyValuesViewTestCase {

    @Override
    public MutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3) {
        return CharShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2) {
        return CharShortHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableCharShortMap newWithKeysValues(char key1, short value1) {
        return CharShortHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableCharShortMap newEmpty() {
        return new CharShortHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharShortMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedCharShortMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharShortMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedCharShortMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
