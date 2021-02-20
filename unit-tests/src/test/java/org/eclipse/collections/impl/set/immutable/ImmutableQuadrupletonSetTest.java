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

import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iSet;

public class ImmutableQuadrupletonSetTest extends AbstractImmutableSetTestCase {

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return new ImmutableQuadrupletonSet<>(1, 2, 3, 4);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(3, immutable.newWithout(4).castToSet());
        Verify.assertSize(3, immutable.newWithout(3).castToSet());
        Verify.assertSize(3, immutable.newWithout(2).castToSet());
        Verify.assertSize(3, immutable.newWithout(1).castToSet());
        Verify.assertSize(4, immutable.newWithout(0).castToSet());
    }

    @Test
    public void selectInstanceOf() {
        ImmutableSet<Number> numbers = new ImmutableQuadrupletonSet<>(1, 2.0, 3, 4.0);
        Assert.assertEquals(iSet(1, 3), numbers.selectInstancesOf(Integer.class));
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithout, this.description("newWithout"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstanceOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstanceOf, this.description("selectInstanceOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        private ImmutableQuadrupletonSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableQuadrupletonSetTest();
        }

        @java.lang.Override
        public ImmutableQuadrupletonSetTest implementation() {
            return this.implementation;
        }
    }
}
