/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectIntMapKeysViewTestCase;

/**
 * JUnit test for {@link ImmutableObjectIntHashMap#keysView()}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapKeysViewTest.stg.
 */
public class ImmutableObjectIntHashMapKeysViewTest extends AbstractObjectIntMapKeysViewTestCase {

    @Override
    public <T> ImmutableObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectIntHashMap<T> map = new ObjectIntHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.toImmutable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectIntMapKeysViewTestCase._Benchmark {

        private ImmutableObjectIntHashMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableObjectIntHashMapKeysViewTest();
        }

        @java.lang.Override
        public ImmutableObjectIntHashMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
