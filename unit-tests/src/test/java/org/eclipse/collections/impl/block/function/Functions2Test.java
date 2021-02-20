/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import java.io.IOException;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class Functions2Test {

    @Test
    public void throwing() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> Functions2.throwing((a, b) -> {
            throw new IOException();
        }).value(null, null));
    }

    @Test
    public void throwingWithUserSpecifiedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Functions2.throwing((one, two) -> {
                throw new IOException();
            }, (one, two, ce) -> new RuntimeException(ce)).value(null, null);
        });
        Verify.assertThrowsWithCause(MyRuntimeException.class, IOException.class, () -> {
            Functions2.throwing((one, two) -> {
                throw new IOException();
            }, this::throwMyException).value(null, null);
        });
        Assert.assertThrows(NullPointerException.class, () -> {
            Functions2.throwing((one, two) -> {
                throw new NullPointerException();
            }, this::throwMyException).value(null, null);
        });
    }

    private MyRuntimeException throwMyException(Object one, Object two, Throwable exception) {
        return new MyRuntimeException(String.valueOf(one) + two, exception);
    }

    @Test
    public void asFunction2Function() {
        Function2<Integer, Object, String> block = Functions2.fromFunction(String::valueOf);
        Assert.assertEquals("1", block.value(1, null));
    }

    @Test
    public void plusInteger() {
        Function2<Integer, Integer, Integer> plusInteger = Functions2.integerAddition();
        Assert.assertEquals(Integer.valueOf(5), plusInteger.value(2, 3));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(Functions2.class);
    }

    private static class MyRuntimeException extends RuntimeException {

        MyRuntimeException(String message, Throwable cause) {
            super(message, cause);
        }
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwing() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::throwing, this.description("throwing"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithUserSpecifiedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::throwingWithUserSpecifiedException, this.description("throwingWithUserSpecifiedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asFunction2Function() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asFunction2Function, this.description("asFunction2Function"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_plusInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::plusInteger, this.description("plusInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private Functions2Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new Functions2Test();
        }

        @java.lang.Override
        public Functions2Test implementation() {
            return this.implementation;
        }
    }
}
