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

import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

// This class is not a full test of AddFunction at present, but serves as a
// holder for the addStringBlockHandlesNulls() test which had been put in the
// BlocksTest class erroneously. The BlocksTest class has since been removed.
public class AddFunctionTest {

    @Test
    public void addStringBlockHandlesNulls() {
        Function2<String, String, String> undertest = AddFunction.STRING;
        Assert.assertEquals("two", undertest.value(null, "two"));
        Assert.assertEquals("one", undertest.value("one", null));
    }

    @Test
    public void addLongFunction() {
        Function2<Long, Long, Long> longFunction = AddFunction.LONG;
        Assert.assertEquals(Long.valueOf(3L), longFunction.value(1L, 2L));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(AddFunction.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addStringBlockHandlesNulls() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addStringBlockHandlesNulls, this.description("addStringBlockHandlesNulls"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addLongFunction() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addLongFunction, this.description("addLongFunction"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private AddFunctionTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new AddFunctionTest();
        }

        @java.lang.Override
        public AddFunctionTest implementation() {
            return this.implementation;
        }
    }
}
