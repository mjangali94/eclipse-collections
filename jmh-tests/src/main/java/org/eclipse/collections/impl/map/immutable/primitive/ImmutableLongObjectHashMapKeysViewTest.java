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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterableTestCase;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;

/**
 * JUnit test for {@link ImmutableLongObjectHashMap#keysView}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapKeysViewTest.stg.
 */
public class ImmutableLongObjectHashMapKeysViewTest extends AbstractLazyLongIterableTestCase {

    @Override
    protected LazyLongIterable classUnderTest() {
        return LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3).toImmutable().keysView();
    }

    @Override
    protected LazyLongIterable getEmptyIterable() {
        return LongObjectHashMap.newMap().toImmutable().keysView();
    }

    @Override
    protected LazyLongIterable newWith(long element1, long element2) {
        return LongObjectHashMap.newWithKeysValues(element1, 1, element2, 2).toImmutable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterableTestCase._Benchmark {

        private ImmutableLongObjectHashMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableLongObjectHashMapKeysViewTest();
        }

        @java.lang.Override
        public ImmutableLongObjectHashMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
