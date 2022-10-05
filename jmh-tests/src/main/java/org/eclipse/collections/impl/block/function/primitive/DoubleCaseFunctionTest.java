/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function.primitive;

import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseFunctionTest.stg.
 */
public class DoubleCaseFunctionTest {

    @Test
    public void noopCase() {
        DoubleCaseFunction<Double> function = new DoubleCaseFunction<Double>();
        Assert.assertNull(function.valueOf(0.0));
    }

    @Test
    public void basicCase() {
        DoubleCaseFunction<Double> function = new DoubleCaseFunction<Double>();
        function.addCase(ignored -> true, Double::valueOf);
        Assert.assertEquals(Double.valueOf(0.0), function.valueOf(0.0));
    }

    @Test
    public void defaultValue() {
        DoubleCaseFunction<String> function = new DoubleCaseFunction<String>(i -> "Yow!").addCase(i -> Double.compare(i, 0) == 0, i -> "Patience, grasshopper");
        Assert.assertEquals("Yow!", function.valueOf(1.0));
        DoubleCaseFunction<String> function1 = function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertSame(function, function1);
        Assert.assertEquals("Patience, grasshopper", function.valueOf(0.0));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(1.0));
        Verify.assertContains("DoubleCaseFunction", function.toString());
    }

    @Test
    public void fizzBuzz() {
        String fizzBuzz = IntInterval.oneTo(20).collectDouble(i -> (double) i, DoubleLists.mutable.empty()).collect(new DoubleCaseFunction<String>(e -> "").addCase(e -> Double.compare(e % 15, 0) == 0, e -> "FizzBuzz").addCase(e -> Double.compare(e % 3, 0) == 0, e -> "Fizz").addCase(e -> Double.compare(e % 5, 0) == 0, e -> "Buzz")).makeString(":");
        Assert.assertEquals("::Fizz::Buzz:Fizz:::Fizz:Buzz::Fizz:::FizzBuzz:::Fizz::Buzz", fizzBuzz);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleCaseFunctionTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noopCase);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.basicCase);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fizzBuzz() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fizzBuzz);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCaseFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleCaseFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCaseFunctionTest> noopCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCaseFunctionTest> basicCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCaseFunctionTest> defaultValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCaseFunctionTest> fizzBuzz;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCase = DoubleCaseFunctionTest::noopCase;
            this.payloads.basicCase = DoubleCaseFunctionTest::basicCase;
            this.payloads.defaultValue = DoubleCaseFunctionTest::defaultValue;
            this.payloads.fizzBuzz = DoubleCaseFunctionTest::fizzBuzz;
        }
    }
}
