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

import org.eclipse.collections.api.map.primitive.ImmutableByteIntMap;
import org.eclipse.collections.api.map.primitive.MutableByteIntMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ByteIntMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ByteIntMaps.immutable.of());
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1).toImmutable(), ByteIntMaps.immutable.of((byte) 1, 1));
    }

    @Test
    public void withAll() {
        ImmutableByteIntMap map = ByteIntMaps.immutable.of();
        Assert.assertEquals(ByteIntMaps.mutable.empty().toImmutable(), ByteIntMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3), ByteIntMaps.mutable.from(iterable, Byte::valueOf, Integer::valueOf));
        Assert.assertTrue(ByteIntMaps.mutable.from(iterable, Byte::valueOf, Integer::valueOf) instanceof MutableByteIntMap);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3), ByteIntMaps.immutable.from(iterable, Byte::valueOf, Integer::valueOf));
        Assert.assertTrue(ByteIntMaps.immutable.from(iterable, Byte::valueOf, Integer::valueOf) instanceof ImmutableByteIntMap);
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

        private ByteIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteIntMapFactoryTest();
        }

        @java.lang.Override
        public ByteIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
