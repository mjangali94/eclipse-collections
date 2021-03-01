/*
 * Copyright (c) 2020 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy;

import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.InternalIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.MultiReaderList;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class CollectIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.collect(FastList.newListWith(elements), Functions.identity());
    }

    @Test
    public void forEach() {
        InternalIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        Appendable builder = new StringBuilder();
        Procedure<String> appendProcedure = Procedures.append(builder);
        select.forEach(appendProcedure);
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        select.forEachWithIndex((object, index) -> {
            builder.append(object);
            builder.append(index);
        });
        Assert.assertEquals("1021324354", builder.toString());
    }

    @Override
    @Test
    public void iterator() {
        InternalIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        for (String each : select) {
            builder.append(each);
        }
        Assert.assertEquals("12345", builder.toString());
    }

    @Test
    public void forEachWith() {
        InternalIterable<String> select = new CollectIterable<>(Interval.oneTo(5), String::valueOf);
        StringBuilder builder = new StringBuilder();
        select.forEachWith((each, aBuilder) -> aBuilder.append(each), builder);
        Assert.assertEquals("12345", builder.toString());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        CollectIterable<Integer, String> collect = new CollectIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5), String::valueOf);
        Assert.assertEquals(FastList.newListWith("3", "2", "4", "1", "5"), collect.distinct().toList());
    }

    @Test
    public void injectIntoInt() {
        CollectIterable<Integer, String> collect = new CollectIterable<>(FastList.newListWith(1, 2, 3, 4, 5), String::valueOf);
        int sum = collect.injectInto(0, (int value, String each) -> value + Integer.parseInt(each));
        Assert.assertEquals(15, sum);
    }

    @Test
    public void injectIntoLong() {
        CollectIterable<Long, String> collect = new CollectIterable<>(FastList.newListWith(1L, 2L, 3L, 4L, 5L), String::valueOf);
        long sum = collect.injectInto(0L, (long value, String each) -> value + Long.parseLong(each));
        Assert.assertEquals(15L, sum);
    }

    @Test
    public void injectIntoDouble() {
        CollectIterable<Double, String> collect = new CollectIterable<>(FastList.newListWith(1.1d, 1.2d, 1.3d, 1.4d), String::valueOf);
        double sum = collect.injectInto(2.2d, (value, each) -> value + Double.parseDouble(each));
        Assert.assertEquals(7.2, sum, 0.1);
    }

    @Test
    public void injectIntoFloat() {
        CollectIterable<Float, String> collect = new CollectIterable<>(FastList.newListWith(1.1f, 1.2f, 1.3f, 1.4f), String::valueOf);
        float sum = collect.injectInto(2.2f, (float value, String each) -> value + Float.parseFloat(each));
        Assert.assertEquals(7.2, sum, 0.1);
    }

    @Test
    public void getFirstOnEmpty() {
        CollectIterable<Integer, String> collect = new CollectIterable<>(FastList.newList(), String::valueOf);
        Assert.assertNull(collect.getFirst());
    }

    @Test
    public void getLastOnEmpty() {
        CollectIterable<Integer, String> collect = new CollectIterable<>(FastList.newList(), String::valueOf);
        Assert.assertNull(collect.getLast());
    }

    @Override
    @Test
    public void toArray() {
        LazyIterable<String> stringNums = Interval.fromTo(0, 3).collect(Functions.getToString());
        stringNums.toArray();
        Assert.assertEquals(Lists.immutable.of("0", "1", "2", "3"), Lists.immutable.ofAll(stringNums));
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detect(each -> each.equals(3)).longValue());
        Assert.assertNull(collect.detect(each -> each.equals(100)));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectIfNone(each -> each.equals(3), () -> Integer.valueOf(0)).longValue());
        Assert.assertNull(collect.detectIfNone(each -> each.equals(100), () -> null));
    }

    @Override
    @Test
    public void detectWith() {
        super.detectWith();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectWith((each, ignore) -> each.equals(3), null).longValue());
        Assert.assertNull(collect.detectWith((each, ignore) -> each.equals(100), null));
    }

    @Override
    @Test
    public void detectWithIfNone() {
        super.detectWithIfNone();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectWithIfNone((each, ignore) -> each.equals(3), null, () -> Integer.valueOf(0)).longValue());
        Assert.assertNull(collect.detectWithIfNone((each, ignore) -> each.equals(100), null, () -> null));
    }

    @Override
    @Test
    public void detectOptional() {
        super.detectOptional();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectOptional(each -> each.equals(3)).get().longValue());
        Assert.assertNull(collect.detectOptional(each -> each.equals(100)).orElse(null));
    }

    @Override
    @Test
    public void detectWithOptional() {
        super.detectWithOptional();
        AtomicInteger functionCount = new AtomicInteger(0);
        MultiReaderList<Integer> integers = Lists.multiReader.withAll(Interval.oneTo(5));
        CollectIterable<Integer, Integer> collect = new CollectIterable<>(integers, functionCount::addAndGet);
        Assert.assertEquals(3L, collect.detectWithOptional((each, ignore) -> each.equals(3), null).get().longValue());
        Assert.assertNull(collect.detectWithOptional((each, ignore) -> each.equals(100), null).orElse(null));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoInt, this.description("injectIntoInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoLong, this.description("injectIntoLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoDouble, this.description("injectIntoDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoFloat, this.description("injectIntoFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirstOnEmpty, this.description("getFirstOnEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOnEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLastOnEmpty, this.description("getLastOnEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNone, this.description("detectWithIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectOptional, this.description("detectOptional"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOptional, this.description("detectWithOptional"));
        }

        private CollectIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectIterableTest();
        }

        @java.lang.Override
        public CollectIterableTest implementation() {
            return this.implementation;
        }
    }
}
