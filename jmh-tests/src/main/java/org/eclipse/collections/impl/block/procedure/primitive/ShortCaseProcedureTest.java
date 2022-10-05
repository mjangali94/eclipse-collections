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

import org.eclipse.collections.api.list.primitive.ShortList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class ShortCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableShortList result = ShortLists.mutable.empty();
        ShortList source = ShortLists.mutable.with((short) 1, (short) 2);
        ShortCaseProcedure procedure = new ShortCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("ShortCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableShortList ifOneList = ShortLists.mutable.empty();
        MutableShortList defaultList = ShortLists.mutable.empty();
        MutableShortList list = ShortLists.mutable.with((short) 1, (short) 2);
        ShortCaseProcedure procedure = new ShortCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(ShortLists.mutable.with((short) 1), ifOneList);
        Assert.assertEquals(ShortLists.mutable.with((short) 2), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableShortList ifOneList = ShortLists.mutable.empty();
        MutableShortList ifTwoList = ShortLists.mutable.empty();
        MutableShortList list = ShortLists.mutable.with((short) 1, (short) 2, (short) 3);
        ShortCaseProcedure procedure = new ShortCaseProcedure().addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(ShortLists.mutable.with((short) 1), ifOneList);
        Assert.assertEquals(ShortLists.mutable.with((short) 2), ifTwoList);
        Verify.assertContains("ShortCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableShortList ifOneList = ShortLists.mutable.empty();
        MutableShortList ifTwoList = ShortLists.mutable.empty();
        MutableShortList defaultList = ShortLists.mutable.empty();
        MutableShortList list = ShortLists.mutable.with((short) 1, (short) 2, (short) 3, (short) 4);
        ShortCaseProcedure procedure = new ShortCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(ShortLists.mutable.with((short) 1), ifOneList);
        Assert.assertEquals(ShortLists.mutable.with((short) 2), ifTwoList);
        Assert.assertEquals(ShortLists.mutable.with((short) 3, (short) 4), defaultList);
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

        private ShortCaseProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortCaseProcedureTest();
        }

        @java.lang.Override
        public ShortCaseProcedureTest implementation() {
            return this.implementation;
        }
    }
}
