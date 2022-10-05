/*
 * Copyright (c) 2022 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SumOfFloatProcedureTest {

    @Test
    public void getResult() {
        SumOfFloatProcedure<Float> procedure = new SumOfFloatProcedure<>(Float::floatValue);
        procedure.value(1.0f);
        assertEquals(1.0, procedure.getResult(), 0.0);
        assertEquals(0.0, procedure.getCompensation(), 0.0);
        procedure.value(2.5f);
        assertEquals(3.5, procedure.getResult(), 0.0);
        assertEquals(0.0, procedure.getCompensation(), 0.0);
        procedure.value(3.5f);
        assertEquals(7.0, procedure.getResult(), 0.0);
        assertEquals(0.0, procedure.getCompensation(), 0.0);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getResult() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getResult, this.description("getResult"));
        }

        private SumOfFloatProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SumOfFloatProcedureTest();
        }

        @java.lang.Override
        public SumOfFloatProcedureTest implementation() {
            return this.implementation;
        }
    }
}
