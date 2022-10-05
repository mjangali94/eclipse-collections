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

import org.eclipse.collections.api.list.primitive.FloatList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class FloatCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableFloatList result = FloatLists.mutable.empty();
        FloatList source = FloatLists.mutable.with(1.0f, 2.0f);
        FloatCaseProcedure procedure = new FloatCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("FloatCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableFloatList ifOneList = FloatLists.mutable.empty();
        MutableFloatList defaultList = FloatLists.mutable.empty();
        MutableFloatList list = FloatLists.mutable.with(1.0f, 2.0f);
        FloatCaseProcedure procedure = new FloatCaseProcedure(defaultList::add).addCase(value -> Float.compare(value, 1) == 0, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(FloatLists.mutable.with(1.0f), ifOneList);
        Assert.assertEquals(FloatLists.mutable.with(2.0f), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableFloatList ifOneList = FloatLists.mutable.empty();
        MutableFloatList ifTwoList = FloatLists.mutable.empty();
        MutableFloatList list = FloatLists.mutable.with(1.0f, 2.0f, 3.0f);
        FloatCaseProcedure procedure = new FloatCaseProcedure().addCase(value -> Float.compare(value, 1) == 0, ifOneList::add).addCase(value -> Float.compare(value, 2) == 0, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(FloatLists.mutable.with(1.0f), ifOneList);
        Assert.assertEquals(FloatLists.mutable.with(2.0f), ifTwoList);
        Verify.assertContains("FloatCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableFloatList ifOneList = FloatLists.mutable.empty();
        MutableFloatList ifTwoList = FloatLists.mutable.empty();
        MutableFloatList defaultList = FloatLists.mutable.empty();
        MutableFloatList list = FloatLists.mutable.with(1.0f, 2.0f, 3.0f, 4.0f);
        FloatCaseProcedure procedure = new FloatCaseProcedure(defaultList::add).addCase(value -> Float.compare(value, 1) == 0, ifOneList::add).addCase(value -> Float.compare(value, 2) == 0, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(FloatLists.mutable.with(1.0f), ifOneList);
        Assert.assertEquals(FloatLists.mutable.with(2.0f), ifTwoList);
        Assert.assertEquals(FloatLists.mutable.with(3.0f, 4.0f), defaultList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatCaseProcedureTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCaseAndThenDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noopCaseAndThenDefault);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_oneCaseWithDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.oneCaseWithDefault);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_twoCasesNoDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.twoCasesNoDefault);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_twoCasesWithDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.twoCasesWithDefault);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCaseProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new FloatCaseProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCaseProcedureTest> noopCaseAndThenDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCaseProcedureTest> oneCaseWithDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCaseProcedureTest> twoCasesNoDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCaseProcedureTest> twoCasesWithDefault;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCaseAndThenDefault = FloatCaseProcedureTest::noopCaseAndThenDefault;
            this.payloads.oneCaseWithDefault = FloatCaseProcedureTest::oneCaseWithDefault;
            this.payloads.twoCasesNoDefault = FloatCaseProcedureTest::twoCasesNoDefault;
            this.payloads.twoCasesWithDefault = FloatCaseProcedureTest::twoCasesWithDefault;
        }
    }
}
