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

import org.eclipse.collections.api.map.primitive.ImmutableByteDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableByteDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ByteDoubleMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ByteDoubleMaps.immutable.of());
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0).toImmutable(), ByteDoubleMaps.immutable.of((byte) 1, 1.0));
    }

    @Test
    public void withAll() {
        ImmutableByteDoubleMap map = ByteDoubleMaps.immutable.of();
        Assert.assertEquals(ByteDoubleMaps.mutable.empty().toImmutable(), ByteDoubleMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0), ByteDoubleMaps.mutable.from(iterable, Byte::valueOf, Double::valueOf));
        Assert.assertTrue(ByteDoubleMaps.mutable.from(iterable, Byte::valueOf, Double::valueOf) instanceof MutableByteDoubleMap);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0), ByteDoubleMaps.immutable.from(iterable, Byte::valueOf, Double::valueOf));
        Assert.assertTrue(ByteDoubleMaps.immutable.from(iterable, Byte::valueOf, Double::valueOf) instanceof ImmutableByteDoubleMap);
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

        private ByteDoubleMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteDoubleMapFactoryTest();
        }

        @java.lang.Override
        public ByteDoubleMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
