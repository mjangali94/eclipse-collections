/*
 * Copyright (c) 2021 The Bank of New York Mellon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.stack.primitive.ImmutableDoubleStack;
import org.eclipse.collections.api.stack.primitive.ImmutableIntStack;
import org.eclipse.collections.api.stack.primitive.ImmutableLongStack;
import org.eclipse.collections.api.stack.primitive.MutableDoubleStack;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.DoubleStacks;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.factory.primitive.IntStacks;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.LongStacks;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.junit.Assert;
import org.junit.Test;

/**
 * @since 9.0
 */
public class PrimitiveStreamsTest {

    @Test
    public void toIntList() {
        MutableIntList list = PrimitiveStreams.mIntList(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10), list);
        Assert.assertEquals(IntLists.immutable.ofAll(IntStream.rangeClosed(1, 10)), list);
    }

    @Test
    public void toImmutableIntList() {
        ImmutableIntList list = PrimitiveStreams.iIntList(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10), list);
        Assert.assertEquals(IntLists.mutable.ofAll(IntStream.rangeClosed(1, 10)), list);
    }

    @Test
    public void toIntSet() {
        MutableIntSet set = PrimitiveStreams.mIntSet(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).toSet(), set);
        Assert.assertEquals(IntSets.immutable.ofAll(IntStream.rangeClosed(1, 10)), set);
    }

    @Test
    public void toImmutableIntSet() {
        ImmutableIntSet set = PrimitiveStreams.iIntSet(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).toSet(), set);
        Assert.assertEquals(IntSets.mutable.ofAll(IntStream.rangeClosed(1, 10)), set);
    }

    @Test
    public void toIntBag() {
        MutableIntBag bag = PrimitiveStreams.mIntBag(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).toBag(), bag);
        Assert.assertEquals(IntBags.immutable.ofAll(IntStream.rangeClosed(1, 10)), bag);
    }

    @Test
    public void toImmutableIntBag() {
        ImmutableIntBag bag = PrimitiveStreams.iIntBag(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).toBag(), bag);
        Assert.assertEquals(IntBags.mutable.ofAll(IntStream.rangeClosed(1, 10)), bag);
    }

    @Test
    public void toIntStack() {
        MutableIntStack stack = PrimitiveStreams.mIntStack(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntStacks.mutable.withAll(IntInterval.oneTo(10)), stack);
        Assert.assertEquals(IntStacks.immutable.ofAll(IntStream.rangeClosed(1, 10)), stack);
    }

    @Test
    public void toImmutableIntStack() {
        ImmutableIntStack stack = PrimitiveStreams.iIntStack(IntStream.rangeClosed(1, 10));
        Assert.assertEquals(IntStacks.immutable.withAll(IntInterval.oneTo(10)), stack);
        Assert.assertEquals(IntStacks.mutable.ofAll(IntStream.rangeClosed(1, 10)), stack);
    }

    @Test
    public void toLongList() {
        MutableLongList list = PrimitiveStreams.mLongList(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).collectLong(i -> (long) i, LongLists.mutable.empty()), list);
        Assert.assertEquals(LongLists.immutable.ofAll(LongStream.rangeClosed(1, 10)), list);
    }

    @Test
    public void toImmutableLongList() {
        ImmutableLongList list = PrimitiveStreams.iLongList(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).collectLong(i -> (long) i, LongLists.mutable.empty()), list);
        Assert.assertEquals(LongLists.mutable.ofAll(LongStream.rangeClosed(1, 10)), list);
    }

    @Test
    public void toLongSet() {
        MutableLongSet set = PrimitiveStreams.mLongSet(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).collectLong(i -> (long) i, LongSets.mutable.empty()), set);
        Assert.assertEquals(LongSets.immutable.ofAll(LongStream.rangeClosed(1, 10)), set);
    }

    @Test
    public void toImmutableLongSet() {
        ImmutableLongSet set = PrimitiveStreams.iLongSet(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).collectLong(i -> (long) i, LongSets.mutable.empty()), set);
        Assert.assertEquals(LongSets.mutable.ofAll(LongStream.rangeClosed(1, 10)), set);
    }

    @Test
    public void toLongBag() {
        MutableLongBag bag = PrimitiveStreams.mLongBag(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).collectLong(i -> (long) i, LongBags.mutable.empty()), bag);
        Assert.assertEquals(LongBags.immutable.ofAll(LongStream.rangeClosed(1, 10)), bag);
    }

    @Test
    public void toImmutableLongBag() {
        ImmutableLongBag bag = PrimitiveStreams.iLongBag(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(IntInterval.oneTo(10).collectLong(i -> (long) i, LongBags.mutable.empty()), bag);
        Assert.assertEquals(LongBags.mutable.ofAll(LongStream.rangeClosed(1, 10)), bag);
    }

    @Test
    public void toLongStack() {
        MutableLongStack stack = PrimitiveStreams.mLongStack(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(LongStacks.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectLong(i -> (long) i)), stack);
        Assert.assertEquals(LongStacks.immutable.ofAll(LongStream.rangeClosed(1, 10)), stack);
    }

    @Test
    public void toImmutableLongStack() {
        ImmutableLongStack stack = PrimitiveStreams.iLongStack(LongStream.rangeClosed(1, 10));
        Assert.assertEquals(LongStacks.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectLong(i -> (long) i)), stack);
        Assert.assertEquals(LongStacks.mutable.ofAll(LongStream.rangeClosed(1, 10)), stack);
    }

    @Test
    public void toDoubleList() {
        MutableDoubleList list = PrimitiveStreams.mDoubleList(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleLists.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), list);
        Assert.assertEquals(DoubleLists.immutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), list);
    }

    @Test
    public void toImmutableDoubleList() {
        ImmutableDoubleList list = PrimitiveStreams.iDoubleList(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleLists.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), list);
        Assert.assertEquals(DoubleLists.mutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), list);
    }

    @Test
    public void toDoubleSet() {
        MutableDoubleSet set = PrimitiveStreams.mDoubleSet(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleSets.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), set);
        Assert.assertEquals(DoubleSets.immutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), set);
    }

    @Test
    public void toImmutableDoubleSet() {
        ImmutableDoubleSet set = PrimitiveStreams.iDoubleSet(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleSets.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), set);
        Assert.assertEquals(DoubleSets.mutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), set);
    }

    @Test
    public void toDoubleBag() {
        MutableDoubleBag bag = PrimitiveStreams.mDoubleBag(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleBags.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), bag);
        Assert.assertEquals(DoubleBags.immutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), bag);
    }

    @Test
    public void toImmutableDoubleBag() {
        ImmutableDoubleBag bag = PrimitiveStreams.iDoubleBag(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleBags.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), bag);
        Assert.assertEquals(DoubleBags.mutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), bag);
    }

    @Test
    public void toDoubleStack() {
        MutableDoubleStack stack = PrimitiveStreams.mDoubleStack(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleStacks.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), stack);
        Assert.assertEquals(DoubleStacks.immutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), stack);
    }

    @Test
    public void toImmutableDoubleStack() {
        ImmutableDoubleStack stack = PrimitiveStreams.iDoubleStack(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleStacks.mutable.ofAll(IntInterval.oneTo(10).asLazy().collectDouble(i -> (double) i)), stack);
        Assert.assertEquals(DoubleStacks.mutable.ofAll(DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), stack);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private PrimitiveStreamsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toIntList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toIntList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableIntList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableIntList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toIntSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toIntSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableIntSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableIntSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toIntBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toIntBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableIntBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableIntBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toIntStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toIntStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableIntStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableIntStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLongList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLongList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableLongList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableLongList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLongSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLongSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableLongSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableLongSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLongBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLongBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableLongBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableLongBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLongStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toLongStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableLongStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableLongStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toDoubleList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toDoubleList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableDoubleList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableDoubleList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toDoubleSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toDoubleSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableDoubleSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableDoubleSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toDoubleBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toDoubleBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableDoubleBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableDoubleBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toDoubleStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toDoubleStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableDoubleStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableDoubleStack);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> payload) throws java.lang.Throwable {
            this.instance = new PrimitiveStreamsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toIntList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableIntList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toIntSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableIntSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toIntBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableIntBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toIntStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableIntStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toLongList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableLongList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toLongSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableLongSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toLongBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableLongBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toLongStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableLongStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toDoubleList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableDoubleList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toDoubleSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableDoubleSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toDoubleBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableDoubleBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toDoubleStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<PrimitiveStreamsTest> toImmutableDoubleStack;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toIntList = PrimitiveStreamsTest::toIntList;
            this.payloads.toImmutableIntList = PrimitiveStreamsTest::toImmutableIntList;
            this.payloads.toIntSet = PrimitiveStreamsTest::toIntSet;
            this.payloads.toImmutableIntSet = PrimitiveStreamsTest::toImmutableIntSet;
            this.payloads.toIntBag = PrimitiveStreamsTest::toIntBag;
            this.payloads.toImmutableIntBag = PrimitiveStreamsTest::toImmutableIntBag;
            this.payloads.toIntStack = PrimitiveStreamsTest::toIntStack;
            this.payloads.toImmutableIntStack = PrimitiveStreamsTest::toImmutableIntStack;
            this.payloads.toLongList = PrimitiveStreamsTest::toLongList;
            this.payloads.toImmutableLongList = PrimitiveStreamsTest::toImmutableLongList;
            this.payloads.toLongSet = PrimitiveStreamsTest::toLongSet;
            this.payloads.toImmutableLongSet = PrimitiveStreamsTest::toImmutableLongSet;
            this.payloads.toLongBag = PrimitiveStreamsTest::toLongBag;
            this.payloads.toImmutableLongBag = PrimitiveStreamsTest::toImmutableLongBag;
            this.payloads.toLongStack = PrimitiveStreamsTest::toLongStack;
            this.payloads.toImmutableLongStack = PrimitiveStreamsTest::toImmutableLongStack;
            this.payloads.toDoubleList = PrimitiveStreamsTest::toDoubleList;
            this.payloads.toImmutableDoubleList = PrimitiveStreamsTest::toImmutableDoubleList;
            this.payloads.toDoubleSet = PrimitiveStreamsTest::toDoubleSet;
            this.payloads.toImmutableDoubleSet = PrimitiveStreamsTest::toImmutableDoubleSet;
            this.payloads.toDoubleBag = PrimitiveStreamsTest::toDoubleBag;
            this.payloads.toImmutableDoubleBag = PrimitiveStreamsTest::toImmutableDoubleBag;
            this.payloads.toDoubleStack = PrimitiveStreamsTest::toDoubleStack;
            this.payloads.toImmutableDoubleStack = PrimitiveStreamsTest::toImmutableDoubleStack;
        }
    }
}
