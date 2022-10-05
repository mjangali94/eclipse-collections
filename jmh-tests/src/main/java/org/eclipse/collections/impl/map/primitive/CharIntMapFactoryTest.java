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

import org.eclipse.collections.api.map.primitive.ImmutableCharIntMap;
import org.eclipse.collections.api.map.primitive.MutableCharIntMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class CharIntMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharIntMaps.immutable.of());
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1).toImmutable(), CharIntMaps.immutable.of((char) 1, 1));
    }

    @Test
    public void withAll() {
        ImmutableCharIntMap map = CharIntMaps.immutable.of();
        Assert.assertEquals(CharIntMaps.mutable.empty().toImmutable(), CharIntMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharIntHashMap.newWithKeysValues('1', 1, '2', 2, '3', 3), CharIntMaps.mutable.from(iterable, each -> each.charAt(0), Integer::valueOf));
        Assert.assertTrue(CharIntMaps.mutable.from(iterable, each -> each.charAt(0), Integer::valueOf) instanceof MutableCharIntMap);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues('1', 1, '2', 2, '3', 3), CharIntMaps.immutable.from(iterable, each -> each.charAt(0), Integer::valueOf));
        Assert.assertTrue(CharIntMaps.immutable.from(iterable, each -> each.charAt(0), Integer::valueOf) instanceof ImmutableCharIntMap);
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

        private CharIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharIntMapFactoryTest();
        }

        @java.lang.Override
        public CharIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
