/*
 * Copyright (c) 2021 The Bank of New York Mellon and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.impl.list.Interval;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AtomicCountProcedureTest {

    private static final int STRING_LENGTH = 5;

    private static final int ZERO = 0;

    @Test
    public void getCount() {
        AtomicCountProcedure<String> atomicCountProcedure = new AtomicCountProcedure<>(each -> STRING_LENGTH < each.length());
        atomicCountProcedure.value("word");
        assertEquals(0, atomicCountProcedure.getCount());
        atomicCountProcedure.value("america");
        assertEquals(1, atomicCountProcedure.getCount());
    }

    @Test(expected = ArithmeticException.class)
    public void predicateException() {
        Procedure<String> atomicCountProcedure = new AtomicCountProcedure<>(each -> STRING_LENGTH < each.length() / ZERO);
        atomicCountProcedure.value("word");
    }

    @Test
    public void parallelProcessing() {
        AtomicCountProcedure<Integer> atomicCountProcedure = new AtomicCountProcedure<>(each -> each % 2 == 0);
        Interval.oneTo(50_000).parallelStream().forEach(atomicCountProcedure);
        assertEquals(25_000, atomicCountProcedure.getCount());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AtomicCountProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicateException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.predicateException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelProcessing() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelProcessing);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AtomicCountProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new AtomicCountProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AtomicCountProcedureTest> getCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AtomicCountProcedureTest> predicateException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AtomicCountProcedureTest> parallelProcessing;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.getCount = AtomicCountProcedureTest::getCount;
            this.payloads.predicateException = new se.chalmers.ju2jmh.api.ExceptionTest<>(AtomicCountProcedureTest::predicateException, java.lang.ArithmeticException.class);
            this.payloads.parallelProcessing = AtomicCountProcedureTest::parallelProcessing;
        }
    }
}
