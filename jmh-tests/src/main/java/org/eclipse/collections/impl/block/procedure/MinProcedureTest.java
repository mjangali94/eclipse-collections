/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class MinProcedureTest {

    @Test
    public void getResultOptional() {
        MinProcedure<Integer> procedure = new MinProcedure<>();
        Assert.assertFalse(procedure.getResultOptional().isPresent());
        procedure.value(2);
        Optional<Integer> resultOptional = procedure.getResultOptional();
        Assert.assertTrue(resultOptional.isPresent());
        Assert.assertEquals((Integer) 2, resultOptional.get());
        procedure.value(1);
        Optional<Integer> resultOptional2 = procedure.getResultOptional();
        Assert.assertTrue(resultOptional2.isPresent());
        Assert.assertEquals((Integer) 1, resultOptional2.get());
    }

    @Test
    public void value() {
        MinProcedure<Integer> procedure = new MinProcedure<>();
        Integer first = new Integer(1);
        procedure.value(first);
        Assert.assertSame(first, procedure.getResult());
        Integer second = new Integer(1);
        procedure.value(second);
        Assert.assertSame(first, procedure.getResult());
        Integer third = new Integer(3);
        procedure.value(third);
        Assert.assertSame(first, procedure.getResult());
        Integer fourth = new Integer(0);
        procedure.value(fourth);
        Assert.assertSame(fourth, procedure.getResult());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MinProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getResultOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getResultOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.value);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MinProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new MinProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MinProcedureTest> getResultOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MinProcedureTest> value;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.getResultOptional = MinProcedureTest::getResultOptional;
            this.payloads.value = MinProcedureTest::value;
        }
    }
}
