/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure.primitive;

import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.junit.Assert;
import org.junit.Test;

public class CollectBooleanProcedureTest {

    @Test
    public void basicCase() {
        BooleanFunction<String> stringIsEmptyFunction = String::isEmpty;
        MutableBooleanList targetList = BooleanLists.mutable.empty();
        Procedure<String> procedure = new CollectBooleanProcedure<>(stringIsEmptyFunction, targetList);
        procedure.value("");
        procedure.value("0");
        procedure.value("00");
        ImmutableBooleanList expected = BooleanLists.immutable.with(true, false, false);
        Assert.assertEquals(expected, targetList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectBooleanProcedureTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.basicCase);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectBooleanProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new CollectBooleanProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectBooleanProcedureTest> basicCase;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.basicCase = CollectBooleanProcedureTest::basicCase;
        }
    }
}
