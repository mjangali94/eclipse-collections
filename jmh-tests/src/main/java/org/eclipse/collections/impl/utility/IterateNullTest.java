/*
 * Copyright (c) 2021 Goldman Sachs.
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IterateNullTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndexWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndexWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropArrayList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropArrayList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfBigInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfBigInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigDecimal() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByBigDecimal);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByBigInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByBigInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> payload) throws java.lang.Throwable {
            this.instance = new IterateNullTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectIndexWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> collectIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> selectArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> selectList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> selectIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> detectIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> rejectArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> rejectList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> rejectIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> injectArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> injectList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> injectIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> forEachArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> forEachList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> forEachIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> takeArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> takeList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> takeIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> dropArrayList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> dropList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> dropIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> sumOfBigInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> sumByBigDecimal;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> sumByBigInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IterateNullTest> sumByDouble;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.collect = IterateNullTest::collect;
            this.payloads.collectBoolean = IterateNullTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = IterateNullTest::collectBooleanWithTarget;
            this.payloads.collectByte = IterateNullTest::collectByte;
            this.payloads.collectByteWithTarget = IterateNullTest::collectByteWithTarget;
            this.payloads.collectChar = IterateNullTest::collectChar;
            this.payloads.collectCharWithTarget = IterateNullTest::collectCharWithTarget;
            this.payloads.collectDouble = IterateNullTest::collectDouble;
            this.payloads.collectDoubleWithTarget = IterateNullTest::collectDoubleWithTarget;
            this.payloads.collectFloat = IterateNullTest::collectFloat;
            this.payloads.collectFloatWithTarget = IterateNullTest::collectFloatWithTarget;
            this.payloads.collectInt = IterateNullTest::collectInt;
            this.payloads.collectIntWithTarget = IterateNullTest::collectIntWithTarget;
            this.payloads.collectLong = IterateNullTest::collectLong;
            this.payloads.collectLongWithTarget = IterateNullTest::collectLongWithTarget;
            this.payloads.collectShort = IterateNullTest::collectShort;
            this.payloads.collectShortWithTarget = IterateNullTest::collectShortWithTarget;
            this.payloads.collectIf = IterateNullTest::collectIf;
            this.payloads.collectWith = IterateNullTest::collectWith;
            this.payloads.select = IterateNullTest::select;
            this.payloads.selectAndRejectWith = IterateNullTest::selectAndRejectWith;
            this.payloads.partition = IterateNullTest::partition;
            this.payloads.partitionWith = IterateNullTest::partitionWith;
            this.payloads.selectWith = IterateNullTest::selectWith;
            this.payloads.selectInstancesOf = IterateNullTest::selectInstancesOf;
            this.payloads.detect = IterateNullTest::detect;
            this.payloads.detectIfNone = IterateNullTest::detectIfNone;
            this.payloads.detectWith = IterateNullTest::detectWith;
            this.payloads.detectWithIfNone = IterateNullTest::detectWithIfNone;
            this.payloads.detectIndex = IterateNullTest::detectIndex;
            this.payloads.detectIndexWith = IterateNullTest::detectIndexWith;
            this.payloads.reject = IterateNullTest::reject;
            this.payloads.rejectWith = IterateNullTest::rejectWith;
            this.payloads.injectInto = IterateNullTest::injectInto;
            this.payloads.injectIntoWith = IterateNullTest::injectIntoWith;
            this.payloads.forEach = IterateNullTest::forEach;
            this.payloads.forEachWith = IterateNullTest::forEachWith;
            this.payloads.forEachWithIndex = IterateNullTest::forEachWithIndex;
            this.payloads.anySatisfy = IterateNullTest::anySatisfy;
            this.payloads.anySatisfyWith = IterateNullTest::anySatisfyWith;
            this.payloads.allSatisfy = IterateNullTest::allSatisfy;
            this.payloads.allSatisfyWith = IterateNullTest::allSatisfyWith;
            this.payloads.noneSatisfy = IterateNullTest::noneSatisfy;
            this.payloads.noneSatisfyWith = IterateNullTest::noneSatisfyWith;
            this.payloads.collectArrayList = IterateNullTest::collectArrayList;
            this.payloads.collectList = IterateNullTest::collectList;
            this.payloads.collectIterable = IterateNullTest::collectIterable;
            this.payloads.selectArrayList = IterateNullTest::selectArrayList;
            this.payloads.selectList = IterateNullTest::selectList;
            this.payloads.selectIterable = IterateNullTest::selectIterable;
            this.payloads.detectArrayList = IterateNullTest::detectArrayList;
            this.payloads.detectList = IterateNullTest::detectList;
            this.payloads.detectIterable = IterateNullTest::detectIterable;
            this.payloads.rejectArrayList = IterateNullTest::rejectArrayList;
            this.payloads.rejectList = IterateNullTest::rejectList;
            this.payloads.rejectIterable = IterateNullTest::rejectIterable;
            this.payloads.injectArrayList = IterateNullTest::injectArrayList;
            this.payloads.injectList = IterateNullTest::injectList;
            this.payloads.injectIterable = IterateNullTest::injectIterable;
            this.payloads.forEachArrayList = IterateNullTest::forEachArrayList;
            this.payloads.forEachList = IterateNullTest::forEachList;
            this.payloads.forEachIterable = IterateNullTest::forEachIterable;
            this.payloads.takeArrayList = IterateNullTest::takeArrayList;
            this.payloads.takeList = IterateNullTest::takeList;
            this.payloads.takeIterable = IterateNullTest::takeIterable;
            this.payloads.dropArrayList = IterateNullTest::dropArrayList;
            this.payloads.dropList = IterateNullTest::dropList;
            this.payloads.dropIterable = IterateNullTest::dropIterable;
            this.payloads.removeAllIterable = IterateNullTest::removeAllIterable;
            this.payloads.sumOfBigInteger = IterateNullTest::sumOfBigInteger;
            this.payloads.sumByBigDecimal = IterateNullTest::sumByBigDecimal;
            this.payloads.sumByBigInteger = IterateNullTest::sumByBigInteger;
            this.payloads.sumByInt = IterateNullTest::sumByInt;
            this.payloads.sumByLong = IterateNullTest::sumByLong;
            this.payloads.sumByFloat = IterateNullTest::sumByFloat;
            this.payloads.sumByDouble = IterateNullTest::sumByDouble;
        }
    }
*/
}
