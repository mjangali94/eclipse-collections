/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure.checked.primitive;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Provides a set of common tests of checked procedures for char and float values.
 * This file was automatically generated from template file checkedPrimitivePrimitiveProcedureTest.stg.
 *
 * @since 5.0.
 */
public final class CheckedCharFloatProcedureTest {

    @Test
    public void regular() {
        final boolean[] result = new boolean[1];
        new CheckedCharFloatProcedure() {

            @Override
            public void safeValue(char item1, float item2) throws Exception {
                result[0] = true;
            }
        }.value('\0', 0.0f);
        Assert.assertTrue(result[0]);
    }

    @Test
    public void runtimeException() {
        Assert.assertThrows(RuntimeException.class, () -> new CheckedCharFloatProcedure() {

            @Override
            public void safeValue(char item1, float item2) throws Exception {
                throw new RuntimeException();
            }
        }.value('\0', 0.0f));
    }

    @Test
    public void checkedException() {
        Assert.assertThrows(RuntimeException.class, () -> new CheckedCharFloatProcedure() {

            @Override
            public void safeValue(char item1, float item2) throws Exception {
                throw new IOException();
            }
        }.value('\0', 0.0f));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CheckedCharFloatProcedureTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_regular() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.regular);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_runtimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.runtimeException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedException);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedCharFloatProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new CheckedCharFloatProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedCharFloatProcedureTest> regular;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedCharFloatProcedureTest> runtimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedCharFloatProcedureTest> checkedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.regular = CheckedCharFloatProcedureTest::regular;
            this.payloads.runtimeException = CheckedCharFloatProcedureTest::runtimeException;
            this.payloads.checkedException = CheckedCharFloatProcedureTest::checkedException;
        }
    }
}
