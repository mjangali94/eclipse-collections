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

import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseFunctionTest.stg.
 */
public class ByteCaseFunctionTest {

    @Test
    public void noopCase() {
        ByteCaseFunction<Byte> function = new ByteCaseFunction<Byte>();
        Assert.assertNull(function.valueOf((byte) 0));
    }

    @Test
    public void basicCase() {
        ByteCaseFunction<Byte> function = new ByteCaseFunction<Byte>();
        function.addCase(ignored -> true, Byte::valueOf);
        Assert.assertEquals(Byte.valueOf((byte) 0), function.valueOf((byte) 0));
    }

    @Test
    public void defaultValue() {
        ByteCaseFunction<String> function = new ByteCaseFunction<String>(i -> "Yow!").addCase(i -> i == 0, i -> "Patience, grasshopper");
        Assert.assertEquals("Yow!", function.valueOf((byte) 1));
        ByteCaseFunction<String> function1 = function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertSame(function, function1);
        Assert.assertEquals("Patience, grasshopper", function.valueOf((byte) 0));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf((byte) 1));
        Verify.assertContains("ByteCaseFunction", function.toString());
    }

    @Test
    public void fizzBuzz() {
        String fizzBuzz = IntInterval.oneTo(20).collectByte(i -> (byte) i, ByteLists.mutable.empty()).collect(new ByteCaseFunction<String>(e -> "").addCase(e -> e % 15 == 0, e -> "FizzBuzz").addCase(e -> e % 3 == 0, e -> "Fizz").addCase(e -> e % 5 == 0, e -> "Buzz")).makeString(":");
        Assert.assertEquals("::Fizz::Buzz:Fizz:::Fizz:Buzz::Fizz:::FizzBuzz:::Fizz::Buzz", fizzBuzz);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteCaseFunctionTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noopCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.basicCase);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fizzBuzz() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fizzBuzz);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCaseFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new ByteCaseFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCaseFunctionTest> noopCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCaseFunctionTest> basicCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCaseFunctionTest> defaultValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCaseFunctionTest> fizzBuzz;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCase = ByteCaseFunctionTest::noopCase;
            this.payloads.basicCase = ByteCaseFunctionTest::basicCase;
            this.payloads.defaultValue = ByteCaseFunctionTest::defaultValue;
            this.payloads.fizzBuzz = ByteCaseFunctionTest::fizzBuzz;
        }
    }
*/
}
