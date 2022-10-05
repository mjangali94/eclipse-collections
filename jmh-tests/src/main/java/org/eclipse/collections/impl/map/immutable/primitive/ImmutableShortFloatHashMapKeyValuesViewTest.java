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

import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableShortFloatHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableShortFloatHashMapKeyValuesViewTest extends AbstractShortFloatMapKeyValuesViewTestCase {

    @Override
    public ImmutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3) {
        return ShortFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2) {
        return ShortFloatHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableShortFloatMap newWithKeysValues(short key1, float value1) {
        return ShortFloatHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableShortFloatMap newEmpty() {
        return new ShortFloatHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortFloatMapKeyValuesViewTestCase._Benchmark {

        private ImmutableShortFloatHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableShortFloatHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableShortFloatHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
