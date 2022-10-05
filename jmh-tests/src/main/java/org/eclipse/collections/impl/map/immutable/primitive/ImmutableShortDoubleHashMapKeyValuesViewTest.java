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

import org.eclipse.collections.api.map.primitive.ImmutableShortDoubleMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableShortDoubleHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableShortDoubleHashMapKeyValuesViewTest extends AbstractShortDoubleMapKeyValuesViewTestCase {

    @Override
    public ImmutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableShortDoubleMap newWithKeysValues(short key1, double value1) {
        return ShortDoubleHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableShortDoubleMap newEmpty() {
        return new ShortDoubleHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapKeyValuesViewTestCase._Benchmark {

        private ImmutableShortDoubleHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableShortDoubleHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableShortDoubleHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
