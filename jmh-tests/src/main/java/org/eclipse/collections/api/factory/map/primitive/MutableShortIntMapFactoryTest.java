/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.factory.map.primitive;

import org.eclipse.collections.api.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableShortIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableShortIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ShortIntHashMap(), ShortIntMaps.mutable.with());
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2), ShortIntMaps.mutable.with((short) 1, 2));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2, (short) 3, 4), ShortIntMaps.mutable.with((short) 1, 2, (short) 3, 4));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2, (short) 3, 4, (short) 5, 6), ShortIntMaps.mutable.with((short) 1, 2, (short) 3, 4, (short) 5, 6));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2, (short) 3, 4, (short) 5, 6, (short) 7, 8), ShortIntMaps.mutable.with((short) 1, 2, (short) 3, 4, (short) 5, 6, (short) 7, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ShortIntHashMap(), ShortIntMaps.mutable.of());
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2), ShortIntMaps.mutable.of((short) 1, 2));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2, (short) 3, 4), ShortIntMaps.mutable.of((short) 1, 2, (short) 3, 4));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2, (short) 3, 4, (short) 5, 6), ShortIntMaps.mutable.of((short) 1, 2, (short) 3, 4, (short) 5, 6));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2, (short) 3, 4, (short) 5, 6, (short) 7, 8), ShortIntMaps.mutable.of((short) 1, 2, (short) 3, 4, (short) 5, 6, (short) 7, 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        private MutableShortIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableShortIntMapFactoryTest();
        }

        @java.lang.Override
        public MutableShortIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
