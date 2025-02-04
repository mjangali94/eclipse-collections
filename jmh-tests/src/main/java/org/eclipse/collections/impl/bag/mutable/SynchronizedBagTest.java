/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable;

import java.util.Set;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.SynchronizedRichIterable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.mutable.AbstractSynchronizedCollectionTestCase;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iBag;

/**
 * JUnit test for {@link SynchronizedBag}.
 */
public class SynchronizedBagTest extends AbstractSynchronizedCollectionTestCase {

    @Override
    protected <T> MutableBag<T> newWith(T... littleElements) {
        return new SynchronizedBag<>(HashBag.newBagWith(littleElements));
    }

    @Override
    @Test
    public void newEmpty() {
        super.newEmpty();
        Verify.assertInstanceOf(SynchronizedBag.class, this.newWith().newEmpty());
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getFirst());
        Assert.assertNull(this.newWith().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNotNull(this.newWith(1, 2, 3).getLast());
        Assert.assertNull(this.newWith().getLast());
    }

    @Override
    @Test
    public void groupBy() {
        RichIterable<Integer> list = this.newWith(1, 2, 3, 4, 5, 6, 7);
        Multimap<Boolean, Integer> multimap = list.groupBy(object -> IntegerPredicates.isOdd().accept(object));
        Assert.assertEquals(Bags.mutable.of(1, 3, 5, 7), multimap.get(Boolean.TRUE));
        Assert.assertEquals(Bags.mutable.of(2, 4, 6), multimap.get(Boolean.FALSE));
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedBag.class, this.newWith().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableBag.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        Verify.assertPostSerializedEqualsAndHashCode(this.newWith(1, 1, 1, 2, 2, 3));
        Verify.assertInstanceOf(SynchronizedBag.class, SerializeTestHelper.serializeDeserialize(this.newWith(1, 1, 1, 2, 2, 3)));
    }

    @Override
    @Test
    public void partition() {
        super.partition();
        MutableBag<Integer> integers = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        PartitionMutableCollection<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iBag(2, 2, 4, 4, 4, 4), result.getSelected());
        Assert.assertEquals(iBag(1, 3, 3, 3), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        super.partitionWith();
        MutableBag<Integer> integers = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        PartitionMutableCollection<Integer> result = integers.partitionWith(Predicates2.in(), integers.select(IntegerPredicates.isEven()));
        Assert.assertEquals(iBag(2, 2, 4, 4, 4, 4), result.getSelected());
        Assert.assertEquals(iBag(1, 3, 3, 3), result.getRejected());
    }

    @Test
    public void selectByOccurrences() {
        MutableBag<Integer> integers = this.newWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
        Assert.assertEquals(iBag(1, 1, 1, 1, 3, 3), integers.selectByOccurrences(IntPredicates.isEven()));
    }

    @Test
    public void selectDuplicates() {
        Assert.assertEquals(iBag(1, 1, 1, 1, 2, 2, 2, 3, 3), this.newWith(0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5).selectDuplicates());
    }

    @Test
    public void addOccurrences() {
        MutableBag<Integer> integers = this.newWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
        Assert.assertEquals(6, integers.addOccurrences(1, 2));
        Verify.assertBagsEqual(this.newWith(1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4), integers);
        Assert.assertEquals(0, integers.addOccurrences(5, 0));
        Assert.assertEquals(2, integers.addOccurrences(5, 2));
        Assert.assertEquals(3, integers.addOccurrences(3, 1));
        Verify.assertBagsEqual(this.newWith(1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5), integers);
    }

    @Test
    public void removeOccurrences() {
        MutableBag<Integer> integers = this.newWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
        Assert.assertEquals(1, integers.occurrencesOf(4));
        Assert.assertEquals(3, integers.occurrencesOf(2));
        integers.removeOccurrences(4, 1);
        integers.removeOccurrences(2, 2);
        Assert.assertEquals(0, integers.occurrencesOf(4));
        Assert.assertEquals(1, integers.occurrencesOf(2));
    }

    @Test
    public void setOccurrences() {
        MutableBag<Integer> integers = this.newWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
        Assert.assertEquals(0, integers.occurrencesOf(5));
        Assert.assertEquals(3, integers.occurrencesOf(2));
        integers.setOccurrences(5, 5);
        integers.setOccurrences(2, 2);
        Assert.assertEquals(5, integers.occurrencesOf(5));
        Assert.assertEquals(2, integers.occurrencesOf(2));
    }

    @Test
    public void toMapOfItemWithCount() {
        MutableBag<Integer> integers = this.newWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
        MapIterable<Integer, Integer> result = integers.toMapOfItemToCount();
        Assert.assertEquals(Maps.mutable.with(1, 4, 2, 3, 3, 2, 4, 1), result);
    }

    @Test
    public void toStringOfItemWithCount() {
        MutableBag<Integer> integers = this.newWith(1, 1, 1, 1);
        String result = integers.toStringOfItemToCount();
        Assert.assertEquals(Maps.mutable.with(1, 4).toString(), result);
    }

    @Test
    public void forEachWithOccurrences() {
        MutableBag<Integer> integers = this.newWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
        MutableBag<Integer> result = HashBag.newBag();
        integers.forEachWithOccurrences(result::setOccurrences);
        Assert.assertEquals(integers, result);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithOccurrences() {
        Bag<Integer> bag = this.newWith(3, 3, 3, 2, 2, 1);
        Bag<ObjectIntPair<Integer>> actual = bag.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Bag<ObjectIntPair<Integer>> expected = Bags.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1));
        Assert.assertEquals(expected, actual);
        Set<ObjectIntPair<Integer>> actual2 = bag.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        ImmutableSet<ObjectIntPair<Integer>> expected2 = Sets.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1));
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void topOccurrences() {
        MutableBag<String> strings = this.newWith();
        strings.addOccurrences("one", 1);
        strings.addOccurrences("two", 2);
        strings.addOccurrences("three", 3);
        strings.addOccurrences("four", 4);
        strings.addOccurrences("five", 5);
        strings.addOccurrences("six", 6);
        strings.addOccurrences("seven", 7);
        strings.addOccurrences("eight", 8);
        strings.addOccurrences("nine", 9);
        strings.addOccurrences("ten", 10);
        MutableList<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(2));
        Verify.assertSize(3, this.newWith("one", "one", "two", "three").topOccurrences(2));
        Verify.assertSize(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith(null, "one", "two").topOccurrences(5));
        Verify.assertSize(3, this.newWith(null, "one", "two").topOccurrences(1));
    }

    @Test
    public void bottomOccurrences() {
        MutableBag<String> strings = this.newWith();
        strings.addOccurrences("one", 1);
        strings.addOccurrences("two", 2);
        strings.addOccurrences("three", 3);
        strings.addOccurrences("four", 4);
        strings.addOccurrences("five", 5);
        strings.addOccurrences("six", 6);
        strings.addOccurrences("seven", 7);
        strings.addOccurrences("eight", 8);
        strings.addOccurrences("nine", 9);
        strings.addOccurrences("ten", 10);
        MutableList<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(2));
        Verify.assertSize(3, this.newWith("one", "one", "two", "three").topOccurrences(2));
        Verify.assertSize(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith(null, "one", "two").topOccurrences(5));
        Verify.assertSize(3, this.newWith(null, "one", "two").topOccurrences(1));
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = Bags.mutable.with("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5").asSynchronized();
        MutableSet<String> expected = Sets.mutable.with("0", "4", "5");
        MutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void distinctView() {
        MutableBag<Integer> bag = this.newWith(1, 1, 2, 3, 4, 4);
        RichIterable<Integer> expected = bag.toSet();
        RichIterable<Integer> actual = bag.distinctView();
        Verify.assertInstanceOf(SynchronizedRichIterable.class, actual);
        // not using Assert.assertEquals as actual is not a Set
        Verify.assertIterablesEqual(expected, actual);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedBagTest instance;

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
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
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
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
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
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
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
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
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
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
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
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
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
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
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
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
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
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
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
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
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
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
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
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemWithCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemWithCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemWithCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedBagTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toMapOfItemWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> toStringOfItemWithCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedBagTest> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = SynchronizedBagTest::testNewCollection;
            this.payloads.contains = SynchronizedBagTest::contains;
            this.payloads.containsBy = SynchronizedBagTest::containsBy;
            this.payloads.containsAllIterable = SynchronizedBagTest::containsAllIterable;
            this.payloads.containsAnyIterable = SynchronizedBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = SynchronizedBagTest::containsNoneIterable;
            this.payloads.containsAllArray = SynchronizedBagTest::containsAllArray;
            this.payloads.containsAnyCollection = SynchronizedBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = SynchronizedBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = SynchronizedBagTest::containsAllCollection;
            this.payloads.tap = SynchronizedBagTest::tap;
            this.payloads.forEach = SynchronizedBagTest::forEach;
            this.payloads.forEachWith = SynchronizedBagTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedBagTest::forEachWithIndex;
            this.payloads.select = SynchronizedBagTest::select;
            this.payloads.selectWith = SynchronizedBagTest::selectWith;
            this.payloads.selectWith_target = SynchronizedBagTest::selectWith_target;
            this.payloads.reject = SynchronizedBagTest::reject;
            this.payloads.rejectWith = SynchronizedBagTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedBagTest::rejectWith_target;
            this.payloads.selectInstancesOf = SynchronizedBagTest::selectInstancesOf;
            this.payloads.collect = SynchronizedBagTest::collect;
            this.payloads.collectTarget = SynchronizedBagTest::collectTarget;
            this.payloads.collectBoolean = SynchronizedBagTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = SynchronizedBagTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = SynchronizedBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = SynchronizedBagTest::collectByte;
            this.payloads.collectByteWithTarget = SynchronizedBagTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = SynchronizedBagTest::collectByteWithBagTarget;
            this.payloads.collectChar = SynchronizedBagTest::collectChar;
            this.payloads.collectCharWithTarget = SynchronizedBagTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = SynchronizedBagTest::collectCharWithBagTarget;
            this.payloads.collectDouble = SynchronizedBagTest::collectDouble;
            this.payloads.collectDoubleWithTarget = SynchronizedBagTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = SynchronizedBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = SynchronizedBagTest::collectFloat;
            this.payloads.collectFloatWithTarget = SynchronizedBagTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = SynchronizedBagTest::collectFloatWithBagTarget;
            this.payloads.collectInt = SynchronizedBagTest::collectInt;
            this.payloads.collectIntWithTarget = SynchronizedBagTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = SynchronizedBagTest::collectIntWithBagTarget;
            this.payloads.collectLong = SynchronizedBagTest::collectLong;
            this.payloads.collectLongWithTarget = SynchronizedBagTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = SynchronizedBagTest::collectLongWithBagTarget;
            this.payloads.collectShort = SynchronizedBagTest::collectShort;
            this.payloads.collectShortWithTarget = SynchronizedBagTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = SynchronizedBagTest::collectShortWithBagTarget;
            this.payloads.flatCollect = SynchronizedBagTest::flatCollect;
            this.payloads.flatCollectWith = SynchronizedBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = SynchronizedBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = SynchronizedBagTest::flatCollectByte;
            this.payloads.flatCollectShort = SynchronizedBagTest::flatCollectShort;
            this.payloads.flatCollectInt = SynchronizedBagTest::flatCollectInt;
            this.payloads.flatCollectChar = SynchronizedBagTest::flatCollectChar;
            this.payloads.flatCollectLong = SynchronizedBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = SynchronizedBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = SynchronizedBagTest::flatCollectFloat;
            this.payloads.detect = SynchronizedBagTest::detect;
            this.payloads.detectOptional = SynchronizedBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = SynchronizedBagTest::min;
            this.payloads.minOptional = SynchronizedBagTest::minOptional;
            this.payloads.max = SynchronizedBagTest::max;
            this.payloads.maxOptional = SynchronizedBagTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = SynchronizedBagTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedBagTest::max_without_comparator;
            this.payloads.min_null_safe = SynchronizedBagTest::min_null_safe;
            this.payloads.max_null_safe = SynchronizedBagTest::max_null_safe;
            this.payloads.minBy = SynchronizedBagTest::minBy;
            this.payloads.minByOptional = SynchronizedBagTest::minByOptional;
            this.payloads.maxBy = SynchronizedBagTest::maxBy;
            this.payloads.maxByOptional = SynchronizedBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = SynchronizedBagTest::detectWith;
            this.payloads.detectWithOptional = SynchronizedBagTest::detectWithOptional;
            this.payloads.detectIfNone = SynchronizedBagTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedBagTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedBagTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedBagTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedBagTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedBagTest::anySatisfyWith;
            this.payloads.count = SynchronizedBagTest::count;
            this.payloads.countWith = SynchronizedBagTest::countWith;
            this.payloads.collectIf = SynchronizedBagTest::collectIf;
            this.payloads.collectWith = SynchronizedBagTest::collectWith;
            this.payloads.collectWith_target = SynchronizedBagTest::collectWith_target;
            this.payloads.getAny = SynchronizedBagTest::getAny;
            this.payloads.getOnly = SynchronizedBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = SynchronizedBagTest::isEmpty;
            this.payloads.iterator = SynchronizedBagTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = SynchronizedBagTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedBagTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedBagTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedBagTest::sumFloat;
            this.payloads.summarizeFloat = SynchronizedBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = SynchronizedBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = SynchronizedBagTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = SynchronizedBagTest::sumDouble;
            this.payloads.summarizeDouble = SynchronizedBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = SynchronizedBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = SynchronizedBagTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = SynchronizedBagTest::sumInteger;
            this.payloads.summarizeInt = SynchronizedBagTest::summarizeInt;
            this.payloads.sumLong = SynchronizedBagTest::sumLong;
            this.payloads.summarizeLong = SynchronizedBagTest::summarizeLong;
            this.payloads.sumByInt = SynchronizedBagTest::sumByInt;
            this.payloads.sumByFloat = SynchronizedBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = SynchronizedBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = SynchronizedBagTest::sumByLong;
            this.payloads.sumByDouble = SynchronizedBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = SynchronizedBagTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = SynchronizedBagTest::toArray;
            this.payloads.toList = SynchronizedBagTest::toList;
            this.payloads.toImmutableList = SynchronizedBagTest::toImmutableList;
            this.payloads.toCollection = SynchronizedBagTest::toCollection;
            this.payloads.toBag = SynchronizedBagTest::toBag;
            this.payloads.toImmutableBag = SynchronizedBagTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedBagTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = SynchronizedBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedBagTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = SynchronizedBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = SynchronizedBagTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = SynchronizedBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedBagTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = SynchronizedBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = SynchronizedBagTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = SynchronizedBagTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = SynchronizedBagTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = SynchronizedBagTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedBagTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = SynchronizedBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedBagTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = SynchronizedBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedBagTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = SynchronizedBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = SynchronizedBagTest::toSet;
            this.payloads.toImmutableSet = SynchronizedBagTest::toImmutableSet;
            this.payloads.toMap = SynchronizedBagTest::toMap;
            this.payloads.toImmutableMap = SynchronizedBagTest::toImmutableMap;
            this.payloads.toMapTarget = SynchronizedBagTest::toMapTarget;
            this.payloads.toSortedMap = SynchronizedBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedBagTest::toSortedMapBy;
            this.payloads.toBiMap = SynchronizedBagTest::toBiMap;
            this.payloads.toImmutableBiMap = SynchronizedBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = SynchronizedBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = SynchronizedBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = SynchronizedBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = SynchronizedBagTest::appendStringThrows;
            this.payloads.countBy = SynchronizedBagTest::countBy;
            this.payloads.countByWith = SynchronizedBagTest::countByWith;
            this.payloads.countByEach = SynchronizedBagTest::countByEach;
            this.payloads.groupByEach = SynchronizedBagTest::groupByEach;
            this.payloads.groupByUniqueKey = SynchronizedBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = SynchronizedBagTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = SynchronizedBagTest::zip;
            this.payloads.zipWithIndex = SynchronizedBagTest::zipWithIndex;
            this.payloads.chunk = SynchronizedBagTest::chunk;
            this.payloads.chunk_empty = SynchronizedBagTest::chunk_empty;
            this.payloads.chunk_single = SynchronizedBagTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedBagTest::chunk_large_size;
            this.payloads.empty = SynchronizedBagTest::empty;
            this.payloads.notEmpty = SynchronizedBagTest::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedBagTest::aggregateByNonMutating;
            this.payloads.reduceOptional = SynchronizedBagTest::reduceOptional;
            this.payloads.toImmutable = SynchronizedBagTest::toImmutable;
            this.payloads.testNewWith = SynchronizedBagTest::testNewWith;
            this.payloads.testNewWithWith = SynchronizedBagTest::testNewWithWith;
            this.payloads.testNewWithWithWith = SynchronizedBagTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = SynchronizedBagTest::testNewWithVarArgs;
            this.payloads.addAll = SynchronizedBagTest::addAll;
            this.payloads.addAllIterable = SynchronizedBagTest::addAllIterable;
            this.payloads.removeAll = SynchronizedBagTest::removeAll;
            this.payloads.removeAllIterable = SynchronizedBagTest::removeAllIterable;
            this.payloads.retainAll = SynchronizedBagTest::retainAll;
            this.payloads.retainAllIterable = SynchronizedBagTest::retainAllIterable;
            this.payloads.clear = SynchronizedBagTest::clear;
            this.payloads.injectIntoWith = SynchronizedBagTest::injectIntoWith;
            this.payloads.removeObject = SynchronizedBagTest::removeObject;
            this.payloads.selectAndRejectWith = SynchronizedBagTest::selectAndRejectWith;
            this.payloads.removeIf = SynchronizedBagTest::removeIf;
            this.payloads.removeIfWith = SynchronizedBagTest::removeIfWith;
            this.payloads.with = SynchronizedBagTest::with;
            this.payloads.withAll = SynchronizedBagTest::withAll;
            this.payloads.without = SynchronizedBagTest::without;
            this.payloads.withoutAll = SynchronizedBagTest::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = SynchronizedBagTest::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = SynchronizedBagTest::asLazy;
            this.payloads.testToString = SynchronizedBagTest::testToString;
            this.payloads.makeString = SynchronizedBagTest::makeString;
            this.payloads.appendString = SynchronizedBagTest::appendString;
            this.payloads.newEmpty = SynchronizedBagTest::newEmpty;
            this.payloads.getFirst = SynchronizedBagTest::getFirst;
            this.payloads.getLast = SynchronizedBagTest::getLast;
            this.payloads.groupBy = SynchronizedBagTest::groupBy;
            this.payloads.asSynchronized = SynchronizedBagTest::asSynchronized;
            this.payloads.asUnmodifiable = SynchronizedBagTest::asUnmodifiable;
            this.payloads.equalsAndHashCode = SynchronizedBagTest::equalsAndHashCode;
            this.payloads.partition = SynchronizedBagTest::partition;
            this.payloads.partitionWith = SynchronizedBagTest::partitionWith;
            this.payloads.selectByOccurrences = SynchronizedBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = SynchronizedBagTest::selectDuplicates;
            this.payloads.addOccurrences = SynchronizedBagTest::addOccurrences;
            this.payloads.removeOccurrences = SynchronizedBagTest::removeOccurrences;
            this.payloads.setOccurrences = SynchronizedBagTest::setOccurrences;
            this.payloads.toMapOfItemWithCount = SynchronizedBagTest::toMapOfItemWithCount;
            this.payloads.toStringOfItemWithCount = SynchronizedBagTest::toStringOfItemWithCount;
            this.payloads.forEachWithOccurrences = SynchronizedBagTest::forEachWithOccurrences;
            this.payloads.collectWithOccurrences = SynchronizedBagTest::collectWithOccurrences;
            this.payloads.topOccurrences = SynchronizedBagTest::topOccurrences;
            this.payloads.bottomOccurrences = SynchronizedBagTest::bottomOccurrences;
            this.payloads.selectUnique = SynchronizedBagTest::selectUnique;
            this.payloads.distinctView = SynchronizedBagTest::distinctView;
        }
    }
*/
}
