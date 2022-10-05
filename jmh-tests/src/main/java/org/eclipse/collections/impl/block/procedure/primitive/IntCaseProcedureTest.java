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

import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class IntCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableIntList result = IntLists.mutable.empty();
        IntList source = IntLists.mutable.with(1, 2);
        IntCaseProcedure procedure = new IntCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("IntCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableIntList ifOneList = IntLists.mutable.empty();
        MutableIntList defaultList = IntLists.mutable.empty();
        MutableIntList list = IntLists.mutable.with(1, 2);
        IntCaseProcedure procedure = new IntCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(IntLists.mutable.with(1), ifOneList);
        Assert.assertEquals(IntLists.mutable.with(2), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableIntList ifOneList = IntLists.mutable.empty();
        MutableIntList ifTwoList = IntLists.mutable.empty();
        MutableIntList list = IntLists.mutable.with(1, 2, 3);
        IntCaseProcedure procedure = new IntCaseProcedure().addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(IntLists.mutable.with(1), ifOneList);
        Assert.assertEquals(IntLists.mutable.with(2), ifTwoList);
        Verify.assertContains("IntCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableIntList ifOneList = IntLists.mutable.empty();
        MutableIntList ifTwoList = IntLists.mutable.empty();
        MutableIntList defaultList = IntLists.mutable.empty();
        MutableIntList list = IntLists.mutable.with(1, 2, 3, 4);
        IntCaseProcedure procedure = new IntCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(IntLists.mutable.with(1), ifOneList);
        Assert.assertEquals(IntLists.mutable.with(2), ifTwoList);
        Assert.assertEquals(IntLists.mutable.with(3, 4), defaultList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntCaseProcedureTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntCaseProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new IntCaseProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCaseProcedureTest> noopCaseAndThenDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCaseProcedureTest> oneCaseWithDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCaseProcedureTest> twoCasesNoDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCaseProcedureTest> twoCasesWithDefault;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCaseAndThenDefault = IntCaseProcedureTest::noopCaseAndThenDefault;
            this.payloads.oneCaseWithDefault = IntCaseProcedureTest::oneCaseWithDefault;
            this.payloads.twoCasesNoDefault = IntCaseProcedureTest::twoCasesNoDefault;
            this.payloads.twoCasesWithDefault = IntCaseProcedureTest::twoCasesWithDefault;
        }
    }
}
