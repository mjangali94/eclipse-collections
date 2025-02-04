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
 * Provides a set of common tests of checked procedures for Object and double values.
 * This file was automatically generated from template file checkedObjectPrimitiveProcedureTest.stg.
 *
 * @since 5.0.
 */
public final class CheckedObjectDoubleProcedureTest {

    @Test
    public void regular() {
        final boolean[] result = new boolean[1];
        new CheckedObjectDoubleProcedure<Object>() {

            @Override
            public void safeValue(Object object, double item) throws Exception {
                result[0] = true;
            }
        }.value(null, 0.0);
        Assert.assertTrue(result[0]);
    }

    @Test
    public void runtimeException() {
        Assert.assertThrows(RuntimeException.class, () -> {
            new CheckedObjectDoubleProcedure<Object>() {

                @Override
                public void safeValue(Object object, double item) throws Exception {
                    throw new RuntimeException();
                }
            }.value(null, 0.0);
        });
    }

    @Test
    public void checkedException() {
        Assert.assertThrows(RuntimeException.class, () -> {
            new CheckedObjectDoubleProcedure<Object>() {

                @Override
                public void safeValue(Object object, double item) throws Exception {
                    throw new IOException();
                }
            }.value(null, 0.0);
        });
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CheckedObjectDoubleProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_regular() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.regular);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_runtimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.runtimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedException);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedObjectDoubleProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new CheckedObjectDoubleProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedObjectDoubleProcedureTest> regular;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedObjectDoubleProcedureTest> runtimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedObjectDoubleProcedureTest> checkedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.regular = CheckedObjectDoubleProcedureTest::regular;
            this.payloads.runtimeException = CheckedObjectDoubleProcedureTest::runtimeException;
            this.payloads.checkedException = CheckedObjectDoubleProcedureTest::checkedException;
        }
    }
*/
}
