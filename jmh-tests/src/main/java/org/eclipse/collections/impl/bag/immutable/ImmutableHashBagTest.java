/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable;

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.bag.HashBagMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iBag;

public class ImmutableHashBagTest extends ImmutableBagTestCase {

    @Override
    protected ImmutableBag<String> newBag() {
        return ImmutableHashBag.newBagWith("1", "2", "2", "3", "3", "3", "4", "4", "4", "4");
    }

    @Override
    protected int numKeys() {
        return 4;
    }

    @Override
    @Test
    public void testSize() {
        Verify.assertIterableSize(10, this.newBag());
    }

    @Override
    public void toStringOfItemToCount() {
        Assert.assertEquals("{}", ImmutableHashBag.newBag().toStringOfItemToCount());
        Assert.assertEquals("{1=3}", ImmutableHashBag.newBagWith("1", "1", "1").toStringOfItemToCount());
        String actual = ImmutableHashBag.newBagWith("1", "2", "2").toStringOfItemToCount();
        Assert.assertTrue("{1=1, 2=2}".equals(actual) || "{2=2, 1=1}".equals(actual));
    }

    @Override
    @Test
    public void selectInstancesOf() {
        super.selectInstancesOf();
        ImmutableBag<Number> numbers = ImmutableHashBag.newBagWith(1, 2.0, 2.0, 3, 3, 3, 4.0, 4.0, 4.0, 4.0);
        Assert.assertEquals(iBag(1, 3, 3, 3), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(iBag(2.0, 2.0, 4.0, 4.0, 4.0, 4.0), numbers.selectInstancesOf(Double.class));
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableBooleanBag result = this.newBag().collectBoolean("4"::equals);
        Assert.assertEquals(2, result.sizeDistinct());
        Assert.assertEquals(4, result.occurrencesOf(true));
        Assert.assertEquals(6, result.occurrencesOf(false));
    }

    @Test
    public void testNewBag() {
        ImmutableHashBag<Object> immutableHashBag = ImmutableHashBag.newBagWith(HashBag.newBag().with(1, 2, 3, 4));
        Verify.assertSize(4, immutableHashBag);
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), immutableHashBag.toSortedList());
    }

    @Override
    @Test
    public void groupByEach() {
        ImmutableBag<Integer> immutableBag = ImmutableHashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        MutableMultimap<Integer, Integer> expected = HashBagMultimap.newMultimap();
        int keys = this.numKeys();
        immutableBag.forEachWithOccurrences((each, parameter) -> {
            HashBag<Integer> bag = HashBag.newBag();
            Interval.fromTo(each, keys).forEach((int eachInt) -> bag.addOccurrences(eachInt, eachInt));
            expected.putAll(-each, bag);
        });
        Multimap<Integer, Integer> actual = immutableBag.groupByEach(new NegativeIntervalFunction());
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = immutableBag.groupByEach(new NegativeIntervalFunction(), HashBagMultimap.newMultimap());
        Assert.assertEquals(expected, actualWithTarget);
    }

    @Override
    @Test
    public void groupByUniqueKey() {
        ImmutableBag<Integer> immutableBag = ImmutableHashBag.newBagWith(1, 2, 3);
        Assert.assertEquals(Maps.immutable.of(1, 1, 2, 2, 3, 3), immutableBag.groupByUniqueKey(id -> id));
    }

    @Override
    @Test
    public void groupByUniqueKey_target() {
        ImmutableBag<Integer> immutableBag = ImmutableHashBag.newBagWith(1, 2, 3);
        Assert.assertEquals(Maps.immutable.of(0, 0, 1, 1, 2, 2, 3, 3), immutableBag.groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0)));
    }

    @Test
    public void topOccurrences() {
        MutableBag<String> mutable = HashBag.newBag();
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
        ImmutableBag<String> strings = ImmutableHashBag.newBagWith(mutable);
        ImmutableList<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Verify.assertIterableSize(5, top5);
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertIterableSize(0, ImmutableHashBag.newBagWith().topOccurrences(5));
        Verify.assertIterableSize(3, this.newWith("one", "two", "three").topOccurrences(5));
        Verify.assertIterableSize(3, this.newWith("one", "two", "three").topOccurrences(1));
        Verify.assertIterableSize(3, this.newWith("one", "two", "three").topOccurrences(2));
        Verify.assertIterableSize(3, this.newWith("one", "one", "two", "three").topOccurrences(2));
        Verify.assertIterableSize(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1));
        Verify.assertIterableSize(3, this.newWith(null, "one", "two").topOccurrences(5));
        Verify.assertIterableSize(3, this.newWith(null, "one", "two").topOccurrences(1));
        Verify.assertIterableSize(3, this.newWith("one", "one", "two", "two", "three", "three").topOccurrences(1));
        Verify.assertIterableSize(0, this.newWith("one").newWithout("one").topOccurrences(0));
        Verify.assertIterableSize(0, this.newWith("one").topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith("one").topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        MutableBag<String> mutable = HashBag.newBag();
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
        ImmutableBag<String> strings = ImmutableHashBag.newBagWith(mutable);
        ImmutableList<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Verify.assertIterableSize(5, bottom5);
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertIterableSize(0, ImmutableHashBag.newBagWith().bottomOccurrences(5));
        Verify.assertIterableSize(3, this.newWith("one", "two", "three").bottomOccurrences(5));
        Verify.assertIterableSize(3, this.newWith("one", "two", "three").bottomOccurrences(1));
        Verify.assertIterableSize(3, this.newWith("one", "two", "three").bottomOccurrences(2));
        Verify.assertIterableSize(3, this.newWith("one", "one", "two", "two", "three").bottomOccurrences(2));
        Verify.assertIterableSize(3, this.newWith("one", "one", "two", "two", "three", "three").bottomOccurrences(1));
        Verify.assertIterableSize(3, this.newWith(null, "one", "two").bottomOccurrences(5));
        Verify.assertIterableSize(3, this.newWith(null, "one", "two").bottomOccurrences(1));
        Verify.assertIterableSize(3, this.newWith("one", "one", "two", "two", "three", "three").bottomOccurrences(1));
        Verify.assertIterableSize(0, this.newWith("one").newWithout("one").bottomOccurrences(0));
        Verify.assertIterableSize(0, this.newWith("one").bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith("one").bottomOccurrences(-1));
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableBag<String> bag = this.newBag();
        ImmutableSet<String> expected = Sets.immutable.of("1");
        ImmutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableHashBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
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
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
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
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
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
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
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
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
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
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
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
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectToTarget);
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
        public void benchmark_rejectWithToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
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
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy_with_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy_with_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_appendString_with_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_separator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_start_separator_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
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
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableHashBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> rejectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupBy_with_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> appendString_with_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> appendString_with_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> testNewBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ImmutableHashBagTest::testNewCollection;
            this.payloads.containsBy = ImmutableHashBagTest::containsBy;
            this.payloads.containsAnyIterable = ImmutableHashBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableHashBagTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableHashBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableHashBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = ImmutableHashBagTest::containsAllCollection;
            this.payloads.selectWith_target = ImmutableHashBagTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableHashBagTest::rejectWith_target;
            this.payloads.collectTarget = ImmutableHashBagTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ImmutableHashBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ImmutableHashBagTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ImmutableHashBagTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ImmutableHashBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ImmutableHashBagTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ImmutableHashBagTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ImmutableHashBagTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ImmutableHashBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ImmutableHashBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ImmutableHashBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ImmutableHashBagTest::flatCollectByte;
            this.payloads.flatCollectShort = ImmutableHashBagTest::flatCollectShort;
            this.payloads.flatCollectInt = ImmutableHashBagTest::flatCollectInt;
            this.payloads.flatCollectChar = ImmutableHashBagTest::flatCollectChar;
            this.payloads.flatCollectLong = ImmutableHashBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = ImmutableHashBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ImmutableHashBagTest::flatCollectFloat;
            this.payloads.detectOptional = ImmutableHashBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minOptional = ImmutableHashBagTest::minOptional;
            this.payloads.maxOptional = ImmutableHashBagTest::maxOptional;
            this.payloads.min_null_safe = ImmutableHashBagTest::min_null_safe;
            this.payloads.max_null_safe = ImmutableHashBagTest::max_null_safe;
            this.payloads.minByOptional = ImmutableHashBagTest::minByOptional;
            this.payloads.maxByOptional = ImmutableHashBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ImmutableHashBagTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = ImmutableHashBagTest::detectWithIfNoneBlock;
            this.payloads.allSatisfyWith = ImmutableHashBagTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableHashBagTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableHashBagTest::anySatisfyWith;
            this.payloads.getAny = ImmutableHashBagTest::getAny;
            this.payloads.getOnly = ImmutableHashBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.summarizeFloat = ImmutableHashBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ImmutableHashBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ImmutableHashBagTest::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = ImmutableHashBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ImmutableHashBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ImmutableHashBagTest::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = ImmutableHashBagTest::summarizeInt;
            this.payloads.summarizeLong = ImmutableHashBagTest::summarizeLong;
            this.payloads.sumByInt = ImmutableHashBagTest::sumByInt;
            this.payloads.sumByFloat = ImmutableHashBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableHashBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableHashBagTest::sumByLong;
            this.payloads.sumByDouble = ImmutableHashBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableHashBagTest::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = ImmutableHashBagTest::toImmutableList;
            this.payloads.toCollection = ImmutableHashBagTest::toCollection;
            this.payloads.toImmutableBag = ImmutableHashBagTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ImmutableHashBagTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ImmutableHashBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableHashBagTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ImmutableHashBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ImmutableHashBagTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ImmutableHashBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableHashBagTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ImmutableHashBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ImmutableHashBagTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ImmutableHashBagTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableHashBagTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ImmutableHashBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableHashBagTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ImmutableHashBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableHashBagTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ImmutableHashBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ImmutableHashBagTest::toImmutableSet;
            this.payloads.toImmutableMap = ImmutableHashBagTest::toImmutableMap;
            this.payloads.toBiMap = ImmutableHashBagTest::toBiMap;
            this.payloads.toImmutableBiMap = ImmutableHashBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ImmutableHashBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableHashBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ImmutableHashBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ImmutableHashBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableHashBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ImmutableHashBagTest::appendStringThrows;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = ImmutableHashBagTest::chunk;
            this.payloads.chunk_empty = ImmutableHashBagTest::chunk_empty;
            this.payloads.chunk_single = ImmutableHashBagTest::chunk_single;
            this.payloads.empty = ImmutableHashBagTest::empty;
            this.payloads.notEmpty = ImmutableHashBagTest::notEmpty;
            this.payloads.aggregateByMutating = ImmutableHashBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableHashBagTest::aggregateByNonMutating;
            this.payloads.reduceOptional = ImmutableHashBagTest::reduceOptional;
            this.payloads.equalsAndHashCode = ImmutableHashBagTest::equalsAndHashCode;
            this.payloads.anySatisfyWithOccurrences = ImmutableHashBagTest::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableHashBagTest::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableHashBagTest::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableHashBagTest::detectWithOccurrences;
            this.payloads.newWith = ImmutableHashBagTest::newWith;
            this.payloads.newWithout = ImmutableHashBagTest::newWithout;
            this.payloads.newWithAll = ImmutableHashBagTest::newWithAll;
            this.payloads.toStringOfItemToCount = ImmutableHashBagTest::toStringOfItemToCount;
            this.payloads.newWithoutAll = ImmutableHashBagTest::newWithoutAll;
            this.payloads.contains = ImmutableHashBagTest::contains;
            this.payloads.containsAllArray = ImmutableHashBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableHashBagTest::containsAllIterable;
            this.payloads.add = ImmutableHashBagTest::add;
            this.payloads.remove = ImmutableHashBagTest::remove;
            this.payloads.addAll = ImmutableHashBagTest::addAll;
            this.payloads.removeAll = ImmutableHashBagTest::removeAll;
            this.payloads.retainAll = ImmutableHashBagTest::retainAll;
            this.payloads.clear = ImmutableHashBagTest::clear;
            this.payloads.tap = ImmutableHashBagTest::tap;
            this.payloads.forEach = ImmutableHashBagTest::forEach;
            this.payloads.forEachWith = ImmutableHashBagTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableHashBagTest::forEachWithIndex;
            this.payloads.collectWithOccurrences = ImmutableHashBagTest::collectWithOccurrences;
            this.payloads.selectByOccurrences = ImmutableHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableHashBagTest::selectDuplicates;
            this.payloads.select = ImmutableHashBagTest::select;
            this.payloads.selectWith = ImmutableHashBagTest::selectWith;
            this.payloads.selectWithToTarget = ImmutableHashBagTest::selectWithToTarget;
            this.payloads.selectToTarget = ImmutableHashBagTest::selectToTarget;
            this.payloads.reject = ImmutableHashBagTest::reject;
            this.payloads.rejectWith = ImmutableHashBagTest::rejectWith;
            this.payloads.rejectWithToTarget = ImmutableHashBagTest::rejectWithToTarget;
            this.payloads.rejectToTarget = ImmutableHashBagTest::rejectToTarget;
            this.payloads.partition = ImmutableHashBagTest::partition;
            this.payloads.partitionWith = ImmutableHashBagTest::partitionWith;
            this.payloads.collect = ImmutableHashBagTest::collect;
            this.payloads.collectBooleanWithTarget = ImmutableHashBagTest::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableHashBagTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableHashBagTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableHashBagTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableHashBagTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableHashBagTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableHashBagTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableHashBagTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableHashBagTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableHashBagTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableHashBagTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableHashBagTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableHashBagTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableHashBagTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableHashBagTest::collectShortWithTarget;
            this.payloads.collectWith = ImmutableHashBagTest::collectWith;
            this.payloads.collectWith_target = ImmutableHashBagTest::collectWith_target;
            this.payloads.collect_target = ImmutableHashBagTest::collect_target;
            this.payloads.flatCollect = ImmutableHashBagTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableHashBagTest::flatCollectWithTarget;
            this.payloads.detect = ImmutableHashBagTest::detect;
            this.payloads.detectWith = ImmutableHashBagTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableHashBagTest::detectWithIfNone;
            this.payloads.zip = ImmutableHashBagTest::zip;
            this.payloads.zipWithIndex = ImmutableHashBagTest::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableHashBagTest::chunk_large_size;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableHashBagTest::min;
            this.payloads.max = ImmutableHashBagTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableHashBagTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableHashBagTest::max_without_comparator;
            this.payloads.minBy = ImmutableHashBagTest::minBy;
            this.payloads.maxBy = ImmutableHashBagTest::maxBy;
            this.payloads.detectIfNone = ImmutableHashBagTest::detectIfNone;
            this.payloads.allSatisfy = ImmutableHashBagTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableHashBagTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableHashBagTest::noneSatisfy;
            this.payloads.count = ImmutableHashBagTest::count;
            this.payloads.countWith = ImmutableHashBagTest::countWith;
            this.payloads.collectIf = ImmutableHashBagTest::collectIf;
            this.payloads.collectIfWithTarget = ImmutableHashBagTest::collectIfWithTarget;
            this.payloads.getFirst = ImmutableHashBagTest::getFirst;
            this.payloads.getLast = ImmutableHashBagTest::getLast;
            this.payloads.isEmpty = ImmutableHashBagTest::isEmpty;
            this.payloads.iterator = ImmutableHashBagTest::iterator;
            this.payloads.injectInto = ImmutableHashBagTest::injectInto;
            this.payloads.injectIntoInt = ImmutableHashBagTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableHashBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableHashBagTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableHashBagTest::sumFloat;
            this.payloads.sumDouble = ImmutableHashBagTest::sumDouble;
            this.payloads.sumInteger = ImmutableHashBagTest::sumInteger;
            this.payloads.sumLong = ImmutableHashBagTest::sumLong;
            this.payloads.toArray = ImmutableHashBagTest::toArray;
            this.payloads.testToString = ImmutableHashBagTest::testToString;
            this.payloads.toList = ImmutableHashBagTest::toList;
            this.payloads.toSortedList = ImmutableHashBagTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableHashBagTest::toSortedListBy;
            this.payloads.forLoop = ImmutableHashBagTest::forLoop;
            this.payloads.iteratorRemove = ImmutableHashBagTest::iteratorRemove;
            this.payloads.toMapOfItemToCount = ImmutableHashBagTest::toMapOfItemToCount;
            this.payloads.toImmutable = ImmutableHashBagTest::toImmutable;
            this.payloads.countBy = ImmutableHashBagTest::countBy;
            this.payloads.countByWith = ImmutableHashBagTest::countByWith;
            this.payloads.countByEach = ImmutableHashBagTest::countByEach;
            this.payloads.groupBy = ImmutableHashBagTest::groupBy;
            this.payloads.groupBy_with_target = ImmutableHashBagTest::groupBy_with_target;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableHashBagTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.toSet = ImmutableHashBagTest::toSet;
            this.payloads.toBag = ImmutableHashBagTest::toBag;
            this.payloads.toMap = ImmutableHashBagTest::toMap;
            this.payloads.toMapTarget = ImmutableHashBagTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableHashBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableHashBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableHashBagTest::toSortedMapBy;
            this.payloads.asLazy = ImmutableHashBagTest::asLazy;
            this.payloads.makeString = ImmutableHashBagTest::makeString;
            this.payloads.appendString = ImmutableHashBagTest::appendString;
            this.payloads.appendString_with_separator = ImmutableHashBagTest::appendString_with_separator;
            this.payloads.appendString_with_start_separator_end = ImmutableHashBagTest::appendString_with_start_separator_end;
            this.payloads.serialization = ImmutableHashBagTest::serialization;
            this.payloads.toSortedBag = ImmutableHashBagTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableHashBagTest::toSortedBagBy;
            this.payloads.distinctView = ImmutableHashBagTest::distinctView;
            this.payloads.testSize = ImmutableHashBagTest::testSize;
            this.payloads.selectInstancesOf = ImmutableHashBagTest::selectInstancesOf;
            this.payloads.collectBoolean = ImmutableHashBagTest::collectBoolean;
            this.payloads.testNewBag = ImmutableHashBagTest::testNewBag;
            this.payloads.groupByEach = ImmutableHashBagTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableHashBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_target = ImmutableHashBagTest::groupByUniqueKey_target;
            this.payloads.topOccurrences = ImmutableHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableHashBagTest::bottomOccurrences;
            this.payloads.selectUnique = ImmutableHashBagTest::selectUnique;
        }
    }
}
