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

import org.eclipse.collections.api.map.primitive.ImmutableCharLongMap;
import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class CharLongMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharLongMaps.immutable.of());
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L).toImmutable(), CharLongMaps.immutable.of((char) 1, 1L));
    }

    @Test
    public void withAll() {
        ImmutableCharLongMap map = CharLongMaps.immutable.of();
        Assert.assertEquals(CharLongMaps.mutable.empty().toImmutable(), CharLongMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharLongHashMap.newWithKeysValues('1', 1L, '2', 2L, '3', 3L), CharLongMaps.mutable.from(iterable, each -> each.charAt(0), Long::valueOf));
        Assert.assertTrue(CharLongMaps.mutable.from(iterable, each -> each.charAt(0), Long::valueOf) instanceof MutableCharLongMap);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues('1', 1L, '2', 2L, '3', 3L), CharLongMaps.immutable.from(iterable, each -> each.charAt(0), Long::valueOf));
        Assert.assertTrue(CharLongMaps.immutable.from(iterable, each -> each.charAt(0), Long::valueOf) instanceof ImmutableCharLongMap);
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

        private CharLongMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharLongMapFactoryTest();
        }

        @java.lang.Override
        public CharLongMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
