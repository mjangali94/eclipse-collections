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

import org.eclipse.collections.api.list.primitive.CharList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class CharCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableCharList result = CharLists.mutable.empty();
        CharList source = CharLists.mutable.with((char) 1, (char) 2);
        CharCaseProcedure procedure = new CharCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("CharCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableCharList ifOneList = CharLists.mutable.empty();
        MutableCharList defaultList = CharLists.mutable.empty();
        MutableCharList list = CharLists.mutable.with((char) 1, (char) 2);
        CharCaseProcedure procedure = new CharCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(CharLists.mutable.with((char) 1), ifOneList);
        Assert.assertEquals(CharLists.mutable.with((char) 2), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableCharList ifOneList = CharLists.mutable.empty();
        MutableCharList ifTwoList = CharLists.mutable.empty();
        MutableCharList list = CharLists.mutable.with((char) 1, (char) 2, (char) 3);
        CharCaseProcedure procedure = new CharCaseProcedure().addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(CharLists.mutable.with((char) 1), ifOneList);
        Assert.assertEquals(CharLists.mutable.with((char) 2), ifTwoList);
        Verify.assertContains("CharCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableCharList ifOneList = CharLists.mutable.empty();
        MutableCharList ifTwoList = CharLists.mutable.empty();
        MutableCharList defaultList = CharLists.mutable.empty();
        MutableCharList list = CharLists.mutable.with((char) 1, (char) 2, (char) 3, (char) 4);
        CharCaseProcedure procedure = new CharCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(CharLists.mutable.with((char) 1), ifOneList);
        Assert.assertEquals(CharLists.mutable.with((char) 2), ifTwoList);
        Assert.assertEquals(CharLists.mutable.with((char) 3, (char) 4), defaultList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharCaseProcedureTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharCaseProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new CharCaseProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharCaseProcedureTest> noopCaseAndThenDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharCaseProcedureTest> oneCaseWithDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharCaseProcedureTest> twoCasesNoDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharCaseProcedureTest> twoCasesWithDefault;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCaseAndThenDefault = CharCaseProcedureTest::noopCaseAndThenDefault;
            this.payloads.oneCaseWithDefault = CharCaseProcedureTest::oneCaseWithDefault;
            this.payloads.twoCasesNoDefault = CharCaseProcedureTest::twoCasesNoDefault;
            this.payloads.twoCasesWithDefault = CharCaseProcedureTest::twoCasesWithDefault;
        }
    }
}
