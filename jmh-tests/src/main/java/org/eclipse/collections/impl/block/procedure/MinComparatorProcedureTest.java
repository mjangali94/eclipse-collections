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

import org.eclipse.collections.impl.block.factory.Comparators;
import org.junit.Assert;
import org.junit.Test;

public class MinComparatorProcedureTest {

    @Test
    public void value() {
        MinComparatorProcedure<Integer> procedure = new MinComparatorProcedure<>(Comparators.naturalOrder());
        Integer first = new Integer(1);
        Integer second = new Integer(1);
        Integer third = new Integer(3);
        Integer fourth = new Integer(0);
        procedure.value(first);
        Assert.assertSame(first, procedure.getResult());
        procedure.value(second);
        Assert.assertSame(first, procedure.getResult());
        procedure.value(third);
        Assert.assertSame(first, procedure.getResult());
        procedure.value(fourth);
        Assert.assertSame(fourth, procedure.getResult());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MinComparatorProcedureTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.value);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MinComparatorProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new MinComparatorProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MinComparatorProcedureTest> value;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.value = MinComparatorProcedureTest::value;
        }
    }
}
