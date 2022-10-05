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

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectByteMapKeysViewTestCase;

/**
 * JUnit test for {@link SynchronizedObjectByteMap#keysView()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeysViewTest.stg.
 */
public class SynchronizedObjectByteMapKeysViewTest extends AbstractObjectByteMapKeysViewTestCase {

    @Override
    public <T> MutableObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        MutableObjectByteMap<T> map = ObjectByteHashMap.newMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (byte) i);
        }
        return map.asSynchronized().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectByteMapKeysViewTestCase._Benchmark {

        private SynchronizedObjectByteMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectByteMapKeysViewTest();
        }

        @java.lang.Override
        public SynchronizedObjectByteMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
