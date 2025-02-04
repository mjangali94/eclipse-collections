/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseBooleanIterable}.
 */
public class ReverseBooleanIterableTest {

    @Test
    public void isEmpty() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Verify.assertEmpty(new BooleanArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false).asReversed();
        Assert.assertTrue(iterable.contains(false));
        Assert.assertFalse(iterable.contains(true));
    }

    @Test
    public void containsAll() {
        BooleanIterable iterable = BooleanArrayList.newListWith(true, false, true).asReversed();
        Assert.assertTrue(iterable.containsAll(true));
        Assert.assertTrue(iterable.containsAll(true, false));
        Assert.assertFalse(BooleanArrayList.newListWith(false, false).asReversed().containsAll(true));
        Assert.assertFalse(BooleanArrayList.newListWith(false, false).asReversed().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(BooleanArrayList.newListWith(false, false, true).asReversed().containsAll(BooleanArrayList.newListWith(true, false)));
    }

    @Test
    public void iterator() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        BooleanIterator iterator = iterable.booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        BooleanIterator iterator = iterable.booleanIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        boolean[] result = { true };
        iterable.forEach(each -> result[0] &= each);
        Assert.assertFalse(result[0]);
    }

    @Test
    public void size() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Verify.assertSize(0, new BooleanArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, BooleanArrayList.newListWith(false, false, true).asReversed().count(BooleanPredicates.equal(false)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(BooleanArrayList.newListWith(true, false).asReversed().anySatisfy(BooleanPredicates.equal(false)));
        Assert.assertFalse(BooleanArrayList.newListWith(true).asReversed().anySatisfy(BooleanPredicates.equal(false)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(BooleanArrayList.newListWith(true, false).asReversed().allSatisfy(BooleanPredicates.equal(false)));
        Assert.assertTrue(BooleanArrayList.newListWith(false, false).asReversed().allSatisfy(BooleanPredicates.equal(false)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(BooleanArrayList.newListWith(true, false).asReversed().noneSatisfy(BooleanPredicates.equal(false)));
        Assert.assertTrue(BooleanArrayList.newListWith(false, false).asReversed().noneSatisfy(BooleanPredicates.equal(true)));
    }

    @Test
    public void select() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Verify.assertSize(2, iterable.select(BooleanPredicates.equal(false)));
        Verify.assertSize(1, iterable.select(BooleanPredicates.equal(true)));
    }

    @Test
    public void reject() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Verify.assertSize(1, iterable.reject(BooleanPredicates.equal(false)));
        Verify.assertSize(2, iterable.reject(BooleanPredicates.equal(true)));
    }

    @Test
    public void detectIfNone() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false).asReversed();
        Assert.assertFalse(iterable.detectIfNone(BooleanPredicates.equal(false), true));
        Assert.assertTrue(iterable.detectIfNone(BooleanPredicates.equal(true), true));
    }

    @Test
    public void collect() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(false, true, true), iterable.collect(parameter -> !parameter));
    }

    @Test
    public void toArray() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Assert.assertTrue(iterable.toArray()[0]);
        Assert.assertFalse(iterable.toArray()[1]);
        Assert.assertFalse(iterable.toArray()[2]);
    }

    @Test
    public void testToString() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Assert.assertEquals("[true, false, false]", iterable.toString());
        Assert.assertEquals("[]", new BooleanArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        Assert.assertEquals("true, false, false", iterable.makeString());
        Assert.assertEquals("true", BooleanArrayList.newListWith(true).makeString("/"));
        Assert.assertEquals("true/false/false", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new BooleanArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        BooleanIterable iterable = BooleanArrayList.newListWith(false, false, true).asReversed();
        StringBuilder appendable = new StringBuilder();
        new BooleanArrayList().asReversed().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        iterable.appendString(appendable2);
        Assert.assertEquals("true, false, false", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertEquals("true/false/false", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(BooleanArrayList.newListWith(false, true), BooleanArrayList.newListWith(true, false).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), BooleanArrayList.newListWith(true, false).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false), BooleanArrayList.newListWith(true, false).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(BooleanArrayList.newListWith(false, true), BooleanArrayList.newListWith(true, false).asReversed().asLazy().toList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ReverseBooleanIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ReverseBooleanIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseBooleanIterableTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ReverseBooleanIterableTest::isEmpty;
            this.payloads.contains = ReverseBooleanIterableTest::contains;
            this.payloads.containsAll = ReverseBooleanIterableTest::containsAll;
            this.payloads.iterator = ReverseBooleanIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseBooleanIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ReverseBooleanIterableTest::forEach;
            this.payloads.size = ReverseBooleanIterableTest::size;
            this.payloads.empty = ReverseBooleanIterableTest::empty;
            this.payloads.count = ReverseBooleanIterableTest::count;
            this.payloads.anySatisfy = ReverseBooleanIterableTest::anySatisfy;
            this.payloads.allSatisfy = ReverseBooleanIterableTest::allSatisfy;
            this.payloads.noneSatisfy = ReverseBooleanIterableTest::noneSatisfy;
            this.payloads.select = ReverseBooleanIterableTest::select;
            this.payloads.reject = ReverseBooleanIterableTest::reject;
            this.payloads.detectIfNone = ReverseBooleanIterableTest::detectIfNone;
            this.payloads.collect = ReverseBooleanIterableTest::collect;
            this.payloads.toArray = ReverseBooleanIterableTest::toArray;
            this.payloads.testToString = ReverseBooleanIterableTest::testToString;
            this.payloads.makeString = ReverseBooleanIterableTest::makeString;
            this.payloads.appendString = ReverseBooleanIterableTest::appendString;
            this.payloads.toList = ReverseBooleanIterableTest::toList;
            this.payloads.toSet = ReverseBooleanIterableTest::toSet;
            this.payloads.toBag = ReverseBooleanIterableTest::toBag;
            this.payloads.asLazy = ReverseBooleanIterableTest::asLazy;
        }
    }
*/
}
