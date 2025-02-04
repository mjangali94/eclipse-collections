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
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectShortIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectShortIterableTest {

    private final SelectShortIterable iterable = new SelectShortIterable(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), ShortPredicates.lessThan((short) 3));

    @Test
    public void shortIterator() {
        long sum = 0L;
        for (ShortIterator iterator = this.iterable.shortIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.iterable.forEach((short each) -> sum[0] += each);
        Assert.assertEquals(3L, sum[0]);
    }

    @Test
    public void size() {
        Verify.assertSize(2, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.iterable.notEmpty());
        Verify.assertNotEmpty(this.iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(1L, this.iterable.count(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(0L, this.iterable.count(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.iterable.anySatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.iterable.allSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertTrue(this.iterable.allSatisfy(ShortPredicates.lessThan((short) 4)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.iterable.noneSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertTrue(this.iterable.noneSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertTrue(this.iterable.noneSatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void select() {
        Verify.assertSize(1, this.iterable.select(ShortPredicates.greaterThan((short) 1)));
        Verify.assertSize(0, this.iterable.select(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(ShortPredicates.greaterThan((short) 1)));
        Verify.assertSize(0, this.iterable.reject(ShortPredicates.greaterThan((short) 0)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.iterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals(0L, this.iterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(2, this.iterable.collect(String::valueOf));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3L, this.iterable.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals((short) 2, this.iterable.max());
    }

    @Test
    public void min() {
        Assert.assertEquals((short) 1, this.iterable.min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((short) 1, this.iterable.minIfEmpty((short) 0));
        Assert.assertEquals((short) 0, this.iterable.select(ShortPredicates.lessThan((short) 0)).minIfEmpty((short) 0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((short) 2, this.iterable.maxIfEmpty((short) 0));
        Assert.assertEquals((short) 0, this.iterable.select(ShortPredicates.lessThan((short) 0)).maxIfEmpty((short) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new short[] { 1, 2 }, this.iterable.toArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains((short) 1));
        Assert.assertTrue(this.iterable.contains((short) 2));
        Assert.assertFalse(this.iterable.contains((short) 3));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll((short) 1));
        Assert.assertTrue(this.iterable.containsAll((short) 2));
        Assert.assertTrue(this.iterable.containsAll((short) 1, (short) 2));
        Assert.assertFalse(this.iterable.containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertFalse(this.iterable.containsAll((short) 4, (short) 5, (short) 6));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(this.iterable.containsAll(ShortArrayList.newListWith((short) 2)));
        Assert.assertTrue(this.iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2)));
        Assert.assertFalse(this.iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Assert.assertFalse(this.iterable.containsAll(ShortArrayList.newListWith((short) 4, (short) 5, (short) 6)));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new short[] { 1, 2 }, this.iterable.toSortedArray());
    }

    @Test
    public void toList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), this.iterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), this.iterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), this.iterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto() {
        MutableShort result = this.iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 3), result);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectShortIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectShortIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectShortIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.shortIterator = SelectShortIterableTest::shortIterator;
            this.payloads.forEach = SelectShortIterableTest::forEach;
            this.payloads.size = SelectShortIterableTest::size;
            this.payloads.empty = SelectShortIterableTest::empty;
            this.payloads.count = SelectShortIterableTest::count;
            this.payloads.anySatisfy = SelectShortIterableTest::anySatisfy;
            this.payloads.allSatisfy = SelectShortIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SelectShortIterableTest::noneSatisfy;
            this.payloads.select = SelectShortIterableTest::select;
            this.payloads.reject = SelectShortIterableTest::reject;
            this.payloads.detectIfNone = SelectShortIterableTest::detectIfNone;
            this.payloads.collect = SelectShortIterableTest::collect;
            this.payloads.sum = SelectShortIterableTest::sum;
            this.payloads.max = SelectShortIterableTest::max;
            this.payloads.min = SelectShortIterableTest::min;
            this.payloads.minIfEmpty = SelectShortIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SelectShortIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectShortIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectShortIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SelectShortIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectShortIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SelectShortIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectShortIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SelectShortIterableTest::toArray;
            this.payloads.contains = SelectShortIterableTest::contains;
            this.payloads.containsAllArray = SelectShortIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SelectShortIterableTest::containsAllIterable;
            this.payloads.toSortedArray = SelectShortIterableTest::toSortedArray;
            this.payloads.toList = SelectShortIterableTest::toList;
            this.payloads.toSortedList = SelectShortIterableTest::toSortedList;
            this.payloads.toSet = SelectShortIterableTest::toSet;
            this.payloads.toBag = SelectShortIterableTest::toBag;
            this.payloads.asLazy = SelectShortIterableTest::asLazy;
            this.payloads.injectInto = SelectShortIterableTest::injectInto;
        }
    }
*/
}
