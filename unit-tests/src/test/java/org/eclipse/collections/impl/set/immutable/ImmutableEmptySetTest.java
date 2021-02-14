/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableEmptySetTest extends AbstractImmutableEmptySetTestCase {

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return Sets.immutable.of();
    }

    @Override
    @Test
    public void newWithout() {
        Assert.assertSame(Sets.immutable.of(), Sets.immutable.of().newWithout(1));
        Assert.assertSame(Sets.immutable.of(), Sets.immutable.of().newWithoutAll(Interval.oneTo(3)));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        MutableSet<Integer> mutable = UnifiedSet.newSet(immutable);
        Verify.assertEqualsAndHashCode(mutable, immutable);
        Verify.assertPostSerializedIdentity(immutable);
        Assert.assertNotEquals(FastList.newList(mutable), immutable);
    }

    @Test
    public void countByEach() {
        Assert.assertEquals(Bags.immutable.empty(), this.classUnderTest().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i)));
    }

    @Test
    public void countByEach_target() {
        MutableBag<Integer> target = Bags.mutable.empty();
        Assert.assertEquals(target, this.classUnderTest().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i), target));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithout, this.description("newWithout"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByEach, this.description("countByEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByEach_target, this.description("countByEach_target"));
        }

        private ImmutableEmptySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableEmptySetTest();
        }

        @java.lang.Override
        public ImmutableEmptySetTest implementation() {
            return this.implementation;
        }
    }
}
