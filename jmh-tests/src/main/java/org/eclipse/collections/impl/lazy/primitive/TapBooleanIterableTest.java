/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.BooleanList;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

public class TapBooleanIterableTest {

    private final BooleanList list = BooleanLists.immutable.with(true, false, false, true);

    @Test
    public void booleanIterator() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        for (BooleanIterator iterator = iterable.booleanIterator(); iterator.hasNext(); ) {
            iterator.next();
        }
        Assert.assertEquals("truefalsefalsetrue", concat.toString());
    }

    @Test
    public void forEach() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        iterable.forEach(each -> {
        });
        Assert.assertEquals("truefalsefalsetrue", concat.toString());
    }

    @Test
    public void injectInto() {
        StringBuilder concat = new StringBuilder();
        TapBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), (object, value) -> object.add(value ? 1 : 0));
        Assert.assertEquals(new MutableInteger(2), result);
        Assert.assertEquals("truefalsefalsetrue", concat.toString());
    }

    @Test
    public void size() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertEquals(4L, iterable.size());
        Assert.assertEquals("truefalsefalsetrue", concat.toString());
    }

    @Test
    public void empty() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertTrue(iterable.notEmpty());
        Assert.assertFalse(iterable.isEmpty());
    }

    @Test
    public void count() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertEquals(2L, iterable.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(2L, iterable.count(BooleanPredicates.isFalse()));
        Assert.assertEquals("truefalsefalsetruetruefalsefalsetrue", concat.toString());
    }

    @Test
    public void anySatisfy() {
        StringBuilder concat = new StringBuilder();
        TapBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertTrue(iterable.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(iterable.anySatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void allSatisfy() {
        StringBuilder concat = new StringBuilder();
        TapBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertFalse(iterable.allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(iterable.allSatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void select() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertEquals(2L, iterable.select(BooleanPredicates.isFalse()).size());
        Assert.assertEquals(2L, iterable.select(BooleanPredicates.equal(true)).size());
        Assert.assertEquals("truefalsefalsetruetruefalsefalsetrue", concat.toString());
    }

    @Test
    public void reject() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertEquals(2L, iterable.reject(BooleanPredicates.isFalse()).size());
        Assert.assertEquals(2L, iterable.reject(BooleanPredicates.equal(true)).size());
        Assert.assertEquals("truefalsefalsetruetruefalsefalsetrue", concat.toString());
    }

    @Test
    public void detectIfNone() {
        StringBuilder concat = new StringBuilder();
        TapBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertTrue(iterable.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(iterable.detectIfNone(BooleanPredicates.isFalse(), false));
    }

    @Test
    public void collect() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertEquals(4L, iterable.collect(String::valueOf).size());
        Assert.assertEquals("truefalsefalsetrue", concat.toString());
    }

    @Test
    public void toArray() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertEquals(4L, iterable.toArray().length);
        Assert.assertTrue(iterable.toArray()[0]);
        Assert.assertFalse(iterable.toArray()[1]);
    }

    @Test
    public void contains() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertTrue(iterable.contains(true));
        Assert.assertTrue(iterable.contains(false));
    }

    @Test
    public void containsAll() {
        StringBuilder concat = new StringBuilder();
        LazyBooleanIterable iterable = new TapBooleanIterable(this.list, concat::append);
        Assert.assertTrue(iterable.containsAll(true, true));
        Assert.assertTrue(iterable.containsAll(false, true));
        Assert.assertTrue(iterable.containsAll(false, false));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapBooleanIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TapBooleanIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapBooleanIterableTest> containsAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.booleanIterator = TapBooleanIterableTest::booleanIterator;
            this.payloads.forEach = TapBooleanIterableTest::forEach;
            this.payloads.injectInto = TapBooleanIterableTest::injectInto;
            this.payloads.size = TapBooleanIterableTest::size;
            this.payloads.empty = TapBooleanIterableTest::empty;
            this.payloads.count = TapBooleanIterableTest::count;
            this.payloads.anySatisfy = TapBooleanIterableTest::anySatisfy;
            this.payloads.allSatisfy = TapBooleanIterableTest::allSatisfy;
            this.payloads.select = TapBooleanIterableTest::select;
            this.payloads.reject = TapBooleanIterableTest::reject;
            this.payloads.detectIfNone = TapBooleanIterableTest::detectIfNone;
            this.payloads.collect = TapBooleanIterableTest::collect;
            this.payloads.toArray = TapBooleanIterableTest::toArray;
            this.payloads.contains = TapBooleanIterableTest::contains;
            this.payloads.containsAll = TapBooleanIterableTest::containsAll;
        }
    }
}
