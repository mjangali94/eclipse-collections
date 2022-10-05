/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableCharByteMap;
import org.eclipse.collections.api.map.primitive.MutableCharByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class CharByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharByteMaps.immutable.of());
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1).toImmutable(), CharByteMaps.immutable.of((char) 1, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableCharByteMap map = CharByteMaps.immutable.of();
        Assert.assertEquals(CharByteMaps.mutable.empty().toImmutable(), CharByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharByteHashMap.newWithKeysValues('1', (byte) 1, '2', (byte) 2, '3', (byte) 3), CharByteMaps.mutable.from(iterable, each -> each.charAt(0), Byte::valueOf));
        Assert.assertTrue(CharByteMaps.mutable.from(iterable, each -> each.charAt(0), Byte::valueOf) instanceof MutableCharByteMap);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues('1', (byte) 1, '2', (byte) 2, '3', (byte) 3), CharByteMaps.immutable.from(iterable, each -> each.charAt(0), Byte::valueOf));
        Assert.assertTrue(CharByteMaps.immutable.from(iterable, each -> each.charAt(0), Byte::valueOf) instanceof ImmutableCharByteMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAll, this.description("withAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::from, this.description("from"));
        }

        private CharByteMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharByteMapFactoryTest();
        }

        @java.lang.Override
        public CharByteMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
