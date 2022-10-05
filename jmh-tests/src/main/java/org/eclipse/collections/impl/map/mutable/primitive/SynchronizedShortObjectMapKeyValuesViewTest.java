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

import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortObjectMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedShortObjectMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapKeyValuesViewTest.stg.
 */
public class SynchronizedShortObjectMapKeyValuesViewTest extends AbstractShortObjectMapKeyValuesViewTestCase {

    @Override
    public MutableShortObjectMap<Integer> newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3) {
        return ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableShortObjectMap<Integer> newWithKeysValues(short key1, int value1, short key2, int value2) {
        return ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableShortObjectMap<Integer> newWithKeysValues(short key1, int value1) {
        return ShortObjectHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableShortObjectMap<Integer> newEmpty() {
        return ShortObjectHashMap.<Integer>newMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortObjectMapKeyValuesViewTestCase._Benchmark {

        private SynchronizedShortObjectMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedShortObjectMapKeyValuesViewTest();
        }

        @java.lang.Override
        public SynchronizedShortObjectMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
