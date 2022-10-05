/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectByteIterableTest {

    private final ByteIterable byteIterable = Interval.oneTo(3).collectByte(PrimitiveFunctions.unboxIntegerToByte());

    @Test
    public void iterator() {
        long sum = 0L;
        ByteIterator iterator = this.byteIterable.byteIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test
    public void size() {
        Assert.assertEquals(3L, this.byteIterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.byteIterable.notEmpty());
        Assert.assertFalse(this.byteIterable.isEmpty());
    }

    @Test
    public void forEach() {
        long[] value = new long[1];
        this.byteIterable.forEach(each -> {
            value[0] += each;
        });
        Assert.assertEquals(6L, value[0]);
    }

    @Test
    public void count() {
        Assert.assertEquals(1, this.byteIterable.count(BytePredicates.equal((byte) 1)));
        Assert.assertEquals(3, this.byteIterable.count(BytePredicates.lessThan((byte) 4)));
        Assert.assertEquals(2, this.byteIterable.count(BytePredicates.greaterThan((byte) 1)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.byteIterable.anySatisfy(BytePredicates.greaterThan((byte) 1)));
        Assert.assertTrue(this.byteIterable.anySatisfy(BytePredicates.equal((byte) 1)));
        Assert.assertFalse(this.byteIterable.anySatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.byteIterable.noneSatisfy(BytePredicates.greaterThan((byte) 2)));
        Assert.assertTrue(this.byteIterable.noneSatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.byteIterable.allSatisfy(BytePredicates.lessThan((byte) 4)));
        Assert.assertFalse(this.byteIterable.allSatisfy(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void select() {
        Assert.assertEquals(3L, this.byteIterable.select(BytePredicates.lessThan((byte) 4)).size());
        Assert.assertEquals(2L, this.byteIterable.select(BytePredicates.lessThan((byte) 3)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(0L, this.byteIterable.reject(BytePredicates.lessThan((byte) 4)).size());
        Assert.assertEquals(1L, this.byteIterable.reject(BytePredicates.lessThan((byte) 3)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals((byte) 1, this.byteIterable.detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
        Assert.assertEquals((byte) 0, this.byteIterable.detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, this.byteIterable.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals((byte) 3, Interval.fromTo(0, 3).collectByte(PrimitiveFunctions.unboxIntegerToByte()).max());
    }

    @Test
    public void min() {
        Assert.assertEquals((byte) 0, Interval.fromTo(0, 3).collectByte(PrimitiveFunctions.unboxIntegerToByte()).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((byte) 0, Interval.fromTo(0, 3).collectByte(PrimitiveFunctions.unboxIntegerToByte()).minIfEmpty((byte) 0));
        Assert.assertEquals((byte) 0, FastList.<Integer>newList().asLazy().collectByte(PrimitiveFunctions.unboxIntegerToByte()).minIfEmpty((byte) 0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((byte) 3, Interval.fromTo(0, 3).collectByte(PrimitiveFunctions.unboxIntegerToByte()).maxIfEmpty((byte) 0));
        Assert.assertEquals((byte) 0, FastList.<Integer>newList().asLazy().collectByte(PrimitiveFunctions.unboxIntegerToByte()).maxIfEmpty((byte) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectByte(PrimitiveFunctions.unboxIntegerToByte()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectByte(PrimitiveFunctions.unboxIntegerToByte()).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectByte(PrimitiveFunctions.unboxIntegerToByte()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectByte(PrimitiveFunctions.unboxIntegerToByte()).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectByte(PrimitiveFunctions.unboxIntegerToByte()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectByte(PrimitiveFunctions.unboxIntegerToByte()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectByte(PrimitiveFunctions.unboxIntegerToByte()).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }, Interval.oneTo(4).collectByte(PrimitiveFunctions.unboxIntegerToByte()).toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 4 }, Interval.fromTo(4, 1).collectByte(PrimitiveFunctions.unboxIntegerToByte()).toSortedArray());
    }

    @Test
    public void contains() {
        ByteIterable byteIterable = Interval.fromTo(4, 1).collectByte(PrimitiveFunctions.unboxIntegerToByte());
        Assert.assertTrue(byteIterable.contains((byte) 1));
        Assert.assertTrue(byteIterable.contains((byte) 3));
        Assert.assertTrue(byteIterable.contains((byte) 4));
        Assert.assertFalse(byteIterable.contains((byte) 5));
    }

    @Test
    public void containsAllArray() {
        ByteIterable byteIterable = Interval.fromTo(4, 1).collectByte(PrimitiveFunctions.unboxIntegerToByte());
        Assert.assertTrue(byteIterable.containsAll((byte) 1));
        Assert.assertTrue(byteIterable.containsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertFalse(byteIterable.containsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertFalse(byteIterable.containsAll((byte) 7, (byte) 6, (byte) 5));
    }

    @Test
    public void containsAllIterable() {
        ByteIterable byteIterable = Interval.fromTo(4, 1).collectByte(PrimitiveFunctions.unboxIntegerToByte());
        Assert.assertTrue(byteIterable.containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(byteIterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4)));
        Assert.assertFalse(byteIterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5)));
        Assert.assertFalse(byteIterable.containsAll(ByteArrayList.newListWith((byte) 7, (byte) 6, (byte) 5)));
    }

    @Test
    public void collect() {
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), this.byteIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[1, 2, 3]", this.byteIterable.toString());
    }

    @Test
    public void makeString() {
        Assert.assertEquals("1, 2, 3", this.byteIterable.makeString());
        Assert.assertEquals("1/2/3", this.byteIterable.makeString("/"));
        Assert.assertEquals("[1, 2, 3]", this.byteIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.byteIterable.appendString(appendable);
        Assert.assertEquals("1, 2, 3", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.byteIterable.appendString(appendable2, "/");
        Assert.assertEquals("1/2/3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.byteIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.byteIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), this.byteIterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), this.byteIterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), this.byteIterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), this.byteIterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.byteIterable.toSet(), this.byteIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyByteIterable.class, this.byteIterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectByteIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> payload) throws java.lang.Throwable {
            this.instance = new CollectByteIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectByteIterableTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.iterator = CollectByteIterableTest::iterator;
            this.payloads.size = CollectByteIterableTest::size;
            this.payloads.empty = CollectByteIterableTest::empty;
            this.payloads.forEach = CollectByteIterableTest::forEach;
            this.payloads.count = CollectByteIterableTest::count;
            this.payloads.anySatisfy = CollectByteIterableTest::anySatisfy;
            this.payloads.noneSatisfy = CollectByteIterableTest::noneSatisfy;
            this.payloads.allSatisfy = CollectByteIterableTest::allSatisfy;
            this.payloads.select = CollectByteIterableTest::select;
            this.payloads.reject = CollectByteIterableTest::reject;
            this.payloads.detectIfNone = CollectByteIterableTest::detectIfNone;
            this.payloads.sum = CollectByteIterableTest::sum;
            this.payloads.max = CollectByteIterableTest::max;
            this.payloads.min = CollectByteIterableTest::min;
            this.payloads.minIfEmpty = CollectByteIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = CollectByteIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectByteIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectByteIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = CollectByteIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectByteIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CollectByteIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectByteIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = CollectByteIterableTest::toArray;
            this.payloads.toSortedArray = CollectByteIterableTest::toSortedArray;
            this.payloads.contains = CollectByteIterableTest::contains;
            this.payloads.containsAllArray = CollectByteIterableTest::containsAllArray;
            this.payloads.containsAllIterable = CollectByteIterableTest::containsAllIterable;
            this.payloads.collect = CollectByteIterableTest::collect;
            this.payloads.testToString = CollectByteIterableTest::testToString;
            this.payloads.makeString = CollectByteIterableTest::makeString;
            this.payloads.appendString = CollectByteIterableTest::appendString;
            this.payloads.toList = CollectByteIterableTest::toList;
            this.payloads.toSortedList = CollectByteIterableTest::toSortedList;
            this.payloads.toSet = CollectByteIterableTest::toSet;
            this.payloads.toBag = CollectByteIterableTest::toBag;
            this.payloads.asLazy = CollectByteIterableTest::asLazy;
        }
    }
}
