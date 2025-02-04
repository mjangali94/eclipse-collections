/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

// This class is not a full test of AddFunction at present, but serves as a
// holder for the addStringBlockHandlesNulls() test which had been put in the
// BlocksTest class erroneously. The BlocksTest class has since been removed.
public class AddFunctionTest {

    @Test
    public void addStringBlockHandlesNulls() {
        Function2<String, String, String> undertest = AddFunction.STRING;
        Assert.assertEquals("two", undertest.value(null, "two"));
        Assert.assertEquals("one", undertest.value("one", null));
    }

    @Test
    public void addLongFunction() {
        Function2<Long, Long, Long> longFunction = AddFunction.LONG;
        Assert.assertEquals(Long.valueOf(3L), longFunction.value(1L, 2L));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(AddFunction.class);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AddFunctionTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addStringBlockHandlesNulls() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addStringBlockHandlesNulls);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addLongFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addLongFunction);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AddFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new AddFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AddFunctionTest> addStringBlockHandlesNulls;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AddFunctionTest> addLongFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AddFunctionTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.addStringBlockHandlesNulls = AddFunctionTest::addStringBlockHandlesNulls;
            this.payloads.addLongFunction = AddFunctionTest::addLongFunction;
            this.payloads.classIsNonInstantiable = AddFunctionTest::classIsNonInstantiable;
        }
    }
*/
}
