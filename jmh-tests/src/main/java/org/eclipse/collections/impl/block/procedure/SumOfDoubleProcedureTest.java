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

public class SumOfDoubleProcedureTest {

    @Test
    public void getResult() {
        SumOfDoubleProcedure<Double> procedure = new SumOfDoubleProcedure<>(Double::doubleValue);
        procedure.value(1.0);
        assertEquals(1, procedure.getResult(), 0.0);
        assertEquals(0.0, procedure.getCompensation(), 0.0);
        procedure.value(2.5);
        assertEquals(3.5, procedure.getResult(), 0.0);
        assertEquals(0.0, procedure.getCompensation(), 0.0);
        procedure.value(3.5);
        assertEquals(7.0, procedure.getResult(), 0.0);
        assertEquals(0.0, procedure.getCompensation(), 0.0);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SumOfDoubleProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getResult() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getResult);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SumOfDoubleProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new SumOfDoubleProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SumOfDoubleProcedureTest> getResult;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.getResult = SumOfDoubleProcedureTest::getResult;
        }
    }
}
