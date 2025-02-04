/*
 * Copyright (c) 2021 Goldman Sachs.
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableRichIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
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
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testDelegatingMethods() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testDelegatingMethods);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_converters() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.converters);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCheck() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nullCheck);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableRichIterableTest();
            this.instance.setUp();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> testDelegatingMethods;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> converters;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> nullCheck;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableRichIterableTest> groupBy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = UnmodifiableRichIterableTest::testNewCollection;
            this.payloads.contains = UnmodifiableRichIterableTest::contains;
            this.payloads.containsBy = UnmodifiableRichIterableTest::containsBy;
            this.payloads.containsAllIterable = UnmodifiableRichIterableTest::containsAllIterable;
            this.payloads.containsAnyIterable = UnmodifiableRichIterableTest::containsAnyIterable;
            this.payloads.containsNoneIterable = UnmodifiableRichIterableTest::containsNoneIterable;
            this.payloads.containsAllArray = UnmodifiableRichIterableTest::containsAllArray;
            this.payloads.containsAnyCollection = UnmodifiableRichIterableTest::containsAnyCollection;
            this.payloads.containsNoneCollection = UnmodifiableRichIterableTest::containsNoneCollection;
            this.payloads.containsAllCollection = UnmodifiableRichIterableTest::containsAllCollection;
            this.payloads.tap = UnmodifiableRichIterableTest::tap;
            this.payloads.forEach = UnmodifiableRichIterableTest::forEach;
            this.payloads.forEachWith = UnmodifiableRichIterableTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableRichIterableTest::forEachWithIndex;
            this.payloads.select = UnmodifiableRichIterableTest::select;
            this.payloads.selectWith = UnmodifiableRichIterableTest::selectWith;
            this.payloads.selectWith_target = UnmodifiableRichIterableTest::selectWith_target;
            this.payloads.reject = UnmodifiableRichIterableTest::reject;
            this.payloads.rejectWith = UnmodifiableRichIterableTest::rejectWith;
            this.payloads.rejectWith_target = UnmodifiableRichIterableTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnmodifiableRichIterableTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableRichIterableTest::collect;
            this.payloads.collectTarget = UnmodifiableRichIterableTest::collectTarget;
            this.payloads.collectBoolean = UnmodifiableRichIterableTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableRichIterableTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = UnmodifiableRichIterableTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = UnmodifiableRichIterableTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableRichIterableTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = UnmodifiableRichIterableTest::collectByteWithBagTarget;
            this.payloads.collectChar = UnmodifiableRichIterableTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableRichIterableTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = UnmodifiableRichIterableTest::collectCharWithBagTarget;
            this.payloads.collectDouble = UnmodifiableRichIterableTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableRichIterableTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = UnmodifiableRichIterableTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = UnmodifiableRichIterableTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableRichIterableTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = UnmodifiableRichIterableTest::collectFloatWithBagTarget;
            this.payloads.collectInt = UnmodifiableRichIterableTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableRichIterableTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = UnmodifiableRichIterableTest::collectIntWithBagTarget;
            this.payloads.collectLong = UnmodifiableRichIterableTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableRichIterableTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = UnmodifiableRichIterableTest::collectLongWithBagTarget;
            this.payloads.collectShort = UnmodifiableRichIterableTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableRichIterableTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = UnmodifiableRichIterableTest::collectShortWithBagTarget;
            this.payloads.flatCollect = UnmodifiableRichIterableTest::flatCollect;
            this.payloads.flatCollectWith = UnmodifiableRichIterableTest::flatCollectWith;
            this.payloads.flatCollectBoolean = UnmodifiableRichIterableTest::flatCollectBoolean;
            this.payloads.flatCollectByte = UnmodifiableRichIterableTest::flatCollectByte;
            this.payloads.flatCollectShort = UnmodifiableRichIterableTest::flatCollectShort;
            this.payloads.flatCollectInt = UnmodifiableRichIterableTest::flatCollectInt;
            this.payloads.flatCollectChar = UnmodifiableRichIterableTest::flatCollectChar;
            this.payloads.flatCollectLong = UnmodifiableRichIterableTest::flatCollectLong;
            this.payloads.flatCollectDouble = UnmodifiableRichIterableTest::flatCollectDouble;
            this.payloads.flatCollectFloat = UnmodifiableRichIterableTest::flatCollectFloat;
            this.payloads.detect = UnmodifiableRichIterableTest::detect;
            this.payloads.detectOptional = UnmodifiableRichIterableTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnmodifiableRichIterableTest::min;
            this.payloads.minOptional = UnmodifiableRichIterableTest::minOptional;
            this.payloads.max = UnmodifiableRichIterableTest::max;
            this.payloads.maxOptional = UnmodifiableRichIterableTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableRichIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableRichIterableTest::max_without_comparator;
            this.payloads.min_null_safe = UnmodifiableRichIterableTest::min_null_safe;
            this.payloads.max_null_safe = UnmodifiableRichIterableTest::max_null_safe;
            this.payloads.minBy = UnmodifiableRichIterableTest::minBy;
            this.payloads.minByOptional = UnmodifiableRichIterableTest::minByOptional;
            this.payloads.maxBy = UnmodifiableRichIterableTest::maxBy;
            this.payloads.maxByOptional = UnmodifiableRichIterableTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = UnmodifiableRichIterableTest::detectWith;
            this.payloads.detectWithOptional = UnmodifiableRichIterableTest::detectWithOptional;
            this.payloads.detectIfNone = UnmodifiableRichIterableTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnmodifiableRichIterableTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = UnmodifiableRichIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableRichIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableRichIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableRichIterableTest::noneSatisfyWith;
            this.payloads.anySatisfy = UnmodifiableRichIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableRichIterableTest::anySatisfyWith;
            this.payloads.count = UnmodifiableRichIterableTest::count;
            this.payloads.countWith = UnmodifiableRichIterableTest::countWith;
            this.payloads.collectIf = UnmodifiableRichIterableTest::collectIf;
            this.payloads.collectWith = UnmodifiableRichIterableTest::collectWith;
            this.payloads.collectWith_target = UnmodifiableRichIterableTest::collectWith_target;
            this.payloads.getAny = UnmodifiableRichIterableTest::getAny;
            this.payloads.getFirst = UnmodifiableRichIterableTest::getFirst;
            this.payloads.getLast = UnmodifiableRichIterableTest::getLast;
            this.payloads.getOnly = UnmodifiableRichIterableTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableRichIterableTest::isEmpty;
            this.payloads.iterator = UnmodifiableRichIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = UnmodifiableRichIterableTest::injectInto;
            this.payloads.injectIntoInt = UnmodifiableRichIterableTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableRichIterableTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableRichIterableTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnmodifiableRichIterableTest::injectIntoFloat;
            this.payloads.sumFloat = UnmodifiableRichIterableTest::sumFloat;
            this.payloads.summarizeFloat = UnmodifiableRichIterableTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = UnmodifiableRichIterableTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = UnmodifiableRichIterableTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = UnmodifiableRichIterableTest::sumDouble;
            this.payloads.summarizeDouble = UnmodifiableRichIterableTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = UnmodifiableRichIterableTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = UnmodifiableRichIterableTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = UnmodifiableRichIterableTest::sumInteger;
            this.payloads.summarizeInt = UnmodifiableRichIterableTest::summarizeInt;
            this.payloads.sumLong = UnmodifiableRichIterableTest::sumLong;
            this.payloads.summarizeLong = UnmodifiableRichIterableTest::summarizeLong;
            this.payloads.sumByInt = UnmodifiableRichIterableTest::sumByInt;
            this.payloads.sumByFloat = UnmodifiableRichIterableTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = UnmodifiableRichIterableTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = UnmodifiableRichIterableTest::sumByLong;
            this.payloads.sumByDouble = UnmodifiableRichIterableTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = UnmodifiableRichIterableTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = UnmodifiableRichIterableTest::toArray;
            this.payloads.toList = UnmodifiableRichIterableTest::toList;
            this.payloads.toImmutableList = UnmodifiableRichIterableTest::toImmutableList;
            this.payloads.toCollection = UnmodifiableRichIterableTest::toCollection;
            this.payloads.toBag = UnmodifiableRichIterableTest::toBag;
            this.payloads.toImmutableBag = UnmodifiableRichIterableTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = UnmodifiableRichIterableTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = UnmodifiableRichIterableTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnmodifiableRichIterableTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = UnmodifiableRichIterableTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = UnmodifiableRichIterableTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = UnmodifiableRichIterableTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnmodifiableRichIterableTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = UnmodifiableRichIterableTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = UnmodifiableRichIterableTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = UnmodifiableRichIterableTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = UnmodifiableRichIterableTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = UnmodifiableRichIterableTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = UnmodifiableRichIterableTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = UnmodifiableRichIterableTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnmodifiableRichIterableTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = UnmodifiableRichIterableTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableRichIterableTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = UnmodifiableRichIterableTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = UnmodifiableRichIterableTest::toSet;
            this.payloads.toImmutableSet = UnmodifiableRichIterableTest::toImmutableSet;
            this.payloads.toMap = UnmodifiableRichIterableTest::toMap;
            this.payloads.toImmutableMap = UnmodifiableRichIterableTest::toImmutableMap;
            this.payloads.toMapTarget = UnmodifiableRichIterableTest::toMapTarget;
            this.payloads.toSortedMap = UnmodifiableRichIterableTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableRichIterableTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableRichIterableTest::toSortedMapBy;
            this.payloads.toBiMap = UnmodifiableRichIterableTest::toBiMap;
            this.payloads.toImmutableBiMap = UnmodifiableRichIterableTest::toImmutableBiMap;
            this.payloads.testToString = UnmodifiableRichIterableTest::testToString;
            this.payloads.makeString = UnmodifiableRichIterableTest::makeString;
            this.payloads.makeStringWithSeparator = UnmodifiableRichIterableTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnmodifiableRichIterableTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = UnmodifiableRichIterableTest::fusedCollectMakeString;
            this.payloads.appendString = UnmodifiableRichIterableTest::appendString;
            this.payloads.appendStringWithSeparator = UnmodifiableRichIterableTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnmodifiableRichIterableTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = UnmodifiableRichIterableTest::appendStringThrows;
            this.payloads.countBy = UnmodifiableRichIterableTest::countBy;
            this.payloads.countByWith = UnmodifiableRichIterableTest::countByWith;
            this.payloads.countByEach = UnmodifiableRichIterableTest::countByEach;
            this.payloads.groupByEach = UnmodifiableRichIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableRichIterableTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableRichIterableTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = UnmodifiableRichIterableTest::zip;
            this.payloads.zipWithIndex = UnmodifiableRichIterableTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableRichIterableTest::chunk;
            this.payloads.chunk_empty = UnmodifiableRichIterableTest::chunk_empty;
            this.payloads.chunk_single = UnmodifiableRichIterableTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.empty = UnmodifiableRichIterableTest::empty;
            this.payloads.notEmpty = UnmodifiableRichIterableTest::notEmpty;
            this.payloads.aggregateByMutating = UnmodifiableRichIterableTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableRichIterableTest::aggregateByNonMutating;
            this.payloads.reduceOptional = UnmodifiableRichIterableTest::reduceOptional;
            this.payloads.chunk_large_size = UnmodifiableRichIterableTest::chunk_large_size;
            this.payloads.testDelegatingMethods = UnmodifiableRichIterableTest::testDelegatingMethods;
            this.payloads.converters = UnmodifiableRichIterableTest::converters;
            this.payloads.nullCheck = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableRichIterableTest::nullCheck, java.lang.IllegalArgumentException.class);
            this.payloads.equalsAndHashCode = UnmodifiableRichIterableTest::equalsAndHashCode;
            this.payloads.partition = UnmodifiableRichIterableTest::partition;
            this.payloads.partitionWith = UnmodifiableRichIterableTest::partitionWith;
            this.payloads.groupBy = UnmodifiableRichIterableTest::groupBy;
        }
    }
*/
}
