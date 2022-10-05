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

import org.eclipse.collections.api.factory.primitive.DoubleDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableDoubleDoubleMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableDoubleDoubleMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new DoubleDoubleHashMap(), DoubleDoubleMaps.mutable.with());
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0), DoubleDoubleMaps.mutable.with(1.0, 2.0));
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0, 3.0, 4.0), DoubleDoubleMaps.mutable.with(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), DoubleDoubleMaps.mutable.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), DoubleDoubleMaps.mutable.with(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
    }

    @Test
    public void of() {
        Assert.assertEquals(new DoubleDoubleHashMap(), DoubleDoubleMaps.mutable.of());
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0), DoubleDoubleMaps.mutable.of(1.0, 2.0));
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0, 3.0, 4.0), DoubleDoubleMaps.mutable.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), DoubleDoubleMaps.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), DoubleDoubleMaps.mutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
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

        private MutableDoubleDoubleMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableDoubleDoubleMapFactoryTest();
        }

        @java.lang.Override
        public MutableDoubleDoubleMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
