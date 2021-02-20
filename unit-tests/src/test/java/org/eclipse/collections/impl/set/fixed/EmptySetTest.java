/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.fixed;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.multimap.set.MutableSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptySetTest extends AbstractMemoryEfficientMutableSetTestCase {

    private EmptySet<Object> emptySet;

    @Before
    public void setUp() {
        this.emptySet = new EmptySet<>();
    }

    @Override
    protected MutableSet<String> classUnderTest() {
        return new EmptySet<>();
    }

    @Override
    protected MutableSet<String> classUnderTestWithNull() {
        throw new AssertionError();
    }

    @Test
    public void testEmpty() {
        Assert.assertTrue(this.emptySet.isEmpty());
        Assert.assertFalse(this.emptySet.notEmpty());
        Assert.assertTrue(Sets.fixedSize.of().isEmpty());
        Assert.assertFalse(Sets.fixedSize.of().notEmpty());
    }

    @Test
    public void testSize() {
        Verify.assertSize(0, this.emptySet);
    }

    @Test
    public void testContains() {
        Assert.assertFalse(this.emptySet.contains("Something"));
        Assert.assertFalse(this.emptySet.contains(null));
    }

    @Test
    public void testGetFirstLast() {
        Assert.assertNull(this.emptySet.getFirst());
        Assert.assertNull(this.emptySet.getLast());
    }

    @Test
    public void testReadResolve() {
        Verify.assertInstanceOf(EmptySet.class, Sets.fixedSize.of());
        Verify.assertPostSerializedIdentity(Sets.fixedSize.of());
    }

    @Override
    @Test
    public void testClone() {
        Assert.assertSame(Sets.fixedSize.of().clone(), Sets.fixedSize.of());
    }

    @Test
    public void testForEach() {
        this.emptySet.forEach(Procedures.cast(each -> Assert.fail()));
    }

    @Test
    public void testForEachWithIndex() {
        this.emptySet.forEachWithIndex((each, index) -> Assert.fail());
    }

    @Test
    public void testForEachWith() {
        this.emptySet.forEachWith((argument1, argument2) -> Assert.fail(), "param");
    }

    @Test
    public void testIterator() {
        Iterator<Object> it = this.emptySet.iterator();
        Assert.assertFalse(it.hasNext());
        Assert.assertThrows(NoSuchElementException.class, it::next);
        Assert.assertThrows(UnsupportedOperationException.class, it::remove);
    }

    @Test
    @Override
    public void groupBy() {
        MutableSetMultimap<Class<?>, String> multimap = this.classUnderTest().groupBy(Object::getClass);
        Verify.assertSize(this.classUnderTest().size(), multimap);
        Assert.assertTrue(multimap.keysView().isEmpty());
        Assert.assertEquals(this.classUnderTest(), multimap.get(String.class));
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void min() {
        this.classUnderTest().min(String::compareTo);
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void max() {
        this.classUnderTest().max(String::compareTo);
    }

    @Test
    @Override
    public void min_null_throws() {
    // Not applicable for empty collections
    }

    @Test
    @Override
    public void max_null_throws() {
    // Not applicable for empty collections
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void min_without_comparator() {
        this.classUnderTest().min();
    }

    @Test(expected = NoSuchElementException.class)
    @Override
    public void max_without_comparator() {
        this.classUnderTest().max();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
    // Not applicable for empty collections
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
    // Not applicable for empty collections
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
        MutableSet<String> set = this.classUnderTest();
        List<Object> nulls = Collections.nCopies(set.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(set.size() + 1, null);
        MutableSet<Pair<String, Object>> pairs = set.zip(nulls);
        Assert.assertEquals(set, pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(nulls, pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        MutableSet<Pair<String, Object>> pairsPlusOne = set.zip(nullsPlusOne);
        Assert.assertEquals(set, pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(nulls, pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        Assert.assertEquals(set.zip(nulls), set.zip(nulls, UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        MutableSet<String> set = this.classUnderTest();
        MutableSet<Pair<String, Integer>> pairs = set.zipWithIndex();
        Assert.assertEquals(set, pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.newSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(set.zipWithIndex(), set.zipWithIndex(UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void chunk_large_size() {
        Assert.assertEquals(Lists.mutable.of(), this.classUnderTest().chunk(10));
    }

    @Override
    @Test
    public void union() {
        Assert.assertEquals(UnifiedSet.newSetWith("a", "b", "c"), this.classUnderTest().union(UnifiedSet.newSetWith("a", "b", "c")));
    }

    @Override
    @Test
    public void unionInto() {
        Assert.assertEquals(UnifiedSet.newSetWith("a", "b", "c"), this.classUnderTest().unionInto(UnifiedSet.newSetWith("a", "b", "c"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void intersect() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersect(UnifiedSet.newSetWith("1", "2", "3")));
    }

    @Override
    @Test
    public void intersectInto() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), this.classUnderTest().intersectInto(UnifiedSet.newSetWith("1", "2", "3"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void difference() {
        MutableSet<String> set = this.classUnderTest();
        MutableSet<String> difference = set.difference(UnifiedSet.newSetWith("2", "3", "4", "not present"));
        Assert.assertEquals(UnifiedSet.<String>newSet(), difference);
        Assert.assertEquals(set, set.difference(UnifiedSet.newSetWith("not present")));
    }

    @Override
    @Test
    public void differenceInto() {
        MutableSet<String> set = this.classUnderTest();
        MutableSet<String> difference = set.differenceInto(UnifiedSet.newSetWith("2", "3", "4", "not present"), UnifiedSet.newSet());
        Assert.assertEquals(UnifiedSet.<String>newSet(), difference);
        Assert.assertEquals(set, set.differenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void symmetricDifference() {
        Assert.assertEquals(UnifiedSet.newSetWith("not present"), this.classUnderTest().symmetricDifference(UnifiedSet.newSetWith("not present")));
    }

    @Override
    @Test
    public void symmetricDifferenceInto() {
        Assert.assertEquals(UnifiedSet.newSetWith("not present"), this.classUnderTest().symmetricDifferenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.emptySet.getOnly());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEmpty, this.description("testEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSize, this.description("testSize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testContains, this.description("testContains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGetFirstLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGetFirstLast, this.description("testGetFirstLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testReadResolve() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testReadResolve, this.description("testReadResolve"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClone, this.description("testClone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForEach, this.description("testForEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForEachWithIndex, this.description("testForEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testForEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testForEachWith, this.description("testForEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testIterator, this.description("testIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupBy, this.description("groupBy"));
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private EmptySetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new EmptySetTest();
        }

        @java.lang.Override
        public EmptySetTest implementation() {
            return this.implementation;
        }
    }
}
