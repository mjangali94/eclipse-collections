/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.primitive;

import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableBooleanSetFactoryImplTest {

    @Test
    public void of() {
        Verify.assertEmpty(BooleanSets.immutable.of());
        Assert.assertEquals(BooleanHashSet.newSetWith(true).toImmutable(), BooleanSets.immutable.of(true));
    }

    @Test
    public void with() {
        Verify.assertEmpty(BooleanSets.immutable.with(null));
        Assert.assertEquals(BooleanHashSet.newSetWith(false).toImmutable(), BooleanSets.immutable.with(new boolean[] { false }));
    }

    @Test
    public void ofAll() {
        ImmutableBooleanSet set = BooleanSets.immutable.of(true, false);
        Assert.assertEquals(BooleanHashSet.newSet(set).toImmutable(), BooleanSets.immutable.ofAll(set));
        Assert.assertEquals(BooleanHashSet.newSet(BooleanArrayList.newListWith(true, false, true)).toImmutable(), BooleanSets.immutable.ofAll(BooleanArrayList.newListWith(true, false)));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAll, this.description("ofAll"));
        }

        private ImmutableBooleanSetFactoryImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableBooleanSetFactoryImplTest();
        }

        @java.lang.Override
        public ImmutableBooleanSetFactoryImplTest implementation() {
            return this.implementation;
        }
    }
}
