/*
 * Copyright (c) 2018 Goldman Sachs and others.
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
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testFactory() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testFactory, this.description("testFactory"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWithOccurrences, this.description("anySatisfyWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWithOccurrences, this.description("allSatisfyWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWithOccurrences, this.description("noneSatisfyWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithOccurrences, this.description("detectWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWith, this.description("newWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectDuplicates, this.description("selectDuplicates"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithOccurrences, this.description("collectWithOccurrences"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSize, this.description("testSize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithout, this.description("newWithout"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNone, this.description("detectWithIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWith, this.description("noneSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirst, this.description("getFirst"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min, this.description("min"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max, this.description("max"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_null_throws, this.description("min_null_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_null_throws, this.description("max_null_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_without_comparator, this.description("min_without_comparator"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_without_comparator, this.description("max_without_comparator"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_null_throws_without_comparator, this.description("min_null_throws_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_null_throws_without_comparator, this.description("max_null_throws_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::minBy, this.description("minBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::maxBy, this.description("maxBy"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipWithIndex, this.description("zipWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk, this.description("chunk"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::chunk_zero_throws, this.description("chunk_zero_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk_large_size, this.description("chunk_large_size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMap, this.description("toSortedMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMap_with_comparator, this.description("toSortedMap_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMapBy, this.description("toSortedMapBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialization, this.description("serialization"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBooleanWithTarget, this.description("collectBooleanWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_target, this.description("collect_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith_target, this.description("collectWith_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey, this.description("groupByUniqueKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_throws, this.description("groupByUniqueKey_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_target, this.description("groupByUniqueKey_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_target_throws, this.description("groupByUniqueKey_target_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByEach, this.description("countByEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countByEach_target, this.description("countByEach_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag, this.description("toSortedBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_empty, this.description("toSortedBag_empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy_empty, this.description("toSortedBagBy_empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectUnique, this.description("selectUnique"));
        }

        private ImmutableEmptyBagTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableEmptyBagTest();
        }

        @java.lang.Override
        public ImmutableEmptyBagTest implementation() {
            return this.implementation;
        }
    }
}
