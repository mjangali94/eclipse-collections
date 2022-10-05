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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyCharIterableTestCase;

/**
 * JUnit test for {@link SynchronizedCharObjectMap#keysView}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapKeysViewTest.stg.
 */
public class SynchronizedCharObjectMapKeysViewTest extends AbstractLazyCharIterableTestCase {

    @Override
    protected LazyCharIterable classUnderTest() {
        return CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3).asSynchronized().keysView();
    }

    @Override
    protected LazyCharIterable getEmptyIterable() {
        return CharObjectHashMap.newMap().asSynchronized().keysView();
    }

    @Override
    protected LazyCharIterable newWith(char element1, char element2) {
        return CharObjectHashMap.newWithKeysValues(element1, 1, element2, 2).asSynchronized().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.lazy.primitive.AbstractLazyCharIterableTestCase._Benchmark {

        private SynchronizedCharObjectMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedCharObjectMapKeysViewTest();
        }

        @java.lang.Override
        public SynchronizedCharObjectMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
