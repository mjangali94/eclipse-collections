/*
 * Copyright (c) 2017 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import java.util.List;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class CaseProcedureTest {

    @Test
    public void noopCaseAndThenDefault() {
        List<String> result = Lists.mutable.empty();
        FastList<String> strings = FastList.newListWith("1", "2");
        CaseProcedure<String> procedure = new CaseProcedure<>();
        strings.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        strings.each(procedure);
        Assert.assertEquals(result, strings);
        Verify.assertContains("CaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault() {
        MutableList<String> ifOneList = Lists.mutable.of();
        MutableList<String> defaultList = Lists.mutable.of();
        MutableList<String> list = FastList.newListWith("1", "2");
        CaseProcedure<String> procedure = new CaseProcedure<String>(defaultList::add).addCase("1"::equals, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(FastList.newListWith("1"), ifOneList);
        Assert.assertEquals(FastList.newListWith("2"), defaultList);
        Verify.assertContains("CaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesNoDefault() {
        MutableList<String> ifOneList = Lists.mutable.of();
        MutableList<String> ifTwoList = Lists.mutable.of();
        MutableList<String> list = FastList.newListWith("1", "2", "3");
        CaseProcedure<String> procedure = new CaseProcedure<String>().addCase("1"::equals, ifOneList::add).addCase("2"::equals, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(FastList.newListWith("1"), ifOneList);
        Assert.assertEquals(FastList.newListWith("2"), ifTwoList);
        Verify.assertContains("CaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault() {
        MutableList<String> ifOneList = Lists.mutable.of();
        MutableList<String> ifTwoList = Lists.mutable.of();
        MutableList<String> defaultList = Lists.mutable.of();
        MutableList<String> list = FastList.newListWith("1", "2", "3", "4");
        CaseProcedure<String> procedure = new CaseProcedure<String>(defaultList::add).addCase("1"::equals, ifOneList::add).addCase("2"::equals, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(FastList.newListWith("1"), ifOneList);
        Assert.assertEquals(FastList.newListWith("2"), ifTwoList);
        Assert.assertEquals(FastList.newListWith("3", "4"), defaultList);
        Verify.assertContains("CaseProcedure", procedure.toString());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
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

        private CaseProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CaseProcedureTest();
        }

        @java.lang.Override
        public CaseProcedureTest implementation() {
            return this.implementation;
        }
    }
}
