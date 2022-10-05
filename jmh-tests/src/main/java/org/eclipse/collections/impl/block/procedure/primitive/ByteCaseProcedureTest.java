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

import org.eclipse.collections.api.list.primitive.ByteList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class ByteCaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        MutableByteList result = ByteLists.mutable.empty();
        ByteList source = ByteLists.mutable.with((byte) 1, (byte) 2);
        ByteCaseProcedure procedure = new ByteCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("ByteCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableByteList ifOneList = ByteLists.mutable.empty();
        MutableByteList defaultList = ByteLists.mutable.empty();
        MutableByteList list = ByteLists.mutable.with((byte) 1, (byte) 2);
        ByteCaseProcedure procedure = new ByteCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(ByteLists.mutable.with((byte) 1), ifOneList);
        Assert.assertEquals(ByteLists.mutable.with((byte) 2), defaultList);
    }

    @Test
    public void twoCasesNoDefault() {
        MutableByteList ifOneList = ByteLists.mutable.empty();
        MutableByteList ifTwoList = ByteLists.mutable.empty();
        MutableByteList list = ByteLists.mutable.with((byte) 1, (byte) 2, (byte) 3);
        ByteCaseProcedure procedure = new ByteCaseProcedure().addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(ByteLists.mutable.with((byte) 1), ifOneList);
        Assert.assertEquals(ByteLists.mutable.with((byte) 2), ifTwoList);
        Verify.assertContains("ByteCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableByteList ifOneList = ByteLists.mutable.empty();
        MutableByteList ifTwoList = ByteLists.mutable.empty();
        MutableByteList defaultList = ByteLists.mutable.empty();
        MutableByteList list = ByteLists.mutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        ByteCaseProcedure procedure = new ByteCaseProcedure(defaultList::add).addCase(value -> value == 1, ifOneList::add).addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(ByteLists.mutable.with((byte) 1), ifOneList);
        Assert.assertEquals(ByteLists.mutable.with((byte) 2), ifTwoList);
        Assert.assertEquals(ByteLists.mutable.with((byte) 3, (byte) 4), defaultList);
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

        private ByteCaseProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteCaseProcedureTest();
        }

        @java.lang.Override
        public ByteCaseProcedureTest implementation() {
            return this.implementation;
        }
    }
}
