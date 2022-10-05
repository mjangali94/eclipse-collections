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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleShortMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableDoubleShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableDoubleShortHashMapKeyValuesViewTest extends AbstractDoubleShortMapKeyValuesViewTestCase {

    @Override
    public ImmutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3) {
        return DoubleShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2) {
        return DoubleShortHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableDoubleShortMap newWithKeysValues(double key1, short value1) {
        return DoubleShortHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableDoubleShortMap newEmpty() {
        return new DoubleShortHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleShortMapKeyValuesViewTestCase._Benchmark {

        private ImmutableDoubleShortHashMapKeyValuesViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableDoubleShortHashMapKeyValuesViewTest();
        }

        @java.lang.Override
        public ImmutableDoubleShortHashMapKeyValuesViewTest implementation() {
            return this.implementation;
        }
    }
}
