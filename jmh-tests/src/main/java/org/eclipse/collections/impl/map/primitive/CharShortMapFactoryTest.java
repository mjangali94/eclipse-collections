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

import org.eclipse.collections.api.map.primitive.ImmutableCharShortMap;
import org.eclipse.collections.api.map.primitive.MutableCharShortMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class CharShortMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharShortMaps.immutable.of());
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1).toImmutable(), CharShortMaps.immutable.of((char) 1, (short) 1));
    }

    @Test
    public void withAll() {
        ImmutableCharShortMap map = CharShortMaps.immutable.of();
        Assert.assertEquals(CharShortMaps.mutable.empty().toImmutable(), CharShortMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharShortHashMap.newWithKeysValues('1', (short) 1, '2', (short) 2, '3', (short) 3), CharShortMaps.mutable.from(iterable, each -> each.charAt(0), Short::valueOf));
        Assert.assertTrue(CharShortMaps.mutable.from(iterable, each -> each.charAt(0), Short::valueOf) instanceof MutableCharShortMap);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues('1', (short) 1, '2', (short) 2, '3', (short) 3), CharShortMaps.immutable.from(iterable, each -> each.charAt(0), Short::valueOf));
        Assert.assertTrue(CharShortMaps.immutable.from(iterable, each -> each.charAt(0), Short::valueOf) instanceof ImmutableCharShortMap);
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

        private CharShortMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharShortMapFactoryTest();
        }

        @java.lang.Override
        public CharShortMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
