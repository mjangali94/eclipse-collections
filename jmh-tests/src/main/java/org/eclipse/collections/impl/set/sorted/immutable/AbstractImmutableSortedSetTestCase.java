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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.sortedset.ImmutableSortedSetMultimap;
import org.eclipse.collections.api.partition.set.sorted.PartitionImmutableSortedSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.set.sorted.SortedSetIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.AddToList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.set.sorted.TreeSortedSetMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableSortedSetTestCase {

    protected abstract ImmutableSortedSet<Integer> classUnderTest();

    protected abstract ImmutableSortedSet<Integer> classUnderTest(Comparator<? super Integer> comparator);

    @Test(expected = NullPointerException.class)
    public void noSupportForNull() {
        this.classUnderTest().newWith(null);
    }

    @Test
    public void equalsAndHashCode() {
        ImmutableSortedSet<Integer> immutable = this.classUnderTest();
        MutableSortedSet<Integer> mutable = TreeSortedSet.newSet(immutable);
        Verify.assertEqualsAndHashCode(mutable, immutable);
        Verify.assertPostSerializedEqualsAndHashCode(immutable);
        Assert.assertNotEquals(FastList.newList(mutable), immutable);
    }

    @Test
    public void newWith() {
        ImmutableSortedSet<Integer> immutable = this.classUnderTest();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Interval.fromTo(0, immutable.size())), immutable.newWith(0).castToSortedSet());
        Assert.assertSame(immutable, immutable.newWith(immutable.size()));
        ImmutableSortedSet<Integer> set = this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Comparators.reverseNaturalOrder(), Interval.oneTo(set.size() + 1)), set.newWith(set.size() + 1).castToSortedSet());
    }

    @Test
    public void newWithout() {
        ImmutableSortedSet<Integer> immutable = this.classUnderTest();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Interval.oneTo(immutable.size() - 1)), immutable.newWithout(immutable.size()).castToSortedSet());
        Assert.assertSame(immutable, immutable.newWithout(immutable.size() + 1));
        ImmutableSortedSet<Integer> set = this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Comparators.reverseNaturalOrder(), Interval.oneTo(set.size() - 1)), set.newWithout(set.size()).castToSortedSet());
    }

    @Test
    public void newWithAll() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedSet<Integer> withAll = set.newWithAll(UnifiedSet.newSet(Interval.fromTo(1, set.size() + 1)));
        Assert.assertNotEquals(set, withAll);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Comparators.reverseNaturalOrder(), Interval.fromTo(1, set.size() + 1)), withAll.castToSortedSet());
    }

    @Test
    public void newWithoutAll() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        ImmutableSortedSet<Integer> withoutAll = set.newWithoutAll(set);
        Assert.assertEquals(SortedSets.immutable.<Integer>of(), withoutAll);
        Assert.assertEquals(Sets.immutable.<Integer>of(), withoutAll);
        ImmutableSortedSet<Integer> largeWithoutAll = set.newWithoutAll(Interval.fromTo(101, 150));
        Assert.assertEquals(set, largeWithoutAll);
        ImmutableSortedSet<Integer> largeWithoutAll2 = set.newWithoutAll(UnifiedSet.newSet(Interval.fromTo(151, 199)));
        Assert.assertEquals(set, largeWithoutAll2);
    }

    @Test
    public void contains() {
        ImmutableSortedSet<Integer> set1 = this.classUnderTest();
        for (int i = 1; i <= set1.size(); i++) {
            Verify.assertContains(i, set1.castToSortedSet());
        }
        Verify.assertNotContains(Integer.valueOf(set1.size() + 1), set1.castToSortedSet());
        SortedSet<Integer> set2 = new TreeSet<>(set1.castToSortedSet());
        Assert.assertThrows(ClassCastException.class, () -> set1.contains(new Object()));
        Assert.assertThrows(ClassCastException.class, () -> set2.contains(new Object()));
        Assert.assertThrows(ClassCastException.class, () -> set1.contains("1"));
        Assert.assertThrows(ClassCastException.class, () -> set2.contains("1"));
        Assert.assertThrows(NullPointerException.class, () -> set1.contains(null));
        Assert.assertThrows(NullPointerException.class, () -> set2.contains(null));
    }

    @Test
    public void containsAllArray() {
        ImmutableSortedSet<Integer> set1 = this.classUnderTest();
        SortedSet<Integer> set2 = new TreeSet<>(set1.castToSortedSet());
        Assert.assertTrue(set1.containsAllArguments(set1.toArray()));
        Assert.assertThrows(NullPointerException.class, () -> set1.containsAllArguments(null, null));
        Assert.assertThrows(NullPointerException.class, () -> set2.containsAll(FastList.newListWith(null, null)));
    }

    @Test
    public void containsAllIterable() {
        ImmutableSortedSet<Integer> set1 = this.classUnderTest();
        SortedSet<Integer> set2 = new TreeSet<>(set1.castToSortedSet());
        Assert.assertTrue(set1.containsAllIterable(Interval.oneTo(set1.size())));
        Assert.assertThrows(NullPointerException.class, () -> set1.containsAllIterable(FastList.newListWith(null, null)));
        Assert.assertThrows(NullPointerException.class, () -> set2.containsAll(FastList.newListWith(null, null)));
    }

    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.of();
        ImmutableSortedSet<Integer> collection = this.classUnderTest();
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void forEach() {
        MutableSet<Integer> result = UnifiedSet.newSet();
        ImmutableSortedSet<Integer> collection = this.classUnderTest();
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(collection, result);
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        set.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Verify.assertListsEqual(result, set.toList());
    }

    @Test
    public void forEachWithIndex() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        set.forEachWithIndex((object, index) -> result.add(object));
        Verify.assertListsEqual(result, set.toList());
    }

    @Test
    public void select() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertIterableEmpty(integers.select(Predicates.greaterThan(integers.size())));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Comparators.reverseNaturalOrder(), Interval.oneTo(integers.size() - 1)), integers.select(Predicates.lessThan(integers.size())).castToSortedSet());
    }

    @Test
    public void selectWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertIterableEmpty(integers.selectWith(Predicates2.greaterThan(), integers.size()));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Comparators.reverseNaturalOrder(), Interval.oneTo(integers.size() - 1)), integers.selectWith(Predicates2.lessThan(), integers.size()).castToSortedSet());
    }

    @Test
    public void selectToTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Verify.assertListsEqual(integers.toList(), integers.select(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Verify.assertEmpty(integers.select(Predicates.greaterThan(integers.size()), FastList.newList()));
    }

    @Test
    public void reject() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(FastList.newList(integers.reject(Predicates.lessThan(integers.size() + 1))));
        Verify.assertSortedSetsEqual(integers.castToSortedSet(), integers.reject(Predicates.greaterThan(integers.size())).castToSortedSet());
    }

    @Test
    public void rejectWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertIterableEmpty(integers.rejectWith(Predicates2.lessThanOrEqualTo(), integers.size()));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Comparators.reverseNaturalOrder(), Interval.oneTo(integers.size() - 1)), integers.rejectWith(Predicates2.greaterThanOrEqualTo(), integers.size()).castToSortedSet());
    }

    @Test
    public void rejectToTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Verify.assertEmpty(integers.reject(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Verify.assertListsEqual(integers.toList(), integers.reject(Predicates.greaterThan(integers.size()), FastList.newList()));
    }

    @Test
    public void selectInstancesOf() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(set, set.selectInstancesOf(Integer.class));
        Verify.assertIterableEmpty(set.selectInstancesOf(Double.class));
        Assert.assertEquals(Collections.<Integer>reverseOrder(), set.selectInstancesOf(Integer.class).comparator());
        Assert.assertEquals(Collections.<Double>reverseOrder(), set.selectInstancesOf(Double.class).comparator());
    }

    @Test
    public void partition() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        PartitionImmutableSortedSet<Integer> partition = integers.partition(Predicates.greaterThan(integers.size()));
        Verify.assertIterableEmpty(partition.getSelected());
        Assert.assertEquals(integers, partition.getRejected());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Test
    public void partitionWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        PartitionImmutableSortedSet<Integer> partition = integers.partitionWith(Predicates2.greaterThan(), integers.size());
        Verify.assertIterableEmpty(partition.getSelected());
        Assert.assertEquals(integers, partition.getRejected());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getSelected().comparator());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition.getRejected().comparator());
    }

    @Test
    public void partitionWhile() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        PartitionImmutableSortedSet<Integer> partition1 = integers.partitionWhile(Predicates.greaterThan(integers.size()));
        Verify.assertIterableEmpty(partition1.getSelected());
        Assert.assertEquals(integers, partition1.getRejected());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition1.getSelected().comparator());
        Assert.assertEquals(Collections.<Integer>reverseOrder(), partition1.getRejected().comparator());
        PartitionImmutableSortedSet<Integer> partition2 = integers.partitionWhile(Predicates.lessThanOrEqualTo(integers.size()));
        Assert.assertEquals(integers, partition2.getSelected());
        Verify.assertIterableEmpty(partition2.getRejected());
    }

    @Test
    public void takeWhile() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedSet<Integer> take1 = integers.takeWhile(Predicates.greaterThan(integers.size()));
        Verify.assertIterableEmpty(take1);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), take1.comparator());
        ImmutableSortedSet<Integer> take2 = integers.takeWhile(Predicates.lessThanOrEqualTo(integers.size()));
        Assert.assertEquals(integers, take2);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), take2.comparator());
    }

    @Test
    public void dropWhile() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedSet<Integer> drop1 = integers.dropWhile(Predicates.greaterThan(integers.size()));
        Assert.assertEquals(integers, drop1);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), drop1.comparator());
        ImmutableSortedSet<Integer> drop2 = integers.dropWhile(Predicates.lessThanOrEqualTo(integers.size()));
        Verify.assertIterableEmpty(drop2);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), drop2.comparator());
    }

    @Test
    public void collect() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertListsEqual(integers.toList(), integers.collect(Functions.getIntegerPassThru()).castToList());
    }

    @Test
    public void collectWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertListsEqual(integers.toList(), integers.collectWith((value, parameter) -> value / parameter, 1).castToList());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(4), 0), PrimitiveTuples.pair(Integer.valueOf(3), 1), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 3)), integers.collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(4), 0), PrimitiveTuples.pair(Integer.valueOf(3), 1), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 3)), integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndexWithTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(4, 2), integers.selectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(3, 1), integers.rejectWithIndex((each, index) -> index % 2 == 0, Lists.mutable.empty()));
    }

    @Test
    public void collectToTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.collect(Functions.getIntegerPassThru(), UnifiedSet.newSet()));
        Verify.assertListsEqual(integers.toList(), integers.collect(Functions.getIntegerPassThru(), FastList.newList()));
    }

    @Test
    public void flatCollect() {
        ImmutableList<String> actual = this.classUnderTest(Collections.reverseOrder()).flatCollect(integer -> Lists.fixedSize.of(String.valueOf(integer)));
        ImmutableList<String> expected = this.classUnderTest(Collections.reverseOrder()).collect(String::valueOf);
        Assert.assertEquals(expected, actual);
        Verify.assertListsEqual(expected.toList(), actual.toList());
    }

    @Test
    public void flatCollectWithTarget() {
        MutableSet<String> actual = this.classUnderTest().flatCollect(integer -> Lists.fixedSize.of(String.valueOf(integer)), UnifiedSet.newSet());
        ImmutableList<String> expected = this.classUnderTest().collect(String::valueOf);
        Verify.assertSetsEqual(expected.toSet(), actual);
    }

    @Test
    public void zip() {
        ImmutableSortedSet<Integer> immutableSet = this.classUnderTest(Collections.reverseOrder());
        List<Object> nulls = Collections.nCopies(immutableSet.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableSet.size() + 1, null);
        List<Object> nullsMinusOne = Collections.nCopies(immutableSet.size() - 1, null);
        ImmutableList<Pair<Integer, Object>> pairs = immutableSet.zip(nulls);
        Assert.assertEquals(immutableSet.toList(), pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Verify.assertListsEqual(FastList.newList(Interval.fromTo(immutableSet.size(), 1)), pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).toList());
        Assert.assertEquals(FastList.newList(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableList<Pair<Integer, Object>> pairsPlusOne = immutableSet.zip(nullsPlusOne);
        Assert.assertEquals(immutableSet.toList(), pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Verify.assertListsEqual(FastList.newList(Interval.fromTo(immutableSet.size(), 1)), pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).castToList());
        Assert.assertEquals(FastList.newList(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableList<Pair<Integer, Object>> pairsMinusOne = immutableSet.zip(nullsMinusOne);
        Verify.assertListsEqual(FastList.newList(Interval.fromTo(immutableSet.size(), 2)), pairsMinusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).castToList());
        Assert.assertEquals(immutableSet.zip(nulls), immutableSet.zip(nulls, FastList.newList()));
        FastList<Holder> holders = FastList.newListWith(new Holder(1), new Holder(2), new Holder(3));
        ImmutableList<Pair<Integer, Holder>> zipped = immutableSet.zip(holders);
        Verify.assertSize(3, zipped.castToList());
        AbstractImmutableSortedSetTestCase.Holder two = new Holder(-1);
        AbstractImmutableSortedSetTestCase.Holder two1 = new Holder(-1);
        Assert.assertEquals(Tuples.pair(10, two1), zipped.newWith(Tuples.pair(10, two)).getLast());
        Assert.assertEquals(Tuples.pair(1, new Holder(3)), this.classUnderTest().zip(holders.reverseThis()).getFirst());
    }

    @Test
    public void zipWithIndex() {
        ImmutableSortedSet<Integer> immutableSet = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedSet<Pair<Integer, Integer>> pairs = immutableSet.zipWithIndex();
        Assert.assertEquals(immutableSet.toList(), pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(Interval.zeroTo(immutableSet.size() - 1).toList(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableSet.zipWithIndex(), immutableSet.zipWithIndex(UnifiedSet.newSet()));
        Verify.assertListsEqual(TreeSortedSet.newSet(Collections.reverseOrder(), Interval.oneTo(immutableSet.size())).toList(), pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).toList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.classUnderTest().chunk(0);
    }

    @Test
    public void chunk_large_size() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().chunk(10).getFirst());
        Verify.assertInstanceOf(ImmutableSortedSet.class, this.classUnderTest().chunk(10).getFirst());
    }

    @Test
    public void detect() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.detect(Predicates.equal(1)));
        Assert.assertNull(integers.detect(Predicates.equal(integers.size() + 1)));
    }

    @Test
    public void detectWith() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.detectWith(Object::equals, Integer.valueOf(1)));
        Assert.assertNull(integers.detectWith(Object::equals, Integer.valueOf(integers.size() + 1)));
    }

    @Test
    public void detectWithIfNone() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Function0<Integer> function = new PassThruFunction0<>(integers.size() + 1);
        Integer sum = Integer.valueOf(integers.size() + 1);
        Assert.assertEquals(Integer.valueOf(1), integers.detectWithIfNone(Object::equals, Integer.valueOf(1), function));
        Assert.assertEquals(Integer.valueOf(integers.size() + 1), integers.detectWithIfNone(Object::equals, sum, function));
    }

    @Test
    public void detectIfNone() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Function0<Integer> function = new PassThruFunction0<>(integers.size() + 1);
        Assert.assertEquals(Integer.valueOf(1), integers.detectIfNone(Predicates.equal(1), function));
        Assert.assertEquals(Integer.valueOf(integers.size() + 1), integers.detectIfNone(Predicates.equal(integers.size() + 1), function));
    }

    @Test
    public void detectIndex() {
        ImmutableSortedSet<Integer> integers1 = this.classUnderTest();
        Assert.assertEquals(1, integers1.detectIndex(integer -> integer % 2 == 0));
        Assert.assertEquals(0, integers1.detectIndex(integer -> integer % 2 != 0));
        Assert.assertEquals(-1, integers1.detectIndex(integer -> integer % 5 == 0));
        ImmutableSortedSet<Integer> integers2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(0, integers2.detectIndex(integer -> integer % 2 == 0));
        Assert.assertEquals(1, integers2.detectIndex(integer -> integer % 2 != 0));
        Assert.assertEquals(-1, integers2.detectIndex(integer -> integer % 5 == 0));
    }

    @Test
    public void corresponds() {
        ImmutableSortedSet<Integer> integers1 = this.classUnderTest();
        Assert.assertFalse(integers1.corresponds(this.classUnderTest().newWith(100), Predicates2.alwaysTrue()));
        ImmutableList<Integer> integers2 = integers1.collect(integers -> integers + 1);
        Assert.assertTrue(integers1.corresponds(integers2, Predicates2.lessThan()));
        Assert.assertFalse(integers1.corresponds(integers2, Predicates2.greaterThan()));
        ImmutableSortedSet<Integer> integers3 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertFalse(integers3.corresponds(integers1, Predicates2.equal()));
    }

    @Test
    public void allSatisfy() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(integers.allSatisfy(Integer.valueOf(0)::equals));
    }

    @Test
    public void anySatisfy() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfy(String.class::isInstance));
        Assert.assertTrue(integers.anySatisfy(Integer.class::isInstance));
    }

    @Test
    public void count() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers.size(), integers.count(Integer.class::isInstance));
        Assert.assertEquals(0, integers.count(String.class::isInstance));
    }

    @Test
    public void collectIf() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertListsEqual(integers.toList(), integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru()).toList());
    }

    @Test
    public void collectIfToTarget() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Verify.assertSetsEqual(integers.toSet(), integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru(), UnifiedSet.newSet()));
    }

    @Test
    public void getFirst() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.getFirst());
        ImmutableSortedSet<Integer> revInt = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Integer.valueOf(revInt.size()), revInt.getFirst());
    }

    @Test
    public void getLast() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(integers.size()), integers.getLast());
        ImmutableSortedSet<Integer> revInt = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Integer.valueOf(1), revInt.getLast());
    }

    @Test
    public void isEmpty() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        Assert.assertFalse(set.isEmpty());
        Assert.assertTrue(set.notEmpty());
    }

    @Test
    public void iterator() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Integer integer = iterator.next();
            Assert.assertEquals(i + 1, integer.intValue());
        }
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
        Iterator<Integer> intItr = integers.iterator();
        intItr.next();
        Assert.assertThrows(UnsupportedOperationException.class, intItr::remove);
    }

    @Test
    public void injectInto() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        Integer result = integers.injectInto(0, AddFunction.INTEGER);
        Assert.assertEquals(FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_INT), result.intValue());
    }

    @Test
    public void toArray() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<Integer> copy = FastList.newList(integers);
        Assert.assertArrayEquals(integers.toArray(), copy.toArray());
        Assert.assertArrayEquals(integers.toArray(new Integer[integers.size()]), copy.toArray(new Integer[integers.size()]));
    }

    @Test
    public void testToString() {
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), this.classUnderTest().toString());
    }

    @Test
    public void makeString() {
        Assert.assertEquals(FastList.newList(this.classUnderTest()).makeString(), this.classUnderTest().makeString());
    }

    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        this.classUnderTest().appendString(builder);
        Assert.assertEquals(FastList.newList(this.classUnderTest()).makeString(), builder.toString());
    }

    @Test
    public void toList() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<Integer> list = integers.toList();
        Verify.assertEqualsAndHashCode(FastList.newList(integers), list);
    }

    @Test
    public void toSortedList() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        MutableList<Integer> copy = FastList.newList(integers);
        MutableList<Integer> list = integers.toSortedList(Collections.reverseOrder());
        Assert.assertEquals(copy.sortThis(Collections.reverseOrder()), list);
        MutableList<Integer> list2 = integers.toSortedList();
        Verify.assertListsEqual(copy.sortThis(), list2);
    }

    @Test
    public void toSortedListBy() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        MutableList<Integer> list = integers.toSortedListBy(String::valueOf);
        Assert.assertEquals(integers.toList(), list);
    }

    @Test
    public void toSortedSet() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableSortedSet<Integer> set = integers.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), set);
    }

    @Test
    public void toSortedSetWithComparator() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        MutableSortedSet<Integer> set = integers.toSortedSet(Collections.reverseOrder());
        Assert.assertEquals(integers.toSet(), set);
        Assert.assertEquals(integers.toSortedList(Comparators.reverseNaturalOrder()), set.toList());
    }

    @Test
    public void toSortedSetBy() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        MutableSortedSet<Integer> set = integers.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(integers), set);
    }

    @Test
    public void toSortedMap() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        MutableSortedMap<Integer, String> map = integers.toSortedMap(Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertMapsEqual(integers.toMap(Functions.getIntegerPassThru(), String::valueOf), map);
        Verify.assertListsEqual(Interval.oneTo(integers.size()), map.keySet().toList());
    }

    @Test
    public void toSortedMap_with_comparator() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        MutableSortedMap<Integer, String> map = integers.toSortedMap(Comparators.reverseNaturalOrder(), Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertMapsEqual(integers.toMap(Functions.getIntegerPassThru(), String::valueOf), map);
        Verify.assertListsEqual(Interval.fromTo(integers.size(), 1), map.keySet().toList());
    }

    @Test
    public void toSortedMapBy() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest();
        MutableSortedMap<Integer, String> map = integers.toSortedMapBy(key -> -key, Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertMapsEqual(integers.toMap(Functions.getIntegerPassThru(), String::valueOf), map);
        Verify.assertListsEqual(Interval.fromTo(integers.size(), 1), map.keySet().toList());
    }

    @Test
    public void forLoop() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        for (Integer each : set) {
            Assert.assertNotNull(each);
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemove() {
        this.classUnderTest().iterator().remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.classUnderTest().castToSortedSet().add(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().castToSortedSet().remove(Integer.valueOf(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().castToSortedSet().clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().castToSortedSet().removeAll(Lists.fixedSize.of());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.classUnderTest().castToSortedSet().retainAll(Lists.fixedSize.of());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() {
        this.classUnderTest().castToSortedSet().addAll(Lists.fixedSize.of());
    }

    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().min(Integer::compareTo));
    }

    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().max(Comparators.reverse(Integer::compareTo)));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().min());
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(Integer.valueOf(this.classUnderTest().size()), this.classUnderTest().max());
    }

    @Test
    public void minBy() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().minBy(String::valueOf));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(Integer.valueOf(this.classUnderTest().size()), this.classUnderTest().maxBy(String::valueOf));
    }

    @Test
    public void groupBy() {
        ImmutableSortedSet<Integer> undertest = this.classUnderTest();
        ImmutableSortedSetMultimap<Integer, Integer> actual = undertest.groupBy(Functions.getPassThru());
        ImmutableSortedSetMultimap<Integer, Integer> expected = TreeSortedSet.newSet(undertest).groupBy(Functions.getPassThru()).toImmutable();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByEach() {
        ImmutableSortedSet<Integer> undertest = this.classUnderTest(Collections.reverseOrder());
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        ImmutableSortedSetMultimap<Integer, Integer> actual = undertest.groupByEach(function);
        ImmutableSortedSetMultimap<Integer, Integer> expected = TreeSortedSet.newSet(undertest).groupByEach(function).toImmutable();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByWithTarget() {
        ImmutableSortedSet<Integer> undertest = this.classUnderTest();
        TreeSortedSetMultimap<Integer, Integer> actual = undertest.groupBy(Functions.getPassThru(), TreeSortedSetMultimap.newMultimap());
        TreeSortedSetMultimap<Integer, Integer> expected = TreeSortedSet.newSet(undertest).groupBy(Functions.getPassThru());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByEachWithTarget() {
        ImmutableSortedSet<Integer> undertest = this.classUnderTest();
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        TreeSortedSetMultimap<Integer, Integer> actual = undertest.groupByEach(function, TreeSortedSetMultimap.newMultimap());
        TreeSortedSetMultimap<Integer, Integer> expected = TreeSortedSet.newSet(undertest).groupByEach(function);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByUniqueKey() {
        Assert.assertEquals(this.classUnderTest().toBag().groupByUniqueKey(id -> id), this.classUnderTest().groupByUniqueKey(id -> id));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws() {
        this.classUnderTest(Collections.reverseOrder()).groupByUniqueKey(Functions.getFixedValue(1));
    }

    @Test
    public void groupByUniqueKey_target() {
        Assert.assertEquals(this.classUnderTest().groupByUniqueKey(id -> id), this.classUnderTest().groupByUniqueKey(id -> id, UnifiedMap.newMap()));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws() {
        this.classUnderTest(Collections.reverseOrder()).groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(2, 2));
    }

    @Test
    public void union() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        ImmutableSortedSet<Integer> union = set.union(UnifiedSet.newSet(Interval.fromTo(set.size(), set.size() + 3)));
        Verify.assertSize(set.size() + 3, union.castToSortedSet());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSet(Interval.oneTo(set.size() + 3)), union.castToSortedSet());
        Assert.assertEquals(set, set.union(UnifiedSet.newSet()));
    }

    @Test
    public void unionInto() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        MutableSet<Integer> union = set.unionInto(UnifiedSet.newSet(Interval.fromTo(set.size(), set.size() + 3)), UnifiedSet.newSet());
        Verify.assertSize(set.size() + 3, union);
        Assert.assertTrue(union.containsAllIterable(Interval.oneTo(set.size() + 3)));
        Assert.assertEquals(set, set.unionInto(UnifiedSet.newSetWith(), UnifiedSet.newSet()));
    }

    @Test
    public void intersect() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedSet<Integer> intersect = set.intersect(UnifiedSet.newSet(Interval.oneTo(set.size() + 2)));
        Verify.assertSize(set.size(), intersect.castToSortedSet());
        Verify.assertSortedSetsEqual(set.castToSortedSet(), intersect.castToSortedSet());
    }

    @Test
    public void intersectInto() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        MutableSet<Integer> intersect = set.intersectInto(UnifiedSet.newSet(Interval.oneTo(set.size() + 2)), UnifiedSet.newSet());
        Verify.assertSize(set.size(), intersect);
        Assert.assertEquals(set, intersect);
        Verify.assertEmpty(set.intersectInto(UnifiedSet.newSet(Interval.fromTo(set.size() + 1, set.size() + 4)), UnifiedSet.newSet()));
    }

    @Test
    public void difference() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        ImmutableSortedSet<Integer> difference = set.difference(UnifiedSet.newSet(Interval.fromTo(2, set.size() + 1)));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1), difference.castToSortedSet());
        ImmutableSortedSet<Integer> difference2 = set.difference(UnifiedSet.newSet(Interval.fromTo(2, set.size() + 2)));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1), difference2.castToSortedSet());
    }

    @Test
    public void differenceInto() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        MutableSet<Integer> difference = set.differenceInto(UnifiedSet.newSet(Interval.fromTo(2, set.size() + 1)), UnifiedSet.newSet());
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1), difference);
    }

    @Test
    public void symmetricDifference() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedSet<Integer> difference = set.symmetricDifference(UnifiedSet.newSet(Interval.fromTo(2, set.size() + 1)));
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 1, set.size() + 1), difference.castToSortedSet());
    }

    @Test
    public void symmetricDifferenceInto() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        MutableSet<Integer> difference = set.symmetricDifferenceInto(UnifiedSet.newSet(Interval.fromTo(2, set.size() + 1)), UnifiedSet.newSet());
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, set.size() + 1), difference);
    }

    @Test
    public void isSubsetOf() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        Assert.assertTrue(set.isSubsetOf(set));
    }

    @Test
    public void isProperSubsetOf() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        Assert.assertTrue(set.isProperSubsetOf(Interval.oneTo(set.size() + 1).toSet()));
        Assert.assertFalse(set.isProperSubsetOf(set));
    }

    @Test
    public void powerSet() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        ImmutableSortedSet<SortedSetIterable<Integer>> powerSet = set.powerSet();
        Verify.assertSize((int) StrictMath.pow(2, set.size()), powerSet.castToSortedSet());
        Verify.assertContains(UnifiedSet.<String>newSet(), powerSet.toSet());
        Verify.assertContains(set, powerSet.toSet());
        Verify.assertInstanceOf(ImmutableSortedSet.class, powerSet);
        Verify.assertInstanceOf(ImmutableSortedSet.class, powerSet.getLast());
    }

    @Test
    public void cartesianProduct() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        LazyIterable<Pair<Integer, Integer>> cartesianProduct = set.cartesianProduct(UnifiedSet.newSet(Interval.oneTo(set.size())));
        Assert.assertEquals(set.size() * set.size(), cartesianProduct.size());
        Assert.assertEquals(set, cartesianProduct.select(Predicates.attributeEqual((Function<Pair<?, Integer>, Integer>) Pair::getTwo, 1)).collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).toSet());
    }

    @Test
    public void distinct() {
        ImmutableSortedSet<Integer> set1 = this.classUnderTest();
        Assert.assertSame(set1, set1.distinct());
        ImmutableSortedSet<Integer> set2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertSame(set2, set2.distinct());
    }

    @Test
    public void indexOf() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(0, integers.indexOf(4));
        Assert.assertEquals(1, integers.indexOf(3));
        Assert.assertEquals(2, integers.indexOf(2));
        Assert.assertEquals(3, integers.indexOf(1));
        Assert.assertEquals(-1, integers.indexOf(0));
        Assert.assertEquals(-1, integers.indexOf(5));
    }

    @Test
    public void forEachFromTo() {
        MutableList<Integer> result = FastList.newList();
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        integers.forEach(1, 2, result::add);
        Assert.assertEquals(Lists.immutable.with(3, 2), result);
        MutableList<Integer> result2 = FastList.newList();
        integers.forEach(0, 3, result2::add);
        Assert.assertEquals(Lists.immutable.with(4, 3, 2, 1), result2);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(-1, 0, result::add));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(0, -1, result::add));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.forEach(2, 1, result::add));
    }

    @Test
    public void forEachWithIndexWithFromTo() {
        ImmutableSortedSet<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        StringBuilder builder = new StringBuilder();
        integers.forEachWithIndex(1, 2, (each, index) -> builder.append(each).append(index));
        Assert.assertEquals("3122", builder.toString());
        MutableList<Integer> result2 = Lists.mutable.of();
        integers.forEachWithIndex(0, 3, new AddToList(result2));
        Assert.assertEquals(Lists.immutable.with(4, 3, 2, 1), result2);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(-1, 0, new AddToList(result2)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(0, -1, new AddToList(result2)));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.forEachWithIndex(2, 1, new AddToList(result2)));
    }

    @Test
    public void toStack() {
        ImmutableSortedSet<Integer> set = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(ArrayStack.newStackWith(4, 3, 2, 1), set.toStack());
    }

    @Test
    public void toImmutable() {
        ImmutableSortedSet<Integer> set = this.classUnderTest();
        ImmutableSortedSet<Integer> actual = set.toImmutable();
        Assert.assertEquals(set, actual);
        Assert.assertSame(set, actual);
    }

    @Test
    public void take() {
        ImmutableSortedSet<Integer> integers1 = this.classUnderTest();
        Assert.assertEquals(SortedSets.immutable.of(integers1.comparator()), integers1.take(0));
        Assert.assertSame(integers1.comparator(), integers1.take(0).comparator());
        Assert.assertEquals(SortedSets.immutable.of(integers1.comparator(), 1, 2, 3), integers1.take(3));
        Assert.assertSame(integers1.comparator(), integers1.take(3).comparator());
        Assert.assertEquals(SortedSets.immutable.of(integers1.comparator(), 1, 2, 3), integers1.take(integers1.size() - 1));
        ImmutableSortedSet<Integer> integers2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertSame(integers2, integers2.take(integers2.size()));
        Assert.assertSame(integers2, integers2.take(10));
        Assert.assertSame(integers2, integers2.take(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_throws() {
        this.classUnderTest().take(-1);
    }

    @Test
    public void drop() {
        ImmutableSortedSet<Integer> integers1 = this.classUnderTest();
        Assert.assertSame(integers1, integers1.drop(0));
        Assert.assertSame(integers1.comparator(), integers1.drop(0).comparator());
        Assert.assertEquals(SortedSets.immutable.of(integers1.comparator(), 4), integers1.drop(3));
        Assert.assertSame(integers1.comparator(), integers1.drop(3).comparator());
        Assert.assertEquals(SortedSets.immutable.of(integers1.comparator(), 4), integers1.drop(integers1.size() - 1));
        ImmutableSortedSet<Integer> expectedSet = SortedSets.immutable.of(Comparators.reverseNaturalOrder());
        ImmutableSortedSet<Integer> integers2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(expectedSet, integers2.drop(integers2.size()));
        Assert.assertEquals(expectedSet, integers2.drop(10));
        Assert.assertEquals(expectedSet, integers2.drop(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_throws() {
        this.classUnderTest().drop(-1);
    }

    @Test
    public abstract void subSet();

    @Test
    public abstract void headSet();

    @Test
    public abstract void tailSet();

    @Test
    public abstract void collectBoolean();

    @Test
    public abstract void collectByte();

    @Test
    public abstract void collectChar();

    @Test
    public abstract void collectDouble();

    @Test
    public abstract void collectFloat();

    @Test
    public abstract void collectInt();

    @Test
    public abstract void collectLong();

    @Test
    public abstract void collectShort();

    private static final class Holder {

        private final int number;

        private Holder(int i) {
            this.number = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Holder holder = (Holder) o;
            return this.number == holder.number;
        }

        @Override
        public int hashCode() {
            return this.number;
        }

        @Override
        public String toString() {
            return String.valueOf(this.number);
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableSortedSetTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noSupportForNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noSupportForNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfToTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEachWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEachWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_unionInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.unionInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_differenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.differenceInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifferenceInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifferenceInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_powerSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.powerSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.headSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tailSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableSortedSetTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> noSupportForNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> newWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectIfToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> unionInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> intersectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> differenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> symmetricDifferenceInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> powerSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> subSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> headSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> tailSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedSetTestCase> collectShort;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.noSupportForNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::noSupportForNull, java.lang.NullPointerException.class);
            this.payloads.equalsAndHashCode = AbstractImmutableSortedSetTestCase::equalsAndHashCode;
            this.payloads.newWith = AbstractImmutableSortedSetTestCase::newWith;
            this.payloads.newWithout = AbstractImmutableSortedSetTestCase::newWithout;
            this.payloads.newWithAll = AbstractImmutableSortedSetTestCase::newWithAll;
            this.payloads.newWithoutAll = AbstractImmutableSortedSetTestCase::newWithoutAll;
            this.payloads.contains = AbstractImmutableSortedSetTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableSortedSetTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableSortedSetTestCase::containsAllIterable;
            this.payloads.tap = AbstractImmutableSortedSetTestCase::tap;
            this.payloads.forEach = AbstractImmutableSortedSetTestCase::forEach;
            this.payloads.forEachWith = AbstractImmutableSortedSetTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractImmutableSortedSetTestCase::forEachWithIndex;
            this.payloads.select = AbstractImmutableSortedSetTestCase::select;
            this.payloads.selectWith = AbstractImmutableSortedSetTestCase::selectWith;
            this.payloads.selectToTarget = AbstractImmutableSortedSetTestCase::selectToTarget;
            this.payloads.reject = AbstractImmutableSortedSetTestCase::reject;
            this.payloads.rejectWith = AbstractImmutableSortedSetTestCase::rejectWith;
            this.payloads.rejectToTarget = AbstractImmutableSortedSetTestCase::rejectToTarget;
            this.payloads.selectInstancesOf = AbstractImmutableSortedSetTestCase::selectInstancesOf;
            this.payloads.partition = AbstractImmutableSortedSetTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableSortedSetTestCase::partitionWith;
            this.payloads.partitionWhile = AbstractImmutableSortedSetTestCase::partitionWhile;
            this.payloads.takeWhile = AbstractImmutableSortedSetTestCase::takeWhile;
            this.payloads.dropWhile = AbstractImmutableSortedSetTestCase::dropWhile;
            this.payloads.collect = AbstractImmutableSortedSetTestCase::collect;
            this.payloads.collectWith = AbstractImmutableSortedSetTestCase::collectWith;
            this.payloads.collectWithIndex = AbstractImmutableSortedSetTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableSortedSetTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndexWithTarget = AbstractImmutableSortedSetTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndexWithTarget = AbstractImmutableSortedSetTestCase::rejectWithIndexWithTarget;
            this.payloads.collectToTarget = AbstractImmutableSortedSetTestCase::collectToTarget;
            this.payloads.flatCollect = AbstractImmutableSortedSetTestCase::flatCollect;
            this.payloads.flatCollectWithTarget = AbstractImmutableSortedSetTestCase::flatCollectWithTarget;
            this.payloads.zip = AbstractImmutableSortedSetTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableSortedSetTestCase::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractImmutableSortedSetTestCase::chunk_large_size;
            this.payloads.detect = AbstractImmutableSortedSetTestCase::detect;
            this.payloads.detectWith = AbstractImmutableSortedSetTestCase::detectWith;
            this.payloads.detectWithIfNone = AbstractImmutableSortedSetTestCase::detectWithIfNone;
            this.payloads.detectIfNone = AbstractImmutableSortedSetTestCase::detectIfNone;
            this.payloads.detectIndex = AbstractImmutableSortedSetTestCase::detectIndex;
            this.payloads.corresponds = AbstractImmutableSortedSetTestCase::corresponds;
            this.payloads.allSatisfy = AbstractImmutableSortedSetTestCase::allSatisfy;
            this.payloads.anySatisfy = AbstractImmutableSortedSetTestCase::anySatisfy;
            this.payloads.count = AbstractImmutableSortedSetTestCase::count;
            this.payloads.collectIf = AbstractImmutableSortedSetTestCase::collectIf;
            this.payloads.collectIfToTarget = AbstractImmutableSortedSetTestCase::collectIfToTarget;
            this.payloads.getFirst = AbstractImmutableSortedSetTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableSortedSetTestCase::getLast;
            this.payloads.isEmpty = AbstractImmutableSortedSetTestCase::isEmpty;
            this.payloads.iterator = AbstractImmutableSortedSetTestCase::iterator;
            this.payloads.injectInto = AbstractImmutableSortedSetTestCase::injectInto;
            this.payloads.toArray = AbstractImmutableSortedSetTestCase::toArray;
            this.payloads.testToString = AbstractImmutableSortedSetTestCase::testToString;
            this.payloads.makeString = AbstractImmutableSortedSetTestCase::makeString;
            this.payloads.appendString = AbstractImmutableSortedSetTestCase::appendString;
            this.payloads.toList = AbstractImmutableSortedSetTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableSortedSetTestCase::toSortedList;
            this.payloads.toSortedListBy = AbstractImmutableSortedSetTestCase::toSortedListBy;
            this.payloads.toSortedSet = AbstractImmutableSortedSetTestCase::toSortedSet;
            this.payloads.toSortedSetWithComparator = AbstractImmutableSortedSetTestCase::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = AbstractImmutableSortedSetTestCase::toSortedSetBy;
            this.payloads.toSortedMap = AbstractImmutableSortedSetTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractImmutableSortedSetTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractImmutableSortedSetTestCase::toSortedMapBy;
            this.payloads.forLoop = AbstractImmutableSortedSetTestCase::forLoop;
            this.payloads.iteratorRemove = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::iteratorRemove, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::add, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::addAll, java.lang.UnsupportedOperationException.class);
            this.payloads.min = AbstractImmutableSortedSetTestCase::min;
            this.payloads.max = AbstractImmutableSortedSetTestCase::max;
            this.payloads.min_without_comparator = AbstractImmutableSortedSetTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractImmutableSortedSetTestCase::max_without_comparator;
            this.payloads.minBy = AbstractImmutableSortedSetTestCase::minBy;
            this.payloads.maxBy = AbstractImmutableSortedSetTestCase::maxBy;
            this.payloads.groupBy = AbstractImmutableSortedSetTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableSortedSetTestCase::groupByEach;
            this.payloads.groupByWithTarget = AbstractImmutableSortedSetTestCase::groupByWithTarget;
            this.payloads.groupByEachWithTarget = AbstractImmutableSortedSetTestCase::groupByEachWithTarget;
            this.payloads.groupByUniqueKey = AbstractImmutableSortedSetTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractImmutableSortedSetTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.union = AbstractImmutableSortedSetTestCase::union;
            this.payloads.unionInto = AbstractImmutableSortedSetTestCase::unionInto;
            this.payloads.intersect = AbstractImmutableSortedSetTestCase::intersect;
            this.payloads.intersectInto = AbstractImmutableSortedSetTestCase::intersectInto;
            this.payloads.difference = AbstractImmutableSortedSetTestCase::difference;
            this.payloads.differenceInto = AbstractImmutableSortedSetTestCase::differenceInto;
            this.payloads.symmetricDifference = AbstractImmutableSortedSetTestCase::symmetricDifference;
            this.payloads.symmetricDifferenceInto = AbstractImmutableSortedSetTestCase::symmetricDifferenceInto;
            this.payloads.isSubsetOf = AbstractImmutableSortedSetTestCase::isSubsetOf;
            this.payloads.isProperSubsetOf = AbstractImmutableSortedSetTestCase::isProperSubsetOf;
            this.payloads.powerSet = AbstractImmutableSortedSetTestCase::powerSet;
            this.payloads.cartesianProduct = AbstractImmutableSortedSetTestCase::cartesianProduct;
            this.payloads.distinct = AbstractImmutableSortedSetTestCase::distinct;
            this.payloads.indexOf = AbstractImmutableSortedSetTestCase::indexOf;
            this.payloads.forEachFromTo = AbstractImmutableSortedSetTestCase::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = AbstractImmutableSortedSetTestCase::forEachWithIndexWithFromTo;
            this.payloads.toStack = AbstractImmutableSortedSetTestCase::toStack;
            this.payloads.toImmutable = AbstractImmutableSortedSetTestCase::toImmutable;
            this.payloads.take = AbstractImmutableSortedSetTestCase::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = AbstractImmutableSortedSetTestCase::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedSetTestCase::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.subSet = AbstractImmutableSortedSetTestCase::subSet;
            this.payloads.headSet = AbstractImmutableSortedSetTestCase::headSet;
            this.payloads.tailSet = AbstractImmutableSortedSetTestCase::tailSet;
            this.payloads.collectBoolean = AbstractImmutableSortedSetTestCase::collectBoolean;
            this.payloads.collectByte = AbstractImmutableSortedSetTestCase::collectByte;
            this.payloads.collectChar = AbstractImmutableSortedSetTestCase::collectChar;
            this.payloads.collectDouble = AbstractImmutableSortedSetTestCase::collectDouble;
            this.payloads.collectFloat = AbstractImmutableSortedSetTestCase::collectFloat;
            this.payloads.collectInt = AbstractImmutableSortedSetTestCase::collectInt;
            this.payloads.collectLong = AbstractImmutableSortedSetTestCase::collectLong;
            this.payloads.collectShort = AbstractImmutableSortedSetTestCase::collectShort;
        }
    }
}
