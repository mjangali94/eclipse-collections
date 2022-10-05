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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyShortIterableTestCase;

/**
 * JUnit test for {@link UnmodifiableShortObjectMap#keysView}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapKeysViewTest.stg.
 */
public class UnmodifiableShortObjectMapKeysViewTest extends AbstractLazyShortIterableTestCase {

    @Override
    protected LazyShortIterable classUnderTest() {
        return ShortObjectHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3).asUnmodifiable().keysView();
    }

    @Override
    protected LazyShortIterable getEmptyIterable() {
        return ShortObjectHashMap.newMap().asUnmodifiable().keysView();
    }

    @Override
    protected LazyShortIterable newWith(short element1, short element2) {
        return ShortObjectHashMap.newWithKeysValues(element1, 1, element2, 2).asUnmodifiable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.lazy.primitive.AbstractLazyShortIterableTestCase._Benchmark {

        private UnmodifiableShortObjectMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableShortObjectMapKeysViewTest();
        }

        @java.lang.Override
        public UnmodifiableShortObjectMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
