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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterableTestCase;

/**
 * JUnit test for {@link SynchronizedLongObjectMap#keysView}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapKeysViewTest.stg.
 */
public class SynchronizedLongObjectMapKeysViewTest extends AbstractLazyLongIterableTestCase {

    @Override
    protected LazyLongIterable classUnderTest() {
        return LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3).asSynchronized().keysView();
    }

    @Override
    protected LazyLongIterable getEmptyIterable() {
        return LongObjectHashMap.newMap().asSynchronized().keysView();
    }

    @Override
    protected LazyLongIterable newWith(long element1, long element2) {
        return LongObjectHashMap.newWithKeysValues(element1, 1, element2, 2).asSynchronized().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterableTestCase._Benchmark {

        private SynchronizedLongObjectMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedLongObjectMapKeysViewTest();
        }

        @java.lang.Override
        public SynchronizedLongObjectMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
