/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.block.factory.Procedures2;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class Procedures2Test {

    @Test
    public void throwing() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> Procedures2.throwing((a, b) -> {
            throw new IOException();
        }).value(null, null));
    }

    @Test
    public void throwingWithUserSpecifiedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> Procedures2.throwing((one, two) -> {
            throw new IOException();
        }, (one, two, ce) -> new RuntimeException(ce)).value(null, null));
        Verify.assertThrowsWithCause(MyRuntimeException.class, IOException.class, () -> Procedures2.throwing((one, two) -> {
            throw new IOException();
        }, this::throwMyException).value(null, null));
        Assert.assertThrows(NullPointerException.class, () -> Procedures2.throwing((one, two) -> {
            throw new NullPointerException();
        }, this::throwMyException).value(null, null));
    }

    private MyRuntimeException throwMyException(Object one, Object two, Throwable exception) {
        return new MyRuntimeException(String.valueOf(one) + two, exception);
    }

    @Test
    public void asProcedure2() {
        CollectionAddProcedure<Integer> procedure = CollectionAddProcedure.on(FastList.newList());
        Procedure2<Integer, Object> procedure2 = Procedures2.fromProcedure(procedure);
        procedure2.value(1, null);
        Assert.assertEquals(FastList.newListWith(1), procedure.getResult());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(Procedures2.class);
    }

    private static class MyRuntimeException extends RuntimeException {

        MyRuntimeException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * @since 9.2.
     */
    @Test
    public void summarizeDouble() {
        MutableList<Double> list = Lists.mutable.with(2.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        MutableMap<String, DoubleSummaryStatistics> map = list.aggregateInPlaceBy(Object::toString, DoubleSummaryStatistics::new, Procedures2.summarizeDouble(Double::doubleValue));
        Verify.assertSize(2, map);
        Assert.assertEquals(6.0, map.get("2.0").getSum(), 0.0);
        Assert.assertEquals(9.0, map.get("3.0").getSum(), 0.0);
    }

    /**
     * @since 9.2.
     */
    @Test
    public void summarizeFloat() {
        MutableList<Float> list = Lists.mutable.with(2.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        MutableMap<String, DoubleSummaryStatistics> map = list.aggregateInPlaceBy(Object::toString, DoubleSummaryStatistics::new, Procedures2.summarizeFloat(Float::floatValue));
        Verify.assertSize(2, map);
        Assert.assertEquals(6.0, map.get("2.0").getSum(), 0.0);
        Assert.assertEquals(9.0, map.get("3.0").getSum(), 0.0);
    }

    /**
     * @since 9.2.
     */
    @Test
    public void summarizeLong() {
        MutableList<Long> list = Lists.mutable.with(2L, 2L, 2L, 3L, 3L, 3L);
        MutableMap<String, LongSummaryStatistics> map = list.aggregateInPlaceBy(Object::toString, LongSummaryStatistics::new, Procedures2.summarizeLong(Long::longValue));
        Verify.assertSize(2, map);
        Assert.assertEquals(6, map.get("2").getSum());
        Assert.assertEquals(9, map.get("3").getSum());
    }

    /**
     * @since 9.2.
     */
    @Test
    public void summarizeInt() {
        MutableList<Integer> list = Lists.mutable.with(2, 2, 2, 3, 3, 3);
        MutableMap<String, IntSummaryStatistics> map = list.aggregateInPlaceBy(Object::toString, IntSummaryStatistics::new, Procedures2.summarizeInt(Integer::intValue));
        Verify.assertSize(2, map);
        Assert.assertEquals(6, map.get("2").getSum());
        Assert.assertEquals(9, map.get("3").getSum());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwing() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::throwing, this.description("throwing"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_throwingWithUserSpecifiedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::throwingWithUserSpecifiedException, this.description("throwingWithUserSpecifiedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asProcedure2() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asProcedure2, this.description("asProcedure2"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::summarizeDouble, this.description("summarizeDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::summarizeFloat, this.description("summarizeFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::summarizeLong, this.description("summarizeLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::summarizeInt, this.description("summarizeInt"));
        }

        private Procedures2Test implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new Procedures2Test();
        }

        @java.lang.Override
        public Procedures2Test implementation() {
            return this.implementation;
        }
    }
}
