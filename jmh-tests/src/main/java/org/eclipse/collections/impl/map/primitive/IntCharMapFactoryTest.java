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

import org.eclipse.collections.api.map.primitive.ImmutableIntCharMap;
import org.eclipse.collections.api.map.primitive.MutableIntCharMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class IntCharMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(IntCharMaps.immutable.of());
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 1).toImmutable(), IntCharMaps.immutable.of(1, (char) 1));
    }

    @Test
    public void withAll() {
        ImmutableIntCharMap map = IntCharMaps.immutable.of();
        Assert.assertEquals(IntCharMaps.mutable.empty().toImmutable(), IntCharMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, '1', 2, '2', 3, '3'), IntCharMaps.mutable.from(iterable, Integer::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(IntCharMaps.mutable.from(iterable, Integer::valueOf, each -> each.charAt(0)) instanceof MutableIntCharMap);
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, '1', 2, '2', 3, '3'), IntCharMaps.immutable.from(iterable, Integer::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(IntCharMaps.immutable.from(iterable, Integer::valueOf, each -> each.charAt(0)) instanceof ImmutableIntCharMap);
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

        private IntCharMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntCharMapFactoryTest();
        }

        @java.lang.Override
        public IntCharMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
