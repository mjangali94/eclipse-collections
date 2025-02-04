/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.list.ImmutableListMultimap;
import org.eclipse.collections.api.partition.list.PartitionImmutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.collection.immutable.AbstractImmutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.utility.Iterate;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public abstract class AbstractImmutableListTestCase extends AbstractImmutableCollectionTestCase {

    @Override
    protected abstract ImmutableList<Integer> classUnderTest();

    @Override
    protected <T> MutableList<T> newMutable() {
        return FastList.newList();
    }

    @Test
    public void equalsAndHashCode() {
        ImmutableList<Integer> immutable = this.classUnderTest();
        MutableList<Integer> mutable1 = FastList.newList(immutable);
        ImmutableList<Integer> immutable1 = mutable1.toImmutable();
        List<Integer> mutable2 = new LinkedList<>(mutable1);
        List<Integer> mutable3 = new ArrayList<>(mutable1);
        Verify.assertEqualsAndHashCode(mutable1, immutable);
        Verify.assertEqualsAndHashCode(immutable1, immutable);
        Verify.assertEqualsAndHashCode(mutable2, immutable);
        Verify.assertEqualsAndHashCode(mutable3, immutable);
        Verify.assertPostSerializedEqualsAndHashCode(immutable);
        Assert.assertNotEquals(immutable, UnifiedSet.newSet(mutable1));
        mutable1.add(null);
        mutable2.add(null);
        mutable3.add(null);
        Assert.assertNotEquals(mutable1, immutable);
        Assert.assertNotEquals(mutable2, immutable);
        Assert.assertNotEquals(mutable3, immutable);
        mutable1.remove(null);
        mutable2.remove(null);
        mutable3.remove(null);
        Verify.assertEqualsAndHashCode(mutable1, immutable);
        Verify.assertEqualsAndHashCode(mutable2, immutable);
        Verify.assertEqualsAndHashCode(mutable3, immutable);
        if (immutable.size() > 2) {
            mutable1.set(2, null);
            mutable2.set(2, null);
            mutable3.set(2, null);
            Assert.assertNotEquals(mutable1, immutable);
            Assert.assertNotEquals(mutable2, immutable);
            Assert.assertNotEquals(mutable3, immutable);
            mutable1.remove(2);
            mutable2.remove(2);
            mutable3.remove(2);
            Assert.assertNotEquals(mutable1, immutable);
            Assert.assertNotEquals(mutable2, immutable);
            Assert.assertNotEquals(mutable3, immutable);
        }
    }

    @Test
    public void contains() {
        ImmutableList<Integer> list = this.classUnderTest();
        for (int i = 1; i <= list.size(); i++) {
            Assert.assertTrue(list.contains(i));
        }
        Assert.assertFalse(list.contains(list.size() + 1));
    }

    @Test
    public void containsAll() {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toList()));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.classUnderTest().containsAllArguments(this.classUnderTest().toArray()));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.classUnderTest().containsAllIterable(this.classUnderTest()));
    }

    @Test
    public void indexOf() {
        Assert.assertEquals(0, this.classUnderTest().indexOf(1));
        Assert.assertEquals(-1, this.classUnderTest().indexOf(null));
        ImmutableList<Integer> immutableList = this.classUnderTest().newWith(null);
        Assert.assertEquals(immutableList.size() - 1, immutableList.indexOf(null));
        Assert.assertEquals(-1, this.classUnderTest().indexOf(Integer.MAX_VALUE));
    }

    @Test
    public void lastIndexOf() {
        Assert.assertEquals(0, this.classUnderTest().lastIndexOf(1));
        Assert.assertEquals(-1, this.classUnderTest().lastIndexOf(null));
        Assert.assertEquals(-1, this.classUnderTest().lastIndexOf(null));
        ImmutableList<Integer> immutableList = this.classUnderTest().newWith(null);
        Assert.assertEquals(immutableList.size() - 1, immutableList.lastIndexOf(null));
        Assert.assertEquals(-1, this.classUnderTest().lastIndexOf(Integer.MAX_VALUE));
    }

    @Test
    public void get() {
        ImmutableList<Integer> list = this.classUnderTest();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void forEach() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableList<Integer> collection = this.classUnderTest();
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(collection, result);
    }

    @Test
    public void each() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableList<Integer> collection = this.classUnderTest();
        collection.each(result::add);
        Assert.assertEquals(collection, result);
    }

    @Test
    public void reverseForEach() {
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableList<Integer> list = this.classUnderTest();
        list.reverseForEach(result::add);
        Assert.assertEquals(ListIterate.reverseThis(FastList.newList(list)), result);
    }

    @Test
    public void reverseForEachWithIndex() {
        MutableList<Integer> expected = Lists.mutable.of();
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableList<Integer> list = this.classUnderTest();
        list.reverseForEachWithIndex((each, index) -> Assert.assertEquals(each - 1, index));
        list.reverseForEachWithIndex((each, index) -> result.add(each + index));
        list.forEachWithIndex((each, index) -> expected.add(each + index));
        Assert.assertEquals(expected.reverseThis(), result);
    }

    @Test
    public void corresponds() {
        ImmutableList<Integer> integers1 = this.classUnderTest();
        ImmutableList<Integer> integers2 = this.classUnderTest().newWith(Integer.valueOf(1));
        Assert.assertFalse(integers1.corresponds(integers2, Predicates2.alwaysTrue()));
        ImmutableList<Integer> integers3 = integers1.collect(integer -> integer + 1);
        Assert.assertTrue(integers1.corresponds(integers3, Predicates2.lessThan()));
        Assert.assertFalse(integers1.corresponds(integers3, Predicates2.greaterThan()));
    }

    @Test
    public void forEachFromTo() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableList<Integer> reverseResult = Lists.mutable.of();
        ImmutableList<Integer> list = this.classUnderTest();
        list.forEach(0, list.size() - 1, result::add);
        Assert.assertEquals(list, result);
        list.forEach(list.size() - 1, 0, reverseResult::add);
        Assert.assertEquals(ListIterate.reverseThis(FastList.newList(list)), reverseResult);
        Verify.assertThrows(IndexOutOfBoundsException.class, () -> list.forEach(-1, 0, result::add));
        Verify.assertThrows(IndexOutOfBoundsException.class, () -> list.forEach(0, -1, result::add));
    }

    @Test
    public void forEachWithIndexFromTo() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableList<Integer> reverseResult = Lists.mutable.of();
        ImmutableList<Integer> list = this.classUnderTest();
        list.forEachWithIndex(0, list.size() - 1, ObjectIntProcedures.fromProcedure(result::add));
        Assert.assertEquals(list, result);
        list.forEachWithIndex(list.size() - 1, 0, ObjectIntProcedures.fromProcedure(reverseResult::add));
        Assert.assertEquals(ListIterate.reverseThis(FastList.newList(list)), reverseResult);
        Verify.assertThrows(IndexOutOfBoundsException.class, () -> list.forEachWithIndex(-1, 0, result::add));
        Verify.assertThrows(IndexOutOfBoundsException.class, () -> list.forEachWithIndex(0, -1, result::add));
    }

    @Test
    public void forEachWith() {
        MutableCollection<Integer> result = Lists.mutable.of();
        this.classUnderTest().forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Assert.assertEquals(this.classUnderTest(), result);
    }

    @Test
    public void forEachWithIndex() {
        ImmutableList<Integer> list = this.classUnderTest();
        MutableList<Integer> result = Lists.mutable.of();
        list.forEachWithIndex((object, index) -> result.add(object + index));
        result.forEachWithIndex((object, index) -> Assert.assertEquals(object, result.set(index, object - index)));
        Assert.assertEquals(list, result);
    }

    @Test
    public void detectIndex() {
        Assert.assertEquals(0, this.classUnderTest().detectIndex(integer -> integer == 1));
        Assert.assertEquals(-1, this.classUnderTest().detectIndex(integer -> integer == 0));
    }

    @Test
    public void detectLastIndex() {
        Assert.assertEquals(0, this.classUnderTest().detectLastIndex(integer -> integer == 1));
        Assert.assertEquals(-1, this.classUnderTest().detectLastIndex(integer -> integer == 0));
    }

    @Test
    public void select_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.select(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Verify.assertEmpty(integers.select(Predicates.greaterThan(integers.size()), FastList.newList()));
    }

    @Test
    public void reject_target() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Verify.assertEmpty(integers.reject(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Assert.assertEquals(integers, integers.reject(Predicates.greaterThan(integers.size()), FastList.newList()));
    }

    @Test
    public void flatCollectWithTarget() {
        MutableCollection<String> actual = this.classUnderTest().flatCollect(integer -> Lists.fixedSize.of(String.valueOf(integer)), FastList.newList());
        ImmutableCollection<String> expected = this.classUnderTest().collect(String::valueOf);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void distinct() {
        ImmutableList<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.newWith(1).distinct());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().distinct());
    }

    @Test
    public void distinctWithHashingStrategy() {
        ImmutableList<Integer> integers = this.classUnderTest();
        HashingStrategy<Integer> hashingStrategy = HashingStrategies.fromFunction(e -> e % 2);
        if (integers.size() > 1) {
            Assert.assertEquals(Lists.immutable.with(1, 2), integers.distinct(hashingStrategy));
        } else if (integers.size() == 1) {
            Assert.assertEquals(Lists.immutable.with(1), integers.distinct(hashingStrategy));
        } else {
            Assert.assertEquals(Lists.immutable.empty(), integers.distinct(hashingStrategy));
        }
    }

    /**
     * @since 9.0.
     */
    @Test
    public void distinctBy() {
        ImmutableList<Integer> integers = this.classUnderTest();
        if (integers.size() > 1) {
            Assert.assertEquals(Lists.immutable.with(1, 2), integers.distinctBy(e -> e % 2));
        } else if (integers.size() == 1) {
            Assert.assertEquals(Lists.immutable.with(1), integers.distinctBy(e -> e % 2));
        } else {
            Assert.assertEquals(Lists.immutable.empty(), integers.distinctBy(e -> e % 2));
        }
    }

    @Test
    public void zip() {
        ImmutableCollection<Integer> immutableCollection = this.classUnderTest();
        List<Object> nulls = Collections.nCopies(immutableCollection.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableCollection.size() + 1, null);
        List<Object> nullsMinusOne = Collections.nCopies(immutableCollection.size() - 1, null);
        ImmutableCollection<Pair<Integer, Object>> pairs = immutableCollection.zip(nulls);
        Assert.assertEquals(immutableCollection, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(nulls, pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableCollection<Pair<Integer, Object>> pairsPlusOne = immutableCollection.zip(nullsPlusOne);
        Assert.assertEquals(immutableCollection, pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(nulls, pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableCollection<Pair<Integer, Object>> pairsMinusOne = immutableCollection.zip(nullsMinusOne);
        Assert.assertEquals(immutableCollection.size() - 1, pairsMinusOne.size());
        Assert.assertTrue(immutableCollection.containsAllIterable(pairsMinusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne)));
        Assert.assertEquals(immutableCollection.zip(nulls), immutableCollection.zip(nulls, FastList.newList()));
    }

    @Test
    public void zipWithIndex() {
        ImmutableCollection<Integer> immutableCollection = this.classUnderTest();
        ImmutableCollection<Pair<Integer, Integer>> pairs = immutableCollection.zipWithIndex();
        Assert.assertEquals(immutableCollection, pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(Interval.zeroTo(immutableCollection.size() - 1), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo));
        Assert.assertEquals(immutableCollection.zipWithIndex(), immutableCollection.zipWithIndex(FastList.newList()));
    }

    @Test
    public void chunk_large_size() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().chunk(10).getFirst());
        Verify.assertInstanceOf(ImmutableList.class, this.classUnderTest().chunk(10).getFirst());
    }

    @Test
    public void collectIfWithTarget() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers, integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru(), FastList.newList()));
    }

    @Test
    public void toList() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        MutableList<Integer> list = integers.toList();
        Verify.assertEqualsAndHashCode(integers, list);
        Assert.assertNotSame(integers, list);
    }

    @Test
    public void toSortedListBy() {
        MutableList<Integer> mutableList = this.classUnderTest().toList();
        mutableList.shuffleThis();
        ImmutableList<Integer> immutableList = mutableList.toImmutable();
        MutableList<Integer> sortedList = immutableList.toSortedListBy(Functions.getIntegerPassThru());
        Assert.assertEquals(this.classUnderTest(), sortedList);
    }

    @Test
    public void removeAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().castToList().remove(1));
    }

    @Test
    public void set() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().castToList().set(0, 1));
    }

    @Test
    public void addAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().castToList().add(0, 1));
    }

    @Test
    public void addAllAtIndex() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().castToList().addAll(0, Lists.fixedSize.of()));
    }

    @Test
    public void sort() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().castToList().sort(Comparator.naturalOrder()));
    }

    @Test
    public void replaceAll() {
        Verify.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().castToList().replaceAll(i -> i * 2));
    }

    @Test
    public void subList() {
        Verify.assertListsEqual(Lists.immutable.of(1).castToList(), this.classUnderTest().castToList().subList(0, 1));
    }

    @Test
    public void subListFromNegative() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.classUnderTest().castToList().subList(-1, 1));
    }

    @Test
    public void subListFromGreaterThanTO() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.classUnderTest().castToList().subList(1, 0));
    }

    @Test
    public void subListToGreaterThanSize() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.classUnderTest().castToList().subList(0, 100));
    }

    @Test
    public void listIterator() {
        ListIterator<Integer> it = this.classUnderTest().listIterator();
        Assert.assertFalse(it.hasPrevious());
        Assert.assertThrows(NoSuchElementException.class, it::previous);
        Assert.assertEquals(-1, it.previousIndex());
        Assert.assertEquals(0, it.nextIndex());
        it.next();
        Assert.assertEquals(1, it.nextIndex());
        Verify.assertThrows(UnsupportedOperationException.class, it::remove);
        Verify.assertThrows(UnsupportedOperationException.class, () -> it.add(null));
        Verify.assertThrows(UnsupportedOperationException.class, () -> it.set(null));
    }

    @Test
    public void listIterator_throwsNegative() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.classUnderTest().listIterator(-1));
    }

    @Test
    public void listIterator_throwsGreaterThanSize() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> this.classUnderTest().listIterator(100));
    }

    @Test
    public void toStack() {
        MutableStack<Integer> stack = this.classUnderTest().toStack();
        Assert.assertEquals(stack.toSortedList().toReversed(), stack.toList());
    }

    @Test
    public void take() {
        ImmutableList<Integer> immutableList = this.classUnderTest();
        Assert.assertEquals(Lists.immutable.of(), immutableList.take(0));
        Assert.assertEquals(iList(1), immutableList.take(1));
        Assert.assertEquals(immutableList, immutableList.take(10));
        MutableList<Integer> mutableList = Lists.mutable.ofAll(immutableList);
        Assert.assertEquals(mutableList.take(mutableList.size() - 1), immutableList.take(immutableList.size() - 1));
        Assert.assertSame(immutableList, immutableList.take(immutableList.size()));
        Assert.assertSame(immutableList, immutableList.take(Integer.MAX_VALUE));
    }

    @Test
    public void take_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.classUnderTest().take(-1));
    }

    @Test
    public void takeWhile() {
        Assert.assertEquals(iList(1), this.classUnderTest().takeWhile(Predicates.lessThan(2)));
    }

    @Test
    public void drop() {
        ImmutableList<Integer> immutableList = this.classUnderTest();
        Assert.assertSame(immutableList, immutableList.drop(0));
        MutableList<Integer> mutableList = Lists.mutable.ofAll(immutableList);
        Assert.assertEquals(mutableList.drop(1), immutableList.drop(1));
        if (mutableList.notEmpty()) {
            Assert.assertEquals(mutableList.drop(mutableList.size() - 1), immutableList.drop(immutableList.size() - 1));
        }
        Assert.assertEquals(Lists.immutable.of(), immutableList.drop(10));
        Assert.assertEquals(Lists.immutable.of(), immutableList.drop(immutableList.size()));
        Assert.assertEquals(Lists.immutable.of(), immutableList.drop(Integer.MAX_VALUE));
    }

    @Test
    public void drop_throws() {
        Assert.assertThrows(IllegalArgumentException.class, () -> this.classUnderTest().drop(-1));
    }

    @Test
    public void dropWhile() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().dropWhile(Predicates.lessThan(0)));
        Assert.assertEquals(Lists.immutable.of(), this.classUnderTest().dropWhile(Predicates.greaterThan(0)));
    }

    @Test
    public void partitionWhile() {
        PartitionImmutableList<Integer> partitionAll = this.classUnderTest().partitionWhile(Predicates.greaterThan(0));
        Assert.assertEquals(this.classUnderTest(), partitionAll.getSelected());
        Assert.assertEquals(Lists.immutable.of(), partitionAll.getRejected());
        PartitionImmutableList<Integer> partitionNone = this.classUnderTest().partitionWhile(Predicates.lessThan(0));
        Assert.assertEquals(Lists.immutable.of(), partitionNone.getSelected());
        Assert.assertEquals(this.classUnderTest(), partitionNone.getRejected());
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        ImmutableBooleanCollection immutableCollection = integers.collectBoolean(PrimitiveFunctions.integerIsPositive());
        Verify.assertSize(integers.size(), immutableCollection);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.classUnderTest().collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.withAll(IntInterval.zeroTo(pairs.size() - 1)), pairs.collectInt(ObjectIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.withAll(Interval.oneTo(pairs.size())), pairs.collect(ObjectIntPair::getOne, Lists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        RichIterable<ObjectIntPair<Integer>> pairs = this.classUnderTest().collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.withAll(IntInterval.zeroTo(pairs.size() - 1)), pairs.collectInt(ObjectIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.withAll(Interval.oneTo(pairs.size())), pairs.collect(ObjectIntPair::getOne, Lists.mutable.empty()));
        RichIterable<ObjectIntPair<Integer>> setOfPairs = this.classUnderTest().collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(IntSets.mutable.withAll(IntInterval.zeroTo(pairs.size() - 1)), setOfPairs.collectInt(ObjectIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(Sets.mutable.withAll(Interval.oneTo(pairs.size())), setOfPairs.collect(ObjectIntPair::getOne, Sets.mutable.empty()));
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndex() {
        ImmutableList<Integer> selected1 = this.classUnderTest().selectWithIndex((each, index) -> index < each);
        ImmutableList<Integer> selected2 = this.classUnderTest().selectWithIndex((each, index) -> index > each);
        Assert.assertEquals(this.classUnderTest(), selected1);
        Assert.assertEquals(Lists.immutable.empty(), selected2);
    }

    /**
     * @since 11.0.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableSet<Integer> selected1 = this.classUnderTest().selectWithIndex((each, index) -> index < each, Sets.mutable.empty());
        MutableSet<Integer> selected2 = this.classUnderTest().selectWithIndex((each, index) -> index > each, Sets.mutable.empty());
        Assert.assertEquals(this.classUnderTest().toSet(), selected1);
        Assert.assertEquals(Sets.immutable.empty(), selected2);
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndex() {
        ImmutableList<Integer> rejected1 = this.classUnderTest().rejectWithIndex((each, index) -> index < each);
        ImmutableList<Integer> rejected2 = this.classUnderTest().rejectWithIndex((each, index) -> index > each);
        Assert.assertEquals(Lists.immutable.empty(), rejected1);
        Assert.assertEquals(this.classUnderTest(), rejected2);
    }

    /**
     * @since 11.0.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableSet<Integer> rejected1 = this.classUnderTest().rejectWithIndex((each, index) -> index < each, Sets.mutable.empty());
        MutableSet<Integer> rejected2 = this.classUnderTest().rejectWithIndex((each, index) -> index > each, Sets.mutable.empty());
        Assert.assertEquals(Sets.immutable.empty(), rejected1);
        Assert.assertEquals(this.classUnderTest().toSet(), rejected2);
    }

    @Test
    public void groupBy() {
        ImmutableList<Integer> list = this.classUnderTest();
        ImmutableListMultimap<Boolean, Integer> multimap = list.groupBy(integer -> IntegerPredicates.isOdd().accept(integer));
        MutableMap<Boolean, RichIterable<Integer>> actualMap = multimap.toMap();
        int halfSize = this.classUnderTest().size() / 2;
        boolean odd = this.classUnderTest().size() % 2 != 0;
        Assert.assertEquals(halfSize, Iterate.sizeOf(actualMap.getIfAbsent(false, FastList::new)));
        Assert.assertEquals(halfSize + (odd ? 1 : 0), Iterate.sizeOf(actualMap.getIfAbsent(true, FastList::new)));
    }

    @Test
    public void groupByEach() {
        ImmutableList<Integer> list = this.classUnderTest();
        MutableMultimap<Integer, Integer> expected = FastListMultimap.newMultimap();
        list.forEach(Procedures.cast(value -> expected.putAll(-value, Interval.fromTo(value, list.size()))));
        Multimap<Integer, Integer> actual = list.groupByEach(new NegativeIntervalFunction());
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = list.groupByEach(new NegativeIntervalFunction(), FastListMultimap.newMultimap());
        Assert.assertEquals(expected, actualWithTarget);
    }

    @Test
    public void asReversed() {
        Verify.assertIterablesEqual(this.classUnderTest().toList().toReversed(), this.classUnderTest().asReversed());
    }

    @Test
    public void toReversed() {
        ImmutableList<Integer> immutableList = this.classUnderTest();
        Assert.assertEquals(immutableList.toReversed().toReversed(), immutableList);
        if (immutableList.size() <= 1) {
            Assert.assertSame(immutableList.toReversed(), immutableList);
        } else {
            Assert.assertNotEquals(immutableList.toReversed(), immutableList);
        }
    }

    @Test
    public void toImmutable() {
        ImmutableList<Integer> integers = this.classUnderTest();
        ImmutableList<Integer> actual = integers.toImmutable();
        Assert.assertEquals(integers, actual);
        Assert.assertSame(integers, actual);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableListTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDoubleConsistentRounding);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
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
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_each() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.each);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseForEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseForEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexFromTo);
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
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectLastIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectLastIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctWithHashingStrategy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctWithHashingStrategy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctBy);
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
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_replaceAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.replaceAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromNegative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListFromGreaterThanTO() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListFromGreaterThanTO);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subListToGreaterThanSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subListToGreaterThanSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator_throwsNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator_throwsNegative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator_throwsGreaterThanSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator_throwsGreaterThanSize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
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
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
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
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
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
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
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
        public void benchmark_asReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> each;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> reverseForEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> reverseForEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> forEachWithIndexFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> detectLastIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> distinctWithHashingStrategy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> distinctBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> addAllAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> sort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> replaceAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> subListFromNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> subListFromGreaterThanTO;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> subListToGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> listIterator_throwsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> listIterator_throwsGreaterThanSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> asReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableListTestCase> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = AbstractImmutableListTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableListTestCase::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableListTestCase::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = AbstractImmutableListTestCase::countBy;
            this.payloads.countByWith = AbstractImmutableListTestCase::countByWith;
            this.payloads.countByEach = AbstractImmutableListTestCase::countByEach;
            this.payloads.selectWith = AbstractImmutableListTestCase::selectWith;
            this.payloads.selectWith_target = AbstractImmutableListTestCase::selectWith_target;
            this.payloads.rejectWith = AbstractImmutableListTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractImmutableListTestCase::rejectWith_target;
            this.payloads.partition = AbstractImmutableListTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableListTestCase::partitionWith;
            this.payloads.collectWith = AbstractImmutableListTestCase::collectWith;
            this.payloads.collect_target = AbstractImmutableListTestCase::collect_target;
            this.payloads.collectWith_target = AbstractImmutableListTestCase::collectWith_target;
            this.payloads.injectInto = AbstractImmutableListTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractImmutableListTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractImmutableListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableListTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractImmutableListTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractImmutableListTestCase::sumFloat;
            this.payloads.sumDouble = AbstractImmutableListTestCase::sumDouble;
            this.payloads.sumInteger = AbstractImmutableListTestCase::sumInteger;
            this.payloads.sumLong = AbstractImmutableListTestCase::sumLong;
            this.payloads.sumByInt = AbstractImmutableListTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractImmutableListTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractImmutableListTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractImmutableListTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractImmutableListTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractImmutableListTestCase::sumByDoubleConsistentRounding;
            this.payloads.makeString = AbstractImmutableListTestCase::makeString;
            this.payloads.appendString = AbstractImmutableListTestCase::appendString;
            this.payloads.testToString = AbstractImmutableListTestCase::testToString;
            this.payloads.select = AbstractImmutableListTestCase::select;
            this.payloads.selectInstancesOf = AbstractImmutableListTestCase::selectInstancesOf;
            this.payloads.reject = AbstractImmutableListTestCase::reject;
            this.payloads.collect = AbstractImmutableListTestCase::collect;
            this.payloads.collectByte = AbstractImmutableListTestCase::collectByte;
            this.payloads.collectChar = AbstractImmutableListTestCase::collectChar;
            this.payloads.collectDouble = AbstractImmutableListTestCase::collectDouble;
            this.payloads.collectFloat = AbstractImmutableListTestCase::collectFloat;
            this.payloads.collectInt = AbstractImmutableListTestCase::collectInt;
            this.payloads.collectLong = AbstractImmutableListTestCase::collectLong;
            this.payloads.collectShort = AbstractImmutableListTestCase::collectShort;
            this.payloads.flatCollect = AbstractImmutableListTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractImmutableListTestCase::flatCollectWith;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableListTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.detect = AbstractImmutableListTestCase::detect;
            this.payloads.detectWith = AbstractImmutableListTestCase::detectWith;
            this.payloads.detectIfNone = AbstractImmutableListTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractImmutableListTestCase::detectWithIfNone;
            this.payloads.allSatisfy = AbstractImmutableListTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractImmutableListTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractImmutableListTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractImmutableListTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractImmutableListTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractImmutableListTestCase::anySatisfyWith;
            this.payloads.count = AbstractImmutableListTestCase::count;
            this.payloads.countWith = AbstractImmutableListTestCase::countWith;
            this.payloads.collectIf = AbstractImmutableListTestCase::collectIf;
            this.payloads.getFirst = AbstractImmutableListTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableListTestCase::getLast;
            this.payloads.isEmpty = AbstractImmutableListTestCase::isEmpty;
            this.payloads.iterator = AbstractImmutableListTestCase::iterator;
            this.payloads.toArray = AbstractImmutableListTestCase::toArray;
            this.payloads.toSortedList = AbstractImmutableListTestCase::toSortedList;
            this.payloads.toSortedSet = AbstractImmutableListTestCase::toSortedSet;
            this.payloads.toSortedSetWithComparator = AbstractImmutableListTestCase::toSortedSetWithComparator;
            this.payloads.toSortedSetBy = AbstractImmutableListTestCase::toSortedSetBy;
            this.payloads.forLoop = AbstractImmutableListTestCase::forLoop;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableListTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableListTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractImmutableListTestCase::min;
            this.payloads.max = AbstractImmutableListTestCase::max;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableListTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableListTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractImmutableListTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractImmutableListTestCase::max_without_comparator;
            this.payloads.minBy = AbstractImmutableListTestCase::minBy;
            this.payloads.maxBy = AbstractImmutableListTestCase::maxBy;
            this.payloads.iteratorRemove = AbstractImmutableListTestCase::iteratorRemove;
            this.payloads.add = AbstractImmutableListTestCase::add;
            this.payloads.remove = AbstractImmutableListTestCase::remove;
            this.payloads.clear = AbstractImmutableListTestCase::clear;
            this.payloads.removeAll = AbstractImmutableListTestCase::removeAll;
            this.payloads.retainAll = AbstractImmutableListTestCase::retainAll;
            this.payloads.addAll = AbstractImmutableListTestCase::addAll;
            this.payloads.aggregateByMutating = AbstractImmutableListTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractImmutableListTestCase::aggregateByNonMutating;
            this.payloads.tap = AbstractImmutableListTestCase::tap;
            this.payloads.equalsAndHashCode = AbstractImmutableListTestCase::equalsAndHashCode;
            this.payloads.contains = AbstractImmutableListTestCase::contains;
            this.payloads.containsAll = AbstractImmutableListTestCase::containsAll;
            this.payloads.containsAllArray = AbstractImmutableListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableListTestCase::containsAllIterable;
            this.payloads.indexOf = AbstractImmutableListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractImmutableListTestCase::lastIndexOf;
            this.payloads.get = AbstractImmutableListTestCase::get;
            this.payloads.forEach = AbstractImmutableListTestCase::forEach;
            this.payloads.each = AbstractImmutableListTestCase::each;
            this.payloads.reverseForEach = AbstractImmutableListTestCase::reverseForEach;
            this.payloads.reverseForEachWithIndex = AbstractImmutableListTestCase::reverseForEachWithIndex;
            this.payloads.corresponds = AbstractImmutableListTestCase::corresponds;
            this.payloads.forEachFromTo = AbstractImmutableListTestCase::forEachFromTo;
            this.payloads.forEachWithIndexFromTo = AbstractImmutableListTestCase::forEachWithIndexFromTo;
            this.payloads.forEachWith = AbstractImmutableListTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractImmutableListTestCase::forEachWithIndex;
            this.payloads.detectIndex = AbstractImmutableListTestCase::detectIndex;
            this.payloads.detectLastIndex = AbstractImmutableListTestCase::detectLastIndex;
            this.payloads.select_target = AbstractImmutableListTestCase::select_target;
            this.payloads.reject_target = AbstractImmutableListTestCase::reject_target;
            this.payloads.flatCollectWithTarget = AbstractImmutableListTestCase::flatCollectWithTarget;
            this.payloads.distinct = AbstractImmutableListTestCase::distinct;
            this.payloads.distinctWithHashingStrategy = AbstractImmutableListTestCase::distinctWithHashingStrategy;
            this.payloads.distinctBy = AbstractImmutableListTestCase::distinctBy;
            this.payloads.zip = AbstractImmutableListTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableListTestCase::zipWithIndex;
            this.payloads.chunk_large_size = AbstractImmutableListTestCase::chunk_large_size;
            this.payloads.collectIfWithTarget = AbstractImmutableListTestCase::collectIfWithTarget;
            this.payloads.toList = AbstractImmutableListTestCase::toList;
            this.payloads.toSortedListBy = AbstractImmutableListTestCase::toSortedListBy;
            this.payloads.removeAtIndex = AbstractImmutableListTestCase::removeAtIndex;
            this.payloads.set = AbstractImmutableListTestCase::set;
            this.payloads.addAtIndex = AbstractImmutableListTestCase::addAtIndex;
            this.payloads.addAllAtIndex = AbstractImmutableListTestCase::addAllAtIndex;
            this.payloads.sort = AbstractImmutableListTestCase::sort;
            this.payloads.replaceAll = AbstractImmutableListTestCase::replaceAll;
            this.payloads.subList = AbstractImmutableListTestCase::subList;
            this.payloads.subListFromNegative = AbstractImmutableListTestCase::subListFromNegative;
            this.payloads.subListFromGreaterThanTO = AbstractImmutableListTestCase::subListFromGreaterThanTO;
            this.payloads.subListToGreaterThanSize = AbstractImmutableListTestCase::subListToGreaterThanSize;
            this.payloads.listIterator = AbstractImmutableListTestCase::listIterator;
            this.payloads.listIterator_throwsNegative = AbstractImmutableListTestCase::listIterator_throwsNegative;
            this.payloads.listIterator_throwsGreaterThanSize = AbstractImmutableListTestCase::listIterator_throwsGreaterThanSize;
            this.payloads.toStack = AbstractImmutableListTestCase::toStack;
            this.payloads.take = AbstractImmutableListTestCase::take;
            this.payloads.take_throws = AbstractImmutableListTestCase::take_throws;
            this.payloads.takeWhile = AbstractImmutableListTestCase::takeWhile;
            this.payloads.drop = AbstractImmutableListTestCase::drop;
            this.payloads.drop_throws = AbstractImmutableListTestCase::drop_throws;
            this.payloads.dropWhile = AbstractImmutableListTestCase::dropWhile;
            this.payloads.partitionWhile = AbstractImmutableListTestCase::partitionWhile;
            this.payloads.collectBoolean = AbstractImmutableListTestCase::collectBoolean;
            this.payloads.collectWithIndex = AbstractImmutableListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableListTestCase::collectWithIndexWithTarget;
            this.payloads.selectWithIndex = AbstractImmutableListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractImmutableListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractImmutableListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractImmutableListTestCase::rejectWithIndexWithTarget;
            this.payloads.groupBy = AbstractImmutableListTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableListTestCase::groupByEach;
            this.payloads.asReversed = AbstractImmutableListTestCase::asReversed;
            this.payloads.toReversed = AbstractImmutableListTestCase::toReversed;
            this.payloads.toImmutable = AbstractImmutableListTestCase::toImmutable;
        }
    }
*/
}
