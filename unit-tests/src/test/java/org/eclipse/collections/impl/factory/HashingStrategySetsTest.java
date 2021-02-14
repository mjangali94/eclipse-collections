/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory;

import org.eclipse.collections.api.factory.set.strategy.ImmutableHashingStrategySetFactory;
import org.eclipse.collections.api.factory.set.strategy.MutableHashingStrategySetFactory;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class HashingStrategySetsTest {

    @Test
    public void immutable() {
        ImmutableHashingStrategySetFactory factory = HashingStrategySets.immutable;
        Assert.assertEquals(UnifiedSet.newSet(), factory.of(HashingStrategies.defaultStrategy()));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy()));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(UnifiedSet.newSetWith(), factory.of(HashingStrategies.defaultStrategy(), null));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), null));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 1), factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Verify.assertInstanceOf(ImmutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 3), factory.withInitialCapacity(HashingStrategies.defaultStrategy(), 3));
        Verify.assertInstanceOf(ImmutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 3));
    }

    @Test
    public void mutable() {
        MutableHashingStrategySetFactory factory = HashingStrategySets.mutable;
        Assert.assertEquals(UnifiedSet.newSet(), factory.of(HashingStrategies.defaultStrategy()));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy()));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8), factory.ofAll(HashingStrategies.defaultStrategy(), FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8)));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8)));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 1), factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Verify.assertInstanceOf(MutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 3), factory.withInitialCapacity(HashingStrategies.defaultStrategy(), 3));
        Verify.assertInstanceOf(MutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 3));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(HashingStrategySets.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutable, this.description("immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutable, this.description("mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private HashingStrategySetsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new HashingStrategySetsTest();
        }

        @java.lang.Override
        public HashingStrategySetsTest implementation() {
            return this.implementation;
        }
    }
}
