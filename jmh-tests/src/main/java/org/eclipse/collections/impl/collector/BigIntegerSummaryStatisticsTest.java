/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collector;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.list.Interval;
import org.junit.Assert;
import org.junit.Test;

public class BigIntegerSummaryStatisticsTest {

    @Test
    public void jdkForEach() {
        BigIntegerSummaryStatistics statistics = new BigIntegerSummaryStatistics();
        List<BigInteger> integers = Interval.oneTo(5).collect(i -> BigInteger.valueOf((long) i)).toList();
        integers.forEach(statistics);
        Assert.assertEquals(BigInteger.valueOf(15L), statistics.getSum());
        Assert.assertEquals(5L, statistics.getCount());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics.getMin());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics.getMinOptional().get());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics.getMax());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics.getMaxOptional().get());
        Assert.assertEquals(BigDecimal.valueOf(3L), statistics.getAverage());
    }

    @Test
    public void each() {
        BigIntegerSummaryStatistics statistics = new BigIntegerSummaryStatistics();
        MutableList<BigInteger> integers = Interval.oneTo(5).collect(i -> BigInteger.valueOf((long) i)).toList();
        integers.each(statistics);
        Assert.assertEquals(BigInteger.valueOf(15L), statistics.getSum());
        Assert.assertEquals(5L, statistics.getCount());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics.getMin());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics.getMinOptional().get());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics.getMax());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics.getMaxOptional().get());
        Assert.assertEquals(BigDecimal.valueOf(3L), statistics.getAverage());
    }

    @Test
    public void merge() {
        BigIntegerSummaryStatistics statistics1 = new BigIntegerSummaryStatistics();
        MutableList<BigInteger> integers1 = Interval.oneTo(2).collect(i -> BigInteger.valueOf((long) i)).toList();
        integers1.each(statistics1);
        BigIntegerSummaryStatistics statistics2 = new BigIntegerSummaryStatistics();
        MutableList<BigInteger> integers2 = Interval.fromTo(3, 5).collect(i -> BigInteger.valueOf((long) i)).toList();
        integers2.each(statistics2);
        Assert.assertSame(statistics1, statistics1.merge(statistics2));
        Assert.assertEquals(BigInteger.valueOf(15L), statistics1.getSum());
        Assert.assertEquals(5L, statistics1.getCount());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics1.getMin());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics1.getMinOptional().get());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics1.getMax());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics1.getMaxOptional().get());
        Assert.assertEquals(BigDecimal.valueOf(3L), statistics1.getAverage());
    }

    @Test
    public void empty() {
        BigIntegerSummaryStatistics statistics = new BigIntegerSummaryStatistics();
        Assert.assertEquals(0L, statistics.getCount());
        Assert.assertEquals(BigInteger.ZERO, statistics.getSum());
        Assert.assertEquals(BigDecimal.ZERO, statistics.getAverage());
        Assert.assertNull(statistics.getMin());
        Assert.assertNull(statistics.getMax());
    }

    @Test
    public void summarizingBigInteger() {
        BigIntegerSummaryStatistics statistics = Interval.oneTo(5).collect(Long::valueOf).toList().stream().collect(Collectors2.summarizingBigInteger(BigInteger::valueOf));
        Assert.assertEquals(BigInteger.valueOf(15L), statistics.getSum());
        Assert.assertEquals(5L, statistics.getCount());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics.getMin());
        Assert.assertEquals(BigInteger.valueOf(1L), statistics.getMinOptional().get());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics.getMax());
        Assert.assertEquals(BigInteger.valueOf(5L), statistics.getMaxOptional().get());
        Assert.assertEquals(BigDecimal.valueOf(3L), statistics.getAverage());
    }

    @Test
    public void average() {
        Assert.assertEquals(new BigDecimal("3.333333333333333333333333333333333"), IntLists.mutable.with(2, 2, 6).collect(Long::valueOf).stream().collect(Collectors2.summarizingBigInteger(BigInteger::valueOf)).getAverage());
        Assert.assertEquals(new BigDecimal("3.666666666666666666666666666666667"), IntLists.mutable.with(2, 3, 6).collect(Long::valueOf).stream().collect(Collectors2.summarizingBigInteger(BigInteger::valueOf)).getAverage());
        Assert.assertEquals(new BigDecimal("1"), IntLists.mutable.with(1, 1, 1).collect(Long::valueOf).stream().collect(Collectors2.summarizingBigInteger(BigInteger::valueOf)).getAverage());
        Assert.assertEquals(new BigDecimal("4"), IntLists.mutable.with(2, 3, 4, 5, 6).collect(Long::valueOf).stream().collect(Collectors2.summarizingBigInteger(BigInteger::valueOf)).getAverage());
        Assert.assertEquals(new BigDecimal("3.8"), IntLists.mutable.with(2, 3, 4, 5, 5).collect(Long::valueOf).stream().collect(Collectors2.summarizingBigInteger(BigInteger::valueOf)).getAverage());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BigIntegerSummaryStatisticsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_jdkForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.jdkForEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_each() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.each);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_merge() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.merge);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizingBigInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizingBigInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BigIntegerSummaryStatisticsTest> payload) throws java.lang.Throwable {
            this.instance = new BigIntegerSummaryStatisticsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BigIntegerSummaryStatisticsTest> jdkForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BigIntegerSummaryStatisticsTest> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BigIntegerSummaryStatisticsTest> merge;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BigIntegerSummaryStatisticsTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BigIntegerSummaryStatisticsTest> summarizingBigInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BigIntegerSummaryStatisticsTest> average;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.jdkForEach = BigIntegerSummaryStatisticsTest::jdkForEach;
            this.payloads.each = BigIntegerSummaryStatisticsTest::each;
            this.payloads.merge = BigIntegerSummaryStatisticsTest::merge;
            this.payloads.empty = BigIntegerSummaryStatisticsTest::empty;
            this.payloads.summarizingBigInteger = BigIntegerSummaryStatisticsTest::summarizingBigInteger;
            this.payloads.average = BigIntegerSummaryStatisticsTest::average;
        }
    }
}
