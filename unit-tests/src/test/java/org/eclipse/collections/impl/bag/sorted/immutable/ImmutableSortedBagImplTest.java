/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.immutable;

import java.util.Collections;
import java.util.Comparator;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.factory.SortedBags;
import org.eclipse.collections.impl.factory.SortedSets;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSortedBagImplTest extends AbstractImmutableSortedBagTestCase {

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest() {
        return SortedBags.immutable.with(1, 1, 1, 2);
    }

    @Override
    protected <T> MutableCollection<T> newMutable() {
        return SortedBags.mutable.empty();
    }

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest(Comparator<? super Integer> comparator) {
        return SortedBags.immutable.with(comparator, 1, 1, 1, 2);
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(T... elements) {
        return SortedBags.immutable.with(elements);
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements) {
        return SortedBags.immutable.with(comparator, elements);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        Comparator<Integer> comparator = Collections.reverseOrder();
        ImmutableSortedBag<Integer> bag = this.classUnderTest(comparator);
        ImmutableSortedSet<Integer> expected = SortedSets.immutable.with(comparator, 2);
        ImmutableSortedSet<Integer> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected.comparator(), actual.comparator());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        private ImmutableSortedBagImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableSortedBagImplTest();
        }

        @java.lang.Override
        public ImmutableSortedBagImplTest implementation() {
            return this.implementation;
        }
    }
}
