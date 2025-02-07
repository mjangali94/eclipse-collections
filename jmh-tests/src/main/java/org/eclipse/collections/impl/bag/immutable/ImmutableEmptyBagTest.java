/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.immutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.partition.bag.PartitionImmutableBag;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iBag;

public class ImmutableEmptyBagTest extends ImmutableBagTestCase {

    public static final Predicate<String> ERROR_THROWING_PREDICATE = each -> {
        throw new AssertionError();
    };

    public static final Predicates2<String, Class<Integer>> ERROR_THROWING_PREDICATE_2 = new Predicates2<String, Class<Integer>>() {

        public boolean accept(String argument1, Class<Integer> argument2) {
            throw new AssertionError();
        }
    };

    @Override
    protected ImmutableBag<String> newBag() {
        return (ImmutableBag<String>) ImmutableEmptyBag.INSTANCE;
    }

    @Override
    protected int numKeys() {
        return 0;
    }

    @Test
    public void testFactory() {
        Verify.assertInstanceOf(ImmutableEmptyBag.class, Bags.immutable.of());
    }

    @Override
    @Test
    public void anySatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> true));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> false));
    }

    @Override
    @Test
    public void allSatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> true));
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> false));
    }

    @Override
    @Test
    public void noneSatisfyWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> true));
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> false));
    }

    @Override
    @Test
    public void detectWithOccurrences() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> true));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> false));
    }

    @Test
    @Override
    public void newWith() {
        ImmutableBag<String> bag = this.newBag();
        ImmutableBag<String> newBag = bag.newWith("1");
        Assert.assertNotEquals(bag, newBag);
        Assert.assertEquals(newBag.size(), bag.size() + 1);
        ImmutableBag<String> newBag2 = bag.newWith("5");
        Assert.assertNotEquals(bag, newBag2);
        Assert.assertEquals(newBag2.size(), bag.size() + 1);
        Assert.assertEquals(1, newBag2.sizeDistinct());
    }

    @Override
    @Test
    public void selectDuplicates() {
        Assert.assertEquals(Bags.immutable.empty(), this.newBag().selectDuplicates());
    }

    @Test
    @Override
    public void select() {
        ImmutableBag<String> strings = this.newBag();
        Verify.assertIterableEmpty(strings.select(Predicates.lessThan("0")));
    }

    @Test
    @Override
    public void reject() {
        ImmutableBag<String> strings = this.newBag();
        Verify.assertIterableEmpty(strings.reject(Predicates.greaterThan("0")));
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithOccurrences() {
        Bag<String> bag = this.newBag();
        Bag<ObjectIntPair<String>> actual = bag.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Bag<ObjectIntPair<String>> expected = Bags.immutable.empty();
        Assert.assertEquals(expected, actual);
        Set<ObjectIntPair<String>> actual2 = bag.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        ImmutableSet<ObjectIntPair<String>> expected2 = Sets.immutable.empty();
        Assert.assertEquals(expected2, actual2);
    }

    @Override
    public void partition() {
        PartitionImmutableBag<String> partition = this.newBag().partition(Predicates.lessThan("0"));
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
    }

    @Override
    public void partitionWith() {
        PartitionImmutableBag<String> partition = this.newBag().partitionWith(Predicates2.lessThan(), "0");
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
    }

    @Override
    @Test
    public void selectInstancesOf() {
        ImmutableBag<Number> numbers = Bags.immutable.of();
        Assert.assertEquals(iBag(), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(iBag(), numbers.selectInstancesOf(Double.class));
        Assert.assertEquals(iBag(), numbers.selectInstancesOf(Number.class));
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[]", this.newBag().toString());
    }

    @Override
    @Test
    public void testSize() {
        Verify.assertIterableSize(0, this.newBag());
    }

    @Override
    @Test
    public void newWithout() {
        Assert.assertSame(this.newBag(), this.newBag().newWithout("1"));
    }

    @Override
    public void toStringOfItemToCount() {
        Assert.assertEquals("{}", Bags.immutable.of().toStringOfItemToCount());
    }

    @Override
    @Test
    public void detect() {
        Assert.assertNull(this.newBag().detect("1"::equals));
    }

    @Override
    @Test
    public void detectWith() {
        Assert.assertNull(this.newBag().detectWith(Predicates2.greaterThan(), "3"));
    }

    @Override
    @Test
    public void detectWithIfNone() {
        Assert.assertEquals("Not Found", this.newBag().detectWithIfNone(Object::equals, "1", new PassThruFunction0<>("Not Found")));
    }

    @Override
    public void detectIfNone() {
        super.detectIfNone();
        Assert.assertEquals("Not Found", this.newBag().detectIfNone("2"::equals, new PassThruFunction0<>("Not Found")));
    }

    @Override
    @Test
    public void allSatisfy() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertTrue(strings.allSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertFalse(strings.anySatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    @Test
    public void noneSatisfy() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertTrue(strings.noneSatisfy(ERROR_THROWING_PREDICATE));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertTrue(strings.allSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertFalse(strings.anySatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        ImmutableBag<String> strings = this.newBag();
        Assert.assertTrue(strings.noneSatisfyWith(ERROR_THROWING_PREDICATE_2, Integer.class));
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNull(this.newBag().getFirst());
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNull(this.newBag().getLast());
    }

    @Override
    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.newBag().getOnly());
    }

    @Override
    @Test
    public void isEmpty() {
        ImmutableBag<String> bag = this.newBag();
        Assert.assertTrue(bag.isEmpty());
        Assert.assertFalse(bag.notEmpty());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.newBag().min(String::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.newBag().max(String::compareTo);
    }

    @Test
    @Override
    public void min_null_throws() {
        super.min_null_throws();
    }

    @Test
    @Override
    public void max_null_throws() {
        super.max_null_throws();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min_without_comparator() {
        this.newBag().min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max_without_comparator() {
        this.newBag().max();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator() {
        // Not applicable for empty collections
        super.min_null_throws_without_comparator();
    }

    @Test
    @Override
    public void max_null_throws_without_comparator() {
        // Not applicable for empty collections
        super.max_null_throws_without_comparator();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.newBag().minBy(String::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.newBag().maxBy(String::valueOf);
    }

    @Override
    @Test
    public void zip() {
        ImmutableBag<String> immutableBag = this.newBag();
        List<Object> nulls = Collections.nCopies(immutableBag.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableBag.size() + 1, null);
        ImmutableBag<Pair<String, Object>> pairs = immutableBag.zip(nulls);
        Assert.assertEquals(immutableBag, pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(HashBag.newBag(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableBag<Pair<String, Object>> pairsPlusOne = immutableBag.zip(nullsPlusOne);
        Assert.assertEquals(immutableBag, pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(HashBag.newBag(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        Assert.assertEquals(immutableBag.zip(nulls), immutableBag.zip(nulls, HashBag.newBag()));
    }

    @Override
    @Test
    public void zipWithIndex() {
        ImmutableBag<String> immutableBag = this.newBag();
        ImmutableSet<Pair<String, Integer>> pairs = immutableBag.zipWithIndex();
        Assert.assertEquals(UnifiedSet.<String>newSet(), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne));
        Assert.assertEquals(UnifiedSet.<Integer>newSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableBag.zipWithIndex(), immutableBag.zipWithIndex(UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void chunk() {
        Assert.assertEquals(this.newBag(), this.newBag().chunk(2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.newBag().chunk(0);
    }

    @Override
    @Test
    public void chunk_large_size() {
        Assert.assertEquals(this.newBag(), this.newBag().chunk(10));
        Verify.assertInstanceOf(ImmutableBag.class, this.newBag().chunk(10));
    }

    @Override
    @Test
    public void toSortedMap() {
        MutableSortedMap<String, String> map = this.newBag().toSortedMap(Functions.getStringPassThru(), Functions.getStringPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
    }

    @Override
    @Test
    public void toSortedMap_with_comparator() {
        MutableSortedMap<String, String> map = this.newBag().toSortedMap(Comparators.reverseNaturalOrder(), Functions.getStringPassThru(), Functions.getStringPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
        Assert.assertEquals(Comparators.<String>reverseNaturalOrder(), map.comparator());
    }

    @Override
    @Test
    public void toSortedMapBy() {
        MutableSortedMap<String, String> map = this.newBag().toSortedMapBy(Integer::valueOf, Functions.getStringPassThru(), Functions.getStringPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
    }

    @Override
    @Test
    public void serialization() {
        ImmutableBag<String> bag = this.newBag();
        Verify.assertPostSerializedIdentity(bag);
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableBooleanBag result = this.newBag().collectBoolean("4"::equals);
        Assert.assertEquals(0, result.sizeDistinct());
        Assert.assertEquals(0, result.occurrencesOf(true));
        Assert.assertEquals(0, result.occurrencesOf(false));
    }

    @Override
    @Test
    public void collectBooleanWithTarget() {
        BooleanHashBag target = new BooleanHashBag();
        BooleanHashBag result = this.newBag().collectBoolean("4"::equals, target);
        Assert.assertSame("Target sent as parameter not returned", target, result);
        Assert.assertEquals(0, result.sizeDistinct());
        Assert.assertEquals(0, result.occurrencesOf(true));
        Assert.assertEquals(0, result.occurrencesOf(false));
    }

    @Override
    @Test
    public void collect_target() {
        MutableList<Integer> targetCollection = FastList.newList();
        MutableList<Integer> actual = this.newBag().collect(object -> {
            throw new AssertionError();
        }, targetCollection);
        Assert.assertEquals(targetCollection, actual);
        Assert.assertSame(targetCollection, actual);
    }

    @Override
    @Test
    public void collectWith_target() {
        MutableList<Integer> targetCollection = FastList.newList();
        MutableList<Integer> actual = this.newBag().collectWith((argument1, argument2) -> {
            throw new AssertionError();
        }, 1, targetCollection);
        Assert.assertEquals(targetCollection, actual);
        Assert.assertSame(targetCollection, actual);
    }

    @Override
    @Test
    public void groupByUniqueKey() {
        Assert.assertEquals(UnifiedMap.newMap().toImmutable(), this.newBag().groupByUniqueKey(id -> id));
    }

    @Override
    @Test
    public void groupByUniqueKey_throws() {
        super.groupByUniqueKey_throws();
        Assert.assertEquals(UnifiedMap.newMap().toImmutable(), this.newBag().groupByUniqueKey(id -> id));
    }

    @Override
    @Test
    public void groupByUniqueKey_target() {
        Assert.assertEquals(UnifiedMap.newMap(), this.newBag().groupByUniqueKey(id -> id, UnifiedMap.newMap()));
    }

    @Override
    @Test
    public void groupByUniqueKey_target_throws() {
        super.groupByUniqueKey_target_throws();
        Assert.assertEquals(UnifiedMap.newMap(), this.newBag().groupByUniqueKey(id -> id, UnifiedMap.newMap()));
    }

    @Test
    public void countByEach() {
        Assert.assertEquals(Bags.immutable.empty(), this.newBag().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i)));
    }

    @Test
    public void countByEach_target() {
        MutableBag<String> target = Bags.mutable.empty();
        Assert.assertEquals(target, this.newBag().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i), target));
    }

    @Override
    @Test
    public void toSortedBag() {
        ImmutableBag<String> immutableBag = this.newBag();
        MutableSortedBag<String> sortedBag = immutableBag.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBag(), sortedBag);
        MutableSortedBag<String> reverse = immutableBag.toSortedBag(Comparator.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparator.<String>reverseOrder()), reverse);
        ImmutableBag<String> immutableBag1 = this.newBag();
        MutableSortedBag<String> sortedBag1 = immutableBag1.toSortedBag(Comparator.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBag(), sortedBag1.toSortedBag());
        ImmutableBag<String> immutableBag2 = this.newBag();
        MutableSortedBag<String> sortedBag2 = immutableBag2.toSortedBag(Comparator.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparator.<String>reverseOrder()), sortedBag2);
    }

    @Test
    public void toSortedBag_empty() {
        ImmutableBag<String> immutableBag = Bags.immutable.of();
        MutableSortedBag<String> sortedBag = immutableBag.toSortedBag(Comparators.reverseNaturalOrder());
        sortedBag.addOccurrences("apple", 3);
        sortedBag.addOccurrences("orange", 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "orange", "orange", "apple", "apple", "apple"), sortedBag);
    }

    @Test
    public void toSortedBagBy_empty() {
        ImmutableBag<Integer> immutableBag = Bags.immutable.of();
        Function<Integer, Integer> function = object -> object * -1;
        MutableSortedBag<Integer> sortedBag = immutableBag.toSortedBagBy(function);
        sortedBag.addOccurrences(1, 3);
        sortedBag.addOccurrences(10, 2);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(function), 10, 10, 1, 1, 1), sortedBag);
    }

    @Override
    @Test
    public void toSortedBagBy() {
        ImmutableBag<String> immutableBag = this.newBag();
        MutableSortedBag<String> sortedBag = immutableBag.toSortedBagBy(String::valueOf);
        TreeBag<Object> expectedBag = TreeBag.newBag(Comparators.byFunction(String::valueOf));
        Verify.assertSortedBagsEqual(expectedBag, sortedBag);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        ImmutableBag<String> bag = this.newBag();
        ImmutableSet<String> expected = Sets.immutable.empty();
        ImmutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableEmptyBagTest instance;

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
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
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
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
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
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testFactory);
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
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testSize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
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
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
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
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptyBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> rejectWithToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupBy_with_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> appendString_with_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> appendString_with_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> testFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> testSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> countByEach_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedBag_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedBagBy_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = ImmutableEmptyBagTest::testNewCollection;
            this.payloads.containsBy = ImmutableEmptyBagTest::containsBy;
            this.payloads.containsAnyIterable = ImmutableEmptyBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = ImmutableEmptyBagTest::containsNoneIterable;
            this.payloads.containsAnyCollection = ImmutableEmptyBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = ImmutableEmptyBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = ImmutableEmptyBagTest::containsAllCollection;
            this.payloads.selectWith_target = ImmutableEmptyBagTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableEmptyBagTest::rejectWith_target;
            this.payloads.collectTarget = ImmutableEmptyBagTest::collectTarget;
            this.payloads.collectBooleanWithBagTarget = ImmutableEmptyBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByteWithBagTarget = ImmutableEmptyBagTest::collectByteWithBagTarget;
            this.payloads.collectCharWithBagTarget = ImmutableEmptyBagTest::collectCharWithBagTarget;
            this.payloads.collectDoubleWithBagTarget = ImmutableEmptyBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithBagTarget = ImmutableEmptyBagTest::collectFloatWithBagTarget;
            this.payloads.collectIntWithBagTarget = ImmutableEmptyBagTest::collectIntWithBagTarget;
            this.payloads.collectLongWithBagTarget = ImmutableEmptyBagTest::collectLongWithBagTarget;
            this.payloads.collectShortWithBagTarget = ImmutableEmptyBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = ImmutableEmptyBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = ImmutableEmptyBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = ImmutableEmptyBagTest::flatCollectByte;
            this.payloads.flatCollectShort = ImmutableEmptyBagTest::flatCollectShort;
            this.payloads.flatCollectInt = ImmutableEmptyBagTest::flatCollectInt;
            this.payloads.flatCollectChar = ImmutableEmptyBagTest::flatCollectChar;
            this.payloads.flatCollectLong = ImmutableEmptyBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = ImmutableEmptyBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = ImmutableEmptyBagTest::flatCollectFloat;
            this.payloads.detectOptional = ImmutableEmptyBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minOptional = ImmutableEmptyBagTest::minOptional;
            this.payloads.maxOptional = ImmutableEmptyBagTest::maxOptional;
            this.payloads.min_null_safe = ImmutableEmptyBagTest::min_null_safe;
            this.payloads.max_null_safe = ImmutableEmptyBagTest::max_null_safe;
            this.payloads.minByOptional = ImmutableEmptyBagTest::minByOptional;
            this.payloads.maxByOptional = ImmutableEmptyBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = ImmutableEmptyBagTest::detectWithOptional;
            this.payloads.detectWithIfNoneBlock = ImmutableEmptyBagTest::detectWithIfNoneBlock;
            this.payloads.getAny = ImmutableEmptyBagTest::getAny;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.summarizeFloat = ImmutableEmptyBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = ImmutableEmptyBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = ImmutableEmptyBagTest::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = ImmutableEmptyBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = ImmutableEmptyBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = ImmutableEmptyBagTest::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = ImmutableEmptyBagTest::summarizeInt;
            this.payloads.summarizeLong = ImmutableEmptyBagTest::summarizeLong;
            this.payloads.sumByInt = ImmutableEmptyBagTest::sumByInt;
            this.payloads.sumByFloat = ImmutableEmptyBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableEmptyBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableEmptyBagTest::sumByLong;
            this.payloads.sumByDouble = ImmutableEmptyBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableEmptyBagTest::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = ImmutableEmptyBagTest::toImmutableList;
            this.payloads.toCollection = ImmutableEmptyBagTest::toCollection;
            this.payloads.toImmutableBag = ImmutableEmptyBagTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = ImmutableEmptyBagTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = ImmutableEmptyBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableEmptyBagTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = ImmutableEmptyBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = ImmutableEmptyBagTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = ImmutableEmptyBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableEmptyBagTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = ImmutableEmptyBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = ImmutableEmptyBagTest::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = ImmutableEmptyBagTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableEmptyBagTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = ImmutableEmptyBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableEmptyBagTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = ImmutableEmptyBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableEmptyBagTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = ImmutableEmptyBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = ImmutableEmptyBagTest::toImmutableSet;
            this.payloads.toImmutableMap = ImmutableEmptyBagTest::toImmutableMap;
            this.payloads.toBiMap = ImmutableEmptyBagTest::toBiMap;
            this.payloads.toImmutableBiMap = ImmutableEmptyBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = ImmutableEmptyBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableEmptyBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = ImmutableEmptyBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = ImmutableEmptyBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableEmptyBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = ImmutableEmptyBagTest::appendStringThrows;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = ImmutableEmptyBagTest::chunk_empty;
            this.payloads.chunk_single = ImmutableEmptyBagTest::chunk_single;
            this.payloads.empty = ImmutableEmptyBagTest::empty;
            this.payloads.notEmpty = ImmutableEmptyBagTest::notEmpty;
            this.payloads.aggregateByMutating = ImmutableEmptyBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableEmptyBagTest::aggregateByNonMutating;
            this.payloads.reduceOptional = ImmutableEmptyBagTest::reduceOptional;
            this.payloads.equalsAndHashCode = ImmutableEmptyBagTest::equalsAndHashCode;
            this.payloads.newWithAll = ImmutableEmptyBagTest::newWithAll;
            this.payloads.toStringOfItemToCount = ImmutableEmptyBagTest::toStringOfItemToCount;
            this.payloads.newWithoutAll = ImmutableEmptyBagTest::newWithoutAll;
            this.payloads.contains = ImmutableEmptyBagTest::contains;
            this.payloads.containsAllArray = ImmutableEmptyBagTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableEmptyBagTest::containsAllIterable;
            this.payloads.add = ImmutableEmptyBagTest::add;
            this.payloads.remove = ImmutableEmptyBagTest::remove;
            this.payloads.addAll = ImmutableEmptyBagTest::addAll;
            this.payloads.removeAll = ImmutableEmptyBagTest::removeAll;
            this.payloads.retainAll = ImmutableEmptyBagTest::retainAll;
            this.payloads.clear = ImmutableEmptyBagTest::clear;
            this.payloads.tap = ImmutableEmptyBagTest::tap;
            this.payloads.forEach = ImmutableEmptyBagTest::forEach;
            this.payloads.forEachWith = ImmutableEmptyBagTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptyBagTest::forEachWithIndex;
            this.payloads.selectByOccurrences = ImmutableEmptyBagTest::selectByOccurrences;
            this.payloads.selectWith = ImmutableEmptyBagTest::selectWith;
            this.payloads.selectWithToTarget = ImmutableEmptyBagTest::selectWithToTarget;
            this.payloads.selectToTarget = ImmutableEmptyBagTest::selectToTarget;
            this.payloads.rejectWith = ImmutableEmptyBagTest::rejectWith;
            this.payloads.rejectWithToTarget = ImmutableEmptyBagTest::rejectWithToTarget;
            this.payloads.rejectToTarget = ImmutableEmptyBagTest::rejectToTarget;
            this.payloads.partition = ImmutableEmptyBagTest::partition;
            this.payloads.partitionWith = ImmutableEmptyBagTest::partitionWith;
            this.payloads.collect = ImmutableEmptyBagTest::collect;
            this.payloads.collectByte = ImmutableEmptyBagTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableEmptyBagTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableEmptyBagTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableEmptyBagTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableEmptyBagTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableEmptyBagTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableEmptyBagTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableEmptyBagTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableEmptyBagTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableEmptyBagTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableEmptyBagTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableEmptyBagTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableEmptyBagTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableEmptyBagTest::collectShortWithTarget;
            this.payloads.collectWith = ImmutableEmptyBagTest::collectWith;
            this.payloads.flatCollect = ImmutableEmptyBagTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableEmptyBagTest::flatCollectWithTarget;
            this.payloads.detectIfNone = ImmutableEmptyBagTest::detectIfNone;
            this.payloads.count = ImmutableEmptyBagTest::count;
            this.payloads.countWith = ImmutableEmptyBagTest::countWith;
            this.payloads.collectIf = ImmutableEmptyBagTest::collectIf;
            this.payloads.collectIfWithTarget = ImmutableEmptyBagTest::collectIfWithTarget;
            this.payloads.iterator = ImmutableEmptyBagTest::iterator;
            this.payloads.injectInto = ImmutableEmptyBagTest::injectInto;
            this.payloads.injectIntoInt = ImmutableEmptyBagTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableEmptyBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableEmptyBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableEmptyBagTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableEmptyBagTest::sumFloat;
            this.payloads.sumDouble = ImmutableEmptyBagTest::sumDouble;
            this.payloads.sumInteger = ImmutableEmptyBagTest::sumInteger;
            this.payloads.sumLong = ImmutableEmptyBagTest::sumLong;
            this.payloads.toArray = ImmutableEmptyBagTest::toArray;
            this.payloads.toList = ImmutableEmptyBagTest::toList;
            this.payloads.toSortedList = ImmutableEmptyBagTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableEmptyBagTest::toSortedListBy;
            this.payloads.forLoop = ImmutableEmptyBagTest::forLoop;
            this.payloads.iteratorRemove = ImmutableEmptyBagTest::iteratorRemove;
            this.payloads.toMapOfItemToCount = ImmutableEmptyBagTest::toMapOfItemToCount;
            this.payloads.toImmutable = ImmutableEmptyBagTest::toImmutable;
            this.payloads.countBy = ImmutableEmptyBagTest::countBy;
            this.payloads.countByWith = ImmutableEmptyBagTest::countByWith;
            this.payloads.groupBy = ImmutableEmptyBagTest::groupBy;
            this.payloads.groupBy_with_target = ImmutableEmptyBagTest::groupBy_with_target;
            this.payloads.groupByEach = ImmutableEmptyBagTest::groupByEach;
            this.payloads.toSet = ImmutableEmptyBagTest::toSet;
            this.payloads.toBag = ImmutableEmptyBagTest::toBag;
            this.payloads.toMap = ImmutableEmptyBagTest::toMap;
            this.payloads.toMapTarget = ImmutableEmptyBagTest::toMapTarget;
            this.payloads.asLazy = ImmutableEmptyBagTest::asLazy;
            this.payloads.makeString = ImmutableEmptyBagTest::makeString;
            this.payloads.appendString = ImmutableEmptyBagTest::appendString;
            this.payloads.appendString_with_separator = ImmutableEmptyBagTest::appendString_with_separator;
            this.payloads.appendString_with_start_separator_end = ImmutableEmptyBagTest::appendString_with_start_separator_end;
            this.payloads.distinctView = ImmutableEmptyBagTest::distinctView;
            this.payloads.testFactory = ImmutableEmptyBagTest::testFactory;
            this.payloads.anySatisfyWithOccurrences = ImmutableEmptyBagTest::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableEmptyBagTest::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableEmptyBagTest::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableEmptyBagTest::detectWithOccurrences;
            this.payloads.newWith = ImmutableEmptyBagTest::newWith;
            this.payloads.selectDuplicates = ImmutableEmptyBagTest::selectDuplicates;
            this.payloads.select = ImmutableEmptyBagTest::select;
            this.payloads.reject = ImmutableEmptyBagTest::reject;
            this.payloads.collectWithOccurrences = ImmutableEmptyBagTest::collectWithOccurrences;
            this.payloads.selectInstancesOf = ImmutableEmptyBagTest::selectInstancesOf;
            this.payloads.testToString = ImmutableEmptyBagTest::testToString;
            this.payloads.testSize = ImmutableEmptyBagTest::testSize;
            this.payloads.newWithout = ImmutableEmptyBagTest::newWithout;
            this.payloads.detect = ImmutableEmptyBagTest::detect;
            this.payloads.detectWith = ImmutableEmptyBagTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableEmptyBagTest::detectWithIfNone;
            this.payloads.allSatisfy = ImmutableEmptyBagTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableEmptyBagTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableEmptyBagTest::noneSatisfy;
            this.payloads.allSatisfyWith = ImmutableEmptyBagTest::allSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableEmptyBagTest::anySatisfyWith;
            this.payloads.noneSatisfyWith = ImmutableEmptyBagTest::noneSatisfyWith;
            this.payloads.getFirst = ImmutableEmptyBagTest::getFirst;
            this.payloads.getLast = ImmutableEmptyBagTest::getLast;
            this.payloads.getOnly = ImmutableEmptyBagTest::getOnly;
            this.payloads.isEmpty = ImmutableEmptyBagTest::isEmpty;
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::min, java.util.NoSuchElementException.class);
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::max, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = ImmutableEmptyBagTest::min_null_throws;
            this.payloads.max_null_throws = ImmutableEmptyBagTest::max_null_throws;
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = ImmutableEmptyBagTest::min_null_throws_without_comparator;
            this.payloads.max_null_throws_without_comparator = ImmutableEmptyBagTest::max_null_throws_without_comparator;
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.zip = ImmutableEmptyBagTest::zip;
            this.payloads.zipWithIndex = ImmutableEmptyBagTest::zipWithIndex;
            this.payloads.chunk = ImmutableEmptyBagTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableEmptyBagTest::chunk_large_size;
            this.payloads.toSortedMap = ImmutableEmptyBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableEmptyBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableEmptyBagTest::toSortedMapBy;
            this.payloads.serialization = ImmutableEmptyBagTest::serialization;
            this.payloads.collectBoolean = ImmutableEmptyBagTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableEmptyBagTest::collectBooleanWithTarget;
            this.payloads.collect_target = ImmutableEmptyBagTest::collect_target;
            this.payloads.collectWith_target = ImmutableEmptyBagTest::collectWith_target;
            this.payloads.groupByUniqueKey = ImmutableEmptyBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = ImmutableEmptyBagTest::groupByUniqueKey_throws;
            this.payloads.groupByUniqueKey_target = ImmutableEmptyBagTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = ImmutableEmptyBagTest::groupByUniqueKey_target_throws;
            this.payloads.countByEach = ImmutableEmptyBagTest::countByEach;
            this.payloads.countByEach_target = ImmutableEmptyBagTest::countByEach_target;
            this.payloads.toSortedBag = ImmutableEmptyBagTest::toSortedBag;
            this.payloads.toSortedBag_empty = ImmutableEmptyBagTest::toSortedBag_empty;
            this.payloads.toSortedBagBy_empty = ImmutableEmptyBagTest::toSortedBagBy_empty;
            this.payloads.toSortedBagBy = ImmutableEmptyBagTest::toSortedBagBy;
            this.payloads.selectUnique = ImmutableEmptyBagTest::selectUnique;
        }
    }
}
