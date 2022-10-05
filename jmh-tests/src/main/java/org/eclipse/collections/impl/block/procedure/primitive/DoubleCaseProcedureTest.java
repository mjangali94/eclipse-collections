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

import org.eclipse.collections.api.list.primitive.DoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class DoubleCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableDoubleList result = DoubleLists.mutable.empty();
        DoubleList source = DoubleLists.mutable.with(1.0, 2.0);
        DoubleCaseProcedure procedure = new DoubleCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("DoubleCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableDoubleList ifOneList = DoubleLists.mutable.empty();
        MutableDoubleList defaultList = DoubleLists.mutable.empty();
        MutableDoubleList list = DoubleLists.mutable.with(1.0, 2.0);
        DoubleCaseProcedure procedure = new DoubleCaseProcedure(defaultList::add).addCase(value -> Double.compare(value, 1) == 0, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(DoubleLists.mutable.with(1.0), ifOneList);
        Assert.assertEquals(DoubleLists.mutable.with(2.0), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableDoubleList ifOneList = DoubleLists.mutable.empty();
        MutableDoubleList ifTwoList = DoubleLists.mutable.empty();
        MutableDoubleList list = DoubleLists.mutable.with(1.0, 2.0, 3.0);
        DoubleCaseProcedure procedure = new DoubleCaseProcedure().addCase(value -> Double.compare(value, 1) == 0, ifOneList::add).addCase(value -> Double.compare(value, 2) == 0, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(DoubleLists.mutable.with(1.0), ifOneList);
        Assert.assertEquals(DoubleLists.mutable.with(2.0), ifTwoList);
        Verify.assertContains("DoubleCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableDoubleList ifOneList = DoubleLists.mutable.empty();
        MutableDoubleList ifTwoList = DoubleLists.mutable.empty();
        MutableDoubleList defaultList = DoubleLists.mutable.empty();
        MutableDoubleList list = DoubleLists.mutable.with(1.0, 2.0, 3.0, 4.0);
        DoubleCaseProcedure procedure = new DoubleCaseProcedure(defaultList::add).addCase(value -> Double.compare(value, 1) == 0, ifOneList::add).addCase(value -> Double.compare(value, 2) == 0, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(DoubleLists.mutable.with(1.0), ifOneList);
        Assert.assertEquals(DoubleLists.mutable.with(2.0), ifTwoList);
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 4.0), defaultList);
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

        private DoubleCaseProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleCaseProcedureTest();
        }

        @java.lang.Override
        public DoubleCaseProcedureTest implementation() {
            return this.implementation;
        }
    }
}
