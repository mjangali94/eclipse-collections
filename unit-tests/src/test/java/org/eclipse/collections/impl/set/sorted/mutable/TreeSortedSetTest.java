/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.sorted.mutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class TreeSortedSetTest extends AbstractSortedSetTestCase {

    @Override
    protected <T> TreeSortedSet<T> newWith(T... elements) {
        return TreeSortedSet.newSetWith(elements);
    }

    @Override
    protected <T> TreeSortedSet<T> newWith(Comparator<? super T> comparator, T... elements) {
        return TreeSortedSet.newSetWith(comparator, elements);
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedSortedSet.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith().asUnmodifiable());
    }

    @Test
    public void sortedSetIterableConstructor() {
        TreeSortedSet<Integer> sortedSetA = TreeSortedSet.newSet(Collections.reverseOrder());
        TreeSortedSet<Integer> sortedSetB = TreeSortedSet.newSet(sortedSetA.with(1).with(2, 3).with(4, 5, 6));
        Verify.assertSortedSetsEqual(sortedSetA, sortedSetB);
        Assert.assertTrue(sortedSetA.first().equals(sortedSetB.first()) && sortedSetB.first() == 6);
        Verify.assertSortedSetsEqual(sortedSetB, new TreeSortedSet<>(sortedSetB));
    }

    @Test
    public void sortedSetConstructor() {
        SortedSet<String> setA = new TreeSet<>(FastList.newListWith("a", "c", "b", "d"));
        Verify.assertSortedSetsEqual(setA, TreeSortedSet.newSet(setA));
        Verify.assertSortedSetsEqual(setA, new TreeSortedSet<>(setA));
    }

    @Test
    public void iterableConstructor() {
        LazyIterable<Integer> integerLazyIterable = FastList.newListWith(2, 4, 1, 3).asLazy();
        TreeSortedSet<Integer> sortedSet = TreeSortedSet.newSet(integerLazyIterable);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), sortedSet);
    }

    @Test
    public void serialization() {
        MutableSortedSet<Integer> set = this.newWith(1, 2, 3, 4, 5);
        Verify.assertPostSerializedEqualsAndHashCode(set);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void detectLastIndex() {
        this.newWith(1, 2, 3).detectLastIndex(each -> each % 2 == 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseForEach() {
        this.newWith(1, 2, 3).reverseForEach(each -> Assert.fail("Should not be evaluated"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseForEachWithIndex() {
        this.newWith(1, 2, 3).reverseForEachWithIndex((each, index) -> Assert.fail("Should not be evaluated"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void toReversed() {
        this.newWith(1, 2, 3).toReversed();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortedSetIterableConstructor() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortedSetIterableConstructor, this.description("sortedSetIterableConstructor"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortedSetConstructor() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortedSetConstructor, this.description("sortedSetConstructor"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterableConstructor() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterableConstructor, this.description("iterableConstructor"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialization, this.description("serialization"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::detectLastIndex, this.description("detectLastIndex"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::reverseForEach, this.description("reverseForEach"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::reverseForEachWithIndex, this.description("reverseForEachWithIndex"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::toReversed, this.description("toReversed"), java.lang.UnsupportedOperationException.class);
        }

        private TreeSortedSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TreeSortedSetTest();
        }

        @java.lang.Override
        public TreeSortedSetTest implementation() {
            return this.implementation;
        }
    }
}
