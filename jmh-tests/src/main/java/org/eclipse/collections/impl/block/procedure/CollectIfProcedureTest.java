/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.junit.Assert;
import org.junit.Test;

public class CollectIfProcedureTest {

    private static final int THE_ANSWER = 42;

    @Test
    public void constructorWithSize() {
        CollectIfProcedure<Integer, String> underTestTrue = new CollectIfProcedure<>(10, String::valueOf, ignored -> true);
        CollectIfProcedure<Integer, String> underTestFalse = new CollectIfProcedure<>(10, String::valueOf, ignored -> false);
        underTestTrue.value(THE_ANSWER);
        underTestFalse.value(THE_ANSWER);
        Assert.assertTrue(underTestTrue.getCollection().contains("42"));
        Assert.assertFalse(underTestFalse.getCollection().contains("42"));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectIfProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorWithSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.constructorWithSize);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIfProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new CollectIfProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIfProcedureTest> constructorWithSize;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.constructorWithSize = CollectIfProcedureTest::constructorWithSize;
        }
    }
*/
}
