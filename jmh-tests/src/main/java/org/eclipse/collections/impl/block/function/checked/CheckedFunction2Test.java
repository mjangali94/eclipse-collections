/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function.checked;

import org.junit.Assert;
import org.junit.Test;

public class CheckedFunction2Test {

    @Test
    public void value() {
        Assert.assertEquals((Integer) 50, new CheckedFunction2<Integer, Integer, Integer>() {

            @Override
            public Integer safeValue(Integer argument1, Integer argument2) {
                return argument1 * argument2;
            }
        }.value(10, 5));
    }

    @Test
    public void exceptionHandling() {
        Assert.assertThrows(RuntimeException.class, () -> new CheckedFunction2<Integer, Integer, Integer>() {

            @Override
            public Integer safeValue(Integer argument1, Integer argument2) throws Exception {
                throw new Exception("Something bad happened");
            }
        }.value(10, 20));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::value, this.description("value"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_exceptionHandling() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::exceptionHandling, this.description("exceptionHandling"));
        }

        private CheckedFunction2Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CheckedFunction2Test();
        }

        @java.lang.Override
        public CheckedFunction2Test implementation() {
            return this.implementation;
        }
    }
}
