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

import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableCharBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class CharBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new CharBooleanHashMap().toImmutable(), CharBooleanMaps.immutable.of());
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, true).toImmutable(), CharBooleanMaps.immutable.of((char) 1, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new CharBooleanHashMap().toImmutable(), CharBooleanMaps.immutable.ofAll(CharBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new CharBooleanHashMap().toImmutable(), CharBooleanMaps.immutable.withAll(CharBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues('1', false, '2', true, '3', false), CharBooleanMaps.mutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(CharBooleanMaps.mutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0) instanceof MutableCharBooleanMap);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues('1', false, '2', true, '3', false), CharBooleanMaps.immutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(CharBooleanMaps.immutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableCharBooleanMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAll, this.description("ofAll"));
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

        private CharBooleanMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharBooleanMapFactoryTest();
        }

        @java.lang.Override
        public CharBooleanMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
