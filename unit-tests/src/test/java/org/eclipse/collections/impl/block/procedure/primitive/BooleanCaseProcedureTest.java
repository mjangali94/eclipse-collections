/*
 * Copyright (c) 2017 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure.primitive;

import org.eclipse.collections.api.list.primitive.BooleanList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class BooleanCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableBooleanList result = BooleanLists.mutable.empty();
        BooleanList source = BooleanLists.mutable.with(true, false);
        BooleanCaseProcedure procedure = new BooleanCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("BooleanCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableBooleanList ifOneList = BooleanLists.mutable.empty();
        MutableBooleanList defaultList = BooleanLists.mutable.empty();
        MutableBooleanList list = BooleanLists.mutable.with(true, false);
        BooleanCaseProcedure procedure = new BooleanCaseProcedure(defaultList::add).addCase(value -> value, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(BooleanLists.mutable.with(true), ifOneList);
        Assert.assertEquals(BooleanLists.mutable.with(false), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableBooleanList ifTrueList = BooleanLists.mutable.empty();
        MutableBooleanList ifFalseList = BooleanLists.mutable.empty();
        MutableBooleanList list = BooleanLists.mutable.with(true, false);
        BooleanCaseProcedure procedure = new BooleanCaseProcedure().addCase(value -> value, ifTrueList::add).addCase(value -> !value, ifFalseList::add);
        list.each(procedure);
        Assert.assertEquals(BooleanLists.mutable.with(true), ifTrueList);
        Assert.assertEquals(BooleanLists.mutable.with(false), ifFalseList);
        Verify.assertContains("BooleanCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableBooleanList ifOneList = BooleanLists.mutable.empty();
        MutableBooleanList ifTwoList = BooleanLists.mutable.empty();
        MutableBooleanList defaultList = BooleanLists.mutable.empty();
        MutableBooleanList list = BooleanLists.mutable.with(true, true, false, false);
        BooleanCaseProcedure procedure = new BooleanCaseProcedure(defaultList::add).addCase(value -> value, ifOneList::add).addCase(value -> !value, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(BooleanLists.mutable.with(true, true), ifOneList);
        Assert.assertEquals(BooleanLists.mutable.with(false, false), ifTwoList);
        Assert.assertEquals(BooleanLists.mutable.empty(), defaultList);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCaseAndThenDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noopCaseAndThenDefault, this.description("noopCaseAndThenDefault"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_oneCaseWithDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::oneCaseWithDefault, this.description("oneCaseWithDefault"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_twoCasesNoDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::twoCasesNoDefault, this.description("twoCasesNoDefault"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_twoCasesWithDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::twoCasesWithDefault, this.description("twoCasesWithDefault"));
        }

        private BooleanCaseProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanCaseProcedureTest();
        }

        @java.lang.Override
        public BooleanCaseProcedureTest implementation() {
            return this.implementation;
        }
    }
}
