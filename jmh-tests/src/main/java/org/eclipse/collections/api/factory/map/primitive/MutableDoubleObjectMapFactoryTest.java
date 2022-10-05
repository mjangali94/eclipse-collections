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

import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.api.factory.primitive.DoubleObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleObjectHashMap;

/**
 * Junit test for {@link MutableDoubleObjectMapFactory}
 * This file was automatically generated from template file primitiveObjectMutableMapFactoryTest.stg
 */
public class MutableDoubleObjectMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(DoubleObjectHashMap.newMap(), DoubleObjectMaps.mutable.with());
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), DoubleObjectMaps.mutable.with(1.0, "one"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two"), DoubleObjectMaps.mutable.with(1.0, "one", 2.0, "two"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two", 3.0, "three"), DoubleObjectMaps.mutable.with(1.0, "one", 2.0, "two", 3.0, "three"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two", 3.0, "three", 4.0, "four"), DoubleObjectMaps.mutable.with(1.0, "one", 2.0, "two", 3.0, "three", 4.0, "four"));
    }

    @Test
    public void of() {
        Assert.assertEquals(DoubleObjectHashMap.newMap(), DoubleObjectMaps.mutable.of());
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), DoubleObjectMaps.mutable.of(1.0, "one"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two"), DoubleObjectMaps.mutable.of(1.0, "one", 2.0, "two"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two", 3.0, "three"), DoubleObjectMaps.mutable.of(1.0, "one", 2.0, "two", 3.0, "three"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two", 3.0, "three", 4.0, "four"), DoubleObjectMaps.mutable.of(1.0, "one", 2.0, "two", 3.0, "three", 4.0, "four"));
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

        private MutableDoubleObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableDoubleObjectMapFactoryTest();
        }

        @java.lang.Override
        public MutableDoubleObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
