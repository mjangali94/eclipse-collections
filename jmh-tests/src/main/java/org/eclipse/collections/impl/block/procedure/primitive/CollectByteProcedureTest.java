/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure.primitive;

import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file CollectPrimitiveProcedureTest.stg.
 */
public class CollectByteProcedureTest {

    @Test
    public void basicCase() {
        ByteFunction<String> stringToLengthFunction = (String string) -> (byte) string.length();
        MutableByteList targetList = ByteLists.mutable.empty();
        CollectByteProcedure<String> procedure = new CollectByteProcedure(stringToLengthFunction, targetList);
        procedure.value("");
        procedure.value("0");
        procedure.value("00");
        ImmutableByteList expected = ByteLists.immutable.with((byte) 0, (byte) 1, (byte) 2);
        Assert.assertEquals(expected, targetList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectByteProcedureTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.basicCase);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new CollectByteProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteProcedureTest> basicCase;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.basicCase = CollectByteProcedureTest::basicCase;
        }
    }
}
