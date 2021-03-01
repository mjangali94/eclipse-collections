/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.immutable;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableBooleanSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableEmptySetTestCase extends AbstractImmutableSetTestCase {

    @Test
    public void containsAll() {
        Assert.assertTrue(this.classUnderTest().castToSet().containsAll(new HashSet<>()));
        Assert.assertFalse(this.classUnderTest().castToSet().containsAll(UnifiedSet.newSetWith(1)));
    }

    @Override
    @Test
    public void newWith() {
        ImmutableSet<Integer> immutable = this.classUnderTest();
        Verify.assertSize(1, immutable.newWith(1).castToSet());
    }

    @Override
    @Test
    public void detect() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.detect(Integer.valueOf(1)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.detectWith(Object::equals, Integer.valueOf(1)));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void anySatisfyWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void allSatisfy() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void allSatisfyWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    public void noneSatisfy() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    public void noneSatisfyWith() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.noneSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void getFirst() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.getFirst());
    }

    @Override
    @Test
    public void getLast() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        Assert.assertNull(integers.getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @Override
    @Test
    public void isEmpty() {
        ImmutableSet<Integer> list = this.classUnderTest();
        Assert.assertTrue(list.isEmpty());
        Assert.assertFalse(list.notEmpty());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max(Integer::compareTo);
    }

    @Test
    @Override
    public void min_null_throws() {
        // Not applicable for empty collections
        super.min_null_throws();
    }

    @Test
    @Override
    public void max_null_throws() {
        // Not applicable for empty collections
        super.max_null_throws();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min_without_comparator() {
        this.classUnderTest().min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max_without_comparator() {
        this.classUnderTest().max();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
        // Not applicable for empty collections
        super.min_null_throws_without_comparator();
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
        // Not applicable for empty collections
        super.max_null_throws_without_comparator();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.classUnderTest().minBy(String::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.classUnderTest().maxBy(String::valueOf);
    }

    @Override
    @Test
    public void zip() {
        ImmutableSet<Integer> immutableSet = this.classUnderTest();
        List<Object> nulls = Collections.nCopies(immutableSet.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableSet.size() + 1, null);
        ImmutableSet<Pair<Integer, Object>> pairs = immutableSet.zip(nulls);
        Assert.assertEquals(immutableSet, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableSet<Pair<Integer, Object>> pairsPlusOne = immutableSet.zip(nullsPlusOne);
        Assert.assertEquals(immutableSet, pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        Assert.assertEquals(immutableSet.zip(nulls), immutableSet.zip(nulls, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        ImmutableSet<Integer> immutableSet = this.classUnderTest();
        ImmutableSet<Pair<Integer, Integer>> pairs = immutableSet.zipWithIndex();
        Assert.assertEquals(immutableSet, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableSet.zipWithIndex(), immutableSet.zipWithIndex(UnifiedSet.newSet()));
    }

    @Test
    public void chunk() {
        Assert.assertEquals(Lists.mutable.of(), this.classUnderTest().chunk(2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.classUnderTest().chunk(0);
    }

    @Override
    @Test
    public void chunk_large_size() {
        Assert.assertEquals(Lists.mutable.of(), this.classUnderTest().chunk(10));
    }

    @Override
    @Test
    public void union() {
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), this.classUnderTest().union(UnifiedSet.newSetWith(1, 2, 3)));
    }

    @Override
    @Test
    public void unionInto() {
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), this.classUnderTest().unionInto(UnifiedSet.newSetWith(1, 2, 3), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void intersect() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersect(UnifiedSet.newSetWith(1, 2, 3)));
    }

    @Override
    @Test
    public void intersectInto() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersectInto(UnifiedSet.newSetWith(1, 2, 3), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void difference() {
        ImmutableSet<Integer> set = this.classUnderTest();
        ImmutableSet<Integer> difference = set.difference(UnifiedSet.newSetWith(1, 2, 3, 999));
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith(999)));
    }

    @Override
    @Test
    public void differenceInto() {
        ImmutableSet<Integer> set = this.classUnderTest();
        MutableSet<Integer> difference = set.differenceInto(UnifiedSet.newSetWith(1, 2, 3, 999), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith(99), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void symmetricDifference() {
        Assert.assertEquals(UnifiedSet.newSetWith(999), this.classUnderTest().symmetricDifference(UnifiedSet.newSetWith(999)));
    }

    @Override
    @Test
    public void symmetricDifferenceInto() {
        Assert.assertEquals(UnifiedSet.newSetWith(999), this.classUnderTest().symmetricDifferenceInto(UnifiedSet.newSetWith(999), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableSet<Integer> integers = this.classUnderTest();
        ImmutableBooleanSet actual = integers.collectBoolean(PrimitiveFunctions.integerIsPositive());
        Verify.assertEmpty(actual);
    }

    @Override
    @Test
    public void collect_target() {
        MutableList<Integer> targetCollection = FastList.newList();
        MutableList<Integer> actual = this.classUnderTest().collect(object -> {
            throw new AssertionError();
        }, targetCollection);
        Assert.assertEquals(targetCollection, actual);
        Assert.assertSame(targetCollection, actual);
    }

    @Override
    @Test
    public void collectWith_target() {
        MutableList<Integer> targetCollection = FastList.newList();
        MutableList<Integer> actual = this.classUnderTest().collectWith((argument1, argument2) -> {
            throw new AssertionError();
        }, 1, targetCollection);
        Assert.assertEquals(targetCollection, actual);
        Assert.assertSame(targetCollection, actual);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAll, this.description("containsAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWith, this.description("newWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirst, this.description("getFirst"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min, this.description("min"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max, this.description("max"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_null_throws, this.description("min_null_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_null_throws, this.description("max_null_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_without_comparator, this.description("min_without_comparator"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_without_comparator, this.description("max_without_comparator"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_null_throws_without_comparator, this.description("min_null_throws_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_null_throws_without_comparator, this.description("max_null_throws_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::minBy, this.description("minBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::maxBy, this.description("maxBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipWithIndex, this.description("zipWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk, this.description("chunk"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::chunk_zero_throws, this.description("chunk_zero_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk_large_size, this.description("chunk_large_size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::union, this.description("union"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unionInto, this.description("unionInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersect, this.description("intersect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersectInto, this.description("intersectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::difference, this.description("difference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::differenceInto, this.description("differenceInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifference, this.description("symmetricDifference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifferenceInto, this.description("symmetricDifferenceInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_target, this.description("collect_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith_target, this.description("collectWith_target"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableEmptySetTestCase implementation();
    }
}
