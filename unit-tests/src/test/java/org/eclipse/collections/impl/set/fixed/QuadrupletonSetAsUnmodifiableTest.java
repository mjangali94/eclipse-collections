/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.fixed;

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class QuadrupletonSetAsUnmodifiableTest extends UnmodifiableMutableCollectionTestCase<String> {

    @Override
    protected MutableCollection<String> getCollection() {
        return Sets.fixedSize.of("1", "2", "3", "4").asUnmodifiable();
    }

    @Override
    @Test
    public void collectBoolean() {
        Verify.assertSize(1, this.getCollection().collectBoolean(Boolean::parseBoolean));
    }

    @Override
    @Test
    public void collectByte() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectByte(Byte::parseByte));
    }

    @Override
    @Test
    public void collectChar() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectChar((CharFunction<String>) string -> string.charAt(0)));
    }

    @Override
    @Test
    public void collectDouble() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectDouble(Double::parseDouble));
    }

    @Override
    @Test
    public void collectFloat() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectFloat(Float::parseFloat));
    }

    @Override
    @Test
    public void collectInt() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectInt(Integer::parseInt));
    }

    @Override
    @Test
    public void collectLong() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectLong(Long::parseLong));
    }

    @Override
    @Test
    public void collectShort() {
        Verify.assertSize(this.getCollection().size(), this.getCollection().collectShort(Short::parseShort));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        private QuadrupletonSetAsUnmodifiableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new QuadrupletonSetAsUnmodifiableTest();
        }

        @java.lang.Override
        public QuadrupletonSetAsUnmodifiableTest implementation() {
            return this.implementation;
        }
    }
}
