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

import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SumOfByteProcedure}.
 * This file was automatically generated from template file sumOfPrimitiveProcedureTest.stg.
 */
public class SumOfByteProcedureTest {

    @Test
    public void getResult() {
        ByteFunction<String> stringToLengthFunction = (String string) -> (byte) string.length();
        SumOfByteProcedure<String> procedure = new SumOfByteProcedure<>(stringToLengthFunction);
        procedure.value("");
        procedure.value("0");
        procedure.value("00");
        procedure.value("000");
        byte actual = (byte) procedure.getResult();
        byte expected = (byte) 6;
        Assert.assertTrue(actual == expected);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getResult() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getResult, this.description("getResult"));
        }

        private SumOfByteProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SumOfByteProcedureTest();
        }

        @java.lang.Override
        public SumOfByteProcedureTest implementation() {
            return this.implementation;
        }
    }
}
