/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.util.Collections;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableRichIterable}.
 */
public class UnmodifiableRichIterableTest extends AbstractRichIterableTestCase {

    private static final String METALLICA = "Metallica";

    private static final String BON_JOVI = "Bon Jovi";

    private static final String EUROPE = "Europe";

    private static final String SCORPIONS = "Scorpions";

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    private RichIterable<String> mutableCollection;

    private RichIterable<String> unmodifiableCollection;

    @Override
    protected <T> RichIterable<T> newWith(T... elements) {
        return UnmodifiableRichIterable.of(Lists.mutable.of(elements));
    }

    @Before
    public void setUp() {
        this.mutableCollection = Lists.mutable.of(METALLICA, BON_JOVI, EUROPE, SCORPIONS);
        this.unmodifiableCollection = UnmodifiableRichIterable.of(this.mutableCollection);
    }

    @Override
    @Test
    public void chunk_large_size() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        Verify.assertIterablesEqual(collection, collection.chunk(10).getOnly());
    }

    @Test
    public void testDelegatingMethods() {
        Assert.assertTrue(this.mutableCollection.notEmpty());
        Assert.assertTrue(this.unmodifiableCollection.notEmpty());
        Assert.assertFalse(this.mutableCollection.isEmpty());
        Assert.assertFalse(this.unmodifiableCollection.isEmpty());
        Verify.assertIterableSize(this.mutableCollection.size(), this.unmodifiableCollection);
        Assert.assertEquals(this.mutableCollection.getFirst(), this.unmodifiableCollection.getFirst());
        Assert.assertEquals(this.mutableCollection.getLast(), this.unmodifiableCollection.getLast());
    }

    @Test
    public void converters() {
        Assert.assertEquals(this.mutableCollection.toBag(), this.unmodifiableCollection.toBag());
        Assert.assertEquals(this.mutableCollection.asLazy().toBag(), this.unmodifiableCollection.asLazy().toBag());
        Assert.assertArrayEquals(this.mutableCollection.toArray(), this.unmodifiableCollection.toArray());
        Assert.assertArrayEquals(this.mutableCollection.toArray(EMPTY_STRING_ARRAY), this.unmodifiableCollection.toArray(EMPTY_STRING_ARRAY));
        Assert.assertEquals(this.mutableCollection.toList(), this.unmodifiableCollection.toList());
        Verify.assertListsEqual(Lists.mutable.of(BON_JOVI, EUROPE, METALLICA, SCORPIONS), this.unmodifiableCollection.toSortedList());
        Verify.assertListsEqual(Lists.mutable.of(SCORPIONS, METALLICA, EUROPE, BON_JOVI), this.unmodifiableCollection.toSortedList(Collections.reverseOrder()));
        Verify.assertListsEqual(Lists.mutable.of(BON_JOVI, EUROPE, METALLICA, SCORPIONS), this.unmodifiableCollection.toSortedListBy(Functions.getStringPassThru()));
        Verify.assertSize(4, this.unmodifiableCollection.toSet());
        Verify.assertSize(4, this.unmodifiableCollection.toMap(Functions.getStringPassThru(), Functions.getStringPassThru()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCheck() {
        UnmodifiableRichIterable.of(null);
    }

    @Test
    @Override
    public void equalsAndHashCode() {
        Assert.assertNotEquals(this.newWith(1, 2, 3).hashCode(), this.newWith(1, 2, 3).hashCode());
        Assert.assertNotEquals(this.newWith(1, 2, 3), this.newWith(1, 2, 3));
    }

    @Test
    @Override
    public void partition() {
        PartitionIterable<String> partition = this.mutableCollection.partition(ignored -> true);
        PartitionIterable<String> unmodifiablePartition = this.unmodifiableCollection.partition(ignored -> true);
        Assert.assertEquals(partition.getSelected(), unmodifiablePartition.getSelected());
        Assert.assertEquals(partition.getRejected(), unmodifiablePartition.getRejected());
    }

    @Test
    @Override
    public void partitionWith() {
        PartitionIterable<String> partition = this.mutableCollection.partitionWith((ignored1, ignored2) -> true, null);
        PartitionIterable<String> unmodifiablePartition = this.unmodifiableCollection.partitionWith((ignored1, ignored2) -> true, null);
        Assert.assertEquals(partition.getSelected(), unmodifiablePartition.getSelected());
        Assert.assertEquals(partition.getRejected(), unmodifiablePartition.getRejected());
    }

    @Test
    @Override
    public void groupBy() {
        Assert.assertEquals(this.mutableCollection.groupBy(Functions.getStringPassThru()), this.unmodifiableCollection.groupBy(Functions.getStringPassThru()));
        Assert.assertEquals(this.mutableCollection.groupBy(Functions.getStringPassThru(), FastListMultimap.newMultimap()), this.unmodifiableCollection.groupBy(Functions.getStringPassThru(), FastListMultimap.newMultimap()));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk_large_size, this.description("chunk_large_size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testDelegatingMethods() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testDelegatingMethods, this.description("testDelegatingMethods"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_converters() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::converters, this.description("converters"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCheck() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::nullCheck, this.description("nullCheck"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWith, this.description("partitionWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupBy, this.description("groupBy"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private UnmodifiableRichIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableRichIterableTest();
        }

        @java.lang.Override
        public UnmodifiableRichIterableTest implementation() {
            return this.implementation;
        }
    }
}
