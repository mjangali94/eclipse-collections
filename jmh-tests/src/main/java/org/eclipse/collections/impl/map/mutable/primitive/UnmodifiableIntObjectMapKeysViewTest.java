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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyIntIterableTestCase;

/**
 * JUnit test for {@link UnmodifiableIntObjectMap#keysView}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapKeysViewTest.stg.
 */
public class UnmodifiableIntObjectMapKeysViewTest extends AbstractLazyIntIterableTestCase {

    @Override
    protected LazyIntIterable classUnderTest() {
        return IntObjectHashMap.newWithKeysValues(1, 1, 2, 2, 3, 3).asUnmodifiable().keysView();
    }

    @Override
    protected LazyIntIterable getEmptyIterable() {
        return IntObjectHashMap.newMap().asUnmodifiable().keysView();
    }

    @Override
    protected LazyIntIterable newWith(int element1, int element2) {
        return IntObjectHashMap.newWithKeysValues(element1, 1, element2, 2).asUnmodifiable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.lazy.primitive.AbstractLazyIntIterableTestCase._Benchmark {

        private UnmodifiableIntObjectMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableIntObjectMapKeysViewTest();
        }

        @java.lang.Override
        public UnmodifiableIntObjectMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
