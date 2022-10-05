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
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapKeysViewTestCase;

/**
 * JUnit test for {@link SynchronizedObjectDoubleMap#keysView()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeysViewTest.stg.
 */
public class SynchronizedObjectDoubleMapKeysViewTest extends AbstractObjectDoubleMapKeysViewTestCase {

    @Override
    public <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        MutableObjectDoubleMap<T> map = ObjectDoubleHashMap.newMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.asSynchronized().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapKeysViewTestCase._Benchmark {

        private SynchronizedObjectDoubleMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedObjectDoubleMapKeysViewTest();
        }

        @java.lang.Override
        public SynchronizedObjectDoubleMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
