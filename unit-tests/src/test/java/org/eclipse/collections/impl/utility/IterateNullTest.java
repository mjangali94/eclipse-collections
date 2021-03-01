/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility;

import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.utility.internal.IterableIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for the null handling behavior of {@link Iterate}, {@link ArrayIterate}, {@link ArrayListIterate},
 * {@link ListIterate}, {@link IterableIterate}.
 */
public class IterateNullTest {

    // Iterate
    @Test
    public void collect() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collect(null, Functions.getPassThru()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collect(null, Functions.getPassThru()));
    }

    @Test
    public void collectBoolean() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectBoolean(null, PrimitiveFunctions.integerIsPositive()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectBoolean(null, PrimitiveFunctions.integerIsPositive()));
    }

    @Test
    public void collectBooleanWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectBoolean(null, PrimitiveFunctions.integerIsPositive(), new BooleanArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectBoolean(null, PrimitiveFunctions.integerIsPositive(), new BooleanArrayList()));
    }

    @Test
    public void collectByte() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectByte(null, PrimitiveFunctions.unboxIntegerToByte()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectByte(null, PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Test
    public void collectByteWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectByte(null, PrimitiveFunctions.unboxIntegerToByte(), new ByteArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectByte(null, PrimitiveFunctions.unboxIntegerToByte(), new ByteArrayList()));
    }

    @Test
    public void collectChar() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectChar(null, PrimitiveFunctions.unboxIntegerToChar()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectChar(null, PrimitiveFunctions.unboxIntegerToChar()));
    }

    @Test
    public void collectCharWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectChar(null, PrimitiveFunctions.unboxIntegerToChar(), new CharArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectChar(null, PrimitiveFunctions.unboxIntegerToChar(), new CharArrayList()));
    }

    @Test
    public void collectDouble() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectDouble(null, PrimitiveFunctions.unboxIntegerToDouble()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectDouble(null, PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Test
    public void collectDoubleWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectDouble(null, PrimitiveFunctions.unboxIntegerToDouble(), new DoubleArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectDouble(null, PrimitiveFunctions.unboxIntegerToDouble(), new DoubleArrayList()));
    }

    @Test
    public void collectFloat() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectFloat(null, PrimitiveFunctions.unboxIntegerToFloat()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectFloat(null, PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Test
    public void collectFloatWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectFloat(null, PrimitiveFunctions.unboxIntegerToFloat(), new FloatArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectFloat(null, PrimitiveFunctions.unboxIntegerToFloat(), new FloatArrayList()));
    }

    @Test
    public void collectInt() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectInt(null, PrimitiveFunctions.unboxIntegerToInt()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectInt(null, PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Test
    public void collectIntWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectInt(null, PrimitiveFunctions.unboxIntegerToInt(), new IntArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectInt(null, PrimitiveFunctions.unboxIntegerToInt(), new IntArrayList()));
    }

    @Test
    public void collectLong() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectLong(null, PrimitiveFunctions.unboxIntegerToLong()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectLong(null, PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Test
    public void collectLongWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectLong(null, PrimitiveFunctions.unboxIntegerToLong(), new LongArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectLong(null, PrimitiveFunctions.unboxIntegerToLong(), new LongArrayList()));
    }

    @Test
    public void collectShort() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectShort(null, PrimitiveFunctions.unboxIntegerToShort()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectShort(null, PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Test
    public void collectShortWithTarget() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectShort(null, PrimitiveFunctions.unboxIntegerToShort(), new ShortArrayList()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectShort(null, PrimitiveFunctions.unboxIntegerToShort(), new ShortArrayList()));
    }

    @Test
    public void collectIf() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectIf(null, null, Functions.getPassThru()));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectIf(null, null, Functions.getPassThru()));
    }

    @Test
    public void collectWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.collectWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.collectWith(null, null, null));
    }

    @Test
    public void select() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.select(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.select(null, null));
    }

    @Test
    public void selectAndRejectWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.selectAndRejectWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.selectAndRejectWith(null, null, null));
    }

    @Test
    public void partition() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.partition(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.partition(null, null));
    }

    @Test
    public void partitionWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.partitionWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.partitionWith(null, null, null));
    }

    @Test
    public void selectWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.selectWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.selectWith(null, null, null));
    }

    @Test
    public void selectInstancesOf() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.selectInstancesOf(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.selectInstancesOf(null, null));
    }

    @Test
    public void detect() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.detect(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.detect(null, null));
    }

    @Test
    public void detectIfNone() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.detectIfNone(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.detectIfNone(null, null, null));
    }

    @Test
    public void detectWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.detectWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.detectWith(null, null, null));
    }

    @Test
    public void detectWithIfNone() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.detectWithIfNone(null, null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.detectWithIfNone(null, null, null, null));
    }

    @Test
    public void detectIndex() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.detectIndex(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.detectIndex(null, null));
    }

    @Test
    public void detectIndexWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.detectIndexWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.detectIndexWith(null, null, null));
    }

    @Test
    public void reject() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.reject(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.reject(null, null));
    }

    @Test
    public void rejectWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.rejectWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.rejectWith(null, null, null));
    }

    @Test
    public void injectInto() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.injectInto(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.injectInto(null, null, null));
    }

    @Test
    public void injectIntoWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.injectIntoWith(null, null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.injectIntoWith(null, null, null, null));
    }

    @Test
    public void forEach() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.forEach(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.forEach(null, null));
    }

    @Test
    public void forEachWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.forEachWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.forEachWith(null, null, null));
    }

    @Test
    public void forEachWithIndex() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.forEachWithIndex(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.forEachWithIndex(null, null));
    }

    @Test
    public void anySatisfy() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.anySatisfy(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.anySatisfy(null, null));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.anySatisfyWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.anySatisfyWith(null, null, null));
    }

    @Test
    public void allSatisfy() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.allSatisfy(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.allSatisfy(null, null));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.allSatisfyWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.allSatisfyWith(null, null, null));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.noneSatisfy(null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.noneSatisfy(null, null));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.noneSatisfyWith(null, null, null));
        Assert.assertThrows(IllegalArgumentException.class, () -> ArrayIterate.noneSatisfyWith(null, null, null));
    }

    // Others
    @Test
    public void collectArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> ArrayListIterate.collect(null, Functions.getPassThru()));
    }

    @Test
    public void collectList() {
        Assert.assertThrows(NullPointerException.class, () -> ListIterate.collect(null, Functions.getPassThru()));
    }

    @Test
    public void collectIterable() {
        Assert.assertThrows(NullPointerException.class, () -> IterableIterate.collect(null, Functions.getPassThru()));
    }

    @Test
    public void selectArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> ArrayListIterate.select(null, null));
    }

    @Test
    public void selectList() {
        Assert.assertThrows(NullPointerException.class, () -> ListIterate.select(null, null));
    }

    @Test
    public void selectIterable() {
        Assert.assertThrows(NullPointerException.class, () -> IterableIterate.select(null, null));
    }

    @Test
    public void detectArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> Assert.assertNull(ArrayListIterate.detect(null, null)));
    }

    @Test
    public void detectList() {
        Assert.assertThrows(NullPointerException.class, () -> Assert.assertNull(ListIterate.detect(null, null)));
    }

    @Test
    public void detectIterable() {
        Assert.assertThrows(NullPointerException.class, () -> Assert.assertNull(IterableIterate.detect(null, null)));
    }

    @Test
    public void rejectArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> ArrayListIterate.reject(null, null));
    }

    @Test
    public void rejectList() {
        Assert.assertThrows(NullPointerException.class, () -> ListIterate.reject(null, null));
    }

    @Test
    public void rejectIterable() {
        Assert.assertThrows(NullPointerException.class, () -> IterableIterate.reject(null, null));
    }

    @Test
    public void injectArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> Assert.assertNull(ArrayListIterate.injectInto(null, null, null)));
    }

    @Test
    public void injectList() {
        Assert.assertThrows(NullPointerException.class, () -> Assert.assertNull(ListIterate.injectInto(null, null, null)));
    }

    @Test
    public void injectIterable() {
        Assert.assertThrows(NullPointerException.class, () -> Assert.assertNull(IterableIterate.injectInto(null, null, null)));
    }

    @Test
    public void forEachArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> ArrayListIterate.forEach(null, null));
    }

    @Test
    public void forEachList() {
        Assert.assertThrows(NullPointerException.class, () -> ListIterate.forEach(null, null));
    }

    @Test
    public void forEachIterable() {
        Assert.assertThrows(NullPointerException.class, () -> IterableIterate.forEach(null, null));
    }

    @Test
    public void takeArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> ArrayListIterate.take(null, 0));
    }

    @Test
    public void takeList() {
        Assert.assertThrows(NullPointerException.class, () -> ListIterate.take(null, 0));
    }

    @Test
    public void takeIterable() {
        Assert.assertThrows(NullPointerException.class, () -> IterableIterate.take(null, 0));
    }

    @Test
    public void dropArrayList() {
        Assert.assertThrows(NullPointerException.class, () -> ArrayListIterate.drop(null, 0));
    }

    @Test
    public void dropList() {
        Assert.assertThrows(NullPointerException.class, () -> ListIterate.drop(null, 0));
    }

    @Test
    public void dropIterable() {
        Assert.assertThrows(NullPointerException.class, () -> IterableIterate.drop(null, 0));
    }

    @Test
    public void removeAllIterable() {
        Assert.assertThrows(NullPointerException.class, () -> Iterate.removeAllIterable(null, null));
    }

    @Test
    public void sumOfBigInteger() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.sumOfBigInteger(null, null));
    }

    @Test
    public void sumByBigDecimal() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.sumByBigDecimal(null, null, null));
    }

    @Test
    public void sumByBigInteger() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.sumByBigInteger(null, null, null));
    }

    @Test
    public void sumByInt() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.sumByInt(null, null, null));
    }

    @Test
    public void sumByLong() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.sumByLong(null, null, null));
    }

    @Test
    public void sumByFloat() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.sumByFloat(null, null, null));
    }

    @Test
    public void sumByDouble() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Iterate.sumByDouble(null, null, null));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBooleanWithTarget, this.description("collectBooleanWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByteWithTarget, this.description("collectByteWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectCharWithTarget, this.description("collectCharWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDoubleWithTarget, this.description("collectDoubleWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloatWithTarget, this.description("collectFloatWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIntWithTarget, this.description("collectIntWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLongWithTarget, this.description("collectLongWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShortWithTarget, this.description("collectShortWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectAndRejectWith, this.description("selectAndRejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWith, this.description("partitionWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
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
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIndex, this.description("detectIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndexWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIndexWith, this.description("detectIndexWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoWith, this.description("injectIntoWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWith, this.description("noneSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectArrayList, this.description("collectArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectList, this.description("collectList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIterable, this.description("collectIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectArrayList, this.description("selectArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectList, this.description("selectList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectIterable, this.description("selectIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectArrayList, this.description("detectArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectList, this.description("detectList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIterable, this.description("detectIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectArrayList, this.description("rejectArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectList, this.description("rejectList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectIterable, this.description("rejectIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectArrayList, this.description("injectArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectList, this.description("injectList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIterable, this.description("injectIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachArrayList, this.description("forEachArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachList, this.description("forEachList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachIterable, this.description("forEachIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::takeArrayList, this.description("takeArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::takeList, this.description("takeList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::takeIterable, this.description("takeIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropArrayList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dropArrayList, this.description("dropArrayList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dropList, this.description("dropList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dropIterable, this.description("dropIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAllIterable, this.description("removeAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfBigInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfBigInteger, this.description("sumOfBigInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigDecimal() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByBigDecimal, this.description("sumByBigDecimal"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByBigInteger, this.description("sumByBigInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByInt, this.description("sumByInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByLong, this.description("sumByLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByFloat, this.description("sumByFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumByDouble, this.description("sumByDouble"));
        }

        private IterateNullTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IterateNullTest();
        }

        @java.lang.Override
        public IterateNullTest implementation() {
            return this.implementation;
        }
    }
}
