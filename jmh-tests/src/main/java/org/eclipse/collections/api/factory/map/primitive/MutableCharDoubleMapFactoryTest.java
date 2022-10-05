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

import org.eclipse.collections.api.factory.primitive.CharDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableCharDoubleMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableCharDoubleMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new CharDoubleHashMap(), CharDoubleMaps.mutable.with());
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0), CharDoubleMaps.mutable.with((char) 1, 2.0));
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0, (char) 3, 4.0), CharDoubleMaps.mutable.with((char) 1, 2.0, (char) 3, 4.0));
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0), CharDoubleMaps.mutable.with((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0));
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0, (char) 7, 8.0), CharDoubleMaps.mutable.with((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0, (char) 7, 8.0));
    }

    @Test
    public void of() {
        Assert.assertEquals(new CharDoubleHashMap(), CharDoubleMaps.mutable.of());
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0), CharDoubleMaps.mutable.of((char) 1, 2.0));
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0, (char) 3, 4.0), CharDoubleMaps.mutable.of((char) 1, 2.0, (char) 3, 4.0));
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0), CharDoubleMaps.mutable.of((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0));
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0, (char) 7, 8.0), CharDoubleMaps.mutable.of((char) 1, 2.0, (char) 3, 4.0, (char) 5, 6.0, (char) 7, 8.0));
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

        private MutableCharDoubleMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableCharDoubleMapFactoryTest();
        }

        @java.lang.Override
        public MutableCharDoubleMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
