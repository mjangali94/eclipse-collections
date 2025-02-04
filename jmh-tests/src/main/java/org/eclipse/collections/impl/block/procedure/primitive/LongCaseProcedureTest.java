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

import org.eclipse.collections.api.list.primitive.LongList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class LongCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableLongList result = LongLists.mutable.empty();
        LongList source = LongLists.mutable.with(1L, 2L);
        LongCaseProcedure procedure = new LongCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("LongCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableLongList ifOneList = LongLists.mutable.empty();
        MutableLongList defaultList = LongLists.mutable.empty();
        MutableLongList list = LongLists.mutable.with(1L, 2L);
        LongCaseProcedure procedure = new LongCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(LongLists.mutable.with(1L), ifOneList);
        Assert.assertEquals(LongLists.mutable.with(2L), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableLongList ifOneList = LongLists.mutable.empty();
        MutableLongList ifTwoList = LongLists.mutable.empty();
        MutableLongList list = LongLists.mutable.with(1L, 2L, 3L);
        LongCaseProcedure procedure = new LongCaseProcedure().addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(LongLists.mutable.with(1L), ifOneList);
        Assert.assertEquals(LongLists.mutable.with(2L), ifTwoList);
        Verify.assertContains("LongCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableLongList ifOneList = LongLists.mutable.empty();
        MutableLongList ifTwoList = LongLists.mutable.empty();
        MutableLongList defaultList = LongLists.mutable.empty();
        MutableLongList list = LongLists.mutable.with(1L, 2L, 3L, 4L);
        LongCaseProcedure procedure = new LongCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(LongLists.mutable.with(1L), ifOneList);
        Assert.assertEquals(LongLists.mutable.with(2L), ifTwoList);
        Assert.assertEquals(LongLists.mutable.with(3L, 4L), defaultList);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongCaseProcedureTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCaseAndThenDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noopCaseAndThenDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_oneCaseWithDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.oneCaseWithDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_twoCasesNoDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.twoCasesNoDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_twoCasesWithDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.twoCasesWithDefault);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongCaseProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new LongCaseProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCaseProcedureTest> noopCaseAndThenDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCaseProcedureTest> oneCaseWithDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCaseProcedureTest> twoCasesNoDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCaseProcedureTest> twoCasesWithDefault;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCaseAndThenDefault = LongCaseProcedureTest::noopCaseAndThenDefault;
            this.payloads.oneCaseWithDefault = LongCaseProcedureTest::oneCaseWithDefault;
            this.payloads.twoCasesNoDefault = LongCaseProcedureTest::twoCasesNoDefault;
            this.payloads.twoCasesWithDefault = LongCaseProcedureTest::twoCasesWithDefault;
        }
    }
*/
}
