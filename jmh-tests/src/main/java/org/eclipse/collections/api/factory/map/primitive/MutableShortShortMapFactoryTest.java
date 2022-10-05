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

import org.eclipse.collections.api.factory.primitive.ShortShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableShortShortMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableShortShortMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ShortShortHashMap(), ShortShortMaps.mutable.with());
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2), ShortShortMaps.mutable.with((short) 1, (short) 2));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2, (short) 3, (short) 4), ShortShortMaps.mutable.with((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), ShortShortMaps.mutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), ShortShortMaps.mutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ShortShortHashMap(), ShortShortMaps.mutable.of());
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2), ShortShortMaps.mutable.of((short) 1, (short) 2));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2, (short) 3, (short) 4), ShortShortMaps.mutable.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), ShortShortMaps.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), ShortShortMaps.mutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
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

        private MutableShortShortMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableShortShortMapFactoryTest();
        }

        @java.lang.Override
        public MutableShortShortMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
