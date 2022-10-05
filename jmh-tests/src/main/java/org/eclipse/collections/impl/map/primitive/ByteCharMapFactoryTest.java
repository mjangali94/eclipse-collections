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

import org.eclipse.collections.api.map.primitive.ImmutableByteCharMap;
import org.eclipse.collections.api.map.primitive.MutableByteCharMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ByteCharMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ByteCharMaps.immutable.of());
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1).toImmutable(), ByteCharMaps.immutable.of((byte) 1, (char) 1));
    }

    @Test
    public void withAll() {
        ImmutableByteCharMap map = ByteCharMaps.immutable.of();
        Assert.assertEquals(ByteCharMaps.mutable.empty().toImmutable(), ByteCharMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, '1', (byte) 2, '2', (byte) 3, '3'), ByteCharMaps.mutable.from(iterable, Byte::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(ByteCharMaps.mutable.from(iterable, Byte::valueOf, each -> each.charAt(0)) instanceof MutableByteCharMap);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, '1', (byte) 2, '2', (byte) 3, '3'), ByteCharMaps.immutable.from(iterable, Byte::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(ByteCharMaps.immutable.from(iterable, Byte::valueOf, each -> each.charAt(0)) instanceof ImmutableByteCharMap);
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

        private ByteCharMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteCharMapFactoryTest();
        }

        @java.lang.Override
        public ByteCharMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
