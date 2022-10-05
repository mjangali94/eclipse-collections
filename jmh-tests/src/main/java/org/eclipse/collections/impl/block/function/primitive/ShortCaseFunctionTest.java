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

import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseFunctionTest.stg.
 */
public class ShortCaseFunctionTest {

    @Test
    public void noopCase() {
        ShortCaseFunction<Short> function = new ShortCaseFunction<Short>();
        Assert.assertNull(function.valueOf((short) 0));
    }

    @Test
    public void basicCase() {
        ShortCaseFunction<Short> function = new ShortCaseFunction<Short>();
        function.addCase(ignored -> true, Short::valueOf);
        Assert.assertEquals(Short.valueOf((short) 0), function.valueOf((short) 0));
    }

    @Test
    public void defaultValue() {
        ShortCaseFunction<String> function = new ShortCaseFunction<String>(i -> "Yow!").addCase(i -> i == 0, i -> "Patience, grasshopper");
        Assert.assertEquals("Yow!", function.valueOf((short) 1));
        ShortCaseFunction<String> function1 = function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertSame(function, function1);
        Assert.assertEquals("Patience, grasshopper", function.valueOf((short) 0));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf((short) 1));
        Verify.assertContains("ShortCaseFunction", function.toString());
    }

    @Test
    public void fizzBuzz() {
        String fizzBuzz = IntInterval.oneTo(20).collectShort(i -> (short) i, ShortLists.mutable.empty()).collect(new ShortCaseFunction<String>(e -> "").addCase(e -> e % 15 == 0, e -> "FizzBuzz").addCase(e -> e % 3 == 0, e -> "Fizz").addCase(e -> e % 5 == 0, e -> "Buzz")).makeString(":");
        Assert.assertEquals("::Fizz::Buzz:Fizz:::Fizz:Buzz::Fizz:::FizzBuzz:::Fizz::Buzz", fizzBuzz);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noopCase, this.description("noopCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basicCase, this.description("basicCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::defaultValue, this.description("defaultValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fizzBuzz() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::fizzBuzz, this.description("fizzBuzz"));
        }

        private ShortCaseFunctionTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortCaseFunctionTest();
        }

        @java.lang.Override
        public ShortCaseFunctionTest implementation() {
            return this.implementation;
        }
    }
}
