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
 * Provides a set of common tests of checked procedures for double and float values.
 * This file was automatically generated from template file checkedPrimitivePrimitiveProcedureTest.stg.
 *
 * @since 5.0.
 */
public final class CheckedDoubleFloatProcedureTest {

    @Test
    public void regular() {
        final boolean[] result = new boolean[1];
        new CheckedDoubleFloatProcedure() {

            @Override
            public void safeValue(double item1, float item2) throws Exception {
                result[0] = true;
            }
        }.value(0.0, 0.0f);
        Assert.assertTrue(result[0]);
    }

    @Test
    public void runtimeException() {
        Assert.assertThrows(RuntimeException.class, () -> new CheckedDoubleFloatProcedure() {

            @Override
            public void safeValue(double item1, float item2) throws Exception {
                throw new RuntimeException();
            }
        }.value(0.0, 0.0f));
    }

    @Test
    public void checkedException() {
        Assert.assertThrows(RuntimeException.class, () -> new CheckedDoubleFloatProcedure() {

            @Override
            public void safeValue(double item1, float item2) throws Exception {
                throw new IOException();
            }
        }.value(0.0, 0.0f));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_regular() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::regular, this.description("regular"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_runtimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::runtimeException, this.description("runtimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedException, this.description("checkedException"));
        }

        private CheckedDoubleFloatProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CheckedDoubleFloatProcedureTest();
        }

        @java.lang.Override
        public CheckedDoubleFloatProcedureTest implementation() {
            return this.implementation;
        }
    }
}
