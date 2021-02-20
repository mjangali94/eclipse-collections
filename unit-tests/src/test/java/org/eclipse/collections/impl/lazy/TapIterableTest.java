/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy;

import org.eclipse.collections.api.InternalIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class TapIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        Appendable builder = new StringBuilder();
        Procedure<T> appendProcedure = Procedures.append(builder);
        return LazyIterate.tap(FastList.newListWith(elements), appendProcedure);
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        InternalIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        Procedure<Integer> appendDouble = each -> builder.append(each * 2);
        tap.forEach(appendDouble);
        Assert.assertEquals("12243648510", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        InternalIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        tap.forEachWithIndex((each, index) -> {
            builder.append(each * 2);
            builder.append(index);
        });
        Assert.assertEquals("1202413624835104", builder.toString());
    }

    @Override
    @Test
    public void iterator() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        InternalIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        for (Integer each : tap) {
            builder.append(each + 1);
        }
        Assert.assertEquals("1223344556", builder.toString());
    }

    @Test
    public void forEachWith() {
        StringBuilder builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        InternalIterable<Integer> tap = new TapIterable<>(Interval.oneTo(5), appendProcedure);
        tap.forEachWith((each, aBuilder) -> aBuilder.append(each - 1), builder);
        Assert.assertEquals("1021324354", builder.toString());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        private TapIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TapIterableTest();
        }

        @java.lang.Override
        public TapIterableTest implementation() {
            return this.implementation;
        }
    }
}
