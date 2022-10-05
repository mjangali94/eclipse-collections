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

import org.eclipse.collections.api.factory.primitive.IntShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableIntShortMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableIntShortMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new IntShortHashMap(), IntShortMaps.mutable.with());
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2), IntShortMaps.mutable.with(1, (short) 2));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2, 3, (short) 4), IntShortMaps.mutable.with(1, (short) 2, 3, (short) 4));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2, 3, (short) 4, 5, (short) 6), IntShortMaps.mutable.with(1, (short) 2, 3, (short) 4, 5, (short) 6));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2, 3, (short) 4, 5, (short) 6, 7, (short) 8), IntShortMaps.mutable.with(1, (short) 2, 3, (short) 4, 5, (short) 6, 7, (short) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new IntShortHashMap(), IntShortMaps.mutable.of());
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2), IntShortMaps.mutable.of(1, (short) 2));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2, 3, (short) 4), IntShortMaps.mutable.of(1, (short) 2, 3, (short) 4));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2, 3, (short) 4, 5, (short) 6), IntShortMaps.mutable.of(1, (short) 2, 3, (short) 4, 5, (short) 6));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2, 3, (short) 4, 5, (short) 6, 7, (short) 8), IntShortMaps.mutable.of(1, (short) 2, 3, (short) 4, 5, (short) 6, 7, (short) 8));
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

        private MutableIntShortMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableIntShortMapFactoryTest();
        }

        @java.lang.Override
        public MutableIntShortMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
