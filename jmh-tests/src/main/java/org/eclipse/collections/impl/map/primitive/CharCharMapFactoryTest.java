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

import org.eclipse.collections.api.map.primitive.ImmutableCharCharMap;
import org.eclipse.collections.api.map.primitive.MutableCharCharMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class CharCharMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharCharMaps.immutable.of());
        Assert.assertEquals(CharCharHashMap.newWithKeysValues((char) 1, (char) 1).toImmutable(), CharCharMaps.immutable.of((char) 1, (char) 1));
    }

    @Test
    public void withAll() {
        ImmutableCharCharMap map = CharCharMaps.immutable.of();
        Assert.assertEquals(CharCharMaps.mutable.empty().toImmutable(), CharCharMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharCharHashMap.newWithKeysValues('1', '1', '2', '2', '3', '3'), CharCharMaps.mutable.from(iterable, each -> each.charAt(0), each -> each.charAt(0)));
        Assert.assertTrue(CharCharMaps.mutable.from(iterable, each -> each.charAt(0), each -> each.charAt(0)) instanceof MutableCharCharMap);
        Assert.assertEquals(CharCharHashMap.newWithKeysValues('1', '1', '2', '2', '3', '3'), CharCharMaps.immutable.from(iterable, each -> each.charAt(0), each -> each.charAt(0)));
        Assert.assertTrue(CharCharMaps.immutable.from(iterable, each -> each.charAt(0), each -> each.charAt(0)) instanceof ImmutableCharCharMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharCharMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new CharCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharCharMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharCharMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharCharMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = CharCharMapFactoryTest::of;
            this.payloads.withAll = CharCharMapFactoryTest::withAll;
            this.payloads.from = CharCharMapFactoryTest::from;
        }
    }
}
