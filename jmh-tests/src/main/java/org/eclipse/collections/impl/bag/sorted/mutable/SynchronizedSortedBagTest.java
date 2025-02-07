/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.SynchronizedRichIterable;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedSortedBag}.
 */
public class SynchronizedSortedBagTest extends AbstractMutableSortedBagTestCase {

    @Override
    protected <T> MutableSortedBag<T> newWith(T... littleElements) {
        return new SynchronizedSortedBag<>(TreeBag.newBagWith(littleElements));
    }

    @SafeVarargs
    @Override
    protected final <T> MutableSortedBag<T> newWithOccurrences(ObjectIntPair<T>... elementsWithOccurrences) {
        return super.newWithOccurrences(elementsWithOccurrences).asSynchronized();
    }

    @Override
    protected <T> MutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements) {
        return new SynchronizedSortedBag<>(TreeBag.newBagWith(comparator, elements));
    }

    @Override
    public void asSynchronized() {
        MutableSortedBag<Object> synchronizedBag = this.newWith();
        Assert.assertSame(synchronizedBag, synchronizedBag.asSynchronized());
    }

    @Override
    @Test
    public void topOccurrences() {
        super.topOccurrences();
        MutableSortedBag<String> mutable = TreeBag.newBag();
        mutable.addOccurrences("one", 1);
        mutable.addOccurrences("two", 2);
        mutable.addOccurrences("three", 3);
        mutable.addOccurrences("four", 4);
        mutable.addOccurrences("five", 5);
        mutable.addOccurrences("six", 6);
        mutable.addOccurrences("seven", 7);
        mutable.addOccurrences("eight", 8);
        mutable.addOccurrences("nine", 9);
        mutable.addOccurrences("ten", 10);
        MutableSortedBag<String> strings = mutable.asSynchronized();
        MutableList<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
    }

    @Override
    @Test
    public void bottomOccurrences() {
        super.bottomOccurrences();
        MutableSortedBag<String> mutable = TreeBag.newBag();
        mutable.addOccurrences("one", 1);
        mutable.addOccurrences("two", 2);
        mutable.addOccurrences("three", 3);
        mutable.addOccurrences("four", 4);
        mutable.addOccurrences("five", 5);
        mutable.addOccurrences("six", 6);
        mutable.addOccurrences("seven", 7);
        mutable.addOccurrences("eight", 8);
        mutable.addOccurrences("nine", 9);
        mutable.addOccurrences("ten", 10);
        MutableSortedBag<String> strings = mutable.asSynchronized();
        MutableList<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
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
        Bag<Integer> bag2 = this.newWith(3, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 1, 1, 4, 5, 7);
        Assert.assertEquals(Lists.mutable.with(6, 5, 8, 5, 6, 8), bag2.collectWithOccurrences((each, index) -> each + index));
    }

    @Override
    @Test
    public void distinctView() {
        Comparator<String> comparator = Collections.reverseOrder();
        MutableSortedBag<String> bag = this.newWith(comparator, "1", "2", "2", "3", "3", "3", "3", "4", "5", "5", "6");
        RichIterable<String> expected = bag.toSortedSet(comparator);
        RichIterable<String> actual = bag.distinctView();
        Verify.assertInstanceOf(SynchronizedRichIterable.class, actual);
        // not using Assert.assertEquals as actual is not a Set
        Verify.assertIterablesEqual(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public SynchronizedSortedBagTest instance;

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
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
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
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
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
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
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
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedSortedBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> iteratorRemove2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> setOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> makeString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> appendString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedSortedBagTest> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedSortedBagTest::testNewCollection;
            this.payloads.contains = SynchronizedSortedBagTest::contains;
            this.payloads.containsBy = SynchronizedSortedBagTest::containsBy;
            this.payloads.containsAnyIterable = SynchronizedSortedBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedSortedBagTest::containsNoneIterable;
            this.payloads.containsAnyCollection = SynchronizedSortedBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedSortedBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedSortedBagTest::containsAllCollection;
            this.payloads.selectInstancesOf = SynchronizedSortedBagTest::selectInstancesOf;
            this.payloads.collectTarget = SynchronizedSortedBagTest::collectTarget;
            this.payloads.collectBooleanWithTarget = SynchronizedSortedBagTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedSortedBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithTarget = SynchronizedSortedBagTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedSortedBagTest::collectByteWithBagTarget;
            this.payloads.collectCharWithTarget = SynchronizedSortedBagTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedSortedBagTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithTarget = SynchronizedSortedBagTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedSortedBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithTarget = SynchronizedSortedBagTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedSortedBagTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithTarget = SynchronizedSortedBagTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedSortedBagTest::collectIntWithBagTarget;
            this.payloads.collectLongWithTarget = SynchronizedSortedBagTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedSortedBagTest::collectLongWithBagTarget;
            this.payloads.collectShortWithTarget = SynchronizedSortedBagTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedSortedBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = SynchronizedSortedBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedSortedBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedSortedBagTest::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedSortedBagTest::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedSortedBagTest::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedSortedBagTest::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedSortedBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedSortedBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedSortedBagTest::flatCollectFloat;
            this.payloads.detectOptional = SynchronizedSortedBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = SynchronizedSortedBagTest::minOptional;
            this.payloads.maxOptional = SynchronizedSortedBagTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedSortedBagTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedSortedBagTest::max_without_comparator;
            this.payloads.minByOptional = SynchronizedSortedBagTest::minByOptional;
            this.payloads.maxByOptional = SynchronizedSortedBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = SynchronizedSortedBagTest::detectWithOptional;
            this.payloads.getAny = SynchronizedSortedBagTest::getAny;
            this.payloads.getOnly = SynchronizedSortedBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedSortedBagTest::isEmpty;
            this.payloads.summarizeFloat = SynchronizedSortedBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedSortedBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedSortedBagTest::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = SynchronizedSortedBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedSortedBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedSortedBagTest::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = SynchronizedSortedBagTest::summarizeInt;
            this.payloads.summarizeLong = SynchronizedSortedBagTest::summarizeLong;
            this.payloads.sumByInt = SynchronizedSortedBagTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedSortedBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedSortedBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedSortedBagTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedSortedBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedSortedBagTest::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = SynchronizedSortedBagTest::toImmutableList;
            this.payloads.toCollection = SynchronizedSortedBagTest::toCollection;
            this.payloads.toImmutableBag = SynchronizedSortedBagTest::toImmutableBag;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedSortedBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedSortedBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedSortedBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedSortedBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = SynchronizedSortedBagTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = SynchronizedSortedBagTest::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedSortedBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedSortedBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = SynchronizedSortedBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = SynchronizedSortedBagTest::toImmutableSet;
            this.payloads.toImmutableMap = SynchronizedSortedBagTest::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedSortedBagTest::toMapTarget;
            this.payloads.toBiMap = SynchronizedSortedBagTest::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedSortedBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SynchronizedSortedBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedSortedBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedSortedBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SynchronizedSortedBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedSortedBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedSortedBagTest::appendStringThrows;
            this.payloads.countBy = SynchronizedSortedBagTest::countBy;
            this.payloads.countByWith = SynchronizedSortedBagTest::countByWith;
            this.payloads.countByEach = SynchronizedSortedBagTest::countByEach;
            this.payloads.groupByUniqueKey = SynchronizedSortedBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedSortedBagTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = SynchronizedSortedBagTest::chunk_empty;
            this.payloads.chunk_single = SynchronizedSortedBagTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedSortedBagTest::chunk_large_size;
            this.payloads.empty = SynchronizedSortedBagTest::empty;
            this.payloads.notEmpty = SynchronizedSortedBagTest::notEmpty;
            this.payloads.reduceOptional = SynchronizedSortedBagTest::reduceOptional;
            this.payloads.newEmpty = SynchronizedSortedBagTest::newEmpty;
            this.payloads.testNewWith = SynchronizedSortedBagTest::testNewWith;
            this.payloads.testNewWithWith = SynchronizedSortedBagTest::testNewWithWith;
            this.payloads.testNewWithWithWith = SynchronizedSortedBagTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SynchronizedSortedBagTest::testNewWithVarArgs;
            this.payloads.removeAll = SynchronizedSortedBagTest::removeAll;
            this.payloads.clear = SynchronizedSortedBagTest::clear;
            this.payloads.with = SynchronizedSortedBagTest::with;
            this.payloads.withAll = SynchronizedSortedBagTest::withAll;
            this.payloads.without = SynchronizedSortedBagTest::without;
            this.payloads.withoutAll = SynchronizedSortedBagTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SynchronizedSortedBagTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SynchronizedSortedBagTest::asLazy;
            this.payloads.iteratorRemove = SynchronizedSortedBagTest::iteratorRemove;
            this.payloads.iteratorRemove2 = SynchronizedSortedBagTest::iteratorRemove2;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.setOccurrences = SynchronizedSortedBagTest::setOccurrences;
            this.payloads.setOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::setOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.toSortedListWith = SynchronizedSortedBagTest::toSortedListWith;
            this.payloads.asSynchronized = SynchronizedSortedBagTest::asSynchronized;
            this.payloads.anySatisfyWithOccurrences = SynchronizedSortedBagTest::anySatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = SynchronizedSortedBagTest::noneSatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = SynchronizedSortedBagTest::allSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = SynchronizedSortedBagTest::detectWithOccurrences;
            this.payloads.toImmutable = SynchronizedSortedBagTest::toImmutable;
            this.payloads.toString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::toString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.makeString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::makeString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.appendString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::appendString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.addAll = SynchronizedSortedBagTest::addAll;
            this.payloads.addAllIterable = SynchronizedSortedBagTest::addAllIterable;
            this.payloads.testClone = SynchronizedSortedBagTest::testClone;
            this.payloads.testToString = SynchronizedSortedBagTest::testToString;
            this.payloads.makeString = SynchronizedSortedBagTest::makeString;
            this.payloads.appendString = SynchronizedSortedBagTest::appendString;
            this.payloads.removeObject = SynchronizedSortedBagTest::removeObject;
            this.payloads.removeIf = SynchronizedSortedBagTest::removeIf;
            this.payloads.removeIfWith = SynchronizedSortedBagTest::removeIfWith;
            this.payloads.equalsAndHashCode = SynchronizedSortedBagTest::equalsAndHashCode;
            this.payloads.select = SynchronizedSortedBagTest::select;
            this.payloads.selectWith = SynchronizedSortedBagTest::selectWith;
            this.payloads.selectWith_target = SynchronizedSortedBagTest::selectWith_target;
            this.payloads.reject = SynchronizedSortedBagTest::reject;
            this.payloads.rejectWith = SynchronizedSortedBagTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedSortedBagTest::rejectWith_target;
            this.payloads.partition = SynchronizedSortedBagTest::partition;
            this.payloads.partitionWith = SynchronizedSortedBagTest::partitionWith;
            this.payloads.partitionWhile = SynchronizedSortedBagTest::partitionWhile;
            this.payloads.selectAndRejectWith = SynchronizedSortedBagTest::selectAndRejectWith;
            this.payloads.collect = SynchronizedSortedBagTest::collect;
            this.payloads.collectWithIndex = SynchronizedSortedBagTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedSortedBagTest::collectWithIndexWithTarget;
            this.payloads.flatCollect = SynchronizedSortedBagTest::flatCollect;
            this.payloads.distinct = SynchronizedSortedBagTest::distinct;
            this.payloads.takeWhile = SynchronizedSortedBagTest::takeWhile;
            this.payloads.dropWhile = SynchronizedSortedBagTest::dropWhile;
            this.payloads.collectIf = SynchronizedSortedBagTest::collectIf;
            this.payloads.collectWith = SynchronizedSortedBagTest::collectWith;
            this.payloads.collectWith_target = SynchronizedSortedBagTest::collectWith_target;
            this.payloads.groupBy = SynchronizedSortedBagTest::groupBy;
            this.payloads.groupByEach = SynchronizedSortedBagTest::groupByEach;
            this.payloads.zip = SynchronizedSortedBagTest::zip;
            this.payloads.zipWithIndex = SynchronizedSortedBagTest::zipWithIndex;
            this.payloads.toStringOfItemToCount = SynchronizedSortedBagTest::toStringOfItemToCount;
            this.payloads.add = SynchronizedSortedBagTest::add;
            this.payloads.iterator = SynchronizedSortedBagTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.tap = SynchronizedSortedBagTest::tap;
            this.payloads.forEach = SynchronizedSortedBagTest::forEach;
            this.payloads.forEachFromTo = SynchronizedSortedBagTest::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = SynchronizedSortedBagTest::forEachWithIndexWithFromTo;
            this.payloads.forEachWithOccurrences = SynchronizedSortedBagTest::forEachWithOccurrences;
            this.payloads.getFirst = SynchronizedSortedBagTest::getFirst;
            this.payloads.getLast = SynchronizedSortedBagTest::getLast;
            this.payloads.indexOf = SynchronizedSortedBagTest::indexOf;
            this.payloads.occurrencesOf = SynchronizedSortedBagTest::occurrencesOf;
            this.payloads.addOccurrences = SynchronizedSortedBagTest::addOccurrences;
            this.payloads.removeOccurrences = SynchronizedSortedBagTest::removeOccurrences;
            this.payloads.toList = SynchronizedSortedBagTest::toList;
            this.payloads.toSet = SynchronizedSortedBagTest::toSet;
            this.payloads.toBag = SynchronizedSortedBagTest::toBag;
            this.payloads.toStack = SynchronizedSortedBagTest::toStack;
            this.payloads.toSortedList_natural_ordering = SynchronizedSortedBagTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedSortedBagTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = SynchronizedSortedBagTest::toSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedSortedBagTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedSortedBagTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedSortedBagTest::toSortedSetBy;
            this.payloads.toMap = SynchronizedSortedBagTest::toMap;
            this.payloads.toSortedMap = SynchronizedSortedBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedSortedBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedSortedBagTest::toSortedMapBy;
            this.payloads.asUnmodifiable = SynchronizedSortedBagTest::asUnmodifiable;
            this.payloads.serialization = SynchronizedSortedBagTest::serialization;
            this.payloads.selectByOccurrences = SynchronizedSortedBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = SynchronizedSortedBagTest::selectDuplicates;
            this.payloads.toMapOfItemToCount = SynchronizedSortedBagTest::toMapOfItemToCount;
            this.payloads.compareTo = SynchronizedSortedBagTest::compareTo;
            this.payloads.containsAllIterable = SynchronizedSortedBagTest::containsAllIterable;
            this.payloads.containsAllArray = SynchronizedSortedBagTest::containsAllArray;
            this.payloads.forEachWith = SynchronizedSortedBagTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedSortedBagTest::forEachWithIndex;
            this.payloads.collectBoolean = SynchronizedSortedBagTest::collectBoolean;
            this.payloads.collectByte = SynchronizedSortedBagTest::collectByte;
            this.payloads.collectChar = SynchronizedSortedBagTest::collectChar;
            this.payloads.collectDouble = SynchronizedSortedBagTest::collectDouble;
            this.payloads.collectFloat = SynchronizedSortedBagTest::collectFloat;
            this.payloads.collectInt = SynchronizedSortedBagTest::collectInt;
            this.payloads.collectLong = SynchronizedSortedBagTest::collectLong;
            this.payloads.collectShort = SynchronizedSortedBagTest::collectShort;
            this.payloads.detect = SynchronizedSortedBagTest::detect;
            this.payloads.min = SynchronizedSortedBagTest::min;
            this.payloads.max = SynchronizedSortedBagTest::max;
            this.payloads.minBy = SynchronizedSortedBagTest::minBy;
            this.payloads.maxBy = SynchronizedSortedBagTest::maxBy;
            this.payloads.detectWith = SynchronizedSortedBagTest::detectWith;
            this.payloads.detectIfNone = SynchronizedSortedBagTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedSortedBagTest::detectWithIfNoneBlock;
            this.payloads.corresponds = SynchronizedSortedBagTest::corresponds;
            this.payloads.allSatisfy = SynchronizedSortedBagTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedSortedBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedSortedBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedSortedBagTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedSortedBagTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedSortedBagTest::anySatisfyWith;
            this.payloads.count = SynchronizedSortedBagTest::count;
            this.payloads.countWith = SynchronizedSortedBagTest::countWith;
            this.payloads.removeAllIterable = SynchronizedSortedBagTest::removeAllIterable;
            this.payloads.retainAll = SynchronizedSortedBagTest::retainAll;
            this.payloads.retainAllIterable = SynchronizedSortedBagTest::retainAllIterable;
            this.payloads.injectInto = SynchronizedSortedBagTest::injectInto;
            this.payloads.injectIntoWith = SynchronizedSortedBagTest::injectIntoWith;
            this.payloads.injectIntoInt = SynchronizedSortedBagTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedSortedBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedSortedBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedSortedBagTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedSortedBagTest::sumFloat;
            this.payloads.sumDouble = SynchronizedSortedBagTest::sumDouble;
            this.payloads.sumInteger = SynchronizedSortedBagTest::sumInteger;
            this.payloads.sumLong = SynchronizedSortedBagTest::sumLong;
            this.payloads.toArray = SynchronizedSortedBagTest::toArray;
            this.payloads.chunk = SynchronizedSortedBagTest::chunk;
            this.payloads.aggregateByMutating = SynchronizedSortedBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedSortedBagTest::aggregateByNonMutating;
            this.payloads.toSortedBag_natural_ordering = SynchronizedSortedBagTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedSortedBagTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = SynchronizedSortedBagTest::toSortedBagBy;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.detectIndex = SynchronizedSortedBagTest::detectIndex;
            this.payloads.take = SynchronizedSortedBagTest::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = SynchronizedSortedBagTest::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedSortedBagTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.selectUnique = SynchronizedSortedBagTest::selectUnique;
            this.payloads.topOccurrences = SynchronizedSortedBagTest::topOccurrences;
            this.payloads.bottomOccurrences = SynchronizedSortedBagTest::bottomOccurrences;
            this.payloads.collectWithOccurrences = SynchronizedSortedBagTest::collectWithOccurrences;
            this.payloads.distinctView = SynchronizedSortedBagTest::distinctView;
        }
    }
}
