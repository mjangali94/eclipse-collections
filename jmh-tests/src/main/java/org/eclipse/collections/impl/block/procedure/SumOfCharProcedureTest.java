/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SumOfCharProcedure}.
 * This file was automatically generated from template file sumOfPrimitiveProcedureTest.stg.
 */
public class SumOfCharProcedureTest {

    @Test
    public void getResult() {
        CharFunction<String> stringToLengthFunction = (String string) -> (char) string.length();
        SumOfCharProcedure<String> procedure = new SumOfCharProcedure<>(stringToLengthFunction);
        procedure.value("");
        procedure.value("0");
        procedure.value("00");
        procedure.value("000");
        char actual = (char) procedure.getResult();
        char expected = (char) 6;
        Assert.assertTrue(actual == expected);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getResult() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getResult, this.description("getResult"));
        }

        private SumOfCharProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SumOfCharProcedureTest();
        }

        @java.lang.Override
        public SumOfCharProcedureTest implementation() {
            return this.implementation;
        }
    }
}
