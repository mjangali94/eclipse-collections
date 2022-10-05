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

import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

public class SelectBooleanIterableTest {

    private final SelectBooleanIterable iterable = new SelectBooleanIterable(BooleanArrayList.newListWith(true, false, false, true), BooleanPredicates.isTrue());

    @Test
    public void booleanIterator() {
        StringBuilder concat = new StringBuilder();
        for (BooleanIterator iterator = this.iterable.booleanIterator(); iterator.hasNext(); ) {
            concat.append(iterator.next());
        }
        Assert.assertEquals("truetrue", concat.toString());
    }

    @Test
    public void forEach() {
        String[] concat = new String[1];
        concat[0] = "";
        this.iterable.forEach(each -> concat[0] += each);
        Assert.assertEquals("truetrue", concat[0]);
    }

    @Test
    public void injectInto() {
        MutableInteger result = this.iterable.injectInto(new MutableInteger(0), (object, value) -> object.add(value ? 1 : 0));
        Assert.assertEquals(new MutableInteger(2), result);
    }

    @Test
    public void size() {
        Assert.assertEquals(2L, this.iterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, this.iterable.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(0L, this.iterable.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.iterable.anySatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.iterable.allSatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void select() {
        Assert.assertEquals(0L, this.iterable.select(BooleanPredicates.isFalse()).size());
        Assert.assertEquals(2L, this.iterable.select(BooleanPredicates.equal(true)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(2L, this.iterable.reject(BooleanPredicates.isFalse()).size());
        Assert.assertEquals(0L, this.iterable.reject(BooleanPredicates.equal(true)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertTrue(this.iterable.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(this.iterable.detectIfNone(BooleanPredicates.isFalse(), false));
    }

    @Test
    public void collect() {
        Assert.assertEquals(2L, this.iterable.collect(String::valueOf).size());
    }

    @Test
    public void toArray() {
        Assert.assertEquals(2L, this.iterable.toArray().length);
        Assert.assertTrue(this.iterable.toArray()[0]);
        Assert.assertTrue(this.iterable.toArray()[1]);
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(true));
        Assert.assertFalse(this.iterable.contains(false));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.iterable.containsAll(true, true));
        Assert.assertFalse(this.iterable.containsAll(false, true));
        Assert.assertFalse(this.iterable.containsAll(false, false));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectBooleanIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectBooleanIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectBooleanIterableTest> containsAll;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.booleanIterator = SelectBooleanIterableTest::booleanIterator;
            this.payloads.forEach = SelectBooleanIterableTest::forEach;
            this.payloads.injectInto = SelectBooleanIterableTest::injectInto;
            this.payloads.size = SelectBooleanIterableTest::size;
            this.payloads.empty = SelectBooleanIterableTest::empty;
            this.payloads.count = SelectBooleanIterableTest::count;
            this.payloads.anySatisfy = SelectBooleanIterableTest::anySatisfy;
            this.payloads.allSatisfy = SelectBooleanIterableTest::allSatisfy;
            this.payloads.select = SelectBooleanIterableTest::select;
            this.payloads.reject = SelectBooleanIterableTest::reject;
            this.payloads.detectIfNone = SelectBooleanIterableTest::detectIfNone;
            this.payloads.collect = SelectBooleanIterableTest::collect;
            this.payloads.toArray = SelectBooleanIterableTest::toArray;
            this.payloads.contains = SelectBooleanIterableTest::contains;
            this.payloads.containsAll = SelectBooleanIterableTest::containsAll;
        }
    }
}
