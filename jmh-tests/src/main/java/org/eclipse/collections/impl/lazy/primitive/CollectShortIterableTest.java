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
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectShortIterableTest {

    private final ShortIterable shortIterable = Interval.oneTo(3).collectShort(PrimitiveFunctions.unboxIntegerToShort());

    @Test
    public void iterator() {
        long sum = 0L;
        ShortIterator iterator = this.shortIterable.shortIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test
    public void size() {
        Assert.assertEquals(3L, this.shortIterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.shortIterable.notEmpty());
        Assert.assertFalse(this.shortIterable.isEmpty());
    }

    @Test
    public void forEach() {
        long[] value = new long[1];
        this.shortIterable.forEach(each -> {
            value[0] += each;
        });
        Assert.assertEquals(6L, value[0]);
    }

    @Test
    public void count() {
        Assert.assertEquals(1, this.shortIterable.count(ShortPredicates.equal((short) 1)));
        Assert.assertEquals(3, this.shortIterable.count(ShortPredicates.lessThan((short) 4)));
        Assert.assertEquals(2, this.shortIterable.count(ShortPredicates.greaterThan((short) 1)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.shortIterable.anySatisfy(ShortPredicates.greaterThan((short) 1)));
        Assert.assertTrue(this.shortIterable.anySatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(this.shortIterable.anySatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.shortIterable.noneSatisfy(ShortPredicates.greaterThan((short) 2)));
        Assert.assertTrue(this.shortIterable.noneSatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.shortIterable.allSatisfy(ShortPredicates.lessThan((short) 4)));
        Assert.assertFalse(this.shortIterable.allSatisfy(ShortPredicates.lessThan((short) 3)));
    }

    @Test
    public void select() {
        Assert.assertEquals(3L, this.shortIterable.select(ShortPredicates.lessThan((short) 4)).size());
        Assert.assertEquals(2L, this.shortIterable.select(ShortPredicates.lessThan((short) 3)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(0L, this.shortIterable.reject(ShortPredicates.lessThan((short) 4)).size());
        Assert.assertEquals(1L, this.shortIterable.reject(ShortPredicates.lessThan((short) 3)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals((short) 1, this.shortIterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals((short) 0, this.shortIterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, this.shortIterable.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals((short) 3, Interval.fromTo(0, 3).collectShort(PrimitiveFunctions.unboxIntegerToShort()).max());
    }

    @Test
    public void min() {
        Assert.assertEquals((short) 0, Interval.fromTo(0, 3).collectShort(PrimitiveFunctions.unboxIntegerToShort()).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((short) 0, Interval.fromTo(0, 3).collectShort(PrimitiveFunctions.unboxIntegerToShort()).minIfEmpty((short) 0));
        Assert.assertEquals((short) 0, FastList.<Integer>newList().asLazy().collectShort(PrimitiveFunctions.unboxIntegerToShort()).minIfEmpty((short) 0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((short) 3, Interval.fromTo(0, 3).collectShort(PrimitiveFunctions.unboxIntegerToShort()).maxIfEmpty((short) 0));
        Assert.assertEquals((short) 0, FastList.<Integer>newList().asLazy().collectShort(PrimitiveFunctions.unboxIntegerToShort()).maxIfEmpty((short) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectShort(PrimitiveFunctions.unboxIntegerToShort()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectShort(PrimitiveFunctions.unboxIntegerToShort()).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectShort(PrimitiveFunctions.unboxIntegerToShort()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectShort(PrimitiveFunctions.unboxIntegerToShort()).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectShort(PrimitiveFunctions.unboxIntegerToShort()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectShort(PrimitiveFunctions.unboxIntegerToShort()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectShort(PrimitiveFunctions.unboxIntegerToShort()).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }, Interval.oneTo(4).collectShort(PrimitiveFunctions.unboxIntegerToShort()).toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new short[] { (short) 1, (short) 2, (short) 3, (short) 4 }, Interval.fromTo(4, 1).collectShort(PrimitiveFunctions.unboxIntegerToShort()).toSortedArray());
    }

    @Test
    public void contains() {
        ShortIterable shortIterable = Interval.fromTo(4, 1).collectShort(PrimitiveFunctions.unboxIntegerToShort());
        Assert.assertTrue(shortIterable.contains((short) 1));
        Assert.assertTrue(shortIterable.contains((short) 3));
        Assert.assertTrue(shortIterable.contains((short) 4));
        Assert.assertFalse(shortIterable.contains((short) 5));
    }

    @Test
    public void containsAllArray() {
        ShortIterable shortIterable = Interval.fromTo(4, 1).collectShort(PrimitiveFunctions.unboxIntegerToShort());
        Assert.assertTrue(shortIterable.containsAll((short) 1));
        Assert.assertTrue(shortIterable.containsAll((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertFalse(shortIterable.containsAll((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertFalse(shortIterable.containsAll((short) 7, (short) 6, (short) 5));
    }

    @Test
    public void containsAllIterable() {
        ShortIterable shortIterable = Interval.fromTo(4, 1).collectShort(PrimitiveFunctions.unboxIntegerToShort());
        Assert.assertTrue(shortIterable.containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(shortIterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4)));
        Assert.assertFalse(shortIterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5)));
        Assert.assertFalse(shortIterable.containsAll(ShortArrayList.newListWith((short) 7, (short) 6, (short) 5)));
    }

    @Test
    public void collect() {
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), this.shortIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[1, 2, 3]", this.shortIterable.toString());
    }

    @Test
    public void makeString() {
        Assert.assertEquals("1, 2, 3", this.shortIterable.makeString());
        Assert.assertEquals("1/2/3", this.shortIterable.makeString("/"));
        Assert.assertEquals("[1, 2, 3]", this.shortIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.shortIterable.appendString(appendable);
        Assert.assertEquals("1, 2, 3", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.shortIterable.appendString(appendable2, "/");
        Assert.assertEquals("1/2/3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.shortIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.shortIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), this.shortIterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), this.shortIterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), this.shortIterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), this.shortIterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.shortIterable.toSet(), this.shortIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, this.shortIterable.asLazy());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectShortIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> payload) throws java.lang.Throwable {
            this.instance = new CollectShortIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectShortIterableTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.iterator = CollectShortIterableTest::iterator;
            this.payloads.size = CollectShortIterableTest::size;
            this.payloads.empty = CollectShortIterableTest::empty;
            this.payloads.forEach = CollectShortIterableTest::forEach;
            this.payloads.count = CollectShortIterableTest::count;
            this.payloads.anySatisfy = CollectShortIterableTest::anySatisfy;
            this.payloads.noneSatisfy = CollectShortIterableTest::noneSatisfy;
            this.payloads.allSatisfy = CollectShortIterableTest::allSatisfy;
            this.payloads.select = CollectShortIterableTest::select;
            this.payloads.reject = CollectShortIterableTest::reject;
            this.payloads.detectIfNone = CollectShortIterableTest::detectIfNone;
            this.payloads.sum = CollectShortIterableTest::sum;
            this.payloads.max = CollectShortIterableTest::max;
            this.payloads.min = CollectShortIterableTest::min;
            this.payloads.minIfEmpty = CollectShortIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = CollectShortIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectShortIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectShortIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = CollectShortIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectShortIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CollectShortIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectShortIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = CollectShortIterableTest::toArray;
            this.payloads.toSortedArray = CollectShortIterableTest::toSortedArray;
            this.payloads.contains = CollectShortIterableTest::contains;
            this.payloads.containsAllArray = CollectShortIterableTest::containsAllArray;
            this.payloads.containsAllIterable = CollectShortIterableTest::containsAllIterable;
            this.payloads.collect = CollectShortIterableTest::collect;
            this.payloads.testToString = CollectShortIterableTest::testToString;
            this.payloads.makeString = CollectShortIterableTest::makeString;
            this.payloads.appendString = CollectShortIterableTest::appendString;
            this.payloads.toList = CollectShortIterableTest::toList;
            this.payloads.toSortedList = CollectShortIterableTest::toSortedList;
            this.payloads.toSet = CollectShortIterableTest::toSet;
            this.payloads.toBag = CollectShortIterableTest::toBag;
            this.payloads.asLazy = CollectShortIterableTest::asLazy;
        }
    }
*/
}
