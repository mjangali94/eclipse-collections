/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.immutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.partition.bag.sorted.PartitionImmutableSortedBag;
import org.eclipse.collections.api.partition.bag.sorted.PartitionSortedBag;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.SortedBags;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableEmptySortedBagTest extends AbstractImmutableSortedBagTestCase {

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest() {
        return SortedBags.immutable.empty();
    }

    @Override
    protected <T> MutableCollection<T> newMutable() {
        return SortedBags.mutable.empty();
    }

    @Override
    protected ImmutableSortedBag<Integer> classUnderTest(Comparator<? super Integer> comparator) {
        return SortedBags.immutable.empty(comparator);
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(T... elements) {
        return (ImmutableSortedBag<T>) ImmutableEmptySortedBag.INSTANCE;
    }

    @Override
    protected <T> ImmutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements) {
        return SortedBags.immutable.empty(comparator);
    }

    @Override
    @Test
    public void corresponds() {
        // Evaluates true for all empty lists and false for all non-empty lists
        Assert.assertTrue(this.classUnderTest().corresponds(Lists.mutable.of(), Predicates2.alwaysFalse()));
        ImmutableSortedBag<Integer> integers = this.classUnderTest().newWith(Integer.valueOf(1));
        Assert.assertFalse(this.classUnderTest().corresponds(integers, Predicates2.alwaysTrue()));
    }

    @Override
    @Test
    public void compareTo() {
        Assert.assertEquals(0, this.classUnderTest().compareTo(this.classUnderTest()));
        Assert.assertEquals(0, this.classUnderTest(Comparator.reverseOrder()).compareTo(this.classUnderTest(Comparator.reverseOrder())));
        Assert.assertEquals(0, this.classUnderTest(Comparator.naturalOrder()).compareTo(this.classUnderTest(Comparator.reverseOrder())));
        Assert.assertEquals(-1, this.classUnderTest().compareTo(TreeBag.newBagWith(1)));
        Assert.assertEquals(-1, this.classUnderTest(Comparator.reverseOrder()).compareTo(TreeBag.newBagWith(Comparator.reverseOrder(), 1)));
        Assert.assertEquals(-5, this.classUnderTest().compareTo(TreeBag.newBagWith(1, 2, 2, 3, 4)));
        Assert.assertEquals(0, this.classUnderTest().compareTo(TreeBag.newBag()));
        Assert.assertEquals(0, this.classUnderTest().compareTo(TreeBag.newBag(Comparator.reverseOrder())));
    }

    @Override
    @Test
    public void selectDuplicates() {
        Assert.assertEquals(Bags.immutable.empty(), this.classUnderTest().selectDuplicates());
    }

    @Override
    @Test
    public void contains() {
        Assert.assertFalse(this.classUnderTest().contains(1));
        Assert.assertFalse(this.classUnderTest(Comparator.reverseOrder()).contains(1));
    }

    @Test(expected = NullPointerException.class)
    public void contains_null() {
        this.classUnderTest().contains(null);
        this.classUnderTest(Comparator.naturalOrder()).contains(null);
    }

    @Override
    public void allSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(Predicates2.alwaysFalse(), "false"));
        Assert.assertTrue(this.classUnderTest(Comparators.reverseNaturalOrder()).allSatisfyWith(Predicates2.alwaysFalse(), false));
    }

    @Override
    public void anySatisfyWith() {
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Predicates2.alwaysFalse(), "false"));
        Assert.assertFalse(this.classUnderTest(Comparators.reverseNaturalOrder()).anySatisfyWith(Predicates2.alwaysFalse(), false));
    }

    @Override
    public void noneSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(Predicates2.alwaysFalse(), "false"));
        Assert.assertTrue(this.classUnderTest(Comparators.reverseNaturalOrder()).noneSatisfyWith(Predicates2.alwaysFalse(), false));
    }

    @Override
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.alwaysFalse()));
        Assert.assertTrue(this.classUnderTest(Comparators.reverseNaturalOrder()).noneSatisfy(Predicates.alwaysFalse()));
    }

    @Override
    @Test
    public void containsAllIterable() {
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith(1, 2, 3)));
        Assert.assertFalse(this.classUnderTest(Comparator.reverseOrder()).containsAllIterable(FastList.newListWith(1, 2, 3)));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith(1, 2, 3)));
        Assert.assertFalse(this.classUnderTest(Comparator.reverseOrder()).containsAll(FastList.newListWith(1, 2, 3)));
    }

    @Override
    @Test
    public void forEachWithIndexWithFromTo() {
        MutableList<Integer> mutableList = Lists.mutable.empty();
        this.classUnderTest().forEachWithIndex(0, 0, (each, index) -> mutableList.add(each + index));
        Verify.assertEmpty(mutableList);
    }

    @Override
    @Test
    public void anySatisfyWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> true));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> false));
    }

    @Override
    @Test
    public void allSatisfyWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> true));
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> false));
    }

    @Override
    @Test
    public void noneSatisfyWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> true));
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> false));
    }

    @Override
    @Test
    public void detectWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> true));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> false));
    }

    @Override
    @Test
    public void chunk_large_size() {
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest().chunk(10));
    }

    @Override
    @Test
    public void detect() {
        Assert.assertNull(this.classUnderTest().detect(each -> each % 2 == 0));
        Assert.assertNull(this.classUnderTest(Comparator.naturalOrder()).detect(each -> each % 2 == 0));
    }

    @Override
    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(each -> each % 2 == 0));
        Assert.assertTrue(this.classUnderTest(Comparators.reverseNaturalOrder()).allSatisfy(each -> each % 2 == 0));
    }

    @Override
    @Test
    public void detectWith() {
        Assert.assertNull(this.classUnderTest().detectWith(Predicates2.greaterThan(), 3));
        Assert.assertNull(this.classUnderTest(Comparators.reverseNaturalOrder()).detectWith(Predicates2.greaterThan(), 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest(Comparators.reverseNaturalOrder()).max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max_without_comparator() {
        this.classUnderTest().max();
        this.classUnderTest().max(Comparator.naturalOrder());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_with_comparator() {
        this.classUnderTest().max(Comparator.naturalOrder());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.classUnderTest().maxBy(Functions.getToString());
        this.classUnderTest(Comparators.reverseNaturalOrder()).maxBy(Functions.getToString());
    }

    @Override
    @Test
    public void toSortedBag() {
        Assert.assertEquals(TreeBag.newBag(), this.classUnderTest().toSortedBag());
        Assert.assertEquals(TreeBag.newBag(Comparators.reverseNaturalOrder()), this.classUnderTest(Comparators.reverseNaturalOrder()).toSortedBag());
    }

    @Override
    @Test
    public void toSortedMap() {
        Assert.assertEquals(SortedMaps.mutable.empty(), this.classUnderTest().toSortedMap(Functions.getIntegerPassThru(), Functions.getIntegerPassThru()));
    }

    @Override
    @Test
    public void toSortedMap_with_comparator() {
        MutableSortedMap<Integer, Integer> map = this.classUnderTest().toSortedMap(Comparators.reverseNaturalOrder(), Functions.getIntegerPassThru(), Functions.getIntegerPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
        Assert.assertEquals(Comparators.<String>reverseNaturalOrder(), map.comparator());
    }

    @Override
    @Test
    public void toSortedMapBy() {
        MutableSortedMap<Integer, Integer> map = this.classUnderTest().toSortedMapBy(key -> -key, Functions.getIntegerPassThru(), Functions.getIntegerPassThru());
        Verify.assertEmpty(map);
        Verify.assertInstanceOf(TreeSortedMap.class, map);
    }

    @Override
    @Test
    public void toStack() {
        Assert.assertEquals(Stacks.immutable.empty(), this.classUnderTest().toStack());
        Assert.assertEquals(Stacks.immutable.empty(), this.classUnderTest(Comparators.reverseNaturalOrder()).toStack());
    }

    @Override
    @Test
    public void toStringOfItemToCount() {
        Assert.assertEquals("{}", this.classUnderTest().toStringOfItemToCount());
        Assert.assertEquals("{}", this.classUnderTest(Comparator.reverseOrder()).toStringOfItemToCount());
    }

    @Override
    @Test
    public void groupByUniqueKey() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(Maps.mutable.empty(), bag.groupByUniqueKey(integer -> integer));
    }

    @Override
    @Test
    public void groupByUniqueKey_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0), bag.groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0)));
    }

    @Test
    public void countByEach() {
        Assert.assertEquals(Bags.immutable.empty(), this.classUnderTest().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i)));
    }

    @Test
    public void countByEach_target() {
        MutableBag<Integer> target = Bags.mutable.empty();
        Assert.assertEquals(target, this.classUnderTest().countByEach(each -> IntInterval.oneTo(5).collect(i -> each + i), target));
    }

    @Override
    @Test
    public void zip() {
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest().zip(Iterables.iBag()));
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest().zip(Iterables.iBag(), FastList.newList()));
        Assert.assertEquals(Lists.immutable.empty(), this.classUnderTest(Comparators.reverseNaturalOrder()).zip(Iterables.iBag()));
    }

    @Override
    public void zipWithIndex() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Comparator.reverseOrder());
        ImmutableSortedSet<Pair<Integer, Integer>> actual = bag.zipWithIndex();
        Assert.assertEquals(SortedSets.immutable.empty(), actual);
        Assert.assertSame(SortedSets.immutable.empty(Comparator.<Integer>reverseOrder()).comparator(), actual.comparator());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest(Comparator.reverseOrder()).min();
        this.classUnderTest(Comparator.reverseOrder()).min(Comparator.naturalOrder());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min_without_comparator() {
        this.classUnderTest().min();
    }

    @Test(expected = NoSuchElementException.class)
    public void min_with_comparator() {
        this.classUnderTest().min(Comparator.naturalOrder());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.classUnderTest().minBy(Functions.getToString());
    }

    @Override
    @Test
    public void newWithTest() {
        Assert.assertEquals(SortedBags.immutable.of(1), this.classUnderTest().newWith(1));
        Assert.assertEquals(SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1), this.classUnderTest(Comparators.reverseNaturalOrder()).newWith(1));
    }

    @Override
    @Test
    public void newWithAll() {
        Assert.assertEquals(SortedBags.immutable.ofAll(FastList.newListWith(1, 2, 3, 3)), this.classUnderTest().newWithAll(FastList.newListWith(1, 2, 3, 3)));
        Assert.assertEquals(SortedBags.immutable.ofAll(Comparators.reverseNaturalOrder(), FastList.newListWith(1, 2, 3, 3)), this.classUnderTest(Comparators.reverseNaturalOrder()).newWithAll(FastList.newListWith(1, 2, 3, 3)));
    }

    @Override
    @Test
    public void newWithout() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().newWithout(1));
        Assert.assertEquals(this.classUnderTest(Comparators.reverseNaturalOrder()), this.classUnderTest(Comparators.reverseNaturalOrder()).newWithout(1));
    }

    @Override
    @Test
    public void partition() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Collections.reverseOrder());
        PartitionImmutableSortedBag<Integer> partition = bag.partition(Predicates.lessThan(4));
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Assert.assertSame(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertSame(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Override
    @Test
    public void partitionWhile() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Collections.reverseOrder());
        PartitionSortedBag<Integer> partition = bag.partitionWhile(Predicates.lessThan(4));
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Assert.assertSame(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertSame(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Override
    @Test
    public void toMapOfItemToCount() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Comparators.reverseNaturalOrder());
        TreeSortedMap<Object, Object> expectedMap = TreeSortedMap.newMap(Comparators.reverseNaturalOrder());
        MutableSortedMap<Integer, Integer> actualMap = bag.toMapOfItemToCount();
        Verify.assertSortedMapsEqual(expectedMap, actualMap);
        Assert.assertSame(expectedMap.comparator(), actualMap.comparator());
    }

    @Override
    @Test
    public void partitionWith() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Collections.reverseOrder());
        PartitionImmutableSortedBag<Integer> partition = bag.partitionWith(Predicates2.lessThan(), 4);
        Verify.assertIterableEmpty(partition.getSelected());
        Verify.assertIterableEmpty(partition.getRejected());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Override
    @Test
    public void reject() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject(each -> each % 2 == 0));
        Assert.assertEquals(this.classUnderTest(Comparators.reverseNaturalOrder()), this.classUnderTest(Comparators.reverseNaturalOrder()).reject(each -> each % 2 == 0));
    }

    @Override
    @Test
    public void rejectWith() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().rejectWith(Predicates2.alwaysFalse(), 2));
        Assert.assertEquals(this.classUnderTest(Comparators.reverseNaturalOrder()), this.classUnderTest(Comparators.reverseNaturalOrder()).rejectWith(Predicates2.alwaysFalse(), 2));
    }

    @Override
    @Test
    public void rejectToTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Verify.assertEmpty(integers.reject(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Verify.assertListsEqual(integers.toList(), integers.reject(Predicates.greaterThan(integers.size()), FastList.newList()));
        ImmutableSortedBag<Integer> integers2 = this.classUnderTest();
        Verify.assertEmpty(integers2.reject(Predicates.lessThan(integers2.size() + 1), new HashBag<>()));
    }

    @Override
    @Test
    public void toSortedSet() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableSortedSet<Integer> set = integers.toSortedSet();
        Assert.assertEquals(SortedSets.immutable.empty(), set);
    }

    @Override
    @Test
    public void toSortedSetWithComparator() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        MutableSortedSet<Integer> set = integers.toSortedSet();
        Assert.assertEquals(SortedSets.immutable.of(Comparator.<Integer>reverseOrder()), set);
    }

    @Override
    @Test
    public void select() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select(each -> each % 2 == 0));
        Assert.assertEquals(this.classUnderTest(Comparators.reverseNaturalOrder()), this.classUnderTest(Comparators.reverseNaturalOrder()).select(each -> each % 2 == 0));
    }

    @Override
    @Test
    public void selectWith() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().selectWith(Predicates2.alwaysFalse(), "false"));
    }

    @Override
    @Test
    public void takeWhile() {
        ImmutableSortedBag<Integer> set = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedBag<Integer> take = set.takeWhile(Predicates.lessThan(4));
        Verify.assertIterableEmpty(take);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), take.comparator());
    }

    @Override
    @Test
    public void distinct() {
        Assert.assertEquals(SortedSets.immutable.empty(), this.classUnderTest().distinct());
        ImmutableSortedSet<Object> expected = SortedSets.immutable.with(Comparators.reverseNaturalOrder());
        ImmutableSortedSet<Integer> actual = this.classUnderTest(Comparators.reverseNaturalOrder()).distinct();
        Assert.assertEquals(expected, actual);
        Assert.assertSame(expected.comparator(), actual.comparator());
    }

    @Override
    @Test
    public void dropWhile() {
        ImmutableSortedBag<Integer> set = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedBag<Integer> drop = set.dropWhile(Predicates.lessThan(4));
        Verify.assertIterableEmpty(drop);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), drop.comparator());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        ImmutableSortedBag<Integer> immutable = this.classUnderTest();
        Verify.assertEqualsAndHashCode(HashBag.newBag(), immutable);
        Verify.assertPostSerializedIdentity(immutable);
        Assert.assertNotEquals(Lists.mutable.empty(), immutable);
        ImmutableSortedBag<Integer> bagWithComparator = this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertEqualsAndHashCode(HashBag.newBag(), bagWithComparator);
        Verify.assertPostSerializedEqualsAndHashCode(bagWithComparator);
    }

    @Override
    @Test
    public void getLast() {
        Assert.assertNull(this.classUnderTest().getLast());
        Assert.assertNull(this.classUnderTest(Comparators.reverseNaturalOrder()).getLast());
    }

    @Override
    @Test
    public void getFirst() {
        Assert.assertNull(this.classUnderTest().getFirst());
        Assert.assertNull(this.classUnderTest(Comparators.reverseNaturalOrder()).getFirst());
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @Override
    public void detectIndex() {
        Assert.assertEquals(-1, this.classUnderTest().detectIndex(each -> each > 1));
    }

    @Override
    public void indexOf() {
        Assert.assertEquals(-1, this.classUnderTest().indexOf(1));
    }

    @Override
    @Test
    public void occurrencesOf() {
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf(1));
    }

    @Override
    @Test
    public void isEmpty() {
        Assert.assertTrue(this.classUnderTest().isEmpty());
        Assert.assertTrue(this.classUnderTest(Comparators.reverseNaturalOrder()).isEmpty());
    }

    @Override
    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy(each -> each * 2 == 4));
        Assert.assertFalse(this.classUnderTest(Comparators.reverseNaturalOrder()).anySatisfy(each -> each * 2 == 4));
    }

    @Override
    @Test
    public void collectIfToTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers.toBag(), integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru(), HashBag.newBag()));
    }

    @Override
    @Test
    public void topOccurrences() {
        Assert.assertEquals(0, this.classUnderTest().topOccurrences(5).size());
    }

    @Override
    @Test
    public void bottomOccurrences() {
        Assert.assertEquals(0, this.newWith().bottomOccurrences(5).size());
    }

    /**
     * @since 9.1.
     */
    @Override
    @Test
    public void collectWithIndex() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        ImmutableList<ObjectIntPair<Integer>> actual = integers.collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(Lists.mutable.empty(), actual);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<ObjectIntPair<Integer>> actual = integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(Lists.mutable.empty(), actual);
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new BooleanArrayList(), bag.collectBoolean(each -> false));
    }

    @Override
    @Test
    public void collectByte() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new ByteArrayList(), bag.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Override
    @Test
    public void collectChar() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new CharArrayList(), bag.collectChar(PrimitiveFunctions.unboxIntegerToChar()));
    }

    @Override
    @Test
    public void collectDouble() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new DoubleArrayList(), bag.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Override
    @Test
    public void collectFloat() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new FloatArrayList(), bag.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Override
    @Test
    public void collectInt() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new IntArrayList(), bag.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Override
    @Test
    public void collectLong() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new LongArrayList(), bag.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Override
    @Test
    public void collectShort() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new ShortArrayList(), bag.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Override
    @Test
    public void collectBoolean_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new BooleanArrayList(), bag.collectBoolean(each -> false, new BooleanArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new BooleanHashBag(), bag2.collectBoolean(each -> false, new BooleanHashBag()));
    }

    @Override
    @Test
    public void collectByte_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new ByteArrayList(), bag.collectByte(PrimitiveFunctions.unboxIntegerToByte(), new ByteArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new ByteHashBag(), bag2.collectByte(PrimitiveFunctions.unboxIntegerToByte(), new ByteHashBag()));
    }

    @Override
    @Test
    public void collectChar_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new CharArrayList(), bag.collectChar(PrimitiveFunctions.unboxIntegerToChar(), new CharArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new CharHashBag(), bag2.collectChar(PrimitiveFunctions.unboxIntegerToChar(), new CharHashBag()));
    }

    @Override
    @Test
    public void collectDouble_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new DoubleArrayList(), bag.collectDouble(PrimitiveFunctions.unboxIntegerToDouble(), new DoubleArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new DoubleHashBag(), bag2.collectDouble(PrimitiveFunctions.unboxIntegerToDouble(), new DoubleHashBag()));
    }

    @Override
    @Test
    public void collectFloat_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new FloatArrayList(), bag.collectFloat(PrimitiveFunctions.unboxIntegerToFloat(), new FloatArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new FloatHashBag(), bag2.collectFloat(PrimitiveFunctions.unboxIntegerToFloat(), new FloatHashBag()));
    }

    @Override
    @Test
    public void collectInt_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new IntArrayList(), bag.collectInt(PrimitiveFunctions.unboxIntegerToInt(), new IntArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new IntHashBag(), bag2.collectInt(PrimitiveFunctions.unboxIntegerToInt(), new IntHashBag()));
    }

    @Override
    @Test
    public void collectLong_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new LongArrayList(), bag.collectLong(PrimitiveFunctions.unboxIntegerToLong(), new LongArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new LongHashBag(), bag2.collectLong(PrimitiveFunctions.unboxIntegerToLong(), new LongHashBag()));
    }

    @Override
    @Test
    public void collectShort_target() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(new ShortArrayList(), bag.collectShort(PrimitiveFunctions.unboxIntegerToShort(), new ShortArrayList()));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest();
        Assert.assertEquals(new ShortHashBag(), bag2.collectShort(PrimitiveFunctions.unboxIntegerToShort(), new ShortHashBag()));
    }

    @Override
    @Test
    public void toArray() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<Integer> copy = FastList.newList(integers);
        Assert.assertArrayEquals(integers.toArray(), copy.toArray());
        Assert.assertArrayEquals(integers.toArray(new Integer[integers.size()]), copy.toArray(new Integer[integers.size()]));
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

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        Comparator<Integer> comparator = Collections.reverseOrder();
        ImmutableSortedBag<Integer> bag = this.classUnderTest(comparator);
        ImmutableSortedSet<Integer> expected = SortedSets.immutable.empty(comparator);
        ImmutableSortedSet<Integer> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected.comparator(), actual.comparator());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableEmptySortedBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToCollection);
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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
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
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
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
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noSupportForNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noSupportForNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
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
        public void benchmark_toSortedBagWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
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
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_null);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
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
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
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
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
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
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithTest);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfToTarget);
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
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
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
        public void benchmark_collectBoolean_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptySortedBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> noSupportForNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedBagWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> distinctView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> contains_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> max_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> countByEach_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> min_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> newWithTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectIfToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectBoolean_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectByte_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectChar_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectDouble_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectFloat_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectInt_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectLong_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> collectShort_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedBagTest> selectUnique;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = ImmutableEmptySortedBagTest::stream;
            this.payloads.parallelStream = ImmutableEmptySortedBagTest::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = ImmutableEmptySortedBagTest::countBy;
            this.payloads.countByWith = ImmutableEmptySortedBagTest::countByWith;
            this.payloads.selectWith_target = ImmutableEmptySortedBagTest::selectWith_target;
            this.payloads.rejectWith_target = ImmutableEmptySortedBagTest::rejectWith_target;
            this.payloads.collect_target = ImmutableEmptySortedBagTest::collect_target;
            this.payloads.collectWith_target = ImmutableEmptySortedBagTest::collectWith_target;
            this.payloads.injectIntoInt = ImmutableEmptySortedBagTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableEmptySortedBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableEmptySortedBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableEmptySortedBagTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableEmptySortedBagTest::sumFloat;
            this.payloads.sumDouble = ImmutableEmptySortedBagTest::sumDouble;
            this.payloads.sumInteger = ImmutableEmptySortedBagTest::sumInteger;
            this.payloads.sumLong = ImmutableEmptySortedBagTest::sumLong;
            this.payloads.sumByInt = ImmutableEmptySortedBagTest::sumByInt;
            this.payloads.sumByFloat = ImmutableEmptySortedBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = ImmutableEmptySortedBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = ImmutableEmptySortedBagTest::sumByLong;
            this.payloads.sumByDouble = ImmutableEmptySortedBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = ImmutableEmptySortedBagTest::sumByDoubleConsistentRounding;
            this.payloads.flatCollectWith = ImmutableEmptySortedBagTest::flatCollectWith;
            this.payloads.allSatisfyWith = ImmutableEmptySortedBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableEmptySortedBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableEmptySortedBagTest::noneSatisfyWith;
            this.payloads.anySatisfyWith = ImmutableEmptySortedBagTest::anySatisfyWith;
            this.payloads.countWith = ImmutableEmptySortedBagTest::countWith;
            this.payloads.toSortedSetBy = ImmutableEmptySortedBagTest::toSortedSetBy;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.iteratorRemove = ImmutableEmptySortedBagTest::iteratorRemove;
            this.payloads.add = ImmutableEmptySortedBagTest::add;
            this.payloads.remove = ImmutableEmptySortedBagTest::remove;
            this.payloads.clear = ImmutableEmptySortedBagTest::clear;
            this.payloads.removeAll = ImmutableEmptySortedBagTest::removeAll;
            this.payloads.retainAll = ImmutableEmptySortedBagTest::retainAll;
            this.payloads.addAll = ImmutableEmptySortedBagTest::addAll;
            this.payloads.aggregateByMutating = ImmutableEmptySortedBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableEmptySortedBagTest::aggregateByNonMutating;
            this.payloads.noSupportForNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::noSupportForNull, java.lang.NullPointerException.class);
            this.payloads.selectByOccurrences = ImmutableEmptySortedBagTest::selectByOccurrences;
            this.payloads.newWithoutAll = ImmutableEmptySortedBagTest::newWithoutAll;
            this.payloads.size = ImmutableEmptySortedBagTest::size;
            this.payloads.containsAllArray = ImmutableEmptySortedBagTest::containsAllArray;
            this.payloads.tap = ImmutableEmptySortedBagTest::tap;
            this.payloads.forEach = ImmutableEmptySortedBagTest::forEach;
            this.payloads.forEachWith = ImmutableEmptySortedBagTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptySortedBagTest::forEachWithIndex;
            this.payloads.selectToTarget = ImmutableEmptySortedBagTest::selectToTarget;
            this.payloads.selectInstancesOf = ImmutableEmptySortedBagTest::selectInstancesOf;
            this.payloads.collect = ImmutableEmptySortedBagTest::collect;
            this.payloads.collectWith = ImmutableEmptySortedBagTest::collectWith;
            this.payloads.collectToTarget = ImmutableEmptySortedBagTest::collectToTarget;
            this.payloads.flatCollect = ImmutableEmptySortedBagTest::flatCollect;
            this.payloads.flatCollectWithTarget = ImmutableEmptySortedBagTest::flatCollectWithTarget;
            this.payloads.zipWithIndex = ImmutableEmptySortedBagTest::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detectWithIfNone = ImmutableEmptySortedBagTest::detectWithIfNone;
            this.payloads.detectIfNone = ImmutableEmptySortedBagTest::detectIfNone;
            this.payloads.count = ImmutableEmptySortedBagTest::count;
            this.payloads.collectIf = ImmutableEmptySortedBagTest::collectIf;
            this.payloads.iterator = ImmutableEmptySortedBagTest::iterator;
            this.payloads.injectInto = ImmutableEmptySortedBagTest::injectInto;
            this.payloads.testToString = ImmutableEmptySortedBagTest::testToString;
            this.payloads.makeString = ImmutableEmptySortedBagTest::makeString;
            this.payloads.appendString = ImmutableEmptySortedBagTest::appendString;
            this.payloads.toList = ImmutableEmptySortedBagTest::toList;
            this.payloads.toSortedList = ImmutableEmptySortedBagTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableEmptySortedBagTest::toSortedListBy;
            this.payloads.toSortedBagWithComparator = ImmutableEmptySortedBagTest::toSortedBagWithComparator;
            this.payloads.toSortedBagBy = ImmutableEmptySortedBagTest::toSortedBagBy;
            this.payloads.forLoop = ImmutableEmptySortedBagTest::forLoop;
            this.payloads.groupBy = ImmutableEmptySortedBagTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptySortedBagTest::groupByEach;
            this.payloads.groupByWithTarget = ImmutableEmptySortedBagTest::groupByWithTarget;
            this.payloads.groupByEachWithTarget = ImmutableEmptySortedBagTest::groupByEachWithTarget;
            this.payloads.toImmutable = ImmutableEmptySortedBagTest::toImmutable;
            this.payloads.forEachFromTo = ImmutableEmptySortedBagTest::forEachFromTo;
            this.payloads.detectIndex = ImmutableEmptySortedBagTest::detectIndex;
            this.payloads.indexOf = ImmutableEmptySortedBagTest::indexOf;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.distinctView = ImmutableEmptySortedBagTest::distinctView;
            this.payloads.corresponds = ImmutableEmptySortedBagTest::corresponds;
            this.payloads.compareTo = ImmutableEmptySortedBagTest::compareTo;
            this.payloads.selectDuplicates = ImmutableEmptySortedBagTest::selectDuplicates;
            this.payloads.contains = ImmutableEmptySortedBagTest::contains;
            this.payloads.contains_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::contains_null, java.lang.NullPointerException.class);
            this.payloads.containsAllIterable = ImmutableEmptySortedBagTest::containsAllIterable;
            this.payloads.containsAll = ImmutableEmptySortedBagTest::containsAll;
            this.payloads.forEachWithIndexWithFromTo = ImmutableEmptySortedBagTest::forEachWithIndexWithFromTo;
            this.payloads.anySatisfyWithOccurrences = ImmutableEmptySortedBagTest::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = ImmutableEmptySortedBagTest::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = ImmutableEmptySortedBagTest::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = ImmutableEmptySortedBagTest::detectWithOccurrences;
            this.payloads.chunk_large_size = ImmutableEmptySortedBagTest::chunk_large_size;
            this.payloads.detect = ImmutableEmptySortedBagTest::detect;
            this.payloads.allSatisfy = ImmutableEmptySortedBagTest::allSatisfy;
            this.payloads.detectWith = ImmutableEmptySortedBagTest::detectWith;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::max, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_with_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::max_with_comparator, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.toSortedBag = ImmutableEmptySortedBagTest::toSortedBag;
            this.payloads.toSortedMap = ImmutableEmptySortedBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableEmptySortedBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableEmptySortedBagTest::toSortedMapBy;
            this.payloads.toStack = ImmutableEmptySortedBagTest::toStack;
            this.payloads.toStringOfItemToCount = ImmutableEmptySortedBagTest::toStringOfItemToCount;
            this.payloads.groupByUniqueKey = ImmutableEmptySortedBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_target = ImmutableEmptySortedBagTest::groupByUniqueKey_target;
            this.payloads.countByEach = ImmutableEmptySortedBagTest::countByEach;
            this.payloads.countByEach_target = ImmutableEmptySortedBagTest::countByEach_target;
            this.payloads.zip = ImmutableEmptySortedBagTest::zip;
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::min, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_with_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::min_with_comparator, java.util.NoSuchElementException.class);
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedBagTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.newWithTest = ImmutableEmptySortedBagTest::newWithTest;
            this.payloads.newWithAll = ImmutableEmptySortedBagTest::newWithAll;
            this.payloads.newWithout = ImmutableEmptySortedBagTest::newWithout;
            this.payloads.partition = ImmutableEmptySortedBagTest::partition;
            this.payloads.partitionWhile = ImmutableEmptySortedBagTest::partitionWhile;
            this.payloads.toMapOfItemToCount = ImmutableEmptySortedBagTest::toMapOfItemToCount;
            this.payloads.partitionWith = ImmutableEmptySortedBagTest::partitionWith;
            this.payloads.reject = ImmutableEmptySortedBagTest::reject;
            this.payloads.rejectWith = ImmutableEmptySortedBagTest::rejectWith;
            this.payloads.rejectToTarget = ImmutableEmptySortedBagTest::rejectToTarget;
            this.payloads.toSortedSet = ImmutableEmptySortedBagTest::toSortedSet;
            this.payloads.toSortedSetWithComparator = ImmutableEmptySortedBagTest::toSortedSetWithComparator;
            this.payloads.select = ImmutableEmptySortedBagTest::select;
            this.payloads.selectWith = ImmutableEmptySortedBagTest::selectWith;
            this.payloads.takeWhile = ImmutableEmptySortedBagTest::takeWhile;
            this.payloads.distinct = ImmutableEmptySortedBagTest::distinct;
            this.payloads.dropWhile = ImmutableEmptySortedBagTest::dropWhile;
            this.payloads.equalsAndHashCode = ImmutableEmptySortedBagTest::equalsAndHashCode;
            this.payloads.getLast = ImmutableEmptySortedBagTest::getLast;
            this.payloads.getFirst = ImmutableEmptySortedBagTest::getFirst;
            this.payloads.getOnly = ImmutableEmptySortedBagTest::getOnly;
            this.payloads.occurrencesOf = ImmutableEmptySortedBagTest::occurrencesOf;
            this.payloads.isEmpty = ImmutableEmptySortedBagTest::isEmpty;
            this.payloads.anySatisfy = ImmutableEmptySortedBagTest::anySatisfy;
            this.payloads.collectIfToTarget = ImmutableEmptySortedBagTest::collectIfToTarget;
            this.payloads.topOccurrences = ImmutableEmptySortedBagTest::topOccurrences;
            this.payloads.bottomOccurrences = ImmutableEmptySortedBagTest::bottomOccurrences;
            this.payloads.collectWithIndex = ImmutableEmptySortedBagTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableEmptySortedBagTest::collectWithIndexWithTarget;
            this.payloads.collectBoolean = ImmutableEmptySortedBagTest::collectBoolean;
            this.payloads.collectByte = ImmutableEmptySortedBagTest::collectByte;
            this.payloads.collectChar = ImmutableEmptySortedBagTest::collectChar;
            this.payloads.collectDouble = ImmutableEmptySortedBagTest::collectDouble;
            this.payloads.collectFloat = ImmutableEmptySortedBagTest::collectFloat;
            this.payloads.collectInt = ImmutableEmptySortedBagTest::collectInt;
            this.payloads.collectLong = ImmutableEmptySortedBagTest::collectLong;
            this.payloads.collectShort = ImmutableEmptySortedBagTest::collectShort;
            this.payloads.collectBoolean_target = ImmutableEmptySortedBagTest::collectBoolean_target;
            this.payloads.collectByte_target = ImmutableEmptySortedBagTest::collectByte_target;
            this.payloads.collectChar_target = ImmutableEmptySortedBagTest::collectChar_target;
            this.payloads.collectDouble_target = ImmutableEmptySortedBagTest::collectDouble_target;
            this.payloads.collectFloat_target = ImmutableEmptySortedBagTest::collectFloat_target;
            this.payloads.collectInt_target = ImmutableEmptySortedBagTest::collectInt_target;
            this.payloads.collectLong_target = ImmutableEmptySortedBagTest::collectLong_target;
            this.payloads.collectShort_target = ImmutableEmptySortedBagTest::collectShort_target;
            this.payloads.toArray = ImmutableEmptySortedBagTest::toArray;
            this.payloads.take = ImmutableEmptySortedBagTest::take;
            this.payloads.drop = ImmutableEmptySortedBagTest::drop;
            this.payloads.selectUnique = ImmutableEmptySortedBagTest::selectUnique;
        }
    }
}
