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
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class SelectProcedureTest {

    @Test
    public void getCollection() {
        SelectProcedure<Integer> selectProcedure = new SelectProcedure<>(Predicates.alwaysTrue(), Lists.mutable.empty());
        Verify.assertEmpty(selectProcedure.getCollection());
        selectProcedure.value(1);
        Verify.assertSize(1, selectProcedure.getCollection());
        Verify.assertContainsAll(selectProcedure.getCollection(), 1);
        selectProcedure.value(2);
        Verify.assertSize(2, selectProcedure.getCollection());
        Verify.assertContainsAll(selectProcedure.getCollection(), 1, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getCollection);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new SelectProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectProcedureTest> getCollection;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.getCollection = SelectProcedureTest::getCollection;
        }
    }
}
