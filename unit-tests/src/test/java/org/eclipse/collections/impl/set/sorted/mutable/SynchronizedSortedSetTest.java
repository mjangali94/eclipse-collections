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
import java.util.TreeSet;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.collection.mutable.AbstractSynchronizedCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedSortedSet}.
 */
public class SynchronizedSortedSetTest extends AbstractSynchronizedCollectionTestCase {

    @Override
    protected <T> MutableSortedSet<T> newWith(T... littleElements) {
        return new SynchronizedSortedSet<>(SortedSetAdapter.adapt(new TreeSet<>(FastList.newListWith(littleElements))));
    }

    @Override
    @Test
    public void newEmpty() {
        super.newEmpty();
        Verify.assertInstanceOf(SynchronizedSortedSet.class, this.newWith().newEmpty());
    }

    @Override
    @Test
    public void removeIf() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(objects.removeIf(Predicates.equal(2)));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 3, 4);
    }

    @Test
    public void removeWithIf() {
        MutableCollection<Integer> objects = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(objects.removeIfWith(Predicates2.equal(), 2));
        Verify.assertSize(3, objects);
        Verify.assertContainsAll(objects, 1, 3, 4);
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedSet.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void selectInstancesOf() {
        MutableSortedSet<Number> mutableSortedSet = SortedSetAdapter.adapt(new TreeSet<>((o1, o2) -> Double.compare(o1.doubleValue(), o2.doubleValue())));
        MutableSortedSet<Number> synchronizedSortedSet = new SynchronizedSortedSet<>(mutableSortedSet).withAll(FastList.newListWith(1, 2.0, 3, 4.0, 5));
        MutableSortedSet<Integer> integers = synchronizedSortedSet.selectInstancesOf(Integer.class);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 3, 5), integers);
        Assert.assertEquals(FastList.newListWith(1, 3, 5), integers.toList());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        MutableSortedSet<Integer> integers = TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2, 3).asSynchronized();
        Verify.assertPostSerializedEqualsAndHashCode(this.newWith(1, 2, 3));
        Verify.assertPostSerializedEqualsAndHashCode(integers);
        Verify.assertInstanceOf(SynchronizedSortedSet.class, SerializeTestHelper.serializeDeserialize(integers));
        Verify.assertInstanceOf(SynchronizedSortedSet.class, SerializeTestHelper.serializeDeserialize(this.newWith(1, 2, 3)));
    }

    @Override
    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(1, 2, 5, 3, 4);
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4, 5), bag);
    }

    @Override
    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 1), bag);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void toSortedBag_with_null() {
        this.newWith(3, 4, null, 1, 2).toSortedBag();
    }

    @Override
    @Test
    public void toSortedBagBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), bag);
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void min_null_safe() {
        super.min_null_safe();
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void max_null_safe() {
        super.max_null_safe();
    }

    @Test
    public void getFirstOptional() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 2).getFirstOptional().get());
        Assert.assertTrue(this.newWith(1, 2).getFirstOptional().isPresent());
        Assert.assertFalse(this.newWith().getFirstOptional().isPresent());
    }

    @Test
    public void getLastOptional() {
        Assert.assertEquals(Integer.valueOf(2), this.newWith(1, 2).getLastOptional().get());
        Assert.assertTrue(this.newWith(1, 2).getLastOptional().isPresent());
        Assert.assertFalse(this.newWith().getLastOptional().isPresent());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newEmpty, this.description("newEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeIf, this.description("removeIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeWithIf, this.description("removeWithIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_natural_ordering, this.description("toSortedBag_natural_ordering"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_with_comparator, this.description("toSortedBag_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::toSortedBag_with_null, this.description("toSortedBag_with_null"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_null_safe, this.description("min_null_safe"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_null_safe, this.description("max_null_safe"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirstOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirstOptional, this.description("getFirstOptional"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLastOptional() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLastOptional, this.description("getLastOptional"));
        }

        private SynchronizedSortedSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedSortedSetTest();
        }

        @java.lang.Override
        public SynchronizedSortedSetTest implementation() {
            return this.implementation;
        }
    }
}
