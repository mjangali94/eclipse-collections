/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function.primitive;

import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class BooleanCaseFunctionTest {

    @Test
    public void noopCase() {
        BooleanToObjectFunction<Boolean> function = new BooleanCaseFunction<>();
        Assert.assertNull(function.valueOf(true));
    }

    @Test
    public void basicCase() {
        BooleanCaseFunction<Boolean> function = new BooleanCaseFunction<>();
        function.addCase(value -> value, Boolean::valueOf);
        Assert.assertEquals(Boolean.valueOf(true), function.valueOf(true));
    }

    @Test
    public void defaultValue() {
        BooleanCaseFunction<String> function = new BooleanCaseFunction<>(e -> "Yow!").addCase(e -> e, e -> "Patience, grasshopper");
        Assert.assertEquals("Yow!", function.valueOf(false));
        BooleanCaseFunction<String> function1 = function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertSame(function, function1);
        Assert.assertEquals("Patience, grasshopper", function.valueOf(true));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(false));
        Verify.assertContains("BooleanCaseFunction", function.toString());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanCaseFunctionTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanCaseFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanCaseFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanCaseFunctionTest> noopCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanCaseFunctionTest> basicCase;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanCaseFunctionTest> defaultValue;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCase = BooleanCaseFunctionTest::noopCase;
            this.payloads.basicCase = BooleanCaseFunctionTest::basicCase;
            this.payloads.defaultValue = BooleanCaseFunctionTest::defaultValue;
        }
    }
}
