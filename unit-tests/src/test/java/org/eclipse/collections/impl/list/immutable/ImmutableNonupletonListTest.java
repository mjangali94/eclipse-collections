/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable;

import org.eclipse.collections.api.list.ImmutableList;
import org.junit.Test;

public class ImmutableNonupletonListTest extends AbstractImmutableListTestCase {

    @Override
    protected ImmutableList<Integer> classUnderTest() {
        return new ImmutableNonupletonList<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        ImmutableList<Integer> list = this.classUnderTest();
        list.getOnly();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly, this.description("getOnly"), java.lang.IllegalStateException.class);
        }

        private ImmutableNonupletonListTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableNonupletonListTest();
        }

        @java.lang.Override
        public ImmutableNonupletonListTest implementation() {
            return this.implementation;
        }
    }
}
