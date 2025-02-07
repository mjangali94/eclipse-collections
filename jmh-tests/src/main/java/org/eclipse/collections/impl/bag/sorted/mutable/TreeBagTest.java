/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.mutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TreeBag}.
 *
 * @since 4.2
 */
public class TreeBagTest extends AbstractMutableSortedBagTestCase {

    @Override
    protected <T> MutableSortedBag<T> newWith(T... littleElements) {
        return TreeBag.newBagWith(littleElements);
    }

    @Override
    protected <T> MutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements) {
        return TreeBag.newBagWith(comparator, elements);
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedSortedBag.class, this.newWith().asSynchronized());
    }

    @Test
    public void sortedBagIterableConstructor() {
        TreeBag<Integer> sortedBagA = TreeBag.newBag(Collections.reverseOrder());
        TreeBag<Integer> sortedBagB = TreeBag.newBag(sortedBagA.with(1).with(2, 3).with(4, 5, 6).with(1, 1, 1, 1));
        Verify.assertSortedBagsEqual(sortedBagA, sortedBagB);
        Assert.assertTrue(sortedBagA.getFirst().equals(sortedBagB.getFirst()) && sortedBagB.getFirst() == 6);
        Verify.assertSortedBagsEqual(sortedBagB, TreeBag.newBag(sortedBagB));
    }

    @Test
    public void selectDuplicates() {
        TreeBag<Integer> sortedBagA = TreeBag.newBag(Collections.reverseOrder());
        TreeBag<Integer> sortedBagB = TreeBag.newBag(sortedBagA.with(1).with(2, 3).with(4, 5, 6).with(1, 1, 1, 1));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 1, 1), sortedBagB.selectDuplicates());
    }

    @Test
    public void collectWithIndex() {
        TreeBag<Integer> sortedBagA = TreeBag.newBag(Collections.reverseOrder());
        TreeBag<Integer> sortedBagB = TreeBag.newBag(sortedBagA.with(1).with(2, 3).with(4, 5, 6).with(1, 1, 1, 1));
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((Integer) 6, 0), PrimitiveTuples.pair((Integer) 5, 1), PrimitiveTuples.pair((Integer) 4, 2), PrimitiveTuples.pair((Integer) 3, 3), PrimitiveTuples.pair((Integer) 2, 4), PrimitiveTuples.pair((Integer) 1, 5), PrimitiveTuples.pair((Integer) 1, 6), PrimitiveTuples.pair((Integer) 1, 7), PrimitiveTuples.pair((Integer) 1, 8), PrimitiveTuples.pair((Integer) 1, 9)), sortedBagB.collectWithIndex(PrimitiveTuples::pair));
    }

    @Test
    public void flatCollectWith() {
        TreeBag<String> sortedBagA = TreeBag.newBag(Collections.reverseOrder());
        TreeBag<String> sortedBagB = TreeBag.newBag(sortedBagA.with("1").with("2", "3").with("1"));
        String s = "Alex";
        Assert.assertEquals(Lists.mutable.of("3", s, "2", s, "1", s, "1", s), sortedBagB.flatCollectWith(Lists.mutable::of, s));
    }

    @Test
    public void sortedBagConstructor() {
        MutableSortedBag<String> bagA = TreeBag.newBag(FastList.newListWith("a", "c", "b", "d"));
        Verify.assertSortedBagsEqual(bagA, TreeBag.newBag(bagA));
        Verify.assertSortedBagsEqual(bagA, TreeBag.newBag(bagA));
    }

    @Test
    public void iterableConstructor() {
        LazyIterable<Integer> integerLazyIterable = FastList.newListWith(2, 4, 1, 3).asLazy();
        TreeBag<Integer> sortedBag = TreeBag.newBag(Comparators.reverseNaturalOrder(), integerLazyIterable);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), sortedBag);
    }

    @Override
    @Test
    public void serialization() {
        MutableSortedBag<Integer> bag = this.newWith(1, 2, 3, 4, 5);
        Verify.assertPostSerializedEqualsAndHashCode(bag);
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

    @Override
    @Test
    public void collectWithOccurrences() {
        Bag<Integer> bag1 = this.newWith(3, 3, 3, 2, 2, 1);
        Bag<ObjectIntPair<Integer>> actual1 = bag1.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Assert.assertEquals(Bags.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1)), actual1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(1), 1), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(3), 3)), bag1.collectWithOccurrences(PrimitiveTuples::pair));
        Set<ObjectIntPair<Integer>> actual2 = bag1.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(Sets.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1)), actual2);
        Bag<Integer> bag2 = this.newWith(Comparator.reverseOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1)), bag2.collectWithOccurrences(PrimitiveTuples::pair));
        Bag<Integer> bag3 = this.newWith(3, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 1, 1, 4, 5, 7);
        Assert.assertEquals(Lists.mutable.with(6, 5, 8, 5, 6, 8), bag3.collectWithOccurrences((each, index) -> each + index));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public TreeBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toString_with_collection_containing_self);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_with_collection_containing_self);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_collection_containing_self);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortedBagIterableConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortedBagIterableConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortedBagConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortedBagConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterableConstructor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterableConstructor);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> payload) throws java.lang.Throwable {
            this.instance = new TreeBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> iteratorRemove2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> setOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> makeString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> appendString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sortedBagIterableConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> sortedBagConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> iterableConstructor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TreeBagTest> collectWithOccurrences;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = TreeBagTest::testNewCollection;
            this.payloads.contains = TreeBagTest::contains;
            this.payloads.containsBy = TreeBagTest::containsBy;
            this.payloads.containsAnyIterable = TreeBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = TreeBagTest::containsNoneIterable;
            this.payloads.containsAnyCollection = TreeBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = TreeBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = TreeBagTest::containsAllCollection;
            this.payloads.selectInstancesOf = TreeBagTest::selectInstancesOf;
            this.payloads.collectTarget = TreeBagTest::collectTarget;
            this.payloads.collectBooleanWithTarget = TreeBagTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = TreeBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithTarget = TreeBagTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = TreeBagTest::collectByteWithBagTarget;
            this.payloads.collectCharWithTarget = TreeBagTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = TreeBagTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithTarget = TreeBagTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = TreeBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithTarget = TreeBagTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = TreeBagTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithTarget = TreeBagTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = TreeBagTest::collectIntWithBagTarget;
            this.payloads.collectLongWithTarget = TreeBagTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = TreeBagTest::collectLongWithBagTarget;
            this.payloads.collectShortWithTarget = TreeBagTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = TreeBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectBoolean = TreeBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = TreeBagTest::flatCollectByte;
            this.payloads.flatCollectShort = TreeBagTest::flatCollectShort;
            this.payloads.flatCollectInt = TreeBagTest::flatCollectInt;
            this.payloads.flatCollectChar = TreeBagTest::flatCollectChar;
            this.payloads.flatCollectLong = TreeBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = TreeBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = TreeBagTest::flatCollectFloat;
            this.payloads.detectOptional = TreeBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = TreeBagTest::minOptional;
            this.payloads.maxOptional = TreeBagTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = TreeBagTest::min_without_comparator;
            this.payloads.max_without_comparator = TreeBagTest::max_without_comparator;
            this.payloads.minByOptional = TreeBagTest::minByOptional;
            this.payloads.maxByOptional = TreeBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = TreeBagTest::detectWithOptional;
            this.payloads.getAny = TreeBagTest::getAny;
            this.payloads.getOnly = TreeBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = TreeBagTest::isEmpty;
            this.payloads.summarizeFloat = TreeBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = TreeBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = TreeBagTest::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = TreeBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = TreeBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = TreeBagTest::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = TreeBagTest::summarizeInt;
            this.payloads.summarizeLong = TreeBagTest::summarizeLong;
            this.payloads.sumByInt = TreeBagTest::sumByInt;
            this.payloads.sumByFloat = TreeBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = TreeBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = TreeBagTest::sumByLong;
            this.payloads.sumByDouble = TreeBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = TreeBagTest::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = TreeBagTest::toImmutableList;
            this.payloads.toCollection = TreeBagTest::toCollection;
            this.payloads.toImmutableBag = TreeBagTest::toImmutableBag;
            this.payloads.toImmutableSortedList_natural_ordering = TreeBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_with_comparator = TreeBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = TreeBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_with_comparator = TreeBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = TreeBagTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = TreeBagTest::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = TreeBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toImmutableSortedSet_with_comparator = TreeBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = TreeBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = TreeBagTest::toImmutableSet;
            this.payloads.toImmutableMap = TreeBagTest::toImmutableMap;
            this.payloads.toMapTarget = TreeBagTest::toMapTarget;
            this.payloads.toBiMap = TreeBagTest::toBiMap;
            this.payloads.toImmutableBiMap = TreeBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = TreeBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = TreeBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = TreeBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = TreeBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = TreeBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = TreeBagTest::appendStringThrows;
            this.payloads.countBy = TreeBagTest::countBy;
            this.payloads.countByWith = TreeBagTest::countByWith;
            this.payloads.countByEach = TreeBagTest::countByEach;
            this.payloads.groupByUniqueKey = TreeBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = TreeBagTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = TreeBagTest::chunk_empty;
            this.payloads.chunk_single = TreeBagTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = TreeBagTest::chunk_large_size;
            this.payloads.empty = TreeBagTest::empty;
            this.payloads.notEmpty = TreeBagTest::notEmpty;
            this.payloads.reduceOptional = TreeBagTest::reduceOptional;
            this.payloads.newEmpty = TreeBagTest::newEmpty;
            this.payloads.testNewWith = TreeBagTest::testNewWith;
            this.payloads.testNewWithWith = TreeBagTest::testNewWithWith;
            this.payloads.testNewWithWithWith = TreeBagTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = TreeBagTest::testNewWithVarArgs;
            this.payloads.removeAll = TreeBagTest::removeAll;
            this.payloads.clear = TreeBagTest::clear;
            this.payloads.with = TreeBagTest::with;
            this.payloads.withAll = TreeBagTest::withAll;
            this.payloads.without = TreeBagTest::without;
            this.payloads.withoutAll = TreeBagTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = TreeBagTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = TreeBagTest::asLazy;
            this.payloads.iteratorRemove = TreeBagTest::iteratorRemove;
            this.payloads.iteratorRemove2 = TreeBagTest::iteratorRemove2;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.setOccurrences = TreeBagTest::setOccurrences;
            this.payloads.setOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::setOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.toSortedListWith = TreeBagTest::toSortedListWith;
            this.payloads.anySatisfyWithOccurrences = TreeBagTest::anySatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = TreeBagTest::noneSatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = TreeBagTest::allSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = TreeBagTest::detectWithOccurrences;
            this.payloads.toImmutable = TreeBagTest::toImmutable;
            this.payloads.toString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::toString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.makeString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::makeString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.appendString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::appendString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.addAll = TreeBagTest::addAll;
            this.payloads.addAllIterable = TreeBagTest::addAllIterable;
            this.payloads.testClone = TreeBagTest::testClone;
            this.payloads.testToString = TreeBagTest::testToString;
            this.payloads.makeString = TreeBagTest::makeString;
            this.payloads.appendString = TreeBagTest::appendString;
            this.payloads.removeObject = TreeBagTest::removeObject;
            this.payloads.removeIf = TreeBagTest::removeIf;
            this.payloads.removeIfWith = TreeBagTest::removeIfWith;
            this.payloads.equalsAndHashCode = TreeBagTest::equalsAndHashCode;
            this.payloads.select = TreeBagTest::select;
            this.payloads.selectWith = TreeBagTest::selectWith;
            this.payloads.selectWith_target = TreeBagTest::selectWith_target;
            this.payloads.reject = TreeBagTest::reject;
            this.payloads.rejectWith = TreeBagTest::rejectWith;
            this.payloads.rejectWith_target = TreeBagTest::rejectWith_target;
            this.payloads.partition = TreeBagTest::partition;
            this.payloads.partitionWith = TreeBagTest::partitionWith;
            this.payloads.partitionWhile = TreeBagTest::partitionWhile;
            this.payloads.selectAndRejectWith = TreeBagTest::selectAndRejectWith;
            this.payloads.collect = TreeBagTest::collect;
            this.payloads.collectWithIndexWithTarget = TreeBagTest::collectWithIndexWithTarget;
            this.payloads.flatCollect = TreeBagTest::flatCollect;
            this.payloads.distinct = TreeBagTest::distinct;
            this.payloads.takeWhile = TreeBagTest::takeWhile;
            this.payloads.dropWhile = TreeBagTest::dropWhile;
            this.payloads.collectIf = TreeBagTest::collectIf;
            this.payloads.collectWith = TreeBagTest::collectWith;
            this.payloads.collectWith_target = TreeBagTest::collectWith_target;
            this.payloads.groupBy = TreeBagTest::groupBy;
            this.payloads.groupByEach = TreeBagTest::groupByEach;
            this.payloads.zip = TreeBagTest::zip;
            this.payloads.zipWithIndex = TreeBagTest::zipWithIndex;
            this.payloads.toStringOfItemToCount = TreeBagTest::toStringOfItemToCount;
            this.payloads.add = TreeBagTest::add;
            this.payloads.iterator = TreeBagTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.tap = TreeBagTest::tap;
            this.payloads.forEach = TreeBagTest::forEach;
            this.payloads.forEachFromTo = TreeBagTest::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = TreeBagTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithOccurrences = TreeBagTest::forEachWithOccurrences;
            this.payloads.getFirst = TreeBagTest::getFirst;
            this.payloads.getLast = TreeBagTest::getLast;
            this.payloads.indexOf = TreeBagTest::indexOf;
            this.payloads.occurrencesOf = TreeBagTest::occurrencesOf;
            this.payloads.addOccurrences = TreeBagTest::addOccurrences;
            this.payloads.removeOccurrences = TreeBagTest::removeOccurrences;
            this.payloads.toList = TreeBagTest::toList;
            this.payloads.toSet = TreeBagTest::toSet;
            this.payloads.toBag = TreeBagTest::toBag;
            this.payloads.toStack = TreeBagTest::toStack;
            this.payloads.toSortedList_natural_ordering = TreeBagTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = TreeBagTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = TreeBagTest::toSortedListBy;
            this.payloads.toSortedSet_natural_ordering = TreeBagTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = TreeBagTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = TreeBagTest::toSortedSetBy;
            this.payloads.toMap = TreeBagTest::toMap;
            this.payloads.toSortedMap = TreeBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = TreeBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = TreeBagTest::toSortedMapBy;
            this.payloads.asUnmodifiable = TreeBagTest::asUnmodifiable;
            this.payloads.selectByOccurrences = TreeBagTest::selectByOccurrences;
            this.payloads.toMapOfItemToCount = TreeBagTest::toMapOfItemToCount;
            this.payloads.compareTo = TreeBagTest::compareTo;
            this.payloads.containsAllIterable = TreeBagTest::containsAllIterable;
            this.payloads.containsAllArray = TreeBagTest::containsAllArray;
            this.payloads.forEachWith = TreeBagTest::forEachWith;
            this.payloads.forEachWithIndex = TreeBagTest::forEachWithIndex;
            this.payloads.collectBoolean = TreeBagTest::collectBoolean;
            this.payloads.collectByte = TreeBagTest::collectByte;
            this.payloads.collectChar = TreeBagTest::collectChar;
            this.payloads.collectDouble = TreeBagTest::collectDouble;
            this.payloads.collectFloat = TreeBagTest::collectFloat;
            this.payloads.collectInt = TreeBagTest::collectInt;
            this.payloads.collectLong = TreeBagTest::collectLong;
            this.payloads.collectShort = TreeBagTest::collectShort;
            this.payloads.detect = TreeBagTest::detect;
            this.payloads.min = TreeBagTest::min;
            this.payloads.max = TreeBagTest::max;
            this.payloads.minBy = TreeBagTest::minBy;
            this.payloads.maxBy = TreeBagTest::maxBy;
            this.payloads.detectWith = TreeBagTest::detectWith;
            this.payloads.detectIfNone = TreeBagTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = TreeBagTest::detectWithIfNoneBlock;
            this.payloads.corresponds = TreeBagTest::corresponds;
            this.payloads.allSatisfy = TreeBagTest::allSatisfy;
            this.payloads.allSatisfyWith = TreeBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = TreeBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = TreeBagTest::noneSatisfyWith;
            this.payloads.anySatisfy = TreeBagTest::anySatisfy;
            this.payloads.anySatisfyWith = TreeBagTest::anySatisfyWith;
            this.payloads.count = TreeBagTest::count;
            this.payloads.countWith = TreeBagTest::countWith;
            this.payloads.removeAllIterable = TreeBagTest::removeAllIterable;
            this.payloads.retainAll = TreeBagTest::retainAll;
            this.payloads.retainAllIterable = TreeBagTest::retainAllIterable;
            this.payloads.injectInto = TreeBagTest::injectInto;
            this.payloads.injectIntoWith = TreeBagTest::injectIntoWith;
            this.payloads.injectIntoInt = TreeBagTest::injectIntoInt;
            this.payloads.injectIntoLong = TreeBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = TreeBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = TreeBagTest::injectIntoFloat;
            this.payloads.sumFloat = TreeBagTest::sumFloat;
            this.payloads.sumDouble = TreeBagTest::sumDouble;
            this.payloads.sumInteger = TreeBagTest::sumInteger;
            this.payloads.sumLong = TreeBagTest::sumLong;
            this.payloads.toArray = TreeBagTest::toArray;
            this.payloads.chunk = TreeBagTest::chunk;
            this.payloads.aggregateByMutating = TreeBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = TreeBagTest::aggregateByNonMutating;
            this.payloads.toSortedBag_natural_ordering = TreeBagTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = TreeBagTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = TreeBagTest::toSortedBagBy;
            this.payloads.topOccurrences = TreeBagTest::topOccurrences;
            this.payloads.bottomOccurrences = TreeBagTest::bottomOccurrences;
            this.payloads.detectIndex = TreeBagTest::detectIndex;
            this.payloads.take = TreeBagTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = TreeBagTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.selectUnique = TreeBagTest::selectUnique;
            this.payloads.distinctView = TreeBagTest::distinctView;
            this.payloads.asSynchronized = TreeBagTest::asSynchronized;
            this.payloads.sortedBagIterableConstructor = TreeBagTest::sortedBagIterableConstructor;
            this.payloads.selectDuplicates = TreeBagTest::selectDuplicates;
            this.payloads.collectWithIndex = TreeBagTest::collectWithIndex;
            this.payloads.flatCollectWith = TreeBagTest::flatCollectWith;
            this.payloads.sortedBagConstructor = TreeBagTest::sortedBagConstructor;
            this.payloads.iterableConstructor = TreeBagTest::iterableConstructor;
            this.payloads.serialization = TreeBagTest::serialization;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(TreeBagTest::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.collectWithOccurrences = TreeBagTest::collectWithOccurrences;
        }
    }
}
