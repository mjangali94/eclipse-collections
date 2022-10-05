/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.junit.Assert;
import org.junit.Test;

public class IfFunctionTest {

    @Test
    public void iterate() {
        UnifiedMap<Integer, Integer> map = UnifiedMap.newMap(5);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        Function<Integer, Integer> function = new IfFunction<>(IntegerPredicates.isEven(), (Integer ignored) -> 1, (Integer ignored) -> 0);
        MutableList<Integer> result = map.valuesView().collect(function).toList();
        Assert.assertEquals(FastList.newListWith(0, 1, 0, 1, 0), result);
    }

    @Test
    public void testIf() {
        IfFunction<Integer, Boolean> function = new IfFunction<>(Predicates.greaterThan(5), (Integer ignored) -> true);
        Assert.assertTrue(function.valueOf(10));
    }

    @Test
    public void ifElse() {
        IfFunction<Integer, Boolean> function = new IfFunction<>(Predicates.greaterThan(5), (Integer ignored) -> true, (Integer ignored) -> false);
        Assert.assertFalse(function.valueOf(1));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IfFunctionTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifElse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifElse);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IfFunctionTest> payload) throws java.lang.Throwable {
            this.instance = new IfFunctionTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IfFunctionTest> iterate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IfFunctionTest> testIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IfFunctionTest> ifElse;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.iterate = IfFunctionTest::iterate;
            this.payloads.testIf = IfFunctionTest::testIf;
            this.payloads.ifElse = IfFunctionTest::ifElse;
        }
    }
}
