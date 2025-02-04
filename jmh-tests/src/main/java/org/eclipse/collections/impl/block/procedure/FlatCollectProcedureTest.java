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

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.list.Interval;
import org.junit.Assert;
import org.junit.Test;

public class FlatCollectProcedureTest {

    @Test
    public void value() {
        FlatCollectProcedure<Integer, Integer> procedure = new FlatCollectProcedure<>(each -> Interval.from(0).to(each).collect(Functions.getPassThru()), Lists.mutable.empty());
        procedure.value(1);
        procedure.value(2);
        procedure.value(3);
        Assert.assertEquals(Lists.mutable.of(0, 1, 0, 1, 2, 0, 1, 2, 3), procedure.getCollection());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FlatCollectProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.value);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new FlatCollectProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FlatCollectProcedureTest> value;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.value = FlatCollectProcedureTest::value;
        }
    }
}
