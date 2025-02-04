/*
 * Copyright (c) 2021 Goldman Sachs and others.
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
        Verify.assertSame(procedure, procedure.setDefault(result::add));
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
    public static class _Benchmark {

        private _Payloads payloads;

        private CaseProcedureTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CaseProcedureTest> payload) throws java.lang.Throwable {
            this.instance = new CaseProcedureTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CaseProcedureTest> noopCaseAndThenDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CaseProcedureTest> oneCaseWithDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CaseProcedureTest> twoCasesNoDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CaseProcedureTest> twoCasesWithDefault;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noopCaseAndThenDefault = CaseProcedureTest::noopCaseAndThenDefault;
            this.payloads.oneCaseWithDefault = CaseProcedureTest::oneCaseWithDefault;
            this.payloads.twoCasesNoDefault = CaseProcedureTest::twoCasesNoDefault;
            this.payloads.twoCasesWithDefault = CaseProcedureTest::twoCasesWithDefault;
        }
    }
}
