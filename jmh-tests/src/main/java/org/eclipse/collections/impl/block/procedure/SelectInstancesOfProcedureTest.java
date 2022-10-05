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
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class SelectInstancesOfProcedureTest {

    @Test
    public void getCollection() {
        SelectInstancesOfProcedure<Integer> procedure = new SelectInstancesOfProcedure<>(Integer.class, Lists.mutable.empty());
        Verify.assertEmpty(procedure.getCollection());
        procedure.value("test");
        Verify.assertEmpty(procedure.getCollection());
        procedure.value(1);
        Verify.assertSize(1, procedure.getCollection());
        Verify.assertContainsAll(procedure.getCollection(), 1);
        procedure.value(2);
        Verify.assertSize(2, procedure.getCollection());
        Verify.assertContainsAll(procedure.getCollection(), 1, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectInstancesOfProcedureTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCollection);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new SelectInstancesOfProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectInstancesOfProcedureTest> getCollection;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.getCollection = SelectInstancesOfProcedureTest::getCollection;
        }
    }
}
