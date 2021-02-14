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

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class MapEntryPredicateTest {

    private final Map.Entry<String, Integer> entry = new Map.Entry<String, Integer>() {

        @Override
        public String getKey() {
            return "1";
        }

        @Override
        public Integer getValue() {
            return 1;
        }

        @Override
        public Integer setValue(Integer value) {
            return null;
        }
    };

    @Test
    public void accept() {
        MapEntryPredicate<String, Integer> mapEntryPredicate = new MapEntryPredicate<String, Integer>() {

            @Override
            public boolean accept(String argument1, Integer argument2) {
                return String.valueOf(argument2).equals(argument1);
            }
        };
        Assert.assertTrue(mapEntryPredicate.accept(this.entry));
    }

    @Test
    public void negate() {
        MapEntryPredicate<String, Integer> mapEntryPredicate = new MapEntryPredicate<String, Integer>() {

            @Override
            public boolean accept(String argument1, Integer argument2) {
                return String.valueOf(argument2).equals(argument1);
            }
        };
        Assert.assertFalse(mapEntryPredicate.negate().accept(this.entry));
        Assert.assertFalse(mapEntryPredicate.negate().accept("1", 1));
        Assert.assertTrue(mapEntryPredicate.negate().accept(new Map.Entry<String, Integer>() {

            @Override
            public String getKey() {
                return "1";
            }

            @Override
            public Integer getValue() {
                return 2;
            }

            @Override
            public Integer setValue(Integer value) {
                return null;
            }
        }));
        Assert.assertTrue(mapEntryPredicate.negate().accept("1", 2));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
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

        private MapEntryPredicateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MapEntryPredicateTest();
        }

        @java.lang.Override
        public MapEntryPredicateTest implementation() {
            return this.implementation;
        }
    }
}
