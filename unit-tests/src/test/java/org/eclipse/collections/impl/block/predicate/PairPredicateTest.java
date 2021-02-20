/*
 * Copyright (c) 2017 Gaurav Khurana.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.predicate;

import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class PairPredicateTest {

    @Test
    public void accept() {
        PairPredicate<String, Integer> pairPredicate = new PairPredicate<String, Integer>() {

            @Override
            public boolean accept(String argument1, Integer argument2) {
                return String.valueOf(argument2).equals(argument1);
            }
        };
        Assert.assertTrue(pairPredicate.accept(Tuples.pair("1", 1)));
        Assert.assertFalse(pairPredicate.accept(Tuples.pair("2", 1)));
    }

    @Test
    public void negate() {
        PairPredicate<String, String> pairPredicate = new PairPredicate<String, String>() {

            @Override
            public boolean accept(String argument1, String argument2) {
                return argument2.equals(argument1);
            }
        };
        PairPredicate<String, String> negatedPredicate = pairPredicate.negate();
        Assert.assertFalse(negatedPredicate.accept(Tuples.pair("1", "1")));
        Assert.assertFalse(negatedPredicate.accept("1", "1"));
        Assert.assertTrue(negatedPredicate.accept(Tuples.pair("2", "1")));
        Assert.assertTrue(negatedPredicate.accept("2", "1"));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_accept() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::accept, this.description("accept"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_negate() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::negate, this.description("negate"));
        }

        private PairPredicateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new PairPredicateTest();
        }

        @java.lang.Override
        public PairPredicateTest implementation() {
            return this.implementation;
        }
    }
}
