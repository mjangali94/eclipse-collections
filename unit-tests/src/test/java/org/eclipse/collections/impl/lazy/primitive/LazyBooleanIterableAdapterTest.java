/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import java.util.Arrays;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyByteIterableAdapter}.
 */
public class LazyBooleanIterableAdapterTest {

    private final LazyBooleanIterableAdapter iterable = new LazyBooleanIterableAdapter(BooleanArrayList.newListWith(true, false, true));

    @Test
    public void booleanIterator() {
        int sum = 0;
        for (BooleanIterator iterator = this.iterable.booleanIterator(); iterator.hasNext(); ) {
            sum += iterator.next() ? 1 : 0;
        }
        Assert.assertEquals(2, sum);
    }

    @Test
    public void forEach() {
        int[] sum = new int[1];
        this.iterable.forEach(each -> sum[0] += each ? 1 : 0);
        Assert.assertEquals(2, sum[0]);
    }

    @Test
    public void size() {
        Verify.assertSize(3, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Verify.assertNotEmpty(this.iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2, this.iterable.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1, this.iterable.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.iterable.anySatisfy(BooleanPredicates.isFalse()));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(value -> true));
        Assert.assertFalse(this.iterable.allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.iterable.allSatisfy(BooleanPredicates.isTrue()));
    }

    @Test
    public void select() {
        Verify.assertSize(2, this.iterable.select(BooleanPredicates.isTrue()));
        Verify.assertSize(1, this.iterable.select(BooleanPredicates.isFalse()));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(BooleanPredicates.isTrue()));
        Verify.assertSize(2, this.iterable.reject(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone() {
        Assert.assertTrue(this.iterable.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(this.iterable.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(this.iterable.detectIfNone(value -> false, false));
    }

    @Test
    public void collect() {
        RichIterable<String> collect = this.iterable.collect(String::valueOf);
        Verify.assertIterableSize(3, collect);
        Assert.assertEquals("truefalsetrue", collect.makeString(""));
    }

    @Test
    public void lazyCollectPrimitives() {
        Assert.assertEquals(BooleanLists.immutable.of(false, true, false), this.iterable.collectBoolean(e -> !e).toList());
        Assert.assertEquals(CharLists.immutable.of((char) 1, (char) 0, (char) 1), this.iterable.asLazy().collectChar(e -> e ? (char) 1 : (char) 0).toList());
        Assert.assertEquals(ByteLists.immutable.of((byte) 1, (byte) 0, (byte) 1), this.iterable.asLazy().collectByte(e -> e ? (byte) 1 : (byte) 0).toList());
        Assert.assertEquals(ShortLists.immutable.of((short) 1, (short) 0, (short) 1), this.iterable.asLazy().collectShort(e -> e ? (short) 1 : (short) 0).toList());
        Assert.assertEquals(IntLists.immutable.of(1, 0, 1), this.iterable.asLazy().collectInt(e -> e ? 1 : 0).toList());
        Assert.assertEquals(FloatLists.immutable.of(1.0f, 0.0f, 1.0f), this.iterable.asLazy().collectFloat(e -> e ? 1.0f : 0.0f).toList());
        Assert.assertEquals(LongLists.immutable.of(1L, 0L, 1L), this.iterable.asLazy().collectLong(e -> e ? 1L : 0L).toList());
        Assert.assertEquals(DoubleLists.immutable.of(1.0, 0.0, 1.0), this.iterable.asLazy().collectDouble(e -> e ? 1.0 : 0.0).toList());
    }

    @Test
    public void toArray() {
        Assert.assertTrue(Arrays.equals(new boolean[] { true, false, true }, this.iterable.toArray()));
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(true));
        Assert.assertTrue(this.iterable.contains(false));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(true, false));
        Assert.assertTrue(this.iterable.containsAll(false, true));
        Assert.assertTrue(this.iterable.containsAll());
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(this.iterable.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.iterable.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.iterable.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Test
    public void toList() {
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), this.iterable.toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(BooleanHashBag.newBagWith(false, true, true), this.iterable.toBag());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanIterator, this.description("booleanIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectPrimitives() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lazyCollectPrimitives, this.description("lazyCollectPrimitives"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllArray, this.description("containsAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        private LazyBooleanIterableAdapterTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LazyBooleanIterableAdapterTest();
        }

        @java.lang.Override
        public LazyBooleanIterableAdapterTest implementation() {
            return this.implementation;
        }
    }
}
