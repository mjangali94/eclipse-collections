/*
 * Copyright (c) 2018 Goldman Sachs and others.
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
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testContainsAll, this.description("testContainsAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewSortedSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewSortedSet, this.description("testNewSortedSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWith, this.description("newWith"));
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
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIndex, this.description("detectIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::corresponds, this.description("corresponds"));
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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getFirst, this.description("getFirst"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getLast, this.description("getLast"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getOnly, this.description("getOnly"), java.lang.IllegalStateException.class);
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
        public void benchmark_union() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::union, this.description("union"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::unionInto, this.description("unionInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersect, this.description("intersect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intersectInto, this.description("intersectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::difference, this.description("difference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::differenceInto, this.description("differenceInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifference, this.description("symmetricDifference"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::symmetricDifferenceInto, this.description("symmetricDifferenceInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithIndex, this.description("collectWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithIndexWithTarget, this.description("collectWithIndexWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectToTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectToTarget, this.description("collectToTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWhile, this.description("partitionWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::takeWhile, this.description("takeWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dropWhile, this.description("dropWhile"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSet, this.description("toSortedSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetWithComparator, this.description("toSortedSetWithComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_first() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::first, this.description("first"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_last() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::last, this.description("last"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::compareTo, this.description("compareTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::cartesianProduct, this.description("cartesianProduct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::indexOf, this.description("indexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachFromTo, this.description("forEachFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndexWithFromTo, this.description("forEachWithIndexWithFromTo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::powerSet, this.description("powerSet"));
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
        public void benchmark_subSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::subSet, this.description("subSet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::headSet, this.description("headSet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::tailSet, this.description("tailSet"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_throws, this.description("groupByUniqueKey_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByUniqueKey_target_throws, this.description("groupByUniqueKey_target_throws"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::take, this.description("take"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::drop, this.description("drop"));
        }

        private ImmutableEmptySortedSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableEmptySortedSetTest();
        }

        @java.lang.Override
        public ImmutableEmptySortedSetTest implementation() {
            return this.implementation;
        }
    }
}
