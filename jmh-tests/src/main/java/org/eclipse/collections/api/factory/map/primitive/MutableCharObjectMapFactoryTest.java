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
import org.eclipse.collections.api.factory.primitive.CharObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;

/**
 * Junit test for {@link MutableCharObjectMapFactory}
 * This file was automatically generated from template file primitiveObjectMutableMapFactoryTest.stg
 */
public class MutableCharObjectMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(CharObjectHashMap.newMap(), CharObjectMaps.mutable.with());
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), CharObjectMaps.mutable.with((char) 1, "one"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two"), CharObjectMaps.mutable.with((char) 1, "one", (char) 2, "two"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three"), CharObjectMaps.mutable.with((char) 1, "one", (char) 2, "two", (char) 3, "three"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three", (char) 4, "four"), CharObjectMaps.mutable.with((char) 1, "one", (char) 2, "two", (char) 3, "three", (char) 4, "four"));
    }

    @Test
    public void of() {
        Assert.assertEquals(CharObjectHashMap.newMap(), CharObjectMaps.mutable.of());
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), CharObjectMaps.mutable.of((char) 1, "one"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two"), CharObjectMaps.mutable.of((char) 1, "one", (char) 2, "two"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three"), CharObjectMaps.mutable.of((char) 1, "one", (char) 2, "two", (char) 3, "three"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three", (char) 4, "four"), CharObjectMaps.mutable.of((char) 1, "one", (char) 2, "two", (char) 3, "three", (char) 4, "four"));
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

        private MutableCharObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableCharObjectMapFactoryTest();
        }

        @java.lang.Override
        public MutableCharObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
