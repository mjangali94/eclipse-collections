/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.sorted.immutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.partition.set.sorted.PartitionImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.AddToList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableEmptySortedSetTest extends AbstractImmutableSortedSetTestCase {

    @Override
    protected ImmutableSortedSet<Integer> classUnderTest() {
        return SortedSets.immutable.of();
    }

    @Override
    protected ImmutableSortedSet<Integer> classUnderTest(Comparator<? super Integer> comparator) {
        return SortedSets.immutable.of(comparator);
    }

    @Test
    public void testContainsAll() {
        Assert.assertTrue(this.classUnderTest().containsAllIterable(UnifiedSet.<Integer>newSet()));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(UnifiedSet.newSetWith(1)));
    }

    @Test
    public void testNewSortedSet() {
        Assert.assertSame(SortedSets.immutable.of(), SortedSets.immutable.ofAll(FastList.newList()));
        Assert.assertSame(SortedSets.immutable.of(), SortedSets.immutable.ofSortedSet(TreeSortedSet.newSet()));
        Assert.assertNotSame(SortedSets.immutable.of(), SortedSets.immutable.ofSortedSet(TreeSortedSet.newSet(Comparators.reverseNaturalOrder())));
    }

    @Override
    @Test
    public void newWith() {
        Assert.assertEquals(UnifiedSet.newSetWith(1), this.classUnderTest().newWith(1));
        Assert.assertSame(SortedSets.immutable.empty(), SortedSets.immutable.of(FastList.newList().toArray()));
        Assert.assertEquals(SortedSets.immutable.empty(), SortedSets.immutable.of(Comparators.naturalOrder(), FastList.newList().toArray()));
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), this.classUnderTest(Comparators.reverseNaturalOrder()).newWith(1).comparator());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2), this.classUnderTest(Comparators.reverseNaturalOrder()).newWith(1).newWith(2).castToSortedSet());
    }

    @Override
    @Test
    public void newWithout() {
        Assert.assertEquals(SortedSets.immutable.empty(), SortedSets.immutable.empty().newWithout(1));
        Assert.assertSame(SortedSets.immutable.empty(), SortedSets.immutable.empty().newWithout(1));
        Assert.assertEquals(SortedSets.immutable.empty(), SortedSets.immutable.empty().newWithoutAll(Interval.oneTo(3)));
        Assert.assertSame(SortedSets.immutable.empty(), SortedSets.immutable.empty().newWithoutAll(Interval.oneTo(3)));
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), this.classUnderTest(Comparators.reverseNaturalOrder()).newWithout(1).comparator());
    }

    @Override
    @Test
    public void detect() {
        Assert.assertNull(this.classUnderTest().detect(Integer.valueOf(1)::equals));
    }

    @Override
    @Test
    public void detectWith() {
        Assert.assertNull(this.classUnderTest().detectWith(Object::equals, Integer.valueOf(1)));
    }

    @Override
    @Test
    public void detectIndex() {
        // Any predicate will result in -1
        Assert.assertEquals(Integer.valueOf(-1), Integer.valueOf(this.classUnderTest().detectIndex(Predicates.alwaysTrue())));
    }

    @Override
    @Test
    public void corresponds() {
        // Evaluates true for all empty sets and false for all non-empty sets
        ImmutableSortedSet<Integer> integers1 = this.classUnderTest();
        Assert.assertTrue(integers1.corresponds(Lists.mutable.of(), Predicates2.alwaysFalse()));
        ImmutableSortedSet<Integer> integers2 = integers1.newWith(Integer.valueOf(1));
        Assert.assertFalse(integers2.corresponds(integers1, Predicates2.alwaysTrue()));
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(Integer.class::isInstance));
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy(Integer.class::isInstance));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void getFirst() {
        this.classUnderTest().getFirst();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void getLast() {
        this.classUnderTest().getLast();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        this.classUnderTest().getOnly();
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.classUnderTest());
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min_without_comparator() {
        this.classUnderTest().min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max_without_comparator() {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.classUnderTest().minBy(String::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.classUnderTest().maxBy(String::valueOf);
    }

    @Override
    @Test
    public void zip() {
        ImmutableSortedSet<Integer> immutableSet = this.classUnderTest(Comparators.reverseNaturalOrder());
        ImmutableList<Pair<Integer, Integer>> pairs = immutableSet.zip(Interval.oneTo(10));
        Assert.assertEquals(FastList.<Pair<Integer, Integer>>newList(), pairs);
        Assert.assertEquals(UnifiedSet.<Pair<Integer, Integer>>newSet(), immutableSet.zip(Interval.oneTo(10), UnifiedSet.newSet()));
        ImmutableList<Pair<Integer, Integer>> pairsWithExtras = pairs.newWith(Tuples.pair(1, 5)).newWith(Tuples.pair(5, 1));
        Assert.assertEquals(FastList.newListWith(Tuples.pair(1, 5), Tuples.pair(5, 1)), pairsWithExtras.toList());
    }

    @Override
    @Test
    public void zipWithIndex() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        ImmutableSortedSet<Pair<Integer, Integer>> pairs = set.zipWithIndex();
        Assert.assertEquals(UnifiedSet.<Pair<Integer, Integer>>newSet(), pairs);
        Assert.assertEquals(UnifiedSet.<Pair<Integer, Integer>>newSet(), set.zipWithIndex(UnifiedSet.newSet()));
        Assert.assertNotNull(pairs.comparator());
        ImmutableSortedSet<Pair<Integer, Integer>> pairsWithExtras = pairs.newWith(Tuples.pair(1, 5)).newWith(Tuples.pair(5, 1));
        Assert.assertEquals(FastList.newListWith(Tuples.pair(1, 5), Tuples.pair(5, 1)), pairsWithExtras.toList());
    }

    @Test
    public void chunk() {
        Verify.assertIterableEmpty(this.classUnderTest().chunk(2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.classUnderTest().chunk(0);
    }

    @Override
    @Test
    public void chunk_large_size() {
        Verify.assertIterableEmpty(this.classUnderTest().chunk(10));
    }

    @Override
    @Test
    public void union() {
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith("a", "b", "c"), SortedSets.immutable.<String>empty().union(UnifiedSet.newSetWith("a", "b", "c")).castToSortedSet());
        Verify.assertListsEqual(FastList.newListWith(3, 2, 1), this.classUnderTest(Comparators.reverseNaturalOrder()).union(UnifiedSet.newSetWith(1, 2, 3)).toList());
    }

    @Override
    @Test
    public void unionInto() {
        Assert.assertEquals(UnifiedSet.newSetWith("a", "b", "c"), SortedSets.immutable.<String>empty().unionInto(UnifiedSet.newSetWith("a", "b", "c"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void intersect() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), SortedSets.immutable.<String>empty().intersect(UnifiedSet.newSetWith("1", "2", "3")));
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), this.classUnderTest(Comparators.reverseNaturalOrder()).intersect(UnifiedSet.newSetWith(1, 2, 3)).comparator());
    }

    @Override
    @Test
    public void intersectInto() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), SortedSets.immutable.<String>empty().intersectInto(UnifiedSet.newSetWith("1", "2", "3"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void difference() {
        Assert.assertEquals(UnifiedSet.<String>newSet(), SortedSets.immutable.<String>empty().difference(UnifiedSet.newSetWith("not present")));
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), this.classUnderTest(Comparators.reverseNaturalOrder()).difference(UnifiedSet.newSetWith(1, 2, 3)).comparator());
    }

    @Override
    @Test
    public void differenceInto() {
        ImmutableSortedSet<String> set = SortedSets.immutable.empty();
        Assert.assertEquals(UnifiedSet.<String>newSet(), set.differenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
        Verify.assertListsEqual(FastList.newListWith(3, 2, 1), this.classUnderTest(Comparators.reverseNaturalOrder()).union(UnifiedSet.newSetWith(1, 2, 3)).toList());
    }

    @Override
    @Test
    public void symmetricDifference() {
        Assert.assertEquals(UnifiedSet.newSetWith("not present"), SortedSets.immutable.<String>empty().symmetricDifference(UnifiedSet.newSetWith("not present")));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), SortedSets.immutable.of(Comparators.<Integer>reverseNaturalOrder()).symmetricDifference(UnifiedSet.newSetWith(1, 3, 2, 4)).castToSortedSet());
    }

    @Override
    @Test
    public void symmetricDifferenceInto() {
        Assert.assertEquals(UnifiedSet.newSetWith("not present"), SortedSets.immutable.<String>empty().symmetricDifferenceInto(UnifiedSet.newSetWith("not present"), UnifiedSet.newSet()));
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        ImmutableSortedSet<Integer> immutable = this.classUnderTest();
        Verify.assertEqualsAndHashCode(UnifiedSet.newSet(), immutable);
        Verify.assertPostSerializedIdentity(immutable);
        Assert.assertNotEquals(Lists.mutable.empty(), immutable);
        ImmutableSortedSet<Integer> setWithComparator = this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertEqualsAndHashCode(UnifiedSet.newSet(), setWithComparator);
        Verify.assertPostSerializedEqualsAndHashCode(setWithComparator);
    }

    @Override
    @Test
    public void contains() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        Verify.assertNotContains(Integer.valueOf(1), set.castToSortedSet());
        Verify.assertEmpty(set.castToSortedSet());
        Assert.assertThrows(NullPointerException.class, () -> set.contains(null));
    }

    @Override
    @Test
    public void containsAllIterable() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        Assert.assertFalse(set.containsAllIterable(FastList.newListWith(1, 2, 3)));
        Assert.assertTrue(set.containsAllIterable(set));
    }

    @Override
    @Test
    public void iterator() {
        Iterator<Integer> iterator = this.classUnderTest().iterator();
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void select() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        Verify.assertEmpty(set.select(Predicates.lessThan(4)).castToSortedSet());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), set.select(Predicates.lessThan(3)).comparator());
    }

    @Override
    @Test
    public void selectWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(integers.selectWith(Predicates2.lessThan(), 4).castToSortedSet());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), integers.selectWith(Predicates2.lessThan(), 3).comparator());
    }

    @Override
    @Test
    public void reject() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        Verify.assertEmpty(set.reject(Predicates.lessThan(3)).castToSortedSet());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), set.reject(Predicates.lessThan(3)).comparator());
    }

    @Override
    @Test
    public void rejectWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(integers.rejectWith(Predicates2.greaterThanOrEqualTo(), 4).castToSortedSet());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), integers.rejectWith(Predicates2.greaterThanOrEqualTo(), 4).comparator());
    }

    @Override
    @Test
    public void partition() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        PartitionImmutableSortedSet<Integer> partition = set.partition(Predicates.lessThan(4));
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Override
    @Test
    public void partitionWith() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        PartitionImmutableSortedSet<Integer> partition = set.partitionWith(Predicates2.lessThan(), 4);
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Override
    @Test
    public void collect() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertIterableEmpty(integers.collect(Functions.getIntegerPassThru()));
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithIndex() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.empty(), integers.collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithIndexWithTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.empty(), integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Override
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.empty(), integers.selectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Override
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.empty(), integers.selectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    @Override
    @Test
    public void collectWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertIterableEmpty(integers.collectWith((value, parameter) -> value / parameter, 1));
    }

    @Override
    @Test
    public void collectToTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        ImmutableSortedSet<Integer> collect = integers.collect(Functions.getIntegerPassThru(), TreeSortedSet.newSet(Collections.reverseOrder())).toImmutable();
        Verify.assertIterableEmpty(collect);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), collect.comparator());
    }

    @Override
    @Test
    public void partitionWhile() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        PartitionImmutableSortedSet<Integer> partition = set.partitionWhile(Predicates.lessThan(4));
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Override
    @Test
    public void takeWhile() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        ImmutableSortedSet<Integer> take = set.takeWhile(Predicates.lessThan(4));
        Verify.assertIterableEmpty(take);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), take.comparator());
    }

    @Override
    @Test
    public void dropWhile() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        ImmutableSortedSet<Integer> drop = set.dropWhile(Predicates.lessThan(4));
        Verify.assertIterableEmpty(drop);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), drop.comparator());
    }

    @Override
    @Test
    public void selectInstancesOf() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(set.castToSortedSet());
        Verify.assertEmpty(set.selectInstancesOf(Integer.class).castToSortedSet());
        Assert.assertEquals(Collections.<Double>reverseOrder(), set.selectInstancesOf(Double.class).comparator());
    }

    @Override
    @Test
    public void toSortedSet() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Assert.assertNull(set.toSortedSet().comparator());
        Verify.assertEmpty(set.toSortedSet());
    }

    @Override
    @Test
    public void toSortedSetWithComparator() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        Assert.assertEquals(Collections.<Integer>reverseOrder(), set.toSortedSet(Collections.reverseOrder()).comparator());
        Verify.assertEmpty(set.toSortedSet());
    }

    @Test(expected = NoSuchElementException.class)
    public void first() {
        this.classUnderTest().castToSortedSet().first();
    }

    @Test(expected = NoSuchElementException.class)
    public void last() {
        this.classUnderTest().castToSortedSet().last();
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(0, (long) this.classUnderTest().compareTo(this.classUnderTest()));
        Assert.assertEquals(-1, this.classUnderTest().compareTo(TreeSortedSet.newSetWith(1)));
        Assert.assertEquals(-4, this.classUnderTest().compareTo(TreeSortedSet.newSetWith(1, 2, 3, 4)));
    }

    @Override
    @Test
    public void cartesianProduct() {
        LazyIterable<Pair<Integer, Integer>> emptyProduct = this.classUnderTest().cartesianProduct(SortedSets.immutable.of(1, 2, 3));
        Verify.assertEmpty(emptyProduct.toList());
        LazyIterable<Pair<Integer, Integer>> empty2 = this.classUnderTest().cartesianProduct(TreeSortedSet.newSet());
        Verify.assertEmpty(empty2.toList());
    }

    @Override
    @Test
    public void indexOf() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(-1, integers.indexOf(4));
        Assert.assertEquals(-1, integers.indexOf(3));
        Assert.assertEquals(-1, integers.indexOf(2));
        Assert.assertEquals(-1, integers.indexOf(1));
        Assert.assertEquals(-1, integers.indexOf(0));
        Assert.assertEquals(-1, integers.indexOf(5));
    }

    @Override
    @Test
    public void forEachFromTo() {
        MutableSortedSet<Integer> result = TreeSortedSet.newSet(Comparators.reverseNaturalOrder());
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(-1, 0, result::add));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(0, -1, result::add));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(0, 0, result::add));
    }

    @Override
    @Test
    public void forEachWithIndexWithFromTo() {
        MutableList<Integer> result = Lists.mutable.empty();
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(-1, 0, new AddToList(result)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(0, -1, new AddToList(result)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(0, 0, new AddToList(result)));
    }

    @Override
    public void toStack() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Stacks.mutable.with(), set.toStack());
    }

    @Override
    @Test
    public void powerSet() {
        Verify.assertSize(1, this.classUnderTest().powerSet().castToSortedSet());
        Assert.assertEquals(SortedSets.immutable.of(SortedSets.immutable.<Integer>empty()), this.classUnderTest().powerSet());
    }

    @Override
    @Test
    public void toSortedMap() {
        MutableSortedMap<Integer, Integer> map = this.classUnderTest().toSortedMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
    }

    @Override
    @Test
    public void toSortedMap_with_comparator() {
        MutableSortedMap<Integer, Integer> map = this.classUnderTest().toSortedMap(Comparators.reverseNaturalOrder(), Functions.getIntegerPassThru(), Functions.getIntegerPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), map.comparator());
    }

    @Override
    @Test
    public void toSortedMapBy() {
        MutableSortedMap<Integer, Integer> map = this.classUnderTest().toSortedMapBy(key -> -key, Functions.getIntegerPassThru(), Functions.getIntegerPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void subSet() {
        this.classUnderTest().castToSortedSet().subSet(1, 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void headSet() {
        this.classUnderTest().castToSortedSet().headSet(4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void tailSet() {
        this.classUnderTest().castToSortedSet().tailSet(1);
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(BooleanArrayList.newListWith(), integers.collectBoolean(PrimitiveFunctions.integerIsPositive()));
    }

    @Override
    @Test
    public void collectByte() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(ByteArrayList.newListWith(), integers.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Override
    @Test
    public void collectChar() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(CharArrayList.newListWith(), integers.collectChar(integer -> (char) (integer.intValue() + 64)));
    }

    @Override
    @Test
    public void collectDouble() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(DoubleArrayList.newListWith(), integers.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Override
    @Test
    public void collectFloat() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(FloatArrayList.newListWith(), integers.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Override
    @Test
    public void collectInt() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(IntArrayList.newListWith(), integers.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Override
    @Test
    public void collectLong() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(LongArrayList.newListWith(), integers.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Override
    @Test
    public void collectShort() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(ShortArrayList.newListWith(), integers.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Override
    @Test
    public void groupByUniqueKey_throws() {
        super.groupByUniqueKey_throws();
        Assert.assertEquals(UnifiedMap.newMap().toImmutable(), this.classUnderTest().groupByUniqueKey(id -> id));
    }

    @Override
    @Test
    public void groupByUniqueKey_target_throws() {
        super.groupByUniqueKey_target_throws();
        Assert.assertEquals(UnifiedMap.newMap(), this.classUnderTest().groupByUniqueKey(id -> id, UnifiedMap.newMap()));
    }

    @Override
    @Test
    public void take() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().take(2));
    }

    @Override
    @Test
    public void drop() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().drop(2));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableEmptySortedSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noSupportForNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noSupportForNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
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
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
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
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
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
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
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
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEachWithTarget);
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
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testContainsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewSortedSet);
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
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
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
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_first() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.first);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_last() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.last);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
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
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
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
        public void benchmark_subSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailSet);
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
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptySortedSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> noSupportForNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectIfToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> testContainsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> testNewSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> first;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> last;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> subSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> headSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> tailSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetTest> drop;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noSupportForNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::noSupportForNull, java.lang.NullPointerException.class);
            this.payloads.newWithAll = ImmutableEmptySortedSetTest::newWithAll;
            this.payloads.newWithoutAll = ImmutableEmptySortedSetTest::newWithoutAll;
            this.payloads.containsAllArray = ImmutableEmptySortedSetTest::containsAllArray;
            this.payloads.tap = ImmutableEmptySortedSetTest::tap;
            this.payloads.forEach = ImmutableEmptySortedSetTest::forEach;
            this.payloads.forEachWith = ImmutableEmptySortedSetTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptySortedSetTest::forEachWithIndex;
            this.payloads.selectToTarget = ImmutableEmptySortedSetTest::selectToTarget;
            this.payloads.rejectToTarget = ImmutableEmptySortedSetTest::rejectToTarget;
            this.payloads.flatCollect = ImmutableEmptySortedSetTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableEmptySortedSetTest::flatCollectWithTarget;
            this.payloads.detectWithIfNone = ImmutableEmptySortedSetTest::detectWithIfNone;
            this.payloads.detectIfNone = ImmutableEmptySortedSetTest::detectIfNone;
            this.payloads.count = ImmutableEmptySortedSetTest::count;
            this.payloads.collectIf = ImmutableEmptySortedSetTest::collectIf;
            this.payloads.collectIfToTarget = ImmutableEmptySortedSetTest::collectIfToTarget;
            this.payloads.injectInto = ImmutableEmptySortedSetTest::injectInto;
            this.payloads.toArray = ImmutableEmptySortedSetTest::toArray;
            this.payloads.testToString = ImmutableEmptySortedSetTest::testToString;
            this.payloads.makeString = ImmutableEmptySortedSetTest::makeString;
            this.payloads.appendString = ImmutableEmptySortedSetTest::appendString;
            this.payloads.toList = ImmutableEmptySortedSetTest::toList;
            this.payloads.toSortedList = ImmutableEmptySortedSetTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableEmptySortedSetTest::toSortedListBy;
            this.payloads.toSortedSetBy = ImmutableEmptySortedSetTest::toSortedSetBy;
            this.payloads.forLoop = ImmutableEmptySortedSetTest::forLoop;
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.groupBy = ImmutableEmptySortedSetTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptySortedSetTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableEmptySortedSetTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableEmptySortedSetTest::groupByEachWithTarget;
            this.payloads.groupByUniqueKey = ImmutableEmptySortedSetTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_target = ImmutableEmptySortedSetTest::groupByUniqueKey_target;
            this.payloads.isSubsetOf = ImmutableEmptySortedSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ImmutableEmptySortedSetTest::isProperSubsetOf;
            this.payloads.distinct = ImmutableEmptySortedSetTest::distinct;
            this.payloads.toStack = ImmutableEmptySortedSetTest::toStack;
            this.payloads.toImmutable = ImmutableEmptySortedSetTest::toImmutable;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.testContainsAll = ImmutableEmptySortedSetTest::testContainsAll;
            this.payloads.testNewSortedSet = ImmutableEmptySortedSetTest::testNewSortedSet;
            this.payloads.newWith = ImmutableEmptySortedSetTest::newWith;
            this.payloads.newWithout = ImmutableEmptySortedSetTest::newWithout;
            this.payloads.detect = ImmutableEmptySortedSetTest::detect;
            this.payloads.detectWith = ImmutableEmptySortedSetTest::detectWith;
            this.payloads.detectIndex = ImmutableEmptySortedSetTest::detectIndex;
            this.payloads.corresponds = ImmutableEmptySortedSetTest::corresponds;
            this.payloads.allSatisfy = ImmutableEmptySortedSetTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableEmptySortedSetTest::anySatisfy;
            this.payloads.getFirst = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::getFirst, java.util.NoSuchElementException.class);
            this.payloads.getLast = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::getLast, java.util.NoSuchElementException.class);
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::getOnly, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ImmutableEmptySortedSetTest::isEmpty;
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::min, java.util.NoSuchElementException.class);
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::max, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.zip = ImmutableEmptySortedSetTest::zip;
            this.payloads.zipWithIndex = ImmutableEmptySortedSetTest::zipWithIndex;
            this.payloads.chunk = ImmutableEmptySortedSetTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableEmptySortedSetTest::chunk_large_size;
            this.payloads.union = ImmutableEmptySortedSetTest::union;
            this.payloads.unionInto = ImmutableEmptySortedSetTest::unionInto;
            this.payloads.intersect = ImmutableEmptySortedSetTest::intersect;
            this.payloads.intersectInto = ImmutableEmptySortedSetTest::intersectInto;
            this.payloads.difference = ImmutableEmptySortedSetTest::difference;
            this.payloads.differenceInto = ImmutableEmptySortedSetTest::differenceInto;
            this.payloads.symmetricDifference = ImmutableEmptySortedSetTest::symmetricDifference;
            this.payloads.symmetricDifferenceInto = ImmutableEmptySortedSetTest::symmetricDifferenceInto;
            this.payloads.equalsAndHashCode = ImmutableEmptySortedSetTest::equalsAndHashCode;
            this.payloads.contains = ImmutableEmptySortedSetTest::contains;
            this.payloads.containsAllIterable = ImmutableEmptySortedSetTest::containsAllIterable;
            this.payloads.iterator = ImmutableEmptySortedSetTest::iterator;
            this.payloads.select = ImmutableEmptySortedSetTest::select;
            this.payloads.selectWith = ImmutableEmptySortedSetTest::selectWith;
            this.payloads.reject = ImmutableEmptySortedSetTest::reject;
            this.payloads.rejectWith = ImmutableEmptySortedSetTest::rejectWith;
            this.payloads.partition = ImmutableEmptySortedSetTest::partition;
            this.payloads.partitionWith = ImmutableEmptySortedSetTest::partitionWith;
            this.payloads.collect = ImmutableEmptySortedSetTest::collect;
            this.payloads.collectWithIndex = ImmutableEmptySortedSetTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableEmptySortedSetTest::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = ImmutableEmptySortedSetTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = ImmutableEmptySortedSetTest::rejectWithIndexWithTarget;
            this.payloads.collectWith = ImmutableEmptySortedSetTest::collectWith;
            this.payloads.collectToTarget = ImmutableEmptySortedSetTest::collectToTarget;
            this.payloads.partitionWhile = ImmutableEmptySortedSetTest::partitionWhile;
            this.payloads.takeWhile = ImmutableEmptySortedSetTest::takeWhile;
            this.payloads.dropWhile = ImmutableEmptySortedSetTest::dropWhile;
            this.payloads.selectInstancesOf = ImmutableEmptySortedSetTest::selectInstancesOf;
            this.payloads.toSortedSet = ImmutableEmptySortedSetTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableEmptySortedSetTest::toSortedSetWithComparator;
            this.payloads.first = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::first, java.util.NoSuchElementException.class);
            this.payloads.last = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::last, java.util.NoSuchElementException.class);
            this.payloads.compareTo = ImmutableEmptySortedSetTest::compareTo;
            this.payloads.cartesianProduct = ImmutableEmptySortedSetTest::cartesianProduct;
            this.payloads.indexOf = ImmutableEmptySortedSetTest::indexOf;
            this.payloads.forEachFromTo = ImmutableEmptySortedSetTest::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = ImmutableEmptySortedSetTest::forEachWithIndexWithFromTo;
            this.payloads.powerSet = ImmutableEmptySortedSetTest::powerSet;
            this.payloads.toSortedMap = ImmutableEmptySortedSetTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableEmptySortedSetTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableEmptySortedSetTest::toSortedMapBy;
            this.payloads.subSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::subSet, java.lang.UnsupportedOperationException.class);
            this.payloads.headSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::headSet, java.lang.UnsupportedOperationException.class);
            this.payloads.tailSet = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetTest::tailSet, java.lang.UnsupportedOperationException.class);
            this.payloads.collectBoolean = ImmutableEmptySortedSetTest::collectBoolean;
            this.payloads.collectByte = ImmutableEmptySortedSetTest::collectByte;
            this.payloads.collectChar = ImmutableEmptySortedSetTest::collectChar;
            this.payloads.collectDouble = ImmutableEmptySortedSetTest::collectDouble;
            this.payloads.collectFloat = ImmutableEmptySortedSetTest::collectFloat;
            this.payloads.collectInt = ImmutableEmptySortedSetTest::collectInt;
            this.payloads.collectLong = ImmutableEmptySortedSetTest::collectLong;
            this.payloads.collectShort = ImmutableEmptySortedSetTest::collectShort;
            this.payloads.groupByUniqueKey_throws = ImmutableEmptySortedSetTest::groupByUniqueKey_throws;
            this.payloads.groupByUniqueKey_target_throws = ImmutableEmptySortedSetTest::groupByUniqueKey_target_throws;
            this.payloads.take = ImmutableEmptySortedSetTest::take;
            this.payloads.drop = ImmutableEmptySortedSetTest::drop;
        }
    }
}
