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

import org.eclipse.collections.api.factory.primitive.DoubleShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableDoubleShortMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableDoubleShortMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new DoubleShortHashMap(), DoubleShortMaps.mutable.with());
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2), DoubleShortMaps.mutable.with(1.0, (short) 2));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4), DoubleShortMaps.mutable.with(1.0, (short) 2, 3.0, (short) 4));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6), DoubleShortMaps.mutable.with(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6, 7.0, (short) 8), DoubleShortMaps.mutable.with(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6, 7.0, (short) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new DoubleShortHashMap(), DoubleShortMaps.mutable.of());
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2), DoubleShortMaps.mutable.of(1.0, (short) 2));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4), DoubleShortMaps.mutable.of(1.0, (short) 2, 3.0, (short) 4));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6), DoubleShortMaps.mutable.of(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6, 7.0, (short) 8), DoubleShortMaps.mutable.of(1.0, (short) 2, 3.0, (short) 4, 5.0, (short) 6, 7.0, (short) 8));
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

        private MutableDoubleShortMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableDoubleShortMapFactoryTest();
        }

        @java.lang.Override
        public MutableDoubleShortMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
