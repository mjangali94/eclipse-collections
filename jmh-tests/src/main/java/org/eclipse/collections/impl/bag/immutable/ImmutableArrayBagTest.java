/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iBag;

public class ImmutableArrayBagTest extends ImmutableBagTestCase {

    @Override
    protected ImmutableBag<String> newBag() {
        return ImmutableArrayBag.newBagWith("1", "2", "2", "3", "3", "3", "4", "4", "4", "4");
    }

    @SafeVarargs
    @Override
    protected final <T> ImmutableBag<T> newWith(T... littleElements) {
        return ImmutableArrayBag.newBagWith(littleElements);
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
    @Test
    public void newWith() {
        super.newWith();
        int maximumUsefulArrayBagSize = ImmutableArrayBag.MAXIMUM_USEFUL_ARRAY_BAG_SIZE;
        Verify.assertInstanceOf(ImmutableArrayBag.class, Bags.immutable.ofAll(Interval.oneTo(maximumUsefulArrayBagSize - 1)).newWith(maximumUsefulArrayBagSize));
        Verify.assertInstanceOf(ImmutableHashBag.class, Bags.immutable.ofAll(Interval.oneTo(maximumUsefulArrayBagSize)).newWith(maximumUsefulArrayBagSize + 1));
        Interval items = Interval.oneTo(maximumUsefulArrayBagSize);
        Verify.assertInstanceOf(ImmutableHashBag.class, new ImmutableArrayBag<>(items.toArray(), items.toIntArray()).newWith(maximumUsefulArrayBagSize + 1));
    }

    @Override
    @Test
    public void newWithout() {
        super.newWithout();
        ImmutableBag<String> bag = this.newBag();
        ImmutableBag<String> newBag2 = bag.newWithout("2").newWithout("2");
        Assert.assertNotEquals(bag, newBag2);
        Assert.assertEquals(newBag2.size(), bag.size() - 2);
        Assert.assertEquals(3, newBag2.sizeDistinct());
        ImmutableBag<String> newBag3 = bag.newWithout("3").newWithout("3").newWithout("3");
        Assert.assertNotEquals(bag, newBag3);
        Assert.assertEquals(newBag3.size(), bag.size() - 3);
        Assert.assertEquals(3, newBag3.sizeDistinct());
        ImmutableBag<String> newBag4 = bag.newWithout("4").newWithout("4").newWithout("4").newWithout("4");
        Assert.assertNotEquals(bag, newBag4);
        Assert.assertEquals(newBag4.size(), bag.size() - 4);
        Assert.assertEquals(3, newBag4.sizeDistinct());
        ImmutableBag<String> newBag5 = bag.newWithout("5");
        Assert.assertEquals(bag, newBag5);
    }

    @Override
    public void toStringOfItemToCount() {
        String actual = ImmutableArrayBag.newBagWith("1", "2", "2").toStringOfItemToCount();
        Assert.assertTrue("{1=1, 2=2}".equals(actual) || "{2=2, 1=1}".equals(actual));
    }

    @Override
    @Test
    public void toMap() {
        super.toMap();
        ImmutableBag<String> integers = this.newBag();
        MutableMap<String, String> map = integers.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1", "2", "2", "3", "3", "4", "4"), map);
    }

    @Test
    public void testNewBag() {
        for (int i = 1; i <= ImmutableArrayBag.MAXIMUM_USEFUL_ARRAY_BAG_SIZE + 1; i++) {
            Interval interval = Interval.oneTo(i);
            Verify.assertEqualsAndHashCode(HashBag.newBag(interval), Bags.immutable.ofAll(interval));
        }
        Assert.assertThrows(IllegalArgumentException.class, () -> new ImmutableArrayBag<>(new Integer[] { 2, 3 }, new int[] { 2 }));
    }

    @Override
    @Test
    public void selectInstancesOf() {
        super.selectInstancesOf();
        ImmutableBag<Number> numbers = ImmutableArrayBag.newBagWith(1, 2.0, 2.0, 3, 3, 3, 4.0, 4.0, 4.0, 4.0);
        Assert.assertEquals(iBag(1, 3, 3, 3), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(iBag(2.0, 2.0, 4.0, 4.0, 4.0, 4.0), numbers.selectInstancesOf(Double.class));
    }

    @Override
    @Test
    public void groupByUniqueKey() {
        // Only works on bags without duplicates
        ImmutableBag<Integer> immutableBag = ImmutableArrayBag.newBagWith(1, 2, 3);
        Assert.assertEquals(Maps.immutable.of(1, 1, 2, 2, 3, 3), immutableBag.groupByUniqueKey(id -> id));
    }

    @Override
    @Test
    public void groupByUniqueKey_target() {
        // Only works on bags without duplicates
        ImmutableBag<Integer> immutableBag = ImmutableArrayBag.newBagWith(1, 2, 3);
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
        ImmutableBag<String> strings = ImmutableArrayBag.copyFrom(mutable);
        ImmutableList<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Verify.assertIterableSize(5, top5);
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertIterableSize(0, ImmutableArrayBag.newBagWith().topOccurrences(5));
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
        ImmutableBag<String> strings = ImmutableArrayBag.copyFrom(mutable);
        ImmutableList<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Verify.assertIterableSize(5, bottom5);
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertIterableSize(0, ImmutableArrayBag.newBagWith().bottomOccurrences(5));
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

    @Override
    @Test
    public void distinctView() {
        ImmutableBag<String> bag = this.newBag();
        RichIterable<String> expected = bag.toSet();
        RichIterable<String> actual = bag.distinctView();
        // this assertion is a reminder to get rid of this test override once distinctView returns a set
        Assert.assertNotEquals(expected, actual);
        Verify.assertIterablesEqual(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableArrayBagTest instance;

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
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
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
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
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
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableArrayBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> rejectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupBy_with_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> appendString_with_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> appendString_with_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> testNewBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableArrayBagTest> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ImmutableArrayBagTest::testNewCollection;
            this.payloads.containsBy = ImmutableArrayBagTest::containsBy;
            this.payloads.containsAnyIterable = ImmutableArrayBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableArrayBagTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableArrayBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableArrayBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = ImmutableArrayBagTest::containsAllCollection;
            this.payloads.selectWith_target = ImmutableArrayBagTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableArrayBagTest::rejectWith_target;
            this.payloads.collectTarget = ImmutableArrayBagTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ImmutableArrayBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ImmutableArrayBagTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ImmutableArrayBagTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ImmutableArrayBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ImmutableArrayBagTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ImmutableArrayBagTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ImmutableArrayBagTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ImmutableArrayBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ImmutableArrayBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ImmutableArrayBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ImmutableArrayBagTest::flatCollectByte;
            this.payloads.flatCollectShort = ImmutableArrayBagTest::flatCollectShort;
            this.payloads.flatCollectInt = ImmutableArrayBagTest::flatCollectInt;
            this.payloads.flatCollectChar = ImmutableArrayBagTest::flatCollectChar;
            this.payloads.flatCollectLong = ImmutableArrayBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = ImmutableArrayBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ImmutableArrayBagTest::flatCollectFloat;
            this.payloads.detectOptional = ImmutableArrayBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minOptional = ImmutableArrayBagTest::minOptional;
            this.payloads.maxOptional = ImmutableArrayBagTest::maxOptional;
            this.payloads.min_null_safe = ImmutableArrayBagTest::min_null_safe;
            this.payloads.max_null_safe = ImmutableArrayBagTest::max_null_safe;
            this.payloads.minByOptional = ImmutableArrayBagTest::minByOptional;
            this.payloads.maxByOptional = ImmutableArrayBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ImmutableArrayBagTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = ImmutableArrayBagTest::detectWithIfNoneBlock;
            this.payloads.allSatisfyWith = ImmutableArrayBagTest::allSatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableArrayBagTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableArrayBagTest::anySatisfyWith;
            this.payloads.getAny = ImmutableArrayBagTest::getAny;
            this.payloads.getOnly = ImmutableArrayBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.summarizeFloat = ImmutableArrayBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ImmutableArrayBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ImmutableArrayBagTest::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = ImmutableArrayBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ImmutableArrayBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ImmutableArrayBagTest::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = ImmutableArrayBagTest::summarizeInt;
            this.payloads.summarizeLong = ImmutableArrayBagTest::summarizeLong;
            this.payloads.sumByInt = ImmutableArrayBagTest::sumByInt;
            this.payloads.sumByFloat = ImmutableArrayBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableArrayBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableArrayBagTest::sumByLong;
            this.payloads.sumByDouble = ImmutableArrayBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableArrayBagTest::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = ImmutableArrayBagTest::toImmutableList;
            this.payloads.toCollection = ImmutableArrayBagTest::toCollection;
            this.payloads.toImmutableBag = ImmutableArrayBagTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ImmutableArrayBagTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ImmutableArrayBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableArrayBagTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ImmutableArrayBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ImmutableArrayBagTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ImmutableArrayBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableArrayBagTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ImmutableArrayBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ImmutableArrayBagTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ImmutableArrayBagTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableArrayBagTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ImmutableArrayBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableArrayBagTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ImmutableArrayBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableArrayBagTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ImmutableArrayBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ImmutableArrayBagTest::toImmutableSet;
            this.payloads.toImmutableMap = ImmutableArrayBagTest::toImmutableMap;
            this.payloads.toBiMap = ImmutableArrayBagTest::toBiMap;
            this.payloads.toImmutableBiMap = ImmutableArrayBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ImmutableArrayBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableArrayBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ImmutableArrayBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ImmutableArrayBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableArrayBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ImmutableArrayBagTest::appendStringThrows;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk = ImmutableArrayBagTest::chunk;
            this.payloads.chunk_empty = ImmutableArrayBagTest::chunk_empty;
            this.payloads.chunk_single = ImmutableArrayBagTest::chunk_single;
            this.payloads.empty = ImmutableArrayBagTest::empty;
            this.payloads.notEmpty = ImmutableArrayBagTest::notEmpty;
            this.payloads.aggregateByMutating = ImmutableArrayBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableArrayBagTest::aggregateByNonMutating;
            this.payloads.reduceOptional = ImmutableArrayBagTest::reduceOptional;
            this.payloads.equalsAndHashCode = ImmutableArrayBagTest::equalsAndHashCode;
            this.payloads.anySatisfyWithOccurrences = ImmutableArrayBagTest::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableArrayBagTest::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableArrayBagTest::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableArrayBagTest::detectWithOccurrences;
            this.payloads.newWithAll = ImmutableArrayBagTest::newWithAll;
            this.payloads.toStringOfItemToCount = ImmutableArrayBagTest::toStringOfItemToCount;
            this.payloads.newWithoutAll = ImmutableArrayBagTest::newWithoutAll;
            this.payloads.contains = ImmutableArrayBagTest::contains;
            this.payloads.containsAllArray = ImmutableArrayBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableArrayBagTest::containsAllIterable;
            this.payloads.add = ImmutableArrayBagTest::add;
            this.payloads.remove = ImmutableArrayBagTest::remove;
            this.payloads.addAll = ImmutableArrayBagTest::addAll;
            this.payloads.removeAll = ImmutableArrayBagTest::removeAll;
            this.payloads.retainAll = ImmutableArrayBagTest::retainAll;
            this.payloads.clear = ImmutableArrayBagTest::clear;
            this.payloads.tap = ImmutableArrayBagTest::tap;
            this.payloads.forEach = ImmutableArrayBagTest::forEach;
            this.payloads.forEachWith = ImmutableArrayBagTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableArrayBagTest::forEachWithIndex;
            this.payloads.collectWithOccurrences = ImmutableArrayBagTest::collectWithOccurrences;
            this.payloads.selectByOccurrences = ImmutableArrayBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = ImmutableArrayBagTest::selectDuplicates;
            this.payloads.select = ImmutableArrayBagTest::select;
            this.payloads.selectWith = ImmutableArrayBagTest::selectWith;
            this.payloads.selectWithToTarget = ImmutableArrayBagTest::selectWithToTarget;
            this.payloads.selectToTarget = ImmutableArrayBagTest::selectToTarget;
            this.payloads.reject = ImmutableArrayBagTest::reject;
            this.payloads.rejectWith = ImmutableArrayBagTest::rejectWith;
            this.payloads.rejectWithToTarget = ImmutableArrayBagTest::rejectWithToTarget;
            this.payloads.rejectToTarget = ImmutableArrayBagTest::rejectToTarget;
            this.payloads.partition = ImmutableArrayBagTest::partition;
            this.payloads.partitionWith = ImmutableArrayBagTest::partitionWith;
            this.payloads.collect = ImmutableArrayBagTest::collect;
            this.payloads.collectBoolean = ImmutableArrayBagTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableArrayBagTest::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableArrayBagTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableArrayBagTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableArrayBagTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableArrayBagTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableArrayBagTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableArrayBagTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableArrayBagTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableArrayBagTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableArrayBagTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableArrayBagTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableArrayBagTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableArrayBagTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableArrayBagTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableArrayBagTest::collectShortWithTarget;
            this.payloads.collectWith = ImmutableArrayBagTest::collectWith;
            this.payloads.collectWith_target = ImmutableArrayBagTest::collectWith_target;
            this.payloads.collect_target = ImmutableArrayBagTest::collect_target;
            this.payloads.flatCollect = ImmutableArrayBagTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableArrayBagTest::flatCollectWithTarget;
            this.payloads.detect = ImmutableArrayBagTest::detect;
            this.payloads.detectWith = ImmutableArrayBagTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableArrayBagTest::detectWithIfNone;
            this.payloads.zip = ImmutableArrayBagTest::zip;
            this.payloads.zipWithIndex = ImmutableArrayBagTest::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableArrayBagTest::chunk_large_size;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableArrayBagTest::min;
            this.payloads.max = ImmutableArrayBagTest::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableArrayBagTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableArrayBagTest::max_without_comparator;
            this.payloads.minBy = ImmutableArrayBagTest::minBy;
            this.payloads.maxBy = ImmutableArrayBagTest::maxBy;
            this.payloads.detectIfNone = ImmutableArrayBagTest::detectIfNone;
            this.payloads.allSatisfy = ImmutableArrayBagTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableArrayBagTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableArrayBagTest::noneSatisfy;
            this.payloads.count = ImmutableArrayBagTest::count;
            this.payloads.countWith = ImmutableArrayBagTest::countWith;
            this.payloads.collectIf = ImmutableArrayBagTest::collectIf;
            this.payloads.collectIfWithTarget = ImmutableArrayBagTest::collectIfWithTarget;
            this.payloads.getFirst = ImmutableArrayBagTest::getFirst;
            this.payloads.getLast = ImmutableArrayBagTest::getLast;
            this.payloads.isEmpty = ImmutableArrayBagTest::isEmpty;
            this.payloads.iterator = ImmutableArrayBagTest::iterator;
            this.payloads.injectInto = ImmutableArrayBagTest::injectInto;
            this.payloads.injectIntoInt = ImmutableArrayBagTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableArrayBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableArrayBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableArrayBagTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableArrayBagTest::sumFloat;
            this.payloads.sumDouble = ImmutableArrayBagTest::sumDouble;
            this.payloads.sumInteger = ImmutableArrayBagTest::sumInteger;
            this.payloads.sumLong = ImmutableArrayBagTest::sumLong;
            this.payloads.toArray = ImmutableArrayBagTest::toArray;
            this.payloads.testToString = ImmutableArrayBagTest::testToString;
            this.payloads.toList = ImmutableArrayBagTest::toList;
            this.payloads.toSortedList = ImmutableArrayBagTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableArrayBagTest::toSortedListBy;
            this.payloads.forLoop = ImmutableArrayBagTest::forLoop;
            this.payloads.iteratorRemove = ImmutableArrayBagTest::iteratorRemove;
            this.payloads.toMapOfItemToCount = ImmutableArrayBagTest::toMapOfItemToCount;
            this.payloads.toImmutable = ImmutableArrayBagTest::toImmutable;
            this.payloads.countBy = ImmutableArrayBagTest::countBy;
            this.payloads.countByWith = ImmutableArrayBagTest::countByWith;
            this.payloads.countByEach = ImmutableArrayBagTest::countByEach;
            this.payloads.groupBy = ImmutableArrayBagTest::groupBy;
            this.payloads.groupBy_with_target = ImmutableArrayBagTest::groupBy_with_target;
            this.payloads.groupByEach = ImmutableArrayBagTest::groupByEach;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableArrayBagTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.toSet = ImmutableArrayBagTest::toSet;
            this.payloads.toBag = ImmutableArrayBagTest::toBag;
            this.payloads.toMapTarget = ImmutableArrayBagTest::toMapTarget;
            this.payloads.toSortedMap = ImmutableArrayBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableArrayBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableArrayBagTest::toSortedMapBy;
            this.payloads.asLazy = ImmutableArrayBagTest::asLazy;
            this.payloads.makeString = ImmutableArrayBagTest::makeString;
            this.payloads.appendString = ImmutableArrayBagTest::appendString;
            this.payloads.appendString_with_separator = ImmutableArrayBagTest::appendString_with_separator;
            this.payloads.appendString_with_start_separator_end = ImmutableArrayBagTest::appendString_with_start_separator_end;
            this.payloads.serialization = ImmutableArrayBagTest::serialization;
            this.payloads.toSortedBag = ImmutableArrayBagTest::toSortedBag;
            this.payloads.toSortedBagBy = ImmutableArrayBagTest::toSortedBagBy;
            this.payloads.testSize = ImmutableArrayBagTest::testSize;
            this.payloads.newWith = ImmutableArrayBagTest::newWith;
            this.payloads.newWithout = ImmutableArrayBagTest::newWithout;
            this.payloads.toMap = ImmutableArrayBagTest::toMap;
            this.payloads.testNewBag = ImmutableArrayBagTest::testNewBag;
            this.payloads.selectInstancesOf = ImmutableArrayBagTest::selectInstancesOf;
            this.payloads.groupByUniqueKey = ImmutableArrayBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_target = ImmutableArrayBagTest::groupByUniqueKey_target;
            this.payloads.topOccurrences = ImmutableArrayBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableArrayBagTest::bottomOccurrences;
            this.payloads.selectUnique = ImmutableArrayBagTest::selectUnique;
            this.payloads.distinctView = ImmutableArrayBagTest::distinctView;
        }
    }
}
