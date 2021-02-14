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

public class ImmutableTripletonSetTest extends AbstractImmutableSetTestCase {

    @Override
    protected ImmutableSet<Integer> classUnderTest() {
        return new ImmutableTripletonSet<>(1, 2, 3);
    }

    @Override
    @Test
    public void newWithout() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(2, immutable.newWithout(3).castToSet());
        Verify.assertSize(2, immutable.newWithout(2).castToSet());
        Verify.assertSize(2, immutable.newWithout(1).castToSet());
        Verify.assertSize(3, immutable.newWithout(0).castToSet());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        private ImmutableTripletonSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableTripletonSetTest();
        }

        @java.lang.Override
        public ImmutableTripletonSetTest implementation() {
            return this.implementation;
        }
    }
}
